import { BlockVolume, world } from "@minecraft/server";
import { ensureDimensionReady, registerDimensionInitializer } from "./dimension_generation.js";
import { isDimensionRegionInitialized } from "./dimension_state.js";
import { fillStage2Cell, stage2Cell, stage2NeighborCells } from "./stage2_terrain.js";
import { logger } from "../core/logging.js";

const DIMENSION = "thebrokenscript:stage2";
const pendingCells = new Set();
/** @type {[string, number][]} */
const ROOM_TEMPLATES = [
  ["clanvoidnew1", 200], ["clandimensionroom1", 207],
  ["woodfloor1", 217], ["stone1", 233], ["fieldbase", 252],
];

export function registerStage2Terrain() {
  registerDimensionInitializer(
    DIMENSION,
    ({ dimension, location }) => {
      const cell = stage2Cell(location);
      fillStage2Cell(cell, (from, to, block) => {
        dimension.fillBlocks(new BlockVolume(from, to), block, { ignoreChunkBoundErrors: false });
      });
      // All templates are the source's 16-block-wide cells. Native placement
      // runs inside the already loaded cell and writes the actual room geometry.
      for (const { x, z } of cell.chunks) {
        if (x === 0 || z === 0 || x === 160 || z === 160) continue;
        for (const [name, y] of ROOM_TEMPLATES) {
          world.structureManager.place(`thebrokenscript:stage2_${name}`, dimension, { x, y, z });
        }
      }
    },
    {
      stage: "source_stage2_terrain",
      version: 1,
      regionKey: (location) => stage2Cell(location).key,
      bounds: (location) => stage2Cell(location).bounds,
    },
  );
}

export function beginStage2Terrain(scheduler) {
  pendingCells.clear();
  scheduler.every("tbs.stage2_neighbor_cells", 20, () => {
    const dimension = world.getDimension(DIMENSION);
    for (const player of world.getAllPlayers()) {
      if (player.dimension.id !== DIMENSION) continue;
      for (const cell of stage2NeighborCells(player.location)) {
        if (pendingCells.has(cell.key)
            || isDimensionRegionInitialized(world, DIMENSION, "source_stage2_terrain", cell.key, 1)) continue;
        pendingCells.add(cell.key);
        const target = {
          x: cell.bounds.from.x + 24,
          y: 255,
          z: cell.bounds.from.z + 24,
        };
        void ensureDimensionReady({ world, dimension, dimensionId: DIMENSION, location: target, logger })
          .finally(() => pendingCells.delete(cell.key));
        return; // Limit terrain placement to one new cell per scan tick.
      }
    }
  });
}
