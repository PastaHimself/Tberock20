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
  "thebrokenscript:circuit",
  "thebrokenscript:circuit_stalk",
  "thebrokenscript:circuit_stare",
  "thebrokenscript:circuit_mineshaft_walk",
  "thebrokenscript:circuit_mineshaft_stare",
  "thebrokenscript:circuit_mineshaft_flee",
];
const CIRCUIT_STALK_CHANCE = 0.015;
const CIRCUIT_SPAWN_DELAY = 5200;
const CIRCUIT_EXCLUSION_RANGE = 420;
const CAVE_MIN_DISTANCE = 24;
const CAVE_MAX_DISTANCE = 64;

function isBlacklistedBiome(dimension, location) {
  try {
    const biome = dimension.getBiome?.(location);
    const id = biome?.id ?? biome?.name ?? "";
    return BIOME_BLACKLIST_SUBSTRINGS.some((s) => String(id).includes(s));
  } catch {
    return false;
  }
}

function difficultyIsPeaceful() {
  try {
    return String(world.getDifficulty()).toLowerCase() === "peaceful";
  } catch {
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
    } catch {
      return undefined;
    }
  }

  return undefined;
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

  const candidate = findCaveCandidate(player);
  if (!candidate) return false;
  if (isBlacklistedBiome(dim, candidate)) return false;

  if (skyLightAt(dim, player.location) !== 0) return false;
  if (skyLightAt(dim, candidate) !== 0) return false;
  if (skyLightAt(dim, { ...candidate, y: candidate.y + 1 }) !== 0) return false;

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

export function register() {
  spawnDirector.registerRule({
    id: "circuit_stalk",
    predicate: (ctx) => canSpawnCircuitStalk(ctx),
  });
}
