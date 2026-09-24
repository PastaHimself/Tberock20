# Chunk 20 — Remaining parity ports

Date: 2026-08-25

## Outcome

This pass replaced the remaining safe-to-port interaction stubs with functional Bedrock implementations and integrated the supplied `VHS_filter_2.1(1).mcpack`. Java-only operating-system, renderer, and packet hooks remain explicit engine limitations rather than being represented as exact ports.

## Decompiled-source evidence

- [`HandCannonItem.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/item/HandCannonItem.java): 100-block entity ray, excludes spectators, plays `tekkit.gun` at volume 1.5/pitch 1.0, and applies 25 damage. The Java-only owner UUID/data component and direct `invulnerableTime` write are not portable.
- [`PolaroidItem.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/item/PolaroidItem.java) and [`PolaroidScreen.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/client/gui/PolaroidScreen.java): page-turn sound at pitch 1.5, source screen texture, and the persisted world `code`.
- [`PlayerDesyncManager.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/util/PlayerDesyncManager.java): persistent desync flag, same-position resync, view restoration, and Java connection-mixin deferred-packet replay.
- [`HeartCorruptionMobEffect.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/effects/HeartCorruptionMobEffect.java): harmful magenta effect with `MAX_HEALTH -1`.
- [`WhyCantYouLeaveMobEffect.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/effects/WhyCantYouLeaveMobEffect.java) and [`WhyCantYouLeaveEvent.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/events/misc/WhyCantYouLeaveEvent.java): custom eyes particle and 1000-tick event duration.
- [`EyesParticle.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/client/particle/EyesParticle.java): stationary, full-bright, approximately 0.4-unit billboard with seven-tick lifetime.
- [`circuit_cave.json`](https://github.com/PastaHimself/tbs-2.0/blob/main/source_extracted/data/thebrokenscript/painting_variant/circuit_cave.json): 4×2 source painting using `thebrokenscript:circuit_cave`.
- [`PortalControllerBlockEntity.java`](https://github.com/PastaHimself/tbs-2.0/blob/main/decompiled/net/thebrokenscript/block/portal/PortalControllerBlockEntity.java): persisted linked controller position.

## Shipped Bedrock ports

### Items and runtime

- Registered five Custom Component V2 item handlers at startup.
- Hand cannon: first non-shooter, non-spectator ray hit up to 100 blocks, block occlusion enabled, source sound, 25 magic damage, and a short duplicate-use guard.
- Polaroid: `ActionFormData` presentation using the original 1080×942 source texture, page sound, and current world code.
- Portal linker: two-click controller pairing persisted as symmetric, dimension-qualified links. Interacting with a linked controller teleports to its mate; unlinked controllers preserve the pre-existing `clan_void` fallback. Holding the linker does not trigger the block fallback.
- Desyncer: per-player toggle with darkness/nausea/glitch feedback and same-position/rotation resync. Packet interception/replay is not claimed.
- Circuit Cave placement item: all four wall faces, 4×2 decorative entity, correct 128×64 UV map, source texture, and survival/adventure item consumption.

### Effects

- Heart corruption: finite dynamic-property deadline, one point of magic damage on application, title, and action-bar pressure.
- Why can't you leave: finite 1000-tick deadline, source title pressure, and namespaced `thebrokenscript:eyes` particles built from the original 16×16 texture.
- Added `/scriptevent tbs:effect heart_corruption|why_cant_you_leave [seconds]` for deterministic testing.

### VHS resource pack

- Replaced the supplied invalid cross-namespace HUD modification with vanilla-safe `hud_screen.$additional_screen_content = "vhs_overlay.root"`.
- Preserved animated grain, chroma, tracking, dropout, head-switch, scanline, vignette, OSD, REC, and battery layers.
- Added clean tape, damaged LP, severe tracking, and worn SP subpacks.
- Added the supplied Vibrant Visuals atmosphere, color grading, lighting, and shadow settings and enabled the RP `pbr` capability.
- Reduced overlay layers from 100–109 to 20–29 to avoid the strict auditor's high-layer collision warning while preserving ordering.

## Official Bedrock API basis

- [ItemCustomComponent](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/itemcustomcomponent?view=minecraft-bedrock-stable)
- [ItemComponentUseOnEvent](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/itemcomponentuseonevent?view=minecraft-bedrock-stable)
- [Entity and view-direction raycasts](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable)
- [EntityRaycastOptions](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entityraycastoptions?view=minecraft-bedrock-stable)
- [ActionFormData](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server-ui/actionformdata?view=minecraft-bedrock-stable)
- [GameMode](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/gamemode?view=minecraft-bedrock-stable)
- [ItemStack](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/itemstack?view=minecraft-bedrock-stable)
- [Particle effects](https://learn.microsoft.com/en-us/minecraft/creator/documents/particleeffects?view=minecraft-bedrock-stable)

## Validation

- `node --test tests/remaining_ports.test.mjs`: 10/10 passed.
- All touched JSON: `jq empty` passed.
- All touched JavaScript: `node --check` passed.
- Strict JSON UI audit: 0 errors, 0 warnings, 0 information items; two UI definition files scanned.
- Image checks: Circuit Cave 128×64, Polaroid 1080×942, eyes 16×16; VHS atlas dimensions match their declared frames.
- GitHub Actions performs repository-wide schema, type, link, structure, Blockception, Creator Tools, regression, and packaging checks after commit.

## Explicit non-ports

- Java window/dialog/file/crash behavior.
- Java framebuffer/core/post GLSL.
- Java packet suppression/deferred replay.
- Custom potion registry entries and per-player maximum-health attribute modifiers.
- A Java owner UUID/data-component restriction that would delete the hand cannon for every other player.
- Unverified global Bedrock font-page replacement and incomplete Nostalgia archive material.

