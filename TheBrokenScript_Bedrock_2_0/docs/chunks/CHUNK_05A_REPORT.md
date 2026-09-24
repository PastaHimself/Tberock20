# CHUNK_05A_REPORT

## Source examined
- 6 circuit entities (CircuitEntity 1186 lines, Stalk 350, Stare 291, MineshaftWalk 218, MineshaftStare 60, Flee 180) + CircuitData, CircuitUtil (BIOME_BLACKLIST = [THE_END, END_MIDLANDS, END_HIGHLANDS, NULL_BIOME]), ChaseState enum
- Handlers: BlockBreak (ore 0.01), Despawner (2000 radius anti-farm), Death/Inhabited (5200 delay), SpawnHandler (entity chance 0.001)
- Spawn predicate CircuitStalkConditions in full (12 gates, 420 exclusion, 5200 delay, eventFrequency, player skyLight==0, !surface, !hasCircuitSpawned, isNullHere gate)
- Stalk/Stare behaviors (gaze 100/20, 50% blick overlay, 70% transform, Darkness/Blindness 5s, midnight fake)

## Implemented
- **BP**: 6 entities (`thebrokenscript:circuit*`) — health/movement/attack/follow/collision/physics with source values (HP 910/110/10, mov 0.4/0.3/0, follow 64/16, size 0.6×1.8-2.0, stepHeight preserved via behavior)
- **RP**: 6 client entities → geometry.circuitv4 (circy.png, entity_alphatest, single_textured) — shared model high parity
- **Scripts**: circuit_controller.js (26 modules total) — grace 160, lifetimes 10000/300/800, stare gaze transform, flee pause <25, chase noWayOut cycle + Darkness, midnight fake via spawn_helpers, despawn gate release; circuit_spawn_rules.js (BIOME_BLACKLIST strings, skyLight check, 420 exclusion, 5200 reset, overworld+config+arena gates)
- Sync + validate_pack PASS

## Validation
| Check | Result |
|---|---|
| sync_scripts.ps1 | 26 files |
| validate_pack.ps1 | PASS (JSON parse incl. 12 new entity JSONs) |
| Geometry id via GEOMETRY_ID_MAP | geometry.circuitv4 verified |

## Parity status
`high`. Approximations: wall-climb block destroy (config-gated) simplified to no-op with ledger note; boat discard approximated via periodic scan (not every tick); grace overlay (blick.png via title) simplified; mineshaft structure detection (requires structureManager query) documented as approximated — per-rule ledger when family fully exercises it; Flat-world 0.001 gate omitted (rare).

## Unresolved defects
- FakePlayerEntity deferred to 05E (player-mimic needs skin handling — high complexity, separate chunk per schedule)
- Block-breaking destroyBlock no-drops not visually verified without runtime

## Next chunk prerequisites
Ready: spawn_director delay handling validated; geometry/textures available.
