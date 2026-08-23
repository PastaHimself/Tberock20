import { world } from "@minecraft/server";

// Chunk 16 perf helpers: shared caches so 1-tick controllers avoid redundant
// world.getAllPlayers()/getDimension calls when idle.

let lastPlayerCheckTick = -1;
let lastHasPlayers = false;
const dimCache = new Map();

export function hasPlayers(currentTick) {
  if (currentTick !== lastPlayerCheckTick) {
    try { lastHasPlayers = world.getAllPlayers().length > 0; } catch { lastHasPlayers = false; }
    lastPlayerCheckTick = currentTick;
  }
  return lastHasPlayers;
}

export function dim(name) {
  if (dimCache.has(name)) {
    const d = dimCache.get(name);
    try { if (d.isValid?.() !== false) return d; } catch {}
    dimCache.delete(name);
  }
  try {
    const d = world.getDimension(name);
    dimCache.set(name, d);
    return d;
  } catch {
    return undefined;
  }
}
