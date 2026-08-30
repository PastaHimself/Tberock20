import { world } from "@minecraft/server";
import { logger } from "../../core/logging.js";
import * as perf from "../../systems/perf.js";
import {
  CHORD_PROJECTILE_BEDROCK_ADAPTER,
  CHORD_PROJECTILE_SOURCE,
  chordProjectileBlockHitStep,
  chordProjectileDirection,
  chordProjectileShouldDiscardForTravel,
} from "../../systems/chord_projectile_model.js";

const TYPE_ID = "thebrokenscript:chord_projectile";
const RUNTIME_FAMILY = "thebrokenscript_chord_projectile_runtime";
const states = new Map();
let spawnHookInstalled = false;

function copyPosition(position) {
  return { x: position.x, y: position.y, z: position.z };
}

function isValid(entity) {
  if (!entity) return false;
  try { return entity.isValid !== false; } catch { return false; }
}

function removeProjectile(entity) {
  states.delete(entity.id);
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

function initState(entity) {
  const position = copyPosition(entity.location);
  const state = {
    initialPosition: position,
    previousPosition: position,
    groundedPosition: null,
    discardTicksRemaining: null,
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

function blockImpactPosition(dimension, start, end) {
  const dx = end.x - start.x;
  const dy = end.y - start.y;
  const dz = end.z - start.z;
  const segmentLength = Math.hypot(dx, dy, dz);
  if (!(segmentLength > 0)) return null;

  const steps = Math.max(
    1,
    Math.ceil(segmentLength / CHORD_PROJECTILE_BEDROCK_ADAPTER.collisionSubstepDistance),
  );
  let previous = start;
  for (let index = 1; index <= steps; index += 1) {
    const amount = index / steps;
    const sample = {
      x: start.x + dx * amount,
      y: start.y + dy * amount,
      z: start.z + dz * amount,
    };
    if (solidBlockAt(dimension, sample)) return copyPosition(previous);
    previous = sample;
  }
  return null;
}

function tickGroundedProjectile(entity, state) {
  if (state.groundedPosition) teleport(entity, state.groundedPosition);
  const step = chordProjectileBlockHitStep(state.discardTicksRemaining);
  state.discardTicksRemaining = step.discardTicksRemaining;
  if (step.discard) removeProjectile(entity);
}

function tickFlyingProjectile(entity, state) {
  const current = copyPosition(entity.location);
  const movement = {
    x: current.x - state.previousPosition.x,
    y: current.y - state.previousPosition.y,
    z: current.z - state.previousPosition.z,
  };
  const direction = chordProjectileDirection(movement);
  let finalPosition = current;

  // boss_controller.js currently advances the projectile by 0.9 blocks/tick.
  // Correct only the missing distance here so the combined runtime reaches the
  // Java shoot(..., 1.6f, 0.0f) speed without re-selecting a target.
  if (direction) {
    const observedDistance = Math.hypot(movement.x, movement.y, movement.z);
    const correction = Math.max(
      0,
      CHORD_PROJECTILE_SOURCE.launchSpeedBlocksPerTick - observedDistance,
    );
    const desired = {
      x: current.x + direction.x * correction,
      y: current.y + direction.y * correction,
      z: current.z + direction.z * correction,
    };
    const impactPosition = blockImpactPosition(
      entity.dimension,
      state.previousPosition,
      desired,
    );
    if (impactPosition) {
      state.groundedPosition = impactPosition;
      state.discardTicksRemaining = chordProjectileBlockHitStep(null).discardTicksRemaining;
      state.previousPosition = impactPosition;
      teleport(entity, impactPosition);
      return;
    }
    if (correction > 0 && teleport(entity, desired)) finalPosition = desired;
  }

  if (chordProjectileShouldDiscardForTravel(finalPosition, state.initialPosition)) {
    removeProjectile(entity);
    return;
  }
  state.previousPosition = copyPosition(finalPosition);
}

function tickProjectile(entity) {
  if (!isValid(entity)) {
    states.delete(entity?.id);
    return;
  }
  const state = states.get(entity.id) ?? initState(entity);
  if (state.groundedPosition) {
    tickGroundedProjectile(entity, state);
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

export function begin(scheduler) {
  installSpawnHook();
  // Register after boss_controller: its existing target vector remains the
  // authority, while this pass corrects source speed/lifetime/block impacts.
  scheduler.every("tbs.chord_projectile_source_tick", 1, onTick);
}
