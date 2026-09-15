# Integrity boss parity

Audit date: **2026-09-15**  
Scope: Todo item 8, Integrity Arena/Phase 1–3 lifecycle and combat.

This report is the source-to-runtime contract for the Integrity boss. A “ported” behavior below means the gameplay contract is implemented in Bedrock; a Java-only packet, rendered-bone, or custom-damage mechanism is called out as an adapter.

## Source contract

| Source behavior | Bedrock contract |
|---|---|
| Arena participants are selected within a 150-block radius and retained by stable player identity. | integrity_runtime.js builds the roster once, deduplicates IDs, removes disconnected IDs, and filters all Integrity damage targets through boss_hooks.js. Java’s two-player liveness exception is preserved in integrity_runtime_model.js. |
| Phase 1 starts at the surface, keeps the boss in crawl-out/no-AI presentation, waits 1,080 ticks, then spawns at most 10 Chords within radius 10. | The runtime owns the delayed intro and tracked-Chord completion. Phase 1 cannot advance from an HP fraction. |
| Phase 1 terrain corruption uses a circular radius 100 queue with a 20-tick cadence. | The runtime keeps the circular queue/cadence and resolves each partial X/Z position to the dimension’s topmost block before applying the explicit replacement list. |
| Phase 2 transfers players after 20 ticks, recovers players in 190 <= y < 199, uses the fixed recovery location, selects the lowest eligible player only when y > 103, and has no source completion predicate. | integrity_runtime.js owns transfer settling, recovery, Stage 2 floor/tether spawning, lowest-player targeting, 0.85 navigation, 3.5-block melee range, 10-tick attack interval, and forward block clearing. Phase 2 remains active unless explicitly advanced by the source-equivalent operator path. |
| Phase 3 creates 251 candidate positions from indices 0 through 250, with random radius 100 through 123, then uses three fixed presets at scale 2. | integrity_arena_model.js and phase3_runtime.js retain the inclusive candidate count and exclusive upper radius. Tentacle, swipe, gravity, fireball, ground-arm, and idle Noop paths are source-backed adapters. |
| Stage 3 kills players above the exclusive Y boundary 90 after a 60-tick countdown. | The Phase 3 runtime tracks each participant’s pending countdown and applies native void damage at the source timing. |
| Integrity Phase 3 accepts the source damage gates, mace parry cooldown, delayed death, and delayed cleanup. | phase3_runtime.js preserves fireball/player caps, hurt-frame gates, mace parry, Generic Kill/Fell Out dying state, and the 298-tick removal delay. Phase 1/2 ordinary damage is cancelled by integrity_runtime.js. |
| FinalCutscene runs for 428 ticks: 108-tick pre-roll, 190-tick movement, 100-tick zoom, and 40-tick blackout. | phase3CutsceneState and tickFinalCutscene use the same tick model and clear cameras/entities/sounds at completion. |

## Runtime ownership

- BP/scripts/entities/boss/integrity_runtime.js: Arena start/stop/next, stable roster, phase transitions, transfers, Phase 1/2 behavior, victory cutscene, and cleanup.
- BP/scripts/entities/boss/phase3_runtime.js: Phase 3 attack selection, cooldowns, tentacles, GroundAttack/GroundArm lifecycle, fireballs, gravity, swipe, damage attribution, and idle Noop.
- BP/scripts/systems/integrity_arena_model.js: source constants and pure candidate/timing/impact predicates.
- BP/scripts/systems/integrity_runtime_model.js: pure roster, intro, Phase 1 completion, Stage 2, and dimension-settle contracts.
- BP/scripts/systems/boss_hooks.js: active arena state and participant ownership.
- BP/scripts/main.js and BP/scripts/systems/commands.js: runtime startup and operator delegation.

## Explicit Bedrock adaptations

| Java-only mechanism | Shipped Bedrock adaptation |
|---|---|
| Transition overlay, music packets, and end-cutscene packets | Native per-player sounds, stopsound, camera fade, and the supported free-camera preset. Tick ordering is preserved; packet identity is not. |
| Client camera packet / exact camera interpolation | integrity_camera.js uses Player.camera.setCamera and clear; the source position/rotation schedule is retained. |
| Custom void_mass damage type | Native void/override causes are used with the source ID retained by the existing damage-source adapter where applicable. Exact death text, exhaustion, and bypass flags cannot be registered from Script API. |
| Synchronized integer owner field | Runtime owner maps plus arena tags preserve owner exclusion and cleanup. Bedrock entity IDs are opaque strings. |
| Rendered child-bone and exact AABB contact | Logical participant filtering and conceptual swept geometry are used because the Script API does not expose Java child parts or rendered-bone impact coordinates. |
| TerrainCorrupter replacement tag | A documented explicit block replacement list is applied to the topmost block at each queued X/Z coordinate. |

## Verification

GitHub Actions runs the focused Integrity boss parity gate in addition to the full JavaScript regression suite. The gate covers the Arena model, encounter model, Phase 3 attack/lifecycle models, runtime timing/roster models, and runtime wiring contracts. The same branch is also checked by JavaScript syntax, Bedrock beta API type-checking, add-on validation, resource-link validation, and the source-to-runtime audit.
