import assert from "node:assert/strict";
import test from "node:test";

import {
  PHASE2_SOURCE,
  phase1CompletionStep,
  phase2TransferPlan,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_phase2_transfer_model.js";
import {
  phase2IntegrityFloorFromY,
  phase2LowestPlayer,
  phase2NeedsRecoveryTeleport,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

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

test("Phase 2 recovery band is inclusive at 190 and exclusive at 199", () => {
  assert.equal(phase2NeedsRecoveryTeleport(190), true);
  assert.equal(phase2NeedsRecoveryTeleport(198), true);
  assert.equal(phase2NeedsRecoveryTeleport(189), false);
  assert.equal(phase2NeedsRecoveryTeleport(199), false);
});

test("Phase 2 lowest-player selection ignores Y 103 and below and keeps first ties", () => {
  assert.deepEqual(
    phase2LowestPlayer([
      { id: "too-low", y: 103 },
      { id: "first", y: 140 },
      { id: "tie", y: 140 },
      { id: "lower", y: 120 },
    ]),
    { id: "lower", y: 120 },
  );
  assert.deepEqual(
    phase2LowestPlayer([
      { id: "first", y: 120 },
      { id: "tie", y: 120 },
    ]),
    { id: "first", y: 120 },
  );
  assert.equal(phase2LowestPlayer([{ id: "too-low", y: 103 }]), null);
});

test("Phase 2 integrity floor mapping preserves Floor 6's special Stage 2 floor", () => {
  assert.equal(phase2IntegrityFloorFromY(300).id, "Floor1");
  assert.equal(phase2IntegrityFloorFromY(230).id, "Floor2");
  assert.equal(phase2IntegrityFloorFromY(180).stage2Floor, "FLOOR_6_INTEG");
  assert.equal(phase2IntegrityFloorFromY(159).id, "Floor7");
  assert.equal(phase2IntegrityFloorFromY(301), null);
});
