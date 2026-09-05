# PORT_PROGRESS.md

Last updated: 2026-09-05 (Chunk 56 — Integrity Phase 2 Stage 2 stone2 template asset)

## Project facts
- Source mod: **The Broken Script 2.0** — `thebrokenscript-neoforge-2.0.0+mc1.21.1-build.3084.jar` (supplied as 9 decompressed chunk zips)
- Source form: **bytecode-only** (.class ×1982) + complete original resources — **NOW FULLY DECOMPILED** (1029 main + 815 brokencore .java under workspace `decompiled*/`)
- Extracted at: `C:\Users\mg4392\Downloads\tbs 2.0\source_extracted` (6765 files; `sites/rblog/file.bin` reassembled)
- Mod metadata: modId `thebrokenscript` v2.0.0; MC `[1.21.1,)`; NeoForge `[21.1.227,)`; deps: brokencore 0.1.0, extensibleenums; license All Rights Reserved
- Target: Minecraft Bedrock **1.26.50+**, manifest format 2, `@minecraft/server` **2.11.0-beta**, `@minecraft/server-ui` **2.1.0**
- Namespace: `thebrokenscript`

## Current chunk

**Chunk 56 implementation in review — Integrity Phase 2 Stage 2 stone2 template asset**

Chunk 56 validates the first rare Floor 4 Stage 2 variant, `stone2`, as a Bedrock `.mcstructure` asset. The source contract is 16×9×16 with 2304 cells: 256 `minecraft:stone`, 50 `thebrokenscript:block_is_missing_id`, and 1998 `minecraft:air`, with no entities or block entities. The pure plan now exposes the source-backed variant and no-mirror structure-load command; validated assets are 2/64 and 62 remain deferred. Java Stage2Generator room RNG, FRONT_BACK mirroring, occupancy, borders/tunnels/nowhere generation, automatic scheduler placement, and live Bedrock smoke testing remain explicit boundaries; GitHub Actions [run 33962536401](https://github.com/PastaHimself/tbs-2.0/actions/runs/33962536401) passed all substantive validation, beta type-check, JavaScript syntax/regression tests, Blockception diagnostics, Creator Tools validation, and packaging; both artifact uploads remained best-effort and logged the exhausted repository quota.

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
| 06 Stalking systems completion pass | **completed** (curved unseen-approach/transform, jon chatter NPC, sub_anomaly_1/2 corrupt-block rolls, obliteration pair w/ stare-kick, herobrine statue; CURVED/HEROBRINE/OBLIT/ANOMALY spawn rules; manifest switched to @minecraft/server beta channel) |
| 07 Bosses (Integrity/Jimmy/Kerfur+fever/chord/tether/tentacle) | **completed** (16 entities; Arena hooks; source-backed Phase 3 ring/boundary slice; remaining lifecycle/cutscene differences recorded in the parity ledger) |
| 08 Blocks (123 + 8 BE equivalents) | **completed** (123/123 blockstates → BP/blocks: ~60 cubes, 19 cross flora w/ geometry.tbs_cross, 16 void_template markers, jim_triggers/initiator/BEs; terrain_texture +13 keys; beta blockComponentRegistry ×12; physical_stacktrace/disruption/corrupt ledgers unblocked; tools/build_blocks.ps1) |
| 09 Items (192) + fluids approximation | **completed** (76 true items defined w/ icons/food/stacking, plush textures copied 39, item_texture 68→101, void_goop_still/flow fluid blocks, null_book signed written-book story adapter at day 12+1000 with bounded delivery retry (Chunk 38)) |
| 10 Dimensions (13) & portals | **completed** (12 dimension JSONs per TBSDimensions + NIGHTMARES set; dimensions.js runtime w/ beta createDimension fallback; follow → clan_void/null_torture teleport unblocked; portal_controller interact → clan_void Y:201) |
| 11 Worldgen (15 biomes, structures, shaft, xcsf→mcstructure) | **completed** (15/15 biomes + RP fog palettes; procedural Shaft/Hallway builders wired to null_structure interact; 305-NBT corpus + xcsf arena conversion ledgered as deferred tooling; 32 spawn modifiers confirmed covered by spawn_director rules) |
| 12 Events & horror choreography (94) | **completed** (horror_events.js: 78-id gated weighted pool @200t, ~60 handlers incl. OS-fake titles A-004, place_* pranks w/ real blocks, fire() export; Arena suppression; manifest external revert re-corrected to beta) |
| 13 Progression/recipes/loot/tags/commands | **completed** (40/40 recipes incl. 16 stonecutter; 126 self-drop loot tables + component wired into 125 blocks; progression.js 5 advancements wired to siluet spawn/TBE kill/polaroid scan/boss hurt; commands.js /scriptevent tbs:* surface + 14 chat responses; manifest version now user-managed, validator non-failing) |
| 14 Presentation completion | **completed** (tbs_slab/stairs/wall geometries wired into 16 blocks w/ collision; tbs_humanoid geo on faraway/deceiver/xxram_2die; boss death hook — integrity_dies + Arena teardown; manifest owner-pinned version respected) |
| 15 Integration | **completed** (tools/integration_audit.ps1 — 7 families, 12 dims, 103 identifier classifications, 22 world_state keys all PASS; fixed 3 wrong sound ids + 1 syntax error found by audit) |
| 16 Multiplayer & performance audit | **completed** (perf.js hasPlayers short-circuit + dimension handle caches in the five 1-tick controllers; multiplayer hook/props review clean; loop inventory documented) |
| 17 Full parity audit vs 912-entry inventory | **completed** (category-level ledger in CHUNK_17_REPORT.md: every entry maps to shipped artifact / ledgered approx / explicit deferral / engine-N/A; totals — 1:1 ported: 68 entities, 123 blocks, 40 recipes, 143 sound defs, 76 items, 15 biomes, 12 dims, 5 advancements) |
| 18 Final validation | **completed** (tools/final_validation.ps1 — 68/68 entity pairing, entity/terrain/item texture resolution, per-scope id uniqueness, item lang keys 76/76, geometry refs 29; found+fixed plural texture paths ×15, gradient + vein_center pointers) |
| 19 Packaging .mcaddon | **completed** (dist/TheBrokenScript_2_0_Bedrock.mcaddon — 145,789,490 bytes, 1400 entries, forward-slash separators verified, key-file spot check PASS; packager rewritten off Compress-Archive due to backslash-entry bug) |
| 20 Remaining parity ports | **completed** (functional hand cannon/polaroid/portal linker/desyncer; 4×2 circuit-cave painting surrogate; heart-corruption + why-cant-you-leave effects with source eyes particle; supplied VHS JSON UI + four subpacks + Vibrant Visuals; regression tests and strict UI audit) |
| 21 Integrity Phase 3 runtime semantics | **completed** (source-backed 251-candidate tentacle ring + 3 presets, 60-tick boundary countdown/native void terminal damage, and exact 428-tick cutscene timing model; Java transport/camera gaps ledgered) |
| 22 VoidTentacle source SCALE adapter | **completed** (persisted client-synced `thebrokenscript:scale` property, event-backed `minecraft:scale` groups for 1..5, and fixed Phase 3 presets at scale 2) |
| 23 Integrity Phase 3 GroundAttack/GroundArm adapter | **completed** (inclusive 40–80 target selection, tick-33 block capture, tick-40 owned arm spawn, tick-5 impact plan, owner-stuck propagation, and tentacle-proximity lifecycle) |
| 24 Integrity Phase 3 attack model/runtime | **completed** (source-backed Fireball, TentacleSwipe, Gravity, and Tentacles constants, selector gates, timing, pulses, and Bedrock adapters) |
| 25 Complete Phase3Goals multi-attack selector | **completed** (weighted candidates, previous-attack exclusion, distance/vertical gates, attack lengths/cooldowns, and runtime dispatch) |
| 26 Chord projectile source correction | **completed** (sole-owner movement/collision runtime, 1.6 speed, 100-block expiry, branch-ordered impacts, gravity restoration, 20-tick block countdown, transient entity, and explicit BrokenCore damage adapter) |
| 27 Integrity Phase 3 damage/death lifecycle | **completed** (player/fireball caps, hurt-frame gate, mace parry, kill causes, center/death state, 298-tick cleanup, and restricted-event deferral) |
| 28 Jimmy attack lifecycle | **completed** (FracturedEntity delay/selector/attack lengths, Stomp/Slam/MoonRockToss/AirLift effects, RockEntity flight/impact adapter, dedicated runtime ownership, and deterministic regressions) |
| 29 Jimmy multipart hitbox/support | **completed** (six source-backed logical parts, body-yaw/Leg transforms, projectile part filtering, arrow side effects, FracturedRoam SWITCHING adapter, root collision envelope, and deterministic regressions) |
| 30 FracturedRoam host lifecycle | **completed** (149-tick server timer, underground/dig/despawn boundaries, arena handoff, participant/sound schedule, and deterministic lifecycle adapters) |
| 31 FracturedRoam movement recovery/control | **completed** (surface recovery scan, support probes, stuck cutoff, stroll range, and MoveControl turn/forward boundary) |
| 32 Chord inherited arrow damage | **completed** (vanilla 1.21.1 AbstractArrow difficulty-weighted triangle formula, stable Bedrock difficulty mapping, runtime adapter, and regressions) |
| 33 Rock block-impact particle burst | **completed** (400 moon-stone particle emitter, exact source offset/count/velocity plan, one-tick cleanup, and regressions) |
| 34 Custom damage-source catalog and attribution | **completed** (15 source definitions and registry flags, native cause/entity/projectile adapter, same-tick source ledger, runtime routing, and regressions) |
| 35 Fractured animation timeline and presentation bridge | **completed** (source keyframe names/seconds, deterministic 20 Hz event ticks, direct attack animation playback, locator-bound contact presentation, Roam state mapping, tracked-bone contract, and regressions) |
| 36 Source particle resources and event bridge | **completed** (nine source definitions/resources; Null/Eyes/Curved event bridge; Paper/resource-only differences ledgered) |
| 37 Fractured audio lifecycle adapter | **completed** (source Jimmy spawn cue; SoundInstance-owned JimArena intro/loop cleanup; focused regression) |
| 38 NullBookStoryEvent written-book adapter | **completed** (source threshold, pages, Java coordinate encoding, injectable ItemBookComponent creation, independent per-player delivery, overflow drop, bounded retry, and persistence-key correction) |
| 39 Custom status-effect adapter | **completed** (source effect metadata, finite expiry refresh, health-cap runtime adapter, Eyes-particle bridge, focused regressions) |
| 40 Jukebox song record adapters | **completed** (12 source songs mapped to native record components, source durations/sound keys preserved, comparator signal clamped to 13, integration regressions) |
| 41 Fractured rendered-contact resolver | **completed** (source bone contract, injectable world-position seam, source stomp transform fallback, explicit entity-anchor fallback, runtime wiring, focused regressions, GitHub Actions run 139) |
| 42 Source-registered horror event adapters | **completed** (seven missing source registrations, source message/title/interface/sign contracts, Null book optional page, Aberration state, explicit Bedrock fallbacks, focused regressions, GitHub Actions run 143) |
| 43 Source event engine contract | **completed** (source frequency curve, one-player-per-tick scheduler, inverse occurrence weighting, disabled event ids, configured rerolls, persistent world state, Bedrock API clock/game-mode seams, focused regressions, GitHub Actions run 33770176189) |
| 44 Library Book reader adapter | **completed** (44 recovered source book payloads, source 1–250 id range, per-item id retention seam, one-based pages, bounded form pagination, focused regressions, GitHub Actions run 33773822475) |
| 45 Null interface form adapters | **completed** (three source menus, exact text/grid contracts, active event-to-form wiring, focused regressions, GitHub Actions run 33782971528) |
| 46 NulledGui screen adapter | **completed** (source title/messages, active event-to-form wiring, glitch cue, focused regressions, GitHub Actions run 33836845836) |
| 47 FakeDisconnect screen adapter | **completed** (source heading/title/body/action, active event-to-form wiring, focused regressions, GitHub Actions run 33838618989) |
| 48 TornPaper and command-block screen adapters | **completed** (source coordinates/text/actions, item/block form wiring, validation branches, focused regressions, GitHub Actions run 33866668553; artifact upload quota noted) |
| 49 Integrity Arena startup handoff | **completed** |
| 50 Integrity Phase 1 terrain corruption | **completed** |\n| 51 Integrity Phase 2 transfer | **completed** |\n| 52 Integrity Phase 2 recovery routing | **completed** (PR #26 merged externally) |
| 53 Integrity Phase 2 Stage 2 runtime | **completed** (PR #27 merged externally) |
| 54 Integrity Phase 2 Stage 2 runtime scaffold | **completed** (PR #28 merged externally) |
| 55 Integrity Phase 2 Stage 2 template asset foundation | **completed** |
| 56 Integrity Phase 2 Stage 2 stone2 template asset | **in review** |

No code or pack-validation blocker is open; the GitHub artifact upload quota failure is recorded in VALIDATION_LOG.md. Remaining engine/source-lifecycle gaps are tracked in PARITY_MATRIX.md and KNOWN_LIMITATIONS.md.

## Files created (Chunk 21)
BP/scripts/systems/integrity_arena_model.js Phase 3 constants/state/cutscene model · BP/scripts/entities/boss/boss_controller.js source-backed ring spawn and boundary countdown · tests/integrity_arena_model.test.mjs regressions · docs/chunks/CHUNK_21_{SPEC,REPORT}.md

## Files changed (Chunk 23)
BP/entities/integrity_arm.json (source non-persistent contract) · BP/scripts/systems/integrity_arena_model.js (GroundAttack/GroundArm constants and pure timing/impact/lifecycle plans) · BP/scripts/entities/boss/boss_controller.js (Phase 3 GroundAttack adapter, runtime owner map, arm impacts, stuck propagation, lifecycle) · tests/integrity_arena_model.test.mjs regressions · docs/chunks/CHUNK_23_{SPEC,REPORT}.md

## Files changed (Chunk 29)
BP/entities/{fractured,fractured_roam}.json · BP/scripts/entities/boss/{boss_controller,fractured_runtime}.js · BP/scripts/systems/fractured_multipart_model.js · tests/fractured_multipart_{model,runtime}.test.mjs · docs/chunks/CHUNK_29_{SPEC,REPORT}.md

## Files changed (Chunks 30–32)
Chunks 30–31 updated the FracturedRoam model/runtime/controller and lifecycle regressions; Chunk 32 updated the Chord projectile model/runtime and projectile regressions.

## Files changed (Chunk 33)
BP/scripts/systems/fractured_attack_model.js · BP/scripts/entities/boss/fractured_runtime.js · BP/entities/rock.json · RP/particles/moon_stone_block_burst.particle.json · tests/fractured_attack_model.test.mjs · tests/fractured_runtime.test.mjs · docs/chunks/CHUNK_33_{SPEC,REPORT}.md

## Files changed (Chunk 34)
BP/scripts/systems/damage_source_model.js · BP/scripts/systems/damage_source_runtime.js · BP/scripts/entities/boss/{boss_controller,phase3_runtime,fractured_runtime}.js · tests/damage_source_{model,runtime}.test.mjs · docs/chunks/CHUNK_34_{SPEC,REPORT}.md · parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 35)
BP/scripts/systems/fractured_animation_model.js · BP/scripts/entities/boss/fractured_runtime.js · RP/models/entity/fractured.geo.json · RP/entity/{fractured,fractured_roam}.entity.json · RP/animations/fractured.animation.json · RP/particles/jimmy_contact_burst.particle.json · tests/fractured_animation_model.test.mjs · tests/fractured_runtime.test.mjs · docs/chunks/CHUNK_35_{SPEC,REPORT}.md · parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 36)
BP/scripts/systems/{particle_model,particle_runtime}.js · RP/particles/*.particle.json (nine source identifiers) · RP/textures/particle/** (eight copied source textures) · systems/horror_events.js · entities/stalk/stalk_controller.js · tests/particle_{model,runtime}.test.mjs · docs/chunks/CHUNK_36_{SPEC,REPORT}.md · parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 37)
BP/scripts/entities/boss/fractured_runtime.js · tests/fractured_runtime.test.mjs · docs/chunks/CHUNK_37_{SPEC,REPORT}.md · audio/parity/validation ledgers

## Files changed (Chunk 38)
BP/scripts/systems/{story_book_model,story_book_adapter,story_events,world_state}.js · tests/story_events.test.mjs · docs/chunks/CHUNK_38_{SPEC,REPORT}.md · SOURCE_MAP.json · story/parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 39)
BP/scripts/systems/{status_effect_model,status_effect_runtime,ported_features}.js · tests/status_effect_{model,runtime}.test.mjs · tests/remaining_ports.test.mjs · docs/chunks/CHUNK_39_{SPEC,REPORT}.md · status/parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 40)
BP/items/{attribute_mutilation,credits,instability,instability_music_box,instabilityv2,instabilityv3,lilly,lilly_v2,record_14,record_15,record_16,record_17}.json · BP/scripts/systems/music_disc_model.js · tests/music_disc_parity.test.mjs · docs/chunks/CHUNK_40_{SPEC,REPORT}.md · music/parity/adaptation/limitation/validation ledgers
## Files changed (Chunk 41)
BP/scripts/systems/fractured_contact_model.js · BP/scripts/entities/boss/fractured_runtime.js · tests/fractured_contact_model.test.mjs · tests/fractured_runtime.test.mjs · docs/chunks/CHUNK_41_{SPEC,REPORT}.md · Fractured parity/adaptation/limitation/validation ledgers
## Files changed (Chunk 42)
BP/scripts/systems/{horror_event_model,horror_events,story_book_model,story_book_adapter}.js · tests/{horror_event_model,story_events}.test.mjs · docs/chunks/CHUNK_42_{SPEC,REPORT}.md · horror-event/parity/adaptation/limitation/validation ledgers
## Files changed (Chunk 43)
BP/scripts/systems/{event_scheduler_model,event_frequency,horror_events,config_defaults}.js · tests/event_scheduler_model.test.mjs · docs/chunks/CHUNK_43_{SPEC,REPORT}.md · event-engine/parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 44)
BP/scripts/systems/{library_book_model,library_book_data,ported_features}.js · BP/items/book.json · tests/library_book_model.test.mjs · docs/chunks/CHUNK_44_{SPEC,REPORT}.md · item/gui/parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 45)
BP/scripts/systems/{null_interface_model,ported_features,horror_events,horror_event_model}.js · tests/null_interface_model.test.mjs · docs/chunks/CHUNK_45_{SPEC,REPORT}.md · GUI/parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 46)
BP/scripts/systems/{nulled_gui_model,ported_features,horror_events}.js · tests/nulled_gui_model.test.mjs · docs/chunks/CHUNK_46_{SPEC,REPORT}.md · GUI/event/parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 47)
BP/scripts/systems/{fake_disconnect_model,ported_features,horror_events}.js · tests/fake_disconnect_model.test.mjs · docs/chunks/CHUNK_47_{SPEC,REPORT}.md · GUI/event/parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 48)
BP/scripts/systems/{command_block_model,ported_features,custom_blocks}.js · BP/items/torn_paper.json · tests/command_block_model.test.mjs · docs/chunks/CHUNK_48_{SPEC,REPORT}.md · item/block/GUI/parity/adaptation/limitation/validation ledgers

## Files changed (Chunk 49)
BP/scripts/systems/{integrity_arena_start_model,integrity_arena_runtime}.js · BP/scripts/entities/boss/boss_controller.js · BP/entities/integrity_phase_1.json · BP/scripts/systems/ported_features.js · tests/integrity_arena_start_model.test.mjs · docs/chunks/CHUNK_49_{SPEC,REPORT}.md · SOURCE_MAP.json · PARITY_MATRIX.md · KNOWN_LIMITATIONS.md · ADAPTATION_NOTES.md · PORT_PROGRESS.md

## Files changed (Chunk 28)
BP/entities/{fractured,rock}.json · BP/scripts/main.js · BP/scripts/entities/boss/{boss_controller,fractured_runtime}.js · BP/scripts/systems/fractured_attack_model.js · tests/fractured_{attack_model,runtime}.test.mjs · docs/chunks/CHUNK_28_{SPEC,REPORT}.md

## Files changed (Chunk 27)
BP/scripts/systems/phase3_attack_model.js (source lifecycle constants and pure damage/death plans) · BP/scripts/entities/boss/phase3_runtime.js (filtered hurt adapter, deferred death/mace actions, lifecycle state) · tests/phase3_lifecycle_model.test.mjs · docs/chunks/CHUNK_27_{SPEC,REPORT}.md

## Files changed (Chunk 26)
BP/entities/chord_projectile.json · BP/scripts/entities/boss/boss_controller.js · BP/scripts/entities/boss/chord_projectile_runtime.js · BP/scripts/systems/chord_projectile_model.js · tests/chord_projectile_model.test.mjs · docs/chunks/CHUNK_26_{SPEC,REPORT}.md

## Files created (Chunk 20)
`BP/scripts/systems/ported_features.js` · `BP/scripts/systems/ported_feature_logic.js` · functional item definitions for desyncer and circuit-cave painting · `BP/entities/circuit_cave_painting.json` · complete RP painting entity/geometry/render/texture chain · `RP/particles/eyes.particle.json` + source eyes texture · VHS `ui/`, `textures/ui/vhs/`, four subpacks, and Vibrant Visuals settings · `tests/remaining_ports.test.mjs` · `docs/chunks/CHUNK_20_REPORT.md`

## Files created (Chunk 18)
tools/final_validation.ps1 · texture-path fixes (terrain_texture ×15, item_texture ×2, gradient/vein_center repoints) · docs/chunks/CHUNK_18_REPORT.md

## Files created (Chunk 19)
dist/TheBrokenScript_2_0_Bedrock.mcaddon (145,789,490 B, 1400 entries) · package_mcaddon.ps1 rewritten (.NET zip, forward-slash entries, self-verification) · docs/chunks/CHUNK_19_REPORT.md

## Files created (Chunk 17)
docs/chunks/CHUNK_17_REPORT.md (final category-level parity ledger vs 912 entries)

## Files created (Chunk 16)
src/systems/perf.js · idle short-circuits + dim caches in 5 controllers · docs/chunks/CHUNK_16_REPORT.md

## Files created (Chunk 15)
tools/integration_audit.ps1 · sound-id fixes (circuit_controller/custom_blocks/horror_events) · progression.js syntax repair · docs/chunks/CHUNK_15_REPORT.md

## Files created (Chunk 14)
RP/models/blocks/{tbs_slab,tbs_stairs,tbs_wall}.geo.json · RP/models/entity/tbs_humanoid.geo.json · 16 block JSONs rewired · 3 entity JSONs rewired · boss_controller death hook · docs/chunks/CHUNK_14_REPORT.md

## Files created (Chunk 13)
BP/recipes/*.json (40) · BP/loot_tables/** (126) · BP/blocks/*.json loot components (125) · src/systems/{progression,commands}.js · advancement wiring (horror_events/humanoid_spawn_rules/tbe_controller) · tools/build_recipes.ps1 · docs/chunks/CHUNK_13_REPORT.md

## Files created (Chunk 12)
src/systems/horror_events.js · main.js wiring · docs/chunks/CHUNK_12_REPORT.md

## Files created (Chunk 11)
BP/biomes/*.json (15) · RP/biomes_client.json · src/systems/worldgen_structures.js · custom_blocks.js null_structure shaft wiring · docs/chunks/CHUNK_11_REPORT.md

## Files created (Chunk 10)
BP/dimensions/*.json (12) · src/systems/dimensions.js · custom_blocks.js portal wiring · misc_controller follow dimension teleport · docs/chunks/CHUNK_10_REPORT.md

## Files created (Chunk 09)
BP/items/*.json (76) · RP/textures/plush/* (39) · RP/item_texture.json (+33) · BP/blocks/{void_goop_still,void_goop_flow}.json · story_events.js null_book wiring + world_state.nullBookGiven · docs/chunks/CHUNK_09_{SPEC,REPORT}.md

## Files created (Chunk 08)
BP/blocks/*.json (123) · RP/models/blocks/tbs_cross.geo.json · RP/terrain_texture.json (+13) · src/systems/custom_blocks.js · tools/build_blocks.ps1 · docs/chunks/CHUNK_08_{SPEC,REPORT}.md

## Files created (Chunk 07)
BP/entities/{integrity_phase_1,integrity_phase_2,integrity_phase_3,integrity_arm,integrity_curious,integ_fireball,fractured,fractured_roam,rock,murderfur,fever,fever_stalk,chord,chord_projectile,tether,void_tentacle}.json (16) · RP/entity/*.entity.json (16) · src/entities/boss/{boss_controller,boss_spawn_rules}.js · docs/chunks/CHUNK_07_{SPEC,REPORT}.md

## Files created (Chunk 06)
BP/entities/{curved,jon,sub_anomaly_1,sub_anomaly_2,the_obliteration,the_obliteration_2,herobrine}.json (7) · RP/entity/*.entity.json (7) · src/entities/stalk/{stalk_controller,stalk_spawn_rules}.js · docs/chunks/CHUNK_06_{SPEC,REPORT}.md · BP/manifest.json beta dep + validator update

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
Chunk 29 focused local validation: 12 deterministic multipart regressions PASS; changed multipart model/runtime/controller JavaScript node --check PASS; fractured and fractured_roam collision-envelope JSON parse and source-extents assertions PASS; GitHub Actions run 33359740828 passed all code/validation gates; artifact uploads were blocked by repository storage quota. Bedrock world/runtime smoke test unavailable locally.

Chunk 33 focused local validation: 13 Jimmy model/runtime regressions PASS; changed attack model/runtime JavaScript node --check PASS; Rock entity and custom particle JSON parse PASS; GitHub Actions validation for the published commit is recorded in the PR; artifact uploads were blocked by repository storage quota. Bedrock world/runtime smoke test unavailable locally.

Chunk 34 focused local validation: 53/53 deterministic Node regressions PASS; custom damage model/runtime and boss runtime JavaScript node --check PASS; Rock entity and moon-stone particle JSON parse PASS. Microsoft Learn and BedrockWiki references confirm native cause/entity/projectile attribution and no custom damage-type registry path. Bedrock world/runtime smoke test unavailable locally.

Chunk 35 focused local validation: 19/19 deterministic Node regressions PASS for the animation, attack, and dedicated Fractured runtime slice; changed animation model/runtime JavaScript `node --check` PASS; source event-tick, presentation-state, tracked-bone, locator-bound particle, and runtime bridge assertions PASS. Bedrock animation/entity/particle JSON parse and locator/timeline assertions PASS. Bedrock world/runtime smoke test unavailable locally.

Chunk 37 focused local validation: 5/5 Fractured runtime regressions PASS; changed runtime JavaScript `node --check` PASS; Bedrock world/runtime smoke testing unavailable locally; GitHub Actions [run 125](https://github.com/PastaHimself/tbs-2.0/actions/runs/33642389983) PASS.

Chunk 38 focused local validation: TDD red/green story-book regressions PASS (7/7 focused; 67/67 full Node suite); changed story, adapter, and state modules `node --check` PASS; source threshold/page/coordinate, ItemBookComponent/signing/distribution, overflow, retry, and persistence assertions PASS. GitHub Actions [run 128](https://github.com/PastaHimself/tbs-2.0/actions/runs/33718374216) passed all repository-owned checks; its MCT bare-beta self-comparison false positive was fixed and verified by [run 129](https://github.com/PastaHimself/tbs-2.0/actions/runs/33718950818), which passed the complete workflow. Bedrock world/runtime smoke test unavailable locally.

Chunk 39 focused local validation: TDD red/green status-effect regressions PASS (6/6 focused); changed status model/runtime/ported_features JavaScript `node --check` PASS; legacy effect regression updated for the model-backed Eyes identifier; Bedrock world/runtime smoke testing remains unavailable locally; GitHub Actions validation for the repaired published commit pending.
Chunk 40 focused local validation: TDD red/green music-disc model regressions PASS (2/2 focused); all 12 item JSONs receive source-duration/sound-event record components and max stack size 1; Microsoft Learn and BedrockWiki `minecraft:record` contract verified; Bedrock world/runtime smoke testing unavailable locally; GitHub Actions [run 134](https://github.com/PastaHimself/tbs-2.0/actions/runs/33751515744) PASS.
Chunk 41 focused local validation: TDD contact regressions PASS (4/4 focused; 12/12 full local Node suite); changed resolver/runtime JavaScript syntax and Bedrock beta type-check PASS; GitHub Actions [run 139](https://github.com/PastaHimself/tbs-2.0/actions/runs/33756631657) passed validators, regression tests, Blockception diagnostics, MCT validation, packaging, and report upload. Bedrock world/runtime smoke testing remains unavailable locally.
## Unresolved defects
- Runtime import test requires a Minecraft Bedrock install (none detected); static validation covers structure/schema only.
- Story-clock daylight-gamerule gate approximated (players-online only) — A-008.
- Fences/trapdoors/panes/doors remain full-cube visuals; flora share one cross geometry (slab/stairs/wall now real geometries).
- Animated block textures static in Bedrock.
- Hand cannon ownership/administrative-override enforcement is intentionally not copied: the Java implementation hard-codes one UUID and deletes the item from everyone else. Bedrock has no equivalent Java data component or portable owner UUID.
- Hand cannon's Java `invulnerableTime = 0` write is not exposed by Bedrock; 100-block targeting, spectator exclusion, sound, and 25 damage are preserved.
- Polaroid uses a Bedrock action form with the source image and world code; Java's arbitrary 15° framebuffer rotation is not available to server forms.
- Desyncer's deferred network-packet replay is engine-unsupported; a stateful audiovisual/resync surrogate ships instead (A-010).
- Circuit Cave is a decorative entity surrogate rather than a registered vanilla painting variant (A-005).
- Arena story triggers: reachable via /scriptevent tbs:arena + boss summon; story-side choreography in horror_events pool.
- Dimension teleports wired; per-dimension fog/sky styling deferred.
- Advancements approximated via progression.js; FunnySetting easter-egg variants pending config pass.
- Chunk clear/move-up (chunk_remover) approximated as sound beat — engine limitation ledgered.

## Dependencies needed by later chunks
- Minecraft (Bedrock) install for runtime tests, if available.

## Experimental requirements so far
- **Beta APIs are required**: BP manifest depends on `@minecraft/server` `2.11.0-beta` and has minimum engine `[1, 26, 50]`. Worlds must enable the “Beta APIs” experiment. The Polaroid additionally uses stable `@minecraft/server-ui` `2.1.0`.

## Chunk 36 — Source particle resources and event bridge

Chunk 36 adds the eight previously missing source particle textures and nine Bedrock emitter definitions, with source-backed provider sizes/lifetimes/materials and known event counts/spread. Null/Eyes use named emitters in the horror event system; Curved emits its 55-particle effect once at the recovered 6200-tick despawn boundary. Focused particle regressions and local JSON parsing pass; GitHub Actions run 123 PASS; Bedrock runtime smoke testing remains unavailable locally.

## Chunk 37 — Fractured audio lifecycle adapter

Chunk 37 adds the source Jimmy spawn cue and SoundInstance lifecycle bridge. Focused Fractured runtime regressions and changed-runtime syntax checks pass; Bedrock world/runtime smoke testing remains unavailable locally; GitHub Actions [run 125](https://github.com/PastaHimself/tbs-2.0/actions/runs/33642389983) PASS.

## Chunk 38 — NullBookStoryEvent written-book adapter

Chunk 38 adds the signed `null_book_hint` story item at the source day-12-plus-1000 threshold. The two pages preserve the source null text and chunk-centered binary Clan Void coordinates, including the Java Integer.MAX_VALUE conversion; the Bedrock book component signs independent per-player copies as `null`/`null`, drops inventory leftovers, and retries logged transient failures. The world-state initialization key is corrected to preserve the delivery gate. Focused and full Node regressions pass; run 128's sole failure was the external MCT bare-beta self-comparison filter, fixed by the narrow follow-up regression; [run 129](https://github.com/PastaHimself/tbs-2.0/actions/runs/33718950818) passed final validator, type-check, diagnostics, Creator Tools, packaging, and artifact/report steps.

## Chunk 39 — Custom status-effect adapter

Chunk 39 adds a source-backed adapter for the two registered custom effects. Heart Corruption preserves the harmful metadata and applies the Java `MAX_HEALTH -1` contract by capping current health at one below the effective maximum while active; Why Can't You Leave preserves its 1000-tick source duration and emits the native Eyes particle bridge. Focused status regressions and changed-runtime syntax checks pass; the legacy effect assertion now accepts the model-backed identifier; Bedrock world/runtime smoke testing remains unavailable locally; GitHub Actions validation for the repaired published commit is pending.

## Chunk 40 — Jukebox song record adapters

Chunk 40 adds native `minecraft:record` components to all twelve existing music items. The source durations and sound-definition keys are preserved, items are made non-stackable, and Java's comparator output of 15 is clamped to Bedrock's documented maximum 13. Focused model and item-link regressions pass; GitHub Actions [run 134](https://github.com/PastaHimself/tbs-2.0/actions/runs/33751515744) PASS.

## Chunk 41 — Fractured rendered-contact resolver

Chunk 41 adds a source-backed resolver for Fractured/Jimmy contact events. It preserves the four source-tracked bones used by `FracturedModel`, accepts exact rendered world positions through an injectable bridge seam, keeps the recovered `SingleStomp` offset as its source-preserving fallback, and makes the client-only claw/rock limitation explicit through entity-anchor fallback positions. The runtime routes stomp, slam, rock throw, and rock release origins through the resolver. Focused contact regressions pass; GitHub Actions [run 139](https://github.com/PastaHimself/tbs-2.0/actions/runs/33756631657) PASS. Bedrock world/runtime smoke testing remains unavailable locally.

## Chunk 42 — Source-registered horror event adapters

Chunk 42 adds the seven source registrations absent from the Bedrock horror-event table: null_book, null_interface_trigger, obfuscated_sign, noop, text, title_event, and aberration. The pure model preserves the source TextEvent pool, WindowTitleEvent's 90/90/50 branching, NullInterface's uniform three-menu selection, ObfuscatedSignEvent's 70/30 structure choice, and AberrationEvent's 1200-tick state. The runtime uses the existing Null book adapter with the source optional coordinate page and explicit title/local-sign fallbacks for unavailable Java presentation and NBT structure APIs. Focused local regressions pass; GitHub Actions [run 143](https://github.com/PastaHimself/tbs-2.0/actions/runs/33766550121) passed the complete workflow. Bedrock world/runtime smoke testing remains unavailable locally.

## Chunk 43 — Source event engine contract

Chunk 43 adds the source-backed random-event scheduler contract. The pure model mirrors TBSEngineControl's 55-day frequency curve and the brokencore weighted picker; the runtime uses World.getAbsoluteTime() and Player.getGameMode() when available, persists occurrence counts and disabled IDs through world state, and exposes enableRandomEvents, rerollEvents, and eventDebug defaults. Focused local scheduler regressions and the full 15-test scratch suite pass; GitHub Actions [run 33770176189](https://github.com/PastaHimself/tbs-2.0/actions/runs/33770176189) passed the complete validator/package workflow. Bedrock world/runtime smoke testing remains unavailable locally.

## Chunk 44 — Library Book reader adapter

Chunk 44 ports the source LibraryBookItem/LibraryBookScreen path. All 44 recovered library book JSON payloads are embedded in the runtime data module; the source 1..250 id range is preserved in the model, while new items select from the recovered payload set so Bedrock does not silently open an empty book for unavailable source ids. The Bedrock book item opens an ActionFormData reader with source page text, author/title context, bounded Previous/Next/Close pagination, optional per-stack id retention, and page-turn audio. Focused local model regressions pass; GitHub Actions [run 33773822475](https://github.com/PastaHimself/tbs-2.0/actions/runs/33773822475) passed the complete validator/package workflow. Bedrock world/runtime smoke testing remains unavailable locally.

## Chunk 45 — Null interface form adapters

Chunk 45 ports the source NullInterfaceTriggerEvent path. The three recovered Null interface menus now have pure contracts and a Bedrock ActionFormData adapter: NullInterface displays “behind you,” NullInterface2 preserves its five-by-five “null” grid, and NullInterface3 displays “help.” The active horror event opens the selected form instead of only showing a title fallback; cancel/close remains safe. Focused local model regressions pass; GitHub Actions [run 33782971528](https://github.com/PastaHimself/tbs-2.0/actions/runs/33782971528) passed the complete validator/package workflow. Bedrock world/runtime smoke testing remains unavailable locally.

## Chunk 46 — NulledGui screen adapter

Chunk 46 ports the source NulledGuiEvent/NulledGuiScreen path. The event now opens a supported ActionFormData reader titled NulledGui with the recovered “Good luck.” and “)=” messages, while preserving the source glitch sound cue. The Java fake-midnight client illusion remains explicitly adapted because Bedrock has no equivalent client-only time hook. Focused local model regressions pass; GitHub Actions [run 33836845836](https://github.com/PastaHimself/tbs-2.0/actions/runs/33836845836) passed the complete validator/package workflow. Bedrock world/runtime smoke testing remains unavailable locally.


## Chunk 47 — FakeDisconnect screen adapter

Chunk 47 ports the source FakeDisconnectEvent/FakeDisconnectScreen path. The active `fake_disconnect` event now opens a supported ActionFormData reader with the source “Connection Lost” heading, “Timed out” body/title, and “Back to title screen” action. The Java panorama background, Esc lockout, forced 100-tick close, global sound-stop/music flag sequence, and live client disconnect transition remain explicitly adapted because they are client/server-native behavior unavailable through the current Bedrock form seam. Focused local model regressions pass; GitHub Actions [run 33838618989](https://github.com/PastaHimself/tbs-2.0/actions/runs/33838618989) passed the complete validator/package workflow. Bedrock world/runtime smoke testing remains unavailable locally.

## Chunk 48 — TornPaper and command-block screen adapters

Chunk 48 ports the source TornPaperItem/TornPaperScreen path and the CommandBlockGui/CommandBlockGuiConfirm screen pair. Torn Paper now opens a supported reader with the source chunk-centered X/Z coordinates and Y 216 note; corrupted command blocks now use a ModalFormData code editor and an ActionFormData confirmation reader preserving Input Code, Execute, both warning lines, and Yes. Source textures, Java client rotation/rendering, exact EditBox glitch presentation, packet transport, native window-title feedback, and Integrity Arena kickoff remain explicitly adapted where the Bedrock form/server seam cannot reproduce them. Focused local model regressions pass; GitHub Actions [run 33866668553](https://github.com/PastaHimself/tbs-2.0/actions/runs/33866668553) passed validators, beta type-check, JavaScript regressions, Blockception diagnostics, Creator Tools validation, and packaging; artifact uploads failed because the repository artifact storage quota is exhausted. Bedrock world/runtime smoke testing remains unavailable locally.

## Chunk 49 — Integrity Arena startup handoff

Chunk 49 continues the command-block path into the recovered CorruptedCommandBlockConfirmPacket → Arena.Companion.start → Phase1.start sequence. The pure startup model preserves the source [-20,20) rejection loop for accepted [-10,10] offsets, surface-height center selection, same-dimension 150-block participant capture, empty-arena restart branch, 40-tick pre-start step, 60-tick nested start delay, midnight/custom-sky values, and the 1080-tick Phase 1 intro. The Bedrock runtime now reaches the handoff from the confirmation Yes action, stages the supported Phase 1 entity, records an arena token and participant roster, spawns the source-sized Chord roster after the intro, and blocks Phase 1 damage while the source Chord predicate remains invulnerable. Global time and dynamic-property sky markers are explicit Bedrock approximations; custom crawl/no-AI animation, terrain corruption, Phase 2/3 transfer, and native packet/camera presentation remain deferred. Focused TDD startup regressions and static syntax checks pass; GitHub Actions [run 33877651299](https://github.com/PastaHimself/tbs-2.0/actions/runs/33877651299) passed all substantive validation, type-check, regression, diagnostics, Creator Tools, and packaging gates; artifact uploads failed because the repository artifact storage quota is exhausted. Bedrock world/runtime smoke testing remains unavailable.

## Chunk 50 — Integrity Phase 1 terrain corruption

Chunk 50 continues the Integrity Arena startup handoff into the recovered Phase1 terrainQueue/tick and TerrainCorrupterKt contract. The pure model preserves the inclusive radius-100 disk, random.nextFloat() <= 0.3 queue inclusion, shuffled candidates, initial 20-tick cadence, one-position-per-20-ticks replacement, four source terrain_corrupt_replace IDs, and corrupted-command-block exclusion. The Bedrock runtime owns the live queue, resolves each X/Z through Dimension.getTopmostBlock, and applies replacements with Block.setType from the existing boss scheduler. ChunkCarver generation, exact registry-backed tag lookup, Phase 2/3 transfer, native packet/camera presentation, and Bedrock world/runtime smoke testing remain explicitly adapted or deferred. Focused terrain regressions pass; GitHub Actions [run 33882851212](https://github.com/PastaHimself/tbs-2.0/actions/runs/33882851212) passed all substantive validation, type-check, regression, diagnostics, Creator Tools, and packaging gates; artifact uploads failed because the repository artifact storage quota is exhausted.
## Chunk 51 — Integrity Phase 2 transfer

Chunk 51 continues the Integrity Arena lifecycle after Phase 1 Chords are defeated. The recovered Arena/Phase2 contract is represented by a pure transfer model and runtime handoff: Phase 1 completes only after the source Chord roster has spawned and no tracked Chords remain living; the Phase 1 entity, Chords, terrain queue, and custom sky state are cleaned up; participants retain their roster and transfer after the source 20-tick delay to the existing thebrokenscript:stage2 dimension through Entity.teleport's dimension option. Stage 2 floor generation, tether-gated floor movement, Phase 2 entity lifecycle, and native packet/camera/music presentation remain separate or deferred boundaries. Focused transfer regressions pass; repository CI validation is running; Bedrock world/runtime smoke testing remains unavailable.

## Chunk 53 — Integrity Phase 2 Stage 2 runtime

Chunk 53 ports the remaining portable Integrity Phase 2 Stage 2 runtime after the Chunk 52 recovery handoff. The pure contract makes Stage2Floor entry idempotent, keeps the Stage2 dimension and loading gates, preserves the Floor 1–7 bands and Floor 7 Integrity prerequisite, and separates target-floor state from successfully placed Integrity state. The runtime uses the source cell/center/random-distance math, scans candidate blocks through supported Bedrock block reads, spawns the source Tether and Integrity Phase 2 entities, detects live Tethers in the target floor volume, rejects Integrity candidates near Tethers, and teleports Integrity to the selected floor. The Java Stage2Generator remains an explicit custom-generator boundary; stage2.json is still a void dimension and does not claim exact room/template generation. GitHub artifact uploads are now best-effort so exhausted repository quota does not fail substantive validation; PR #27 run 33906338464 passed all substantive gates.


## Files changed (Chunk 53)
BP/scripts/systems/integrity_arena_model.js · BP/scripts/systems/integrity_arena_runtime.js · tests/integrity_phase2_stage2_model.test.mjs · .github/workflows/bedrock-addon-check.yml · docs/chunks/CHUNK_53_{SPEC,REPORT}.md · PORT_PROGRESS.md · PARITY_MATRIX.md · KNOWN_LIMITATIONS.md · ADAPTATION_NOTES.md · VALIDATION_LOG.md

## Chunk 54 — Integrity Phase 2 Stage 2 runtime scaffold

Chunk 54 adds a source-backed, air-only runtime scaffold for the Stage 2 cell. It preserves the source 10×10 chunk cell origin, the seven floor spawn surfaces derived from Stage2Floor.pickSpawnY() - 1, and the Stage2Generator barrier layers at Y 251, 232, 216, 206, 102, and 271. Dimension.fillBlocks with BlockVolume is used only for the loaded cell and only where the existing block is air; completed cell keys are cached per arena so the one-tick Phase 2 loop does not refill the same cell. This makes the supported Stage 2 entity scan executable in the void dimension without claiming Java room/template parity.

## Files changed (Chunk 54)
BP/scripts/systems/integrity_arena_model.js · BP/scripts/systems/integrity_arena_runtime.js · tests/integrity_stage2_scaffold_model.test.mjs · docs/chunks/CHUNK_54_{SPEC,REPORT}.md · PORT_PROGRESS.md · PARITY_MATRIX.md · KNOWN_LIMITATIONS.md · ADAPTATION_NOTES.md · VALIDATION_LOG.md

## Chunk 55 — Integrity Phase 2 Stage 2 template asset foundation

Chunk 55 converted the source-audited `stone1` template into a Bedrock `.mcstructure` with the exact source dimensions, palette, block count, and Floor 4 placement Y. `stage2TemplatePlacementPlan` preserves the Java source identity and transform inputs; `stage2TemplateLoadCommand` emits a no-animation, no-entity `structure load` command only for the validated no-mirror path. `runStage2TemplateLoad` is an explicit runtime seam and is intentionally not called by the automatic Phase 2 scheduler until the remaining template families and Java transform mapping are validated.

## Files changed (Chunk 55)
BP/scripts/systems/integrity_arena_model.js · BP/scripts/systems/integrity_arena_runtime.js · BP/structures/thebrokenscript/stage2/stone1.mcstructure · STAGE2_TEMPLATE_ASSET_AUDIT.json · tests/integrity_stage2_template_asset_model.test.mjs · docs/chunks/CHUNK_55_{SPEC,REPORT}.md · PORT_PROGRESS.md · PARITY_MATRIX.md · KNOWN_LIMITATIONS.md · ADAPTATION_NOTES.md · VALIDATION_LOG.md

## Chunk 56 — Integrity Phase 2 Stage 2 stone2 template asset

Chunk 56 validates the first rare Floor 4 `stone2` variant against the audited Java NBT source and adds the corresponding Bedrock structure asset. The model records the source blob, 16×9×16 dimensions, palette audit, 2304-cell count, Y 233 placement band, and `floor4_rare_variant_1` role. The implementation deliberately keeps asset loading opt-in while the custom Java generator and the other 62 templates remain deferred.

## Files changed (Chunk 56)
BP/scripts/systems/integrity_arena_model.js · BP/structures/thebrokenscript/stage2/stone2.mcstructure · STAGE2_TEMPLATE_ASSET_AUDIT.json · tests/integrity_stage2_stone2_asset_model.test.mjs · docs/chunks/CHUNK_56_{SPEC,REPORT}.md · PORT_PROGRESS.md · PARITY_MATRIX.md · KNOWN_LIMITATIONS.md · ADAPTATION_NOTES.md · VALIDATION_LOG.md

## Next chunk
**Next source boundary.** Convert the remaining 62 Stage 2 Java NBT templates—including entity/block-entity palettes and source custom IDs—into validated Bedrock assets, then integrate deterministic room/surface/tunnel placement with occupancy and Java RNG/mirror semantics. Java PlayerVariables/native packet-camera-music presentation and live Bedrock-world smoke validation remain later boundaries.
