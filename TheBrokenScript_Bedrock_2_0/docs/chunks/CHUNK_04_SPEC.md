# CHUNK_04_SPEC — Entity Framework and Common AI Primitives

## Source basis (decompiled evidence)
- `brokencore/api/entity/SpawnConditions.java` — placementType + heightmap + predicate interface; 23 concrete condition classes under `api/entity/conditions/`
- `CircuitStalkConditions.java` (reference predicate, full order extracted):
  peaceful gate · dark-enough · valid-below-block · doMobSpawning · **isNullHere() required** · config disableSpawningEntities · overworld-only · Arena Phase1 block · flat-world 0.001 roll · **random ≤ 0.015 + eventFrequency(gameTime)** · closest player ≤512 with skylight==0 at both player+spawn pos · not-on-surface · no other circuit-type within **420** · on success `circuitSpawnDelay=5200`
- `LongExt.eventFrequency → TBSEngineControl.Companion → EngineControl` controller sum (EventEngine lands Chunk 12)
- `CircuitStalkEntity` synced state {spawning, spawningTimer, timer, crouch(20t re-eval)}; timer expiry → `hasCircuitSpawned=false` + discard (one-at-a-time gate release)
- `CircuitStalkBehavior` / `CircuitDefaultStareBehavior`: target=closest ≤256; gaze-gate (≤100, looking-at-hitbox); branches 50% overlay blick.png+YOU_KNOW_NOTHING / 70% transform→Circuit(+spotted) / fallback despawn; Darkness 5s everywhere; mineshaft-walk variant gates at ≤20

## Bedrock modules delivered
| Primitive | Module |
|---|---|
| closest-player / entity-count scans (bounded) | `src/systems/ai/entity_finder.js` |
| view-cone gaze approximation of hitbox check | `src/systems/ai/gaze.js` |
| Darkness/Blindness helpers | `src/systems/ai/effects.js` |
| trySummon + random rotation + fake-midnight | `src/systems/ai/spawn_helpers.js` |
| stable-ID refs + invalidation | `src/core/entity_refs.js` |
| spawn-rule framework + 10 delay timers (per-tick decrement, INT_MAX sentinels) | `src/systems/spawn_director.js` |
| arena state interface (real values from Chunk 07) | `src/systems/boss_hooks.js` |
| event-frequency hook (provider set by Chunk 12 EventEngine) | `src/systems/event_frequency.js` |

main.js wired: director start, ref invalidation on leave/death.

## Verified API surface used
getSkyLightLevel/getLightLevel/getBiome (v2.3.0 ⊂ 2.6.0 ✓), addEffect, getViewDirection, spawnEntity(SpawnEntityOptions), runCommandAsync (guarded), world.getEntity(id).

## Documented approximations (ledger)
- gaze = view-cone w/ distance-widened half-angle (hitbox raycast unavailable) — high parity
- difficulty/gamerule/superflat/mineshaft-structure gates lack stable queries → enforced via equivalent states where possible; omissions ledgered per rule when families port them
- candidate-position scanning is director-driven (200t around players), not vanilla natural-spawn cloning

## Validation
sync 24 modules; validate_pack.ps1 PASS.
