# Chunk 61 Specification — Integrity Phase 2 Stage 2 stone7 asset

## Scope

Port the sixth rare Floor 4 Stage 2 structure variant from the Java source audit into the Bedrock asset catalog. This chunk is isolated to the source-backed stone7 template contract and its validated .mcstructure asset.

## Source contract

- Java branch: Stage2Generator.genRoom Floor 4 special/rare branch, variant 6.
- Source blob: source_extracted/data/thebrokenscript/structure/stone7.nbt
- Source blob SHA: 2446bc420007c6daa7e78a1cf6edcecac2ffbdc8
- DataVersion: 3955.
- Size: 16×3×16 (768 cells).
- Palette/state counts: 256 minecraft:stone, 32 minecraft:smooth_stone, 480 minecraft:air.
- Entities and block entities: none.
- Placement: Floor 4 Y 233; rare variant 6 resolves to stone7.

## Bedrock contract

- Asset: BP/structures/thebrokenscript/stage2/stone7.mcstructure.
- Format version: 1, little-endian NBT.
- Primary palette: minecraft:stone, minecraft:smooth_stone, minecraft:air.
- Two block-index layers: primary indices plus secondary -1 placeholders.
- Placement plan: block-only, no mirror, includeEntities=false, includeBlocks=true.
- Command seam: structure load thebrokenscript:stage2/stone7 <x> <y> <z> 0_degrees none false true.

## Acceptance tests

1. The model maps stage2GeneratorFloor4Structure(true, true, 6) to stone7.
2. The model exposes the exact source metadata and audited counts.
3. The placement plan preserves Y 233, the 16×3×16 size, no mirror, and block-only loading.
4. The generated .mcstructure begins with a compound NBT root, contains stone and smooth_stone palette entries, is larger than 2000 bytes, and has no armor-stand entity identifier.
5. The source generator limitation remains documented: Bedrock static dimension JSON cannot reproduce Java custom chunk generation, automatic structure placement, occupancy/RNG, or FRONT_BACK mirroring exactly.

## API evidence

No new @minecraft/server API is introduced. The existing Dimension.runCommand(commandString) seam was rechecked with BedrockWikiMcp; Microsoft Learn's stable /structure command reference (https://learn.microsoft.com/minecraft/creator/reference/content/commandsreference/examples/commands/structure?view=minecraft-bedrock-stable) verifies the rotation enum and entity/block boolean arguments used by the command contract.

## Out of scope

Automatic Phase 2 template scheduling, remaining 57 templates, exact Java custom-generator behavior, live Bedrock-world smoke testing, and pull-request merge.
