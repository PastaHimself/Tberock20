# Chunk 57 — Integrity Phase 2 Stage 2 stone3 template asset

## Result

Chunk 57 validates Floor 4 rare variant 2 (`stone3`) as a Bedrock structure asset and extends the source-backed Stage 2 catalog from 2/64 to 3/64. It preserves the existing Floor 1–7 and Floor 6 special-mapping contracts, while keeping Java custom chunk generation and automatic template placement explicitly bounded.

## Source-to-Bedrock mapping

| Source contract | Bedrock implementation | Preserved | Adaptation |
|---|---|---|---|
| `stone3.nbt` size/palette/cells | `stone3.mcstructure` | 16×4×16; 256 stone + 724 air + 44 oak-door cells; 14 palette states; zero entities/block entities | Bedrock format 1, ZYX block indices, two layers, and Bedrock door state names |
| Floor 4 rare variant 2 | `stage2GeneratorFloor4Structure(true, true, 2)` + metadata | source role, Y 233, source blob SHA | only audited variant is supported |
| Java oak-door states | Bedrock `minecraft:oak_door` palette states | facing, hinge, open, upper/lower state | Java `powered=false` omitted because Bedrock oak doors have no powered state |
| Java structure loading | existing placement plan, command seam, and asset | validated no-mirror, no-entity, block-inclusive command path | not automatically called by Phase 2 |
| Java custom `Stage2Generator` | audit and limitation ledgers | source evidence and 3/64 progress are machine-readable | RNG, occupancy, borders, tunnels, nowhere, remaining 61 assets, and exact world placement remain open |

## TDD and validation

- Red commit: `97d891ed3f9bfede0b268e3c1383daa19191594a`; the focused stone3 test was added first and the first workflow run failed at the JavaScript regression step because the model/asset contract was absent.
- Implementation commit: `74558bc8613bd7ccc417398570e27b370ef0fb89`; its CI run exposed the empty `structure.block_indices` NBT field name and the missing existing `stone2.blockEntityCount` metadata field.
- Corrective commit: `0f5d3b0d12a978da166ed7d720b5a10ec8aa907e`.
- GitHub Actions [run 33966171389](https://github.com/PastaHimself/tbs-2.0/actions/runs/33966171389) passed structure validation, JavaScript syntax, beta type-check, 233 JavaScript tests with 0 failures, Blockception diagnostics (0 errors, 0 warnings, 4 info, 0 hints), Creator Tools validation (0 blockers, 582 warnings, 25 known false-positive blockers ignored), `.mcaddon` packaging, and both upload steps.
- BedrockWikiMcp and Microsoft Learn verification completed for the Bedrock door block states and `/structure load` syntax. No new Script API was added.
- Bedrock world/runtime smoke testing remains unavailable locally.

## Files

- `BP/scripts/systems/integrity_arena_model.js`
- `BP/structures/thebrokenscript/stage2/stone3.mcstructure`
- `STAGE2_TEMPLATE_ASSET_AUDIT.json`
- `tests/integrity_stage2_stone3_asset_model.test.mjs`
- `docs/chunks/CHUNK_57_SPEC.md`
- `docs/chunks/CHUNK_57_REPORT.md`
- `PORT_PROGRESS.md`
- `PARITY_MATRIX.md`
- `KNOWN_LIMITATIONS.md`
- `ADAPTATION_NOTES.md`
- `VALIDATION_LOG.md`

## Remaining task

Audit and convert the remaining 61 Stage 2 templates, especially entity/block-entity and custom-state families, then implement deterministic per-cell room/surface/tunnel placement with Java variant selection, rotation/mirror semantics, occupancy, borders, tunnels, and nowhere generation. The portable floor/entity/tether runtime contracts are already represented; Java custom `Stage2Generator` parity remains explicitly blocked where Bedrock cannot reproduce it exactly.