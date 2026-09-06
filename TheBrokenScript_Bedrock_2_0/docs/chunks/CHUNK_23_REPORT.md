# Chunk 23 — Integrity Phase 3 GroundAttack/GroundArm adapter

## Delivered

- Added source-backed `GROUND_ATTACK_SOURCE` and `GROUND_ARM_SOURCE` contracts plus pure model functions for attack eligibility, target capture/spawn timing, impact vectors, and arm lifecycle.
- Wired a bounded GroundAttack runtime adapter into Phase 3: players in the inclusive 40–80 range are selected, the target block is captured at tick 33, and an owned `integrity_arm` is spawned at tick 40.
- Replaced the old generic arm lifetime/melee pulse with the source GroundArm lifecycle: owner validation, tick-5 player impacts, owner damage attribution, knockback impulse, owner-stuck propagation, and tentacle-proximity cleanup.
- Removed `minecraft:persistent` from the GroundArm definition so source transient-arm behavior is represented by both data and controller cleanup.
- Added regression coverage and documented the runtime-map and radius-contact adaptations.

## Validation

- TDD red phase observed before implementation for the missing controller/definition contracts.
- `npm test`: **26 passed, 0 failed**.
- `node --check` passed for `integrity_arena_model.js` and `boss_controller.js`.
- `integrity_arm.json` parsed successfully.

## Remaining work

The complete Phase3Goals attack selector, Fireball/TentacleSwipe/Gravity/Tentacles attack parity, Java synchronized owner IDs, exact bounding-box contact, and remaining Integrity/Jimmy/Kerfur lifecycle work remain separate slices or documented engine gaps.
