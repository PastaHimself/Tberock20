import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const repoRoot = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const read = (relativePath) => readFile(path.join(repoRoot, relativePath), "utf8");

test("Integrity arena runtime is wired into the world lifecycle", async () => {
  const main = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/main.js");
  const runtime = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/integrity_runtime.js");
  assert.match(main, /integrity_runtime/);
  assert.match(main, /integrityRuntime\.begin\(scheduler\)/);
  assert.match(runtime, /events\.subscribeGuarded/);
  assert.match(runtime, /playerDimensionChange/);
  assert.match(runtime, /scheduler\.every\("tbs\.integrity_runtime_tick"/);
  assert.match(runtime, /ARENA_SOURCE/);
  assert.match(runtime, /PHASE1_SOURCE/);
  assert.match(runtime, /PHASE2_SOURCE/);
  assert.match(runtime, /PHASE3_SOURCE/);
  assert.match(runtime, /arenaCheckLivingPlayers/);
  assert.match(runtime, /phase1Ended/);
  assert.match(runtime, /phase2NeedsRecoveryTeleport/);
  assert.match(runtime, /phase2EligibleForLowestPlayer/);
  assert.match(runtime, /phase3Ended/);
});

test("Arena commands delegate to the lifecycle and do not only flip a dynamic flag", async () => {
  const commands = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js");
  assert.match(commands, /integrityRuntime/);
  assert.match(commands, /integrityRuntime\.start\(player/);
  assert.match(commands, /integrityRuntime\.stop\(\)/);
  assert.match(commands, /integrityRuntime\.next\(\)/);
  assert.doesNotMatch(commands, /setDynamicProperty\(["']tbs:arenaActive/);
});

test("Early Integrity behavior does not fabricate Phase 1 melee or health-threshold transitions", async () => {
  const controller = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js");
  const early = controller.match(/function tickIntegrityEarly\(e\) \{[\s\S]*?\n\}/)?.[0] ?? "";
  assert.doesNotMatch(early, /meleePulse/);
  assert.doesNotMatch(early, /health|currentValue|0\.5|0\.4/);
  assert.doesNotMatch(early, /y: e\.location\.y \+ 0\.08/);
});

test("Phase 3 idle behavior includes the source Noop melee window", async () => {
  const runtime = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/phase3_runtime.js");
  assert.match(runtime, /NOOP/);
  assert.match(runtime, /NoopAttack|NOOP.*melee|noop.*melee/i);
  assert.match(runtime, /5/);
  assert.match(runtime, /4/);
});

test("Integrity cleanup documents engine-limited Java behavior", async () => {
  const runtime = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/integrity_runtime.js");
  assert.match(runtime, /custom camera|camera override|engine gap/i);
  assert.match(runtime, /music|packet/i);
  assert.match(runtime, /owner/i);
  assert.match(runtime, /AABB|bounding|contact/i);
});
