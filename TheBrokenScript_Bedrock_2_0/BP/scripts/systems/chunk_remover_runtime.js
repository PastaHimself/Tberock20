import { BlockVolume, system, world } from "@minecraft/server";
import * as events from "../core/events.js";
import { config } from "../core/config.js";
import { logger } from "../core/logging.js";
import {
    chunkCoordinate,
    chunkRemovalPlan,
    chunkVerticalMovePlan,
} from "./chunk_remover_model.js";

const CHUNK_REMOVER_ID = "thebrokenscript:chunk_remover";
const HANDLED_ENTITY_RETENTION_TICKS = 20;
const handledEntities = new Set();
let begun = false;

function isValid(entity) {
    if (!entity) return false;
    try { return entity.isValid !== false; } catch { return false; }
}

function integer(value, fallback) {
    return Number.isFinite(value) ? Math.trunc(value) : fallback;
}

function dimensionHeight(dimension) {
    try {
        const range = dimension.heightRange;
        const min = integer(range?.min, -64);
        const max = integer(range?.max, 320);
        if (max > min && (max - min) % 16 === 0) return { min, max };
    } catch {}
    return { min: -64, max: 320 };
}

function chunkBounds(dimension, location) {
    const chunkX = chunkCoordinate(location.x);
    const chunkZ = chunkCoordinate(location.z);
    return {
        chunkX,
        chunkZ,
        minX: chunkX * 16,
        minZ: chunkZ * 16,
        ...dimensionHeight(dimension),
    };
}

function isLoaded(dimension, location) {
    try {
        return typeof dimension.isChunkLoaded === "function" &&
            dimension.isChunkLoaded({ x: Math.floor(location.x), y: 0, z: Math.floor(location.z) });
    } catch {
        return false;
    }
}

function playSourceSound(dimension, location) {
    // Bedrock sound pitch is bounded away from zero, while Java accepts the
    // source's pitch 0.0. 0.01 is the documented closest supported value.
    try {
        for (const player of world.getAllPlayers()) {
            if (!isValid(player) || player.dimension?.id !== dimension.id) continue;
            const dx = player.location.x - location.x;
            const dy = player.location.y - location.y;
            const dz = player.location.z - location.z;
            if (dx * dx + dy * dy + dz * dz > 16 ** 2) continue;
            player.playSound("ambient.cave", { volume: 10, pitch: 0.01 });
        }
    } catch {}
}

function fillSection(dimension, bounds, y) {
    try {
        const volume = new BlockVolume(
            { x: bounds.minX, y, z: bounds.minZ },
            { x: bounds.minX + 15, y: y + 15, z: bounds.minZ + 15 },
        );
        dimension.fillBlocks(volume, "minecraft:air", { ignoreChunkBoundErrors: false });
        return true;
    } catch (error) {
        logger.error(`chunk_remover: fill failed at ${bounds.chunkX},${bounds.chunkZ},y=${y}`, error);
        return false;
    }
}

function clearChunk(dimension, location) {
    const bounds = chunkBounds(dimension, location);
    if (!isLoaded(dimension, location)) return false;
    try {
        const volume = new BlockVolume(
            { x: bounds.minX, y: bounds.min, z: bounds.minZ },
            { x: bounds.minX + 15, y: bounds.max - 1, z: bounds.minZ + 15 },
        );
        dimension.fillBlocks(volume, "minecraft:air", { ignoreChunkBoundErrors: false });
        return true;
    } catch (error) {
        logger.error(`chunk_remover: clear failed at ${bounds.chunkX},${bounds.chunkZ}`, error);
        return false;
    }
}

/**
 * Bedrock equivalent of the source `tbs chunk remove` developer command.
 * The command is intentionally separate from applyChunkRemoval: Java's
 * command always clears the current chunk and does not roll the 5%/move
 * outcome used by ChunkRemoverEntity.
 */
export function clearChunkAt(dimension, location) {
    if (!dimension || !location) {
        return { ok: false, operation: "invalid" };
    }
    return { ok: clearChunk(dimension, location), operation: "clear" };
}

function runCloneMove(dimension, bounds, sourceY, destinationY) {
    const command = [
        "clone",
        bounds.minX, sourceY, bounds.minZ,
        bounds.minX + 15, sourceY + 15, bounds.minZ + 15,
        bounds.minX, destinationY, bounds.minZ,
        "replace", "move",
    ].join(" ");
    try {
        dimension.runCommand(command);
        return true;
    } catch (error) {
        logger.error(`chunk_remover: section move failed at ${bounds.chunkX},${bounds.chunkZ},y=${sourceY}`, error);
        return false;
    }
}

function moveChunkUp(dimension, location, offsetY) {
    const bounds = chunkBounds(dimension, location);
    if (!isLoaded(dimension, location)) return false;
    const plan = chunkVerticalMovePlan({ minY: bounds.min, maxY: bounds.max, offsetY });
    if (plan.length === 0) return false;

    // The source shifts whole sections from high to low so an upward move
    // cannot overwrite a section that has not been read yet. The stable clone
    // command is used instead of the @rc Dimension.cloneBlocks API.
    for (const section of plan) {
        const ok = section.operation === "clear"
            ? fillSection(dimension, bounds, section.sourceY)
            : runCloneMove(dimension, bounds, section.sourceY, section.destinationY);
        if (!ok) return false;
    }

    // ChunkUtil teleports every entity whose resulting Y remains in the build
    // range. Entity queries are restricted to this one loaded chunk and are
    // filtered again because volume queries use an extent around their center.
    try {
        const center = {
            x: bounds.minX + 8,
            y: (bounds.min + bounds.max) / 2,
            z: bounds.minZ + 8,
        };
        const entities = dimension.getEntities({
            location: center,
            volume: { x: 16, y: bounds.max - bounds.min, z: 16 },
        });
        for (const entity of entities) {
            if (!isValid(entity) || !entity.location) continue;
            const position = entity.location;
            if (position.x < bounds.minX || position.x >= bounds.minX + 16 ||
                position.z < bounds.minZ || position.z >= bounds.minZ + 16 ||
                position.y < bounds.min || position.y >= bounds.max) continue;
            const newY = position.y + offsetY;
            if (newY < bounds.min || newY >= bounds.max) continue;
            try {
                entity.teleport({ x: position.x, y: newY, z: position.z });
            } catch (error) {
                logger.debug(`chunk_remover: entity ${entity.id ?? "unknown"} did not move: ${String(error)}`);
            }
        }
    } catch (error) {
        logger.error(`chunk_remover: entity move query failed at ${bounds.chunkX},${bounds.chunkZ}`, error);
    }
    return true;
}

/** Execute the source's 5% clear / 95% 16..128-block upward operation. */
export function applyChunkRemoval(dimension, location, random = Math.random) {
    if (!dimension || !location || config.get("world.disableChunkRemoval")) {
        return { ok: false, operation: "disabled" };
    }
    const actionRoll = random();
    const plan = actionRoll < 0.05
        ? chunkRemovalPlan({ actionRoll })
        : chunkRemovalPlan({ actionRoll, offsetRoll: random() });
    playSourceSound(dimension, location);
    const ok = plan.operation === "clear"
        ? clearChunk(dimension, location)
        : moveChunkUp(dimension, location, plan.offsetY);
    return { ok, ...plan };
}

function rememberHandledEntity(entityId) {
    handledEntities.add(entityId);
    try {
        system.runTimeout(() => handledEntities.delete(entityId), HANDLED_ENTITY_RETENTION_TICKS);
    } catch {
        // If scheduling is unavailable, prefer losing duplicate suppression over
        // retaining every historical entity id for the rest of the server run.
        handledEntities.delete(entityId);
    }
}

/**
 * ChunkRemoverEntity cancels its spawn in onFinalizeSpawn. Removing the
 * Bedrock entity before applying the operation gives the same observable
 * result and prevents the remover itself from being teleported by a move.
 */
export function handleChunkRemoverEntity(entity) {
    if (!isValid(entity) || entity.typeId !== CHUNK_REMOVER_ID || handledEntities.has(entity.id)) return undefined;
    rememberHandledEntity(entity.id);
    const dimension = entity.dimension;
    const location = entity.location && { ...entity.location };
    try { entity.remove(); } catch {}
    if (!dimension || !location) return { ok: false, operation: "invalid" };
    return applyChunkRemoval(dimension, location);
}

function onEntitySpawn(event) {
    const entity = event?.entity;
    if (!entity || entity.typeId !== CHUNK_REMOVER_ID) return;
    try {
        system.run(() => handleChunkRemoverEntity(entity));
    } catch (error) {
        logger.error("chunk_remover: failed to defer spawned entity operation", error);
    }
}

export function begin() {
    if (begun) return;
    begun = true;
    events.subscribeGuarded(world.afterEvents.entitySpawn, "chunk-remover.entitySpawn", "chunk-remover", onEntitySpawn);
}
