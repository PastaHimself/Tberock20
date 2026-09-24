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
- GitHub Actions run 72 ([Bedrock Add-on Check](https://github.com/PastaHimself/tbs-2.0/actions/runs/33260817900)) passed all validation, diagnostics, Creator Tools, packaging, and report-upload steps.

## Remaining difference

Bedrock does not expose Java's mutable `Attributes.SCALE` or its renderer pipeline. The implementation preserves the source value's persistence, synchronization, behavior lookup, and visual application through Bedrock properties, events, and component groups. Exact Java attribute mutation remains documented in `ADAPTATION_NOTES.md` and `KNOWN_LIMITATIONS.md`.
