# Chunk 53 — Integrity Phase 2 Stage 2 runtime

## Result

Chunk 53 ports the portable Stage 2 portion of Integrity Phase 2. The runtime now tracks one-shot floor transitions, spawns the source Tether/Integrity Phase 2 entities when a loaded safe position is available, detects target-floor Tethers, rejects Integrity positions within the source 50-block Tether exclusion radius, and commits the Phase 2 floor state only after a successful Integrity teleport. Floor 1–7 boundaries and Floor 6 → FLOOR_6_INTEG remain distinct.

The Java Stage2Generator is explicitly not executed. stage2.json remains a void dimension, so exact room/template/occupancy generation is still a documented engine boundary.

## Source-to-Bedrock mapping

| Source path | Bedrock adapter | Preserved contract | Explicit adaptation |
|---|---|---|---|
| Stage2Floor.fromY / Phase2.checkFloorSpawns | phase2Stage2FloorStep + tickPhaseTwo | Floor 1–7 bands, one-shot state, Stage2/loading gates, Floor 7 Integrity prerequisite | roster is the active-arena participant list |
| Stage2Util.spawnFloorEntities | spawnStage2FloorEntities | Tether/Integrity Phase 2 spawn IDs, source cell math, floor-specific safe-position attempts | Bedrock spawns after a safe read instead of Java entity construction/finalized spawn |
| Stage2Util.findSafeChunkPos | stage2FindSafeSpawnY + runtime block adapter | 40 attempts, four-level scan, three-block clearance, special Y-band coordinate rule | air-only clearance and non-air/non-liquid standable approximation |
| Phase2.hasTetherOnFloor | hasTetherOnFloor | 160×160 cell query, target floor Y range, live Tether gate | supported Dimension.getEntities({ volume }) query over loaded Bedrock blocks |
| Phase2.teleportIntegrityTo / Stage2Util.getRandomFloorPos | findRandomIntegrityStage2BlockPosition + placeIntegrityForLowestPlayer | target-floor state, Tether exclusion radius 50, center teleport, retry behavior | supported Entity.teleport; Java Stage2Generator/occupancy is unavailable |

## Tests and validation

- TDD red was observed before implementation: the new focused test failed because phase2Stage2FloorStep was undefined.
- Focused local suite: 5/5 passed.
- Changed model/runtime JavaScript: node --check passed.
- Microsoft Learn and BedrockWikiMcp verified every new Script API used by the adapter.
- GitHub Actions run 33889515640 was inspected: all substantive validation, type-check, JavaScript tests, diagnostics, Creator Tools, and packaging passed; only artifact uploads failed because the repository quota was exhausted. Chunk 53 changes both upload steps to best-effort; PR CI for this branch is pending.
- Bedrock world/runtime smoke testing remains unavailable locally.

## Remaining task

Port or otherwise resolve the Java-only Stage2Generator custom chunk generation/occupancy behavior, then validate the full Phase 2 lifecycle in a live Bedrock world. Native Java PlayerVariables, music/camera/packet presentation, and exact Java block predicates remain explicit adaptations.
