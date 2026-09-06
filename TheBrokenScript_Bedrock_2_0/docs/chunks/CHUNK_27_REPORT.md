# Chunk 27 report — Integrity Phase 3 damage/death lifecycle

## Ported

- Added source constants and pure damage/death rules to `phase3_attack_model.js`.
- Added a filtered Phase 3 `EntityHurtBeforeEvent` adapter with one-time damage rewriting/cancellation and deferred restricted-context state changes.
- Added player/fireball damage caps, hurt-frame immunity, mace-smash parry and durability break, kill-cause death entry, center teleport, attack freeze, and source-backed 298-tick cleanup.
- Corrected Phase 3 initialization to the Java attack-delay default of 100 ticks.

## Validation

- Phase 3 lifecycle suite: 10 tests passed.
- Cumulative materialized Node suite: 32 tests passed.
- `node --check` passed for the Phase 3 model/runtime.
- Phase 3 entity JSON and Chord entity JSON parsed successfully.
- `bedrock_debugger.py` reported 0 errors and 0 warnings on the materialized pack.
- No Bedrock runtime world is installed locally; CI/device runtime smoke testing remains pending.

## Source and API evidence

- Java: `decompiled/net/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity.java`.
- [`EntityHurtBeforeEvent`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityhurtbeforeevent?view=minecraft-bedrock-stable) exposes writable `damage` and `cancel`.
- [`EntityDamageSource`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entitydamagesource?view=minecraft-bedrock-stable) exposes `cause` and `damagingEntity`.
- [`EntityDamageCause`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entitydamagecause?view=minecraft-bedrock-stable) supplies `void`, `selfDestruct`, `override`, and `maceSmash`.
- [`System.run`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/system?view=minecraft-bedrock-stable) defers gameplay mutations from the restricted before-event callback.
- [`EntityEquippableComponent`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityequippablecomponent?view=minecraft-bedrock-stable) and [`ItemDurabilityComponent`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/itemdurabilitycomponent?view=minecraft-bedrock-stable) support the mace-break adapter.
