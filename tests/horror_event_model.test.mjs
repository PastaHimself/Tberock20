import test from "node:test";
import assert from "node:assert/strict";
import {
  BASE_EVENT_FREQUENCY,
  EVENT_CONTRACTS,
  SOURCE_EVENT_IDS,
  eventCurveTicks,
  sourceEventFrequency,
  chooseRandomPlayer,
  weightedPick,
  pickValidEvent,
  normalizeEventUseCounts,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/shared/horror_event_model.js";

test("source event curve preserves the Java quadratic/logarithmic cap", () => {
  assert.equal(SOURCE_EVENT_IDS.length, 86);
  assert.equal(EVENT_CONTRACTS.length, 86);
  assert.equal(eventCurveTicks(0), 0);
  assert.ok(eventCurveTicks(55 * 24000) > 2);
  assert.equal(eventCurveTicks(1000000000), 7);
  assert.equal(sourceEventFrequency(0), 0);
  assert.equal(sourceEventFrequency(1000000000), BASE_EVENT_FREQUENCY);
});

test("player selection is one-player random selection", () => {
  const players = ["a", "b", "c"];
  assert.equal(chooseRandomPlayer(players, () => 0), "a");
  assert.equal(chooseRandomPlayer(players, () => 0.99), "c");
  assert.equal(chooseRandomPlayer([], () => 0), undefined);
});

test("weighted selection uses inverse times-used scores", () => {
  const entries = [{ id: "fresh", weight: 1 }, { id: "used", weight: 1 }];
  assert.equal(weightedPick(entries, { fresh: 1, used: 10 }, () => 0), "fresh");
  assert.equal(weightedPick([{ id: "a", weight: 0 }, { id: "b", weight: 0 }], {}, () => 0.99).id, "b");
});

test("invalid candidates reroll without consuming their use count", () => {
  const entries = [{ id: "bad", weight: 1 }, { id: "good", weight: 1 }];
  const randomValues = [0, 0.99];
  const result = pickValidEvent(entries, {}, () => randomValues.shift() ?? 0, (entry) => entry.id === "good", 2);
  assert.equal(result.entry.id, "good");
  assert.equal(result.attempts, 2);
  assert.equal(result.useCounts.bad, 0);
  assert.equal(result.useCounts.good, 1);
});

test("use-count persistence is normalized to registered bounded integer keys", () => {
  const normalized = normalizeEventUseCounts({ bsod: 2.8, unknown: 99, damage: -5 }, SOURCE_EVENT_IDS, 10);
  assert.equal(normalized.bsod, 2);
  assert.equal(normalized.damage, 0);
  assert.equal(normalized.unknown, undefined);
  assert.equal(Object.keys(normalized).length, 86);
});
