import assert from "node:assert/strict";
import test from "node:test";

import {
  phase2IntegrityFloorFromY,
  phase2LowestPlayer,
  phase2NeedsRecoveryTeleport,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

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
