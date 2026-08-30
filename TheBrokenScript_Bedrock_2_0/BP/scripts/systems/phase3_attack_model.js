// Pure, source-backed Integrity Phase 3 attack-selection semantics.
// Keep this module free of @minecraft/server imports so CI can verify parity.

import { GROUND_ATTACK_SOURCE, groundAttackCanUse } from "./integrity_arena_model.js";

export const PHASE3_ATTACK = Object.freeze({
  NOOP: "NOOP",
  GROUND_ATTACK: "GROUND_ATTACK",
  FIREBALL: "FIREBALL",
  TENTACLE_SWIPE: "TENTACLE_SWIPE",
  GRAVITY: "GRAVITY",
  TENTACLES: "TENTACLES",
});

export const FIREBALL_ATTACK_SOURCE = Object.freeze({
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

// GeckoLib fires the Java projectile from the `ballin;` custom keyframe using
// the world position of model bone `righttendrils5`. Bedrock server Script API
// does not expose that client-model bone position. This adapter deliberately
// isolates the approximation instead of presenting it as source-exact data.
export const FIREBALL_BEDROCK_ADAPTER = Object.freeze({
  runtimeStatus: "adapted_animation_keyframe",
  launchTick: 1,
  muzzleHeightFromFeet: 16,
  playerTargetCenterHeight: 0.9,
  collisionRadius: 1,
  maxLifetimeTicks: 200,
});

export const TENTACLE_SWIPE_SOURCE = Object.freeze({
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
  offsetPosition: Object.freeze({ x: -291.5252, y: 400.7372, z: 5.4492 }),
});

// Java LivingEntity.knockback applies horizontal knockback through engine
// velocity logic (including its grounded vertical nudge). Bedrock exposes a
// different API, so preserve the source horizontal strength and isolate the
// vanilla Java vertical cap as an adapter value.
export const TENTACLE_SWIPE_BEDROCK_ADAPTER = Object.freeze({
  runtimeStatus: "adapted_knockback_api",
  verticalStrength: 0.4,
});

export const GRAVITY_ATTACK_SOURCE = Object.freeze({
  attackCooldownTicks: 140,
  chance: 0.15,
  canMove: false,
  canUse: true,
  lengthTicks: 240,
  // Attack.kt's inherited MIN_VALUE..MAX_VALUE range is special-cased by
  // Phase3Goals as unbounded, so model that semantic directly in JavaScript.
  distanceRange: Object.freeze([Number.NEGATIVE_INFINITY, Number.POSITIVE_INFINITY]),
  particlesPerTick: 20,
  particleSpreadXZ: 5,
  particleVelocity: Object.freeze({ x: 0, y: 2, z: 0 }),
  particleBlock: "thebrokenscript:intense_projection",
  inverseGravityStrength: -0.0125,
  stage3Dimension: "thebrokenscript:void_shadow",
});

// Java replaces LivingEntity#getDefaultGravity for Stage 3 players. Bedrock
// cannot replace a player's gravity scalar, so the runtime applies the
// equivalent upward velocity increment once per tick while GravityAttack is
// active. Keep that substitution explicit and separately testable.
export const GRAVITY_BEDROCK_ADAPTER = Object.freeze({
  runtimeStatus: "adapted_default_gravity",
  upwardImpulsePerTick: 0.0125,
  particleRuntimeStatus: "blocked_block_particle_equivalent",
});

export const TENTACLES_ATTACK_SOURCE = Object.freeze({
  attackCooldownTicks: 55,
  chance: 0.9,
  canMove: false,
  lengthTicks: 144,
  distanceRange: Object.freeze([10, 20]),
  canUseSearchRadius: 35,
  canUseMinVerticalOffset: 0,
  canUseMaxVerticalOffset: 1.5,
  setupStuck: true,
  firstPulseSourceTimer: 65,
  firstPulseAttackTick: 66,
  firstPulseRadius: 25,
  firstPulseMinDistanceExclusive: 8,
  firstPulseDamage: 7.5,
  firstPulseKnockbackMaxDistanceExclusive: 10,
  firstPulseHorizontalKnockback: 2.3,
  firstPulseUpwardKnockback: 1.15,
  secondPulseSourceTimer: 80,
  secondPulseAttackTick: 81,
  secondPulseRadius: 35,
  secondPulseDamage: 5,
  secondPulseKnockbackMaxDistanceExclusive: 10,
  secondPulseHorizontalKnockback: 1.25,
  secondPulseUpwardKnockback: 0.95,
  secondPulseKnockbackRequiresOnGround: true,
});

// TBSDamageTypes.INTEGRITY_SHIELD_BYPASS is a custom Java damage type. Bedrock
// Script API does not expose a custom damage-type registration path equivalent
// to that source hook, so the runtime uses an entity-attack damage source while
// preserving source timing, amounts, radii, and impulses.
export const TENTACLES_BEDROCK_ADAPTER = Object.freeze({
  runtimeStatus: "adapted_custom_damage_type",
  damageCause: "entityAttack",
});

function withinDistanceRange(distance, range) {
  return Number.isFinite(distance)
    && distance >= range[0]
    && distance <= range[1];
}

export function tentaclesAttackCanUse({ hasTarget = true, players = [] } = {}) {
  if (!hasTarget) return false;
  return players.some((player) => (
    Number.isFinite(player.distance)
    && player.distance <= TENTACLES_ATTACK_SOURCE.canUseSearchRadius
    && Number.isFinite(player.verticalOffset)
    && player.verticalOffset >= TENTACLES_ATTACK_SOURCE.canUseMinVerticalOffset
    && player.verticalOffset <= TENTACLES_ATTACK_SOURCE.canUseMaxVerticalOffset
  ));
}

export function phase3ImplementedAttackCandidates({
  hasTarget = true,
  attackDelay = 0,
  stuck = false,
  distance = Number.NaN,
  previousAttack = null,
  tentaclesUsable = false,
} = {}) {
  if (!hasTarget || attackDelay > 0 || stuck) return [];

  const candidates = [];
  if (
    previousAttack !== PHASE3_ATTACK.GROUND_ATTACK
    && groundAttackCanUse({ distance, previousAttack })
  ) {
    candidates.push({
      type: PHASE3_ATTACK.GROUND_ATTACK,
      chance: GROUND_ATTACK_SOURCE.chance,
    });
  }

  if (previousAttack !== PHASE3_ATTACK.FIREBALL) {
    candidates.push({
      type: PHASE3_ATTACK.FIREBALL,
      chance: FIREBALL_ATTACK_SOURCE.chance,
    });
  }

  if (previousAttack !== PHASE3_ATTACK.TENTACLE_SWIPE) {
    candidates.push({
      type: PHASE3_ATTACK.TENTACLE_SWIPE,
      chance: TENTACLE_SWIPE_SOURCE.chance,
    });
  }

  if (
    previousAttack !== PHASE3_ATTACK.GRAVITY
    && withinDistanceRange(distance, GRAVITY_ATTACK_SOURCE.distanceRange)
  ) {
    candidates.push({
      type: PHASE3_ATTACK.GRAVITY,
      chance: GRAVITY_ATTACK_SOURCE.chance,
    });
  }

  if (
    previousAttack !== PHASE3_ATTACK.TENTACLES
    && tentaclesUsable
    && withinDistanceRange(distance, TENTACLES_ATTACK_SOURCE.distanceRange)
  ) {
    candidates.push({
      type: PHASE3_ATTACK.TENTACLES,
      chance: TENTACLES_ATTACK_SOURCE.chance,
    });
  }
  return candidates;
}

export function selectPhase3ImplementedAttack({ randomFloat = 0, ...state } = {}) {
  if (!Number.isFinite(randomFloat) || randomFloat < 0 || randomFloat >= 1) {
    throw new RangeError(`Phase 3 attack randomFloat must be in [0, 1): ${randomFloat}`);
  }
  const candidates = phase3ImplementedAttackCandidates(state);
  if (candidates.length === 0) return null;

  const totalWeight = candidates.reduce((sum, candidate) => sum + candidate.chance, 0);
  let roll = randomFloat * totalWeight;
  for (const candidate of candidates) {
    roll -= candidate.chance;
    if (roll <= 0) return candidate.type;
  }
  return candidates[candidates.length - 1].type;
}

export function phase3AttackLength(type, { stuck = false } = {}) {
  switch (type) {
    case PHASE3_ATTACK.GROUND_ATTACK:
      return stuck ? GROUND_ATTACK_SOURCE.stuckLengthTicks : GROUND_ATTACK_SOURCE.normalLengthTicks;
    case PHASE3_ATTACK.FIREBALL:
      return FIREBALL_ATTACK_SOURCE.lengthTicks;
    case PHASE3_ATTACK.TENTACLE_SWIPE:
      return TENTACLE_SWIPE_SOURCE.lengthTicks;
    case PHASE3_ATTACK.GRAVITY:
      return GRAVITY_ATTACK_SOURCE.lengthTicks;
    case PHASE3_ATTACK.TENTACLES:
      return TENTACLES_ATTACK_SOURCE.lengthTicks;
    default:
      return 0;
  }
}

export function phase3AttackCooldown(type) {
  switch (type) {
    case PHASE3_ATTACK.GROUND_ATTACK: return GROUND_ATTACK_SOURCE.attackCooldownTicks;
    case PHASE3_ATTACK.FIREBALL: return FIREBALL_ATTACK_SOURCE.attackCooldownTicks;
    case PHASE3_ATTACK.TENTACLE_SWIPE: return TENTACLE_SWIPE_SOURCE.attackCooldownTicks;
    case PHASE3_ATTACK.GRAVITY: return GRAVITY_ATTACK_SOURCE.attackCooldownTicks;
    case PHASE3_ATTACK.TENTACLES: return TENTACLES_ATTACK_SOURCE.attackCooldownTicks;
    default: return 0;
  }
}

export function fireballAttackStep({ attackTicks = 0, shotFireball = false, hasTarget = true } = {}) {
  if (!Number.isInteger(attackTicks) || attackTicks < 0) {
    throw new RangeError(`Fireball attackTicks must be a non-negative integer: ${attackTicks}`);
  }
  return {
    launch: hasTarget
      && !shotFireball
      && attackTicks === FIREBALL_BEDROCK_ADAPTER.launchTick,
    finished: attackTicks >= FIREBALL_ATTACK_SOURCE.lengthTicks,
  };
}

export function tentacleSwipeCenter({ position, yawDegrees = 0 } = {}) {
  if (!position || !Number.isFinite(yawDegrees)) {
    throw new RangeError("TentacleSwipe center requires a position and finite yaw");
  }
  const source = TENTACLE_SWIPE_SOURCE.offsetPosition;
  const localX = source.x * TENTACLE_SWIPE_SOURCE.offsetScale;
  const localY = source.y * TENTACLE_SWIPE_SOURCE.offsetScale;
  const localZ = source.z * TENTACLE_SWIPE_SOURCE.offsetScale;
  const angle = (-yawDegrees * Math.PI / 180) + Math.PI;
  const sin = Math.sin(angle);
  const cos = Math.cos(angle);
  return {
    x: position.x + localX * cos + localZ * sin,
    y: position.y + localY,
    z: position.z - localX * sin + localZ * cos,
  };
}

export function tentacleSwipeImpactPlan({ center, players = [] } = {}) {
  if (!center) return [];
  return players
    .filter((player) => {
      const pos = player.position;
      if (!pos) return false;
      return Math.hypot(pos.x - center.x, pos.y - center.y, pos.z - center.z)
        <= TENTACLE_SWIPE_SOURCE.aoeRadius;
    })
    .map((player) => {
      const dx = (player.position?.x ?? center.x) - center.x;
      const dz = (player.position?.z ?? center.z) - center.z;
      const horizontal = Math.max(Math.hypot(dx, dz), 0.001);
      // Java passes (player - swipeCenter) into LivingEntity.knockback, whose
      // implementation subtracts that normalized vector from target velocity.
      return {
        id: player.id,
        damage: TENTACLE_SWIPE_SOURCE.damage,
        bedrockHorizontalForce: {
          x: -(dx / horizontal) * TENTACLE_SWIPE_SOURCE.knockbackStrength,
          z: -(dz / horizontal) * TENTACLE_SWIPE_SOURCE.knockbackStrength,
        },
        bedrockVerticalStrength: TENTACLE_SWIPE_BEDROCK_ADAPTER.verticalStrength,
      };
    });
}

export function gravityAttackStep({ attackTicks = 0 } = {}) {
  if (!Number.isInteger(attackTicks) || attackTicks < 0) {
    throw new RangeError(`Gravity attackTicks must be a non-negative integer: ${attackTicks}`);
  }
  return {
    flipGravity: attackTicks > 0 && attackTicks <= GRAVITY_ATTACK_SOURCE.lengthTicks,
    finished: attackTicks >= GRAVITY_ATTACK_SOURCE.lengthTicks,
  };
}

function tentaclesImpulse(player, horizontalStrength, upwardStrength) {
  const horizontalDistance = Math.max(Math.hypot(player.dx ?? 0, player.dz ?? 0), 0.001);
  return {
    x: (player.dx ?? 0) / horizontalDistance * horizontalStrength,
    y: upwardStrength,
    z: (player.dz ?? 0) / horizontalDistance * horizontalStrength,
  };
}

export function tentaclesAttackImpactPlan({ attackTicks = 0, players = [] } = {}) {
  if (!Number.isInteger(attackTicks) || attackTicks < 0) {
    throw new RangeError(`Tentacles attackTicks must be a non-negative integer: ${attackTicks}`);
  }

  if (attackTicks === TENTACLES_ATTACK_SOURCE.firstPulseAttackTick) {
    return players
      .filter((player) => (
        Number.isFinite(player.distance)
        && player.distance <= TENTACLES_ATTACK_SOURCE.firstPulseRadius
        && player.distance > TENTACLES_ATTACK_SOURCE.firstPulseMinDistanceExclusive
        && Number.isFinite(player.verticalOffset)
        && player.verticalOffset >= TENTACLES_ATTACK_SOURCE.canUseMinVerticalOffset
        && player.verticalOffset <= TENTACLES_ATTACK_SOURCE.canUseMaxVerticalOffset
      ))
      .map((player) => ({
        id: player.id,
        damage: TENTACLES_ATTACK_SOURCE.firstPulseDamage,
        impulse: player.distance < TENTACLES_ATTACK_SOURCE.firstPulseKnockbackMaxDistanceExclusive
          ? tentaclesImpulse(
            player,
            TENTACLES_ATTACK_SOURCE.firstPulseHorizontalKnockback,
            TENTACLES_ATTACK_SOURCE.firstPulseUpwardKnockback,
          )
          : null,
      }));
  }

  if (attackTicks === TENTACLES_ATTACK_SOURCE.secondPulseAttackTick) {
    return players
      .filter((player) => (
        Number.isFinite(player.distance)
        && player.distance <= TENTACLES_ATTACK_SOURCE.secondPulseRadius
      ))
      .map((player) => ({
        id: player.id,
        damage: TENTACLES_ATTACK_SOURCE.secondPulseDamage,
        impulse: player.distance < TENTACLES_ATTACK_SOURCE.secondPulseKnockbackMaxDistanceExclusive
          && (!TENTACLES_ATTACK_SOURCE.secondPulseKnockbackRequiresOnGround || player.onGround === true)
          ? tentaclesImpulse(
            player,
            TENTACLES_ATTACK_SOURCE.secondPulseHorizontalKnockback,
            TENTACLES_ATTACK_SOURCE.secondPulseUpwardKnockback,
          )
          : null,
      }));
  }

  return [];
}
