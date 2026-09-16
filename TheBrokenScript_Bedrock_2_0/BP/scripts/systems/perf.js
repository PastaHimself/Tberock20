import { world } from "@minecraft/server";
import {
    createDimensionHandleCache,
    createPlayerPresenceCache,
} from "./perf_model.js";

// Chunk 16 perf helpers: shared caches so 1-tick controllers avoid redundant
// world.getAllPlayers()/getDimension calls when idle.

const playerPresence = createPlayerPresenceCache(() => world.getAllPlayers());
const dimensionHandles = createDimensionHandleCache((name) => world.getDimension(name));

export function hasPlayers(currentTick) {
  return playerPresence.hasPlayers(currentTick);
}

export function dim(name) {
  return dimensionHandles.get(name);
}

export function invalidateDimension(name) {
  return dimensionHandles.invalidate(name);
}

export function reset() {
  playerPresence.reset();
  dimensionHandles.clear();
}
