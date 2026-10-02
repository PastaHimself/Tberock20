import assert from "node:assert/strict";
import test from "node:test";

import {
  PLAYER_LIFECYCLE_SOURCE,
  becomeVoidTransition,
  decrementPositiveTimer,
  shouldClearDespawnEntitySwitch,
  shouldClearSkipFallDamage,
  trueEndGameStep,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/player_lifecycle_model.js";

test("PlayerDataTicker timer boundaries decrement once and expire at zero", () => {
  assert.deepEqual(decrementPositiveTimer(2), { previous: 2, next: 1, expired: false });
  assert.deepEqual(decrementPositiveTimer(1), { previous: 1, next: 0, expired: true });
  assert.deepEqual(decrementPositiveTimer(0), { previous: 0, next: 0, expired: false });
});

test("PlayerDataTicker random and grounded reset predicates preserve strict source comparisons", () => {
  assert.equal(PLAYER_LIFECYCLE_SOURCE.despawnEntitySwitchClearChance, 0.001);
  assert.equal(shouldClearDespawnEntitySwitch(true, 0), true);
  assert.equal(shouldClearDespawnEntitySwitch(true, 0.000999), true);
  assert.equal(shouldClearDespawnEntitySwitch(true, 0.001), false);
  assert.equal(shouldClearDespawnEntitySwitch(false, 0), false);
  assert.equal(shouldClearSkipFallDamage(true, 120, false), true);
  assert.equal(shouldClearSkipFallDamage(true, 119, false), false);
  assert.equal(shouldClearSkipFallDamage(true, 120, true), false);
});

test("BecomeVoid exact dimension and Y boundaries match Java", () => {
  assert.equal(becomeVoidTransition({ dimensionId: "overworld", y: -78, moonStage: 0 }), null);
  assert.deepEqual(becomeVoidTransition({ dimensionId: "overworld", y: -78.01, moonStage: 0 }), {
    kind: "dimension", destination: "nowhere",
  });
  assert.deepEqual(becomeVoidTransition({ dimensionId: "minecraft:overworld", y: -90, moonStage: 1 }), {
    kind: "dimension", destination: "the_moon",
  });
  assert.equal(becomeVoidTransition({ dimensionId: "overworld", y: -90, moonStage: 1, fixPos: true }), null);

  assert.deepEqual(becomeVoidTransition({ dimensionId: "thebrokenscript:stage2", y: 4 }), {
    kind: "stage2_to_stage3", destination: "void_shadow",
  });
  assert.equal(becomeVoidTransition({ dimensionId: "stage2", y: 4.01 }), null);
  assert.equal(becomeVoidTransition({ dimensionId: "concrete", y: -85 }), null);
  assert.deepEqual(becomeVoidTransition({ dimensionId: "concrete", y: -85.01 }), {
    kind: "overworld_return", fellFromMoon: false, restoreBedAfterTicks: 5,
  });
  assert.equal(becomeVoidTransition({ dimensionId: "the_moon", y: -85 }), null);
  assert.deepEqual(becomeVoidTransition({ dimensionId: "the_moon", y: -86 }), {
    kind: "overworld_return", fellFromMoon: true, restoreBedAfterTicks: 0,
  });
  assert.equal(becomeVoidTransition({ dimensionId: "nowhere", y: -100 }), null);
  assert.deepEqual(becomeVoidTransition({ dimensionId: "nowhere", y: -101 }), {
    kind: "dimension", destination: "protected_void",
  });
});

test("BecomeVoid Clan Void bands retain strict inequalities", () => {
  assert.equal(becomeVoidTransition({ dimensionId: "clan_void", y: 98 }), null);
  assert.deepEqual(becomeVoidTransition({ dimensionId: "clan_void", y: 100 }), {
    kind: "clan_void_vertical", targetY: 550,
  });
  assert.equal(becomeVoidTransition({ dimensionId: "clan_void", y: 105 }), null);
  assert.deepEqual(becomeVoidTransition({ dimensionId: "clan_void", y: 250 }), { kind: "clan_void_floor_guard" });
  assert.deepEqual(becomeVoidTransition({ dimensionId: "clan_void", y: 230 }), { kind: "clan_void_floor_guard" });
});

test("TrueEndGame uses >10 first alert and exact tick 16 terminal action", () => {
  assert.deepEqual(trueEndGameStep({ shutdown: 10, nullEndgameNearby: true }), {
    shutdown: 11,
    spawnedShutdownWindow: true,
    showInitialAlert: true,
    showTerminalAlert: false,
    forceSurvival: false,
  });
  assert.deepEqual(trueEndGameStep({ shutdown: 15, spawnedShutdownWindow: true, nullEndgameNearby: true }), {
    shutdown: 16,
    spawnedShutdownWindow: true,
    showInitialAlert: false,
    showTerminalAlert: true,
    forceSurvival: true,
  });
  assert.deepEqual(trueEndGameStep({ shutdown: 16, spawnedShutdownWindow: true, nullEndgameNearby: false }), {
    shutdown: 16,
    spawnedShutdownWindow: true,
    showInitialAlert: false,
    showTerminalAlert: false,
    forceSurvival: false,
  });
});
