import test from "node:test";
import assert from "node:assert/strict";
import { enforceHeartCorruptionHealthCap } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/status_effect_runtime.js";

test("Heart Corruption clamps health through the documented health component", () => {
  const calls = [];
  const player = {
    getComponent(id) {
      assert.equal(id, "minecraft:health");
      return {
        effectiveMax: 20,
        currentValue: 20,
        setCurrentValue(value) {
          calls.push(value);
          return true;
        },
      };
    },
  };

  assert.equal(enforceHeartCorruptionHealthCap(player), true);
  assert.deepEqual(calls, [19]);
});

test("health already below the Heart Corruption cap is not damaged", () => {
  let writes = 0;
  const player = {
    getComponent() {
      return {
        effectiveMax: 20,
        currentValue: 10,
        setCurrentValue() {
          writes += 1;
        },
      };
    },
  };

  assert.equal(enforceHeartCorruptionHealthCap(player), false);
  assert.equal(writes, 0);
});

test("missing or failing health components are contained", () => {
  assert.equal(enforceHeartCorruptionHealthCap(null), false);
  assert.equal(enforceHeartCorruptionHealthCap({ getComponent: () => undefined }), false);
  assert.equal(
    enforceHeartCorruptionHealthCap({
      getComponent: () => ({
        effectiveMax: 20,
        currentValue: 20,
        setCurrentValue: () => { throw new Error("unloaded"); },
      }),
    }),
    false,
  );
});
