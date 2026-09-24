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


test("Stage 2 source template selection preserves seeded Java RNG order", async () => {
  const {
    stage2RoomTemplatePlan,
    stage2SurfaceTemplatePlan,
  } = await import(pathToFileURL(modelPath));

  assert.deepEqual(stage2SurfaceTemplatePlan(39, 5, 5), {
    structureId: "fieldbase2",
    y: 252,
    mirror: "none",
    rotation: "rotate90",
  });

  assert.deepEqual(stage2SurfaceTemplatePlan(1327, 5, 5), {
    structureId: "fieldbase",
    y: 252,
    mirror: "front_back",
    rotation: "rotate270",
  });

  assert.deepEqual(stage2RoomTemplatePlan(0, 5, 5), {
    transform: { mirror: "none", rotation: "rotate270" },
    randomExtra: false,
    special: true,
    variants: {
      variantF1: 6,
      variantF2: 5,
      variantF3: 32,
      variantF4: 1,
    },
    placements: [
      { structureId: "clanvoidnew6", y: 200 },
      { structureId: "clandimensionroom2", y: 207 },
      { structureId: "woodfloor4", y: 217 },
      { structureId: "stone2", y: 233 },
    ],
  });

  assert.deepEqual(stage2RoomTemplatePlan(108, 5, 5), {
    transform: { mirror: "none", rotation: "none" },
    randomExtra: true,
    special: true,
    variants: {
      variantF1: 2,
      variantF2: 5,
      variantF3: 11,
      variantF4: 2,
    },
    placements: [
      { structureId: "clanvoidnew2", y: 200 },
      { structureId: "clandimensionroom2", y: 207 },
      { structureId: "tek_woodfloor2", y: 217 },
      { structureId: "stone1", y: 233 },
    ],
  });

  assert.equal(stage2SurfaceTemplatePlan(0, 0, 5), null);
  assert.equal(stage2RoomTemplatePlan(0, 10, 5), null);
});

test("Stage 2 tunnel source branch keeps the 90% hallway-1 gate and 2..10 fallback", async () => {
  const { stage2TunnelTemplatePlan } = await import(pathToFileURL(modelPath));
  assert.deepEqual(stage2TunnelTemplatePlan(() => 0.899999, () => 0.75), {
    structureId: "bedrockhallway1",
    y: 160,
    mirror: "none",
    rotation: "none",
  });
  assert.equal(stage2TunnelTemplatePlan(() => 0.9, () => 0).structureId, "bedrockhallway2");
  assert.equal(stage2TunnelTemplatePlan(() => 1, () => 0.999999).structureId, "bedrockhallway10");
});
