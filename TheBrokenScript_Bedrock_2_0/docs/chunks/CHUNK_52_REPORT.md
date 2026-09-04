# Chunk 52 — Integrity Phase 2 recovery routing

## Result

Chunk 52 activates the Integrity Arena runtime after the Phase 2 transfer. The existing one-tick scheduler now reaches Phase 2, recovers participants in the source Y 190–198 band to (85.5, 162.5, 87.5), selects the lowest eligible participant using the source Y > 103 threshold and first-tie behavior, and records the recovered Phase 2 floor mapping. Floor 6 correctly resolves to FLOOR_6_INTEG.

## Source-to-Bedrock mapping

| Source path | Bedrock adapter | Preserved contract | Explicit adaptation |
|---|---|---|---|
| Phase2.tick | integrity_arena_runtime.js | Phase 2 is ticked after transfer | Stage2 entity spawning and Integrity movement remain separate |
| Phase2.java recovery filter | integrity_arena_model.js + runtime | 190 <= block Y < 199 and target coordinates | Entity.teleport preserves the current dimension |
| Phase2.java lowestPlayer | integrity_arena_model.js + runtime | block Y > 103 and first tie | player roster is the active-arena participant list |
| Phase2Floors.java / Stage2Floor.java | integrity_arena_model.js | Floor boundaries and Floor 6 → FLOOR_6_INTEG | live Stage2 floor query and entity placement remain deferred |
| ported_features.js scheduler | supported scheduler seam | one-tick arena cadence | live Bedrock-world smoke testing unavailable |

## Evidence and tests

- Phase2.java, Phase2Floors.java, Stage2Floor.java, Stage2Util.java, and the existing Stage2 dimension were compared with the adapter.
- TDD red was observed in PR #26 before implementation: the JavaScript regression step failed because phase2LowestPlayer was not exported.
- Focused model checks pass locally: 7/7.
- Repository validation, beta type-check, JavaScript regressions, Blockception, Creator Tools, and packaging gates are running on PR #26.
- The supported Entity.teleport and TeleportOptions.dimension seam remains documented from the prior transfer slice.
- Bedrock world/runtime smoke testing remains unavailable.

## Remaining differences

Stage2Generator/floor templates, safe-block scanning, floor entity spawning, tether-gated Integrity placement, Phase 2 entity lifecycle/goals, PlayerVariables parity, and native music/camera/packet presentation remain explicit adaptations or deferred source boundaries.
