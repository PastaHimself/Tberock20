# Bedrock Script API Contract Audit

Reviewed: 2026-09-10

This ledger records the version contract that the repository actually targets. It is evidence-driven: the current manifests, development typings, regression tests, CI workflow, and post-audit history take precedence over the abandoned stable-migration notes that previously remained in this file.

## Authoritative target contract

- **Minecraft runtime channel:** the **1.26.50 preview line** that provides `@minecraft/server` `2.11.0-beta`.
- **Manifest engine floor:** BP and RP both use `min_engine_version: [1, 26, 50]`.
- **Runtime `@minecraft/server`:** `2.11.0-beta` in the BP manifest.
- **Development/CI `@minecraft/server` typings:** exactly `2.11.0-beta.1.26.50-preview.26`.
- **Runtime `@minecraft/server-ui`:** stable `2.1.0` in the BP manifest.
- **Development/CI `@minecraft/server-ui` typings:** exactly `2.3.0-beta.1.26.50-preview.26`, matching the pinned preview server peer used for type checking.
- **Required world experiment:** **Beta APIs** must be enabled because the shipping behavior pack declares a `-beta` Script API dependency.
- **No open-ended `1.26.50+` compatibility promise:** Microsoft documents that beta modules do not provide semantic-versioning backwards compatibility and may require a dependency update at each major Minecraft release. Any move off the 1.26.50 preview line must re-audit the module versions and API surface first.

The exact `preview.26` build is **confirmed for development/CI typings** by `package.json` and the regression tests. The manifest intentionally uses the runtime module version `2.11.0-beta`, so support for any other 1.26.50 preview build is **not inferred** here without a runtime validation result for that build.

## Repository evidence

### Confirmed current state

- `BP/manifest.json` declares `@minecraft/server` `2.11.0-beta`, `@minecraft/server-ui` `2.1.0`, and minimum engine `[1, 26, 50]`.
- `RP/manifest.json` also declares minimum engine `[1, 26, 50]`.
- `package.json` pins `@minecraft/server` `2.11.0-beta.1.26.50-preview.26` and `@minecraft/server-ui` `2.3.0-beta.1.26.50-preview.26` for development/type checking.
- `tests/beta_module_alignment.test.mjs` locks the runtime beta module, exact preview typings, engine floor, and beta-labeled CI workflow.
- `tests/api_alignment_regressions.test.mjs` locks the BP/RP engine-floor match and the stable-runtime/preview-typing split for `@minecraft/server-ui`.
- `tests/beta_script_api_compatibility.test.mjs` rejects API shapes that were removed or changed on the selected beta line.
- `.github/workflows/bedrock-addon-check.yml` installs the pinned beta typings and type-checks all behavior scripts against them.
- The current `main` validation workflow at audit time completed successfully through repository validators, JavaScript syntax checks, beta API type checking, JavaScript regressions, Blockception diagnostics, Mojang Creator Tools validation, and `.mcaddon` packaging.

### History that resolves the prior ambiguity

The 2026-08-29 history contains a short-lived attempt to move the pack to stable `@minecraft/server` `2.9.0` and to add a stable-only audit. That attempt is not the final repository contract:

- PR #9 explicitly states that the Behavior Pack was aligned with the **beta Script API definitions used by CI** before merge.
- Subsequent port work restored `@minecraft/server` `2.11.0-beta` in the manifest and added beta-compatibility fixes.
- On 2026-09-08, commits `61e529e` and `853380e` deliberately aligned `@minecraft/server-ui` preview typings and added exact regression expectations for the 1.26.50 preview packages.
- Current `main` therefore contains newer, executable evidence for the beta contract than the old stable-only prose and audit script.

The obsolete `tools/audit_bedrock_stable.py` is removed as part of resolving this contract. Its stable-only policy contradicted the current manifests and tests and was not invoked by the active CI workflow.

## Official API/version reconciliation

Microsoft's Script Module Versioning documentation defines stable modules as unsuffixed semver releases and beta modules as `-beta` releases with no backwards-compatibility guarantee. It also states that worlds using beta APIs must enable the **Beta APIs** experiment and recommends versioned npm declarations as the definitive development type surface.

The current Microsoft Creator documentation has already advanced beyond this repository's target: it lists `@minecraft/server` `2.9.0` as stable and a newer 1.26.60 preview beta line. That does not make the repository's historical 1.26.50 preview pin invalid; it means the pin must not be generalized to later Minecraft releases without an explicit migration.

Relevant used surfaces are not all beta-only. For example, current documentation places `ItemBookComponent` in stable `@minecraft/server` 2.x, `Entity.addItem` in stable 2.7.0, and `SoundInstance.stop` in stable 2.9.0. Therefore this task does **not** claim that every gameplay feature intrinsically requires beta. The beta channel is selected because the repository's current executable contract and compatibility fixes explicitly target that ABI; changing the gameplay code to a stable ABI would be a separate migration task.

`@minecraft/server-ui` is intentionally different: the in-game manifest remains on stable `2.1.0`, while development uses the 1.26.50 preview declaration package that is compatible with the pinned preview `@minecraft/server` peer. This is a typing/peer alignment, not a claim that the UI calls themselves require beta at runtime.

Custom-dimension APIs were promoted to stable in `@minecraft/server` 2.8.0 / Minecraft 1.26.30. No separate custom-dimension experiment is inferred from the Script API contract. The **Beta APIs** experiment remains mandatory solely because the shipping manifest itself depends on `@minecraft/server` `2.11.0-beta`.

## Contract validation

The contract is enforced by existing tests and the active CI workflow rather than a second, conflicting policy script:

```bash
npm install --ignore-scripts --no-audit --no-fund
npm run typecheck
npm test
python -m unittest discover -s tests -p 'test_*.py' -v
python tools/validate_addon.py --report artifacts/addon-validation.json
python tools/validate_resource_links.py --report artifacts/resource-link-validation.json
python tools/validate_jigsaw_worldgen.py
python tools/validate_jigsaw_nbt_connectors.py
python tools/validate_mcstructures.py --report artifacts/mcstructure-validation.json
```

The workflow additionally runs `node --check` over every behavior-pack JavaScript file, Blockception diagnostics, Mojang Minecraft Creator Tools validation, and production `.mcaddon` packaging.

## Upgrade rule

Do not silently replace the beta dependency with a stable release or bump it to a later preview. A future version migration must, at minimum:

1. choose the new Minecraft product build from repository requirements rather than package recency;
2. update the manifest module dependency and the exact npm declaration package together;
3. update the `@minecraft/server-ui` development package if its peer contract changes;
4. rerun the complete type/API compatibility and pack-validation suite;
5. runtime-smoke-test the pack in the matching Bedrock build with the required experiments configured;
6. update this ledger and the compatibility document with the validated build.

## Official references

- Microsoft Learn — Script Module Versioning: https://learn.microsoft.com/minecraft/creator/documents/scripting/versioning?view=minecraft-bedrock-stable
- Microsoft Learn — `@minecraft/server` module and changelog: https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/minecraft-server?view=minecraft-bedrock-stable
- Microsoft Learn — Minecraft Bedrock 1.26.40 Creator update notes: https://learn.microsoft.com/minecraft/creator/documents/update1.26.40?view=minecraft-bedrock-stable
- Microsoft Learn — `@minecraft/server-ui` module: https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server-ui/minecraft-server-ui?view=minecraft-bedrock-stable
