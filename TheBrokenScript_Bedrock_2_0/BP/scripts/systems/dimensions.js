import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";

// TBSDimensions.java port — logical realm IDs retained for callers.
// Current Bedrock behavior packs can only provide overworld, nether and the_end
// dimension data, so unsupported custom realm IDs must not be passed to the engine.
export const ALL = [
  "clan_void", "null_torture", "the_moon", "nowhere", "limbo", "nothing",
  "protected_void", "library", "concrete", "lucid", "stage2", "void_shadow"
];

export const NIGHTMARES = ["library", "concrete", "limbo", "nothing"];
export const SUPPORTED = ["overworld", "nether", "the_end"];

const SUPPORTED_DIMENSIONS = new Set(SUPPORTED);
const handles = new Map();
const warnedUnsupported = new Set();

function normalizeId(id) {
  if (typeof id !== "string") return "";
  const value = id.trim();
  if (value.startsWith("minecraft:")) return value.slice("minecraft:".length);
  if (value.startsWith("thebrokenscript:")) return value.slice("thebrokenscript:".length);
  return value;
}

function logicalId(key) {
  return `thebrokenscript:${key}`;
}

export function isSupported(id) {
  return SUPPORTED_DIMENSIONS.has(normalizeId(id));
}

export function get(id) {
  const key = normalizeId(id);
  if (!key) {
    logger.error("dimensions: cannot resolve an empty dimension identifier");
    return undefined;
  }

  if (!SUPPORTED_DIMENSIONS.has(key)) {
    const requested = logicalId(key);
    if (!warnedUnsupported.has(requested)) {
      warnedUnsupported.add(requested);
      logger.warn(
        `dimensions: '${requested}' is unavailable; Bedrock behavior-pack dimension data only supports overworld, nether and the_end`
      );
    }
    return undefined;
  }

  if (handles.has(key)) {
    const handle = handles.get(key);
    try {
      if (handle?.isValid?.() !== false) return handle;
    } catch {}
  }

  try {
    const dimension = world.getDimension(key);
    handles.set(key, dimension);
    return dimension;
  } catch (error) {
    logger.error(`dimensions: cannot resolve supported dimension '${key}'`, error);
    return undefined;
  }
}

export function teleportTo(entity, dimId, location) {
  const dim = get(dimId);
  if (!dim) return false;

  try {
    entity.teleport(location ?? { x: 0, y: 201, z: 0 }, { dimension: dim });
    return true;
  } catch (err) {
    logger.error(`dimensions: teleport to ${dimId} failed`, err);
    return false;
  }
}

export function randomNightmareId() {
  return NIGHTMARES[Math.floor(Math.random() * NIGHTMARES.length)];
}
