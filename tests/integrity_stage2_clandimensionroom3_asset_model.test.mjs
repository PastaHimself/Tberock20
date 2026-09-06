import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 2 variants 3 and 4 expose the audited clandimensionroom3 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor2Structure(3, false),
    "clandimensionroom3",
  );
  assert.equal(
    integrityModel.stage2GeneratorFloor2Structure(4, false),
    "clandimensionroom3",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.clandimensionroom3,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom3.nbt",
      sourceBlobSha: "37d9f55b6fc9ac6c6f41979380e398cfdbf56ead",
      size: [16, 9, 16],
      paletteNames: ["minecraft:air", "minecraft:cobblestone"],
      blockCount: 2304,
      nonAirBlockCount: 855,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 207,
      generationRole: "floor2_variant_3_4",
      status: "validated_asset",
    },
  );
});

test("clandimensionroom3 placement preserves Floor 2 Y and the no-mirror boundary", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "clandimensionroom3",
    { x: 48, y: 207, z: -64 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "clandimensionroom3",
    sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom3.nbt",
    sourceBlobSha: "37d9f55b6fc9ac6c6f41979380e398cfdbf56ead",
    assetId: "thebrokenscript:stage2/clandimensionroom3",
    origin: { x: 48, y: 207, z: -64 },
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
    "structure load thebrokenscript:stage2/clandimensionroom3 48 207 -64 0_degrees none false true",
  );
});

test("validated clandimensionroom3 is present as a block-only Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/clandimensionroom3.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 2000);
  assert.ok(asset.toString("utf8").includes("minecraft:cobblestone"));
  assert.equal(asset.toString("utf8").match(/minecraft:armor_stand/g)?.length ?? 0, 0);
  assert.equal(asset.toString("utf8").match(/minecraft:minecart/g)?.length ?? 0, 0);
});
