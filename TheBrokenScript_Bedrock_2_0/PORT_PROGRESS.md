# PORT_PROGRESS.md

Last updated: 2026-08-31 (Chunk 29 — Jimmy multipart hitbox/support)

## Project facts
- Source mod: **The Broken Script 2.0** — `thebrokenscript-neoforge-2.0.0+mc1.21.1-build.3084.jar` (supplied as 9 decompressed chunk zips)
- Source form: **bytecode-only** (.class ×1982) + complete original resources — **NOW FULLY DECOMPILED** (1029 main + 815 brokencore .java under workspace `decompiled*/`)
- Extracted at: `C:\Users\mg4392\Downloads\tbs 2.0\source_extracted` (6765 files; `sites/rblog/file.bin` reassembled)
- Mod metadata: modId `thebrokenscript` v2.0.0; MC `[1.21.1,)`; NeoForge `[21.1.227,)`; deps: brokencore 0.1.0, extensibleenums; license All Rights Reserved
- Target: Minecraft Bedrock **1.26.50+**, manifest format 2, `@minecraft/server` **2.11.0-beta**, `@minecraft/server-ui` **2.1.0**
- Namespace: `thebrokenscript`

## Current chunk
**Chunk 29 complete — Jimmy multipart hitbox/support**

Chunk 29 ports the recoverable FracturedPartEntity, FracturedSubEntity, Leg, and BaseFracturedEntity multipart contract into a pure geometry/hit model and a dedicated runtime adapter. The runtime preserves the six logical part dimensions and offsets, body-yaw leg transforms, arrow side-effect order, and FracturedRoam SWITCHING promotion timer. Chunk 28 completed Jimmy's attack lifecycle, Chunk 27 completed the Integrity Phase 3 damage/death lifecycle, and Chunk 26 completed the Chord projectile runtime correction.

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
| 09 Items (192) + fluids approximation | **completed** (76 true items defined w/ icons/food/stacking, plush textures copied 39, item_texture 68→101, void_goop_still/flow fluid blocks, null_book story event wired at day 12+1000) |
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

No validation blocker is open; remaining engine/source-lifecycle gaps are tracked in PARITY_MATRIX.md and KNOWN_LIMITATIONS.md.

## Files created (Chunk 21)
BP/scripts/systems/integrity_arena_model.js Phase 3 constants/state/cutscene model · BP/scripts/entities/boss/boss_controller.js source-backed ring spawn and boundary countdown · tests/integrity_arena_model.test.mjs regressions · docs/chunks/CHUNK_21_{SPEC,REPORT}.md

## Files changed (Chunk 23)
BP/entities/integrity_arm.json (source non-persistent contract) · BP/scripts/systems/integrity_arena_model.js (GroundAttack/GroundArm constants and pure timing/impact/lifecycle plans) · BP/scripts/entities/boss/boss_controller.js (Phase 3 GroundAttack adapter, runtime owner map, arm impacts, stuck propagation, lifecycle) · tests/integrity_arena_model.test.mjs regressions · docs/chunks/CHUNK_23_{SPEC,REPORT}.md

## Files changed (Chunk 29)
BP/entities/{fractured,fractured_roam}.json · BP/scripts/entities/boss/{boss_controller,fractured_runtime}.js · BP/scripts/systems/fractured_multipart_model.js · tests/fractured_multipart_{model,runtime}.test.mjs · docs/chunks/CHUNK_29_{SPEC,REPORT}.md

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
Chunk 29 focused local validation: 10 deterministic multipart regressions PASS; changed multipart model/runtime/controller JavaScript passes `node --check`; fractured and fractured_roam collision-envelope JSON parses; source extents and six-part filtering assertions PASS. GitHub Actions validation for this head is pending; runtime/device smoke testing remains pending. Historical validation remains in VALIDATION_LOG.md.

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

## Next chunk
**Chunk 30 — FracturedRoam host lifecycle.** The next unfinished source slice is the remaining FracturedRoamEntity lifecycle: underground/dig movement, switching animation/state progression, arena start choreography, and despawn/host transitions. Chunk 29 only ports the multipart hit → SWITCHING → direct Fractured promotion adapter; it does not claim the full Java host lifecycle. Exact Java shaders/OS/packet hooks, verified font glyph mapping, optional Nostalgia import, NBT/xcsf tooling, and per-event day-schedule fidelity remain explicit engine/deferred items.

## Exact source references to inspect next
- `decompiled/net/thebrokenscript/entity/fractured/FracturedRoamEntity.java`
- `decompiled/net/thebrokenscript/entity/fractured/JimArena.java`
- Optional future passes: runtime device testing, verified Bedrock font-page mapping, complete Nostalgia archive review, plushie block forms + skin-fit, and NBT conversion tooling.
