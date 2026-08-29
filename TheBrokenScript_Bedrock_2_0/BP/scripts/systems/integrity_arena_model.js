// Pure, source-backed Integrity/XCSF arena semantics.
// Keep this module free of @minecraft/server imports so CI can regression-test
// Java parity without requiring a Bedrock runtime.

export const INTEGRITY_PHASE = Object.freeze({
  PHASE_1: "phase1",
  PHASE_2: "phase2",
  PHASE_3: "phase3",
});

export const ARENA_SOURCE = Object.freeze({
  participantRadius: 150,
});

export const PHASE1_SOURCE = Object.freeze({
  introDelayTicks: 1080,
  terrainCorruptionRadius: 100,
  terrainCorruptionDelayTicks: 20,
  chordMaxCount: 10,
  chordRadius: 10,
});

// Stage2Floor.kt/CFR output. `boundsMinDistance` is the SpawnBounds value;
// FLOOR_4/FLOOR_5/FLOOR_6_INTEG use the constructor default of 32.
export const STAGE2_FLOORS = Object.freeze([
  Object.freeze({ id: "FLOOR_1", yMin: 249, yMax: 300, spawnY: 254, sourceSpawns: Object.freeze(["TETHER", "INTEGRITY_PHASE_2"]), boundsMinDistance: 48 }),
  Object.freeze({ id: "FLOOR_2", yMin: 230, yMax: 248, spawnY: 235, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 32 }),
  Object.freeze({ id: "FLOOR_3", yMin: 214, yMax: 229, spawnY: 219, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 16 }),
  Object.freeze({ id: "FLOOR_4", yMin: 206, yMax: 213, spawnY: 209, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 32 }),
  Object.freeze({ id: "FLOOR_5", yMin: 200, yMax: 205, spawnY: 203, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 32 }),
  Object.freeze({ id: "FLOOR_6", yMin: 160, yMax: 199, spawnY: 163, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 8 }),
  Object.freeze({ id: "FLOOR_6_INTEG", yMin: 160, yMax: 180, spawnY: 163, sourceSpawns: Object.freeze([]), boundsMinDistance: 32 }),
  Object.freeze({ id: "FLOOR_7", yMin: -2147483648, yMax: 159, spawnY: 104, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 28 }),
]);

// Phase2Floors is deliberately not the same enum as Stage2Floor. Floor6 maps
// to FLOOR_6_INTEG, while floor-spawn lookup sees FLOOR_6 first.
export const PHASE2_INTEGRITY_FLOORS = Object.freeze([
  Object.freeze({ id: "Floor1", stage2Floor: "FLOOR_1", level: 1 }),
  Object.freeze({ id: "Floor2", stage2Floor: "FLOOR_2", level: 2 }),
  Object.freeze({ id: "Floor3", stage2Floor: "FLOOR_3", level: 3 }),
  Object.freeze({ id: "Floor4", stage2Floor: "FLOOR_4", level: 4 }),
  Object.freeze({ id: "Floor5", stage2Floor: "FLOOR_5", level: 5 }),
  Object.freeze({ id: "Floor6", stage2Floor: "FLOOR_6_INTEG", level: 6 }),
  Object.freeze({ id: "Floor7", stage2Floor: "FLOOR_7", level: 7 }),
]);

export const PHASE2_SOURCE = Object.freeze({
  transferDelayTicks: 20,
  recoveryBandMinY: 190,
  recoveryBandMaxYExclusive: 199,
  recoveryTeleport: Object.freeze({ x: 85.5, y: 162.5, z: 87.5 }),
  lowestPlayerMinYExclusive: 103,
});

// Stage2Generator.java is a Java custom chunk generator. Bedrock's static
// dimension JSON cannot execute this generator, so this is an audit model only.
// Every structure id below is a source template reference; it is not a claim
// that a Java NBT template can be placed by the Bedrock runtime unchanged.
const STAGE2_FLOOR2_VARIANTS = Object.freeze([
  Object.freeze({ variant: 1, structureId: "clandimensionroom1", specialStructureId: null, ordinaryStructureId: null }),
  Object.freeze({ variant: 2, structureId: "clandimensionroom2", specialStructureId: null, ordinaryStructureId: null }),
  Object.freeze({ variant: 3, structureId: "clandimensionroom3", specialStructureId: null, ordinaryStructureId: null }),
  Object.freeze({ variant: 4, structureId: "clandimensionroom3", specialStructureId: null, ordinaryStructureId: null }),
  Object.freeze({ variant: 5, structureId: null, specialStructureId: "clandimensionroom2", ordinaryStructureId: "clandimensionroom5" }),
]);

const STAGE2_FLOOR3_VARIANTS = Object.freeze([
  Object.freeze({ variant: 1, ordinaryStructureId: "woodfloor1", extraStructureId: null }),
  Object.freeze({ variant: 2, ordinaryStructureId: "woodfloor2", extraStructureId: null }),
  Object.freeze({ variant: 3, ordinaryStructureId: "woodfloor3", extraStructureId: null }),
  Object.freeze({ variant: 4, ordinaryStructureId: "woodfloor4", extraStructureId: null }),
  Object.freeze({ variant: 5, ordinaryStructureId: "woodfloor5", extraStructureId: null }),
  Object.freeze({ variant: 6, ordinaryStructureId: "woodfloor6", extraStructureId: null }),
  Object.freeze({ variant: 7, ordinaryStructureId: "woodfloor7", extraStructureId: null }),
  Object.freeze({ variant: 8, ordinaryStructureId: "woodfloor4", extraStructureId: "woodfloor8" }),
  Object.freeze({ variant: 9, ordinaryStructureId: "woodfloor4", extraStructureId: "woodfloor9" }),
  Object.freeze({ variant: 10, ordinaryStructureId: "woodfloor1", extraStructureId: "tek_woodfloor1" }),
  Object.freeze({ variant: 11, ordinaryStructureId: "woodfloor1", extraStructureId: "tek_woodfloor2" }),
  Object.freeze({ variant: 12, ordinaryStructureId: "woodfloor2", extraStructureId: "tek_woodfloor3" }),
  Object.freeze({ variant: 13, ordinaryStructureId: "woodfloor2", extraStructureId: "tek_woodfloor4" }),
  Object.freeze({ variant: 14, ordinaryStructureId: "woodfloor3", extraStructureId: "tek_woodfloor6" }),
  Object.freeze({ variant: 15, ordinaryStructureId: "woodfloor3", extraStructureId: "tek_woodfloor7" }),
  Object.freeze({ variant: 16, ordinaryStructureId: "woodfloor4", extraStructureId: "tek_woodfloor8" }),
  Object.freeze({ variant: 17, ordinaryStructureId: "woodfloor4", extraStructureId: "tek_woodfloor9" }),
  Object.freeze({ variant: 18, ordinaryStructureId: "woodfloor1", extraStructureId: "tek_woodfloor10" }),
  Object.freeze({ variant: 19, ordinaryStructureId: "woodfloor1", extraStructureId: null }),
  Object.freeze({ variant: 20, ordinaryStructureId: "woodfloor2", extraStructureId: "tek_woodfloor12" }),
  Object.freeze({ variant: 21, ordinaryStructureId: "woodfloor2", extraStructureId: "tek_woodfloor13" }),
  Object.freeze({ variant: 22, ordinaryStructureId: "woodfloor3", extraStructureId: "tek_woodfloor14" }),
  Object.freeze({ variant: 23, ordinaryStructureId: "woodfloor3", extraStructureId: "tek_woodfloor15" }),
  Object.freeze({ variant: 24, ordinaryStructureId: "woodfloor4", extraStructureId: "tek_woodfloor16" }),
  Object.freeze({ variant: 25, ordinaryStructureId: "woodfloor4", extraStructureId: "tek_woodfloor17" }),
  Object.freeze({ variant: 26, ordinaryStructureId: "woodfloor1", extraStructureId: "tek_woodfloor18" }),
  Object.freeze({ variant: 27, ordinaryStructureId: "woodfloor2", extraStructureId: "tek_woodfloor20" }),
  Object.freeze({ variant: 28, ordinaryStructureId: "woodfloor2", extraStructureId: "tek_woodfloor21" }),
  Object.freeze({ variant: 29, ordinaryStructureId: "woodfloor3", extraStructureId: "tek_woodfloor22" }),
  Object.freeze({ variant: 30, ordinaryStructureId: "woodfloor3", extraStructureId: "tek_woodfloor23" }),
  Object.freeze({ variant: 31, ordinaryStructureId: "woodfloor4", extraStructureId: "tek_woodfloor24" }),
  Object.freeze({ variant: 32, ordinaryStructureId: "woodfloor4", extraStructureId: "tek_woodfloor25" }),
  Object.freeze({ variant: 33, ordinaryStructureId: "woodfloor1", extraStructureId: "tek_woodfloor26" }),
  Object.freeze({ variant: 34, ordinaryStructureId: "woodfloor1", extraStructureId: "tek_woodfloor27" }),
  Object.freeze({ variant: 35, ordinaryStructureId: "woodfloor2", extraStructureId: "tek_woodfloor28" }),
  Object.freeze({ variant: 36, ordinaryStructureId: "woodfloor2", extraStructureId: null }),
  Object.freeze({ variant: 37, ordinaryStructureId: "woodfloor6", extraStructureId: null }),
]);

export const STAGE2_GENERATOR_SOURCE = Object.freeze({
  runtimeStatus: "blocked_custom_chunk_generator",
  namespace: "thebrokenscript",
  roomMinBlock: 16,
  roomMaxBlock: 160,
  generationRegionMaxBlockInclusive: 160,
  barrierRegionMaxBlockExclusive: 162,
  structureSourceRoot: "source_extracted/data/thebrokenscript/structure",
  roomPlacements: Object.freeze([
    Object.freeze({
      y: 200,
      variant: "floor1",
      structureIds: Object.freeze([
        "clanvoidnew1", "clanvoidnew2", "clanvoidnew3", "clanvoidnew4",
        "clanvoidnew5", "clanvoidnew6", "clanvoidnew7",
      ]),
    }),
    Object.freeze({
      y: 207,
      variant: "floor2",
      structureIds: Object.freeze([
        "clandimensionroom1", "clandimensionroom2", "clandimensionroom3", "clandimensionroom5",
      ]),
    }),
    Object.freeze({
      y: 217,
      variant: "floor3",
      structureIds: Object.freeze([
        "woodfloor1", "woodfloor2", "woodfloor3", "woodfloor4", "woodfloor5", "woodfloor6",
        "woodfloor7", "woodfloor8", "woodfloor9", "tek_woodfloor1", "tek_woodfloor2",
        "tek_woodfloor3", "tek_woodfloor4", "tek_woodfloor6", "tek_woodfloor7",
        "tek_woodfloor8", "tek_woodfloor9", "tek_woodfloor10", "tek_woodfloor12",
        "tek_woodfloor13", "tek_woodfloor14", "tek_woodfloor15", "tek_woodfloor16",
        "tek_woodfloor17", "tek_woodfloor18", "tek_woodfloor20", "tek_woodfloor21",
        "tek_woodfloor22", "tek_woodfloor23", "tek_woodfloor24", "tek_woodfloor25",
        "tek_woodfloor26", "tek_woodfloor27", "tek_woodfloor28",
      ]),
    }),
    Object.freeze({
      y: 233,
      variant: "floor4",
      structureIds: Object.freeze([
        "stone1", "stone2", "stone3", "stone4", "stone5", "stone6", "stone7",
      ]),
    }),
  ]),
  floor2Variants: STAGE2_FLOOR2_VARIANTS,
  floor3Variants: STAGE2_FLOOR3_VARIANTS,
  surfacePlacement: Object.freeze({
    y: 252,
    structureIds: Object.freeze(["fieldbase", "fieldbase2"]),
    primaryProbability: 0.99,
  }),
  floorLayers: Object.freeze([
    Object.freeze({ y: 199, sourceBlock: "TBSBlocks.COBBLESTONE_BORDER_BLOCK", belowBlock: "minecraft:barrier" }),
    Object.freeze({ y: 160, sourceBlock: "minecraft:bedrock", belowBlock: "minecraft:barrier" }),
  ]),
  barrierLayers: Object.freeze([251, 232, 216, 206, 102, 271]),
  nowhere: Object.freeze({
    y: 100,
    randomOffset: 341873128712,
    divider: 1,
  }),
  tunnel: Object.freeze({
    x: 80,
    y: 160,
    excludedZ: Object.freeze([0, 160]),
    structureIds: Object.freeze([
      "bedrockhallway1", "bedrockhallway2", "bedrockhallway3", "bedrockhallway4", "bedrockhallway5",
      "bedrockhallway6", "bedrockhallway7", "bedrockhallway8", "bedrockhallway9", "bedrockhallway10",
    ]),
    primaryProbability: 0.9,
  }),
});

export const PHASE3_SOURCE = Object.freeze({
  center: Object.freeze({ x: 194, y: -59, z: 205 }),
  transferDelayTicks: 20,
  upperBoundaryYExclusive: 90,
  boundaryKillDelayTicks: 60,
  minTentacleRange: 100,
  maxTentacleRangeExclusive: 124,
  tentacleConstantCount: 250,
  tentacleCandidateIndexMin: 0,
  tentacleCandidateIndexMaxInclusive: 250,
  tentacleCircleCenter: Object.freeze({ x: 200, z: 202 }),
  endDiscardDelayTicks: 298,
  presetTentacles: Object.freeze([
    Object.freeze({ x: 162, y: -59, z: 232 }),
    Object.freeze({ x: 186, y: -59, z: 181 }),
    Object.freeze({ x: 228, y: -59, z: 213 }),
  ]),
});

export function nextIntegrityPhase(phase) {
  switch (phase) {
    case INTEGRITY_PHASE.PHASE_1: return INTEGRITY_PHASE.PHASE_2;
    case INTEGRITY_PHASE.PHASE_2: return INTEGRITY_PHASE.PHASE_3;
    case INTEGRITY_PHASE.PHASE_3: return null;
    default: return null;
  }
}

// Mirrors Arena.checkLivingPlayers after disconnected cached players are removed.
// The Java source intentionally/oddly allows one or two connected participants to
// keep the arena alive even when both are dead; for 3+ players at least one must live.
export function arenaCheckLivingPlayers(participants) {
  const connected = participants.filter((player) => player?.connected !== false);
  if (connected.length === 0) return false;
  if (connected.length <= 2) return true;
  return connected.some((player) => player?.alive === true);
}

// Phase1.hasLivingChords returns true for an empty tracked list. That prevents the
// phase from ending during the 1080-tick crawl-out delay before Chords are spawned.
export function phase1HasLivingChords(chords) {
  if (chords.length === 0) return true;
  return chords.some((chord) => chord === true || chord?.alive === true);
}

export function phase1Ended(chords) {
  return !phase1HasLivingChords(chords);
}

export function stage2SpawnFloorFromY(y) {
  return STAGE2_FLOORS.find((floor) => y >= floor.yMin && y <= floor.yMax) ?? null;
}

export function stage2GeneratorFloor2Structure(variant, special) {
  const entry = STAGE2_FLOOR2_VARIANTS.find((candidate) => candidate.variant === variant);
  if (!entry) throw new RangeError(`Stage2 floor 2 variant must be in 1..5: ${variant}`);
  if (entry.specialStructureId) {
    return special === true ? entry.specialStructureId : entry.ordinaryStructureId;
  }
  return entry.structureId;
}

export function stage2GeneratorFloor3Structure(variant, randomExtra) {
  const entry = STAGE2_FLOOR3_VARIANTS.find((candidate) => candidate.variant === variant);
  if (!entry) throw new RangeError(`Stage2 floor 3 variant must be in 1..37: ${variant}`);
  return randomExtra === true && entry.extraStructureId
    ? entry.extraStructureId
    : entry.ordinaryStructureId;
}

export function stage2GeneratorFloor4Structure(special, rareVariant, variant) {
  if (special !== true || rareVariant !== true) return "stone1";
  if (!Number.isInteger(variant) || variant < 1 || variant > 6) {
    throw new RangeError(`Stage2 floor 4 variant must be in 1..6: ${variant}`);
  }
  return `stone${variant + 1}`;
}

export function stage2GeneratorRegion(chunkWorldX, chunkWorldZ) {
  const inGenerationRegion = (
    chunkWorldX >= 0
    && chunkWorldX < STAGE2_GENERATOR_SOURCE.generationRegionMaxBlockInclusive + 1
    && chunkWorldZ >= 0
    && chunkWorldZ < STAGE2_GENERATOR_SOURCE.generationRegionMaxBlockInclusive + 1
  );
  if (!inGenerationRegion) return null;
  const isBorder = (
    chunkWorldX === 0
    || chunkWorldX === STAGE2_GENERATOR_SOURCE.generationRegionMaxBlockInclusive
    || chunkWorldZ === 0
    || chunkWorldZ === STAGE2_GENERATOR_SOURCE.generationRegionMaxBlockInclusive
  );
  return isBorder ? "border" : "interior";
}

export function stage2GeneratorBarrierApplies(chunkWorldX, chunkWorldZ) {
  return (
    chunkWorldX >= 0
    && chunkWorldX < STAGE2_GENERATOR_SOURCE.barrierRegionMaxBlockExclusive
    && chunkWorldZ >= 0
    && chunkWorldZ < STAGE2_GENERATOR_SOURCE.barrierRegionMaxBlockExclusive
  );
}

export function stage2GeneratorDecorationPlan(chunkWorldX, chunkWorldZ) {
  const region = stage2GeneratorRegion(chunkWorldX, chunkWorldZ);
  if (region === null) return null;
  if (region === "border") {
    return {
      region,
      surface: null,
      floorLayers: [],
      barrierLayers: [271],
      outerBarrierY: 271,
      nowhere: null,
      roomPlacements: [],
      tunnel: null,
    };
  }

  const tunnel = (
    chunkWorldX === STAGE2_GENERATOR_SOURCE.tunnel.x
    && !STAGE2_GENERATOR_SOURCE.tunnel.excludedZ.includes(chunkWorldZ)
  )
    ? {
      y: STAGE2_GENERATOR_SOURCE.tunnel.y,
      structureIds: STAGE2_GENERATOR_SOURCE.tunnel.structureIds,
      primaryProbability: STAGE2_GENERATOR_SOURCE.tunnel.primaryProbability,
    }
    : null;
  return {
    region,
    surface: STAGE2_GENERATOR_SOURCE.surfacePlacement,
    floorLayers: STAGE2_GENERATOR_SOURCE.floorLayers,
    barrierLayers: STAGE2_GENERATOR_SOURCE.barrierLayers.filter((y) => y !== 271),
    outerBarrierY: 271,
    nowhere: STAGE2_GENERATOR_SOURCE.nowhere,
    roomPlacements: STAGE2_GENERATOR_SOURCE.roomPlacements,
    tunnel,
  };
}

// Stage2Util.java spawn math. These helpers accept plain data so the exact Java
// rules can be tested without importing @minecraft/server.
export const STAGE2_UTIL_SOURCE = Object.freeze({
  cellSizeChunks: 10,
  cellSizeBlocks: 160,
  centerOffsetBlocks: 88,
  centerY: 253,
  centerChunkOffset: 5,
  defaultMaxAttempts: 40,
  defaultScanDepth: 4,
  candidateAboveOffset: 1,
  specialSpawnYMinInclusive: 160,
  specialSpawnYMaxExclusive: 201,
  specialBlockXOffset: 5,
  integrityTetherExclusionRadius: 50,
});

function stage2ChunkFromBlockCoordinate(blockCoordinate) {
  return Math.floor(blockCoordinate / 16);
}

function stage2CellOriginChunk(chunkCoordinate) {
  return Math.floor(chunkCoordinate / STAGE2_UTIL_SOURCE.cellSizeChunks)
    * STAGE2_UTIL_SOURCE.cellSizeChunks;
}

export function stage2CenterOfExistingGeneration(playerBlock) {
  const chunkX = stage2ChunkFromBlockCoordinate(playerBlock.x);
  const chunkZ = stage2ChunkFromBlockCoordinate(playerBlock.z);
  const cellChunkX = stage2CellOriginChunk(chunkX);
  const cellChunkZ = stage2CellOriginChunk(chunkZ);
  return {
    x: cellChunkX * 16 + STAGE2_UTIL_SOURCE.centerOffsetBlocks,
    y: STAGE2_UTIL_SOURCE.centerY,
    z: cellChunkZ * 16 + STAGE2_UTIL_SOURCE.centerOffsetBlocks,
  };
}

export function stage2SpawnCellChunksFromPlayerBlock(playerBlock) {
  const chunkX = stage2ChunkFromBlockCoordinate(playerBlock.x);
  const chunkZ = stage2ChunkFromBlockCoordinate(playerBlock.z);
  const cellChunkX = stage2CellOriginChunk(chunkX);
  const cellChunkZ = stage2CellOriginChunk(chunkZ);
  return {
    cellChunk: { x: cellChunkX, z: cellChunkZ },
    centerChunk: {
      x: cellChunkX + STAGE2_UTIL_SOURCE.centerChunkOffset,
      z: cellChunkZ + STAGE2_UTIL_SOURCE.centerChunkOffset,
    },
  };
}

export function stage2IsSpecialSpawnBand(spawnY) {
  return (
    spawnY >= STAGE2_UTIL_SOURCE.specialSpawnYMinInclusive
    && spawnY < STAGE2_UTIL_SOURCE.specialSpawnYMaxExclusive
  );
}

export function stage2SpawnAttemptCoordinates({
  cellChunk,
  centerChunk,
  spawnY,
  minBlockDistance,
  isTether,
  randomChunkXOffset,
  randomChunkZOffset,
  randomBlockXOffset,
  randomBlockZOffset,
}) {
  const specialBand = stage2IsSpecialSpawnBand(spawnY);
  const chunkX = !specialBand && isTether
    ? cellChunk.x + randomChunkXOffset
    : centerChunk.x;
  const chunkZ = cellChunk.z + randomChunkZOffset;
  const minChunkDistance = Math.floor(minBlockDistance / 16);
  const dChunkX = chunkX - centerChunk.x;
  const dChunkZ = chunkZ - centerChunk.z;
  if (dChunkX * dChunkX + dChunkZ * dChunkZ < minChunkDistance * minChunkDistance) {
    return null;
  }
  return {
    chunkX,
    chunkZ,
    blockX: chunkX * 16 + (specialBand
      ? STAGE2_UTIL_SOURCE.specialBlockXOffset
      : randomBlockXOffset),
    blockZ: chunkZ * 16 + randomBlockZOffset,
  };
}

// getRandomFloorPos rejects an IntegrityPhase2 candidate only when the
// radius-limited closest-Tether query finds an entity.
export function stage2IntegrityPositionAllowed(hasNearbyTether) {
  return !hasNearbyTether;
}

export function stage2IsValidFloor(state) {
  if (state.isAir || state.canBeReplaced) return false;
  return state.canStandOnUp || state.isBarrier || state.isMud;
}

export function stage2FindSafeSpawnY({
  spawnY,
  maxScanDepth = STAGE2_UTIL_SOURCE.defaultScanDepth,
  isValidFloor,
  areAboveBlocksReplaceable,
}) {
  for (let dy = 0; dy <= maxScanDepth; dy += 1) {
    const candidateY = spawnY - dy;
    if (
      isValidFloor(candidateY)
      && [1, 2, 3].every((offset) => areAboveBlocksReplaceable(candidateY, offset))
    ) {
      return candidateY + STAGE2_UTIL_SOURCE.candidateAboveOffset;
    }
  }
  return null;
}

export function phase2IntegrityFloorFromY(y) {
  for (const floor of PHASE2_INTEGRITY_FLOORS) {
    const stage = STAGE2_FLOORS.find((entry) => entry.id === floor.stage2Floor);
    if (stage && y >= stage.yMin && y <= stage.yMax) return floor;
  }
  return null;
}

export function phase2NeedsRecoveryTeleport(y) {
  return y >= PHASE2_SOURCE.recoveryBandMinY && y < PHASE2_SOURCE.recoveryBandMaxYExclusive;
}

export function phase2EligibleForLowestPlayer(y) {
  return y > PHASE2_SOURCE.lowestPlayerMinYExclusive;
}

// Phase2.getEnded() returns the final field `ended`, which is never assigned true
// in Phase2.java. Do not manufacture a health threshold for this phase.
export function phase2Ended() {
  return false;
}

export function phase3BoundaryKillEligible(y, inStage3Dimension) {
  return inStage3Dimension === true && y > PHASE3_SOURCE.upperBoundaryYExclusive;
}

export function phase3Ended(integrityDying) {
  return integrityDying === true;
}

export function phase3TentacleCandidateCount() {
  return PHASE3_SOURCE.tentacleCandidateIndexMaxInclusive - PHASE3_SOURCE.tentacleCandidateIndexMin + 1;
}
