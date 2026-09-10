# BEDROCK_COMPATIBILITY.md

Effective target: **Minecraft Bedrock 1.26.50 preview line**. Both the BP and paired RP declare `min_engine_version: [1, 26, 50]`; development/CI typings are pinned to the `1.26.50-preview.26` declarations. This is not an open-ended `1.26.50+` compatibility promise: the shipping BP uses a beta Script API module, and beta module compatibility must be re-audited when moving to another Minecraft release line.
Version-sensitive claims were re-verified against official Microsoft Learn / Minecraft Creator documentation on 2026-09-10 for the Script API contract audit.

## Verified platform facts (with sources)

| Topic | Verified fact | Source |
|---|---|---|
| Manifest format | Stable manifest `format_version: 2`. Module types: `resources`, `data`, `world_template`, `script`. Script modules require `"language": "javascript"` only. Format 3 is preview-only and must not be used. | Pack manifest reference (`.../addonsreference/packmanifest`) |
| BP→RP dependency | `dependencies[]` with `uuid` = RP header UUID + matching `version`; script module deps use `module_name`/`version`. | Pack manifest reference; Behavior Pack from Scratch |
| Script API tracks | Stable (semver, no suffix), beta (`-beta`, requires "Beta APIs" experiment, breaking changes may occur at each major MC release), internal (unsupported). Stable minor-version upgrades within a major are backward compatible; beta releases do not provide that guarantee. | Scripting Versioning docs |
| v2 scripting | Current Creator docs list stable `@minecraft/server` `2.9.0` and a newer 1.26.60 preview beta line. This repository deliberately remains pinned to its older 1.26.50 preview ABI until a separate migration is validated. | `@minecraft/server` module page; Scripting Versioning docs |
| Bedrock 1.26.10 stable release | `@minecraft/server` **v2.6.0**: entity heal events, `entityHurt` before event, entity item pickup/drop events, `Block.getComponents`/`hasComponent`, aim-assist suite, **camera animation & attachment APIs stable** (`playAnimation`, `attachToEntity`, `EntityAttachPoint`, CatmullRom/Linear splines, `AnimationOptions`, `CameraAttachOptions`). Also stable: biome queries (`containsBiomes` w/ `isSuperset`, `BiomeFilter`), `World.getSeed`. | 1.26.10 Creator update notes |
| Ticking areas in 1.26.10 | **RESOLVED — STABLE at v2.6.0**: `@minecraft/server` changelog lists `TickingAreaManager` and `World.tickingAreaManager` as additions in **2.6.0** (the experimental-notes entry referred to a preview-channel change). Usable by this port without experiments. | `@minecraft/server` changelog §2.6.0 |
| Custom dimensions | Experimental/beta at 1.26.10 (official custom-dimension tutorial workflow). Promoted to **stable in 1.26.30** via `@minecraft/server` v2.8.0 (`DimensionRegistry`, `StartupBeforeEvent.dimensionRegistry`, related error types). The current pack's Beta APIs requirement comes from its `@minecraft/server` `2.11.0-beta` dependency, not from custom dimensions themselves. | custom-dimension-api-tutorial; 1.26.30 update notes |
| Entity JSON validation | Stricter entity/AI JSON validation at 1.26.10 — invalid AI goal data must be treated as build/load failure. | prompt baseline + 1.26.10 notes |
| Removed components | Legacy `minecraft:pushable` removed for new content; split pushability components are current. Exact replacement component names to be confirmed against the current entity-components reference in Chunk 04 before first entity file is written. | prompt baseline; entity components reference |
| Custom items | Item cooldowns render correctly from 1.26.10; `minecraft:block_placer.aligned_placement` supported (format ≥1.26.0); empty `liquid_detection` arrays fail load. | 1.26.10 update notes |
| Script item components | Custom Component V2 attaches a namespaced component directly beside native item components. `ItemCustomComponent.onUse` and `onUseOn` are registered through the startup item-component registry; `ItemComponentUseOnEvent` exposes `source`, inherited `block`, and inherited `blockFace`. | ItemCustomComponent; ItemComponentUseOnEvent; Introducing Custom Components |
| Raycast/damage | `Entity.getEntitiesFromViewDirection` accepts `EntityRaycastOptions.maxDistance` and `ignoreBlockCollision`; returned entities can receive `applyDamage`. | Entity; EntityRaycastOptions |
| Forms | `@minecraft/server-ui` stable `2.1.0` provides `ActionFormData` and is declared as a separate manifest module dependency. CI uses `2.3.0-beta.1.26.50-preview.26` declarations because that package aligns with the pinned `@minecraft/server` preview peer used for type checking. | `@minecraft/server-ui` module; ActionFormData |
| Game mode/inventory | Script API 2.x `GameMode` constants are title-cased (`GameMode.Creative`, `GameMode.Spectator`). `Player.selectedSlotIndex`, inventory `Container.getItem/setItem`, and mutable `ItemStack.amount` support a consumable placement item outside Creative mode. | GameMode; Player; Container; ItemStack |
| Particles | Custom particles are resource-pack `particle_effect` documents. Instant emitters, finite particle lifetime, billboard appearance, and namespaced spawning are supported. | Particle Effects; particle document/component references |
| Blocks experimental | Voxel shapes (culling) behind experimental toggle; block entity events via `onEntity` handler (beta lineage) — not required for Chunk 03; re-check when blocks chunk starts. | 1.26.10 update notes (Experimental) |
| Stable-track guidance | For stable modules, prefer the highest supported stable minor within the chosen major. This does not authorize replacing the repository's explicit beta contract; changing channels is a separate migration that requires full re-validation. | Scripting Versioning docs; Latest Platform Version Guidance |
| Java Phase 3 transport | The source uses custom music/overlay/cutscene packets and a client camera override. This port can preserve their deterministic timing in a pure model, but cannot reproduce the Java packet or camera transport through the add-on runtime. | decompiled/net/thebrokenscript/boss/integrity/Phase3.java; FinalCutscene.java; ADAPTATION_NOTES A-011 |

## Decisions locked by verification

1. **Manifest**: format 2, BP (`data` + JavaScript) and RP (`resources`). Both declare minimum engine `[1, 26, 50]`.
2. **Scripts**: shipping BP dependency is `@minecraft/server` `2.11.0-beta`; local/CI type checking pins `2.11.0-beta.1.26.50-preview.26`. Worlds must enable the **Beta APIs** experiment.
3. **Forms**: the BP manifest stays on stable `@minecraft/server-ui` `2.1.0`. Development typings are pinned to `2.3.0-beta.1.26.50-preview.26`; the preview declaration package is used to align with the pinned `@minecraft/server` preview peer even though the in-game UI API used here is stable.
4. **Custom dimensions**: retained on the chosen beta contract. Their API surface has been stable since `@minecraft/server` 2.8.0; they are not the reason the pack requires the Beta APIs experiment.
5. **Camera horror effects**: the previously verified camera APIs remain available; Chunk 20 adds no new camera dependency.
6. **Version range**: `min_engine_version` is an engine floor, not evidence that every later preview/release supports `2.11.0-beta`. The verified authoring/CI target is `1.26.50-preview.26`; upgrades to another Minecraft release line require a deliberate module migration.
7. **Documentation sources**: Script API, item, form, GameMode, and particle decisions are grounded in Microsoft Learn; Bedrock Wiki indexing is used as a practical cross-check, with first-party sources taking precedence on version/runtime claims.

## Chunk 21 compatibility note

The Phase 3 controller only relies on APIs already used by the pack: entity spawning, Dimension.getTopmostBlock/getBlock, player applyDamage, and the existing scheduler. The exact Java custom overlay, music packet, camera override, and custom damage type remain documented adaptations rather than hidden compatibility assumptions.

## Documentation changes since the porting prompt was written

| Prompt claim | Current documented state | Impact |
|---|---|---|
| Custom dimensions are experimental requiring Beta APIs | Still true at 1.26.10, but **stable since 1.26.30** (`@minecraft/server` 2.8.0) | The current pack still requires Beta APIs because its shipping `@minecraft/server` dependency is `2.11.0-beta`; custom dimensions do not independently require that experiment |
| `@minecraft/server` v2.6.0 is newest relevant stable | Newer stable and beta lines exist; this repository targets the 1.26.50 preview ABI | The BP uses `2.11.0-beta` and CI pins the exact `1.26.50-preview.26` declarations; Beta APIs are a shipping requirement and later releases are not assumed compatible |

## Chunk 20 official references

- [ItemCustomComponent](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/itemcustomcomponent?view=minecraft-bedrock-stable)
- [ItemComponentUseOnEvent](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/itemcomponentuseonevent?view=minecraft-bedrock-stable)
- [Entity](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable)
- [EntityRaycastOptions](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entityraycastoptions?view=minecraft-bedrock-stable)
- [ActionFormData](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server-ui/actionformdata?view=minecraft-bedrock-stable)
- [`@minecraft/server-ui`](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server-ui/minecraft-server-ui?view=minecraft-bedrock-stable)
- [GameMode](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/gamemode?view=minecraft-bedrock-stable)
- [ItemStack](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/itemstack?view=minecraft-bedrock-stable)
- [Particle Effects](https://learn.microsoft.com/en-us/minecraft/creator/documents/particleeffects?view=minecraft-bedrock-stable)

## Chunk 22 compatibility note

The SCALE adapter uses the Bedrock entity property surface (integer range/default plus client synchronization), entity events with `set_property`, and the built-in `minecraft:scale` component. These are data-driven definition features; the controller only uses the entity `getProperty`, `setProperty`, and `triggerEvent` methods already guarded by the pack's runtime adapter. Exact Java `Attributes.SCALE` mutation remains an implementation difference, while the value's persistence, client visibility, behavior lookup, and visual application are now represented.

## Chunk 23 compatibility note

The GroundArm adapter uses the documented `Dimension.getEntities({ location, maxDistance })` query for nearby-player and nearby-tentacle lookup, `Entity.applyImpulse` for the source knockback plan, and `Entity.remove` for source discard behavior. Each call is guarded because these APIs can throw on invalid/unloaded entities. Bedrock still provides no direct Java bounding-box intersection or synchronized integer owner field, so those two details remain explicit adaptations.

Official references: [Dimension.getEntities](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/dimension?view=minecraft-bedrock-stable) · [Entity.applyImpulse](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable) · [Entity.remove](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable)


## Chunk 29 compatibility note

The multipart adapter uses the documented Entity.getAABB() surface to obtain a projectile's current center, Entity.setOnFire(seconds, useEffects) for the burning-arrow parent effect, Entity.addEffect(effectType, duration, options) for the spectral-arrow glowing effect, and System.run to defer those mutations out of the world.beforeEvents.entityHurt restricted callback. These APIs cover the supported side effects; no current add-on API creates a Java-style child multipart entity or exposes exact moving-part projectile intersection.

Official references: [Entity.getAABB](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable#getaabb) · [Entity.setOnFire](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable#setonfire) · [Entity.addEffect](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable#addeffect) · [System.run](https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/system?view=minecraft-bedrock-stable#run)
