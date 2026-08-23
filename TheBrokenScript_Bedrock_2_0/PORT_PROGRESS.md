# PORT_PROGRESS.md

Last updated: 2026-08-23 (Chunk 05F)

## Project facts
- Source mod: **The Broken Script 2.0** — `thebrokenscript-neoforge-2.0.0+mc1.21.1-build.3084.jar` (supplied as 9 decompressed chunk zips)
- Source form: **bytecode-only** (.class ×1982) + complete original resources — **NOW FULLY DECOMPILED** (1029 main + 815 brokencore .java under workspace `decompiled*/`)
- Extracted at: `C:\Users\mg4392\Downloads\tbs 2.0\source_extracted` (6765 files; `sites/rblog/file.bin` reassembled)
- Mod metadata: modId `thebrokenscript` v2.0.0; MC `[1.21.1,)`; NeoForge `[21.1.227,)`; deps: brokencore 0.1.0, extensibleenums; license All Rights Reserved
- Target: Minecraft Bedrock **1.26.10+**, manifest format 2, `@minecraft/server` **2.6.0**
- Namespace: `thebrokenscript`

## Current chunk
**Chunk 06 — Stalking systems completion pass (+ deferred medium entities)**

## Chunk state
| Chunk | State |
|---|---|
| 00 Complete source inventory & architecture | **completed** |
| 01 BP/RP foundation | **completed** |
| 02 Shared runtime & persistence | **completed** (story clock, world/player state ports, config defaults; null_book story event pending item system) |
| 03 Asset & client foundation | **completed** (sounds/defs 143, textures 502, atlases, geo×77 w/ id fixes, anims×36, flipbooks×5, lang) |
| 04 Entity framework & AI primitives | **completed** (finder/gaze/effects/spawn_helpers/entity_refs/spawn_director + hooks; 24 modules) |
| 05A Circuit family (6 entities) | **completed** (BP/RP entities, controller timers/stare/flee/chase, spawn rule with source constants) |
| 05B Null watcher/scare (4 entities) | **completed** (watching/scare/mining/is_here, timers 8000/40/1200/500, 10-case anger, spawn rule) |
| 05C Null pursuit/endgame (7 entities) | **completed** (chase/nulll/maze/endgame/unbeatable/flying/invade, timers 450/3200/420/500, chase/maze/endgame logic) |
| 05D The Broken End family | **completed** (4 entities stalk/curious/ambush/TBE, timers 1000/7200+320/2400/18000-24000+26, TBE/Ambush spawn rules delays 32000/8200) |
| 05E Humanoid apparitions | **completed** (10 entities stare/siluet×4/he×3/deceiver/faraway, SILUET/FARAWAY/ENTITY spawn matrices, r2 model family) |
| 05F Remaining entities | **completed** (14 misc/niw/players entities: xxram_2die chat seq, ban, eerie_noise, chunk_remover*, corruption void-column, follow, name_tag, maze_shadows, null_cod, nothing_watcher, niw pair w/ kick, phantom_player swap, hetzer; *chunk ops approximated) |
| 06 Stalking systems completion pass | pending (now includes curved/jon/sub_anomaly_1-2/herobrine/obliteration pair moved from 05F) |
| 07 Bosses (Integrity/Jimmy/Kerfur+fever/chord/tether/tentacle) | pending |
| 08 Blocks (123 + 8 BE equivalents) | pending |
| 09 Items (192) + fluids approximation | pending |
| 10 Dimensions (13) & portals | pending |
| 11 Worldgen (15 biomes, structures, shaft, xcsf→mcstructure) | pending |
| 12 Events & horror choreography (94) | pending |
| 13 Progression/recipes/loot/tags/commands | pending |
| 14 Presentation completion | pending |
| 15 Integration | pending |
| 16 Multiplayer & performance audit | pending |
| 17 Full parity audit vs 912-entry inventory | pending |
| 18 Final validation | pending |
| 19 Packaging .mcaddon | pending |

Blocked: none.

## Files created (Chunk 05F)
BP/entities/{xxram_2die,ban,eerie_noise,chunk_remover,corruption,follow,name_tag,maze_shadows,null_cod,nothing_watcher,niw,nothingiswatchingchase,phantom_player,hetzer}.json (14) · RP/entity/*.entity.json (14) · src/entities/misc/{misc_controller,misc_spawn_rules}.js · docs/chunks/CHUNK_05F_{SPEC,REPORT}.md

## Files created (Chunk 05E)
BP/entities/{stare,siluet,siluet_stare,siluet_chase,siluet_hallucination,he,he_chase,he_hallucination,deceiver,faraway}.json (10) · RP/entity/*.entity.json (10) · src/entities/humanoid/{humanoid_controller,humanoid_spawn_rules}.js · docs/chunks/CHUNK_05E_{SPEC,REPORT}.md

## Files created (Chunk 05D)
BP/entities/the_broken_end*.json (4) · RP/entity/the_broken_end*.entity.json (4) · src/entities/tbe/{tbe_controller,tbe_spawn_rules}.js · docs/chunks/CHUNK_05D_{SPEC,REPORT}.md

## Files created (Chunk 05C)
BP/entities/null_{chase,maze,endgame,unbeatable,flying,invade,nulll}.json (7) · RP/entity/null_*.entity.json (7) · src/entities/null/null_pursuit_controller.js · docs/chunks/CHUNK_05C_SPEC.md

## Files created (Chunk 05B)
BP/entities/null_*.json (4) · RP/entity/null_*.entity.json (4) · src/entities/null/{null_controller,null_spawn_rules}.js · docs/chunks/CHUNK_05B_SPEC.md

## Files created (Chunk 05A)
BP/entities/circuit*.json (6) · RP/entity/circuit*.entity.json (6) · src/entities/circuit/{circuit_controller,circuit_spawn_rules}.js · docs/chunks/CHUNK_05A_SPEC.md

## Files created (Chunk 04)
src/systems/ai/{entity_finder,gaze,effects,spawn_helpers}.js · src/core/entity_refs.js · src/systems/{spawn_director,boss_hooks,event_frequency}.js · main.js rewired · docs/chunks/CHUNK_04_{SPEC,REPORT}.md

## Files created (Chunk 03)
RP/sound_definitions.json · RP/terrain_texture.json · RP/item_texture.json · RP/flipbook_textures.json · RP/models/entity/*.geo.json (77) · RP/animations/* (36) · RP/sounds/** · RP/textures/** · BP+RP texts (997 lang lines) · docs/GEOMETRY_ID_MAP.json · tools/build_rp_assets.ps1 · tools/inspect_assets.ps1 · docs/chunks/CHUNK_03_SPEC.md

## Files created (Chunk 02)
src/core/random.js · src/core/cooldowns.js · src/shared/story_time.js · src/systems/{world_state,player_state,config_defaults,story_events}.js · main.js rewired · docs/chunks/CHUNK_02_{SPEC,REPORT}.md · tools/jdk/ + CFR (decompiler toolchain)

## Files created (Chunk 01)
BP/manifest.json · RP/manifest.json · BP/texts/en_US.lang · RP/texts/en_US.lang · BP/pack_icon.png · RP/pack_icon.png
src/main.js · src/core/{logging,errors,scheduler,events,state,config,flags}.js · src/shared/ids.js (+ synced copies under BP/scripts/)
tools/sync_scripts.ps1 · tools/validate_pack.ps1 · tools/package_mcaddon.ps1 · docs/chunks/CHUNK_01_SPEC.md · dist/TheBrokenScript_2_0_Bedrock.mcaddon

## Files created (Chunk 00)
SOURCE_INVENTORY.json · SOURCE_MAP.json · ASSET_MAP.json · IDENTIFIER_MAP.json · PARITY_MATRIX.md · BEDROCK_ARCHITECTURE.md · BEDROCK_COMPATIBILITY.md · ADAPTATION_NOTES.md · VALIDATION_LOG.md · KNOWN_LIMITATIONS.md · PORT_PROGRESS.md · docs/chunks/CHUNK_00_SPEC.md · docs/chunks/CHUNK_00_REPORT.md · tools/build_source_inventory.ps1 · tools/build_source_map.ps1

## Validation completed
See VALIDATION_LOG.md (Chunk 05F: 35 modules sync, 213 JSONs parsed incl. 28 new misc JSONs — PASS; 05E: 33/185; 05D: 31/165; 05C: 29; 05B: 28; 05A: 26; 04: 24; 03: 123; 02: 16 — all PASS).

## Unresolved defects
- Runtime import test requires a Minecraft Bedrock install (none detected); static validation covers structure/schema only.
- Story-clock daylight-gamerule gate approximated (players-online only) — A-008.
- null_book_story event unwired until item system exists (Chunk 09) — ledgered in_progress.
- PhysicalStacktraceBlock placement (TBE stalk) + disruption block placement (follow) pending Chunk 08.
- Dimension teleports (follow → CLAN_VOID/NULL_TORTURE) pending Chunk 10.
- Advancements (can_you_see_me) pending Chunk 13; FunnySetting easter-egg variants pending config pass.
- Chunk clear/move-up (chunk_remover) approximated as sound beat — engine limitation ledgered.
- Decompiler toolchain now installed (JDK21+CFR under tools/) — resolved.

## Dependencies needed by later chunks
- Minecraft (Bedrock) install for runtime tests, if available.

## Experimental requirements so far
- Potential "Beta APIs" world experiment isolated to custom-dimension module IF min-engine stays 1.26.10 (decision Chunk 10). Alternative documented: floor 1.26.30 for stable DimensionRegistry.

## Next chunk
Chunk 06 — Stalking systems completion pass (+ deferred medium entities)

## Exact source references to inspect next
- `players/CurvedEntity.java` (1149 ln), `misc/JonEntity.java` (453 ln), `anomaly/sa1|sa2/SubAnomaly*Entity.java`
- `HerobrineEntity.java` + `conditions/HerobrineConditions.java`; `oblit/{Obliteration,Obliteration2}Entity.java` + ObliterationConditions
- Stalking-pass cross-checks: event_frequency usage, encounter-delay ledger, remaining story-event hooks
