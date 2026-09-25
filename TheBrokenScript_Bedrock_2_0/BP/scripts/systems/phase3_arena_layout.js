import { isDimensionRegionInitialized, markDimensionRegionInitialized } from "./dimension_state.js";

const DIMENSION_ID = "thebrokenscript:void_shadow";
const STAGE = "source_xcsf_core";
const OUTER_STAGE = "outer_tentacle_floor";
const VERSION = 1;

export const PHASE3_CORE_TILES = Object.freeze(Array.from({ length: 9 }, (_, i) => {
  const x = Math.floor(i / 3);
  const z = i % 3;
  return Object.freeze({
    id: `thebrokenscript:phase3_core_${x}_${z}`,
    x: 144 + x * 32,
    y: -64,
    z: 160 + z * 32,
  });
}));

export const PHASE3_OUTER_TILES = Object.freeze(Array.from({ length: 81 }, (_, i) => {
  const x = Math.floor(i / 9) - 3;
  const z = i % 9 - 3;
  return Object.freeze({
    id: "thebrokenscript:phase3_outer_platform",
    x: 144 + x * 32,
    y: -60,
    z: 160 + z * 32,
  });
}).filter((tile) => tile.x < 144 || tile.x > 208 || tile.z < 160 || tile.z > 224));

export function placeNextPhase3Tile(worldLike, place) {
  for (const tile of PHASE3_CORE_TILES) {
    if (isDimensionRegionInitialized(worldLike, DIMENSION_ID, STAGE, tile.id, VERSION)) continue;
    place(tile);
    markDimensionRegionInitialized(worldLike, DIMENSION_ID, STAGE, tile.id, VERSION);
    return true;
  }
  return false;
}

export function placeNextOuterTile(worldLike, place) {
  for (const tile of PHASE3_OUTER_TILES) {
    const key = `${tile.x}:${tile.z}`;
    if (isDimensionRegionInitialized(worldLike, DIMENSION_ID, OUTER_STAGE, key, VERSION)) continue;
    place(tile);
    markDimensionRegionInitialized(worldLike, DIMENSION_ID, OUTER_STAGE, key, VERSION);
    return true;
  }
  return false;
}
