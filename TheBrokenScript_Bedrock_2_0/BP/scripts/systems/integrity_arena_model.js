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

export const STAGE2_DIMENSION_ID = "thebrokenscript:stage2";

// Stage2Generator.java is a Java custom chunk generator. Bedrock's static
// dimension JSON cannot execute this generator. The runtime therefore uses
// this audit model plus validated .mcstructure assets and a deterministic
// placement adapter; exact Java seed/occupancy semantics remain a boundary.
const STAGE2_FLOOR1_VARIANTS = Object.freeze([
  Object.freeze({ variant: 1, structureId: "clanvoidnew1" }),
  Object.freeze({ variant: 2, structureId: "clanvoidnew2" }),
  Object.freeze({ variant: 3, structureId: "clanvoidnew3" }),
  Object.freeze({ variant: 4, structureId: "clanvoidnew4" }),
  Object.freeze({ variant: 5, structureId: "clanvoidnew5" }),
  Object.freeze({ variant: 6, structureId: "clanvoidnew6" }),
  Object.freeze({ variant: 7, structureId: "clanvoidnew7" }),
]);

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
  floor1Variants: STAGE2_FLOOR1_VARIANTS,
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

// GroundAttack.kt and IntegrityP3GroundArmEntity.kt. The Bedrock controller
// stores the Java owner relationship in a runtime map because Bedrock entity
// ids are opaque strings rather than the source's synchronized integer id.
export const GROUND_ATTACK_SOURCE = Object.freeze({
  attackCooldownTicks: 70,
  distanceRange: Object.freeze([40, 80]),
  chance: 1,
  canMove: false,
  canUse: true,
  normalLengthTicks: 175,
  stuckLengthTicks: 260,
  targetCaptureTick: 33,
  armSpawnTick: 40,
});

export const GROUND_ARM_SOURCE = Object.freeze({
  impactTick: 5,
  impactRadius: 5,
  impactDamage: 15,
  horizontalKnockback: 1.5,
  upwardKnockback: 2.6,
  tentacleSearchRadius: 20,
  discardWithoutTentacleAfterTick: 40,
  discardWithTentacleAfterTick: 180,
  persistent: false,
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

export function stage2GeneratorFloor1Structure(variant) {
  const entry = STAGE2_FLOOR1_VARIANTS.find((candidate) => candidate.variant === variant);
  if (!entry) throw new RangeError(`Stage2 floor 1 variant must be in 1..7: ${variant}`);
  return entry.structureId;
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

/**
 * Maps the runtime spawn bands to the four room layers generated by
 * Stage2Generator.java. The Stage2Floor enum is ordered top-to-bottom, while
 * the Java generator names those layers bottom-to-top (floor1..floor4).
 *
 * The options are intentionally explicit so a caller can reproduce the
 * generator's already-audited variant decisions without hiding random calls
 * inside this pure model.
 */
export function stage2GeneratorTemplateForFloor(floorId, options = {}) {
  switch (floorId) {
    case "FLOOR_1":
      return options.surfaceRare === true ? "fieldbase2" : "fieldbase";
    case "FLOOR_2":
      return stage2GeneratorFloor4Structure(
        options.floor4Special === true,
        options.floor4RareVariant === true,
        options.floor4Variant ?? 1,
      );
    case "FLOOR_3":
      return stage2GeneratorFloor3Structure(
        options.floor3Variant ?? 1,
        options.floor3RandomExtra === true,
      );
    case "FLOOR_4":
      return stage2GeneratorFloor2Structure(
        options.floor2Variant ?? 1,
        options.floor2Special === true,
      );
    case "FLOOR_5":
      return stage2GeneratorFloor1Structure(options.floor1Variant ?? 1);
    case "FLOOR_6":
    case "FLOOR_6_INTEG": {
      const variant = options.tunnelVariant ?? 1;
      if (!Number.isInteger(variant) || variant < 1 || variant > 10) {
        throw new RangeError(`Stage2 tunnel variant must be in 1..10: ${variant}`);
      }
      return `bedrockhallway${variant}`;
    }
    case "FLOOR_7":
    default:
      return null;
  }
}

export function stage2GeneratorPlacementYForFloor(floorId) {
  switch (floorId) {
    case "FLOOR_1": return 252;
    case "FLOOR_2": return 233;
    case "FLOOR_3": return 217;
    case "FLOOR_4": return 207;
    case "FLOOR_5": return 200;
    case "FLOOR_6":
    case "FLOOR_6_INTEG": return 160;
    default: return null;
  }
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

// Bedrock runtime scaffold contract. These air-only support pads preserve the
// Stage2Util spawn scan while the validated template queue is being placed.
// They also provide a retryable floor for templates whose source AIR cells are
// represented as Bedrock -1/no-op indices.
export const STAGE2_RUNTIME_SCAFFOLD_SOURCE = Object.freeze({
  supportLayers: Object.freeze([
    Object.freeze({ floorId: "FLOOR_1", y: 253, blockId: "minecraft:grass_block" }),
    Object.freeze({ floorId: "FLOOR_2", y: 234, blockId: "minecraft:stone" }),
    Object.freeze({ floorId: "FLOOR_3", y: 218, blockId: "minecraft:oak_planks" }),
    Object.freeze({ floorId: "FLOOR_4", y: 208, blockId: "minecraft:cobblestone" }),
    Object.freeze({ floorId: "FLOOR_5", y: 202, blockId: "minecraft:cobblestone" }),
    Object.freeze({ floorId: "FLOOR_6", y: 162, blockId: "minecraft:stone" }),
    Object.freeze({ floorId: "FLOOR_7", y: 103, blockId: "minecraft:bedrock" }),
  ]),
  barrierLayers: STAGE2_GENERATOR_SOURCE.barrierLayers,
  fillOnlyAir: true,
});

export function stage2GeneratorRuntimeVolumes(playerBlock) {
  const { cellChunk } = stage2SpawnCellChunksFromPlayerBlock(playerBlock);
  const origin = {
    x: cellChunk.x * 16,
    z: cellChunk.z * 16,
  };
  const volumes = [
    ...STAGE2_RUNTIME_SCAFFOLD_SOURCE.supportLayers.map((layer) => ({
      kind: "floor",
      floorId: layer.floorId,
      y: layer.y,
      blockId: layer.blockId,
    })),
    ...STAGE2_RUNTIME_SCAFFOLD_SOURCE.barrierLayers.map((y) => ({
      kind: "barrier",
      y,
      blockId: "minecraft:barrier",
    })),
  ];
  return {
    cellKey: `${cellChunk.x}:${cellChunk.z}`,
    origin,
    volumes,
  };
}

const STAGE2_ADDITIONAL_TEMPLATE_ROWS = Object.freeze([
    {"id":"bedrockhallway1","sourceBlobSha":"e56700411058fa096327a1b34395f71b7e67facf","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava"],"blockCount":2750,"nonAirBlockCount":1175,"entityCount":0,"blockEntityCount":0,"placementY":160,"generationRole":"tunnel_default"},
    {"id":"bedrockhallway10","sourceBlobSha":"a3a3c9f854814a67482007916f92d79a9f15e0e2","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_10"},
    {"id":"bedrockhallway2","sourceBlobSha":"f4a2c158eef58058b8a8788fd364731b076f3e52","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_2"},
    {"id":"bedrockhallway3","sourceBlobSha":"b2421e252b0048bd9a67ef72bc59f664dec34039","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_3"},
    {"id":"bedrockhallway4","sourceBlobSha":"003448b554ab85f9de7af6b6da0d5aef16dcb2f8","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_4"},
    {"id":"bedrockhallway5","sourceBlobSha":"c82e0beb4a65611802a6eb26efd361b53c9e79f3","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_5"},
    {"id":"bedrockhallway6","sourceBlobSha":"9827db33b319859c58523adaa83c73cc65640fef","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_6"},
    {"id":"bedrockhallway7","sourceBlobSha":"80dab3d3661e70d062ed8b062cd46b6eccf8be23","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_7"},
    {"id":"bedrockhallway8","sourceBlobSha":"484c3b4ec818f1b655fd41b3b53b4ed884888155","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_8"},
    {"id":"bedrockhallway9","sourceBlobSha":"a3a3c9f854814a67482007916f92d79a9f15e0e2","size":[11,10,25],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:lava","minecraft:oak_sign"],"blockCount":2750,"nonAirBlockCount":1176,"entityCount":0,"blockEntityCount":1,"placementY":160,"generationRole":"tunnel_variant_9"},
    {"id":"clanvoidnew2","sourceBlobSha":"df00ef5ed37b1d2d6071df9f1fc3f34c2a7712b1","size":[16,6,16],"paletteNames":["minecraft:air","minecraft:cobblestone","minecraft:glass","minecraft:oak_door","minecraft:oak_wall_sign","minecraft:wall_torch","thebrokenscript:cobblestone_border_block","thebrokenscript:stone_slab_border_block"],"blockCount":1536,"nonAirBlockCount":772,"entityCount":0,"blockEntityCount":8,"placementY":200,"generationRole":"floor1_variant_2"},
    {"id":"clanvoidnew3","sourceBlobSha":"270b92bb4674824b49854ff77074cebb25cdab1a","size":[16,6,16],"paletteNames":["minecraft:air","minecraft:cobblestone","minecraft:glass","minecraft:smooth_stone_slab","minecraft:wall_torch","thebrokenscript:cobblestone_border_block","thebrokenscript:stone_slab_border_block"],"blockCount":1536,"nonAirBlockCount":812,"entityCount":0,"blockEntityCount":0,"placementY":200,"generationRole":"floor1_variant_3"},
    {"id":"clanvoidnew4","sourceBlobSha":"f8b93694e203dc63717d1e55b26043d6a11f969f","size":[16,6,16],"paletteNames":["minecraft:air","minecraft:chest","minecraft:cobblestone","minecraft:glass","minecraft:wall_torch","thebrokenscript:cobblestone_border_block","thebrokenscript:stone_slab_border_block"],"blockCount":1536,"nonAirBlockCount":780,"entityCount":0,"blockEntityCount":32,"placementY":200,"generationRole":"floor1_variant_4"},
    {"id":"clanvoidnew5","sourceBlobSha":"115b15d2ec2ee9bd1ec4c5c5e03d015a5ce4f546","size":[16,6,16],"paletteNames":["minecraft:air","minecraft:cobblestone","minecraft:crafting_table","minecraft:furnace","minecraft:glass","minecraft:wall_torch","thebrokenscript:cobblestone_border_block","thebrokenscript:stone_slab_border_block"],"blockCount":1536,"nonAirBlockCount":760,"entityCount":0,"blockEntityCount":8,"placementY":200,"generationRole":"floor1_variant_5"},
    {"id":"clanvoidnew6","sourceBlobSha":"d8e1fe6fbc5e4e91af0611ca6a8dec6a2509c213","size":[16,6,16],"paletteNames":["minecraft:air","minecraft:chest","minecraft:cobblestone","minecraft:cobblestone_wall","minecraft:glass","minecraft:jukebox","minecraft:wall_torch","thebrokenscript:cobblestone_border_block","thebrokenscript:stone_slab_border_block"],"blockCount":1536,"nonAirBlockCount":776,"entityCount":0,"blockEntityCount":12,"placementY":200,"generationRole":"floor1_variant_6"},
    {"id":"clanvoidnew7","sourceBlobSha":"3f2e9f531528079abda22a2d061c2e521261c9ea","size":[16,6,16],"paletteNames":["minecraft:air","minecraft:cobblestone","minecraft:crafting_table","minecraft:glass","minecraft:wall_torch","thebrokenscript:cobblestone_border_block","thebrokenscript:stone_slab_border_block"],"blockCount":1536,"nonAirBlockCount":796,"entityCount":0,"blockEntityCount":0,"placementY":200,"generationRole":"floor1_variant_7"},
    {"id":"fieldbase","sourceBlobSha":"c5c561db0aadfe0bcfc518adcc4ce29d413c648f","size":[16,9,16],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:grass","minecraft:grass_block"],"blockCount":2304,"nonAirBlockCount":768,"entityCount":0,"blockEntityCount":0,"placementY":252,"generationRole":"surface_default"},
    {"id":"fieldbase2","sourceBlobSha":"cb5f55cfc7098ac18c3ae58c67e72736b33d6330","size":[16,4,16],"paletteNames":["minecraft:air","minecraft:azure_bluet","minecraft:bedrock","minecraft:cornflower","minecraft:dandelion","minecraft:grass_block","minecraft:oxeye_daisy","minecraft:poppy","minecraft:short_grass"],"blockCount":1024,"nonAirBlockCount":629,"entityCount":0,"blockEntityCount":0,"placementY":252,"generationRole":"surface_rare"},
    {"id":"tek_woodfloor1","sourceBlobSha":"2f7e6f65b7c17f7b709df731c8855f8d15c68d2b","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:bookshelf","minecraft:glass","minecraft:oak_door","minecraft:oak_planks","minecraft:oak_stairs"],"blockCount":3840,"nonAirBlockCount":1832,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_10_extra"},
    {"id":"tek_woodfloor10","sourceBlobSha":"9c16337ea4520da0c9a5c2dd060030cf61fa45fe","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks","minecraft:redstone_torch"],"blockCount":3840,"nonAirBlockCount":625,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_18_extra"},
    {"id":"tek_woodfloor12","sourceBlobSha":"1c2d8e08d529ddc49cd3a1147ffa2a5c70debca6","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":624,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_20_extra"},
    {"id":"tek_woodfloor13","sourceBlobSha":"ba7ad8e439893ee9680f27fae652d876a53b3353","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_fence","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":922,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_21_extra"},
    {"id":"tek_woodfloor14","sourceBlobSha":"13c191c701ac42015a1a01719c2d666d2c91653b","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_fence","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":698,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_22_extra"},
    {"id":"tek_woodfloor15","sourceBlobSha":"282d634ae4f3d7d28ace7d34be49f9d8bef73b51","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_fence","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":698,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_23_extra"},
    {"id":"tek_woodfloor16","sourceBlobSha":"a2378805e1a2c20de957183a65ac0f1c3f31b4bb","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_fence","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":698,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_24_extra"},
    {"id":"tek_woodfloor17","sourceBlobSha":"ef132ea33b05db543bf87c94a2fb43af7ae1081c","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:dirt","minecraft:ladder","minecraft:oak_planks","thebrokenscript:limbo"],"blockCount":3840,"nonAirBlockCount":956,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_25_extra"},
    {"id":"tek_woodfloor18","sourceBlobSha":"bac42312adb55fa15d176f87763ad7245ba71893","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:chest","minecraft:oak_planks","minecraft:oak_stairs","minecraft:redstone_wall_torch"],"blockCount":3840,"nonAirBlockCount":1101,"entityCount":0,"blockEntityCount":1,"placementY":217,"generationRole":"floor3_variant_26_extra"},
    {"id":"tek_woodfloor2","sourceBlobSha":"3c1ec5797fcdfb97824a45e4c4df5222487f3a08","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":960,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_11_extra"},
    {"id":"tek_woodfloor20","sourceBlobSha":"73944fa55f81408266eace6aeec6d056e33b3a0b","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:lectern","minecraft:oak_planks","minecraft:oak_stairs","minecraft:redstone_wall_torch"],"blockCount":3840,"nonAirBlockCount":1090,"entityCount":0,"blockEntityCount":1,"placementY":217,"generationRole":"floor3_variant_27_extra"},
    {"id":"tek_woodfloor21","sourceBlobSha":"913d0f068d7986e72723f2ab86cc5e3aa11e2484","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks","minecraft:redstone_torch","minecraft:redstone_wall_torch"],"blockCount":3840,"nonAirBlockCount":684,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_28_extra"},
    {"id":"tek_woodfloor22","sourceBlobSha":"be71828a93ed8b6d3fdf3e4ab25a4d95a5850b1d","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks","minecraft:redstone_torch","minecraft:redstone_wall_torch"],"blockCount":3840,"nonAirBlockCount":683,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_29_extra"},
    {"id":"tek_woodfloor23","sourceBlobSha":"4655d4de9ea88e1e2c8b93be5e7247829a4cd5f9","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks","minecraft:redstone_torch","minecraft:redstone_wall_torch"],"blockCount":3840,"nonAirBlockCount":689,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_30_extra"},
    {"id":"tek_woodfloor24","sourceBlobSha":"6e5837391181d39024040a3738f3bc3365f45c31","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_fence","minecraft:oak_planks","minecraft:oak_stairs","minecraft:potted_dead_bush","minecraft:redstone_wall_torch"],"blockCount":3840,"nonAirBlockCount":1413,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_31_extra"},
    {"id":"tek_woodfloor25","sourceBlobSha":"9743e41ee5aafbba52a60903816b552d14aacfe1","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:chest","minecraft:crafting_table","minecraft:furnace","minecraft:oak_planks","minecraft:oak_stairs","thebrokenscript:null"],"blockCount":3840,"nonAirBlockCount":694,"entityCount":0,"blockEntityCount":3,"placementY":217,"generationRole":"floor3_variant_32_extra"},
    {"id":"tek_woodfloor26","sourceBlobSha":"05e00d871583f2514c55ee035bc737bc0017f502","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:chest","minecraft:crafting_table","minecraft:furnace","minecraft:oak_planks","minecraft:oak_stairs","thebrokenscript:null"],"blockCount":3840,"nonAirBlockCount":694,"entityCount":0,"blockEntityCount":3,"placementY":217,"generationRole":"floor3_variant_33_extra"},
    {"id":"tek_woodfloor27","sourceBlobSha":"ffb7ed1c9b8244761af76893f911c1c1579e6902","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks","minecraft:oak_stairs","minecraft:oak_wall_sign"],"blockCount":3840,"nonAirBlockCount":859,"entityCount":0,"blockEntityCount":52,"placementY":217,"generationRole":"floor3_variant_34_extra"},
    {"id":"tek_woodfloor28","sourceBlobSha":"03e83002f3d3b51bad0f5fabf363fcde71760c5c","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bedrock","minecraft:bookshelf","minecraft:chest","minecraft:dirt","minecraft:glass","minecraft:oak_door","minecraft:oak_planks","minecraft:oak_wall_sign","minecraft:potted_dead_bush","thebrokenscript:exit","thebrokenscript:null","thebrokenscript:ud_oak_door"],"blockCount":3840,"nonAirBlockCount":1943,"entityCount":0,"blockEntityCount":57,"placementY":217,"generationRole":"floor3_variant_35_extra"},
    {"id":"tek_woodfloor3","sourceBlobSha":"c603eac65fe207f3e9b7c40a7e99cd66aa560ac8","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:dirt","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":635,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_12_extra"},
    {"id":"tek_woodfloor4","sourceBlobSha":"af65f6aead0d6a42b53e6a5944385afdc389c8af","size":[16,16,16],"paletteNames":["minecraft:air","minecraft:oak_planks","minecraft:oak_stairs","minecraft:stone"],"blockCount":4096,"nonAirBlockCount":3416,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_13_extra"},
    {"id":"tek_woodfloor6","sourceBlobSha":"aa69f906304c06a5db25b7596eeae9c9dd4c5bc7","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:chest","minecraft:oak_planks","minecraft:oak_slab","minecraft:oak_wall_sign"],"blockCount":3840,"nonAirBlockCount":1139,"entityCount":0,"blockEntityCount":7,"placementY":217,"generationRole":"floor3_variant_14_extra"},
    {"id":"tek_woodfloor7","sourceBlobSha":"160620307f732cb014510192fb5c9d64cae45361","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":707,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_15_extra"},
    {"id":"tek_woodfloor8","sourceBlobSha":"55b1362a5c10a79479f2bd65ea9859302eecc69e","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:ladder","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":960,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_16_extra"},
    {"id":"tek_woodfloor9","sourceBlobSha":"2ecbcb1505ef3b933fde01d3ced7a8c15e001472","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:dirt","minecraft:glass","minecraft:oak_door","minecraft:oak_planks","minecraft:potted_dead_bush"],"blockCount":3840,"nonAirBlockCount":2078,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_17_extra"},
    {"id":"woodfloor1","sourceBlobSha":"bc88673a46dc5ad71b46e0725cd6485bf92bd783","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:glass","minecraft:oak_door","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":1823,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_1_ordinary"},
    {"id":"woodfloor2","sourceBlobSha":"238596fe717d2c323da6d6f20de0f736e65d00a1","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:glass","minecraft:oak_door","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":1565,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_2_ordinary"},
    {"id":"woodfloor3","sourceBlobSha":"a92ba2e4e6cc988da1d8defed2e7136b4842946a","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":512,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_3_ordinary"},
    {"id":"woodfloor4","sourceBlobSha":"a4263b986ed5408d23618502b3d86c18e99d19c1","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":768,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_8_9_ordinary"},
    {"id":"woodfloor5","sourceBlobSha":"516371e2098f90751b1b72d0f268df4ceb7cb754","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_door","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":1529,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_5_ordinary"},
    {"id":"woodfloor6","sourceBlobSha":"b68641398b06799aac02f7e23702db982f0dd431","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":938,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_37_ordinary"},
    {"id":"woodfloor7","sourceBlobSha":"d31b295072b0c02c42748257bdc61d34a777f439","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:bookshelf","minecraft:oak_planks"],"blockCount":3840,"nonAirBlockCount":992,"entityCount":0,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_7_ordinary"},
    {"id":"woodfloor8","sourceBlobSha":"fae9605f22b3c0ff1119873240095e621a59b1a2","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:dirt","minecraft:grass_block","minecraft:oak_fence","minecraft:oak_fence_gate","minecraft:oak_planks","minecraft:poppy","minecraft:redstone_torch","minecraft:short_grass","minecraft:tall_grass"],"blockCount":3840,"nonAirBlockCount":580,"entityCount":1,"blockEntityCount":0,"placementY":217,"generationRole":"floor3_variant_8_extra"},
    {"id":"woodfloor9","sourceBlobSha":"8d41ef46ec24b3d463f14ec77af95d50a02d7ff0","size":[16,15,16],"paletteNames":["minecraft:air","minecraft:dispenser","minecraft:lever","minecraft:oak_planks","minecraft:obsidian","minecraft:piston_head","minecraft:redstone_wire","minecraft:repeater","minecraft:sticky_piston","minecraft:water","minecraft:white_wool"],"blockCount":3840,"nonAirBlockCount":1002,"entityCount":0,"blockEntityCount":10,"placementY":217,"generationRole":"floor3_variant_9_extra"},
]);

function createAdditionalStage2TemplateEntry(row) {
  return Object.freeze({
    sourcePath: `source_extracted/data/thebrokenscript/structure/${row.id}.nbt`,
    sourceBlobSha: row.sourceBlobSha,
    size: Object.freeze([...row.size]),
    paletteNames: Object.freeze([...row.paletteNames]),
    blockCount: row.blockCount,
    nonAirBlockCount: row.nonAirBlockCount,
    entityCount: row.entityCount,
    blockEntityCount: row.blockEntityCount,
    placementY: row.placementY,
    generationRole: row.generationRole,
    status: "validated_asset",
  });
}

// Stage2Generator.java template catalog. All 64 audited source templates
// have deterministic Bedrock .mcstructure assets. The catalog retains the
// source palette names for parity inspection while the converter adapts Java
// block states and block-entity payloads to Bedrock's structure format.
export const STAGE2_TEMPLATE_SOURCE = Object.freeze({
  namespace: "thebrokenscript",
  assetPath: "stage2",
  supportedTemplates: Object.freeze({
    clanvoidnew1: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/clanvoidnew1.nbt",
      sourceBlobSha: "a92773a3f9da467f1849d6d34b0e6292e47bcf62",
      size: Object.freeze([16, 6, 16]),
      paletteNames: Object.freeze([
        "minecraft:air",
        "minecraft:cobblestone",
        "minecraft:glass",
        "minecraft:wall_torch",
        "thebrokenscript:cobblestone_border_block",
        "thebrokenscript:stone_slab_border_block",
      ]),
      blockCount: 1536,
      nonAirBlockCount: 748,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 200,
      generationRole: "floor1_variant_1",
      status: "validated_asset",
    }),
    stone1: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone1.nbt",
      sourceBlobSha: "2d8e2d3da26e07f4921764f9f6937cc46f359060",
      size: Object.freeze([16, 1, 16]),
      paletteNames: Object.freeze(["minecraft:stone"]),
      blockCount: 256,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_default",
      status: "validated_asset",
    }),
    stone2: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone2.nbt",
      sourceBlobSha: "a61aabc79ec6bd18a3bdb325367d65055a108e9d",
      size: Object.freeze([16, 9, 16]),
      paletteNames: Object.freeze([
        "minecraft:air",
        "minecraft:stone",
        "thebrokenscript:block_is_missing_id",
      ]),
      blockCount: 2304,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_1",
      status: "validated_asset",
    }),
    stone3: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone3.nbt",
      sourceBlobSha: "45381d498f95f558e296b8aae40bb9183f13032e",
      size: Object.freeze([16, 4, 16]),
      paletteNames: Object.freeze(["minecraft:air", "minecraft:oak_door", "minecraft:stone"]),
      paletteStateCount: 14,
      blockCount: 1024,
      nonAirBlockCount: 300,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_2",
      status: "validated_asset",
    }),
    stone4: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone4.nbt",
      sourceBlobSha: "d43f4146ebe57edb8dbfb3a2b25d8b616fb39137",
      size: Object.freeze([16, 3, 16]),
      paletteNames: Object.freeze(["minecraft:air", "minecraft:rail", "minecraft:stone"]),
      paletteStateCount: 8,
      blockCount: 768,
      nonAirBlockCount: 295,
      entityCount: 1,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_3",
      status: "validated_asset",
    }),
    stone5: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone5.nbt",
      sourceBlobSha: "e770282817af7b4fbb94d76151c925bbbf351b94",
      size: Object.freeze([16, 3, 16]),
      paletteNames: Object.freeze([
        "minecraft:air",
        "minecraft:stone",
        "thebrokenscript:block_is_missing_id",
      ]),
      blockCount: 768,
      nonAirBlockCount: 512,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_4",
      status: "validated_asset",
    }),
    stone6: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone6.nbt",
      sourceBlobSha: "1b15f9ac3f6b35506b25361694b87c7ca8dd6231",
      size: Object.freeze([16, 4, 16]),
      paletteNames: Object.freeze(["minecraft:air", "minecraft:stone"]),
      blockCount: 1024,
      nonAirBlockCount: 256,
      entityCount: 15,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_5",
      status: "validated_asset",
    }),
    stone7: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone7.nbt",
      sourceBlobSha: "2446bc420007c6daa7e78a1cf6edcecac2ffbdc8",
      size: Object.freeze([16, 3, 16]),
      paletteNames: Object.freeze([
        "minecraft:air",
        "minecraft:smooth_stone",
        "minecraft:stone",
      ]),
      blockCount: 768,
      nonAirBlockCount: 288,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_6",
      status: "validated_asset",
    }),
    clandimensionroom1: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom1.nbt",
      sourceBlobSha: "4f30ee7f5f37cfff08ee6e4728fe27e5f62becc2",
      size: Object.freeze([16, 9, 16]),
      paletteNames: Object.freeze(["minecraft:air", "minecraft:cobblestone"]),
      blockCount: 2304,
      nonAirBlockCount: 750,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 207,
      generationRole: "floor2_variant_1",
      status: "validated_asset",
    }),
    clandimensionroom2: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom2.nbt",
      sourceBlobSha: "d555dff8e0c3d45d9509e9b281323d1042e54063",
      size: Object.freeze([16, 9, 16]),
      paletteNames: Object.freeze(["minecraft:air", "minecraft:cobblestone"]),
      blockCount: 2304,
      nonAirBlockCount: 799,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 207,
      generationRole: "floor2_variant_2",
      status: "validated_asset",
    }),
    clandimensionroom3: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom3.nbt",
      sourceBlobSha: "37d9f55b6fc9ac6c6f41979380e398cfdbf56ead",
      size: Object.freeze([16, 9, 16]),
      paletteNames: Object.freeze(["minecraft:air", "minecraft:cobblestone"]),
      blockCount: 2304,
      nonAirBlockCount: 855,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 207,
      generationRole: "floor2_variant_3_4",
      status: "validated_asset",
    }),
    clandimensionroom5: Object.freeze({
      sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom5.nbt",
      sourceBlobSha: "8757e559d147f81f9dae6f8301d59af47027ca23",
      size: Object.freeze([16, 9, 16]),
      paletteNames: Object.freeze(["minecraft:air", "minecraft:cobblestone"]),
      blockCount: 2304,
      nonAirBlockCount: 792,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 207,
      generationRole: "floor2_variant_5_ordinary",
      status: "validated_asset",
    }),
    ...Object.fromEntries(STAGE2_ADDITIONAL_TEMPLATE_ROWS.map((row) => [
      row.id,
      createAdditionalStage2TemplateEntry(row),
    ])),
  }),
  deferredTemplateCount: 0,
});

function normalizeStage2TemplateRotation(rotation) {
  const normalized = Number(rotation ?? 0);
  if (![0, 90, 180, 270].includes(normalized)) {
    throw new RangeError("Stage 2 template rotation must be 0, 90, 180, or 270 degrees");
  }
  return normalized;
}

function normalizeStage2TemplateMirror(mirror) {
  const normalized = String(mirror ?? "none");
  if (!["none", "front_back"].includes(normalized)) {
    throw new RangeError("Stage 2 template mirror must be none or front_back");
  }
  return normalized;
}

export function stage2TemplatePlacementPlan(templateId, origin, options = {}) {
  const template = STAGE2_TEMPLATE_SOURCE.supportedTemplates[templateId];
  if (!template) return null;
  const rotation = normalizeStage2TemplateRotation(options.rotation);
  const mirror = normalizeStage2TemplateMirror(options.mirror);
  return {
    templateId,
    sourcePath: template.sourcePath,
    sourceBlobSha: template.sourceBlobSha,
    assetId: `${STAGE2_TEMPLATE_SOURCE.namespace}:${STAGE2_TEMPLATE_SOURCE.assetPath}/${templateId}`,
    origin: { x: origin.x, y: origin.y, z: origin.z },
    size: [...template.size],
    placementY: template.placementY,
    rotation,
    mirror,
    includeEntities: template.entityCount > 0,
    includeBlocks: true,
    status: template.status,
  };
}

export function stage2TemplatePlacementPlanForFloor(templateId, floorId, origin, options = {}) {
  const placementY = stage2GeneratorPlacementYForFloor(floorId);
  if (placementY === null) return null;
  return stage2TemplatePlacementPlan(
    templateId,
    { x: origin.x, y: placementY, z: origin.z },
    options,
  );
}

export function stage2TemplateLoadCommand(plan) {
  if (!plan || plan.status !== "validated_asset") return null;
  if (!Number.isFinite(plan.origin?.x) || !Number.isFinite(plan.origin?.y) || !Number.isFinite(plan.origin?.z)) {
    return null;
  }
  const mirror = plan.mirror === "front_back" ? "z" : "none";
  return [
    "structure",
    "load",
    plan.assetId,
    plan.origin.x,
    plan.origin.y,
    plan.origin.z,
    `${plan.rotation}_degrees`,
    mirror,
    String(plan.includeEntities),
    String(plan.includeBlocks),
  ].join(" ");
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

export function phase2Stage2FloorStep({
  phase = INTEGRITY_PHASE.PHASE_2,
  spawnedFloorIds = [],
  integrityPresent = false,
  players = [],
} = {}) {
  const spawned = new Set(spawnedFloorIds);
  const floorsToSpawn = [];
  if (phase !== INTEGRITY_PHASE.PHASE_2) {
    return {
      floorsToSpawn,
      nextSpawnedFloorIds: [...spawned],
    };
  }

  for (const player of players) {
    if (!player || player.id === undefined || player.dimensionId !== STAGE2_DIMENSION_ID) continue;
    if (player.loadingPhase2 === true || !Number.isFinite(player.y)) continue;

    const floor = stage2SpawnFloorFromY(player.y);
    if (!floor) continue;
    if (floor.id === "FLOOR_7" && integrityPresent !== true) continue;
    if (spawned.has(floor.id)) continue;

    spawned.add(floor.id);
    floorsToSpawn.push({
      floorId: floor.id,
      playerId: player.id,
      floor,
    });
  }

  return {
    floorsToSpawn,
    nextSpawnedFloorIds: [...spawned],
  };
}

function phase2IntegrityPlacementResult(action, targetFloor, requiresTether = false) {
  return {
    action,
    targetFloorId: targetFloor?.id ?? null,
    stage2FloorId: targetFloor?.stage2Floor ?? null,
    requiresTether,
  };
}

/**
 * @param {{
 *   playerY?: number;
 *   integrityPresent?: boolean;
 *   currentFloorId?: string | null;
 *   hasTetherOnTargetFloor?: boolean;
 * }} [options]
 */
export function phase2IntegrityPlacementStep({
  playerY,
  integrityPresent = false,
  currentFloorId = null,
  hasTetherOnTargetFloor = false,
} = {}) {
  if (integrityPresent !== true || !Number.isFinite(playerY)) {
    return phase2IntegrityPlacementResult("none", null);
  }

  const targetFloor = phase2IntegrityFloorFromY(playerY);
  if (!targetFloor) return phase2IntegrityPlacementResult("none", null);

  const stage2Floor = STAGE2_FLOORS.find((floor) => floor.id === targetFloor.stage2Floor);
  const requiresTether = stage2Floor?.sourceSpawns.includes("TETHER") === true;
  if (currentFloorId === targetFloor.id) {
    return phase2IntegrityPlacementResult("already_placed", targetFloor, requiresTether);
  }
  if (requiresTether && hasTetherOnTargetFloor !== true) {
    return phase2IntegrityPlacementResult("wait_for_tether", targetFloor, true);
  }
  return phase2IntegrityPlacementResult("place", targetFloor, requiresTether);
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

export function phase2LowestPlayer(players = []) {
  let lowest = null;
  for (const player of players) {
    if (player?.id === undefined || !Number.isFinite(player.y)) continue;
    if (!phase2EligibleForLowestPlayer(player.y)) continue;
    if (lowest === null || player.y < lowest.y) lowest = player;
  }
  return lowest;
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

/**
 * @param {{
 *   distance?: number;
 *   previousAttack?: string | null;
 * }} [options]
 */
export function groundAttackCanUse({ distance, previousAttack = null } = {}) {
  const [minDistance, maxDistance] = GROUND_ATTACK_SOURCE.distanceRange;
  return previousAttack !== "GROUND_ATTACK"
    && Number.isFinite(distance)
    && distance >= minDistance
    && distance <= maxDistance;
}

export function groundAttackStep({
  timer = 0,
  targetBlockPosition = null,
  targetBlock = null,
  hasTarget = false,
  stuck = false,
} = {}) {
  const nextTimer = timer + 1;
  const capturedTarget = nextTimer === GROUND_ATTACK_SOURCE.targetCaptureTick
    && hasTarget
    && targetBlock !== null;
  const nextTargetBlockPosition = capturedTarget
    ? targetBlock
    : targetBlockPosition;
  return {
    timer: nextTimer,
    targetBlockPosition: nextTargetBlockPosition,
    capturedTarget,
    spawnArm: nextTimer === GROUND_ATTACK_SOURCE.armSpawnTick
      && nextTargetBlockPosition !== null,
    lookAtTarget: nextTargetBlockPosition,
    lengthTicks: stuck
      ? GROUND_ATTACK_SOURCE.stuckLengthTicks
      : GROUND_ATTACK_SOURCE.normalLengthTicks,
  };
}

export function groundArmImpactPlan({ intersectingPlayers = [] } = {}) {
  return intersectingPlayers.map((player) => {
    const horizontalDistance = Math.max(
      Math.hypot(player.dx ?? 0, player.dz ?? 0),
      0.001,
    );
    return {
      id: player.id,
      damage: GROUND_ARM_SOURCE.impactDamage,
      knockback: {
        x: (player.dx ?? 0) / horizontalDistance * GROUND_ARM_SOURCE.horizontalKnockback,
        y: GROUND_ARM_SOURCE.upwardKnockback,
        z: (player.dz ?? 0) / horizontalDistance * GROUND_ARM_SOURCE.horizontalKnockback,
      },
    };
  });
}

export function groundArmLifecycleStep({
  timer = 0,
  ownerPresent = true,
  hasTentacleNearby = false,
} = {}) {
  const nextTimer = timer + 1;
  return {
    timer: nextTimer,
    impact: ownerPresent && nextTimer === GROUND_ARM_SOURCE.impactTick,
    discard: !ownerPresent
      || (nextTimer > GROUND_ARM_SOURCE.discardWithoutTentacleAfterTick && !hasTentacleNearby)
      || (nextTimer > GROUND_ARM_SOURCE.discardWithTentacleAfterTick && hasTentacleNearby),
  };
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
