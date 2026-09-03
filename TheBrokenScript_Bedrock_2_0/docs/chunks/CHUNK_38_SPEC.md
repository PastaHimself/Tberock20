# Chunk 38 — NullBookStoryEvent written-book adapter

## Goal

Port the source `null_book_hint` story stage as a real signed written book,
including its source page layout and chunk-centered binary Clan Void
coordinates.

## Source contract

- `NullBookStoryEvent` fires at `Time.days(12) + 1000`.
- It creates a two-page `WrittenBookContent` titled `null` and authored by
  `null`, then gives the same book to every online player.
- Page one is `TBSLang.NULL_BOOK_CONTENT`.
- Page two renders `X`, `Y`, and `Z` labels plus `CV`; X/Z are computed as
  `Math.floorDiv(clanVoidCoordinate, 16) * 16 + 8` and encoded as signed binary,
  while Y is the literal `201`.
- `Integer.MAX_VALUE` is still encoded through the source arithmetic; it is not
  replaced with an invented placeholder.

## Bedrock adapter

- Keep the story threshold/retry lifecycle in `story_events.js`, model the page
  contract in the pure `story_book_model.js` module, and isolate item creation
  and delivery in the injectable `story_book_adapter.js` module.
- Create `minecraft:writable_book`, populate its `minecraft:book`
  `ItemBookComponent` with `setContents`, and call `signBook("null", "null")`.
- Give each online player an independent copy, drop any `addItem` remainder at
  the player's location, and retry/log transient creation or delivery failures
  without setting `nullBookGiven` prematurely.
- Persist the world-state initialization marker under the same `mv.dataVersion`
  key that the initializer writes.

## Non-goals

Java data-component/NBT installation, exact Java inventory serialization, and
custom font glyph replacement remain outside this chunk.

## Acceptance

- The day-12 threshold uses source event id `null_book_hint`.
- Coordinate and page-model regressions cover positive, negative, and unset
  coordinates.
- Runtime assertions cover the Bedrock book component, signing, and player
  distribution.
- Focused and full Node suites pass.
