import assert from "node:assert/strict";
import test from "node:test";

import {
  stepAmbientCounter,
  stepNaturalDespawn,
  TBE_SOURCE,
  tbeMeleeBoxIntersects,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/tbe/tbe_source_model.js";

test("TBE natural despawn pauses without a ServerPlayer target", () => {
  assert.equal(TBE_SOURCE.naturalDespawnTicks, 1000);
  assert.deepEqual(stepNaturalDespawn(1000, false), {
    life: 1000,
    expired: false,
    reputationDelta: 0,
  });
});

test("TBE natural expiry grants source GAIN_MEDIUM only at exact zero", () => {
  assert.deepEqual(stepNaturalDespawn(2, true), {
    life: 1,
    expired: false,
    reputationDelta: 0,
  });
  assert.deepEqual(stepNaturalDespawn(1, true), {
    life: 0,
    expired: true,
    reputationDelta: 25,
  });
});

test("TBE ambient counter advances independently of target state", () => {
  assert.deepEqual(stepAmbientCounter(149), { counter: 150, pulse: false });
  assert.deepEqual(stepAmbientCounter(150), { counter: 0, pulse: true });
});

test("TBE melee preserves the Java expanded contact box and 20-tick 600-damage contract", () => {
  assert.equal(TBE_SOURCE.attackDamage, 600);
  assert.equal(TBE_SOURCE.attackCooldownTicks, 20);
  assert.equal(tbeMeleeBoxIntersects({ x: 0, y: 64, z: 0 }, { x: 1.79, y: 64, z: 0 }), true);
  assert.equal(tbeMeleeBoxIntersects({ x: 0, y: 64, z: 0 }, { x: 1.8, y: 64, z: 0 }), false);
  assert.equal(tbeMeleeBoxIntersects({ x: 0, y: 64, z: 0 }, { x: 0, y: 95.3, z: 0 }), false);
});
