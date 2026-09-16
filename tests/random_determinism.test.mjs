import assert from "node:assert/strict";
import test from "node:test";

import {
  chance,
  chancePercent,
  intBetween,
  pick,
  weightedPick,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/random.js";
import {
  SOURCE_EVENT_DEFINITIONS,
  selectWeightedEvent,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_rules.js";

const justBelowOne = () => 1 - Number.EPSILON;

test("random helpers preserve inclusive integer and strict probability boundaries", () => {
  assert.equal(intBetween(-2, 2, () => 0), -2);
  assert.equal(intBetween(-2, 2, justBelowOne), 2);
  assert.equal(chance(0, () => 0), false);
  assert.equal(chance(1, justBelowOne), true);
  assert.equal(chancePercent(0, () => 0), false);
  assert.equal(chancePercent(100, justBelowOne), true);
  assert.equal(pick(["first", "middle", "last"], justBelowOne), "last");
});

test("weighted random helpers consume the injected source exactly once", () => {
  const rolls = [];
  const result = weightedPick(
    [{ value: "a", weight: 1 }, { value: "b", weight: 3 }],
    () => {
      rolls.push("roll");
      return 0.5;
    },
  );

  assert.equal(result, "b");
  assert.deepEqual(rolls, ["roll"]);
});

test("event selection filters invalid candidates before applying the ordered weighted roll", () => {
  const candidates = [
    { id: "negative", weight: -1 },
    { id: "first", weight: 1 },
    { id: "second", weight: 1 },
  ];

  assert.equal(selectWeightedEvent(candidates, {}, 0)?.id, "first");
  assert.equal(selectWeightedEvent(candidates, {}, 0.499999)?.id, "first");
  assert.equal(selectWeightedEvent(candidates, {}, 0.500001)?.id, "second");
  const sourceOrder = SOURCE_EVENT_DEFINITIONS.filter(
    (event) => event.id === "moon_phase" || event.id === "heartbeat",
  );
  assert.equal(selectWeightedEvent(sourceOrder, { moon_phase: 2 }, 0.5)?.id, "moon_phase");
});
