import assert from "node:assert/strict";
import { readFileSync, existsSync } from "node:fs";
import test from "node:test";
import { stage2Cell, stage2ChunkLayers, fillStage2Cell, stage2NeighborCells, stage2ChunkWalls } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/stage2_terrain.js";

test("Stage 2 entrance generates a bounded, persistent three-chunk cell", () => {
  const cell = stage2Cell({ x: 85, y: 255, z: 85 });
  assert.equal(cell.key, "1:1");
  assert.deepEqual(cell.bounds, { from: { x: 48, y: -64, z: 48 }, to: { x: 95, y: 271, z: 95 } });
  assert.equal(cell.chunks.length, 9);
  assert.deepEqual(stage2Cell({ x: 96, z: 85 }).chunks[0], { x: 96, z: 48 });
});

test("Stage 2 reproduces source floor and barrier elevations and a playable surface", () => {
  const layers = stage2ChunkLayers(80, 80);
  assert.deepEqual(layers.filter((layer) => layer.block === "minecraft:barrier").map((layer) => layer.y), [198, 159, 251, 232, 216, 206, 102, 271]);
  assert.deepEqual(layers.filter((layer) => layer.y === 199 || layer.y === 160), [
    { y: 199, block: "thebrokenscript:cobblestone_border_block" },
    { y: 160, block: "minecraft:bedrock" },
  ]);
  assert.deepEqual(layers.filter((layer) => layer.y === 252 || layer.y === 253), [
    { y: 252, block: "minecraft:bedrock" },
    { y: 253, block: "minecraft:grass_block" },
  ]);
  assert.deepEqual(stage2ChunkLayers(0, 80), [{ y: 271, block: "minecraft:barrier" }]);
  assert.deepEqual(stage2ChunkWalls(160, 80), [
    { from: { x: 161, y: -64, z: 80 }, to: { x: 161, y: 270, z: 95 }, block: "minecraft:barrier" },
    { from: { x: 174, y: -64, z: 80 }, to: { x: 174, y: 270, z: 95 }, block: "minecraft:barrier" },
  ]);
  assert.deepEqual(stage2ChunkLayers(176, 80), []);
});

test("Stage 2 placement fills complete chunks and does not mark failed cells", () => {
  const calls = [];
  const cell = stage2Cell({ x: 85, z: 85 });
  fillStage2Cell(cell, (from, to, block) => calls.push({ from, to, block }));
  assert.equal(calls.length, cell.chunks.length * stage2ChunkLayers(80, 80).length);
  assert.deepEqual(calls.find((call) => call.block === "minecraft:grass_block"), {
    from: { x: 48, y: 253, z: 48 }, to: { x: 63, y: 253, z: 63 }, block: "minecraft:grass_block",
  });
  assert.throws(() => fillStage2Cell(cell, () => { throw new Error("unloaded"); }), /unloaded/);
});

test("Stage 2 expands into neighboring cells before players reach an edge", () => {
  assert.deepEqual(stage2NeighborCells({ x: 85, z: 85 }).map((cell) => cell.key), ["2:1", "1:2"]);
  assert.deepEqual(stage2NeighborCells({ x: 72, z: 72 }), []);
  assert.deepEqual(stage2NeighborCells({ x: 150, z: 85 }).map((cell) => cell.key), ["2:1", "3:2"]);
});

test("Stage 2 initializer is registered before any world-load routing starts", () => {
  const root = "TheBrokenScript_Bedrock_2_0/BP/scripts";
  const main = readFileSync(new URL(`../${root}/main.js`, import.meta.url), "utf8");
  assert.match(main, /registerStage2Terrain\(\)/);
  assert.match(main, /beginStage2Terrain\(scheduler\)/);
  assert.ok(main.indexOf("registerStage2Terrain()") < main.indexOf("portedFeatures.begin(scheduler)"));
  const runtime = readFileSync(new URL(`../${root}/systems/stage2_terrain_runtime.js`, import.meta.url), "utf8");
  assert.match(runtime, /world\.structureManager\.place/);
  for (const name of ["clanvoidnew1", "clandimensionroom1", "woodfloor1", "stone1", "fieldbase"]) {
    assert.ok(existsSync(new URL(`../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2_${name}.mcstructure`, import.meta.url)));
  }
});
