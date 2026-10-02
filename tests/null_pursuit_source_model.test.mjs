import assert from "node:assert/strict";
import test from "node:test";

import {
  NULL_PURSUIT_SOURCE,
  invadeSeenOutcome,
  stepPursuitTimer,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_pursuit_source_model.js";

test("NullEndgame source radius, damage, and death reputation are retained", () => {
  assert.equal(NULL_PURSUIT_SOURCE.endgameRadius, 500);
  assert.equal(NULL_PURSUIT_SOURCE.endgameLifetimeTicks, 420);
  assert.equal(NULL_PURSUIT_SOURCE.endgameDamagePeriodTicks, 60);
  assert.equal(NULL_PURSUIT_SOURCE.endgameDamage, 999);
  assert.equal(NULL_PURSUIT_SOURCE.endgameDeathReputation, -50);
});

test("NullEndgame despawn timer pauses without a nearby target", () => {
  assert.deepEqual(stepPursuitTimer(420, 5, false), { timer: 420, expired: false });
  assert.deepEqual(stepPursuitTimer(5, 5, true), { timer: 0, expired: true });
});

test("NullInvade preserves exact 70 percent branch boundary and reputation tiers", () => {
  assert.equal(NULL_PURSUIT_SOURCE.invadeTriggerReputation, -10);
  assert.equal(NULL_PURSUIT_SOURCE.invadeTimeoutReputation, 15);
  assert.equal(invadeSeenOutcome(0.699999), "scare");
  assert.equal(invadeSeenOutcome(0.7), "chase");
});

test("NullUnbeatable attack damage matches source attribute", () => {
  assert.equal(NULL_PURSUIT_SOURCE.unbeatableAttackDamage, 313);
});
