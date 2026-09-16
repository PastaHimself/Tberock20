import assert from "node:assert/strict";
import { execFileSync } from "node:child_process";
import test from "node:test";
import { fileURLToPath } from "node:url";

const PROFILE_TOOL = fileURLToPath(new URL("../tools/profile_p2_scans.mjs", import.meta.url));

test("synthetic 1-tick controller profile proves cache savings without changing entity scan work", () => {
  const output = execFileSync(
    process.execPath,
    [PROFILE_TOOL, "--check", "--json"],
    { encoding: "utf8" },
  );
  const report = JSON.parse(output);

  assert.equal(report.schemaVersion, 1);
  assert.equal(report.scenarios.length, 5);
  for (const scenario of report.scenarios) {
    assert.equal(scenario.cached.playerReads, scenario.ticks);
    assert.equal(scenario.cached.entityScans, scenario.uncached.entityScans);
    assert.ok(scenario.cached.dimensionReads <= scenario.uncached.dimensionReads);
    assert.equal(scenario.cached.controllerTicks, scenario.uncached.controllerTicks);
  }
});
