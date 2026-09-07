import test from "node:test";
import assert from "node:assert/strict";
import {
  INTEGRITY_ENCOUNTER_STATE,
  advanceIntegrityPhase,
  beginIntegrityArenaPreparation,
  beginIntegrityCleanup,
  beginIntegrityParticipantTransfer,
  beginIntegrityPhase1,
  completeIntegrityVictory,
  createIntegrityEncounter,
  detectIntegrityTrigger,
  failIntegrityEncounter,
  finishIntegrityCleanup,
  isIntegrityEncounterActive,
  markIntegrityEncounterStarted,
  removeIntegrityParticipant,
  selectIntegrityParticipants,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_encounter_model.js";

function requireAccepted(result) {
  assert.equal(result.accepted, true);
  return result.encounter;
}

function advanceToPhase1(ids = ["player-a"]) {
  let encounter = createIntegrityEncounter();
  encounter = requireAccepted(detectIntegrityTrigger(encounter));
  encounter = requireAccepted(selectIntegrityParticipants(encounter, ids));
  encounter = requireAccepted(beginIntegrityArenaPreparation(encounter));
  encounter = requireAccepted(beginIntegrityParticipantTransfer(encounter));
  encounter = requireAccepted(markIntegrityEncounterStarted(encounter));
  return requireAccepted(beginIntegrityPhase1(encounter));
}

test("Integrity encounter rejects duplicate startup triggers", () => {
  let encounter = createIntegrityEncounter();
  const first = detectIntegrityTrigger(encounter);
  assert.equal(first.accepted, true);
  encounter = first.encounter;

  const duplicate = detectIntegrityTrigger(encounter);
  assert.equal(duplicate.accepted, false);
  assert.equal(duplicate.encounter.state, INTEGRITY_ENCOUNTER_STATE.TRIGGER_DETECTED);
});

test("Integrity participant roster is stable-id based and deduplicated", () => {
  let encounter = requireAccepted(detectIntegrityTrigger(createIntegrityEncounter()));
  encounter = requireAccepted(selectIntegrityParticipants(encounter, ["a", "b", "a"]));

  assert.deepEqual(encounter.participantIds, ["a", "b"]);
  assert.equal(encounter.state, INTEGRITY_ENCOUNTER_STATE.PARTICIPANTS_SELECTED);
});

test("Integrity phases can only progress in source order", () => {
  let encounter = advanceToPhase1();
  assert.equal(encounter.state, INTEGRITY_ENCOUNTER_STATE.PHASE_1);

  encounter = requireAccepted(advanceIntegrityPhase(encounter));
  assert.equal(encounter.state, INTEGRITY_ENCOUNTER_STATE.PHASE_2);
  encounter = requireAccepted(advanceIntegrityPhase(encounter));
  assert.equal(encounter.state, INTEGRITY_ENCOUNTER_STATE.PHASE_3);

  assert.equal(advanceIntegrityPhase(encounter).accepted, false);
  encounter = requireAccepted(completeIntegrityVictory(encounter));
  assert.equal(encounter.state, INTEGRITY_ENCOUNTER_STATE.VICTORY);
  assert.equal(isIntegrityEncounterActive(encounter), false);
});

test("disconnect/death removal keeps remaining participants and fails when roster empties", () => {
  let encounter = advanceToPhase1(["a", "b"]);
  encounter = requireAccepted(removeIntegrityParticipant(encounter, "a", "disconnect"));
  assert.deepEqual(encounter.participantIds, ["b"]);
  assert.equal(encounter.state, INTEGRITY_ENCOUNTER_STATE.PHASE_1);

  encounter = requireAccepted(removeIntegrityParticipant(encounter, "b", "death"));
  assert.deepEqual(encounter.participantIds, []);
  assert.equal(encounter.state, INTEGRITY_ENCOUNTER_STATE.FAILURE_RESET);
  assert.equal(encounter.failureReason, "death");
});

test("failure and victory both converge through cleanup to a fresh generation", () => {
  let failed = advanceToPhase1();
  failed = requireAccepted(failIntegrityEncounter(failed, "arena_invariant"));
  failed = requireAccepted(beginIntegrityCleanup(failed));
  failed = requireAccepted(finishIntegrityCleanup(failed));
  assert.deepEqual(failed, {
    state: INTEGRITY_ENCOUNTER_STATE.DORMANT,
    participantIds: [],
    generation: 1,
    failureReason: null,
  });

  let won = advanceToPhase1();
  won = requireAccepted(advanceIntegrityPhase(won));
  won = requireAccepted(advanceIntegrityPhase(won));
  won = requireAccepted(completeIntegrityVictory(won));
  won = requireAccepted(beginIntegrityCleanup(won));
  won = requireAccepted(finishIntegrityCleanup(won));
  assert.equal(won.state, INTEGRITY_ENCOUNTER_STATE.DORMANT);
  assert.equal(won.generation, 1);
});
