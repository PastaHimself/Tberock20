import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import { existsSync } from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath, pathToFileURL } from "node:url";

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const sourceBooks = path.join(root, "source_extracted/assets/thebrokenscript/library_books");
const pageModule = path.join(root, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/library_book_pages.js");

test("every available Java library book page is readable from the Bedrock data", async () => {
  assert.equal(existsSync(pageModule), true, "shipped library book pages are missing");
  const { libraryBookPageView } = await import(pathToFileURL(pageModule));

  for (let id = 1; id <= 44; id++) {
    const { pages } = JSON.parse(await readFile(path.join(sourceBooks, `${id}.json`), "utf8"));
    for (let index = 0; index < pages.length; index++) {
      const view = libraryBookPageView(id, index);
      assert.equal(view.content, pages[index], `book ${id}, page ${index + 1}`);
      assert.equal(view.totalPages, pages.length);
    }
  }

  const absent = libraryBookPageView(45, 0);
  assert.equal(absent.content, "");
  assert.equal(absent.totalPages, 0);
});

test("book navigation has a previous and next page only when one exists", async () => {
  assert.equal(existsSync(pageModule), true, "shipped library book pages are missing");
  const { libraryBookPageView } = await import(pathToFileURL(pageModule));
  assert.deepEqual(libraryBookPageView(1, 0).buttons.map((button) => button.label), ["Next page", "Close"]);
  assert.deepEqual(libraryBookPageView(1, 1).buttons.map((button) => button.label), ["Previous page", "Next page", "Close"]);
  assert.deepEqual(libraryBookPageView(1, 22).buttons.map((button) => button.label), ["Previous page", "Close"]);
  assert.deepEqual(libraryBookPageView(45, 0).buttons.map((button) => button.label), ["Close"]);
});

test("library book use presents pages rather than placeholder text", async () => {
  const runtime = await readFile(path.join(root, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js"), "utf8");
  assert.match(runtime, /libraryBookPageView\(bookNumber, page\)/);
  assert.doesNotMatch(runtime, /full Java book screen is represented by this stable Bedrock form adapter/);
});
