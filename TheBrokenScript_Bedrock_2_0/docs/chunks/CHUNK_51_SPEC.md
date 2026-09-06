# Chunk 51 — Integrity Phase 2 transfer

## Scope

Continue the Integrity Arena lifecycle after Chunk 50's Phase 1 terrain corruption adapter.

## Source contract

- Arena Phase 1 completion is based on the source Chord roster: before Chords spawn the phase remains active; after spawn it ends when no tracked Chords remain living.
- Arena cleans up the finished Phase 1 before advancing to Phase 2.
- Phase2.start clears the custom sky/loading state, starts the Phase 2 music path, and waits 20 ticks.
- The participant roster is sent to TBSDimensions.STAGE2.
- Stage2 floor generation and Phase 2's floor/tether runtime are not part of this handoff.

## Bedrock design

- integrity_phase2_transfer_model.js owns the pure completion predicate, transfer constants, and idempotent staging plan.
- integrity_arena_runtime.js checks the Chord roster from the existing arena tick, tears down Phase 1, clears custom sky, marks Phase 2 staging, and schedules the transfer.
- Entity.teleport preserves each participant's current coordinates while TeleportOptions.dimension selects the existing thebrokenscript:stage2 dimension.
- Dynamic properties represent the source loading/fix-position markers until the remaining Phase 2 player-state bridge is ported.

## Acceptance criteria

1. Pure tests preserve the completion predicate, 20-tick delay, destination id, and participant roster.
2. The existing boss scheduler reaches the transfer once the Chord roster is dead.
3. The runtime uses the supported dimension teleport seam and remains safe when the destination dimension is unavailable.
4. Stage2Generator/floor behavior and native packet/camera/music differences remain explicitly documented.
