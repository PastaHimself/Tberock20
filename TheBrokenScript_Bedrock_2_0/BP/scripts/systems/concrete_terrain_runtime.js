import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import { ensureDimensionReady, registerDimensionInitializer } from "./dimension_generation.js";
import { isDimensionRegionInitialized } from "./dimension_state.js";
import {
  CONCRETE_TERRAIN,
  concreteCell,
  concreteCellPlan,
  concreteExplorationCells,
  executeConcreteCellPlan,
} from "./concrete_terrain.js";

const pendingCells = new Set();
const MAX_NEW_CELLS_PER_TICK = 2;
const MAX_IN_FLIGHT_CELLS = 6;

export function registerConcreteTerrain() {
  registerDimensionInitializer(
    CONCRETE_TERRAIN.dimensionId,
    ({ world: worldLike, dimension, location }) => {
      const plan = concreteCellPlan(concreteCell(location));
      executeConcreteCellPlan(plan, (structureId, position) => {
        worldLike.structureManager.place(structureId, dimension, position);
      });
    },
    {
      stage: CONCRETE_TERRAIN.stage,
      version: CONCRETE_TERRAIN.version,
      preferredLandingY: CONCRETE_TERRAIN.preferredLandingY,
      regionKey: (location) => concreteCell(location).key,
      bounds: (location) => concreteCell(location).bounds,
    },
  );
}

export function beginConcreteTerrain(scheduler) {
  pendingCells.clear();
  scheduler.every("tbs.concrete_terrain", 1, () => {
    const players = world.getAllPlayers().filter(
      (player) => player.dimension.id === CONCRETE_TERRAIN.dimensionId,
    );
    if (players.length === 0) return;

    const cells = concreteExplorationCells(players.map((player) => player.location));
    let started = 0;
    for (const cell of cells) {
      if (started >= MAX_NEW_CELLS_PER_TICK || pendingCells.size >= MAX_IN_FLIGHT_CELLS) break;
      if (pendingCells.has(cell.key)
          || isDimensionRegionInitialized(
            world,
            CONCRETE_TERRAIN.dimensionId,
            CONCRETE_TERRAIN.stage,
            cell.key,
            CONCRETE_TERRAIN.version,
          )) continue;
      pendingCells.add(cell.key);
      started++;
      const target = {
        x: cell.bounds.from.x,
        y: CONCRETE_TERRAIN.preferredLandingY,
        z: cell.bounds.from.z + 8,
      };
      void ensureDimensionReady({
        world,
        dimension: players[0].dimension,
        dimensionId: CONCRETE_TERRAIN.dimensionId,
        location: target,
        logger,
      }).finally(() => pendingCells.delete(cell.key));
    }
  });
}
