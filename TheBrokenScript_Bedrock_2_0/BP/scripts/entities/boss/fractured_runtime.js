import { EntityDamageCause, EquipmentSlot, world, system } from "@minecraft/server";
import * as perf from "../../systems/perf.js";
import { logger } from "../../core/logging.js";
import {
  FRACTURED_ATTACKS,
  FRACTURED_LIFECYCLE_SOURCE,
  FRACTURED_SOURCE,
  chooseFracturedAttack,
  fracturedAttackStep,
  fracturedDefeatStep,
  fracturedImpactPlan,
  fracturedRockFlightStep,
  fracturedRockImpactPlan,
} from "../../systems/fractured_attack_model.js";
import {
  FRACTURED_MULTIPART_SOURCE,
  fracturedPartHitPlan,
  fracturedRoamSwitchStep,
  multipartAabbs,
  multipartPartDefinitions,
  pointInsideAabb,
  shouldApplyMultipartArrowEffects,
} from "../../systems/fractured_multipart_model.js";
import {
  FRACTURED_ROAM_SOURCE,
  fracturedRoamArenaPlan,
  fracturedRoamBaseTick,
  fracturedRoamDespawnStep,
  fracturedRoamDigEligibility,
  fracturedRoamDigGoalStart,
  fracturedRoamDigGoalStop,
  fracturedRoamRandomInclusive,
  fracturedRoamRandomInt,
  fracturedRoamServerTimerStep,
  fracturedRoamStrollDue,
} from "../../systems/fractured_roam_model.js";

const FRACTURED_TYPE = "thebrokenscript:fractured";
const FRACTURED_ROAM_TYPE = "thebrokenscript:fractured_roam";
const ROCK_TYPE = "thebrokenscript:rock";
const FRACTURED_FAMILY = "thebrokenscript_fractured_runtime";
const ROCK_FAMILY = "thebrokenscript_fractured_rock_runtime";
const DEFEATED_TAG = "thebrokenscript.fractured_defeated";
const ROAM_SWITCH_TAG = "thebrokenscript.fractured_roam_switching";
const ROAM_NO_AI_TAG = "thebrokenscript.fractured_roam_no_ai";
const ATTACK_TAG_PREFIX = "thebrokenscript.fractured_attack.";

// The Java attack effects are emitted by GeckoLib keyframes. The decompiled
// source exposes the instruction names but not their animation timestamps, and
// Bedrock's current renderer does not expose the Java model bones to script.
// Keep these fallback timings isolated so a future animation bridge can replace
// them without changing the source-backed model.
const KEYFRAME_ADAPTER_TICKS = Object.freeze({
  slam: 1,
  bigStomp: 1,
  moonRockToss: 1,
  airLift: 1,
});

// BaseFracturedEntity's RoamMoveControl uses the Java movement attribute. This
// is the existing Bedrock movement conversion, not a source combat constant.
const MOVEMENT_ADAPTER_BLOCKS_PER_TICK = 0.075;
const COLLISION_SUBSTEP_BLOCKS = 0.4;
const ROAM_ARENA_SOURCE = fracturedRoamArenaPlan();
const ROAM_STROLL_MOVEMENT_ADAPTER = FRACTURED_ROAM_SOURCE.randomStrollSpeedModifier * MOVEMENT_ADAPTER_BLOCKS_PER_TICK;
const ROAM_DIG_MOVEMENT_ADAPTER = FRACTURED_ROAM_SOURCE.navigationSpeedModifier * MOVEMENT_ADAPTER_BLOCKS_PER_TICK;

const fracturedStates = new Map();
const rockStates = new Map();
const roamSwitchStates = new Map();
const roamLifecycleStates = new Map();
const roamArenaStates = new Map();
let damageHookInstalled = false;
let spawnHookInstalled = false;

function copyPosition(position) {
  return { x: position.x, y: position.y, z: position.z };
}

function distance(a, b) {
  return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z);
}

function isValid(entity) {
  if (!entity) return false;
  try { return entity.isValid !== false; } catch { return false; }
}

function callEntity(entity, method, ...args) {
  try {
    const fn = entity?.[method];
    return typeof fn === "function" ? fn.call(entity, ...args) : undefined;
  } catch {
    return undefined;
  }
}

function getHealth(entity) {
  try { return entity.getComponent("minecraft:health")?.currentValue ?? 0; } catch { return 0; }
}

function getAabb(entity) {
  try { return entity.getAABB(); } catch { return null; }
}

function getBodyYaw(entity) {
  try {
    const rotation = entity.getRotation();
    return typeof rotation?.y === "number" ? rotation.y : 0;
  } catch {
    return 0;
  }
}

function projectileImpactPoint(projectile) {
  if (!projectile) return null;
  const aabb = getAabb(projectile);
  if (aabb?.center) return copyPosition(aabb.center);
  try {
    return projectile.location ? copyPosition(projectile.location) : null;
  } catch {
    return null;
  }
}

function projectileHitsMultipartPart(parent, projectile) {
  const point = projectileImpactPoint(projectile);
  if (!point) return null;
  return multipartAabbs({
    position: copyPosition(parent.location),
    yawDegrees: getBodyYaw(parent),
  }).find((part) => pointInsideAabb(point, part)) ?? null;
}

function isEntityOnFire(entity) {
  if (!entity) return false;
  try {
    const value = entity.isOnFire;
    if (typeof value === "function" && value.call(entity) === true) return true;
    if (value === true) return true;
  } catch {}
  try {
    return Boolean(entity.getComponent("minecraft:onfire"));
  } catch {
    return false;
  }
}

function isRoamDamageIgnored(cause) {
  return cause === EntityDamageCause.fall || cause === EntityDamageCause.suffocation ||
    cause === "fall" || cause === "suffocation";
}

function applyMultipartArrowEffects(entity, plan) {
  if (plan.igniteSeconds <= 0 && plan.spectralGlowTicks <= 0) return;
  try {
    system.run(() => {
      if (!isValid(entity)) return;
      if (plan.igniteSeconds > 0) {
        callEntity(entity, "setOnFire", plan.igniteSeconds, true);
      }
      if (plan.spectralGlowTicks > 0) {
        callEntity(entity, "addEffect", "glowing", plan.spectralGlowTicks);
      }
    });
  } catch {}
}

function hasGroundSupport(entity) {
  try { return entity.isOnGround === true; } catch { return false; }
}

function dimensionsToTick() {
  const dimensions = [];
  for (const id of ["overworld", "nether", "the_end", "thebrokenscript:stage2", "thebrokenscript:void_shadow"]) {
    const dimension = perf.dim(id);
    if (dimension) dimensions.push(dimension);
  }
  return dimensions;
}

function nearestPlayer(entity, maxDistance = 1000) {
  let closest = null;
  let closestDistance = maxDistance;
  let players = [];
  try { players = world.getAllPlayers(); } catch { return null; }
  for (const player of players) {
    try {
      if (!isValid(player) || player.dimension.id !== entity.dimension.id) continue;
      const currentDistance = distance(entity.location, player.location);
      if (currentDistance < closestDistance) {
        closest = player;
        closestDistance = currentDistance;
      }
    } catch {}
  }
  return closest;
}

function getFracturedState(entity) {
  let state = fracturedStates.get(entity.id);
  if (state) return state;
  state = {
    attack: "noop",
    attackDelay: FRACTURED_LIFECYCLE_SOURCE.initialAttackDelayTicks,
    attackTicks: 0,
    timesAttacked: 0,
    attackedCooldown: 0,
    defeated: callEntity(entity, "hasTag", DEFEATED_TAG) === true,
    emitted: new Set(),
    attackTag: null,
  };
  fracturedStates.set(entity.id, state);
  return state;
}

function getRockState(entity) {
  let state = rockStates.get(entity.id);
  if (state) return state;
  state = {
    owner: null,
    ownerId: null,
    previousPosition: copyPosition(entity.location),
    grounded: false,
    groundedTicks: 0,
    pulseDueTick: null,
    pulsePosition: null,
    pulseApplied: false,
  };
  rockStates.set(entity.id, state);
  return state;
}

function getFracturedRoamLifecycleState(entity) {
  let state = roamLifecycleStates.get(entity.id);
  if (state) return state;
  state = {
    entity,
    state: "RISING",
    riseTicks: FRACTURED_ROAM_SOURCE.riseTicks,
    digTicks: FRACTURED_ROAM_SOURCE.digAnimationTicks,
    despawnTicks: FRACTURED_ROAM_SOURCE.despawnAnimationTicks,
    serverTimer: FRACTURED_ROAM_SOURCE.serverTimerTicks,
    aiEnabled: false,
    digCooldown: 0,
    despawnTimer: fracturedRoamRandomInclusive(
      FRACTURED_ROAM_SOURCE.despawnTimerMinTicks,
      FRACTURED_ROAM_SOURCE.despawnTimerMaxTicks,
    ),
    undergroundTimer: 0,
    navigationCooldown: 0,
    wanderTarget: null,
  };
  roamLifecycleStates.set(entity.id, state);
  callEntity(entity, "addTag", ROAM_NO_AI_TAG);
  return state;
}

function randomRoamTarget(entity) {
  const angle = Math.random() * Math.PI * 2;
  const radius = Math.random() * 30;
  return {
    x: entity.location.x + Math.cos(angle) * radius,
    y: entity.location.y + (Math.random() * 14 - 7),
    z: entity.location.z + Math.sin(angle) * radius,
  };
}

function moveRoamToward(entity, target, speed) {
  if (!target) return;
  const dx = target.x - entity.location.x;
  const dz = target.z - entity.location.z;
  const horizontalDistance = Math.hypot(dx, dz);
  if (horizontalDistance < 0.125) return;
  const amount = Math.min(speed, horizontalDistance);
  try {
    entity.teleport({
      x: entity.location.x + (dx / horizontalDistance) * amount,
      y: entity.location.y,
      z: entity.location.z + (dz / horizontalDistance) * amount,
    });
  } catch {}
}

function tickFracturedRoamMovement(entity, state) {
  if (!state.aiEnabled || state.state === "SWITCHING" || state.state === "DESPAWNING") return;

  if (state.state === "NORMAL") {
    if (!hasGroundSupport(entity)) return;
    if (!state.wanderTarget && fracturedRoamStrollDue(system.currentTick)) {
      state.wanderTarget = randomRoamTarget(entity);
    }
    if (state.wanderTarget) {
      moveRoamToward(entity, state.wanderTarget, ROAM_STROLL_MOVEMENT_ADAPTER);
      if (distance(entity.location, state.wanderTarget) < 0.5) state.wanderTarget = null;
    }
    return;
  }

  if (state.state !== "DIGGING" && state.state !== "UNDERGROUND") return;
  const target = nearestPlayer(entity);
  if (target && distance(entity.location, target.location) >= 5) {
    if (state.navigationCooldown <= 0) {
      state.wanderTarget = copyPosition(target.location);
      state.navigationCooldown = fracturedRoamRandomInt(
        FRACTURED_ROAM_SOURCE.navigationCooldownMinTicks,
        FRACTURED_ROAM_SOURCE.navigationCooldownMaxExclusive,
      );
    } else {
      state.navigationCooldown -= 1;
    }
  } else if (!target) {
    if (!state.wanderTarget) state.wanderTarget = randomRoamTarget(entity);
    if (state.navigationCooldown <= 0) {
      state.navigationCooldown = fracturedRoamRandomInt(
        FRACTURED_ROAM_SOURCE.navigationCooldownMinTicks,
        FRACTURED_ROAM_SOURCE.navigationCooldownMaxExclusive,
      );
    } else {
      state.navigationCooldown -= 1;
    }
  }
  if (state.wanderTarget) {
    moveRoamToward(entity, state.wanderTarget, ROAM_DIG_MOVEMENT_ADAPTER);
    if (distance(entity.location, state.wanderTarget) < 0.5) state.wanderTarget = null;
  }
}

function tickFracturedRoamLifecycle(entity) {
  const state = getFracturedRoamLifecycleState(entity);
  if (state.state === "SWITCHING") return true;

  const baseStep = fracturedRoamBaseTick({
    state: state.state,
    riseTicks: state.riseTicks,
    digTicks: state.digTicks,
    despawnTicks: state.despawnTicks,
  });
  state.state = baseStep.state;
  state.riseTicks = baseStep.riseTicks;
  state.digTicks = baseStep.digTicks;
  state.despawnTicks = baseStep.despawnTicks;
  if (baseStep.discarded) {
    safeRemove(entity);
    roamLifecycleStates.delete(entity.id);
    return false;
  }

  const serverTimer = fracturedRoamServerTimerStep(state.serverTimer);
  state.serverTimer = serverTimer.timer;
  if (serverTimer.enableAi) {
    state.aiEnabled = true;
    callEntity(entity, "removeTag", ROAM_NO_AI_TAG);
  }

  if (state.digCooldown > 0 && state.state === "NORMAL") state.digCooldown -= 1;

  const despawnStep = fracturedRoamDespawnStep({
    state: state.state,
    despawnTimer: state.despawnTimer,
  });
  state.despawnTimer = despawnStep.despawnTimer;
  state.state = despawnStep.state;

  if (state.state === "DIGGING" || state.state === "UNDERGROUND") {
    // canContinueToUse() is checked before the goal tick. A zero timer therefore
    // stops the goal on the following runtime tick, matching Java's goal order.
    if (state.undergroundTimer <= 0) {
      const stop = fracturedRoamDigGoalStop(fracturedRoamRandomInt(
        FRACTURED_ROAM_SOURCE.digCooldownMinTicks,
        FRACTURED_ROAM_SOURCE.digCooldownMaxExclusive,
      ));
      state.state = stop.state;
      state.riseTicks = stop.riseTicks;
      state.digCooldown = stop.digCooldown;
      state.navigationCooldown = 0;
      state.wanderTarget = null;
    } else {
      state.undergroundTimer -= 1;
    }
  }

  if (state.state === "NORMAL" && state.aiEnabled && fracturedRoamDigEligibility({
    state: state.state,
    digCooldown: state.digCooldown,
    roll: Math.floor(Math.random() * FRACTURED_ROAM_SOURCE.digRollBound),
  })) {
    const start = fracturedRoamDigGoalStart(fracturedRoamRandomInt(
      FRACTURED_ROAM_SOURCE.undergroundTimerMinTicks,
      FRACTURED_ROAM_SOURCE.undergroundTimerMaxExclusive,
    ));
    state.state = start.state;
    state.undergroundTimer = start.undergroundTimer;
    state.digTicks = start.digTicks;
    state.navigationCooldown = 0;
    state.wanderTarget = null;
  }

  return true;
}

function removeFracturedState(entity) {
  fracturedStates.delete(entity?.id);
}

function removeRockState(entity) {
  rockStates.delete(entity?.id);
}

function runAfter(callback, ticks) {
  try {
    const scheduler = /** @type {any} */ (system);
    if (typeof scheduler.runTimeout === "function") {
      scheduler.runTimeout(callback, ticks);
      return true;
    }
  } catch {}
  return false;
}

function playersNearArena(dimension, center) {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return []; }
  return players.filter((player) => {
    try {
      return isValid(player) && player.dimension.id === dimension.id &&
        distance(player.location, center) <= ROAM_ARENA_SOURCE.playerRange;
    } catch {
      return false;
    }
  });
}

function refreshArenaPlayers(arena) {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return []; }
  const current = new Map();
  for (const player of players) {
    try {
      if (isValid(player) && arena.playerIds.has(player.id)) current.set(player.id, player);
    } catch {}
  }
  arena.players = current;
  return [...current.values()];
}

function arenaHasLivingPlayers(arena) {
  const players = refreshArenaPlayers(arena);
  if (players.length === 0) return false;
  // JimArena intentionally treats one or two cached players as sufficient,
  // even when they are dead; with three or more, one living player is required.
  if (players.length <= 2) return true;
  return players.some((player) => getHealth(player) > 0);
}

function playArenaSound(arena, sound) {
  for (const player of arena.players.values()) {
    try { player.playSound(sound, { volume: 1, pitch: 1 }); } catch {}
  }
}

function spawnArenaSubAnomalies(arena) {
  for (let index = 0; index < FRACTURED_ROAM_SOURCE.arenaSubAnomalyCount; index += 1) {
    const angle = Math.random() * Math.PI * 2;
    const radius = Math.sqrt(Math.random()) * FRACTURED_ROAM_SOURCE.arenaSubAnomalyRadius;
    const location = {
      x: arena.center.x + Math.cos(angle) * radius,
      y: arena.center.y,
      z: arena.center.z + Math.sin(angle) * radius,
    };
    try {
      const subAnomaly = arena.dimension.spawnEntity("thebrokenscript:sub_anomaly_2", location);
      if (subAnomaly) arena.subAnomalies.push(subAnomaly);
    } catch (error) {
      logger.warn(`fractured arena SubAnomaly2 spawn unavailable: ${error}`);
    }
  }
}

function finishFracturedRoamArenaIntro(arena) {
  if (!arena || arena.musicStarted || !arenaHasLivingPlayers(arena)) return;
  arena.musicStarted = true;
  playArenaSound(arena, ROAM_ARENA_SOURCE.loopSound);
  spawnArenaSubAnomalies(arena);
  arena.pendingSubAnomalies = 0;
  arena.subAnomalyCount = arena.subAnomalies.length;
  arena.subAnomalyRadius = FRACTURED_ROAM_SOURCE.arenaSubAnomalyRadius;
}

function startFracturedRoamArena(entity) {
  const center = copyPosition(entity.location);
  const players = playersNearArena(entity.dimension, center);
  let jimmy = null;
  try { jimmy = entity.dimension.spawnEntity(FRACTURED_TYPE, center); } catch (error) {
    logger.warn(`fractured arena spawn unavailable: ${error}`);
    return null;
  }
  if (!jimmy) return null;

  const arena = {
    dimension: entity.dimension,
    center,
    jimmy,
    playerIds: new Set(players.map((player) => player.id)),
    players: new Map(players.map((player) => [player.id, player])),
    subAnomalies: [],
    introTicks: ROAM_ARENA_SOURCE.startMusicTicks,
    musicScheduled: false,
    musicStarted: false,
    pendingSubAnomalies: 0,
    subAnomalyRadius: ROAM_ARENA_SOURCE.subAnomalyRadius,
  };
  roamArenaStates.set(jimmy.id, arena);
  for (const player of players) {
    try { player.playSound(ROAM_ARENA_SOURCE.introSound, { volume: 1, pitch: 1 }); } catch {}
  }
  // Source: JimArena.START_MUSIC_TICKS = 340. The callback remains guarded by
  // arena identity because Java reset() can run before the delayed event.
  arena.musicScheduled = runAfter(() => {
    if (roamArenaStates.get(jimmy.id) === arena && isValid(jimmy)) finishFracturedRoamArenaIntro(arena);
  }, ROAM_ARENA_SOURCE.startMusicTicks)) {
    arena.musicScheduled = false;
  }
  return jimmy;
}

function resetFracturedRoamArena(arena) {
  if (!arena) return;
  safeRemove(arena.jimmy);
  for (const subAnomaly of arena.subAnomalies ?? []) safeRemove(subAnomaly);
  roamArenaStates.delete(arena.jimmy?.id);
  arena.players.clear();
  // Java also stops all arena sounds and clears the bossbar. Those presentation
  // services have no stable equivalent in the current Bedrock pack.
}

function tickFracturedRoamArenas() {
  for (const [id, arena] of roamArenaStates) {
    if (!arena?.jimmy || !isValid(arena.jimmy)) {
      resetFracturedRoamArena(arena);
      continue;
    }
    if (!arenaHasLivingPlayers(arena)) {
      resetFracturedRoamArena(arena);
      continue;
    }
    if (!arena.musicScheduled && !arena.musicStarted) {
      arena.introTicks -= 1;
      if (arena.introTicks <= 0) finishFracturedRoamArenaIntro(arena);
    }
  }
}

function beginFracturedRoamSwitch(entity) {
  if (!isValid(entity) || roamSwitchStates.has(entity.id)) return;
  const lifecycle = getFracturedRoamLifecycleState(entity);
  if (lifecycle.state !== "NORMAL") return;
  lifecycle.state = FRACTURED_MULTIPART_SOURCE.roamSwapState;
  roamSwitchStates.set(entity.id, {
    entity,
    switchTicks: FRACTURED_ROAM_SOURCE.switchingTicks,
  });
  callEntity(entity, "addTag", ROAM_SWITCH_TAG);
}

function tickFracturedRoamSwitch(entity, state) {
  if (!isValid(entity)) {
    roamSwitchStates.delete(entity?.id);
    return;
  }
  const switchStep = fracturedRoamSwitchStep(state.switchTicks);
  state.switchTicks = switchStep.switchTicks;
  if (!switchStep.promote) return;
  const fractured = startFracturedRoamArena(entity);
  if (!fractured) return;
  safeRemove(entity);
  roamSwitchStates.delete(entity.id);
  roamLifecycleStates.delete(entity.id);
}

