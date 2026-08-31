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
