import {
  ARENA_SOURCE,
  INTEGRITY_PHASE,
  PHASE1_SOURCE,
  PHASE2_SOURCE,
  PHASE3_SOURCE,
  arenaCheckLivingPlayers,
  phase1Ended,
  phase2IntegrityFloorFromY,
  phase2NeedsRecoveryTeleport,
  phase2EligibleForLowestPlayer,
  phase3Ended,
} from "./integrity_arena_model.js";

export const INTEGRITY_RUNTIME_SOURCE = Object.freeze({
  participantRadius: ARENA_SOURCE.participantRadius,
  dimensionSettleDelayTicks: 35,
  phase1: Object.freeze({
    introDelayTicks: PHASE1_SOURCE.introDelayTicks,
    terrainCorruptionRadius: PHASE1_SOURCE.terrainCorruptionRadius,
    terrainCorruptionDelayTicks: PHASE1_SOURCE.terrainCorruptionDelayTicks,
    chordMaxCount: PHASE1_SOURCE.chordMaxCount,
    chordRadius: PHASE1_SOURCE.chordRadius,
  }),
  phase2: Object.freeze({
    transferDelayTicks: PHASE2_SOURCE.transferDelayTicks,
    recoveryTeleport: PHASE2_SOURCE.recoveryTeleport,
    ended: false,
  }),
  phase3: Object.freeze({
    transferDelayTicks: PHASE3_SOURCE.transferDelayTicks,
    center: PHASE3_SOURCE.center,
    endedOnDying: true,
  }),
});

const PHASES = new Set(Object.values(INTEGRITY_PHASE));

function normalizeParticipantIds(ids) {
  if (!Array.isArray(ids)) throw new TypeError("participantIds must be an array");
  const unique = [];
  const seen = new Set();
  for (const id of ids) {
    if (typeof id !== "string" || id.length === 0) {
      throw new TypeError("participant ids must be non-empty strings");
    }
    if (seen.has(id)) continue;
    seen.add(id);
    unique.push(id);
  }
  return unique;
}

export function createIntegrityRuntimeState(participantIds = []) {
  return {
    generation: 0,
    phase: INTEGRITY_PHASE.PHASE_1,
    phaseTick: 0,
    participantIds: normalizeParticipantIds(participantIds),
    introComplete: false,
    trackedChordIds: [],
    integrityId: null,
    currentFloorId: null,
    pendingDimensionPlayers: {},
    victory: false,
  };
}

export function refreshIntegrityParticipantIds(state, playerRecords = []) {
  const connected = new Set(
    playerRecords
      .filter((record) => record?.connected !== false)
      .map((record) => record?.id)
      .filter((id) => typeof id === "string" && id.length > 0),
  );
  return {
    ...state,
    participantIds: state.participantIds.filter((id) => connected.has(id)),
  };
}

export function arenaParticipantsAlive(playerRecords = []) {
  return arenaCheckLivingPlayers(playerRecords);
}

export function phase1IntroStep({ tick, introComplete = false } = {}) {
  if (!Number.isInteger(tick) || tick < 0) {
    throw new RangeError(`Phase 1 tick must be a non-negative integer: ${tick}`);
  }
  if (introComplete) return { introComplete: true, spawnChords: false };
  if (tick < PHASE1_SOURCE.introDelayTicks) {
    return { introComplete: false, spawnChords: false };
  }
  return { introComplete: true, spawnChords: true };
}

export function phase1CompletionStep(chords = []) {
  return phase1Ended(chords);
}

export function phase2PlayerStep({ y, currentFloorId = null } = {}) {
  if (!Number.isFinite(y)) throw new RangeError(`Phase 2 player Y must be finite: ${y}`);
  const floor = phase2IntegrityFloorFromY(y);
  return {
    recoveryTeleport: phase2NeedsRecoveryTeleport(y),
    floorId: floor?.id ?? null,
    eligibleForIntegrity: phase2EligibleForLowestPlayer(y),
    floorChanged: floor?.id !== undefined && floor?.id !== currentFloorId,
  };
}

export function integrityPhaseStep({
  phase,
  phase1Ended: phase1IsEnded = false,
  phase2Ended: phase2IsEnded = false,
  phase3Dying = false,
} = {}) {
  if (!PHASES.has(phase)) throw new RangeError(`Unknown Integrity phase: ${phase}`);
  if (phase === INTEGRITY_PHASE.PHASE_1 && phase1IsEnded) {
    return { nextPhase: INTEGRITY_PHASE.PHASE_2, victory: false };
  }
  if (phase === INTEGRITY_PHASE.PHASE_2 && phase2IsEnded) {
    return { nextPhase: INTEGRITY_PHASE.PHASE_3, victory: false };
  }
  if (phase === INTEGRITY_PHASE.PHASE_3 && phase3Ended(phase3Dying)) {
    return { nextPhase: null, victory: true };
  }
  return { nextPhase: null, victory: false };
}

export function dimensionSettleStep(elapsedTicks) {
  return Number.isInteger(elapsedTicks)
    && elapsedTicks >= INTEGRITY_RUNTIME_SOURCE.dimensionSettleDelayTicks;
}
