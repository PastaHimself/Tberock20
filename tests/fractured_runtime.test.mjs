import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";

const runtimePath = new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/fractured_runtime.js", import.meta.url);
const mainPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/main.js", import.meta.url);
const bossControllerPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js", import.meta.url);
const fracturedPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/entities/fractured.json", import.meta.url);
const rockPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/entities/rock.json", import.meta.url);
const particlePath = new URL("../TheBrokenScript_Bedrock_2_0/RP/particles/moon_stone_block_burst.particle.json", import.meta.url);

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
  assert.match(runtime, /applyProjectileDamage\(target, plan\.damage, state\.owner, rock\)/);
  assert.match(runtime, /EquipmentSlot\.Chest/);
  assert.match(runtime, /EntityDamageCause\.projectile/);
  assert.match(runtime, /fracturedRockImpactPlan/);
  assert.match(runtime, /KEYFRAME_ADAPTER_TICKS/);
  assert.doesNotMatch(runtime, /\.applyKnockback\s*\([^)]*,[^)]*,[^)]*,[^)]*\)/);
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
