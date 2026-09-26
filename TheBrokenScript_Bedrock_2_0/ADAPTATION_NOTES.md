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
6. **Design**: In-game surrogates: kick-to-menu ("banned"), full-screen fake disconnect/error forms, source JFrame textures in the HUD for the five registered events, chat/title "file written" narration where story-required.
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
Source `StoryEvents.tick()` returns before dispatch when the daylight-cycle gamerule is disabled, then advances the persisted story counter only when `playerCount>0`. The pinned Bedrock Script API exposes the equivalent readable `world.gameRules.doDayLightCycle` boolean, so the runtime now applies the same two-stage gate in both the deployed `BP` and authoring `src` copies.

With daylight cycling disabled, the clock and event dispatcher pause. With daylight cycling enabled and no players online, the persisted time does not advance but the dispatcher still evaluates the persisted exact threshold, matching the Java method. With a player online, the clock advances by one tick before exact-threshold dispatch. `tests/story_clock.test.mjs` covers these pause/resume and schedule contracts.

The command-backed workaround is not needed. Engine import/smoke execution remains a separate validation boundary because no Bedrock runtime is available in the local environment. Parity: `VALIDATED_HIGH_PARITY`.

## A-009 — Java custom font
The Java font provider and glyph image do not map directly to Bedrock's glyph-page resources. Until every codepoint and page offset is verified, the pack uses standard Bedrock glyphs with obfuscation/color formatting. Shipping an unverified glyph page could replace unrelated vanilla characters globally. Parity: exact = `DEFERRED_UNSAFE`; styled text = `VALIDATED_APPROXIMATION`.

## A-010 — Packet desynchronization
`PlayerDesyncManager` toggles a Java player flag and resends deferred packets through a server-connection mixin on resync. Bedrock Script API exposes neither packet interception nor deferred packet replay. Chunk 20 makes the item functional with per-player state, nausea/darkness, glitch presentation, and a same-position/rotation teleport on resync. Parity: packet behavior = `ENGINE_UNSUPPORTED`; gameplay beat = `VALIDATED_APPROXIMATION`.

## A-011 — Integrity Arena transport and final cutscene
1. **Source feature**: Arena participant selection/liveness, Phase1/Phase2 progression, Phase3 ring spawning, boundary kill countdown, custom transition overlay, dimension transfer, music packets, end cutscene, and delayed boss discard; IntegrityPhase3Entity.java damage/death lifecycle.
2. **Source behavior**: Arena selects players within 150 blocks and keeps the encounter alive with the source <=2-player rule; Phase1 waits 1080 ticks before ten chords; Phase2 transfers after 20 ticks; Phase3 transfers after 20 ticks, spawns 251 random candidates plus three fixed SCALE-2 presets, kills above y>90 after 60 ticks, and uses the 428-tick final cutscene (108 pre-roll, 190 camera interpolation, 100 zoom, 40 blackout).
3. **Source evidence**: decompiled/net/thebrokenscript/boss/integrity/{Arena,Phase1,Phase2,Phase3,FinalCutscene}.java and decompiled/net/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity.java.
4. **Replacement design**: `BP/scripts/entities/boss/integrity_arena_runtime.js` owns stable participant ids, radius selection, liveness, phase transitions, source transfer delays, tracked entity cleanup, and cutscene completion. `integrity_arena_model.js` holds the exact predicates/constants; `phase3_runtime.js` consumes the Arena roster; `integrity_camera.js` uses Bedrock's supported free-camera/fade API; the damage-source adapter preserves same-tick source attribution.
5. **Bedrock limitation**: Java's overlay and custom music/start-stop packets, exact client camera interpolation/zoom transport, custom `void_mass` damage-type registration, and superclass dying animation have no direct add-on equivalent. The source transition sheet now plays through the Bedrock JSON UI HUD when a boundary countdown begins.
6. **Player-visible difference**: The deterministic roster, phase timing, transfers, boundary countdown, transition images, attacks, damage gate, camera position/target adapter, blackout fade, and delayed cleanup are shipped. Packet-level music, exact camera interpolation/zoom, and native Java death-text/custom-damage metadata remain engine adapters.
7. **Parity class**: `VALIDATED_APPROXIMATION` for the source gameplay/runtime slice; `ENGINE_UNSUPPORTED` only for the documented Java-only transport and presentation mechanisms.

## A-036 — Source screen images and HUD transport

1. **Source evidence**: `textures/screens` contains 59 PNGs and three `.png.anim.json` atlases. `TheBrokenEndEntity`, `TheBrokenEndCuriousEntity`, `Phase3`, `ClientOblit2Handler`, `FeverGoals`, the horror events, Null chat response, and the other entity overlay callsites supply the triggers and tick durations.
2. **Bedrock implementation**: the resource pack carries the source textures. `screen_overlay.js` sends `tbs:screen/<texture-id>` through the player's title channel; `hud_screen.json` hides only titles with that prefix and `tbs_screens.json` draws the named image above the VHS layer. `tools/generate_screen_ui.py` builds fixed UV controls for the 4-frame TBE Curious, 22-frame transition, and 5-frame Obliteration 2 sheets. The source atlas PNG bytes are not altered. Normal titles keep their vanilla rendering.
3. **Screen event coverage**: the TBE four-frame interference, ordinary frame and text flashes, Curious, Circuit, phantom, hallucination, Faraway, Siluet, Null invade/chat, Fever contact, Integrity Phase 3 boundary, Obliteration 2 proximity, five JFrame events, BSOD, keep-playing, run, behind-you, and wrong-overlay use source images at their recorded or adapted timings. The three Null interfaces and nulled GUI display their original 176×166 art at the center of the HUD.
4. **Protocol and validation**: `tbs:screen/<id>` is reserved for the add-on; `tbs:screen/<sheet>/<frame>` selects an atlas cell, and `tbs:screen/clear` releases it. The `tests/screen_overlay.test.mjs` runtime checks title replacement, cancellation, frame cadence, asset paths, and the 22-frame UV endpoint. The JSON UI audit and add-on validators check the declarative files. The HUD title-text binding and image-texture binding follow the current Mojang sample and Bedrock Wiki title protocol pattern (community pattern, inferred from documented examples).
5. **Remaining difference**: the original OS dialogs and interactive Java container menus cannot be installed through a Bedrock add-on. Null menu images are brief visual replicas without inventory slots; source `polaroid` and paper interactions still use native forms. Other copied screen textures are available for future event triggers but are not claimed to be active. Title-based routing may compete with unrelated titles that arrive at the same tick, and actual display, timing, UI scaling, and touch behavior require a Bedrock 1.26.50 Preview smoke run.

## Pending-analysis adaptations (bytecode required)
- Spawn-condition predicates → all 23 decompiled `api/entity/conditions/*.java` classes were source-audited on 2026-09-20 and the corresponding runtime/authoring rules were reconciled. Exact `TBSEngineControl.Companion.eventFrequency(gameTime)` escalation is now ported and the director supplies absolute world time. Remaining differences are engine adapters rather than unaudited predicates: Bedrock Script API does not expose Java natural-spawn placement/heightmap internals, `StructureManager` mineshaft-piece membership, or `Monster.isDarkEnoughToSpawn`; the Circuit Mineshaft rule therefore uses a conservative local rail/cobweb/plank/fence signature. Real 1.26.50 Preview smoke evidence is still required for engine-level spawn behavior.
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
4. **Bedrock limitation**: Bedrock entity IDs are opaque strings, so the source's synchronized integer owner field cannot be reproduced as a networked entity field. The pinned Script API does expose `Entity.getAABB()`, so the source strict intersection predicate is now available; exact client/network synchronization of the owner remains unavailable.
5. **Replacement design**: `phase3_runtime.js` keeps a live `arm.id → owner` map, guards invalid references, applies the source timing/damage/impulse plan, and tests the arm AABB against each roster player's AABB with strict face/edge exclusion. GroundArm remains explicitly non-persistent in its BP definition and is removed when its owner/lifecycle expires.
6. **Player-visible difference**: owner association is runtime-only and is rebuilt when a new GroundAttack spawns an arm; geometric contact uses the supported server AABBs, while Java's synchronized owner field is represented only inside the live runtime.
7. **Parity class**: `VALIDATED_APPROXIMATION`; exact owner synchronization remains an engine gap, while GroundArm timing and AABB contact are source-backed.

## A-014 — Chord projectile and BrokenCore arrow-damage adapter

1. **Source feature**: `ChordEntity.performProjectileAttack` and `ChordProjectileEntity` movement, distance expiry, impact branches, gravity restoration, grounded offsets, and empty pickup behavior.
2. **Source behavior**: source speed is `1.6f`, inaccuracy is `0.0f`, `initialPos` is the Chord position, and `setBaseDamageFromMob(2.0f)` is called. The projectile is transient, no-gravity in flight, discarded at 100 blocks, and queues 20-tick block-hit removal.
3. **Source evidence**: `decompiled/net/thebrokenscript/entity/boss/ChordEntity.java`, `ChordProjectileEntity.java`, and `decompiled_brokencore/net/thebrokenscript/brokencore/api/entity/base/UwuableArrow.java`.
4. **Bedrock limitation**: the server API does not expose the Java renderer's grounded `Vec2` hook or a direct Java projectile hit result. The adapter uses the target AABB top for `getY(1.0)`, with a one-block fallback if an entity does not expose an AABB.
5. **Replacement design**: a dedicated runtime owns normalized 1.6-block/tick movement, substepped block/entity collision, owner exclusion, source branch order, gravity restoration event, 100-block expiry, and block countdown. Chord damage uses the documented projectile attribution shape with the Chord as `damagingEntity` and the projectile as `damagingProjectile`. The pure model mirrors inherited vanilla `AbstractArrow#setBaseDamageFromMob(2.0f)` with the source difficulty-weighted triangular term; the runtime maps stable Bedrock `World.getDifficulty()` values to Java difficulty ids. Exact face offsets remain in the pure model.
6. **Player-visible difference**: continuous collision and renderer application of grounded offsets remain adapted; launch targeting and inherited vanilla arrow damage are source-backed within the available server API.
7. **Parity class**: `VALIDATED_APPROXIMATION` for the gameplay/runtime slice; renderer and continuous-contact differences remain documented adapters.

## A-015 — Fractured/Jimmy attack and keyframe adapters

1. **Source feature**: FracturedEntity, JimAttackSelectorGoal, the four Jimmy attacks, and RockEntity.
2. **Source behavior**: Jimmy starts with a 100-tick attack delay, chooses among the four equal-weight attacks, emits Stomp/Slam/SingleStomp/Rock effects at source timings, and uses RockEntity's 15-damage AOE/owner exclusion/Elytra side effect.
3. **Source evidence**: decompiled/net/thebrokenscript/entity/fractured/{FracturedEntity,JimAttackSelectorGoal,RockEntity}.java and decompiled/net/thebrokenscript/entity/fractured/attacks/*.java.
4. **Bedrock limitation**: add-ons do not expose GeckoLib server bone transforms or the custom SUB_ANOM_2 damage source. A Bedrock custom particle emitter replaces Java's block-particle registration.
5. **Replacement design**: the dedicated runtime owns the recovered base lifecycle, rising pulse, attack state machine, and impact constants. Player melee is the explicit six-hit progress adapter; source keyframe instruction names are isolated behind `fracturedAnimationEventPlan`; Rock collision uses `getAABB()` and a substepped runtime query. Block impact invokes a custom Bedrock moon-stone emitter with the source count, offset ranges, upward velocity, and one-tick cleanup boundary.
6. **Player-visible difference**: exact attack keyframe timestamps and bone-origin positions remain adapters; the 400-particle moon-stone burst preserves the source count/material/spatial plan, with Bedrock emitter lifetime and particle physics as the engine-specific presentation layer. Attack timing, damage, cooldown, owner exclusion, and defeat progress are preserved.
7. **Parity class**: VALIDATED_APPROXIMATION for the recovered gameplay slice; keyframe/bone mechanisms remain engine-limited while the block-particle burst is source-backed through a Bedrock emitter.

## A-016 — Jimmy multipart hitbox and FracturedRoam switch adapter

1. **Source feature**: BaseFracturedEntity's head/chest/leg-part layout, FracturedPartEntity, FracturedSubEntity, Leg, and the FracturedRoam multipart-trigger path.
2. **Source behavior**: the source builds head 14×14 at (1, 88, 10), chest 18×18 at (1, 68, 10), four 15×15 subentities at frontleft/frontright/backleft/backright, and four 45-block Leg targets. Part hurt handling calls Roam.swap() first; burning arrows ignite the parent for 20 seconds, spectral arrows add glowing for 400 ticks, and accepted part hits temporarily set the parent's hit-via-part flag. Leg.tick rotates target offsets by the parent's body yaw. A FracturedRoam part hit enters SWITCHING and the host promotes to the main Fractured entity after the source 103-tick switching duration.
3. **Source evidence**: decompiled/net/thebrokenscript/api/entity/BaseFracturedEntity.java; decompiled/net/thebrokenscript/entity/fractured/{FracturedPartEntity,FracturedSubEntity,Leg,FracturedRoamEntity}.java; decompiled/net/thebrokenscript/boss/fractured/JimArena.java.
4. **Bedrock limitation**: Bedrock add-ons do not expose Java child multipart entities, parent/part identity, GeckoLib limb transforms, or exact melee impact coordinates. Rendered-bone world transforms are also unavailable to the server Script API.
5. **Replacement design**: `fractured_multipart_model.js` preserves the six logical part definitions, dimensions, offsets, yaw transform, AABBs, hit-plan ordering, and 103-tick state. The runtime applies a derived 105×102 root collision envelope, uses a deterministic swept segment against the six conceptual AABBs for projectile history, defers `setOnFire`/`addEffect` side effects with `system.run`, and tags/ticks FracturedRoam until it can spawn the main Fractured entity.
6. **Player-visible difference**: projectiles use conceptual part filtering rather than actual child entities, so exact child identity and moving rendered contact remain adapted. FracturedRoam promotion spawns the main entity directly; the JimArena participant/sound schedule and underground/dig/despawn lifecycle are adapted in Chunks 30–31, while bossbar, camera, exact ordinary melee hit location, and guaranteed looping-music control remain engine gaps.
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
6. **Replacement design**: `damage_source_model.js` is a pure 15-entry catalog, exact tag-parity model, and explicit native-cause mapping. `damage_source_runtime.js` validates the custom id, sends the mapped native cause with entity/projectile attribution, and retains every same-tick custom source record per target instead of overwriting collisions. Recovered callsites now route Jimmy stomp, Rock, Integrity ball, Integrity shield bypass, void mass, Fever, Chord, and hand-cannon damage through the adapter.
7. **Player-visible difference**: custom source ids and same-tick attribution order remain available to the port's logic, but Bedrock's native death text and armor/effect/shield/totem handling still follow the selected built-in cause.
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

## A-023 — Entity-family targeting, visibility, and spawn-gate contract

1. **Source feature**: the 69 shipped behavior-pack entity definitions represented by the source entity registry, including Circuit, Null, TBE, humanoid, misc, stalking, boss, projectile, and render-only variants.
2. **Source behavior**: entity controllers select player targets in the entity's dimension, exclude spectator players, evaluate gaze against the target hitbox, and apply spawn sky/light and distance gates before creating an entity. Family-specific controllers retain their source timers, cleanup hooks, and side-effect adapters.
3. **Source evidence**: `SOURCE_MAP.json` entity rows; `decompiled/net/thebrokenscript/entity/**`; `TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_family_registry.js`; and the family controller/spawn-rule files listed by that registry.
4. **Bedrock limitation**: Java multipart child entities, client render-bone visibility, exact FOV internals, and Java chunk operations are not exposed as one-to-one Script API mechanisms.
5. **Docs checked**: [Microsoft's Dimension Script API](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/dimension?view=minecraft-bedrock-stable) for `getBlockFromRay` and sky-light access, [Microsoft's Entity Script API](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable) for hitboxes/view helpers, and the Bedrock Wiki `behavior.nearest_attackable_target` examples for player filters and `must_see` semantics.
6. **Replacement design**: `entity_family_registry.js` is a dependency-free source/runtime/render inventory for all 69 shipped entities. `targeting_model.js` centralizes dimension/game-mode filtering; `gaze.js` samples the entity AABB and rejects obstructed rays; `visibility.js` uses `Dimension.getSkyLightLevel`; and the spawn director scopes legacy `players[0]` rules to each player while retaining one successful spawn per tick.
7. **Player-visible difference**: exact Java multipart/render visibility and engine-only chunk behavior remain adaptations; supported Bedrock target selection, ray visibility, and sky-light gates are no longer permissive component or cone-only surrogates.
8. **Parity class**: `VALIDATED_HIGH_PARITY` for the supported targeting/visibility/spawn-gate slice; `VALIDATED_APPROXIMATION` for Java-only multipart, render, and chunk-operation behavior.

## A-024 — Jimmy rising, sweep, and Bedrock capability boundary

1. **Source feature**: `BaseFracturedEntity` rising damage, `JimAttackSelectorGoal`, `FracturedPartEntity`/`FracturedSubEntity` filtering, `FracturedRoamEntity`, and `JimArena` lifecycle.
2. **Source behavior**: the 149-tick rising counter emits the 30-block grounded-player wave while its post-decrement value is 103 through 55; the source id is `thebrokenscript:jimmy_rise` and damage is 19. The four real attacks retain equal weight 1.0 with no previous-attack exclusion. Projectile filtering is represented by six yaw-transformed regions, while Roam uses the source 30-block underground random range and 100-block normal stroll range.
3. **Source evidence**: `decompiled/net/thebrokenscript/api/entity/BaseFracturedEntity.java`; `decompiled/net/thebrokenscript/entity/fractured/{FracturedEntity,FracturedPartEntity,FracturedSubEntity,FracturedRoamEntity,JimAttackSelectorGoal}.java`; `decompiled/net/thebrokenscript/boss/jimmy/JimArena.java`; and `fractured.animation.json`.
4. **Docs checked**: [Microsoft's Entity Script API](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable), [EntityHurtBeforeEvent](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityhurtbeforeevent?view=minecraft-bedrock-stable), [EntityDamageSource](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entitydamagesource?view=minecraft-bedrock-stable), and [Bedrock geometry locators](https://learn.microsoft.com/minecraft/creator/reference/content/visualreference/geometry.v1.21.0?view=minecraft-bedrock-stable).
5. **Bedrock limitation**: the current server API exposes AABBs and rotation but no rendered-bone/locator world-transform getter, and `EntityHurtBeforeEvent` exposes no melee impact coordinate. Exact ordinary melee part selection and exact animated bone origins therefore remain unavailable.
6. **Replacement design**: the pure models expose rising plans, equal-weight attack candidates, source lifecycle gates, and a slab-based continuous projectile sweep. The runtime keeps per-projectile history, applies source-order side effects, exposes injectable contact-origin adapters, and falls back to the entity root when no server-side locator adapter exists. JimArena refreshes roster instances and stops both `SoundInstance` and `stopSound` fallbacks during reset.
7. **Player-visible difference**: source gameplay timings, damage, impulses, lifecycle, recovery, conceptual sweep, and audio cleanup are deterministic; rendered-bone contact, exact melee hit locations, bossbar/camera packets, and exact Java audio attenuation remain adaptations.
8. **Parity class**: `VALIDATED_APPROXIMATION` for source-verifiable gameplay and cleanup; `ENGINE_UNSUPPORTED` for exact rendered-bone and melee-impact transport.

## A-025 — Projectiles and damage parity audit

1. **Source feature**: the custom Chord projectile, Integrity fireball, Jimmy Rock projectile, inherited Chord/engine arrow damage, and all 15 Java custom damage types.
2. **Source behavior**: Chord uses the Chord position, speed 1.6, zero inaccuracy, no-gravity flight, owner exclusion, 100-block expiry, source impact branch order, and 20-tick grounded cleanup. Integrity fireball uses the animated righttendrils5 origin, speed 1.6, zero inaccuracy, superclass entity/block impact ordering, a power-5 no-block/no-fire explosion, and 6 integrity_ball damage. Rock uses its attack origin, speed 8, zero inaccuracy, owner exclusion, 15-damage AOE over every living entity in the impact box, Elytra/arrow side effects, the 400-particle block burst, and one-tick cleanup.
3. **Source evidence**: decompiled/net/thebrokenscript/entity/boss/ChordEntity.java, ChordProjectileEntity.java, decompiled/net/thebrokenscript/entity/integrity/phase3/{FireballAttack,IntegFireballEntity}.java, decompiled/net/thebrokenscript/entity/fractured/{RockEntity,attacks/MoonRockTossAttack}.java, source_extracted/data/thebrokenscript/damage_type/*.json, the six extracted damage-type tag files, and TBSDamageTypes.java.
4. **Replacement design**: Chord, fireball, and Rock use source-backed pure models plus dedicated swept collision runtimes. Chord targets the AABB top to mirror getY(1.0) and sends Bedrock projectile attribution with both the Chord owner and projectile. Fireball targets getY(0.5) and retains an explicit adapter lifetime for orphan cleanup because the Java LargeFireball lifetime is engine-owned. The damage model exports all 15 native-cause/attribution mappings; hand cannon, boss, phase-3, and Fractured callsites use the common adapter. The bounded per-target ledger preserves multiple same-tick source/player records in arrival order.
5. **Docs checked**: [Entity.applyDamage](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityapplydamageoptions?view=minecraft-bedrock-stable), [EntityApplyDamageByProjectileOptions](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityapplydamagebyprojectileoptions?view=minecraft-bedrock-stable), [EntityDamageSource](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entitydamagesource?view=minecraft-bedrock-stable), [EntityHurtBeforeEvent](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityhurtbeforeevent?view=minecraft-bedrock-stable), and [EntityDamageCause](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entitydamagecause?view=minecraft-bedrock-stable).
6. **Player-visible difference**: Bedrock cannot register the Java damage-type ids or enforce their custom death-message, exhaustion/scaling, armor/effect/invulnerability/shield/totem bypass, and no-knockback metadata through Entity.applyDamage(). Fireball animation-bone origin and engine-owned lifetime remain adapters; grounded renderer offsets and continuous collision are also not byte-for-byte Java projectile behavior.
7. **Parity class**: VALIDATED_APPROXIMATION for source constants, branch ordering, owner exclusion, cleanup, native attribution, all-15 catalog/tag parity, and same-tick ledger isolation; exact custom damage-type semantics and Java-only projectile transport remain ENGINE_UNSUPPORTED.
## A-026 — P1 custom-dimension policy and entry routing

1. **Source feature**: the 13 registered Java dimensions, their dimension-type/generator/biome associations, entry variants, return routes, and protected-void orientation.
2. **Source behavior**: the port preserves the source-backed policy values and routes entry through startup registration, destination readiness, safe landing, and explicit return adapters.
3. **Source evidence**: `source_extracted/data/thebrokenscript/dimension_type/`, `source_extracted/data/thebrokenscript/worldgen/`, `decompiled/net/thebrokenscript/registry/TBSDimensions.java`, and `docs/P1_DIMENSION_POLICY.json`.
4. **Bedrock limitation**: the supported `DimensionRegistry.registerCustomDimension` surface exposes a void generator and does not expose Java `noise_settings` or arbitrary custom `ChunkGenerator` registration.
5. **Docs checked**: [Bedrock DimensionRegistry](https://github.com/MicrosoftDocs/minecraft-creator/blob/main/creator/ScriptAPI/minecraft/server/DimensionRegistry.md) and [Microsoft's custom dimension API tutorial](https://learn.microsoft.com/minecraft/creator/documents/scripting/custom-dimension-api-tutorial?view=minecraft-bedrock-stable).
6. **Replacement design**: `dimension_policies.js` is the source-backed policy registry; `dimensions.js` uses its entry location/rotation and the existing readiness/safe-landing path.
7. **Player-visible difference**: exact Java terrain/noise generation and every client-side environment setter remain unavailable; entry coordinates, protected-void yaw, registration IDs, and supported route behavior are validated.
8. **Parity class**: `VALIDATED_HIGH_PARITY` for registration and supported routing; `VALIDATED_APPROXIMATION` for environment and terrain; exact noise/custom-generator behavior is `ENGINE_UNSUPPORTED`.

## A-027 — P1 structure corpus and jigsaw conversion boundary

1. **Source feature**: the complete source structure inventory, including 314 NBT templates, Shaft pools/connectors, Integrity Stage 2 assets, XCSF material, and custom processors.
2. **Source behavior**: every source template has an explicit inventory status; the six Shaft templates are staged source-identical assets and the supported Shaft graph is validated separately.
3. **Source evidence**: `tools/inventory_structure_corpus.py`, `tools/validate_jigsaw_worldgen.py`, `tools/validate_jigsaw_nbt_connectors.py`, and `docs/P1_PARITY_AUDIT.md`.
4. **Bedrock limitation**: static tooling cannot execute Java custom generators/processors or compare generated worlds, and Bedrock has no one-to-one API for the remaining Java placement pipeline.
5. **Replacement design**: source inventory, NBT parsing status, connector graph, pool metadata, and explicit conversion status are release-gated; supported templates remain available to the existing Bedrock worldgen adapters.
6. **Player-visible difference**: Stage 2/XCSF/custom-processor placement and natural generation frequency/spacing are not claimed as exact without an engine world sample.
7. **Parity class**: `VALIDATED` for corpus/graph inventory and supported staged assets; `VALIDATED_APPROXIMATION` for converted placement; runtime world comparison remains deferred.

## A-028 — P1 block-entity and tag adapters

1. **Source feature**: eight Java block-entity equivalents plus source block/item tags used by recipes, drops, placement, and scripted predicates.
2. **Source behavior**: source membership and block-entity state contracts are inventoried; the deployed pack uses namespaced dynamic properties, marker/render adapters, and scripted handlers where Bedrock has no matching registry/state surface.
3. **Source evidence**: `tools/validate_p1_parity.py`, the source block-entity registry/resources, and `docs/P1_PARITY_AUDIT.md`.
4. **Bedrock limitation**: Java block-entity NBT/storage/tick semantics and item-tag registries are not universally expressible through the pinned Bedrock ABI.
5. **Replacement design**: supported block tags, shears matching, persistence keys, render markers, and scripted interactions are explicit and validated; unsupported state is kept in the adapter layer rather than silently dropped.
6. **Player-visible difference**: exact Java container/NBT internals and unexposed tag consumers remain implementation-specific adapters.
7. **Parity class**: `VALIDATED_HIGH_PARITY` for source inventory and supported consumers; `VALIDATED_APPROXIMATION` for engine-specific block-entity/state behavior.

## A-029 — P1 portal entity-scope adapter

1. **Source feature**: portal controller/extender activation, linking, destination selection, safe arrival, cooldown, and incoming-entity handling.
2. **Source behavior**: activation requires sneaking, the linker is not consumed, anchors and links persist, destination readiness is checked, safe fallback is used, and repeat entry is guarded for one tick.
3. **Source evidence**: the source portal controller/extender classes and `BP/scripts/systems/ported_features.js`.
4. **Bedrock limitation**: the current Script API route does not provide the Java portal tick sweep for every same-dimension living entity, nor a one-to-one item/projectile transfer hook.
5. **Replacement design**: the shipped route handles player interaction, namespaced persisted anchors/links, readiness-gated teleport, safe landing, and persisted cooldown state.
6. **Player-visible difference**: mobs, items, and projectiles do not claim Java portal parity; unavailable destination initialization falls back to the documented safe route.
7. **Parity class**: `VALIDATED_HIGH_PARITY` for player linking/arrival/cooldown; `ENGINE_UNSUPPORTED` for the unexposed entity/item/projectile sweep.

## A-030 — P1 direct command surface

1. **Source feature**: the Java `tbs` root's direct `devmode [code]` and `reputation` commands, plus its separately gated `dev` command tree.
2. **Source behavior**: `devmode` accepts `2018` or `544253`, reports the exact success/error messages, and attempts the corresponding 1000-entity spawn effect; `reputation` is player-only and reports the source reputation bands.
3. **Replacement design**: Bedrock registers both direct commands as player-only `Admin` custom commands with `cheatsRequired: false`; the larger developer/regression surface remains on `/scriptevent tbs:*`.
4. **Bedrock limitation**: Bedrock has no Java permission-level 4 ladder or one-to-one Brigadier `CommandSourceStack` position contract, so `Admin` and a player origin are the closest safe mappings.
5. **Docs checked**: [Microsoft's CustomCommandRegistry](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/customcommandregistry?view=minecraft-bedrock-stable) and [CustomCommandParameter](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/customcommandparameter?view=minecraft-bedrock-stable).
6. **Parity class**: `VALIDATED_HIGH_PARITY` for direct command validation/messages/effects; `VALIDATED_APPROXIMATION` for the permission/source-origin mapping and the unregistered Java `dev` tree.

## A-031 — P1 vanilla loot output identifiers

1. **Source feature**: the `sideways_cobblestone_stairs` and `ud_oak_door` block loot tables.
2. **Source behavior**: the Java tables drop `minecraft:cobblestone_stairs` and `minecraft:oak_door`, respectively, after the source explosion-survival condition.
3. **Source evidence**: `source_extracted/data/thebrokenscript/loot_table/blocks/{sideways_cobblestone_stairs,ud_oak_door}.json`.
4. **Bedrock limitation**: the current project validation surface cannot resolve those two vanilla outputs as behavior-pack item definitions, while the shipped custom block forms are resolvable and placeable.
5. **Replacement design**: the tables keep the source condition and weight but route the output through `thebrokenscript:sideways_cobblestone_stairs` and `thebrokenscript:ud_oak_door`; `validate_p1_parity.py` release-gates both explicit mappings.
6. **Player-visible difference**: breaking these custom blocks returns the pack's custom block form instead of an unresolved vanilla item identifier.
7. **Parity class**: `VALIDATED_APPROXIMATION`; source table structure and intent are preserved, with the output identifier represented by a documented Bedrock adapter.

## A-032 — Presentation and player-visible timing audit

1. **Source feature**: the P1 presentation surface: Java animation/controller resources and model references, particle definitions/providers/callsites, `jukebox_song` definitions and music items, the ten `TBSMenus` registrations, VHS/UI resources, and Integrity/Fractured camera and audio adapters.
2. **Source evidence**: `source_extracted/assets/thebrokenscript/animations` (35 files/197 entries), `source_extracted/assets/thebrokenscript/particles` (9 definitions), `source_extracted/data/thebrokenscript/jukebox_song` (12 songs), `source_extracted/assets/thebrokenscript/sounds.json`, `decompiled/net/thebrokenscript/registry/TBSMenus.java`, the current `BP/` presentation runtimes, and the current `RP/` animation/audio/UI trees.
3. **Validation**: `tools/validate_presentation.py` compares animation names/lengths/loop flags and model references, particle identifiers/resources/lifetimes/counts, inventories extracted provider/callsite families, compares every shared sound cue, verifies all 12 songs, all 10 record items, all ten Java menu registrations, the three UI files, overlay scope, and supported camera calls. The check is run by the existing `bedrock-addon-check` workflow and has focused mutation tests for a missing animation and incorrect record timing.
4. **Replacement design**: the missing deployed `chord_projectile.animation.json` resource is restored; Fractured presentation uses source-derived 20 Hz event timing and guarded `playAnimation` calls; particle resources and the extracted seven-provider callsite inventory are checked, with generic event bridges for `null_particle`, `eyes`, and `particle_of_curved` plus the 400-particle Rock adapter; ten Bedrock record components use source durations and bare `sound_definitions.json` keys; the two Lilly themes remain script-only; and arena `SoundInstance` handles are owned per player and stopped on reset, leave, death, and dimension change.
5. **Player-visible difference**: Bedrock's record comparator signal is capped at 13, so the source value is adapted rather than overstated. Java provider/callsite families without a dedicated Bedrock runtime bridge remain explicit follow-up work, and `video/alpha3` remains an intentional source-only sound cue. Java GeckoLib controller transitions, server-visible rendered-bone transforms, exact melee/contact origins, FancyAudio fading/attenuation and reload mixing, actual network disconnects, custom glyph pages, and the Java GLSL pipeline remain engine-specific or blocked. The VHS layer is statically HUD-scoped, but multiplayer/menu isolation still needs an in-game smoke check.
6. **Docs checked**: [Entity.playAnimation](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable), [animation overview](https://learn.microsoft.com/minecraft/creator/documents/animations/animationsoverview?view=minecraft-bedrock-stable), [Dimension.spawnParticle](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/dimension?view=minecraft-bedrock-stable), [custom sounds](https://learn.microsoft.com/minecraft/creator/documents/addcustomsounds?view=minecraft-bedrock-stable), [`minecraft:record`](https://learn.microsoft.com/minecraft/creator/reference/content/itemreference/examples/itemcomponents/minecraft_record?view=minecraft-bedrock-stable), [1.26.30 technical updates](https://learn.microsoft.com/minecraft/creator/documents/update1.26.30?view=minecraft-bedrock-stable#experimental-technical-updates), and the [Camera Script API](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/camera?view=minecraft-bedrock-stable).
7. **Parity class**: `VALIDATED_APPROXIMATION` for source inventory, resource/timing contracts, supported runtime bridges, and cleanup hooks; `ENGINE_UNSUPPORTED` or `DEFERRED_UNSAFE` for exact Java controller/render-bone, custom-font, shader, audio-mixer, and multiplayer rendering behavior.

## A-033 — Null Maze door/block and Null Flying gaze/sneak adapters

1. **Source feature**: `NullMazeEntity`, `MazeHitGoal`, `MazeNavigator`/`DynamicMazeNavigationGoal`, `NullFlyingEntity`, `PlayerUtil.isLookingAt`, and `PlayerExt.isEntityInFovCone`.
2. **Source behavior**: Maze's `StalkGoal` nearest-player provider searches within 128 blocks, while its separately constructed `PersistentTargetGoal` inherits the entity's 416-block `follow_range`; the retained target window is 450 unseen ticks. While targeted it opens the first closed collider hit within 2.5 blocks. When its target is present and it has been strictly stationary for more than 30 ticks, it inspects the two forward block positions using Java's per-component integer truncation, destroys each non-air block and its block above with drops, and resets the stuck counter after that destroy branch. Its source navigation can open/pass doors, float, walk over fences, and uses 1.45 movement speed (the source's 1.55 falling-target branch is also retained in the model). Flying uses a strict eye-center gaze test `dot > 1 - 0.025 / distance` within 128 blocks, schedules the 20-tick callback once, treats sneaking at either trigger or callback as success, applies the source -10/+10 reputation result and 24000-tick gain cooldown, and uses the 30-block 70%/1..9 proximity branch. The client FOV helper uses same-dimension/line-of-sight checks and the inclusive cosine threshold `cos(fov / 1.5)`.
3. **Source evidence**: `decompiled/net/thebrokenscript/entity/nullent/NullMazeEntity.java`, `decompiled/net/thebrokenscript/api/entity/ai/null_maze/MazeHitGoal.java`, `decompiled/net/thebrokenscript/util/DynamicMazeNavigationGoal.java`, `decompiled/net/thebrokenscript/entity/nullent/NullFlyingEntity.java`, `decompiled_brokencore/net/thebrokenscript/brokencore/api/dsl/PlayerUtil__PlayerCheckDSLKt.java`, `decompiled/net/thebrokenscript/api/ext/PlayerExt.java`, and `decompiled_brokencore/net/thebrokenscript/brokencore/api/dsl/ClientPlayerDSLKt.java`.
4. **Bedrock limitation**: the Script API has no Java custom `MazeNavigator`, no server-visible client FOV option, no Java `DoorBlock` upper/lower/hinge geometry for custom blocks, and no custom damage-type/swing hook that exactly reproduces `NULL_MAZE`. The stable navigation component can express door opening/passage/float/fence flags, but cannot express the source's transparent-wall stalking goal or its custom pathfinder internals.
5. **Replacement design**: `null_source_controller.js` owns event-driven tracking, the persisted 3200-tick timer, light-block cleanup, source stuck/block-destroy/door-ray decisions, delayed Flying callback, proximity side effects, hurt cleanup, and invalid-entity guards. `null_pursuit_model.js` keeps the pure thresholds and random branches. `null_maze.json` uses native nearest-target/melee/move goals with the recovered priorities, 450-tick memory, 2-block attack radius, 10-tick cooldown, and navigation flags. `door_runtime.js` provides native/custom open-state mutation, native door-half pairing, interaction tracking, and the protected-void +24-block mirror. `gaze.js` exposes the exact center-gaze and supplied-FOV equivalents.
6. **Player-visible difference**: custom doors use a namespaced open state and a full-block geometry with an empty collision permutation rather than Java's directional door shape; native door sound mapping and Maze's custom swing/damage-source/pathfinder internals are Bedrock adapters. The server uses exact source gaze and sneak timing for the Flying gameplay callback, while the client-only FOV flag is exposed when a caller supplies the FOV and cannot be populated from the server Script API alone.
7. **Parity class**: `VALIDATED_APPROXIMATION` for the source constants, conditions, timers, state transitions, door/block side effects, and supported AI components; real 1.26.50 Preview engine smoke testing remains required for collision, navigation, damage, sound, custom block permutations, multiplayer isolation, reload, and FOV behavior.

## A-034 — Chunk-removal and player-modified-chunk surrogates

1. **Source feature**: `ChunkRemoverConditions`, `ChunkRemoverEntity`, `ChunkHelper.clearChunk`, `ChunkUtil.moveChunkUp`, `ChunkCommands`, `ChunkTrackerHandler`, `PlayerModifiedChunksData`, `StructureUtil.placeStructureForced`, `CorruptedCommandBlockHandler`, and `LevelLoadHandler`.
2. **Source behavior**: the natural remover gates in source order: non-peaceful, valid spawn surface unless a spawner, mob spawning enabled, Null Here enabled, entity spawning not disabled, overworld only, chunk removal not disabled, random roll `<= 1e-4`, no player at or inside 25 blocks, sky visible from below water, not Integrity Phase 1, flat-world roll `<= 1e-4`, block light `< 1`, and no player-modified block count in the chunk. A spawned remover plays ambient cave at volume 10/pitch 0, then clears the chunk with 5% probability or moves its 16-block sections upward by a random 16..128 blocks. The source clear/move operations also update block entities, ticks, heightmaps, light, tickets, full-chunk packets, and in-chunk entities. The developer command always clears the command source's chunk. Player placement/break events maintain a persistent dimension-aware count, and forced structure placement force-loads its bounding-box chunks.
3. **Source evidence**: `decompiled/net/thebrokenscript/api/entity/conditions/ChunkRemoverConditions.java`, `decompiled/net/thebrokenscript/entity/misc/ChunkRemoverEntity.java`, `decompiled_brokencore/net/thebrokenscript/brokencore/api/world/ChunkHelper.java`, `decompiled_brokencore/net/thebrokenscript/brokencore/api/world/ChunkUtil.java`, `decompiled_brokencore/net/thebrokenscript/brokencore/impl/commands/ChunkCommands.java`, `decompiled/net/thebrokenscript/handlers/player/ChunkTrackerHandler.java`, `decompiled/net/thebrokenscript/data/PlayerModifiedChunksData.java`, `decompiled_brokencore/net/thebrokenscript/brokencore/api/dsl/StructureUtil.java`, `decompiled/net/thebrokenscript/handlers/CorruptedCommandBlockHandler.java`, and `decompiled/net/thebrokenscript/handlers/player/LevelLoadHandler.java`.
4. **Bedrock limitation**: Bedrock add-on scripts do not expose Java chunk-section storage, light-engine invalidation, chunk tickets, full-chunk packets, arbitrary force-load/unload operations, or a separate `LightLayer.BLOCK` query. `Dimension.getLightLevel` is total brightness, and `Dimension.isChunkLoaded` only reports current state; it is not a replacement for Java's forced ticket lifecycle.
5. **Replacement design**: `chunk_remover_model.js` preserves the gate/order/boundary/random contracts and computes a top-down section plan. `misc_spawn_rules.js` uses that decision model and the persistent `modified_chunks.js` event ledger. `chunk_remover_runtime.js` removes the transient entity, fails closed when the target chunk is not loaded, clears with supported `BlockVolume`/`fillBlocks`, and uses deferred-safe `clone ... replace move` section operations plus guarded in-chunk entity teleports for the upward observable effect. `commands.js` adds the flat admin `tbs:chunk_remove` form of the source nested command. The force-load callsites are inventoried but do not issue unsupported low-level chunk operations.
6. **Player-visible difference**: the surrogate can remove/move loaded blocks and move entities in the affected chunk, but Bedrock owns block-entity/tick/light/ticket/packet maintenance and the operation fails safely for unloaded chunks. The block-light gate is conservative because total brightness rejects locations that Java's block-light-only test might allow. Forced structure placement and limbo chunk initialization continue to use the engine's normal loading behavior rather than claiming Java ticket parity.
7. **Parity class**: `VALIDATED_APPROXIMATION` for source gate/random/ledger contracts and the safe loaded-chunk observable mutation; Java low-level chunk internals and forced-ticket behavior are `ENGINE_UNSUPPORTED`. Real 1.26.50 Preview smoke testing remains required for block entities, redstone/tick behavior, light updates, entities, persistence, multiplayer, and reload boundaries.

## A-035 — Numeric source provenance and Bedrock adapter boundaries

The source-backed models keep the provenance of the remaining non-trivial numeric literals explicit:

1. `RepTier.LOSS_HUGE` is `-35`, and `RepUtilKt.gainBackHalfLostRep` uses Java integer division. The corresponding Bedrock regain value is therefore `17`, not `17.5`; odd loss amounts are truncated toward zero.
2. `TimeOfDay.java` provides the source `TICKS_PER_DAY = 24000` and `NIGHT = 13000`. The `23000` event cutoff is a Bedrock-side final-1000-tick gate and is not claimed as a Java source literal.
3. `1e-9` is only the Bedrock swept-AABB zero-delta tolerance. Java's child-part collision hierarchy does not provide an equivalent scalar constant.
4. `0.999999999` is only the Bedrock normalized-roll clamp for an exclusive `[0, 1)` random boundary. It is not presented as a recovered Java literal.

Parity class: `VALIDATED_APPROXIMATION` for the supported adapters; the Java child-entity collision hierarchy and exact client/runtime engine behavior remain subject to the limitations recorded in `KNOWN_LIMITATIONS.md`.
