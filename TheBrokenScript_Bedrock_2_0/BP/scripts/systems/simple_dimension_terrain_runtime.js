import { BlockVolume, world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import { ensureDimensionReady, registerDimensionInitializer } from "./dimension_generation.js";
import { isDimensionRegionInitialized } from "./dimension_state.js";
import {
  SIMPLE_DIMENSION_TERRAIN,
  fillSingleLayerCell,
  singleLayerCell,
  singleLayerNeighborCells,
} from "./simple_dimension_terrain.js";

const pendingCells = new Set();
/** @type {Map<string, (typeof SIMPLE_DIMENSION_TERRAIN)[keyof typeof SIMPLE_DIMENSION_TERRAIN]>} */
const specsByDimension = new Map(
  Object.values(SIMPLE_DIMENSION_TERRAIN).map((spec) => [spec.dimensionId, spec]),
);

export function registerSimpleDimensionTerrain() {
  for (const spec of specsByDimension.values()) {
    registerDimensionInitializer(
      spec.dimensionId,
      ({ dimension, location }) => {
        const cell = singleLayerCell(location, spec);
        fillSingleLayerCell(cell, spec, (from, to, block) => {
          dimension.fillBlocks(
            new BlockVolume(from, to),
            block,
            { ignoreChunkBoundErrors: false },
          );
        });
      },
      {
        stage: spec.stage,
        version: spec.version,
        preferredLandingY: spec.y + 1,
        regionKey: (location) => singleLayerCell(location, spec).key,
        bounds: (location) => singleLayerCell(location, spec).bounds,
      },
    );
  }
}

export function beginSimpleDimensionTerrain(scheduler) {
  pendingCells.clear();
  scheduler.every("tbs.simple_dimension_terrain", 20, () => {
    for (const player of world.getAllPlayers()) {
      const spec = specsByDimension.get(player.dimension.id);
      if (!spec) continue;
      const cells = [singleLayerCell(player.location, spec), ...singleLayerNeighborCells(player.location, spec)];
      for (const cell of cells) {
        const pendingKey = `${spec.dimensionId}|${cell.key}`;
        if (pendingCells.has(pendingKey)
            || isDimensionRegionInitialized(world, spec.dimensionId, spec.stage, cell.key, spec.version)) continue;
        pendingCells.add(pendingKey);
        const target = {
          x: cell.bounds.from.x + 24,
          y: spec.y + 1,
          z: cell.bounds.from.z + 24,
        };
        void ensureDimensionReady({
          world,
          dimension: player.dimension,
          dimensionId: spec.dimensionId,
          location: target,
          logger,
        }).finally(() => pendingCells.delete(pendingKey));
        return;
      }
    }
  });
}
