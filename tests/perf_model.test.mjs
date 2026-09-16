import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import {
  createDimensionHandleCache,
  createPlayerPresenceCache,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/perf_model.js";

test("player presence cache reads once per tick and recovers from transient API errors", () => {
  let reads = 0;
  let players = [];
  const cache = createPlayerPresenceCache(() => {
    reads += 1;
    if (players === null) throw new Error("world unavailable");
    return players;
  });

  assert.equal(cache.hasPlayers(10), false);
  assert.equal(cache.hasPlayers(10), false);
  assert.equal(reads, 1);

  players = [{ id: "player-1" }];
  assert.equal(cache.hasPlayers(11), true);
  assert.equal(cache.hasPlayers(11), true);
  assert.equal(reads, 2);

  players = null;
  assert.equal(cache.hasPlayers(12), false);
  assert.equal(cache.hasPlayers(12), false);
  assert.equal(reads, 3);

  cache.reset();
  players = [];
  assert.equal(cache.hasPlayers(12), false);
  assert.equal(reads, 4);
});

test("dimension cache reuses handles, does not cache failed lookups, and invalidates explicitly", () => {
  let reads = 0;
  const dimensions = new Map([
    ["overworld", { id: "overworld", generation: 1 }],
    ["nether", { id: "nether", generation: 1 }],
  ]);
  const cache = createDimensionHandleCache((name) => {
    reads += 1;
    const dimension = dimensions.get(name);
    if (!dimension) throw new Error(`missing dimension ${name}`);
    return dimension;
  });

  const first = cache.get("overworld");
  assert.equal(cache.get("overworld"), first);
  assert.equal(reads, 1);

  cache.invalidate("overworld");
  dimensions.set("overworld", { id: "overworld", generation: 2 });
  assert.equal(cache.get("overworld")?.generation, 2);
  assert.equal(reads, 2);

  assert.equal(cache.get("missing"), undefined);
  assert.equal(cache.get("missing"), undefined);
  assert.equal(reads, 4);

  cache.clear();
  assert.equal(cache.get("nether")?.generation, 1);
  assert.equal(reads, 5);
});

test("runtime cache adapter uses explicit invalidation instead of unsupported Dimension.isValid()", async () => {
  const perfSource = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/perf.js", import.meta.url),
    "utf8",
  );
  const mainSource = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js", import.meta.url),
    "utf8",
  );
  const sourceMain = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/src/main.js", import.meta.url),
    "utf8",
  );
  const dimensionsSource = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimensions.js", import.meta.url),
    "utf8",
  );
  const sourceDimensions = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/src/systems/dimensions.js", import.meta.url),
    "utf8",
  );
  const sourcePerf = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/src/systems/perf.js", import.meta.url),
    "utf8",
  );
  const perfModel = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/perf_model.js", import.meta.url),
    "utf8",
  );
  const sourcePerfModel = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/src/systems/perf_model.js", import.meta.url),
    "utf8",
  );

  assert.doesNotMatch(perfSource, /\.isValid(?:\?\.)?\s*\(/);
  assert.doesNotMatch(dimensionsSource, /\.isValid(?:\?\.)?\s*\(/);
  assert.doesNotMatch(sourcePerf, /\.isValid(?:\?\.)?\s*\(/);
  assert.doesNotMatch(sourceDimensions, /\.isValid(?:\?\.)?\s*\(/);
  assert.equal(sourcePerfModel, perfModel);
  assert.match(perfSource, /export function invalidateDimension/);
  assert.match(perfSource, /export function reset/);
  assert.match(dimensionsSource, /export function invalidateDimension/);
  assert.match(dimensionsSource, /export function resetCache/);
  assert.match(mainSource, /import \* as perf from "\.\/systems\/perf\.js"/);
  assert.match(mainSource, /perf\.reset\(\)/);
  assert.match(sourceMain, /import \* as dimensions from "\.\/systems\/dimensions\.js"/);
  assert.match(sourceMain, /import \* as perf from "\.\/systems\/perf\.js"/);
  assert.match(sourceMain, /dimensions\.resetCache\(\)/);
  assert.match(sourceMain, /perf\.reset\(\)/);
});
