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

// FinalCutscene.java is client-only in the source mod. Keep its timing and
// camera path explicit so a Bedrock presentation can consume the same contract
// without pretending that Java camera overrides or custom packets are portable.
export const PHASE3_CUTSCENE_SOURCE = Object.freeze({
  preLengthTicks: 108,
  movementLengthTicks: 190,
  zoomLengthTicks: 100,
  zoomOffsetTicks: 10,
  blackoutTicks: 40,
  totalLengthTicks: 428,
  positionStart: Object.freeze({ x: 194, y: -45, z: 169 }),
  positionEnd: Object.freeze({ x: 194, y: 10, z: 199 }),
  rotationStart: Object.freeze({ x: 0, y: 10 }),
  rotationEnd: Object.freeze({ x: 0, y: -90 }),
});

// TetherEntity.java and TentacleGoals.java. These are kept separate because
// Tether registers no custom melee goal while VoidTentacle does.
export const TETHER_SOURCE = Object.freeze({
  customMeleeGoal: false,
  maxHealth: 14,
  armor: 0,
  knockbackResistance: 1,
  pathRootCountMinInclusive: 8,
  pathRootCountMaxInclusive: 12,
  pathRadiusMinInclusive: 8,
  pathRadiusMaxInclusive: 16,
  pathMaxNodes: 24,
  pathVariance: 0,
  heartbeatCooldownTicks: 24,
  heartbeatPeriodTicks: 25,
  heartbeatVolume: 2,
  heartbeatPitch: 1,
  heartbeatSound: "WARDEN_HEARTBEAT",
  persistent: true,
  removeWhenFarAway: false,
  blockedDamageSources: Object.freeze(["integrity_phase_2", "in_wall"]),
});

// VoidTentacleEntity.java, TentacleGoals.java, and TentacleHitPacket.java.
// The multipliers include the source's `(scale * 0.7)` expression so callers
// can apply them directly to the entity's SCALE attribute.
export const VOID_TENTACLE_SOURCE = Object.freeze({
  targetAcquisitionRadius: 100,
  maxHealth: 14,
  armor: 0,
  knockbackResistance: 1,
  attackIntervalTicks: 25,
  attackSearchRadiusMultiplier: 5.6, // 8 * 0.7
  attackCandidateRadiusMultiplier: 4.9, // 7 * 0.7
  meleeRadiusMultiplier: 1.925, // 2.75 * 0.7
  sweepPlayerRadiusMultiplier: 4.2, // 6 * 0.7
  meleeDamage: 5,
  sweepDamage: 12,
  sweepChance: 0.35,
  sweepAnimation: "360_Sweep",
  sweepStuckDiscardDelayTicks: 60,
  stuckDurationTicks: 100,
  scaleMinInclusive: 1,
  scaleMaxInclusive: 5,
  persistent: true,
  removeWhenFarAway: false,
  allowedDamageCauses: Object.freeze(["override", "void"]),
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

// Phase3.kt uses IntRange(0, 250), a 0.025132742-radian step, and
// Random.nextInt(100, 124). The upper bound is exclusive for the random
// range, while the candidate index range is inclusive.
export function phase3TentacleCandidatePosition(index, range) {
  if (
    !Number.isInteger(index)
    || index < PHASE3_SOURCE.tentacleCandidateIndexMin
    || index > PHASE3_SOURCE.tentacleCandidateIndexMaxInclusive
  ) {
    throw new RangeError(
      `Phase 3 tentacle candidate index must be in 0..250: ${index}`,
    );
  }
  if (
    !Number.isInteger(range)
    || range < PHASE3_SOURCE.minTentacleRange
    || range >= PHASE3_SOURCE.maxTentacleRangeExclusive
  ) {
    throw new RangeError(
      `Phase 3 tentacle range must be in 100..123: ${range}`,
    );
  }

  const angle = 0.025132742 * index;
  return {
    x: Math.round(Math.cos(angle) * range + PHASE3_SOURCE.tentacleCircleCenter.x),
    z: Math.round(Math.sin(angle) * range + PHASE3_SOURCE.tentacleCircleCenter.z),
  };
}

// Mirrors Phase3.tick's LinkedHashMap countdown. A newly eligible player is
// inserted at 60 and decremented during the same tick, so the first returned
// state contains 59. The overlay that accompanies insertion is a Java custom
// packet/resource operation and is intentionally left to the runtime adapter.
export function phase3BoundaryKillStep({ pendingKills = {}, players = [] } = {}) {
  const nextPending = {};
  for (const [id, ticksLeft] of Object.entries(pendingKills)) {
    if (!Number.isInteger(ticksLeft) || ticksLeft < 0) {
      throw new RangeError(`Phase 3 pending kill must be a non-negative integer: ${ticksLeft}`);
    }
    nextPending[id] = ticksLeft;
  }

  const eligiblePlayers = players.filter((player) => (
    player?.id !== undefined
    && phase3BoundaryKillEligible(player.y, player.inStage3Dimension)
  ));
  const eligibleIds = new Set(eligiblePlayers.map((player) => String(player.id)));
  const startedIds = [];
  for (const player of eligiblePlayers) {
    const id = String(player.id);
    if (Object.prototype.hasOwnProperty.call(nextPending, id)) continue;
    nextPending[id] = PHASE3_SOURCE.boundaryKillDelayTicks;
    startedIds.push(id);
  }

  for (const id of Object.keys(nextPending)) {
    if (!eligibleIds.has(id)) delete nextPending[id];
  }

  const killIds = [];
  for (const id of Object.keys(nextPending)) {
    if (nextPending[id] <= 0) {
      killIds.push(id);
      delete nextPending[id];
    } else {
      nextPending[id] -= 1;
    }
  }

  return { pendingKills: nextPending, startedIds, killIds };
}

function clamp01(value) {
  return Math.min(1, Math.max(0, value));
}

function lerp(start, end, amount) {
  return start + (end - start) * amount;
}

// FinalCutscene.update() interpolates after adding deltaTime. This helper
// models the resulting state at an already-advanced tick value.
export function phase3CutsceneState(ticks) {
  if (!Number.isFinite(ticks)) {
    throw new RangeError(`Phase 3 cutscene ticks must be finite: ${ticks}`);
  }
  const t = Math.max(0, ticks);
  const motion = clamp01(
    (t - PHASE3_CUTSCENE_SOURCE.preLengthTicks)
    / PHASE3_CUTSCENE_SOURCE.movementLengthTicks,
  );
  const zoom = clamp01(
    (t
      - PHASE3_CUTSCENE_SOURCE.preLengthTicks
      - PHASE3_CUTSCENE_SOURCE.movementLengthTicks
      + PHASE3_CUTSCENE_SOURCE.zoomOffsetTicks)
    / PHASE3_CUTSCENE_SOURCE.zoomLengthTicks,
  );
  return {
    active: t <= PHASE3_CUTSCENE_SOURCE.totalLengthTicks,
    ended: t > PHASE3_CUTSCENE_SOURCE.totalLengthTicks,
    position: {
      x: lerp(PHASE3_CUTSCENE_SOURCE.positionStart.x, PHASE3_CUTSCENE_SOURCE.positionEnd.x, motion),
      y: lerp(PHASE3_CUTSCENE_SOURCE.positionStart.y, PHASE3_CUTSCENE_SOURCE.positionEnd.y, motion),
      z: lerp(PHASE3_CUTSCENE_SOURCE.positionStart.z, PHASE3_CUTSCENE_SOURCE.positionEnd.z, motion),
    },
    rotation: {
      x: lerp(PHASE3_CUTSCENE_SOURCE.rotationStart.x, PHASE3_CUTSCENE_SOURCE.rotationEnd.x, motion),
      y: lerp(PHASE3_CUTSCENE_SOURCE.rotationStart.y, PHASE3_CUTSCENE_SOURCE.rotationEnd.y, motion),
    },
    zoom: lerp(1, 5, zoom),
    blackout: t >= 388 && t < PHASE3_CUTSCENE_SOURCE.totalLengthTicks,
  };
}

export function tetherHeartbeatStep(cooldownTicks) {
  if (!Number.isInteger(cooldownTicks) || cooldownTicks < 0) {
    throw new RangeError(`Tether heartbeat cooldown must be a non-negative integer: ${cooldownTicks}`);
  }
  if (cooldownTicks === 0) {
    return { play: true, nextCooldown: TETHER_SOURCE.heartbeatCooldownTicks };
  }
  return { play: false, nextCooldown: cooldownTicks - 1 };
}

/** @param {{ sourceType?: string, cause?: string }} [damage] */
export function tetherDamageBlocked(damage = {}) {
  return damage.sourceType === "thebrokenscript:integrity_phase_2"
    || damage.cause === "flyIntoWall";
}

export function voidTentacleDamageAllowed(cause) {
  return VOID_TENTACLE_SOURCE.allowedDamageCauses.includes(cause);
}

export function voidTentacleScaleFromRoll(roll) {
  const maxRoll = VOID_TENTACLE_SOURCE.scaleMaxInclusive - VOID_TENTACLE_SOURCE.scaleMinInclusive;
  if (!Number.isInteger(roll) || roll < 0 || roll > maxRoll) {
    throw new RangeError(`VoidTentacle scale roll must be in 0..${maxRoll}: ${roll}`);
  }
  return VOID_TENTACLE_SOURCE.scaleMinInclusive + roll;
}

function voidTentacleTargetAllowed(target) {
  if (target?.alive !== true) return false;
  if (target.kind === "player" || target.kind === "integrity_p3_ground_arm") return true;
  return target.kind === "integrity_phase_3" && target.stuck !== true;
}

export function voidTentacleAttackPlan({
  scale = 1,
  candidates = [],
  randomFloat = 0,
  targetAcquired = true,
} = {}) {
  if (!Number.isFinite(scale) || scale <= 0) {
    throw new RangeError(`VoidTentacle scale must be positive: ${scale}`);
  }
  if (!Number.isFinite(randomFloat) || randomFloat < 0 || randomFloat > 1) {
    throw new RangeError(`VoidTentacle randomFloat must be in 0..1: ${randomFloat}`);
  }
  if (targetAcquired === false) {
    return {
      action: "none",
      candidateCount: 0,
      cooldownTicks: 0,
      lookTarget: null,
      meleeTarget: null,
    };
  }

  const searchRadius = VOID_TENTACLE_SOURCE.attackSearchRadiusMultiplier * scale;
  const candidateRadius = VOID_TENTACLE_SOURCE.attackCandidateRadiusMultiplier * scale;
  const meleeRadius = VOID_TENTACLE_SOURCE.meleeRadiusMultiplier * scale;
  const validCandidates = candidates.filter((target) => (
    voidTentacleTargetAllowed(target)
    && Number.isFinite(target.distance)
    && target.distance < searchRadius
    && target.distance < candidateRadius
  ));
  if (validCandidates.length === 0) {
    return {
      action: "none",
      candidateCount: 0,
      cooldownTicks: 0,
      lookTarget: null,
      meleeTarget: null,
    };
  }

  const tooClose = validCandidates.filter((target) => target.distance < meleeRadius);
  const sweep = validCandidates.length > 1
    || (tooClose.length === 0 && randomFloat <= VOID_TENTACLE_SOURCE.sweepChance);
  return {
    action: sweep ? "sweep" : (tooClose.length > 0 ? "melee" : "none"),
    candidateCount: validCandidates.length,
    cooldownTicks: VOID_TENTACLE_SOURCE.attackIntervalTicks,
    lookTarget: validCandidates[0],
    meleeTarget: sweep ? null : (tooClose[0] ?? null),
  };
}

function voidTentacleSweepTargetInRange(target, radius) {
  return target?.alive === true
    && Number.isFinite(target.distance)
    && target.distance < radius;
}

function closestVoidTentacleTarget(targets, radius) {
  return targets
    .filter((target) => voidTentacleSweepTargetInRange(target, radius))
    .reduce((closest, target) => (
      closest === null || target.distance < closest.distance ? target : closest
    ), null);
}

export function voidTentacleSweepPlan({
  scale = 1,
  players = [],
  phase3Targets = [],
  armTargets = [],
} = {}) {
  if (!Number.isFinite(scale) || scale <= 0) {
    throw new RangeError(`VoidTentacle scale must be positive: ${scale}`);
  }
  const radius = VOID_TENTACLE_SOURCE.sweepPlayerRadiusMultiplier * scale;
  const playerTargets = players.filter((target) => (
    target?.onGround === true && voidTentacleSweepTargetInRange(target, radius)
  ));
  const phase3Target = closestVoidTentacleTarget(phase3Targets, radius);
  const armTarget = closestVoidTentacleTarget(armTargets, radius);
  return {
    radius,
    playerTargets,
    stuckTarget: phase3Target ?? armTarget,
    discardDelayTicks: phase3Target
      ? VOID_TENTACLE_SOURCE.sweepStuckDiscardDelayTicks
      : 0,
  };
}
