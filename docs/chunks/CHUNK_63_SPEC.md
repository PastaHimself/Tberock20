# Chunk 63 Specification — Stage 2 Floor 2 `clandimensionroom2`

## Objective

Port the next isolated Integrity Phase 2 Stage 2 template boundary: Java Floor 2 variant 2 (`clandimensionroom2`) as a source-backed Bedrock structure asset and validated placement/catalog contract.

## Source evidence

- `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Generator.java`
  - Floor 2 chooses variants 1–5.
  - Variant 2 selects `clandimensionroom2`.
  - Floor 2 structures are placed at Y=207.
- `TheBrokenScript_Bedrock_2_0/STAGE2_GENERATOR_AUDIT.json`
  - source blob SHA: `d555dff8e0c3d45d9509e9b281323d1042e54063`
  - Java DataVersion: 3955
  - size: 16×9×16
  - palette: air and cobblestone
  - 2,304 blocks, zero entities, zero block entities
- Direct source-NBT parse:
  - 799 cobblestone blocks
  - 1,505 air blocks

## Acceptance criteria

1. A focused test fails before implementation because the variant-2 catalog entry and asset are absent.
2. `stage2GeneratorFloor2Structure(2, false)` returns `clandimensionroom2`.
3. The catalog records the source SHA, dimensions, palette, counts, Y=207 placement, and `floor2_variant_2` role.
4. `BP/structures/thebrokenscript/stage2/clandimensionroom2.mcstructure` is a valid uncompressed Bedrock structure with format version 1, the source dimensions, the source palette, 799 non-air primary blocks, and no entities.
5. The placement contract emits:
   `structure load thebrokenscript:stage2/clandimensionroom2 <x> 207 <z> 0_degrees none false true`.
6. The asset audit advances to 9 validated and 55 deferred templates.
7. The Java custom `Stage2Generator` limitation remains explicit; this chunk does not claim automatic chunk-generation parity.

## Bedrock compatibility boundary

The existing `Dimension.runCommand` adapter is sufficient for the validated command seam. BedrockWikiMcp confirms the stable signature and no-leading-slash rule. Microsoft Learn confirms the `/structure load` rotation, mirror, entity, and block arguments. No new `@minecraft/server` API is introduced.

## Validation

- Focused red test: required before implementation.
- Focused green assertions: required after implementation.
- JavaScript syntax, beta API type-check, repository validators, structure/NBT validation, full JavaScript regression suite, diagnostics, Creator Tools validation, and packaging: required in GitHub Actions.
