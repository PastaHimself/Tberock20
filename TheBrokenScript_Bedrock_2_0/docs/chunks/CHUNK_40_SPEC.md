# Chunk 40 — Jukebox song record adapters

## Goal

Port the twelve source `TBSSongs` registrations to the existing Bedrock music
items with native `minecraft:record` components.

## Source contract

- Preserve each source sound event, duration, comparator output, and description.
- Keep the twelve music items non-stackable.
- Map record14, disc15.betray, disc16.youcant, disc17.silenced,
  instability variants, credits, Lilly themes, and Attribute Mutilation.

## Bedrock adapter

- Catalog all source values in `music_disc_model.js`.
- Add `minecraft:record` with the source duration and matching
  `RP/sound_definitions.json` key to each existing item.
- Add `minecraft:max_stack_size: 1` where the existing Bedrock item did not
  already declare it.
- Clamp Java comparator output 15 to Bedrock's documented maximum signal 13.

## Non-goals

Java `JukeboxSong` holder registration, exact comparator value 15, and Java's
network/music client helper remain engine-specific. The existing audio assets
and sound-definition entries are reused.

## Acceptance

- The model contains all twelve source songs with exact source durations and
  sound keys.
- Every item JSON parses and matches its model-backed record component.
- Every record sound key resolves to an existing Bedrock sound definition.
- Comparator clamp and non-stackable behavior are explicitly tested.
