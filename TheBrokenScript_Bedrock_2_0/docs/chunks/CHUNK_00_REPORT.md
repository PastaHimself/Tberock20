# CHUNK_00_REPORT

## Source examined
- Full extracted JAR surface: metadata, 124 mixins, jarjar libs, 1982 classes across 28 top packages, complete `data/` (datapack JSONs), complete `assets/` (727 json + 191 ogg + 493 images), lang rosters, embedded packs, custom binaries.
- Key discoveries:
  - **13 custom dimensions** (incl. stage2 boss arena dim, the_moon corrupted-moon dim, void_shadow)
  - **69 registered entity ids** incl. variants (circuit ×6 forms, null ×14+, tbe ×4, siluet ×4, he ×3, integrity phases/arm/curious/fireball…)
  - **94 named horror events**; ~91 TBSEvents handler lambdas; 45 chat responses; 4-stage story machine
  - **123 blockstates**, 8 block entities, 192 item ids, 40 recipes, 12 jukebox songs, 20 damage types
  - **24 custom spawn-condition classes** + 33 spawn biome modifiers
  - **Native Bedrock-format geo/animations** shipped by the authors (direct RP reuse)
  - Custom XCSF structure format; jigsaw shaft set; ~250 root structures
  - Deep engine hooks (generation corruption, deepslate removal, mob-cap edits, fake join/leave, window/desktop effects)

## Implemented
Inventory/architecture only (per spec): 11 state files + 2 tools + spec/report. No BP/RP gameplay files (correct for this chunk).

## Validation
12/12 checks PASS (VALIDATION_LOG). SOURCE_INVENTORY/SOURCE_MAP parse as valid JSON with 912 coherent rows; counts cross-checked against directory listings and regex extractions.

## Parity status
Not applicable (no ported behavior yet). Ledger initialized: all 912 components tracked, status `uninspected`.

## Adaptations recorded
A-001…A-007 seed entries (fluid/effects/shaders/desktop/painting/advancements/noise terrain).

## Unresolved defects / risks
1. **Bytecode-only source**: no decompiled Java supplied; JDK+decompiler not installed. Behavior constants (AI timings, probabilities) need disassembly from Chunk 02+. Requires user approval to install tooling locally.
2. Ticking-area API stability at 1.26.10 flagged for re-verification before Chunk 01/02 use.
3. Custom-dimension strategy decision deferred to Chunk 10 (two documented paths).
4. `sites/rblog/file.bin` opaque payload unparseable without code analysis (non-blocking).

## Next chunk prerequisites met?
Chunk 01 can start: manifests/deps verified, namespace locked, schedule set, asset reuse paths known. Decompiler install recommended first action of Chunk 01.

## Files created
See PORT_PROGRESS.md "Files created this execution".
