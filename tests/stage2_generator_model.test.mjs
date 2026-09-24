import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath, pathToFileURL } from "node:url";

const here = path.dirname(fileURLToPath(import.meta.url));
const repoRoot = path.resolve(here, "..");
const modelPath = path.join(
  repoRoot,
  "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/stage2_generator_model.js",
);
const runtimePath = path.join(
  repoRoot,
  "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/stage2_generator_runtime.js",
);

test("JavaLegacyRandom matches java.util.Random compatibility vectors", async () => {
  const { JavaLegacyRandom } = await import(pathToFileURL(modelPath));
  const random = new JavaLegacyRandom(0);
  assert.equal(random.nextInt(100), 60);
  assert.equal(random.nextFloat(), 0.8314409852027893);
  assert.equal(random.nextInt(32), 7);
  assert.equal(random.nextInt(3), 2);
});

test("Stage 2 core chunk plan preserves Java floor and barrier bands", async () => {
  const {
    stage2CoreChunkRegion,
    stage2CorePlanePlan,
  } = await import(pathToFileURL(modelPath));

  assert.equal(stage2CoreChunkRegion(5, 5), "interior");
  assert.equal(stage2CoreChunkRegion(0, 5), "border");
  assert.equal(stage2CoreChunkRegion(10, 10), "border");
  assert.equal(stage2CoreChunkRegion(11, 5), null);

  assert.deepEqual(stage2CorePlanePlan(5, 5).planes, [
    { y: 271, blockId: "minecraft:barrier" },
    { y: 251, blockId: "minecraft:barrier" },
    { y: 232, blockId: "minecraft:barrier" },
    { y: 216, blockId: "minecraft:barrier" },
    { y: 206, blockId: "minecraft:barrier" },
    { y: 199, blockId: "thebrokenscript:cobblestone_border_block" },
    { y: 198, blockId: "minecraft:barrier" },
    { y: 160, blockId: "minecraft:bedrock" },
    { y: 159, blockId: "minecraft:barrier" },
    { y: 102, blockId: "minecraft:barrier" },
  ]);
  assert.deepEqual(stage2CorePlanePlan(0, 5).planes, [
    { y: 271, blockId: "minecraft:barrier" },
  ]);
});

test("Stage 2 Nowhere layer is deterministic from the Java world-seed formula", async () => {
  const {
    stage2NowhereCells,
    stage2NowhereLayerLocations,
  } = await import(pathToFileURL(modelPath));

  const cells = stage2NowhereCells("12345", 5, 5);
  assert.equal(cells.mud.length, 165);
  assert.equal(cells.barrier.length, 91);
  assert.equal(cells.mud.length + cells.barrier.length, 256);

  const repeated = stage2NowhereCells(12345n, 5, 5);
  assert.deepEqual(repeated, cells);

  const layers = stage2NowhereLayerLocations("12345", 5, 5);
  assert.equal(layers.mud.length, 660);
  assert.equal(layers.barrier.length, 364);
  assert.ok([...layers.mud, ...layers.barrier].every(({ y }) => y >= 100 && y <= 103));

  assert.deepEqual(stage2NowhereCells("12345", 0, 5), { mud: [], barrier: [] });
});

test("Stage 2 runtime loads one chunk at a time and persists completion", async () => {
  const source = await readFile(runtimePath, "utf8");
  assert.match(source, /createTickingArea\(identifier, options\)/);
  assert.match(source, /removeTickingArea\(identifier\)/);
  assert.match(source, /await nextTick\(\)/);
  assert.match(source, /dimension\.fillBlocks\(/);
  assert.match(source, /new ListBlockVolume\(nowhere\.mud\)/);
  assert.match(source, /includeTypes: Object\.freeze\(\["minecraft:air"\]\)/);
  assert.match(source, /worldLike\.setDynamicProperty\(READY_PROPERTY, true\)/);
});
