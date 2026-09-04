import assert from "node:assert/strict";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Phase 2 plans the first Stage 2 floor transition from the participant roster", () => {
  assert.equal(typeof integrityModel.phase2Stage2FloorStep, "function");

  const step = integrityModel.phase2Stage2FloorStep({
    phase: "phase2",
    spawnedFloorIds: [],
    integrityPresent: false,
    players: [
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
    ],
  });

  assert.deepEqual(
    step.floorsToSpawn.map(({ floorId, playerId }) => ({ floorId, playerId })),
    [{ floorId: "FLOOR_1", playerId: "player-floor-1" }],
  );
  assert.deepEqual(step.nextSpawnedFloorIds, ["FLOOR_1"]);
});
