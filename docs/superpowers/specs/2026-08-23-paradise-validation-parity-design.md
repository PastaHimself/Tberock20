# TBS 2.0 Paradise.exe Validation Parity Design

## Goal

Make `PastaHimself/tbs-2.0` use the same validation architecture as `PastaHimself/Paradise.exe`, adapted only where repository names, pack paths, package names, or TBS-specific content require it.

The existing Mojang Minecraft Creator Tools validation in TBS remains in place. The Paradise.exe validation layers are added on top of it rather than replacing it.

## Scope

The TBS workflow will include the same categories of validation used by Paradise.exe:

1. Python validator unit tests.
2. Repository-wide Bedrock add-on validation.
3. Resource identifier/reference validation.
4. `.mcstructure` binary/NBT validation.
5. JavaScript syntax validation for every behavior-pack script.
6. TypeScript `checkJs` validation against the Bedrock Script API typings.
7. JavaScript regression tests for validation/runtime-support code that can be tested outside Minecraft.
8. Blockception Minecraft Bedrock language-server diagnostics.
9. Mojang Minecraft Creator Tools validation already present in TBS.
10. Installable `.mcaddon` packaging.
11. Upload of machine-readable JSON validation reports and the packaged `.mcaddon` as GitHub Actions artifacts.

## Repository Adaptation

Paradise.exe paths and names will be translated to the TBS layout:

- Add-on root: `TheBrokenScript_Bedrock_2_0`
- Behavior pack: `TheBrokenScript_Bedrock_2_0/BP`
- Resource pack: `TheBrokenScript_Bedrock_2_0/RP`
- Behavior scripts: `TheBrokenScript_Bedrock_2_0/BP/scripts`
- Packaged artifact: `dist/The_Broken_Script_2_0.mcaddon`

Paradise-specific identifiers, entity names, structure locations, or gameplay assumptions will not be copied blindly. The validation logic will operate against TBS content and identifiers.

## Validation Components

### `tools/validate_addon.py`

Port the Paradise.exe repository-wide validator and adapt it to TBS. It will check:

- BP/RP roots exist.
- All JSON files parse.
- Manifest format/version structure.
- Manifest UUID validity and duplicate UUIDs.
- BP data/script modules and RP resources module.
- Script entry existence.
- BP-to-RP UUID/version dependency correctness.
- Relative JavaScript imports resolve.
- Referenced local structures exist.
- Required local texture references resolve.
- Sound definitions resolve to files.
- PNG signatures are valid.
- Sound assets are non-empty.

### `tools/validate_resource_links.py`

Port the Paradise.exe semantic RP validator and adapt it to the TBS RP. It will collect and cross-check custom:

- geometry identifiers;
- animation identifiers;
- animation-controller identifiers;
- render-controller identifiers;
- client-entity and attachable references.

Vanilla/base-pack identifiers that are valid external references remain allowed where Paradise.exe allows them.

### `tools/validate_mcstructures.py`

Port the Paradise.exe little-endian NBT parser and `.mcstructure` validator. It will validate every TBS structure for:

- valid Bedrock NBT container shape;
- positive dimensions;
- sane structure volume;
- block-index layer lengths;
- valid palette indices;
- palette structure and block states;
- non-empty/non-air content;
- configured safety limits.

### Script API Type Checking

Add a root `package.json` and `tsconfig.json` following the Paradise.exe setup, with paths changed to TBS scripts. TypeScript will run in `allowJs`/`checkJs`/`noEmit` mode so existing JavaScript is checked without converting the add-on to TypeScript.

Bedrock Script API typings will correspond to the Script API dependencies used by the TBS behavior-pack manifest.

### Blockception Diagnostics

Copy the Paradise.exe Blockception CI pattern:

- check out `Blockception/minecraft-bedrock-language-server` during CI;
- build it;
- run project diagnostics against the TBS add-on workspace;
- write diagnostics to a JSON report;
- fail CI on blocking diagnostics according to the same policy used by Paradise.exe.

### Mojang Creator Tools

Keep TBS's existing `@minecraft/creator-tools` validation and its existing narrowly scoped self-comparison false-positive handling. It remains a required validation stage.

## Workflow

Update `.github/workflows/bedrock-addon-check.yml` so the validation order mirrors Paradise.exe while retaining the existing TBS Creator Tools stage:

1. Checkout.
2. Set up Python.
3. Set up Node.js.
4. Install Bedrock Script API/TypeScript dependencies.
5. Run Python validator unit tests.
6. Run complete add-on validator.
7. Run resource-link validator.
8. Run `.mcstructure` validator.
9. Run JavaScript syntax checks.
10. Run Script API type-checking.
11. Run JavaScript regression tests.
12. Build and run Blockception diagnostics.
13. Stage and run Mojang Creator Tools validation.
14. Package the `.mcaddon`.
15. Upload `.mcaddon` and validation reports.

A real validation error in any required stage fails the workflow. Warnings remain visible but do not fail CI unless the underlying validator categorizes them as blocking.

## Tests

Port the Paradise.exe validator-test approach and adapt fixtures/assertions to TBS paths. Tests will cover the validation code itself so CI does not rely on untested custom validators.

TBS-specific regression tests will be added only where code can be deterministically exercised in Node without pretending to simulate the Minecraft engine. Minecraft-only runtime behavior remains outside static CI coverage.

## Preservation Rules

- Do not replace or remove TBS gameplay code.
- Do not change add-on behavior merely to make validators pass unless an actual invalid Bedrock construct is discovered.
- Do not remove the existing Mojang Creator Tools checks.
- Do not weaken or broadly suppress diagnostics.
- Preserve the existing `.mcaddon` packaging behavior and artifact name.
- Only adapt Paradise.exe validation code where TBS paths/content make adaptation necessary.

## Success Criteria

The work is complete when a TBS pull request runs the combined validation stack and:

- all Paradise.exe-equivalent validation layers are present;
- the existing Mojang Creator Tools stage still runs;
- custom validators have automated tests;
- Script API type-checking runs against TBS scripts;
- Blockception diagnostics run against the TBS project;
- `.mcstructure` files are parsed and validated, not merely checked for existence;
- cross-resource references are checked;
- JSON validation reports are uploaded;
- a valid installable TBS `.mcaddon` is produced only after required validation succeeds.
