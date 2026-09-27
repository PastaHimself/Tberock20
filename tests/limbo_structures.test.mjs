import assert from "node:assert/strict";
import { existsSync, readFileSync } from "node:fs";
import test from "node:test";

import {
  LIMBO_HOUSE,
  LIMBO_STRUCTURE_ORDER,
  LIMBO_STRUCTURE_SIZES,
  applyLimboStructurePlacement,
  emptyLimboStructureLedger,
  limboCandidateChunk,
  limboStructureCell,
  planLimboStructureCell,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/limbo_structures.js";

const SOURCE_ORDER = [
  "limbo_caveoutpost",
  "limbo_happyfarm",
  "limbo_sanctuary",
  "limbo_thewrongdirection",
  "limbo_distastefulquandary",
  "limbo_somethingoldsomethingnew",
  "limbo_towerbaseright",
  "limbo_treehouse",
];

test("Limbo rare structures retain the Java source order and one-per-three-chunk candidate", () => {
  const java = readFileSync(new URL(
    "../decompiled/net/thebrokenscript/world/dimension/limbo/LimboGenerator.java",
    import.meta.url,
  ), "utf8");
  assert.match(java, /Math\.floorMod\(chunkX, 3\) != 1/);
  assert.match(java, /isTooClose\(chunkPos2, 1024\)/);
  assert.deepEqual(LIMBO_STRUCTURE_ORDER, SOURCE_ORDER);
  assert.deepEqual(limboCandidateChunk(0, 0), { x: 1, z: 1 });
  assert.deepEqual(limboCandidateChunk(-1, -1), { x: -2, z: -2 });
});

test("Limbo picks the first unplaced structure and centers it at Y=1", () => {
  const cell = limboStructureCell({ x: 24, z: 24 });
  const placements = planLimboStructureCell(cell, emptyLimboStructureLedger());
  assert.equal(placements.length, 1);
  assert.deepEqual(placements[0], {
    name: "limbo_caveoutpost",
    structureId: "thebrokenscript:limbo_caveoutpost",
    chunk: { x: 1, z: 1 },
    position: { x: 0, y: 1, z: 1 },
  });
  assert.deepEqual(LIMBO_STRUCTURE_SIZES.limbo_caveoutpost, { x: 48, y: 44, z: 47 });
});

test("Limbo enforces the source 1024 squared-chunk spacing threshold", () => {
  const first = planLimboStructureCell(
    limboStructureCell({ x: 24, z: 24 }),
    emptyLimboStructureLedger(),
  )[0];
  const ledger = applyLimboStructurePlacement(emptyLimboStructureLedger(), first);

  assert.deepEqual(
    planLimboStructureCell(limboStructureCell({ x: 10 * 48 + 24, z: 24 }), ledger),
    [],
  );
  assert.deepEqual(
    planLimboStructureCell(limboStructureCell({ x: 11 * 48 + 24, z: 24 }), ledger),
    [{
      name: "limbo_happyfarm",
      structureId: "thebrokenscript:limbo_happyfarm",
      chunk: { x: 34, z: 1 },
      position: { x: 543, y: 1, z: 13 },
    }],
  );
});

test("Limbo's fixed house is placed once at the exact Java coordinates", () => {
  const cell = limboStructureCell({ x: -24, z: -24 });
  const placements = planLimboStructureCell(cell, emptyLimboStructureLedger());
  assert.deepEqual(placements, [{
    name: "limbo_house",
    structureId: "thebrokenscript:limbo_house",
    chunk: { x: -1, z: -1 },
    position: { x: -5, y: 1, z: -5 },
  }]);
  assert.deepEqual(LIMBO_HOUSE.position, { x: -5, y: 1, z: -5 });
  assert.ok(cell.bounds.from.x <= LIMBO_HOUSE.position.x);
  assert.ok(cell.bounds.from.z <= LIMBO_HOUSE.position.z);
  assert.ok(cell.bounds.to.x >= LIMBO_HOUSE.position.x + 10);
  assert.ok(cell.bounds.to.z >= LIMBO_HOUSE.position.z + 10);

  const ledger = applyLimboStructurePlacement(emptyLimboStructureLedger(), placements[0]);
  assert.deepEqual(planLimboStructureCell(cell, ledger), []);
});

test("Limbo placement state limits every source structure to one successful placement", () => {
  let ledger = emptyLimboStructureLedger();
  const names = [];
  for (let cellX = 0; cellX < SOURCE_ORDER.length; cellX += 1) {
    const cell = limboStructureCell({ x: cellX * 11 * 48 + 24, z: 24 });
    const [placement] = planLimboStructureCell(cell, ledger);
    assert.ok(placement);
    names.push(placement.name);
    ledger = applyLimboStructurePlacement(ledger, placement);
  }
  assert.deepEqual(names, SOURCE_ORDER);
  assert.deepEqual(
    planLimboStructureCell(limboStructureCell({ x: 99 * 48 + 24, z: 24 }), ledger),
    [],
  );
});

test("Limbo structure stage is wired and all converted source assets are present", () => {
  const main = readFileSync(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js",
    import.meta.url,
  ), "utf8");
  assert.match(main, /registerLimboStructures\(\)/);
  assert.match(main, /beginLimboStructures\(scheduler\)/);
  assert.ok(main.indexOf("registerLimboStructures()") < main.indexOf("portedFeatures.begin(scheduler)"));

  for (const name of ["limbo_house", ...SOURCE_ORDER]) {
    assert.ok(existsSync(new URL(
      `../TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/${name}.mcstructure`,
      import.meta.url,
    )), `missing converted structure ${name}`);
  }

  const runtime = readFileSync(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/limbo_structures_runtime.js",
    import.meta.url,
  ), "utf8");
  assert.match(runtime, /applyLimboStructureMetadata/);
  assert.ok(existsSync(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/limbo_structure_metadata.js",
    import.meta.url,
  )), "missing generated Limbo block metadata module");
});
