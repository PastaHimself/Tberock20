import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import {
  REGAIN_HALF_BY_TIER,
  REPUTATION_TIER_AMOUNTS,
  integerHalfLostReputation,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_reputation_model.js";
import {
  BEDROCK_NIGHT_END,
  JAVA_NIGHT_START,
  isDayTime,
  isNightTime,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_time_model.js";
import {
  FRACTURED_SEGMENT_EPSILON,
  NORMALIZED_ROLL_UPPER_BOUND,
  clampNormalizedRoll,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/source_numeric_model.js";
import { selectWeightedEvent } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_rules.js";

const ROOT = new URL("../", import.meta.url);

async function text(relativePath) {
  return readFile(new URL(relativePath, ROOT), "utf8");
}

test("reputation model preserves Java integer-half parity for LOSS_HUGE", async () => {
  const repTier = await text("decompiled/net/thebrokenscript/util/RepTier.java");
  const repUtil = await text("decompiled/net/thebrokenscript/util/RepUtilKt.java");

  assert.match(repTier, /LOSS_HUGE = new RepTier\(-35\)/);
  assert.match(repUtil, /-\$lastTier\.getAmount\(\) \/ 2/);
  assert.equal(REPUTATION_TIER_AMOUNTS.LOSS_HUGE, -35);
  assert.equal(integerHalfLostReputation(REPUTATION_TIER_AMOUNTS.LOSS_HUGE), 17);
  assert.equal(REGAIN_HALF_BY_TIER.LOSS_HUGE, 17);
  assert.equal(REGAIN_HALF_BY_TIER.LOSS_TEENYTINY, 0);

  const runtime = await text("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_chat.js");
  assert.match(runtime, /horror_reputation_model\.js/);
  assert.doesNotMatch(runtime, /17\.5/);
});

test("time model distinguishes Java night start from the Bedrock adapter boundary", async () => {
  const timeOfDay = await text("decompiled_brokencore/net/thebrokenscript/brokencore/api/world/TimeOfDay.java");
  const runtime = await text("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js");

  assert.match(timeOfDay, /TICKS_PER_DAY = 24000/);
  assert.match(timeOfDay, /NIGHT = new TimeOfDay\(13000L\)/);
  assert.equal(JAVA_NIGHT_START, 13000);
  assert.equal(BEDROCK_NIGHT_END, 23000);
  assert.equal(isNightTime(13000), true);
  assert.equal(isNightTime(22999), true);
  assert.equal(isNightTime(23000), false);
  assert.equal(isDayTime(0), true);
  assert.equal(isDayTime(13000), false);
  assert.match(runtime, /horror_time_model\.js/);
  assert.doesNotMatch(runtime, /time >= 13000 && time < 23000/);
});

test("numeric adapter provenance keeps zero-delta and exclusive-roll boundaries explicit", async () => {
  assert.equal(FRACTURED_SEGMENT_EPSILON, 1e-9);
  assert.equal(NORMALIZED_ROLL_UPPER_BOUND, 0.999999999);
  assert.equal(clampNormalizedRoll(-1), 0);
  assert.equal(clampNormalizedRoll(1), NORMALIZED_ROLL_UPPER_BOUND);
  assert.equal(clampNormalizedRoll(Number.NaN), 0);

  const multipart = await text("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_multipart_model.js");
  const rules = await text("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_rules.js");
  assert.match(multipart, /source_numeric_model\.js/);
  assert.match(rules, /source_numeric_model\.js/);
  assert.doesNotMatch(multipart, /Math\.abs\(delta\) < 1e-9/);
  assert.doesNotMatch(rules, /0\.999999999/);

  const selected = selectWeightedEvent(
    [{ id: "first", weight: 1 }, { id: "last", weight: 1 }],
    {},
    1,
  );
  assert.equal(selected.id, "last");
});
