import { readFile } from "node:fs/promises";
import test from "node:test";
import assert from "node:assert/strict";

import {
  DEFAULT_EVENT_FREQUENCY,
  aggregateEventFrequency,
  pickEvent,
  sourceEventFrequency,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/event_scheduler_model.js";

test("source event frequency starts at zero and follows the 55-day curve", () => {
  assert.equal(aggregateEventFrequency(0), 0);
  assert.equal(sourceEventFrequency(0), -DEFAULT_EVENT_FREQUENCY);
  assert.ok(aggregateEventFrequency(55 * 24000) > 0);
  assert.ok(aggregateEventFrequency(70 * 24000) > aggregateEventFrequency(55 * 24000));
  assert.equal(aggregateEventFrequency(1_000_000 * 24000), 7 / 24000);
});

test("weighted selection uses persistent inverse occurrence weights and skips disabled ids", () => {
  const result = pickEvent(
    [
      { id: "common", weight: 3 },
      { id: "rare", weight: 1 },
      { id: "disabled", weight: 100 },
    ],
    {
      rolls: [0.76],
      counts: { common: 1, rare: 1 },
      disabledEventIds: ["disabled"],
    },
  );

  assert.equal(result.event.id, "rare");
  assert.deepEqual(result.counts, { common: 1, rare: 2 });
  assert.equal(result.attempts, 1);
});

test("rerolling retries invalid events, while disabled rerolling returns no event", () => {
  const events = [
    { id: "blocked", weight: 1 },
    { id: "allowed", weight: 1 },
  ];
  const canExecute = (event) => event.id === "allowed";

  const rerolled = pickEvent(events, {
    rolls: [0, 0.75],
    canExecute,
    rerollEvents: true,
  });
  assert.equal(rerolled.event.id, "allowed");
  assert.equal(rerolled.attempts, 2);
  assert.deepEqual(rerolled.counts, { allowed: 2 });

  const stopped = pickEvent(events, {
    rolls: [0],
    canExecute,
    rerollEvents: false,
  });
  assert.equal(stopped.event, null);
  assert.deepEqual(stopped.counts, {});
});


test("wires the source scheduler contract into the Bedrock runtime", async () => {
  const runtime = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js",
    import.meta.url,
  ), "utf8");
  assert.ok(runtime.includes("aggregateEventFrequency"));
  assert.ok(runtime.includes("pickEvent(EVENT_DEFINITIONS"));
  assert.ok(runtime.includes("world[\"getAbsoluteTime\"]"));
  assert.ok(runtime.includes("scheduler.every(\"tbs.horror_events\", 1, tick)"));
  assert.ok(runtime.includes("setDisabledEvents"));

  const defaults = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/config_defaults.js",
    import.meta.url,
  ), "utf8");
  assert.ok(defaults.includes("events.enableRandomEvents"));
  assert.ok(defaults.includes("events.rerollEvents"));
  assert.ok(defaults.includes("events.eventDebug"));
});
