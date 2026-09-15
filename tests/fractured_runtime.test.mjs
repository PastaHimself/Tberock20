import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";

const runtimePath = new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/fractured_runtime.js", import.meta.url);
const mainPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js", import.meta.url);
const bossControllerPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js", import.meta.url);
const fracturedPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/entities/fractured.json", import.meta.url);
const rockPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/entities/rock.json", import.meta.url);
const particlePath = new URL("../TheBrokenScript_Bedrock_2_0/RP/particles/moon_stone_block_burst.particle.json", import.meta.url);
const adaptationNotesPath = new URL("../TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md", import.meta.url);
const limitationsPath = new URL("../TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md", import.meta.url);

test("Jimmy and Rock are owned by the dedicated runtime families", async () => {
  const fractured = JSON.parse(await readFile(fracturedPath, "utf8"));
  const rock = JSON.parse(await readFile(rockPath, "utf8"));
  assert.deepEqual(fractured["minecraft:entity"].components["minecraft:type_family"].family, [
    "thebrokenscript_fractured_runtime", "monster", "mob",
  ]);
  assert.deepEqual(rock["minecraft:entity"].components["minecraft:type_family"].family, [
    "thebrokenscript_fractured_rock_runtime", "monster", "mob",
  ]);
  assert.equal(fractured["minecraft:entity"].components["minecraft:type_family"].family.includes("thebrokenscript_boss"), false);
  assert.equal(rock["minecraft:entity"].components["minecraft:type_family"].family.includes("thebrokenscript_boss"), false);
  assert.equal("minecraft:projectile" in rock["minecraft:entity"].components, false);
});

test("main wires the dedicated runtime and the generic boss loop releases Jimmy ownership", async () => {
  const main = await readFile(mainPath, "utf8");
  const bossController = await readFile(bossControllerPath, "utf8");
  assert.match(main, /fracturedRuntime\.begin\(scheduler\)/);
  assert.match(main, /fractured_runtime\.js/);
  assert.doesNotMatch(bossController, /case "thebrokenscript:fractured":\s*return tickFractured/);
  assert.doesNotMatch(bossController, /case "thebrokenscript:rock":\s*return tickRock/);
  assert.doesNotMatch(bossController, /function tickFractured\(e\)/);
  assert.doesNotMatch(bossController, /function tickRock\(e\)/);
});

test("runtime exposes one scheduler owner and one collision owner", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  assert.match(runtime, /scheduler\.every\("tbs\.fractured_runtime", 1, onTick\)/);
  assert.match(runtime, /getEntities\(\{ families: \[FRACTURED_FAMILY\] \}\)/);
  assert.match(runtime, /getEntities\(\{ families: \[ROCK_FAMILY\] \}\)/);
  assert.match(runtime, /applyProjectileDamage\(target, plan\.damage, state\.owner, rock, "thebrokenscript:rock"\)/);
  assert.match(runtime, /EquipmentSlot\.Chest/);
  assert.match(runtime, /EntityDamageCause\.projectile/);
  const rockImpactBody = runtime.match(/function rockHitTargets\([\s\S]*?\n\}/)?.[0] ?? "";
  assert.doesNotMatch(rockImpactBody, /\bbreak;/);
  assert.match(runtime, /fracturedRockImpactPlan/);
  assert.match(runtime, /fracturedAnimationEventPlan/);
  assert.match(runtime, /fracturedAnimationId/);
  assert.match(runtime, /fracturedPresentationAnimationId/);
  assert.match(runtime, /playFracturedPresentation/);
  assert.match(runtime, /playAnimation/);
  assert.doesNotMatch(runtime, /KEYFRAME_ADAPTER_TICKS/);
  assert.doesNotMatch(runtime, /\.applyKnockback\s*\([^)]*,[^)]*,[^)]*,[^)]*\)/);
});

test("runtime wires source rising parity, lifecycle state, and contact fallback", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  assert.match(runtime, /FRACTURED_RISING_SOURCE/);
  assert.match(runtime, /fracturedRisingStep/);
  assert.match(runtime, /fracturedRisingImpactPlan/);
  assert.match(runtime, /FRACTURED_RISING_SOURCE\.sourceId/);
  assert.match(runtime, /fracturedLifecycleStates/);
  assert.match(runtime, /resolveFracturedContactOrigin/);
  assert.match(runtime, /fracturedRoamTargetRange/);
});

test("Jimmy parity documentation records the current Bedrock capability boundary", async () => {
  const notes = await readFile(adaptationNotesPath, "utf8");
  const limitations = await readFile(limitationsPath, "utf8");
  const text = `${notes}\n${limitations}`;
  assert.match(text, /EntityHurtBeforeEvent/);
  assert.match(text, /rendered bone|locator/i);
  assert.match(text, /continuous projectile sweep|swept/i);
  assert.match(text, /ordinary melee|melee hit/i);
});

test("Rock block impact is wired to the source-counted custom particle emitter", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  const particle = JSON.parse(await readFile(particlePath, "utf8"));
  assert.match(runtime, /spawnParticle\(burst\.effectId, burst\.origin\)/);
  assert.equal(particle.particle_effect.description.identifier, "thebrokenscript:moon_stone_block_burst");
  assert.equal(particle.particle_effect.components["minecraft:emitter_rate_instant"].num_particles, 400);
  assert.deepEqual(particle.particle_effect.components["minecraft:emitter_shape_point"].offset, [
    "Math.random(-15, 15)",
    "Math.random(-7.5, 7.5)",
    "Math.random(-15, 15)",
  ]);
  assert.deepEqual(particle.particle_effect.components["minecraft:emitter_shape_point"].direction, [0, 1, 0]);
  assert.equal(particle.particle_effect.components["minecraft:particle_initial_speed"], 2);
});

test("Fractured audio retains SoundInstance handles and stops arena music on reset", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  assert.match(runtime, /soundInstances: \[\]/);
  assert.match(runtime, /const instance = player\.playSound\(sound/);
  assert.match(runtime, /arena\.soundInstances\.push\(instance\)/);
  assert.match(runtime, /function stopArenaSounds\(arena\)/);
  assert.match(runtime, /instance\.stop\(\)/);
  assert.match(runtime, /stopArenaSounds\(arena\)/);
  assert.match(runtime, /ROAM_ARENA_SOURCE\.introSound/);
  assert.match(runtime, /jimmy\.spawn/);
  assert.match(runtime, /fracturedRoamArenaRosterStep/);
  assert.match(runtime, /playerNames/);
  assert.match(runtime, /soundStops/);
});
