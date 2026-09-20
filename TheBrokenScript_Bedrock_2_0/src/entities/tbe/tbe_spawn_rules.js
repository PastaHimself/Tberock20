import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import { hasSkyLightAt } from "../../systems/ai/visibility.js";

// TBEConditions (moonStage==2) & TBEAmbushConditions (hasMoonCorrupted).
const SPAWN_CHANCE_TBE = [0, 0, 0, 0, 0.00015, 0.00025, 0.001, 0.002];
const SPAWN_MATRIX_AMBUSH = [
  [0.0002, 0.0004, 0.0006, 0.0008, 0.001, 0.0012],
  [0.0005, 0.001, 0.0015, 0.002, 0.0025, 0.003],
  [0.001, 0.002, 0.003, 0.004, 0.005, 0.006],
];
const TBE_TYPES = [
  "thebrokenscript:the_broken_end",
  "thebrokenscript:the_broken_end_stalk",
  "thebrokenscript:the_broken_end_ambush",
];
const TBE_EXCLUSION_RANGE = 512;
const TBE_STALK_MIN_PLAYER_DISTANCE = 45;
const TBE_STALK_MAX_PLAYER_DISTANCE = 150;

function difficultyIsPeaceful() {
  try {
    return String(world.getDifficulty()).toLowerCase() === "peaceful";
  } catch {
    return true;
  }
}

function getMoonPhase() {
  try {
    const phase = Number(world.getMoonPhase());
    if (Number.isInteger(phase)) return ((phase % 8) + 8) % 8;
  } catch {
    // Fall through to the source-equivalent eight-day cycle.
  }
  try {
    const day = Number(world.getDay());
    if (Number.isFinite(day)) return ((Math.floor(day) % 8) + 8) % 8;
  } catch {
    // Fail closed to phase zero.
  }
  return 0;
}

function pickSurfaceCandidate(player, minDistance, maxDistance) {
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

function totalLightAt(dimension, location) {
  try {
    const value = dimension.getLightLevel?.({
      x: Math.floor(location.x),
      y: Math.floor(location.y),
      z: Math.floor(location.z),
    });
    return typeof value === "number" ? value : undefined;
  } catch {
    return undefined;
  }
}

function hasOtherBrokenEndsInRange(dimension, location) {
  return entityFinder.hasEntitiesInRange(
    dimension,
    location,
    TBE_EXCLUSION_RANGE,
    TBE_TYPES,
  );
}

function nearestPlayerDistance(players, dimension, location) {
  let nearest = Number.POSITIVE_INFINITY;
  for (const player of players) {
    if (!player || player.dimension?.id !== dimension.id) continue;
    nearest = Math.min(
      nearest,
      Math.hypot(
        player.location.x - location.x,
        player.location.y - location.y,
        player.location.z - location.z,
      ),
    );
  }
  return nearest;
}

function commonSourceGates(dimension) {
  if (difficultyIsPeaceful()) return false;
  if (world.gameRules?.doMobSpawning !== true) return false;
  if (!worldState.get("isNullHere")) return false;
  if (config.get("danger.disableSpawningEntities")) return false;
  if (dimension.id !== "minecraft:overworld") return false;
  return true;
}

function canSpawnTbeStalk(ctx) {
  const player = ctx.players[0];
  if (!player) return false;
  const dimension = player.dimension;

  // Java's natural-spawn engine supplies the ON_GROUND candidate before the
  // predicate. Keep the source's explicit 45-block minimum and 150-block
  // nearest-player maximum while selecting a surface adapter position.
  const location = pickSurfaceCandidate(player, TBE_STALK_MIN_PLAYER_DISTANCE, 90);
  if (!location) return false;

  if (!commonSourceGates(dimension)) return false;
  if (!hasSkyLightAt(dimension, location)) return false;

  // TBEConditions additionally calls Monster.isDarkEnoughToSpawn. Bedrock
  // does not expose that Java helper, but total light > 7 is a definite reject.
  const light = totalLightAt(dimension, location);
  if (typeof light === "number" && light > 7) return false;

  if (worldState.get("moonStage") !== 2) return false;
  if (worldState.get("tbeSpawnDelay") > 0) return false;
  if (hasOtherBrokenEndsInRange(dimension, location)) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  if (bossHooks.isArenaPhase1()) return false;

  const nearest = nearestPlayerDistance(ctx.players, dimension, location);
  if (!Number.isFinite(nearest) || nearest > TBE_STALK_MAX_PLAYER_DISTANCE) return false;
  if (nearest < TBE_STALK_MIN_PLAYER_DISTANCE) return false;

  const chance = (SPAWN_CHANCE_TBE[getMoonPhase()] ?? 0) + eventFrequency(ctx.gameTime ?? 0);
  if (Math.random() > chance) return false;

  const spawned = spawnHelpers.trySummon(
    dimension,
    "thebrokenscript:the_broken_end_stalk",
    location,
  );
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);
  worldState.set("tbeSpawnDelay", 32000);
  return true;
}

function canSpawnTbeAmbush(ctx) {
  const player = ctx.players[0];
  if (!player) return false;
  const dimension = player.dimension;

  // The Java predicate has no extra 45-block distance gate for ambushes. A
  // 24-block minimum retains the vanilla natural-spawn safety envelope used
  // by the script adapter without adding the stalk-only source restriction.
  const location = pickSurfaceCandidate(player, 24, 90);
  if (!location) return false;

  if (!commonSourceGates(dimension)) return false;
  if (!hasSkyLightAt(dimension, location)) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  if (!worldState.get("hasMoonCorrupted")) return false;
  if (worldState.get("tbeSpawnDelay") > 0) return false;
  if (hasOtherBrokenEndsInRange(dimension, location)) return false;

  const corruptStage = Math.max(0, Math.min(2, Number(worldState.get("moonStage") ?? 0)));
  const inventoryCorruption = Math.max(
    0,
    Math.min(5, Number(worldState.get("inventoryCorruption") ?? 0)),
  );
  const chance =
    (SPAWN_MATRIX_AMBUSH[corruptStage]?.[inventoryCorruption] ?? 0) +
    eventFrequency(ctx.gameTime ?? 0);
  if (Math.random() > chance) return false;

  const spawned = spawnHelpers.trySummon(
    dimension,
    "thebrokenscript:the_broken_end_ambush",
    location,
  );
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);
  worldState.set("tbeSpawnDelay", 8200);
  return true;
}

export function register() {
  spawnDirector.registerRule({
    id: "tbe_stalk",
    predicate: (ctx) => canSpawnTbeStalk(ctx),
  });
  spawnDirector.registerRule({
    id: "tbe_ambush",
    predicate: (ctx) => canSpawnTbeAmbush(ctx),
  });
}
