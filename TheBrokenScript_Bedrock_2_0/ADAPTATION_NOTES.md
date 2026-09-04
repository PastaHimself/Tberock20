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

## A-025 — Fractured rendered-contact spatial resolver

1. **Source feature**: `FracturedModel` tracked bones and `FracturedEntity` custom instruction handlers for `SingleStomp`, `Slam`, `OffenseRockThrow`, and `DefensiveRockRelease`.

2. **Source behavior**: the client model resolves world positions for `ROCK`, `right_l_claw`, `left_l_claw`, and `right_f_tarsus`. The server instruction handlers use those positions for rock spawn/drop and claw/stomp packet origins. The source stomp attack's `(210, 0, -1313) × 0.125` offset recovers to `(26.25, 0, -164.125)` before body-yaw rotation.

3. **Source evidence**: `decompiled/net/thebrokenscript/client/model/entity/FracturedModel.java`; `decompiled/net/thebrokenscript/entity/fractured/FracturedEntity.java`; `decompiled/net/thebrokenscript/entity/fractured/attacks/StompAttack.java`; `BP/scripts/systems/fractured_animation_model.js`.

4. **Bedrock limitation**: the current Bedrock Script API does not expose GeckoLib-style rendered bone matrices or a server packet path for client render-bone world positions.

5. **Replacement design**: `fractured_contact_model.js` derives its event/bone catalog from the animation contract, accepts bridge-injected world positions for exact contact routing, preserves the recovered stomp offset as a deterministic fallback, and returns an explicit entity-anchor fallback for unavailable claw/rock bones. `fractured_runtime.js` routes stomp, slam, rock throw, and rock release origins through this resolver.

6. **Player-visible difference**: a future render bridge can provide exact limb/rock origins without changing the gameplay adapter; current Bedrock-only execution preserves source stomp placement and keeps the other unavailable contacts deterministic at the boss anchor.

7. **Parity class**: `VALIDATED_APPROXIMATION`; source event/bone ownership and fallback behavior are implemented and tested, while a live GeckoLib-equivalent render-bone bridge remains engine-limited.

## A-026 — Source-registered horror event adapters

1. **Source feature**: the seven registrations absent from the Bedrock event table — null_book, null_interface_trigger, obfuscated_sign, noop, text, title_event, and aberration.

2. **Source behavior**: NullBookEvent creates a written book with the null page and a 50% optional Clan Void coordinate page; NullInterfaceTriggerEvent uniformly selects one of three named Null menus; ObfuscatedSignEvent selects obfuscatedsign 70% of the time and ciphersign otherwise; NoopEvent does nothing; TextEvent sends one of 16 source messages; WindowTitleEvent branches 90%/90%/50% between Null titles, ERR.INTEGRITY, <o>, or a clear title; AberrationEvent enables aberration and sets its timer to 1200 ticks.

3. **Source evidence**: decompiled/net/thebrokenscript/registry/TBSEvents.java; decompiled/net/thebrokenscript/events/nullent/NullBookEvent.java; decompiled/net/thebrokenscript/events/nullent/interfaces/NullInterfaceTriggerEvent.java; decompiled/net/thebrokenscript/events/structures/ObfuscatedSignEvent.java; decompiled/net/thebrokenscript/events/NoopEvent.java; decompiled/net/thebrokenscript/events/misc/{TextEvent,WindowTitleEvent,AberrationEvent}.java; decompiled/net/thebrokenscript/registry/TBSLang.java.

4. **Bedrock limitation**: the current Script API cannot open the Java custom Null menus, change the native desktop window title, or load these source NBT structures as runtime structure assets. The source RandomEvent engine's exact weighting/config/day schedule is also not exposed by the current runtime.

5. **Replacement design**: horror_event_model.js keeps the recovered contracts testable. horror_events.js adds all seven IDs, reuses the existing Null book adapter, maps the three menus to titled in-game notices, uses a local oak-sign placement notice for the two unavailable structures, sends the source TextEvent pool through Bedrock chat, maps WindowTitleEvent to setTitle, and persists Aberration state through player_state.

6. **Player-visible difference**: Null interfaces become title notices, native window-title changes become in-game titles, and obfuscated/cipher structures become a local oak-sign fallback with the selected source template named in the notice. Scheduler cadence/gating remains the existing Bedrock ambient approximation.

7. **Parity class**: VALIDATED_APPROXIMATION; source registrations/contracts are represented and CI-validated, with Java-only presentation/structure/scheduling boundaries documented.


## A-027 — Source random-event engine scheduler

1. **Source feature**: the brokencore EventEngine and TBS TBSEngineControl scheduler that gates random events by absolute world time, chooses one random player, filters disabled event IDs, applies persistent inverse occurrence weights, validates event eligibility, and rerolls invalid selections when configured.

2. **Source behavior**: the TBS controller contributes evalCurve(gameTime / 24000) / 24000 - 2.9166666E-4, with a quadratic curve through day 55, a logarithmic continuation after day 55, and a cap of 7. The aggregate engine starts at zero probability because the default controller contributes the offsetting 2.9166666E-4. Registered event constructors currently provide weight 1; the tracker starts each event at count 1 and divides weight by the persisted occurrence count after each successful execution.

3. **Source evidence**: decompiled/net/thebrokenscript/TBSEngineControl.java; decompiled_brokencore/net/thebrokenscript/brokencore/api/engine/EventEngine.java; decompiled_brokencore/net/thebrokenscript/brokencore/impl/event/engine/StatisticsEventPicker.java; decompiled_brokencore/net/thebrokenscript/brokencore/impl/event/engine/EventWeightTracker.java; decompiled_brokencore/net/thebrokenscript/brokencore/impl/config/EventsConfig.java; Microsoft Learn World.getAbsoluteTime() and Player.getGameMode() API contracts.

4. **Bedrock adaptation**: event_scheduler_model.js keeps the probability and picker pure and deterministic under injected rolls. horror_events.js runs the scheduler every tick, chooses one player, uses the Bedrock world clock/game-mode methods when available, persists counts and disabled IDs with the existing world JSON state service, and reads the source defaults through config_defaults.js.

5. **Player-visible difference**: Java SavedData and the Java configuration screen are represented by world-state JSON and config keys; the source custom menus, desktop title/packet hooks, and NBT structure placement remain the explicit Chunk 42 presentation/structure adapters. Runtime smoke testing in a Bedrock world is still pending.

6. **Parity class**: VALIDATED_APPROXIMATION; source frequency, weighted selection, disabled filtering, rerolls, persistence, and API seams are implemented and covered by local tests and repository CI.

## A-028 — Library Book reader adapter

1. **Source feature**: LibraryBookItem, LibraryBookScreen, and the 44 recovered library_books JSON payloads.
2. **Source behavior**: Each book item carries a random source ID in the 1..250 range; the screen loads library_books/<id>.json, displays author/pages one-based, and bounds navigation.
3. **Source evidence**: decompiled/net/thebrokenscript/item/LibraryBookItem.java; decompiled/net/thebrokenscript/client/gui/LibraryBookScreen.java; source_extracted/assets/thebrokenscript/library_books/1.json through 44.json.
4. **Bedrock adaptation**: library_book_model.js preserves the ID/page contract; library_book_data.js embeds the 44 payloads; the book item uses ActionFormData with Previous/Next/Close controls and safe optional item-stack ID retention.
5. **Player-visible difference**: Java's custom book texture, noisy glyph animation, rendered page layout, and animated special pages become a form with the source page text and author context. New selections use recovered IDs because the supplied source payload corpus contains 44 resources although the source random range reaches 250.
6. **Parity class**: VALIDATED_APPROXIMATION; payload, selection, page, and navigation contracts are covered by local tests and repository CI.

## A-029 — Null interface form adapters

1. **Source feature**: NullInterfaceTriggerEvent and the NullInterfaceScreen, NullInterface2Screen, and NullInterface3Screen menu/screen pairs.
2. **Source behavior**: The trigger randomly selects one of three Null events; each opens its named menu. Interface 1 renders “behind you,” interface 2 renders 25 “null” labels in a five-by-five grid, and interface 3 renders “help”; Escape closes the container.
3. **Source evidence**: decompiled/net/thebrokenscript/events/nullent/interfaces/NullInterfaceTriggerEvent.java; NullInterface1Event.java; NullInterface2Event.java; NullInterface3Event.java; decompiled/net/thebrokenscript/client/gui/NullInterfaceScreen.java; NullInterface2Screen.java; NullInterface3Screen.java.
4. **Bedrock adaptation**: null_interface_model.js preserves the three titles, text, and grid shape; ported_features.js shows the selected definition in ActionFormData; horror_events.js routes null_interface_trigger to the form adapter.
5. **Player-visible difference**: The Java 176×166 textured container screens become supported forms. The exact texture, font metrics, label color, and container chrome are not available through this adapter.
6. **Parity class**: VALIDATED_APPROXIMATION; source text/layout and event wiring are covered by local model regressions and repository CI.

## A-030 — NulledGui screen adapter

1. **Source feature**: NulledGuiEvent, NulledGuiMenu, and NulledGuiScreen.
2. **Source behavior**: The event opens the NulledGui menu with the NulledGui title, renders Good luck. and )=, sets a client-side fake midnight state, and sends the glitch sound at the source cue.
3. **Source evidence**: decompiled/net/thebrokenscript/events/nullent/NulledGuiEvent.java; decompiled/net/thebrokenscript/client/gui/NulledGuiScreen.java; decompiled/net/thebrokenscript/registry/TBSLang.java; source_extracted/assets/thebrokenscript/textures/screens/nulled_gui.png.
4. **Bedrock adaptation**: nulled_gui_model.js preserves the source title/messages and stacked body; ported_features.js exposes showNulledGui through ActionFormData; horror_events.js routes nulled_gui to the form and existing glitch sound definition.
5. **Player-visible difference**: The Java 176×166 textured container and client-only fake-midnight illusion become a supported form plus the source glitch cue. Exact texture, font metrics, native container chrome, and fake client time are unavailable in the server-side adapter.
6. **Parity class**: VALIDATED_APPROXIMATION; source content, event wiring, and cue are covered by local model regressions and repository CI.

## A-031 — FakeDisconnect form adapter

1. **Source feature**: FakeDisconnectEvent, FakeDisconnectMenu, and FakeDisconnectScreen.
2. **Source behavior**: The event opens FakeDisconnect with the Timed out title, stops existing sounds, sets a music flag, and schedules a 100-tick cleanup. The screen renders Connection Lost above Timed out over the title panorama and has a Back to title screen button; Escape is disabled.
3. **Source evidence**: decompiled/net/thebrokenscript/events/nullent/FakeDisconnectEvent.java; decompiled/net/thebrokenscript/client/gui/FakeDisconnectScreen.java; decompiled/net/thebrokenscript/registry/TBSLang.java.
4. **Bedrock adaptation**: fake_disconnect_model.js preserves heading/title/body/action and the 100-tick/escape/panorama source metadata; ported_features.js exposes showFakeDisconnect through ActionFormData; horror_events.js routes fake_disconnect to the form adapter.
5. **Player-visible difference**: The Java panorama/custom disconnect screen becomes a supported form. The native client disconnect transition, Esc lockout, timed close, global sound-stop/music flag lifecycle, and exact button no-op behavior are not exposed by this server-side adapter.
6. **Parity class**: VALIDATED_APPROXIMATION; source text/action and event wiring are covered by local model regressions and repository CI.

## A-032 — TornPaper and command-block form adapters

1. **Source feature**: TornPaperItem/TornPaperScreen and CommandBlockGuiScreen/CommandBlockGuiConfirmScreen, including the CorruptedCommandBlock packet path.
2. **Source behavior**: Torn Paper opens with title Torn Paper and shows chunk-centered X/Z coordinates with Y 216; the command GUI accepts the world code, exposes Execute, glitches between Input Code/Leave/You Still Have Time, then opens a warning confirmation with Yes. Invalid code, dimension, and initiator-position branches are evaluated in source order. The command-block giver gives the corrupted command-block item and removes itself.
3. **Source evidence**: decompiled/net/thebrokenscript/item/TornPaperItem.java; decompiled/net/thebrokenscript/client/gui/TornPaperScreen.java; decompiled/net/thebrokenscript/client/gui/CommandBlockGuiScreen.java; decompiled/net/thebrokenscript/client/gui/CommandBlockGuiConfirmScreen.java; decompiled/net/thebrokenscript/block/CorruptedCommandBlock.java; decompiled/net/thebrokenscript/network/CorruptedCommandBlockPacket.java; decompiled/net/thebrokenscript/network/CorruptedCommandBlockConfirmPacket.java; source_extracted/assets/thebrokenscript/lang/en_us.json.
4. **Bedrock adaptation**: command_block_model.js preserves the source text, dimensions, glitch constants, and decision order; ported_features.js exposes the Torn Paper ActionFormData reader and command ModalFormData/confirmation ActionFormData forms; custom_blocks.js routes the corrupted command block and giver; torn_paper.json registers item use. Chunk 49 routes Yes through integrity_arena_runtime.js, which preserves the source center selection, 150-block roster, 40+60 tick staging, Phase 1 entity spawn, Chord roster, and 1080-tick intro gate. Chunk 50 extends that adapter with the source Phase 1 terrain queue and 20-tick replacement cadence. The ModalFormData, BlockCustomComponent, Dimension.getTopmostBlock, world time, dynamic-property, and entity-spawn seams are the supported Bedrock API path.
5. **Player-visible difference**: Text, coordinate math, actions, invalid-branch order, and codeApplied transition are retained, but Java textures, 15° rotation, exact EditBox glitch animation, packet/window-title feedback and native camera/sky presentation are not exposed by the server-side form/block seam; the supported server-side Arena startup and terrain adapter are now shipped. Command-block giver behavior uses a supported give/remove adapter.
6. **Parity class**: VALIDATED_APPROXIMATION; source text, coordinate math, decision order, and item/block wiring are covered by focused regressions and repository CI.

## A-033 — Integrity Phase 1 terrain corruption
1. **Source feature**: Phase1 terrainQueue/tick lifecycle and TerrainCorrupterKt.createTerrainCorruptionQueue.
2. **Source behavior**: build an inclusive radius-100 X/Z disk, include each position when random.nextFloat() <= 0.3, shuffle the queue, replace one queued topmost block every 20 ticks, select from the terrain_corrupt_replace tag, and skip corrupted command blocks.
3. **Source evidence**: decompiled/net/thebrokenscript/boss/integrity/Phase1.java; decompiled/net/thebrokenscript/boss/integrity/TerrainCorrupterKt.java; decompiled/net/thebrokenscript/boss/integrity/PartialBlockPos.java; decompiled/net/thebrokenscript/registry/TBSTags.java.
4. **Bedrock adaptation**: integrity_phase1_terrain_model.js preserves the queue geometry, inclusion ratio, shuffle seam, and tick state. integrity_arena_runtime.js owns the live queue, resolves the topmost target with Dimension.getTopmostBlock, skips the protected command block, and applies the source replacement IDs through Block.setType from the existing boss tick.
5. **Player-visible difference**: the four source replacement IDs are an explicit adapter for the Java registry tag; Java ChunkCarver, exact heightmap/registry behavior, and live Bedrock-world smoke testing remain unavailable.

## A-034 — Integrity Phase 2 transfer adapter

1. **Source feature**: Arena.nextPhase → Phase2.start and the Phase2.start 20-tick dimension handoff.

2. **Source behavior**: Phase 1 ends after the tracked Chord roster has no living members. Arena cleans up Phase 1 and starts Phase 2. Phase2 clears custom sky/loading state, stops the prior music, starts the Phase 2 music track, waits 20 ticks, marks the roster fixed, and sends every participant to TBSDimensions.STAGE2.

3. **Source evidence**: decompiled/net/thebrokenscript/boss/integrity/Arena.java; decompiled/net/thebrokenscript/boss/integrity/Phase1.java; decompiled/net/thebrokenscript/boss/integrity/Phase2.java; decompiled/net/thebrokenscript/handlers/dimensions/ArenaDimensionHandler.java; decompiled/net/thebrokenscript/boss/integrity/ArenaPhase.java.

4. **Bedrock adaptation**: integrity_phase2_transfer_model.js preserves the completion predicate, 20-tick delay, Stage2 dimension id, and idempotent staging plan. integrity_arena_runtime.js detects the completed Chord roster, tears down Phase 1, clears custom sky, schedules the transfer, and calls Entity.teleport with TeleportOptions.dimension for the existing thebrokenscript:stage2 dimension.

5. **Player-visible difference**: Java PlayerVariables and custom packet/music transport are represented by dynamic state and the existing Bedrock sound path. Stage2Generator/floor population, tether-gated floor movement, Phase 2 entity lifecycle, and live Bedrock-world smoke testing remain explicit future boundaries.

6. **Parity class**: VALIDATED_APPROXIMATION; pure transfer regressions and repository CI gates cover the supported handoff.

## A-035 — Integrity Phase 2 recovery tick adapter

1. **Source feature**: Phase2.tick recovery teleport, lowest-player selection, Phase2Floors.fromY, and the Phase 2 tick lifecycle.

2. **Source behavior**: Each Phase 2 tick checks floor spawns, teleports participants whose block Y is in 190..198 to (85.5, 162.5, 87.5), chooses the lowest participant with block Y > 103 using first-item tie behavior, maps that player through Phase2Floors.fromY, and uses the resulting floor as the target for later tether-gated Integrity placement.

3. **Source evidence**: decompiled/net/thebrokenscript/boss/integrity/Phase2.java; decompiled/net/thebrokenscript/boss/integrity/Phase2Floors.java; decompiled/net/thebrokenscript/boss/integrity/Stage2Floor.java.

4. **Bedrock adaptation**: integrity_arena_model.js adds the pure lowest-player selector; integrity_arena_runtime.js runs the Phase 2 tick from the supported 1-tick scheduler, performs Entity.teleport for the recovered Y band, and records the participant id and mapped floor id for the next Stage2 placement slice.

5. **Player-visible difference**: Floor spawning, safe-block scanning, Tether queries, random Integrity placement, Stage2Generator occupancy, and the Phase 2 entity lifecycle remain deferred. The tracked floor is runtime state only until those supported entity/placement adapters are ported.

6. **Parity class**: VALIDATED_APPROXIMATION; focused Y-boundary, threshold/tie, and Floor 6 mapping regressions cover the shipped contract.
