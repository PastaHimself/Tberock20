import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import { ensureDimensionReady, registerDimensionInitializer } from "./dimension_generation.js";
import { isDimensionRegionInitialized } from "./dimension_state.js";
import {
  LIBRARY_TERRAIN,
  executeLibraryCellPlan,
  libraryCell,
  libraryCellPlan,
  libraryExplorationCells,
} from "./library_terrain.js";

const pendingCells = new Set();
const MAX_NEW_CELLS_PER_TICK = 2;
const MAX_IN_FLIGHT_CELLS = 8;

export function registerLibraryTerrain() {
  registerDimensionInitializer(
    LIBRARY_TERRAIN.dimensionId,
    ({ world: worldLike, dimension, location }) => {
      const plan = libraryCellPlan(libraryCell(location));
      executeLibraryCellPlan(plan, (structureId, position) => {
        worldLike.structureManager.place(structureId, dimension, position);
      });
    },
    {
      stage: LIBRARY_TERRAIN.stage,
      version: LIBRARY_TERRAIN.version,
      preferredLandingY: LIBRARY_TERRAIN.preferredLandingY,
      regionKey: (location) => libraryCell(location).key,
      bounds: (location) => libraryCell(location).bounds,
    },
  );
}

export function beginLibraryTerrain(scheduler) {
  pendingCells.clear();
  scheduler.every("tbs.library_terrain", 1, () => {
    const players = world.getAllPlayers().filter(
      (player) => player.dimension.id === LIBRARY_TERRAIN.dimensionId,
    );
    if (players.length === 0) return;

    const cells = libraryExplorationCells(players.map((player) => player.location));
    let started = 0;
    for (const cell of cells) {
      if (started >= MAX_NEW_CELLS_PER_TICK || pendingCells.size >= MAX_IN_FLIGHT_CELLS) break;
      if (pendingCells.has(cell.key)
          || isDimensionRegionInitialized(
            world,
            LIBRARY_TERRAIN.dimensionId,
            LIBRARY_TERRAIN.stage,
            cell.key,
            LIBRARY_TERRAIN.version,
          )) continue;
      pendingCells.add(cell.key);
      started++;
      const target = {
        x: cell.bounds.from.x + 8,
        y: LIBRARY_TERRAIN.preferredLandingY,
        z: cell.bounds.from.z + 8,
      };
      void ensureDimensionReady({
        world,
        dimension: players[0].dimension,
        dimensionId: LIBRARY_TERRAIN.dimensionId,
        location: target,
        logger,
      }).finally(() => pendingCells.delete(cell.key));
    }
  });
}
