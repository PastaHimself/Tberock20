const DEG = Math.PI / 180;
const DEFAULT_EYE_HEIGHT = 1.62;

export function normalize(v) {
    const len = Math.hypot(v.x, v.y, v.z);
    if (len === 0) return { x: 0, y: 0, z: 0 };
    return { x: v.x / len, y: v.y / len, z: v.z / len };
}

export function dot(a, b) {
    return a.x * b.x + a.y * b.y + a.z * b.z;
}

export function directionFromTo(from, to) {
    return normalize({ x: to.x - from.x, y: to.y - from.y, z: to.z - from.z });
}

function headLocation(player) {
    return player.getHeadLocation?.() ?? {
        x: player.location.x,
        y: player.location.y + DEFAULT_EYE_HEIGHT,
        z: player.location.z,
    };
}

function dimensionId(value) {
    return value?.dimension?.id;
}

function sameDimension(player, target) {
    const playerDimension = dimensionId(player);
    const targetDimension = dimensionId(target);
    return !playerDimension || !targetDimension || playerDimension === targetDimension;
}

function hitDistance(hit, origin) {
    if (typeof hit?.distance === "number") return hit.distance;
    const blockOrigin = hit?.block?.location;
    const faceLocation = hit?.faceLocation;
    if (blockOrigin && faceLocation) {
        return Math.hypot(
            blockOrigin.x + faceLocation.x - origin.x,
            blockOrigin.y + faceLocation.y - origin.y,
            blockOrigin.z + faceLocation.z - origin.z,
        );
    }
    if (!blockOrigin) return Number.NaN;
    return Math.hypot(
        blockOrigin.x + 0.5 - origin.x,
        blockOrigin.y + 0.5 - origin.y,
        blockOrigin.z + 0.5 - origin.z,
    );
}

export function hasLineOfSight(player, targetLocation, { tolerance = 0.35 } = {}) {
    const origin = headLocation(player);
    const toTarget = {
        x: targetLocation.x - origin.x,
        y: targetLocation.y - origin.y,
        z: targetLocation.z - origin.z,
    };
    const distance = Math.hypot(toTarget.x, toTarget.y, toTarget.z);
    if (distance === 0) return true;

    const raycaster = player.dimension?.getBlockFromRay;
    if (typeof raycaster !== "function") return true;

    let hit;
    try {
        hit = raycaster.call(player.dimension, origin, normalize(toTarget), {
            maxDistance: distance,
            includeLiquidBlocks: false,
            includePassableBlocks: false,
        });
    } catch {
        return false;
    }

    if (!hit) return true;
    const obstructionDistance = hitDistance(hit, origin);
    return Number.isFinite(obstructionDistance) && obstructionDistance >= distance - tolerance;
}

function isWithinGazeCone(player, targetLocation, maxDegrees) {
    const origin = headLocation(player);
    const dist = Math.hypot(
        targetLocation.x - origin.x,
        targetLocation.y - origin.y,
        targetLocation.z - origin.z,
    );
    const extraDeg = dist < 16 ? (16 - dist) : 0;
    const limit = Math.cos((maxDegrees + extraDeg) * DEG);
    const view = player.getViewDirection();
    const to = directionFromTo(origin, targetLocation);
    return dot(view, to) >= limit;
}

function hitboxSamples(entity) {
    let aabb;
    try {
        aabb = entity.getAABB?.();
    } catch {
        return [entity.location];
    }

    const min = aabb?.min ?? (aabb?.center && aabb?.extent ? {
        x: aabb.center.x - aabb.extent.x,
        y: aabb.center.y - aabb.extent.y,
        z: aabb.center.z - aabb.extent.z,
    } : undefined);
    const max = aabb?.max ?? (aabb?.center && aabb?.extent ? {
        x: aabb.center.x + aabb.extent.x,
        y: aabb.center.y + aabb.extent.y,
        z: aabb.center.z + aabb.extent.z,
    } : undefined);
    if (!min || !max) return [entity.location];

    const center = {
        x: (min.x + max.x) / 2,
        y: (min.y + max.y) / 2,
        z: (min.z + max.z) / 2,
    };
    return [
        center,
        { x: min.x, y: min.y, z: min.z },
        { x: min.x, y: min.y, z: max.z },
        { x: min.x, y: max.y, z: min.z },
        { x: min.x, y: max.y, z: max.z },
        { x: max.x, y: min.y, z: min.z },
        { x: max.x, y: min.y, z: max.z },
        { x: max.x, y: max.y, z: min.z },
        { x: max.x, y: max.y, z: max.z },
    ];
}

// The source checks the entity hitbox rather than only its origin. Bedrock's
// raycast supplies the closest solid obstruction, so a visible hitbox sample is
// accepted only when no block is between the player's eyes and that sample.
export function isLookingAtLocation(player, targetLocation, maxDegrees = 12, options = {}) {
    if (!isWithinGazeCone(player, targetLocation, maxDegrees)) return false;
    return options.requireLineOfSight === false || hasLineOfSight(player, targetLocation, options);
}

export function isLookingAtEntity(player, entity, maxDegrees = 12, options = {}) {
    if (!entity?.location || !sameDimension(player, entity)) return false;
    return hitboxSamples(entity).some((sample) => isLookingAtLocation(player, sample, maxDegrees, options));
}
