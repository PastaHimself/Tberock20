import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";

const repoRoot = path.resolve(new URL("..", import.meta.url).pathname);
const mainPath = path.join(repoRoot, "TheBrokenScript_Bedrock_2_0/BP/scripts/main.js");
const commandsPath = path.join(repoRoot, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js");
const runtimePath = path.join(
  repoRoot,
  "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/integrity_arena_runtime.js",
);
const bossControllerPath = path.join(
  repoRoot,
  "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js",
);
const phase3RuntimePath = path.join(
  repoRoot,
  "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/phase3_runtime.js",
);

test("main starts the Arena owner before the Phase 3 adapter", async () => {
  const main = await readFile(mainPath, "utf8");
  assert.match(main, /integrityArenaRuntime\.begin\(scheduler\)/);
  assert.ok(main.indexOf("integrityArenaRuntime.begin") < main.indexOf("phase3Runtime.begin"));
});

test("developer arena commands delegate to the runtime lifecycle", async () => {
  const commands = await readFile(commandsPath, "utf8");
  assert.match(commands, /integrityArenaRuntime\.start/);
  assert.match(commands, /integrityArenaRuntime\.next/);
  assert.match(commands, /integrityArenaRuntime\.stop/);
  assert.doesNotMatch(commands, /world\.setDynamicProperty\("tbs:arenaActive", on\)/);
});

test("Arena runtime exposes the source lifecycle entry points", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  assert.match(runtime, /export function begin\(scheduler\)/);
  assert.match(runtime, /export function start\(triggerPlayer/);
  assert.match(runtime, /export function next\(\)/);
  assert.match(runtime, /export function stop\(/);
  assert.match(runtime, /phase2Ended/);
  assert.match(runtime, /setParticipantIds/);
  assert.match(runtime, /phase3Runtime\.cleanup\(\)/);
});

test("Phase 3 runtime is the sole owner of runtime-family entities", async () => {
  const controller = await readFile(bossControllerPath, "utf8");
  const phase3Runtime = await readFile(phase3RuntimePath, "utf8");
  assert.doesNotMatch(controller, /case "thebrokenscript:integrity_phase_3": return tickIntegrityP3/);
  assert.doesNotMatch(controller, /case "thebrokenscript:integrity_arm": return tickArm/);
  assert.doesNotMatch(controller, /case "thebrokenscript:integ_fireball": return tickFireball/);
  assert.match(phase3Runtime, /families: \[RUNTIME_FAMILY\]/);
});
