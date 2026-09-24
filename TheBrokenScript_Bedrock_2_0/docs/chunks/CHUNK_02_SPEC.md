# CHUNK_02_SPEC — Shared Runtime and Persistence

## Source basis (decompiled, CFR 0.152)
Tooling stood up first: portable Temurin JDK 21 (`tools/jdk/`) + CFR → **1029 main-mod files** (`decompiled/`) + **815 brokencore files** (`decompiled_brokencore/`).

Inspected for this chunk:
- `data/PlayerVariables.java` — 50+ per-player fields w/ defaults (entityReputation=50, cameraMode=FIRST_PERSON, voidBox=true, MOON_GLITCH_DURATION_SECS=80 → 1600 ticks, isolation fields, teleport counters, FX toggles)
- `data/MapVariables.java` — world saved-data schema: spawn-once flags, moon stage/crack system, structure anchor coords (MAX_VALUE sentinels), code/codeApplied, **10 encounter delay timers default Integer.MAX_VALUE**, isFirstJoin/firstJoinTimer/joinTimerTicking, daylightCycleEventTimer
- `brokencore api/event/StoryEvent.java` + `impl/event/StoryEvents.java` + `StoryEventsData` — persisted story clock: +1/tick **only while players online** (+ daylight gamerule), multimap time→event fired on exact equality, addSkippedTime()
- `registry/TBSStoryEvents.java` + `events/story/*` — 4 story events: txt_story days(5/10/15/20)+1000; coords_hint days(6)+1000; null_book days(12)+1000; moon_corruption days(24/32/38/48)+1000 gated on !hasMoonCorrupted
- `config/common/{World,Danger,Entity}Config.java` — gameplay defaults extracted verbatim

## Bedrock design
| Source | Bedrock module |
|---|---|
| MapVariables SavedData | `src/systems/world_state.js` typed accessors over dynamic properties (`mv.*` keys, source defaults incl. INT_MAX sentinels) |
| PlayerVariables attachment | `src/systems/player_state.js` (`pv.*` keys) + isMetaParanoia() + setMoonGlitch() |
| StoryEventsData clock | `src/shared/story_time.js` (threshold multimap, equality firing, skip support, online-gate) |
| 4 StoryEvents | `src/systems/story_events.js` (null_book deferred → needs item system) |
| Config defaults | `src/systems/config_defaults.js` (15 verified values) |
| timers/cooldowns | `src/core/cooldowns.js`; weighted RNG `src/core/random.js` |

## Validation performed
- tools/sync_scripts.ps1 → 16 modules; tools/validate_pack.ps1 → PASS (imports resolved incl. new systems/, braces balanced)

## Expected parity
High for state schemas/story clock/config; documented deviations below.
