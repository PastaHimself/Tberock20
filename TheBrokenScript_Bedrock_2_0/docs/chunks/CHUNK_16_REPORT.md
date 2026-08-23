# CHUNK_16_REPORT

## Scope
Multiplayer-safety and performance audit of all runtime loops, plus targeted optimizations.

## Loop inventory (after audit)
| Loop | Rate | Cost profile | Status |
|---|---|---|---|
| scheduler delays (spawn_director) | 1t | 10 map reads | OK |
| tbe/humanoid/misc/stalk/boss controllers | 1t | getEntities per dim ×3 | **optimized**: idle short-circuit + cached dimension handles |
| circuit/null controllers + pursuit | 5t | getEntities overworld(+nether/end for pursuit) | OK |
| horror_events ambient pool | 200t | table roll ≤2 fires | OK |
| spawn_director evaluate | 200t | rule predicates | OK |
| progression polaroid scan | 300t | inventory scan per player | OK |
| story_time threshold check | 100t heartbeat cadence | single compare | OK |

## Changes
- **`src/systems/perf.js`** — per-tick cached `hasPlayers(tick)` and `dim(name)` handle cache (`isValid` revalidation)
- **5 one-tick controllers** (tbe/humanoid/misc/stalk/boss) now short-circuit when no players are online — eliminates all family `getEntities` scans on idle servers/realms
- **tbe/boss controllers** use cached dimension handles instead of rebuilding the dims array every tick
- Multiplayer review findings (no code change needed): timers are per-entity-id maps; entityDie/entityHurt hooks each guard typeId before acting; player state uses per-player dynamic properties; horror events intentionally broadcast to all players (matches source behavior); commands gate on `sourceEntity.typeId === "minecraft:player"`; known shared-state nit in legacy null_controller (`isHereApproach` module counter) is benign — single consumer.

## Validation
| Check | Result |
|---|---|
| integration_audit.ps1 | PASSED |
| validate_pack.ps1 | PASS (659 JSONs, 46 modules synced) |

## Parity / risk
No behavioral change intended: early-outs only trigger when zero players are online (no entity can be observed or affected then). Timer decrements pause during empty-server windows — matches source semantics where mob ticks also halt without players.

## Next chunk prerequisites
Ready: Chunk 17 = Full parity audit vs SOURCE_INVENTORY (912 entries) → produce final gap ledger.
