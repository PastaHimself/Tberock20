import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

import {
  ARENA_SOURCE,
  INTEGRITY_PHASE,
  PHASE1_SOURCE,
  PHASE2_SOURCE,
  PHASE3_SOURCE,
  STAGE2_GENERATOR_SOURCE,
  STAGE2_UTIL_SOURCE,
  STAGE2_FLOORS,
  arenaCheckLivingPlayers,
  nextIntegrityPhase,
  phase1Ended,
  phase1HasLivingChords,
  phase2EligibleForLowestPlayer,
  phase2Ended,
  phase2IntegrityFloorFromY,
  phase2NeedsRecoveryTeleport,
  phase3BoundaryKillEligible,
  phase3Ended,
  phase3TentacleCandidateCount,
  stage2GeneratorBarrierApplies,
  stage2GeneratorDecorationPlan,
  stage2GeneratorFloor2Structure,
  stage2GeneratorFloor3Structure,
  stage2GeneratorFloor4Structure,
  stage2GeneratorRegion,
  stage2CenterOfExistingGeneration,
  stage2FindSafeSpawnY,
  stage2IsSpecialSpawnBand,
  stage2IsValidFloor,
  stage2SpawnAttemptCoordinates,
  stage2SpawnCellChunksFromPlayerBlock,
  stage2SpawnFloorFromY,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

const repoRoot = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");

test("Arena phase order and participant radius match Java source", () => {
  assert.equal(ARENA_SOURCE.participantRadius, 150);
  assert.equal(nextIntegrityPhase(INTEGRITY_PHASE.PHASE_1), INTEGRITY_PHASE.PHASE_2);
  assert.equal(nextIntegrityPhase(INTEGRITY_PHASE.PHASE_2), INTEGRITY_PHASE.PHASE_3);
  assert.equal(nextIntegrityPhase(INTEGRITY_PHASE.PHASE_3), null);
});

test("Arena.checkLivingPlayers preserves the source's <=2-player behavior", () => {
  assert.equal(arenaCheckLivingPlayers([]), false);
  assert.equal(arenaCheckLivingPlayers([{ connected: true, alive: false }]), true);
  assert.equal(arenaCheckLivingPlayers([
    { connected: true, alive: false },
    { connected: true, alive: false },
  ]), true);
  assert.equal(arenaCheckLivingPlayers([
    { connected: true, alive: false },
    { connected: true, alive: false },
    { connected: true, alive: false },
  ]), false);
  assert.equal(arenaCheckLivingPlayers([
    { connected: true, alive: false },
    { connected: true, alive: true },
    { connected: true, alive: false },
  ]), true);
  assert.equal(arenaCheckLivingPlayers([
    { connected: false, alive: true },
  ]), false);
});

test("Phase 1 delays, corruption cadence, and Chord end predicate match source", () => {
  assert.deepEqual(PHASE1_SOURCE, {
    introDelayTicks: 1080,
    terrainCorruptionRadius: 100,
    terrainCorruptionDelayTicks: 20,
    chordMaxCount: 10,
    chordRadius: 10,
  });
  assert.equal(phase1HasLivingChords([]), true);
  assert.equal(phase1Ended([]), false);
  assert.equal(phase1HasLivingChords([{ alive: false }]), false);
  assert.equal(phase1Ended([{ alive: false }]), true);
  assert.equal(phase1Ended([{ alive: false }, { alive: true }]), false);
});

test("Stage 2 floor bands and spawn bounds match Stage2Floor source", () => {
  assert.deepEqual(
    STAGE2_FLOORS.map(({ id, yMin, yMax, spawnY, boundsMinDistance }) => ({
      id, yMin, yMax, spawnY, boundsMinDistance,
    })),
    [
      { id: "FLOOR_1", yMin: 249, yMax: 300, spawnY: 254, boundsMinDistance: 48 },
      { id: "FLOOR_2", yMin: 230, yMax: 248, spawnY: 235, boundsMinDistance: 32 },
      { id: "FLOOR_3", yMin: 214, yMax: 229, spawnY: 219, boundsMinDistance: 16 },
      { id: "FLOOR_4", yMin: 206, yMax: 213, spawnY: 209, boundsMinDistance: 32 },
      { id: "FLOOR_5", yMin: 200, yMax: 205, spawnY: 203, boundsMinDistance: 32 },
      { id: "FLOOR_6", yMin: 160, yMax: 199, spawnY: 163, boundsMinDistance: 8 },
      { id: "FLOOR_6_INTEG", yMin: 160, yMax: 180, spawnY: 163, boundsMinDistance: 32 },
      { id: "FLOOR_7", yMin: -2147483648, yMax: 159, spawnY: 104, boundsMinDistance: 28 },
    ],
  );
  assert.equal(stage2SpawnFloorFromY(300)?.id, "FLOOR_1");
  assert.equal(stage2SpawnFloorFromY(199)?.id, "FLOOR_6");
  assert.equal(stage2SpawnFloorFromY(170)?.id, "FLOOR_6");
  assert.equal(stage2SpawnFloorFromY(159)?.id, "FLOOR_7");
});

test("Phase2Floors mapping remains distinct from Stage2Floor spawn lookup", () => {
  assert.equal(PHASE2_SOURCE.transferDelayTicks, 20);
  assert.deepEqual(PHASE2_SOURCE.recoveryTeleport, { x: 85.5, y: 162.5, z: 87.5 });
  assert.equal(phase2NeedsRecoveryTeleport(190), true);
  assert.equal(phase2NeedsRecoveryTeleport(198), true);
  assert.equal(phase2NeedsRecoveryTeleport(199), false);
  assert.equal(phase2IntegrityFloorFromY(170)?.id, "Floor6");
  assert.equal(phase2IntegrityFloorFromY(190), null, "Phase2Floors intentionally uses FLOOR_6_INTEG");
  assert.equal(phase2EligibleForLowestPlayer(103), false);
  assert.equal(phase2EligibleForLowestPlayer(104), true);
  assert.equal(phase2Ended(), false);
});

test("Stage 2 generator preserves source-only placement and template selection rules", () => {
  assert.equal(STAGE2_GENERATOR_SOURCE.runtimeStatus, "blocked_custom_chunk_generator");
  assert.equal(STAGE2_GENERATOR_SOURCE.namespace, "thebrokenscript");
  assert.equal(STAGE2_GENERATOR_SOURCE.roomMinBlock, 16);
  assert.equal(STAGE2_GENERATOR_SOURCE.roomMaxBlock, 160);
  assert.ok(STAGE2_GENERATOR_SOURCE.floor2Variants.every((entry) => (
    "structureId" in entry
    && "specialStructureId" in entry
    && "ordinaryStructureId" in entry
  )));
  assert.ok(STAGE2_GENERATOR_SOURCE.floor3Variants.every((entry) => "extraStructureId" in entry));
  assert.deepEqual(STAGE2_GENERATOR_SOURCE.roomPlacements, [
    {
      y: 200,
      variant: "floor1",
      structureIds: ["clanvoidnew1", "clanvoidnew2", "clanvoidnew3", "clanvoidnew4", "clanvoidnew5", "clanvoidnew6", "clanvoidnew7"],
    },
    {
      y: 207,
      variant: "floor2",
      structureIds: ["clandimensionroom1", "clandimensionroom2", "clandimensionroom3", "clandimensionroom5"],
    },
    {
      y: 217,
      variant: "floor3",
      structureIds: [
        "woodfloor1", "woodfloor2", "woodfloor3", "woodfloor4", "woodfloor5", "woodfloor6",
        "woodfloor7", "woodfloor8", "woodfloor9", "tek_woodfloor1", "tek_woodfloor2",
        "tek_woodfloor3", "tek_woodfloor4", "tek_woodfloor6", "tek_woodfloor7",
        "tek_woodfloor8", "tek_woodfloor9", "tek_woodfloor10", "tek_woodfloor12",
        "tek_woodfloor13", "tek_woodfloor14", "tek_woodfloor15", "tek_woodfloor16",
        "tek_woodfloor17", "tek_woodfloor18", "tek_woodfloor20", "tek_woodfloor21",
        "tek_woodfloor22", "tek_woodfloor23", "tek_woodfloor24", "tek_woodfloor25",
        "tek_woodfloor26", "tek_woodfloor27", "tek_woodfloor28",
      ],
    },
    {
      y: 233,
      variant: "floor4",
      structureIds: ["stone1", "stone2", "stone3", "stone4", "stone5", "stone6", "stone7"],
    },
  ]);
  assert.deepEqual(STAGE2_GENERATOR_SOURCE.surfacePlacement, {
    y: 252,
    structureIds: ["fieldbase", "fieldbase2"],
    primaryProbability: 0.99,
  });
  assert.deepEqual(STAGE2_GENERATOR_SOURCE.floorLayers, [
    { y: 199, sourceBlock: "TBSBlocks.COBBLESTONE_BORDER_BLOCK", belowBlock: "minecraft:barrier" },
    { y: 160, sourceBlock: "minecraft:bedrock", belowBlock: "minecraft:barrier" },
  ]);
  assert.deepEqual(STAGE2_GENERATOR_SOURCE.barrierLayers, [251, 232, 216, 206, 102, 271]);
  assert.deepEqual(STAGE2_GENERATOR_SOURCE.nowhere, {
    y: 100,
    randomOffset: 341873128712,
    divider: 1,
  });
  assert.deepEqual(STAGE2_GENERATOR_SOURCE.tunnel, {
    x: 80,
    y: 160,
    excludedZ: [0, 160],
    structureIds: [
      "bedrockhallway1", "bedrockhallway2", "bedrockhallway3", "bedrockhallway4", "bedrockhallway5",
      "bedrockhallway6", "bedrockhallway7", "bedrockhallway8", "bedrockhallway9", "bedrockhallway10",
    ],
    primaryProbability: 0.9,
  });

  assert.equal(stage2GeneratorFloor2Structure(1, false), "clandimensionroom1");
  assert.equal(stage2GeneratorFloor2Structure(4, true), "clandimensionroom3");
  assert.equal(stage2GeneratorFloor2Structure(5, true), "clandimensionroom2");
  assert.equal(stage2GeneratorFloor2Structure(5, false), "clandimensionroom5");
  assert.equal(stage2GeneratorFloor3Structure(8, false), "woodfloor4");
  assert.equal(stage2GeneratorFloor3Structure(8, true), "woodfloor8");
  assert.equal(stage2GeneratorFloor3Structure(18, true), "tek_woodfloor10");
  assert.equal(stage2GeneratorFloor3Structure(37, true), "woodfloor6");
  assert.equal(stage2GeneratorFloor4Structure(false, false, 3), "stone1");
  assert.equal(stage2GeneratorFloor4Structure(true, true, 3), "stone4");
});

test("Stage 2 generator region gates and fixed layer plan mirror Java predicates", () => {
  assert.equal(stage2GeneratorRegion(16, 16), "interior");
  assert.equal(stage2GeneratorRegion(0, 16), "border");
  assert.equal(stage2GeneratorRegion(160, 144), "border");
  assert.equal(stage2GeneratorRegion(161, 16), null);
  assert.equal(stage2GeneratorRegion(-16, 16), null);
  assert.equal(stage2GeneratorBarrierApplies(161, 161), true);
  assert.equal(stage2GeneratorBarrierApplies(162, 161), false);
  assert.equal(stage2GeneratorBarrierApplies(161, 162), false);

  assert.equal(stage2GeneratorDecorationPlan(16, 16).region, "interior");
  assert.equal(stage2GeneratorDecorationPlan(16, 16).outerBarrierY, 271);
  assert.equal(stage2GeneratorDecorationPlan(0, 16).region, "border");
  assert.equal(stage2GeneratorDecorationPlan(16, 0).surface, null);
  assert.deepEqual(stage2GeneratorDecorationPlan(80, 16).tunnel, {
    y: 160,
    structureIds: STAGE2_GENERATOR_SOURCE.tunnel.structureIds,
    primaryProbability: 0.9,
  });
  assert.equal(stage2GeneratorDecorationPlan(80, 160).tunnel, null);
  assert.equal(stage2GeneratorDecorationPlan(162, 16), null);
});

test("Stage 2 generator audit records every source template and its NBT shape", async () => {
  const audit = JSON.parse(await readFile(
    path.join(repoRoot, "TheBrokenScript_Bedrock_2_0/STAGE2_GENERATOR_AUDIT.json"),
    "utf8",
  ));
  assert.equal(audit.templateCount, 64);
  assert.equal(audit.allSourceTemplatesPresent, true);
  assert.equal(audit.runtimeStatus, "blocked_custom_chunk_generator");
  assert.deepEqual(audit.dimensionShapes, [
    [11, 10, 25],
    [16, 1, 16],
    [16, 3, 16],
    [16, 4, 16],
    [16, 6, 16],
    [16, 9, 16],
    [16, 15, 16],
    [16, 16, 16],
  ]);
  assert.deepEqual(audit.templatesWithEntities, ["stone4", "stone6", "woodfloor8"]);
  assert.ok(audit.templates.every((template) => (
    template.sourcePath.endsWith(`.nbt`)
    && template.paletteSize > 0
    && template.blockCount > 0
    && template.connectorCount === 0
    && template.hasLoot === false
    && template.hasDataMarker === false
  )));
});

test("Stage2Util uses 10x10 chunk cells and the exact generation center", () => {
  assert.deepEqual(STAGE2_UTIL_SOURCE, {
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
  assert.deepEqual(stage2CenterOfExistingGeneration({ x: 0, z: 0 }), { x: 88, y: 253, z: 88 });
  assert.deepEqual(stage2CenterOfExistingGeneration({ x: 159, z: 159 }), { x: 88, y: 253, z: 88 });
  assert.deepEqual(stage2CenterOfExistingGeneration({ x: 160, z: 160 }), { x: 248, y: 253, z: 248 });
  assert.deepEqual(stage2CenterOfExistingGeneration({ x: -1, z: -1 }), { x: -72, y: 253, z: -72 });
  assert.deepEqual(stage2SpawnCellChunksFromPlayerBlock({ x: 159, z: 159 }), {
    cellChunk: { x: 0, z: 0 },
    centerChunk: { x: 5, z: 5 },
  });
  assert.deepEqual(stage2SpawnCellChunksFromPlayerBlock({ x: 160, z: 160 }), {
    cellChunk: { x: 10, z: 10 },
    centerChunk: { x: 15, z: 15 },
  });
});

test("Stage2Util preserves special-band chunk selection and minimum-distance rejection", () => {
  assert.equal(stage2IsSpecialSpawnBand(159), false);
  assert.equal(stage2IsSpecialSpawnBand(160), true);
  assert.equal(stage2IsSpecialSpawnBand(200), true);
  assert.equal(stage2IsSpecialSpawnBand(201), false);

  const normalTether = stage2SpawnAttemptCoordinates({
    cellChunk: { x: 0, z: 0 },
    centerChunk: { x: 5, z: 5 },
    spawnY: 104,
    minBlockDistance: 48,
    isTether: true,
    randomChunkXOffset: 2,
    randomChunkZOffset: 3,
    randomBlockXOffset: 11,
    randomBlockZOffset: 7,
  });
  assert.deepEqual(normalTether, { chunkX: 2, chunkZ: 3, blockX: 43, blockZ: 55 });

  const specialTether = stage2SpawnAttemptCoordinates({
    cellChunk: { x: 0, z: 0 },
    centerChunk: { x: 5, z: 5 },
    spawnY: 200,
    minBlockDistance: 0,
    isTether: true,
    randomChunkXOffset: 2,
    randomChunkZOffset: 3,
    randomBlockXOffset: 11,
    randomBlockZOffset: 7,
  });
  assert.deepEqual(specialTether, { chunkX: 5, chunkZ: 3, blockX: 85, blockZ: 55 });

  const nonTether = stage2SpawnAttemptCoordinates({
    cellChunk: { x: 0, z: 0 },
    centerChunk: { x: 5, z: 5 },
    spawnY: 104,
    minBlockDistance: 0,
    isTether: false,
    randomChunkXOffset: 2,
    randomChunkZOffset: 3,
    randomBlockXOffset: 11,
    randomBlockZOffset: 7,
  });
  assert.deepEqual(nonTether, { chunkX: 5, chunkZ: 3, blockX: 91, blockZ: 55 });

  assert.equal(stage2SpawnAttemptCoordinates({
    cellChunk: { x: 0, z: 0 },
    centerChunk: { x: 5, z: 5 },
    spawnY: 163,
    minBlockDistance: 48,
    isTether: true,
    randomChunkXOffset: 5,
    randomChunkZOffset: 5,
    randomBlockXOffset: 0,
    randomBlockZOffset: 0,
  }), null);
});

test("Stage2Util floor validation and bounded scan return the block above a safe floor", () => {
  assert.equal(stage2IsValidFloor({
    isAir: false,
    canBeReplaced: false,
    canStandOnUp: true,
    isBarrier: false,
    isMud: false,
  }), true);
  assert.equal(stage2IsValidFloor({
    isAir: false,
    canBeReplaced: false,
    canStandOnUp: false,
    isBarrier: true,
    isMud: false,
  }), true);
  assert.equal(stage2IsValidFloor({
    isAir: false,
    canBeReplaced: false,
    canStandOnUp: false,
    isBarrier: false,
    isMud: true,
  }), true);
  assert.equal(stage2IsValidFloor({
    isAir: true,
    canBeReplaced: false,
    canStandOnUp: true,
    isBarrier: false,
    isMud: false,
  }), false);
  assert.equal(stage2IsValidFloor({
    isAir: false,
    canBeReplaced: true,
    canStandOnUp: true,
    isBarrier: false,
    isMud: false,
  }), false);

  assert.equal(stage2FindSafeSpawnY({
    spawnY: 163,
    isValidFloor: (y) => y === 161,
    areAboveBlocksReplaceable: (y, offset) => y === 161 && offset >= 1 && offset <= 3,
  }), 162);
  assert.equal(stage2FindSafeSpawnY({
    spawnY: 163,
    maxScanDepth: 4,
    isValidFloor: (y) => y === 159,
    areAboveBlocksReplaceable: () => true,
  }), 160);
  assert.equal(stage2FindSafeSpawnY({
    spawnY: 163,
    maxScanDepth: 4,
    isValidFloor: (y) => y === 158,
    areAboveBlocksReplaceable: () => true,
  }), null);
});

test("Phase 3 source constants and end predicate match current decompilation", () => {
  assert.deepEqual(PHASE3_SOURCE.center, { x: 194, y: -59, z: 205 });
  assert.equal(PHASE3_SOURCE.transferDelayTicks, 20);
  assert.equal(PHASE3_SOURCE.boundaryKillDelayTicks, 60);
  assert.equal(PHASE3_SOURCE.minTentacleRange, 100);
  assert.equal(PHASE3_SOURCE.maxTentacleRangeExclusive, 124);
  assert.equal(PHASE3_SOURCE.tentacleConstantCount, 250);
  assert.equal(phase3TentacleCandidateCount(), 251, "source loops IntRange(0, 250), which is inclusive");
  assert.equal(PHASE3_SOURCE.endDiscardDelayTicks, 298);
  assert.deepEqual(PHASE3_SOURCE.presetTentacles, [
    { x: 162, y: -59, z: 232 },
    { x: 186, y: -59, z: 181 },
    { x: 228, y: -59, z: 213 },
  ]);
  assert.equal(phase3BoundaryKillEligible(91, true), true);
  assert.equal(phase3BoundaryKillEligible(90, true), false);
  assert.equal(phase3BoundaryKillEligible(120, false), false);
  assert.equal(phase3Ended(false), false);
  assert.equal(phase3Ended(true), true);
});

test("boss controller does not manufacture Integrity health-threshold phase transitions", async () => {
  const controller = await readFile(
    path.join(repoRoot, "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js"),
    "utf8",
  );
  assert.doesNotMatch(controller, /phase transition by health fraction/i);
  assert.doesNotMatch(controller, /function transitionPhase\(/);
  assert.doesNotMatch(controller, /const threshold = e\.typeId === "thebrokenscript:integrity_phase_1" \? 0\.5 : 0\.4/);
  assert.match(controller, /setArenaState\(true, e\.typeId === "thebrokenscript:integrity_phase_1"\)/);
});
