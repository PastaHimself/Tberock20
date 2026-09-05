# Chunk 60 — Integrity Phase 2 Stage 2 stone6 template asset

## Result

Chunk 60 adds the audited Floor 4 rare variant 5 asset, `stone6.mcstructure`, and extends the validated Stage 2 catalog from 5/64 to 6/64 templates. The asset is not automatically placed by the Phase 2 scheduler; it is an opt-in, source-backed placement seam while Java room selection and custom chunk generation remain deferred.

The source is Java DataVersion 3955, size 16×4×16, with 1024 cells: 256 `minecraft:stone`, 768 `minecraft:air`, 15 `minecraft:armor_stand` entities, and no block entities. The Bedrock asset preserves the block dimensions/order, 256 non-air primary cells, and the 15 source-relative armor-stand positions/rotations. The Java player-head profile/skin payload attached to those armor stands is omitted because no verified portable Bedrock structure/profile representation exists for that source data; plain Bedrock armor stands remain visible at the audited positions.

## Source-to-Bedrock mapping

| Source contract | Bedrock implementation | Preserved | Adaptation |
|---|---|---|---|
| Floor 4 rare variant 5 → `stone6` | `stage2GeneratorFloor4Structure(true, true, 5)` | exact variant identity and Y 233 placement band | no automatic scheduler placement |
| Java 16×4×16 / 1024-cell structure | format-version 1 `.mcstructure` | dimensions, ZYX cell order, 256 non-air primary cells | Bedrock little-endian NBT serialization |
| 15 Java `minecraft:armor_stand` entities | 15 Bedrock `minecraft:armor_stand` structure entities | entity count, relative positions, rotations, `includeEntities=true` | Java player-head profile/skin payload omitted |
| Java Stage2Generator custom chunk generation | existing Stage 2 runtime scaffold and opt-in load seam | source audit and explicit boundary | no exact room RNG, rotation/mirror, occupancy, border/tunnel/nowhere generation |

## Validation

- TDD red: focused stone6 test failed in [run 33980367028](https://github.com/PastaHimself/tbs-2.0/actions/runs/33980367028) because the catalog and asset contract were absent; the validator, syntax, and type-check gates before the regression step passed.
- Green CI: [run 33980738760](https://github.com/PastaHimself/tbs-2.0/actions/runs/33980738760) passed validator unit tests, complete add-on validation, resource links, Jigsaw definitions/connectors, all Bedrock structures, behavior-pack JavaScript syntax, beta type-check, 242 JavaScript regressions (0 failures), Blockception diagnostics (0 errors, 0 warnings, 4 info, 0 hints), Mojang Creator Tools validation (0 blockers; 582 warnings; 25 exact known false-positive blockers filtered), packaging, and the configured artifact-upload steps. The artifact service still logged its exhausted quota, but those steps are non-blocking.
- No new `@minecraft/server` API was added. Microsoft Learn verifies the existing `/structure load` command arguments, and BedrockWikiMcp verifies the `minecraft:armor_stand` Bedrock entity definition used by the adapted structure entities.
- Bedrock world/runtime smoke testing remains unavailable locally.

## Next remaining task

Validate the remaining Floor 4 rare variant, `stone7.nbt`, then continue the remaining 58 source Stage 2 templates. Automatic placement and exact Java custom-generator parity remain separate work.
