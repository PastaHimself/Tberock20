import { EntityDamageCause, EquipmentSlot, world, system } from "@minecraft/server";
import * as perf from "../../systems/perf.js";
import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { applyDamageWithSource } from "../../systems/damage_source_runtime.js";
import {
  FRACTURED_ATTACKS,
  FRACTURED_LIFECYCLE_SOURCE,
  FRACTURED_RISING_SOURCE,
  FRACTURED_SOURCE,
  chooseFracturedAttack,
  fracturedAttackStep,
  fracturedDefeatStep,
  fracturedImpactPlan,
  fracturedRockBlockBurstPlan,
  fracturedRockFlightStep,
  fracturedRockImpactPlan,
  fracturedRisingImpactPlan,
  fracturedRisingStep,
} from "../../systems/fractured_attack_model.js";
import {
  FRACTURED_MULTIPART_SOURCE,
  fracturedPartHitPlan,
  fracturedRoamSwitchStep,
  multipartPartDefinitions,
  multipartProjectileHitPlan,
  shouldApplyMultipartArrowEffects,
} from "../../systems/fractured_multipart_model.js";
import {
  fracturedAnimationEventPlan,
  fracturedAnimationId,
  fracturedPresentationAnimationId,
} from "../../systems/fractured_animation_model.js";
import {
  FRACTURED_ROAM_SOURCE,
  fracturedRoamArenaPlan,
  fracturedRoamArenaRosterStep,
  fracturedRoamBaseTick,
  fracturedRoamDespawnStep,
  fracturedRoamDigEligibility,
  fracturedRoamDigGoalStart,
  fracturedRoamDigGoalStop,
  fracturedRoamFindSurfaceAhead,
  fracturedRoamMoveControlStep,
  fracturedRoamRandomInclusive,
  fracturedRoamRandomInt,
  fracturedRoamRecoveryStep,
  fracturedRoamServerTimerStep,
  fracturedRoamSupportAhead,
  fracturedRoamSupportNear,
  fracturedRoamStrollDue,
  fracturedRoamTargetRange,
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

// BaseFracturedEntity's RoamMoveControl uses the Java movement attribute. This
// is the existing Bedrock movement conversion, not a source combat constant.
const MOVEMENT_ADAPTER_BLOCKS_PER_TICK = 0.075;
const COLLISION_SUBSTEP_BLOCKS = 0.4;
const ROAM_ARENA_SOURCE = fracturedRoamArenaPlan();
const FRACTURED_RISING_SOURCE_ID = FRACTURED_RISING_SOURCE.sourceId;

const fracturedStates = new Map();
const fracturedLifecycleStates = new Map();
const rockStates = new Map();
const projectilePositions = new Map();
const projectileEntities = new Map();
const roamSwitchStates = new Map();
const roamLifecycleStates = new Map();
const roamArenaStates = new Map();
const contactOriginAdapters = new Map();
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
  try { return entity.getComponent("minecraft:health")?.currentValue ?? 0; } catch (error) {
    operationDiagnostics.warnOnce("fractured.health", "fractured: health query failed; using zero fallback", error);
    return 0;
  }
}

function getAabb(entity) {
  try { return entity.getAABB(); } catch (error) {
    operationDiagnostics.warnOnce("fractured.aabb", "fractured: AABB query failed; preserving location fallback", error);
    return null;
  }
}

function getBodyYaw(entity) {
  try {
    const rotation = entity.getRotation();
    return typeof rotation?.y === "number" ? rotation.y : 0;
  } catch (error) {
    operationDiagnostics.warnOnce("fractured.yaw", "fractured: body-yaw query failed; using zero fallback", error);
    return 0;
  }
}

/**
 * Validates an optional rendered-bone adapter without depending on a future
 * Bedrock API. The root position is the deterministic current fallback.
 */
export function resolveFracturedContactOrigin(entity, locator, fallback = entity?.location) {
  try {
    const value = typeof locator === "function" ? locator(entity) : null;
    if (value && ["x", "y", "z"].every((axis) => Number.isFinite(value[axis]))) {
      return { x: value.x, y: value.y, z: value.z };
    }
  } catch (error) {
    operationDiagnostics.warnOnce("fractured.contact_origin", "fractured: contact-origin adapter failed; using root fallback", error);
  }
  if (fallback && ["x", "y", "z"].every((axis) => Number.isFinite(fallback[axis]))) {
    return { x: fallback.x, y: fallback.y, z: fallback.z };
  }
  return null;
}

/** Registers a future locator/bone adapter; null removes the adapter. */
export function registerFracturedContactOriginAdapter(locator, resolver) {
  if (typeof locator !== "string" || !locator) return false;
  if (typeof resolver === "function") contactOriginAdapters.set(locator, resolver);
  else contactOriginAdapters.delete(locator);
  return true;
}

function fracturedContactOrigin(entity, locator) {
  return resolveFracturedContactOrigin(entity, contactOriginAdapters.get(locator), entity?.location);
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

function isTrackedProjectile(entity) {
  return entity?.typeId === "minecraft:arrow" ||
    entity?.typeId === "minecraft:spectral_arrow" ||
    entity?.typeId === "minecraft:trident";
}

function rememberProjectileEntity(projectile) {
  if (!isTrackedProjectile(projectile) || !isValid(projectile)) return;
  projectileEntities.set(projectile.id, projectile);
}

function trackProjectilePositions() {
  for (const [id, projectile] of projectileEntities) {
    if (!isValid(projectile)) {
      projectileEntities.delete(id);
      projectilePositions.delete(id);
      continue;
    }
    const position = projectileImpactPoint(projectile);
    if (!position) {
      projectileEntities.delete(id);
      projectilePositions.delete(id);
      continue;
    }
    projectilePositions.set(id, position);
  }
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

function roamIsAirAt(dimension, position) {
  const block = blockAt(dimension, position);
  if (!block) return false;
  try { return block.isAir === true; } catch { return false; }
}

function roamMinimumBuildHeight(dimension) {
  try {
    const range = dimension.heightRange;
    return typeof range?.min === "number" ? range.min : -64;
  } catch {
    return -64;
  }
}

function recoverFracturedFromAir(entity, state) {
  if (hasGroundSupport(entity)) {
    state.lastSafeGroundPosition = copyPosition(entity.location);
    state.airborneTicks = 0;
    return;
  }

  const safe = state.lastSafeGroundPosition;
  const recovery = fracturedRoamRecoveryStep({
    onGround: false,
    airborneTicks: state.airborneTicks,
    safeY: safe?.y ?? null,
    currentY: entity.location.y,
  });
  state.airborneTicks = recovery.airborneTicks;
  if (!recovery.recover) return;

  const surface = fracturedRoamFindSurfaceAhead({
    position: copyPosition(entity.location),
    yawDegrees: getBodyYaw(entity),
    minBuildHeight: roamMinimumBuildHeight(entity.dimension),
    isAirAt: (position) => roamIsAirAt(entity.dimension, position),
  }) ?? safe;
  callEntity(entity, "clearVelocity");
  callEntity(entity, "clearFallDistance");
  try { entity.teleport(surface); } catch { return; }
  state.lastSafeGroundPosition = copyPosition(surface);
  state.airborneTicks = 0;
  state.wanderTarget = null;
  state.lastPosition = copyPosition(surface);
  state.stuckTicks = 0;
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

function getFracturedLifecycleState(entity) {
  let state = fracturedLifecycleStates.get(entity.id);
  if (state) return state;
  state = {
    entity,
    state: callEntity(entity, "hasTag", DEFEATED_TAG) === true ? "DEFEATED" : "RISING",
    riseTicks: FRACTURED_RISING_SOURCE.durationTicks,
    digTicks: FRACTURED_ROAM_SOURCE.digAnimationTicks,
    despawnTicks: FRACTURED_ROAM_SOURCE.despawnAnimationTicks,
    switchTicks: FRACTURED_ROAM_SOURCE.switchingTicks,
    lastSafeGroundPosition: hasGroundSupport(entity) ? copyPosition(entity.location) : null,
    airborneTicks: 0,
    wanderTarget: null,
    stuckTicks: 0,
    lastPosition: copyPosition(entity.location),
    presentationAnimation: null,
  };
  fracturedLifecycleStates.set(entity.id, state);
  playFracturedSpawnSound(entity);
  playFracturedPresentation(entity, state, false);
  return state;
}

function getFracturedState(entity) {
  let state = fracturedStates.get(entity.id);
  if (state) return state;
  state = {
    entity,
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
  getFracturedLifecycleState(entity);
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
    lastSafeGroundPosition: hasGroundSupport(entity) ? copyPosition(entity.location) : null,
    airborneTicks: 0,
    stuckTicks: 0,
    lastPosition: copyPosition(entity.location),
    presentationAnimation: null,
  };
  roamLifecycleStates.set(entity.id, state);
  callEntity(entity, "addTag", ROAM_NO_AI_TAG);
  playFracturedSpawnSound(entity);
  playFracturedPresentation(entity, state, false);
  return state;
}

function playFracturedSpawnSound(entity) {
  try {
    entity.dimension.playSound("thebrokenscript:jimmy.spawn", entity.location, {
      volume: 1,
      pitch: 1,
    });
  } catch {}
}

function playFracturedPresentation(entity, state, moving) {
  const animationId = fracturedPresentationAnimationId(state.state, moving);
  if (state.presentationAnimation === animationId) return;
  state.presentationAnimation = animationId;
  callEntity(entity, "playAnimation", animationId);
}

function randomRoamTarget(entity, horizontalRange = fracturedRoamTargetRange("NORMAL")) {
  const angle = Math.random() * Math.PI * 2;
  const radius = Math.random() * horizontalRange;
  return {
    x: entity.location.x + Math.cos(angle) * radius,
    y: entity.location.y + (Math.random() * FRACTURED_ROAM_SOURCE.randomStrollVerticalRange * 2 - FRACTURED_ROAM_SOURCE.randomStrollVerticalRange),
    z: entity.location.z + Math.sin(angle) * radius,
  };
}

function moveRoamToward(entity, target, sourceSpeedModifier) {
  if (!target) return false;
  const location = copyPosition(entity.location);
  const control = fracturedRoamMoveControlStep({
    operation: "MOVE_TO",
    position: location,
    wanted: target,
    yawDegrees: getBodyYaw(entity),
    speedModifier: sourceSpeedModifier,
    movementSpeed: MOVEMENT_ADAPTER_BLOCKS_PER_TICK,
  });
  if (control.operation !== "MOVE_TO") return false;
  const dx = target.x - location.x;
  const dz = target.z - location.z;
  const horizontalDistance = Math.hypot(dx, dz);
  const amount = Math.min(control.speed, horizontalDistance);
  try {
    entity.teleport({
      x: location.x + (dx / horizontalDistance) * amount,
      y: location.y,
      z: location.z + (dz / horizontalDistance) * amount,
    }, { rotation: { x: 0, y: control.yawDegrees } });
    return true;
  } catch { return false; }
}

function tickFracturedRoamMovement(entity, state) {
  if (!state.aiEnabled || state.state === "SWITCHING" || state.state === "DESPAWNING") return;

  if (state.state === "NORMAL") {
    if (!hasGroundSupport(entity)) {
      playFracturedPresentation(entity, state, false);
      return;
    }
    if (!state.wanderTarget && fracturedRoamStrollDue(system.currentTick)) {
      const target = randomRoamTarget(entity, fracturedRoamTargetRange("NORMAL"));
      if (fracturedRoamSupportNear({
        position: target,
        isAirAt: (position) => roamIsAirAt(entity.dimension, position),
      })) {
        state.wanderTarget = target;
        state.lastPosition = copyPosition(entity.location);
        state.stuckTicks = 0;
      }
    }
    if (!state.wanderTarget) {
      playFracturedPresentation(entity, state, false);
      return;
    }
    if (!fracturedRoamSupportAhead({
      current: entity.location,
      wanted: state.wanderTarget,
      isAirAt: (position) => roamIsAirAt(entity.dimension, position),
    })) {
      state.stuckTicks = 21;
      state.wanderTarget = null;
      playFracturedPresentation(entity, state, false);
      return;
    }
    playFracturedPresentation(entity, state, true);
    moveRoamToward(entity, state.wanderTarget, FRACTURED_ROAM_SOURCE.randomStrollSpeedModifier);
    const dx = state.wanderTarget.x - entity.location.x;
    const dz = state.wanderTarget.z - entity.location.z;
    if (dx * dx + dz * dz <= 1) {
      state.wanderTarget = null;
      state.stuckTicks = 0;
      playFracturedPresentation(entity, state, false);
      return;
    }
    const movedDistance = distance(entity.location, state.lastPosition);
    if (movedDistance * movedDistance < 0.0025) state.stuckTicks += 1;
    else {
      state.stuckTicks = 0;
      state.lastPosition = copyPosition(entity.location);
    }
    if (state.stuckTicks > FRACTURED_ROAM_SOURCE.strollStuckTicks) {
      state.wanderTarget = null;
      state.stuckTicks = 0;
      playFracturedPresentation(entity, state, false);
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
    if (!state.wanderTarget) {
      state.wanderTarget = randomRoamTarget(entity, fracturedRoamTargetRange("UNDERGROUND"));
    }
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
    playFracturedPresentation(entity, state, true);
    moveRoamToward(entity, state.wanderTarget, FRACTURED_ROAM_SOURCE.navigationSpeedModifier);
    if (distance(entity.location, state.wanderTarget) < 0.5) {
      state.wanderTarget = null;
      playFracturedPresentation(entity, state, false);
    }
  }
}

function tickFracturedRoamLifecycle(entity) {
  const state = getFracturedRoamLifecycleState(entity);
  const previousState = state.state;
  recoverFracturedFromAir(entity, state);
  if (state.state === "SWITCHING") {
    playFracturedPresentation(entity, state, false);
    return true;
  }

  if (!tickFracturedBaseLifecycle(entity, state)) {
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

  if (state.state !== previousState) playFracturedPresentation(entity, state, false);

  return true;
}

function removeFracturedState(entity) {
  fracturedStates.delete(entity?.id);
  fracturedLifecycleStates.delete(entity?.id);
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
  const candidates = [];
  for (const player of players) {
    try {
      const sameArenaRoster = arena.playerIds.has(player.id) ||
        (player.name && arena.playerNames?.has(player.name));
      if (isValid(player) && player.dimension.id === arena.dimension.id && sameArenaRoster) {
        candidates.push(player);
      }
    } catch {}
  }
  const rosterStep = fracturedRoamArenaRosterStep({
    previous: arena.players,
    current: candidates,
  });
  arena.players = rosterStep.roster;
  for (const player of arena.players.values()) {
    if (player?.id != null) arena.playerIds.add(player.id);
  }
  return [...arena.players.values()];
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
    try {
      const instance = player.playSound(sound, { volume: 1, pitch: 1 });
      if (instance && typeof instance.stop === "function") {
        arena.soundInstances.push(instance);
        arena.soundInstanceOwners.set(instance, {
          id: player.id ?? null,
          name: player.name ?? null,
        });
      }
      else if (typeof player.stopSound === "function") arena.soundStops.push({ player, sound });
    } catch {}
  }
}

function stopArenaSounds(arena) {
  for (const instance of arena.soundInstances ?? []) {
    try { instance.stop(); } catch {}
  }
  for (const { player, sound } of arena.soundStops ?? []) {
    try { player.stopSound(sound); } catch {}
  }
  arena.soundInstances = [];
  arena.soundStops = [];
  arena.soundInstanceOwners?.clear();
}

function playerIdentity(playerOrId, playerName = null) {
  if (playerOrId && typeof playerOrId === "object") {
    return { id: playerOrId.id ?? null, name: playerOrId.name ?? null };
  }
  return { id: playerOrId ?? null, name: playerName ?? null };
}

function identityMatches(player, identity) {
  if (!player || !identity) return false;
  return (identity.id != null && player.id === identity.id) ||
    (identity.name != null && player.name === identity.name);
}

function stopArenaSoundsForPlayer(arena, identity) {
  const remainingInstances = [];
  for (const instance of arena.soundInstances ?? []) {
    const owner = arena.soundInstanceOwners?.get(instance);
    if (identityMatches(owner, identity)) {
      try { instance.stop(); } catch {}
      arena.soundInstanceOwners?.delete(instance);
    } else {
      remainingInstances.push(instance);
    }
  }
  arena.soundInstances = remainingInstances;

  const remainingStops = [];
  for (const entry of arena.soundStops ?? []) {
    if (identityMatches(entry.player, identity)) {
      try { entry.player.stopSound(entry.sound); } catch {}
    } else {
      remainingStops.push(entry);
    }
  }
  arena.soundStops = remainingStops;
}

function detachPlayerFromArena(arena, identity) {
  let detached = false;
  for (const [key, player] of arena.players) {
    if (key === identity.id || identityMatches(player, identity)) {
      arena.players.delete(key);
      detached = true;
    }
  }
  if (identity.id != null) arena.playerIds.delete(identity.id);
  if (identity.name != null) arena.playerNames.delete(identity.name);
  if (detached) stopArenaSoundsForPlayer(arena, identity);
  return detached;
}

function detachPlayerFromArenas(playerOrId, playerName = null) {
  const identity = playerIdentity(playerOrId, playerName);
  let detached = 0;
  for (const arena of [...roamArenaStates.values()]) {
    if (!detachPlayerFromArena(arena, identity)) continue;
    detached += 1;
    if (arena.players.size === 0) resetFracturedRoamArena(arena);
  }
  return detached;
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
      operationDiagnostics.warnOnce("fractured.arena_sub_anomaly", "fractured: arena SubAnomaly2 spawn unavailable", error);
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
    operationDiagnostics.errorOnce("fractured.arena_spawn", "fractured: arena Jimmy spawn unavailable", error);
    return null;
  }
  if (!jimmy) return null;
  // Ensure the source RISING lifecycle is initialized even when the engine's
  // after-spawn event is delayed or unavailable for this entity.
  getFracturedState(jimmy);

  const arena = {
    dimension: entity.dimension,
    center,
    jimmy,
    playerIds: new Set(players.map((player) => player.id)),
    playerNames: new Set(players.map((player) => player.name).filter(Boolean)),
    players: new Map(players.map((player) => [player.id, player])),
    subAnomalies: [],
    soundInstances: [],
    soundInstanceOwners: new Map(),
    soundStops: [],
    introTicks: ROAM_ARENA_SOURCE.startMusicTicks,
    musicScheduled: false,
    musicStarted: false,
    pendingSubAnomalies: 0,
    subAnomalyRadius: ROAM_ARENA_SOURCE.subAnomalyRadius,
  };
  roamArenaStates.set(jimmy.id, arena);
  playArenaSound(arena, ROAM_ARENA_SOURCE.introSound);
  // Source: JimArena.START_MUSIC_TICKS = 340. The callback remains guarded by
  // arena identity because Java reset() can run before the delayed event.
  arena.musicScheduled = runAfter(() => {
    if (roamArenaStates.get(jimmy.id) === arena && isValid(jimmy)) finishFracturedRoamArenaIntro(arena);
  }, ROAM_ARENA_SOURCE.startMusicTicks);
  return jimmy;
}

function resetFracturedRoamArena(arena) {
  if (!arena) return;
  stopArenaSounds(arena);
  safeRemove(arena.jimmy);
  for (const subAnomaly of arena.subAnomalies ?? []) safeRemove(subAnomaly);
  roamArenaStates.delete(arena.jimmy?.id);
  arena.players.clear();
  arena.playerIds.clear();
  arena.playerNames.clear();
  // The Java bossbar remains unsupported, but SoundInstance.stop preserves the
  // source AudioFader cleanup for the intro and looping arena tracks.
}

/** Stop arena audio and remove a player who disconnected before the next tick. */
export function onPlayerLeave(playerId, playerName = null) {
  return detachPlayerFromArenas(playerId, playerName);
}

/** Stop arena audio when a participant changes dimension. */
export function onPlayerDimensionChange(player) {
  return detachPlayerFromArenas(player);
}

/** Stop arena audio and remove a participant on death. */
export function onPlayerDeath(player) {
  return detachPlayerFromArenas(player);
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
  playFracturedPresentation(entity, lifecycle, false);
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
  if (!fractured) {
    const lifecycle = getFracturedRoamLifecycleState(entity);
    lifecycle.state = "NORMAL";
    callEntity(entity, "removeTag", ROAM_SWITCH_TAG);
    roamSwitchStates.delete(entity.id);
    playFracturedPresentation(entity, lifecycle, false);
    return;
  }
  safeRemove(entity);
  roamSwitchStates.delete(entity.id);
  roamLifecycleStates.delete(entity.id);
}

function tickRoamSwitchStates() {
  for (const [id, state] of roamSwitchStates) {
    if (!state?.entity) {
      roamSwitchStates.delete(id);
      continue;
    }
    tickFracturedRoamSwitch(state.entity, state);
  }
}

function safeRemove(entity) {
  try { entity.remove(); } catch (error) {
    operationDiagnostics.warnOnce("fractured.remove", "fractured: entity removal failed; using kill fallback", error);
    try { entity.kill(); } catch (fallbackError) {
      operationDiagnostics.errorOnce("fractured.kill_fallback", "fractured: kill fallback failed", fallbackError);
    }
  }
}

function playFracturedAnimation(entity, attack) {
  callEntity(entity, "playAnimation", fracturedAnimationId(attack));
}

function setAttackTag(entity, state, attack) {
  if (state.attackTag) callEntity(entity, "removeTag", state.attackTag);
  state.attackTag = attack === "noop" ? null : `${ATTACK_TAG_PREFIX}${attack}`;
  if (state.attackTag) callEntity(entity, "addTag", state.attackTag);
  playFracturedAnimation(entity, attack);
}

function setDefeated(entity, state) {
  state.defeated = true;
  state.attack = "noop";
  state.attackDelay = 0;
  state.attackTicks = 0;
  state.emitted.clear();
  setAttackTag(entity, state, "noop");
  callEntity(entity, "addTag", DEFEATED_TAG);
  const lifecycle = getFracturedLifecycleState(entity);
  lifecycle.state = "DEFEATED";
  // Java switches to BaseFracturedEntity.JimmyStates.DEFEATED and the death
  // controller plays Loss. Bedrock has no server-side GeckoLib controller, but
  // its playAnimation bridge can start the same resource-pack animation.
  playFracturedAnimation(entity, "loss");
}

function applyDamage(target, amount, damagingEntity, damagingProjectile = null, sourceId = null) {
  if (!isValid(target)) return false;
  if (sourceId) {
    return applyDamageWithSource(target, amount, sourceId, {
      cause: damagingProjectile ? EntityDamageCause.projectile : EntityDamageCause.entityAttack,
      damagingEntity,
      damagingProjectile,
    }).accepted;
  }
  try {
    const options = {
      cause: EntityDamageCause.entityAttack,
      damagingEntity,
    };
    if (damagingProjectile) options.damagingProjectile = damagingProjectile;
    return target.applyDamage(amount, options) === true;
  } catch (error) {
    operationDiagnostics.warnOnce("fractured.damage", "fractured: attributed damage failed; using un-attributed fallback", error);
    try { return target.applyDamage(amount) === true; } catch (fallbackError) {
      operationDiagnostics.errorOnce("fractured.damage_fallback", "fractured: damage fallback failed", fallbackError);
      return false;
    }
  }
}

function applyProjectileDamage(target, amount, owner, projectile, sourceId = null) {
  if (!isValid(target)) return false;
  if (sourceId) {
    return applyDamageWithSource(target, amount, sourceId, {
      cause: EntityDamageCause.projectile,
      damagingEntity: owner,
      damagingProjectile: projectile,
    }).accepted;
  }
  try {
    const options = {
      cause: EntityDamageCause.projectile,
      damagingProjectile: projectile,
    };
    if (owner && isValid(owner)) options.damagingEntity = owner;
    return target.applyDamage(amount, options) === true;
  } catch (error) {
    operationDiagnostics.warnOnce("fractured.projectile_damage", "fractured: projectile damage failed; using un-attributed fallback", error);
    try { return target.applyDamage(amount); } catch (fallbackError) {
      operationDiagnostics.errorOnce("fractured.projectile_damage_fallback", "fractured: projectile damage fallback failed", fallbackError);
      return false;
    }
  }
}

function applyViewKnockback(target, strength) {
  try {
    const view = target.getViewDirection();
    target.applyImpulse({ x: -view.x * strength, y: strength, z: -view.z * strength });
    return;
  } catch (error) {
    operationDiagnostics.warnOnce("fractured.view_impulse", "fractured: view knockback impulse failed; using knockback fallback", error);
  }
  try { target.applyKnockback({ x: 0, z: 0 }, strength); } catch (error) {
    operationDiagnostics.warnOnce("fractured.view_knockback", "fractured: view knockback fallback failed", error);
  }
}

function applyRadialKnockback(target, origin, strength) {
  const dx = target.location.x - origin.x;
  const dz = target.location.z - origin.z;
  const length = Math.hypot(dx, dz);
  if (length < 0.0001) return;
  try {
    target.applyKnockback({ x: (dx / length) * strength, z: (dz / length) * strength }, 0);
  } catch (error) {
    operationDiagnostics.warnOnce("fractured.radial_knockback", "fractured: radial knockback failed; using impulse fallback", error);
    try { target.applyImpulse({ x: (dx / length) * strength, y: 0, z: (dz / length) * strength }); } catch (fallbackError) {
      operationDiagnostics.warnOnce("fractured.radial_impulse", "fractured: radial impulse fallback failed", fallbackError);
    }
  }
}

function playerPulse(
  entity,
  center,
  plan,
  knockbackMode = "view",
  sourceId = plan?.sourceId ?? "thebrokenscript:jimmy_stomp",
  requireDamageAcceptance = false,
) {
  if (!center || !plan) return;
  let players = [];
  try { players = world.getAllPlayers(); } catch { return; }
  for (const player of players) {
    try {
      if (!isValid(player) || player.dimension.id !== entity.dimension.id) continue;
      if (plan.groundedOnly && !hasGroundSupport(player)) continue;
      if (distance(player.location, center) > plan.radius) continue;
      const accepted = applyDamage(player, plan.damage, entity, null, sourceId);
      if (requireDamageAcceptance && !accepted) continue;
      if (knockbackMode === "radial") applyRadialKnockback(player, center, plan.knockback);
      else applyViewKnockback(player, plan.knockback);
    } catch {}
  }
}

function emitFracturedRisingPulse(entity, state) {
  const plan = fracturedRisingImpactPlan();
  playerPulse(
    entity,
    copyPosition(entity.location),
    plan,
    "view",
    FRACTURED_RISING_SOURCE_ID,
    true,
  );
  state.lastRisingPulseTick = system.currentTick;
}

function tickFracturedBaseLifecycle(entity, state) {
  const previousState = state.state;
  const risingStep = state.state === "RISING" ? fracturedRisingStep(state.riseTicks) : null;
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
  if (risingStep?.active && state.state === "RISING") emitFracturedRisingPulse(entity, state);
  if (state.state !== previousState) playFracturedPresentation(entity, state, false);
  return !baseStep.discarded;
}

function rotatedStompPosition(entity) {
  const offset = FRACTURED_SOURCE.stomp.offset;
  let yawDegrees = 0;
  try { yawDegrees = entity.getRotation().y; } catch {}
  const yaw = (-yawDegrees * Math.PI) / 180 + Math.PI;
  return {
    x: entity.location.x + offset.x * Math.cos(yaw) - offset.z * Math.sin(yaw),
    y: entity.location.y + offset.y,
    z: entity.location.z + offset.x * Math.sin(yaw) + offset.z * Math.cos(yaw),
  };
}

function sameCenterClawPositions(entity) {
  // The two Java slam packets carry the world positions of the two claw bones.
  // Current Bedrock has no server-side locator getter, so the resolver falls
  // back to the entity anchor while preserving the two-packet damage count.
  return [
    fracturedContactOrigin(entity, "right_l_claw"),
    fracturedContactOrigin(entity, "left_l_claw"),
  ].filter(Boolean);
}

function emitAttackEffect(entity, state, attack, target) {
  const events = fracturedAnimationEventPlan(attack, state.attackTicks);
  if (attack === "moonRockToss" && !events.includes("OffenseRockThrow")) return;
  if (attack === "airLift" && !events.includes("DefensiveRockRelease")) return;
  if (attack !== "stomp" && attack !== "slam" && attack !== "moonRockToss" && attack !== "airLift") return;
  if (attack === "stomp" && !events.includes("SingleStomp")) return;
  if (attack === "slam" && !events.includes("Slam")) return;
  const eventName = events.find((name) =>
    name === "SingleStomp" || name === "Slam" || name === "OffenseRockThrow" || name === "DefensiveRockRelease");
  if (!eventName) return;
  const key = `${attack}:${eventName}`;
  if (state.emitted.has(key)) return;
  state.emitted.add(key);

  if (attack === "stomp") {
    const direct = fracturedImpactPlan("stomp");
    playerPulse(entity, rotatedStompPosition(entity), direct, "radial");
    // SingleStomp is a separate animation keyframe packet in the source.
    playerPulse(entity, fracturedContactOrigin(entity, "right_f_tarsus"), fracturedImpactPlan("bigStomp"));
    return;
  }
  if (attack === "slam") {
    const plan = fracturedImpactPlan("slam");
    for (const position of sameCenterClawPositions(entity)) playerPulse(entity, position, plan);
    return;
  }
  if (attack === "moonRockToss") {
    const origin = fracturedContactOrigin(entity, "ROCK") ?? copyPosition(entity.location);
    const targetPoint = targetPointAtHalfHeight(target);
    spawnRock(entity, origin, targetPoint, FRACTURED_SOURCE.rock.throwSpeed);
    return;
  }
  if (attack === "airLift") {
    const origin = fracturedContactOrigin(entity, "ROCK") ?? copyPosition(entity.location);
    const rock = spawnRock(entity, origin, null, 0);
    if (rock) {
      const rockState = getRockState(rock);
      rockState.pulseDueTick = system.currentTick + FRACTURED_SOURCE.rock.airLiftPulseDelayTicks;
      rockState.pulsePosition = origin;
    }
  }
}

function targetPointAtHalfHeight(target) {
  if (!target) return { x: 0, y: 0, z: 0 };
  const aabb = getAabb(target);
  if (aabb?.center) return copyPosition(aabb.center);
  return copyPosition(target.location);
}

function advanceFracturedAttack(entity, state, target) {
  const currentAttack = state.attack;
  const step = fracturedAttackStep({
    attack: currentAttack,
    attackTicks: state.attackTicks,
    attackDelay: state.attackDelay,
  });
  state.attackTicks = step.attackTicks;
  state.attackDelay = step.nextAttackDelay;
  if (currentAttack !== "noop" && !step.finished) {
    emitAttackEffect(entity, state, currentAttack, target);
  }
  if (step.finished) {
    state.attack = step.nextAttack;
    state.emitted.clear();
    setAttackTag(entity, state, state.attack);
    if (currentAttack !== "noop") {
      const lifecycle = getFracturedLifecycleState(entity);
      if (lifecycle.state === "ATTACKING") {
        lifecycle.state = "NORMAL";
        playFracturedPresentation(entity, lifecycle, false);
      }
    }
  }
}

function beginFracturedAttack(entity, state, target) {
  const attack = chooseFracturedAttack({
    currentAttack: state.attack,
    attackDelay: state.attackDelay,
    targetPresent: target !== null,
    roll: Math.random(),
  });
  if (!attack) return false;
  state.attack = attack;
  state.attackTicks = 0;
  state.attackDelay = 0;
  state.emitted.clear();
  getFracturedLifecycleState(entity).state = "ATTACKING";
  setAttackTag(entity, state, attack);
  return true;
}

function approach(entity, target) {
  const dx = target.location.x - entity.location.x;
  const dz = target.location.z - entity.location.z;
  const length = Math.hypot(dx, dz);
  if (length < 0.0001) return;
  try {
    entity.teleport({
      x: entity.location.x + (dx / length) * MOVEMENT_ADAPTER_BLOCKS_PER_TICK,
      y: entity.location.y,
      z: entity.location.z + (dz / length) * MOVEMENT_ADAPTER_BLOCKS_PER_TICK,
    });
  } catch {}
}

function tickFractured(entity) {
  const state = getFracturedState(entity);
  const lifecycle = getFracturedLifecycleState(entity);
  if (state.defeated || callEntity(entity, "hasTag", DEFEATED_TAG) === true) {
    state.defeated = true;
    lifecycle.state = "DEFEATED";
    return;
  }

  recoverFracturedFromAir(entity, lifecycle);
  if (!tickFracturedBaseLifecycle(entity, lifecycle)) {
    fracturedLifecycleStates.delete(entity.id);
    return;
  }

  const target = nearestPlayer(entity);
  const previousCooldown = state.attackedCooldown;
  if (state.attackedCooldown > 0) state.attackedCooldown -= 1;

  if (state.attackDelay > 0) state.attackDelay -= 1;
  if (state.attackDelay <= 0) advanceFracturedAttack(entity, state, target);
  if (state.attack === "noop" && state.attackDelay <= 0) {
    if (target && distance(entity.location, target.location) > 6) approach(entity, target);
    beginFracturedAttack(entity, state, target);
  }

  // Keep the source defeat predicate observable even when the progress hit is
  // delivered from an event between two runtime ticks.
  const defeat = fracturedDefeatStep({
    timesAttacked: state.timesAttacked,
    attackedCooldown: previousCooldown,
    accepted: false,
  });
  state.attackedCooldown = Math.min(state.attackedCooldown, defeat.attackedCooldown);
  if (defeat.defeated) setDefeated(entity, state);
}

function isAcceptedProgressHit(event) {
  const source = event.damageSource;
  return source?.cause === EntityDamageCause.entityAttack && source.damagingEntity?.typeId === "minecraft:player";
}

function installDamageHook() {
  if (damageHookInstalled) return;
  damageHookInstalled = true;
  try {
    world.beforeEvents.entityHurt.subscribe((event) => {
      const entity = event.hurtEntity;
      const isFractured = entity?.typeId === FRACTURED_TYPE;
      const isRoam = entity?.typeId === FRACTURED_ROAM_TYPE;
      if (!isFractured && !isRoam) return;

      if (isFractured && isAcceptedProgressHit(event)) {
        const state = getFracturedState(entity);
        event.cancel = true;
        if (state.defeated || state.attackedCooldown > 0) return;
        state.timesAttacked += 1;
        state.attackedCooldown = FRACTURED_LIFECYCLE_SOURCE.attackedCooldownTicks;
        if (state.timesAttacked >= FRACTURED_LIFECYCLE_SOURCE.defeatAfterHits) {
          system.run(() => {
            if (isValid(entity)) setDefeated(entity, state);
          });
        }
        return;
      }

      const source = event.damageSource;
      if (isRoam && source?.cause !== EntityDamageCause.projectile) {
        // FracturedRoamEntity calls super.hurt for ordinary damage but rejects
        // fall and in-wall damage before that call. Leaving ordinary damage
        // uncancelled lets Bedrock's health component perform the super call.
        event.cancel = isRoamDamageIgnored(source?.cause);
        return;
      }
      if (source?.cause === EntityDamageCause.projectile) {
        const projectile = source.damagingProjectile;
        rememberProjectileEntity(projectile);
        const impact = projectileImpactPoint(projectile);
        const previous = projectile?.id ? projectilePositions.get(projectile.id) : null;
        const multipartHit = impact
          ? multipartProjectileHitPlan({
            position: copyPosition(entity.location),
            yawDegrees: getBodyYaw(entity),
            from: previous ?? impact,
            to: impact,
          })
          : { hit: false, part: null };
        const matchedPart = multipartHit.hit ? multipartHit.part : null;
        const roamLifecycle = isRoam ? getFracturedRoamLifecycleState(entity) : null;
        const plan = fracturedPartHitPlan({
          parentType: entity.typeId,
          partHit: matchedPart,
          partRole: matchedPart?.role ?? null,
          projectileType: projectile?.typeId ?? null,
          projectileOnFire: isEntityOnFire(projectile),
          // Bedrock has no direct equivalent of Java isInvulnerableTo().
          invulnerable: false,
          roamState: roamLifecycle?.state ?? "NORMAL",
        });
        event.cancel = plan.cancel;
        if (plan.swap) {
          try {
            system.run(() => {
              if (isValid(entity)) beginFracturedRoamSwitch(entity);
            });
          } catch (error) {
            operationDiagnostics.warnOnce("fractured.roam_switch_schedule", "fractured: roam-switch scheduling failed", error);
          }
        }
        if (shouldApplyMultipartArrowEffects(plan)) applyMultipartArrowEffects(entity, plan);
        return;
      }

      // FracturedPartEntity is the only source path that can damage Jimmy;
      // ordinary body hits and all direct damage to the roam host are rejected.
      event.cancel = true;
    });
  } catch (error) {
    operationDiagnostics.errorOnce("fractured.damage_subscription", "fractured: multipart damage hook unavailable", error);
  }
}
function installSpawnHook() {
  if (spawnHookInstalled) return;
  spawnHookInstalled = true;
  try {
    world.afterEvents.entitySpawn.subscribe((event) => {
      const entity = event.entity;
      if (entity?.typeId === ROCK_TYPE) getRockState(entity);
      if (entity?.typeId === FRACTURED_TYPE) getFracturedState(entity);
      if (entity?.typeId === FRACTURED_ROAM_TYPE) getFracturedRoamLifecycleState(entity);
      rememberProjectileEntity(entity);
    });
  } catch (error) {
    operationDiagnostics.errorOnce("fractured.spawn_subscription", "fractured: spawn hook unavailable", error);
  }
}

function isSolidBlock(block) {
  if (!block) return false;
  try { if (block.isAir) return false; } catch {}
  const typeId = block.typeId;
  return typeId !== "minecraft:air" &&
    typeId !== "minecraft:flowing_water" &&
    typeId !== "minecraft:water" &&
    typeId !== "minecraft:flowing_lava" &&
    typeId !== "minecraft:lava";
}

function blockAt(dimension, position) {
  try {
    return dimension.getBlock({
      x: Math.floor(position.x),
      y: Math.floor(position.y),
      z: Math.floor(position.z),
    });
  } catch {
    return null;
  }
}

function blockImpactOnSegment(dimension, from, to) {
  const dx = to.x - from.x;
  const dy = to.y - from.y;
  const dz = to.z - from.z;
  const length = Math.hypot(dx, dy, dz);
  const steps = Math.max(1, Math.ceil(length / COLLISION_SUBSTEP_BLOCKS));
  for (let index = 1; index <= steps; index += 1) {
    const t = index / steps;
    const position = { x: from.x + dx * t, y: from.y + dy * t, z: from.z + dz * t };
    if (isSolidBlock(blockAt(dimension, position))) return { position, t };
  }
  return null;
}

function pointToAabbDistanceSquared(point, aabb, inflation = 0) {
  if (!aabb?.center || !aabb?.extent) return Number.POSITIVE_INFINITY;
  const dx = Math.max(Math.abs(point.x - aabb.center.x) - aabb.extent.x - inflation, 0);
  const dy = Math.max(Math.abs(point.y - aabb.center.y) - aabb.extent.y - inflation, 0);
  const dz = Math.max(Math.abs(point.z - aabb.center.z) - aabb.extent.z - inflation, 0);
  return dx * dx + dy * dy + dz * dz;
}

function segmentEntityHit(rock, from, to, ownerId) {
  const midpoint = {
    x: (from.x + to.x) / 2,
    y: (from.y + to.y) / 2,
    z: (from.z + to.z) / 2,
  };
  const range = Math.max(8, distance(from, to) / 2 + 8);
  let candidates = [];
  try { candidates = rock.dimension.getEntities({ location: midpoint, maxDistance: range }); } catch { return null; }
  const dx = to.x - from.x;
  const dy = to.y - from.y;
  const dz = to.z - from.z;
  const steps = Math.max(1, Math.ceil(distance(from, to) / COLLISION_SUBSTEP_BLOCKS));
  let best = null;
  for (const candidate of candidates) {
    try {
      if (!isValid(candidate) || candidate.id === rock.id || candidate.id === ownerId || candidate.typeId === ROCK_TYPE) continue;
      if (getHealth(candidate) <= 0) continue;
      const aabb = getAabb(candidate);
      let hitT = null;
      for (let index = 0; index <= steps; index += 1) {
        const t = index / steps;
        const point = { x: from.x + dx * t, y: from.y + dy * t, z: from.z + dz * t };
        if (aabb && pointToAabbDistanceSquared(point, aabb, FRACTURED_SOURCE.rock.hitboxInflation) <= 0) {
          hitT = t;
          break;
        }
        if (!aabb && distance(point, candidate.location) <= FRACTURED_SOURCE.rock.hitboxInflation) {
          hitT = t;
          break;
        }
      }
      if (hitT !== null && (!best || hitT < best.t)) best = { entity: candidate, t: hitT };
    } catch {}
  }
  return best;
}

function aabbsIntersectWithInflation(first, second, inflation) {
  if (!first || !second) return false;
  return Math.abs(first.center.x - second.center.x) <= first.extent.x + second.extent.x + inflation &&
    Math.abs(first.center.y - second.center.y) <= first.extent.y + second.extent.y + inflation &&
    Math.abs(first.center.z - second.center.z) <= first.extent.z + second.extent.z + inflation;
}

function breakElytra(target) {
  try {
    const equippable = target.getComponent("minecraft:equippable");
    const slot = equippable?.getEquipmentSlot(EquipmentSlot.Chest);
    const item = slot?.getItem();
    if (!item || item.typeId !== "minecraft:elytra") return;
    const durability = item.getComponent("minecraft:durability");
    if (!durability || durability.maxDurability <= 0) return;
    const amount = Math.min(
      Math.max(Math.floor(durability.maxDurability / 8), 1),
      Math.max(durability.maxDurability - durability.damage - 1, 0),
    );
    if (amount <= 0) return;
    durability.damage += amount;
    slot.setItem(item);
  } catch {}
}

function rockHitTargets(rock, position, state) {
  const rockAabb = getAabb(rock);
  let candidates = [];
  try { candidates = rock.dimension.getEntities({ location: position, maxDistance: 8 }); } catch (error) {
    operationDiagnostics.warnOnce("fractured.rock_target_query", "fractured: rock impact target query failed", error);
    return;
  }
  for (const target of candidates) {
    try {
      if (!isValid(target) || target.id === rock.id || target.id === state.ownerId || getHealth(target) <= 0) continue;
      const targetAabb = getAabb(target);
      const impactAabb = rockAabb
        ? { center: position, extent: rockAabb.extent }
        : null;
      const intersects = impactAabb && targetAabb
        ? aabbsIntersectWithInflation(impactAabb, targetAabb, FRACTURED_SOURCE.rock.hitboxInflation)
        : distance(target.location, position) <= FRACTURED_SOURCE.rock.hitboxInflation;
      const plan = fracturedRockImpactPlan({
        owner: target.id === state.ownerId,
        living: getHealth(target) > 0,
        intersects,
      });
      if (!plan.applyDamage) continue;
      applyProjectileDamage(target, plan.damage, state.owner, rock, "thebrokenscript:rock");
      breakElytra(target);
    } catch (error) {
      operationDiagnostics.warnOnce("fractured.rock_target", "fractured: rock impact target handling failed", error);
    }
  }
}

function finishRockBlockImpact(rock, state, position) {
  rockHitTargets(rock, position, state);
  state.grounded = true;
  state.groundedTicks = FRACTURED_SOURCE.rock.blockImpactCleanupTicks;
  state.previousPosition = copyPosition(position);
  callEntity(rock, "clearVelocity");
  try { rock.teleport(position); } catch (error) {
    operationDiagnostics.warnOnce("fractured.rock_impact_teleport", "fractured: rock impact teleport failed", error);
  }
  const burst = fracturedRockBlockBurstPlan(position);
  try { rock.dimension.spawnParticle(burst.effectId, burst.origin); } catch (error) {
    operationDiagnostics.warnOnce("fractured.rock_particle", "fractured: rock impact particle failed", error);
  }
  try { rock.dimension.playSound("dig.stone", position, { volume: 1, pitch: 1 }); } catch (error) {
    operationDiagnostics.warnOnce("fractured.rock_sound", "fractured: rock impact sound failed", error);
  }
}

function finishRockEntityImpact(rock, state, position) {
  rockHitTargets(rock, position, state);
  safeRemove(rock);
  removeRockState(rock);
}

function tickRock(rock) {
  const state = getRockState(rock);
  if (state.pulseDueTick !== null && !state.pulseApplied && system.currentTick >= state.pulseDueTick) {
    state.pulseApplied = true;
    const plan = fracturedImpactPlan("airLift");
    playerPulse(state.owner ?? rock, state.pulsePosition, {
      radius: plan.pulseRadius,
      damage: plan.pulseDamage,
      groundedOnly: plan.groundedOnly,
      knockback: plan.pulseKnockback,
    });
  }

  if (state.grounded) {
    const step = fracturedRockFlightStep({
      position: rock.location,
      direction: null,
      grounded: true,
      groundedTicks: state.groundedTicks,
    });
    if (step.remove) {
      safeRemove(rock);
      removeRockState(rock);
    } else {
      state.groundedTicks = Math.max(0, state.groundedTicks - 1);
    }
    return;
  }

  const currentPosition = copyPosition(rock.location);
  const previousPosition = state.previousPosition;
  const blockHit = blockImpactOnSegment(rock.dimension, previousPosition, currentPosition);
  const entityHit = segmentEntityHit(rock, previousPosition, currentPosition, state.ownerId);
  if (entityHit && (!blockHit || entityHit.t <= blockHit.t)) {
    const impactPosition = {
      x: previousPosition.x + (currentPosition.x - previousPosition.x) * entityHit.t,
      y: previousPosition.y + (currentPosition.y - previousPosition.y) * entityHit.t,
      z: previousPosition.z + (currentPosition.z - previousPosition.z) * entityHit.t,
    };
    finishRockEntityImpact(rock, state, impactPosition);
    return;
  }
  if (blockHit) {
    finishRockBlockImpact(rock, state, blockHit.position);
    return;
  }
  state.previousPosition = currentPosition;
}

function tickDimension(dimension) {
  let fractured = [];
  let rocks = [];
  let roams = [];
  try { fractured = dimension.getEntities({ families: [FRACTURED_FAMILY] }); } catch (error) {
    operationDiagnostics.warnOnce("fractured.entity_query", "fractured: body entity query failed", error);
  }
  try { rocks = dimension.getEntities({ families: [ROCK_FAMILY] }); } catch (error) {
    operationDiagnostics.warnOnce("fractured.rock_query", "fractured: rock entity query failed", error);
  }
  try {
    roams = dimension.getEntities({ families: ["thebrokenscript_boss"] })
      .filter((entity) => entity.typeId === FRACTURED_ROAM_TYPE);
  } catch (error) {
    operationDiagnostics.warnOnce("fractured.roam_query", "fractured: roam entity query failed", error);
  }
  for (const entity of fractured) {
    try { tickFractured(entity); } catch (error) {
      operationDiagnostics.errorOnce("fractured.body_tick", "fractured: body tick failed", error);
    }
  }
  for (const rock of rocks) {
    try { tickRock(rock); } catch (error) {
      operationDiagnostics.errorOnce("fractured.rock_tick", "fractured: rock tick failed", error);
    }
  }
  for (const roam of roams) {
    try {
      if (tickFracturedRoamLifecycle(roam)) tickFracturedRoamMovement(roam, getFracturedRoamLifecycleState(roam));
    } catch (error) {
      operationDiagnostics.errorOnce("fractured.roam_tick", "fractured: roam lifecycle tick failed", error);
    }
  }
}

function onTick() {
  for (const dimension of dimensionsToTick()) tickDimension(dimension);
  trackProjectilePositions();
  tickRoamSwitchStates();
  tickFracturedRoamArenas();
  for (const [id, state] of fracturedStates) {
    if (!state?.entity || !isValid(state.entity)) {
      fracturedStates.delete(id);
      fracturedLifecycleStates.delete(id);
    }
  }
  for (const [id, state] of roamLifecycleStates) {
    if (!state?.entity || !isValid(state.entity)) roamLifecycleStates.delete(id);
  }
  for (const [id, arena] of roamArenaStates) {
    if (!arena?.jimmy || !isValid(arena.jimmy)) resetFracturedRoamArena(arena);
  }
}

export function spawnRock(owner, origin, targetPoint, speed) {
  let rock = null;
  try { rock = owner.dimension.spawnEntity(ROCK_TYPE, origin); } catch (error) {
    operationDiagnostics.warnOnce("fractured.rock_spawn", "fractured: rock spawn failed; preserving no-projectile fallback", error);
    return null;
  }
  if (!rock) return null;
  const state = getRockState(rock);
  state.owner = owner;
  state.ownerId = owner?.id ?? null;
  state.previousPosition = copyPosition(rock.location);
  try { rock.clearVelocity(); } catch {}
  if (speed > 0 && targetPoint) {
    const dx = targetPoint.x - origin.x;
    const dy = targetPoint.y - origin.y;
    const dz = targetPoint.z - origin.z;
    const length = Math.hypot(dx, dy, dz);
    if (length > 0.0001) {
      try {
        rock.applyImpulse({ x: (dx / length) * speed, y: (dy / length) * speed, z: (dz / length) * speed });
      } catch {}
    }
  }
  return rock;
}

export function begin(scheduler) {
  installDamageHook();
  installSpawnHook();
  scheduler.every("tbs.fractured_runtime", 1, onTick);
}

export const FRACTURED_RUNTIME_SOURCE = Object.freeze({
  fracturedType: FRACTURED_TYPE,
  fracturedRoamType: FRACTURED_ROAM_TYPE,
  rockType: ROCK_TYPE,
  multipartPartCount: multipartPartDefinitions().length,
  risingDurationTicks: FRACTURED_RISING_SOURCE.durationTicks,
  risingActiveWindow: [
    FRACTURED_RISING_SOURCE.activeMinTick,
    FRACTURED_RISING_SOURCE.activeMaxTick,
  ],
  risingSourceId: FRACTURED_RISING_SOURCE.sourceId,
  roamRiseTicks: FRACTURED_ROAM_SOURCE.riseTicks,
  roamServerTimerTicks: FRACTURED_ROAM_SOURCE.serverTimerTicks,
  roamDigAnimationTicks: FRACTURED_ROAM_SOURCE.digAnimationTicks,
  roamDespawnAnimationTicks: FRACTURED_ROAM_SOURCE.despawnAnimationTicks,
  roamSwitchTicks: FRACTURED_ROAM_SOURCE.switchingTicks,
  roamDespawnTimerRange: [
    FRACTURED_ROAM_SOURCE.despawnTimerMinTicks,
    FRACTURED_ROAM_SOURCE.despawnTimerMaxTicks,
  ],
  roamUndergroundTimerRange: [
    FRACTURED_ROAM_SOURCE.undergroundTimerMinTicks,
    FRACTURED_ROAM_SOURCE.undergroundTimerMaxExclusive,
  ],
  roamDigCooldownRange: [
    FRACTURED_ROAM_SOURCE.digCooldownMinTicks,
    FRACTURED_ROAM_SOURCE.digCooldownMaxExclusive,
  ],
  roamRandomStrollHorizontalRange: FRACTURED_ROAM_SOURCE.randomStrollHorizontalRange,
  roamUndergroundRandomHorizontalRange: FRACTURED_ROAM_SOURCE.undergroundRandomHorizontalRange,
  roamRandomStrollVerticalRange: FRACTURED_ROAM_SOURCE.randomStrollVerticalRange,
  roamSupportDepth: FRACTURED_ROAM_SOURCE.strollSupportDepth,
  roamSupportLookahead: FRACTURED_ROAM_SOURCE.strollSupportLookahead,
  roamStuckTicks: FRACTURED_ROAM_SOURCE.strollStuckTicks,
  roamSurfaceRecoveryMaxDistance: FRACTURED_ROAM_SOURCE.surfaceRecoveryMaxDistance,
  roamSurfaceRecoveryStep: FRACTURED_ROAM_SOURCE.surfaceRecoveryStep,
  roamMoveControlMaxTurnDegrees: FRACTURED_ROAM_SOURCE.moveControlMaxTurnDegrees,
  arenaStartMusicTicks: FRACTURED_ROAM_SOURCE.arenaStartMusicTicks,
  arenaSubAnomalyCount: FRACTURED_ROAM_SOURCE.arenaSubAnomalyCount,
  arenaPlayerRange: FRACTURED_ROAM_SOURCE.arenaPlayerRange,
  arenaSubAnomalyRadius: FRACTURED_ROAM_SOURCE.arenaSubAnomalyRadius,
  fracturedFamily: FRACTURED_FAMILY,
  rockFamily: ROCK_FAMILY,
  animationEventAdapter: "fractured_animation_model",
  animationPresentationBridge: true,
  collisionSubstepBlocks: COLLISION_SUBSTEP_BLOCKS,
  movementAdapterBlocksPerTick: MOVEMENT_ADAPTER_BLOCKS_PER_TICK,
  usesSourceAttackModel: true,
  usesSourceRisingModel: true,
  usesFracturedLifecycleState: true,
  usesMultipartProjectileSweep: true,
  usesFracturedContactOriginAdapter: true,
  usesSingleRockRuntimeOwner: true,
  usesSourceRoamLifecycleModel: true,
  usesSourceRoamSurfaceRecovery: true,
  usesSourceRoamMoveControl: true,
  usesSourceRoamSupportChecks: true,
  usesJimArenaScheduleAdapter: true,
});
