import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import { hasSkyLightAt } from "../../systems/ai/visibility.js";
import * as progression from "../../systems/progression.js";

const SILUET_MATRIX = [
  [0.0, 0.001, 0.001, 0.005, 0.0085, 0.0085, 0.0085, 0.0085],
  [0.001, 0.002, 0.002, 0.005, 0.0085, 0.009, 0.01, 0.01],
  [0.003, 0.003, 0.006, 0.006, 0.005, 0.0, 0.0, 0.0],
];
const ENTITY_MATRIX = [
  [0.0, 0.0001, 0.0001, 0.0005, 0.001, 0.008, 0.0085, 0.0085],
  [0.001, 0.002, 0.002, 0.002, 0.0025, 0.009, 0.01, 0.01],
  [0.003, 0.003, 0.006, 0.006, 0.005, 0.0, 0.0, 0.0],
];
const SILUET_TYPES = [
  { id: "thebrokenscript:siluet", weight: 25 },
  { id: "thebrokenscript:siluet_stare", weight: 25 },
  { id: "thebrokenscript:he", weight: 1 },
];
const ENTITY_TYPES = [
  { id: "thebrokenscript:fake_player", weight: 1 },
  { id: "thebrokenscript:hetzer", weight: 1 },
  { id: "thebrokenscript:follow", weight: 1 },
  { id: "thebrokenscript:deceiver", weight: 2 },
];

function difficultyIsPeaceful() {
  try {
    return String(world.getDifficulty()).toLowerCase() === "peaceful";
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.difficulty",
      "best-effort Bedrock API fallback",
      error,
    );
    return true;
  }
}

function commonOverworldGates() {
  if (difficultyIsPeaceful()) return false;
  if (world.gameRules?.doMobSpawning !== true) return false;
  if (!worldState.get("isNullHere")) return false;
  if (config.get("danger.disableSpawningEntities")) return false;
  return true;
}

function getMoonPhase() {
  try {
    const phase = Number(world.getMoonPhase());
    if (Number.isInteger(phase)) return ((phase % 8) + 8) % 8;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.moon_phase",
      "best-effort Bedrock API fallback",
      error,
    );
  }
  try {
    const day = Number(world.getDay());
    if (Number.isFinite(day)) return ((Math.floor(day) % 8) + 8) % 8;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.day_fallback",
      "best-effort Bedrock API fallback",
      error,
    );
  }
  return 0;
}

function stageIndex() {
  return Math.max(0, Math.min(2, Number(worldState.get("moonStage") ?? 0)));
}

function pickSurfaceCandidate(player, minDist, maxDist) {
  const angle = Math.random() * Math.PI * 2;
  const radius = minDist + Math.random() * (maxDist - minDist);
  const x = Math.floor(player.location.x + Math.cos(angle) * radius);
  const z = Math.floor(player.location.z + Math.sin(angle) * radius);
  try {
    const top = player.dimension.getTopmostBlock?.({ x, z });
    const surfaceY = typeof top?.y === "number"
      ? top.y
      : (typeof top?.location?.y === "number" ? top.location.y : undefined);
    if (typeof surfaceY !== "number") return undefined;
    return { x: x + 0.5, y: surfaceY + 1, z: z + 0.5 };
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.candidate",
      "best-effort Bedrock API fallback",
      error,
    );
    return undefined;
  }
}

function totalLightAt(dimension, location) {
  try {
    const value = dimension.getLightLevel?.({
      x: Math.floor(location.x),
      y: Math.floor(location.y),
      z: Math.floor(location.z),
    });
    return typeof value === "number" ? value : undefined;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.total_light",
      "best-effort Bedrock API fallback",
      error,
    );
    return undefined;
  }
}

function weightedType(entries) {
  const total = entries.reduce((sum, entry) => sum + entry.weight, 0);
  let roll = Math.random() * total;
  for (const entry of entries) {
    if (roll < entry.weight) return entry.id;
    roll -= entry.weight;
  }
  return entries[entries.length - 1].id;
}

function hasPlayerWithSkyLight(players, dimension, location, maxDistance, minimumSky) {
  for (const player of players) {
    if (!player || player.dimension?.id !== dimension.id) continue;
    if (
      Math.hypot(
        player.location.x - location.x,
        player.location.y - location.y,
        player.location.z - location.z,
      ) > maxDistance
    ) continue;
    try {
      const sky = dimension.getSkyLightLevel?.({
        x: Math.floor(player.location.x),
        y: Math.floor(player.location.y),
        z: Math.floor(player.location.z),
      });
      if (typeof sky === "number" && sky >= minimumSky) return true;
    } catch (error) {
      operationDiagnostics.warnOnce(
        "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.player_sky",
        "best-effort Bedrock API fallback",
        error,
      );
    }
  }
  return false;
}

function countType(dimension, typeId) {
  try {
    return dimension.getEntities({ type: typeId }).length;
  } catch (error) {
    operationDiagnostics.warnOnce(
      `audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.count.${typeId}`,
      "best-effort Bedrock API fallback",
      error,
    );
    return Number.POSITIVE_INFINITY;
  }
}

function canSpawnSiluet(ctx) {
  const player = ctx.players[0];
  if (!player || !commonOverworldGates()) return false;
  const dimension = player.dimension;
  if (dimension.id !== "minecraft:overworld") return false;
  if (worldState.get("entitySpawnDelay") > 0) return false;

  const location = pickSurfaceCandidate(player, 24, 60);
  if (!location) return false;
  if (!hasSkyLightAt(dimension, location)) return false;

  const light = totalLightAt(dimension, location);
  if (typeof light === "number" && light > 7) return false;

  if (
    entityFinder.hasEntitiesInRange(
      dimension,
      location,
      500,
      ["thebrokenscript:siluet", "thebrokenscript:siluet_stare"],
    )
  ) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;

  // Java's biome spawn weights choose the entity before the predicate. If HE
  // is selected and its additional 10% gate fails, the spawn fails; it does
  // not fall back to Siluet.
  const typeId = weightedType(SILUET_TYPES);
  const chance = SILUET_MATRIX[stageIndex()]?.[getMoonPhase()] ?? 0;
  if (Math.random() > chance + eventFrequency(ctx.gameTime ?? 0)) return false;
  if (typeId === "thebrokenscript:he" && Math.random() > 0.1) return false;
  if (!hasPlayerWithSkyLight(ctx.players, dimension, location, 75, 2)) return false;

  const spawned = spawnHelpers.trySummon(dimension, typeId, location);
  if (!spawned) return false;
  worldState.set("entitySpawnDelay", 6400);

  if (typeId === "thebrokenscript:siluet") {
    try {
      dimension.playSound("ambient.cave", location, { volume: 10, pitch: 1 });
    } catch (error) {
      operationDiagnostics.warnOnce(
        "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.siluet_sound",
        "best-effort Bedrock API fallback",
        error,
      );
    }
    if (Math.random() < 0.9) {
      const near = entityFinder.closestPlayerInRange(
        world.getAllPlayers(),
        location,
        1000,
        { dimension },
      );
      if (near) progression.award(near.id, "can_you_see_me");
    }
  } else if (typeId === "thebrokenscript:he") {
    try {
      dimension.playSound("thebrokenscript:rare_thing_spawn", location, { volume: 10, pitch: 0 });
    } catch (error) {
      operationDiagnostics.warnOnce(
        "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.he_sound",
        "best-effort Bedrock API fallback",
        error,
      );
    }
    try {
      dimension.spawnEntity("minecraft:lightning_bolt", location);
    } catch (error) {
      operationDiagnostics.warnOnce(
        "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.he_lightning",
        "best-effort Bedrock API fallback",
        error,
      );
    }
    try {
      dimension.runCommand("weather rain 6000");
    } catch (error) {
      operationDiagnostics.warnOnce(
        "audit.BP.scripts.entities.humanoid.humanoid_spawn_rules.js.he_weather",
        "best-effort Bedrock API fallback",
        error,
      );
    }
  }
  return true;
}

function canSpawnFaraway(ctx) {
  const player = ctx.players[0];
  if (!player || !commonOverworldGates()) return false;
  const dimension = player.dimension;
  if (dimension.id !== "minecraft:overworld") return false;
  if (bossHooks.isArenaPhase1()) return false;

  const location = pickSurfaceCandidate(player, 32, 80);
  if (!location || !hasSkyLightAt(dimension, location)) return false;

  if (Math.random() > 0.0085 + eventFrequency(ctx.gameTime ?? 0)) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  if (countType(dimension, "thebrokenscript:faraway") > 0) return false;

  return (
    spawnHelpers.trySummon(
      dimension,
      "thebrokenscript:faraway",
      location,
    ) !== undefined
  );
}

function canSpawnEntityFamily(ctx) {
  const player = ctx.players[0];
  if (!player || !commonOverworldGates()) return false;
  const dimension = player.dimension;
  if (dimension.id !== "minecraft:overworld") return false;
  if (worldState.get("rareSpawnDelay") > 0) return false;

  const location = pickSurfaceCandidate(player, 24, 64);
  if (!location || !hasSkyLightAt(dimension, location)) return false;

  const light = totalLightAt(dimension, location);
  if (typeof light === "number" && light > 7) return false;

  if (bossHooks.isArenaPhase1()) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;

  const chance = ENTITY_MATRIX[stageIndex()]?.[getMoonPhase()] ?? 0;
  if (Math.random() > chance + eventFrequency(ctx.gameTime ?? 0)) return false;

  const typeId = weightedType(ENTITY_TYPES);
  if (typeId === "thebrokenscript:hetzer") {
    if (countType(dimension, "thebrokenscript:hetzer") >= 1) return false;
    if (countType(dimension, "thebrokenscript:phantom_player") < 1) return false;
  }
  if (
    typeId === "thebrokenscript:deceiver" &&
    countType(dimension, "thebrokenscript:deceiver") >= 1
  ) return false;

  const spawned = spawnHelpers.trySummon(dimension, typeId, location);
  if (!spawned) return false;
  worldState.set("rareSpawnDelay", 12000);
  return true;
}

export function register() {
  spawnDirector.registerRule({
    id: "siluet_family",
    predicate: (ctx) => canSpawnSiluet(ctx),
  });
  spawnDirector.registerRule({
    id: "faraway",
    predicate: (ctx) => canSpawnFaraway(ctx),
  });
  spawnDirector.registerRule({
    id: "entity_family",
    predicate: (ctx) => canSpawnEntityFamily(ctx),
  });
}
