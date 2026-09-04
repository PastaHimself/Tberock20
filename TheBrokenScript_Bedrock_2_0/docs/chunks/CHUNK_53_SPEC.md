# Chunk 53 — Integrity Phase 2 Stage 2 runtime

## Scope

Port the remaining portable Integrity Phase 2 Stage 2 runtime after Chunk 52's recovery routing.

## Source contract

- Phase2.checkFloorSpawns runs for each participant once Phase 2 is active.
- Participants must be in thebrokenscript:stage2 and have the Phase 2 loading flag clear.
- Stage2Floor.fromY preserves the inclusive Floor 1–7 bands; Floor 7 does not spawn until the Phase 2 Integrity entity exists.
- A floor is marked spawned before the source entity loop, so each Stage2 floor is one-shot per Phase 2 lifecycle.
- Stage2Util uses the existing 10×10 chunk cell, center chunk offset 5, floor-specific minimum chunk distance, up to 40 attempts, and a four-block downward scan.
- The source valid-floor predicate rejects air/replaceable blocks and accepts an upward-standable block or barrier/mud exception; offsets 1, 2, and 3 above the candidate must be replaceable.
- Phase2Floors.fromY maps Integrity Floor 6 to Stage2Floor.FLOOR_6_INTEG, while Stage2 floor spawn lookup still resolves Y 160–180 to FLOOR_6.
- Integrity placement waits for a live Tether in the target floor when that Stage2 floor has a Tether spawn, rejects candidate positions within 50 blocks of a Tether, and advances the placed-floor state only after a successful teleport.
- Stage2Generator.java remains a custom Java chunk generator and must stay explicitly documented as unavailable in the static Bedrock void dimension.

## Bedrock design

- integrity_arena_model.js owns the pure floor-transition and Integrity-placement decisions.
- integrity_arena_runtime.js owns loaded-block scanning, Stage2 entity spawning, floor-volume Tether detection, proximity exclusion, and supported entity teleports.
- phase2TargetFloor records the current lowest-player target; phase2IntegrityFloor records only a successful Integrity placement.
- Existing ported_features.js one-tick scheduling remains the Phase 2 tick cadence.
- stage2.json remains void; no exact Java room/template generation is claimed.

## Focused acceptance tests

1. First Stage2 floor transition is planned once and Floor 7 is gated on Integrity.
2. Loading/dimension gates and one-shot floor state are preserved.
3. Tether-gated placement waits, then places; Floor 6 uses FLOOR_6_INTEG without a Tether requirement.
4. Safe scanning returns the block above the first valid floor and rejects blocked clearance.
5. Runtime source wiring includes supported block, entity, query, spawn, and teleport seams.

## API evidence

- Microsoft Learn and BedrockWikiMcp verified Entity.getDynamicProperty, Dimension.getBlock, Block.isAir, Block.isLiquid, Dimension.getEntities, EntityQueryOptions.volume, EntityQueryOptions.maxDistance, Dimension.spawnEntity, and Entity.teleport for the project beta channel.
