# Chunk 35 — Fractured animation timeline and presentation bridge

## Delivered

- Added a pure source-backed animation model for `OffenseStompShockwave`, `OffenseSlam`, `MoonRockToss`, and `DefenseAirLift`.
- Preserved source clip lengths and instruction seconds, converting events to deterministic 20 Hz ticks: stomp 13, slam 25, rock grab 28, rock throw 105, and rock release 45.
- Wired the dedicated Fractured runtime to Bedrock `Entity.playAnimation` for attack, defeat, and Roam lifecycle presentation.
- Preserved the BaseFractured controller mapping: RISING→Spawn, NORMAL idle/moving→Idle/Walk, DIGGING/DESPAWNING/SWITCHING→Flee, UNDERGROUND→Underground, and DEFEATED→Loss.
- Kept the Java render-bone contract for `ROCK`, `right_l_claw`, `left_l_claw`, and `right_f_tarsus` in the pure model.

## Source-to-engine decision

The existing RP animation resources are already present and named for the recovered source clips, so the runtime can request them directly. Gameplay effects now wait for source-derived event ticks instead of using a generic first-tick fallback. Bedrock still has no script-visible GeckoLib world-space bone transform, so impact origins remain the documented spatial adapter.

## Validation

- 18/18 focused Node regressions pass locally.
- Changed animation model and Fractured runtime pass `node --check`.
- Presentation-state mapping, source event ticks, attack animation ids, tracked bones, and runtime bridge assertions pass.
- Bedrock world/runtime smoke testing remains unavailable in this workspace.
