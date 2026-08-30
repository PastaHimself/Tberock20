# Chunk 26 spec — Chord projectile source semantics

## Scope

Replace the legacy Chord projectile approximation with the independently recoverable behavior from `ChordEntity.performProjectileAttack` and `ChordProjectileEntity`. The BrokenCore arrow-damage formula remains unresolved and must stay behind an explicit adapter.

## Java source contracts

`ChordEntity.performProjectileAttack` constructs the projectile with the Chord as owner, aims at `(target.x, target.getY(1.0), target.z)`, records the Chord position as `initialPos`, calls `shoot(..., 1.6f, 0.0f)`, and passes `2.0f` to `setBaseDamageFromMob`.

`ChordProjectileEntity` then:

- flies with no gravity;
- returns `false` from `shouldBeSaved()` and uses an empty pickup item;
- discards at `distance(initialPos) >= 100`;
- discards immediately on a Chord hit;
- restores gravity after entity or block impact;
- still runs the ordinary arrow entity-hit path before explicitly discarding a creative player hit;
- stores face-specific grounded offsets and queues discard after 20 ticks on a block hit.

The recovered grounded offsets are preserved exactly in `chord_projectile_model.js`: south `(215,180)`, north `(215,0)`, east `(215,-90)`, west `(215,90)`, down `(115,180)`, and up `(185,180)`.

## Bedrock adapter

`boss_controller.js` remains responsible for choosing the target and spawning the entity. It registers the source aim vector, owner, and initial position with `chord_projectile_runtime.js`; it no longer advances the projectile or handles projectile collisions. The dedicated runtime is the sole movement/collision owner.

The runtime:

- normalizes the registered aim vector and advances at the source speed `1.6` blocks/tick;
- removes an orphan or zero-vector spawn instead of allowing an unregistered projectile to persist;
- enforces the 100-block distance boundary;
- substeps movement at the explicit collision-adapter distance `0.4` and queries a radius-2 candidate set to avoid tunneling;
- resolves the earliest block/entity hit once per tick;
- applies the existing Bedrock 6-damage value once for ordinary entity hits, skips damage for Chord, and uses `GameMode.Creative` for the creative-player branch;
- triggers a physics component group to restore gravity after a hit, freezes block-hit motion for the source 20-tick countdown, and leaves ordinary post-entity motion to Bedrock physics.

The source `target.getY(1.0)` call is a bounding-box interpolation unavailable through the current runtime adapter, so the launch bridge uses the target entity location as its documented aim-height adaptation. The face offset is retained in the pure model and inferred best-effort from the server collision segment; the current client entity has no source-equivalent renderer hook for applying the stored `Vec2`.

## Explicit unresolved dependency

The repository does not contain BrokenCore's `UwuableArrow#setBaseDamageFromMob` implementation. `CHORD_PROJECTILE_BEDROCK_ADAPTER.entityHitDamage = 6` is therefore an adaptation, not a Java-derived final damage formula. The Java `2.0f` input is not substituted directly into Bedrock damage.

## Validation target

- pure launch, impact-branch, direction, distance, countdown, orphan-state, and grounded-offset regressions;
- runtime registration ordering and single collision-owner checks;
- entity JSON checks for transient storage, no-gravity flight, runtime family, and gravity restoration event;
- JavaScript syntax, JSON parsing, Bedrock static scanner, and available CI checks.
