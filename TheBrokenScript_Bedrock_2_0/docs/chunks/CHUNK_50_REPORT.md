# Chunk 50 — Integrity Phase 1 terrain corruption

## Result

Chunk 50 is implemented on the stacked branch. Phase 1 now preserves the recovered terrain corruption queue contract: an inclusive radius-100 disk, 30% candidate inclusion, shuffled positions, one replacement every 20 ticks, the four source replacement blocks, and corrupted-command-block exclusion. The runtime keeps the queue across the startup/intro boundary, adds the source post-intro queue, and applies replacements through the supported Bedrock block APIs from the existing boss scheduler.

## Source-to-Bedrock mapping

| Source path | Bedrock adapter | Preserved contract | Explicit adaptation |
|---|---|---|---|
| Phase1.java terrainQueue/tick | integrity_phase1_terrain_model.js + integrity_arena_runtime.js | radius 100, ratio 0.3, shuffled queue, initial 20-tick cadence, one position per 20 ticks | exact Java block registry and heightmap implementation |
| TerrainCorrupterKt.java | integrity_phase1_terrain_model.js | inclusive disk and random inclusion rule | Java random source and shuffle order |
| PartialBlockPos.java | integrity_arena_runtime.js | X/Z queue positions resolve to the topmost target block | Dimension.getTopmostBlock is the supported surface-height seam |
| TBSTags.java terrain_corrupt_replace | PHASE1_TERRAIN_SOURCE.replacementBlockIds | obsidian, r_3, void_root, teeth replacement set | explicit list replaces Java registry-backed tag lookup |
| boss_controller.js | tickIntegrityArena() | one terrain tick per server tick | Arena player lifecycle and later phase transfer remain deferred |

## Evidence and tests

- Recovered Phase1.java, TerrainCorrupterKt.java, PartialBlockPos.java, and TBSTags.java were compared with the adapter.
- Focused TDD terrain model tests: 6/6 pass.
- Changed model/runtime/controller JavaScript syntax checks pass locally.
- GitHub Actions run 33882851212 passed validator unit tests, complete add-on/resource/Jigsaw/structure checks, JavaScript syntax, beta type-check, JavaScript regressions, Blockception diagnostics, Creator Tools validation, and .mcaddon packaging. Only artifact uploads failed because repository artifact storage quota is exhausted.
- Bedrock world/runtime smoke testing remains unavailable.

## Remaining differences

ChunkCarver generation, exact Java heightmap and dynamic registry tag behavior, Phase 2/3 transfer, and native packet/camera/music presentation remain explicit adaptations or deferred source boundaries.
