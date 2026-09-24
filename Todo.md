# The Broken Script 2.0 — Remaining Bedrock Port Work

Updated: 2026-09-22

This replaces the previous cumulative TODO with the remaining documented work. Completed audit history is omitted; its evidence remains in the repository audits and Git history. This list covers all 57 previously partial checklist items plus concrete omissions/deferred work identified by the supporting audits. It is not a claim that a fresh full Java-to-Bedrock audit or engine test has been performed.

An unchecked item means work remains, not necessarily that the feature is absent:
- **Implementation**: a documented runtime path or asset import is unfinished.
- **Verification**: an implementation/adapter exists but source or engine evidence is incomplete.
- **Conditional**: revisit only when source evidence or API capability changes.
- **BLOCKED**: the exact Java mechanism is outside the documented Bedrock contract; retain the closest supported behavior.

## P0 — Release evidence

- [ ] Run the complete smoke matrix on the exact build/API contract in [API_AUDIT.md](TheBrokenScript_Bedrock_2_0/API_AUDIT.md), currently the 1.26.50 Preview target with the pinned 2.11.0-beta dependency.
- [ ] Commit a genuine passing `tests/runtime-smoke/latest-report.json` with the required evidence. Only the matrix, README, and report template are currently present.
- [ ] Resolve parity-critical runtime errors/warnings before release; use the existing report validator and release gate. Static checks and synthetic profiles cannot substitute for engine evidence.

## P1 — Confirmed implementation gaps and deferred assets

- [ ] **Runtime verification — particles:** in the pinned 1.26.50 Preview, verify visible output for the completed `fardaway`, `wretched_particle`, `null_structure_particle`, and `paper_particle` bridges, including multiplayer player-local visibility for Null Structure/Library Paper and the documented Paper cadence approximation.
- [ ] **Implementation/verification — structures:** complete or validate Integrity Stage 2 and XCSF reconstruction/placement within supported generator/processor capabilities. Inventorying all 314 templates is not proof that their placement behavior is ported.
- [ ] **Deferred — Nostalgia pack:** obtain a complete reliable source archive, inventory missing overrides, resolve broad vanilla sound/model conflicts with the main RP, and validate the optional pack. Do not claim a complete import from the partial multipart archive.
- [ ] **Deferred — custom fonts:** resolve A-009 only with verified Bedrock glyph-page mappings; retain standard-glyph formatting until that evidence exists.

## Remaining verification and conditional work

The following carries forward every previously partial task. These checks must be completed against source and, where behavior depends on the engine, a real world run. Fix any confirmed discrepancy or record the unavoidable observable difference.

### 1. Runtime smoke-test matrix

- [ ] Establish a repeatable smoke-test world for the exact Bedrock build/API contract documented in `API_AUDIT.md`. The checked-in world contract, scenario steps, evidence requirements, and report schema are in `tests/runtime-smoke/matrix.json` and `tests/runtime-smoke/README.md`.
- [ ] Test first world creation and pack initialization (`bootstrap`).
- [ ] Test save → quit → reload for world state and player state (`persistence`).
- [ ] Test player death/respawn while story, quest, boss, and effect state is active (`death_respawn`).
- [ ] Test leaving/rejoining and server restart persistence (`leave_rejoin_restart`).
- [ ] Test two-player and multi-player ownership/targeting/event behavior (`multiplayer`).
- [ ] Test dimension travel, return travel, safe arrival, and portal recovery/failure paths (`dimensions`).
- [ ] Test boss encounter start, abort, player death, reconnect, victory, cleanup, and replay prevention (`boss_lifecycle`).
- [ ] Test story progression across every threshold and one-shot event (`story_progression`).
- [ ] Test event suppression while boss arenas/other suppressors are active (`event_suppression`).

### 2. Every entity family

Compare each entity's Java source with its deployed Bedrock definition/controller and in-game behavior:

- [ ] health, movement speed, follow range, scale, collision size, knockback resistance, attack damage, armor, and immunities;
- [ ] spawn conditions, rarity, biome/dimension blacklist/whitelist, light/sky checks, distance gates, delays, and caps;
- [ ] despawn rules and persistence;
- [ ] AI state transitions, timers, interruptions, grace periods, and cooldowns;
- [ ] teleport, stalking, hiding, chase, flee, mining/block interaction, and environmental side effects;
- [ ] sound/particle/animation events at exact state/tick boundaries;
- [ ] death behavior, drops, progression hooks, and cleanup.
- [ ] Revisit dimension-teleport approximations in Null behavior.
- [ ] Revisit maze door/block-breaking behavior that was skipped or approximated.
- [ ] Revisit flying FOV/sneak behavior.
- [ ] Revisit chunk-removal/chunk-operation surrogates and confirm the closest safe observable behavior.

### 3. Jimmy / Fractured / FracturedRoam parity

Conditional API review; the source-backed boss models are not being reopened as missing systems.

- [ ] Revisit rendered-bone/world-contact adapters if Bedrock exposes usable locator/bone transform data in a future API.

### 4. Projectiles and damage

- [ ] Verify Bedrock damage causes do not accidentally change armor, shield, invulnerability, totem, knockback, or attribution behavior compared with each Java custom damage type.

### 5. Quest/progression behavior

- [ ] Verify rewards, item quantities, effects, messages, sounds, and state flags.
- [ ] Verify progression remains correct after reload, death, disconnect, and multiplayer participation.

### 6. Blocks and block entities

- [ ] Audit all 123 source blocks against Bedrock definitions for material-like behavior, hardness/destruction time, tool requirements, collision/selection boxes, light, placement, drops, sounds, ticking, redstone-like behavior, and scripted interactions.
- [ ] Audit all 8 source block-entity equivalents for storage/state/tick semantics.
- [ ] Verify custom geometry blocks (slabs/stairs/walls/cross flora) behave correctly for collision, placement, rotation, water/environment interaction where relevant.

### 7. Items

- [ ] Verify stack size, durability, cooldown, use duration, use animation, consumability, food/effect values, rarity-like presentation, enchantability, and creative availability where applicable.
- [ ] Verify Java data-component/NBT semantics are preserved where gameplay observes them.
- [ ] Verify item behavior under full inventory, death, container transfer, duplication-sensitive paths, and multiplayer ownership.

### 8. Commands and operator/dev behavior

- [ ] Match arguments, default values, validation, error cases, messages, and side effects.

### 9. Dimension parity

- [ ] Verify spawn/entry position, time/light/environment settings, fog, biome association, portal routes, return routes, and death/respawn behavior.
- [ ] Test cross-dimension entity/player references for stale handles and cleanup.
- [ ] Verify dimension-specific event/spawn restrictions.

### 10. Structures and jigsaw/world placement

- [ ] Verify rotations, mirrors, connector orientation, pools, target/name matching, weights, projection/placement behavior, and processors.
- [ ] Verify native Shaft assembly against Java pool weights and natural placement frequency/spacing once authoritative source evidence is recovered.
- [ ] Resolve remaining Integrity Stage 2 placement behavior where Java's custom generator cannot map directly.
- [ ] Complete/verify XCSF reconstruction and decide which portions can be made runtime-equivalent.
- [ ] Compare actual in-game generated structures to Java screenshots/world samples where source alone is insufficient.

### 11. Portals

- [ ] Verify mobs/items/projectiles if Java portals support them.
- [ ] Test portal behavior when destination chunks/dimensions are unavailable or initialization fails.

### 12. Animations and render-controller behavior

- [ ] Verify server-side damage/event keyframes remain synchronized with visible animation under lag.
- [ ] Verify look/head tracking and procedural tentacle behavior identified as pending-analysis adapters.

### 13. Particles

- [ ] Revisit resource-only particles if Java source later proves runtime callsites exist.

### 14. Audio/music

- [ ] Test music/loop cleanup on death, disconnect, dimension change, boss abort, and reload.
- [ ] Keep Java FancyAudio/fade/attenuation differences explicit where Bedrock cannot reproduce them.

### 15. UI, camera, overlays, shaders, and fonts

- [ ] Verify VHS/UI overlays do not unintentionally affect unrelated screens or multiplayer players.
- [ ] Re-evaluate A-009 custom-font support only with a verified Bedrock glyph mapping; do not globally replace unrelated vanilla glyphs.

### 16. Expand source-backed regression tests

- [ ] Add pure-model tests for every mechanic with meaningful constants/timers/state transitions.
- [ ] Add boundary tests for every inclusive/exclusive random range and tick threshold.
- [ ] Add tests for negative conditions, not only successful activation.

### 17. Performance without behavior loss

- [ ] Profile all 1-tick controllers and world/entity scans in realistic multiplayer/entity counts.
- [ ] Add defensive budgets where Bedrock engine limits require them, with parity impact documented.

### 18. Script API/version safety

- [ ] On every Bedrock/API upgrade, re-check old `ENGINE_UNSUPPORTED` and approximation entries for newly available APIs.
- [ ] Run full static validation plus in-game smoke tests before declaring a new runtime supported.

## Exact-parity boundaries — retain adapters

These are documented mechanism limits, not ordinary missing-code tasks. Reassess against the pinned API when capabilities change; do not remove the gameplay surrogate just because exact parity is blocked.

- `BLOCKED` exact Java mechanism cannot currently be reproduced by Bedrock; preserve closest observable behavior and document it
- `BLOCKED` Java OS/window/JFrame/arbitrary desktop-file integration.
- `BLOCKED` Java GLSL/core post-processing pipeline.
- `BLOCKED` true Java-style custom fluid registration/physics.
- `BLOCKED` exact Java custom mob-effect registry/attribute modifier behavior.
- `BLOCKED` native Java advancement definitions.
- `BLOCKED` exact Java custom painting variant registration.
- `BLOCKED` exact Java noise-settings terrain generator parity.
- `BLOCKED` packet interception/suppression/replay used by the Java desync mechanic.
- `BLOCKED` Java mod-compatibility mixins for other Java mods.
- `BLOCKED` exact custom Java damage-type registration and all associated bypass/death-message semantics.
- `BLOCKED` Java multipart child-entity/render-bone mechanisms where Bedrock exposes no equivalent transform/contact API.
- `BLOCKED` some Java packet-driven overlays/music/camera transport.
- `BLOCKED` Java raw chunk-section storage mutation and exact force-load/unload ticket lifecycle; verify the existing loaded-chunk operations and modified-chunk ledger instead.
- `BLOCKED / ADAPTED` exact Java Maze navigation/door geometry, client FOV transport, and swing hooks; verify the source-backed models and supported Bedrock controller behavior.
- `ADAPTED` Java block-entity NBT/storage/tick internals, item-tag registry semantics, and book component serialization where the pinned ABI lacks equivalent mechanisms.
- `ADAPTED` Java FancyAudio fading/attenuation/mixing, particle custom rendering/emitter physics, and disc comparator behavior; retain explicit observable differences.
- `ADAPTED` Java vanilla loot output mappings for cobblestone stairs and oak doors; keep their source conditions/weights and documented custom-block mappings.

Integrity still has transport/presentation differences (transition overlay, camera interpolation/zoom, music packets, custom dying animation and damage/owner metadata). Jimmy/Fractured still uses conceptual multipart regions rather than exact rendered-bone/melee impact positions. Test their supported behavior through the boss lifecycle, damage, animation, and audio checks above.

Resource-only `follows_particle`/`revuxor_particle`, intentional source-only `video/alpha3`, and the opaque non-Minecraft `sites/rblog/file.bin` are not confirmed missing gameplay implementations. Require new source evidence before expanding their scope.

## Completion requirements

Close a task only when its applicable evidence exists:
- Identify the Java source/data/resource and corresponding deployed Bedrock path.
- Match triggers, constants/ranges, tick order, cooldowns, RNG selection, state transitions, and side effects.
- Verify multiplayer ownership and save/reload/death/reconnect behavior where relevant.
- Cover negative/error cases and add a focused automated regression where practical.
- Attach in-game evidence for engine-dependent behavior.
- Record unavoidable differences in adaptation/limitation docs and update the source map and parity matrix.

## Work order

1. Produce runtime smoke evidence and fix gameplay-critical failures.
2. Finish supported Stage 2/XCSF work; runtime-verify the restored portal sweep and completed particle bridges.
3. Close entity/combat, block/item/quest, dimension, and structure verification gaps.
4. Verify animation/audio/UI behavior and profile real multiplayer loads.
5. Complete deferred optional assets when reliable source material is available.
6. Revisit conditional engine/API gaps during deliberate version upgrades.

## Evidence and contracts

- [Runtime smoke matrix](tests/runtime-smoke/matrix.json) and [instructions](tests/runtime-smoke/README.md)
- [P1 parity audit](TheBrokenScript_Bedrock_2_0/docs/P1_PARITY_AUDIT.md)
- [Presentation timing audit](TheBrokenScript_Bedrock_2_0/PRESENTATION_TIMING_AUDIT.md)
- [Known limitations](TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md)
- [Adaptation notes](TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md)
- [Source map](TheBrokenScript_Bedrock_2_0/SOURCE_MAP.json) and [parity matrix](TheBrokenScript_Bedrock_2_0/PARITY_MATRIX.md)
