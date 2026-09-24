import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import {
  BAN_FOLLOWUP_CHANCE,
  captureBanSpawnContext,
  shouldSummonBan,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/tbe/tbe_kill_followup_model.js";

test("TBE BAN follow-up preserves the source 50 percent threshold", () => {
  assert.equal(BAN_FOLLOWUP_CHANCE, 0.5);
  assert.equal(shouldSummonBan(0), true);
  assert.equal(shouldSummonBan(0.499999), true);
  assert.equal(shouldSummonBan(0.5), false);
  assert.equal(shouldSummonBan(0.999999), false);
});

test("TBE BAN follow-up rejects invalid RNG values", () => {
  for (const value of [-0.1, 1, Number.NaN, Number.POSITIVE_INFINITY]) {
    assert.throws(() => shouldSummonBan(value), /randomValue/);
  }
});

test("BAN spawn context survives removal-time location mutation", () => {
  const dimension = { id: "minecraft:overworld" };
  const sourceLocation = { x: 10.5, y: 64, z: -3.25 };
  const snapshot = captureBanSpawnContext(dimension, sourceLocation);

  sourceLocation.x = 999;
  sourceLocation.y = -64;

  assert.equal(snapshot.dimension, dimension);
  assert.deepEqual(snapshot.location, { x: 10.5, y: 64, z: -3.25 });
});

test("the existing BAN entity is summonable under the expected identifier", async () => {
  const text = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/entities/ban.json",
    import.meta.url,
  ), "utf8");
  const entity = JSON.parse(text);
  const description = entity["minecraft:entity"].description;

  assert.equal(description.identifier, "thebrokenscript:ban");
  assert.equal(description.is_spawnable, true);
  assert.equal(description.is_summonable, true);
});
