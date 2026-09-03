import test from "node:test";
import assert from "node:assert/strict";
import {
  SOURCE_STATUS_EFFECTS,
  heartCorruptionHealthCap,
  isStatusEffectActive,
  refreshStatusEffectExpiry,
  statusEffectDefinition,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/status_effect_model.js";

test("custom effect definitions preserve the recovered Java contracts", () => {
  assert.deepEqual(SOURCE_STATUS_EFFECTS, {
    heart_corruption: {
      identifier: "thebrokenscript:heart_corruption",
      category: "harmful",
      color: 0xff00ff,
      maxHealthDelta: -1,
      shouldApplyEffectTick: true,
      appliesTickDamage: false,
    },
    why_cant_you_leave: {
      identifier: "thebrokenscript:why_cant_you_leave",
      category: "neutral",
      color: -16777216,
      durationTicks: 1000,
      amplifier: 0,
      ambient: true,
      visible: true,
      particleEffect: "thebrokenscript:eyes",
    },
  });
  assert.equal(statusEffectDefinition("heart_corruption").maxHealthDelta, -1);
  assert.throws(() => statusEffectDefinition("missing"), /Unknown source status effect/);
});

test("Heart Corruption caps current health at one below the effective maximum", () => {
  assert.equal(heartCorruptionHealthCap(20), 19);
  assert.equal(heartCorruptionHealthCap(1), 1);
  assert.equal(heartCorruptionHealthCap(0), 0);
});

test("effect expiry refreshes without shortening an active source effect", () => {
  assert.equal(refreshStatusEffectExpiry(300, 200, 50), 350);
  assert.equal(refreshStatusEffectExpiry(100, 80, 50), 150);
  assert.equal(isStatusEffectActive(300, 299), true);
  assert.equal(isStatusEffectActive(300, 300), false);
  assert.equal(isStatusEffectActive(0, 0), false);
});
