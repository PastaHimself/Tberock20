import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

const ROOT = new URL("../", import.meta.url);
const SRC = "TheBrokenScript_Bedrock_2_0/src/systems/world_state.js";
const BP = "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/world_state.js";

async function text(path) {
  return (await readFile(new URL(path, ROOT), "utf8")).replace(/^\uFEFF/, "");
}

const ENCOUNTER_DELAYS = [
  "entitySpawnDelay",
  "circuitSpawnDelay",
  "oblitSpawnDelay",
  "tbeSpawnDelay",
  "rareSpawnDelay",
  "nullSpawnDelay",
  "curvedSpawnDelay",
  "eerieNoiseDelay",
  "herobrineDelay",
  "circuitInhabitedDelay",
];

test("world-state source and deploy copy stay synchronized", async () => {
  assert.equal(await text(SRC), await text(BP));
});

test("MapVariables encounter delays use the Java zero defaults", async () => {
  const source = await text(SRC);
  for (const key of ENCOUNTER_DELAYS) {
    assert.match(source, new RegExp(`\\b${key}:\\s*0,`), `${key} must default to zero`);
    assert.doesNotMatch(source, new RegExp(`\\b${key}:\\s*INT_MAX`));
  }
});

test("world-state initialization is additive and migration-safe", async () => {
  const source = await text(SRC);
  const init = source.match(/export function init\(\) \{([\s\S]*?)\n\}/)?.[1] ?? "";

  assert.match(init, /Object\.entries\(DEFAULTS\)/);
  assert.match(init, /const propertyKey = `mv\.\$\{key\}`/);
  assert.match(init, /state\.getWorld\(propertyKey, undefined\) === undefined/);
  assert.match(init, /state\.setWorld\(propertyKey, value\)/);
  assert.doesNotMatch(init, /mapVarsDataVersion/);
  assert.doesNotMatch(init, /getWorld\("mv\.dataVersion"/);
});
