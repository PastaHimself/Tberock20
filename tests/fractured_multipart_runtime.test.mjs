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

test("generic roam drift pauses while the source SWITCHING adapter owns the entity", async () => {
  const controller = await readFile(bossControllerPath, "utf8");
  assert.match(controller, /fractured_roam_switching/);
});
