import * as operationDiagnostics from "../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import * as events from "../core/events.js";
import * as state from "../core/state.js";
import { logger } from "../core/logging.js";
import {
    chunkCoordinate,
    createModifiedChunkLedger,
} from "./chunk_remover_model.js";

// Java stores this map in SavedData named tbs_player_modified_chunks. Bedrock
// has no per-dimension SavedData equivalent, so the world JSON property uses a
// dimension-qualified key. The bound is a safety valve for the 30 KB property
// limit: once tracking cannot be persisted, chunk removal fails closed.
const STATE_KEY = "playerModifiedChunks";
const MAX_LEDGER_ENTRIES = 400;

let ledger = createModifiedChunkLedger();
let initialized = false;
let persistenceHealthy = true;
let trackingOverflow = false;
let begun = false;

function isValid(value) {
    if (!value) return false;
    try { return value.isValid !== false; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.modified_chunks.js.25", "best-effort Bedrock API fallback", error); return false; }
}

function topSurfaceY(dimension, location) {
    try {
        const top = dimension.getTopmostBlock({ x: location.x, z: location.z });
        const y = top?.location?.y ?? top?.y;
        // Java Heightmap#getHeight is the first available block above the
        // topmost WORLD_SURFACE block; getTopmostBlock returns that surface
        // block itself, hence the +1 conversion.
        return typeof y === "number" ? Math.floor(y) + 1 : undefined;
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.modified_chunks.js.36", "best-effort Bedrock API fallback", error);
        return undefined;
    }
}

function isAtOrAboveWorldSurface(event, delta) {
    const block = event?.block;
    const dimension = block?.dimension;
    const location = block?.location;
    if (!dimension || !location) return false;
    const surfaceY = topSurfaceY(dimension, location);
    if (!Number.isInteger(surfaceY)) return false;
    // playerPlaceBlock is an after-event: the placed block is now part of the
    // WORLD_SURFACE heightmap, so its old surface position is surfaceY - 1.
    // playerBreakBlock observes the post-break heightmap and keeps the source
    // condition at the current surfaceY.
    const threshold = delta > 0 ? surfaceY - 1 : surfaceY;
    return Math.floor(location.y) >= threshold;
}

function persist() {
    if (!persistenceHealthy) return false;
    try {
        state.setWorldJSON(STATE_KEY, ledger.serialize());
        return true;
    } catch (error) {
        persistenceHealthy = false;
        trackingOverflow = true;
        logger.error("modified_chunks: persistence failed; chunk removal is now fail-closed", error);
        return false;
    }
}

function record(event, delta) {
    const player = event?.player;
    const block = event?.block;
    if (!isValid(player) || !isAtOrAboveWorldSurface(event, delta)) return false;

    const dimension = block.dimension;
    const location = block.location;
    const chunkX = chunkCoordinate(location.x);
    const chunkZ = chunkCoordinate(location.z);
    const before = ledger.serialize();
    const currentlyTracked = ledger.count(dimension.id, chunkX, chunkZ) > 0;
    if (!currentlyTracked && delta > 0 && before.entries.length >= MAX_LEDGER_ENTRIES) {
        if (!trackingOverflow) {
            trackingOverflow = true;
            logger.error(`modified_chunks: ${MAX_LEDGER_ENTRIES} entry safety bound reached; chunk removal disabled until reload`);
        }
        return false;
    }

    ledger.record(dimension.id, chunkX, chunkZ, delta);
    if (!persist()) {
        ledger = createModifiedChunkLedger(before);
        return false;
    }
    return true;
}

export function countModifiedChunk(dimensionId, chunkX, chunkZ) {
    if (!initialized || !persistenceHealthy || trackingOverflow) return 1;
    return ledger.count(dimensionId, chunkX, chunkZ);
}

export function begin() {
    if (begun) return;
    begun = true;
    try {
        ledger = createModifiedChunkLedger(state.getWorldJSON(STATE_KEY));
    } catch (error) {
        persistenceHealthy = false;
        trackingOverflow = true;
        logger.error("modified_chunks: failed to load persisted ledger; chunk removal is fail-closed", error);
    }
    initialized = true;

    events.subscribeGuarded(
        world.afterEvents.playerPlaceBlock,
        "modified-chunks.playerPlace",
        "chunk-tracker",
        (event) => record(event, 1),
    );
    events.subscribeGuarded(
        world.afterEvents.playerBreakBlock,
        "modified-chunks.playerBreak",
        "chunk-tracker",
        (event) => record(event, -1),
    );
}

export function snapshot() {
    return {
        initialized,
        persistenceHealthy,
        trackingOverflow,
        ledger: ledger.serialize(),
    };
}
