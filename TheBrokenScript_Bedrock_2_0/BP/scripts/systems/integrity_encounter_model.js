// Pure Integrity encounter lifecycle model. Runtime code owns entity/player lookups;
// this module stores only stable participant ids so stale Script API references are
// never retained across ticks or disconnects.

export const INTEGRITY_ENCOUNTER_STATE = Object.freeze({
  DORMANT: "dormant",
  TRIGGER_DETECTED: "trigger_detected",
  PARTICIPANTS_SELECTED: "participants_selected",
  ARENA_PREPARING: "arena_preparing",
  PARTICIPANTS_TRANSFERRING: "participants_transferring",
  ENCOUNTER_STARTED: "encounter_started",
  PHASE_1: "phase_1",
  PHASE_2: "phase_2",
  PHASE_3: "phase_3",
  VICTORY: "victory",
  FAILURE_RESET: "failure_reset",
  CLEANUP: "cleanup",
});

const ACTIVE_STATES = new Set([
  INTEGRITY_ENCOUNTER_STATE.TRIGGER_DETECTED,
  INTEGRITY_ENCOUNTER_STATE.PARTICIPANTS_SELECTED,
  INTEGRITY_ENCOUNTER_STATE.ARENA_PREPARING,
  INTEGRITY_ENCOUNTER_STATE.PARTICIPANTS_TRANSFERRING,
  INTEGRITY_ENCOUNTER_STATE.ENCOUNTER_STARTED,
  INTEGRITY_ENCOUNTER_STATE.PHASE_1,
  INTEGRITY_ENCOUNTER_STATE.PHASE_2,
  INTEGRITY_ENCOUNTER_STATE.PHASE_3,
]);

function copy(encounter, patch) {
  return {
    state: encounter.state,
    participantIds: [...encounter.participantIds],
    generation: encounter.generation,
    failureReason: encounter.failureReason,
    ...patch,
  };
}

function transition(encounter, expectedState, nextState, patch = {}) {
  if (encounter.state !== expectedState) {
    return { accepted: false, encounter };
  }
  return {
    accepted: true,
    encounter: copy(encounter, { state: nextState, ...patch }),
  };
}

function normalizeParticipantIds(ids) {
  if (!Array.isArray(ids)) throw new TypeError("participantIds must be an array");
  const unique = [];
  const seen = new Set();
  for (const raw of ids) {
    if (typeof raw !== "string" || raw.length === 0) {
      throw new TypeError("participant ids must be non-empty strings");
    }
    if (!seen.has(raw)) {
      seen.add(raw);
      unique.push(raw);
    }
  }
  return unique;
}

export function createIntegrityEncounter() {
  return {
    state: INTEGRITY_ENCOUNTER_STATE.DORMANT,
    participantIds: [],
    generation: 0,
    failureReason: null,
  };
}

export function detectIntegrityTrigger(encounter) {
  return transition(
    encounter,
    INTEGRITY_ENCOUNTER_STATE.DORMANT,
    INTEGRITY_ENCOUNTER_STATE.TRIGGER_DETECTED,
    { failureReason: null },
  );
}

export function selectIntegrityParticipants(encounter, participantIds) {
  if (encounter.state !== INTEGRITY_ENCOUNTER_STATE.TRIGGER_DETECTED) {
    return { accepted: false, encounter };
  }
  const normalized = normalizeParticipantIds(participantIds);
  if (normalized.length === 0) return { accepted: false, encounter };
  return {
    accepted: true,
    encounter: copy(encounter, {
      state: INTEGRITY_ENCOUNTER_STATE.PARTICIPANTS_SELECTED,
      participantIds: normalized,
    }),
  };
}

export function beginIntegrityArenaPreparation(encounter) {
  return transition(
    encounter,
    INTEGRITY_ENCOUNTER_STATE.PARTICIPANTS_SELECTED,
    INTEGRITY_ENCOUNTER_STATE.ARENA_PREPARING,
  );
}

export function beginIntegrityParticipantTransfer(encounter) {
  return transition(
    encounter,
    INTEGRITY_ENCOUNTER_STATE.ARENA_PREPARING,
    INTEGRITY_ENCOUNTER_STATE.PARTICIPANTS_TRANSFERRING,
  );
}

export function markIntegrityEncounterStarted(encounter) {
  return transition(
    encounter,
    INTEGRITY_ENCOUNTER_STATE.PARTICIPANTS_TRANSFERRING,
    INTEGRITY_ENCOUNTER_STATE.ENCOUNTER_STARTED,
  );
}

export function beginIntegrityPhase1(encounter) {
  return transition(
    encounter,
    INTEGRITY_ENCOUNTER_STATE.ENCOUNTER_STARTED,
    INTEGRITY_ENCOUNTER_STATE.PHASE_1,
  );
}

export function advanceIntegrityPhase(encounter) {
  if (encounter.state === INTEGRITY_ENCOUNTER_STATE.PHASE_1) {
    return transition(encounter, INTEGRITY_ENCOUNTER_STATE.PHASE_1, INTEGRITY_ENCOUNTER_STATE.PHASE_2);
  }
  if (encounter.state === INTEGRITY_ENCOUNTER_STATE.PHASE_2) {
    return transition(encounter, INTEGRITY_ENCOUNTER_STATE.PHASE_2, INTEGRITY_ENCOUNTER_STATE.PHASE_3);
  }
  return { accepted: false, encounter };
}

export function completeIntegrityVictory(encounter) {
  return transition(
    encounter,
    INTEGRITY_ENCOUNTER_STATE.PHASE_3,
    INTEGRITY_ENCOUNTER_STATE.VICTORY,
  );
}

export function failIntegrityEncounter(encounter, reason = "unknown") {
  if (!ACTIVE_STATES.has(encounter.state)) return { accepted: false, encounter };
  return {
    accepted: true,
    encounter: copy(encounter, {
      state: INTEGRITY_ENCOUNTER_STATE.FAILURE_RESET,
      failureReason: String(reason),
    }),
  };
}

export function removeIntegrityParticipant(encounter, participantId, reason = "participant_unavailable") {
  if (typeof participantId !== "string" || participantId.length === 0) {
    throw new TypeError("participantId must be a non-empty string");
  }
  if (!encounter.participantIds.includes(participantId)) {
    return { accepted: false, encounter };
  }

  const participantIds = encounter.participantIds.filter((id) => id !== participantId);
  if (participantIds.length === 0 && ACTIVE_STATES.has(encounter.state)) {
    return {
      accepted: true,
      encounter: copy(encounter, {
        state: INTEGRITY_ENCOUNTER_STATE.FAILURE_RESET,
        participantIds,
        failureReason: String(reason),
      }),
    };
  }

  return {
    accepted: true,
    encounter: copy(encounter, { participantIds }),
  };
}

export function beginIntegrityCleanup(encounter) {
  if (
    encounter.state !== INTEGRITY_ENCOUNTER_STATE.VICTORY &&
    encounter.state !== INTEGRITY_ENCOUNTER_STATE.FAILURE_RESET
  ) {
    return { accepted: false, encounter };
  }
  return {
    accepted: true,
    encounter: copy(encounter, { state: INTEGRITY_ENCOUNTER_STATE.CLEANUP }),
  };
}

export function finishIntegrityCleanup(encounter) {
  if (encounter.state !== INTEGRITY_ENCOUNTER_STATE.CLEANUP) {
    return { accepted: false, encounter };
  }
  return {
    accepted: true,
    encounter: {
      state: INTEGRITY_ENCOUNTER_STATE.DORMANT,
      participantIds: [],
      generation: encounter.generation + 1,
      failureReason: null,
    },
  };
}

export function isIntegrityEncounterActive(encounter) {
  return ACTIVE_STATES.has(encounter.state);
}
