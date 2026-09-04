import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import {
  PHASE1_TERRAIN_SOURCE,
  createTerrainCorruptionQueue,
  phase1TerrainTick,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_phase1_terrain_model.js";

test("Phase 1 terrain constants preserve the recovered corruption contract", () => {
  assert.deepEqual(PHASE1_TERRAIN_SOURCE, {
    radius: 100,
    ratio: 0.3,
    delayTicks: 20,
    initialTicksSinceLastCorrupt: 20,
    replacementBlockIds: [
      "thebrokenscript:obsidian",
      "thebrokenscript:r_3",
      "thebrokenscript:void_root",
      "thebrokenscript:teeth",
    ],
    protectedBlockId: "thebrokenscript:corrupted_command_block",
  });
});

test("the corruption queue uses an inclusive disk and source ratio", () => {
  const queue = createTerrainCorruptionQueue(
    { x: 10, y: 70, z: -4 },
    {
      radius: 1,
      ratio: 1,
      nextFloat: () => 0.5,
      shuffle: (values) => values,
    },
  );

  assert.deepEqual(queue, [
    { x: 9, z: -4 },
    { x: 10, z: -5 },
    { x: 10, z: -4 },
    { x: 10, z: -3 },
    { x: 11, z: -4 },
  ]);
});

test("terrain tick corrupts one queued position exactly at the 20-tick boundary", () => {
  assert.deepEqual(
    phase1TerrainTick(
      { terrainQueue: [{ x: 3, z: 7 }], ticksSinceLastCorrupt: 19 },
      () => "thebrokenscript:obsidian",
    ),
    {
      action: "corrupt",
      position: { x: 3, z: 7 },
      replacementBlockId: "thebrokenscript:obsidian",
      terrainQueue: [],
      ticksSinceLastCorrupt: 0,
    },
  );
});

test("terrain tick waits without consuming a position before the boundary", () => {
  assert.deepEqual(
    phase1TerrainTick(
      { terrainQueue: [{ x: 3, z: 7 }], ticksSinceLastCorrupt: 0 },
      () => "thebrokenscript:obsidian",
    ),
    {
      action: "wait",
      terrainQueue: [{ x: 3, z: 7 }],
      ticksSinceLastCorrupt: 1,
    },
  );
});

test("terrain tick leaves an empty queue untouched", () => {
  assert.deepEqual(
    phase1TerrainTick(
      { terrainQueue: [], ticksSinceLastCorrupt: 7 },
      () => "thebrokenscript:obsidian",
    ),
    {
      action: "idle",
      terrainQueue: [],
      ticksSinceLastCorrupt: 7,
    },
  );
});

test("terrain tick does not consume a position when no replacement is available", () => {
  assert.deepEqual(
    phase1TerrainTick(
      { terrainQueue: [{ x: 3, z: 7 }], ticksSinceLastCorrupt: 19 },
      () => undefined,
    ),
    {
      action: "replacement_unavailable",
      terrainQueue: [{ x: 3, z: 7 }],
      ticksSinceLastCorrupt: 0,
    },
  );
});

test("Phase 1 terrain corruption is wired into the arena tick", async () => {
  const [runtime, controller] = await Promise.all([
    readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_runtime.js", import.meta.url), "utf8"),
    readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js", import.meta.url), "utf8"),
  ]);

  assert.ok(runtime.includes("createTerrainCorruptionQueue"));
  assert.ok(runtime.includes("phase1TerrainTick"));
  assert.ok(runtime.includes("block.setType(replacementBlockId)"));
  assert.ok(controller.includes("tickIntegrityArena()"));
});
