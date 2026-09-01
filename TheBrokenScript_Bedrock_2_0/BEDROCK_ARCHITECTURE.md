# BEDROCK_ARCHITECTURE.md

Semantic port of The Broken Script 2.0 (NeoForge, MC 1.21.1) → Minecraft Bedrock 1.26.10+ add-on.

## Project layout

```
TheBrokenScript_Bedrock_2_0/
  BP/                     behavior pack (data + script modules)
    manifest.json
    entities/  blocks/  items/  recipes/  loot_tables/
    dimensions/ dimension/ biomes/ features/ feature_rules/
    structures/ functions/ tags/ spawn_rules/ texts/
  RP/                     resource pack (resources module)
    manifest.json
    entity/ models/ animations/ textures/ sounds/ sound_definitions.json
    particles/ fog/ texts/ terrain_texture.json item_texture.json flipbook_textures.json
  src/                    TypeScript sources -> compiled to BP scripts (deployed JS)
  tools/                  generators + validators (PowerShell)
  docs/chunks/            per-chunk specs and reports
  *.md / *.json           persistent project memory (this file set)
```

Namespace: `thebrokenscript` everywhere (see IDENTIFIER_MAP.json).

## Source package → Bedrock subsystem mapping

| Source family (evidence) | Bedrock design |
|---|---|
| `TheBrokenScript.class` bootstrap, `TBSEngineControl` | `src/bootstrap.ts`: startup event init, feature flags, error containment, logging |
| `registry/*` (TBS* classes, 545 classes) | Data-driven JSON definitions + registry constants module mirroring every ID (IDENTIFIER_MAP is authoritative) |
| `TBSEvents` (~91 handlers), `events/**` (97 classes) | Central event engine: `worldAfterEvents/worldBeforeEvents/system.runInterval` scheduler; ~94 named horror events as data+handler modules with source timing/probabilities |
| `TBSStoryEvents` (stages) | Story stage machine persisted in world dynamic properties; gates encounters/events |
| `handlers/player`, `TBSDataAttachments` (player_base, player_variables, circuit_inhabited, interaction_tracker) | Per-player state service on dynamic properties; join/leave/death/respawn lifecycle hooks |
| `handlers/audio`, `network/music` | Server-authoritative music/sfx dispatcher (playSound, music disc logic, synced cues) |
| `handlers/chat`, `TBSChatResponses` (45) | Chat response engine: keyword triggers → scripted reactions (titles/sounds/entities) |
| `TBSSpawnConditions` (24 conditions) + `biome_modifier/spawns` (33) | Spawn director: event-driven + bounded-interval spawner reproducing condition predicates (light/distance/structure/player-state); native spawn_rules where sufficient |
| `entity/**` (216 classes, 69 registered entities incl. variants) | BP entity JSONs + RP client entities reusing native-format geo/animations + per-entity controller modules implementing source AI as explicit state machines |
| Stalking/observation AI (circuit_stare/stalk, siluet_stare, tbe_stalk, fever_stalk, null_watching, he_hallucination…) | Shared stalking framework (Chunk 04): LOS, last-known-position memory, observation timers, imperfect information, escalation/cooldowns, teleport governance |
| `boss/**` integrity/jimmy/kerfur, `entity/integrity/phase1..3`, xcsf arena | Boss framework: phase machines, thresholds, summons, arena control (stage2/xcsf → .mcstructure + scripted choreography) |
| `block/**` (76 classes), blockstates (123), block entities (8) | Custom blocks (1.26.10 schemas) + scripted custom components replacing BEs (portal_controller/extender, corrupted command block, trigger/template blocks) |
| `item/**`, TBSItems/TBSEasterEggItems/TBSPlushies (192 ids) | Custom items (stable components) + script behaviors where beyond data-driven |
| `neoforge/fluids` void_liquid | ENGINE approximation: tinted translucent block + damage/slow/particle script layer (no custom fluids) |
| `world/dimension` (13 dims), portals | Dimension strategy per BEDROCK_COMPATIBILITY (data-driven void-type dims where possible; script-registered dims isolated behind dedicated module; portal blocks/items drive safe transitions with arrival validation) |
| `world/gen` features/structures, noise_settings, jigsaw shaft | Biomes/features/feature-rules/.mcstructure conversions; jigsaw shaft → structure templates + placement scripts; noise terrain approximated (documented) |
| `cutscene`, client/cutscene, camera mixins | Stable v2.6.0 camera spline/attach APIs; no invented cinematics |
| Client VFX mixins, shaders (VHS/aberration/invert/dream/fever/glitch) | Approximation layer: fog, particles, titles, screen-shake via camera, overlay-equivalents; exact GLSL pipeline ENGINE_UNSUPPORTED |
| GUIs/menus (`TBSMenus`, NullInterface, PC GUI, fake disconnect) | ActionForm/ModalForm flows + title/actionbar overlays; desktop-window effects ENGINE_UNSUPPORTED (in-game kick/title equivalents only) |
| `command/**` (+dev), `/fx` toggles | Chat-command emulations via `!`-prefix script commands and/or custom behavior; fx flags persisted per-world |
| Config (`config/common`, 17 classes) | Bedrock config layer: world-scoped dynamic properties seeded from source defaults; parity values preserved |

## Runtime principles

- Event-driven first; bounded intervals only where source polls; no full-world scans.
- Server-authoritative state; stable IDs over retained entity refs; cleanup on leave/death/unload.
- One central scheduler + per-subsystem tick budgets; duplicate-registration guards.
- Error containment per module; content-log errors are defects.

## Subsystem dependency graph (build order)

```
bootstrap ─┬─ config layer ── shared runtime ─┬─ story stages ─┬─ events engine ─ chat responses
           ├─ persistence service             ├─ player state   ├─ spawn director
           └─ scheduler                       └─ sound/music    └─ encounter scheduler
shared runtime ── entity framework (AI primitives, stalking FSM) ── entity families ── bosses
asset foundation (geo/anims/textures/sounds/particles) ── independent, feeds entity/item/block chunks
blocks ── portals/dimensions ── worldgen ── integration ── audits ── packaging
```

## Revised chunk schedule (authoritative, replaces prompt default grouping)

| Chunk | Scope |
|---|---|
| 00 | Complete source inventory & architecture (this execution) |
| 01 | BP/RP foundation: manifests (format 2), UUIDs, deps, TS→JS pipeline, bootstrap, scheduler, persistence service, static validators; minimal loadable addon |
| 02 | Shared runtime: player/world state, story-stage machine, config layer, spawn director framework, encounter scheduler, chat response engine skeleton |
| 03 | Asset foundation: copy geo/anims/textures/sounds; sound_definitions, terrain/item_texture, particles translation, fog, localization |
| 04 | Entity framework + stalking/AI primitives (state machine framework, LOS/LKP memory, teleport governance, damage helpers, multiplayer target rules) |
| 05A | Circuit family (circuit, stare, stalk, mineshaft flee/stare/walk) + handlers.circuit + disguised-circuit config |
| 05B | Null watchers/scare variants (null_watching, null_scare, null_mining, null_is_here, deceiver, nulll, nothingiswatching pair, nothing_watcher, stare, name_tag, eerie_noise) |
| 05C | Null pursuit/endgame (null_chase, null_maze, maze_shadows, null_flying, null_invade_base, null_unbeatable_bossfight, null_endgame, ban, corruption, chunk_remover) |
| 05D | TBE family (the_broken_end + ambush/curious/stalk) |
| 05E | Humanoid apparitions (siluet ×3, faraway, he/he_chase/he_hallucination, herobrine, fake_player, phantom_player, xxram_2die, curved/DyeXD412, follow/no-texture, hetzer, murderfur, jon, liberty) |
| 05F | Remaining entities (fever, fever_stalk, fractured_roam + fractured(+attacks), oblit/the_obliteration ×2, sub_anomaly_1/2, rock, tether, void_tentacle, chord + chord_projectile, integrity_arm, integ_fireball, null_cod, he misc) |
| 06 | Shared psychological/stalking systems completion pass (cross-entity pressure patterns, isolation, adaptive behavior) if not fully covered by 04/05x |
| 07 | Bosses: Integrity phases 1–3 (+arm/fireball/curious, xcsf arena), Jimmy (rise/stomp/triggers), Kerfur; boss handlers/audio/bar |
| 08 | All 123 blocks + 8 block-entity equivalents + trigger/template/portal blocks |
| 09 | All 192 items + void liquid approximation + hand cannon + polaroid pieces + discs |
| 10 | 13 dimensions + portal system (strategy per compatibility doc; experiments documented) |
| 11 | Worldgen: 15 biomes, features/carvers/noise approximations, structures (.nbt→.mcstructure families), shaft jigsaw equivalent, void_growth |
| 12 | Events & horror choreography: all 94 named events + story events + jframe/desktop-tier replacements |
| 13 | Progression: advancements(5), recipes(40), loot, tags, commands/fx toggles |
| 14 | Presentation completion: animations/controllers, render controllers, materials/emissives, audio polish, camera, UI/forms, fonts gap |
| 15 | Integration pass (cross-system matrix from prompt §25) |
| 16 | Multiplayer & performance audit |
| 17 | Full source parity audit vs SOURCE_INVENTORY (912 entries) |
| 18 | Final validation (static + runtime) |
| 19 | Packaging: .mcaddon + final reports |
| 20 | Remaining safe source ports and VHS UI integration |
| 21 | Integrity Phase 3 runtime semantics: tentacle ring, boundary countdown, and cutscene timing model |

Subchunk splits remain allowed (Chunk NNx) without changing this table's contract.

## Chunk 22 mapping update

- `VoidTentacleEntity.Attributes.SCALE` → `description.properties.thebrokenscript:scale` with `client_sync: true`.
- Scale-dependent rendering → five `minecraft:scale` component groups selected by namespaced entity events.
- Phase 3 fixed scale presets → controller calls the same property/event bridge with value 2.

## Chunk 23 mapping update

- `GroundAttack` target/range/timing → Phase 3 controller state plus pure model functions: inclusive 40–80 selection, target-block capture at tick 33, arm creation at tick 40, and 70-tick post-attack cooldown.
- `IntegrityP3GroundArmEntity` ownership → guarded in-memory `arm.id → Integrity Phase 3 entity` references; owner absence discards the arm.
- GroundArm impact/lifecycle → tick-5 source damage and knockback plan, owner-stuck propagation, and tick `>40` / `>180` tentacle-proximity discard thresholds.
- Java `AABB.intersects` → Bedrock five-block `Dimension.getEntities` contact approximation; exact synchronized integer owner IDs and the complete Phase3Goals selector remain deferred.
