import { readFile } from "node:fs/promises";
import test from "node:test";
import assert from "node:assert/strict";

import {
  MAX_BOOK_ID,
  assignBookId,
  normalizeBook,
  pageAt,
  pageBack,
  pageForward,
  selectAvailableBookId,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/library_book_model.js";
import { getLibraryBook, LIBRARY_BOOK_IDS } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/library_book_data.js";

test("library books preserve a valid source id and assign new ids in the source range", () => {
  assert.equal(MAX_BOOK_ID, 251);
  assert.equal(assignBookId(44, 0.99), 44);
  assert.equal(assignBookId(undefined, 0), 1);
  assert.equal(assignBookId(undefined, 0.999999), 250);
});

test("library reader falls back to a recovered book when the source id has no payload", () => {
  assert.equal(selectAvailableBookId(44, 0.9, [1, 44]), 44);
  assert.equal(selectAvailableBookId(250, 0, [1, 44]), 1);
  assert.equal(selectAvailableBookId(250, 0.9999, [1, 44]), 44);
});

test("library book pages are one-based and missing pages render empty", () => {
  const book = normalizeBook({ author: "Dev", pages: ["first", "second"] });

  assert.equal(book.author, "Dev");
  assert.equal(pageAt(book, 1), "first");
  assert.equal(pageAt(book, 2), "second");
  assert.equal(pageAt(book, 0), "");
  assert.equal(pageAt(book, 3), "");
});

test("library reader pagination stays within the source book bounds", () => {
  assert.equal(pageForward(0, 3), 1);
  assert.equal(pageForward(2, 3), 2);
  assert.equal(pageBack(2), 1);
  assert.equal(pageBack(0), 0);
});

test("all recovered library book payloads are available to the runtime", () => {
  assert.equal(LIBRARY_BOOK_IDS.length, 44);
  assert.deepEqual(LIBRARY_BOOK_IDS.slice(0, 3), [1, 2, 3]);
  assert.equal(getLibraryBook(1).author, "tekkitdooood");
  assert.ok(getLibraryBook(1).pages.length > 0);
  assert.deepEqual(getLibraryBook(250), { author: "", pages: [] });
});

test("the book item exposes the source use component", async () => {
  const item = JSON.parse(await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/items/book.json",
    import.meta.url,
  ), "utf8"));
  assert.equal(item["minecraft:item"].components["thebrokenscript:library_book_use"], true);
});
