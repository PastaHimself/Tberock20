# KNOWN_LIMITATIONS.md

Engine-level gaps verified against official documentation (see BEDROCK_COMPATIBILITY.md). “Shipped approximation” means the gameplay-facing behavior now exists, but the Java-only mechanism does not.

1. **OS-level integration remains impossible** — Bedrock cannot change the native window title, open LWJGL/JFrame dialogs, create desktop files, or crash the process. The in-game title/form surrogates remain (A-004).
2. **The Java GLSL pipeline remains impossible** — Bedrock cannot load the mod's 89 Java core/post shaders. Chunk 20 ships the supplied VHS pack as a valid JSON UI HUD overlay, four severity subpacks, and Vibrant Visuals atmosphere/color/lighting/shadow settings. Aberration, invert, dream, fever, and glitch effects remain mood-level approximations (A-003).
3. **Custom fluid physics remain unavailable** — `void_liquid` uses the existing translucent block/script approximation (A-001).
4. **Custom mob-effect registry entries remain unavailable** — `heart_corruption` and `why_cant_you_leave` now run as finite script effects. The latter uses the original eyes texture through a native Bedrock particle. A custom potion icon and Java's `MAX_HEALTH -1` attribute modifier cannot be reproduced exactly (A-002).
5. **Custom advancements remain unavailable** — the existing progression flags and toast-style presentation are the shipped replacement (A-006).
6. **Custom painting variants remain unavailable** — Chunk 20 ships `circuit_cave` as a breakable 4×2 decorative entity with the original 128×64 texture and a consumable placement item (A-005).
7. **Noise-based custom terrain generation remains unavailable** — the dimension terrain and structures remain supported approximations (A-007).
8. **Beta APIs are required by the shipping behavior pack** — the effective pack floor is Bedrock 1.26.50 and the BP declares `@minecraft/server` `2.11.0-beta`; worlds must enable Beta APIs. Dimensions are retained.
9. **Custom Java font glyphs are unresolved** — corrupted text uses Bedrock formatting and standard glyphs. The Java font map cannot be copied safely without a verified Bedrock glyph-page mapping (A-009).
10. **Packet-level desynchronization is impossible** — the Java desyncer suppresses and later resends network packets. Bedrock exposes no packet interception API, so the item ships a nausea/darkness/glitch/resync gameplay surrogate (A-010).
11. **Java-mod compatibility mixins are inapplicable** — Iris/Oculus/Sodium/JourneyMap/Xaero/EMI/JEI/Jade/VoiceChat/DistantHorizons integration has no Bedrock runtime equivalent.
12. **`sites/rblog/file.bin` stays out of the pack** — it is an opaque 85 MB non-Minecraft payload and cannot execute in Bedrock.
13. **Nostalgia overrides remain partial/deferred** — these replace broad vanilla sound/model assets and can conflict with the main RP. The later `tbs.zip` upload is a multipart/concatenated archive whose outer directory exposes only chunks 3, 5, 6, 7, 8, and 9, so it is not a safe basis for claiming a complete optional-pack import.

14. **Integrity Phase 3 Java transport is not exact** — the controller now ships source-backed tentacle placement, boundary countdown, and native void terminal damage. The Java Arena participant roster/transfer, transition.png overlay packet, custom music/cutscene packets, client camera override, custom void_mass attribution, and delayed cleanup remain adaptations or unsupported transport (A-011).

All reachable Java behavior is either implemented, approximated with an explicit player-visible difference, or retained here as engine-unsupported.

