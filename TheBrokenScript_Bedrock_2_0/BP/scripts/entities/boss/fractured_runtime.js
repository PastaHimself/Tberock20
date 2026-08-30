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

const FRACTURED_TYPE = "thebrokenscript:fractured";
const ROCK_TYPE = "thebrokenscript:rock";
const FRACTURED_FAMILY = "thebrokenscript_fractured_runtime";
const ROCK_FAMILY = "thebrokenscript_fractured_rock_runtime";
const DEFEATED_TAG = "thebrokenscript.fractured_defeated";
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

const fracturedStates = new Map();
const rockStates = new Map();
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

function removeFracturedState(entity) {
  fracturedStates.delete(entity?.id);
}

function removeRockState(entity) {
  rockStates.delete(entity?.id);
}

function safeRemove(entity) {
  try { entity.remove(); } catch { try { entity.kill(); } catch {} }
}

function setAttackTag(entity, state, attack) {
  if (state.attackTag) callEntity(entity, "removeTag", state.attackTag);
  state.attackTag = attack === "noop" ? null : `${ATTACK_TAG_PREFIX}${attack}`;
  if (state.attackTag) callEntity(entity, "addTag", state.attackTag);
}

function setDefeated(entity, state) {
  state.defeated = true;
  state.attack = "noop";
  state.attackDelay = 0;
  state.attackTicks = 0;
  state.emitted.clear();
  setAttackTag(entity, state, "noop");
  callEntity(entity, "addTag", DEFEATED_TAG);
  // Java switches to BaseFracturedEntity.JimmyStates.DEFEATED and lets the
  // client loss controller run. No matching Bedrock animation controller is
  // present, so the tag is the stable gameplay state for future presentation.
}

function applyDamage(target, amount, damagingEntity, damagingProjectile = null) {
  if (!isValid(target)) return false;
  try {
    const options = {
      cause: EntityDamageCause.entityAttack,
      damagingEntity,
    };
    if (damagingProjectile) options.damagingProjectile = damagingProjectile;
    return target.applyDamage(amount, options) === true;
  } catch {
    try { return target.applyDamage(amount) === true; } catch { return false; }
  }
}

function applyProjectileDamage(target, amount, owner, projectile) {
  if (!isValid(target)) return false;
  try {
    const options = {
      cause: EntityDamageCause.projectile,
      damagingProjectile: projectile,
    };
    if (owner && isValid(owner)) options.damagingEntity = owner;
    return target.applyDamage(amount, options) === true;
  } catch {
    try { return target.applyDamage(amount); } catch { return false; }
  }
}

function applyViewKnockback(target, strength) {
  try {
    const view = target.getViewDirection();
    target.applyImpulse({ x: -view.x * strength, y: strength, z: -view.z * strength });
    return;
  } catch {}
  try { target.applyKnockback({ x: 0, z: 0 }, strength); } catch {}
}

function applyRadialKnockback(target, origin, strength) {
  const dx = target.location.x - origin.x;
  const dz = target.location.z - origin.z;
  const length = Math.hypot(dx, dz);
  if (length < 0.0001) return;
  try {
    target.applyKnockback({ x: (dx / length) * strength, z: (dz / length) * strength }, 0);
  } catch {
    try { target.applyImpulse({ x: (dx / length) * strength, y: 0, z: (dz / length) * strength }); } catch {}
  }
}

function playerPulse(entity, center, plan, knockbackMode = "view") {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return; }
  for (const player of players) {
    try {
      if (!isValid(player) || player.dimension.id !== entity.dimension.id) continue;
      if (plan.groundedOnly && !hasGroundSupport(player)) continue;
      if (distance(player.location, center) > plan.radius) continue;
      applyDamage(player, plan.damage, entity);
      if (knockbackMode === "radial") applyRadialKnockback(player, center, plan.knockback);
      else applyViewKnockback(player, plan.knockback);
    } catch {}
  }
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
  // With no script-visible Bedrock bone API, preserving the two-packet damage
  // count at the entity anchor is the least speculative spatial adapter.
  return [copyPosition(entity.location), copyPosition(entity.location)];
}

function emitAttackEffect(entity, state, attack, target) {
  const triggerTick = attack === "stomp"
    ? FRACTURED_SOURCE.stomp.triggerTick
    : KEYFRAME_ADAPTER_TICKS[attack];
  if (triggerTick === undefined || state.attackTicks !== triggerTick) return;
  const key = `${attack}:${triggerTick}`;
  if (state.emitted.has(key)) return;
  state.emitted.add(key);

  if (attack === "stomp") {
    const direct = fracturedImpactPlan("stomp");
    playerPulse(entity, rotatedStompPosition(entity), direct, "radial");
    // SingleStomp is a separate animation keyframe packet in the source.
    playerPulse(entity, copyPosition(entity.location), fracturedImpactPlan("bigStomp"));
    return;
  }
  if (attack === "slam") {
    const plan = fracturedImpactPlan("slam");
    for (const position of sameCenterClawPositions(entity)) playerPulse(entity, position, plan);
    return;
  }
  if (attack === "moonRockToss") {
    const origin = copyPosition(entity.location);
    const targetPoint = targetPointAtHalfHeight(target);
    spawnRock(entity, origin, targetPoint, FRACTURED_SOURCE.rock.throwSpeed);
    return;
  }
  if (attack === "airLift") {
    const origin = copyPosition(entity.location);
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
  if (state.defeated || callEntity(entity, "hasTag", DEFEATED_TAG) === true) {
    state.defeated = true;
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
      if (entity?.typeId !== FRACTURED_TYPE) return;

      // FracturedPartEntity converts a successful hit on a multipart part into
      // the custom SUB_ANOM_2 damage source. Bedrock has no multipart entity in
      // this pack, so player melee is the explicit gameplay signal adapter.
      if (isAcceptedProgressHit(event)) {
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

      // Java FracturedEntity ignores fire, fall, wall, and ordinary non-part
      // damage. Arrow/projectile damage is allowed as the broad Bedrock body
      // hitbox adapter for Java multipart arrow hits.
      const cause = event.damageSource?.cause;
      if (cause !== EntityDamageCause.projectile) event.cancel = true;
    });
  } catch (error) {
    logger.warn("fractured damage hook unavailable", error);
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
    });
  } catch (error) {
    logger.warn("fractured spawn hook unavailable", error);
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
  try { candidates = rock.dimension.getEntities({ location: position, maxDistance: 8 }); } catch { return; }
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
      applyProjectileDamage(target, plan.damage, state.owner, rock);
      breakElytra(target);
    } catch {}
  }
}

function finishRockBlockImpact(rock, state, position) {
  rockHitTargets(rock, position, state);
  state.grounded = true;
  state.groundedTicks = FRACTURED_SOURCE.rock.blockImpactCleanupTicks;
  state.previousPosition = copyPosition(position);
  callEntity(rock, "clearVelocity");
  try { rock.teleport(position); } catch {}
  // Java emits 400 moon-stone block particles before the one-tick discard.
  // The Bedrock pack has no matching block-particle asset, so preserve the
  // timing and sound hook without inventing a particle identifier.
  try { rock.dimension.playSound("dig.stone", position, { volume: 1, pitch: 1 }); } catch {}
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
  try { fractured = dimension.getEntities({ families: [FRACTURED_FAMILY] }); } catch {}
  try { rocks = dimension.getEntities({ families: [ROCK_FAMILY] }); } catch {}
  for (const entity of fractured) {
    try { tickFractured(entity); } catch (error) { logger.error(`fractured tick ${entity.id}`, error); }
  }
  for (const rock of rocks) {
    try { tickRock(rock); } catch (error) { logger.error(`rock tick ${rock.id}`, error); }
  }
}

function onTick() {
  for (const dimension of dimensionsToTick()) tickDimension(dimension);
  for (const [id, state] of fracturedStates) {
    if (!state) fracturedStates.delete(id);
  }
}

export function spawnRock(owner, origin, targetPoint, speed) {
  let rock = null;
  try { rock = owner.dimension.spawnEntity(ROCK_TYPE, origin); } catch { return null; }
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
  rockType: ROCK_TYPE,
  fracturedFamily: FRACTURED_FAMILY,
  rockFamily: ROCK_FAMILY,
  keyframeAdapterTicks: KEYFRAME_ADAPTER_TICKS,
  collisionSubstepBlocks: COLLISION_SUBSTEP_BLOCKS,
  movementAdapterBlocksPerTick: MOVEMENT_ADAPTER_BLOCKS_PER_TICK,
  usesSourceAttackModel: true,
  usesSingleRockRuntimeOwner: true,
});
