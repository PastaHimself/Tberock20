# Chunk 58 — Integrity Phase 2 Stage 2 stone4 template asset

## Result

Chunk 58 adds the audited Floor 4 rare variant 3 asset, `stone4.mcstructure`, and extends the source catalog/model from 3/64 to 4/64 validated Stage 2 templates. The asset is not automatically placed by the Phase 2 scheduler; it is an opt-in, source-backed placement seam while Java room selection and custom chunk generation remain deferred.

The first implementation CI run found a serializer defect: the binary contained 22 literal `\\x00` sequences where NBT compound terminators were required. Commit `846a83c952c0a2fc665a9b29ad94f6109a32258a` replaced each sequence with a single zero byte. The corrected asset passes the repository’s little-endian NBT parser and all substantive CI gates.

## Source-to-Bedrock mapping

| Source contract | Bedrock implementation | Preserved | Adaptation |
|---|---|---|---|
| Floor 4 rare variant 3 → `stone4` | `stage2GeneratorFloor4Structure(true, true, 3)` | exact variant identity and Y 233 placement band | no automatic scheduler placement |
| Java 16×3×16 / 768-cell structure | format-version 1 `.mcstructure` | dimensions, palette state count, primary non-air count 295 | Bedrock little-endian NBT serialization |
| Java `minecraft:rail` shapes | typed Bedrock `rail_direction` states | rail blocks and audited directions [0, 1, 6, 7, 8, 9] | Java/Bedrock state-name/value conversion |
| Java minecart entity | structure entity list with `identifier` and `Pos` | one `minecraft:minecart` | `structure load` must use `includeEntities=true` |
| Java Stage2Generator custom chunk generation | existing Stage 2 runtime scaffold and opt-in load seam | source audit and explicit boundary | no exact room RNG, rotation/mirror, occupancy, border/tunnel/nowhere generation |

## Validation

- TDD red: focused stone4 test failed before the catalog entry and asset existed in [run 33968384215](https://github.com/PastaHimself/tbs-2.0/actions/runs/33968384215).
- Corrective CI: [run 33969060246](https://github.com/PastaHimself/tbs-2.0/actions/runs/33969060246) failed only at structure validation; the failure was fixed in commit `846a83c952c0a2fc665a9b29ad94f6109a32258a`.
- Green CI: [run 33969395706](https://github.com/PastaHimself/tbs-2.0/actions/runs/33969395706) passed validator unit tests, complete add-on validation, resource links, Jigsaw definitions/connectors, all Bedrock structures, behavior-pack JavaScript syntax, beta type-check, 236 JavaScript tests, Blockception diagnostics (0 errors, 0 warnings, 4 info, 0 hints), Mojang Creator Tools validation (0 blockers; 582 warnings; 25 exact known false-positive blockers filtered), packaging, and the configured artifact-upload steps. The artifact service still logged its exhausted quota, but those steps are non-blocking.
- Bedrock world/runtime smoke testing remains unavailable locally.
- No new `@minecraft/server` API was added.

## Next remaining task

Validate the next Floor 4 rare variant, `stone5.nbt`, then continue the remaining 60 source Stage 2 templates. Automatic placement and exact Java custom-generator parity remain separate work.