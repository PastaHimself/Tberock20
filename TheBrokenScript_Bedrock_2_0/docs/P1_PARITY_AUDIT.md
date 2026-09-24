# P1 parity audit

This audit records the source-backed implementation for the two selected Todo headings:

- `P1 — Quests, items, blocks, loot, and commands`
- `P1 — Dimensions, worldgen, structures, and portals`

The source of truth is the extracted Java data and decompiled registries in
this repository. The machine-readable release gate is
`tools/validate_p1_parity.py`; it emits a report with the exact selected Todo
headings and fails on missing source content, metadata drift, or incomplete
dimension/portal contracts.

## Content and progression

- All 123 source blockstates resolve to Bedrock block definitions. The two
  additional Bedrock block forms are the explicit `void_goop_flow` and
  `void_goop_still` fluid-state adapters.
- All eight source block entities are represented by the existing scripted,
  marker, renderer, or persistent-state adapters. Portal controller and
  extender state is stored in namespaced dynamic properties; custom geometry
  remains governed by the existing block definitions and placement handlers.
- All 40 source recipes match ingredient signatures, result identifiers, and
  result counts. Stonecutter recipes are represented by Bedrock shapeless
  recipes tagged `stonecutter`.
- All 138 source loot tables are present, including the 26 plush tables and
  the intentional empty `null` table. Explosion survival, shears-only flora
  drops, output identifiers, empty/no-drop tables, and source weights are
  checked. The Java-only `minecraft:cobblestone_stairs` and
  `minecraft:oak_door` outputs use explicit custom-block loot adapters in
  the Bedrock pack, and those mappings are release-gated. Java slab/door
  state functions are recorded as the documented single-block geometry
  adapter.
- Source block-tag membership is checked against `minecraft:tags`; the
  source item tags are preserved as explicit adapters. The flora tag maps to
  `minecraft:shears`, and the creepy-disc tag remains source evidence for
  the corresponding disc family.
- The five source advancements keep their exact English titles and
  descriptions. Awards are persisted per player and duplicate awards are
  suppressed across reloads and alternate event paths. Recipe-crafted
  progression uses the existing persisted inventory scan because this target
  Bedrock ABI has no equivalent stable custom recipe event.
- The source advancement criteria and their live hooks are inventoried: the
  three impossible criteria remain explicitly event-award adapters,
  `polaroid_craft` uses the persisted inventory scan, and the boss/proximity
  awards resolve through the existing horror, humanoid, and TBE controller
  paths. Source icon/background and client advancement-screen presentation
  remain Bedrock UI limitations.
- The Java `tbs` command root is permission level 4. Bedrock maps the direct
  `tbs:reputation` and `tbs:devmode` entries to the closest operator-only
  `Admin` permission and keeps both player-only. `devmode` accepts the exact
  Java codes (`2018` and `544253`) and schedules the corresponding 1000-entity
  spawn effect. The larger developer/regression tree stays behind
  `/scriptevent tbs:*` and is not registered as production commands.

The complete command inventory is emitted in the parity report from the
decompiled command sources. Its direct root entries are `devmode [code]` and
`reputation`; the gated `dev` tree includes arena, Jim arena, boss, entity,
give, player, structure, world, set, FX, summon, reputation-debug, code,
coordinate, cape-update, and the imported core command groups. The Bedrock
production surface exposes the two direct source entries with an operator gate;
the broader regression/developer operations remain explicit script events so a
debug hook cannot silently become a release gameplay bypass.

## Item contracts

The 191 source item models are resolved, including the intentional vanilla
`thebrokenscript:totem` → `minecraft:totem_of_undying` model adapter. Gameplay
metadata is now checked for the source-sensitive items:

- all 17 cod easter-egg items use the source Cod food values;
- Null Bread and Circuit Bread remain always edible and fast;
- Null Cod, Revuxorfish, and Faraway Salmon remain always edible;
- Revuxorfish and Faraway Salmon apply their source effects through registered
  `onConsume` components;
- the Java negative nutrition values are carried directly because the current
  Bedrock food component documents `nutrition` as an integer;
- Glaggle is a non-food stack of 16;
- the 12 source music discs carry stack size, rarity, comparator signal,
  duration, and resource-pack sound-event metadata;
- polaroid pieces, Polaroid, and Torn Paper carry the source rarity, stack,
  and fire-resistance metadata;
- N and Gore consume one selected item outside Creative, Torn Paper opens a
  stable form adapter, and Book stores its source 1–250 identifier on the
  non-stackable `ItemStack` dynamic property before opening its form adapter;
- the existing hand cannon, Polaroid, portal linker, desyncer, and Circuit
  Cave placement components remain connected and covered by the same static
  component registry check.

The Java library-book menu and Torn Paper menu are client-side Java screens.
Bedrock uses the supported `ActionFormData` route, while preserving the
library-book identifier on the item stack so transfers and reloads do not
silently reroll it.

## Dimension, structure, and portal contracts

- The 13 source dimension IDs have one source-backed policy row each. The
  policy records source dimension type, generator, biome, ambient light, time,
  skylight, natural/piglin-safe flags, height limits, entry coordinates,
  source entry variants, and return/death adapters.
- Registration remains in the startup event, uses
  `DimensionRegistry.registerCustomDimension`, and routes teleports through
  ticking-area readiness plus a safe platform/landing fallback.
- The complete source structure corpus is inventoried: 314 NBT templates,
  parsed/inventory status for every entry, and explicit conversion status.
  The six Shaft templates are source-identical staged assets; Stage 2/XCSF
  and Java-only processors remain identified as conversion boundaries rather
  than being presented as a different, fabricated generator.
- Portal linking is sneak-gated like Java, does not consume the linker, keeps
  two anchors and bidirectional links in persisted namespaced state, removes
  obsolete reverse links when either endpoint is relinked, rejects
  cross-dimension pairs, validates both controller blocks before use, waits for
  the destination on the interaction adapter, and applies a one-tick persisted
  arrival guard.
- The source controller's one-tick portal sweep is restored for same-dimension
  Bedrock entities carrying the documented `minecraft:health` component (the
  closest supported `LivingEntity` boundary). Connected extender blocks grow
  the portal AABB, equal-size portals preserve relative XYZ offsets, riders use
  the source zero-Y offset, arrival UUIDs are guarded against same-tick bounce,
  and `TeleportOptions.keepVelocity` preserves motion.
- The protected-void entry preserves the source `(11, 71, 6)` position and
  180-degree yaw without passing non-coordinate metadata to the Bedrock
  teleport location object. Other source entry variants/search rules remain
  in the policy file as explicit lifecycle adapters.

## Explicit Bedrock boundaries

The Bedrock custom-dimension registration surface currently creates a void
generator. Exact Java `noise_settings` terrain and custom `ChunkGenerator`
behavior are therefore not claimed. Java's `LivingEntity` class boundary has
no one-to-one Bedrock Script API type, so the portal sweep uses the documented
`minecraft:health` component as its supported runtime adapter; item and
projectile entities remain excluded because the Java implementation does not
teleport them. Static checks cannot replace in-game multiplayer and world-sample
comparison, so those runtime checks remain separate validation gates.

## Validation entry point

```text
python tools/validate_p1_parity.py --check --report artifacts/p1-parity-validation.json
```

The validator is also exercised by `tests/test_p1_parity_validator.py`, which
checks the selected headings, source counts, metadata contracts, and mutation
failures for reintroduced gaps.

## Documentation consulted

- [Bedrock `DimensionRegistry.registerCustomDimension`](https://github.com/MicrosoftDocs/minecraft-creator/blob/main/creator/ScriptAPI/minecraft/server/DimensionRegistry.md)
- [Custom dimension API tutorial](https://learn.microsoft.com/minecraft/creator/documents/scripting/custom-dimension-api-tutorial?view=minecraft-bedrock-stable)
- [Custom components](https://learn.microsoft.com/minecraft/creator/documents/scripting/custom-components?view=minecraft-bedrock-stable)
- [Loot table conditions](https://learn.microsoft.com/minecraft/creator/documents/loottableconditions?view=minecraft-bedrock-stable)
- [Custom command registry](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/customcommandregistry?view=minecraft-bedrock-stable)
- [ItemStack dynamic properties](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/itemstack?view=minecraft-bedrock-stable)
- [`minecraft:food`](https://learn.microsoft.com/minecraft/creator/reference/content/itemreference/examples/itemcomponents/minecraft_food?view=minecraft-bedrock-stable)
- [`minecraft:record`](https://learn.microsoft.com/minecraft/creator/reference/content/itemreference/examples/itemcomponents/minecraft_record?view=minecraft-bedrock-stable)
- [`minecraft:rarity`](https://learn.microsoft.com/minecraft/creator/reference/content/itemreference/examples/itemcomponents/minecraft_rarity?view=minecraft-bedrock-stable)
- [`minecraft:fire_resistant`](https://learn.microsoft.com/minecraft/creator/reference/content/itemreference/examples/itemcomponents/minecraft_fire_resistant?view=minecraft-bedrock-stable)
