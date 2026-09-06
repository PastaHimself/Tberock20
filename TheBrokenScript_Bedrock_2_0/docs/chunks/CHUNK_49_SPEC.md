# Chunk 49 — Integrity Arena startup handoff

## Objective

Continue the Chunk 48 corrupted-command-block path through the recovered CorruptedCommandBlockConfirmPacket and the portable portion of Arena.Companion.start → Arena.start → Phase1.start.

## Source contract

- An existing Arena with no living participants restarts its current phase and returns.
- Otherwise the packet samples each offset with nextInt(-20, 20) until the accepted range [-10, 10].
- The center is the command-block X/Z plus those offsets and the MOTION_BLOCKING_NO_LEAVES surface height.
- Participants are captured from the same server level within 150 blocks of center.getCenter().
- The server schedules a 40-tick preparation step, then a nested 60-tick delay before Arena.start().
- The preparation step sets fake midnight and each participant's custom sky to (70, 0, 0).
- Phase 1 spawns the Integrity entity at the surface, keeps it in its intro state for 1080 ticks, then spawns 10 Chords in a radius of 10.
- Phase 1 remains invulnerable while its tracked Chord predicate is true.

## Bedrock design

- integrity_arena_start_model.js is pure and testable; it owns startup constants, offset sampling, center math, participant filtering, and the restart/create plan.
- integrity_arena_runtime.js is the server adapter reached by the confirmation form. It uses Dimension.getTopmostBlock, world.setTimeOfDay, dynamic properties, system.runTimeout, and existing integrity_phase_1/chord entities.
- boss_controller.js honors the 1080-tick intro gate and the source Chord-gated Phase 1 damage protection.
- The Phase 1 entity definition declares no gravity, matching the source setNoGravity(true) startup step.

## Explicit adaptations

- Bedrock has no Java packet path, FakeTimeOfDay, per-player custom sky renderer, custom crawl/no-AI entity data, Java terrain-corruption queue, Arena phase transfer, or custom camera/music packet transport.
- The adapter uses global midnight during the active arena and player dynamic-property markers for the source sky values; the original world time is restored when the active arena resets.
- Phase 2/3 transfer and remaining Arena tick/cleanup semantics are intentionally outside this vertical slice.

## Acceptance criteria

- The confirmation Yes action reaches the startup adapter.
- Source startup constants and branch order are covered by deterministic tests.
- The supported runtime starts Phase 1 on the recovered timing sequence.
- Phase 1 intro damage is gated and Chord spawning is source-sized.
- Source/runtime differences remain explicitly documented.
