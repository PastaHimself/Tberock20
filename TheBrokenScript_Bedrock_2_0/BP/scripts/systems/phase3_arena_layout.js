import { isDimensionRegionInitialized, markDimensionRegionInitialized } from "./dimension_state.js";

const DIMENSION_ID = "thebrokenscript:void_shadow";
const STAGE = "source_xcsf_core";
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

export function placeNextPhase3Tile(worldLike, place) {
  for (const tile of PHASE3_CORE_TILES) {
    if (isDimensionRegionInitialized(worldLike, DIMENSION_ID, STAGE, tile.id, VERSION)) continue;
    place(tile);
    markDimensionRegionInitialized(worldLike, DIMENSION_ID, STAGE, tile.id, VERSION);
    return true;
  }
  return false;
}
