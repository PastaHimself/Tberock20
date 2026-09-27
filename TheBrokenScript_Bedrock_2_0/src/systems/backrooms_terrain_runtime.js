import { BlockVolume, world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import { ensureDimensionReady, registerDimensionInitializer } from "./dimension_generation.js";
import { isDimensionRegionInitialized } from "./dimension_state.js";
import {
  BACKROOMS_LEVEL_ZERO,
  backroomsCell,
  backroomsCellPlan,
  backroomsNeighborCells,
  executeBackroomsCellPlan,
} from "./backrooms_terrain.js";

const pendingCells = new Set();

function fillVolume(dimension, volume) {
  dimension.fillBlocks(
    new BlockVolume(volume.from, volume.to),
    volume.block,
    { ignoreChunkBoundErrors: false },
  );
}

export function applyBackroomsCellPlan(dimension, plan) {
  executeBackroomsCellPlan(plan, {
    fill: (volume) => fillVolume(dimension, volume),
    set: ({ block, ...location }) => dimension.setBlockType(location, block),
  });
}

export function registerBackroomsTerrain() {
  registerDimensionInitializer(
    BACKROOMS_LEVEL_ZERO.dimensionId,
    ({ world: worldLike, dimension, location }) => {
      const cell = backroomsCell(location);
      applyBackroomsCellPlan(dimension, backroomsCellPlan(cell, worldLike.seed));
    },
    {
      stage: BACKROOMS_LEVEL_ZERO.stage,
      version: BACKROOMS_LEVEL_ZERO.version,
      preferredLandingY: BACKROOMS_LEVEL_ZERO.floorY + 1,
      regionKey: (location) => backroomsCell(location).key,
      bounds: (location) => backroomsCell(location).bounds,
    },
  );
}

export function beginBackroomsTerrain(scheduler) {
  pendingCells.clear();
  scheduler.every("tbs.backrooms_terrain", 20, () => {
    for (const player of world.getAllPlayers()) {
      if (player.dimension.id !== BACKROOMS_LEVEL_ZERO.dimensionId) continue;
      const cells = [backroomsCell(player.location), ...backroomsNeighborCells(player.location)];
      for (const cell of cells) {
        if (pendingCells.has(cell.key)
            || isDimensionRegionInitialized(
              world,
              BACKROOMS_LEVEL_ZERO.dimensionId,
              BACKROOMS_LEVEL_ZERO.stage,
              cell.key,
              BACKROOMS_LEVEL_ZERO.version,
            )) continue;
        pendingCells.add(cell.key);
        const target = {
          x: cell.bounds.from.x + 24,
          y: BACKROOMS_LEVEL_ZERO.floorY + 1,
          z: cell.bounds.from.z + 24,
        };
        void ensureDimensionReady({
          world,
          dimension: player.dimension,
          dimensionId: BACKROOMS_LEVEL_ZERO.dimensionId,
          location: target,
          logger,
        }).finally(() => pendingCells.delete(cell.key));
        return;
      }
    }
  });
}
