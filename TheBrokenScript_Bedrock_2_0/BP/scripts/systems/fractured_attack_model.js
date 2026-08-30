// Source-backed constants and pure state transitions for FracturedEntity
// (Jimmy). Runtime code owns Bedrock queries, movement, damage, and rendering
// adapters; this module intentionally has no @minecraft/server dependency.

export const FRACTURED_LIFECYCLE_SOURCE = Object.freeze({
  initialAttackDelayTicks: 100,
  defeatAfterHits: 6,
  attackedCooldownTicks: 800,
});

export const FRACTURED_ATTACKS = Object.freeze({
  noop: Object.freeze({ lengthTicks: -1, chance: 0, canMove: true }),
  stomp: Object.freeze({ lengthTicks: 78, chance: 1, canMove: false }),
  slam: Object.freeze({ lengthTicks: 78, chance: 1, canMove: false }),
  moonRockToss: Object.freeze({ lengthTicks: 139, cooldownTicks: 20, chance: 1, canMove: false }),
  airLift: Object.freeze({ lengthTicks: 60, chance: 1, canMove: false }),
});

export const FRACTURED_SOURCE = Object.freeze({
  stomp: Object.freeze({
    offset: Object.freeze({ x: 26.25, y: 0, z: -164.125 }),
    triggerTick: 13,
    radius: 5,
    damage: 5,
    knockback: 2,
  }),
  slam: Object.freeze({ radius: 512, damage: 12, knockback: 30, groundedOnly: true }),
  bigStomp: Object.freeze({ radius: 64, damage: 12, knockback: 5, groundedOnly: true }),
  rock: Object.freeze({
    damage: 15,
    throwSpeed: 8,
    throwInaccuracy: 0,
    blockImpactCleanupTicks: 1,
    hitboxInflation: 4,
    airLiftPulseDelayTicks: 25,
    airLiftPulseRadius: 32,
    airLiftPulseDamage: 12,
    airLiftPulseKnockback: 10,
  }),
});

const SELECTABLE_ATTACKS = Object.freeze(["stomp", "slam", "moonRockToss", "airLift"]);

/**
 * Mirrors JimAttackSelectorGoal.start(). `roll` is the random value before
 * multiplication by the sum of the equal source weights. The source's
 * subtract-then-test makes each upper boundary inclusive.
 */
export function chooseFracturedAttack({
  currentAttack = "noop",
  attackDelay = 0,
  targetPresent = false,
  roll = 0,
} = {}) {
  if (currentAttack !== "noop" || attackDelay > 0 || !targetPresent) return null;
  const normalizedRoll = Number.isFinite(roll) ? Math.max(0, Math.min(0.999999999999, roll)) : 0;
  const totalWeight = SELECTABLE_ATTACKS.reduce((sum, attack) => sum + FRACTURED_ATTACKS[attack].chance, 0);
  let remaining = normalizedRoll * totalWeight;
  for (const attack of SELECTABLE_ATTACKS) {
    remaining -= FRACTURED_ATTACKS[attack].chance;
    if (remaining <= 0) return attack;
  }
  return SELECTABLE_ATTACKS.at(-1);
}

/** Mirrors FracturedEntity.tick() and finishAttack(). */
export function fracturedAttackStep({
  attack = "noop",
  attackTicks = 0,
  attackDelay = 0,
} = {}) {
  if (attackDelay > 0) {
    return {
      attackTicks,
      finished: false,
      nextAttack: attack,
      nextAttackDelay: attackDelay - 1,
    };
  }

  const definition = FRACTURED_ATTACKS[attack] ?? FRACTURED_ATTACKS.noop;
  const nextTicks = attackTicks + 1;
  if (definition.lengthTicks >= 0 && nextTicks >= definition.lengthTicks) {
    return {
      attackTicks: 0,
      finished: true,
      nextAttack: "noop",
      nextAttackDelay: definition.cooldownTicks ?? 0,
    };
  }
  return {
    attackTicks: nextTicks,
    finished: false,
    nextAttack: attack,
    nextAttackDelay: attackDelay,
  };
}

export function fracturedImpactPlan(attack) {
  switch (attack) {
    case "stomp":
      return {
        attack: "stomp",
        radius: FRACTURED_SOURCE.stomp.radius,
        damage: FRACTURED_SOURCE.stomp.damage,
        knockback: FRACTURED_SOURCE.stomp.knockback,
        triggerTick: FRACTURED_SOURCE.stomp.triggerTick,
        groundedOnly: false,
      };
    case "slam":
      return {
        attack: "slam",
        radius: FRACTURED_SOURCE.slam.radius,
        damage: FRACTURED_SOURCE.slam.damage,
        knockback: FRACTURED_SOURCE.slam.knockback,
        groundedOnly: true,
      };
    case "bigStomp":
      return {
        attack: "bigStomp",
        radius: FRACTURED_SOURCE.bigStomp.radius,
        damage: FRACTURED_SOURCE.bigStomp.damage,
        knockback: FRACTURED_SOURCE.bigStomp.knockback,
        groundedOnly: true,
      };
    case "moonRockToss":
      return {
        attack: "moonRockToss",
        lengthTicks: FRACTURED_ATTACKS.moonRockToss.lengthTicks,
        cooldownTicks: FRACTURED_ATTACKS.moonRockToss.cooldownTicks,
        damage: FRACTURED_SOURCE.rock.damage,
        speed: FRACTURED_SOURCE.rock.throwSpeed,
        inaccuracy: FRACTURED_SOURCE.rock.throwInaccuracy,
        targetYInterpolation: 0.5,
      };
    case "airLift":
      return {
        attack: "airLift",
        lengthTicks: FRACTURED_ATTACKS.airLift.lengthTicks,
        rockDamage: FRACTURED_SOURCE.rock.damage,
        speed: 0,
        inaccuracy: FRACTURED_SOURCE.rock.throwInaccuracy,
        pulseDelayTicks: FRACTURED_SOURCE.rock.airLiftPulseDelayTicks,
        pulseRadius: FRACTURED_SOURCE.rock.airLiftPulseRadius,
        pulseDamage: FRACTURED_SOURCE.rock.airLiftPulseDamage,
        pulseKnockback: FRACTURED_SOURCE.rock.airLiftPulseKnockback,
        groundedOnly: true,
      };
    default:
      return null;
  }
}

export function fracturedRockImpactPlan({
  owner = false,
  living = false,
  intersects = false,
} = {}) {
  const applyDamage = !owner && living && intersects;
  return {
    applyDamage,
    damage: FRACTURED_SOURCE.rock.damage,
    hitboxInflation: FRACTURED_SOURCE.rock.hitboxInflation,
    remove: applyDamage,
    excludeOwner: true,
  };
}

export function fracturedRockFlightStep({
  position = { x: 0, y: 0, z: 0 },
  direction = null,
  blocked = false,
  grounded = false,
  groundedTicks = 0,
} = {}) {
  if (grounded) {
    return {
      position: { ...position },
      remove: groundedTicks >= FRACTURED_SOURCE.rock.blockImpactCleanupTicks,
      grounded: true,
    };
  }
  if (blocked) {
    return {
      position: { ...position },
      remove: false,
      grounded: true,
      cleanupTicks: FRACTURED_SOURCE.rock.blockImpactCleanupTicks,
    };
  }
  if (!direction) {
    return { position: { ...position }, remove: true, grounded: false };
  }
  return {
    position: {
      x: position.x + direction.x * FRACTURED_SOURCE.rock.throwSpeed,
      y: position.y + direction.y * FRACTURED_SOURCE.rock.throwSpeed,
      z: position.z + direction.z * FRACTURED_SOURCE.rock.throwSpeed,
    },
    remove: false,
    grounded: false,
  };
}

export function fracturedDefeatStep({
  timesAttacked = 0,
  attackedCooldown = 0,
  accepted = false,
} = {}) {
  let nextTimes = timesAttacked;
  let nextCooldown = attackedCooldown;
  if (accepted && attackedCooldown <= 0) {
    nextTimes += 1;
    nextCooldown = FRACTURED_LIFECYCLE_SOURCE.attackedCooldownTicks;
  } else if (nextCooldown > 0) {
    nextCooldown -= 1;
  }
  return {
    timesAttacked: nextTimes,
    attackedCooldown: nextCooldown,
    defeated: nextTimes >= FRACTURED_LIFECYCLE_SOURCE.defeatAfterHits,
  };
}
