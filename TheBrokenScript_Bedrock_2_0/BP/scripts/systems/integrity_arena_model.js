// Pure, source-backed Integrity/XCSF arena semantics.
// Keep this module free of @minecraft/server imports so CI can regression-test
// Java parity without requiring a Bedrock runtime.

export const INTEGRITY_PHASE = Object.freeze({
  PHASE_1: "phase1",
  PHASE_2: "phase2",
  PHASE_3: "phase3",
});

export const ARENA_SOURCE = Object.freeze({
  participantRadius: 150,
});

export const PHASE1_SOURCE = Object.freeze({
  introDelayTicks: 1080,
  terrainCorruptionRadius: 100,
  terrainCorruptionDelayTicks: 20,
  chordMaxCount: 10,
  chordRadius: 10,
});

// Stage2Floor.kt/CFR output. `boundsMinDistance` is the SpawnBounds value;
// FLOOR_4/FLOOR_5/FLOOR_6_INTEG use the constructor default of 32.
export const STAGE2_FLOORS = Object.freeze([
  Object.freeze({ id: "FLOOR_1", yMin: 249, yMax: 300, spawnY: 254, sourceSpawns: Object.freeze(["TETHER", "INTEGRITY_PHASE_2"]), boundsMinDistance: 48 }),
  Object.freeze({ id: "FLOOR_2", yMin: 230, yMax: 248, spawnY: 235, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 32 }),
  Object.freeze({ id: "FLOOR_3", yMin: 214, yMax: 229, spawnY: 219, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 16 }),
  Object.freeze({ id: "FLOOR_4", yMin: 206, yMax: 213, spawnY: 209, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 32 }),
  Object.freeze({ id: "FLOOR_5", yMin: 200, yMax: 205, spawnY: 203, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 32 }),
  Object.freeze({ id: "FLOOR_6", yMin: 160, yMax: 199, spawnY: 163, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 8 }),
  Object.freeze({ id: "FLOOR_6_INTEG", yMin: 160, yMax: 180, spawnY: 163, sourceSpawns: Object.freeze([]), boundsMinDistance: 32 }),
  Object.freeze({ id: "FLOOR_7", yMin: -2147483648, yMax: 159, spawnY: 104, sourceSpawns: Object.freeze(["TETHER"]), boundsMinDistance: 28 }),
]);

// Phase2Floors is deliberately not the same enum as Stage2Floor. Floor6 maps
// to FLOOR_6_INTEG, while floor-spawn lookup sees FLOOR_6 first.
export const PHASE2_INTEGRITY_FLOORS = Object.freeze([
  Object.freeze({ id: "Floor1", stage2Floor: "FLOOR_1", level: 1 }),
  Object.freeze({ id: "Floor2", stage2Floor: "FLOOR_2", level: 2 }),
  Object.freeze({ id: "Floor3", stage2Floor: "FLOOR_3", level: 3 }),
  Object.freeze({ id: "Floor4", stage2Floor: "FLOOR_4", level: 4 }),
  Object.freeze({ id: "Floor5", stage2Floor: "FLOOR_5", level: 5 }),
  Object.freeze({ id: "Floor6", stage2Floor: "FLOOR_6_INTEG", level: 6 }),
  Object.freeze({ id: "Floor7", stage2Floor: "FLOOR_7", level: 7 }),
]);

export const PHASE2_SOURCE = Object.freeze({
  transferDelayTicks: 20,
  recoveryBandMinY: 190,
  recoveryBandMaxYExclusive: 199,
  recoveryTeleport: Object.freeze({ x: 85.5, y: 162.5, z: 87.5 }),
  lowestPlayerMinYExclusive: 103,
});

export const PHASE3_SOURCE = Object.freeze({
  center: Object.freeze({ x: 194, y: -59, z: 205 }),
  transferDelayTicks: 20,
  upperBoundaryYExclusive: 90,
  boundaryKillDelayTicks: 60,
  minTentacleRange: 100,
  maxTentacleRangeExclusive: 124,
  tentacleConstantCount: 250,
  tentacleCandidateIndexMin: 0,
  tentacleCandidateIndexMaxInclusive: 250,
  tentacleCircleCenter: Object.freeze({ x: 200, z: 202 }),
  endDiscardDelayTicks: 298,
  presetTentacles: Object.freeze([
    Object.freeze({ x: 162, y: -59, z: 232 }),
    Object.freeze({ x: 186, y: -59, z: 181 }),
    Object.freeze({ x: 228, y: -59, z: 213 }),
  ]),
});

export function nextIntegrityPhase(phase) {
  switch (phase) {
    case INTEGRITY_PHASE.PHASE_1: return INTEGRITY_PHASE.PHASE_2;
    case INTEGRITY_PHASE.PHASE_2: return INTEGRITY_PHASE.PHASE_3;
    case INTEGRITY_PHASE.PHASE_3: return null;
    default: return null;
  }
}

// Mirrors Arena.checkLivingPlayers after disconnected cached players are removed.
// The Java source intentionally/oddly allows one or two connected participants to
// keep the arena alive even when both are dead; for 3+ players at least one must live.
export function arenaCheckLivingPlayers(participants) {
  const connected = participants.filter((player) => player?.connected !== false);
  if (connected.length === 0) return false;
  if (connected.length <= 2) return true;
  return connected.some((player) => player?.alive === true);
}

// Phase1.hasLivingChords returns true for an empty tracked list. That prevents the
// phase from ending during the 1080-tick crawl-out delay before Chords are spawned.
export function phase1HasLivingChords(chords) {
  if (chords.length === 0) return true;
  return chords.some((chord) => chord === true || chord?.alive === true);
}

export function phase1Ended(chords) {
  return !phase1HasLivingChords(chords);
}

export function stage2SpawnFloorFromY(y) {
  return STAGE2_FLOORS.find((floor) => y >= floor.yMin && y <= floor.yMax) ?? null;
}

export function phase2IntegrityFloorFromY(y) {
  for (const floor of PHASE2_INTEGRITY_FLOORS) {
    const stage = STAGE2_FLOORS.find((entry) => entry.id === floor.stage2Floor);
    if (stage && y >= stage.yMin && y <= stage.yMax) return floor;
  }
  return null;
}

export function phase2NeedsRecoveryTeleport(y) {
  return y >= PHASE2_SOURCE.recoveryBandMinY && y < PHASE2_SOURCE.recoveryBandMaxYExclusive;
}

export function phase2EligibleForLowestPlayer(y) {
  return y > PHASE2_SOURCE.lowestPlayerMinYExclusive;
}

// Phase2.getEnded() returns the final field `ended`, which is never assigned true
// in Phase2.java. Do not manufacture a health threshold for this phase.
export function phase2Ended() {
  return false;
}

export function phase3BoundaryKillEligible(y, inStage3Dimension) {
  return inStage3Dimension === true && y > PHASE3_SOURCE.upperBoundaryYExclusive;
}

export function phase3Ended(integrityDying) {
  return integrityDying === true;
}

export function phase3TentacleCandidateCount() {
  return PHASE3_SOURCE.tentacleCandidateIndexMaxInclusive - PHASE3_SOURCE.tentacleCandidateIndexMin + 1;
}
