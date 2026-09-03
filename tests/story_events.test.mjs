import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import {
  NULL_BOOK_PAGE1,
  NULL_BOOK_STORY_TICKS,
  nullBookCoordinate,
  nullBookPages,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_book_model.js";

const root = new URL("../TheBrokenScript_Bedrock_2_0/", import.meta.url);

async function source(path) {
  return readFile(new URL(path, root), "utf8");
}

test("NullBookStoryEvent preserves its day-12 story threshold and source page text", () => {
  assert.equal(NULL_BOOK_STORY_TICKS, 24000 * 12 + 1000);
  assert.equal(
    NULL_BOOK_PAGE1,
    "§0null.err.object.err.null.object.alone.3.not.behind.entitytype:player.receiveddata.invalid.reboot.failed.reset.playerdata:00F9219492D94210F812",
  );
});

test("null-book coordinates use Java floorDiv chunk centers and signed binary", () => {
  assert.equal(nullBookCoordinate(160), "10101000");
  assert.equal(nullBookCoordinate(-1), "-1000");
  assert.equal(nullBookCoordinate(2147483647), "?");
});

test("null-book pages preserve the source layout and Y coordinate", () => {
  assert.deepEqual(nullBookPages(160, -1), [
    NULL_BOOK_PAGE1,
    "X:\n10101000\n\nY:\n201\n\nZ:\n-1000\n\nCV",
  ]);
});

test("story runtime creates and distributes a signed written book", async () => {
  const runtime = await source("BP/scripts/systems/story_events.js");
  assert.match(runtime, /registerThreshold\(DAY \* 12 \+ OFFSET, "null_book_hint", onNullBook\)/);
  assert.match(runtime, /new ItemStack\("minecraft:writable_book", 1\)/);
  assert.match(runtime, /getComponent\("minecraft:book"\)/);
  assert.match(runtime, /book\.setContents\(nullBookPages\(/);
  assert.match(runtime, /book\.signBook\("null", "null"\)/);
  assert.match(runtime, /container\.addItem\(item\)/);
  assert.doesNotMatch(runtime, /sendMessage\("§8\[null\]/);
});
