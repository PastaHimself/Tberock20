# Chunk 57 — Integrity Phase 2 Stage 2 stone3 template asset

## Scope

Validate the next isolated Stage 2 source template boundary: Floor 4 rare variant 2 (`stone3`). This chunk adds the audited Bedrock asset and catalog/model coverage only. It does not wire automatic template placement and does not claim Java custom chunk-generator parity.

## Source contract

- `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Generator.java` selects `stone3` for the Floor 4 special/rare variant-2 branch and places Floor 4 structures at Y 233.
- `source_extracted/data/thebrokenscript/structure/stone3.nbt` is Java DataVersion 3955, size 16×4×16, with 1024 cells and no entities or block entities.
- Source block counts are 256 `minecraft:stone`, 724 `minecraft:air`, and 44 `minecraft:oak_door` cells. The 44 door cells use 12 Java door block states; the full Java palette contains 14 states including stone and air.
- The retained source blob SHA is `45381d498f95f558e296b8aae40bb9183f13032e`.

## Bedrock contract

- `STAGE2_TEMPLATE_ASSET_AUDIT.json` records `stone3` as validated, bringing the catalog to 3/64 assets with 61 deferred.
- `BP/structures/thebrokenscript/stage2/stone3.mcstructure` uses Bedrock format version 1, size 16×4×16, two block-index layers, ZYX flattened cell order, and palette order `minecraft:stone`, `minecraft:air`, `minecraft:oak_door`.
- The Bedrock door states are `minecraft:cardinal_direction`, `door_hinge_bit`, `open_bit`, and `upper_block_bit`. The source Java `powered=false` property is intentionally not invented as a Bedrock state.
- `stage2GeneratorFloor4Structure(true, true, 2)` returns `stone3`; `stage2TemplatePlacementPlan` preserves the source blob, Y 233, size, role, and transform inputs.
- The existing no-mirror `stage2TemplateLoadCommand`/`runStage2TemplateLoad` seam remains opt-in; automatic Phase 2 placement is not enabled.

## Preserved boundaries and limitation

- Existing Stage 2 runtime contracts preserve Floor 1–7 boundaries, the Floor 7 Integrity prerequisite, and the special Floor 6 → `FLOOR_6_INTEG` mapping.
- Java `Stage2Generator` custom chunk generation, room RNG, occupancy, border/tunnel/nowhere generation, exact rotation/mirror behavior, and automatic structure placement remain explicitly documented as not exactly reproducible by Bedrock static dimension JSON.

## Acceptance tests

1. The focused test fails before implementation because the `stone3` catalog metadata and asset are absent.
2. The model returns exact `stone3` metadata and maps Floor 4 rare variant 2 to `stone3`.
3. The structure asset starts as a valid Bedrock compound, contains the expected dimensions/door-state strings, and is accepted by the repository structure validator.
4. The placement plan and command seam preserve the validated no-mirror boundary.
5. Repository syntax, beta type-check, validators, regression tests, diagnostics, Creator Tools validation, and packaging pass; artifact upload quota failures remain non-blocking.

## API evidence

- BedrockWikiMcp stable block listing confirms door blocks expose `minecraft:cardinal_direction`, `door_hinge_bit`, `open_bit`, and `upper_block_bit`; no powered state is listed for Bedrock doors.
- Microsoft Learn `/structure` documentation confirms namespaced structure IDs, rotations `0_degrees`/`90_degrees`/`180_degrees`/`270_degrees`, mirror options, and include-entities/include-blocks arguments.
- No new `@minecraft/server` API is introduced in Chunk 57; the existing command seam was re-verified against the official references.