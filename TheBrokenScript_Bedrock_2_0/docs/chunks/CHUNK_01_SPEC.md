# CHUNK_01_SPEC — Bedrock Project Foundation

## Source basis
- Mod identity: `neoforge.mods.toml` (modId `thebrokenscript`, v2.0.0, display name "The Broken Script", license All Rights Reserved).
- Platform rules: BEDROCK_COMPATIBILITY.md (manifest format 2; `@minecraft/server` 2.6.0 @ min-engine 1.26.10; script language javascript only).
- No gameplay content in this chunk.

## Behavior discovered / requirements
Foundation must provide the runtime skeleton every later chunk imports:
bootstrap → logging → error containment → scheduler → centralized events → persistent state → config layer → feature flags → identifier constants.

## Bedrock files to create
```
BP/manifest.json            format 2; header + data module + script module (entry scripts/main.js)
BP/dependencies             RP header uuid 82fc6a1e-… version [2,0,0]; @minecraft/server "2.6.0"
BP/pack_icon.png            generated meta-asset (not gameplay art)
BP/texts/en_US.lang         pack.name/pack.description
RP/manifest.json            format 2; resources module
RP/pack_icon.png, RP/texts/en_US.lang
src/main.js                 entry: startup/world-load init sequence, error-contained
src/core/logging.js         leveled logger with tbs prefix + log throttling
src/core/errors.js          guard()/tryAsync error containment boundaries
src/core/scheduler.js       named interval/timeout registry, budgets, duplicate-registration guards
src/core/events.js          centralized event subscription registry (idempotent)
src/core/state.js           namespaced dynamic-property persistence service (world/player scopes)
src/core/config.js          config layer seeded from source-derived defaults (values filled per-chunk as decompiled constants land)
src/core/flags.js           runtime feature flags (experimental isolation, e.g. custom-dimension beta path)
src/shared/ids.js           namespace + identifier constants mirroring IDENTIFIER_MAP.json
```

## UUID allocation (recorded in IDENTIFIER_MAP.json)
| Role | UUID |
|---|---|
| BP header | a7728576-fbb9-44e9-8bf0-a5342d135e18 |
| BP data module | f9cd1e05-fe74-49f9-92a0-c32fcb6de7b8 |
| BP script module | ac50eb52-3224-4d98-8375-2d2f471bfc78 |
| RP header | 82fc6a1e-7feb-42bc-8d01-5a58f76a0f70 |
| RP resources module | 7a1b3141-6c97-424d-95b1-41bf784aa1df |

Versions: packs `[2,0,0]` (mirrors mod 2.0.0); `min_engine_version [1,26,10]`.

## Build pipeline decision
Node.js/tsc unavailable → author deployable ES-module JavaScript under `src/`; `tools/sync_scripts.ps1` mirrors into `BP/scripts/`. TypeScript upgrade path documented; no transpilation required by Bedrock for plain ESM.

## Tooling/scripts to create
- `tools/sync_scripts.ps1` — copy src/**/*.js → BP/scripts/
- `tools/validate_pack.ps1` — JSON validity; unique UUIDs; BP dep == RP header uuid+version; script entry exists; no `-beta` script deps outside allowlist; lang files parse; icon presence

## Expected tests
1. All JSON parses.
2. Validator passes with zero errors.
3. JS syntax check of every src file (PowerShell-hosted check via node absent → structural lint: balanced braces heuristic + import-path existence resolution).

## Expected parity
Infrastructure only — parity ledger unaffected except foundation row marked ported after validation.
