import assert from "node:assert/strict";
import { existsSync, readFileSync } from "node:fs";
import test from "node:test";

const MODEL_URL = new URL(
  "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/concrete_terrain.js",
  import.meta.url,
);

async function loadModel() {
  assert.equal(existsSync(MODEL_URL), true, "Concrete terrain model must exist");
  return import(MODEL_URL);
}

test("Concrete terrain preserves the Java stripe and vertical schedule", async () => {
  const source = readFileSync(
    new URL(
      "../decompiled/net/thebrokenscript/world/dimension/concrete/ConcreteGenerator.java",
      import.meta.url,
    ),
    "utf8",
  );
  assert.match(source, /case -5:[\s\S]*case 0:[\s\S]*case 5:/);
  assert.match(source, /\(level\.getMinBuildHeight\(\) - 32\) \/ 16/);
  assert.match(source, /i < 27/);
  assert.match(source, /\(i \* 9\)/);
  assert.match(source, /Rotation\.CLOCKWISE_180/);

  const { CONCRETE_TERRAIN } = await loadModel();
  assert.deepEqual(CONCRETE_TERRAIN, {
    dimensionId: "thebrokenscript:concrete",
    stage: "source_concrete_terrain",
    version: 1,
    chunkSize: 16,
    cellSizeChunks: 1,
    minY: -64,
    maxY: 319,
    firstLevel: -6,
    lastLevel: 26,
    levelHeight: 9,
    preferredLandingY: 201,
    structureId: "thebrokenscript:concrete",
    stripeChunkXs: [-5, 0, 5],
    rotation: "clockwise_180_baked",
  });
});

test("Concrete places 33 templates only in the three source chunk columns", async () => {
  const { concreteChunkPlacements } = await loadModel();
  const placements = concreteChunkPlacements(-5, 2);
  assert.equal(placements.length, 33);
  assert.deepEqual(placements[0], {
    level: -6,
    structureId: "thebrokenscript:concrete",
    position: { x: -80, y: -54, z: 32 },
  });
  assert.deepEqual(placements.at(-1), {
    level: 26,
    structureId: "thebrokenscript:concrete",
    position: { x: -80, y: 234, z: 32 },
  });
  assert.deepEqual(concreteChunkPlacements(-4, 2), []);
});

test("Concrete cells are one chunk wide and stable at negative coordinates", async () => {
  const { concreteCell } = await loadModel();
  assert.deepEqual(concreteCell({ x: -0.01, z: -16 }), {
    key: "-1:-1",
    chunk: { x: -1, z: -1 },
    eligible: false,
    bounds: {
      from: { x: -16, y: -64, z: -16 },
      to: { x: -1, y: 319, z: -1 },
    },
  });
});

test("Concrete exploration prepares both directions along each source stripe", async () => {
  const { concreteExplorationCells } = await loadModel();
  assert.deepEqual(
    concreteExplorationCells([{ x: 8, z: 8 }, { x: 88, z: 8 }]).map(({ key }) => key),
    ["0:0", "5:0", "0:-1", "5:-1", "0:1", "5:1"],
  );
  assert.deepEqual(concreteExplorationCells([{ x: 24, z: 8 }]), []);
});

test("Concrete cell execution emits every planned native structure placement", async () => {
  const { concreteCell, concreteCellPlan, executeConcreteCellPlan } = await loadModel();
  const plan = concreteCellPlan(concreteCell({ x: 0, z: 0 }));
  const calls = [];
  executeConcreteCellPlan(plan, (structureId, position) => calls.push({ structureId, position }));
  assert.equal(calls.length, 33);
  assert.deepEqual(calls, plan.placements.map(({ structureId, position }) => ({ structureId, position })));
});

test("Concrete source template is converted with its rotation and water state", () => {
  assert.equal(existsSync(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/concrete.mcstructure",
    import.meta.url,
  )), true);
});

test("Concrete terrain runtime is synchronized and wired before schedulers begin", () => {
  const bpRuntime = new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/concrete_terrain_runtime.js",
    import.meta.url,
  );
  const sourceRuntime = new URL(
    "../TheBrokenScript_Bedrock_2_0/src/systems/concrete_terrain_runtime.js",
    import.meta.url,
  );
  const sourceModel = new URL(
    "../TheBrokenScript_Bedrock_2_0/src/systems/concrete_terrain.js",
    import.meta.url,
  );
  assert.equal(existsSync(bpRuntime), true);
  assert.equal(existsSync(sourceRuntime), true);
  assert.equal(existsSync(sourceModel), true);
  assert.equal(readFileSync(bpRuntime, "utf8"), readFileSync(sourceRuntime, "utf8"));
  assert.equal(readFileSync(MODEL_URL, "utf8"), readFileSync(sourceModel, "utf8"));

  const runtime = readFileSync(bpRuntime, "utf8");
  assert.match(runtime, /MAX_NEW_CELLS_PER_TICK = 2/);
  assert.match(runtime, /MAX_IN_FLIGHT_CELLS = 6/);
  assert.match(runtime, /scheduler\.every\("tbs\.concrete_terrain", 1,/);
  assert.match(runtime, /concreteExplorationCells/);

  const main = readFileSync(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js", import.meta.url),
    "utf8",
  );
  assert.match(main, /registerConcreteTerrain\(\)/);
  assert.match(main, /beginConcreteTerrain\(scheduler\)/);
  assert.ok(main.indexOf("registerConcreteTerrain()") < main.indexOf("scheduler.begin()"));
});
