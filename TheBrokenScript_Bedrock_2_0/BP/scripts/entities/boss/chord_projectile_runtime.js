import { EntityDamageCause, GameMode, world } from "@minecraft/server";
import { logger } from "../../core/logging.js";
import * as perf from "../../systems/perf.js";
import {
  CHORD_PROJECTILE_BEDROCK_ADAPTER,
  CHORD_PROJECTILE_SOURCE,
  chordProjectileBlockHitStep,
  chordProjectileBaseDamageFromMob,
  chordProjectileDifficultyId,
  chordProjectileDirection,
  chordProjectileEntityImpactPlan,
  chordProjectileGroundedOffset,
  chordProjectileShouldDiscardForTravel,
} from "../../systems/chord_projectile_model.js";

const TYPE_ID = "thebrokenscript:chord_projectile";
const RUNTIME_FAMILY = "thebrokenscript_chord_projectile_runtime";
const GRAVITY_RESTORE_EVENT = "thebrokenscript:chord_projectile_restore_gravity";
const states = new Map();
const pendingLaunches = new Map();
let spawnHookInstalled = false;

function copyPosition(position) {
  return { x: position.x, y: position.y, z: position.z };
}

function isValid(entity) {
  if (!entity) return false;
  try { return entity.isValid !== false; } catch { return false; }
}

function removeProjectile(entity) {
  states.delete(entity?.id);
  pendingLaunches.delete(entity?.id);
  try { entity.remove(); } catch {}
}

function teleport(entity, position) {
  try {
    entity.teleport(position);
    return true;
  } catch {
    return false;
  }
}

function applyLaunchToState(state, launch) {
  state.launchRegistered = true;
  state.direction = launch.direction;
  state.ownerId = launch.ownerId;
  state.initialPosition = copyPosition(launch.initialPosition);
}

function initState(entity) {
  const position = copyPosition(entity.location);
  const launch = pendingLaunches.get(entity.id);
  if (launch) pendingLaunches.delete(entity.id);
  const state = {
    initialPosition: copyPosition(launch?.initialPosition ?? position),
    previousPosition: position,
    launchRegistered: Boolean(launch),
    direction: launch?.direction ?? null,
    ownerId: launch?.ownerId ?? null,
    groundedPosition: null,
    discardTicksRemaining: null,
    entityImpact: false,
    gravityRestored: false,
    groundedFace: null,
    groundedOffset: null,
  };
  states.set(entity.id, state);
  return state;
}

function installSpawnHook() {
  if (spawnHookInstalled) return;
  spawnHookInstalled = true;
  try {
    world.afterEvents.entitySpawn.subscribe((event) => {
      const entity = event.entity;
      if (entity?.typeId !== TYPE_ID) return;
      initState(entity);
    });
  } catch {}
}

function dimensions() {
  const result = [];
  for (const id of [
    "overworld",
    "nether",
    "the_end",
    "thebrokenscript:stage2",
    "thebrokenscript:void_shadow",
  ]) {
    const dimension = perf.dim(id);
    if (dimension) result.push(dimension);
  }
  return result;
}

function runtimeProjectiles(dimension) {
  try {
    return dimension.getEntities({ families: [RUNTIME_FAMILY] });
  } catch {
    return [];
  }
}

function isFluidBlock(block) {
  try {
    if (block.isLiquid === true) return true;
  } catch {}
  const typeId = block?.typeId;
  return typeId === "minecraft:water" || typeId === "minecraft:lava";
}

function solidBlockAt(dimension, position) {
  try {
    const block = dimension.getBlock({
      x: Math.floor(position.x),
      y: Math.floor(position.y),
      z: Math.floor(position.z),
    });
    if (!block || block.isAir === true || isFluidBlock(block)) return false;
    return true;
  } catch {
    return false;
  }
}

function blockFaceFromSegment(start, end, enteredBlock) {
  const previousBlock = {
    x: Math.floor(start.x),
    y: Math.floor(start.y),
    z: Math.floor(start.z),
  };
  const delta = {
    x: enteredBlock.x - previousBlock.x,
    y: enteredBlock.y - previousBlock.y,
    z: enteredBlock.z - previousBlock.z,
  };
  if (delta.x > 0) return "west";
  if (delta.x < 0) return "east";
  if (delta.y > 0) return "down";
  if (delta.y < 0) return "up";
  if (delta.z > 0) return "north";
  if (delta.z < 0) return "south";

  const movement = {
    x: Math.abs(end.x - start.x),
    y: Math.abs(end.y - start.y),
    z: Math.abs(end.z - start.z),
  };
  if (movement.x >= movement.y && movement.x >= movement.z) return end.x >= start.x ? "west" : "east";
  if (movement.y >= movement.x && movement.y >= movement.z) return end.y >= start.y ? "down" : "up";
  return end.z >= start.z ? "north" : "south";
}

function blockImpactOnSegment(dimension, start, end) {
  const dx = end.x - start.x;
  const dy = end.y - start.y;
  const dz = end.z - start.z;
  const segmentLength = Math.hypot(dx, dy, dz);
  if (!(segmentLength > 0)) return null;

  const steps = Math.max(
    1,
    Math.ceil(segmentLength / CHORD_PROJECTILE_BEDROCK_ADAPTER.collisionSubstepDistance),
  );
  let previous = copyPosition(start);
  for (let index = 1; index <= steps; index += 1) {
    const amount = index / steps;
    const sample = {
      x: start.x + dx * amount,
      y: start.y + dy * amount,
      z: start.z + dz * amount,
    };
    if (solidBlockAt(dimension, sample)) {
      return {
        position: previous,
        t: (index - 1) / steps,
        face: blockFaceFromSegment(previous, sample, {
          x: Math.floor(sample.x),
          y: Math.floor(sample.y),
          z: Math.floor(sample.z),
        }),
      };
    }
    previous = sample;
  }
  return null;
}

function pointToSegment(point, start, end) {
  const dx = end.x - start.x;
  const dy = end.y - start.y;
  const dz = end.z - start.z;
  const lengthSquared = dx * dx + dy * dy + dz * dz;
  if (!(lengthSquared > 0)) {
    return {
      distance: Math.hypot(point.x - start.x, point.y - start.y, point.z - start.z),
      t: 0,
      position: copyPosition(start),
    };
  }
  const rawT = (
    (point.x - start.x) * dx
    + (point.y - start.y) * dy
    + (point.z - start.z) * dz
  ) / lengthSquared;
  const t = Math.max(0, Math.min(1, rawT));
  const position = {
    x: start.x + dx * t,
    y: start.y + dy * t,
    z: start.z + dz * t,
  };
  return {
    distance: Math.hypot(point.x - position.x, point.y - position.y, point.z - position.z),
    t,
    position,
  };
}

function entitiesAt(dimension, position) {
  try {
    return dimension.getEntities({
      location: position,
      maxDistance: CHORD_PROJECTILE_BEDROCK_ADAPTER.collisionQueryRadius,
    });
  } catch {
    return [];
  }
}

function entityImpactOnSegment(dimension, start, end, projectile, state) {
  const dx = end.x - start.x;
  const dy = end.y - start.y;
  const dz = end.z - start.z;
  const segmentLength = Math.hypot(dx, dy, dz);
  if (!(segmentLength > 0)) return null;

  const steps = Math.max(
    1,
    Math.ceil(segmentLength / CHORD_PROJECTILE_BEDROCK_ADAPTER.collisionSubstepDistance),
  );
  const seen = new Set();
  let best = null;
  for (let index = 0; index <= steps; index += 1) {
    const amount = index / steps;
    const sample = {
      x: start.x + dx * amount,
      y: start.y + dy * amount,
      z: start.z + dz * amount,
    };
    for (const target of entitiesAt(dimension, sample)) {
      if (!isValid(target) || target.id === projectile.id || target.typeId === TYPE_ID) continue;
      if (state.ownerId && target.id === state.ownerId) continue;
      if (typeof target.applyDamage !== "function") continue;
      const identity = target.id ?? target;
      if (seen.has(identity)) continue;
      seen.add(identity);
      let targetPosition;
      try { targetPosition = copyPosition(target.location); } catch { continue; }
      const closest = pointToSegment(targetPosition, start, end);
      if (closest.distance > CHORD_PROJECTILE_BEDROCK_ADAPTER.collisionQueryRadius) continue;
      if (!best || closest.t < best.t) {
        best = { target, position: closest.position, t: closest.t };
      }
    }
  }
  return best;
}

function triggerGravityRestoration(entity, state) {
  if (state.gravityRestored) return;
  state.gravityRestored = true;
  try { entity.triggerEvent(GRAVITY_RESTORE_EVENT); } catch {}
}

function isCreativePlayer(entity) {
  if (entity?.typeId !== "minecraft:player") return false;
  try { return entity.getGameMode() === GameMode.Creative; } catch { return false; }
}

function currentDifficultyId() {
  try { return chordProjectileDifficultyId(world.getDifficulty()); } catch { return 0; }
}

function applyProjectileDamage(projectile, target) {
  const damage = chordProjectileBaseDamageFromMob({
    power: CHORD_PROJECTILE_SOURCE.baseDamageFromMob,
    difficultyId: currentDifficultyId(),
    randomDouble: Math.random,
  });
  try {
    target.applyDamage(damage, {
      cause: EntityDamageCause.projectile,
      damagingEntity: projectile,
    });
    return;
  } catch {}
  try { target.applyDamage(damage); } catch {}
}

function handleEntityImpact(projectile, target, state, impactPosition) {
  const plan = chordProjectileEntityImpactPlan({
    targetType: target.typeId,
    isCreativePlayer: isCreativePlayer(target),
  });
  if (plan.applyDamage) applyProjectileDamage(projectile, target);
  if (plan.restoreGravity) triggerGravityRestoration(projectile, state);
  if (plan.discard) {
    removeProjectile(projectile);
    return;
  }

  // Vanilla AbstractArrow stops being flight-controlled after an entity hit;
  // the restored Bedrock physics component owns the post-impact motion.
  state.entityImpact = true;
  state.direction = null;
  state.previousPosition = copyPosition(impactPosition);
  teleport(projectile, impactPosition);
}

function tickGroundedProjectile(entity, state) {
  if (state.groundedPosition) teleport(entity, state.groundedPosition);
  const step = chordProjectileBlockHitStep(state.discardTicksRemaining);
  state.discardTicksRemaining = step.discardTicksRemaining;
  if (step.discard) removeProjectile(entity);
}

function tickPostEntityImpact(entity, state) {
  let position;
  try { position = copyPosition(entity.location); } catch { return; }
  if (chordProjectileShouldDiscardForTravel(position, state.initialPosition)) {
    removeProjectile(entity);
  }
}

function tickFlyingProjectile(entity, state) {
  const current = copyPosition(entity.location);
  if (!state.launchRegistered) {
    // Chord always registers an aim vector immediately after spawning this
    // entity. An orphan (including a zero-vector launch) has no source-backed
    // flight state and must not linger forever in the runtime family.
    removeProjectile(entity);
    return;
  }
  if (!state.direction) {
    if (chordProjectileShouldDiscardForTravel(current, state.initialPosition)) removeProjectile(entity);
    state.previousPosition = current;
    return;
  }

  const desired = {
    x: current.x + state.direction.x * CHORD_PROJECTILE_SOURCE.launchSpeedBlocksPerTick,
    y: current.y + state.direction.y * CHORD_PROJECTILE_SOURCE.launchSpeedBlocksPerTick,
    z: current.z + state.direction.z * CHORD_PROJECTILE_SOURCE.launchSpeedBlocksPerTick,
  };
  const blockImpact = blockImpactOnSegment(entity.dimension, current, desired);
  const entityImpact = entityImpactOnSegment(entity.dimension, current, desired, entity, state);
  if (entityImpact && (!blockImpact || entityImpact.t < blockImpact.t)) {
    handleEntityImpact(entity, entityImpact.target, state, entityImpact.position);
    return;
  }
  if (blockImpact) {
    state.groundedPosition = copyPosition(blockImpact.position);
    state.groundedFace = blockImpact.face ?? null;
    state.groundedOffset = chordProjectileGroundedOffset(state.groundedFace);
    state.discardTicksRemaining = chordProjectileBlockHitStep(null).discardTicksRemaining;
    state.direction = null;
    state.previousPosition = copyPosition(blockImpact.position);
    triggerGravityRestoration(entity, state);
    teleport(entity, blockImpact.position);
    return;
  }

  const finalPosition = teleport(entity, desired) ? desired : current;
  if (chordProjectileShouldDiscardForTravel(finalPosition, state.initialPosition)) {
    removeProjectile(entity);
    return;
  }
  state.previousPosition = copyPosition(finalPosition);
}

function tickProjectile(entity) {
  if (!isValid(entity)) {
    states.delete(entity?.id);
    pendingLaunches.delete(entity?.id);
    return;
  }
  const state = states.get(entity.id) ?? initState(entity);
  if (state.groundedPosition) {
    tickGroundedProjectile(entity, state);
    return;
  }
  if (state.entityImpact) {
    tickPostEntityImpact(entity, state);
    return;
  }
  tickFlyingProjectile(entity, state);
}

function onTick() {
  for (const dimension of dimensions()) {
    for (const entity of runtimeProjectiles(dimension)) {
      try {
        tickProjectile(entity);
      } catch (error) {
        logger.error(`chord projectile tick ${entity.id}`, error);
      }
    }
  }
}

// ChordEntity supplies the source-backed aim vector and owner at launch time.
// This bridge avoids persisting synthetic direction properties on the entity.
export function registerChordProjectileLaunch(projectile, vector, owner, initialPosition = projectile?.location) {
  if (!projectile?.id || !initialPosition) return false;
  const direction = chordProjectileDirection(vector);
  if (!direction) return false;
  const launch = {
    direction,
    ownerId: owner?.id ?? null,
    initialPosition: copyPosition(initialPosition),
  };
  const state = states.get(projectile.id);
  if (state) applyLaunchToState(state, launch);
  else pendingLaunches.set(projectile.id, launch);
  return true;
}

export function begin(scheduler) {
  installSpawnHook();
  scheduler.every("tbs.chord_projectile_source_tick", 1, onTick);
}
