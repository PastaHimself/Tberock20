import assert from "node:assert/strict";
import { existsSync, readFileSync } from "node:fs";
import test from "node:test";

const MODEL_URL = new URL(
  "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/library_terrain.js",
  import.meta.url,
);

async function loadModel() {
  assert.equal(existsSync(MODEL_URL), true, "Library terrain model must exist");
  return import(MODEL_URL);
}

test("Library terrain preserves the Java vertical template schedule", async () => {
  const source = readFileSync(
    new URL(
      "../decompiled/net/thebrokenscript/world/dimension/library/LibraryGenerator.java",
      import.meta.url,
    ),
    "utf8",
  );
  assert.match(source, /for \(int i = -3; i < 12; \+\+i\)/);
  assert.match(source, /case 0:[\s\S]*case 4:[\s\S]*case 8:/);
  assert.match(source, /\(0 \+ i \* 17\)/);

  const { LIBRARY_TERRAIN } = await loadModel();
  assert.deepEqual(LIBRARY_TERRAIN, {
    dimensionId: "thebrokenscript:library",
    stage: "source_library_terrain",
    version: 1,
    chunkSize: 16,
    cellSizeChunks: 1,
    minY: -64,
    maxY: 255,
    firstLevel: -3,
    lastLevel: 11,
    levelHeight: 17,
    preferredLandingY: 201,
    structures: {
      normal: "thebrokenscript:library",
      variant: "thebrokenscript:library2",
    },
    variantLevels: [0, 4, 8],
  });
});

test("Library chunk plans place all 15 source templates at exact coordinates", async () => {
  const { libraryChunkPlacements } = await loadModel();
  const placements = libraryChunkPlacements(-1, 2);
  assert.equal(placements.length, 15);
  assert.deepEqual(placements[0], {
    level: -3,
    structureId: "thebrokenscript:library",
    position: { x: -16, y: -51, z: 32 },
  });
  assert.deepEqual(
    placements.filter(({ structureId }) => structureId.endsWith("library2")),
    [
      { level: 0, structureId: "thebrokenscript:library2", position: { x: -16, y: 0, z: 32 } },
      { level: 4, structureId: "thebrokenscript:library2", position: { x: -16, y: 68, z: 32 } },
      { level: 8, structureId: "thebrokenscript:library2", position: { x: -16, y: 136, z: 32 } },
    ],
  );
  assert.deepEqual(placements.at(-1), {
    level: 11,
    structureId: "thebrokenscript:library",
    position: { x: -16, y: 187, z: 32 },
  });
});

test("Library cells are one chunk wide and stable at negative coordinates", async () => {
  const { libraryCell } = await loadModel();
  assert.deepEqual(libraryCell({ x: -0.01, z: -16 }), {
    key: "-1:-1",
    chunk: { x: -1, z: -1 },
    bounds: {
      from: { x: -16, y: -64, z: -16 },
      to: { x: -1, y: 255, z: -1 },
    },
  });
});

test("Library exploration keeps a full movement-safe neighbor ring", async () => {
  const { libraryNeighborCells } = await loadModel();
  assert.deepEqual(
    libraryNeighborCells({ x: 8, z: 8 }).map(({ key }) => key),
    ["-1:0", "1:0", "0:-1", "0:1", "-1:-1", "-1:1", "1:-1", "1:1"],
  );
  assert.deepEqual(libraryNeighborCells({ x: 8, z: 8 }, 4), []);
  assert.deepEqual(
    libraryNeighborCells({ x: 15, z: 15 }, 4).map(({ key }) => key),
    ["1:0", "0:1", "1:1"],
  );
});

test("Library exploration interleaves and deduplicates cells for multiple players", async () => {
  const { libraryExplorationCells } = await loadModel();
  assert.equal(typeof libraryExplorationCells, "function");
  assert.deepEqual(
    libraryExplorationCells([{ x: 8, z: 8 }, { x: 40, z: 8 }]).map(({ key }) => key),
    [
      "0:0", "2:0",
      "-1:0", "1:0", "3:0",
      "0:-1", "2:-1",
      "0:1", "2:1",
      "-1:-1", "1:-1",
      "-1:1", "1:1",
      "3:-1", "3:1",
    ],
  );
});

test("Library cell execution emits every planned native structure placement", async () => {
  const { executeLibraryCellPlan, libraryCell, libraryCellPlan } = await loadModel();
  const plan = libraryCellPlan(libraryCell({ x: 0, z: 0 }));
  const calls = [];
  executeLibraryCellPlan(plan, (structureId, position) => calls.push({ structureId, position }));
  assert.equal(calls.length, 15);
  assert.deepEqual(calls, plan.placements.map(({ structureId, position }) => ({ structureId, position })));
});

test("Library source templates are converted with top and bottom slab support", () => {
  for (const name of ["library", "library2"]) {
    assert.equal(existsSync(new URL(
      `../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/${name}.mcstructure`,
      import.meta.url,
    )), true, name);
  }

  const slab = JSON.parse(readFileSync(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/blocks/mono_slab.json", import.meta.url),
    "utf8",
  ))["minecraft:block"];
  assert.deepEqual(slab.description.states["thebrokenscript:top"], [false, true]);
  const top = slab.permutations.find(({ condition }) => condition.includes("thebrokenscript:top"));
  assert.equal(top.components["minecraft:geometry"], "geometry.tbs_slab_top");
  assert.deepEqual(top.components["minecraft:collision_box"], {
    origin: [-8, 8, -8],
    size: [16, 8, 16],
  });

  const geometry = JSON.parse(readFileSync(
    new URL("../TheBrokenScript_Bedrock_2_0/RP/models/blocks/tbs_slab.geo.json", import.meta.url),
    "utf8",
  ))["minecraft:geometry"];
  const topGeometry = geometry.find(({ description }) => description.identifier === "geometry.tbs_slab_top");
  assert.ok(topGeometry);
  assert.deepEqual(topGeometry.bones[0].cubes[0].origin, [-8, 8, -8]);
});

test("Library terrain runtime is source-synchronized and wired before schedulers begin", () => {
  const bpRuntime = new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/library_terrain_runtime.js",
    import.meta.url,
  );
  const sourceRuntime = new URL(
    "../TheBrokenScript_Bedrock_2_0/src/systems/library_terrain_runtime.js",
    import.meta.url,
  );
  const sourceModel = new URL(
    "../TheBrokenScript_Bedrock_2_0/src/systems/library_terrain.js",
    import.meta.url,
  );
  assert.equal(existsSync(bpRuntime), true);
  assert.equal(existsSync(sourceRuntime), true);
  assert.equal(existsSync(sourceModel), true);
  assert.equal(readFileSync(bpRuntime, "utf8"), readFileSync(sourceRuntime, "utf8"));
  assert.equal(readFileSync(MODEL_URL, "utf8"), readFileSync(sourceModel, "utf8"));

  const runtime = readFileSync(bpRuntime, "utf8");
  assert.match(runtime, /MAX_NEW_CELLS_PER_TICK = 2/);
  assert.match(runtime, /MAX_IN_FLIGHT_CELLS = 8/);
  assert.match(runtime, /scheduler\.every\("tbs\.library_terrain", 1,/);
  assert.match(runtime, /libraryExplorationCells/);

  const main = readFileSync(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js", import.meta.url),
    "utf8",
  );
  assert.match(main, /registerLibraryTerrain\(\)/);
  assert.match(main, /beginLibraryTerrain\(scheduler\)/);
  assert.ok(main.indexOf("registerLibraryTerrain()") < main.indexOf("scheduler.begin()"));
});
