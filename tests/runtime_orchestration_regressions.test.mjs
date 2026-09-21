import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const ROOT = fileURLToPath(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/", import.meta.url));

async function source(name) {
  return readFile(path.join(ROOT, name), "utf8");
}

test("spawn director passes total world time to the frequency provider", async () => {
  const spawnDirector = await source("spawn_director.js");

  assert.match(spawnDirector, /const gameTime = world\.getAbsoluteTime\(\);/);
  assert.match(spawnDirector, /frequency:\s*eventFrequency\(gameTime\)/);
  assert.doesNotMatch(spawnDirector, /eventFrequency\(0\)/);
});
