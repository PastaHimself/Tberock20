import { world } from "@minecraft/server";
import * as dimensions from "./dimensions.js";
import * as operationDiagnostics from "../core/operation_diagnostics.js";
import { placeNextPhase3Tile } from "./phase3_arena_layout.js";

const INTERVAL = "tbs.phase3_xcsf_core";

export function begin(scheduler) {
  scheduler.every(INTERVAL, 20, () => {
    try {
      const dimension = dimensions.get("thebrokenscript:void_shadow");
      if (!dimension) return;
      const placed = placeNextPhase3Tile(world, (tile) => {
        world.structureManager.place(tile.id, dimension, { x: tile.x, y: tile.y, z: tile.z });
      });
      if (!placed) scheduler.cancelInterval(INTERVAL);
    } catch (error) {
      operationDiagnostics.warnOnce("phase3.xcsf_core", "phase3: source arena tile placement failed; retrying", error);
    }
  });
}
