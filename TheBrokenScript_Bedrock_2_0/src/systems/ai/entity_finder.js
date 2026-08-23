import { world } from "@minecraft/server";

export function closestPlayerInRange(players, location, maxDistance) {
    let best = null;
    let bestDist = maxDistance * maxDistance;
    for (const p of players) {
        if (p.dimension.id !== undefined && location.dimension !== undefined && p.dimension.id !== location.dimension.id) continue;
        const dx = p.location.x - location.x;
        const dy = p.location.y - location.y;
        const dz = p.location.z - location.z;
        const d2 = dx * dx + dy * dy + dz * dz;
        if (d2 <= bestDist) {
            bestDist = d2;
            best = p;
        }
    }
    return best;
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
