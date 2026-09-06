# Chunk 49 — Integrity Arena startup handoff

## Result

Chunk 49 is implemented on the stacked branch. The corrupted-command-block confirmation now reaches a source-backed startup adapter: it chooses the bounded surface center, captures the same-dimension 150-block participant roster, applies the 40+60 tick staging sequence, spawns the existing Bedrock Integrity Phase 1 entity, preserves the 1080-tick intro gate, spawns the source-sized Chord roster, and protects Phase 1 while the source Chord invulnerability predicate is true.

## Source-to-Bedrock mapping

| Source path | Bedrock adapter | Preserved contract | Explicit adaptation |
|---|---|---|---|
| CorruptedCommandBlockConfirmPacket | ported_features.js + integrity_arena_runtime.js | Yes action, existing-empty restart branch, bounded offsets, surface center, 150-block roster, 40+60 tick schedule | native packet payload/transport and Java broadcast component |
| Arena.Companion.start / Arena.start | integrity_arena_start_model.js + integrity_arena_runtime.js | reset/create handoff, Phase 1 start | Arena singleton is an in-memory adapter; later phase transfer remains deferred |
| Phase1.start | integrity_arena_runtime.js + integrity_phase_1.json | surface spawn, no-gravity setup, Phase 1 intro, 10 Chords/radius 10, 1080-tick release | custom crawl/no-AI data, terrain corruption queue, exact custom music packet |
| IntegrityPhase1Entity.isInvulnerable | boss_controller.js + runtime Chord tracking | Chord-gated Phase 1 damage protection | exact Java entity data/goal implementation |

## Evidence and tests

- Recovered Arena.java, Phase1.java, IntegrityPhase1Entity.java, and CorruptedCommandBlockConfirmPacket.java were compared with the adapter.
- Focused TDD startup model tests: 6/6 pass, including runtime wiring.
- Changed runtime/model/controller JavaScript syntax checks pass locally.
- GitHub Actions [run 33877651299](https://github.com/PastaHimself/tbs-2.0/actions/runs/33877651299) passed validator unit tests, complete add-on/resource/Jigsaw/structure checks, JavaScript syntax, beta type-check, JavaScript regressions, Blockception diagnostics, Creator Tools validation, and `.mcaddon` packaging; only artifact uploads failed because the repository artifact storage quota is exhausted. Bedrock world/runtime smoke testing remains unavailable.

## Remaining differences

Per-player fake time/custom sky, Java packet/camera/music transport, custom crawl/no-AI entity data, terrain corruption, and the later Phase 2/3 Arena transfer remain explicit adaptations or deferred source boundaries.
