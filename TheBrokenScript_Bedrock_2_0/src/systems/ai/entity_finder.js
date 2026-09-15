import { world } from "@minecraft/server";
import { closestTarget, dimensionIdOf } from "./targeting_model.js";

export function closestPlayerInRange(players, location, maxDistance, options = {}) {
    const dimensionId = options.dimensionId ?? dimensionIdOf(options.dimension);
    return closestTarget(players, location, maxDistance, { dimensionId });
}

export function closestPlayerForEntity(players, entity, maxDistance, options = {}) {
    return closestPlayerInRange(players, entity?.location, maxDistance, {
        ...options,
        dimensionId: options.dimensionId ?? dimensionIdOf(entity?.dimension),
    });
}

export function countEntitiesInRange(dimension, location, maxDistance, typeIds) {
    const found = dimension.getEntities({
        location,
        maxDistance,
        type: typeIds.length === 1 ? typeIds[0] : undefined
    });
    if (typeIds.length <= 1) return found.length;
    const set = new Set(typeIds);
    let n = 0;
    for (const e of found) {
        if (set.has(e.typeId)) n++;
    }
    return n;
}

export function hasEntitiesInRange(dimension, location, maxDistance, typeIds) {
    return countEntitiesInRange(dimension, location, maxDistance, typeIds) > 0;
}

export function allPlayers() {
    return world.getAllPlayers();
}
