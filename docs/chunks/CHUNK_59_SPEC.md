# Chunk 59 — Integrity Phase 2 Stage 2 stone5 template asset

## Scope

Validate and ship the Floor 4 rare variant 4 Stage 2 template as a Bedrock `.mcstructure` asset. Keep the existing Phase 2 runtime contracts unchanged: Floor 1–7 boundaries, Floor 6 → `FLOOR_6_INTEG` mapping, tether-gated Integrity placement, and the explicit Java custom-generator limitation remain in force.

## Source contract

- Java source: `source_extracted/data/thebrokenscript/structure/stone5.nbt`.
- Source blob: `e770282817af7b4fbb94d76151c925bbbf351b94`.
- Java DataVersion: 3955.
- Size: 16×3×16; 768 block cells; palette `minecraft:air`, `minecraft:stone`, and `thebrokenscript:it`.
- Cell counts: 256 stone, 489 air, 23 source custom-block cells; no entities or block entities.
- Java `Stage2Generator` selects `stone5` for Floor 4 rare variant 4 and places the template at Y 233.

## Bedrock design

- Add `BP/structures/thebrokenscript/stage2/stone5.mcstructure`.
- Record the adapted source metadata in `STAGE2_TEMPLATE_ASSET_AUDIT.json` and `STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone5`.
- Map source `thebrokenscript:it` to the existing `thebrokenscript:block_is_missing_id` surrogate because no exact Bedrock block is present.
- Preserve source dimensions, positions, counts, and empty entity list in format-version 1 Bedrock NBT.
- Keep `stage2TemplatePlacementPlan` at Y 233 with `includeEntities=false`; emit the existing no-mirror `structure load` seam.
- Do not connect this asset to automatic Phase 2 placement until the remaining templates and Java transform/occupancy semantics are validated.
- Do not claim exact Java `Stage2Generator` custom chunk generation; `stage2.json` remains a void dimension.

## Focused acceptance tests

1. `stage2GeneratorFloor4Structure(true, true, 4)` returns `stone5`.
2. The source catalog records the exact source blob, dimensions, adapted palette, cell counts, entity count, and Y 233 role.
3. The placement plan and command use `includeEntities=false` and preserve the no-mirror boundary.
4. The binary asset is a valid format-version 1 Bedrock structure containing the expected stone, air, and surrogate identifiers.
5. Existing Phase 2 runtime and Floor 1–7/Floor 6 mapping regressions remain green.

## API evidence

- No new `@minecraft/server` API is introduced by this chunk.
- Microsoft Learn verifies the Bedrock `/structure load` command accepts rotation, mirror, `includeEntities`, and `includeBlocks`: https://learn.microsoft.com/minecraft/creator/reference/content/commandsreference/examples/commands/structure?view=minecraft-bedrock-stable#usage
- BedrockWikiMcp verifies the existing Bedrock structure and block-state documentation used for the format/state conversion; the prior supported surrogate block definition is retained rather than introducing a new API or block.
