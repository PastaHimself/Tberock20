import assert from "node:assert/strict";
import test from "node:test";

import {
  INTEGRITY_RUNTIME_SOURCE,
  createIntegrityRuntimeState,
  arenaParticipantsAlive,
  refreshIntegrityParticipantIds,
  phase1CompletionStep,
  phase1IntroStep,
  phase2PlayerStep,
  integrityPhaseStep,
  dimensionSettleStep,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_runtime_model.js";

test("Integrity runtime constants preserve Arena and phase timing", () => {
  assert.equal(INTEGRITY_RUNTIME_SOURCE.participantRadius, 150);
  assert.equal(INTEGRITY_RUNTIME_SOURCE.dimensionSettleDelayTicks, 35);
  assert.equal(INTEGRITY_RUNTIME_SOURCE.phase1.introDelayTicks, 1080);
  assert.equal(INTEGRITY_RUNTIME_SOURCE.phase2.transferDelayTicks, 20);
  assert.equal(INTEGRITY_RUNTIME_SOURCE.phase3.transferDelayTicks, 20);
  assert.equal(INTEGRITY_RUNTIME_SOURCE.phase2.ended, false);
});

test("Integrity runtime state deduplicates stable participant ids", () => {
  const state = createIntegrityRuntimeState(["a", "b", "a"]);
  assert.deepEqual(state.participantIds, ["a", "b"]);
  assert.equal(state.phase, "phase1");
  assert.equal(state.generation, 0);
});

test("Arena refresh removes disconnected participants without cross-player attribution", () => {
  const state = createIntegrityRuntimeState(["a", "b", "c"]);
  const refreshed = refreshIntegrityParticipantIds(state, [
    { id: "a", connected: true, alive: true },
    { id: "b", connected: false, alive: true },
    { id: "c", connected: true, alive: false },
  ]);
  assert.deepEqual(refreshed.participantIds, ["a", "c"]);
  assert.equal(arenaParticipantsAlive([
    { connected: true, alive: false },
    { connected: true, alive: false },
  ]), true);
  assert.equal(arenaParticipantsAlive([
    { connected: true, alive: false },
    { connected: true, alive: false },
    { connected: true, alive: false },
  ]), false);
});

test("Phase 1 intro fires once at the inclusive delayed tick", () => {
  assert.deepEqual(phase1IntroStep({ tick: 1079, introComplete: false }), {
    introComplete: false,
    spawnChords: false,
  });
  assert.deepEqual(phase1IntroStep({ tick: 1080, introComplete: false }), {
    introComplete: true,
    spawnChords: true,
  });
  assert.deepEqual(phase1IntroStep({ tick: 1081, introComplete: true }), {
    introComplete: true,
    spawnChords: false,
  });
});

test("Phase 1 completion waits for tracked Chords and Phase 2 does not invent an HP ending", () => {
  assert.equal(phase1CompletionStep([]), false);
  assert.equal(phase1CompletionStep([{ alive: true }]), false);
  assert.equal(phase1CompletionStep([{ alive: false }]), true);
  assert.deepEqual(integrityPhaseStep({
    phase: "phase1",
    phase1Ended: true,
    phase2Ended: false,
    phase3Dying: false,
  }), { nextPhase: "phase2", victory: false });
  assert.deepEqual(integrityPhaseStep({
    phase: "phase2",
    phase1Ended: false,
    phase2Ended: false,
    phase3Dying: false,
  }), { nextPhase: null, victory: false });
});

test("Phase 2 recovery and lowest-player selection preserve exclusive Y bounds", () => {
  assert.deepEqual(phase2PlayerStep({ y: 190, currentFloorId: null }), {
    recoveryTeleport: true,
    floorId: null,
    eligibleForIntegrity: true,
  });
  assert.deepEqual(phase2PlayerStep({ y: 199, currentFloorId: null }), {
    recoveryTeleport: false,
    floorId: null,
    eligibleForIntegrity: true,
  });
  assert.deepEqual(phase2PlayerStep({ y: 170, currentFloorId: null }), {
    recoveryTeleport: false,
    floorId: "Floor6",
    eligibleForIntegrity: true,
  });
  assert.equal(phase2PlayerStep({ y: 103, currentFloorId: null }).eligibleForIntegrity, false);
});

test("Dimension transfer settles only after Java's 35-tick dimension callback delay", () => {
  assert.equal(dimensionSettleStep(34), false);
  assert.equal(dimensionSettleStep(35), true);
});
