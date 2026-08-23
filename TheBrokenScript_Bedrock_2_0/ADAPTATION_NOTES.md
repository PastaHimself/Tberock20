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
1–3. **Feature/behavior/evidence**: TBSEffects registry; ERR.HEALTH HUD corruption effect; leave-prevention effect.
4. **Limitation**: No custom status-effect registry.
5. **Docs checked**: `@minecraft/server` Effect APIs (vanilla effects only).
6. **Design**: Script-driven emulation: timers on player state + HUD via titles/actionbar + health manipulation for heart_corruption.
7. **Difference**: Icon-only potion HUD absent.
8. **Parity**: `VALIDATED_APPROXIMATION`.

## A-003 — Post-processing shader suite (VHS, aberration, invert, dream, fever, glitch, sky)
1–3. **Feature/behavior/evidence**: 89 GLSL files under `shaders/**`; client mixins hooking GameRenderer/LevelRenderer/FogRenderer; `/fx` toggles.
4. **Limitation**: Bedrock has no Java core/post GLSL pipeline for add-ons.
5. **Docs checked**: Creator VFX/fog/camera references; 1.26.10 camera API notes (stable splines).
6. **Design**: Approximation layer: fog color/density control, camera shake/splines, particle fields, title/actionbar overlays, texture-swap flicker via render controllers where visible-equivalent exists. Per-effect mapping decided in Chunk 14.
7. **Difference**: Exact pixel post-processing unreproducible; mood-level equivalents only.
8. **Parity**: `ENGINE_UNSUPPORTED` for exact pipeline; `VALIDATED_APPROXIMATION` for visible results where achievable.

## A-004 — OS/desktop integration
1–3. **Feature/behavior/evidence**: window title hijack (`window.thebrokenscript.*`), LWJGL alert popups, JFrame popups (jframe_1..5), desktop `.txt` creation (`enableFileCreation`), world "ban" to menu.
4. **Limitation**: Bedrock scripts cannot touch the OS window, spawn dialogs, or write arbitrary files.
5. **Docs checked**: Scripting overview/security model.
6. **Design**: In-game surrogates: kick-to-menu ("banned"), full-screen fake disconnect/error forms, title overlays mimicking LWJGL text, chat/title "file written" narration where story-required.
7. **Difference**: Effects stay inside the game window.
8. **Parity**: exact = `ENGINE_UNSUPPORTED`; surrogate = `VALIDATED_APPROXIMATION`.

## A-005 — Painting variant `circuit_cave`
**Limitation**: no custom painting variants → surrogate (item-frame entity with custom texture or decorative block). Parity: approximation.

## A-006 — Advancements (5)
**Limitation**: no custom advancement definitions → tracked progression flags + toast-style title/sound presentation. Trigger logic preserved in scripts. Parity: approximation.

## A-007 — Noise-based dimension terrain (noise_settings ×3)
**Limitation**: no `noise_settings` equivalent; custom-dimension generator capability limited. Design: closest supported terrain via vanilla dimension types + features/structures/scripts per dimension; exact noise parity impossible. Parity: approximation; per-dimension detail in Chunk 10/11.

## A-008 — Story-clock daylight gate
Source `StoryEvents.tick()` advances the persisted story counter only when `playerCount>0` **and** gamerule `doDaylight` is enabled. Bedrock stable API (v2.6.0) exposes no gamerule query without commands workarounds; port gates on players-online only. Difference: story time also advances while daylight cycling is disabled (rare server setups). Parity: `VALIDATED_HIGH_PARITY`.

## Pending-analysis adaptations (bytecode required)
- Spawn-condition predicates (24 classes) → spawn director fidelity depends on decompiled constants/timings.
- Event probabilities/cooldowns (~91 handlers) → same.
- GeckoLib animation *code* behaviors (head-tracking, procedural tentacles via `api/tentaclev2`) → script equivalents; assets already Bedrock-native.
