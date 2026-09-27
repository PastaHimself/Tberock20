export const LIBRARY_TERRAIN = Object.freeze({
  dimensionId: "thebrokenscript:library",
  stage: "source_library_terrain",
  version: 1,
  chunkSize: 16,
  cellSizeChunks: 1,
  minY: -64,
  maxY: 255,
  firstLevel: -3,
  lastLevel: 11,
  levelHeight: 17,
  preferredLandingY: 201,
  structures: Object.freeze({
    normal: "thebrokenscript:library",
    variant: "thebrokenscript:library2",
  }),
  variantLevels: Object.freeze([0, 4, 8]),
});

function finiteCoordinate(value, name) {
  const number = Number(value);
  if (!Number.isFinite(number)) throw new TypeError(`${name} must be finite`);
  return number;
}

export function libraryCell(location) {
  const chunkX = Math.floor(finiteCoordinate(location?.x, "location.x") / LIBRARY_TERRAIN.chunkSize);
  const chunkZ = Math.floor(finiteCoordinate(location?.z, "location.z") / LIBRARY_TERRAIN.chunkSize);
  const minX = chunkX * LIBRARY_TERRAIN.chunkSize;
  const minZ = chunkZ * LIBRARY_TERRAIN.chunkSize;
  return {
    key: `${chunkX}:${chunkZ}`,
    chunk: { x: chunkX, z: chunkZ },
    bounds: {
      from: { x: minX, y: LIBRARY_TERRAIN.minY, z: minZ },
      to: {
        x: minX + LIBRARY_TERRAIN.chunkSize - 1,
        y: LIBRARY_TERRAIN.maxY,
        z: minZ + LIBRARY_TERRAIN.chunkSize - 1,
      },
    },
  };
}

export function libraryNeighborCells(location, margin = LIBRARY_TERRAIN.chunkSize) {
  const current = libraryCell(location);
  const { from, to } = current.bounds;
  const neighborXs = [];
  const neighborZs = [];
  if (location.x - from.x <= margin) neighborXs.push(from.x - 1);
  if (to.x - location.x <= margin) neighborXs.push(to.x + 1);
  if (location.z - from.z <= margin) neighborZs.push(from.z - 1);
  if (to.z - location.z <= margin) neighborZs.push(to.z + 1);
  const neighbors = [];
  for (const x of neighborXs) neighbors.push(libraryCell({ x, z: location.z }));
  for (const z of neighborZs) neighbors.push(libraryCell({ x: location.x, z }));
  for (const x of neighborXs) {
    for (const z of neighborZs) neighbors.push(libraryCell({ x, z }));
  }
  return neighbors;
}

export function libraryExplorationCells(locations) {
  const groups = locations.map((location) => [
    libraryCell(location),
    ...libraryNeighborCells(location),
  ]);
  const cells = [];
  const seen = new Set();
  const groupSize = groups.reduce((largest, group) => Math.max(largest, group.length), 0);
  // Interleave each player's current/cardinal/diagonal cells so one explorer
  // cannot monopolize the generation budget for another explorer.
  for (let index = 0; index < groupSize; index++) {
    for (const group of groups) {
      const cell = group[index];
      if (!cell || seen.has(cell.key)) continue;
      seen.add(cell.key);
      cells.push(cell);
    }
  }
  return cells;
}

export function libraryChunkPlacements(chunkX, chunkZ) {
  const x = Math.floor(finiteCoordinate(chunkX, "chunkX"));
  const z = Math.floor(finiteCoordinate(chunkZ, "chunkZ"));
  const placements = [];
  for (let level = LIBRARY_TERRAIN.firstLevel; level <= LIBRARY_TERRAIN.lastLevel; level++) {
    const variant = LIBRARY_TERRAIN.variantLevels.includes(level);
    placements.push({
      level,
      structureId: variant
        ? LIBRARY_TERRAIN.structures.variant
        : LIBRARY_TERRAIN.structures.normal,
      position: {
        x: x * LIBRARY_TERRAIN.chunkSize,
        y: level * LIBRARY_TERRAIN.levelHeight,
        z: z * LIBRARY_TERRAIN.chunkSize,
      },
    });
  }
  return placements;
}

export function libraryCellPlan(cell) {
  return {
    cell,
    placements: libraryChunkPlacements(cell.chunk.x, cell.chunk.z),
  };
}

export function executeLibraryCellPlan(plan, place) {
  for (const { structureId, position } of plan.placements) place(structureId, position);
}
