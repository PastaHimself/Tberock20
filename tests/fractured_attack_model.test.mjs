import test from "node:test";
import assert from "node:assert/strict";
import {
  FRACTURED_ATTACKS,
  FRACTURED_LIFECYCLE_SOURCE,
  FRACTURED_SOURCE,
  chooseFracturedAttack,
  fracturedAttackStep,
  fracturedDefeatStep,
  fracturedImpactPlan,
  fracturedRockBlockBurstPlan,
  fracturedRockImpactPlan,
  fracturedRockFlightStep,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_attack_model.js";

test("Jimmy constants preserve the recovered source timings and damage values", () => {
  assert.deepEqual(FRACTURED_LIFECYCLE_SOURCE, {
    initialAttackDelayTicks: 100,
    defeatAfterHits: 6,
    attackedCooldownTicks: 800,
  });
  assert.deepEqual(FRACTURED_ATTACKS, {
    noop: { lengthTicks: -1, chance: 0, canMove: true },
    stomp: { lengthTicks: 78, chance: 1, canMove: false },
    slam: { lengthTicks: 78, chance: 1, canMove: false },
    moonRockToss: { lengthTicks: 139, cooldownTicks: 20, chance: 1, canMove: false },
    airLift: { lengthTicks: 60, chance: 1, canMove: false },
  });
  assert.deepEqual(FRACTURED_SOURCE, {
    stomp: {
      offset: { x: 26.25, y: 0, z: -164.125 },
      triggerTick: 13,
      radius: 5,
      damage: 5,
      knockback: 2,
    },
    slam: { radius: 512, damage: 12, knockback: 30, groundedOnly: true },
    bigStomp: { radius: 64, damage: 12, knockback: 5, groundedOnly: true },
    rock: {
      damage: 15,
      throwSpeed: 8,
      throwInaccuracy: 0,
      blockImpactCleanupTicks: 1,
      hitboxInflation: 4,
      blockParticleBurst: {
        effectId: "thebrokenscript:moon_stone_block_burst",
        count: 400,
        offset: { x: 15, y: 7.5, z: 15 },
        initialVelocity: { x: 0, y: 2, z: 0 },
      },
      airLiftPulseDelayTicks: 25,
      airLiftPulseRadius: 32,
      airLiftPulseDamage: 12,
      airLiftPulseKnockback: 10,
    },
  });
});

test("selector accepts only NOOP after delay and uses source equal weights", () => {
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 1, targetPresent: true, roll: 0.1 }), null);
  assert.equal(chooseFracturedAttack({ currentAttack: "stomp", attackDelay: 0, targetPresent: true, roll: 0.1 }), null);
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: false, roll: 0.1 }), null);
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0 }), "stomp");
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0.249999 }), "stomp");
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0.25 }), "stomp");
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0.250001 }), "slam");
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0.5 }), "slam");
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0.500001 }), "moonRockToss");
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0.75 }), "moonRockToss");
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0.750001 }), "airLift");
  assert.equal(chooseFracturedAttack({ currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0.999999 }), "airLift");
});

test("attack step increments and finishes at the source length", () => {
  assert.deepEqual(fracturedAttackStep({ attack: "stomp", attackTicks: 12, attackDelay: 0 }), {
    attackTicks: 13,
    finished: false,
    nextAttack: "stomp",
    nextAttackDelay: 0,
  });
  assert.deepEqual(fracturedAttackStep({ attack: "stomp", attackTicks: 77, attackDelay: 0 }), {
    attackTicks: 0,
    finished: true,
    nextAttack: "noop",
    nextAttackDelay: 0,
  });
  assert.deepEqual(fracturedAttackStep({ attack: "moonRockToss", attackTicks: 138, attackDelay: 0 }), {
    attackTicks: 0,
    finished: true,
    nextAttack: "noop",
    nextAttackDelay: 20,
  });
});

test("stomp trigger uses the source transform and impact values", () => {
  assert.deepEqual(fracturedImpactPlan("stomp"), {
    attack: "stomp",
    radius: 5,
    damage: 5,
    knockback: 2,
    triggerTick: 13,
    groundedOnly: false,
  });
  assert.deepEqual(fracturedImpactPlan("slam"), {
    attack: "slam",
    radius: 512,
    damage: 12,
    knockback: 30,
    groundedOnly: true,
  });
  assert.deepEqual(fracturedImpactPlan("bigStomp"), {
    attack: "bigStomp",
    radius: 64,
    damage: 12,
    knockback: 5,
    groundedOnly: true,
  });
});

test("rock throw and air-lift plans retain source damage and timing", () => {
  assert.deepEqual(fracturedImpactPlan("moonRockToss"), {
    attack: "moonRockToss",
    lengthTicks: 139,
    cooldownTicks: 20,
    damage: 15,
    speed: 8,
    inaccuracy: 0,
    targetYInterpolation: 0.5,
  });
  assert.deepEqual(fracturedImpactPlan("airLift"), {
    attack: "airLift",
    lengthTicks: 60,
    rockDamage: 15,
    speed: 0,
    inaccuracy: 0,
    pulseDelayTicks: 25,
    pulseRadius: 32,
    pulseDamage: 12,
    pulseKnockback: 10,
    groundedOnly: true,
  });
});

test("rock block impact preserves the source moon-stone particle burst", () => {
  assert.deepEqual(FRACTURED_SOURCE.rock.blockParticleBurst, {
    effectId: "thebrokenscript:moon_stone_block_burst",
    count: 400,
    offset: { x: 15, y: 7.5, z: 15 },
    initialVelocity: { x: 0, y: 2, z: 0 },
  });
  assert.deepEqual(fracturedRockBlockBurstPlan({ x: 1, y: 2, z: 3 }), {
    effectId: "thebrokenscript:moon_stone_block_burst",
    count: 400,
    origin: { x: 1, y: 2, z: 3 },
    offset: { x: 15, y: 7.5, z: 15 },
    initialVelocity: { x: 0, y: 2, z: 0 },
  });
});

test("rock impact excludes the owner and damages an inflated living hitbox once", () => {
  assert.deepEqual(fracturedRockImpactPlan({ owner: false, living: true, intersects: true }), {
    applyDamage: true,
    damage: 15,
    hitboxInflation: 4,
    remove: true,
    excludeOwner: true,
  });
  assert.equal(fracturedRockImpactPlan({ owner: true, living: true, intersects: true }).applyDamage, false);
  assert.equal(fracturedRockImpactPlan({ owner: false, living: false, intersects: true }).applyDamage, false);
  assert.equal(fracturedRockImpactPlan({ owner: false, living: true, intersects: false }).applyDamage, false);
});

test("rock flight uses a source speed and block cleanup boundary", () => {
  assert.deepEqual(fracturedRockFlightStep({ position: { x: 0, y: 0, z: 0 }, direction: { x: 0, y: 1, z: 0 }, blocked: false }), {
    position: { x: 0, y: 8, z: 0 },
    remove: false,
    grounded: false,
  });
  assert.deepEqual(fracturedRockFlightStep({ position: { x: 1, y: 2, z: 3 }, direction: { x: 1, y: 0, z: 0 }, blocked: true }), {
    position: { x: 1, y: 2, z: 3 },
    remove: false,
    grounded: true,
    cleanupTicks: 1,
  });
  assert.deepEqual(fracturedRockFlightStep({ position: { x: 1, y: 2, z: 3 }, direction: null, blocked: true, grounded: true, groundedTicks: 1 }), {
    position: { x: 1, y: 2, z: 3 },
    remove: true,
    grounded: true,
  });
});

test("Jimmy becomes defeated at the sixth accepted hit", () => {
  assert.deepEqual(fracturedDefeatStep({ timesAttacked: 5, attackedCooldown: 0, accepted: true }), {
    timesAttacked: 6,
    attackedCooldown: 800,
    defeated: true,
  });
  assert.deepEqual(fracturedDefeatStep({ timesAttacked: 5, attackedCooldown: 10, accepted: true }), {
    timesAttacked: 5,
    attackedCooldown: 9,
    defeated: false,
  });
  assert.deepEqual(fracturedDefeatStep({ timesAttacked: 6, attackedCooldown: 0, accepted: false }), {
    timesAttacked: 6,
    attackedCooldown: 0,
    defeated: true,
  });
});
