import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import test from "node:test";
import {
  SIMPLE_DIMENSION_TERRAIN,
  fillSingleLayerCell,
  singleLayerCell,
  singleLayerNeighborCells,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/simple_dimension_terrain.js";

test("Nothing terrain preserves the Java single-layer generator contract", () => {
  const java = readFileSync(new URL("../decompiled/net/thebrokenscript/world/dimension/nothing/NothingGenerator.java", import.meta.url), "utf8");
  assert.match(java, /TBSBlocks\.NOTHING\.getDefaultState\(\)/);
  assert.deepEqual(SIMPLE_DIMENSION_TERRAIN.nothing, {
    dimensionId: "thebrokenscript:nothing", stage: "source_nothing_terrain", version: 1,
    block: "thebrokenscript:nothing", y: 0, minY: -64, maxY: 255,
  });
});

test("Limbo terrain preserves its Java single-layer base independently of structures", () => {
  const java = readFileSync(new URL("../decompiled/net/thebrokenscript/world/dimension/limbo/LimboGenerator.java", import.meta.url), "utf8");
  assert.match(java, /TBSBlocks\.LIMBO\.getDefaultState\(\)/);
  assert.deepEqual(SIMPLE_DIMENSION_TERRAIN.limbo, {
    dimensionId: "thebrokenscript:limbo", stage: "source_limbo_terrain", version: 1,
    block: "thebrokenscript:limbo", y: 0, minY: -64, maxY: 255,
  });
});

test("single-layer terrain initializes a bounded three-chunk cell", () => {
  const spec = SIMPLE_DIMENSION_TERRAIN.nothing;
  const cell = singleLayerCell({ x: -1, z: 16 }, spec);
  assert.deepEqual(cell, {
    key: "-1:0",
    bounds: { from: { x: -48, y: -64, z: 0 }, to: { x: -1, y: 255, z: 47 } },
  });
  const calls = [];
  fillSingleLayerCell(cell, spec, (from, to, block) => calls.push({ from, to, block }));
  assert.deepEqual(calls, [{
    from: { x: -48, y: 0, z: 0 }, to: { x: -1, y: 0, z: 47 },
    block: "thebrokenscript:nothing",
  }]);
});

test("single-layer terrain pre-generates neighboring cells near an edge", () => {
  const spec = SIMPLE_DIMENSION_TERRAIN.nothing;
  assert.deepEqual(singleLayerNeighborCells({ x: 36, z: 24 }, spec).map((cell) => cell.key), ["1:0"]);
  assert.deepEqual(
    singleLayerNeighborCells({ x: 47, z: 47 }, spec).map((cell) => cell.key),
    ["1:0", "0:1", "1:1"],
  );
  assert.deepEqual(singleLayerNeighborCells({ x: 24, z: 24 }, spec), []);
});

test("Nothing terrain is registered before world routing and expanded after load", () => {
  const main = readFileSync(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js", import.meta.url), "utf8");
  assert.match(main, /registerSimpleDimensionTerrain\(\)/);
  assert.match(main, /beginSimpleDimensionTerrain\(scheduler\)/);
  assert.ok(main.indexOf("registerSimpleDimensionTerrain()") < main.indexOf("portedFeatures.begin(scheduler)"));
});
