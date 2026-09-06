// Pure, source-backed Phase 1 terrain corruption semantics.

export const PHASE1_TERRAIN_SOURCE = Object.freeze({
  radius: 100,
  ratio: 0.3,
  delayTicks: 20,
  initialTicksSinceLastCorrupt: 20,
  replacementBlockIds: Object.freeze([
    "thebrokenscript:obsidian",
    "thebrokenscript:r_3",
    "thebrokenscript:void_root",
    "thebrokenscript:teeth",
  ]),
  protectedBlockId: "thebrokenscript:corrupted_command_block",
});

export function createTerrainCorruptionQueue(center, options = {}) {
  const radius = Number(options.radius ?? PHASE1_TERRAIN_SOURCE.radius);
  const ratio = Number(options.ratio ?? PHASE1_TERRAIN_SOURCE.ratio);
  const nextFloat = typeof options.nextFloat === "function" ? options.nextFloat : Math.random;
  const shuffle = typeof options.shuffle === "function" ? options.shuffle : shuffleLocations;
  const radiusSquared = radius * radius;
  const locations = [];

  for (let x = -radius; x <= radius; x += 1) {
    for (let z = -radius; z <= radius; z += 1) {
      if (x * x + z * z > radiusSquared) continue;
      if (nextFloat() > ratio) continue;
      locations.push({ x: center.x + x, z: center.z + z });
    }
  }
  return shuffle(locations);
}

export function phase1TerrainTick(state, replacementProvider) {
  const terrainQueue = Array.isArray(state?.terrainQueue)
    ? state.terrainQueue.map((position) => ({ ...position }))
    : [];
  const ticksSinceLastCorrupt = Number.isFinite(state?.ticksSinceLastCorrupt)
    ? state.ticksSinceLastCorrupt
    : 0;

  if (terrainQueue.length === 0) {
    return { action: "idle", terrainQueue, ticksSinceLastCorrupt };
  }

  const nextTicks = ticksSinceLastCorrupt + 1;
  if (nextTicks < PHASE1_TERRAIN_SOURCE.delayTicks) {
    return { action: "wait", terrainQueue, ticksSinceLastCorrupt: nextTicks };
  }

  const replacementBlockId = typeof replacementProvider === "function"
    ? replacementProvider()
    : undefined;
  if (typeof replacementBlockId !== "string" || replacementBlockId.length === 0) {
    return { action: "replacement_unavailable", terrainQueue, ticksSinceLastCorrupt: 0 };
  }

  const position = terrainQueue.shift();
  return {
    action: "corrupt",
    position,
    replacementBlockId,
    terrainQueue,
    ticksSinceLastCorrupt: 0,
  };
}

function shuffleLocations(values) {
  const shuffled = [...values];
  for (let index = shuffled.length - 1; index > 0; index -= 1) {
    const swapIndex = Math.floor(Math.random() * (index + 1));
    [shuffled[index], shuffled[swapIndex]] = [shuffled[swapIndex], shuffled[index]];
  }
  return shuffled;
}
