# The Broken Script 2.0 → Minecraft Bedrock Full Port

## Role

Act as a senior Minecraft Bedrock add-on engineer, reverse-engineering specialist, gameplay/AI programmer, technical artist, world-generation engineer, and integration tester.

Your task is to build a **complete Minecraft Bedrock Edition port of The Broken Script 2.0 from scratch** from the supplied decompiled NeoForge mod and its original resources.

This is not a prototype, partial remake, proof of concept, compatibility layer, or “inspired by” addon. The end state must be a functioning Bedrock `.mcaddon` that systematically ports every shipping gameplay/content system that can be represented in Bedrock and explicitly documents any engine-level limitation that prevents exact parity.

The project is intentionally too large for a single execution. **Work in strict, resumable chunks. One execution handles one chunk only.**

---

# 1. Authoritative Inputs

The user will provide some or all of the following:

- Decompiled/reconstructed Java and/or Kotlin source for The Broken Script 2.0.
- The original NeoForge mod JAR:
  `thebrokenscript-neoforge-2.0.0+mc1.21.1-build.3084.jar`
- Fully decompressed JAR contents or split archives containing those contents.
- Original `assets/`, `data/`, `META-INF/`, configuration, tags, structures, textures, sounds, music, models, shaders/render data, JSON, and other resources.
- JVM disassembly only when a class could not be reconstructed correctly.

There is **no existing Bedrock port to use as a base**.

Do not ask for, depend on, or reconstruct behavior from an older Bedrock addon.

Build the Bedrock version from the supplied The Broken Script 2.0 sources and resources only.

---

# 2. Source-of-Truth Order

Use evidence in this order:

1. Decompiled/reconstructed The Broken Script 2.0 Java/Kotlin logic.
2. Original The Broken Script 2.0 resources and data files.
3. Original configuration/default values.
4. JVM bytecode/disassembly when decompilation is incomplete.
5. Comments/documentation contained in the supplied source.
6. Careful behavioral inference only when none of the above resolves the behavior.

Never claim that `javap` output or raw `.class` metadata is reconstructed source code.

When decompiler artifacts make a method ambiguous, inspect:

- neighboring classes,
- call sites,
- field usage,
- constants,
- state transitions,
- registries,
- configuration,
- resources,
- data files,
- bytecode/disassembly.

Record genuine uncertainty instead of inventing behavior.

---

# 3. Bedrock Technical Authority

For Minecraft Bedrock implementation details, treat the **current official Microsoft/Minecraft Creator documentation** as authoritative.

Before implementing version-sensitive Bedrock behavior, verify it against Microsoft Learn / Minecraft Creator documentation.

Use stable documentation by default.

Important baseline rules for this port:

- Target **Minecraft Bedrock 1.26.10+**.
- Use a normal Behavior Pack + Resource Pack architecture.
- Default to stable **manifest format version 2**. Manifest version 3 is preview/experimental and must not be adopted just because it is newer.
- Behavior Pack data modules use the appropriate `data` module.
- Resource Pack modules use the appropriate `resources` module.
- Script modules use `type: "script"`, `language: "javascript"`, and a real compiled JavaScript entry file.
- If TypeScript is used for maintainability, compile it to JavaScript for deployment.
- Pack-to-pack dependencies must reference the exact paired pack header UUID/version.
- Script API dependencies must use versions supported by the actual target Bedrock release.
- For an exact 1.26.10 target, verify all scripting dependencies against the 1.26.10 Creator documentation before writing the manifest.
- Minecraft Bedrock 1.26.10 exposes major stable scripting functionality through `@minecraft/server` v2.6.0, including stable camera animation/attachment and ticking-area APIs. Use later stable APIs only when the chosen minimum game version supports them.
- Beta APIs must not be used casually.
- **Custom script-registered dimensions are currently experimental** in the official Creator workflow and require Beta APIs. If The Broken Script requires custom dimensions and exact parity cannot be achieved through stable data-driven functionality, Beta APIs are permitted for that subsystem. Isolate the experimental dependency, document it, and do not downgrade/remove the dimension simply to avoid the experiment.
- Bedrock 1.26.10 has stricter entity/AI JSON validation. Invalid AI goal data must be treated as a build/load failure.
- Do not use the removed legacy `minecraft:pushable` entity component for 1.26.10+ content; use the currently supported split pushability components when required.
- Prefer stable custom block/item components and stable Script API hooks where they can reproduce the source behavior.
- Use current Bedrock world-generation systems—custom biomes, features, feature rules, structure templates, jigsaw structures, structure sets, and scripting—where they accurately map to the Java implementation.
- Do not assume Java terrain-generation systems have a 1:1 Bedrock equivalent. Preserve the gameplay result using the closest supported Bedrock mechanism and document unavoidable differences.
- Use current stable camera APIs for horror/cinematic effects when they correspond to source behavior.
- Do not depend on community documentation when an official Minecraft Creator reference exists.

High-value official references to consult during the port include:

- Pack manifests:
  https://learn.microsoft.com/minecraft/creator/reference/content/addonsreference/packmanifest?view=minecraft-bedrock-stable
- Bedrock 1.26.10 Creator update notes:
  https://learn.microsoft.com/minecraft/creator/documents/update1.26.10?view=minecraft-bedrock-stable
- `@minecraft/server`:
  https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/minecraft-server?view=minecraft-bedrock-stable
- Script module versioning:
  https://learn.microsoft.com/minecraft/creator/documents/scripting/versioning?view=minecraft-bedrock-stable
- Behavior Packs:
  https://learn.microsoft.com/minecraft/creator/documents/behaviorpackfromscratch?view=minecraft-bedrock-stable
- Resource Packs:
  https://learn.microsoft.com/minecraft/creator/documents/resourcepack?view=minecraft-bedrock-stable
- World generation:
  https://learn.microsoft.com/minecraft/creator/documents/world-generation?view=minecraft-bedrock-stable
- Custom dimensions:
  https://learn.microsoft.com/minecraft/creator/documents/scripting/custom-dimension-api-tutorial?view=minecraft-bedrock-stable
- Custom components:
  https://learn.microsoft.com/minecraft/creator/documents/scripting/components-tutorial?view=minecraft-bedrock-stable

When the documentation has changed since this prompt was written, follow the newer official documentation and record the version change in `BEDROCK_COMPATIBILITY.md`.

---

# 4. Definition of “Full Port”

A full port means that the final parity inventory accounts for **every shipping system discovered in the supplied 2.0 source**, including as applicable:

- mod bootstrap and lifecycle,
- shared/core libraries used by gameplay,
- configuration that affects gameplay,
- registries,
- entities,
- entity variants,
- entity AI,
- stalking/psychological systems,
- bosses,
- projectiles,
- attacks,
- damage mechanics,
- status/effect systems,
- player state,
- world state,
- persistent state,
- cooldowns/timers,
- events,
- random encounters,
- horror events,
- environmental events,
- blocks,
- block states,
- block interactions,
- block entities or equivalents,
- items,
- weapons,
- tools,
- consumables,
- special items,
- recipes,
- loot,
- tags,
- structures,
- dimensions,
- portals,
- custom world spaces,
- biomes,
- world generation,
- configured/placed features,
- structures and structure placement,
- progression,
- advancements or Bedrock-equivalent state,
- commands that ship as player/admin functionality,
- networking-dependent gameplay translated into Bedrock’s architecture,
- animations,
- models,
- textures,
- materials,
- render behavior,
- particles,
- fog,
- lighting effects where supported,
- sounds,
- music,
- ambience,
- camera behavior,
- screen effects,
- UI required for gameplay,
- multiplayer behavior,
- death/respawn behavior,
- join/leave behavior,
- dimension transitions,
- save/reload behavior,
- cleanup/despawn logic,
- performance-critical scheduling,
- any hidden system that materially affects normal gameplay.

Do not omit a source feature merely because it is difficult.

For every source feature, the final parity ledger must end in exactly one of these states:

- `VALIDATED_FULL`
- `VALIDATED_HIGH_PARITY`
- `VALIDATED_APPROXIMATION`
- `ENGINE_UNSUPPORTED`

`ENGINE_UNSUPPORTED` is allowed only when the relevant Bedrock capability was checked against current official documentation and no practical supported implementation exists.

---

# 5. Semantic-Port Rule

This is a **semantic port**, not source-language translation.

Do not mechanically convert NeoForge APIs into JavaScript.

Translate each Java system to an appropriate Bedrock design.

Examples:

- NeoForge entity registration → Bedrock entity definitions + client entities + spawn rules + Script API controller when necessary.
- Java AI goals → Bedrock AI components and/or explicit scripted state machines.
- Java event bus → centralized Bedrock event subscriptions.
- Java capability/data attachment → dynamic properties and/or managed persistent state.
- Java tick handlers → centralized scheduling with `system.run`, `system.runInterval`, event-driven logic, or another supported mechanism.
- Java networking → Bedrock-native server-authoritative state/event flow.
- custom renderers → Bedrock geometry, client entities, render controllers, materials, animation controllers, particles, camera APIs, and supported visual systems.
- Java configuration → explicit Bedrock configuration/state layer.
- Java worldgen → Bedrock biomes/features/feature rules/structures/jigsaws/scripts as appropriate.
- Java dimensions → supported Bedrock dimension systems; use experimental script-registered custom dimensions only when required for parity.
- Java GUIs → appropriate Bedrock UI/forms or another supported presentation when gameplay requires them.

Preserve semantics, timing, state transitions, probabilities, pacing, and player-facing results as closely as Bedrock permits.

---

# 6. Clean-Room Bedrock Project

Create a new project such as:

```text
TheBrokenScript_Bedrock_2_0/
  BP/
  RP/
  src/
  tools/
  docs/
```

Use a consistent namespace:

`thebrokenscript`

unless the supplied 2.0 source proves another public identifier must be used.

Do not modify the supplied Java mod.

Do not place decompiled Java/Kotlin code inside the shipping Bedrock pack.

Do not ship extraction artifacts, bytecode, decompiler outputs, or analysis dumps inside the final `.mcaddon`.

---

# 7. Chunking Contract — Mandatory

## ONE EXECUTION = ONE CHUNK

For every execution:

1. Read the persistent progress files.
2. Determine the exact current chunk.
3. Inspect only the source families required for that chunk plus their immediate dependencies.
4. Write/update the chunk specification.
5. Implement the chunk completely.
6. Validate it.
7. Run a source-parity review for that chunk.
8. Update all persistent state files.
9. Produce a chunk report.
10. Stop.

Do **not** begin the next chunk in the same execution.

If a planned chunk is too large to implement and validate with high confidence, split it before coding:

- `Chunk 05A`
- `Chunk 05B`
- `Chunk 05C`

A subchunk is still subject to the one-execution rule.

Do not reduce fidelity just to fit a chunk.

---

# 8. Persistent Project Memory

At project initialization create and maintain:

```text
PORT_PROGRESS.md
SOURCE_INVENTORY.json
SOURCE_MAP.json
PARITY_MATRIX.md
BEDROCK_ARCHITECTURE.md
BEDROCK_COMPATIBILITY.md
ADAPTATION_NOTES.md
VALIDATION_LOG.md
KNOWN_LIMITATIONS.md
ASSET_MAP.json
IDENTIFIER_MAP.json
```

Also create:

```text
docs/chunks/
```

with one specification and one report for every chunk/subchunk.

These files are the authoritative memory of the project across separate executions.

---

# 9. Required State-File Semantics

## `PORT_PROGRESS.md`

Track:

- source mod/version,
- target Bedrock version,
- current chunk,
- current subchunk,
- completed chunks,
- blocked chunks,
- files created,
- files modified,
- validation completed,
- unresolved defects,
- source dependencies required by later chunks,
- Bedrock experimental requirements,
- next chunk,
- exact source packages/classes/resources to inspect next.

Never mark a chunk complete merely because files were generated.

---

## `SOURCE_INVENTORY.json`

Record every discovered source-side shipping component.

Each entry should include fields such as:

```json
{
  "source_id": "unique-source-key",
  "category": "entity",
  "source_paths": [
    "net/thebrokenscript/..."
  ],
  "resource_paths": [],
  "dependencies": [],
  "shipping_relevance": "runtime",
  "status": "uninspected"
}
```

This is how the project proves that source content was not silently skipped.

---

## `SOURCE_MAP.json`

Map source behavior to the Bedrock implementation:

```json
{
  "source_id": "entity.example",
  "source_paths": [
    "net/thebrokenscript/example/ExampleEntity.java"
  ],
  "bedrock_identifier": "thebrokenscript:example",
  "bedrock_files": [
    "BP/entities/example.json",
    "RP/entity/example.entity.json",
    "src/entities/example_controller.ts"
  ],
  "status": "ported",
  "parity": "high",
  "notes": ""
}
```

Allowed `status`:

- `uninspected`
- `analyzed`
- `in_progress`
- `ported`
- `validated`
- `blocked`

Allowed `parity`:

- `full`
- `high`
- `approximation`
- `unsupported`
- `unknown`

---

## `PARITY_MATRIX.md`

Every source feature must eventually appear here.

Minimum columns:

| Source Feature | Source Evidence | Bedrock Implementation | Status | Parity | Validation | Notes |
|---|---|---|---|---|---|---|

At final release there must be no unexplained `uninspected`, `unknown`, or `in_progress` entries.

---

## `ASSET_MAP.json`

Track every shipping asset and whether it is used:

- textures,
- models,
- animations,
- sounds,
- music,
- particles,
- structures,
- icons,
- UI assets,
- shader/render assets,
- localization.

Every relevant source asset must be either mapped to a Bedrock asset, intentionally converted, or documented as engine-inapplicable.

---

## `IDENTIFIER_MAP.json`

Track Java registry IDs and corresponding Bedrock IDs.

Never create identifiers ad hoc in multiple files.

---

# 10. Chunk 00 — Complete Source Inventory and Architecture Reconstruction

**Do not implement gameplay in this chunk.**

Inspect the entire supplied 2.0 source tree in bounded groups and build the inventory.

Identify at minimum:

- mod metadata,
- mod ID/version,
- Minecraft/NeoForge versions,
- dependencies,
- BrokenCore or other runtime-library dependencies,
- entry points,
- package hierarchy,
- registries,
- entities and variants,
- blocks,
- items,
- effects,
- particles,
- sounds/music,
- animation/model systems,
- dimensions,
- portals,
- biomes,
- features,
- structures,
- worldgen,
- events,
- AI,
- bosses,
- networking,
- configuration,
- commands,
- persistent/saved data,
- client-only systems,
- server/common systems,
- GUI/UI,
- progression,
- loot,
- recipes,
- tags,
- data-driven files,
- rendering/shader-related content,
- all assets.

For each major subsystem identify:

- entry points,
- dependencies,
- state,
- lifecycle,
- public identifiers,
- call graph boundaries,
- relevant resources.

Create:

- `SOURCE_INVENTORY.json`
- initial `SOURCE_MAP.json`
- initial `PARITY_MATRIX.md`
- `ASSET_MAP.json`
- `IDENTIFIER_MAP.json`
- `BEDROCK_ARCHITECTURE.md`
- `BEDROCK_COMPATIBILITY.md`
- a subsystem dependency graph
- a revised chunk/subchunk schedule based on what actually exists

The remainder of the supplied chunk plan is a starting structure. Modify the exact grouping when the source inventory proves a different dependency order is safer.

Chunk 00 is complete only after every shipping source package/resource family has an inventory entry.

---

# 11. Chunk 01 — Bedrock Project Foundation

Create the complete clean BP/RP project foundation.

Implement and validate:

- Behavior Pack manifest,
- Resource Pack manifest,
- unique UUIDs,
- exact BP→RP dependency,
- script module,
- supported `@minecraft/server` dependency,
- optional `@minecraft/server-ui` only if required,
- source TypeScript build pipeline if TypeScript is chosen,
- compiled JS deployment path,
- shared namespace/constants,
- bootstrap,
- logging,
- error containment,
- centralized event initialization,
- centralized scheduler,
- persistent-state service,
- runtime feature flags for genuinely experimental subsystems,
- build/package scripts,
- static validators.

Use stable manifest format 2 unless official documentation for the chosen target makes another stable format appropriate.

The pack must load as a minimal valid addon before this chunk is complete.

---

# 12. Chunk 02 — Shared Runtime and Persistence

Port source systems used by multiple gameplay subsystems:

- global state,
- world state,
- per-player state,
- dynamic properties,
- persistence,
- world-load initialization,
- join/leave lifecycle,
- death/respawn lifecycle,
- timers,
- cooldowns,
- weighted random utilities,
- spatial queries,
- safe entity references,
- target invalidation,
- dimension-aware state,
- shared event dispatch,
- encounter scheduling,
- configuration values that affect runtime behavior.

Prefer event-driven work over broad per-tick polling.

Do not start individual monsters until the shared runtime they depend on exists.

---

# 13. Chunk 03 — Asset and Client-Resource Foundation

Inventory and convert the reusable visual/audio resource foundation:

- texture organization,
- item texture atlas/registrations,
- block texture registrations,
- sound definitions,
- common sounds/music,
- shared geometry,
- material mappings,
- render-controller conventions,
- animation-controller conventions,
- particles,
- fog/client-biome resources where applicable,
- localization.

Preserve original assets when compatible.

When Java model formats are incompatible with Bedrock, convert/reconstruct the models while preserving:

- silhouette,
- dimensions,
- part layout,
- texture mapping,
- visible materials,
- animation pivots,
- intended pose.

Do not invent replacement art merely because conversion requires effort.

---

# 14. Chunk 04 — Entity Framework and Common AI Primitives

Before porting the full entity roster, port reusable entity infrastructure actually justified by the source:

- spawn/despawn policy,
- target selection,
- line-of-sight helpers,
- distance bands,
- navigation helpers,
- last-known-position memory,
- observation timers,
- investigation/search helpers,
- teleport safety/governance,
- damage helpers,
- scripted attacks,
- state-machine framework,
- sound/animation synchronization,
- dimension checks,
- multiplayer ownership/target rules,
- encounter cleanup.

Do not build abstractions the source does not need.

---

# 15. Chunks 05+ — Entity Families

Divide the complete discovered entity roster into coherent source-driven families.

Do not arbitrarily limit the entity count.

Every registered/shipping entity and meaningful variant must be assigned to one entity chunk.

For every entity inspect and port, as applicable:

- identity,
- role,
- attributes,
- health,
- damage,
- movement,
- navigation,
- physics,
- collision,
- spawn logic,
- despawn logic,
- target selection,
- awareness,
- visibility,
- line of sight,
- stalking,
- observation,
- investigation,
- search,
- pursuit,
- retreat,
- teleport rules,
- memory,
- escalation,
- adaptive behavior,
- attacks,
- special abilities,
- projectiles,
- invulnerability,
- transformations,
- phases,
- environmental reactions,
- interactions,
- death behavior,
- drops,
- sounds,
- particles,
- model,
- textures,
- materials,
- animations,
- animation controllers,
- render behavior,
- player-specific state,
- global state,
- multiplayer behavior,
- persistence.

Known names may include systems such as Circuit, Null, Integrity, Faraway, Siluet, Herobrine, Fractured, Fever, Chord, Tether, Nothing Is Watching, Broken End/TBE variants, and Void-related entities, but **do not rely on this list**. The source inventory determines the authoritative roster.

If an entity family is large, automatically create subchunks.

---

# 16. Dedicated Chunk — Psychological/Stalking Systems

Even if several entities use them, give sophisticated shared horror AI its own chunk when present in the source.

Reconstruct source behavior including as applicable:

- observation,
- stalking,
- visibility awareness,
- player awareness,
- last known position,
- imperfect information,
- investigation,
- search patterns,
- pursuit,
- hiding,
- distance pressure,
- retreat,
- disengagement,
- cooldown,
- escalation,
- teleport restrictions,
- environmental cues,
- fake signals,
- false appearances,
- player isolation,
- target switching,
- multiplayer target choice,
- adaptive behavior,
- learned pressure patterns.

Do not reduce sophisticated AI to:

```text
spawn -> nearest player -> chase -> attack
```

Do not give an entity perfect player information unless the source intentionally does so.

---

# 17. Dedicated Chunk — Bosses and Advanced Combat

Port all source bosses and boss-level combat systems.

For each:

- trigger/spawn conditions,
- arena assumptions,
- health,
- phases,
- thresholds,
- transitions,
- attacks,
- projectiles,
- AoE,
- status effects,
- summons,
- movement,
- targeting,
- invulnerability,
- scripted sequences,
- music,
- animation,
- camera effects,
- particles,
- death sequence,
- cleanup,
- drops,
- progression consequences,
- multiplayer scaling/target behavior if present.

Preserve phase semantics rather than replacing bosses with a single health pool and melee attack.

---

# 18. Dedicated Chunk — Blocks

Port **every registered/shipping block**.

For every block determine and implement as applicable:

- identifier,
- states/traits,
- permutations,
- placement,
- orientation,
- collision,
- selection box,
- geometry,
- materials/textures,
- destruction,
- loot/drop logic,
- interaction,
- scripted custom components,
- redstone,
- light/emission,
- liquid behavior,
- sounds,
- particles,
- scheduled/random ticking,
- environmental effects,
- associated state/persistence,
- worldgen use.

Validate against 1.26.10+ block schemas.

Do not silently turn functional blocks into decoration.

---

# 19. Dedicated Chunk — Items

Port **every registered/shipping item**.

For each item implement as applicable:

- identifier,
- stack behavior,
- icon/model,
- use behavior,
- use duration,
- cooldown,
- durability,
- food/consumable behavior,
- weapon/tool behavior,
- interactions,
- special abilities,
- scripted custom components,
- placement,
- projectiles,
- effects,
- progression role,
- portal role,
- boss role,
- recipes,
- loot integration.

Use current stable custom-item capabilities first; use scripting where the source behavior exceeds data-driven components.

---

# 20. Dedicated Chunk — Dimensions and Portals

Inventory every Java dimension/portal system before implementation.

For each dimension determine:

- source dimension identity,
- entry/exit conditions,
- portal rules,
- destination coordinates,
- world state,
- terrain/generation expectations,
- biome/environment,
- fog,
- sky/lighting identity,
- ambience/music,
- entity spawn rules,
- structures/features,
- player effects,
- death/respawn behavior,
- persistence,
- return behavior.

Important Bedrock rule:

If exact source behavior requires script-registered custom dimensions, use the official custom-dimension API only after confirming the current API status. These APIs are experimental in the current documented workflow. Encapsulate the beta dependency behind a dedicated dimension module and record the required world experiment in `BEDROCK_COMPATIBILITY.md`.

Do not remove a required dimension merely to keep the pack experiment-free.

If the source requires terrain beyond the current custom-dimension generator capability, reproduce the playable result through supported structures/features/scripted generation where possible and document the exact difference.

Port every portal with safe arrival loading and destination validation.

---

# 21. Dedicated Chunk — World Generation, Biomes, Features, and Structures

Port all source world-generation behavior that affects the shipping experience.

Map Java systems to Bedrock as appropriate:

- custom biome definitions/replacements,
- client-biome visuals/audio,
- feature JSON,
- feature rules,
- weighted/random features,
- scatter features,
- structure templates,
- `.mcstructure` content,
- jigsaw processors,
- template pools,
- jigsaw structures,
- structure sets,
- scripted placement,
- loot,
- dimension-specific placement.

Account for Bedrock’s terrain-generation limits.

Do not perform enormous uncontrolled runtime block loops when data-driven generation or structure placement can do the job safely.

Validate generated locations for:

- grounding,
- orientation,
- collisions,
- terrain integration,
- duplicates,
- inaccessible rooms,
- floating pieces,
- missing blocks,
- invalid custom block references.

---

# 22. Dedicated Chunk — Events, Horror Choreography, and Encounters

Port all source-driven:

- ambient events,
- random scares,
- scripted scares,
- player-specific events,
- global events,
- environmental changes,
- hallucination-like effects,
- fake signals,
- sound events,
- music events,
- entity appearances,
- disappearance events,
- screen/camera behavior,
- progression gates,
- cooldowns,
- rarity,
- probabilities,
- escalation rules,
- prerequisites,
- cleanup.

Use source constants/default configuration for timing/probability whenever available.

Do not rebalance simply because the Java numbers look unusual.

---

# 23. Dedicated Chunk — Progression, Recipes, Loot, Tags, and Commands

Port all remaining shipping progression/data systems:

- recipes,
- loot tables,
- item/block/entity tags,
- advancement-triggered logic translated into Bedrock state,
- unlocks,
- progression flags,
- custom commands exposed to players/admins,
- scripted interactions,
- hidden runtime state used by progression.

Do not port Java-only developer diagnostics unless they affect normal shipping gameplay.

---

# 24. Dedicated Chunk — Animation, Rendering, Audio, Camera, and UI

Complete presentation parity.

Port:

- entity animations,
- animation controllers,
- state-driven animations,
- procedural animation equivalents,
- render controllers,
- texture swaps,
- emissive behavior where supported,
- materials,
- particles,
- sound events,
- music,
- ambience,
- positional audio,
- fog,
- camera shake,
- camera attachment,
- camera animation/splines when justified by source behavior,
- gameplay UI/forms,
- titles/actionbar overlays,
- source-required screen effects,
- localization.

Bedrock 1.26.10 exposes stable camera attachment/animation APIs in `@minecraft/server` v2.6.0. Prefer the stable API for relevant horror/cinematic effects.

Do not add cinematic effects that are not present in the source.

---

# 25. Dedicated Chunk — Integration

Perform a cross-system integration pass.

Test interactions including:

- entities + events,
- entities + dimensions,
- entities + blocks,
- entities + items,
- items + portals,
- bosses + progression,
- events + progression,
- events + audio/camera,
- structures + worldgen,
- worldgen + custom blocks,
- dimensions + portals,
- death/respawn + dimensions,
- persistence + reload,
- player join/leave,
- multiplayer encounters,
- target invalidation,
- simultaneous players,
- entity cleanup,
- chunk unload/reload.

Fix integration defects at their responsible module rather than adding random compatibility hacks.

---

# 26. Dedicated Chunk — Multiplayer and Performance Audit

Audit every active runtime system for multiplayer and performance.

Check:

- per-tick work,
- broad entity queries,
- broad player queries,
- full-world scans,
- repeated command execution,
- repeated event registration,
- duplicated intervals,
- dynamic-property frequency,
- allocation churn,
- retained invalid entities,
- orphaned player state,
- leaked dimension state,
- unloaded-chunk access,
- excessive structure/block placement,
- runaway queues,
- duplicate encounter triggers.

Prefer:

- event-driven logic,
- bounded spatial queries,
- centralized schedulers,
- coarse update frequencies when behavior allows,
- stable ID references instead of indefinitely retained Entity objects,
- cleanup on invalidation/leave/death,
- server-authoritative state.

Do not “optimize” by deleting original mechanics.

---

# 27. Dedicated Chunk — Full Source Parity Audit

Return to `SOURCE_INVENTORY.json` and compare the entire Java source/resource inventory against the Bedrock project.

Perform all of the following:

1. Search for source classes never mapped.
2. Search for registry entries never mapped.
3. Search for assets never mapped.
4. Search for data files never mapped.
5. Search for events with no Bedrock implementation.
6. Search for config values with no consuming implementation.
7. Search for Bedrock identifiers with unresolved references.
8. Search for placeholder/stub code.
9. Search for parity entries still marked `unknown`, `uninspected`, or `in_progress`.
10. Reinspect all `approximation` and `unsupported` entries.

The full port is **not ready** if any shipping source feature vanished without explanation.

---

# 28. Dedicated Chunk — Final Validation

Run the strongest available static and runtime checks.

At minimum verify:

## Pack/manifest
- JSON validity.
- unique UUIDs.
- BP/RP dependency correctness.
- script module entry.
- Script API dependency versions.
- minimum engine version.
- no accidental preview-only manifest use.

## Behavior Pack
- entities.
- spawn rules.
- blocks.
- items.
- recipes.
- loot.
- functions.
- features.
- feature rules.
- structures.
- dimensions.
- scripts.
- dynamic-property/state initialization.

## Resource Pack
- client entities.
- models/geometries.
- textures.
- texture registrations.
- materials.
- render controllers.
- animations.
- animation controllers.
- particles.
- sounds.
- sound definitions.
- fog/client-biome resources.
- localization.

## References
- no missing textures.
- no missing geometry.
- no missing animations.
- no missing animation controllers.
- no missing render controllers.
- no unresolved sound IDs.
- no unknown item/block/entity IDs.
- no broken structure references.

## Script
- syntax/build passes.
- no unresolved imports.
- no duplicate event initialization.
- no invalid API calls for the selected version.
- no unhandled startup errors.
- safe world reload behavior.
- safe invalid-entity handling.

## Runtime when Minecraft is available
- import succeeds.
- pack activation succeeds.
- no blocking content-log errors.
- script starts.
- representative entities spawn and behave.
- portals work.
- dimensions work.
- structures/worldgen work.
- progression survives save/reload.
- multiplayer smoke test passes.

Treat content-log/schema errors as real defects unless proven otherwise.

---

# 29. Final Packaging Chunk

Only after the parity and validation chunks pass:

1. Remove temporary analysis/build artifacts from shipping packs.
2. Keep required license/attribution material.
3. Ensure BP and RP versioning are correct.
4. Package both packs into one valid `.mcaddon`.
5. Re-open/test the final archive structure.
6. Generate:
   - `FINAL_PARITY_REPORT.md`
   - `FINAL_VALIDATION_REPORT.md`
   - `INSTALLATION.md`
   - `KNOWN_LIMITATIONS.md`
7. Deliver the final `.mcaddon`.

The final archive must contain the actual working BP/RP, not source-only project files.

---

# 30. Per-Chunk Engineering Procedure

For every implementation chunk:

## A. Inspect

Before editing, read every directly relevant source class/resource and trace its dependencies.

Record:

- inputs,
- outputs,
- state,
- lifecycle,
- events,
- constants,
- timing,
- probabilities,
- config dependencies,
- client/server distinctions,
- resource dependencies.

## B. Specify

Create:

`docs/chunks/CHUNK_XX_SPEC.md`

or for a subchunk:

`docs/chunks/CHUNK_XXA_SPEC.md`

The spec must identify:

- exact source files inspected,
- exact behavior discovered,
- Bedrock files to create/modify,
- required interfaces,
- Bedrock API/schema requirements,
- stable vs experimental dependencies,
- expected tests,
- expected parity.

## C. Implement

Implement **only** the current chunk.

Do not begin unrelated later systems.

## D. Validate

Run applicable:

- JSON parsing,
- schema/static checks,
- JavaScript/TypeScript build,
- identifier validation,
- reference graph validation,
- texture/model/audio reference checks,
- pack validators,
- Minecraft runtime test when available.

## E. Source-Parity Review

Re-read the relevant source after implementation.

Look specifically for behavior lost during translation.

## F. Update Persistent State

Update:

- `PORT_PROGRESS.md`
- `SOURCE_INVENTORY.json`
- `SOURCE_MAP.json`
- `PARITY_MATRIX.md`
- `BEDROCK_ARCHITECTURE.md`
- `BEDROCK_COMPATIBILITY.md`
- `ADAPTATION_NOTES.md`
- `VALIDATION_LOG.md`
- `KNOWN_LIMITATIONS.md`
- `ASSET_MAP.json`
- `IDENTIFIER_MAP.json`

## G. Report

Create:

`docs/chunks/CHUNK_XX_REPORT.md`

Include:

- source examined,
- implementation completed,
- files created,
- files modified,
- validation commands/checks,
- validation results,
- parity status,
- adaptations,
- unresolved defects,
- next chunk prerequisites.

Then stop.

---

# 31. Chunk Completion Gate

A chunk is complete only if all applicable conditions are true:

1. Relevant source was inspected.
2. Source behavior was documented.
3. Required Bedrock implementation exists.
4. No known required behavior is left as a hidden stub.
5. References resolve.
6. Static validation passes.
7. Runtime validation was performed when available.
8. Source parity was reviewed after implementation.
9. Persistent state files were updated.
10. Chunk report was written.

If one of these conditions fails, the chunk remains `in_progress` or `blocked`.

---

# 32. No Placeholder / No Fake-Completion Rule

Do not leave:

- `TODO`
- `FIXME`
- empty implementations
- dummy state handlers
- placeholder entities
- placeholder textures
- fake success returns
- nonfunctional portals
- unimplemented boss phases
- “temporary” melee-only AI replacing complex behavior
- comments claiming a later chunk will magically complete required current behavior

When a later subsystem is genuinely required, define the interface/dependency and mark the current feature as blocked or partial in the parity ledger.

Never label it complete.

---

# 33. AI Fidelity Rule

If the source entity includes sophisticated horror AI, preserve the logic rather than simplifying it.

Use explicit state machines where appropriate.

Possible states may include:

```text
DORMANT
OBSERVING
STALKING
INVESTIGATING
PRESSURING
HUNTING
SEARCHING
RETREATING
COOLDOWN
```

These are conceptual examples only.

Use only states justified by the actual source.

Preserve source behavior such as:

- imperfect information,
- memory,
- line of sight,
- last-known location,
- probabilistic choices,
- delayed reaction,
- cooldowns,
- escalation,
- false appearances,
- disengagement,
- teleport governance,
- environment checks.

---

# 34. Multiplayer Rule

Assume multiplayer unless the source explicitly establishes single-player-only behavior.

For every major system audit:

- player ownership,
- target selection,
- per-player state,
- world-global state,
- simultaneous encounters,
- player join,
- player leave,
- death,
- respawn,
- dimension transfer,
- disconnect during encounter,
- invalid targets,
- two players triggering the same event,
- cleanup.

Do not store raw player/entity references indefinitely when stable IDs/state can be used safely.

---

# 35. Adaptation Rule

When exact parity is impossible, write an entry in `ADAPTATION_NOTES.md` containing:

1. source feature,
2. source behavior,
3. source evidence,
4. Bedrock limitation,
5. official Creator documentation checked,
6. Bedrock replacement design,
7. expected player-visible difference,
8. parity classification.

Never silently omit or redesign a mechanic.

---

# 36. Preservation Rule

Do not arbitrarily change:

- names,
- entity identities,
- roles,
- textures,
- music,
- sounds,
- models,
- animation intent,
- health,
- damage,
- timing,
- probabilities,
- progression,
- dimension identity,
- portal behavior,
- boss phases,
- horror pacing.

Only change a value/behavior when:

- source evidence requires it, or
- Bedrock cannot reproduce the original directly.

Document engine-driven adaptations.

---

# 37. Scope Rule

Do not:

- invent monsters,
- add fan-made lore,
- redesign the story,
- add unrelated items,
- add unrelated dimensions,
- rebalance without source evidence,
- replace original assets merely for style,
- convert the project into a generic horror addon,
- remove difficult mechanics to save time.

The target is specifically:

**The Broken Script 2.0 faithfully ported to Minecraft Bedrock.**

---

# 38. Progress Updates During a Chunk

When the execution is long, provide short progress updates after meaningful milestones.

Useful updates include:

- source family inspected,
- architecture discovered,
- first validated implementation result,
- important parity blocker,
- validation status.

Do not spam low-level file operations.

Do not promise future/background work.

Finish the current chunk within the current execution or clearly mark what blocked it.

---

# 39. End-of-Execution Response Contract

At the end of each execution, respond with:

## Chunk
`Chunk XX — Name`

## Source Inspected
Concise list of the primary source packages/classes/resources used.

## Implemented
Concise list.

## Validation
Checks run and outcomes.

## Parity
`full`, `high`, `approximation`, or `blocked`, with only material caveats.

## Files
Important created/modified files.

## Remaining Defects
Only actual unresolved defects.

## Next Chunk
`Chunk YY — Name`

## Resume Instruction

Return a short paste-ready continuation instruction:

> Read `PORT_PROGRESS.md`, `SOURCE_INVENTORY.json`, `SOURCE_MAP.json`, `PARITY_MATRIX.md`, `BEDROCK_COMPATIBILITY.md`, and the next chunk's source references. Continue with Chunk YY only. Preserve all completed work, validate the new chunk, update the persistent state files, and stop before beginning another chunk.

Then **STOP**.

Do not start the next chunk automatically.

---

# 40. First Execution

Start with:

**Chunk 00 — Complete Source Inventory and Architecture Reconstruction**

Do not create gameplay implementations yet.

First establish exactly what The Broken Script 2.0 contains and how its major systems depend on each other.

Inspect actual source contents rather than inferring functionality from filenames.

At the end of Chunk 00, every shipping source package/resource family must be represented in `SOURCE_INVENTORY.json`, and the later chunk schedule must be revised so that completing every chunk produces the entire port.

The project is not finished until:

- every shipping source feature is accounted for,
- every non-engine-blocked feature is implemented,
- every implemented feature is validated,
- all parity gaps are documented,
- final integration passes,
- final packaging passes,
- and a valid `.mcaddon` is produced.
