import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";

// ── TBSDimensions.java port — 12 custom dimensions + nightmare set ──────────
export const ALL = [
  "clan_void", "null_torture", "the_moon", "nowhere", "limbo", "nothing",
  "protected_void", "library", "concrete", "lucid", "stage2", "void_shadow"
];
// NIGHTMARES list from source (used for random scare destinations)
export const NIGHTMARES = ["library", "concrete", "limbo", "nothing"];

const handles = new Map();

function fullId(id) {
  return id.startsWith("thebrokenscript:") ? id : `thebrokenscript:${id}`;
}

function tryCreate(id) {
  // beta API: world.createDimension (guarded — static JSON definitions also exist)
  try {
    if (typeof world.createDimension === "function") {
      const d = world.createDimension(fullId(id));
      if (d) { handles.set(id, d); return d; }
    }
  } catch {}
  return undefined;
}

export function get(id) {
  const key = id.replace("thebrokenscript:", "");
  if (handles.has(key)) {
    const h = handles.get(key);
    try { if (h.isValid?.() !== false) return h; } catch {}
  }
  try {
    const d = world.getDimension(fullId(key));
    handles.set(key, d);
    return d;
  } catch {
    return tryCreate(key);
  }
}

export function teleportTo(entity, dimId, location) {
  const dim = get(dimId);
  if (!dim) {
    logger.error(`dimensions: cannot resolve '${dimId}'`);
    return false;
  }
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
