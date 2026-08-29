# Chunk 22 — VoidTentacle source SCALE adapter

## Delivered

- Added the persisted, client-synced `thebrokenscript:scale` property to `BP/entities/void_tentacle.json`.
- Added five event-selected `minecraft:scale` component groups for values 1 through 5.
- Updated `boss_controller.js` to read and set the property, trigger the matching visual event, and route fixed Phase 3 tentacles through scale 2.
- Added a regression covering the JSON contract and controller bridge.

## Validation

- `npm test`: **24 passed, 0 failed**.
- `node --check` passed for the changed JavaScript files.
- `void_tentacle.json` parsed successfully.
- GitHub Actions validation is run on the published commit and recorded in `VALIDATION_LOG.md` after completion.

## Remaining difference

Bedrock does not expose Java's mutable `Attributes.SCALE` or its renderer pipeline. The implementation preserves the source value's persistence, synchronization, behavior lookup, and visual application through Bedrock properties, events, and component groups. Exact Java attribute mutation remains documented in `ADAPTATION_NOTES.md` and `KNOWN_LIMITATIONS.md`.
