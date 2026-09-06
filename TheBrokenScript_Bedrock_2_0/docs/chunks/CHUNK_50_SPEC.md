# Chunk 50 — Integrity Phase 1 terrain corruption

## Scope

Port the recovered Phase1 terrainQueue/tick behavior after Chunk 49’s Arena startup handoff.

## Source contract

- TerrainCorrupterKt creates an inclusive X/Z disk with radius 100.
- Each candidate is included when random.nextFloat() <= 0.3, then the selected positions are shuffled.
- Phase1 begins with ticksSinceLastCorrupt = 20.
- One queued position is processed every 20 ticks.
- The replacement is selected from TBSTags.TERRAIN_CORRUPT_REPLACE: obsidian, r_3, void_root, and teeth.
- A corrupted_command_block target is skipped after the position is dequeued.
- The intro release adds another freshly generated queue to the remaining queue.

## Bedrock design

- integrity_phase1_terrain_model.js owns pure queue geometry and tick state with injectable random/shuffle/replacement seams.
- integrity_arena_runtime.js owns the live queue, regenerates it at Phase 1 start and appends the post-intro queue, and exposes tickIntegrityArena().
- The existing boss scheduler calls tickIntegrityArena() once per server tick.
- Dimension.getTopmostBlock resolves the target surface, Dimension.getBlock reads it, and Block.setType applies the source replacement ID.
- The four Java registry-tag members are explicit model constants because the repository has no equivalent Bedrock block-tag file for this source tag.

## Non-goals

ChunkCarver generation, exact Java heightmap/registry semantics, Arena phase transfer, native packet/camera/music transport, and live Bedrock world smoke testing remain outside this chunk.

## Acceptance criteria

1. Pure tests cover the source constants, disk/rationing, 20-tick boundary, empty queues, and missing replacement behavior.
2. Phase 1 terrain work is wired through the existing boss tick.
3. Changed scripts pass syntax/type/static validation and the packaged add-on gates.
