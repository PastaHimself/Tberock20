# CHUNK_03_SPEC — Asset and Client-Resource Foundation

## Source basis (inspected formats)
- `sounds.json`: **143 sound events**, Java shape `{"evt": {"sounds": ["ns:path" | {"name","stream"}]}}` → Bedrock `sound_definitions.json` (format_version 1.14.0 wrapper; name = `sounds/<path>` relative to RP root, no extension; category map: tbs_ambience→ambient, music/records→music|record, else neutral)
- Textures: 502 png (+56 jpg gui/menu art); 6 `.mcmeta` animated textures (vanilla animation metadata) → `flipbook_textures.json` (frametime→ticksPerFrame rounded, interpolate→blend_frames, index lists preserved). Entity flipbook (`anomaly.png`) deferred to its entity chunk.
- Java models: `models/block/*.json` mostly `cube_all` parents with `thebrokenscript:block/x` texture refs → generate `terrain_texture.json`; `models/item/*.json` → `item_texture.json`
- Blockstates (123): consumed by Chunk 08 authoring, not this chunk
- Particles: source JSONs are **sprite-list declarations only** (`{"textures":["tbs:eyes"]}`); actual behavior is code-side (TBSParticles) → register textures now, effects authored in consuming chunks (ledger note)
- Geometry: 77 native Bedrock geo files — **several carry the literal shared id `geometry.unknown`** → rewrite collisions to unique `geometry.tbs_<basename>` + record mapping; animations 35 files copied as-is
- Localization: mod lang (en_us.json) converted to `key=value` lines into RP+BP texts; languages.json added

## Generator
Single re-runnable tool: `tools/build_rp_assets.ps1`
1. copy sounds/** → RP/sounds/
2. sounds.json → RP/sound_definitions.json (category/stream preserved)
3. copy textures/** → RP/textures/
4. terrain_texture.json from block-model texture refs + direct pngs (collision-safe keys)
5. item_texture.json from item-model texture refs + item png basenames
6. geo → RP/models/entity/ with unique-id rewrite + docs/GEOMETRY_ID_MAP.json
7. animations → RP/animations/
8. flipbook_textures.json from mcmeta (block set)
9. texts/en_US.lang + languages.json both packs

## Acceptance
validate_pack.ps1 PASS; generated atlases parse; every copied ogg/png referenced-or-registerable; geometry id map recorded; no placeholder content invented.

## Known deferrals (ledgered)
- Particle effect behaviors (code-side) → consuming chunks
- anomaly.png entity flipbook → Chunk 05F entity
- blocks.json material/sound table → Chunk 08
