import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";

// TBSDimensions.java port — 12 custom dimensions + nightmare set.
// Dimension definitions are static pack content; stable Script API resolves them
// through world.getDimension(). Preview-only dynamic-dimension creation is not used.
export const ALL = [
  "clan_void", "null_torture", "the_moon", "nowhere", "limbo", "nothing",
  "protected_void", "library", "concrete", "lucid", "stage2", "void_shadow"
];

export const NIGHTMARES = ["library", "concrete", "limbo", "nothing"];

const handles = new Map();

function fullId(id) {
  return id.startsWith("thebrokenscript:") ? id : `thebrokenscript:${id}`;
}

export function get(id) {
  const key = id.replace("thebrokenscript:", "");
  if (handles.has(key)) {
    const handle = handles.get(key);
    try {
      if (handle?.isValid?.() !== false) return handle;
    } catch {}
  }

  try {
    const dimension = world.getDimension(fullId(key));
    handles.set(key, dimension);
    return dimension;
  } catch (error) {
    logger.error(`dimensions: cannot resolve '${key}' from static dimension definitions`, error);
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
