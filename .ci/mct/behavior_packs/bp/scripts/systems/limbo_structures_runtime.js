import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import { ensureDimensionReady, registerDimensionInitializer } from "./dimension_generation.js";
import { isDimensionRegionInitialized } from "./dimension_state.js";
import {
  SIMPLE_DIMENSION_TERRAIN,
  singleLayerCell,
  singleLayerNeighborCells,
} from "./simple_dimension_terrain.js";
import {
  LIMBO_STRUCTURE_LEDGER_PROPERTY,
  LIMBO_STRUCTURE_STAGE,
  LIMBO_STRUCTURE_VERSION,
  applyLimboStructurePlacement,
  limboStructureCell,
  planLimboStructureCell,
  readLimboStructureLedger,
  serializeLimboStructureLedger,
} from "./limbo_structures.js";
import { applyLimboStructureMetadata } from "./limbo_structure_metadata_runtime.js";

const DIMENSION = "thebrokenscript:limbo";
const pendingCells = new Set();

export function registerLimboStructures() {
  registerDimensionInitializer(
    DIMENSION,
    ({ world: worldLike, dimension, location }) => {
      const cell = limboStructureCell(location);
      let ledger = readLimboStructureLedger(
        worldLike.getDynamicProperty(LIMBO_STRUCTURE_LEDGER_PROPERTY),
      );
      for (const placement of planLimboStructureCell(cell, ledger)) {
        worldLike.structureManager.place(
          placement.structureId,
          dimension,
          placement.position,
        );
        applyLimboStructureMetadata(dimension, placement.name, placement.position);
        // Commit after each successful placement. If a later operation fails,
        // the initializer retries without duplicating already committed work.
        ledger = applyLimboStructurePlacement(ledger, placement);
        worldLike.setDynamicProperty(
          LIMBO_STRUCTURE_LEDGER_PROPERTY,
          serializeLimboStructureLedger(ledger),
        );
      }
    },
    {
      stage: LIMBO_STRUCTURE_STAGE,
      version: LIMBO_STRUCTURE_VERSION,
      regionKey: (location) => limboStructureCell(location).key,
      bounds: (location) => limboStructureCell(location).bounds,
    },
  );
}

export function beginLimboStructures(scheduler) {
  pendingCells.clear();
  scheduler.every("tbs.limbo_structures", 20, () => {
    for (const player of world.getAllPlayers()) {
      if (player.dimension.id !== DIMENSION) continue;
      const terrain = SIMPLE_DIMENSION_TERRAIN.limbo;
      const cells = [
        singleLayerCell(player.location, terrain),
        ...singleLayerNeighborCells(player.location, terrain),
      ];
      for (const cell of cells) {
        if (pendingCells.has(cell.key)
            || isDimensionRegionInitialized(
              world,
              DIMENSION,
              LIMBO_STRUCTURE_STAGE,
              cell.key,
              LIMBO_STRUCTURE_VERSION,
            )) continue;
        pendingCells.add(cell.key);
        const target = {
          x: cell.bounds.from.x + 24,
          y: terrain.y + 1,
          z: cell.bounds.from.z + 24,
        };
        void ensureDimensionReady({
          world,
          dimension: player.dimension,
          dimensionId: DIMENSION,
          location: target,
          logger,
        }).finally(() => pendingCells.delete(cell.key));
        return;
      }
    }
  });
}
