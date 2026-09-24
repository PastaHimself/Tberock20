import { system, world } from "@minecraft/server";
import * as operationDiagnostics from "../core/operation_diagnostics.js";
import {
  STAGE3_ARENA_VERSION,
  STAGE3_DIMENSION_ID,
  STAGE3_SOURCE_MIN_Y,
  STAGE3_SOURCE_SIZE,
  stage3ArenaStructurePlan,
} from "./stage3_generator_model.js";

const READY_PROPERTY = "tbs:stage3_arena_v1";
let inFlight = null;

function nextTick() {
  return new Promise((resolve) => system.run(() => resolve()));
}

function chunkBounds(entry) {
  return {
    from: {
      x: entry.chunkX * 16,
      y: STAGE3_SOURCE_MIN_Y,
      z: entry.chunkZ * 16,
    },
    to: {
      x: entry.chunkX * 16 + 15,
      y: STAGE3_SOURCE_MIN_Y + STAGE3_SOURCE_SIZE.y - 1,
      z: entry.chunkZ * 16 + 15,
    },
  };
}

async function withChunkLoaded(worldLike, dimension, entry, action) {
  const manager = worldLike?.tickingAreaManager;
  if (!manager?.createTickingArea || !manager?.removeTickingArea) {
    throw new Error("world.tickingAreaManager is unavailable for Stage 3 generation");
  }

  const bounds = chunkBounds(entry);
  const identifier = "tbs_stage3_" + entry.chunkX + "_" + entry.chunkZ;
  const options = { dimension, from: bounds.from, to: bounds.to };

  if (typeof manager.hasTickingArea === "function" && manager.hasTickingArea(identifier)) {
    manager.removeTickingArea(identifier);
  }
  if (typeof manager.hasCapacity === "function" && !manager.hasCapacity(options)) {
    throw new Error("no ticking-area capacity for Stage 3 chunk " + entry.chunkX + "," + entry.chunkZ);
  }

  let created = false;
  try {
    await manager.createTickingArea(identifier, options);
    created = true;
    return await action();
  } finally {
    if (created) {
      try {
        manager.removeTickingArea(identifier);
      } catch (error) {
        operationDiagnostics.warnOnce(
          "stage3_generator.ticking_area_cleanup",
          "Stage 3 generator failed to remove a temporary ticking area",
          error,
        );
      }
    }
  }
}

function ready(worldLike) {
  try {
    return worldLike.getDynamicProperty(READY_PROPERTY) === true;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "stage3_generator.ready_read",
      "Stage 3 generator readiness read failed",
      error,
    );
    return false;
  }
}

function markReady(worldLike) {
  worldLike.setDynamicProperty(READY_PROPERTY, true);
}

function packedStructurePlan(worldLike) {
  const manager = worldLike?.structureManager;
  if (!manager?.getPackStructureIds || !manager?.place) {
    throw new Error("world.structureManager is unavailable for Stage 3 generation");
  }
  return stage3ArenaStructurePlan(manager.getPackStructureIds());
}

export function stage3ArenaReady(worldLike = world) {
  return ready(worldLike);
}

export function stage3GenerationInFlight() {
  return inFlight !== null;
}

export async function ensureStage3Arena(worldLike = world, dimension) {
  if (!dimension || dimension.id !== STAGE3_DIMENSION_ID) {
    throw new TypeError("Stage 3 generation requires the void_shadow dimension");
  }
  if (ready(worldLike)) return { built: false, version: STAGE3_ARENA_VERSION };
  if (inFlight) return inFlight;

  inFlight = (async () => {
    const manager = worldLike.structureManager;
    const plan = packedStructurePlan(worldLike);
    for (const entry of plan) {
      await withChunkLoaded(worldLike, dimension, entry, () => {
        manager.place(
          entry.id,
          dimension,
          entry.location,
          { includeBlocks: true, includeEntities: false },
        );
      });
      // Mirror Java's chunk-local generation and keep native structure placement
      // bounded so loading the source chunks cannot monopolize one script tick.
      await nextTick();
    }
    markReady(worldLike);
    return { built: true, version: STAGE3_ARENA_VERSION, chunks: plan.length };
  })();

  try {
    return await inFlight;
  } finally {
    inFlight = null;
  }
}
