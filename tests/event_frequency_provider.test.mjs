import test from "node:test";
import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";

import { eventFrequency } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/event_frequency.js";

const projectRoot = path.resolve(path.dirname(new URL(import.meta.url).pathname), "..");

function close(actual, expected, tolerance = 1e-12) {
  assert.ok(
    Math.abs(actual - expected) <= tolerance,
    `expected ${actual} to be within ${tolerance} of ${expected}`,
  );
}

test("event frequency reproduces TBSEngineControl source constants and curve", () => {
  const source = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "TBSEngineControl.java"),
    "utf8",
  );

  assert.match(source, /CUTOFF = 55\.0f/);
  assert.match(source, /0\.03125f \* x/);
  assert.match(source, /coerceAtMost[\s\S]*?7\.0f/);
  assert.match(source, /evalCurveTicks\(gameTime\) \/ \(float\)24000/);
  assert.match(source, /freq - 2\.9166666E-4f/);

  close(eventFrequency(0), -2.9166666e-4);
  close(
    eventFrequency(55 * 24000),
    Math.pow(0.03125 * 55, 2) / 24000 - 2.9166666e-4,
  );

  const day100 = (
    Math.log10(100 + 1 - 55) + Math.pow(0.03125 * 55, 2)
  ) / 24000 - 2.9166666e-4;
  close(eventFrequency(100 * 24000), day100);
});

test("event frequency is monotonic and caps at the Java maximum curve", () => {
  const values = [0, 1, 10, 55, 100, 1000, 10000, 12000].map(
    (days) => eventFrequency(days * 24000),
  );

  for (let i = 1; i < values.length; i++) {
    assert.ok(values[i] >= values[i - 1], `frequency decreased at index ${i}`);
  }

  const capped = 7 / 24000 - 2.9166666e-4;
  close(eventFrequency(12000 * 24000), capped);
  close(eventFrequency(20000 * 24000), capped);
});

test("spawn director feeds total world time into source frequency callers", () => {
  const spawnDirector = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "systems", "spawn_director.js"),
    "utf8",
  );

  assert.match(spawnDirector, /const gameTime = world\.getAbsoluteTime\(\)/);
  assert.doesNotMatch(spawnDirector, /const gameTime = world\.getTimeOfDay\(\)/);
});
