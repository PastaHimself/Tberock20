# Chunk 42 — Source-registered horror event adapters

## Result

The Bedrock horror-event table now represents all 86 source-registered event IDs. Chunk 42 adds the seven IDs that were previously missing and keeps their portable source contracts in a pure model.

The runtime reuses the existing Null book adapter, including the source's optional coordinate page, persists Aberration's 1200-tick state, sends the exact 16-message TextEvent pool, and preserves the WindowTitle, NullInterface, and ObfuscatedSign branch contracts. Java-only menus, native desktop titles, and source NBT structure placement use explicit player-visible fallbacks.

## Source evidence

- decompiled/net/thebrokenscript/registry/TBSEvents.java
- decompiled/net/thebrokenscript/events/nullent/NullBookEvent.java
- decompiled/net/thebrokenscript/events/nullent/interfaces/NullInterfaceTriggerEvent.java
- decompiled/net/thebrokenscript/events/structures/ObfuscatedSignEvent.java
- decompiled/net/thebrokenscript/events/NoopEvent.java
- decompiled/net/thebrokenscript/events/misc/{TextEvent,WindowTitleEvent,AberrationEvent}.java
- decompiled/net/thebrokenscript/registry/TBSLang.java

## Validation

- Focused model/wiring regressions: 6/6 passed.
- Full local scratch regression suite: 12/12 passed.
- GitHub Actions [run 143](https://github.com/PastaHimself/tbs-2.0/actions/runs/33766550121) passed validators, JavaScript syntax, Bedrock beta type-check, regression tests, Blockception diagnostics, Creator Tools validation, packaging, and report upload.
- Bedrock world/runtime smoke testing remains unavailable locally.

## Parity

The source registrations and portable behavior branches are represented. The current Bedrock scheduler remains an ambient approximation, and the Java custom menus, desktop window-title hook, and obfuscated/cipher NBT structure assets remain engine-specific/deferred.
