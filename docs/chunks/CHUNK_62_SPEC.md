# Chunk 62 Specification — Integrity Phase 2 Stage 2 clandimensionroom1 asset

## Scope

Port the source-backed Floor 2 variant 1 Stage 2 template into the Bedrock asset catalog. This chunk is isolated to the `clandimensionroom1` source contract, its validated `.mcstructure` asset, and the required ledger/report updates.

## Source contract

- Java branch: `Stage2Generator.genRoom` Floor 2 selection, variant 1.
- Source blob: `source_extracted/data/thebrokenscript/structure/clandimensionroom1.nbt`
- Source blob SHA: `4f30ee7f5f37cfff08ee6e4728fe27e5f62becc2`
- DataVersion: 3955.
- Size: 16×9×16 (2,304 cells).
- Palette/counts: 750 `minecraft:cobblestone`, 1,554 `minecraft:air`.
- Entities and block entities: none.
- Placement: Floor 2 Y 207; variant 1 resolves to `clandimensionroom1`.

## Bedrock contract

- Asset: `TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2/clandimensionroom1.mcstructure`.
- Format version: 1, little-endian NBT.
- Primary palette: `minecraft:cobblestone`, `minecraft:air`.
- Two block-index layers: primary indices plus secondary `-1` placeholders.
- Placement plan: block-only, no mirror, `includeEntities=false`, `includeBlocks=true`.
- Command seam: `structure load thebrokenscript:stage2/clandimensionroom1 <x> <y> <z> 0_degrees none false true`.

## Acceptance tests

1. `stage2GeneratorFloor2Structure(1, false)` resolves to `clandimensionroom1`.
2. The model exposes the exact source metadata, counts, Floor 2 Y 207 placement, and validated status.
3. The placement plan preserves the 16×9×16 size, no-mirror boundary, and block-only loading.
4. The generated `.mcstructure` begins with a compound NBT root, contains cobblestone, is larger than 2,000 bytes, and contains no entity identifiers.
5. The source Java custom-generator boundary remains documented; automatic scheduler placement and exact Java RNG/occupancy/rotation/mirror/border/tunnel/nowhere generation remain deferred.

## API evidence

No new `@minecraft/server` API is introduced. The existing `Dimension.runCommand(commandString)` seam was rechecked with BedrockWikiMcp; Microsoft Learn's stable `/structure` command reference (https://learn.microsoft.com/minecraft/creator/reference/content/commandsreference/examples/commands/structure?view=minecraft-bedrock-stable) verifies the rotation, `none` mirror, and entity/block boolean arguments used by the command contract.

## Out of scope

Automatic Phase 2 template scheduling, the remaining 56 templates, exact Java custom-generator behavior, live Bedrock-world smoke testing, and pull-request merge.
