# Chunk 38 — NullBookStoryEvent written-book adapter

## Result

The story runtime now ports `NullBookStoryEvent` as a signed written book at
the source day-12-plus-1000 threshold. The pure story-book model preserves the
source null text, chunk-centered binary X/Z coordinates, literal Y=201, and
two-page layout. The runtime fills the Bedrock `ItemBookComponent`, signs the
book as `null`/`null`, and distributes it to every online player's inventory.

The earlier chat/title approximation was removed so the story stage has one
player-visible delivery path, matching the source event.

## Source evidence

- `decompiled/net/thebrokenscript/registry/TBSStoryEvents.java`
- `decompiled/net/thebrokenscript/events/story/NullBookStoryEvent.java`
- `TBSLang.NULL_BOOK_CONTENT` in the extracted language registry

## Validation

- TDD RED: the new story-book test failed before the model existed.
- TDD GREEN: `node --test tests/story_events.test.mjs` — **4/4 passed**.
- Full local suite: `node --test tests/*.test.mjs` — **64/64 passed**.
- Changed story modules pass `node --check`.
- Microsoft Learn documents `ItemStack`, `ItemStack.getComponent`,
  `ItemBookComponent.setContents`, and `ItemBookComponent.signBook` for the
  target `@minecraft/server` beta dependency.
- Bedrock world/runtime smoke testing remains unavailable locally; GitHub
  Actions is the authoritative pack/schema gate.

## Parity

The story threshold, source page content/layout, coordinate encoding, signed
book metadata, and online-player delivery are now represented. Bedrock uses the
supported book component API in place of Java's `WrittenBookContent` data
component, and inventory overflow remains a container adapter detail.
