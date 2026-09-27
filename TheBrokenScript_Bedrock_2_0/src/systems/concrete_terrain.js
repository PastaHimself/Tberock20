export const CONCRETE_TERRAIN = Object.freeze({
  dimensionId: "thebrokenscript:concrete",
  stage: "source_concrete_terrain",
  version: 1,
  chunkSize: 16,
  cellSizeChunks: 1,
  minY: -64,
  maxY: 319,
  firstLevel: -6,
  lastLevel: 26,
  levelHeight: 9,
  preferredLandingY: 201,
  structureId: "thebrokenscript:concrete",
  stripeChunkXs: Object.freeze([-5, 0, 5]),
  rotation: "clockwise_180_baked",
});

function finiteCoordinate(value, name) {
  const number = Number(value);
  if (!Number.isFinite(number)) throw new TypeError(`${name} must be finite`);
  return number;
}

function isStripeChunk(chunkX) {
  return CONCRETE_TERRAIN.stripeChunkXs.includes(chunkX);
}

export function concreteCell(location) {
  const chunkX = Math.floor(finiteCoordinate(location?.x, "location.x") / CONCRETE_TERRAIN.chunkSize);
  const chunkZ = Math.floor(finiteCoordinate(location?.z, "location.z") / CONCRETE_TERRAIN.chunkSize);
  const minX = chunkX * CONCRETE_TERRAIN.chunkSize;
  const minZ = chunkZ * CONCRETE_TERRAIN.chunkSize;
  return {
    key: `${chunkX}:${chunkZ}`,
    chunk: { x: chunkX, z: chunkZ },
    eligible: isStripeChunk(chunkX),
    bounds: {
      from: { x: minX, y: CONCRETE_TERRAIN.minY, z: minZ },
      to: {
        x: minX + CONCRETE_TERRAIN.chunkSize - 1,
        y: CONCRETE_TERRAIN.maxY,
        z: minZ + CONCRETE_TERRAIN.chunkSize - 1,
      },
    },
  };
}

export function concreteExplorationCells(locations) {
  const groups = locations.map((location) => {
    const current = concreteCell(location);
    if (!current.eligible) return [];
    return [
      current,
      concreteCell({ x: current.bounds.from.x, z: current.bounds.from.z - 1 }),
      concreteCell({ x: current.bounds.from.x, z: current.bounds.to.z + 1 }),
    ];
  });
  const cells = [];
  const seen = new Set();
  const groupSize = groups.reduce((largest, group) => Math.max(largest, group.length), 0);
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

export function concreteChunkPlacements(chunkX, chunkZ) {
  const x = Math.floor(finiteCoordinate(chunkX, "chunkX"));
  const z = Math.floor(finiteCoordinate(chunkZ, "chunkZ"));
  if (!isStripeChunk(x)) return [];

  const placements = [];
  for (let level = CONCRETE_TERRAIN.firstLevel; level <= CONCRETE_TERRAIN.lastLevel; level++) {
    placements.push({
      level,
      structureId: CONCRETE_TERRAIN.structureId,
      position: {
        x: x * CONCRETE_TERRAIN.chunkSize,
        y: level * CONCRETE_TERRAIN.levelHeight,
        z: z * CONCRETE_TERRAIN.chunkSize,
      },
    });
  }
  return placements;
}

export function concreteCellPlan(cell) {
  return {
    cell,
    placements: concreteChunkPlacements(cell.chunk.x, cell.chunk.z),
  };
}

export function executeConcreteCellPlan(plan, place) {
  for (const { structureId, position } of plan.placements) place(structureId, position);
}
