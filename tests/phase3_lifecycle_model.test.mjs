import test from "node:test";
import assert from "node:assert/strict";
import {
  PHASE3_LIFECYCLE_SOURCE,
  phase3DamagePlan,
  phase3DeathStep,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/phase3_attack_model.js";

test("Phase 3 lifecycle constants retain the Java defaults", () => {
  assert.deepEqual(PHASE3_LIFECYCLE_SOURCE, {
    initialAttackDelayTicks: 100,
    normalHurtFrameWindowTicks: 30,
    stuckHurtFrameWindowTicks: 10,
    maceParryWindowTicks: 80,
    idleStuckTimeoutTicks: 100,
    deathCleanupDelayTicks: 298,
  });
});

test("player damage is capped and starts the normal hurt-frame window", () => {
  assert.deepEqual(phase3DamagePlan({
    sourceKind: "player",
    incomingAmount: 40,
    stuck: false,
  }), {
    apply: true,
    amount: 10,
    beginDeath: false,
    hurtFrames: 30,
    setMaceParryCooldown: false,
    parryMace: false,
  });
});

test("stuck player damage is tripled, capped at 40, and uses ten hurt frames", () => {
  assert.deepEqual(phase3DamagePlan({
    sourceKind: "player",
    incomingAmount: 20,
    stuck: true,
  }), {
    apply: true,
    amount: 40,
    beginDeath: false,
    hurtFrames: 10,
    setMaceParryCooldown: false,
    parryMace: false,
  });
});

test("fireball damage is fixed at 50 and follows the stuck frame window", () => {
  assert.deepEqual(phase3DamagePlan({
    sourceKind: "integ_fireball",
    incomingAmount: 1,
    stuck: true,
  }), {
    apply: true,
    amount: 50,
    beginDeath: false,
    hurtFrames: 10,
    setMaceParryCooldown: false,
    parryMace: false,
  });
});

test("non-player damage is rejected unless it is the Integrity fireball", () => {
  assert.deepEqual(phase3DamagePlan({
    sourceKind: "mob",
    incomingAmount: 100,
  }), {
    apply: false,
    amount: 0,
    beginDeath: false,
    hurtFrames: 0,
    setMaceParryCooldown: false,
    parryMace: false,
  });
});

test("void and kill causes begin the delayed death lifecycle", () => {
  for (const sourceKind of ["void", "self_destruct", "generic_kill"]) {
    assert.deepEqual(phase3DamagePlan({ sourceKind }), {
      apply: false,
      amount: 0,
      beginDeath: true,
      hurtFrames: 0,
      setMaceParryCooldown: false,
      parryMace: false,
    });
  }
});

test("hurt frames and dying state reject new damage", () => {
  assert.equal(phase3DamagePlan({
    sourceKind: "player",
    incomingAmount: 10,
    hurtFrames: 1,
  }).apply, false);
  assert.equal(phase3DamagePlan({
    sourceKind: "player",
    incomingAmount: 10,
    dying: true,
  }).apply, false);
});

test("mace smash is parried during the cooldown window", () => {
  assert.deepEqual(phase3DamagePlan({
    sourceKind: "player",
    incomingAmount: 20,
    maceAttack: true,
    maceParryCooldown: 1,
  }), {
    apply: false,
    amount: 0,
    beginDeath: false,
    hurtFrames: 0,
    setMaceParryCooldown: false,
    parryMace: true,
  });
});

test("lethal accepted damage enters the delayed death path", () => {
  assert.deepEqual(phase3DamagePlan({
    sourceKind: "integ_fireball",
    targetHealth: 50,
  }), {
    apply: true,
    amount: 50,
    beginDeath: true,
    hurtFrames: 30,
    setMaceParryCooldown: false,
    parryMace: false,
  });
});

test("death cleanup occurs at the source-backed 298-tick boundary", () => {
  assert.deepEqual(phase3DeathStep({ dying: true, deathTicks: 297 }), {
    dying: true,
    deathTicks: 298,
    remove: true,
  });
  assert.deepEqual(phase3DeathStep({ dying: true, deathTicks: 296 }), {
    dying: true,
    deathTicks: 297,
    remove: false,
  });
  assert.deepEqual(phase3DeathStep({ dying: false, deathTicks: 0 }), {
    dying: false,
    deathTicks: 0,
    remove: false,
  });
});
