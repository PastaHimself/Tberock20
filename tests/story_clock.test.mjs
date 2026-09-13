import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";
import {
  STORY_EVENT_THRESHOLDS,
  evaluateStoryClockTick,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_clock_model.js";

const ROOT = new URL("../", import.meta.url);

async function source(path) {
  return readFile(new URL(path, ROOT), "utf8");
}

test("story clock gates processing on the daylight-cycle gamerule", async () => {
  const runtime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
  );

  assert.match(runtime, /world\.gameRules\.doDayLightCycle/);
  assert.match(
    runtime,
    /const doDayLightCycle = world\.gameRules\.doDayLightCycle;/,
  );
  assert.match(runtime, /if \(doDayLightCycle !== true\) \{\s*return;\s*\}/);
  assert.match(runtime, /evaluateStoryClockTick/);
  assert.match(runtime, /shouldDispatch/);
});

test("story clock keeps the Java online-player pause semantics", async () => {
  const runtime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
  );

  assert.match(runtime, /world\.getAllPlayers\(\)\.length/);
  assert.match(runtime, /evaluateStoryClockTick\(/);
  assert.match(runtime, /tick\.nextTime !== currentTime/);
  assert.match(runtime, /fire\(tick\.nextTime\);/);
});

test("deployed and authoring story clocks stay behaviorally aligned", async () => {
  const deployed = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
  );
  const authoring = await source(
    "TheBrokenScript_Bedrock_2_0/src/shared/story_time.js",
  );
  assert.equal(authoring, deployed);
});

test("story clock model pauses, resumes, and dispatches like Java", () => {
  assert.deepEqual(evaluateStoryClockTick(100, 0, true), {
    nextTime: 100,
    shouldDispatch: true,
  });
  assert.deepEqual(evaluateStoryClockTick(100, 1, true), {
    nextTime: 101,
    shouldDispatch: true,
  });
  assert.deepEqual(evaluateStoryClockTick(100, 1, false), {
    nextTime: 100,
    shouldDispatch: false,
  });
});

test("story threshold model keeps chronological ordering and exact offsets", () => {
  assert.deepEqual(
    STORY_EVENT_THRESHOLDS.map(({ eventId, threshold }) => [eventId, threshold]),
    [
      ["txt_story_5", 121000],
      ["coords_hint_6", 145000],
      ["txt_story_10", 241000],
      ["null_book_hint", 289000],
      ["txt_story_15", 361000],
      ["txt_story_20", 481000],
      ["moon_corruption_24", 577000],
      ["moon_corruption_32", 769000],
      ["moon_corruption_38", 913000],
      ["moon_corruption_48", 1153000],
    ],
  );
});

test("story thresholds preserve every Java day and tick offset", async () => {
  const runtime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_events.js",
  );
  const clockRuntime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
  );
  assert.match(runtime, /STORY_EVENT_THRESHOLDS/);
  assert.match(
    runtime,
    /for \(const \{ eventId, threshold \} of STORY_EVENT_THRESHOLDS\)/,
  );
  assert.match(runtime, /registerThreshold\(threshold, eventId/);
  assert.match(clockRuntime, /thresholds\.get\(time\)/);
});

test("deployed story events use the source-backed threshold schedule", async () => {
  const runtime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_events.js",
  );

  assert.match(runtime, /STORY_EVENT_THRESHOLDS/);
  assert.match(runtime, /for \(const \{ eventId, threshold \} of STORY_EVENT_THRESHOLDS\)/);
});

test("threshold model remains anchored to every Java story event", async () => {
  const sourceContracts = [
    [
      "decompiled/net/thebrokenscript/events/story/TXTStoryEvent.java",
      [5, 10, 15, 20],
    ],
    [
      "decompiled/net/thebrokenscript/events/story/CoordsStoryEvent.java",
      [6],
    ],
    [
      "decompiled/net/thebrokenscript/events/story/NullBookStoryEvent.java",
      [12],
    ],
    [
      "decompiled/net/thebrokenscript/events/story/MoonCorruptionStoryEvent.java",
      [24, 32, 38, 48],
    ],
  ];

  for (const [path, days] of sourceContracts) {
    const runtime = await source(path);
    for (const day of days) {
      assert.match(runtime, new RegExp(`Time\\.INSTANCE\\.days\\(${day}\\) \\+ 1000`));
    }
  }
});
