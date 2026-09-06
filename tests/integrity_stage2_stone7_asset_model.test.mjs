import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 4 rare variant 6 exposes the audited stone7 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor4Structure(true, true, 6),
    "stone7",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone7,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone7.nbt",
      sourceBlobSha: "2446bc420007c6daa7e78a1cf6edcecac2ffbdc8",
      size: [16, 3, 16],
      paletteNames: [
        "minecraft:air",
        "minecraft:smooth_stone",
        "minecraft:stone",
      ],
      blockCount: 768,
      nonAirBlockCount: 288,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_6",
      status: "validated_asset",
    },
  );
});

test("stone7 placement is block-only and keeps the no-mirror boundary", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "stone7",
    { x: 32, y: 233, z: -48 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "stone7",
    sourcePath: "source_extracted/data/thebrokenscript/structure/stone7.nbt",
    sourceBlobSha: "2446bc420007c6daa7e78a1cf6edcecac2ffbdc8",
    assetId: "thebrokenscript:stage2/stone7",
    origin: { x: 32, y: 233, z: -48 },
    size: [16, 3, 16],
    placementY: 233,
    rotation: 0,
    mirror: "none",
    includeEntities: false,
    includeBlocks: true,
    status: "validated_asset",
  });
  assert.equal(
    integrityModel.stage2TemplateLoadCommand(plan),
    "structure load thebrokenscript:stage2/stone7 32 233 -48 0_degrees none false true",
  );
});

test("validated stone7 is present as a block-only Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/stone7.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 2000);
  assert.ok(asset.toString("utf8").includes("minecraft:stone"));
  assert.ok(asset.toString("utf8").includes("minecraft:smooth_stone"));
  assert.equal(asset.toString("utf8").match(/minecraft:armor_stand/g)?.length ?? 0, 0);
});
