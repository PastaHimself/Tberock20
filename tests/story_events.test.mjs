import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import {
  NULL_BOOK_PAGE1,
  NULL_BOOK_STORY_TICKS,
  nullBookCoordinate,
  nullBookPages,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_book_model.js";
import {
  createSignedNullBook,
  distributeNullBook,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_book_adapter.js";

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
  assert.equal(nullBookCoordinate(2147483647), "1111111111111111111111111111000");
});

test("null-book pages preserve the source layout and Y coordinate", () => {
  assert.deepEqual(nullBookPages(160, -1), [
    NULL_BOOK_PAGE1,
    "X:\n10101000\n\nY:\n201\n\nZ:\n-1000\n\nCV",
  ]);
});

test("book adapter builds signed pages and gives each player an independent stack", () => {
  class FakeItemStack {
    constructor(typeId, amount) {
      this.typeId = typeId;
      this.amount = amount;
      this.pages = null;
      this.signature = null;
    }

    getComponent(componentId) {
      if (componentId !== "minecraft:book") return undefined;
      return {
        setContents: (pages) => { this.pages = pages; },
        signBook: (title, author) => { this.signature = { title, author }; },
      };
    }

    clone() {
      const copy = new FakeItemStack(this.typeId, this.amount);
      copy.pages = this.pages;
      copy.signature = this.signature;
      return copy;
    }
  }

  const item = createSignedNullBook(FakeItemStack, 160, -1);
  assert.equal(item.typeId, "minecraft:writable_book");
  assert.deepEqual(item.pages, nullBookPages(160, -1));
  assert.deepEqual(item.signature, { title: "null", author: "null" });

  const onePageBook = createSignedNullBook(FakeItemStack, 160, -1, false);
  assert.deepEqual(onePageBook.pages, [NULL_BOOK_PAGE1]);

  const players = [
    { added: [], addItem(stack) { this.added.push(stack); return undefined; } },
    { added: [], addItem(stack) { this.added.push(stack); return undefined; } },
  ];
  assert.equal(distributeNullBook(players[0], item), true);
  assert.equal(distributeNullBook(players[1], item), true);
  assert.equal(players[0].added.length, 1);
  assert.equal(players[1].added.length, 1);
  assert.notEqual(players[0].added[0], item);
  assert.notEqual(players[0].added[0], players[1].added[0]);
});

test("book adapter drops a leftover stack when a player's inventory is full", () => {
  const leftover = { typeId: "minecraft:written_book", amount: 1 };
  const drops = [];
  const player = {
    addItem() { return leftover; },
    dimension: { spawnItem(stack, location) { drops.push({ stack, location }); } },
    location: { x: 1, y: 2, z: 3 },
  };
  const item = { clone: () => ({ typeId: "minecraft:written_book", amount: 1 }) };

  assert.equal(distributeNullBook(player, item), true);
  assert.deepEqual(drops, [{ stack: leftover, location: player.location }]);
});

test("story runtime creates and distributes a signed written book", async () => {
  const runtime = await source("BP/scripts/systems/story_events.js");
  assert.match(runtime, /registerThreshold\(DAY \* 12 \+ OFFSET, "null_book_hint", onNullBook\)/);
  assert.match(runtime, /createSignedNullBook\(\s*ItemStack/);
  assert.match(runtime, /distributeNullBook\(player, item\)/);
  assert.match(runtime, /system\.runTimeout/);
  assert.match(runtime, /logger\.error/);
  assert.doesNotMatch(runtime, /sendMessage\("§8\[null\]/);
});

test("world-state initialization checks the key it persists", async () => {
  const state = await source("BP/scripts/systems/world_state.js");
  assert.match(state, /getWorld\("mv\.dataVersion", undefined\)/);
  assert.doesNotMatch(state, /getWorld\("mapVarsDataVersion", undefined\)/);
});
