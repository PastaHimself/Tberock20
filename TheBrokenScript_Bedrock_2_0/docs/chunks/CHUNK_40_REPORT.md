# Chunk 40 — Jukebox song record adapters

## Result

All twelve source jukebox-song definitions now map onto existing Bedrock music
items. Each item has a native `minecraft:record` component, source duration,
matching custom sound-definition key, and max stack size 1. The source comparator
output of 15 is represented by Bedrock's maximum supported signal 13.

## Source evidence

- `decompiled/net/thebrokenscript/registry/TBSSongs.java`
- `source_extracted/data/thebrokenscript/jukebox_song/*.json`
- Existing `RP/sound_definitions.json` and copied source `.ogg` assets

## Validation

- TDD RED: the music-disc model test failed before `music_disc_model.js` existed.
- TDD GREEN: focused model tests — **2/2 passed**.
- Integration assertions parse all twelve item files and confirm every
  sound-definition link, duration, component, and stack-size contract.
- Microsoft Learn and BedrockWiki confirm the `minecraft:record` component,
  including duration, comparator signal, and sound event fields.
- Bedrock world/runtime smoke testing remains unavailable locally; GitHub
  Actions is the authoritative pack/schema gate.

## Parity

Source song timing, sound links, item identities, descriptions, and non-stackable
behavior are preserved. The only documented difference is comparator signal
15→13 because Bedrock's record component caps the signal at 13.
