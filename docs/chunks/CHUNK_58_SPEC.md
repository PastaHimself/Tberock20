# Chunk 58 — Integrity Phase 2 Stage 2 stone4 template asset

## Scope

Validate and ship the Floor 4 rare variant 3 Stage 2 template as a Bedrock `.mcstructure` asset. Keep the existing Phase 2 runtime contracts unchanged: Floor 1–7 boundaries, Floor 6 → `FLOOR_6_INTEG` mapping, tether-gated Integrity placement, and the explicit Java custom-generator limitation remain in force.

## Source contract

- Java source: `source_extracted/data/thebrokenscript/structure/stone4.nbt`.
- Source blob: `d43f4146ebe57edb8dbfb3a2b25d8b616fb39137`.
- Java DataVersion: 3955.
- Size: 16×3×16; 768 block cells; palette names `minecraft:air`, `minecraft:rail`, and `minecraft:stone`; eight palette states.
- Primary layer: 295 non-air cells.
- Entities: one `minecraft:minecart`; block entities: zero.
- Java `Stage2Generator` selects `stone4` for Floor 4 rare variant 3 and places the template at Y 233.

## Bedrock design

- Add `BP/structures/thebrokenscript/stage2/stone4.mcstructure`.
- Record the source metadata in `STAGE2_TEMPLATE_ASSET_AUDIT.json` and `STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone4`.
- Convert Java rail shapes to Bedrock `minecraft:rail` palette entries with typed `rail_direction` values.
- Preserve the minecart in the Bedrock structure entity list using the existing entity conversion contract (`identifier` and `Pos`).
- Set `includeEntities=true` in the placement plan and emitted `structure load` command.
- Do not connect this asset to automatic Phase 2 placement until the remaining templates and Java transform/occupancy semantics are validated.
- Do not claim exact Java `Stage2Generator` custom chunk generation; `stage2.json` remains a void dimension.

## Focused acceptance tests

1. `stage2GeneratorFloor4Structure(true, true, 3)` returns `stone4`.
2. The source catalog records the exact source blob, dimensions, palette count, cell counts, entity count, and Y 233 role.
3. The placement plan and command preserve the minecart with `includeEntities=true`.
4. The binary asset is a valid format-version 1 Bedrock structure and contains the expected rail/entity identifiers.
5. Existing Phase 2 runtime and Floor 1–7/Floor 6 mapping regressions remain green.

## API evidence

- No new `@minecraft/server` API is introduced by this chunk.
- Microsoft Learn verifies the Bedrock `/structure load` command accepts rotation, mirror, `includeEntities`, and `includeBlocks` arguments: https://learn.microsoft.com/minecraft/creator/reference/content/commandsreference/examples/commands/structure?view=minecraft-bedrock-stable#usage
- BedrockWikiMcp verifies `minecraft:rail` uses the `rail_direction` block state; current state conversion follows the audited Bedrock mapping used by the asset generator.