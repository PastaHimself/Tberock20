import test from "node:test";
import assert from "node:assert/strict";
import {
  FRACTURED_ROAM_SOURCE,
  fracturedRoamArenaPlan,
  fracturedRoamBaseTick,
  fracturedRoamDigEligibility,
  fracturedRoamDigGoalStart,
  fracturedRoamDigGoalStop,
  fracturedRoamDespawnStep,
  fracturedRoamServerTimerStep,
  fracturedRoamStrollDue,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_roam_model.js";

test("FracturedRoam preserves the source timers and arena constants", () => {
  assert.deepEqual(FRACTURED_ROAM_SOURCE, {
    serverTimerTicks: 149,
    riseTicks: 149,
    digAnimationTicks: 103,
    despawnAnimationTicks: 103,
    switchingTicks: 103,
    despawnTimerMinTicks: 18000,
    despawnTimerMaxTicks: 24000,
    undergroundTimerMinTicks: 300,
    undergroundTimerMaxExclusive: 400,
    digCooldownMinTicks: 400,
    digCooldownMaxExclusive: 800,
    navigationCooldownMinTicks: 60,
    navigationCooldownMaxExclusive: 120,
    navigationSpeedModifier: 0.4,
    randomStrollSpeedModifier: 0.6,
    randomStrollIntervalTicks: 45,
    digRoll: 1,
    digRollBound: 1000,
    arenaStartMusicTicks: 340,
    arenaSubAnomalyCount: 30,
    arenaPlayerRange: 150,
    arenaSubAnomalyRadius: 20,
  });
});

test("the Roam server timer enables AI only after the decrement reaches zero", () => {
  assert.deepEqual(fracturedRoamServerTimerStep(149), { timer: 148, enableAi: false });
  assert.deepEqual(fracturedRoamServerTimerStep(1), { timer: 0, enableAi: true });
  assert.deepEqual(fracturedRoamServerTimerStep(0), { timer: 0, enableAi: false });
});

test("BaseFracturedEntity rise, dig, and despawn states use decrement-then-transition", () => {
  assert.deepEqual(fracturedRoamBaseTick({ state: "RISING", riseTicks: 1 }), {
    state: "RISING",
    riseTicks: 0,
    digTicks: 103,
    despawnTicks: 103,
    discarded: false,
  });
  assert.deepEqual(fracturedRoamBaseTick({ state: "RISING", riseTicks: 0 }), {
    state: "NORMAL",
    riseTicks: 0,
    digTicks: 103,
    despawnTicks: 103,
    discarded: false,
  });
  assert.deepEqual(fracturedRoamBaseTick({ state: "DIGGING", digTicks: 0 }), {
    state: "UNDERGROUND",
    riseTicks: 149,
    digTicks: 0,
    despawnTicks: 103,
    discarded: false,
  });
  assert.deepEqual(fracturedRoamBaseTick({ state: "DESPAWNING", despawnTicks: 0 }), {
    state: "DESPAWNING",
    riseTicks: 149,
    digTicks: 103,
    despawnTicks: 0,
    discarded: true,
  });
});

test("the underground goal can start only on NORMAL with cooldown clear and roll one", () => {
  assert.equal(fracturedRoamDigEligibility({ state: "NORMAL", digCooldown: 0, roll: 1 }), true);
  assert.equal(fracturedRoamDigEligibility({ state: "RISING", digCooldown: 0, roll: 1 }), false);
  assert.equal(fracturedRoamDigEligibility({ state: "NORMAL", digCooldown: 1, roll: 1 }), false);
  assert.equal(fracturedRoamDigEligibility({ state: "NORMAL", digCooldown: 0, roll: 2 }), false);
  assert.deepEqual(fracturedRoamDigGoalStart(399), {
    state: "DIGGING",
    undergroundTimer: 399,
    digTicks: 103,
  });
  assert.deepEqual(fracturedRoamDigGoalStop(799), {
    state: "RISING",
    digCooldown: 799,
    riseTicks: 149,
  });
});

test("Roam despawn starts one tick after the random timer reaches zero", () => {
  assert.deepEqual(fracturedRoamDespawnStep({ state: "NORMAL", despawnTimer: 1 }), {
    state: "NORMAL",
    despawnTimer: 0,
  });
  assert.deepEqual(fracturedRoamDespawnStep({ state: "NORMAL", despawnTimer: 0 }), {
    state: "DESPAWNING",
    despawnTimer: 0,
  });
  assert.deepEqual(fracturedRoamDespawnStep({ state: "DIGGING", despawnTimer: 0 }), {
    state: "DIGGING",
    despawnTimer: 0,
  });
});

test("RandomStroll keeps the source 45-tick interval and Arena keeps the source schedule", () => {
  assert.equal(fracturedRoamStrollDue(0), true);
  assert.equal(fracturedRoamStrollDue(44), false);
  assert.equal(fracturedRoamStrollDue(45), true);
  assert.deepEqual(fracturedRoamArenaPlan(), {
    introSound: "thebrokenscript:jimbob.intro",
    loopSound: "thebrokenscript:jimbob.loop",
    startMusicTicks: 340,
    subAnomalyCount: 30,
    playerRange: 150,
