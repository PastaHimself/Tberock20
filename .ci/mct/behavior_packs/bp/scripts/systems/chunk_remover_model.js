// Pure source-parity decisions for ChunkRemoverEntity and its persistent
// player-modified-chunk guard. Low-level Java chunk storage is intentionally
// kept out of this module; the runtime adapter uses supported Bedrock commands
// and fill operations instead.

export const CHUNK_REMOVER_SOURCE = Object.freeze({
  spawnChance: 0.0001,
  clearChance: 0.05,
  minNearestPlayerDistance: 25,
  moveOffsetMinSections: 1,
  moveOffsetMaxExclusiveSections: 9,
  sectionHeight: 16,
});

const CHUNK_KEY_SEPARATOR = "|";

function finiteNumber(value) {
  return typeof value === "number" && Number.isFinite(value);
}

/** @param {Record<string, any>} options */
export function chunkSpawnDecision(options = {}) {
  const {
    difficultyPeaceful = false,
    spawnReason,
    belowBlockValid = false,
    doMobSpawning = false,
    isNullHere = false,
    disableSpawningEntities = false,
    dimensionId,
    disableChunkRemoval = false,
    spawnRoll,
    nearestPlayerDistance = null,
    canSeeSkyFromBelowWater = false,
    arenaPhase,
    flat = false,
    flatRoll,
    blockLight,
    modifiedChunkCount = 0,
  } = options;
  if (difficultyPeaceful) return { allowed: false, reason: "peaceful" };
  if (spawnReason !== "spawner" && belowBlockValid !== true) {
    return { allowed: false, reason: "invalid_spawn_surface" };
  }
  if (doMobSpawning !== true) return { allowed: false, reason: "mob_spawning_disabled" };
  if (isNullHere !== true) return { allowed: false, reason: "null_not_here" };
  if (disableSpawningEntities === true) return { allowed: false, reason: "entity_spawning_disabled" };
  if (dimensionId !== "minecraft:overworld") return { allowed: false, reason: "wrong_dimension" };
  if (disableChunkRemoval === true) return { allowed: false, reason: "chunk_removal_disabled" };
  if (!finiteNumber(spawnRoll) || spawnRoll > CHUNK_REMOVER_SOURCE.spawnChance) {
    return { allowed: false, reason: "spawn_probability" };
  }
  if (finiteNumber(nearestPlayerDistance) && nearestPlayerDistance <= CHUNK_REMOVER_SOURCE.minNearestPlayerDistance) {
    return { allowed: false, reason: "player_too_close" };
  }
  if (canSeeSkyFromBelowWater !== true) return { allowed: false, reason: "sky_blocked" };
  if (arenaPhase === "phase1") return { allowed: false, reason: "arena_phase1" };
  if (flat && (!finiteNumber(flatRoll) || flatRoll > CHUNK_REMOVER_SOURCE.spawnChance)) {
    return { allowed: false, reason: "flat_world_probability" };
  }
  // The stable Script API exposes total brightness (sky + block), not Java's
  // LightLayer.BLOCK value. Runtime adapters pass that total brightness here
  // as a conservative, fail-closed surrogate.
  if (!finiteNumber(blockLight)) return { allowed: false, reason: "block_light_unavailable" };
  if (blockLight >= 1) return { allowed: false, reason: "block_lit" };
  if (!finiteNumber(modifiedChunkCount) || modifiedChunkCount >= 1) {
    return { allowed: false, reason: "player_modified_chunk" };
  }
  return { allowed: true, reason: "allowed" };
}

/** @param {Record<string, any>} options */
export function chunkRemovalPlan(options = {}) {
  const { actionRoll, offsetRoll } = options;
  if (finiteNumber(actionRoll) && actionRoll < CHUNK_REMOVER_SOURCE.clearChance) {
    return { operation: "clear" };
  }
  const safeOffsetRoll = Math.max(0, Math.min(1 - Number.EPSILON, Number(offsetRoll) || 0));
  const sections = CHUNK_REMOVER_SOURCE.moveOffsetMinSections +
    Math.floor(safeOffsetRoll * (CHUNK_REMOVER_SOURCE.moveOffsetMaxExclusiveSections - CHUNK_REMOVER_SOURCE.moveOffsetMinSections));
  return { operation: "move", offsetY: sections * CHUNK_REMOVER_SOURCE.sectionHeight };
}

/** Java uses `(int)x >> 4`, rather than floor division, for chunk operations. */
export function chunkCoordinate(value) {
  return (finiteNumber(value) ? Math.trunc(value) : 0) >> 4;
}

/**
 * A command/fill-based surrogate executes one 16-block section at a time from
 * the top down. Sections whose destinations leave the build range are cleared.
 */
/** @param {Record<string, any>} options */
export function chunkVerticalMovePlan(options = {}) {
  const { minY, maxY, offsetY } = options;
  if (![minY, maxY, offsetY].every(Number.isInteger) || maxY <= minY || offsetY <= 0 || offsetY % 16 !== 0) {
    return [];
  }
  const plan = [];
  for (let sourceY = maxY - 16; sourceY >= minY; sourceY -= 16) {
    const destinationY = sourceY + offsetY;
    plan.push(destinationY < maxY
      ? { sourceY, destinationY, operation: "move" }
      : { sourceY, destinationY, operation: "clear" });
  }
  return plan;
}

export function modifiedChunkKey(dimensionId, chunkX, chunkZ) {
  return [String(dimensionId), Math.trunc(chunkX), Math.trunc(chunkZ)].join(CHUNK_KEY_SEPARATOR);
}

/**
 * Persistent state is represented as `{version, entries}` instead of a raw
 * object so dimension names and negative chunk coordinates remain unambiguous.
 */
export function createModifiedChunkLedger(serialized = undefined) {
  const entries = new Map();
  if (serialized?.entries && Array.isArray(serialized.entries)) {
    for (const entry of serialized.entries) {
      if (typeof entry?.key !== "string" || !finiteNumber(entry.count) || entry.count < 1) continue;
      entries.set(entry.key, Math.trunc(entry.count));
    }
  } else if (serialized && typeof serialized === "object") {
    for (const [key, count] of Object.entries(serialized)) {
      if (finiteNumber(count) && count >= 1) entries.set(key, Math.trunc(count));
    }
  }

  return {
    count(dimensionId, chunkX, chunkZ) {
      return entries.get(modifiedChunkKey(dimensionId, chunkX, chunkZ)) ?? 0;
    },
    record(dimensionId, chunkX, chunkZ, delta) {
      const key = modifiedChunkKey(dimensionId, chunkX, chunkZ);
      const change = Math.trunc(Number(delta));
      if (!Number.isFinite(change) || change === 0) return entries.get(key) ?? 0;
      const next = (entries.get(key) ?? 0) + change;
      if (next > 0) entries.set(key, next);
      else entries.delete(key);
      return Math.max(0, next);
    },
    serialize() {
      return {
        version: 1,
        entries: [...entries.entries()].map(([key, count]) => ({ key, count })),
      };
    },
  };
}
