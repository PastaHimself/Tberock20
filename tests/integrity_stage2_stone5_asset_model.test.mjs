import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 4 rare variant 4 exposes the audited stone5 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor4Structure(true, true, 4),
    "stone5",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone5,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone5.nbt",
      sourceBlobSha: "e770282817af7b4fbb94d76151c925bbbf351b94",
      size: [16, 3, 16],
      paletteNames: [
        "minecraft:air",
        "minecraft:stone",
        "thebrokenscript:block_is_missing_id",
      ],
      blockCount: 768,
      nonAirBlockCount: 512,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_4",
      status: "validated_asset",
    },
  );
});

test("stone5 placement uses the supported direct structure-load seam", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "stone5",
    { x: 32, y: 233, z: -48 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "stone5",
    sourcePath: "source_extracted/data/thebrokenscript/structure/stone5.nbt",
    sourceBlobSha: "e770282817af7b4fbb94d76151c925bbbf351b94",
    assetId: "thebrokenscript:stage2/stone5",
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
    "structure load thebrokenscript:stage2/stone5 32 233 -48 0_degrees none false true",
  );
});

test("validated stone5 is present as a Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/stone5.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 1000);
  assert.ok(asset.toString("utf8").includes("minecraft:stone"));
  assert.ok(asset.toString("utf8").includes("thebrokenscript:block_is_missing_id"));
});
