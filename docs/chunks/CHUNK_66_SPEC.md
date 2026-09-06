# Chunk 66 Specification — Stage 2 Floor 1 `clanvoidnew1`

## Objective

Port the source-backed Integrity Phase 2 Stage 2 Floor 1 variant-1 template while preserving the Java selector boundary, placement height, source palette/count contract, and Bedrock structure-load seam.

## Source evidence

- `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Generator.java`
  - Floor 1 resolves variants 1..7 to `clanvoidnew1`..`clanvoidnew7`.
  - Floor 1 room templates are placed at Y=200.
- `source_extracted/data/thebrokenscript/structure/clanvoidnew1.nbt`
  - source blob SHA: `a92773a3f9da467f1849d6d34b0e6292e47bcf62`
  - Java DataVersion: 3955
  - size: 16×6×16
  - palette names: air, cobblestone, glass, wall_torch, cobblestone_border_block, stone_slab_border_block
  - 1,536 block cells; 748 non-air cells; zero entities; zero block entities
- Existing Bedrock custom blocks:
  - `thebrokenscript:cobblestone_border_block`
  - `thebrokenscript:stone_slab_border_block`

## Acceptance criteria

1. The focused test fails before implementation because the Floor 1 selector/catalog/asset contract is absent.
2. `stage2GeneratorFloor1Structure(1)` returns `clanvoidnew1`, variant 7 returns `clanvoidnew7`, and variants outside 1..7 throw `RangeError`.
3. The catalog records the source SHA, dimensions, palette names, cell counts, Y=200 placement, zero entity/block-entity counts, and `floor1_variant_1` role.
4. `clanvoidnew1.mcstructure` is a valid format-version 1 Bedrock structure with the source dimensions, source custom blocks, `minecraft:wall_torch`, and directional `torch_facing_direction` states.
5. The placement contract emits `structure load thebrokenscript:stage2/clanvoidnew1 <x> 200 <z> 0_degrees none false true`.
6. The Stage 2 audit advances to 12 validated and 52 deferred templates without changing Floor 1..7 boundaries or the Floor 6 → `FLOOR_6_INTEG` mapping.
7. The Java custom `Stage2Generator` limitation remains explicit; this chunk does not claim automatic chunk-generation parity.

## Bedrock compatibility boundary

BedrockWikiMcp verified the existing stable `Dimension.runCommand(commandString)` API and its no-leading-slash rule. Microsoft Learn verified the `/structure load` rotation, mirror, entity, and block arguments and the documented `torch_facing_direction` values (unknown, west, east, north, south, top). No new `@minecraft/server` API is introduced.

## Validation

- Focused red test is required before implementation.
- Focused green assertions are required after implementation.
- JavaScript syntax, beta API type-check, repository validators, structure/NBT validation, full JavaScript regression suite, diagnostics, Creator Tools validation, and packaging are required in GitHub Actions.
