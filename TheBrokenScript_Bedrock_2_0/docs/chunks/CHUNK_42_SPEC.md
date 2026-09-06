# Chunk 42 — Source-registered horror event adapters

## Goal

Complete the source-registered horror-event boundary by adding the seven IDs that were present in TBSEvents.java but absent from the Bedrock ambient table.

## Source contract

- null_book: create the Null book and include the coordinate page 50% of the time.
- null_interface_trigger: uniformly select NullInterface 1, 2, or 3.
- obfuscated_sign: choose obfuscatedsign at 70% and ciphersign at 30%.
- noop: execute no player-visible action.
- text: choose from the source's 16 TextEvent messages.
- title_event: preserve the 90% outer, 90% inner, and 50% final branches.
- aberration: enable aberration and set its timer to 1200 ticks.

## Bedrock adapter

- Keep the source contracts in horror_event_model.js for deterministic tests.
- Add all seven handlers and table entries to horror_events.js.
- Reuse the existing Null book adapter and make its optional coordinate page explicit.
- Map custom Null menus and native desktop title changes to in-game title fallbacks.
- Preserve the two structure-choice branches and use an explicit local oak-sign fallback because the source NBT structures are not current Bedrock assets.
- Persist Aberration's source state through player_state.

## Non-goals

Exact RandomEvent weighting/config/day scheduling, Java custom GUI screens, native desktop window-title changes, and runtime placement of the source obfuscated/cipher NBT structures remain engine/deferred boundaries.

## Acceptance

- All seven IDs appear in both the handler map and ambient table.
- The pure model covers the source timer, message pool, title branches, interface selection, and structure choice.
- The Null book adapter can represent both one-page and two-page outcomes.
- Focused regressions and the complete GitHub Actions workflow pass.
