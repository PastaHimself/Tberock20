export const STAGE3_ARENA_VERSION = 1;
export const STAGE3_DIMENSION_ID = "thebrokenscript:void_shadow";
export const STAGE3_SOURCE_MIN_Y = -64;
export const STAGE3_SOURCE_SIZE = Object.freeze({ x: 400, y: 147, z: 404 });
export const STAGE3_EXPECTED_CHUNK_COUNT = 560;
export const STAGE3_STRUCTURE_PREFIX = "thebrokenscript:stage3/phase3_arena_final/chunk_";

const MAX_CHUNK_X = Math.ceil(STAGE3_SOURCE_SIZE.x / 16) - 1;
const MAX_CHUNK_Z = Math.ceil(STAGE3_SOURCE_SIZE.z / 16) - 1;
const ID_PATTERN = /^thebrokenscript:stage3\/phase3_arena_final\/chunk_(\d+)_(\d+)$/;

export function stage3ArenaStructureEntry(id) {
  if (typeof id !== "string") return null;
  const match = ID_PATTERN.exec(id);
  if (!match) return null;
  const chunkX = Number(match[1]);
  const chunkZ = Number(match[2]);
  if (
    !Number.isSafeInteger(chunkX)
    || !Number.isSafeInteger(chunkZ)
    || chunkX < 0
    || chunkZ < 0
    || chunkX > MAX_CHUNK_X
    || chunkZ > MAX_CHUNK_Z
  ) return null;
  return {
    id,
    chunkX,
    chunkZ,
    location: Object.freeze({
      x: chunkX * 16,
      y: STAGE3_SOURCE_MIN_Y,
      z: chunkZ * 16,
    }),
  };
}

export function stage3ArenaStructurePlan(ids) {
  if (!Array.isArray(ids)) throw new TypeError("Stage 3 structure ids must be an array");
  const entries = [];
  const seen = new Set();
  for (const id of ids) {
    if (typeof id !== "string" || !id.startsWith(STAGE3_STRUCTURE_PREFIX)) continue;
    const entry = stage3ArenaStructureEntry(id);
    if (!entry) throw new Error("invalid Stage 3 arena structure id: " + String(id));
    const key = entry.chunkX + "," + entry.chunkZ;
    if (seen.has(key)) throw new Error("duplicate Stage 3 arena chunk: " + key);
    seen.add(key);
    entries.push(entry);
  }
  if (entries.length !== STAGE3_EXPECTED_CHUNK_COUNT) {
    throw new Error(
      "Stage 3 arena structure inventory mismatch: expected "
      + STAGE3_EXPECTED_CHUNK_COUNT
      + ", found "
      + entries.length,
    );
  }
  entries.sort((a, b) => (a.chunkZ - b.chunkZ) || (a.chunkX - b.chunkX));
  return entries;
}
