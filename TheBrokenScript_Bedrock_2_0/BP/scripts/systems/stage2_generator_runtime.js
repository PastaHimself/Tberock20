import {
  BlockVolume,
  ListBlockVolume,
  system,
  world,
} from "@minecraft/server";
import * as operationDiagnostics from "../core/operation_diagnostics.js";
import {
  STAGE2_BORDER_MAX_Y,
  STAGE2_CHUNK_MAX,
  STAGE2_CHUNK_MIN,
  STAGE2_CORE_VERSION,
  STAGE2_DIMENSION_ID,
  STAGE2_MIN_BUILD_Y,
  stage2CoreChunkBounds,
  stage2CoreChunkRegion,
  stage2CorePlanePlan,
  stage2NowhereLayerLocations,
} from "./stage2_generator_model.js";

const READY_PROPERTY = "tbs:stage2_core_v" + STAGE2_CORE_VERSION;
const OUTER_WALL_BLOCK = "thebrokenscript:r_3";
const BORDER_BLOCK = "minecraft:barrier";
const AIR_ONLY = Object.freeze({
  blockFilter: Object.freeze({ includeTypes: Object.freeze(["minecraft:air"]) }),
});
let inFlight = null;

function nextTick() {
  return new Promise((resolve) => system.run(resolve));
}

function stage2Seed(worldLike) {
  const value = worldLike?.seed;
  if (typeof value === "string" && /^-?\d+$/.test(value.trim())) return BigInt(value.trim());
  if (typeof value === "number" && Number.isSafeInteger(value)) return BigInt(value);
  throw new Error("Stage 2 generator could not read the numeric world seed");
}

function fillPlane(dimension, minX, maxX, minZ, maxZ, y, blockId) {
  dimension.fillBlocks(
    new BlockVolume({ x: minX, y, z: minZ }, { x: maxX, y, z: maxZ }),
    blockId,
  );
}

function fillColumnWall(dimension, from, to, blockId) {
  dimension.fillBlocks(new BlockVolume(from, to), blockId);
}

function buildBorderChunk(dimension, chunkX, chunkZ) {
  const bounds = stage2CoreChunkBounds(chunkX, chunkZ);
  const minX = bounds.from.x;
  const maxX = bounds.to.x;
  const minZ = bounds.from.z;
  const maxZ = bounds.to.z;

  // CFR loses the assignment to wallMaterial, but the bytecode-shaped source
  // immediately evaluates TBSBlocks.R_3.defaultBlockState() before each border
  // write. R_3 is therefore the only source-backed outer wall material.
  if (chunkX === STAGE2_CHUNK_MIN || chunkX === STAGE2_CHUNK_MAX) {
    fillColumnWall(
      dimension,
      { x: minX, y: STAGE2_MIN_BUILD_Y, z: minZ },
      { x: minX, y: STAGE2_BORDER_MAX_Y, z: maxZ },
      OUTER_WALL_BLOCK,
    );
    fillColumnWall(
      dimension,
      { x: minX + 1, y: STAGE2_MIN_BUILD_Y, z: minZ },
      { x: minX + 1, y: STAGE2_BORDER_MAX_Y, z: maxZ },
      BORDER_BLOCK,
    );
    fillColumnWall(
      dimension,
      { x: maxX, y: STAGE2_MIN_BUILD_Y, z: minZ },
      { x: maxX, y: STAGE2_BORDER_MAX_Y, z: maxZ },
      OUTER_WALL_BLOCK,
    );
    fillColumnWall(
      dimension,
      { x: maxX - 1, y: STAGE2_MIN_BUILD_Y, z: minZ },
      { x: maxX - 1, y: STAGE2_BORDER_MAX_Y, z: maxZ },
      BORDER_BLOCK,
    );
  }

  if (chunkZ === STAGE2_CHUNK_MIN || chunkZ === STAGE2_CHUNK_MAX) {
    fillColumnWall(
      dimension,
      { x: minX, y: STAGE2_MIN_BUILD_Y, z: minZ },
      { x: maxX, y: STAGE2_BORDER_MAX_Y, z: minZ },
      OUTER_WALL_BLOCK,
    );
    fillColumnWall(
      dimension,
      { x: minX, y: STAGE2_MIN_BUILD_Y, z: minZ + 1 },
      { x: maxX, y: STAGE2_BORDER_MAX_Y, z: minZ + 1 },
      BORDER_BLOCK,
    );
    fillColumnWall(
      dimension,
      { x: minX, y: STAGE2_MIN_BUILD_Y, z: maxZ },
      { x: maxX, y: STAGE2_BORDER_MAX_Y, z: maxZ },
      OUTER_WALL_BLOCK,
    );
    fillColumnWall(
      dimension,
      { x: minX, y: STAGE2_MIN_BUILD_Y, z: maxZ - 1 },
      { x: maxX, y: STAGE2_BORDER_MAX_Y, z: maxZ - 1 },
      BORDER_BLOCK,
    );
  }
}

function buildInteriorChunk(dimension, worldSeed, chunkX, chunkZ) {
  const bounds = stage2CoreChunkBounds(chunkX, chunkZ);
  const plan = stage2CorePlanePlan(chunkX, chunkZ);

  for (const plane of plan.planes) {
    fillPlane(
      dimension,
      bounds.from.x,
      bounds.to.x,
      bounds.from.z,
      bounds.to.z,
      plane.y,
      plane.blockId,
    );
  }

  const nowhere = stage2NowhereLayerLocations(worldSeed, chunkX, chunkZ);
  if (nowhere.mud.length > 0) {
    dimension.fillBlocks(new ListBlockVolume(nowhere.mud), "minecraft:mud", AIR_ONLY);
  }
  if (nowhere.barrier.length > 0) {
    dimension.fillBlocks(new ListBlockVolume(nowhere.barrier), "minecraft:barrier", AIR_ONLY);
  }
}

function buildChunk(dimension, worldSeed, chunkX, chunkZ) {
  const plan = stage2CorePlanePlan(chunkX, chunkZ);
  if (!plan) return;

  if (plan.region === "interior") {
    buildInteriorChunk(dimension, worldSeed, chunkX, chunkZ);
  } else {
    // buildSurface calls genBorders instead of interior floors for border chunks.
    buildBorderChunk(dimension, chunkX, chunkZ);
    const bounds = stage2CoreChunkBounds(chunkX, chunkZ);
    fillPlane(
      dimension,
      bounds.from.x,
      bounds.to.x,
      bounds.from.z,
      bounds.to.z,
      271,
      "minecraft:barrier",
    );
  }
}

async function withChunkLoaded(worldLike, dimension, chunkX, chunkZ, action) {
  const manager = worldLike?.tickingAreaManager;
  if (!manager?.createTickingArea || !manager?.removeTickingArea) {
    throw new Error("world.tickingAreaManager is unavailable for Stage 2 generation");
  }

  const bounds = stage2CoreChunkBounds(chunkX, chunkZ);
  const identifier = "tbs_stage2_" + chunkX + "_" + chunkZ;
  const options = { dimension, from: bounds.from, to: bounds.to };

  if (typeof manager.hasTickingArea === "function" && manager.hasTickingArea(identifier)) {
    manager.removeTickingArea(identifier);
  }
  if (typeof manager.hasCapacity === "function" && !manager.hasCapacity(options)) {
    throw new Error("no ticking-area capacity for Stage 2 chunk " + chunkX + "," + chunkZ);
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
          "stage2_generator.ticking_area_cleanup",
          "Stage 2 generator failed to remove a temporary ticking area",
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
      "stage2_generator.ready_read",
      "Stage 2 generator readiness read failed",
      error,
    );
    return false;
  }
}

function markReady(worldLike) {
  worldLike.setDynamicProperty(READY_PROPERTY, true);
}

export function stage2ArenaCoreReady(worldLike = world) {
  return ready(worldLike);
}

export function stage2GenerationInFlight() {
  return inFlight !== null;
}

export async function ensureStage2ArenaCore(worldLike = world, dimension) {
  if (!dimension || dimension.id !== STAGE2_DIMENSION_ID) {
    throw new TypeError("Stage 2 generation requires the stage2 dimension");
  }
  if (ready(worldLike)) return { built: false, version: STAGE2_CORE_VERSION };
  if (inFlight) return inFlight;

  inFlight = (async () => {
    const seed = stage2Seed(worldLike);
    for (let chunkZ = STAGE2_CHUNK_MIN; chunkZ <= STAGE2_CHUNK_MAX; chunkZ += 1) {
      for (let chunkX = STAGE2_CHUNK_MIN; chunkX <= STAGE2_CHUNK_MAX; chunkX += 1) {
        await withChunkLoaded(worldLike, dimension, chunkX, chunkZ, () => {
          buildChunk(dimension, seed, chunkX, chunkZ);
        });
        // Bound work to one source chunk per tick to avoid watchdog spikes.
        await nextTick();
      }
    }
    markReady(worldLike);
    return { built: true, version: STAGE2_CORE_VERSION };
  })();

  try {
    return await inFlight;
  } finally {
    inFlight = null;
  }
}
