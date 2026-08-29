import assert from "node:assert/strict";
import test from "node:test";
import {
  FIREBALL_ATTACK_SOURCE,
  FIREBALL_BEDROCK_ADAPTER,
  PHASE3_ATTACK,
  fireballAttackStep,
  phase3AttackCooldown,
  phase3AttackLength,
  phase3ImplementedAttackCandidates,
  selectPhase3ImplementedAttack,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/phase3_attack_model.js";

test("FireballAttack source constants are preserved", () => {
  assert.deepEqual(FIREBALL_ATTACK_SOURCE, {
    attackCooldownTicks: 120,
    chance: 0.15,
    canMove: false,
    canUse: true,
    lengthTicks: 144,
    projectileSpeedBlocksPerTick: 1.6,
    projectileInaccuracy: 0,
    explosionPower: 5,
    entityHitDamage: 6,
    causesFire: false,
    breaksBlocks: false,
  });
});

test("implemented selector preserves Phase3Goals gates", () => {
  assert.deepEqual(phase3ImplementedAttackCandidates({ hasTarget: false, distance: 50 }), []);
  assert.deepEqual(phase3ImplementedAttackCandidates({ attackDelay: 1, distance: 50 }), []);
  assert.deepEqual(phase3ImplementedAttackCandidates({ stuck: true, distance: 50 }), []);
});

test("implemented selector keeps GroundAttack distance gate and Fireball global range", () => {
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 50 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.GROUND_ATTACK, PHASE3_ATTACK.FIREBALL],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 20 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.FIREBALL],
  );
});

test("implemented selector excludes the immediately previous attack", () => {
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 50, previousAttack: PHASE3_ATTACK.GROUND_ATTACK }),
    [{ type: PHASE3_ATTACK.FIREBALL, chance: 0.15 }],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 50, previousAttack: PHASE3_ATTACK.FIREBALL }),
    [{ type: PHASE3_ATTACK.GROUND_ATTACK, chance: 1 }],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 20, previousAttack: PHASE3_ATTACK.FIREBALL }),
    [],
  );
});

test("implemented selector uses Java weighted-choice semantics", () => {
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0 }), PHASE3_ATTACK.GROUND_ATTACK);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.8 }), PHASE3_ATTACK.GROUND_ATTACK);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.99 }), PHASE3_ATTACK.FIREBALL);
  assert.equal(
    selectPhase3ImplementedAttack({
      distance: 50,
      previousAttack: PHASE3_ATTACK.GROUND_ATTACK,
      randomFloat: 0,
    }),
    PHASE3_ATTACK.FIREBALL,
  );
});

test("attack lengths and cooldowns match implemented source attacks", () => {
  assert.equal(phase3AttackLength(PHASE3_ATTACK.GROUND_ATTACK), 175);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.GROUND_ATTACK, { stuck: true }), 260);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.FIREBALL), 144);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.GROUND_ATTACK), 70);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.FIREBALL), 120);
});

test("Bedrock Fireball adapter launches once and keeps source duration", () => {
  assert.equal(FIREBALL_BEDROCK_ADAPTER.runtimeStatus, "adapted_animation_keyframe");
  assert.equal(fireballAttackStep({ attackTicks: FIREBALL_BEDROCK_ADAPTER.launchTick }).launch, true);
  assert.equal(fireballAttackStep({ attackTicks: FIREBALL_BEDROCK_ADAPTER.launchTick, shotFireball: true }).launch, false);
  assert.equal(fireballAttackStep({ attackTicks: 143 }).finished, false);
  assert.equal(fireballAttackStep({ attackTicks: 144 }).finished, true);
});
