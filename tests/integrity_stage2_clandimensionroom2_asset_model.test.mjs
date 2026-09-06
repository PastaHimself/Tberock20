import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Floor 2 variant 2 exposes the audited clandimensionroom2 template", () => {
  assert.equal(
    integrityModel.stage2GeneratorFloor2Structure(2, false),
    "clandimensionroom2",
  );
  assert.deepEqual(
    integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates.clandimensionroom2,
    {
      sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom2.nbt",
      sourceBlobSha: "d555dff8e0c3d45d9509e9b281323d1042e54063",
      size: [16, 9, 16],
      paletteNames: ["minecraft:air", "minecraft:cobblestone"],
      blockCount: 2304,
      nonAirBlockCount: 799,
      entityCount: 0,
      blockEntityCount: 0,
      placementY: 207,
      generationRole: "floor2_variant_2",
      status: "validated_asset",
    },
  );
});

test("clandimensionroom2 placement preserves Floor 2 Y and the no-mirror boundary", () => {
  const plan = integrityModel.stage2TemplatePlacementPlan(
    "clandimensionroom2",
    { x: 32, y: 207, z: -48 },
    { rotation: 0, mirror: "none" },
  );

  assert.deepEqual(plan, {
    templateId: "clandimensionroom2",
    sourcePath: "source_extracted/data/thebrokenscript/structure/clandimensionroom2.nbt",
    sourceBlobSha: "d555dff8e0c3d45d9509e9b281323d1042e54063",
    assetId: "thebrokenscript:stage2/clandimensionroom2",
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
    "structure load thebrokenscript:stage2/clandimensionroom2 32 207 -48 0_degrees none false true",
  );
});

test("validated clandimensionroom2 is present as a block-only Bedrock mcstructure asset", async () => {
  const asset = await readFile(
    new URL(
      "../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/clandimensionroom2.mcstructure",
      import.meta.url,
    ),
  );

  assert.equal(asset[0], 10);
  assert.ok(asset.length > 2000);
  assert.ok(asset.toString("utf8").includes("minecraft:cobblestone"));
  assert.equal(asset.toString("utf8").match(/minecraft:armor_stand/g)?.length ?? 0, 0);
  assert.equal(asset.toString("utf8").match(/minecraft:minecart/g)?.length ?? 0, 0);
});
