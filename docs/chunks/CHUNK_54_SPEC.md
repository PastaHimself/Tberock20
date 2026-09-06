# Chunk 54 — Integrity Phase 2 Stage 2 runtime scaffold

## Scope

Add the portable Stage 2 generation seam required for Chunk 53 floor/entity spawning to operate in the existing Bedrock void dimension. Keep Java Stage2Generator custom room/template generation explicitly documented when Bedrock cannot reproduce it exactly.

## Source contract

- Stage2Generator operates over a 10×10 chunk cell (160×160 blocks) and uses the cell origin already recovered by Stage2Util.getCenterOfExistingGeneration.
- Source floor support depends on generated geometry at the seven Stage2Floor.pickSpawnY() bands. The adapter uses the support surface immediately below each spawn Y: 253, 234, 218, 208, 202, 162, and 103.
- genFloor adds source floor layers at Y 199 and 160 and a barrier below each; the runtime scaffold preserves the recovered horizontal barrier layers used by the spawn lifecycle: 251, 232, 216, 206, 102, and 271.
- Java room/template placement remains source-backed but is not claimed as Bedrock parity: 64 NBT templates are present in the source corpus, while stage2.json has only a void generator.
- The scaffold must be air-only, cell-scoped, cached per arena, and retryable when the target chunks are not writable.

## Bedrock design

- integrity_arena_model.js exposes STAGE2_RUNTIME_SCAFFOLD_SOURCE and stage2GeneratorRuntimeVolumes(playerBlock).
- integrity_arena_runtime.js imports the stable BlockVolume class and calls Dimension.fillBlocks for each planned horizontal volume.
- BlockFillOptions.blockFilter.includeTypes = ["minecraft:air"] prevents overwriting existing structures or player-modified blocks.
- stage2ScaffoldCells prevents repeated fills on the one-tick Phase 2 scheduler and remains empty after a failed fill so the next tick retries.
- Floor entity spawning waits for a successful scaffold attempt; the source template/occupancy boundary remains explicit.

## Focused acceptance tests

1. A negative-coordinate player resolves to the correct floor-divided 10×10 cell origin.
2. The plan contains all seven support surfaces and all six recovered barrier Y layers with stable block IDs.
3. Runtime wiring uses BlockVolume, Dimension.fillBlocks, an air-only block filter, per-cell caching, and retry-on-failure seams.
4. Existing Chunk 53 Phase 2 Stage 2 regressions remain green.

## API evidence

- BedrockWikiMcp Dimension.fillBlocks: stable signature accepts BlockVolumeBase, block ID/type/permutation, and optional BlockFillOptions; can throw UnloadedChunksError and is not allowed in restricted execution.
- BedrockWikiMcp BlockVolume.constructor: stable new BlockVolume(from, to).
- BedrockWikiMcp BlockFillOptions.blockFilter: stable fill filter property.
- BedrockWikiMcp/Microsoft Learn BlockFilter.includeTypes: stable air-only inclusion filter.
- Microsoft Learn Dimension.fillBlocks and BlockVolume pages were fetched from the official Minecraft Creator Script API documentation.
