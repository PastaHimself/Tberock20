import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import * as integrityModel from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";

const stage2Players = [
  {
    id: "player-floor-1",
    dimensionId: "thebrokenscript:stage2",
    y: 254,
    loadingPhase2: false,
  },
  {
    id: "player-floor-7",
    dimensionId: "thebrokenscript:stage2",
    y: 104,
    loadingPhase2: false,
  },
];

test("Phase 2 plans the first Stage 2 floor transition from the participant roster", () => {
  assert.equal(typeof integrityModel.phase2Stage2FloorStep, "function");

  const step = integrityModel.phase2Stage2FloorStep({
    phase: "phase2",
    spawnedFloorIds: [],
    integrityPresent: false,
    players: stage2Players,
  });

  assert.deepEqual(
    step.floorsToSpawn.map(({ floorId, playerId }) => ({ floorId, playerId })),
    [{ floorId: "FLOOR_1", playerId: "player-floor-1" }],
  );
  assert.deepEqual(step.nextSpawnedFloorIds, ["FLOOR_1"]);
});

test("Stage 2 floor spawning is one-shot, dimension-gated, and permits Floor 7 only after Integrity exists", () => {
  const step = integrityModel.phase2Stage2FloorStep({
    phase: "phase2",
    spawnedFloorIds: ["FLOOR_1"],
    integrityPresent: true,
    players: [
      ...stage2Players,
      {
        id: "player-floor-2",
        dimensionId: "thebrokenscript:stage2",
        y: 235,
        loadingPhase2: false,
      },
      {
        id: "player-loading",
        dimensionId: "thebrokenscript:stage2",
        y: 219,
        loadingPhase2: true,
      },
      {
        id: "player-other-dimension",
        dimensionId: "minecraft:overworld",
        y: 219,
        loadingPhase2: false,
      },
    ],
  });

  assert.deepEqual(
    step.floorsToSpawn.map(({ floorId, playerId }) => ({ floorId, playerId })),
    [
      { floorId: "FLOOR_7", playerId: "player-floor-7" },
      { floorId: "FLOOR_2", playerId: "player-floor-2" },
    ],
  );
  assert.deepEqual(step.nextSpawnedFloorIds, ["FLOOR_1", "FLOOR_7", "FLOOR_2"]);
});

test("Integrity placement waits for a Tether except on the Floor 6 special mapping", () => {
  const waiting = integrityModel.phase2IntegrityPlacementStep({
    playerY: 235,
    integrityPresent: true,
    currentFloorId: "Floor1",
    hasTetherOnTargetFloor: false,
  });
  assert.deepEqual(waiting, {
    action: "wait_for_tether",
    targetFloorId: "Floor2",
    stage2FloorId: "FLOOR_2",
    requiresTether: true,
  });

  const placed = integrityModel.phase2IntegrityPlacementStep({
    playerY: 235,
    integrityPresent: true,
    currentFloorId: "Floor1",
    hasTetherOnTargetFloor: true,
  });
  assert.deepEqual(placed, {
    action: "place",
    targetFloorId: "Floor2",
    stage2FloorId: "FLOOR_2",
    requiresTether: true,
  });

  const floorSix = integrityModel.phase2IntegrityPlacementStep({
    playerY: 180,
    integrityPresent: true,
    currentFloorId: "Floor5",
    hasTetherOnTargetFloor: false,
  });
  assert.deepEqual(floorSix, {
    action: "place",
    targetFloorId: "Floor6",
    stage2FloorId: "FLOOR_6_INTEG",
    requiresTether: false,
  });

  const alreadyPlaced = integrityModel.phase2IntegrityPlacementStep({
    playerY: 180,
    integrityPresent: true,
    currentFloorId: "Floor6",
  });
  assert.equal(alreadyPlaced.action, "already_placed");
});

test("Stage 2 safe scanning returns the block above the first valid floor", () => {
  const safeY = integrityModel.stage2FindSafeSpawnY({
    spawnY: 254,
    maxScanDepth: 4,
    isValidFloor: (candidateY) => candidateY === 252,
    areAboveBlocksReplaceable: () => true,
  });
  assert.equal(safeY, 253);

  const blockedY = integrityModel.stage2FindSafeSpawnY({
    spawnY: 254,
    maxScanDepth: 4,
    isValidFloor: (candidateY) => candidateY === 252,
    areAboveBlocksReplaceable: (_candidateY, offset) => offset !== 2,
  });
  assert.equal(blockedY, null);
});

test("Stage 2 runtime maps every generated floor band to its source template family", () => {
  assert.equal(typeof integrityModel.stage2GeneratorTemplateForFloor, "function");
  assert.equal(integrityModel.stage2GeneratorTemplateForFloor("FLOOR_1"), "fieldbase");
  assert.equal(
    integrityModel.stage2GeneratorTemplateForFloor("FLOOR_1", { surfaceRare: true }),
    "fieldbase2",
  );
  assert.equal(
    integrityModel.stage2GeneratorTemplateForFloor("FLOOR_2", {
      floor4Special: true,
      floor4RareVariant: true,
      floor4Variant: 6,
    }),
    "stone7",
  );
  assert.equal(
    integrityModel.stage2GeneratorTemplateForFloor("FLOOR_3", {
      floor3Variant: 35,
      floor3RandomExtra: true,
    }),
    "tek_woodfloor28",
  );
  assert.equal(
    integrityModel.stage2GeneratorTemplateForFloor("FLOOR_4", {
      floor2Variant: 5,
      floor2Special: false,
    }),
    "clandimensionroom5",
  );
  assert.equal(
    integrityModel.stage2GeneratorTemplateForFloor("FLOOR_5", { floor1Variant: 7 }),
    "clanvoidnew7",
  );
  assert.equal(
    integrityModel.stage2GeneratorTemplateForFloor("FLOOR_6", { tunnelVariant: 10 }),
    "bedrockhallway10",
  );
  assert.equal(integrityModel.stage2GeneratorTemplateForFloor("FLOOR_7"), null);
});

test("Stage 2 floor placement plans keep the selected floor height and origin", () => {
  assert.equal(typeof integrityModel.stage2TemplatePlacementPlanForFloor, "function");
  const plan = integrityModel.stage2TemplatePlacementPlanForFloor(
    "stone1",
    "FLOOR_2",
    { x: 16, z: 32 },
    { rotation: 90, mirror: "front_back" },
  );

  assert.deepEqual(
    {
      assetId: plan.assetId,
      origin: plan.origin,
      placementY: plan.placementY,
      rotation: plan.rotation,
      mirror: plan.mirror,
    },
    {
      assetId: "thebrokenscript:stage2/stone1",
      origin: { x: 16, y: 233, z: 32 },
      placementY: 233,
      rotation: 90,
      mirror: "front_back",
    },
  );
});

test("Stage 2 runtime wires the supported block, entity, and placement seams", async () => {
  const runtime = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_runtime.js", import.meta.url),
    "utf8",
  );

  for (const fragment of [
    "phase2Stage2FloorStep",
    "phase2IntegrityPlacementStep",
    "stage2FindSafeSpawnY",
    "dimension.getBlock(",
    "dimension.getEntities({",
    "dimension.spawnEntity(",
    "stage2IntegrityPositionAllowed",
  ]) {
    assert.ok(runtime.includes(fragment), "runtime is missing " + fragment);
  }
});

test("Stage 2 runtime places each generated template through StructureManager", async () => {
  const runtime = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_runtime.js", import.meta.url),
    "utf8",
  );

  for (const fragment of [
    "stage2GeneratorTemplateForFloor",
    "stage2TemplatePlacementPlan",
    "world.structureManager",
    "structureManager.place(",
    "stage2PlacedTemplateKeys",
    "runStage2TemplateLoad(dimension, plan)",
    "includeEntities: plan.includeEntities",
  ]) {
    assert.ok(runtime.includes(fragment), "runtime is missing " + fragment);
  }
});

test("the Stage 2 catalog covers every audited source template", async () => {
  const audit = JSON.parse(
    await readFile(
      new URL(
        "../TheBrokenScript_Bedrock_2_0/STAGE2_GENERATOR_AUDIT.json",
        import.meta.url,
      ),
      "utf8",
    ),
  );
  const assetAudit = JSON.parse(
    await readFile(
      new URL(
        "../TheBrokenScript_Bedrock_2_0/STAGE2_TEMPLATE_ASSET_AUDIT.json",
        import.meta.url,
      ),
      "utf8",
    ),
  );
  const ids = audit.templates.map(({ id }) => id);
  const supported = integrityModel.STAGE2_TEMPLATE_SOURCE.supportedTemplates;
  const assetAuditById = new Map(
    assetAudit.templates.map((entry) => [entry.id, entry]),
  );

  assert.equal(integrityModel.STAGE2_TEMPLATE_SOURCE.deferredTemplateCount, 0);
  assert.deepEqual(Object.keys(supported).sort(), [...ids].sort());
  assert.equal(assetAudit.validatedAssetCount, ids.length);
  assert.equal(assetAudit.deferredTemplateCount, 0);

  for (const id of ids) {
    const auditEntry = audit.templates.find((entry) => entry.id === id);
    const catalogEntry = supported[id];
    const assetAuditEntry = assetAuditById.get(id);
    assert.ok(assetAuditEntry, `${id} is missing from the asset audit`);
    const asset = await readFile(
      new URL(
        `../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/${id}.mcstructure`,
        import.meta.url,
      ),
    );
    assert.ok(asset.length > 100, `${id} asset is empty`);
    assert.equal(catalogEntry.status, "validated_asset");
    assert.equal(catalogEntry.sourceBlobSha, auditEntry.gitBlobSha);
    assert.deepEqual(catalogEntry.size, auditEntry.size);
    assert.equal(catalogEntry.blockCount, auditEntry.blockCount);
    assert.equal(catalogEntry.entityCount, auditEntry.entityCount);
    assert.equal(catalogEntry.blockEntityCount, auditEntry.blockEntityCount);
    assert.equal(catalogEntry.generationRole, assetAuditEntry.generationRole);
    assert.equal(catalogEntry.placementY, assetAuditEntry.placementY);
  }
});
