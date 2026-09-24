# CHUNK_04_REPORT

## Source examined
- `brokencore/api/entity/{SpawnConditions,BasicSpawnConditions}.java`, main-mod `api/entity/conditions/*` (23 classes; CircuitStalkConditions read in full)
- `entity/circuit/CircuitStalkEntity.java` (synced state + lifecycle), `behaviors/{CircuitStalkBehavior,CircuitDefaultStareBehavior}.java`
- Frequency chain: `api/ext/LongExt.java → TBSEngineControl.java (CUTOFF=55) → brokencore api/engine/{EngineControl,EngineController,EventEngine,EventPicker}`

## Implemented
- AI primitives: entity_finder (bounded closest/count scans), gaze view-cone, effects wrappers, spawn_helpers (trySummon/rotation/fake-midnight)
- `core/entity_refs.js`: stable-ID reference registry w/ invalidation on leave/death (multiplayer-safe)
- `systems/spawn_director.js`: rule registry, 10 encounter delay timers with per-tick decrement honoring INT_MAX sentinels, 200t bounded evaluation loop, global config/arena gates
- Hook modules: `boss_hooks.js` (arena state interface), `event_frequency.js` (provider interface; default 0 = fresh-world behavior)
- main.js wiring complete; **24 modules** synced

## Validation
| Check | Result |
|---|---|
| sync_scripts.ps1 | 24 files |
| validate_pack.ps1 | PASS |

## Parity status
Framework layer `high`. Concrete spawn predicates/AI states port per family (Chunks 05A+) against this framework — no gameplay rule registered yet by design (entities do not exist until their family chunks).

## Documented approximations
Gaze cone vs hitbox raycast; difficulty/gamerule/superflat/mineshaft-structure gates (no stable queries — per-rule ledgering when families activate); director-driven candidate scanning vs vanilla natural spawn pipeline.

## Unresolved defects
None in delivered scope. Runtime verification pending Minecraft install.

## Next chunk prerequisites
Framework ready for Chunk 05A (Circuit family): needs CircuitUtil.BIOME_BLACKLIST extraction + circuit geo/animations (available from Chunk 03 outputs).
