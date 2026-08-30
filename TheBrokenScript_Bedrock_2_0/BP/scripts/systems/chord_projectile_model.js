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

// ChordProjectileEntity delegates actual entity-hit damage to BrokenCore's
// UwuableArrow#setBaseDamageFromMob(2.0f). That dependency is not present in
// this repository, so the existing Bedrock 6-damage value remains isolated as
// an adaptation instead of being presented as source-exact.
export const CHORD_PROJECTILE_BEDROCK_ADAPTER = Object.freeze({
  runtimeStatus: "adapted_brokencore_arrow_damage",
  entityHitDamage: 6,
  collisionSubstepDistance: 0.4,
});

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
  if (discardTicksRemaining === 0) {
    return { grounded: true, discard: true, discardTicksRemaining: 0 };
  }
  return {
    grounded: true,
    discard: false,
    discardTicksRemaining: discardTicksRemaining - 1,
  };
}
