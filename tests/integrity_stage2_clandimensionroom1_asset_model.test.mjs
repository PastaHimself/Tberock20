import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 2 variant 1 exposes the audited clandimensionroom1 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor2Structure(1, false),
    "clandimensionroom1",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.clandimensionroom1,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom1.nbt",
      sourceBlobSha: "4f30ee7f5f37cfff08ee6e4728fe27e5f62becc2",
      size: [16, 9, 16],
      paletteNames: ["minecraft:air", "minecraft:cobblestone"],
      blockCount: 2304,
      nonAirBlockCount: 750,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 207,
      generationRole: "floor2_variant_1",
      status: "validated_asset",
    },
  );
});

test("clandimensionroom1 placement preserves Floor 2 Y and the no-mirror boundary", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "clandimensionroom1",
    { x: 32, y: 207, z: -48 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "clandimensionroom1",
    sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom1.nbt",
    sourceBlobSha: "4f30ee7f5f37cfff08ee6e4728fe27e5f62becc2",
    assetId: "thebrokenscript:stage2/clandimensionroom1",
    origin: { x: 32, y: 207, z: -48 },
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
    "structure load thebrokenscript:stage2/clandimensionroom1 32 207 -48 0_degrees none false true",
  );
});

test("validated clandimensionroom1 is present as a block-only Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/clandimensionroom1.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 2000);
  assert.ok(asset.toString("utf8").includes("minecraft:cobblestone"));
  assert.equal(asset.toString("utf8").match(/minecraft:armor_stand/g)?.length ?? 0, 0);
  assert.equal(asset.toString("utf8").match(/minecraft:minecart/g)?.length ?? 0, 0);
});
