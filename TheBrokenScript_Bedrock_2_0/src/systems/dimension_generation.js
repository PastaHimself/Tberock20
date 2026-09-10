import {
  isCustomDimensionId,
  normalizeDimensionId,
} from "./dimension_ids.js";
import {
  dimensionStatePropertyKey,
  isDimensionRegionInitialized,
  markDimensionRegionInitialized,
  readDimensionRegionState,
} from "./dimension_state.js";

export const SAFE_LANDING_STAGE = "landing";
export const SAFE_LANDING_VERSION = 1;
export const SAFE_LANDING_BLOCK = "minecraft:bedrock";

const inFlight = new Map();
const initializers = new Map();

function finiteCoordinate(value, name) {
  const number = Number(value);
  if (!Number.isFinite(number)) throw new TypeError(`${name} must be finite`);
  return number;
}

export function clampLandingLocation(location, heightRange) {
  const min = Math.ceil(finiteCoordinate(heightRange?.min, "heightRange.min"));
  const max = Math.floor(finiteCoordinate(heightRange?.max, "heightRange.max"));
  if (max - min < 4) throw new RangeError("dimension height range is too small for a safe landing");

  const x = finiteCoordinate(location?.x, "location.x");
  const z = finiteCoordinate(location?.z, "location.z");
  const requestedY = Math.floor(finiteCoordinate(location?.y, "location.y"));
  const minFeetY = min + 1;
  const maxFeetY = max - 2;
  return {
    x,
    y: Math.max(minFeetY, Math.min(maxFeetY, requestedY)),
    z,
  };
}

export function landingRegionKey(location) {
  const x = Math.floor(finiteCoordinate(location?.x, "location.x"));
  const y = Math.floor(finiteCoordinate(location?.y, "location.y"));
  const z = Math.floor(finiteCoordinate(location?.z, "location.z"));
  return `${Math.floor(x / 16)}:${Math.floor(y / 16)}:${Math.floor(z / 16)}`;
}

export function landingAreaBounds(location, radius = 1) {
  const safeRadius = Math.max(0, Math.floor(Number(radius)));
  const x = Math.floor(finiteCoordinate(location?.x, "location.x"));
  const y = Math.floor(finiteCoordinate(location?.y, "location.y"));
  const z = Math.floor(finiteCoordinate(location?.z, "location.z"));
  return {
    from: { x: x - safeRadius, y, z: z - safeRadius },
    to: { x: x + safeRadius, y, z: z + safeRadius },
  };
}

export function registerDimensionInitializer(dimensionId, initializer, options = {}) {
  const normalized = normalizeDimensionId(dimensionId);
  if (!isCustomDimensionId(normalized)) {
    throw new TypeError(`initializer dimension '${String(dimensionId)}' is not a known custom dimension`);
  }
  if (typeof initializer !== "function") throw new TypeError("initializer must be a function");

  const stage = String(options.stage ?? "terrain").trim();
  if (!stage || stage === SAFE_LANDING_STAGE) {
    throw new TypeError(`initializer stage '${stage}' is reserved or invalid`);
  }
  const version = Math.max(1, Math.floor(Number(options.version ?? 1)));
  if (!Number.isFinite(version)) throw new TypeError("initializer version must be finite");

  initializers.set(normalized, {
    initializer,
    stage,
    version,
    regionKey:
      typeof options.regionKey === "function"
        ? options.regionKey
        : (location) => landingRegionKey(location),
    bounds:
      typeof options.bounds === "function"
        ? options.bounds
        : (location) => landingAreaBounds(location, 1),
  });
}

export function unregisterDimensionInitializer(dimensionId) {
  return initializers.delete(normalizeDimensionId(dimensionId));
}

export function inFlightDimensionInitializationCount() {
  return inFlight.size;
}

function isAir(block) {
  return block?.isAir === true || block?.typeId === "minecraft:air";
}

function candidateFeetY(centerY, minY, maxY, radius = 16) {
  const values = [centerY];
  for (let offset = 1; offset <= radius; offset++) {
    if (centerY + offset <= maxY) values.push(centerY + offset);
    if (centerY - offset >= minY) values.push(centerY - offset);
  }
  return values;
}

function blocksAt(dimension, x, y, z) {
  return {
    floor: dimension.getBlock({ x, y: y - 1, z }),
    feet: dimension.getBlock({ x, y, z }),
    head: dimension.getBlock({ x, y: y + 1, z }),
  };
}

function findNaturalLanding(dimension, location, heightRange) {
  const x = Math.floor(location.x);
  const z = Math.floor(location.z);
  const minY = Math.ceil(heightRange.min) + 1;
  const maxY = Math.floor(heightRange.max) - 2;
  for (const y of candidateFeetY(location.y, minY, maxY)) {
    const blocks = blocksAt(dimension, x, y, z);
    if (!isAir(blocks.floor) && isAir(blocks.feet) && isAir(blocks.head)) return y;
  }
  return undefined;
}

function buildFallbackLanding(dimension, location, heightRange) {
  const x = Math.floor(location.x);
  const z = Math.floor(location.z);
  const minY = Math.ceil(heightRange.min) + 1;
  const maxY = Math.floor(heightRange.max) - 2;
  for (const y of candidateFeetY(location.y, minY, maxY)) {
    const { feet, head } = blocksAt(dimension, x, y, z);
    if (!isAir(feet) || !isAir(head)) continue;

    for (let dx = -1; dx <= 1; dx++) {
      for (let dz = -1; dz <= 1; dz++) {
        dimension.setBlockType({ x: x + dx, y: y - 1, z: z + dz }, SAFE_LANDING_BLOCK);
      }
    }
    return y;
  }
  return undefined;
}

function tickingAreaIdentifier(dimensionId, regionKey) {
  const key = dimensionStatePropertyKey(
    dimensionId,
    SAFE_LANDING_STAGE,
    regionKey,
    SAFE_LANDING_VERSION,
  );
  return `tbs_dim_${key.slice("tbs:dim_init_".length)}`;
}

async function withTemporaryTickingArea(worldLike, dimension, dimensionId, regionKey, bounds, action) {
  const manager = worldLike?.tickingAreaManager;
  if (!manager?.createTickingArea || !manager?.removeTickingArea) {
    throw new Error("world.tickingAreaManager is unavailable");
  }

  const identifier = tickingAreaIdentifier(dimensionId, regionKey);
  const options = { dimension, ...bounds };
  let created = false;

  if (typeof manager.hasTickingArea === "function" && manager.hasTickingArea(identifier)) {
    manager.removeTickingArea(identifier);
  }
  if (typeof manager.hasCapacity === "function" && !manager.hasCapacity(options)) {
    throw new Error(`no ticking-area capacity for '${dimensionId}' region '${regionKey}'`);
  }

  try {
    await manager.createTickingArea(identifier, options);
    created = true;
    return await action();
  } finally {
    if (created) {
      try {
        manager.removeTickingArea(identifier);
      } catch {
        // Cleanup failure must not convert a successfully initialized region into
        // an uninitialized one. A later run will reclaim the deterministic ID.
      }
    }
  }
}

function initializerRegionKey(spec, location, dimension) {
  const regionKey = String(spec.regionKey(location, dimension)).trim();
  if (!regionKey) throw new Error("dimension initializer produced an empty region key");
  return regionKey;
}

function initializerIsReady(worldLike, dimensionId, spec, regionKey) {
  return isDimensionRegionInitialized(
    worldLike,
    dimensionId,
    spec.stage,
    regionKey,
    spec.version,
  );
}

async function runRegisteredInitializer(context, spec, regionKey) {
  const { world, dimension, dimensionId, location } = context;
  if (initializerIsReady(world, dimensionId, spec, regionKey)) return false;

  await spec.initializer({
    world,
    dimension,
    dimensionId,
    location,
    regionKey,
  });
  markDimensionRegionInitialized(
    world,
    dimensionId,
    spec.stage,
    regionKey,
    spec.version,
  );
  return true;
}

function persistedLandingLocation(worldLike, dimensionId, regionKey, location) {
  const persisted = readDimensionRegionState(
    worldLike,
    dimensionId,
    SAFE_LANDING_STAGE,
    regionKey,
    SAFE_LANDING_VERSION,
  );
  if (!persisted.initialized) return undefined;

  const persistedY = Number(persisted.data?.y);
  return {
    ...location,
    y: Number.isFinite(persistedY) ? persistedY : location.y,
  };
}

async function initializeLanding(context, regionKey) {
  const { world, dimension, dimensionId, location } = context;
  const spec = initializers.get(dimensionId);
  const initializerKey = spec
    ? initializerRegionKey(spec, location, dimension)
    : undefined;
  const initializerReady =
    !spec || initializerIsReady(world, dimensionId, spec, initializerKey);

  const persistedLocation = persistedLandingLocation(
    world,
    dimensionId,
    regionKey,
    location,
  );
  if (persistedLocation && initializerReady) {
    return { ready: true, location: persistedLocation };
  }

  const bounds = spec
    ? spec.bounds(location, dimension)
    : landingAreaBounds(location, 1);

  return withTemporaryTickingArea(
    world,
    dimension,
    dimensionId,
    regionKey,
    bounds,
    async () => {
      if (spec && !initializerReady) {
        await runRegisteredInitializer(context, spec, initializerKey);
      }

      const range = dimension.heightRange;
      const naturalY = findNaturalLanding(dimension, location, range);
      const landingY =
        naturalY ?? buildFallbackLanding(dimension, location, range);
      if (landingY === undefined) {
        throw new Error(`no safe landing position found for '${dimensionId}'`);
      }

      const readyLocation = { ...location, y: landingY };
      markDimensionRegionInitialized(
        world,
        dimensionId,
        SAFE_LANDING_STAGE,
        regionKey,
        SAFE_LANDING_VERSION,
        { y: landingY },
      );
      return { ready: true, location: readyLocation };
    },
  );
}

export async function ensureDimensionReady({
  world,
  dimension,
  dimensionId,
  location,
  logger,
}) {
  const normalized = normalizeDimensionId(dimensionId);
  if (!normalized || !dimension) {
    logger?.error?.(`dimension generation: invalid destination '${String(dimensionId ?? "")}'`);
    return { ready: false, location };
  }

  if (!isCustomDimensionId(normalized)) {
    return { ready: true, location };
  }

  let target;
  try {
    target = clampLandingLocation(location, dimension.heightRange);
  } catch (error) {
    logger?.error?.(`dimension generation: invalid landing for '${normalized}'`, error);
    return { ready: false, location };
  }

  const regionKey = landingRegionKey(target);
  const spec = initializers.get(normalized);
  const initializerKey = spec
    ? initializerRegionKey(spec, target, dimension)
    : undefined;
  const initializerReady =
    !spec || initializerIsReady(world, normalized, spec, initializerKey);
  const persistedLocation = persistedLandingLocation(
    world,
    normalized,
    regionKey,
    target,
  );
  if (persistedLocation && initializerReady) {
    return { ready: true, location: persistedLocation };
  }

  const flightKey = `${normalized}|${regionKey}`;
  const existing = inFlight.get(flightKey);
  if (existing) return existing;

  const pending = initializeLanding(
    {
      world,
      dimension,
      dimensionId: normalized,
      location: target,
    },
    regionKey,
  )
    .catch((error) => {
      logger?.error?.(
        `dimension generation: failed to initialize '${normalized}' region '${regionKey}'`,
        error,
      );
      return { ready: false, location: target };
    })
    .finally(() => {
      if (inFlight.get(flightKey) === pending) inFlight.delete(flightKey);
    });

  inFlight.set(flightKey, pending);
  return pending;
}
