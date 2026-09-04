# Chunk 51 — Integrity Phase 2 transfer

## Result

Chunk 51 adds the first Arena phase-advancement handoff. Once Phase 1's tracked Chord roster has spawned and no Chords remain living, the Bedrock runtime removes the Phase 1 entity and Chords, clears the terrain queue and custom sky state, and schedules the participant roster for transfer after the recovered 20-tick delay. Participants are moved to the existing void-backed thebrokenscript:stage2 dimension using Entity.teleport with TeleportOptions.dimension.

## Source-to-Bedrock mapping

| Source path | Bedrock adapter | Preserved contract | Explicit adaptation |
|---|---|---|---|
| Arena.java / ArenaPhase.java | integrity_arena_runtime.js | Phase 1 completion advances to Phase 2 | later Phase2 gameplay remains separate |
| Phase1.java | integrity_phase2_transfer_model.js + runtime | Chord roster is the completion gate; Phase 1 cleanup | Bedrock entity validity/health seam |
| Phase2.java start | integrity_phase2_transfer_model.js + runtime | 20-tick delay and participant transfer to Stage2 | PlayerVariables/custom packets are dynamic state/supported teleport |
| Stage2 dimension | BP/dimensions/stage2.json | existing target dimension id | Java Stage2Generator and floor population remain deferred |

## Evidence and tests

- Arena.java, ArenaPhase.java, Phase1.java, Phase2.java, ArenaDimensionHandler.java, and the existing Stage2 dimension were compared with the adapter.
- Focused TDD transfer model tests: 4/4 pass.
- Changed model/runtime syntax checks pass locally.
- Repository beta type-check, regression, Blockception, Creator Tools, and packaging gates are running on the PR.
- Bedrock world/runtime smoke testing remains unavailable.

## Remaining differences

Stage2Generator/floor templates, tether-gated floor movement, Phase 2 entity lifecycle/goals, PlayerVariables parity, and native music/camera/packet presentation remain explicit adaptations or deferred source boundaries.
