# Chunk 27 spec — Integrity Phase 3 damage/death lifecycle

## Scope

Complete the source-backed damage gate and delayed death lifecycle for `IntegrityPhase3Entity`. The existing Phase 3 attack selector/runtime remains the owner of attack timing; this chunk closes the entity's `hurt`, `die`, and `tickDeath` behavior without fabricating a Java health/phase transition.

## Java source contracts

From `IntegrityPhase3Entity.java`:

- a new entity starts with attack delay `100`;
- a dying entity rejects all new damage;
- `FELL_OUT_OF_WORLD` and `GENERIC_KILL` start `die` and return without applying damage;
- while `hurtFrames > 0`, new damage is rejected;
- an `IntegFireballEntity` deals fixed damage `50`;
- player damage is `min(amount / 2, 10)` while normal and `min(amount * 3, 40)` while stuck;
- successful damage gives 30 hurt frames normally or 10 while stuck;
- a mace attack starts an 80-tick parry window, and a mace attack during that window is rejected and breaks the player's mace;
- `die` marks the entity dying, clears its target, finishes the active attack, moves it to `Phase3.CENTER`, and delays the superclass death path by `298` ticks;
- `tickDeath` removes the server entity at the 298-tick boundary.

## Bedrock adapter

`phase3_runtime.js` subscribes once to `world.beforeEvents.entityHurt` and filters strictly to `thebrokenscript:integrity_phase_3`.

- `EntityHurtBeforeEvent.damage` is rewritten for accepted player/fireball damage, so no second script damage call is made.
- Rejected causes are cancelled once. Bedrock `void`, `selfDestruct`, and `override` are mapped to the source void/generic-kill death gate.
- The stable `maceSmash` cause is used as the source mace-attack signal; the main-hand durability component is set to max through `EquipmentSlot.Mainhand` after the restricted callback.
- Because before-event handlers cannot perform gameplay mutations, death teleport/tagging and mace durability writes are deferred through `system.run`.
- A runtime tag plus in-memory state represents the source dying flag. The state stops attack, arena, and projectile work, teleports to the recovered center, and removes the entity after 298 runtime ticks.

The pure rules live in `phase3_attack_model.js` so the Java caps, frame windows, cause gates, and cleanup boundary remain deterministic and independently testable.

## Known differences

The Java `DamageSource` identity and custom death animation/superclass death event are not exposed as an equivalent Bedrock hook. The adapter preserves the gameplay gate, center move, state freeze, and cleanup timing; the Java custom cutscene/camera/packet choreography remains covered by A-011.

## Validation target

- pure lifecycle regressions for every damage branch, hurt-frame gate, mace-parry gate, lethal transition, and 298-tick cleanup;
- syntax/JSON/static add-on validation;
- CI validation after the focused commit is pushed.
