const CHUNK_SIZE = 16;
const CELL_SIZE_CHUNKS = 3;
const CELL_SIZE = CHUNK_SIZE * CELL_SIZE_CHUNKS;

export const SIMPLE_DIMENSION_TERRAIN = Object.freeze({
  limbo: Object.freeze({
    dimensionId: "thebrokenscript:limbo",
    stage: "source_limbo_terrain",
    version: 1,
    block: "thebrokenscript:limbo",
    y: 0,
    minY: -64,
    maxY: 255,
  }),
  nothing: Object.freeze({
    dimensionId: "thebrokenscript:nothing",
    stage: "source_nothing_terrain",
    version: 1,
    block: "thebrokenscript:nothing",
    y: 0,
    minY: -64,
    maxY: 255,
  }),
});

export function singleLayerCell(location, spec) {
  const chunkX = Math.floor(location.x / CHUNK_SIZE);
  const chunkZ = Math.floor(location.z / CHUNK_SIZE);
  const cellX = Math.floor(chunkX / CELL_SIZE_CHUNKS);
  const cellZ = Math.floor(chunkZ / CELL_SIZE_CHUNKS);
  const minX = cellX * CELL_SIZE;
  const minZ = cellZ * CELL_SIZE;
  return {
    key: `${cellX}:${cellZ}`,
    bounds: {
      from: { x: minX, y: spec.minY, z: minZ },
      to: { x: minX + CELL_SIZE - 1, y: spec.maxY, z: minZ + CELL_SIZE - 1 },
    },
  };
}

export function singleLayerNeighborCells(location, spec, margin = 16) {
  const current = singleLayerCell(location, spec);
  const { from, to } = current.bounds;
  const neighbors = [];
  const neighborXs = [];
  const neighborZs = [];
  const add = (x, z) => neighbors.push(singleLayerCell({ x, z }, spec));
  if (location.x - from.x <= margin) neighborXs.push(from.x - 1);
  if (to.x - location.x <= margin) neighborXs.push(to.x + 1);
  if (location.z - from.z <= margin) neighborZs.push(from.z - 1);
  if (to.z - location.z <= margin) neighborZs.push(to.z + 1);
  for (const x of neighborXs) add(x, location.z);
  for (const z of neighborZs) add(location.x, z);
  for (const x of neighborXs) {
    for (const z of neighborZs) add(x, z);
  }
  return neighbors;
}

export function fillSingleLayerCell(cell, spec, fill) {
  fill(
    { x: cell.bounds.from.x, y: spec.y, z: cell.bounds.from.z },
    { x: cell.bounds.to.x, y: spec.y, z: cell.bounds.to.z },
    spec.block,
  );
}
