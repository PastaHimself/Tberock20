import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 2 variant 5 preserves special and ordinary source mappings", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor2Structure(5, true),
    "clandimensionroom2",
  );
  assert.equal(
    integrityModel.stage2GeneratorFloor2Structure(5, false),
    "clandimensionroom5",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.clandimensionroom5,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom5.nbt",
      sourceBlobSha: "8757e559d147f81f9dae6f8301d59af47027ca23",
      size: [16, 9, 16],
      paletteNames: ["minecraft:air", "minecraft:cobblestone"],
      blockCount: 2304,
      nonAirBlockCount: 792,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 207,
      generationRole: "floor2_variant_5_ordinary",
      status: "validated_asset",
    },
  );
});

test("clandimensionroom5 placement preserves Floor 2 Y and the no-mirror boundary", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "clandimensionroom5",
    { x: 64, y: 207, z: -80 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "clandimensionroom5",
    sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom5.nbt",
    sourceBlobSha: "8757e559d147f81f9dae6f8301d59af47027ca23",
    assetId: "thebrokenscript:stage2/clandimensionroom5",
    origin: { x: 64, y: 207, z: -80 },
    size: [16, 9, 16],
    placementY: 207,
    rotation: 0,
    mirror: "none",
    includeEntities: false,
    includeBlocks: true,
    status: "validated_asset",
  });
  assert.equal(
    integrityModel.stage2TemplateLoadCommand(plan),
    "structure load thebrokenscript:stage2/clandimensionroom5 64 207 -80 0_degrees none false true",
  );
});

test("validated clandimensionroom5 is present as a block-only Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/clandimensionroom5.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 2000);
  assert.ok(asset.toString("utf8").includes("minecraft:cobblestone"));
  assert.equal(asset.toString("utf8").match(/minecraft:armor_stand/g)?.length ?? 0, 0);
  assert.equal(asset.toString("utf8").match(/minecraft:minecart/g)?.length ?? 0, 0);
});
