# Chunk 56 — Integrity Phase 2 Stage 2 stone2 template asset

## Scope

Validate the next isolated source boundary after `stone1`: the first rare Floor 4 Stage 2 template, `stone2`. This chunk adds only source-backed asset/catalog coverage and keeps the Java custom `Stage2Generator` explicitly deferred.

## Source contract

- `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Generator.java` selects `stone2` in the Floor 4 rare-variant branch and places it at Y 233.
- `source_extracted/data/thebrokenscript/structure/stone2.nbt` is audited as Java DataVersion 3955, size 16×9×16, 2304 cells, with palette names `minecraft:air`, `minecraft:stone`, and `thebrokenscript:block_is_missing_id`.
- The source cell counts are 256 stone, 50 custom missing-id, and 1998 air; entities and block entities are absent.
- The retained source blob SHA is `a61aabc79ec6bd18a3bdb325367d65055a108e9d`.

## Bedrock contract

- `STAGE2_TEMPLATE_ASSET_AUDIT.json` records `stone2` as validated, bringing the catalog to 2/64 assets with 62 deferred.
- `BP/structures/thebrokenscript/stage2/stone2.mcstructure` uses Bedrock structure format version 1, one primary layer, size 16×9×16, and palette order `minecraft:stone`, `thebrokenscript:block_is_missing_id`, `minecraft:air`.
- `stage2GeneratorFloor4Structure(true, true, 1)` returns `stone2`; `stage2TemplatePlacementPlan` preserves the source blob, Y 233, size, role, and transform inputs.
- The existing `stage2TemplateLoadCommand` / `runStage2TemplateLoad` seam emits only the validated no-mirror `Dimension.runCommand` path with entities disabled and blocks enabled. It is not wired into automatic Phase 2 placement.

## Focused acceptance tests

1. The new focused test fails before implementation because the `stone2` model metadata and asset contract are absent.
2. The model returns the exact source-backed `stone2` metadata and rare-variant selection.
3. The asset exists, parses as Bedrock structure NBT, preserves size/palette/cell counts, and contains no entities.
4. The placement plan and command seam preserve the no-mirror boundary; unverified Java `FRONT_BACK` is not silently mapped.
5. Repository syntax, beta type-check, validators, regression tests, diagnostics, Creator Tools validation, and packaging remain green.

## API evidence

- BedrockWikiMcp stable `Dimension.runCommand(commandString: string): CommandResult`: synchronous dimension-context command execution, command text without a leading slash, restricted-execution caveat, and `CommandError` behavior.
- Microsoft Learn `/structure load` syntax: `structure load <name> <to> [rotation] [mirror] [includeEntities] [includeBlocks]`, with named rotations `0_degrees`, `90_degrees`, `180_degrees`, and `270_degrees`.
- No new `@minecraft/server` API is introduced in Chunk 56; the existing command seam was re-verified against those references.
