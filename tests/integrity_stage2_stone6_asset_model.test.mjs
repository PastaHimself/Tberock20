import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 4 rare variant 5 exposes the audited stone6 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor4Structure(true, true, 5),
    "stone6",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone6,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone6.nbt",
      sourceBlobSha: "1b15f9ac3f6b35506b25361694b87c7ca8dd6231",
      size: [16, 4, 16],
      paletteNames: ["minecraft:air", "minecraft:stone"],
      blockCount: 1024,
      nonAirBlockCount: 256,
      entityCount: 15,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_5",
      status: "validated_asset",
    },
  );
});

test("stone6 placement includes the audited armor-stand entities", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "stone6",
    { x: 32, y: 233, z: -48 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "stone6",
    sourcePath: "source_extracted/data/thebrokenscript/structure/stone6.nbt",
    sourceBlobSha: "1b15f9ac3f6b35506b25361694b87c7ca8dd6231",
    assetId: "thebrokenscript:stage2/stone6",
    origin: { x: 32, y: 233, z: -48 },
    size: [16, 4, 16],
    placementY: 233,
    rotation: 0,
    mirror: "none",
    includeEntities: true,
    includeBlocks: true,
    status: "validated_asset",
  });
  assert.equal(
    integrityModel.stage2TemplateLoadCommand(plan),
    "structure load thebrokenscript:stage2/stone6 32 233 -48 0_degrees none true true",
  );
});

test("validated stone6 is present as an entity-bearing Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/stone6.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 7000);
  assert.ok(asset.toString("utf8").includes("minecraft:stone"));
  assert.equal(
    asset.toString("utf8").match(/minecraft:armor_stand/g)?.length,
    15,
  );
  assert.ok(asset.toString("utf8").includes("Pos"));
  assert.ok(asset.toString("utf8").includes("Rotation"));
});
