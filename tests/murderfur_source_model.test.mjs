import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";
import {
  MURDERFUR_SOURCE,
  murderfurMeleeBoxIntersects,
  murderfurPhaseStats,
  murderfurPhaseStep,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/murderfur_source_model.js";

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");

test("Murderfur phase thresholds preserve Java one-step transition ordering", () => {
  assert.equal(murderfurPhaseStep(1, 667), 1);
  assert.equal(murderfurPhaseStep(1, 666), 2);
  assert.equal(murderfurPhaseStep(1, 100), 2, "phase 1 must not skip phase 2 in one tick");
  assert.equal(murderfurPhaseStep(2, 334), 2);
  assert.equal(murderfurPhaseStep(2, 333), 3);
  assert.equal(murderfurPhaseStep(3, 0), 3);
});

test("Murderfur phase multipliers preserve Java attack and movement attributes", () => {
  const phase1 = murderfurPhaseStats(1);
  assert.equal(phase1.phase, 1);
  assert.equal(phase1.attackDamage, 1);
  assert.ok(Math.abs(phase1.movementSpeed - 0.225) < 1e-12);
  const phase2 = murderfurPhaseStats(2);
  assert.equal(phase2.phase, 2);
  assert.equal(phase2.attackDamage, 2);
  assert.ok(Math.abs(phase2.movementSpeed - 0.3) < 1e-12);
  const phase3 = murderfurPhaseStats(3);
  assert.equal(phase3.phase, 3);
  assert.equal(phase3.attackDamage, 5);
  assert.ok(Math.abs(phase3.movementSpeed - 0.45) < 1e-12);
  assert.equal(MURDERFUR_SOURCE.attackIntervalTicks, 10);
  assert.equal(MURDERFUR_SOURCE.attackRange, 1.5);
});

test("Murderfur melee uses the Java expanded AABB and per-entity 10-tick cadence", () => {
  assert.equal(murderfurMeleeBoxIntersects({ x: 0, y: 64, z: 0 }, { x: 1.29, y: 64, z: 0 }), true);
  assert.equal(murderfurMeleeBoxIntersects({ x: 0, y: 64, z: 0 }, { x: 1.3, y: 64, z: 0 }), false);
  const controller = fs.readFileSync(path.join(root, "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js"), "utf8");
  assert.match(controller, /murderfurMeleeReadyAt/);
  assert.match(controller, /system\.currentTick \+ MURDERFUR_SOURCE\.attackIntervalTicks/);
  assert.doesNotMatch(controller, /system\.currentTick % MURDERFUR_SOURCE\.attackIntervalTicks/);
});

test("Murderfur music is stopped on death, removal, and a Murderfur player kill", () => {
  const controller = fs.readFileSync(path.join(root, "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js"), "utf8");
  assert.match(controller, /if \(id === "thebrokenscript:murderfur"\)[\s\S]*?stopMurderfurMusic\(\)/);
  assert.match(controller, /entityRemove\.subscribe[\s\S]*?thebrokenscript:murderfur[\s\S]*?stopMurderfurMusic\(\)/);
  assert.match(controller, /damagingEntity\?\.typeId === "thebrokenscript:murderfur"[\s\S]*?stopMurderfurMusicForPlayer/);
});
