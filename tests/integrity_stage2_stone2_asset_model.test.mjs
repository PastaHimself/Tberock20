import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 4 rare variant 1 exposes the audited stone2 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor4Structure(true, true, 1),
    "stone2",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone2,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone2.nbt",
      sourceBlobSha: "a61aabc79ec6bd18a3bdb325367d65055a108e9d",
      size: [16, 9, 16],
      paletteNames: [
        "minecraft:air",
        "minecraft:stone",
        "thebrokenscript:block_is_missing_id",
      ],
      blockCount: 2304,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_1",
      status: "validated_asset",
    },
  );
});

test("stone2 placement uses the supported direct structure-load seam", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "stone2",
    { x: 32, y: 233, z: -48 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "stone2",
    sourcePath: "source_extracted/data/thebrokenscript/structure/stone2.nbt",
    sourceBlobSha: "a61aabc79ec6bd18a3bdb325367d65055a108e9d",
    assetId: "thebrokenscript:stage2/stone2",
    origin: { x: 32, y: 233, z: -48 },
    size: [16, 9, 16],
    placementY: 233,
    rotation: 0,
    mirror: "none",
    includeEntities: false,
    includeBlocks: true,
    status: "validated_asset",
  });
  assert.equal(
    integrityModel.stage2TemplateLoadCommand(plan),
    "structure load thebrokenscript:stage2/stone2 32 233 -48 0_degrees none false true",
  );
});

test("validated stone2 is present as a Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/stone2.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 8000);
  assert.ok(asset.toString("utf8").includes("thebrokenscript:block_is_missing_id"));
});
