import assert from "node:assert/strict";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

test("Stage 2 placement plan exposes the validated Java stone1 template", () => {
  assert.equal(typeof integrityModel.stage2TemplatePlacementPlan, "function");

  assert.deepEqual(
    integrityModel.stage2TemplatePlacementPlan(
      "stone1",
      { x: 32, y: 233, z: -48 },
      { rotation: 90, mirror: "none" },
    ),
    {
      templateId: "stone1",
      sourcePath: "source_extracted/data/thebrokenscript/structure/stone1.nbt",
      sourceBlobSha: "2d8e2d3da26e07f4921764f9f6937cc46f359060",
      assetId: "thebrokenscript:stage2/stone1",
      origin: { x: 32, y: 233, z: -48 },
      size: [16, 1, 16],
      placementY: 233,
      rotation: 90,
      mirror: "none",
      includeEntities: false,
      includeBlocks: true,
      status: "validated_asset",
    },
  );
});
