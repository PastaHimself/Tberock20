# KNOWN_LIMITATIONS.md

Engine-level gaps verified against official documentation (see BEDROCK_COMPATIBILITY.md). Each maps to an ADAPTATION_NOTES entry and final `ENGINE_UNSUPPORTED`/`VALIDATED_APPROXIMATION` ledger states.

1. **No OS-level integration** — window title changes, LWJGL/JFrame popups, desktop `.txt` creation, real process crash. In-game equivalents only (A-004).
2. **No Java GLSL post-processing** — VHS/aberration/invert/dream/fever/glitch shaders approximated via supported visuals (A-003).
3. **No custom fluids** — void_liquid approximated (A-001).
4. **No custom mob effects** — two effects emulated (A-002).
5. **No custom advancements** — progression state tracked in scripts (A-006).
6. **No custom painting variants** — surrogate planned (A-005).
7. **No noise-based custom terrain generation** — dimension terrain approximated (A-007).
8. **Custom dimensions require experiments at min-engine 1.26.10** — beta path isolated; OR raised floor to 1.26.30 stable API (decision Chunk 10). Dimensions will NOT be removed.
9. **Custom font glyphs** — corrupted-font text rendering approximated with standard glyph styling.
10. **Iris/Oculus/Sodium/JourneyMap/Xaero/EMI/JEI/Jade/VoiceChat/DistantHorizons compat mixins** — Java-mod interop only; meaningless on Bedrock (documented non-runtime on other platforms).
11. **sites/rblog/file.bin** — opaque 85 MB non-Minecraft payload; cannot execute in Bedrock; preserved out-of-pack.
12. **Nostalgia packs** — vanilla sound/model legacy overrides; partial applicability; decision in Chunk 03.

None of these remove shipping gameplay; every affected feature keeps its Bedrock-side behavior or is explicitly ledgered.
