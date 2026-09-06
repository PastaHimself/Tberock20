# Chunk 60 — Integrity Phase 2 Stage 2 stone6 template asset

## Scope

Validate and ship the Floor 4 rare variant 5 Stage 2 template as an entity-bearing Bedrock `.mcstructure` asset. Keep the existing Phase 2 runtime contracts unchanged: Floor 1–7 boundaries, Floor 6 → `FLOOR_6_INTEG` mapping, tether-gated Integrity placement, and the explicit Java custom-generator limitation remain in force.

## Source contract

- Java source: `source_extracted/data/thebrokenscript/structure/stone6.nbt`.
- Source blob: `1b15f9ac3f6b35506b25361694b87c7ca8dd6231`.
- Java DataVersion: 3955.
- Size: 16×4×16; 1024 block cells; palette `minecraft:air` and `minecraft:stone`.
- Cell counts: 256 stone, 768 air, 15 `minecraft:armor_stand` entities; no block entities.
- Each source armor stand carries a Java player-head profile payload.
- Java `Stage2Generator` selects `stone6` for Floor 4 rare variant 5 and places the template at Y 233.

## Bedrock design

- Add `BP/structures/thebrokenscript/stage2/stone6.mcstructure`.
- Record the adapted source metadata in `STAGE2_TEMPLATE_ASSET_AUDIT.json` and `STAGE2_TEMPLATE_SOURCE.supportedTemplates.stone6`.
- Preserve the 16×4×16 block layout, ZYX block-index ordering, 256 non-air primary cells, and 15 source-relative entity positions/rotations.
- Map source armor stands to `minecraft:armor_stand` structure entities and keep `includeEntities=true` in the placement plan/command.
- Omit the Java player-head profile/skin payload as an explicit, player-visible adaptation; do not invent a Bedrock custom profile identifier.
- Keep `stage2TemplatePlacementPlan` at Y 233 and the no-mirror `structure load` seam opt-in; do not connect this asset to automatic Phase 2 placement.
- Do not claim exact Java `Stage2Generator` custom chunk generation; `stage2.json` remains a void dimension.

## Focused acceptance tests

1. `stage2GeneratorFloor4Structure(true, true, 5)` returns `stone6`.
2. The source catalog records the exact source blob, dimensions, palette, cell counts, 15 entity count, and Y 233 role.
3. The placement plan and command use `includeEntities=true` and preserve the no-mirror boundary.
4. The binary asset is a valid format-version 1 Bedrock structure containing the expected stone/air palette and 15 `minecraft:armor_stand` entities with `Pos` and `Rotation`.
5. Existing Phase 2 runtime and Floor 1–7/Floor 6 mapping regressions remain green.

## API evidence

- No new `@minecraft/server` API is introduced by this chunk.
- Microsoft Learn verifies the Bedrock `/structure load` command accepts rotation, mirror, `includeEntities`, and `includeBlocks`: https://learn.microsoft.com/minecraft/creator/reference/content/commandsreference/examples/commands/structure?view=minecraft-bedrock-stable#usage
- BedrockWikiMcp verifies the stable `minecraft:armor_stand` resource/entity identifier and its supported Bedrock client entity definition: https://github.com/Mojang/bedrock-samples/blob/main/resource_pack/entity/armor_stand.v1.0.entity.json
