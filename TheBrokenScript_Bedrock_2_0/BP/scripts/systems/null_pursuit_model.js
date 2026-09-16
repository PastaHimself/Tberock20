// Pure source-parity decisions for Null Maze and Null Flying.
//
// Keeping these decisions independent of @minecraft/server makes the Java
// thresholds testable without pretending that Node can simulate a Bedrock
// world. Runtime adapters are responsible for obtaining locations, blocks,
// line-of-sight results, and valid entity references.

export const NULL_MAZE_SOURCE = Object.freeze({
  // PersistentTargetGoal is constructed without an explicit range, so the
  // vanilla goal inherits NullMazeEntity's follow_range attribute (416).
  // StalkGoal has its own nearest-player provider capped at 128.
  targetRange: 416,
  stalkRange: 128,
  targetMemoryTicks: 450,
  attackRange: 2,
  attackBoxInflation: 1.2,
  attackIntervalTicks: 10,
  stuckDistanceSquared: 0.002,
  stuckThresholdTicks: 30,
  breakLookDistance: 2,
  doorRayDistance: 2.5,
  movementSpeed: 1.45,
  fallingMovementSpeed: 1.55,
});

export const NULL_FLYING_SOURCE = Object.freeze({
  despawnTicks: 3200,
  targetRange: 512,
  gazeRange: 128,
  triggerDelayTicks: 20,
  proximityRange: 30,
  proximityDamageChance: 0.7,
  proximityDamageMin: 1,
  proximityDamageMaxExclusive: 10,
  gazeMargin: 0.025,
  fovDivisor: 1.5,
  repGainCooldownTicks: 24000,
});

const EPSILON = Number.EPSILON;

function finiteNumber(value) {
  return typeof value === "number" && Number.isFinite(value);
}

function vectorLength(vector) {
  return Math.hypot(vector?.x ?? Number.NaN, vector?.y ?? Number.NaN, vector?.z ?? Number.NaN);
}

function normalize(vector) {
  const length = vectorLength(vector);
  if (!Number.isFinite(length) || length === 0) return undefined;
  return { x: vector.x / length, y: vector.y / length, z: vector.z / length };
}

function dot(left, right) {
  return left.x * right.x + left.y * right.y + left.z * right.z;
}

/**
 * Exact server-side PlayerUtil.isLookingAt equivalent used by NullFlying.
 * The source compares the view vector with the vector to the entity's eye
 * center using a distance-scaled margin, then performs line of sight.
 */
/** @param {Record<string, any>} options */
export function exactFlyingGaze(options = {}) {
  const {
    viewDirection,
    toEntity,
    distance = undefined,
    lineOfSight = false,
    sameDimension = true,
  } = options;
  if (!sameDimension || !lineOfSight) return false;
  const view = normalize(viewDirection);
  const target = normalize(toEntity);
  const actualDistance = finiteNumber(distance) ? distance : vectorLength(toEntity);
  if (!view || !target || !finiteNumber(actualDistance) || actualDistance === 0) return false;
  return dot(view, target) > 1 - NULL_FLYING_SOURCE.gazeMargin / actualDistance;
}

/**
 * Exact PlayerExt.isEntityInFovCone equivalent used by the client flag.
 * `fovDegrees` is explicit when non-null; otherwise the stored player FOV is
 * used. A missing stored FOV is intentionally not treated as a valid cone.
 */
/** @param {Record<string, any>} options */
export function flyingFovCone(options = {}) {
  const {
    viewDirection,
    toEntity,
    fovDegrees = null,
    storedFovDegrees = 0,
    lineOfSight = false,
    sameDimension = true,
  } = options;
  if (!sameDimension || !lineOfSight) return false;
  const explicitFov = fovDegrees !== null && fovDegrees !== undefined;
  const fov = explicitFov ? fovDegrees : storedFovDegrees;
  if (!finiteNumber(fov) || (!explicitFov && fov === 0)) return false;
  const view = normalize(viewDirection);
  const target = normalize(toEntity);
  if (!view || !target) return false;
  const threshold = Math.cos((fov / NULL_FLYING_SOURCE.fovDivisor) * Math.PI / 180);
  return dot(view, target) >= threshold;
}

/**
 * Java casts each facing component to int before multiplying by the loop
 * distance. Math.trunc preserves that behavior for negative values.
 */
/** @param {Record<string, any>} options */
export function mazeBreakPlan(options = {}) {
  const {
    blockPosition,
    facing,
    stuckTicks = 0,
    hasTarget = false,
    blockAt,
    blockBreakingDisabled = false,
  } = options;
  const eligible = hasTarget === true && stuckTicks > NULL_MAZE_SOURCE.stuckThresholdTicks;
  if (!eligible) return { eligible: false, resetStuck: false, positions: [] };

  const positions = [];
  if (!blockBreakingDisabled && blockPosition && facing && typeof blockAt === "function") {
    for (let distance = 1; distance <= NULL_MAZE_SOURCE.breakLookDistance; distance += 1) {
      const front = {
        x: Math.trunc(facing.x * distance) + Math.trunc(blockPosition.x),
        y: Math.trunc(facing.y * distance) + Math.trunc(blockPosition.y),
        z: Math.trunc(facing.z * distance) + Math.trunc(blockPosition.z),
      };
      let block;
      try { block = blockAt(front); } catch { block = undefined; }
      if (!block || block.isAir === true || block.typeId === "minecraft:air") continue;
      positions.push(front, { x: front.x, y: front.y + 1, z: front.z });
    }
  }

  // The source resets stuckTicks inside the successful destroy branch. An
  // air-only inspection or the disableBlockBreaking config leaves the counter
  // above the threshold for the next tick.
  return { eligible: true, resetStuck: positions.length > 0, positions };
}

/** @param {Record<string, any>} options */
export function mazeDoorAction(options = {}) {
  const {
    hasTarget = false,
    hitType,
    isDoor = false,
    isOpen = false,
  } = options;
  return hasTarget === true && hitType === "block" && isDoor === true && isOpen !== true
    ? "open"
    : "none";
}

/** PersistentTargetGoal keeps a live target while its line of sight has been
 * absent for fewer than 450 ticks. A newly acquired target must be visible. */
/** @param {Record<string, any>} options */
export function mazeTargetMemoryStep(options = {}) {
  const {
    currentTargetId = undefined,
    targetExists = false,
    targetVisible = false,
    candidateTargetId = undefined,
    candidateVisible = false,
    unseenTicks = 0,
  } = options;
  if (currentTargetId === undefined || !targetExists) {
    if (candidateTargetId !== undefined && candidateVisible === true) {
      return { targetId: candidateTargetId, unseenTicks: 0 };
    }
    return { targetId: undefined, unseenTicks: 0 };
  }
  if (targetVisible === true) return { targetId: currentTargetId, unseenTicks: 0 };
  const nextUnseenTicks = Math.max(0, Math.trunc(Number(unseenTicks) || 0)) + 1;
  if (nextUnseenTicks >= NULL_MAZE_SOURCE.targetMemoryTicks) {
    return { targetId: undefined, unseenTicks: 0 };
  }
  return { targetId: currentTargetId, unseenTicks: nextUnseenTicks };
}

/** @param {Record<string, any>} options */
export function flyingDelayedOutcome(options = {}) {
  const {
    initialSneaking = false,
    currentSneaking = false,
    repGainTimer = 0,
  } = options;
  const sneaking = initialSneaking === true || currentSneaking === true;
  const timer = finiteNumber(repGainTimer) ? Math.trunc(repGainTimer) : 0;
  if (!sneaking) {
    return {
      discard: true,
      reputationDelta: -10,
      playHostileSound: true,
      nextRepGainTimer: timer,
    };
  }
  if (timer !== 0) {
    return {
      discard: true,
      reputationDelta: 0,
      playHostileSound: false,
      nextRepGainTimer: timer,
    };
  }
  return {
    discard: true,
    reputationDelta: 10,
    playHostileSound: false,
    nextRepGainTimer: NULL_FLYING_SOURCE.repGainCooldownTicks,
  };
}

export function flyingRepGainCooldownStep(timer) {
  const current = finiteNumber(timer) ? Math.trunc(timer) : 0;
  return current > 0 ? current - 1 : 0;
}

/** @param {Record<string, any>} options */
export function flyingProximityOutcome(options = {}) {
  const { branchRoll, damageRoll } = options;
  if (!finiteNumber(branchRoll) || branchRoll >= NULL_FLYING_SOURCE.proximityDamageChance) {
    return { action: "summon_null_is_here" };
  }
  const normalizedDamageRoll = Math.max(0, Math.min(1 - EPSILON, Number(damageRoll) || 0));
  const span = NULL_FLYING_SOURCE.proximityDamageMaxExclusive - NULL_FLYING_SOURCE.proximityDamageMin;
  return {
    action: "damage",
    amount: NULL_FLYING_SOURCE.proximityDamageMin + Math.floor(normalizedDamageRoll * span),
  };
}

export function naturalDespawnStep(timer, defaultTimer) {
  const initial = finiteNumber(timer) ? Math.trunc(timer) : Math.trunc(defaultTimer);
  if (initial < 0) return { timer: initial, discard: false };
  const next = initial - 1;
  return { timer: next, discard: next === 0 };
}
