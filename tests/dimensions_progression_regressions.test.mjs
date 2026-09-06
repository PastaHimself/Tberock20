import assert from "node:assert/strict";
import test from "node:test";

import {
  CUSTOM_DIMENSION_IDS,
  CUSTOM_REALM_NAMES,
  isKnownDimensionId,
  normalizeDimensionId
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimension_ids.js";
import {
  hasPersistedAdvancement,
  persistAdvancement,
  progressionPropertyKey
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/progression_state.js";

test("custom dimension roster is namespaced, unique, and normalizes bare IDs", () => {
  assert.equal(CUSTOM_REALM_NAMES.length, 12);
  assert.equal(new Set(CUSTOM_DIMENSION_IDS).size, CUSTOM_DIMENSION_IDS.length);
  assert.deepEqual(
    CUSTOM_DIMENSION_IDS,
    CUSTOM_REALM_NAMES.map((name) => `thebrokenscript:${name}`)
  );

  assert.equal(normalizeDimensionId("overworld"), "overworld");
  assert.equal(normalizeDimensionId("minecraft:overworld"), "overworld");
  assert.equal(normalizeDimensionId("clan_void"), "thebrokenscript:clan_void");
  assert.equal(normalizeDimensionId("thebrokenscript:clan_void"), "thebrokenscript:clan_void");
  assert.equal(normalizeDimensionId("thebrokenscript:not_a_realm"), "");
  assert.equal(isKnownDimensionId("library"), true);
  assert.equal(isKnownDimensionId("minecraft:made_up"), false);
});

function fakePlayer(id) {
  const properties = new Map();
  return {
    id,
    getDynamicProperty(key) {
      return properties.get(key);
    },
    setDynamicProperty(key, value) {
      properties.set(key, value);
    }
  };
}

test("progression cache and persistence are isolated per player", () => {
  const cache = new Set();
  const a = fakePlayer("player-a");
  const b = fakePlayer("player-b");
  const advancement = "polaroid_craft";

  assert.equal(persistAdvancement(a, advancement, cache), true);
  assert.equal(persistAdvancement(a, advancement, cache), false);
  assert.equal(hasPersistedAdvancement(a, advancement, cache), true);

  assert.equal(hasPersistedAdvancement(b, advancement, cache), false);
  assert.equal(persistAdvancement(b, advancement, cache), true);
  assert.equal(persistAdvancement(b, advancement, cache), false);

  assert.equal(a.getDynamicProperty(progressionPropertyKey(advancement)), true);
  assert.equal(b.getDynamicProperty(progressionPropertyKey(advancement)), true);
});

test("persisted advancement survives a runtime cache reset", () => {
  const player = fakePlayer("player-a");
  const advancement = "can_you_see_me";
  const firstCache = new Set();

  assert.equal(persistAdvancement(player, advancement, firstCache), true);
  const reloadedCache = new Set();
  assert.equal(hasPersistedAdvancement(player, advancement, reloadedCache), true);
  assert.equal(reloadedCache.has(`player-a:${advancement}`), true);
  assert.equal(persistAdvancement(player, advancement, reloadedCache), false);
});
