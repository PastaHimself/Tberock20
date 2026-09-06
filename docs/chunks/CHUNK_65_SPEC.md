# Chunk 65 Specification — Stage 2 Floor 2 `clandimensionroom5`

## Objective

Port the remaining Floor 2 variant-5 source boundary: preserve Java’s special/ordinary selector mapping and add `clandimensionroom5` as a source-backed Bedrock structure asset.

## Source evidence

- `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Generator.java`
  - Floor 2 variant 5 selects `clandimensionroom2` when `special=true`.
  - Floor 2 variant 5 selects `clandimensionroom5` otherwise.
  - Floor 2 structures are placed at Y=207.
- `TheBrokenScript_Bedrock_2_0/STAGE2_GENERATOR_AUDIT.json`
  - source blob SHA: `8757e559d147f81f9dae6f8301d59af47027ca23`
  - Java DataVersion: 3955
  - size: 16×9×16
  - palette: `minecraft:air` and `minecraft:cobblestone`
  - 2,304 blocks, zero entities, zero block entities
- Direct source-NBT parse:
  - 792 cobblestone blocks
  - 1,512 air blocks

## Acceptance criteria

1. A focused test fails before implementation because the `clandimensionroom5` catalog entry and asset are absent.
2. `stage2GeneratorFloor2Structure(5, true)` remains `clandimensionroom2`.
3. `stage2GeneratorFloor2Structure(5, false)` returns `clandimensionroom5`.
4. The catalog records the source SHA, dimensions, palette, counts, Y=207 placement, and `floor2_variant_5_ordinary` role.
5. `BP/structures/thebrokenscript/stage2/clandimensionroom5.mcstructure` is a valid uncompressed Bedrock structure with format version 1, source dimensions/palette, 792 non-air primary blocks, and no entities.
6. The placement contract emits:
   `structure load thebrokenscript:stage2/clandimensionroom5 <x> 207 <z> 0_degrees none false true`.
7. The asset audit advances to 11 validated and 53 deferred templates.
8. The Java custom `Stage2Generator` limitation remains explicit; this chunk does not claim automatic chunk-generation parity.

## Bedrock compatibility boundary

The existing `Dimension.runCommand` adapter is sufficient for the validated command seam. BedrockWikiMcp confirms the stable signature and no-leading-slash rule. Microsoft Learn confirms the `/structure load` rotation, mirror, entity, and block arguments. No new `@minecraft/server` API is introduced.

## Validation

- Focused red test: required before implementation.
- Focused green assertions: required after implementation.
- JavaScript syntax, beta API type-check, repository validators, structure/NBT validation, full JavaScript regression suite, diagnostics, Creator Tools validation, and packaging: required in GitHub Actions.
