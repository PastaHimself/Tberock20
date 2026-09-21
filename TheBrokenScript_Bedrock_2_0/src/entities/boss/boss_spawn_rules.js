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

const FRACTURED_ROW = [0.01, 0.02, 0.03, 0.04, 0.05, 0.06];
const FEVER_STALK_ROW = [0.0005, 0.001, 0.0015, 0.002, 0.0025, 0.003];
const FRACTURED_DIMENSION = "thebrokenscript:the_moon";
const SOURCE_EXCLUSION_RANGE = 512;

function difficultyIsPeaceful() {
  try {
    return String(world.getDifficulty()).toLowerCase() === "peaceful";
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.boss.boss_spawn_rules.js.difficulty",
      "best-effort Bedrock API fallback",
      error,
    );
    return true;
  }
}

function sourceWorldGates() {
  if (difficultyIsPeaceful()) return false;
  if (world.gameRules?.doMobSpawning !== true) return false;
  if (config.get("danger.disableSpawningEntities")) return false;
  return true;
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
      "audit.BP.scripts.entities.boss.boss_spawn_rules.js.candidate",
      "best-effort Bedrock API fallback",
      error,
    );
    return undefined;
  }
}

function stageIndex() {
  const stage = Number(worldState.get("moonStage") ?? 0);
  return Math.max(0, Math.min(5, stage));
}

function nearestPlayer(players, dimension, location, maxDistance) {
  let nearest;
  let nearestDistance = Number.POSITIVE_INFINITY;
  for (const player of players) {
    if (!player || player.dimension?.id !== dimension.id) continue;
    const distance = Math.hypot(
      player.location.x - location.x,
      player.location.y - location.y,
      player.location.z - location.z,
    );
    if (distance <= maxDistance && distance < nearestDistance) {
      nearest = player;
      nearestDistance = distance;
    }
  }
  return nearest;
}

function feverPlayerYGate(ctx, dimension, location) {
  const player = nearestPlayer(ctx.players, dimension, location, 512);
  if (!player || player.location.y < 130) return false;
  const normalized = Math.max(0, Math.min(1, (player.location.y - 130) / (320 - 130)));
  return Math.random() <= normalized * 0.75;
}

function hasOtherJims(dimension, location) {
  return entityFinder.hasEntitiesInRange(
    dimension,
    location,
    SOURCE_EXCLUSION_RANGE,
    ["thebrokenscript:fractured", "thebrokenscript:fractured_roam"],
  );
}

function hasOtherFevers(dimension, location) {
  return entityFinder.hasEntitiesInRange(
    dimension,
    location,
    SOURCE_EXCLUSION_RANGE,
    ["thebrokenscript:fever_stalk"],
  );
}

function canSpawnFracturedRoam(ctx) {
  const player = ctx.players[0];
  if (!player || !sourceWorldGates()) return false;
  const dimension = player.dimension;

  // Source: FracturedConditions.predicate().
  if (dimension.id !== FRACTURED_DIMENSION) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (!worldState.get("canFracturedSpawn")) return false;

  const location = pickSurfaceCandidate(player, 48, 96);
  if (!location) return false;
  if (hasOtherJims(dimension, location)) return false;

  const chance = FRACTURED_ROW[stageIndex()] + eventFrequency(ctx.gameTime ?? 0);
  if (Math.random() > chance) return false;

  const spawned = spawnHelpers.trySummon(
    dimension,
    "thebrokenscript:fractured_roam",
    location,
  );
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);
  return true;
}

function canSpawnFeverStalk(ctx) {
  const player = ctx.players[0];
  if (!player || !sourceWorldGates()) return false;
  const dimension = player.dimension;

  // Source: FeverStalkConditions.predicate().
  if (dimension.id !== "minecraft:overworld") return false;
  if (!worldState.get("isNullHere")) return false;

  const location = pickSurfaceCandidate(player, 32, 80);
  if (!location) return false;
  if (!hasSkyLightAt(dimension, location)) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  if (hasOtherFevers(dimension, location)) return false;
  if (!feverPlayerYGate(ctx, dimension, location)) return false;

  const chance = FEVER_STALK_ROW[stageIndex()] + eventFrequency(ctx.gameTime ?? 0);
  if (Math.random() > chance) return false;

  const spawned = spawnHelpers.trySummon(
    dimension,
    "thebrokenscript:fever_stalk",
    location,
  );
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);
  return true;
}

export function register() {
  spawnDirector.registerRule({
    id: "fractured_roam",
    predicate: (ctx) => canSpawnFracturedRoam(ctx),
  });
  spawnDirector.registerRule({
    id: "fever_stalk",
    predicate: (ctx) => canSpawnFeverStalk(ctx),
  });
}
