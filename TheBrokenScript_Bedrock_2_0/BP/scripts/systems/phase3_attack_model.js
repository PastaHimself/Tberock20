// Pure, source-backed Integrity Phase 3 attack-selection semantics.
// Keep this module free of @minecraft/server imports so CI can verify parity.

import { GROUND_ATTACK_SOURCE, groundAttackCanUse } from "./integrity_arena_model.js";

export const PHASE3_ATTACK = Object.freeze({
  NOOP: "NOOP",
  GROUND_ATTACK: "GROUND_ATTACK",
  FIREBALL: "FIREBALL",
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

export function phase3ImplementedAttackCandidates({
  hasTarget = true,
  attackDelay = 0,
  stuck = false,
  distance = Number.NaN,
  previousAttack = null,
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
    default:
      return 0;
  }
}

export function phase3AttackCooldown(type) {
  switch (type) {
    case PHASE3_ATTACK.GROUND_ATTACK: return GROUND_ATTACK_SOURCE.attackCooldownTicks;
    case PHASE3_ATTACK.FIREBALL: return FIREBALL_ATTACK_SOURCE.attackCooldownTicks;
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
