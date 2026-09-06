import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";

const root = new URL("../TheBrokenScript_Bedrock_2_0/", import.meta.url);

async function source(path) {
  return readFile(new URL(path, root), "utf8");
}

test("runtime damage adapter preserves native attribution and a same-tick custom source ledger", async () => {
  const runtime = await source("BP/scripts/systems/damage_source_runtime.js");
  assert.match(runtime, /damageSourcePlan\(sourceId/);
  assert.match(runtime, /cause: plan\.cause/);
  assert.match(runtime, /options\.damagingEntity/);
  assert.match(runtime, /options\.damagingProjectile/);
  assert.match(runtime, /getLastPortedDamageSource/);
});

test("source-specific combat runtimes route recovered custom damage ids", async () => {
  const [boss, phase3, fractured] = await Promise.all([
    source("BP/scripts/entities/boss/boss_controller.js"),
    source("BP/scripts/entities/boss/phase3_runtime.js"),
    source("BP/scripts/entities/boss/fractured_runtime.js"),
  ]);
  assert.match(boss, /thebrokenscript:void_mass/);
  assert.match(boss, /thebrokenscript:integrity_ball/);
  assert.match(boss, /thebrokenscript:fever_attack/);
  assert.match(boss, /thebrokenscript:chord_lazer/);
  assert.match(phase3, /thebrokenscript:integ_bypass/);
  assert.match(phase3, /thebrokenscript:integrity_ball/);
  assert.match(fractured, /thebrokenscript:jimmy_stomp/);
  assert.match(fractured, /thebrokenscript:rock/);
});
