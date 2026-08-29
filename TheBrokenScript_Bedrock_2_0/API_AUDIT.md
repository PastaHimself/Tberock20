# Bedrock API Audit

Reviewed: 2026-08-29

This ledger records the API baseline for the shipping behavior pack. It is intentionally conservative: preview/beta APIs must not become a default dependency merely to preserve a Java-only implementation detail.

## Shipping baseline

- Bedrock minimum engine: `1.26.40`.
- `@minecraft/server`: `2.9.0` stable.
- `@minecraft/server-ui`: `2.1.0` stable.
- The shipping manifest must not contain `-beta`, `-preview`, `-rc`, or `-internal` Script API module versions.
- Preview APIs, if ever needed for an optional experiment-only build, must live behind a separate opt-in manifest/build path and must not be required by the normal add-on.

## Reviewed API decisions

| Surface | Decision | Reason |
|---|---|---|
| `system.beforeEvents.startup` | Stable / allowed | Startup registration is available on the stable Script API surface. |
| `StartupEvent.blockComponentRegistry` | Stable / allowed | Custom block component registration is available without forcing a beta module. |
| `StartupEvent.itemComponentRegistry` | Stable / allowed | Custom item component registration is available on the stable startup event. |
| `world.getDimension(...)` | Stable / allowed | Static behavior-pack dimension definitions are resolved through the stable world API. |
| `world.createDimension(...)` | Banned in shipping scripts | The previous compatibility fallback was not part of the reviewed stable `World` surface and forced the project toward preview assumptions. Custom dimensions must be defined by pack content and resolved with `world.getDimension`. |
| Native Jigsaw worldgen | Stable / preferred | Shaft generation now uses `worldgen/template_pools`, `worldgen/structures`, and `worldgen/structure_sets` with the source-backed structure templates instead of a block-by-block Script API reconstruction. |

## Automated audit

Run:

```bash
python tools/audit_bedrock_stable.py
```

The audit fails when:

- the behavior-pack manifest uses a preview/beta Script API dependency;
- `@minecraft/server` is older than the reviewed stable baseline;
- a known preview-only compatibility pattern such as `world.createDimension(...)` returns;
- native Jigsaw references or generation settings fail `tools/validate_jigsaw_worldgen.py`.

A newer stable `@minecraft/server` version is reported as a warning until this ledger is reviewed against the current first-party API documentation.

## Structure API/worldgen notes

The six staged Shaft NBT templates are source-backed and are now connected through native Jigsaw data. The current template weights, structure-set frequency, start height, depth, and terrain-adaptation values are **not yet source-verified** because the decompiled authoritative Java source tree referenced by the port goal is not present in this Git repository. They therefore remain an approximation and must not be promoted to full parity until the source placement logic is restored and survival-world generation is tested.

## Remaining audit work

- Run the stable audit against the complete checked-out branch in a local environment or Minecraft development workspace.
- Runtime-load the behavior/resource packs on Bedrock stable with Beta APIs disabled.
- Exercise startup registration, persistence, custom dimensions, native Shaft generation, multiplayer joins/leaves, and boss/event systems.
- Re-review the dependency baseline whenever the minimum engine version or Script API module version changes.

## References

- Microsoft Learn: Minecraft Creator Script API versioning and stable `@minecraft/server` documentation.
- Microsoft Learn: Jigsaw Structures and StructureManager documentation.
- Bedrock Wiki: Jigsaw Structures world-generation documentation.
