# Chunk 38 — NullBookStoryEvent written-book adapter

## Result

The story runtime now ports `NullBookStoryEvent` as a signed written book at
the source day-12-plus-1000 threshold. The pure story-book model preserves the
source null text, chunk-centered binary X/Z coordinates, literal Y=201, and
two-page layout. The runtime fills the Bedrock `ItemBookComponent`, signs the
book as `null`/`null`, and distributes it to every online player's inventory.

The earlier chat/title approximation was removed so the story stage has one
player-visible delivery path, matching the source event.

The adapter preserves the Java result for `Integer.MAX_VALUE` coordinates,
clones the signed item per player, drops `addItem` leftovers at the player's
location, and retries transient creation/delivery failures with bounded logging.
The adjacent world-state initialization marker now checks `mv.dataVersion`, the
key it persists, so the null-book gate and Clan Void coordinates survive reload.

## Source evidence

- `decompiled/net/thebrokenscript/registry/TBSStoryEvents.java`
- `decompiled/net/thebrokenscript/events/story/NullBookStoryEvent.java`
- `TBSLang.NULL_BOOK_CONTENT` in the extracted language registry

## Validation

- TDD RED: the new story-book test failed before the model existed.
- TDD RED: the review follow-up test failed before the injectable adapter,
  exact sentinel conversion, and persistence-key fix existed.
- TDD GREEN: `node --test tests/story_events.test.mjs` — **7/7 passed**.
- Full local suite: `node --test tests/*.test.mjs` — **67/67 passed**.
- Changed story and state modules pass `node --check`.
- Microsoft Learn documents `ItemStack`, `ItemStack.getComponent`,
  `ItemBookComponent.setContents`, and `ItemBookComponent.signBook` for the
  target `@minecraft/server` beta dependency.
- Bedrock world/runtime smoke testing remains unavailable locally; GitHub
  Actions is the authoritative pack/schema gate.

## Parity

The story threshold, source page content/layout, coordinate encoding, signed
book metadata, reliable per-player delivery, and persistence gate are now
represented. Bedrock uses the supported book component API in place of Java's
`WrittenBookContent` data component; inventory overflow is surfaced as a dropped
item, and transient failures use a bounded retry adapter.

## CI follow-up

GitHub Actions run 128 passed repository-owned validation, syntax, beta API type-checking, JavaScript regressions, and Blockception diagnostics. Its only failure was Mojang Creator Tools reporting the identical bare beta version `2.11.0-beta` as “out of date” against `2.11.0-beta`; the existing self-comparison filter required a suffixed beta version and did not recognize this valid form. A focused regression and optional-suffix matcher fix were published in the follow-up commit; final CI validation is pending.
