# CHUNK_17_REPORT — Full parity audit vs SOURCE_INVENTORY (912 entries)

## Method
Every entry in `SOURCE_INVENTORY.json` (912) classified against the shipped pack:
**PORTED** (1:1 Bedrock artifact), **APPROX** (Bedrock equivalent with behavioral deltas — ledgered in chunk reports / KNOWN_LIMITATIONS A-series), **DEFERRED** (planned follow-up), **N/A-ENGINE** (impossible by design).

## Category ledger
| Category | Source | Ported (1:1) | Approx | Deferred / N-A | Basis |
|---|---|---|---|---|---|
| item | 192 | 76 true items + 123 block-item forms implicit | food/stack flags; functional items stubbed → Ch12/13 | plush block-forms | BP/items, item_texture 101 |
| block | 123 | 123 JSONs, exact textures/ids | slab/stairs/wall geos; fences/trapdoors/doors cubes; flora cross; animated tex static | — | BP/blocks + loot ×126 |
| horror_event | 94 | — | 78-id gated pool + story thresholds (Ch12); OS-fakes = titles per A-004 | per-event day-schedule fidelity → Ch17b if needed | horror_events.js |
| entity | 69 | 68 registry ids (+ nulll alias = 69nd mapping) as BP/RP pairs | controller-driven AI approximations (per-chunk reports) | — | BP+RP entities |
| code_package | 199 | decompiled semantics extracted (Ch02+) and re-expressed across 46 script modules | behavior-level, not line-level | mixins (124) = N/A-ENGINE or absorbed | src/** |
| recipe | 40 | 40/40 (incl. 16 stonecutter-tagged) | — | — | BP/recipes |
| spawn_rule | 35 | covered by 11 spawn_director rules w/ source constants (matrices/delays/exclusions) | candidate-ring placement vs heightmap pos | — | *_spawn_rules.js |
| sound | 18 defs → 143 events | 143 sound_definitions + 191 ogg | — | — | RP |
| damage_type | 15 | applied via applyDamage causes where mappable | numeric equivalents | custom types N/A | controllers |
| biome | 15 | 15 JSONs + fog palettes | climate stubs (no decoration features) | feature decoration → worldgen tooling | BP/biomes, biomes_client |
| dimension | 13 | 12 customs + overworld refs | void terrain (Java generators not convertible) | per-dim sky/fog styling → presentation residue | BP/dimensions, dimensions.js |
| music | 13 | discs as items + instability songs referenced in random_song | network-synced music N/A (server-auth model) | jukebox_song JSONs deferred | items/horror_events |
| gui | 11 | title/actionbar beats | menus/interfaces → titles | real GUI screens N/A | horror_events/controllers |
| particle | 9 | vanilla-particle substitutes | — | custom particle sheets N/A | controllers |
| worldgen | 8 packages | procedural Shaft/Hallway builders; biome climate stubs | — | 305-NBT corpus conversion (tooling) | worldgen_structures.js |
| block_entity | 8 | beta blockComponentRegistry behaviors (command/portal×2/null_structure/shadow_bug/a_flower/all_dead-via-flesh/exit) | interaction stubs for portal flow → Ch10 wiring done | full BE data models | custom_blocks.js |
| progression | 5 | 5/5 award() wired | titles/sounds instead of advancement UI | — | progression.js |
| structures | 4 sets | shaft family procedural | hallway analogue | full NBT corpus conversion (tooling) | worldgen_structures.js |
| misc_asset | 6 | file.bin + books preserved out-of-pack | credits/book content via lang pages | — | KNOWN_LIMITATIONS #11 |
| tags | 3 | LOOKABLE approximated as 19-type list; others unused at runtime | — | tag files N/A | humanoid_controller |
| status_effect | 2 | emulated (darkness/blindness combos) | — | custom effect ids N/A | effects.js (A-002) |
| fluid | 1 | void_goop still/flow blocks | no flow physics (engine) | — | BP/blocks (A-001) |
| loot | 2 | blocks self-drop ×125 + null_cod | simplified pools | — | BP/loot_tables |
| desktop_integration | 1 | kick/titles only | — | window/JFrame/files = ENGINE_UNSUPPORTED (A-004) | KNOWN_LIMITATIONS #1 |
| embedded packs | 2 nostalgia | preserved out-of-pack | optional ship decision | — | KNOWN_LIMITATIONS #12 |
| networking/packets/event_engine/command/chat/config/player_state/registry/font/painting/shader/animation/texture/model_geometry/library/metadata/build_artifact/code_entrypoint | ~20 | script-authoritative equivalents; config defaults registered; chat responses 14 mapped; font/painting/shader documented N/A or substituted | — | — | core/systems |

## Totals
- **PORTED (1:1)**: entities 68(+alias), blocks 123, recipes 40, sounds 143 defs/191 ogg, items 76, biomes 15, dimensions 12, advancements 5, loot 127, geo 77+, textures 502+, lang 997 lines
- **APPROX**: all controller AI (per-chunk parity notes), event choreography pool, fluids, BE interactions, worldgen builders, OS-fakes (A-004)
- **DEFERRED (tooling/later)**: 305-NBT structure conversion, xcsf arena import, per-event day schedules, plush block forms, herobrine/phantom skin-fit, per-dimension sky rendering
- **N/A-ENGINE**: JVM/desktop integration, Java GLSL shaders, custom fluids physics, custom effect/particle ids, mixins, mod-compat interop (KNOWN_LIMITATIONS 1–16)

## Verdict
No shipping gameplay category is missing. Every one of the 912 inventory entries maps to a shipped artifact, a ledgered approximation, an explicit deferral, or a documented engine limitation.
