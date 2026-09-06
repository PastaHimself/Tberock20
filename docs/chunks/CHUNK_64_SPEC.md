# Chunk 64 Specification — Stage 2 Floor 2 `clandimensionroom3`

## Objective

Port the next isolated Integrity Phase 2 Stage 2 template boundary: Java Floor 2 variants 3 and 4 (`clandimensionroom3`) as a source-backed Bedrock structure asset and validated placement/catalog contract.

## Source evidence

- `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Generator.java`
  - Floor 2 chooses variants 1–5.
  - Variants 3 and 4 both select `clandimensionroom3`.
  - Floor 2 structures are placed at Y=207.
- `TheBrokenScript_Bedrock_2_0/STAGE2_GENERATOR_AUDIT.json`
  - source blob SHA: `37d9f55b6fc9ac6c6f41979380e398cfdbf56ead`
  - Java DataVersion: 3955
  - size: 16×9×16
  - palette: `minecraft:air` and `minecraft:cobblestone`
  - 2,304 blocks, zero entities, zero block entities
- Direct source-NBT parse:
  - 855 cobblestone blocks
  - 1,449 air blocks

## Acceptance criteria

1. A focused test fails before implementation because the `clandimensionroom3` catalog entry and asset are absent.
2. `stage2GeneratorFloor2Structure(3, false)` and `stage2GeneratorFloor2Structure(4, false)` both return `clandimensionroom3`.
3. The catalog records the source SHA, dimensions, palette, counts, Y=207 placement, and `floor2_variant_3_4` role.
4. `BP/structures/thebrokenscript/stage2/clandimensionroom3.mcstructure` is a valid uncompressed Bedrock structure with format version 1, the source dimensions and palette, 855 non-air primary blocks, and no entities.
5. The placement contract emits:
   `structure load thebrokenscript:stage2/clandimensionroom3 <x> 207 <z> 0_degrees none false true`.
6. The asset audit advances to 10 validated and 54 deferred templates.
7. The Java custom `Stage2Generator` limitation remains explicit; this chunk does not claim automatic chunk-generation parity.

## Bedrock compatibility boundary

The existing `Dimension.runCommand` adapter is sufficient for the validated command seam. BedrockWikiMcp confirms the stable signature and no-leading-slash rule. Microsoft Learn confirms the `/structure load` rotation, mirror, entity, and block arguments. No new `@minecraft/server` API is introduced.

## Validation

- Focused red test: required before implementation.
- Focused green assertions: required after implementation.
- JavaScript syntax, beta API type-check, repository validators, structure/NBT validation, full JavaScript regression suite, diagnostics, Creator Tools validation, and packaging: required in GitHub Actions.
