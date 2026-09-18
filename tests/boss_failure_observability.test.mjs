import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const ROOT = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const read = (relativePath) => readFileSync(path.join(ROOT, "TheBrokenScript_Bedrock_2_0", relativePath), "utf8");

test("boss runtime operations report bounded failures", () => {
  for (const file of [
    "BP/scripts/entities/boss/boss_controller.js",
    "BP/scripts/entities/boss/phase3_runtime.js",
    "BP/scripts/entities/boss/fractured_runtime.js",
    "BP/scripts/entities/boss/chord_projectile_runtime.js",
  ]) {
    const source = read(file);
    assert.match(source, /operation_diagnostics\.js/, file);
    assert.match(source, /operationDiagnostics\.(warnOnce|errorOnce)/, file);
  }
});

test("boss fallbacks retain spawn, damage, and cleanup paths", () => {
  const boss = read("BP/scripts/entities/boss/boss_controller.js");
  const phase3 = read("BP/scripts/entities/boss/phase3_runtime.js");
  const fractured = read("BP/scripts/entities/boss/fractured_runtime.js");
  const chord = read("BP/scripts/entities/boss/chord_projectile_runtime.js");
  assert.match(boss, /function spawnAt[\s\S]*operationDiagnostics\.warnOnce/);
  assert.match(phase3, /function removeEntity[\s\S]*operationDiagnostics\.warnOnce/);
  assert.match(fractured, /function safeRemove[\s\S]*entity\.kill\(\)/);
  assert.match(chord, /function teleport[\s\S]*return false/);
});
