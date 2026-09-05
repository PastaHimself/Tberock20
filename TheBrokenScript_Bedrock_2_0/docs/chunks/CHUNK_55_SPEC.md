# Chunk 55 — Integrity Phase 2 Stage 2 template asset foundation

## Scope

Convert the first source-audited Stage 2 Java template into a validated Bedrock structure asset and define the smallest supported placement seam.

This chunk deliberately covers one isolated template: `stone1`, the Java default Floor 4 layer. It does not claim that the Java custom `Stage2Generator` is now reproduced.

## Source contract

- `Stage2Generator.genRoom` resolves the default Floor 4 template to `stone1` and places it at Y 233.
- `STAGE2_GENERATOR_AUDIT.json` records `stone1.nbt` as 16×1×16, palette `minecraft:stone`, 256 blocks, zero entities, and zero block entities.
- The source template blob is retained by SHA `2d8e2d3da26e07f4921764f9f6937cc46f359060`.
- Java still applies per-room rotation, optional `FRONT_BACK` mirroring, bounding-box clipping, occupancy tracking, and custom-generator timing. Those behaviors remain explicit follow-up boundaries.

## Bedrock design

- `STAGE2_TEMPLATE_ASSET_AUDIT.json` records the 1/64 validated asset status and the 63-template deferment.
- `BP/structures/thebrokenscript/stage2/stone1.mcstructure` uses Bedrock little-endian NBT with one primary layer containing 256 stone palette indices.
- `stage2TemplatePlacementPlan` preserves source identity, source blob, origin, Y band, size, and transform inputs.
- `stage2TemplateLoadCommand` emits a direct no-animation `structure load` command only for a validated asset with `none` mirror, `includeEntities=false`, and `includeBlocks=true`.
- `runStage2TemplateLoad` calls `Dimension.runCommand` as an explicit opt-in seam. It is not called by the automatic Phase 2 scheduler while the remaining templates are unconverted.

## Focused acceptance tests

1. The source-backed `stone1` placement plan returns the expected 16×1×16 metadata and Floor 4 Y 233 band.
2. A supported plan emits `structure load thebrokenscript:stage2/stone1 32 233 -48 90_degrees none false true`.
3. A Java `front_back` transform is not silently mapped to an unverified Bedrock mirror and returns no command.
4. The runtime exposes the explicit load seam without automatic scheduler wiring.
5. The actual `.mcstructure` passes `tools/validate_mcstructures.py` with 256 non-air primary blocks and no warnings.

## API evidence

- BedrockWikiMcp stable `Dimension.runCommand(commandString: string): CommandResult`: synchronous dimension-context command execution; command strings do not start with slash; the call is unavailable in restricted execution and can throw `CommandError`.
- Microsoft Learn `/structure load` syntax: `structure load <name> <to> [rotation] [mirror] [includeEntities] [includeBlocks]`; rotations use `0_degrees`, `90_degrees`, `180_degrees`, or `270_degrees`.
- Microsoft Learn structure documentation confirms structure templates are stored as `.nbt` or `.mcstructure` files.
- The helper is intentionally not called from a restricted callback and catches command failures for retry by its caller.
