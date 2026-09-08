import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import {
  CUSTOM_DIMENSION_IDS,
  CUSTOM_REALM_NAMES,
  VANILLA_DIMENSION_IDS,
  displayDimensionId,
  isCustomDimensionId,
  isKnownDimensionId,
  normalizeDimensionId
} from "./dimension_ids.js";

// TBSDimensions.java port — logical realm IDs are registered as Script API custom
// dimensions during StartupEvent and resolved through the same canonical ID model.
export const ALL = [...CUSTOM_REALM_NAMES];
export const NIGHTMARES = ["library", "concrete", "limbo", "nothing"];
export const SUPPORTED = [...VANILLA_DIMENSION_IDS, ...CUSTOM_REALM_NAMES];
export const REGISTERED_CUSTOM_IDS = [...CUSTOM_DIMENSION_IDS];

const handles = new Map();
const warnedUnregistered = new Set();
const registeredCustom = new Set();
let registrationAttempted = false;

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
    logger.error("dimensions: startup DimensionRegistry is unavailable; custom realms cannot be registered");
    return false;
  }

  let ok = true;
  for (const id of CUSTOM_DIMENSION_IDS) {
    try {
      dimensionRegistry.registerCustomDimension(id);
      registeredCustom.add(id);
    } catch (error) {
      ok = false;
      logger.error(`dimensions: failed to register custom dimension '${id}'`, error);
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
    logger.error(`dimensions: cannot resolve invalid dimension identifier '${String(id ?? "")}'`);
    return undefined;
  }

  if (isCustomDimensionId(normalized) && !registeredCustom.has(normalized)) {
    if (!warnedUnregistered.has(normalized)) {
      warnedUnregistered.add(normalized);
      logger.error(`dimensions: custom dimension '${normalized}' was requested before successful startup registration`);
    }
    return undefined;
  }

  if (handles.has(normalized)) {
    const handle = handles.get(normalized);
    try {
      if (handle?.isValid?.() !== false) return handle;
    } catch {
      handles.delete(normalized);
    }
  }

  try {
    const dimension = world.getDimension(normalized);
    handles.set(normalized, dimension);
    return dimension;
  } catch (error) {
    logger.error(`dimensions: cannot resolve dimension '${normalized}'`, error);
    return undefined;
  }
}

/**
 * Teleport only after the requested realm resolves successfully. Callers can use
 * the boolean result to gate progression/follow-up state.
 */
export function teleportTo(entity, dimId, location) {
  const dim = get(dimId);
  if (!dim) return false;

  try {
    entity.teleport(location ?? { x: 0, y: 201, z: 0 }, { dimension: dim });
    return true;
  } catch (error) {
    logger.error(`dimensions: teleport to '${normalizeDimensionId(dimId) || dimId}' failed`, error);
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
