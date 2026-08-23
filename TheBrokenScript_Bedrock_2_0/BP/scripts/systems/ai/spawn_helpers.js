import { logger } from "../../core/logging.js";

export function trySummon(dimension, entityTypeId, location, options = {}) {
    try {
        const opts = {};
        if (options.initialRotation !== undefined) opts.initialRotation = options.initialRotation;
        if (options.initialPersistence !== undefined) opts.initialPersistence = options.initialPersistence;
        return dimension.spawnEntity(entityTypeId, location, opts);
    } catch (err) {
        logger.error(`trySummon failed for ${entityTypeId}`, err);
        return undefined;
    }
}

export function applyRandomRotation(entity) {
    if (entity === undefined || !entity.isValid) return entity;
    try {
        entity.setRotation({ x: 0, y: Math.random() * 360 });
    } catch {
        entity.teleport(entity.location, { rotation: { x: 0, y: Math.random() * 360 } });
    }
    return entity;
}

// Source: TimeOfDay.MIDNIGHT.setFake() — forces world time to midnight as a scare beat.
export function setFakeMidnight(dimension) {
    dimension.runCommandAsync("time set midnight").catch(() => {});
}
