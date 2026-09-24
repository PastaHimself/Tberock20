# CHUNK_02_REPORT

## Source examined
- Decompilation toolchain established: Temurin JDK 21 (portable, `tools/jdk/`) + CFR 0.152 → main mod **1029 .java** at workspace `decompiled/`, brokencore library **815 .java** at `decompiled_brokencore/`
- Read for this chunk: `data/PlayerVariables.java`, `data/MapVariables.java`, `brokencore/api/event/StoryEvent.java`, `brokencore/impl/event/StoryEvents.java` (+StoryEventsData), `registry/TBSStoryEvents.java`, `events/story/{MoonCorruption,TXT,Coords,NullBook}StoryEvent.java`, `config/common/{World,Danger,Entity,Events}Config.java`, `api/util/time/Time.java`

## Behavior discovered
- Story clock: persisted counter; +1/tick only while players online (source also gates on daylight gamerule — see A-008); events fire on exact threshold equality
- Thresholds: txt_story days(5/10/15/20)+1000 · coords_hint day(6)+1000 · null_book day(12)+1000 · moon_corruption days(24/32/38/48)+1000 gated by !hasMoonCorrupted (moonStage++, moonShouldChange=false)
- Full MapVariables world schema (spawn-once flags, moon stage/crack, MAX_VALUE structure anchors, 10 encounter delay timers default INT_MAX) and PlayerVariables schema (reputation=50, FX toggles, isolation+allowed-users, teleport counters)
- Config defaults: removeDeepslate=true, allowOldWorldGen=true, nightmareTeleportChance=10, disableAttackCooldown=true, disguisedCircuitEntityChance=0.001, ore=0.01, …

## Implemented
- `src/core/random.js` (int/chance/weighted), `src/core/cooldowns.js` (tick cooldown registry)
- `src/shared/story_time.js` — story clock port (threshold multimap, online-gate, skip support)
- `src/systems/world_state.js` — MapVariables port (56 typed keys, source defaults/sentinels)
- `src/systems/player_state.js` — PlayerVariables port (typed keys, isMetaParanoia(), setMoonGlitch())
- `src/systems/config_defaults.js` — 15 decompiled config defaults registered
- `src/systems/story_events.js` — txt_story/coords_hint/moon_corruption wired to source thresholds
- `src/main.js` — lifecycle wiring: join/leave/spawn(+first-seen state)/entityDie(player) logging, worldState init, story clock start

## Validation
| Check | Result |
|---|---|
| sync_scripts.ps1 | 16 modules synced |
| validate_pack.ps1 | PASS (12 ok / 0 errors) |
| Import graph incl. systems/* | resolved |

## Parity status
`high` for state schemas, story clock, and wired story events. Deviations: A-008 (daylight gate), TXT alert presentation under A-004 surrogate.

## Adaptations recorded
A-008 added. null_book_story event deliberately NOT yet wired — requires item/book system (Chunk 09); ledgered `in_progress`, never silent.

## Unresolved defects
None in delivered scope. Runtime test still pending Minecraft install.

## Next chunk prerequisites
Chunk 03 needs no new tooling; asset pipeline can start immediately.
