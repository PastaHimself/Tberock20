import assert from "node:assert/strict";
import test from "node:test";

import {
  PHASE2_SOURCE,
  phase1CompletionStep,
  phase2TransferPlan,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_phase2_transfer_model.js";

test("Phase 2 transfer constants preserve the recovered source contract", () => {
  assert.deepEqual(PHASE2_SOURCE, {
    transferDelayTicks: 20,
    destinationDimensionId: "thebrokenscript:stage2",
    recoveryBandMinY: 190,
    recoveryBandMaxYExclusive: 199,
    recoveryTeleport: { x: 85.5, y: 162.5, z: 87.5 },
    lowestPlayerMinYExclusive: 103,
  });
});

test("Phase 1 only completes after the Chord roster has spawned and all are dead", () => {
  assert.equal(phase1CompletionStep({ chordsSpawned: false, livingChordCount: 0 }), "active");
  assert.equal(phase1CompletionStep({ chordsSpawned: true, livingChordCount: 2 }), "active");
  assert.equal(phase1CompletionStep({ chordsSpawned: true, livingChordCount: 0 }), "complete");
});

test("Phase 2 transfer keeps the participant roster and waits 20 ticks", () => {
  assert.deepEqual(
    phase2TransferPlan({ phase: "phase1", participantIds: ["p1", "p2"] }),
    {
      action: "schedule_transfer",
      delayTicks: 20,
      destinationDimensionId: "thebrokenscript:stage2",
      participantIds: ["p1", "p2"],
    },
  );
});

test("Phase 2 transfer plan is idempotent once staging has begun", () => {
  assert.deepEqual(
    phase2TransferPlan({ phase: "phase2_loading", participantIds: ["p1"] }),
    { action: "already_staging" },
  );
});
