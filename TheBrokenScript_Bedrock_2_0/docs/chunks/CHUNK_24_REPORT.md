# Chunk 24 report — Phase 3 Fireball + selector

## Implemented

- Added a pure Phase 3 implemented-subset attack selector with the Java `Phase3Goals` gates, previous-attack exclusion, distance filtering, and weighted selection.
- Added source constants for `FireballAttack` and `IntegFireballEntity`.
- Added a dedicated Phase 3 runtime that owns Integrity Phase 3, its GroundArm entities, and its Fireball projectiles.
- Preserved the Chunk 23 GroundAttack/GroundArm timing and impact model inside the dedicated runtime.
- Corrected Fireball runtime behavior from the legacy 0.8-speed / 12-damage proximity projectile to source-backed 1.6-speed, 6 direct entity-hit damage, and a power-5 non-destructive/non-incendiary explosion.
- Moved the three runtime-owned entity definitions to `thebrokenscript_phase3_runtime` so the old generic boss tick cannot double-process them.
- Registered the dedicated runtime from `BP/scripts/main.js`.

## Validation

- `node --check` passed for `phase3_attack_model.js`, `phase3_runtime.js`, and the updated `main.js`.
- New `phase3_attack_model.test.mjs`: 7/7 tests passed in a local isolated harness using the existing GroundAttack contract.
- All modified entity JSON files parsed successfully with `python -m json.tool`.
- Current Microsoft Creator documentation confirms `Dimension.createExplosion` accepts `breaksBlocks`, `causesFire`, and `source`, which are the options used by this adapter.

## Remaining Phase 3 work

The full Java attack table still contains three unported active attacks:

- `TentacleSwipeAttack`
- `GravityAttack`
- `TentaclesAttack`

Until those are implemented, the selector's probabilities are exact only relative to the currently implemented GroundAttack + Fireball subset. The GeckoLib `ballin;` keyframe/bone world transform remains an explicit Bedrock engine adaptation.
