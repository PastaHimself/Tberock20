import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import * as operationDiagnostics from "../core/operation_diagnostics.js";
import {
  CUSTOM_DIMENSION_IDS,
  CUSTOM_REALM_NAMES,
  JAVA_REGISTERED_REALM_NAMES,
  VANILLA_DIMENSION_IDS,
  displayDimensionId,
  isCustomDimensionId,
  isKnownDimensionId,
  normalizeDimensionId
} from "./dimension_ids.js";
import { ensureDimensionReady } from "./dimension_generation.js";
import { createDimensionHandleCache } from "./perf_model.js";
import {
  getDimensionEntryLocation as readDimensionEntryLocation,
  getDimensionEntryRotation as readDimensionEntryRotation,
  getDimensionPolicy as readDimensionPolicy,
} from "./dimension_policies.js";

// Java source inventory port — all discovered dimension resources are registered as
// Script API custom dimensions, while ALL preserves TBSDimensions.java semantics.
export const ALL = [...JAVA_REGISTERED_REALM_NAMES];
export const NIGHTMARES = ["library", "concrete", "limbo", "nothing"];
export const SUPPORTED = [...VANILLA_DIMENSION_IDS, ...CUSTOM_REALM_NAMES];
export const REGISTERED_CUSTOM_IDS = [...CUSTOM_DIMENSION_IDS];

const handles = createDimensionHandleCache(
  (name) => world.getDimension(name),
  (error, name) => operationDiagnostics.errorOnce("dimensions.resolve", `dimensions: cannot resolve dimension '${name}'`, error),
);
const warnedUnregistered = new Set();
const registeredCustom = new Set();
let registrationAttempted = false;

// Bedrock's registerCustomDimension currently supplies the void generator
// boundary; the source Java noise_settings/custom ChunkGenerator remains an
// explicit approximation documented in docs/P1_DIMENSION_POLICY.json.

/**
 * Register every logical TBS realm in the only valid registration window.
 * @param {import("@minecraft/server").DimensionRegistry} dimensionRegistry
 */
export function registerCustomDimensions(dimensionRegistry) {
  if (registrationAttempted) {
    return registeredCustom.size === CUSTOM_DIMENSION_IDS.length;
  }
  registrationAttempted = true;

  if (!dimensionRegistry?.registerCustomDimension) {
    operationDiagnostics.errorOnce("dimensions.registry.missing", "dimensions: startup DimensionRegistry is unavailable; custom realms cannot be registered");
    return false;
  }

  let ok = true;
  for (const id of CUSTOM_DIMENSION_IDS) {
    try {
      dimensionRegistry.registerCustomDimension(id);
      registeredCustom.add(id);
    } catch (error) {
      ok = false;
      operationDiagnostics.errorOnce(`dimensions.register.${id}`, `dimensions: failed to register custom dimension '${id}'`, error);
    }
  }

  if (ok) {
    logger.info(`dimensions: registered ${registeredCustom.size} custom realms`);
  }
  return ok;
}

export function isSupported(id) {
  return isKnownDimensionId(id);
}

export function get(id) {
  const normalized = normalizeDimensionId(id);
  if (!normalized) {
    operationDiagnostics.errorOnce("dimensions.invalid_id", `dimensions: cannot resolve invalid dimension identifier '${String(id ?? "")}'`);
    return undefined;
  }

  if (isCustomDimensionId(normalized) && !registeredCustom.has(normalized)) {
    if (!warnedUnregistered.has(normalized)) {
      warnedUnregistered.add(normalized);
      operationDiagnostics.errorOnce("dimensions.unregistered", `dimensions: custom dimension '${normalized}' was requested before successful startup registration`);
    }
    return undefined;
  }

  return handles.get(normalized);
}

export function invalidateDimension(id) {
  const normalized = normalizeDimensionId(id);
  return normalized ? handles.invalidate(normalized) : false;
}

export function resetCache() {
  handles.clear();
}

/**
 * Immediate compatibility path. New custom-dimension entry points should prefer
 * teleportWhenReady so the target region is loaded and has safe footing first.
 */
export function teleportTo(entity, dimId, location) {
  const normalized = normalizeDimensionId(dimId);
  const dim = get(normalized);
  if (!dim) return false;

  try {
    entity.teleport(
      location ?? readDimensionEntryLocation(normalized),
      teleportOptions(normalized, dim),
    );
    return true;
  } catch (error) {
    invalidateDimension(normalized);
    operationDiagnostics.errorOnce("dimensions.teleport", `dimensions: teleport to '${normalized || dimId}' failed`, error);
    return false;
  }
}

/**
 * Resolve the destination, initialize/load custom-dimension landing state, and
 * teleport only after the destination region is ready.
 * @param {import("@minecraft/server").Entity} entity
 * @param {string} dimId
 * @param {import("@minecraft/server").Vector3} [location]
 * @param {{ validateDestination?: (dimension: import("@minecraft/server").Dimension) => boolean }} [options]
 */
export async function teleportWhenReady(entity, dimId, location, { validateDestination } = {}) {
  const normalized = normalizeDimensionId(dimId);
  const dim = get(normalized);
  if (!dim) return false;

  let target = location ?? readDimensionEntryLocation(normalized);
  if (isCustomDimensionId(normalized)) {
    const prepared = await ensureDimensionReady({
      world,
      dimension: dim,
      dimensionId: normalized,
      location: target,
      logger,
    });
    if (!prepared.ready) {
      operationDiagnostics.warnOnce("dimensions.prepare", `dimensions: destination '${normalized || dimId}' was not ready`, prepared.error);
      return false;
    }
    target = prepared.location;
  }

  try {
    if (validateDestination && !validateDestination(dim)) return false;
    entity.teleport(target, teleportOptions(normalized, dim));
    return true;
  } catch (error) {
    invalidateDimension(normalized);
    operationDiagnostics.errorOnce("dimensions.ready_teleport", `dimensions: ready teleport to '${normalized || dimId}' failed`, error);
    return false;
  }
}

export function randomNightmareId() {
  return NIGHTMARES[Math.floor(Math.random() * NIGHTMARES.length)];
}

export function canonicalId(id) {
  return normalizeDimensionId(id);
}

export function displayId(id) {
  return displayDimensionId(id);
}

export function getPolicy(id) {
  return readDimensionPolicy(id);
}

function teleportOptions(normalized, dimension) {
  const options = { dimension };
  const rotation = readDimensionEntryRotation(normalized);
  if (rotation) options.rotation = rotation;
  return options;
}
