# Persistent State Parity Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** Complete Todo item 5 by making Java world/player persistence explicit, additive, migration-safe, lifecycle-correct, and continuously checked in CI.

**Architecture:** Keep the existing namespaced Bedrock dynamic-property adapter, add a pure persistence schema as the source of truth for Java attachment fields and defaults, initialize missing fields without rewriting existing values, migrate legacy scalar/vector and raw-key representations, and record entity-owned state as an explicit persistence policy. Source scripts and the shipped behavior-pack copies stay byte-for-byte synchronized where the project already requires it.

**Tech Stack:** Bedrock Script API dynamic properties, JavaScript ESM, Node’s built-in test runner, Python `unittest`, GitHub Actions, and the repository’s existing add-on validators.

## Global Constraints

- Follow the repository’s source-to-`BP/scripts` synchronization convention.
- Treat an absent property as the only safe condition for applying a default; never reset an existing world/player value during first load.
- Use `undefined` to remove transient dynamic properties, matching the documented Bedrock API behavior.
- Preserve legacy keys while migrating them into the canonical schema so existing worlds remain readable.
- Add tests before production changes and run the failing tests before implementing each behavior.

## Task 1: Establish the canonical persistence schema and migration helpers

**Files:**

- Add `TheBrokenScript_Bedrock_2_0/src/core/persistence_schema.js`.
- Add the synchronized copy `TheBrokenScript_Bedrock_2_0/BP/scripts/core/persistence_schema.js`.
- Add `tests/persistent_state_parity.test.mjs` coverage for field names, types, defaults, schema versions, and additive migration behavior.

**Tests:** First add assertions that the Java `MapVariables` and `PlayerVariables` fields are represented exactly once, that structured `BlockPos`/`Vec3` fields are represented as Bedrock vectors, and that migration only writes missing fields. Run `npm test -- --test-name-pattern='persistent state'` and confirm the new assertions fail before writing the schema.

**Implementation:** Export immutable world/player schemas, Java-compatible defaults, structured JSON defaults, schema versions, and a pure additive migration function. Include the Java default for every field, including empty `doors` and `isolationAllowedUsers`, `voidBox: true`, and zero-valued coordinates. Keep the schema module free of `@minecraft/server` imports so tests can execute in Node.

## Task 2: Make the dynamic-property adapter vector-safe and migration-safe

**Files:**

- Update `TheBrokenScript_Bedrock_2_0/src/core/state.js`.
- Update `TheBrokenScript_Bedrock_2_0/BP/scripts/core/state.js`.
- Extend `tests/persistent_state_parity.test.mjs`.

**Tests:** Add coverage for primitive and `Vector3` values, malformed JSON cleanup, schema-1-to-current migration, future-schema rejection, and preservation of existing values. Run the focused tests red before changing the adapter.

**Implementation:** Accept finite Bedrock `Vector3` values, centralize the core schema version, migrate metadata without touching gameplay fields, and expose explicit removal helpers for lifecycle cleanup. Keep world and player namespaces separate and retain the existing JSON size guard.

## Task 3: Initialize complete Java world/player attachments

**Files:**

- Update `TheBrokenScript_Bedrock_2_0/src/systems/world_state.js`.
- Update `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/world_state.js`.
- Update `TheBrokenScript_Bedrock_2_0/src/systems/player_state.js`.
- Add `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/player_state.js` if it is missing or synchronize it.
- Update `tests/persistent_state_parity.test.mjs`.

**Tests:** Add checks for additive initialization, Java field/type parity, vector migration from legacy scalar coordinates, JSON collection defaults, and no reset of existing values. Run the focused tests red first.

**Implementation:** Make world initialization use the canonical schema while preserving the existing `mv.*` compatibility keys. Add `playerState.init(player)` for every Java `PlayerVariables` field, including `spawnPos`, `customSkyColor`, `doors`, and `isolationAllowedUsers`; migrate legacy `spawnPosX/Y/Z`, `customSkyR/G/B`, and raw `tbs:ban` without overwriting canonical values. Wire player initialization to the initial spawn/join lifecycle and keep respawn from resetting persistent attachment state.

## Task 4: Correct one-shot, temporary, and scope-specific lifecycle behavior

**Files:**

- Update `TheBrokenScript_Bedrock_2_0/src/systems/progression.js`.
- Update `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/progression_state.js` or its source equivalent as needed.
- Update `TheBrokenScript_Bedrock_2_0/src/systems/ported_features.js` or its shipped equivalent.
- Update the relevant player/world controller files that still write canonical state through raw keys.
- Update `tests/persistent_state_parity.test.mjs` and related regression tests.

**Tests:** Prove one-shot awards are persisted per player, survive reload, and do not leak from one player to another; prove world flags remain world-scoped; prove temporary expiry removes its property and transient runtime state is not serialized. Run focused tests red before implementation.

**Implementation:** Use persisted per-player award keys as the source of truth instead of a process-global cache, migrate raw ban/legacy keys into `pv.*`, clear expired temporary effects with `undefined`, and preserve persistent world progression separately from player state.

## Task 5: Declare and validate entity-owned persistence policy

**Files:**

- Add `TheBrokenScript_Bedrock_2_0/src/core/entity_persistence_policy.js`.
- Add the synchronized behavior-pack copy.
- Add `tools/validate_persistent_state.py`.
- Add `tests/test_persistent_state_validator.py`.
- Extend `tests/persistent_state_parity.test.mjs`.

**Tests:** Add validator tests for entity dynamic-property scope, in-memory controller timers being transient, explicitly non-persistent `integrity_arm`, and synchronized source/deploy policy files. Run the Python tests red before adding the validator.

**Implementation:** Record which entity-owned values are intentionally persistent (`tbe:variant` and declared block/entity keys), which controller maps are runtime-only, and which entities must remain non-persistent. Make the validator fail on undeclared dynamic-property keys or a persistence-component drift, while allowing the documented non-persistent entity behavior.

## Task 6: Gate parity in GitHub Actions and document completion

**Files:**

- Update `.github/workflows/bedrock-addon-check.yml` to run `python tools/validate_persistent_state.py` and its unit tests.
- Update `Todo.md` item 5 with evidence links/commands and mark only the completed item-5 checks.
- Add a concise persistence-parity report under `docs/` with the Java-to-Bedrock mappings and lifecycle decisions.

**Tests:** Run the full local validator, JavaScript test suite, typecheck, syntax checks, and package validation; then push the branch and inspect the GitHub Actions run for the PR commit.

## Task 7: Review and publish the pull request

**Files:**

- No additional source changes unless review finds a defect.

**Implementation:** Inspect the complete diff, run whitespace and synchronization checks, request a code review through the repository workflow if available, push the branch, open a focused pull request against `main`, and report the PR plus GitHub Actions result.

---

## Verification commands

```bash
npm test
npm run typecheck
python -m unittest discover -s tests -p 'test_*.py' -v
python tools/validate_persistent_state.py
git diff --check
```
