// Source-backed multipart definitions for BaseFracturedEntity and its Jimmy
// subclasses. Bedrock has no server-side multipart entity-part hierarchy, so
// the runtime uses these definitions for conceptual hitboxes and transforms.

const freezeVector = (vector) => Object.freeze({ ...vector });

export const FRACTURED_MULTIPART_SOURCE = Object.freeze({
  legDistance: 45,
  rootCollisionBox: Object.freeze({ width: 105, height: 102 }),
  parts: Object.freeze({
    head: Object.freeze({
      name: "head",
      width: 14,
      height: 14,
      offset: freezeVector({ x: 1, y: 88, z: 10 }),
    }),
    chest: Object.freeze({
      name: "chest",
      width: 18,
      height: 18,
      offset: freezeVector({ x: 1, y: 68, z: 10 }),
    }),
  }),
  subEntities: Object.freeze({
    frontLeft: Object.freeze({
      name: "frontleft",
      width: 15,
      height: 15,
      defaultOffset: freezeVector({ x: 40, y: 0, z: 50 }),
      targetOffset: freezeVector({ x: 45, y: 0, z: 45 }),
    }),
    frontRight: Object.freeze({
      name: "frontright",
      width: 15,
      height: 15,
      defaultOffset: freezeVector({ x: -40, y: 0, z: 50 }),
      targetOffset: freezeVector({ x: -45, y: 0, z: 45 }),
    }),
    backLeft: Object.freeze({
      name: "backleft",
      width: 15,
      height: 15,
      defaultOffset: freezeVector({ x: 40, y: 0, z: -49 }),
      targetOffset: freezeVector({ x: 45, y: 0, z: -45 }),
    }),
    backRight: Object.freeze({
      name: "backright",
      width: 15,
      height: 15,
      defaultOffset: freezeVector({ x: -40, y: 0, z: -49 }),
      targetOffset: freezeVector({ x: -45, y: 0, z: -45 }),
    }),
  }),
  arrowEffects: Object.freeze({
    igniteSeconds: 20,
    spectralGlowTicks: 400,
  }),
  roamSwitchTicks: 103,
  roamSwapState: "SWITCHING",
});

const PARENT_TYPES = Object.freeze([
  "thebrokenscript:fractured",
  "thebrokenscript:fractured_roam",
  "fractured",
  "fractured_roam",
]);

function copyVector(vector) {
  return { x: vector.x, y: vector.y, z: vector.z };
}

/** Mirrors MultipartEntityPart.updatePosition and Leg.tick. */
export function multipartWorldPosition(parentPosition, offset, yawDegrees = 0) {
  const yaw = (yawDegrees * Math.PI) / 180;
  return {
    x: parentPosition.x + offset.x * Math.cos(yaw) - offset.z * Math.sin(yaw),
    y: parentPosition.y + offset.y,
    z: parentPosition.z + offset.x * Math.sin(yaw) + offset.z * Math.cos(yaw),
  };
}

/** Returns detached definitions so runtime callers cannot mutate source data. */
export function multipartPartDefinitions() {
  const parentParts = Object.values(FRACTURED_MULTIPART_SOURCE.parts).map((part) => ({
    name: part.name,
    role: "part",
    width: part.width,
    height: part.height,
    offset: copyVector(part.offset),
  }));
  const legs = Object.values(FRACTURED_MULTIPART_SOURCE.subEntities).map((part) => ({
    name: part.name,
    role: "sub_entity",
    width: part.width,
    height: part.height,
    defaultOffset: copyVector(part.defaultOffset),
    targetOffset: copyVector(part.targetOffset),
  }));
  return [...parentParts, ...legs];
}

function partOffset(part) {
  return part.role === "sub_entity" ? part.targetOffset : part.offset;
}

/**
 * Builds the six logical AABBs that replace Java multipart entities. Entity
 * positions are treated as the lower Y edge, matching the source setPos plus
 * EntityDimensions behavior; the current Bedrock entity remains the renderer.
 * @param {{ position?: { x: number, y: number, z: number }, yawDegrees?: number }} options
 */
export function multipartAabbs({ position, yawDegrees = 0 } = {}) {
  if (!position) return [];
  return multipartPartDefinitions().map((part) => {
    const center = multipartWorldPosition(position, partOffset(part), yawDegrees);
    const halfWidth = part.width / 2;
    return {
      name: part.name,
      role: part.role,
      min: {
        x: center.x - halfWidth,
        y: center.y,
        z: center.z - halfWidth,
      },
      max: {
        x: center.x + halfWidth,
        y: center.y + part.height,
        z: center.z + halfWidth,
      },
    };
  });
}

/** Mirrors BaseFracturedEntity's decrement-then-promote switching tick. */
export function fracturedRoamSwitchStep(switchTicks = FRACTURED_MULTIPART_SOURCE.roamSwitchTicks) {
  const current = Math.max(0, Math.floor(Number(switchTicks) || 0));
  if (current === 0) return { switchTicks: 0, promote: true };
  const next = current - 1;
  return { switchTicks: next, promote: next === 0 };
}

export function pointInsideAabb(point, aabb) {
  if (!point || !aabb) return false;
  return point.x >= aabb.min.x && point.x <= aabb.max.x &&
    point.y >= aabb.min.y && point.y <= aabb.max.y &&
    point.z >= aabb.min.z && point.z <= aabb.max.z;
}

/** Mirrors MultipartEntity/MultipartEntityPart.is(entity). */
export function multipartEntityMatches(part, entityId) {
  return Boolean(part?.name && (part.name === entityId || PARENT_TYPES.includes(entityId)));
}

function isArrowProjectile(projectileType) {
  return projectileType === "minecraft:arrow" || projectileType === "minecraft:spectral_arrow";
}

/**
 * Mirrors FracturedPartEntity.hurt ordering. Arrow side effects occur before
 * the source invulnerability check; a FracturedRoam part swaps first and gets
 * none of those effects.
 */
export function fracturedPartHitPlan({
  parentType = "thebrokenscript:fractured",
  partHit = false,
  projectileType = null,
  projectileOnFire = false,
  invulnerable = false,
} = {}) {
  const hit = partHit === true;
  const isRoam = parentType === "thebrokenscript:fractured_roam";
  const arrow = isArrowProjectile(projectileType);
  const swap = hit && isRoam;
  const allowParentDamage = hit && !swap && !invulnerable && arrow;
  return {
    cancel: !allowParentDamage,
    allowParentDamage,
    markHitViaPart: allowParentDamage,
    swap,
    igniteSeconds: hit && !swap && arrow && projectileOnFire
      ? FRACTURED_MULTIPART_SOURCE.arrowEffects.igniteSeconds
      : 0,
    spectralGlowTicks: hit && !swap && projectileType === "minecraft:spectral_arrow"
      ? FRACTURED_MULTIPART_SOURCE.arrowEffects.spectralGlowTicks
      : 0,
  };
}
