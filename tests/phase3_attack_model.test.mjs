import assert from "node:assert/strict";
import test from "node:test";
import {
  FIREBALL_ATTACK_SOURCE,
  FIREBALL_BEDROCK_ADAPTER,
  GRAVITY_ATTACK_SOURCE,
  GRAVITY_BEDROCK_ADAPTER,
  PHASE3_ATTACK,
  TENTACLE_SWIPE_BEDROCK_ADAPTER,
  TENTACLE_SWIPE_SOURCE,
  fireballAttackStep,
  gravityAttackStep,
  phase3AttackCooldown,
  phase3AttackLength,
  phase3ImplementedAttackCandidates,
  selectPhase3ImplementedAttack,
  tentacleSwipeCenter,
  tentacleSwipeImpactPlan,
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

test("TentacleSwipeAttack source constants are preserved", () => {
  assert.deepEqual(TENTACLE_SWIPE_SOURCE, {
    attackCooldownTicks: 100,
    chance: 0.15,
    canMove: false,
    canUse: true,
    lengthTicks: 40,
    hitTick: 9,
    aoeRadius: 14,
    damage: 5,
    knockbackStrength: 2,
    offsetScale: 0.125,
    offsetPosition: { x: -291.5252, y: 400.7372, z: 5.4492 },
  });
  assert.equal(TENTACLE_SWIPE_BEDROCK_ADAPTER.runtimeStatus, "adapted_knockback_api");
});

test("GravityAttack source constants and Bedrock adapter are explicit", () => {
  assert.deepEqual(GRAVITY_ATTACK_SOURCE, {
    attackCooldownTicks: 100,
    chance: 0.45,
    canMove: false,
    canUse: true,
    lengthTicks: 180,
    distanceRange: [0, 45],
    inverseGravityStrength: -0.0125,
    stage3Dimension: "thebrokenscript:void_shadow",
  });
  assert.equal(GRAVITY_BEDROCK_ADAPTER.runtimeStatus, "adapted_default_gravity");
  assert.equal(GRAVITY_BEDROCK_ADAPTER.upwardImpulsePerTick, -GRAVITY_ATTACK_SOURCE.inverseGravityStrength);
});

test("implemented selector preserves Phase3Goals gates", () => {
  assert.deepEqual(phase3ImplementedAttackCandidates({ hasTarget: false, distance: 50 }), []);
  assert.deepEqual(phase3ImplementedAttackCandidates({ attackDelay: 1, distance: 50 }), []);
  assert.deepEqual(phase3ImplementedAttackCandidates({ stuck: true, distance: 50 }), []);
});

test("implemented selector preserves per-attack ranges", () => {
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 50 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.GROUND_ATTACK, PHASE3_ATTACK.FIREBALL, PHASE3_ATTACK.TENTACLE_SWIPE],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 20 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.FIREBALL, PHASE3_ATTACK.TENTACLE_SWIPE, PHASE3_ATTACK.GRAVITY],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 45 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.GROUND_ATTACK, PHASE3_ATTACK.FIREBALL, PHASE3_ATTACK.TENTACLE_SWIPE, PHASE3_ATTACK.GRAVITY],
  );
});

test("implemented selector excludes the immediately previous attack", () => {
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 50, previousAttack: PHASE3_ATTACK.GROUND_ATTACK }),
    [
      { type: PHASE3_ATTACK.FIREBALL, chance: 0.15 },
      { type: PHASE3_ATTACK.TENTACLE_SWIPE, chance: 0.15 },
    ],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 20, previousAttack: PHASE3_ATTACK.FIREBALL }),
    [
      { type: PHASE3_ATTACK.TENTACLE_SWIPE, chance: 0.15 },
      { type: PHASE3_ATTACK.GRAVITY, chance: 0.45 },
    ],
  );
});

test("implemented selector uses Java weighted-choice semantics", () => {
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0 }), PHASE3_ATTACK.GROUND_ATTACK);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.7 }), PHASE3_ATTACK.GROUND_ATTACK);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.8 }), PHASE3_ATTACK.FIREBALL);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.95 }), PHASE3_ATTACK.TENTACLE_SWIPE);
  assert.equal(selectPhase3ImplementedAttack({ distance: 20, randomFloat: 0.5 }), PHASE3_ATTACK.GRAVITY);
});

test("attack lengths and cooldowns match implemented source attacks", () => {
  assert.equal(phase3AttackLength(PHASE3_ATTACK.GROUND_ATTACK), 175);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.GROUND_ATTACK, { stuck: true }), 260);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.FIREBALL), 144);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.TENTACLE_SWIPE), 40);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.GRAVITY), 180);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.GROUND_ATTACK), 70);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.FIREBALL), 120);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.TENTACLE_SWIPE), 100);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.GRAVITY), 100);
});

test("Bedrock Fireball adapter launches once and keeps source duration", () => {
  assert.equal(FIREBALL_BEDROCK_ADAPTER.runtimeStatus, "adapted_animation_keyframe");
  assert.equal(fireballAttackStep({ attackTicks: FIREBALL_BEDROCK_ADAPTER.launchTick }).launch, true);
  assert.equal(fireballAttackStep({ attackTicks: FIREBALL_BEDROCK_ADAPTER.launchTick, shotFireball: true }).launch, false);
  assert.equal(fireballAttackStep({ attackTicks: 143 }).finished, false);
  assert.equal(fireballAttackStep({ attackTicks: 144 }).finished, true);
});

test("TentacleSwipe center and impact plan retain source transform and hit rules", () => {
  const center = tentacleSwipeCenter({ position: { x: 10, y: 20, z: 30 }, yawDegrees: 0 });
  assert.ok(Math.abs(center.x - 46.44065) < 1e-6);
  assert.ok(Math.abs(center.y - 70.09215) < 1e-6);
  assert.ok(Math.abs(center.z - 29.31885) < 1e-6);

  const impacts = tentacleSwipeImpactPlan({
    center: { x: 0, y: 0, z: 0 },
    players: [
      { id: "hit", position: { x: 3, y: 4, z: 0 } },
      { id: "miss", position: { x: 15, y: 0, z: 0 } },
    ],
  });
  assert.equal(impacts.length, 1);
  assert.equal(impacts[0].id, "hit");
  assert.equal(impacts[0].damage, 5);
  assert.ok(Math.abs(impacts[0].bedrockHorizontalForce.x + 2) < 1e-9);
  assert.equal(impacts[0].bedrockVerticalStrength, 0.4);
});

test("Gravity attack flips for its active source duration", () => {
  assert.equal(gravityAttackStep({ attackTicks: 0 }).flipGravity, false);
  assert.equal(gravityAttackStep({ attackTicks: 1 }).flipGravity, true);
  assert.equal(gravityAttackStep({ attackTicks: 179 }).finished, false);
  assert.equal(gravityAttackStep({ attackTicks: 180 }).flipGravity, true);
  assert.equal(gravityAttackStep({ attackTicks: 180 }).finished, true);
  assert.equal(gravityAttackStep({ attackTicks: 181 }).flipGravity, false);
});
