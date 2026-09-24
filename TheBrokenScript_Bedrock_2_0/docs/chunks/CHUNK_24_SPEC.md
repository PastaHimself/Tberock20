# Chunk 24 — Integrity Phase 3 Fireball + implemented attack selector

## Scope

Port the source-backed Phase 3 attack-selection rules needed to make the already-ported GroundAttack coexist with FireballAttack, and replace the legacy Bedrock fireball approximation with the Java projectile contract.

## Source evidence

- `decompiled/net/thebrokenscript/api/entity/ai/integrity/phase3/Phase3Goals.java`
  - attack selection only while a living target exists, the current attack is `NOOP`, attack delay is zero, and Integrity is not stuck;
  - the immediately previous attack is excluded;
  - remaining attacks are filtered by distance range and selected by weighted `chance`.
- `decompiled/net/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity.java`
  - attack delay decrements every tick;
  - the active attack ticks until its dynamic length is reached;
  - finishing applies that attack's cooldown, resets attack ticks/GroundAttack timer/stuck state, then returns to `NOOP`;
  - Fireball launch is initiated by the GeckoLib `ballin;` custom keyframe using the world position of model bone `righttendrils5`.
- `decompiled/net/thebrokenscript/entity/integrity/phase3/attacks/FireballAttack.java`
  - cooldown 120 ticks, chance 0.15, length 144 ticks, always eligible, immobile;
  - fires once toward the current target at speed 1.6 with zero inaccuracy.
- `decompiled/net/thebrokenscript/entity/integrity/phase3/IntegFireballEntity.java`
  - entity impact adds 6 damage;
  - any hit creates a power-5 explosion with no fire and no terrain interaction.

## Bedrock mapping

1. `phase3_attack_model.js` contains the pure selector and Fireball source constants so Node CI can test the Java rules without importing `@minecraft/server`.
2. The implemented selector contains only the attacks currently ported in Bedrock: GroundAttack and Fireball. It preserves Java gating, previous-attack exclusion, distance filtering, and relative weights for that implemented subset. It does **not** claim final full-selector probabilities until TentacleSwipe, Gravity, and Tentacles are ported.
3. `phase3_runtime.js` owns Integrity Phase 3, GroundArm, and IntegFireball. Those entities use a dedicated `thebrokenscript_phase3_runtime` family so the legacy generic boss controller cannot double-tick them.
4. Existing VoidTentacle behavior remains in `boss_controller.js`; its exact-type target scans continue to see Phase 3 and GroundArm entities even though those entities no longer carry the generic boss family.
5. Fireball movement uses the source speed 1.6. Entity contact applies 6 projectile damage and then creates a radius/power-5 Bedrock explosion with `breaksBlocks: false` and `causesFire: false`.

## Explicit adaptation

The exact Java projectile origin cannot be reproduced server-side: the source launch packet contains the client GeckoLib world transform of `righttendrils5` at the `ballin;` animation keyframe, and Bedrock Script API does not expose that client model-bone world transform. The adapter therefore launches once at attack tick 1 from the vertical midpoint of the boss's 32-block collision volume and aims at the player's center. This is isolated as `FIREBALL_BEDROCK_ADAPTER` and must remain documented as an approximation rather than source-exact timing/origin.

## Acceptance checks

- Fireball constants: cooldown 120, chance 0.15, length 144, speed 1.6, direct damage 6, explosion 5, no fire, no block breaking.
- Selector refuses no-target, delayed, and stuck states.
- Selector excludes the previous attack.
- GroundAttack remains limited to 40–80 blocks; Fireball uses the source default unlimited distance range.
- Weighted selection between the currently implemented GroundAttack (1.0) and Fireball (0.15) matches Java subtraction/roll semantics.
- Fireball launches at most once per attack and attack completion resets its shot flag.
- Phase 3 / GroundArm / Fireball are not processed by both runtimes.
