import assert from "node:assert/strict";
import { existsSync, readFileSync } from "node:fs";
import test from "node:test";

import {
  BACKROOMS_LEVEL_ZERO,
  backroomsCell,
  backroomsCellPlan,
  backroomsChunkPlan,
  backroomsNeighborCells,
  classifyBackroomsChunk,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/backrooms_terrain.js";
import * as backroomsTerrain from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/backrooms_terrain.js";

test("Backrooms Level 0 has a dedicated pure terrain model", () => {
  assert.equal(
    existsSync(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/backrooms_terrain.js", import.meta.url)),
    true,
  );
});

test("Backrooms Level 0 constants preserve the Java source layers, blocks, and thresholds", () => {
  const source = readFileSync(
    new URL("../decompiled/net/thebrokenscript/world/dimension/backrooms/BackroomsLevelZero.java", import.meta.url),
    "utf8",
  );

  assert.match(source, /this\.endLevel = 9/);
  assert.match(source, /RedRoomNoise, 0\.3/);
  assert.match(source, /UnlitRoomNoise, 0\.15/);
  assert.match(source, /EmptyAreaNoise, 0\.2/);
  assert.deepEqual(BACKROOMS_LEVEL_ZERO, {
    dimensionId: "thebrokenscript:backrooms",
    stage: "source_backrooms_level_zero",
    version: 1,
    chunkSize: 16,
    cellSizeChunks: 3,
    minY: 0,
    maxY: 511,
    bedrockY: 0,
    floorY: 1,
    ceilingY: 9,
    thresholds: { redRoom: 0.3, unlitRoom: 0.15, emptyArea: 0.2 },
    blocks: {
      base: "minecraft:bedrock",
      normal: {
        floor: "thebrokenscript:moist_carpet",
        ceiling: "thebrokenscript:ceiling_tile",
        wall: "thebrokenscript:ugly_wallpaper",
        light: "thebrokenscript:ceiling_light",
      },
      red: {
        floor: "thebrokenscript:red_moist_carpet",
        ceiling: "thebrokenscript:red_ceiling_tile",
        wall: "thebrokenscript:red_ugly_wallpaper",
        light: "thebrokenscript:red_ceiling_light",
      },
    },
  });
});

test("Backrooms threshold boundaries retain the Java greater-than semantics", () => {
  assert.deepEqual(
    classifyBackroomsChunk({ redRoom: 0.3, unlitRoom: 0.15, emptyArea: 0.2 }),
    { red: false, lit: true, walls: true },
  );
  assert.deepEqual(
    classifyBackroomsChunk({ redRoom: 0.300001, unlitRoom: 0.150001, emptyArea: 0.200001 }),
    { red: true, lit: false, walls: false },
  );
});

test("Backrooms noise fields retain the three Java octave sets", () => {
  assert.deepEqual(backroomsTerrain.BACKROOMS_NOISE_FIELDS, {
    unlitRoom: { salt: "unlit", octaves: [1, 5, 9] },
    emptyArea: { salt: "empty", octaves: [2, 1, 9] },
    redRoom: { salt: "red", octaves: [0, 4, 2] },
  });
});

test("Backrooms octave sets are order-independent and include octave zero", () => {
  assert.equal(typeof backroomsTerrain.sampleBackroomsNoiseField, "function");
  const field = { salt: "octave-set-test", octaves: [0, 4, 2] };
  assert.equal(
    backroomsTerrain.sampleBackroomsNoiseField("set-seed", field, 3, 7),
    backroomsTerrain.sampleBackroomsNoiseField(
      "set-seed",
      { ...field, octaves: [2, 0, 4] },
      3,
      7,
    ),
  );

  const octaveZeroSamples = [];
  for (let chunkX = 1; chunkX <= 8; chunkX++) {
    octaveZeroSamples.push(
      backroomsTerrain.sampleBackroomsNoiseField(
        "set-seed",
        { salt: "octave-zero-test", octaves: [0] },
        chunkX,
        chunkX + 2,
      ),
    );
  }
  assert.ok(octaveZeroSamples.some((sample) => Math.abs(sample) > Number.EPSILON));
});

test("Backrooms ceiling fixtures preserve the Java light level", () => {
  for (const name of ["ceiling_light", "red_ceiling_light"]) {
    const block = JSON.parse(readFileSync(
      new URL(`../TheBrokenScript_Bedrock_2_0/BP/blocks/${name}.json`, import.meta.url),
      "utf8",
    ))["minecraft:block"];
    assert.equal(block.components["minecraft:light_emission"], 15, name);
  }
});

test("Backrooms cells are three chunks wide and stable across negative coordinates", () => {
  assert.deepEqual(backroomsCell({ x: 0, z: 0 }), {
    key: "0:0",
    chunk: { x: 0, z: 0 },
    bounds: {
      from: { x: 0, y: 0, z: 0 },
      to: { x: 47, y: 511, z: 47 },
    },
  });
  assert.deepEqual(backroomsCell({ x: -0.01, z: -48 }), {
    key: "-1:-1",
    chunk: { x: -3, z: -3 },
    bounds: {
      from: { x: -48, y: 0, z: -48 },
      to: { x: -1, y: 511, z: -1 },
    },
  });
  assert.deepEqual(
    backroomsNeighborCells({ x: 47, z: 47 }).map((cell) => cell.key),
    ["1:0", "0:1", "1:1"],
  );
});

test("Backrooms chunk plans are deterministic per world seed and source chunk", () => {
  const first = backroomsChunkPlan(-12, 31, "8675309");
  assert.deepEqual(first, backroomsChunkPlan(-12, 31, "8675309"));
  assert.notDeepEqual(first.samples, backroomsChunkPlan(-12, 31, "8675310").samples);
  assert.deepEqual(first.origin, { x: -192, z: 496 });
});

test("lit Backrooms chunks use the source four-block ceiling grid", () => {
  let plan;
  for (let x = -80; x <= 80 && !plan; x++) {
    for (let z = -80; z <= 80; z++) {
      const candidate = backroomsChunkPlan(x, z, "light-grid-test");
      if (candidate.lit) {
        plan = candidate;
        break;
      }
    }
  }
  assert.ok(plan, "expected at least one lit deterministic chunk");
  assert.equal(plan.lights.length, 16);
  assert.deepEqual(
    [...new Set(plan.lights.map((light) => light.x - plan.origin.x))],
    [0, 4, 8, 12],
  );
  assert.deepEqual(
    [...new Set(plan.lights.map((light) => light.z - plan.origin.z))],
    [0, 4, 8, 12],
  );
  assert.ok(plan.lights.every((light) => light.y === 9 && light.block === plan.lightBlock));
});

test("Backrooms walls preserve source ranges and remain inside their source chunk", () => {
  let plan;
  for (let x = -80; x <= 80 && !plan; x++) {
    for (let z = -80; z <= 80; z++) {
      const candidate = backroomsChunkPlan(x, z, "wall-range-test");
      if (candidate.walls && candidate.wallVolumes.length > 1) {
        plan = candidate;
        break;
      }
    }
  }
  assert.ok(plan, "expected a wrapped source wall");
  assert.ok(plan.wall.startX >= 0 && plan.wall.startX <= 14);
  assert.ok(plan.wall.startZ >= 0 && plan.wall.startZ <= 14);
  assert.ok(plan.wall.length >= 1 && plan.wall.length <= 14);
  assert.ok(plan.wall.thickness >= 0 && plan.wall.thickness <= 5);
  for (const volume of plan.wallVolumes) {
    assert.equal(volume.block, plan.wallBlock);
    assert.equal(volume.from.y, 2);
    assert.equal(volume.to.y, 8);
    assert.ok(volume.from.x >= plan.origin.x && volume.to.x <= plan.origin.x + 15);
    assert.ok(volume.from.z >= plan.origin.z && volume.to.z <= plan.origin.z + 15);
  }
});

test("a Backrooms cell plan covers exactly nine chunks plus its bedrock base", () => {
  const cell = backroomsCell({ x: -1, z: 49 });
  const plan = backroomsCellPlan(cell, "cell-plan-test");
  assert.equal(plan.chunks.length, 9);
  assert.deepEqual(plan.baseVolume, {
    from: { x: -48, y: 0, z: 48 },
    to: { x: -1, y: 0, z: 95 },
    block: "minecraft:bedrock",
  });
  assert.deepEqual(
    plan.chunks.map((chunk) => `${chunk.chunk.x}:${chunk.chunk.z}`),
    ["-3:3", "-3:4", "-3:5", "-2:3", "-2:4", "-2:5", "-1:3", "-1:4", "-1:5"],
  );
});

test("Backrooms cell execution emits every planned fill and light operation", () => {
  assert.equal(typeof backroomsTerrain.executeBackroomsCellPlan, "function");
  const plan = backroomsCellPlan(backroomsCell({ x: 0, z: 0 }), "execution-test");
  const fills = [];
  const sets = [];
  backroomsTerrain.executeBackroomsCellPlan(plan, {
    fill: (volume) => fills.push(volume),
    set: (light) => sets.push(light),
  });

  assert.deepEqual(fills[0], plan.baseVolume);
  assert.equal(
    fills.length,
    1 + plan.chunks.reduce((count, chunk) => count + 2 + chunk.wallVolumes.length, 0),
  );
  assert.equal(
    sets.length,
    plan.chunks.reduce((count, chunk) => count + chunk.lights.length, 0),
  );
});

test("Backrooms terrain runtime is deployed, source-synchronized, and wired before schedulers begin", () => {
  const bpRuntimeUrl = new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/backrooms_terrain_runtime.js",
    import.meta.url,
  );
  const sourceRuntimeUrl = new URL(
    "../TheBrokenScript_Bedrock_2_0/src/systems/backrooms_terrain_runtime.js",
    import.meta.url,
  );
  const sourceModelUrl = new URL(
    "../TheBrokenScript_Bedrock_2_0/src/systems/backrooms_terrain.js",
    import.meta.url,
  );
  assert.equal(existsSync(bpRuntimeUrl), true);
  assert.equal(existsSync(sourceRuntimeUrl), true);
  assert.equal(existsSync(sourceModelUrl), true);
  assert.equal(readFileSync(bpRuntimeUrl, "utf8"), readFileSync(sourceRuntimeUrl, "utf8"));
  assert.equal(
    readFileSync(
      new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/backrooms_terrain.js", import.meta.url),
      "utf8",
    ),
    readFileSync(sourceModelUrl, "utf8"),
  );

  const main = readFileSync(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js", import.meta.url),
    "utf8",
  );
  assert.match(main, /registerBackroomsTerrain\(\)/);
  assert.match(main, /beginBackroomsTerrain\(scheduler\)/);
  assert.ok(main.indexOf("registerBackroomsTerrain()") < main.indexOf("scheduler.begin()"));
});
