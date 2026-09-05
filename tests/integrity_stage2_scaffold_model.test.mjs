import assert from "node:assert/strict";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Stage 2 runtime scaffold plan preserves the source cell and boundary layers", () => {
  assert.equal(typeof integrityModel.stage2GeneratorRuntimeVolumes, "function");

  const plan = integrityModel.stage2GeneratorRuntimeVolumes({ x: -1, y: 200, z: -1 });

  assert.deepEqual(plan, {
    cellKey: "-10:-10",
    origin: { x: -160, z: -160 },
    volumes: [
      { kind: "floor", floorId: "FLOOR_1", y: 253, blockId: "minecraft:grass_block" },
      { kind: "floor", floorId: "FLOOR_2", y: 234, blockId: "minecraft:stone" },
      { kind: "floor", floorId: "FLOOR_3", y: 218, blockId: "minecraft:oak_planks" },
      { kind: "floor", floorId: "FLOOR_4", y: 208, blockId: "minecraft:cobblestone" },
      { kind: "floor", floorId: "FLOOR_5", y: 202, blockId: "minecraft:cobblestone" },
      { kind: "floor", floorId: "FLOOR_6", y: 162, blockId: "minecraft:stone" },
      { kind: "floor", floorId: "FLOOR_7", y: 103, blockId: "minecraft:bedrock" },
      { kind: "barrier", y: 251, blockId: "minecraft:barrier" },
      { kind: "barrier", y: 232, blockId: "minecraft:barrier" },
      { kind: "barrier", y: 216, blockId: "minecraft:barrier" },
      { kind: "barrier", y: 206, blockId: "minecraft:barrier" },
      { kind: "barrier", y: 102, blockId: "minecraft:barrier" },
      { kind: "barrier", y: 271, blockId: "minecraft:barrier" },
    ],
  });
});
