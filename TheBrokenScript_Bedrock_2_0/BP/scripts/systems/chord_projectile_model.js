// Pure, source-backed ChordProjectileEntity semantics.
// Keep this module free of @minecraft/server imports so CI can verify parity.

export const CHORD_PROJECTILE_SOURCE = Object.freeze({
  saved: false,
  noGravityInFlight: true,
  launchSpeedBlocksPerTick: 1.6,
  launchInaccuracy: 0,
  maxTravelDistance: 100,
  blockHitDiscardDelayTicks: 20,
  pickupItem: null,
  baseDamageFromMob: 2,
  discardOnChordHit: true,
  discardOnCreativePlayerHit: true,
  restoreGravityAfterEntityHit: true,
  restoreGravityAfterBlockHit: true,
});

// ChordProjectileEntity stores this Vec2 for the client model after a block
// hit. Bedrock's server-side collision adapter may not receive a
// BlockHitResult face, so keep the exact source table separate from the
// runtime's best-effort collision position.
export const CHORD_PROJECTILE_GROUNDED_OFFSETS = Object.freeze({
  south: Object.freeze({ x: 215, y: 180 }),
  north: Object.freeze({ x: 215, y: 0 }),
  east: Object.freeze({ x: 215, y: -90 }),
  west: Object.freeze({ x: 215, y: 90 }),
  down: Object.freeze({ x: 115, y: 180 }),
  up: Object.freeze({ x: 185, y: 180 }),
});

export function chordProjectileGroundedOffset(face) {
  const offset = CHORD_PROJECTILE_GROUNDED_OFFSETS[String(face ?? "").toLowerCase()];
  return offset ? { x: offset.x, y: offset.y } : null;
}

// ChordProjectileEntity delegates actual entity-hit damage to BrokenCore's
// UwuableArrow#setBaseDamageFromMob(2.0f). That dependency is not present in
// this repository, so the existing Bedrock 6-damage value remains isolated as
// an adaptation instead of being presented as source-exact.
export const CHORD_PROJECTILE_BEDROCK_ADAPTER = Object.freeze({
  runtimeStatus: "adapted_brokencore_arrow_damage",
  movementRuntimeStatus: "adapted_source_launch_vector",
  entityHitDamage: 6,
  collisionSubstepDistance: 0.4,
  collisionQueryRadius: 2,
});

// The Java onHitEntity branch checks Chord before delegating to the vanilla
// arrow implementation, then checks creative mode after that delegation.
// Keep this decision pure so the runtime adapter cannot accidentally damage a
// Chord or discard an ordinary hit.
/**
 * @param {{
 *   targetType?: string;
 *   isCreativePlayer?: boolean;
 * }} [options]
 */
export function chordProjectileEntityImpactPlan({ targetType, isCreativePlayer = false } = {}) {
  if (targetType === "thebrokenscript:chord") {
    return {
      targetKind: "chord",
      applyDamage: false,
      discard: true,
      restoreGravity: true,
    };
  }
  if (targetType === "minecraft:player" && isCreativePlayer === true) {
    return {
      targetKind: "creative_player",
      applyDamage: true,
      discard: true,
      restoreGravity: true,
    };
  }
  return {
    targetKind: "entity",
    applyDamage: true,
    discard: false,
    restoreGravity: true,
  };
}

export function chordProjectileDirection(vector) {
  const x = Number(vector?.x ?? 0);
  const y = Number(vector?.y ?? 0);
  const z = Number(vector?.z ?? 0);
  const length = Math.hypot(x, y, z);
  if (!(length > 0)) return null;
  return { x: x / length, y: y / length, z: z / length };
}

export function chordProjectileTravelDistance(position, initialPosition) {
  if (!position || !initialPosition) return Number.POSITIVE_INFINITY;
  return Math.hypot(
    position.x - initialPosition.x,
    position.y - initialPosition.y,
    position.z - initialPosition.z,
  );
}

export function chordProjectileShouldDiscardForTravel(position, initialPosition) {
  return chordProjectileTravelDistance(position, initialPosition)
    >= CHORD_PROJECTILE_SOURCE.maxTravelDistance;
}

export function chordProjectileBlockHitStep(discardTicksRemaining) {
  if (discardTicksRemaining === null || discardTicksRemaining === undefined) {
    return {
      grounded: true,
      discard: false,
      discardTicksRemaining: CHORD_PROJECTILE_SOURCE.blockHitDiscardDelayTicks,
    };
  }
  if (!Number.isInteger(discardTicksRemaining) || discardTicksRemaining < 0) {
    throw new RangeError(`Chord projectile discard countdown must be a non-negative integer: ${discardTicksRemaining}`);
  }
  if (discardTicksRemaining <= 1) {
    return { grounded: true, discard: true, discardTicksRemaining: 0 };
  }
  return {
    grounded: true,
    discard: false,
    discardTicksRemaining: discardTicksRemaining - 1,
  };
}
