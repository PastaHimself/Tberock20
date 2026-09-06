import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 4 rare variant 3 exposes the audited stone4 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor4Structure(true, true, 3),
    "stone4",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone4,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone4.nbt",
      sourceBlobSha: "d43f4146ebe57edb8dbfb3a2b25d8b616fb39137",
      size: [16, 3, 16],
      paletteNames: [
        "minecraft:air",
        "minecraft:rail",
        "minecraft:stone",
      ],
      paletteStateCount: 8,
      blockCount: 768,
      nonAirBlockCount: 295,
      entityCount: 1,
      blockEntityCount: 0,
      placementY: 233,
      generationRole: "floor4_rare_variant_3",
      status: "validated_asset",
    },
  );
});

test("stone4 placement includes the audited minecart entity", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "stone4",
    { x: 32, y: 233, z: -48 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "stone4",
    sourcePath: "source_extracted/data/thebrokenscript/structure/stone4.nbt",
    sourceBlobSha: "d43f4146ebe57edb8dbfb3a2b25d8b616fb39137",
    assetId: "thebrokenscript:stage2/stone4",
    origin: { x: 32, y: 233, z: -48 },
    size: [16, 3, 16],
    placementY: 233,
    rotation: 0,
    mirror: "none",
    includeEntities: true,
    includeBlocks: true,
    status: "validated_asset",
  });
  assert.equal(
    integrityModel.stage2TemplateLoadCommand(plan),
    "structure load thebrokenscript:stage2/stone4 32 233 -48 0_degrees none true true",
  );
});

test("validated stone4 is present as a Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/stone4.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 5000);
  assert.ok(asset.toString("utf8").includes("minecraft:rail"));
  assert.ok(asset.toString("utf8").includes("rail_direction"));
  assert.ok(asset.toString("utf8").includes("minecraft:minecart"));
  assert.ok(asset.toString("utf8").includes("identifier"));
  assert.ok(asset.toString("utf8").includes("Pos"));
});
