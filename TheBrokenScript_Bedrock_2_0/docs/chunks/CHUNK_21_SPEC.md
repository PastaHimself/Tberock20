# Chunk 21 — Integrity Phase 3 runtime semantics

Date: 2026-08-29

## Source slice

Port the source-backed Phase 3 behavior that was still missing from the Bedrock controller:

- decompiled/net/thebrokenscript/boss/integrity/Phase3.java ring candidate math and three fixed tentacles.
- decompiled/net/thebrokenscript/boss/integrity/Phase3.java y>90 Stage3 boundary countdown and terminal damage.
- decompiled/net/thebrokenscript/boss/integrity/FinalCutscene.java timing/path model, without claiming Java client transport parity.

## Acceptance criteria

1. Candidate indexes are inclusive 0..250, with source angle step 0.025132742 and random radius 100..123.
2. The three preset tentacles remain at (162,-59,232), (186,-59,181), and (228,-59,213), with preset SCALE 2 preserved by the controller fallback state.
3. Boundary state starts at 60 ticks, decrements on the insertion tick, drops players who return to y≤90 or leave the Stage3 dimension, and emits terminal damage only at zero.
4. The old fabricated Phase 3 melee/fireball volley is removed.
5. FinalCutscene constants and interpolation/blackout windows are testable without @minecraft/server.
6. Source-specific limitations are recorded in the persistent parity/adaptation documents.

## Explicit non-scope

- Recovering the Java Arena callsite and participant roster/phase lifecycle.
- Reproducing Java custom packets, transition texture overlays, music payloads, or client camera overrides.
- Implementing the blocked Stage2 custom chunk generator, ground-arm owner propagation, Jimmy, or Kerfur parity.

## Validation plan

Run the focused Node regression suite, package-wide JavaScript syntax checks for touched runtime/model files, JSON parsing for touched definitions, then rely on GitHub Actions for the repository-wide add-on validators and typecheck.
