import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 4 rare variant 2 exposes the audited stone3 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor4Structure(true, true, 2),
    "stone3",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone3,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone3.nbt",
      sourceBlobSha: "45381d498f95f558e296b8aae40bb9183f13032e",
      size: [16, 4, 16],
      paletteNames: [
        "minecraft:air",
        "minecraft:oak_door",
        "minecraft:stone",
      ],
      paletteStateCount: 14,
      blockCount: 1024,
      nonAirBlockCount: 300,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_2",
      status: "validated_asset",
    },
  );
});

test("stone3 placement uses the supported direct structure-load seam", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "stone3",
    { x: 32, y: 233, z: -48 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "stone3",
    sourcePath: "source_extracted/data/thebrokenscript/structure/stone3.nbt",
    sourceBlobSha: "45381d498f95f558e296b8aae40bb9183f13032e",
    assetId: "thebrokenscript:stage2/stone3",
    origin: { x: 32, y: 233, z: -48 },
    size: [16, 4, 16],
    placementY: 233,
    rotation: 0,
    mirror: "none",
    includeEntities: false,
    includeBlocks: true,
    status: "validated_asset",
  });
  assert.equal(
    integrityModel.stage2TemplateLoadCommand(plan),
    "structure load thebrokenscript:stage2/stone3 32 233 -48 0_degrees none false true",
  );
});

test("validated stone3 is present as a Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/stone3.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 5000);
  assert.ok(asset.toString("utf8").includes("minecraft:oak_door"));
  assert.ok(asset.toString("utf8").includes("minecraft:cardinal_direction"));
  assert.ok(asset.toString("utf8").includes("door_hinge_bit"));
});
