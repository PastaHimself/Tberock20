import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";

const BIOME_BLACKLIST_SUBSTRINGS = ["the_end", "end_midlands", "end_highlands", "null_biome"];
const CIRCUIT_FAMILY = [
  "thebrokenscript:circuit_stalk",
  "thebrokenscript:circuit_stare",
  "thebrokenscript:circuit_mineshaft_walk",
  "thebrokenscript:circuit_mineshaft_stare",
  "thebrokenscript:circuit_mineshaft_flee",
];
const CIRCUIT_STALK_CHANCE = 0.015;
const CIRCUIT_MINESHAFT_CHANCE = 0.065;
const CIRCUIT_SPAWN_DELAY = 5200;
const CIRCUIT_EXCLUSION_RANGE = 420;
const CIRCUIT_MINESHAFT_EXCLUSION_RANGE = 500;
const MINESHAFT_STRONG_BLOCKS = new Set([
  "minecraft:rail",
  "minecraft:powered_rail",
  "minecraft:detector_rail",
  "minecraft:activator_rail",
  "minecraft:cobweb",
]);
const MINESHAFT_PLANKS = new Set(["minecraft:oak_planks", "minecraft:dark_oak_planks"]);
const MINESHAFT_FENCES = new Set(["minecraft:oak_fence", "minecraft:dark_oak_fence"]);
const CAVE_MIN_DISTANCE = 24;
const CAVE_MAX_DISTANCE = 64;

function isBlacklistedBiome(dimension, location) {
  try {
    const biome = dimension.getBiome?.(location);
    const id = biome?.id ?? biome?.name ?? "";
    return BIOME_BLACKLIST_SUBSTRINGS.some((s) => String(id).includes(s));
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.circuit.circuit_spawn_rules.js.biome",
      "best-effort Bedrock API fallback",
      error,
    );
    return false;
  }
}

function difficultyIsPeaceful() {
  try {
    return String(world.getDifficulty()).toLowerCase() === "peaceful";
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.circuit.circuit_spawn_rules.js.difficulty",
      "best-effort Bedrock API fallback",
      error,
    );
    return true;
  }
}

function skyLightAt(dimension, location) {
  try {
    const value = dimension.getSkyLightLevel?.({
      x: Math.floor(location.x),
      y: Math.floor(location.y),
      z: Math.floor(location.z),
    });
    return typeof value === "number" ? value : undefined;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.circuit.circuit_spawn_rules.js.sky_light",
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
      "audit.BP.scripts.entities.circuit.circuit_spawn_rules.js.total_light",
      "best-effort Bedrock API fallback",
      error,
    );
    return undefined;
  }
}

function findCaveCandidate(player) {
  const angle = Math.random() * Math.PI * 2;
  const radius = CAVE_MIN_DISTANCE + Math.random() * (CAVE_MAX_DISTANCE - CAVE_MIN_DISTANCE);
  const x = Math.floor(player.location.x + Math.cos(angle) * radius);
  const z = Math.floor(player.location.z + Math.sin(angle) * radius);
  const centerY = Math.floor(player.location.y);

  for (let offset = 6; offset >= -12; offset--) {
    const y = centerY + offset;
    try {
      const below = player.dimension.getBlock({ x, y: y - 1, z });
      const at = player.dimension.getBlock({ x, y, z });
      const above = player.dimension.getBlock({ x, y: y + 1, z });
      if (!below || !at || !above) continue;
      if (below.isAir === true || below.typeId === "minecraft:air") continue;
      if (at.isAir !== true && at.typeId !== "minecraft:air") continue;
      if (above.isAir !== true && above.typeId !== "minecraft:air") continue;
      return { x: x + 0.5, y, z: z + 0.5 };
    } catch (error) {
      operationDiagnostics.warnOnce(
        "audit.BP.scripts.entities.circuit.circuit_spawn_rules.js.candidate",
        "best-effort Bedrock API fallback",
        error,
      );
      return undefined;
    }
  }

  return undefined;
}

// Java queries StructureTags.MINESHAFT in a 13×13×13 cube. Bedrock
// Script API has no structure-piece membership query, so use a conservative
// block signature: rails/cobwebs are decisive; otherwise require repeated
// plank + fence support blocks characteristic of vanilla mineshafts.
function looksLikeMineshaft(dimension, location) {
  const cx = Math.floor(location.x);
  const cy = Math.floor(location.y);
  const cz = Math.floor(location.z);
  let planks = 0;
  let fences = 0;

  try {
    for (let dx = -6; dx <= 6; dx++) {
      for (let dy = -6; dy <= 6; dy++) {
        for (let dz = -6; dz <= 6; dz++) {
          const typeId = dimension.getBlock({
            x: cx + dx,
            y: cy + dy,
            z: cz + dz,
          })?.typeId;
          if (!typeId) continue;
          if (MINESHAFT_STRONG_BLOCKS.has(typeId)) return true;
          if (MINESHAFT_PLANKS.has(typeId)) planks++;
          else if (MINESHAFT_FENCES.has(typeId)) fences++;
          if (planks >= 4 && fences >= 2) return true;
        }
      }
    }
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.circuit.circuit_spawn_rules.js.mineshaft_signature",
      "best-effort Bedrock structure-membership fallback",
      error,
    );
  }
  return false;
}

function canSpawnCircuitStalk(ctx) {
  const player = ctx.players[0];
  if (!player) return false;
  const dim = player.dimension;

  // Source: CircuitStalkConditions.predicate().
  if (difficultyIsPeaceful()) return false;
  if (world.gameRules?.doMobSpawning !== true) return false;
  if (!worldState.get("isNullHere")) return false;
  if (config.get("danger.disableSpawningEntities")) return false;
  if (dim.id !== "minecraft:overworld") return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  if (Math.random() > CIRCUIT_STALK_CHANCE + eventFrequency(ctx.gameTime)) return false;
  if (worldState.get("circuitSpawnDelay") > 0) return false;
  if (worldState.get("hasCircuitSpawned")) return false;

  // Java receives an engine-selected ON_GROUND spawn position. The script
  // director has no equivalent natural-spawn callback, so select a nearby
  // two-block-high cave floor and then apply the source-visible gates there.
  const candidate = findCaveCandidate(player);
  if (!candidate) return false;
  if (isBlacklistedBiome(dim, candidate)) return false;

  // CircuitStalkConditions requires zero sky light both at the player and at
  // the spawn position and rejects a spawn position that is on the surface.
  if (skyLightAt(dim, player.location) !== 0) return false;
  if (looksLikeMineshaft(dim, player.location)) return false;
  if (skyLightAt(dim, candidate) !== 0) return false;
  if (skyLightAt(dim, { ...candidate, y: candidate.y + 1 }) !== 0) return false;

  // Monster.isDarkEnoughToSpawn is not exposed directly. A total-light value
  // above 7 can never pass Java's block-light random gate, so reject that
  // provably-invalid subset without inventing a replacement probability.
  const totalLight = totalLightAt(dim, candidate);
  if (typeof totalLight === "number" && totalLight > 7) return false;

  if (entityFinder.hasEntitiesInRange(dim, candidate, CIRCUIT_EXCLUSION_RANGE, CIRCUIT_FAMILY)) return false;

  const spawned = spawnHelpers.trySummon(dim, "thebrokenscript:circuit_stalk", candidate);
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);

  worldState.set("circuitSpawnDelay", CIRCUIT_SPAWN_DELAY);
  worldState.set("hasCircuitSpawned", true);
  return true;
}

function canSpawnCircuitMineshaft(ctx) {
  const player = ctx.players[0];
  if (!player) return false;
  const dim = player.dimension;

  // Source: CircuitMineshaftConditions.predicate().
  if (difficultyIsPeaceful()) return false;
  if (dim.id !== "minecraft:overworld") return false;
  if (world.gameRules?.doMobSpawning !== true) return false;
  if (!worldState.get("isNullHere")) return false;
  if (config.get("danger.disableSpawningEntities")) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  if (!looksLikeMineshaft(dim, player.location)) return false;
  if (worldState.get("hasCircuitSpawned")) return false;

  const candidate = findCaveCandidate(player);
  if (!candidate) return false;
  if (isBlacklistedBiome(dim, candidate)) return false;
  if (!looksLikeMineshaft(dim, candidate)) return false;
  if (skyLightAt(dim, candidate) !== 0) return false;
  if (entityFinder.hasEntitiesInRange(
    dim,
    candidate,
    CIRCUIT_MINESHAFT_EXCLUSION_RANGE,
    CIRCUIT_FAMILY,
  )) return false;
  if (worldState.get("circuitSpawnDelay") > 0) return false;
  if (Math.random() > CIRCUIT_MINESHAFT_CHANCE + eventFrequency(ctx.gameTime)) return false;

  const typeId = Math.random() < 0.5
    ? "thebrokenscript:circuit_mineshaft_walk"
    : "thebrokenscript:circuit_mineshaft_stare";
  const spawned = spawnHelpers.trySummon(dim, typeId, candidate);
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);

  try {
    dim.playSound("ambient.cave", candidate, { volume: 10, pitch: 0 });
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.circuit.circuit_spawn_rules.js.mineshaft_sound",
      "best-effort Bedrock API fallback",
      error,
    );
  }

  worldState.set("circuitSpawnDelay", CIRCUIT_SPAWN_DELAY);
  worldState.set("hasCircuitSpawned", true);
  return true;
}

export function register() {
  spawnDirector.registerRule({
    id: "circuit_stalk",
    predicate: (ctx) => canSpawnCircuitStalk(ctx),
  });
  spawnDirector.registerRule({
    id: "circuit_mineshaft",
    predicate: (ctx) => canSpawnCircuitMineshaft(ctx),
  });
}
