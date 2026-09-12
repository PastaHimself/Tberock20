# Java → Bedrock Parity TODO

This is the active audit and rework backlog for **The Broken Script 2.0 Bedrock port**.

The objective is not simply to make every feature exist. The objective is to make Bedrock reproduce the Java/NeoForge mod **as accurately as the Bedrock engine permits**.

## Rules for this checklist

- Java source/data/resources are the behavioral reference.
- Do not invent behavior where source evidence exists.
- Do not mark a feature complete only because the Bedrock equivalent loads or passes static validation.
- Prefer exact constants/timings/state transitions over “feels similar” approximations.
- An approximation is acceptable only when an exact implementation is blocked by Bedrock or would be materially less reliable.
- Every unavoidable difference must remain explicit in `ADAPTATION_NOTES.md` or `KNOWN_LIMITATIONS.md`.
- Re-check old limitations when the pinned/new Bedrock Script API exposes a better mechanism.

### Status convention

- `[ ]` not completed / requires audit
- `[~]` partially covered or requires runtime/source verification
- `[x]` verified complete
- `BLOCKED` exact Java mechanism cannot currently be reproduced by Bedrock; preserve closest observable behavior and document it

---

# P0 — Parity blockers and source coverage

## 1. Reconcile the parity ledgers with the actual repository

The documentation currently disagrees with itself. `PORT_PROGRESS.md` reports chunks 00–38 completed, while `PARITY_MATRIX.md` still marks many later-implemented families as `uninspected`, `unknown`, or `in_progress`.

- [x] Re-audit all **912 `SOURCE_MAP.json` entries** against the current Bedrock tree.
  - Evidence (2026-09-12): `tools/audit_source_map_tree.py` requires exactly 912 rows and resolves every declared `bedrock_files` literal/glob against `TheBrokenScript_Bedrock_2_0`; the dedicated GitHub Actions audit step passed with zero unresolved path/case errors.
- [ ] Make every gameplay-relevant source entry resolve to exactly one of: exact port, validated high-parity port, validated approximation, engine-unsupported, or intentionally excluded with evidence.
- [ ] Eliminate stale `uninspected`, `unknown`, and `in_progress` statuses that no longer describe the implementation.
- [ ] Do not blindly convert entries to `ported`; inspect the Java source and current Bedrock behavior first.
- [ ] Reconcile family rollups in `PARITY_MATRIX.md` with component-level `SOURCE_MAP.json` results.
- [ ] Reconcile `PORT_PROGRESS.md` claims with current files/tests rather than historical chunk completion alone.
- [x] Add a validator that detects source-map entries with unresolved statuses before a release build.
- [x] Add a validator/test that detects obvious disagreement between family-level parity status and the source map.
  - Evidence (2026-09-12): release CI runs `tools/validate_parity_ledgers.py` before packaging; it rejects unresolved gameplay classifications and family/source-map disagreement. Focused validator unit coverage also remains in `tests/test_source_map_release_validator.py` and `tests/test_parity_source_map_validator.py`.

### Known stale rollups to verify

`PARITY_MATRIX.md` currently lists several families as uninspected/unknown despite later progress chunks reporting implementations. Audit these first:

- [ ] remaining entity families (Chunks 05D–05F and 06);
- [ ] blocks and block-entity equivalents (Chunk 08);
- [ ] items and fluid approximation (Chunk 09);
- [ ] dimensions and portals (Chunk 10);
- [ ] biomes/worldgen/spawn modifiers (Chunk 11);
- [ ] events and horror choreography (Chunk 12);
- [ ] chat responses (Chunk 13 reports 14 implemented while the matrix identifies a 45-response source family — verify actual source coverage, aliases, and unreachable/dead entries before deciding whether anything is missing);
- [ ] recipes, loot, tags, advancements, commands (Chunk 13);
- [ ] presentation/UI/music/config families (Chunks 14 and 20);
- [ ] bosses currently still marked `in_progress` even though later chunks substantially extended Phase 3/Jimmy/Fractured behavior.

## 2. Full source-to-runtime audit

- [ ] For every Java gameplay class, identify its Bedrock implementation or explicit limitation entry.
- [ ] Trace callers/callees, not just class names. Verify helper classes, inherited behavior, event subscribers, registry hooks, data attachments, and mixin effects that alter visible behavior.
- [ ] Audit `decompiled/` and `decompiled_brokencore/` for behavior not represented by the current source inventory.
- [ ] Audit original JSON/NBT/assets under `source_extracted/` for data-driven behavior that may have been reduced to placeholder Bedrock content.
- [ ] Search for Java constants that were manually retyped in Bedrock and compare exact values.
- [ ] Search for Bedrock hard-coded constants that have no Java evidence; either source them, justify them as adapters, or remove them.
- [ ] Search for fallback/no-op branches that silently skip Java side effects.
- [ ] Search for catch-and-ignore paths that can turn parity failures into invisible behavior loss.

## 3. Runtime smoke-test matrix

Static validators and Node tests are necessary but cannot prove engine behavior.

- [ ] Establish a repeatable smoke-test world for the exact Bedrock build/API contract documented in `API_AUDIT.md`.
- [ ] Test first world creation and pack initialization.
- [ ] Test save → quit → reload for world state and player state.
- [ ] Test player death/respawn while story, quest, boss, and effect state is active.
- [ ] Test leaving/rejoining and server restart persistence.
- [ ] Test two-player and multi-player ownership/targeting/event behavior.
- [ ] Test dimension travel, return travel, safe arrival, and portal recovery/failure paths.
- [ ] Test boss encounter start, abort, player death, reconnect, victory, cleanup, and replay prevention.
- [ ] Test story progression across every threshold and one-shot event.
- [ ] Test event suppression while boss arenas/other suppressors are active.
- [ ] Capture runtime errors/warnings and make parity-critical errors release blockers.

---

# P0 — Story, progression, persistence, and event correctness

## 4. Story clock and day-cycle parity

`ADAPTATION_NOTES.md` entry A-008 documents a known difference: Java advances the story clock only when players are online **and `doDaylight` is enabled**, while the Bedrock port currently gates only on players being online.

- [x] Re-audit the currently pinned Script API (`@minecraft/server` 2.11.0-beta target) for a supported way to read the daylight-cycle gamerule.
  - Evidence (2026-09-12): `package.json` pins `@minecraft/server` `2.11.0-beta.1.26.50-preview.26`; the indexed Microsoft Creator API definition and Microsoft Learn expose `GameRules.doDayLightCycle` as a readable boolean. The implementation/gate work below remains incomplete.
- [ ] If the API now exposes the needed state, reproduce Java's `playerCount > 0 && doDaylight` gate exactly and retire/update A-008.
- [ ] If it remains unavailable, investigate a robust command-backed or state-synchronized adapter only if it does not introduce worse correctness/security/performance problems.
- [ ] Regression-test story counter pause/resume semantics.
- [ ] Verify all source story thresholds, including day/tick offsets and ordering when multiple thresholds are crossed.

## 5. Persistent state parity

- [ ] Compare every Java world/player attachment field against Bedrock defaults, types, reset behavior, and persistence keys.
- [ ] Verify first-run initialization does not overwrite existing worlds.
- [ ] Verify migrations when a property/schema is added after a world already exists.
- [ ] Verify one-shot events remain consumed after reload.
- [ ] Verify temporary states that should *not* persist are cleared at the same lifecycle boundary as Java.
- [ ] Verify per-player state is never accidentally promoted to global/world state or vice versa.
- [ ] Verify entity-owned runtime state survives only where Java persistence says it should.

## 6. Horror events and chat responses

- [ ] Enumerate every Java event and chat response from source, including registration conditions and aliases.
- [ ] Compare Java probability, cooldown, delay, player selection, world/dimension gates, and mutual exclusion rules.
- [ ] Verify the implemented weighted event pool has the same effective selection behavior as Java, not merely similar weights.
- [ ] Verify every event's cleanup path after player death, dimension change, disconnect, or server reload.
- [x] Resolve the **45-source-response vs 14-implemented-response** documentation discrepancy through source inspection; do not assume either count means 31 missing features until aliases/unreachable/dead source entries are checked.
  - Evidence (2026-09-12): `tests/horror_chat_registration_audit.test.mjs` derives 42 registered Java chat-response IDs from `decompiled/.../TBSChatResponses.java` and 13 generic Bedrock response keys from `commands.js`. Those counts describe different units and are not a parity denominator; per-response trigger/gate/delay auditing remains open.
- [ ] Verify exact trigger normalization: casing, whitespace, punctuation, substrings/whole-message behavior, cooldowns, and whether the sender or all players receive side effects.

---

# P1 — Entity, AI, combat, and boss fidelity

## 7. Every entity family

For each entity, compare source and Bedrock side-by-side:

- [ ] health, movement speed, follow range, scale, collision size, knockback resistance, attack damage, armor, and immunities;
- [ ] spawn conditions, rarity, biome/dimension blacklist/whitelist, light/sky checks, distance gates, delays, and caps;
- [ ] despawn rules and persistence;
- [ ] target acquisition/loss and player filters;
- [ ] line-of-sight/gaze/FOV logic;
- [ ] AI state transitions, timers, interruptions, grace periods, and cooldowns;
- [ ] teleport, stalking, hiding, chase, flee, mining/block interaction, and environmental side effects;
- [ ] sound/particle/animation events at exact state/tick boundaries;
- [ ] death behavior, drops, progression hooks, and cleanup.

### High-risk adapted entity behavior

- [ ] Revisit gaze-cone approximations where Java uses more exact view/visibility tests.
- [ ] Revisit dimension-teleport approximations in Null behavior.
- [ ] Revisit maze door/block-breaking behavior that was skipped or approximated.
- [ ] Revisit flying FOV/sneak behavior.
- [ ] Revisit chunk-removal/chunk-operation surrogates and confirm the closest safe observable behavior.
- [ ] Verify all spawn-director rules against the source conditions rather than relying solely on the historical Chunk 17 category audit.

## 8. Integrity boss parity

- [ ] Audit Phase 1 and Phase 2 directly from source; confirm no historical fabricated health-threshold transition logic remains.
- [ ] Audit Phase 3 candidate generation, presets, arena boundary, attack selector, attack cooldowns, damage gates, mace parry, death timing, and cleanup against source.
- [ ] Verify inclusive/exclusive random ranges exactly.
- [ ] Verify GroundAttack/GroundArm target capture, spawn tick, owner semantics, impact geometry, stuck propagation, and destruction lifecycle.
- [ ] Verify fireball/projectile collision and owner exclusion under lag and multiplayer.
- [ ] Verify final cutscene timing model against Java even where camera/packet transport must be adapted.
- [ ] Verify participant tracking/arena membership has no multiplayer leak or cross-player damage attribution errors.

### Engine-limited Integrity behavior

- [ ] Keep Java-only overlay/music packet, exact camera override, exact custom damage type, synchronized owner field, and exact AABB-contact differences explicitly documented until a better Bedrock API exists.

## 9. Jimmy / Fractured / FracturedRoam parity

- [ ] Verify all attack selector weights and previous-attack exclusion rules.
- [ ] Verify source attack lengths, keyframe event ticks, cooldowns, damage values, impulses, AOE ranges, and block effects.
- [ ] Verify six logical multipart hit regions against Java dimensions/offset/yaw transforms.
- [ ] Verify head/chest versus leg hit behavior, especially burning/spectral projectile side-effect ordering.
- [ ] Stress-test conceptual multipart projectile filtering at different yaw, movement speed, elevation, and network latency.
- [ ] Verify Roam RISING → NORMAL → SWITCHING state gates and the 149/103-tick boundaries.
- [ ] Verify underground/dig/despawn/recovery movement against Java edge cases.
- [ ] Verify JimArena player lifecycle, audio start/stop/cleanup, failure, and reconnect behavior.
- [ ] Revisit rendered-bone/world-contact adapters if Bedrock exposes usable locator/bone transform data in a future API.

## 10. Projectiles and damage

- [ ] Compare every custom projectile's launch origin, speed, inaccuracy, gravity, collision sweep, max distance/lifetime, impact branch ordering, owner exclusion, and cleanup.
- [ ] Verify Chord's inherited Java arrow-damage formula over every Bedrock difficulty setting.
- [ ] Verify Bedrock damage causes do not accidentally change armor, shield, invulnerability, totem, knockback, or attribution behavior compared with each Java custom damage type.
- [ ] Confirm every one of the 15 custom Java damage definitions has a documented Bedrock mapping and that gameplay code consistently uses that mapping.
- [ ] Test simultaneous same-tick damage from multiple sources/players for attribution-ledger collisions.

---

# P1 — Quests, items, blocks, loot, and commands

## 11. Quest/progression behavior

- [ ] Enumerate all Java quest/progression triggers and prerequisites.
- [ ] Verify unlock ordering and mutually exclusive/one-shot branches.
- [ ] Verify rewards, item quantities, effects, messages, sounds, and state flags.
- [ ] Verify boss/progression hooks cannot trigger twice through alternate damage/death paths.
- [ ] Verify progression remains correct after reload, death, disconnect, and multiplayer participation.

## 12. Blocks and block entities

- [ ] Audit all 123 source blocks against Bedrock definitions for material-like behavior, hardness/destruction time, tool requirements, collision/selection boxes, light, placement, drops, sounds, ticking, redstone-like behavior, and scripted interactions.
- [ ] Audit all 8 source block-entity equivalents for storage/state/tick semantics.
- [ ] Verify portal controller/extender/linking interactions and safe-arrival checks.
- [ ] Verify custom geometry blocks (slabs/stairs/walls/cross flora) behave correctly for collision, placement, rotation, water/environment interaction where relevant.
- [ ] Replace placeholder/self-drop loot behavior where Java has richer source loot/functions.

## 13. Items

- [ ] Audit every source item, including items represented indirectly rather than as one Bedrock item JSON.
- [ ] Verify stack size, durability, cooldown, use duration, use animation, consumability, food/effect values, rarity-like presentation, enchantability, and creative availability where applicable.
- [ ] Re-audit hand cannon, polaroid, portal linker, desyncer, plushies, discs, null book, easter-egg items, and any item with scripted use behavior.
- [ ] Verify Java data-component/NBT semantics are preserved where gameplay observes them.
- [ ] Verify item behavior under full inventory, death, container transfer, duplication-sensitive paths, and multiplayer ownership.

## 14. Recipes, loot, tags, and drops

- [ ] Compare all 40 source recipes ingredient-for-ingredient and output-for-output, including counts and recipe category/type behavior that affects availability.
- [ ] Audit stonecutter recipes for exact inputs/outputs/counts.
- [ ] Compare all source block/entity loot tables rather than assuming self-drop is parity.
- [ ] Port source loot conditions/functions/weights where Bedrock supports them; document adapters where it does not.
- [ ] Verify tag membership because tags can silently alter recipes, tools, spawning, interactions, and source predicates.

## 15. Commands and operator/dev behavior

- [ ] Enumerate Java commands and subcommands.
- [ ] Match permissions/operator requirements as closely as Bedrock allows.
- [ ] Match arguments, default values, validation, error cases, messages, and side effects.
- [ ] Keep test/dev commands clearly separated from player-facing production behavior.
- [ ] Ensure a debug command cannot accidentally bypass normal progression in release gameplay unless Java provides the same capability.

---

# P1 — Dimensions, worldgen, structures, and portals

## 16. Dimension parity

- [x] Verify all source dimensions and IDs against Bedrock equivalents.
  - Evidence (2026-09-12): `tests/dimension_inventory.test.mjs` compares the complete Java dimension resource inventory plus `TBSDimensions.java` registrations to the Bedrock ID model, including the resource-only `backrooms` exception; `tests/dimension_registration.test.mjs` verifies all 13 namespaced IDs are registered through the supported startup `DimensionRegistry` path.
- [ ] Verify spawn/entry position, time/light/environment settings, fog, biome association, portal routes, return routes, and death/respawn behavior.
- [ ] Test cross-dimension entity/player references for stale handles and cleanup.
- [ ] Verify dimension-specific event/spawn restrictions.

### BLOCKED / approximation boundary

Exact Java `noise_settings` terrain generation is currently documented as unavailable. Maintain the closest supported terrain/gameplay approximation and do not claim exact worldgen parity unless Bedrock gains an equivalent generator surface.

## 17. Structures and jigsaw/world placement

- [ ] Audit the entire source NBT structure corpus, not only the Shaft and Integrity slices already modeled.
- [ ] Verify rotations, mirrors, connector orientation, pools, target/name matching, weights, projection/placement behavior, and processors.
- [ ] Verify native Shaft assembly against Java pool weights and natural placement frequency/spacing once authoritative source evidence is recovered.
- [ ] Resolve remaining Integrity Stage 2 placement behavior where Java's custom generator cannot map directly.
- [ ] Complete/verify XCSF reconstruction and decide which portions can be made runtime-equivalent.
- [ ] Compare actual in-game generated structures to Java screenshots/world samples where source alone is insufficient.

## 18. Portals

- [ ] Audit activation requirements and item consumption.
- [ ] Audit destination selection and coordinates.
- [ ] Verify safe-arrival/platform/fallback logic.
- [ ] Verify cooldowns and repeat entry behavior.
- [ ] Verify mobs/items/projectiles if Java portals support them.
- [ ] Test portal behavior when destination chunks/dimensions are unavailable or initialization fails.

---

# P1 — Presentation and player-visible timing

## 19. Animations and render-controller behavior

- [ ] Audit every Java animation-controller/GeckoLib state mapping against Bedrock animation/controller state.
- [ ] Verify animation names, lengths, loop behavior, blend/transition timing, and state-entry timing.
- [ ] Verify server-side damage/event keyframes remain synchronized with visible animation under lag.
- [ ] Verify look/head tracking and procedural tentacle behavior identified as pending-analysis adapters.
- [ ] Keep exact rendered-bone hit/contact behavior marked as adapted until script-visible transforms make an exact port possible.

## 20. Particles

- [ ] Audit all source particle definitions/providers and every runtime callsite.
- [ ] Verify count, spread, velocity, lifetime, material/texture, brightness, attachment, and event tick.
- [ ] Verify the 400-particle Rock block-impact source count without creating unacceptable performance degradation; optimization must preserve the visible result.
- [ ] Revisit resource-only particles if Java source later proves runtime callsites exist.

## 21. Audio/music

- [ ] Compare source cue, volume, pitch, attenuation, loop, delay, overlap, interruption, and cleanup behavior.
- [ ] Test music/loop cleanup on death, disconnect, dimension change, boss abort, and reload.
- [ ] Verify all 12 Java jukebox songs/music discs against Bedrock definitions and item behavior.
- [ ] Keep Java FancyAudio/fade/attenuation differences explicit where Bedrock cannot reproduce them.

## 22. UI, camera, overlays, shaders, and fonts

- [ ] Audit the 10 Java menu/overlay families and determine which are fully represented versus approximation-only.
- [ ] Verify VHS/UI overlays do not unintentionally affect unrelated screens or multiplayer players.
- [ ] Re-evaluate camera APIs for closer Java cutscene parity.
- [ ] Re-evaluate A-009 custom-font support only with a verified Bedrock glyph mapping; do not globally replace unrelated vanilla glyphs.
- [ ] Keep the Java GLSL shader pipeline marked `BLOCKED` for exact parity; compare visible mood/effect output rather than pretending the rendering mechanism is equivalent.

---

# P2 — Reliability, deterministic parity tests, and performance

## 23. Expand source-backed regression tests

- [ ] Add pure-model tests for every mechanic with meaningful constants/timers/state transitions.
- [ ] Add boundary tests for every inclusive/exclusive random range and tick threshold.
- [ ] Add tests for negative conditions, not only successful activation.
- [ ] Add persistence serialization/default/migration tests.
- [ ] Add multiplayer ownership/selection model tests where engine-independent.
- [ ] Add source-table snapshot tests so accidental constant drift is obvious in diffs.
- [ ] Add tests that compare source-derived registries/counts against Bedrock definitions where 1:1 mapping is expected.

## 24. Randomness parity

- [ ] Identify every Java RNG source and whether it uses world/entity/local randomness.
- [ ] Verify Bedrock calls occur in equivalent order so probabilities are not unintentionally biased.
- [ ] Verify weighted selectors preserve Java's exact candidate filtering before random selection.
- [ ] For tests, use injectable/deterministic RNG without changing production probability behavior.

## 25. Performance without behavior loss

- [ ] Profile all 1-tick controllers and world/entity scans in realistic multiplayer/entity counts.
- [ ] Preserve Java timing when optimizing scans/caches.
- [ ] Verify cached dimension/entity handles are invalidated correctly after unload/removal.
- [ ] Avoid reducing particle counts, scan frequency, AI frequency, or event checks solely for performance unless the resulting difference is explicitly accepted/documented.
- [ ] Add defensive budgets where Bedrock engine limits require them, with parity impact documented.

## 26. Script API/version safety

- [ ] Keep the manifest/runtime/npm type versions aligned with `API_AUDIT.md`.
- [ ] Do not silently migrate from the selected beta ABI to stable/latest.
- [ ] On every Bedrock/API upgrade, re-check old `ENGINE_UNSUPPORTED` and approximation entries for newly available APIs.
- [ ] Run full static validation plus in-game smoke tests before declaring a new runtime supported.
- [ ] Update API/compatibility docs in the same change as a version migration.

---

# Known exact-parity engine gaps to keep explicit

These are not ordinary missing-code tasks. They are current Bedrock engine/API boundaries documented in `KNOWN_LIMITATIONS.md` / `ADAPTATION_NOTES.md`. The task is to preserve the closest observable Java behavior and improve it when APIs permit.

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

Do not remove these features merely because the mechanism is blocked. Keep or improve the gameplay/presentation surrogate, and document exactly what the player can observe differently.

---

# Definition of done for a parity item

Do **not** check an item off until the applicable evidence exists:

- [ ] Java source/data/resource location is identified.
- [ ] Trigger/preconditions match.
- [ ] Constants and ranges match.
- [ ] Tick timing/order/cooldowns match.
- [ ] Random selection semantics match.
- [ ] State transitions and side effects match.
- [ ] Multiplayer ownership/selection semantics match.
- [ ] Save/reload lifecycle is tested where state persists.
- [ ] Negative/error/edge cases are tested.
- [ ] Automated regression exists where practical.
- [ ] In-game smoke test exists where engine behavior matters.
- [ ] Any unavoidable difference is recorded as an explicit adaptation/limitation.
- [ ] `SOURCE_MAP.json` and `PARITY_MATRIX.md` reflect the verified result.

---

# Immediate recommended work order

1. **Reconcile all 912 source-map entries and the stale family matrix.** This identifies what is genuinely missing versus merely undocumented.
2. **Resolve progression/event/chat coverage and persistence first.** Silent story/state divergence can invalidate long playthroughs.
3. **Run a full runtime smoke matrix.** The repository already has strong static checks; engine-only behavior is the largest remaining verification gap.
4. **Audit entity/boss AI and combat source-by-source.** Focus on approximated geometry, targeting, transitions, and multiplayer behavior.
5. **Audit worldgen/structures/portals and all data-driven content.** Separate Bedrock-engine limits from incomplete source fidelity.
6. **Audit presentation timing after gameplay semantics are correct.** Animation/audio/particle timing should follow source state, not compensate for incorrect logic.
7. **Turn every confirmed discrepancy into a focused regression or explicit engine-limitation entry.**

The release target is reached when the source inventory has no unexplained behavior, gameplay-critical paths pass runtime testing, and every remaining difference from Java is either fixed or demonstrably caused by a Bedrock engine/API limitation.