# ADAPTATION_NOTES.md

Every entry documents an engine-driven adaptation (prompt §35). Seed set from Chunk 00; expanded as chunks run.

## A-001 — Custom fluid `void_liquid`
1. **Source feature**: Void liquid fluid (source + flowing) with custom block, used by void dimensions.
2. **Source behavior**: the source builds head 14×14 at (1, 88, 10), chest 18×18 at (1, 68, 10), four 15×15 subentities at frontleft/frontright/backleft/backright, and four 45-block Leg targets. The head/chest FracturedPartEntity children call Roam.swap() first; burning arrows ignite the parent for 20 seconds, spectral arrows add glowing for 400 ticks, and accepted part hits temporarily set the parent's hit-via-part flag. The four FracturedSubEntity legs delegate to the parent without invoking swap or applying those arrow side effects. MultipartEntityPart uses positive body yaw, while Leg.tick rotates target offsets by negative body yaw. A FracturedRoam head/chest hit enters SWITCHING only from NORMAL, and the host promotes to the main Fractured entity after the source 103-tick switching duration.
3. **Source evidence**: `neoforge/fluids/`, `TBSFluids*.class`, `item.thebrokenscript.void_liquid_bucket`.
4. **Bedrock limitation**: No data-driven or script-registered custom fluids.
5. **Docs checked**: Creator block/item references; scripting module docs (no fluid registration API).
6. **Replacement design**: Translucent tinted custom block + scripted swim/damage/particle/bucket logic; bucket item swaps liquid blocks.
7. **Player-visible difference**: No true flow simulation unless scripted; visuals approximated.
8. **Parity class**: `VALIDATED_APPROXIMATION` target.

## A-002 — Custom mob effects (`heart_corruption`, `why_cant_you_leave`)
1–3. **Feature/behavior/evidence**: `HeartCorruptionMobEffect` is harmful/magenta and applies a `MAX_HEALTH -1` attribute modifier. `WhyCantYouLeaveMobEffect` is neutral/black and substitutes the custom `eyes` particle; its event duration is 1000 ticks.
4. **Limitation**: No custom status-effect registry.
5. **Docs checked**: `@minecraft/server` entity effect, dynamic-property, damage, title, and particle APIs.
6. **Design**: Chunk 20 added persisted finite tick deadlines, `ERR.HEALTH` title/action-bar pressure, one point of magic damage on application, the source eyes texture as `thebrokenscript:eyes`, and direct wiring from the 1000-tick horror event. `/scriptevent tbs:effect` exposes both effects for testing.
7. **Difference**: No custom potion icon or per-player max-health attribute modifier. The health effect uses damage/HUD pressure; the eyes particle preserves the source's seven-tick, stationary, full-bright visual intent.
8. **Parity**: `VALIDATED_APPROXIMATION`.

## A-003 — Post-processing shader suite (VHS, aberration, invert, dream, fever, glitch, sky)
1–3. **Feature/behavior/evidence**: 89 GLSL files under `shaders/**`; client mixins hooking GameRenderer/LevelRenderer/FogRenderer; `/fx` toggles.
4. **Limitation**: Bedrock has no Java core/post GLSL pipeline for add-ons.
5. **Docs checked**: Creator VFX/fog/camera references; 1.26.10 camera API notes (stable splines).
6. **Design**: Chunk 20 merges the supplied VHS resource pack into the main RP: vanilla-safe `$additional_screen_content` HUD injection, animated grain/chroma/tracking/dropout/head-switch layers, scanlines/vignette/OSD, four selectable tape-severity subpacks, plus supplied Vibrant Visuals atmosphere/color-grading/lighting/shadow settings. Existing camera, fog, particle, title, and render-controller approximations remain for the other Java shaders.
7. **Difference**: The VHS layer is UI/Vibrant-Visuals driven, not a framebuffer shader; exact chromatic sampling and the other Java post chains remain unreproducible.
8. **Parity**: `ENGINE_UNSUPPORTED` for exact pipeline; `VALIDATED_APPROXIMATION` for visible results where achievable.

## A-004 — OS/desktop integration
1–3. **Feature/behavior/evidence**: window title hijack (`window.thebrokenscript.*`), LWJGL alert popups, JFrame popups (jframe_1..5), desktop `.txt` creation (`enableFileCreation`), world "ban" to menu.
4. **Limitation**: Bedrock scripts cannot touch the OS window, spawn dialogs, or write arbitrary files.
5. **Docs checked**: Scripting overview/security model.
6. **Design**: In-game surrogates: kick-to-menu ("banned"), full-screen fake disconnect/error forms, title overlays mimicking LWJGL text, chat/title "file written" narration where story-required.
7. **Difference**: Effects stay inside the game window.
8. **Parity**: exact = `ENGINE_UNSUPPORTED`; surrogate = `VALIDATED_APPROXIMATION`.

## A-005 — Painting variant `circuit_cave`
1–3. **Feature/evidence**: source painting data declares a 4×2 `thebrokenscript:circuit_cave` variant backed by `textures/painting/circuit_cave.png` (128×64).
4. **Limitation**: Bedrock add-ons cannot register a Java painting variant.
5–6. **Design**: Chunk 20 adds a 4×2, wall-oriented decorative entity, client geometry/render controller, original texture, and placement item. Placement supports all four horizontal faces and consumes one item outside Creative mode.
7. **Difference**: It is a custom entity rather than a vanilla painting, so vanilla painting cycling and native painting drop behavior do not apply.
8. **Parity**: `VALIDATED_APPROXIMATION`.

## A-006 — Advancements (5)
**Limitation**: no custom advancement definitions → tracked progression flags + toast-style title/sound presentation. Trigger logic preserved in scripts. Parity: approximation.

## A-007 — Noise-based dimension terrain (noise_settings ×3)
**Limitation**: no `noise_settings` equivalent; custom-dimension generator capability limited. Design: closest supported terrain via vanilla dimension types + features/structures/scripts per dimension; exact noise parity impossible. Parity: approximation; per-dimension detail in Chunk 10/11.

## A-008 — Story-clock daylight gate
Source `StoryEvents.tick()` advances the persisted story counter only when `playerCount>0` **and** gamerule `doDaylight` is enabled. Bedrock stable API (v2.6.0) exposes no gamerule query without commands workarounds; port gates on players-online only. Difference: story time also advances while daylight cycling is disabled (rare server setups). Parity: `VALIDATED_HIGH_PARITY`.

## A-009 — Java custom font
The Java font provider and glyph image do not map directly to Bedrock's glyph-page resources. Until every codepoint and page offset is verified, the pack uses standard Bedrock glyphs with obfuscation/color formatting. Shipping an unverified glyph page could replace unrelated vanilla characters globally. Parity: exact = `DEFERRED_UNSAFE`; styled text = `VALIDATED_APPROXIMATION`.

## A-010 — Packet desynchronization
`PlayerDesyncManager` toggles a Java player flag and resends deferred packets through a server-connection mixin on resync. Bedrock Script API exposes neither packet interception nor deferred packet replay. Chunk 20 makes the item functional with per-player state, nausea/darkness, glitch presentation, and a same-position/rotation teleport on resync. Parity: packet behavior = `ENGINE_UNSUPPORTED`; gameplay beat = `VALIDATED_APPROXIMATION`.

## A-011 — Integrity Phase 3 transport and final cutscene
1. **Source feature**: Phase3.java ring spawning, boundary kill countdown, custom transition overlay, dimension transfer, music packets, end cutscene, and delayed boss discard; IntegrityPhase3Entity.java damage/death lifecycle.
2. **Source behavior**: IntRange(0, 250) generates 251 candidate iterations with random radii 100–123 around (200, 202); three preset tentacles use fixed coordinates and SCALE 2. Players above y=90 in the Stage3 dimension receive a 60-tick countdown and then 1,000,000 void_mass damage. FinalCutscene.java runs for 428 ticks with a 108-tick pre-roll, 190-tick camera interpolation, 100-tick zoom, and 40-tick blackout.
3. **Source evidence**: decompiled/net/thebrokenscript/boss/integrity/Phase3.java and decompiled/net/thebrokenscript/boss/integrity/FinalCutscene.java.
4. **Bedrock limitation**: The Java Arena participant roster, custom overlay/music/cutscene packets, client camera override, and custom void_mass damage-type registration have no direct add-on equivalent in the current runtime surface.
5. **Replacement design**: fractured_multipart_model.js preserves the six logical part definitions, role-specific positive/negative yaw transforms, AABBs, hit-plan ordering, the 149-tick Roam rising guard, and the 103-tick switch state. The runtime applies a derived 105×102 root collision envelope, filters projectile centers against the six conceptual AABBs, defers setOnFire/addEffect side effects with system.run, and tracks Roam until it can legally enter SWITCHING and spawn the main Fractured entity.
6. **Player-visible difference**: The source transition texture, custom music packets, final camera path, exact participant transfer/attribution, and custom superclass death animation are not reproduced; the deterministic gameplay countdown, attacks, damage gate, and delayed cleanup are shipped.
7. **Parity class**: VALIDATED_APPROXIMATION for the gameplay/runtime slice; ENGINE_UNSUPPORTED for Java-only transport/camera behavior.

## Pending-analysis adaptations (bytecode required)
- Spawn-condition predicates (24 classes) → spawn director fidelity depends on decompiled constants/timings.
- Event probabilities/cooldowns (~91 handlers) → same.
- GeckoLib animation *code* behaviors (head-tracking, procedural tentacles via `api/tentaclev2`) → script equivalents; assets already Bedrock-native.

## A-012 — Java SCALE attribute to Bedrock property/event adapter

Source `VoidTentacleEntity.onFinalizeSpawn` rolls `Attributes.SCALE` inclusively from 1 through 5 when the base scale is unchanged. Phase 3 also creates three fixed tentacles with scale 2.

The Bedrock port persists the equivalent value as the client-synced `thebrokenscript:scale` integer property, maps values 1..5 to `minecraft:scale` component groups, and exposes matching events that set the property and select the visual group. The controller reads the persisted property and uses the same bridge for fixed presets and fallback initialization.

The Java attribute mutation and renderer pipeline are not portable; persistence, synchronization, behavior lookup, and visual size are covered by the Bedrock adapter.

## A-013 — Integrity GroundArm owner and contact adapter

1. **Source feature**: `GroundAttack` creates an `IntegrityP3GroundArmEntity`, assigns the Integrity Phase 3 entity as its owner, and the arm later forwards stuck state and damage behavior to that owner.
2. **Source behavior**: the attack captures the target block at tick 33 and creates the arm at tick 40; the arm impacts intersecting players at tick 5, then discards when its owner is absent or when the source tentacle-proximity thresholds are crossed.
3. **Source evidence**: `decompiled/net/thebrokenscript/entity/integrity/phase3/attacks/GroundAttack.java` and `decompiled/net/thebrokenscript/entity/integrity/phase3/IntegrityP3GroundArmEntity.java`.
4. **Bedrock limitation**: Bedrock entity IDs are opaque strings and the current add-on surface does not expose the source's synchronized integer owner field or Java `AABB.intersects` query.
5. **Replacement design**: the controller keeps a live `arm.id → owner` map, guards invalid references, applies the source timing/damage/impulse plan, and uses a five-block entity query as the contact approximation. GroundArm is explicitly non-persistent in its BP definition.
6. **Player-visible difference**: owner association is runtime-only and is rebuilt only when a new GroundAttack spawns an arm; player contact is radius-based rather than exact bounding-box intersection.
7. **Parity class**: `VALIDATED_APPROXIMATION`; exact owner synchronization and geometric contact remain engine gaps.

## A-014 — Chord projectile and BrokenCore arrow-damage adapter

1. **Source feature**: `ChordEntity.performProjectileAttack` and `ChordProjectileEntity` movement, distance expiry, impact branches, gravity restoration, grounded offsets, and empty pickup behavior.
2. **Source behavior**: source speed is `1.6f`, inaccuracy is `0.0f`, `initialPos` is the Chord position, and `setBaseDamageFromMob(2.0f)` is called. The projectile is transient, no-gravity in flight, discarded at 100 blocks, and queues 20-tick block-hit removal.
3. **Source evidence**: `decompiled/net/thebrokenscript/entity/boss/ChordEntity.java`, `ChordProjectileEntity.java`, and `decompiled_brokencore/net/thebrokenscript/brokencore/api/entity/base/UwuableArrow.java`.
4. **Bedrock limitation**: the server API does not expose the Java bounding-box interpolation used by `getY(1.0)` or the client renderer's grounded `Vec2` hook.
5. **Replacement design**: a dedicated runtime owns normalized 1.6-block/tick movement, substepped block/entity collision, source branch order, gravity restoration event, 100-block expiry, and block countdown. The pure model mirrors inherited vanilla `AbstractArrow#setBaseDamageFromMob(2.0f)` with the source difficulty-weighted triangular term; the runtime maps stable Bedrock `World.getDifficulty()` values to Java difficulty ids. Exact face offsets remain in the pure model.
6. **Player-visible difference**: launch height, entity bounding-box contact, and renderer application of grounded offsets remain adapted; the inherited vanilla arrow damage calculation is now source-backed.
7. **Parity class**: `VALIDATED_APPROXIMATION` for the gameplay/runtime slice; renderer and continuous-contact differences remain documented adapters.

## A-015 — Fractured/Jimmy attack and keyframe adapters

1. **Source feature**: FracturedEntity, JimAttackSelectorGoal, the four Jimmy attacks, and RockEntity.
2. **Source behavior**: Jimmy starts with a 100-tick attack delay, chooses among the four equal-weight attacks, emits Stomp/Slam/SingleStomp/Rock effects at source timings, and uses RockEntity's 15-damage AOE/owner exclusion/Elytra side effect.
3. **Source evidence**: decompiled/net/thebrokenscript/entity/fractured/{FracturedEntity,JimAttackSelectorGoal,RockEntity}.java and decompiled/net/thebrokenscript/entity/fractured/attacks/*.java.
4. **Bedrock limitation**: add-ons do not expose GeckoLib server bone transforms or the custom SUB_ANOM_2 damage source. A Bedrock custom particle emitter replaces Java's block-particle registration.
5. **Replacement design**: the dedicated runtime owns the recovered state machine and impact constants. Player melee is the explicit six-hit progress adapter; keyframe instruction names are isolated behind KEYFRAME_ADAPTER_TICKS; Rock collision uses getAABB() and a substepped runtime query. Block impact invokes a custom Bedrock moon-stone emitter with the source count, offset ranges, upward velocity, and one-tick cleanup boundary.
6. **Player-visible difference**: exact attack keyframe timestamps and bone-origin positions remain adapters; the 400-particle moon-stone burst preserves the source count/material/spatial plan, with Bedrock emitter lifetime and particle physics as the engine-specific presentation layer. Attack timing, damage, cooldown, owner exclusion, and defeat progress are preserved.
7. **Parity class**: VALIDATED_APPROXIMATION for the recovered gameplay slice; keyframe/bone mechanisms remain engine-limited while the block-particle burst is source-backed through a Bedrock emitter.

## A-016 — Jimmy multipart hitbox and FracturedRoam switch adapter

1. **Source feature**: BaseFracturedEntity's head/chest/leg-part layout, FracturedPartEntity, FracturedSubEntity, Leg, and the FracturedRoam multipart-trigger path.
2. **Source behavior**: the source builds head 14×14 at (1, 88, 10), chest 18×18 at (1, 68, 10), four 15×15 subentities at frontleft/frontright/backleft/backright, and four 45-block Leg targets. Part hurt handling calls Roam.swap() first; burning arrows ignite the parent for 20 seconds, spectral arrows add glowing for 400 ticks, and accepted part hits temporarily set the parent's hit-via-part flag. Leg.tick rotates target offsets by the parent's body yaw. A FracturedRoam part hit enters SWITCHING and the host promotes to the main Fractured entity after the source 103-tick switching duration.
3. **Source evidence**: decompiled/net/thebrokenscript/api/entity/BaseFracturedEntity.java; decompiled/net/thebrokenscript/entity/fractured/{FracturedPartEntity,FracturedSubEntity,Leg,FracturedRoamEntity}.java; decompiled/net/thebrokenscript/boss/fractured/JimArena.java.
4. **Bedrock limitation**: Bedrock add-ons do not expose Java child multipart entities, parent/part identity, GeckoLib limb transforms, or the source's exact projectile sweep against moving part entities.
5. **Replacement design**: fractured_multipart_model.js preserves the six logical part definitions, dimensions, offsets, yaw transform, AABBs, hit-plan ordering, and 103-tick state. The runtime applies a derived 105×102 root collision envelope, filters projectile centers against the six conceptual AABBs, defers setOnFire/addEffect side effects with system.run, and tags/ticks FracturedRoam until it can spawn the main Fractured entity.
6. **Player-visible difference**: projectiles use conceptual part filtering rather than actual child entities, so continuous projectile contact and exact part identity are adapted. FracturedRoam promotion spawns the main entity directly; the JimArena participant/sound schedule and underground/dig/despawn lifecycle are adapted in Chunks 30–31, while bossbar, camera, and guaranteed looping-music control remain engine gaps.
7. **Parity class**: VALIDATED_APPROXIMATION for the multipart gameplay contract; Java hierarchy, exact bone/render contact, and presentation transport remain engine/deferred gaps.


## A-017 — Rock block-impact particle burst adapter

1. **Source feature**: `RockEntity.onHitBlock`.
2. **Source behavior**: after the superclass block-hit path, the source emits 400 `BlockParticleOption(BLOCK, MOON_STONE)` particles at independent offsets `x/z ∈ [-15, 15]`, `y ∈ [-7.5, 7.5]`, with upward velocity `(0, 2, 0)`, then queues discard one tick later.
3. **Source evidence**: `decompiled/net/thebrokenscript/entity/fractured/RockEntity.java`.
4. **Bedrock limitation**: `Dimension.spawnParticle` accepts a named emitter rather than Java's block-particle option and does not expose Java client particle lifetime/physics directly.
5. **Replacement design**: `moon_stone_block_burst.particle.json` uses the existing moon-stone texture, emits exactly 400 particles, preserves the source offset ranges and upward initial velocity, and is invoked once at the Rock block-impact position. The existing one-tick grounded cleanup remains in the runtime.
6. **Player-visible difference**: emitter lifetime and motion integration are Bedrock particle-system behavior rather than Java `TerrainParticle` behavior.
7. **Parity class**: `VALIDATED_APPROXIMATION` with source count/material/spatial/timing parity.

## A-018 — Java custom damage-source catalog and attribution adapter

1. **Source feature**: the 15 `data/thebrokenscript/damage_type/*.json` definitions and the `TBSDamageTypes` registry builders.
2. **Source behavior**: source ids, death-message metadata, `hurt`/`burning` effects, exhaustion (`0.1`, except `bad_sun` at `0.0`), scaling (`always`, except `bad_sun` at `never`), no-knockback flags, and armor/effect/invulnerability/shield/totem bypass flags are preserved from the resource and registry layers.
3. **Source evidence**: `source_extracted/data/thebrokenscript/damage_type/*.json` and `decompiled/net/thebrokenscript/registry/TBSDamageTypes.java`.
4. **Bedrock limitation**: Bedrock cannot register arbitrary Java damage-type ids or reproduce their death-message, exhaustion, scaling, and bypass metadata through `Entity.applyDamage()`.
5. **Docs checked**: stable `Entity.applyDamage`, `EntityApplyDamageOptions`, `EntityApplyDamageByProjectileOptions`, `EntityDamageSource`, and `EntityDamageCause` references. Bedrock exposes native cause plus optional damaging entity/projectile fields.
6. **Replacement design**: `damage_source_model.js` is a pure 15-entry catalog and plan builder. `damage_source_runtime.js` validates the custom id, sends the nearest native cause with entity/projectile attribution, and retains the custom source id in a same-tick runtime ledger. Recovered callsites now route Jimmy stomp, Rock, Integrity ball, Integrity shield bypass, void mass, Fever, and Chord damage through the adapter.
7. **Player-visible difference**: custom source ids remain available to the port's same-tick logic, but Bedrock's native death text and armor/effect/shield/totem handling still follow the selected built-in cause.
8. **Parity class**: `VALIDATED_APPROXIMATION` for source catalog and attribution; exact custom damage-type registration remains engine-unsupported.

## A-019 — Fractured animation timeline and presentation bridge

1. **Source feature**: `fractured.animation.json`, `FracturedModel`, and `BaseFracturedEntity`'s animation-controller mappings.
2. **Source behavior**: `OffenseStompShockwave` fires `SingleStomp` at 0.68 seconds, `OffenseSlam` fires `Slam` at 1.23 seconds, `MoonRockToss` fires `OffenseRockGrab`/`OffenseRockThrow` at 1.41/5.24 seconds, and `DefenseAirLift` fires `DefensiveRockRelease` at 2.27 seconds. The controller maps RISING→Spawn, NORMAL idle/moving→Idle/Walk, DIGGING/DESPAWNING/SWITCHING→Flee, UNDERGROUND→Underground, and DEFEATED→Loss.
3. **Source evidence**: `source_extracted/assets/thebrokenscript/animations/fractured.animation.json`; `decompiled/net/thebrokenscript/client/model/entity/FracturedModel.java`; `decompiled/net/thebrokenscript/api/entity/BaseFracturedEntity.java`; `decompiled/net/thebrokenscript/entity/fractured/FracturedEntity.java`.
4. **Bedrock limitation**: the Script API can start a named entity animation, but does not expose GeckoLib's server-side rendered-bone world transform or the Java animation controller implementation.
5. **Replacement design**: `fractured_animation_model.js` preserves source clip names, lengths, instruction seconds, tracked-bone ownership, presentation mapping, and deterministic 20 Hz runtime ticks. `fractured_runtime.js` calls `playAnimation` when an attack or Roam presentation state changes and dispatches gameplay effects on the source-derived event tick. The geometry adds zero-offset locators to the tracked bones, the client entity binds a compact contact emitter, and the animation timeline fires it at each source contact event.
6. **Player-visible difference**: attack and Roam clips now use the existing Bedrock resources and source timing, and visual contact follows the animated locators. Server-side damage/rock origins still use the documented spatial adapters rather than exact animated bone coordinates.
7. **Parity class**: `VALIDATED_APPROXIMATION`; animation resource/timing/presentation mapping is source-backed, while exact rendered contact remains engine-limited.

## A-020 — Source particle resource and provider adapter

1. **Source feature**: the nine assets/thebrokenscript/particles/*.json definitions, the registered Java providers under net/thebrokenscript/client/particle, and the Null/Eyes/Curved sendParticles callsites.
2. **Source behavior**: Eyes is size 0.4 for seven ticks; Fardaway and Null use the recovered 1..56 tick lifetime ranges; NullStructure is size 0.5 for 60 ticks; Paper is size 0.25 for 100..199 ticks with a custom crossed-quad flutter; ParticleOfCurved is size 10 for 5..24 ticks; Wretched is size 0.6 for 7..26 ticks.
3. **Source evidence**: source_extracted/assets/thebrokenscript/particles/*.json; the decompiled provider classes; NullParticleEvent, EyesEvent, and CurvedEntity.
4. **Bedrock limitation**: Dimension.spawnParticle accepts a named emitter and origin rather than Java's count/offset API, and Bedrock does not expose Java's custom particle renderer or provider registry.
5. **Replacement design**: particle_model.js is a pure catalog of all nine definitions and three event contracts. Each resource uses the documented Bedrock emitter lifetime/rate/shape, lifetime expression, initial speed, billboard, lighting, and dynamic-motion components. Source PNGs are copied without re-encoding. particle_runtime.js guards the named-effect bridge, and the known event handlers invoke it.
6. **Player-visible difference**: emitter count/spread is encoded in the resource and Paper's double crossed quads/roll-dependent wave are approximated by one billboard with dynamic motion and drag. follows_particle and revuxor_particle retain their source textures but have no Java provider implementation in the extracted registry.
7. **Parity class**: VALIDATED_APPROXIMATION for the catalog/resource/event slice; exact Java provider registration and custom renderer behavior remain engine-limited.

## A-021 — Fractured audio lifecycle adapter

1. **Source feature**: `BaseFracturedEntity.playSpawnSounds()`, `JimArena` intro/loop scheduling, and `AudioFader` reset cleanup.
2. **Source behavior**: Fractured hosts play `jimmy.spawn`; JimArena plays `jimbob.intro`, starts `jimbob.loop` after 340 ticks, and stops active tracks on reset.
3. **Source evidence**: `decompiled/net/thebrokenscript/api/entity/BaseFracturedEntity.java`; `decompiled/net/thebrokenscript/boss/jimmy/JimArena.java`; `decompiled/net/thebrokenscript/boss/jimmy/AudioFader.java`.
4. **Bedrock limitation**: Java's client-only `FancyAudio` and audio-fader implementation are unavailable; local attenuation and music packet ownership are not identical.
5. **Replacement design**: `fractured_runtime.js` emits the namespaced spawn sound once per Fractured/Roam state, retains `Player.playSound()`'s `SoundInstance` handles for arena intro/loop tracks, and calls `SoundInstance.stop()` before reset clears the arena.
6. **Player-visible difference**: sound ownership is server-scripted through Bedrock handles, and exact Java attenuation/fade behavior remains runtime-dependent.
7. **Parity class**: `VALIDATED_APPROXIMATION` for the source cue and cleanup lifecycle; Java client transport remains engine-specific.

## A-022 — NullBookStoryEvent written-book adapter

1. **Source feature**: `TBSStoryEvents.null_book_hint` and `NullBookStoryEvent`.
2. **Source behavior**: at `Time.days(12) + 1000`, the event creates a two-page `WrittenBookContent` titled `null`, authored by `null`, with `TBSLang.NULL_BOOK_CONTENT` on page one and chunk-centered binary Clan Void coordinates on page two, then gives it to every online player.
3. **Source evidence**: `decompiled/net/thebrokenscript/registry/TBSStoryEvents.java`; `decompiled/net/thebrokenscript/events/story/NullBookStoryEvent.java`; the extracted language registry.
4. **Bedrock limitation**: Java's `WrittenBookContent` data component is not directly installable; the current Bedrock pack instead uses the supported `ItemBookComponent` API on a writable book.
5. **Replacement design**: `story_book_model.js` preserves the threshold/page/binary-coordinate contract; `story_book_adapter.js` creates the writable book through an injected ItemStack constructor and distributes cloned copies, dropping a leftover stack when inventory insertion is full. `story_events.js` wires the real Bedrock constructor, logs failures, retries transient creation/delivery failures with a bounded `system.runTimeout` loop, and sets `nullBookGiven` only after all current players are delivered.
6. **Player-visible difference**: the Bedrock adapter uses Script API book mutation/signing instead of Java's serialized data component; an inventory-full remainder appears as a dropped item at the player location, and transient failures are retried rather than silently discarded.
7. **Parity class**: `VALIDATED_HIGH_PARITY` for source timing/content/metadata/delivery, with the book-component and inventory serialization differences documented above.

## A-023 — Custom status-effect registry and modifier adapter

1. **Source feature**: `TBSEffects`, `HeartCorruptionMobEffect`, `WhyCantYouLeaveMobEffect`, and `WhyCantYouLeaveEvent`.

2. **Source behavior**: `heart_corruption` is harmful, magenta, applies the `MAX_HEALTH` ADD_VALUE modifier with value `-1.0`, and declares a tick hook without custom tick damage. `why_cant_you_leave` is neutral, black, visible, ambient, uses the Eyes particle, and is applied for 1000 ticks at amplifier 0.

3. **Source evidence**: `decompiled/net/thebrokenscript/effects/HeartCorruptionMobEffect.java`; `decompiled/net/thebrokenscript/effects/WhyCantYouLeaveMobEffect.java`; `decompiled/net/thebrokenscript/events/WhyCantYouLeaveEvent.java`; `decompiled/net/thebrokenscript/registry/TBSEffects.java`.

4. **Bedrock limitation**: the Script API cannot register a custom mob-effect id or install Java's attribute-modifier registry entry; health-component writes also require a runtime player component.

5. **Replacement design**: `status_effect_model.js` is the source catalog and expiry model. `status_effect_runtime.js` caps current health at one below `effectiveMax` while Heart Corruption is active. `ported_features.js` refreshes finite dynamic-property expiries, reapplies the cap every 20 ticks, and emits the source Eyes particle for Why Can't You Leave.

6. **Player-visible difference**: the Bedrock implementation is a finite script effect rather than a native status-effect registry entry; the custom potion icon and Java attribute-modifier identity remain unavailable.

7. **Parity class**: `VALIDATED_APPROXIMATION`; source metadata and timing are preserved, while custom registry/modifier installation remains engine-limited.

## A-024 — Jukebox song record adapter

1. **Source feature**: the twelve `TBSSongs` registrations and their `data/thebrokenscript/jukebox_song/*.json` definitions.

2. **Source behavior**: each song keeps its source sound event, duration, comparator output of 15, and human-facing description; the Java records are non-stackable music items.

3. **Source evidence**: `decompiled/net/thebrokenscript/registry/TBSSongs.java`; `source_extracted/data/thebrokenscript/jukebox_song/*.json`; existing `RP/sound_definitions.json` and copied `.ogg` assets.

4. **Bedrock limitation**: `minecraft:record.comparator_signal` is documented for values 1–13, so Java's 15 is clamped to 13. Bedrock's record component is used instead of Java's registered `JukeboxSong` holder.

5. **Replacement design**: `music_disc_model.js` catalogs the twelve source contracts. Each existing Bedrock item receives `minecraft:record` with the source duration and matching custom sound-definition key, plus `minecraft:max_stack_size: 1`.

6. **Player-visible difference**: comparator output is two points lower than Java's source value; sound playback uses Bedrock's native record component and existing resource-pack sound definitions.

7. **Parity class**: `VALIDATED_APPROXIMATION`; source song timing, descriptions, item identity, sound assets, and playback links are preserved, with the comparator range clamp documented.
