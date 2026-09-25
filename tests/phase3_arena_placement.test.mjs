import assert from "node:assert/strict";
import { readFileSync, existsSync } from "node:fs";
import test from "node:test";
import { PHASE3_CORE_TILES, PHASE3_OUTER_TILES, placeNextPhase3Tile, placeNextOuterTile } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/phase3_arena_layout.js";

test("source XCSF core surrounds the boss spawn and all three preset tentacles", () => {
  assert.equal(PHASE3_CORE_TILES.length, 9);
  assert.deepEqual(PHASE3_CORE_TILES[0], { id: "thebrokenscript:phase3_core_0_0", x: 144, y: -64, z: 160 });
  assert.deepEqual(PHASE3_CORE_TILES.at(-1), { id: "thebrokenscript:phase3_core_2_2", x: 208, y: -64, z: 224 });
  for (const tile of PHASE3_CORE_TILES) {
    const name = tile.id.split(":")[1];
    assert.ok(existsSync(new URL(`../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/${name}.mcstructure`, import.meta.url)));
  }
});

test("phase-three placement is resumable and only persists completed tiles", () => {
  const state = new Map();
  const world = { getDynamicProperty: (key) => state.get(key), setDynamicProperty: (key, value) => state.set(key, value) };
  const placements = [];
  assert.throws(() => placeNextPhase3Tile(world, () => { throw new Error("unavailable"); }), /unavailable/);
  assert.equal(state.size, 0);
  for (let i = 0; i < 9; i++) {
    assert.equal(placeNextPhase3Tile(world, (tile) => placements.push(tile)), true);
  }
  assert.equal(placements.length, 9);
  assert.equal(placeNextPhase3Tile(world, () => { throw new Error("duplicate"); }), false);
});

test("a reusable outer floor spans the boss's 123-block tentacle radius without covering source core tiles", () => {
  assert.equal(PHASE3_OUTER_TILES.length, 72);
  assert.ok(existsSync(new URL("../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/phase3_outer_platform.mcstructure", import.meta.url)));
  for (const tile of PHASE3_OUTER_TILES) {
    assert.equal(tile.id, "thebrokenscript:phase3_outer_platform");
    assert.equal(tile.y, -60);
    assert.ok(tile.x + 31 < 144 || tile.x > 239 || tile.z + 31 < 160 || tile.z > 255);
  }
  for (const point of [{ x: 77, z: 202 }, { x: 323, z: 202 }, { x: 200, z: 79 }, { x: 200, z: 325 }]) {
    assert.ok(PHASE3_OUTER_TILES.some((tile) => tile.x <= point.x && point.x <= tile.x + 31 && tile.z <= point.z && point.z <= tile.z + 31));
  }
  const state = new Map();
  const world = { getDynamicProperty: (key) => state.get(key), setDynamicProperty: (key, value) => state.set(key, value) };
  const placed = [];
  for (let i = 0; i < 72; i++) assert.equal(placeNextOuterTile(world, (tile) => placed.push(tile)), true);
  assert.equal(placeNextOuterTile(world, () => { throw new Error("duplicate"); }), false);
  assert.equal(placed.length, 72);
});

test("phase-three structure placement runs after world load", () => {
  const main = readFileSync(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js", import.meta.url), "utf8");
  assert.match(main, /phase3ArenaLayout\.begin\(scheduler\)/);
});
