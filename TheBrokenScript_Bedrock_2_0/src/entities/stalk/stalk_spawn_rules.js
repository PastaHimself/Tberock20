import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import { hasSkyLightAt, skyLightLevelAt } from "../../systems/ai/visibility.js";

const CURVED_CHANCE = 0.00085;
const HEROBRINE_CHANCE = 0.0001;
const OBLIT_CHANCE = 0.0085;
const ANOMALY_MATRIX = [0.001, 0.005, 0.02, 0.015, 0.01, 0, 0, 0];
const SURFACE_MIN_DISTANCE = 24;
const SURFACE_MAX_DISTANCE = 80;
const CAVE_BIOMES = ["lush_caves", "dripstone_caves", "deep_dark"];
const OBLITERATION_TYPES = [
  "thebrokenscript:the_obliteration",
  "thebrokenscript:the_obliteration_2",
];

function difficultyIsPeaceful() {
  try {
    return String(world.getDifficulty()).toLowerCase() === "peaceful";
  } catch {
    return true;
  }
}

function genericSourceGates() {
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
  } catch {
    // Fall through to the eight-day cycle.
  }
  try {
    const day = Number(world.getDay());
    if (Number.isFinite(day)) return ((Math.floor(day) % 8) + 8) % 8;
  } catch {
    // Fail closed to phase zero.
  }
  return 0;
}

function isDay() {
  try {
    const time = Number(world.getTimeOfDay());
    return Number.isFinite(time) && time >= 0 && time < 12000;
  } catch {
    return false;
  }
}

function surfaceCandidate(player, minDistance = SURFACE_MIN_DISTANCE, maxDistance = SURFACE_MAX_DISTANCE) {
  const angle = Math.random() * Math.PI * 2;
  const radius = minDistance + Math.random() * (maxDistance - minDistance);
  const x = Math.floor(player.location.x + Math.cos(angle) * radius);
  const z = Math.floor(player.location.z + Math.sin(angle) * radius);
  try {
    const top = player.dimension.getTopmostBlock?.({ x, z });
    const surfaceY = typeof top?.y === "number"
      ? top.y
      : (typeof top?.location?.y === "number" ? top.location.y : undefined);
    if (typeof surfaceY !== "number") return undefined;
    return { x: x + 0.5, y: surfaceY + 1, z: z + 0.5 };
  } catch {
    return undefined;
  }
}

function airSpaceScore(dimension, location) {
  let airBlocks = 0;
  const cx = Math.floor(location.x);
  const cy = Math.floor(location.y);
  const cz = Math.floor(location.z);
  try {
    for (let x = -3; x <= 3; x++) {
      for (let y = -1; y < 3; y++) {
        for (let z = -3; z <= 3; z++) {
          const block = dimension.getBlock({ x: cx + x, y: cy + y, z: cz + z });
          if (block?.isAir === true || block?.typeId === "minecraft:air") airBlocks++;
        }
      }
    }
  } catch {
    return 0;
  }
  return airBlocks;
}

function isInCave(dimension, location) {
  try {
    const biome = dimension.getBiome?.(location);
    const biomeId = String(biome?.id ?? biome?.name ?? "");
    if (CAVE_BIOMES.some((id) => biomeId.includes(id))) return true;
  } catch {
    // Continue with source's geometry/light checks.
  }

  const skyLight = skyLightLevelAt(dimension, location);
  if (typeof skyLight !== "number" || skyLight > 0) return false;

  let surfaceY;
  try {
    const top = dimension.getTopmostBlock?.({ x: location.x, z: location.z });
    surfaceY = typeof top?.y === "number"
      ? top.y
      : (typeof top?.location?.y === "number" ? top.location.y : undefined);
  } catch {
    return false;
  }
  if (typeof surfaceY !== "number" || surfaceY - location.y < 5) return false;

  // BaseMonsterExtKt.isInCave accepts an air-space score >= 5.
  return airSpaceScore(dimension, location) >= 5;
}

function caveCandidate(player) {
  const angle = Math.random() * Math.PI * 2;
  const radius = SURFACE_MIN_DISTANCE + Math.random() * (56 - SURFACE_MIN_DISTANCE);
  const x = Math.floor(player.location.x + Math.cos(angle) * radius);
  const z = Math.floor(player.location.z + Math.sin(angle) * radius);
  const centerY = Math.floor(player.location.y);

  for (let offset = 8; offset >= -16; offset--) {
    const y = centerY + offset;
    try {
      const below = player.dimension.getBlock({ x, y: y - 1, z });
      const at = player.dimension.getBlock({ x, y, z });
      const above = player.dimension.getBlock({ x, y: y + 1, z });
      if (!below || !at || !above) continue;
      if (below.isAir === true || below.typeId === "minecraft:air") continue;
      if (at.isAir !== true && at.typeId !== "minecraft:air") continue;
      if (above.isAir !== true && above.typeId !== "minecraft:air") continue;
      const candidate = { x: x + 0.5, y, z: z + 0.5 };
      if (isInCave(player.dimension, candidate)) return candidate;
    } catch {
      return undefined;
    }
  }
  return undefined;
}

function nearestPlayerWithin(players, dimension, location, maxDistance) {
  return players.some((player) => {
    if (!player || player.dimension?.id !== dimension.id) return false;
    return Math.hypot(
      player.location.x - location.x,
      player.location.y - location.y,
      player.location.z - location.z,
    ) <= maxDistance;
  });
}

function countType(dimension, typeId) {
  try {
    return dimension.getEntities({ type: typeId }).length;
  } catch {
    return Number.POSITIVE_INFINITY;
  }
}

function hasObliterationNear(dimension, location) {
  return entityFinder.hasEntitiesInRange(dimension, location, 512, OBLITERATION_TYPES);
}

export function register() {
  // CurvedConditions: Overworld, 8.5e-4 chance, flat gate, Phase1 gate,
  // <=2 existing, nearest player <=158, and player/candidate cave parity.
  spawnDirector.registerRule({
    id: "curved",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !genericSourceGates()) return false;
      if (player.dimension.id !== "minecraft:overworld") return false;
      if (worldState.get("curvedSpawnDelay") > 0) return false;
      if (Math.random() > CURVED_CHANCE) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (countType(player.dimension, "thebrokenscript:curved") > 1) return false;

      const playerInCave = isInCave(player.dimension, player.location);
      const location = playerInCave ? caveCandidate(player) : surfaceCandidate(player, 24, 56);
      if (!location) return false;
      if (isInCave(player.dimension, location) !== playerInCave) return false;
      if (!nearestPlayerWithin(ctx.players, player.dimension, location, 158)) return false;

      const spawned = spawnHelpers.trySummon(player.dimension, "thebrokenscript:curved", location);
      if (!spawned) return false;
      worldState.set("curvedSpawnDelay", 32000);
      return true;
    },
  });

  // HerobrineConditions intentionally has no Overworld/Arena restriction in
  // Java. The shrine prerequisite is mandatory and was previously omitted.
  spawnDirector.registerRule({
    id: "herobrine",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !genericSourceGates()) return false;
      if (!worldState.get("hasBuiltHerobrineShrine")) return false;

      const location = surfaceCandidate(player, 32, 80);
      if (!location || !hasSkyLightAt(player.dimension, location)) return false;
      if (Math.random() > HEROBRINE_CHANCE) return false;
      if (worldState.get("herobrineDelay") > 0) return false;

      const spawned = spawnHelpers.trySummon(
        player.dimension,
        "thebrokenscript:herobrine",
        location,
      );
      if (!spawned) return false;
      worldState.set("herobrineDelay", 32000);
      return true;
    },
  });

  // ObliterationConditions: Overworld, nonzero sky light, chance+frequency,
  // delay, Phase1/exclusion/flat gates, and daytime only.
  spawnDirector.registerRule({
    id: "obliteration",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !genericSourceGates()) return false;
      if (player.dimension.id !== "minecraft:overworld") return false;

      const location = surfaceCandidate(player, 64, 120);
      if (!location) return false;
      const sky = skyLightLevelAt(player.dimension, location);
      if (typeof sky !== "number" || sky === 0) return false;

      if (Math.random() > OBLIT_CHANCE + eventFrequency(ctx.gameTime ?? 0)) return false;
      if (worldState.get("oblitSpawnDelay") > 0) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (hasObliterationNear(player.dimension, location)) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;
      if (!isDay()) return false;

      // Both source entity types use OBLIT with equal biome-spawn weight.
      const typeId =
        Math.random() < 0.5
          ? "thebrokenscript:the_obliteration"
          : "thebrokenscript:the_obliteration_2";
      const spawned = spawnHelpers.trySummon(player.dimension, typeId, location);
      if (!spawned) return false;
      worldState.set("oblitSpawnDelay", 32000);
      return true;
    },
  });

  // Only SUB_ANOMALY_1 is registered with ANOMALY in TBSEntities.java.
  spawnDirector.registerRule({
    id: "sub_anomaly",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !genericSourceGates()) return false;
      if (player.dimension.id !== "minecraft:overworld") return false;
      if (bossHooks.isArenaPhase1()) return false;

      const location = surfaceCandidate(player, 24, 64);
      if (!location || !hasSkyLightAt(player.dimension, location)) return false;

      const phase = getMoonPhase();
      if (Math.random() > (ANOMALY_MATRIX[phase] ?? 0) + eventFrequency(ctx.gameTime ?? 0)) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;
      if (countType(player.dimension, "thebrokenscript:sub_anomaly_1") > 0) return false;

      return (
        spawnHelpers.trySummon(
          player.dimension,
          "thebrokenscript:sub_anomaly_1",
          location,
        ) !== undefined
      );
    },
  });
}
