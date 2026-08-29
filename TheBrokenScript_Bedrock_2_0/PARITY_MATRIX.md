# PARITY_MATRIX.md

Ledger of every source feature → Bedrock implementation status.
Component-level detail lives in `SOURCE_MAP.json` (912 rows, one per `SOURCE_INVENTORY.json` entry). This file tracks family-level rollups; both must end with no `uninspected`/`unknown`/`in_progress` rows at final release.

Status values: `uninspected` → `analyzed` → `in_progress` → `ported` → `validated`, or `blocked`.
Parity: `full` / `high` / `approximation` / `unsupported` / `unknown`.

| Source Feature | Source Evidence | Bedrock Implementation | Status | Parity | Validation | Notes |
|---|---|---|---|---|---|---|
| Mod bootstrap/lifecycle | TheBrokenScript.class, TBSEngineControl | Chunk 01 bootstrap.ts → src/main.js + core modules | ported (foundation) | full (infrastructure) | validate_pack.ps1 PASS; runtime test pending Minecraft install | |
| Shared runtime library (brokencore) | jarjar brokencore-0.1.0 | decompiled (815 files); StoryEvent/clock/config semantics absorbed into src/shared+core | ported | high | validator PASS | |
| Registries (entities/blocks/items/etc.) | registry/ 545 classes | JSON definitions + ID constants module | uninspected | unknown | — | roster enumerated: 69 entities, 123 blocks, 192 items |
| Circuit family (6 entities) | TBSEntities CIRCUIT* (6), entity/circuit/*, handlers/circuit/*, BIOME_BLACKLIST | BP/RP entities + controller + spawn rule (stalk predicate ported: skyLight, blacklist, 420, 5200) | ported | high | validate_pack PASS; runtime chase fidelity approximated | wall-climb destroy, boat discard, grace overlay skipped for high parity |
| Null watcher/scare (4 entities) | TBSEntities NULL_WATCHING/SCARE/MINING/IS_HERE, entity/nullent/* | BP/RP entities + controller (8000/40/1200/500 timers, 10-case anger, mining build, flying approach) + NullConditions port (7200 delay, sky visible, isNullHere) | ported | high | validate_pack PASS | dimension teleport cases approximated |
| Null pursuit/endgame (7 entities incl. alias) | TBSEntities NULL_CHASE(nulll alias)/MAZE/ENDGAME/UNBEATABLE/FLYING/INVADE, entity/nullent/* | BP/RP entities + pursuit controller (450/3200/420/500 timers, chase/maze light, endgame 999 pulse, unbeatable invuln) | ported | high | validate_pack PASS | maze door break, flying FOV sneak approximated |
| Entities & variants (remaining) | entity/ 216 classes; TBSEntities (52 remaining) | Chunks 05D–05F per family | uninspected | unknown | — | |
| Stalking/psychological AI | circuit_stalk/stare, siluet_stare, tbe_stalk, fever_stalk, null_watching… | framework live (finder/gaze/effects/refs/spawn director/delay timers); per-entity FSMs in 05A–05F | ported (framework) | high | validate_pack PASS | gaze=cone approximation; gate omissions ledgered per rule |
| Bosses (Integrity P1–3, Jimmy, Kerfur) | boss/, entity/integrity/phase1..3, xcsf arena | Integrity Arena/Phase source model + source-backed Stage2 generator and Stage2Util audits; existing boss controller; fabricated P1/P2 health-threshold transitions removed | in_progress | unknown | JS regression tests + Stage2 NBT/Stage2Util audits + add-on CI | Source-backed model covers phase order, 150-block participant capture, Arena liveness, P1 1080/100/20/10/10 semantics, Stage2 floor bands/mappings, Stage2Util cell-center/chunk selection/safe-floor scan/tether exclusion semantics, generator layer/template selection, and current P3 center/boundary/tentacle/end predicates. Automatic arena start, Stage2 generator/tether runtime, P3 runtime/cutscene, Jimmy, and Kerfur parity remain pending. |
| Projectiles | chord_projectile, integ_fireball, integrity_ball dmg type | Chunk 05F/07 | uninspected | unknown | — | |
| Damage types (20) | data/damage_type/*.json | BP damage_type equivalents where supported; scripted fallbacks | uninspected | unknown | — | |
| Status effects (2) | TBSEffects | scripted effect emulation | uninspected | approximation-pending | — | no custom potion registry |
| Player/world/persistent state | TBSDataAttachments, handlers | src/systems/{world_state,player_state}.js + state service — full schema defaults ported | ported | high | validator PASS | MapVariables/PlayerVariables decompiled |
| Events engine (~94 named) | events/, TBSEvents lang keys | story-clock driver live; named event modules land in Chunk 12 | in_progress | unknown | — | |
| Chat responses (45) | TBSChatResponses, responses/ | chat keyword engine (Chunk 02/12) | uninspected | unknown | — | moved: chat engine lands with events chunk |
| Story progression (stages) | TBSStoryEvents, events/story | story_time clock + txt/coords/moon events wired; null_book pending item system | in_progress | high | validator PASS | thresholds days(5,6,12,24,32,38,48)+1000 preserved |
| Blocks (123) + block entities (8) | blockstates/, block/, TBSBlockEntities | Chunk 08 | uninspected | unknown | — | portal controller/extender critical path |
| Items (192) | item lang ids, TBSItems/TBSEasterEggItems/TBSPlushies | Chunk 09 | uninspected | unknown | — | incl polaroid pieces, hand cannon, discs, plushies |
| Fluid void_liquid | neoforge/fluids, TBSFluids | approximated translucent/damage block | uninspected | approximation-pending | — | Bedrock lacks custom fluids |
| Dimensions (13) | data/dimension/*.json | Chunk 10 (strategy pending) | uninspected | unknown | — | see BEDROCK_COMPATIBILITY decision |
| Portals | block/portal/, portal_controller/extender items | Chunk 08+10 | uninspected | unknown | — | safe arrival validation required |
| Biomes (15) + carver/features/noise | worldgen/** | Chunk 11 | uninspected | unknown | — | noise_settings = documented approximation |
| Structures (source corpus + shaft jigsaw + xcsf) | structure/, xcsf_structure/ | Six-piece Shaft now has source-backed NBT + native Jigsaw pools/structure; 64-template Integrity Stage 2 NBT audit/model; remaining structure corpus and XCSF reconstruction still pending | in_progress | unknown | six Shaft source/BP Git blob SHAs match; JSON + binary-NBT connector validators present; Integrity model regression tests + Stage2 metadata audit | Stage2 templates are source-present but Java custom-generator placement is blocked in Bedrock; do not treat native Shaft assembly, the Arena source model, or the Stage2 audit as full corpus/world-placement/XCSF runtime parity |
| Shaft Jigsaw | `data/thebrokenscript/structure/shaft/*.nbt` (corner, hall, junction, room, room_hall, root) | `BP/structures/thebrokenscript/shaft/*.nbt` + `BP/worldgen/template_pools/{shaft_root,hallway,shaft_room}.json` + `BP/worldgen/structures/shaft.json` | in_progress | unknown | source-identical templates; NBT connector graph checks pool/target/name compatibility; regression tests added | Natural `structure_set` frequency/spacing and source pool weights remain pending authoritative Java placement evidence; current generation parameters are not promoted to full parity |
| Spawn conditions/modifiers (33) | biome_modifier/spawns, TBSSpawnConditions | spawn director (Chunk 02) + native rules | uninspected | unknown | — | |
| Recipes (40) | data/recipe/*.json | BP recipes Chunk 13 | uninspected | unknown | — | |
| Loot tables | loot_table/blocks(150+)/entities(1) | BP loot Chunk 13 | uninspected | unknown | — | |
| Tags | data/*/tags/** | BP/RP tags Chunk 13 | uninspected | unknown | — | |
| Advancements (5) | advancement/*.json + triggers | Bedrock-equivalent tracked state + toast-equivalent UX Chunk 13 | uninspected | approximation-pending | — | |
| Commands + fx toggles | command/, command/dev | script commands Chunk 13 | uninspected | unknown | — | |
| Networking (music/debug/gui sync) | network/, TBSPackets | server-authoritative script flow | uninspected | unknown | — | |
| Animations/render/audio/camera/UI | client/, assets | RP foundation built: geo×77 (26 ids fixed), anims×36, sounds+defs×143, textures×502, atlases, flipbooks×5, lang | ported (foundation) | full (asset layer) | validate_pack PASS; per-entity controllers land in Chunks 04–05x/14 |
| Particles (9 defs) | particles/*.json | translated RP particles | uninspected | unknown | — | |
| Java GLSL shaders (89 files) | shaders/** | approximation layer; pipeline unsupported | uninspected | unsupported-pending | — | VHS/aberration/invert/dream/fever/glitch/sky |
| GUI screens/menus (10 menus + overlays) | TBSMenus, client/gui | forms + overlays | uninspected | approximation-pending | — | |
| Desktop integration (window title/LWJGL/JFrame/txt files/ban-kick) | window.* keys, events/jframe, config enableFileCreation | ENGINE_UNSUPPORTED except in-game kick/title equivalents | uninspected | unsupported-pending | — | documented in KNOWN_LIMITATIONS |
| Config surface (gameplay-affecting) | config/common + lang configuration keys | config layer seeded with decompiled defaults (world/danger/entity groups, 15 values) | ported (partial groups) | full | validator PASS | remaining client/accessibility/menu groups land in Chunk 14 |
| Music discs (12 jukebox songs) | jukebox_song/, TBSSongs | custom discs + music system Chunk 09/14 | uninspected | unknown | — | |
| Paintings (1) | painting_variant/circuit_cave | approximation (no custom painting variants) | uninspected | approximation-pending | — | |
| Embedded nostalgia packs | nostalgia/, nostalgia_gen/ | optional RP or documented exclusion | uninspected | unknown | — | decision Chunk 03 |
| books/book0.book, sites/rblog/file.bin | misc binaries | parse book format Chunk 12; bin external-only | uninspected | unknown | — | |

Chunk-level completion updates this table; SOURCE_MAP.json carries the 912-row component detail.
