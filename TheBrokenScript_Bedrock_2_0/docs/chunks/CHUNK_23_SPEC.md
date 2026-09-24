# Chunk 23 — Integrity Phase 3 GroundAttack/GroundArm adapter

## Scope

Port the next isolated Integrity Phase 3 source slice: `GroundAttack` target timing and `IntegrityP3GroundArmEntity` ownership, impact, stuck propagation, and lifecycle behavior.

## Source contract

- `GroundAttack` is usable at inclusive distances 40–80, has a 70-tick cooldown, cannot move, and lasts 175 ticks normally or 260 ticks while the Integrity entity is stuck.
- The attack captures the target block at tick 33 and creates an `IntegrityP3GroundArmEntity` at tick 40, assigning the Integrity entity as owner.
- GroundArm impacts intersecting players at tick 5 for 15 damage with horizontal strength 1.5 and upward strength 2.6.
- GroundArm forwards its stuck state to its owner, is not persistent, and discards if its owner is unavailable or after the source tentacle-proximity thresholds (`>40` without a nearby tentacle, `>180` with one).

## Bedrock design

- Pure timing, range, impact, and lifecycle functions live in `integrity_arena_model.js` and are regression-tested independently of Minecraft.
- `boss_controller.js` runs the GroundAttack adapter from `tickIntegrityP3`, keeps the owner relationship in a guarded `arm.id → owner` map, and spawns owned arms at the captured block position.
- GroundArm uses `Dimension.getEntities` with the source five-block/20-block radii, `applyDamage` through the owner, `applyImpulse`, and guarded `remove` calls.
- `integrity_arm.json` omits `minecraft:persistent`, matching the source `shouldBeSaved=false` / `isPersistenceRequired=false` contract.

## Explicit differences

- Bedrock entity IDs are opaque strings; the source synchronized integer owner field is represented by a runtime-only map.
- Bedrock does not expose Java `AABB.intersects`; the five-block query is a radius-based player-contact approximation.
- The complete `Phase3Goals` multi-attack selector and the other Phase 3 attack classes are not included in this bounded slice.

## Acceptance tests

- GroundAttack constants and inclusive range/timing behavior are covered by `tests/integrity_arena_model.test.mjs`.
- GroundArm impact vector, owner absence, tick-5 impact, and `>40`/`>180` lifecycle boundaries are covered by the same suite.
- The controller wiring and non-persistent entity definition are asserted statically.
