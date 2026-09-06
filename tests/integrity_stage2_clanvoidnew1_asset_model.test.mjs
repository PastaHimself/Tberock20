import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 1 preserves the Java variant 1..7 boundary", () => {
  assert.equal(integrityModel.stage2GeneratorFloor1Structure(1), "clanvoidnew1");
  assert.equal(integrityModel.stage2GeneratorFloor1Structure(7), "clanvoidnew7");
  assert.throws(
    () => integrityModel.stage2GeneratorFloor1Structure(0),
    RangeError,
  );
  assert.throws(
    () => integrityModel.stage2GeneratorFloor1Structure(8),
    RangeError,
  );
});

test("clanvoidnew1 preserves the source-backed Floor 1 placement contract", () => {
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.clanvoidnew1,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/clanvoidnew1.nbt",
      sourceBlobSha: "a92773a3f9da467f1849d6d34b0e6292e47bcf62",
      size: [16, 6, 16],
      paletteNames: [
        "minecraft:air",
        "minecraft:cobblestone",
        "minecraft:glass",
        "minecraft:wall_torch",
        "thebrokenscript:cobblestone_border_block",
        "thebrokenscript:stone_slab_border_block",
      ],
      blockCount: 1536,
      nonAirBlockCount: 748,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 200,
      generationRole: "floor1_variant_1",
      status: "validated_asset",
    },
  );

  const plan = integrityModel.stage2TemplatePlacementPlan(
    "clanvoidnew1",
    { x: 0, y: 200, z: 0 },
    { rotation: 0, mirror: "none" },
  );
  assert.deepEqual(plan, {
    templateId: "clanvoidnew1",
    sourcePath: "source_extracted/data/thebrokenscript/structure/clanvoidnew1.nbt",
    sourceBlobSha: "a92773a3f9da467f1849d6d34b0e6292e47bcf62",
    assetId: "thebrokenscript:stage2/clanvoidnew1",
    origin: { x: 0, y: 200, z: 0 },
    size: [16, 6, 16],
    placementY: 200,
    rotation: 0,
    mirror: "none",
    includeEntities: false,
    includeBlocks: true,
    status: "validated_asset",
  });
  assert.equal(
    integrityModel.stage2TemplateLoadCommand(plan),
    "structure load thebrokenscript:stage2/clanvoidnew1 0 200 0 0_degrees none false true",
  );
});

test("clanvoidnew1 contains the source custom blocks and directional torch state", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/clanvoidnew1.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 1000);
  const serialized = asset.toString("utf8");
  assert.ok(serialized.includes("thebrokenscript:cobblestone_border_block"));
  assert.ok(serialized.includes("thebrokenscript:stone_slab_border_block"));
  assert.ok(serialized.includes("minecraft:wall_torch"));
  assert.ok(serialized.includes("torch_facing_direction"));
});
