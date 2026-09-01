import assert from "node:assert/strict";
import test from "node:test";
import {
  FIREBALL_ATTACK_SOURCE,
  FIREBALL_BEDROCK_ADAPTER,
  GRAVITY_ATTACK_SOURCE,
  GRAVITY_BEDROCK_ADAPTER,
  PHASE3_ATTACK,
  TENTACLES_ATTACK_SOURCE,
  TENTACLES_BEDROCK_ADAPTER,
  TENTACLE_SWIPE_BEDROCK_ADAPTER,
  TENTACLE_SWIPE_SOURCE,
  fireballAttackStep,
  gravityAttackStep,
  phase3AttackCooldown,
  phase3AttackLength,
  phase3ImplementedAttackCandidates,
  selectPhase3ImplementedAttack,
  tentaclesAttackCanUse,
  tentaclesAttackImpactPlan,
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
    attackCooldownTicks: 140,
    chance: 0.15,
    canMove: false,
    canUse: true,
    lengthTicks: 240,
    distanceRange: [-Infinity, Infinity],
    particlesPerTick: 20,
    particleSpreadXZ: 5,
    particleVelocity: { x: 0, y: 2, z: 0 },
    particleBlock: "thebrokenscript:intense_projection",
    inverseGravityStrength: -0.0125,
    stage3Dimension: "thebrokenscript:void_shadow",
  });
  assert.equal(GRAVITY_BEDROCK_ADAPTER.runtimeStatus, "adapted_default_gravity");
  assert.equal(GRAVITY_BEDROCK_ADAPTER.upwardImpulsePerTick, -GRAVITY_ATTACK_SOURCE.inverseGravityStrength);
  assert.equal(GRAVITY_BEDROCK_ADAPTER.particleRuntimeStatus, "blocked_block_particle_equivalent");
});

test("TentaclesAttack source constants and custom-damage adaptation are explicit", () => {
  assert.equal(TENTACLES_ATTACK_SOURCE.attackCooldownTicks, 55);
  assert.equal(TENTACLES_ATTACK_SOURCE.chance, 0.9);
  assert.equal(TENTACLES_ATTACK_SOURCE.lengthTicks, 144);
  assert.deepEqual(TENTACLES_ATTACK_SOURCE.distanceRange, [10, 20]);
  assert.equal(TENTACLES_ATTACK_SOURCE.firstPulseSourceTimer, 65);
  assert.equal(TENTACLES_ATTACK_SOURCE.firstPulseAttackTick, 66);
  assert.equal(TENTACLES_ATTACK_SOURCE.firstPulseDamage, 7.5);
  assert.equal(TENTACLES_ATTACK_SOURCE.secondPulseSourceTimer, 80);
  assert.equal(TENTACLES_ATTACK_SOURCE.secondPulseAttackTick, 81);
  assert.equal(TENTACLES_ATTACK_SOURCE.secondPulseDamage, 5);
  assert.equal(TENTACLES_BEDROCK_ADAPTER.runtimeStatus, "adapted_custom_damage_type");
});

test("implemented selector preserves Phase3Goals gates", () => {
  assert.deepEqual(phase3ImplementedAttackCandidates({ hasTarget: false, distance: 50 }), []);
  assert.deepEqual(phase3ImplementedAttackCandidates({ attackDelay: 1, distance: 50 }), []);
  assert.deepEqual(phase3ImplementedAttackCandidates({ stuck: true, distance: 50 }), []);
});

test("implemented selector preserves per-attack ranges", () => {
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 50 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.GROUND_ATTACK, PHASE3_ATTACK.FIREBALL, PHASE3_ATTACK.TENTACLE_SWIPE, PHASE3_ATTACK.GRAVITY],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 20 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.FIREBALL, PHASE3_ATTACK.TENTACLE_SWIPE, PHASE3_ATTACK.GRAVITY],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 45 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.GROUND_ATTACK, PHASE3_ATTACK.FIREBALL, PHASE3_ATTACK.TENTACLE_SWIPE, PHASE3_ATTACK.GRAVITY],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 15, tentaclesUsable: true }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.FIREBALL, PHASE3_ATTACK.TENTACLE_SWIPE, PHASE3_ATTACK.GRAVITY, PHASE3_ATTACK.TENTACLES],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 1000 }).map((candidate) => candidate.type),
    [PHASE3_ATTACK.FIREBALL, PHASE3_ATTACK.TENTACLE_SWIPE, PHASE3_ATTACK.GRAVITY],
  );
});

test("implemented selector excludes the immediately previous attack", () => {
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 50, previousAttack: PHASE3_ATTACK.GROUND_ATTACK }),
    [
      { type: PHASE3_ATTACK.FIREBALL, chance: 0.15 },
      { type: PHASE3_ATTACK.TENTACLE_SWIPE, chance: 0.15 },
      { type: PHASE3_ATTACK.GRAVITY, chance: 0.15 },
    ],
  );
  assert.deepEqual(
    phase3ImplementedAttackCandidates({ distance: 20, previousAttack: PHASE3_ATTACK.FIREBALL }),
    [
      { type: PHASE3_ATTACK.TENTACLE_SWIPE, chance: 0.15 },
      { type: PHASE3_ATTACK.GRAVITY, chance: 0.15 },
    ],
  );
  assert.equal(
    phase3ImplementedAttackCandidates({
      distance: 15,
      tentaclesUsable: true,
      previousAttack: PHASE3_ATTACK.TENTACLES,
    }).some((candidate) => candidate.type === PHASE3_ATTACK.TENTACLES),
    false,
  );
});

test("implemented selector uses Java weighted-choice semantics", () => {
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0 }), PHASE3_ATTACK.GROUND_ATTACK);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.68 }), PHASE3_ATTACK.GROUND_ATTACK);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.7 }), PHASE3_ATTACK.FIREBALL);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.8 }), PHASE3_ATTACK.TENTACLE_SWIPE);
  assert.equal(selectPhase3ImplementedAttack({ distance: 50, randomFloat: 0.9 }), PHASE3_ATTACK.GRAVITY);
  assert.equal(selectPhase3ImplementedAttack({ distance: 20, randomFloat: 0.5 }), PHASE3_ATTACK.TENTACLE_SWIPE);
  assert.equal(selectPhase3ImplementedAttack({ distance: 20, randomFloat: 0.8 }), PHASE3_ATTACK.GRAVITY);
  assert.equal(
    selectPhase3ImplementedAttack({ distance: 15, tentaclesUsable: true, randomFloat: 0.6 }),
    PHASE3_ATTACK.TENTACLES,
  );
});

test("attack lengths and cooldowns match implemented source attacks", () => {
  assert.equal(phase3AttackLength(PHASE3_ATTACK.GROUND_ATTACK), 175);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.GROUND_ATTACK, { stuck: true }), 260);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.FIREBALL), 144);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.TENTACLE_SWIPE), 40);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.GRAVITY), 240);
  assert.equal(phase3AttackLength(PHASE3_ATTACK.TENTACLES), 144);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.GROUND_ATTACK), 70);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.FIREBALL), 120);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.TENTACLE_SWIPE), 100);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.GRAVITY), 140);
  assert.equal(phase3AttackCooldown(PHASE3_ATTACK.TENTACLES), 55);
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
  assert.equal(gravityAttackStep({ attackTicks: 239 }).finished, false);
  assert.equal(gravityAttackStep({ attackTicks: 240 }).flipGravity, true);
  assert.equal(gravityAttackStep({ attackTicks: 240 }).finished, true);
  assert.equal(gravityAttackStep({ attackTicks: 241 }).flipGravity, false);
});

test("TentaclesAttack canUse matches the source vertical player gate", () => {
  assert.equal(tentaclesAttackCanUse({ hasTarget: false, players: [{ distance: 10, verticalOffset: 1 }] }), false);
  assert.equal(tentaclesAttackCanUse({ players: [{ distance: 35, verticalOffset: 1.5 }] }), true);
  assert.equal(tentaclesAttackCanUse({ players: [{ distance: 35, verticalOffset: 1.5001 }] }), false);
  assert.equal(tentaclesAttackCanUse({ players: [{ distance: 35.01, verticalOffset: 1 }] }), false);
});

test("TentaclesAttack first pulse preserves vertical, annulus, damage, and impulse rules", () => {
  assert.deepEqual(tentaclesAttackImpactPlan({ attackTicks: 65, players: [] }), []);
  const impacts = tentaclesAttackImpactPlan({
    attackTicks: 66,
    players: [
      { id: "too-close", distance: 8, verticalOffset: 1, dx: 8, dz: 0, onGround: true },
      { id: "knock", distance: 9, verticalOffset: 1, dx: 9, dz: 0, onGround: true },
      { id: "damage", distance: 20, verticalOffset: 1, dx: 20, dz: 0, onGround: true },
      { id: "high", distance: 9, verticalOffset: 2, dx: 9, dz: 0, onGround: true },
      { id: "far", distance: 26, verticalOffset: 1, dx: 26, dz: 0, onGround: true },
    ],
  });
  assert.deepEqual(impacts.map((impact) => impact.id), ["knock", "damage"]);
  assert.equal(impacts[0].damage, 7.5);
  assert.deepEqual(impacts[0].impulse, { x: 2.3, y: 1.15, z: 0 });
  assert.equal(impacts[1].damage, 7.5);
  assert.equal(impacts[1].impulse, null);
});

test("TentaclesAttack second pulse damages 35-block range and only launches grounded close players", () => {
  const impacts = tentaclesAttackImpactPlan({
    attackTicks: 81,
    players: [
      { id: "ground", distance: 9, verticalOffset: -5, dx: 9, dz: 0, onGround: true },
      { id: "air", distance: 9, verticalOffset: 8, dx: 9, dz: 0, onGround: false },
      { id: "far", distance: 34, verticalOffset: 20, dx: 34, dz: 0, onGround: true },
      { id: "outside", distance: 36, verticalOffset: 0, dx: 36, dz: 0, onGround: true },
    ],
  });
  assert.deepEqual(impacts.map((impact) => impact.id), ["ground", "air", "far"]);
  assert.equal(impacts[0].damage, 5);
  assert.deepEqual(impacts[0].impulse, { x: 1.25, y: 0.95, z: 0 });
  assert.equal(impacts[1].impulse, null);
  assert.equal(impacts[2].impulse, null);
});
