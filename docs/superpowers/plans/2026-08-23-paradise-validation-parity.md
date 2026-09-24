# Paradise.exe Validation Parity Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Port the validation layers used by `PastaHimself/Paradise.exe` to TBS 2.0 while preserving TBS's existing Mojang Creator Tools validation and `tools/package-addon.sh` packaging flow.

**Architecture:** Keep validation as independent CI layers. Python tools validate pack-wide structure, semantic RP links, and Bedrock `.mcstructure` NBT; Node/TypeScript validates JavaScript syntax and Script API typing; the Paradise-derived Blockception LSP client performs schema/project diagnostics; Mojang Creator Tools remains the final Bedrock-specific static validator before packaging.

**Tech Stack:** Python 3.12 `unittest`, Node.js 22, TypeScript 5.9, `@minecraft/server` beta typings, Blockception Minecraft Bedrock language server, Mojang `@minecraft/creator-tools@0.17.7`, GitHub Actions.

---

## Task 1: Add failing validator tests first

**Files:**
- Create: `tests/test_full_addon_validator.py`
- Create: `tests/test_resource_link_validator.py`
- Create: `tests/test_mcstructure_validator.py`

- [ ] Port Paradise.exe's Python validator tests and adapt only repository paths/names from `addon/Genshin X Craft BP` / `addon/Genshin X Craft RP` to `TheBrokenScript_Bedrock_2_0/BP` / `TheBrokenScript_Bedrock_2_0/RP`.
- [ ] Use deterministic temporary BP/RP fixtures. Cover valid manifests, invalid JSON, missing relative imports, BP-to-RP dependency mismatch, local texture resolution, vanilla texture fallback, structure reference resolution, geometry/animation/controller/render-controller links, and malformed/valid little-endian NBT structures.
- [ ] Verify RED with `python -m unittest discover -s tests -p 'test_*.py' -v`; expected failure is that the three `tools/validate_*.py` modules do not exist yet.
- [ ] Commit the tests before adding validator implementation.

## Task 2: Port the Paradise.exe Python validators

**Files:**
- Create: `tools/validate_addon.py`
- Create: `tools/validate_resource_links.py`
- Create: `tools/validate_mcstructures.py`

- [ ] Port `tools/validate_addon.py` from Paradise.exe. Set the add-on root to `TheBrokenScript_Bedrock_2_0`, BP to `BP`, and RP to `RP`. Preserve Paradise.exe checks for JSON parsing, manifest UUID/version/module validity, BP→RP dependency matching, script entry/import resolution, structure references, required local textures, sound files, PNG signatures, and non-empty sound assets.
- [ ] Port `tools/validate_resource_links.py` from Paradise.exe. Scan `TheBrokenScript_Bedrock_2_0/RP` and preserve the same custom geometry, animation, animation-controller, and render-controller resolution behavior plus vanilla/base-pack fallback behavior.
- [ ] Port `tools/validate_mcstructures.py` from Paradise.exe. Change only the structure tree root to `TheBrokenScript_Bedrock_2_0/BP/structures`; preserve the little-endian NBT parser and Bedrock safety/integrity checks.
- [ ] Verify GREEN with `python -m unittest discover -s tests -p 'test_*.py' -v`.
- [ ] Run each validator against the actual repository with reports: `python tools/validate_addon.py --report artifacts/addon-validation.json`, `python tools/validate_resource_links.py --report artifacts/resource-link-validation.json`, and `python tools/validate_mcstructures.py --report artifacts/mcstructure-validation.json`.

## Task 3: Add Paradise-style Node/TypeScript validation

**Files:**
- Create: `package.json`
- Create: `tsconfig.json`
- Create: `tests/addon_layout.test.mjs`

- [ ] Add the Paradise.exe package scripts: `npm test` uses Node's built-in test runner and `npm run typecheck` uses `tsc --project tsconfig.json`.
- [ ] Add `@minecraft/server` beta typings and TypeScript `^5.9.3`. TBS currently does not import `@minecraft/server-ui`, so do not add an unused dependency.
- [ ] Copy Paradise.exe's compiler settings and set the include path to `TheBrokenScript_Bedrock_2_0/BP/scripts/**/*.js`.
- [ ] Add deterministic Node regression tests proving BP/RP manifests exist, the manifest script entry resolves, and the BP dependency matches the RP UUID/version.
- [ ] Verify with `npm install --ignore-scripts --no-audit --no-fund`, `npm test`, and `npm run typecheck`.

## Task 4: Port the Paradise.exe Blockception diagnostic client

**Files:**
- Create: `tools/run_blockception_lsp_check.mjs`

- [ ] Copy the Paradise.exe LSP client implementation.
- [ ] Change the client name to `The Broken Script 2.0 GitHub Actions Bedrock checker`.
- [ ] Default/check workspace paths for `TheBrokenScript_Bedrock_2_0`.
- [ ] Adapt Paradise-specific resource-pack path predicates to TBS's `RP` layout. Keep any false-positive allowance exact and narrow; do not suppress unrelated diagnostics.
- [ ] Preserve JSON reporting, GitHub annotations, blocking-error behavior, timeout handling, and clean LSP shutdown.

## Task 5: Integrate the complete stack into GitHub Actions

**Files:**
- Modify: `.github/workflows/bedrock-addon-check.yml`

- [ ] Preserve the current triggers, permissions, concurrency, existing MCT validation, narrow MCT self-comparison false-positive handling, Bash packaging, and `.mcaddon` artifact name.
- [ ] Add Python 3.12 setup and dependency install after checkout/Node setup.
- [ ] Run Python validator unit tests before the production validators.
- [ ] Run `validate_addon.py`, `validate_resource_links.py`, and `validate_mcstructures.py` with JSON reports under `artifacts/`.
- [ ] Keep JavaScript syntax checks and add `npm run typecheck` plus `npm test`.
- [ ] Check out/build `Blockception/minecraft-bedrock-language-server` and run `tools/run_blockception_lsp_check.mjs --server .blockception/minecraft-bedrock-language-server/ide/vscode/lsp/server.js --workspace TheBrokenScript_Bedrock_2_0 --report artifacts/blockception-lsp-diagnostics.json`.
- [ ] Keep MCT validation after the added validation layers and copy its JSON output to `artifacts/mct-validation.json`.
- [ ] Keep `bash tools/package-addon.sh` and `dist/The_Broken_Script_2_0.mcaddon` upload behavior.
- [ ] Add an `if: always()` upload for `artifacts/*.json`.
- [ ] Raise the job timeout to 30 minutes for the added Blockception build/diagnostics.

## Task 6: PR verification and fixes

- [ ] Open a PR from `paradise-validation-parity` to `main`.
- [ ] Inspect every GitHub Actions job/step and its logs.
- [ ] If validation exposes real TBS add-on defects, fix only defects required for the new validation stack to pass; do not weaken validators to hide them.
- [ ] If a third-party validator produces a demonstrated false positive, use the same Paradise.exe policy: allow only an exact, documented case rather than broad suppression.
- [ ] Re-run until the PR validation workflow is green, then review the final diff before reporting completion.
