# Chunk 28 spec — Fractured/Jimmy attack lifecycle

## Scope

Port the recoverable Java lifecycle for FracturedEntity, JimAttackSelectorGoal, the four concrete attack classes, and RockEntity into a dedicated Bedrock runtime. The generic boss loop must release Fractured and Rock ownership so each entity has one scheduler, one damage adapter, and one collision owner.

## Authoritative Java contracts

The implementation is grounded in the decompiled source classes:

- FracturedEntity starts with attack id NOOP, attack delay 100, attack ticks 0, attacked cooldown 0, and defeat progress 0.
- JimAttackSelectorGoal selects only when a target exists, the current attack is NOOP, and attack delay is non-positive. Candidates are the source attack map with their equal chance 1.0; the source subtract-then-tests the roll, so upper bucket boundaries remain inclusive.
- StompAttack lasts 78 ticks. At attack tick 13 it uses the transformed local offset (26.25, 0, -164.125), radius 5, damage 5, and knockback strength 2.
- SlamAttack lasts 78 ticks; its two JimmySlamHitPacket keyframes each affect grounded players in radius 512, with damage 12 and knockback 30.
- SingleStomp is a separate JimmyBigStompPacket: grounded players in radius 64 receive damage 12 and knockback 5.
- MoonRockTossAttack lasts 139 ticks and cools down for 20. Its rock is launched toward the target's interpolated getY(0.5) position at speed 8 with inaccuracy 0, and RockEntity uses base damage 15.
- AirLiftAttack lasts 60 ticks. Its stationary rock schedules the source RockDropPacket pulse after 25 ticks; the pulse uses radius 32, grounded-only filtering, damage 12, and knockback 10.
- RockEntity keeps the source 15 damage and inflated living-target hit test (4 blocks), excludes its owner, applies the Elytra durability side effect, and discards one tick after a block impact. The source's 400 moonstone-particle burst has no matching asset/API hook and remains an explicit presentation adapter.
- Six accepted SUB_ANOM_2 progress hits transition the entity to the source defeated state. Bedrock has no multipart FracturedPartEntity or custom source registration, so player melee is the explicit progress signal adapter while projectile damage is treated as a broad body-hit adapter.

## Bedrock ownership and adaptation

- fractured.json and rock.json move to dedicated runtime families without the generic thebrokenscript_boss family. Rock also has no native minecraft:projectile component; the runtime owns its substepped collision path.
- main.js starts fractured_runtime.js once per world load. boss_controller.js retains fractured_roam behavior but no longer dispatches Fractured or Rock.
- fractured_attack_model.js is pure and contains only source constants and deterministic state/impact plans.
- fractured_runtime.js scans only the dedicated families, handles one attack state per entity, and defers before-event state mutation through system.run where required.
- Java GeckoLib keyframe instruction names and model-bone positions are not server-script-visible. KEYFRAME_ADAPTER_TICKS isolates the fallback trigger tick (1) for Slam, SingleStomp, MoonRockToss, and AirLift; the source attack lengths and effect constants remain exact.
- Stable Script API Entity.applyKnockback takes a VectorXZ plus vertical strength; Entity.getAABB() supplies the entity collision bounds; EntityEquippableComponent.getEquipmentSlot(EquipmentSlot.Chest) supports the Elytra side effect.

## Validation target

- deterministic model/runtime/ownership regressions;
- node --check for all changed JavaScript;
- JSON parsing for the touched entity definitions;
- repository CI typecheck, full regression suite, add-on validators, Blockception diagnostics, and Creator Tools validation.

## Known differences

Exact multipart part identity, Java custom damage-source identity, GeckoLib bone transforms, and the 400-particle block-impact presentation remain engine-limited. The runtime preserves source timings, branch order, damage amounts, cooldowns, owner exclusion, and dedicated ownership; the remaining differences are listed in ADAPTATION_NOTES.md and KNOWN_LIMITATIONS.md.
