import assert from "node:assert/strict";
import test from "node:test";

import {
  NULL_FLYING_SOURCE,
  NULL_MAZE_SOURCE,
  exactFlyingGaze,
  flyingFovCone,
  flyingDelayedOutcome,
  flyingProximityOutcome,
  mazeBreakPlan,
  mazeDoorAction,
  mazeTargetMemoryStep,
  naturalDespawnStep,
  flyingRepGainCooldownStep,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/null_pursuit_model.js";
import {
  CHUNK_REMOVER_SOURCE,
  chunkCoordinate,
  chunkRemovalPlan,
  chunkSpawnDecision,
  chunkVerticalMovePlan,
  createModifiedChunkLedger,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/chunk_remover_model.js";

test("source constants preserve maze and flying timing/range contracts", () => {
  assert.deepEqual(NULL_MAZE_SOURCE, {
    targetRange: 416,
    stalkRange: 128,
    targetMemoryTicks: 450,
    attackRange: 2,
    attackBoxInflation: 1.2,
    attackIntervalTicks: 10,
    stuckDistanceSquared: 0.002,
    stuckThresholdTicks: 30,
    breakLookDistance: 2,
    doorRayDistance: 2.5,
    movementSpeed: 1.45,
    fallingMovementSpeed: 1.55,
  });
  assert.deepEqual(NULL_FLYING_SOURCE, {
    despawnTicks: 3200,
    targetRange: 512,
    gazeRange: 128,
    triggerDelayTicks: 20,
    proximityRange: 30,
    proximityDamageChance: 0.7,
    proximityDamageMin: 1,
    proximityDamageMaxExclusive: 10,
    gazeMargin: 0.025,
    fovDivisor: 1.5,
    repGainCooldownTicks: 24000,
  });
});

test("maze breaks only after a strictly greater-than-30-tick stuck window", () => {
  const blocked = () => ({ isAir: false });
  assert.deepEqual(
    mazeBreakPlan({
      blockPosition: { x: 10, y: 64, z: -3 },
      facing: { x: 0.6, y: -0.6, z: 0 },
      stuckTicks: 30,
      hasTarget: true,
      blockAt: blocked,
      blockBreakingDisabled: false,
    }),
    { eligible: false, resetStuck: false, positions: [] },
  );

  assert.deepEqual(
    mazeBreakPlan({
      blockPosition: { x: 10, y: 64, z: -3 },
      facing: { x: 0.6, y: -0.6, z: 0 },
      stuckTicks: 31,
      hasTarget: true,
      blockAt: blocked,
      blockBreakingDisabled: false,
    }),
    {
      eligible: true,
      resetStuck: true,
      positions: [
        { x: 10, y: 64, z: -3 },
        { x: 10, y: 65, z: -3 },
        { x: 11, y: 63, z: -3 },
        { x: 11, y: 64, z: -3 },
      ],
    },
  );
});

test("maze breaking honors target, config, air, and Java truncation conditions", () => {
  const calls = [];
  const plan = mazeBreakPlan({
    blockPosition: { x: 0, y: 5, z: 0 },
    facing: { x: -0.9, y: 0.9, z: 0 },
    stuckTicks: 31,
    hasTarget: true,
    blockAt(position) {
      calls.push(position);
      return { isAir: position.x === 0 };
    },
    blockBreakingDisabled: false,
  });
  assert.deepEqual(plan.positions, [
    { x: -1, y: 6, z: 0 },
    { x: -1, y: 7, z: 0 },
  ]);
  assert.equal(calls.length, 2);
  assert.equal(mazeBreakPlan({ stuckTicks: 31, hasTarget: false }).eligible, false);
  assert.equal(mazeBreakPlan({ stuckTicks: 31, hasTarget: true, blockBreakingDisabled: true }).positions.length, 0);
});

test("maze opens only a closed door hit by the short collider ray while targeted", () => {
  assert.equal(mazeDoorAction({ hasTarget: true, hitType: "block", isDoor: true, isOpen: false }), "open");
  assert.equal(mazeDoorAction({ hasTarget: true, hitType: "block", isDoor: true, isOpen: true }), "none");
  assert.equal(mazeDoorAction({ hasTarget: true, hitType: "miss", isDoor: true, isOpen: false }), "none");
  assert.equal(mazeDoorAction({ hasTarget: false, hitType: "block", isDoor: true, isOpen: false }), "none");
});

test("maze target memory keeps a visible target and forgets it only after 450 unseen ticks", () => {
  assert.deepEqual(mazeTargetMemoryStep({ candidateTargetId: "p1", candidateVisible: true }), {
    targetId: "p1", unseenTicks: 0,
  });
  assert.deepEqual(mazeTargetMemoryStep({
    currentTargetId: "p1", targetExists: true, targetVisible: false, unseenTicks: 448,
  }), { targetId: "p1", unseenTicks: 449 });
  assert.deepEqual(mazeTargetMemoryStep({
    currentTargetId: "p1", targetExists: true, targetVisible: false, unseenTicks: 449,
  }), { targetId: undefined, unseenTicks: 0 });
  assert.deepEqual(mazeTargetMemoryStep({
    currentTargetId: "p1", targetExists: false, candidateTargetId: "p2", candidateVisible: true,
  }), { targetId: "p2", unseenTicks: 0 });
});

test("flying gaze uses the exact center dot threshold and line of sight", () => {
  const exact = { x: 0, y: 0, z: 1 };
  assert.equal(exactFlyingGaze({ viewDirection: exact, toEntity: exact, lineOfSight: true, sameDimension: true }), true);
  assert.equal(exactFlyingGaze({ viewDirection: exact, toEntity: exact, lineOfSight: false, sameDimension: true }), false);
  assert.equal(exactFlyingGaze({ viewDirection: exact, toEntity: { x: 0.3, y: 0, z: 1 }, lineOfSight: true, sameDimension: true }), false);
  assert.equal(exactFlyingGaze({ viewDirection: exact, toEntity: exact, lineOfSight: true, sameDimension: false }), false);
});

test("flying FOV cone uses the source fov/1.5 cosine threshold and explicit-FOV rule", () => {
  assert.equal(flyingFovCone({
    viewDirection: { x: 0, y: 0, z: 1 },
    toEntity: { x: 0, y: 0, z: 1 },
    fovDegrees: 90,
    lineOfSight: true,
    sameDimension: true,
  }), true);
  assert.equal(flyingFovCone({
    viewDirection: { x: 0, y: 0, z: 1 },
    toEntity: { x: 2, y: 0, z: 1 },
    fovDegrees: 90,
    lineOfSight: true,
    sameDimension: true,
  }), false);
  assert.equal(flyingFovCone({
    viewDirection: { x: 0, y: 0, z: 1 },
    toEntity: { x: 0, y: 0, z: 1 },
    storedFovDegrees: 0,
    lineOfSight: true,
    sameDimension: true,
  }), false);
  assert.equal(flyingFovCone({
    viewDirection: { x: 0, y: 0, z: 1 },
    toEntity: { x: 0, y: 0, z: 1 },
    fovDegrees: 0,
    lineOfSight: true,
    sameDimension: true,
  }), true);
});

test("flying delayed callback preserves sneak-at-trigger, sneak-at-callback, and cooldown behavior", () => {
  assert.deepEqual(flyingDelayedOutcome({ initialSneaking: false, currentSneaking: false, repGainTimer: 0 }), {
    discard: true, reputationDelta: -10, playHostileSound: true, nextRepGainTimer: 0,
  });
  assert.deepEqual(flyingDelayedOutcome({ initialSneaking: false, currentSneaking: true, repGainTimer: 0 }), {
    discard: true, reputationDelta: 10, playHostileSound: false, nextRepGainTimer: 24000,
  });
  assert.deepEqual(flyingDelayedOutcome({ initialSneaking: true, currentSneaking: false, repGainTimer: 12 }), {
    discard: true, reputationDelta: 0, playHostileSound: false, nextRepGainTimer: 12,
  });
});

test("the player cooldown ticker decrements the flying reputation cooldown every tick", () => {
  assert.equal(flyingRepGainCooldownStep(2), 1);
  assert.equal(flyingRepGainCooldownStep(1), 0);
  assert.equal(flyingRepGainCooldownStep(0), 0);
});

test("flying proximity uses the source 70% damage branch and 1..9 damage range", () => {
  assert.deepEqual(flyingProximityOutcome({ branchRoll: 0.7, damageRoll: 0 }), {
    action: "summon_null_is_here",
  });
  assert.deepEqual(flyingProximityOutcome({ branchRoll: 0.699999, damageRoll: 0 }), {
    action: "damage", amount: 1,
  });
  assert.deepEqual(flyingProximityOutcome({ branchRoll: 0, damageRoll: 1 - Number.EPSILON }), {
    action: "damage", amount: 9,
  });
});

test("natural despawn is decrement-then-remove and survives a persisted timer", () => {
  assert.deepEqual(naturalDespawnStep(1, 3200), { timer: 0, discard: true });
  assert.deepEqual(naturalDespawnStep(2, 3200), { timer: 1, discard: false });
  assert.deepEqual(naturalDespawnStep(undefined, 3200), { timer: 3199, discard: false });
  assert.deepEqual(naturalDespawnStep(-1, 3200), { timer: -1, discard: false });
});

test("chunk remover source gates preserve strict probability and boundary checks", () => {
  assert.equal(CHUNK_REMOVER_SOURCE.spawnChance, 0.0001);
  const base = {
    difficultyPeaceful: false,
    spawnReason: "natural",
    belowBlockValid: true,
    doMobSpawning: true,
    isNullHere: true,
    disableSpawningEntities: false,
    dimensionId: "minecraft:overworld",
    disableChunkRemoval: false,
    spawnRoll: 0.0001,
    nearestPlayerDistance: 25,
    canSeeSkyFromBelowWater: true,
    arenaPhase: "phase2",
    flat: false,
    flatRoll: 0.5,
    blockLight: 0,
    modifiedChunkCount: 0,
  };
  assert.equal(chunkSpawnDecision(base).allowed, false, "the source rejects a player at the 25-block boundary");
  assert.equal(chunkSpawnDecision({ ...base, nearestPlayerDistance: 25.000001 }).allowed, true);
  assert.equal(chunkSpawnDecision({ ...base, spawnRoll: 0.000100001 }).allowed, false);
  assert.equal(chunkSpawnDecision({ ...base, blockLight: 1 }).allowed, false);
  assert.equal(chunkSpawnDecision({ ...base, modifiedChunkCount: 1 }).allowed, false);
  assert.equal(chunkSpawnDecision({ ...base, spawnReason: "spawner", belowBlockValid: false, nearestPlayerDistance: null }).allowed, true);
});

test("chunk remover chooses clear at rolls below .05 and otherwise moves by 16..128", () => {
  assert.deepEqual(chunkRemovalPlan({ actionRoll: 0.049999, offsetRoll: 0.99 }), { operation: "clear" });
  assert.deepEqual(chunkRemovalPlan({ actionRoll: 0.05, offsetRoll: 0 }), { operation: "move", offsetY: 16 });
  assert.deepEqual(chunkRemovalPlan({ actionRoll: 0.99, offsetRoll: 1 - Number.EPSILON }), { operation: "move", offsetY: 128 });
  assert.equal(chunkCoordinate(-0.5), 0, "Java casts before shifting; it is not floor division");
  assert.equal(chunkCoordinate(-16.5), -1);
});

test("chunk vertical surrogate moves sections top-down and clears sections leaving the build range", () => {
  assert.deepEqual(chunkVerticalMovePlan({ minY: 0, maxY: 64, offsetY: 32 }), [
    { sourceY: 48, destinationY: 80, operation: "clear" },
    { sourceY: 32, destinationY: 64, operation: "clear" },
    { sourceY: 16, destinationY: 48, operation: "move" },
    { sourceY: 0, destinationY: 32, operation: "move" },
  ]);
});

test("modified chunk ledger is dimension-safe, decrementing, and reloadable", () => {
  const ledger = createModifiedChunkLedger();
  ledger.record("minecraft:overworld", 0, 0, 1);
  ledger.record("minecraft:overworld", 0, 0, 1);
  ledger.record("thebrokenscript:limbo", 0, 0, 1);
  assert.equal(ledger.count("minecraft:overworld", 0, 0), 2);
  assert.equal(ledger.count("thebrokenscript:limbo", 0, 0), 1);
  ledger.record("minecraft:overworld", 0, 0, -1);
  assert.equal(ledger.count("minecraft:overworld", 0, 0), 1);
  ledger.record("minecraft:overworld", 0, 0, -1);
  assert.equal(ledger.count("minecraft:overworld", 0, 0), 0);
  const restored = createModifiedChunkLedger(ledger.serialize());
  assert.equal(restored.count("thebrokenscript:limbo", 0, 0), 1);
});
