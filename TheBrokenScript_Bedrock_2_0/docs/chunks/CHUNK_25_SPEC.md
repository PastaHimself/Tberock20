# Chunk 25 spec — complete Integrity Phase 3 attack table

## Scope

Close the remaining active `IntegrityPhase3Entity` attack-table gap after Chunk 24 by porting `TentacleSwipeAttack`, `GravityAttack`, and `TentaclesAttack` into the dedicated Bedrock Phase 3 runtime and preserving the Java selector semantics across the full implemented table.

## Java source contracts

### TentacleSwipeAttack

- cooldown: 100 ticks
- chance: 0.15
- duration: 40 ticks
- movement disabled
- impact tick: 9
- transformed impact-center source position: `(-291.5252, 400.7372, 5.4492) * 0.125`, rotated by entity yaw
- radius: 14
- damage: 5
- horizontal knockback strength: 2

### GravityAttack

- cooldown: 140 ticks
- chance: 0.15
- duration: 240 ticks
- inherited unbounded attack distance
- setup sets `BossGlobals.FLIP_GRAVITY = true`
- finish clears `BossGlobals.FLIP_GRAVITY`
- `BossGlobals.INVERSE_GRAVITY_STRENGTH = -0.0125`
- emits 20 `INTENSE_PROJECTION` block particles per tick with ±5 X/Z spread and `(0, 2, 0)` particle velocity

### TentaclesAttack

- cooldown: 55 ticks
- chance: 0.9
- duration: 144 ticks
- distance range: 10..20 inclusive
- can-use gate: target exists and a player within 35 blocks has vertical offset in `[0, 1.5]`
- setup stops movement and sets Integrity stuck
- source timer 65 pulse: players within 25 blocks, vertical offset `[0, 1.5]`, distance > 8; 7.5 damage; players within 10 receive 2.3 horizontal / 1.15 upward impulse
- source timer 80 pulse: players within 35 receive 5 damage; grounded players within 10 receive 1.25 horizontal / 0.95 upward impulse

## Selector requirements

The dedicated runtime must preserve `Phase3Goals.AttackSelectorGoal` behavior:

- no selection while dying/stuck, without a target, during a non-NOOP attack, or while attack delay is positive
- exclude the immediately previous attack
- enforce each attack's source distance/can-use gate
- choose by source `chance` weight across all eligible implemented attacks

## Bedrock adaptations

- Java's replacement of `LivingEntity#getDefaultGravity` cannot be reproduced directly; apply the equivalent +0.0125 upward increment to Stage 3 players each active Gravity tick and label this as an adapter.
- Java's custom `INTEGRITY_SHIELD_BYPASS` damage type has no equivalent registration path in the current Script API; preserve Tentacles timing/damage/impulses while using the documented Bedrock entity-attack adapter.
- Java block-particle emission for the Gravity attack remains an explicit presentation gap unless a verified Bedrock particle equivalent is available.

## Validation

- pure model regressions for constants, selector gates/weights, attack duration/cooldowns, Swipe transform/impact, Gravity lifecycle, and both Tentacles pulses
- JavaScript syntax and beta Script API type-check
- full add-on validator and Creator Tools workflow
