// Source-backed FracturedRoam lifecycle values from FracturedRoamEntity,
// FracturedRoamGoUnDerGroundGoal, BaseFracturedEntity, and JimArena.

export const FRACTURED_ROAM_SOURCE = Object.freeze({
  serverTimerTicks: 149,
  riseTicks: 149,
  digAnimationTicks: 103,
  despawnAnimationTicks: 103,
  switchingTicks: 103,
  despawnTimerMinTicks: 18000,
  despawnTimerMaxTicks: 24000,
  undergroundTimerMinTicks: 300,
  undergroundTimerMaxExclusive: 400,
  digCooldownMinTicks: 400,
  digCooldownMaxExclusive: 800,
  navigationCooldownMinTicks: 60,
  navigationCooldownMaxExclusive: 120,
  navigationSpeedModifier: 0.4,
  randomStrollSpeedModifier: 0.6,
  randomStrollIntervalTicks: 45,
  randomStrollHorizontalRange: 100,
  randomStrollVerticalRange: 7,
  strollSupportDepth: 10,
  strollSupportLookahead: 8,
  strollStuckTicks: 20,
  surfaceRecoveryMaxDistance: 64,
  surfaceRecoveryStep: 3,
  surfaceRecoveryHeightOffset: 60,
  surfaceRecoveryScanLayers: 41,
  moveControlMaxTurnDegrees: 90,
  digRoll: 1,
  digRollBound: 1000,
  arenaStartMusicTicks: 340,
  arenaSubAnomalyCount: 30,
  arenaPlayerRange: 150,
  arenaSubAnomalyRadius: 20,
});

function nonNegativeTicks(value, fallback) {
  const number = Number(value);
  return Number.isFinite(number) ? Math.max(0, Math.floor(number)) : fallback;
}

/** Mirrors FracturedRoamEntity's independent server timer lambda. */
export function fracturedRoamServerTimerStep(timer = FRACTURED_ROAM_SOURCE.serverTimerTicks) {
  const current = nonNegativeTicks(timer, FRACTURED_ROAM_SOURCE.serverTimerTicks);
  if (current === 0) return { timer: 0, enableAi: false };
  const next = current - 1;
  return { timer: next, enableAi: next === 0 };
}

/** Mirrors BaseFracturedEntity.tick's decrement-then-transition behavior. */
export function fracturedRoamBaseTick({
  state = "RISING",
  riseTicks = FRACTURED_ROAM_SOURCE.riseTicks,
  digTicks = FRACTURED_ROAM_SOURCE.digAnimationTicks,
  despawnTicks = FRACTURED_ROAM_SOURCE.despawnAnimationTicks,
} = {}) {
  let nextState = state;
  let nextRiseTicks = nonNegativeTicks(riseTicks, FRACTURED_ROAM_SOURCE.riseTicks);
  let nextDigTicks = nonNegativeTicks(digTicks, FRACTURED_ROAM_SOURCE.digAnimationTicks);
  let nextDespawnTicks = nonNegativeTicks(despawnTicks, FRACTURED_ROAM_SOURCE.despawnAnimationTicks);
  let discarded = false;

  if (nextState === "RISING") {
    if (nextRiseTicks > 0) nextRiseTicks -= 1;
    else nextState = "NORMAL";
  } else {
    nextRiseTicks = FRACTURED_ROAM_SOURCE.riseTicks;
  }

  if (nextState === "DIGGING") {
    if (nextDigTicks > 0) nextDigTicks -= 1;
    else nextState = "UNDERGROUND";
  } else {
    nextDigTicks = FRACTURED_ROAM_SOURCE.digAnimationTicks;
  }

  if (nextState === "DESPAWNING") {
    if (nextDespawnTicks > 0) nextDespawnTicks -= 1;
    else discarded = true;
  } else {
    nextDespawnTicks = FRACTURED_ROAM_SOURCE.despawnAnimationTicks;
  }

  return {
    state: nextState,
    riseTicks: nextRiseTicks,
    digTicks: nextDigTicks,
    despawnTicks: nextDespawnTicks,
    discarded,
  };
}

/** Mirrors FracturedRoamGoUnDerGroundGoal.canUse.
 * @param {{ state?: string, digCooldown?: number, roll?: number }} options
 */
export function fracturedRoamDigEligibility({ state, digCooldown, roll } = {}) {
  return state === "NORMAL" && Number(digCooldown) <= 0 && roll === FRACTURED_ROAM_SOURCE.digRoll;
}

/** Mirrors the goal start side effects; the caller supplies Java's random value. */
export function fracturedRoamDigGoalStart(undergroundTimer) {
  return {
    state: "DIGGING",
    undergroundTimer: nonNegativeTicks(undergroundTimer, FRACTURED_ROAM_SOURCE.undergroundTimerMinTicks),
    digTicks: FRACTURED_ROAM_SOURCE.digAnimationTicks,
  };
}

/** Mirrors the goal stop side effects; the caller supplies Java's random value. */
export function fracturedRoamDigGoalStop(digCooldown) {
  return {
    state: "RISING",
    digCooldown: nonNegativeTicks(digCooldown, FRACTURED_ROAM_SOURCE.digCooldownMinTicks),
    riseTicks: FRACTURED_ROAM_SOURCE.riseTicks,
  };
}

/** Mirrors FracturedRoamEntity's despawn timer branch.
 * @param {{ state?: string, despawnTimer?: number }} options
 */
export function fracturedRoamDespawnStep({ state, despawnTimer } = {}) {
  const current = nonNegativeTicks(despawnTimer, 0);
  if (current > 0) return { state, despawnTimer: current - 1 };
  return {
    state: state === "NORMAL" ? "DESPAWNING" : state,
    despawnTimer: 0,
  };
}

/** Mirrors RandomStrollGoal's source interval adapter. */
export function fracturedRoamStrollDue(tick) {
  const current = nonNegativeTicks(tick, 0);
  return current % FRACTURED_ROAM_SOURCE.randomStrollIntervalTicks === 0;
}

function finiteCoordinate(value, fallback = 0) {
  const number = Number(value);
  return Number.isFinite(number) ? number : fallback;
}

function airAt(isAirAt, position) {
  try {
    return isAirAt(position) === true;
  } catch {
    return false;
  }
}

/** Mirrors BaseFracturedEntity.findSurfaceAhead's integer scan.\n+ * @param {{ position?: { x?: number, y?: number, z?: number }, yawDegrees?: number, maxDist?: number, step?: number, minBuildHeight?: number, isAirAt?: (position: { x: number, y: number, z: number }) => boolean }} options
 */
export function fracturedRoamFindSurfaceAhead({
  position,
  yawDegrees = 0,
  maxDist = FRACTURED_ROAM_SOURCE.surfaceRecoveryMaxDistance,
  step = FRACTURED_ROAM_SOURCE.surfaceRecoveryStep,
  minBuildHeight = -64,
  isAirAt,
} = {}) {
  if (typeof isAirAt !== "function") return null;
  const origin = position ?? {};
  const maxDistance = Math.max(0, Math.floor(finiteCoordinate(maxDist, FRACTURED_ROAM_SOURCE.surfaceRecoveryMaxDistance)));
  const stride = Math.floor(finiteCoordinate(step, FRACTURED_ROAM_SOURCE.surfaceRecoveryStep));
  if (stride <= 0) return null;
  const minimumY = Math.floor(finiteCoordinate(minBuildHeight, -64));
  const yaw = (finiteCoordinate(yawDegrees, 0) + 90) * Math.PI / 180;
  const dirX = -Math.sin(yaw);
  const dirZ = Math.cos(yaw);
  const originX = finiteCoordinate(origin.x);
  const originY = finiteCoordinate(origin.y);
  const originZ = finiteCoordinate(origin.z);

  for (let distance = stride; distance <= maxDistance; distance += stride) {
    const checkX = Math.trunc(originX + dirX * distance);
    const checkZ = Math.trunc(originZ + dirZ * distance);
    const baseY = Math.trunc(originY) + FRACTURED_ROAM_SOURCE.surfaceRecoveryHeightOffset;
    for (let offset = 0; offset < FRACTURED_ROAM_SOURCE.surfaceRecoveryScanLayers; offset += 1) {
      const checkY = baseY - offset;
      if (checkY < minimumY) break;
      const base = { x: checkX, y: checkY, z: checkZ };
      if (!airAt(isAirAt, base) &&
          airAt(isAirAt, { x: checkX, y: checkY + 1, z: checkZ }) &&
          airAt(isAirAt, { x: checkX, y: checkY + 2, z: checkZ })) {
        return { x: checkX + 0.5, y: checkY + 1, z: checkZ + 0.5 };
      }
    }
  }
  return null;
}

/** Mirrors RandomStrollGoal.hasSupportNear's downward support search.\n+ * @param {{ position?: { x?: number, y?: number, z?: number }, checkDepth?: number, isAirAt?: (position: { x: number, y: number, z: number }) => boolean }} options
 */
export function fracturedRoamSupportNear({
  position,
  checkDepth = FRACTURED_ROAM_SOURCE.strollSupportDepth,
  isAirAt,
} = {}) {
  if (typeof isAirAt !== "function") return false;
  const origin = position ?? {};
  const baseX = Math.floor(finiteCoordinate(origin.x));
  const baseY = Math.floor(finiteCoordinate(origin.y));
  const baseZ = Math.floor(finiteCoordinate(origin.z));
  const depth = Math.max(0, Math.floor(finiteCoordinate(checkDepth, FRACTURED_ROAM_SOURCE.strollSupportDepth)));
  for (let offset = 1; offset <= depth; offset += 1) {
    if (!airAt(isAirAt, { x: baseX, y: baseY - offset, z: baseZ })) return true;
  }
  return false;
}

/** Mirrors RandomStrollGoal.hasSupportAhead's eight-block path probe.\n+ * @param {{ current?: { x?: number, y?: number, z?: number }, wanted?: { x?: number, y?: number, z?: number }, lookaheadDist?: number, checkDepth?: number, isAirAt?: (position: { x: number, y: number, z: number }) => boolean }} options
 */
export function fracturedRoamSupportAhead({
  current,
  wanted,
  lookaheadDist = FRACTURED_ROAM_SOURCE.strollSupportLookahead,
  checkDepth = FRACTURED_ROAM_SOURCE.strollSupportDepth,
  isAirAt,
} = {}) {
  if (typeof isAirAt !== "function") return false;
  const from = current ?? {};
  const destination = wanted ?? from;
  const fromX = finiteCoordinate(from.x);
  const fromY = finiteCoordinate(from.y);
  const fromZ = finiteCoordinate(from.z);
  const dx = finiteCoordinate(destination.x) - fromX;
  const dz = finiteCoordinate(destination.z) - fromZ;
  const horizontalDistance = Math.hypot(dx, dz);
  if (horizontalDistance < 0.001) return true;
  const checkDistance = Math.min(Math.max(0, finiteCoordinate(lookaheadDist, FRACTURED_ROAM_SOURCE.strollSupportLookahead)), horizontalDistance);
  return fracturedRoamSupportNear({
    position: {
      x: fromX + (dx / horizontalDistance) * checkDistance,
      y: fromY,
      z: fromZ + (dz / horizontalDistance) * checkDistance,
    },
    checkDepth,
    isAirAt,
  });
}

function wrapDegrees(degrees) {
  const wrapped = ((degrees + 180) % 360 + 360) % 360 - 180;
  return wrapped === -180 ? 180 : wrapped;
}

/** Mirrors BaseFracturedEntity.RoamMoveControl.tick's movement decision.\n+ * @param {{ operation?: string, position?: { x?: number, z?: number }, wanted?: { x?: number, z?: number }, yawDegrees?: number, speedModifier?: number, movementSpeed?: number }} options
 */
export function fracturedRoamMoveControlStep({
  operation = "WAIT",
  position,
  wanted,
  yawDegrees = 0,
  speedModifier = 0.6,
  movementSpeed = 0.075,
} = {}) {
  const yaw = finiteCoordinate(yawDegrees);
  if (operation !== "MOVE_TO") return { operation, yawDegrees: yaw, forward: 0, speed: 0 };
  const from = position ?? {};
  const destination = wanted ?? from;
  const dx = finiteCoordinate(destination.x) - finiteCoordinate(from.x);
  const dz = finiteCoordinate(destination.z) - finiteCoordinate(from.z);
  const horizontalDistanceSquared = dx * dx + dz * dz;
  if (horizontalDistanceSquared < 0.125) {
    return { operation: "WAIT", yawDegrees: yaw, forward: 0, speed: 0 };
  }
  const targetYaw = Math.atan2(dz, dx) * 180 / Math.PI - 90;
  const delta = wrapDegrees(targetYaw - yaw);
  const limitedDelta = Math.max(
    -FRACTURED_ROAM_SOURCE.moveControlMaxTurnDegrees,
    Math.min(FRACTURED_ROAM_SOURCE.moveControlMaxTurnDegrees, delta),
  );
  return {
    operation: "MOVE_TO",
    yawDegrees: yaw + limitedDelta,
    forward: 1,
    speed: finiteCoordinate(speedModifier, 0.6) * finiteCoordinate(movementSpeed, 0.075),
  };
}

/** Captures JimArena.start's observable schedule without inventing Bedrock-only packets. */
export function fracturedRoamArenaPlan() {
  return {
    introSound: "thebrokenscript:jimbob.intro",
    loopSound: "thebrokenscript:jimbob.loop",
    startMusicTicks: FRACTURED_ROAM_SOURCE.arenaStartMusicTicks,
    subAnomalyCount: FRACTURED_ROAM_SOURCE.arenaSubAnomalyCount,
    playerRange: FRACTURED_ROAM_SOURCE.arenaPlayerRange,
    subAnomalyRadius: FRACTURED_ROAM_SOURCE.arenaSubAnomalyRadius,
  };
}

/** Java's nextInt(origin, bound) adapter, with an exclusive upper bound. */
export function fracturedRoamRandomInt(origin, bound, roll = Math.random()) {
  const low = Math.floor(origin);
  const high = Math.floor(bound);
  if (high <= low) return low;
  const normalized = Math.max(0, Math.min(0.999999999, Number(roll) || 0));
  return low + Math.floor(normalized * (high - low));
}

/** Java's inclusive IntRange random adapter used by despawnTimer. */
export function fracturedRoamRandomInclusive(min, max, roll = Math.random()) {
  return fracturedRoamRandomInt(min, max + 1, roll);
}
