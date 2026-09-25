import { STAGE2_GENERATOR_SOURCE, stage2GeneratorDecorationPlan } from "./integrity_arena_model.js";

const CHUNK_SIZE = 16;
const CELL_SIZE_CHUNKS = 3;

// Keep generation within one bounded ticking area. Cells do not overlap, so
// revisiting a neighboring cell never overwrites a player's earlier edits.
export function stage2Cell(location) {
  const chunkX = Math.floor(location.x / CHUNK_SIZE);
  const chunkZ = Math.floor(location.z / CHUNK_SIZE);
  const cellX = Math.floor(chunkX / CELL_SIZE_CHUNKS);
  const cellZ = Math.floor(chunkZ / CELL_SIZE_CHUNKS);
  const minX = cellX * CELL_SIZE_CHUNKS * CHUNK_SIZE;
  const minZ = cellZ * CELL_SIZE_CHUNKS * CHUNK_SIZE;
  const chunks = [];
  for (let x = minX; x < minX + CELL_SIZE_CHUNKS * CHUNK_SIZE; x += CHUNK_SIZE) {
    for (let z = minZ; z < minZ + CELL_SIZE_CHUNKS * CHUNK_SIZE; z += CHUNK_SIZE) {
      if (stage2GeneratorDecorationPlan(x, z)) chunks.push({ x, z });
    }
  }
  return {
    key: `${cellX}:${cellZ}`,
    chunks,
    bounds: {
      from: { x: minX, y: -64, z: minZ },
      to: { x: minX + 47, y: 271, z: minZ + 47 },
    },
  };
}

export function stage2NeighborCells(location, margin = 16) {
  const current = stage2Cell(location);
  const { from, to } = current.bounds;
  const width = CELL_SIZE_CHUNKS * CHUNK_SIZE;
  const neighbors = [];
  const add = (x, z) => {
    const cell = stage2Cell({ x, z });
    if (cell.chunks.length) neighbors.push(cell);
  };
  if (location.x - from.x <= margin) add(from.x - width / 2, from.z + width / 2);
  if (to.x - location.x <= margin) add(to.x + 1 + width / 2, from.z + width / 2);
  if (location.z - from.z <= margin) add(from.x + width / 2, from.z - width / 2);
  if (to.z - location.z <= margin) add(from.x + width / 2, to.z + 1 + width / 2);
  return neighbors;
}

export function stage2ChunkLayers(x, z) {
  const plan = stage2GeneratorDecorationPlan(x, z);
  if (!plan) return [];
  if (plan.region === "border") return [{ y: plan.outerBarrierY, block: "minecraft:barrier" }];
  const layers = [];
  for (const layer of plan.floorLayers) {
    layers.push({ y: layer.y - 1, block: layer.belowBlock });
    layers.push({ y: layer.y, block: layer.y === 199 ? "thebrokenscript:cobblestone_border_block" : layer.sourceBlock });
  }
  for (const y of plan.barrierLayers) layers.push({ y, block: "minecraft:barrier" });
  layers.push({ y: plan.outerBarrierY, block: "minecraft:barrier" });
  // fieldbase.nbt has a solid bedrock base and grass-block surface. These
  // layers ensure a safe platform even if native structure placement fails.
  layers.push({ y: plan.surface.y, block: "minecraft:bedrock" });
  layers.push({ y: plan.surface.y + 1, block: "minecraft:grass_block" });
  return layers;
}

export function stage2ChunkWalls(x, z) {
  const plan = stage2GeneratorDecorationPlan(x, z);
  if (!plan || plan.region !== "border") return [];
  const walls = [];
  for (const offset of [1, 14]) {
    if (x === 0 || x === 160) walls.push({
      from: { x: x + offset, y: -64, z },
      to: { x: x + offset, y: 270, z: z + 15 },
      block: "minecraft:barrier",
    });
    if (z === 0 || z === 160) walls.push({
      from: { x, y: -64, z: z + offset },
      to: { x: x + 15, y: 270, z: z + offset },
      block: "minecraft:barrier",
    });
  }
  return walls;
}

export function fillStage2Cell(cell, fill) {
  for (const { x, z } of cell.chunks) {
    for (const { y, block } of stage2ChunkLayers(x, z)) {
      fill({ x, y, z }, { x: x + 15, y, z: z + 15 }, block);
    }
    for (const wall of stage2ChunkWalls(x, z)) fill(wall.from, wall.to, wall.block);
  }
}

export const STAGE2_TERRAIN_SOURCE = STAGE2_GENERATOR_SOURCE;
