# Chunk 21 — Integrity Phase 3 runtime semantics

Date: 2026-08-29

## Outcome

This pass replaces the fabricated Integrity Phase 3 fireball/melee behavior with the source's actual flailing-tentacle ring and boundary-kill contract. It also records the exact final cutscene schedule as a pure model so the Java-only client path is not silently approximated as a different timeline.

## Decompiled-source evidence

- decompiled/net/thebrokenscript/boss/integrity/Phase3.java uses IntRange(0, 250), so there are 251 candidate iterations. Each candidate uses Random.nextInt(100, 124), angle step 0.025132742, and circle center (200, 202). It then adds fixed tentacles at (162,-59,232), (186,-59,181), and (228,-59,213) with SCALE 2.
- The same source tracks players with y>90 in the Stage3 dimension, inserts a 60-tick pending kill, retains only players still above the boundary, decrements each tick, and applies 1,000,000 void_mass damage at zero.
- decompiled/net/thebrokenscript/boss/integrity/FinalCutscene.java defines PRE_LENGTH 108, LENGTH 190, ZOOM_LENGTH 100, OFFSET 10, BLACKOUT_TICKS 40, TOTAL_LENGTH 428, positions (194,-45,169) to (194,10,199), and rotations (0,10) to (0,-90).

## Shipped implementation

- integrity_arena_model.js now exposes the Phase 3 candidate-position function, serializable boundary countdown step, cutscene constants, and interpolated cutscene state.
- boss_controller.js now spawns the source ring once per Phase 3 entity, adds the three preset tentacles, and applies the source countdown to players currently sharing the boss dimension. Terminal damage uses Bedrock's native EntityDamageCause.void because the custom void_mass damage type is unavailable.
- The prior fabricated Phase 3 melee pulse, five-second fireball volley, and random ground-arm summon are removed.

## Validation

- npm test: 23/23 passing locally.
- node --check: touched model and boss controller pass.
- JSON parsing: no entity JSON was changed in this chunk.
- GitHub Actions run 33259723699: complete workflow passed, including add-on validation, resource links, Jigsaw/NBT checks, syntax, beta-API typecheck, regressions, Blockception diagnostics, Creator Tools validation, packaging, and artifact/report upload.

## Parity and remaining gaps

Status remains in_progress with approximation parity for the boss family. The deterministic tentacle geometry, preset positions, boundary timing, and cutscene timing model are source-backed. Java Arena startup/participant transfer, the transition overlay, music/cutscene packet delivery, client camera override, custom damage attribution, delayed cleanup, Stage2 placement, exposed SCALE, ground-arm owner propagation, Jimmy, and Kerfur remain documented gaps.

## Files

- BP/scripts/systems/integrity_arena_model.js
- BP/scripts/entities/boss/boss_controller.js
- tests/integrity_arena_model.test.mjs
- docs/chunks/CHUNK_21_SPEC.md
- docs/chunks/CHUNK_21_REPORT.md
