# P1 — Presentation and player-visible timing audit

Evidence date: 2026-09-24

This audit covers the exact Todo section `P1 — Presentation and player-visible timing`. The source-backed checks are implemented in `tools/validate_presentation.py` and are intentionally separate from an in-game Bedrock smoke test.

Run the audit from the repository root:

```text
python tools/validate_presentation.py --report artifacts/presentation-validation.json
```

## Inventory and timing contract

| Area | Source inventory | Deployed contract | Result |
|---|---:|---:|---|
| Animations | 35 files / 197 entries | 35 files / 197 entries | Names, lengths, loop flags, model references, and direct script bridges are checked. The restored `chord_projectile.animation.json` is intentionally an empty deployed placeholder because the source file has no animation entries. |
| Particles | 9 definitions; 7 registered Java providers and their callsite families | 11 emitters | Source textures, identifiers, provider lifetimes/render choices, event counts/spread, and every extracted Java callsite family are checked. Dedicated bridges now cover `fardaway`, `wretched_particle`, `null_structure_particle`, and `paper_particle` in addition to the generic `null_particle`, `eyes`, `particle_of_curved`, and Rock paths. The validator reports zero unadapted Java provider/callsite types. |
| Audio/music | 12 jukebox songs; 143 extracted sound definitions | 142 sound definitions; 10 record items + 2 script-only songs | Cue metadata/files are compared for every shared sound key; `video/alpha3` is recorded as intentional source-only evidence. Bedrock record durations are source-backed and comparator strength is explicitly adapted to the Bedrock maximum of 13. Custom record sound events use bare `sound_definitions.json` keys under the pinned Beta API. |
| UI/camera | 3 UI files; 10 Java menu registrations | HUD-scoped VHS overlay; supported camera calls | UI namespace/scope, overlay textures, menu inventory, and `setCamera`/`fade`/`clear` usage are checked. |

## Java menu family inventory

The ten registrations in `decompiled/net/thebrokenscript/registry/TBSMenus.java` are retained as an explicit audit surface. Bedrock uses the closest supported player-visible adapter for each family:

| Java registration | Bedrock treatment | Boundary |
|---|---|---|
| `nullinterface` | title/actionbar horror presentation | No Java container/menu internals |
| `null_interface_2` | title/actionbar horror presentation | No Java container/menu internals |
| `null_interface_3` | title/actionbar horror presentation | No Java container/menu internals |
| `nulled_gui` | scoped title/overlay presentation | No packet-driven GUI replacement |
| `command` | scripted command/input path | No Java screen handler |
| `command_confirm` | scripted confirmation path | No Java screen handler |
| `polaroid_gui` | `ActionFormData` form with source-themed texture | Form is a Bedrock UI approximation |
| `paper_gui` | text/title presentation | No Java paper-screen renderer |
| `library_book_gui` | supported book-component adapter | Java menu data components are not serialized identically |
| `fake_disconnect` | player-scoped disconnect/reconnect titles | No actual network disconnect |

## Runtime boundaries

- `fractured_animation_model.js` retains source clip names, source seconds converted to deterministic 20 Hz ticks, and event ordering. `fractured_runtime.js` calls guarded `playAnimation` bridges and keeps gameplay contact origins explicit where rendered-bone transforms are unavailable.
- `fractured_runtime.js` tracks returned `SoundInstance` handles by player and stops them on arena reset, player leave, death, and dimension change. Java `FancyAudio` fading, attenuation, client mixing after reload, and a Bedrock runtime smoke test remain outside the static contract.
- The VHS overlay is attached to `hud_screen` with `render_only_when_topmost: true`; its namespace and texture paths are validated. Multiplayer/menu isolation still needs an in-game smoke check.
- `fardaway` preserves the source funny-setting 1% branch, 50-particle ±3 Fardaway burst, and terminal 555-particle ±2 null/eyes burst. `wretched_particle` emits two ±3 particles every NoTexture/Follow tick. `null_structure_particle` is player-scoped to Creative holders of the marker item, matching the Java client-local visibility boundary. `paper_particle` is also player-scoped in the Library with the source 1% trial and ±16/±8/±16 spawn volume. Bedrock scripts run at 20 Hz rather than Java's render-frame `setupFog` hook, so Paper spawn cadence remains a documented timing approximation; its crossed-quad flutter remains a billboard/dynamic-motion adapter. `follows_particle` and `revuxor_particle` remain resource-only because the extracted source has no verified runtime provider/callsite for them.
- Exact GeckoLib controller transitions, rendered-bone hit/contact transforms, custom Java glyph pages, and the Java GLSL shader pipeline remain explicit approximation or blocked boundaries.
