import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath, pathToFileURL } from "node:url";

const here = path.dirname(fileURLToPath(import.meta.url));
const repoRoot = path.resolve(here, "..");
const modelPath = path.join(
  repoRoot,
  "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/stage3_generator_model.js",
);
const runtimePath = path.join(
  repoRoot,
  "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/stage3_generator_runtime.js",
);

function expectedIds() {
  const ids = [];
  for (let z = 0; z <= 25 && ids.length < 560; z += 1) {
    for (let x = 0; x <= 24 && ids.length < 560; x += 1) {
      ids.push("thebrokenscript:stage3/phase3_arena_final/chunk_" + x + "_" + z);
    }
  }
  return ids.reverse();
}

test("Stage 3 structure plan validates source bounds and source Y origin", async () => {
  const {
    STAGE3_EXPECTED_CHUNK_COUNT,
    STAGE3_SOURCE_MIN_Y,
    stage3ArenaStructureEntry,
    stage3ArenaStructurePlan,
  } = await import(pathToFileURL(modelPath));

  assert.equal(STAGE3_EXPECTED_CHUNK_COUNT, 560);
  assert.equal(STAGE3_SOURCE_MIN_Y, -64);
  assert.deepEqual(
    stage3ArenaStructureEntry("thebrokenscript:stage3/phase3_arena_final/chunk_12_13"),
    {
      id: "thebrokenscript:stage3/phase3_arena_final/chunk_12_13",
      chunkX: 12,
      chunkZ: 13,
      location: { x: 192, y: -64, z: 208 },
    },
  );
  assert.equal(stage3ArenaStructureEntry(
    "thebrokenscript:stage3/phase3_arena_final/chunk_25_0",
  ), null);

  const plan = stage3ArenaStructurePlan(expectedIds());
  assert.equal(plan.length, 560);
  assert.equal(plan[0].chunkX, 0);
  assert.equal(plan[0].chunkZ, 0);
  assert.ok(plan.every((entry, index) => index === 0
    || entry.chunkZ > plan[index - 1].chunkZ
    || (entry.chunkZ === plan[index - 1].chunkZ && entry.chunkX > plan[index - 1].chunkX)));
  assert.throws(() => stage3ArenaStructurePlan(expectedIds().slice(1)), /inventory mismatch/);
});

test("Stage 3 runtime uses pack structures, bounded ticking areas, and persistent completion", async () => {
  const source = await readFile(runtimePath, "utf8");
  assert.match(source, /getPackStructureIds\(\)/);
  assert.match(source, /manager\.place\(/);
  assert.match(source, /createTickingArea\(identifier, options\)/);
  assert.match(source, /removeTickingArea\(identifier\)/);
  assert.match(source, /includeBlocks: true, includeEntities: false/);
  assert.match(source, /await nextTick\(\)/);
  assert.match(source, /worldLike\.setDynamicProperty\(READY_PROPERTY, true\)/);
});
