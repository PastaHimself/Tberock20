# Chunk 26 spec — Chord projectile source semantics

## Scope

Replace the legacy Bedrock `chord_projectile` lifetime/movement approximation with the independently recoverable behavior from `ChordEntity.performProjectileAttack` and `ChordProjectileEntity`, without fabricating the unavailable BrokenCore arrow-damage formula.

## Java source contracts

### Launch from ChordEntity

- construct `ChordProjectileEntity` with the Chord as owner
- aim at target `(x, y(1.0), z)`
- set projectile `initialPos` to the Chord position
- shoot at speed `1.6f`
- inaccuracy `0.0f`
- call `setBaseDamageFromMob(2.0f)`

### ChordProjectileEntity lifecycle

- no gravity during flight
- `shouldBeSaved()` returns false
- no pickup item
- discard once distance from `initialPos` reaches 100 blocks
- hitting a Chord discards the projectile
- entity impact restores gravity; creative-player impact explicitly discards
- block impact restores gravity, records a face-specific grounded render offset, and queues discard after 20 ticks

## Bedrock adapter

The existing generic Chord tick already owns target selection and currently advances the spawned projectile by 0.9 blocks/tick. Avoid replacing the entire large boss controller just to change projectile semantics:

- keep the existing Chord target vector as authority
- register a projectile-specific correction pass after `bossController`
- infer the normalized direction from the existing tick displacement and add only the missing distance required to reach 1.6 blocks/tick
- record spawn position through `world.afterEvents.entitySpawn` when available, with first-observed-position fallback
- enforce 100-block distance expiry rather than the legacy 160-tick lifetime
- substep the corrected movement path for block collision; freeze the projectile at the impact point for the source 20-tick discard window
- make the Bedrock entity transient by removing `minecraft:persistent` and disable gravity during flight

## Explicit unresolved dependency

The repository does not contain BrokenCore's `UwuableArrow#setBaseDamageFromMob` implementation. Preserve the existing Bedrock 6-damage hit value behind `CHORD_PROJECTILE_BEDROCK_ADAPTER` and mark it `adapted_brokencore_arrow_damage`; do not claim it is the Java-derived final damage until that dependency is recovered.

## Validation

- pure regression for launch/lifecycle constants
- normalized direction helper regression
- 100-block distance threshold regression
- exact 20-tick post-block-hit discard regression
- integration regression proving runtime registration occurs after `bossController`
- entity JSON regression proving no persistence, no flight gravity, and runtime family wiring
- full JavaScript syntax, beta API type-check, add-on schema validation, and Creator Tools workflow
