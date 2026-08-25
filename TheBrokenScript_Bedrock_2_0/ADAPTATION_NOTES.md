# ADAPTATION_NOTES.md

Every entry documents an engine-driven adaptation (prompt §35). Seed set from Chunk 00; expanded as chunks run.

## A-001 — Custom fluid `void_liquid`
1. **Source feature**: Void liquid fluid (source + flowing) with custom block, used by void dimensions.
2. **Source behavior**: TBSFluids/TBSFluidTypes registry; flowing/source semantics; player interaction (damage/visuals per code — bytecode analysis pending).
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

## Pending-analysis adaptations (bytecode required)
- Spawn-condition predicates (24 classes) → spawn director fidelity depends on decompiled constants/timings.
- Event probabilities/cooldowns (~91 handlers) → same.
- GeckoLib animation *code* behaviors (head-tracking, procedural tentacles via `api/tentaclev2`) → script equivalents; assets already Bedrock-native.
