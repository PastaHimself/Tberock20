# Parity ledger reconciliation

Audit date: **2026-09-15**  
Repository baseline: `4956a0575da28cbec161773d8b7c4ef947b41550`  
Source inventory: `SOURCE_INVENTORY.json`  
Component ledger: `SOURCE_MAP.json`

## Method

The audit treats `BP/` and `RP/` as the deployed add-on and therefore the
shipping authority. The authoring `src/` tree is useful source context, but it
is not substituted for the deployed copy when the two differ. This matters for
the integrated Chunk 38 story-book adapter, which is currently present in
`BP/scripts/`.

`tools/reconcile_parity_ledgers.py` performs these checks before it writes a
decision:

1. `SOURCE_MAP.json` and `SOURCE_INVENTORY.json` each contain exactly 912 rows
   in the same order with the same source IDs.
2. Current entity, block, item, recipe, biome, particle, structure, script,
   and resource files are inspected from the live BP/RP tree.
3. The current horror-event `H` handlers and weighted `TABLE` are parsed from
   `BP/scripts/systems/horror_events.js`; handler/table drift is a failure.
4. Every row gets a terminal status/parity pair and at least one existing
   Bedrock-side artifact or evidence document. Missing evidence is a failure.
5. Source-only, Java-only, and engine-limited behavior is recorded as
   `blocked` or `excluded` with a reason. It is never silently converted to an
   exact port.

Run `python tools/reconcile_parity_ledgers.py --write` only when intentionally
refreshing the ledger. CI and reviewers should use
`python tools/reconcile_parity_ledgers.py --check`.

## Decision vocabulary

| Status | Parity | Meaning |
|---|---|---|
| `ported` | `full` | The source inventory row resolves to a matching current resource-level artifact, such as a recipe or sound-definition entry. |
| `ported` | `high` | The source contract is represented by a current runtime/resource implementation with focused evidence and only bounded engine adaptations. |
| `ported` | `approximation` | A current implementation or adapter exists, but behavior, rendering, scheduling, or registration differs from Java and the difference is documented. |
| `blocked` | `unsupported` | The exact Java mechanism is outside the Bedrock pack/API boundary; the closest supported adapter, if any, is listed as evidence. |
| `excluded` | `full` | The row is intentionally not runtime content, such as a build artifact, inactive marker, parsed source binary, or vanilla helper. |
| `excluded` | `unsupported` | The row is source-only, opaque, optional/out-of-pack, or tied to an unavailable Java/OS mechanism. |

## Reconciled snapshot

The 912 source IDs resolve as follows:

| Measure | Current result |
|---|---:|
| Source-map rows | 912 |
| Inventory/map ID mismatches | 0 |
| Unresolved status/parity values | 0 |
| `ported/full` | 42 |
| `ported/high` | 25 |
| `ported/approximation` | 758 |
| `blocked/unsupported` | 61 |
| `excluded/full` | 13 |
| `excluded/unsupported` | 13 |

Current deployed tree evidence includes:

- 69 BP/RP entity pairs;
- 125 BP block JSON files, covering 123 source block rows plus the two void-goop
  forms;
- 78 BP item JSON files, covering 76 direct source items plus Bedrock-only
  additions and 123 implicit block-item forms;
- 40 recipes, 15 biomes, 6 Shaft NBT templates, and 126 loot files;
- 72 BP JavaScript files, 34 current RP animation JSON files plus one retained
  `.old` source artifact, 181 OGG files, and 266 PNG files;
- 13 logical custom dimensions registered by the startup Script API rather than
  static `BP/dimensions` files; and
- 86 current source-backed horror-event H entries, plus the story-threshold and
  source-only decisions needed to reconcile the remaining source rows.

## Deliberate exceptions

- `entity.nothingiswatching` maps to the current `thebrokenscript:niw` BP/RP
  pair. `entity.fake_player` is `blocked/unsupported` because the Java entity
  requires GameProfile/skin/session and client-packet behavior. `entity.liberty`
  is `excluded/full` because the source `LibrarianHandler` creates a vanilla
  Allay named Liberty rather than a TBS registry entity.
- The current chat runtime carries all 42 ordered source response contracts. The source inventory row
  records the separate 45-response registration surface; the chat audit does
  not treat those counts as the same denominator.
- Five story event rows are represented by the current story clock/state/book
  adapters. Ten other source-only event keys are explicitly excluded or
  unsupported because they are not in the live `H`/`TABLE` pool or require
  desktop/shader/interface behavior.
- Void liquid, custom damage types, custom effects, painting variants, Java
  shaders, desktop integration, packet hooks, and Java noise/generator hooks
  remain explicit approximations or engine-unsupported decisions. See
  `KNOWN_LIMITATIONS.md` and `ADAPTATION_NOTES.md` for the detailed boundaries.
- Tags are represented by current script predicates/component checks; the audit
  does not invent a missing BP tag directory. Unused source markers and opaque
  external files are excluded rather than counted as runtime ports.

## API evidence used for the boundary decisions

The native damage adapter is based on the supported Bedrock shape where
`Entity.applyDamage` accepts a native damage cause and optional damaging entity;
the current runtime preserves the source catalog separately because a Java
custom damage-type registry is not exposed by that API. See [Microsoft Learn:
EntityApplyDamageOptions](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityapplydamageoptions?view=minecraft-bedrock-stable).

The daylight-cycle check is now implemented through the documented Bedrock
`GameRules` surface: `doDayLightCycle` is a readable boolean. The deployed and
authoring story clocks pass that value through the source-backed tick model,
which pauses dispatch when false and preserves Java's no-player persisted-time
behavior when true. See [Microsoft Learn: GameRules](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/gamerules?view=minecraft-bedrock-stable)
and [Microsoft Learn: World](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/world?view=minecraft-bedrock-stable).

The stable `Entity.applyDamage` contract and native damage-cause model were
cross-checked against the connected Bedrock Wiki reference for the pinned
1.26.50 target during this audit.

## Validation gate

The PR workflow runs the reconciliation before the existing add-on checks:

```text
python tools/reconcile_parity_ledgers.py --check
python tools/validate_parity_ledgers.py
python tools/validate_parity_source_map.py
python tools/validate_source_map_release.py
```

The family matrix parser now rejects malformed rows and unresolved/unsupported
rollup pairs. The release validator continues to reject unresolved source-map
statuses, so a future change must update the ledger and its evidence in the
same change.
