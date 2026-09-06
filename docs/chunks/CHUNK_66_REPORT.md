# Chunk 66 Report — Stage 2 Floor 1 `clanvoidnew1`

## Result

Implemented on branch `codex/chunk-66-stage2-clanvoidnew1-asset-2026-09-06`; PR #40 is ready for review and remains open and unmerged.

## TDD and corrective debugging evidence

- Red test commit: `8a1fa80f74f5571963faf6934a929b5abfc2e134`.
- Workflow [run 34020660995](https://github.com/PastaHimself/Tberock20/actions/runs/34020660995) failed at the JavaScript regression step exactly as intended: 257 existing tests passed and the 3 new Chunk 66 assertions failed because the selector, catalog entry, and asset were absent.
- The first asset correction exposed a second source-format issue: Bedrock `TAG_List<Compound>` elements are bare compound payloads and must not carry an extra type byte. The corrected asset also uses actual zero-byte compound terminators.
- The green focused contract then exposed one omitted source field, `blockEntityCount: 0`; commit `a4cbbda51d915d4562d7f35a4f3d096c69e5d891` added only that field.

## Source-backed implementation

- Added `clanvoidnew1.mcstructure` from source blob `a92773a3f9da467f1849d6d34b0e6292e47bcf62`.
- The asset is 16×6×16 with 1,536 cells: 788 air, 176 cobblestone, 48 glass, 12 wall torches, 368 custom cobblestone-border blocks, and 144 custom stone-slab-border blocks.
- Preserved 748 non-air primary blocks, zero entities, and zero block entities.
- Added the Floor 1 selector contract for variants 1..7 and the validated catalog entry at Y=200.
- Converted source wall-torch directions to Bedrock `torch_facing_direction` states and reused the existing custom border-block definitions.
- Updated the audit and documentation to 12 validated / 52 deferred Stage 2 templates.

## API verification

BedrockWikiMcp verified stable `Dimension.runCommand(commandString)`; Microsoft Learn verified `/structure load` argument ordering and the `torch_facing_direction` block-state values. No new `@minecraft/server` API was added. The exact Java custom `Stage2Generator` chunk-generation lifecycle remains explicitly documented as an engine boundary.

## CI

GitHub Actions [run 34021929745](https://github.com/PastaHimself/Tberock20/actions/runs/34021929745) passed:

- 67 Python validator tests.
- Complete add-on, resource-link, Jigsaw JSON, and Jigsaw connector validation.
- All 12 Bedrock structures with no validation errors or warnings.
- Behavior-pack JavaScript syntax and beta API type-check.
- 260/260 JavaScript regressions, including all 3 Chunk 66 assertions.
- Blockception diagnostics: 0 errors, 0 warnings, 4 info, 0 hints.
- Mojang Creator Tools: 0 blockers, 582 warnings, and 25 exact known false-positive blockers ignored.
- Production packaging and both artifact uploads.

Bedrock world/runtime smoke testing remains unavailable locally.