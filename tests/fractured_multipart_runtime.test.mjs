import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";

const runtimePath = new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/fractured_runtime.js", import.meta.url);
const bossControllerPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js", import.meta.url);
const fracturedPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/entities/fractured.json", import.meta.url);
const roamPath = new URL("../TheBrokenScript_Bedrock_2_0/BP/entities/fractured_roam.json", import.meta.url);

test("Jimmy runtime owns conceptual multipart hit routing and deferred arrow effects", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  assert.match(runtime, /multipartAabbs/);
  assert.match(runtime, /fracturedPartHitPlan/);
  assert.match(runtime, /partRole: matchedPart\?\.role/);
  assert.match(runtime, /roamState: roamLifecycle\?\.state/);
  assert.match(runtime, /roamRiseTicks/);
  assert.match(runtime, /\.find\(\(part\) => pointInsideAabb/);
  assert.match(runtime, /ROAM_SWITCH_TAG/);
  assert.match(runtime, /system\.run\(\(\) =>/);
  assert.match(runtime, /setOnFire/);
  assert.match(runtime, /"addEffect", "glowing"/);
  assert.doesNotMatch(runtime, /minecraft:projectile/);
  assert.match(runtime, /EntityDamageCause\.projectile/);
});

test("root collision envelopes cover source multipart extents while runtime filters the six logical parts", async () => {
  const fractured = JSON.parse(await readFile(fracturedPath, "utf8"));
  const roam = JSON.parse(await readFile(roamPath, "utf8"));
  for (const entity of [fractured, roam]) {
    assert.deepEqual(entity["minecraft:entity"].components["minecraft:collision_box"], {
      width: 105,
      height: 102,
    });
  }
});

test("generic boss ticking delegates Roam ownership to the dedicated runtime", async () => {
  const controller = await readFile(bossControllerPath, "utf8");
  assert.match(controller, /case "thebrokenscript:fractured_roam": return tickFracturedRoam\(e\)/);
  assert.match(controller, /dedicated runtime owns the source timers/);
});

test("dedicated runtime owns the source FracturedRoam host lifecycle and Arena handoff", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  assert.match(runtime, /fractured_roam_model\.js/);
  assert.match(runtime, /fracturedRoamServerTimerStep/);
  assert.match(runtime, /fracturedRoamBaseTick/);
  assert.match(runtime, /fracturedRoamDespawnStep/);
  assert.match(runtime, /fracturedRoamDigEligibility/);
  assert.match(runtime, /fracturedRoamArenaPlan/);
  assert.match(runtime, /arenaStartMusicTicks/);
  assert.match(runtime, /arenaSubAnomalyCount/);
  assert.match(runtime, /spawnArenaSubAnomalies/);
  assert.match(runtime, /thebrokenscript:sub_anomaly_2/);
  assert.match(runtime, /runTimeout/);
  assert.match(runtime, /ROAM_ARENA_SOURCE\.introSound/);
  assert.match(runtime, /ROAM_ARENA_SOURCE\.loopSound/);
});

test("generic boss ticking no longer fabricates a below-half-health Roam promotion", async () => {
  const controller = await readFile(bossControllerPath, "utf8");
  assert.doesNotMatch(controller, /damaged below half/);
  assert.doesNotMatch(controller, /getHealth\(e\) < maxHealth\(e\) \* 0\.5/);
});
