# Chunk 28 report — Fractured/Jimmy attack lifecycle

## Ported

- Added a pure Fractured lifecycle model with source attack-map order, equal-weight selector boundaries, 100-tick startup delay, exact attack lengths/cooldown, stomp transform, pulse plans, rock launch/impact constants, and sixth-hit defeat transition.
- Added a dedicated runtime for Fractured and Rock. The runtime owns attack selection/ticking, movement adapter, melee/projectile damage gating, Rock physics/collision, block/entity impact ordering, owner exclusion, Elytra durability, and the delayed AirLift pulse.
- Added the source-preserving JSON family split and removed the generic boss controller's Fractured/Rock dispatch and approximation functions.
- Added deterministic tests for all recovered constants, selector boundaries, attack timing, pulse plans, Rock impact/flight, runtime ownership, JSON families, and beta-safe knockback syntax.

## API/source evidence

- Java source: [FracturedEntity.java](https://github.com/PastaHimself/tbs-2.0/blob/2086a33a0610f561c08259aadff58b974d2c458d/decompiled/net/thebrokenscript/entity/fractured/FracturedEntity.java), [JimAttackSelectorGoal.java](https://github.com/PastaHimself/tbs-2.0/blob/2086a33a0610f561c08259aadff58b974d2c458d/decompiled/net/thebrokenscript/entity/fractured/JimAttackSelectorGoal.java), [StompAttack.java](https://github.com/PastaHimself/tbs-2.0/blob/2086a33a0610f561c08259aadff58b974d2c458d/decompiled/net/thebrokenscript/entity/fractured/attacks/StompAttack.java), [SlamAttack.java](https://github.com/PastaHimself/tbs-2.0/blob/2086a33a0610f561c08259aadff58b974d2c458d/decompiled/net/thebrokenscript/entity/fractured/attacks/SlamAttack.java), [MoonRockTossAttack.java](https://github.com/PastaHimself/tbs-2.0/blob/2086a33a0610f561c08259aadff58b974d2c458d/decompiled/net/thebrokenscript/entity/fractured/attacks/MoonRockTossAttack.java), [AirLiftAttack.java](https://github.com/PastaHimself/tbs-2.0/blob/2086a33a0610f561c08259aadff58b974d2c458d/decompiled/net/thebrokenscript/entity/fractured/attacks/AirLiftAttack.java), and [RockEntity.java](https://github.com/PastaHimself/tbs-2.0/blob/2086a33a0610f561c08259aadff58b974d2c458d/decompiled/net/thebrokenscript/entity/fractured/RockEntity.java).
- Microsoft Learn: [Entity.applyKnockback](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable#applyknockback), [Entity.getAABB](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable#getaabb), [EntityEquippableComponent.getEquipmentSlot](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityequippablecomponent?view=minecraft-bedrock-stable#getequipmentslot), and [System.run](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/system?view=minecraft-bedrock-stable#run).
- BedrockWikiMcp cross-checks resolved the stable getAABB, applyKnockback(VectorXZ, number), and getEquipmentSlot(EquipmentSlot) signatures.

## Validation

- Local focused Jimmy suite: 11 passed, 0 failed.
- node --check passed for the dedicated model, runtime, main entry point, and generic boss controller.
- Both touched entity JSON definitions parse successfully.
- GitHub Actions run 33323628395 passed typecheck, all 89 JavaScript regressions, 67 Python validator tests, resource/Jigsaw/Blockception/MCT validation, and packaging; only GitHub artifact uploads were blocked by repository storage quota.
- No Minecraft Bedrock world is installed locally, so in-game behavior still requires device/runtime smoke testing.

## Next unfinished source slice

The next source class is FracturedPartEntity.java, followed by the multipart support classes FracturedSubEntity.java and Leg.java; FracturedRoamEntity.java remains the next host lifecycle slice. These are intentionally not claimed as complete by Chunk 28.
