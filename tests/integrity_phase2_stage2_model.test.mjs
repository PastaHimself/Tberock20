import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

const stage2Players = [
  {
    id: "player-floor-1",
    dimensionId: "thebrokenscript:stage2",
    y: 254,
    loadingPhase2: false,
  },
  {
    id: "player-floor-7",
    dimensionId: "thebrokenscript:stage2",
    y: 104,
    loadingPhase2: false,
  },
];

test("Phase 2 plans the first Stage 2 floor transition from the participant roster", () => {
  assert.equal(typeof integrityModel.phase2Stage2FloorStep, "function");

  const step = integrityModel.phase2Stage2FloorStep({
    phase: "phase2",
    spawnedFloorIds: [],
    integrityPresent: false,
    players: stage2Players,
  });

  assert.deepEqual(
    step.floorsToSpawn.map(({ floorId, playerId }) => ({ floorId, playerId })),
    [{ floorId: "FLOOR_1", playerId: "player-floor-1" }],
  );
  assert.deepEqual(step.nextSpawnedFloorIds, ["FLOOR_1"]);
});

test("Stage 2 floor spawning is one-shot, dimension-gated, and permits Floor 7 only after Integrity exists", () => {
  const step = integrityModel.phase2Stage2FloorStep({
    phase: "phase2",
    spawnedFloorIds: ["FLOOR_1"],
    integrityPresent: true,
    players: [
      ...stage2Players,
      {
        id: "player-floor-2",
        dimensionId: "thebrokenscript:stage2",
        y: 235,
        loadingPhase2: false,
      },
      {
        id: "player-loading",
        dimensionId: "thebrokenscript:stage2",
        y: 219,
        loadingPhase2: true,
      },
      {
        id: "player-other-dimension",
        dimensionId: "minecraft:overworld",
        y: 219,
        loadingPhase2: false,
      },
    ],
  });

  assert.deepEqual(
    step.floorsToSpawn.map(({ floorId, playerId }) => ({ floorId, playerId })),
    [
      { floorId: "FLOOR_7", playerId: "player-floor-7" },
      { floorId: "FLOOR_2", playerId: "player-floor-2" },
    ],
  );
  assert.deepEqual(step.nextSpawnedFloorIds, ["FLOOR_1", "FLOOR_7", "FLOOR_2"]);
});

test("Integrity placement waits for a Tether except on the Floor 6 special mapping", () => {
  const waiting = integrityModel.phase2IntegrityPlacementStep({
    playerY: 235,
    integrityPresent: true,
    currentFloorId: "Floor1",
    hasTetherOnTargetFloor: false,
  });
  assert.deepEqual(waiting, {
    action: "wait_for_tether",
    targetFloorId: "Floor2",
    stage2FloorId: "FLOOR_2",
    requiresTether: true,
  });

  const placed = integrityModel.phase2IntegrityPlacementStep({
    playerY: 235,
    integrityPresent: true,
    currentFloorId: "Floor1",
    hasTetherOnTargetFloor: true,
  });
  assert.deepEqual(placed, {
    action: "place",
    targetFloorId: "Floor2",
    stage2FloorId: "FLOOR_2",
    requiresTether: true,
  });

  const floorSix = integrityModel.phase2IntegrityPlacementStep({
    playerY: 180,
    integrityPresent: true,
    currentFloorId: "Floor5",
    hasTetherOnTargetFloor: false,
  });
  assert.deepEqual(floorSix, {
    action: "place",
    targetFloorId: "Floor6",
    stage2FloorId: "FLOOR_6_INTEG",
    requiresTether: false,
  });

  const alreadyPlaced = integrityModel.phase2IntegrityPlacementStep({
    playerY: 180,
    integrityPresent: true,
    currentFloorId: "Floor6",
  });
  assert.equal(alreadyPlaced.action, "already_placed");
});

test("Stage 2 safe scanning returns the block above the first valid floor", () => {
  const safeY = integrityModel.stage2FindSafeSpawnY({
    spawnY: 254,
    maxScanDepth: 4,
    isValidFloor: (candidateY) => candidateY === 252,
    areAboveBlocksReplaceable: () => true,
  });
  assert.equal(safeY, 253);

  const blockedY = integrityModel.stage2FindSafeSpawnY({
    spawnY: 254,
    maxScanDepth: 4,
    isValidFloor: (candidateY) => candidateY === 252,
    areAboveBlocksReplaceable: (_candidateY, offset) => offset !== 2,
  });
  assert.equal(blockedY, null);
});

test("Stage 2 runtime wires the supported block, entity, and placement seams", async () => {
  const runtime = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_runtime.js", import.meta.url),
    "utf8",
  );

  for (const fragment of [
    "phase2Stage2FloorStep",
    "phase2IntegrityPlacementStep",
    "stage2FindSafeSpawnY",
    "dimension.getBlock(",
    "dimension.getEntities({",
    "dimension.spawnEntity(",
    "stage2IntegrityPositionAllowed",
  ]) {
    assert.ok(runtime.includes(fragment), "runtime is missing " + fragment);
  }
});
