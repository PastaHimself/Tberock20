import * as operationDiagnostics from "../core/operation_diagnostics.js";
// Pure cache primitives for the engine-facing performance adapter.
//
// Dimension handles are intentionally invalidated by an explicit lifecycle
// signal. The Bedrock Dimension API does not expose the Entity.isValid property
// as a dimension-handle validation signal, so probing an optional validity
// method would be both
// unsupported and unable to prove that a cached handle is still usable.

/**
 * @param {() => Array<any>} readPlayers
 */
export function createPlayerPresenceCache(readPlayers) {
    if (typeof readPlayers !== "function") {
        throw new TypeError("perf: player reader must be a function");
    }

    let lastPlayerCheckTick = -1;
    let lastHasPlayers = false;

    return {
        hasPlayers(currentTick) {
            if (currentTick !== lastPlayerCheckTick) {
                try {
                    lastHasPlayers = readPlayers().length > 0;
                } catch {
                    lastHasPlayers = false;
                }
                lastPlayerCheckTick = currentTick;
            }
            return lastHasPlayers;
        },

        reset() {
            lastPlayerCheckTick = -1;
            lastHasPlayers = false;
        },
    };
}

/**
 * @param {(name: string) => any} readDimension
 * @param {(error: any, name: string) => void} [onError]
 */
export function createDimensionHandleCache(readDimension, onError) {
    if (typeof readDimension !== "function") {
        throw new TypeError("perf: dimension reader must be a function");
    }

    const cache = new Map();

    return {
        get(name) {
            if (cache.has(name)) return cache.get(name);
            try {
                const dimension = readDimension(name);
                cache.set(name, dimension);
                return dimension;
            } catch (error) {
              operationDiagnostics.warnOnce("audit.BP.scripts.systems.perf_model.js.58", "best-effort Bedrock API fallback", error);
                // Do not cache failures: a dimension can become available after
                // world initialization or a transient engine error.
                try {
                    onError?.(error, name);
                } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.perf_model.js.63", "best-effort Bedrock API fallback", error);
                    // Error reporting must not change cache behavior.
                }
                return undefined;
            }
        },

        invalidate(name) {
            return cache.delete(name);
        },

        clear() {
            cache.clear();
        },
    };
}
