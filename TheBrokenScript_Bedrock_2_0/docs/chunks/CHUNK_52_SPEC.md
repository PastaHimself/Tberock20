# Chunk 52 — Integrity Phase 2 recovery routing

## Scope

Continue the Integrity Arena lifecycle after Chunk 51's Phase 2 Stage2 transfer adapter.

## Source contract

- Phase2.tick runs once per Arena tick after Phase 2 begins.
- Participants with block Y in the inclusive/exclusive range 190 <= Y < 199 are teleported to (85.5, 162.5, 87.5).
- The lowest participant is selected from players with block Y > 103; ties keep the first participant in the existing roster order.
- The selected Y maps through Phase2Floors.fromY. Floor 6 maps to Stage2Floor.FLOOR_6_INTEG, not Stage2Floor.FLOOR_6.
- The selected floor is later used for tether-gated Integrity placement.

## Bedrock design

- integrity_arena_model.js owns the pure selector and reuses the recovered Phase2 source/floor constants.
- integrity_arena_runtime.js accepts Phase 2 as an active arena phase, performs the supported recovery teleport, and records the lowest participant id and mapped Phase 2 floor id.
- ported_features.js schedules the arena tick at one-tick cadence, matching the server-side Phase2.tick lifecycle.
- Stage2 floor entity spawning, safe-block scanning, Tether queries, random Integrity placement, and Stage2Generator occupancy remain deferred to a later slice.

## Acceptance criteria

1. Focused regressions cover recovery Y boundaries, the Y > 103 eligibility threshold, first tie behavior, and Floor 6 special mapping.
2. The supported scheduler reaches Phase 2 ticks after the 20-tick transfer.
3. Recovery uses Entity.teleport with supported options and preserves the current dimension.
4. The runtime remains safe for invalid/missing player locations and failed teleports.
5. Deferred Stage2 generation/entity placement is explicit in the parity ledger.
