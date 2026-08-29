import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

import {
  ARENA_SOURCE,
  INTEGRITY_PHASE,
  PHASE1_SOURCE,
  PHASE2_SOURCE,
  PHASE3_SOURCE,
  STAGE2_FLOORS,
  arenaCheckLivingPlayers,
  nextIntegrityPhase,
  phase1Ended,
  phase1HasLivingChords,
  phase2EligibleForLowestPlayer,
  phase2Ended,
  phase2IntegrityFloorFromY,
  phase2NeedsRecoveryTeleport,
  phase3BoundaryKillEligible,
  phase3Ended,
  phase3TentacleCandidateCount,
  stage2SpawnFloorFromY,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

const repoRoot = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");

test("Arena phase order and participant radius match Java source", () => {
  assert.equal(ARENA_SOURCE.participantRadius, 150);
  assert.equal(nextIntegrityPhase(INTEGRITY_PHASE.PHASE_1), INTEGRITY_PHASE.PHASE_2);
  assert.equal(nextIntegrityPhase(INTEGRITY_PHASE.PHASE_2), INTEGRITY_PHASE.PHASE_3);
  assert.equal(nextIntegrityPhase(INTEGRITY_PHASE.PHASE_3), null);
});

test("Arena.checkLivingPlayers preserves the source's <=2-player behavior", () => {
  assert.equal(arenaCheckLivingPlayers([]), false);
  assert.equal(arenaCheckLivingPlayers([{ connected: true, alive: false }]), true);
  assert.equal(arenaCheckLivingPlayers([
    { connected: true, alive: false },
    { connected: true, alive: false },
  ]), true);
  assert.equal(arenaCheckLivingPlayers([
    { connected: true, alive: false },
    { connected: true, alive: false },
    { connected: true, alive: false },
  ]), false);
  assert.equal(arenaCheckLivingPlayers([
    { connected: true, alive: false },
    { connected: true, alive: true },
    { connected: true, alive: false },
  ]), true);
  assert.equal(arenaCheckLivingPlayers([
    { connected: false, alive: true },
  ]), false);
});

test("Phase 1 delays, corruption cadence, and Chord end predicate match source", () => {
  assert.deepEqual(PHASE1_SOURCE, {
    introDelayTicks: 1080,
    terrainCorruptionRadius: 100,
    terrainCorruptionDelayTicks: 20,
    chordMaxCount: 10,
    chordRadius: 10,
  });
  assert.equal(phase1HasLivingChords([]), true);
  assert.equal(phase1Ended([]), false);
  assert.equal(phase1HasLivingChords([{ alive: false }]), false);
  assert.equal(phase1Ended([{ alive: false }]), true);
  assert.equal(phase1Ended([{ alive: false }, { alive: true }]), false);
});

test("Stage 2 floor bands and spawn bounds match Stage2Floor source", () => {
  assert.deepEqual(
    STAGE2_FLOORS.map(({ id, yMin, yMax, spawnY, boundsMinDistance }) => ({
      id, yMin, yMax, spawnY, boundsMinDistance,
    })),
    [
      { id: "FLOOR_1", yMin: 249, yMax: 300, spawnY: 254, boundsMinDistance: 48 },
      { id: "FLOOR_2", yMin: 230, yMax: 248, spawnY: 235, boundsMinDistance: 32 },
      { id: "FLOOR_3", yMin: 214, yMax: 229, spawnY: 219, boundsMinDistance: 16 },
      { id: "FLOOR_4", yMin: 206, yMax: 213, spawnY: 209, boundsMinDistance: 32 },
      { id: "FLOOR_5", yMin: 200, yMax: 205, spawnY: 203, boundsMinDistance: 32 },
      { id: "FLOOR_6", yMin: 160, yMax: 199, spawnY: 163, boundsMinDistance: 8 },
      { id: "FLOOR_6_INTEG", yMin: 160, yMax: 180, spawnY: 163, boundsMinDistance: 32 },
      { id: "FLOOR_7", yMin: -2147483648, yMax: 159, spawnY: 104, boundsMinDistance: 28 },
    ],
  );
  assert.equal(stage2SpawnFloorFromY(300)?.id, "FLOOR_1");
  assert.equal(stage2SpawnFloorFromY(199)?.id, "FLOOR_6");
  assert.equal(stage2SpawnFloorFromY(170)?.id, "FLOOR_6");
  assert.equal(stage2SpawnFloorFromY(159)?.id, "FLOOR_7");
});

test("Phase2Floors mapping remains distinct from Stage2Floor spawn lookup", () => {
  assert.equal(PHASE2_SOURCE.transferDelayTicks, 20);
  assert.deepEqual(PHASE2_SOURCE.recoveryTeleport, { x: 85.5, y: 162.5, z: 87.5 });
  assert.equal(phase2NeedsRecoveryTeleport(190), true);
  assert.equal(phase2NeedsRecoveryTeleport(198), true);
  assert.equal(phase2NeedsRecoveryTeleport(199), false);
  assert.equal(phase2IntegrityFloorFromY(170)?.id, "Floor6");
  assert.equal(phase2IntegrityFloorFromY(190), null, "Phase2Floors intentionally uses FLOOR_6_INTEG");
  assert.equal(phase2EligibleForLowestPlayer(103), false);
  assert.equal(phase2EligibleForLowestPlayer(104), true);
  assert.equal(phase2Ended(), false);
});

test("Phase 3 source constants and end predicate match current decompilation", () => {
  assert.deepEqual(PHASE3_SOURCE.center, { x: 194, y: -59, z: 205 });
  assert.equal(PHASE3_SOURCE.transferDelayTicks, 20);
  assert.equal(PHASE3_SOURCE.boundaryKillDelayTicks, 60);
  assert.equal(PHASE3_SOURCE.minTentacleRange, 100);
  assert.equal(PHASE3_SOURCE.maxTentacleRangeExclusive, 124);
  assert.equal(PHASE3_SOURCE.tentacleConstantCount, 250);
  assert.equal(phase3TentacleCandidateCount(), 251, "source loops IntRange(0, 250), which is inclusive");
  assert.equal(PHASE3_SOURCE.endDiscardDelayTicks, 298);
  assert.deepEqual(PHASE3_SOURCE.presetTentacles, [
    { x: 162, y: -59, z: 232 },
    { x: 186, y: -59, z: 181 },
    { x: 228, y: -59, z: 213 },
  ]);
  assert.equal(phase3BoundaryKillEligible(91, true), true);
  assert.equal(phase3BoundaryKillEligible(90, true), false);
  assert.equal(phase3BoundaryKillEligible(120, false), false);
  assert.equal(phase3Ended(false), false);
  assert.equal(phase3Ended(true), true);
});

test("boss controller does not manufacture Integrity health-threshold phase transitions", async () => {
  const controller = await readFile(
    path.join(repoRoot, "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js"),
    "utf8",
  );
  assert.doesNotMatch(controller, /phase transition by health fraction/i);
  assert.doesNotMatch(controller, /function transitionPhase\(/);
  assert.doesNotMatch(controller, /const threshold = e\.typeId === "thebrokenscript:integrity_phase_1" \? 0\.5 : 0\.4/);
  assert.match(controller, /setArenaState\(true, e\.typeId === "thebrokenscript:integrity_phase_1"\)/);
});
