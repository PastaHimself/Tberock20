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

// Vanilla 1.21.1 AbstractArrow#setBaseDamageFromMob(float) uses the launch
// power plus a difficulty-weighted triangular random term. The Chord source
// passes 2.0f, so keep both the callsite input and vanilla constants explicit.
export const CHORD_PROJECTILE_VANILLA_ARROW_DAMAGE = Object.freeze({
  difficultyMeanPerId: 0.11,
  triangleSpread: 0.57425,
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

// ChordProjectileEntity delegates actual entity-hit damage to vanilla
// AbstractArrow#setBaseDamageFromMob(2.0f), inherited through BrokenCore's
// UwuableArrow. The Bedrock adapter keeps only the engine-specific collision
// values here; the damage formula is pure and source-backed below.
export const CHORD_PROJECTILE_BEDROCK_ADAPTER = Object.freeze({
  runtimeStatus: "adapted_brokencore_arrow_collision",
  movementRuntimeStatus: "adapted_source_launch_vector",
  damageRuntimeStatus: "vanilla_abstract_arrow_formula",
  collisionSubstepDistance: 0.4,
  collisionQueryRadius: 2,
});

/** Maps Bedrock's stable Difficulty enum values to Java Difficulty ids. */
export function chordProjectileDifficultyId(difficulty) {
  const value = typeof difficulty === "string"
    ? difficulty
    : difficulty?.id ?? difficulty?.value ?? difficulty?.name ?? "";
  switch (String(value).toLowerCase()) {
    case "peaceful":
    case "p":
    case "0":
      return 0;
    case "easy":
    case "e":
    case "1":
      return 1;
    case "normal":
    case "n":
    case "2":
      return 2;
    case "hard":
    case "h":
    case "3":
      return 3;
    default:
      return 0;
  }
}

/**
 * Mirrors vanilla 1.21.1 AbstractArrow#setBaseDamageFromMob(float).
 * RandomSource.triangle(mean, spread) consumes two uniform draws.
 *
 * @param {{ power?: number, difficultyId?: number, randomDouble?: () => number }} [options]
 */
export function chordProjectileBaseDamageFromMob({
  power = CHORD_PROJECTILE_SOURCE.baseDamageFromMob,
  difficultyId = 0,
  randomDouble = Math.random,
} = {}) {
  const velocity = Number(power);
  const difficulty = Number(difficultyId);
  const safeVelocity = Number.isFinite(velocity) ? velocity : CHORD_PROJECTILE_SOURCE.baseDamageFromMob;
  const safeDifficulty = Number.isFinite(difficulty) ? difficulty : 0;
  const mean = safeDifficulty * CHORD_PROJECTILE_VANILLA_ARROW_DAMAGE.difficultyMeanPerId;
  const first = Number(randomDouble()) || 0;
  const second = Number(randomDouble()) || 0;
  return safeVelocity * 2 + mean + CHORD_PROJECTILE_VANILLA_ARROW_DAMAGE.triangleSpread * (first - second);
}

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
