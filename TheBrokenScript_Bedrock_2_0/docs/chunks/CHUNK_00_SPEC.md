# CHUNK_00_SPEC — Complete Source Inventory & Architecture Reconstruction

## Goal
Establish exactly what The Broken Script 2.0 contains and how its systems depend on each other. No gameplay implementation.

## Inputs inspected (bounded groups)
1. Archive layer: 9 chunk zips → 6765 extracted files; reassembly manifest + README; split-binary reconstruction (`sites/rblog/file.bin`, 85 MB).
2. Metadata: `neoforge.mods.toml`, `MANIFEST.MF`, `pack.mcmeta`, both mixin configs (124 mixins), `accesstransformer.cfg`, jarjar metadata (brokencore 0.1.0 / mixinextras / mixinsquared).
3. Code tree: all 1982 `.class` paths under `net/thebrokenscript/**` aggregated per package; registry class roster parsed from filenames (TBS* classes incl. inner classes).
4. Data pack: every JSON under `data/thebrokenscript|minecraft|brokencore` (dimensions, dimension_types, biomes, carver, features, placed features, noise settings, structure/set, damage types, jukebox songs, advancements, recipes, loot tables, tags, biome modifiers incl. spawns/, painting).
5. Resources: `assets/thebrokenscript/**` family audit (geo 77 Bedrock-native, animations 36 Bedrock-native, sounds.json + 191 ogg, textures 502, models 388 Java, particles 9, shaders 89, fonts, library_books 44, gui/screens), plus `assets/minecraft` overrides and embedded nostalgia/nostalgia_gen packs.
6. Localization: `assets/minecraft/lang/en_us.json` + mod lang — authoritative id extraction for entities/events/items via strict single-segment key regex.

## Deliverables
SOURCE_INVENTORY.json (912 entries) · SOURCE_MAP.json (912 rows) · ASSET_MAP.json · IDENTIFIER_MAP.json · PARITY_MATRIX.md · BEDROCK_ARCHITECTURE.md (mapping + dependency graph + revised 19-chunk schedule) · BEDROCK_COMPATIBILITY.md (MS-Learn-verified) · ADAPTATION_NOTES.md (A-001…A-007 seeds) · VALIDATION_LOG.md · KNOWN_LIMITATIONS.md · PORT_PROGRESS.md

## Acceptance criteria
- Every shipping package/resource family has an inventory entry.
- Registry-derived rosters enumerated (entities/blocks/items/dimensions/etc.).
- Chunk schedule revised against actual content.
- Version-sensitive platform claims verified against official docs.

## Out of scope
Any gameplay file creation in BP/RP; bytecode decompilation (tooling gap recorded).
