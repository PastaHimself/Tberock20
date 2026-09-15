# Integrity boss parity Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (\`- [ ]\`) syntax for tracking.

**Goal:** Make Integrity Arena ownership, Phase 1/2/3 source timing, Phase 3 contact/damage behavior, and multiplayer isolation source-verifiable in the Bedrock add-on, then publish the result through GitHub Actions.

**Architecture:** Keep source constants and deterministic decisions in the existing pure Integrity models. Add one live \`integrity_arena_runtime.js\` owner for roster and phase lifecycle, and make \`phase3_runtime.js\` consume its roster rather than discovering unrelated same-dimension players. Keep Bedrock-only camera, packet, and damage-type substitutions at the adapter boundary and document them.

**Tech Stack:** JavaScript ES modules, Node \`node:test\`, TypeScript checking against \`@minecraft/server\` \`2.11.0-beta.1.26.50-preview.26\`, Python repository validators, GitHub Actions, and the Bedrock debugger scanner.

## Global Constraints

- Java decompiled source and source data are the behavioral authority.
- No production behavior is added before a focused test has failed for the missing behavior.
- The source Arena radius is exactly 150 blocks.
- Phase 2 remains non-ending unless the explicit developer \`next\` hook is used because Java never assigns its \`ended\` field.
- Phase 3 candidate indices are inclusive \`0..250\); random radii are \`100..123\` with exclusive maximum \`124\`.
- Phase 3 boundary eligibility is strictly \`Y > 90\`; the countdown is 60 ticks.
- Phase 3 delayed cleanup is 298 ticks; the cutscene blackout is \`388 <= ticks < 428\`.
- Bedrock custom damage types and Java custom packets remain documented adaptations.
- Every changed authoring file and shipped BP file must remain aligned where the repository has a mirrored contract.

---

### Task 1: Add deterministic roster and contact models

**Files:**
- Modify: \`TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js\`
- Modify: \`TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_encounter_model.js\`
- Modify: \`TheBrokenScript_Bedrock_2_0/BP/scripts/systems/phase3_attack_model.js\`
- Create: \`tests/integrity_parity_model.test.mjs\`

**Interfaces:**
- Produce \`integrityParticipantIdsWithinRadius(players, center, radius = ARENA_SOURCE.participantRadius): string[]\`.
- Produce \`integrityRosterRecords(participantIds, players): Array<{ id: string, player: object }>\`.
- Produce \`aabbIntersects(first, second): boolean\` using strict Java AABB overlap semantics.
- Produce \`fireballSegmentHitPlan({ from, to, targets, ownerId, radius = FIREBALL_BEDROCK_ADAPTER.collisionRadius }): { id: string, t: number } | null\`.
- Produce \`maceAttackIsEligible({ mainhandItemId, fallDistance, fallFlying }): boolean\`.

- [ ] **Step 1: Write the failing tests.**

~~~js
test("Integrity roster selects only unique players inside the source radius", () => {
  assert.deepEqual(integrityParticipantIdsWithinRadius([
    { id: "outside", location: { x: 151, y: 0, z: 0 } },
    { id: "b", location: { x: 3, y: 0, z: 4 } },
    { id: "a", location: { x: 0, y: 0, z: 0 } },
    { id: "a", location: { x: 0, y: 0, z: 0 } },
  ], { x: 0, y: 0, z: 0 }), ["a", "b"]);
});

test("GroundArm contact excludes touching-only AABBs", () => {
  assert.equal(aabbIntersects(
    { min: { x: 0, y: 0, z: 0 }, max: { x: 1, y: 1, z: 1 } },
    { min: { x: 1, y: 0, z: 0 }, max: { x: 2, y: 1, z: 1 } },
  ), false);
});

test("fireball sweep selects the earliest non-owner roster target", () => {
  assert.deepEqual(fireballSegmentHitPlan({
    from: { x: 0, y: 1, z: 0 }, to: { x: 10, y: 1, z: 0 }, ownerId: "boss",
    targets: [
      { id: "late", aabb: { min: { x: 7, y: 0, z: -0.5 }, max: { x: 8, y: 2, z: 0.5 } } },
      { id: "owner", aabb: { min: { x: 1, y: 0, z: -0.5 }, max: { x: 2, y: 2, z: 0.5 } } },
      { id: "early", aabb: { min: { x: 3, y: 0, z: -0.5 }, max: { x: 4, y: 2, z: 0.5 } } },
    ],
  }), { id: "early", t: 0.3 });
});

test("source mace gate requires a main-hand mace and the fall threshold", () => {
  assert.equal(maceAttackIsEligible({ mainhandItemId: "minecraft:mace", fallDistance: 1.5, fallFlying: false }), true);
  assert.equal(maceAttackIsEligible({ mainhandItemId: "minecraft:sword", fallDistance: 2, fallFlying: false }), false);
  assert.equal(maceAttackIsEligible({ mainhandItemId: "minecraft:mace", fallDistance: 1.49, fallFlying: false }), false);
  assert.equal(maceAttackIsEligible({ mainhandItemId: "minecraft:mace", fallDistance: 2, fallFlying: true }), false);
});
~~~

- [ ] **Step 2: Run the focused tests to verify the red state.**

Run:

~~~bash
node --test tests/integrity_parity_model.test.mjs
~~~

Expected: FAIL because the four requested exports do not yet exist.

- [ ] **Step 3: Implement the pure helpers.**

Use squared 3D distance for the 150-block source radius, deduplicate IDs, and
return IDs sorted by stable ID. Return no roster record for a missing or
explicitly disconnected player. Implement AABB overlap with strict inequalities
on all axes. Use a slab segment intersection for fireballs, expand target AABBs
by the adapter radius, ignore \`ownerId\`, and sort equal-contact results by ID.
The mace helper returns true only for a main-hand mace, fall distance at least
1.5, and \`fallFlying !== true\`.

- [ ] **Step 4: Run the focused tests to verify green.**

~~~bash
node --test tests/integrity_parity_model.test.mjs
~~~

Expected: all new model tests pass.

- [ ] **Step 5: Commit the model slice.**

~~~bash
git add TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js \
  TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_encounter_model.js \
  TheBrokenScript_Bedrock_2_0/BP/scripts/systems/phase3_attack_model.js \
  tests/integrity_parity_model.test.mjs
git commit -m "test: add Integrity roster and contact contracts"
~~~

### Task 2: Make the Phase 3 adapter roster-safe and contact-accurate

**Files:**
- Modify: \`TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/phase3_runtime.js\`
- Modify: \`tests/integrity_parity_model.test.mjs\`
- Modify: \`tests/integrity_arena_model.test.mjs\`
- Modify: \`tests/phase3_lifecycle_model.test.mjs\`

**Interfaces:**
- Produce \`setParticipantIds(ids: string[]): void\`, \`clearParticipantIds(): void\`, and \`getParticipantIds(): string[]\` from \`phase3_runtime.js\`.
- Route nearest-player, boundary, tentacle, swipe, inverse-gravity, arm, and fireball queries through the active roster.
- Preserve a null-roster fallback for standalone developer summons; an Arena always sets a non-null roster before Phase 3 begins.

- [ ] **Step 1: Add failing runtime-contract tests.**

~~~js
test("Phase 3 runtime exposes one participant-roster seam", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  assert.match(runtime, /export function setParticipantIds\(ids\)/);
  assert.match(runtime, /export function clearParticipantIds\(\)/);
  assert.match(runtime, /fireballSegmentHitPlan/);
  assert.match(runtime, /getAABB\(\)/);
  assert.doesNotMatch(runtime, /const candidates = nearby\(fireball, FIREBALL_BEDROCK_ADAPTER\.collisionRadius\)/);
});
~~~

- [ ] **Step 2: Run the focused tests to verify red.**

~~~bash
node --test tests/integrity_parity_model.test.mjs tests/integrity_arena_model.test.mjs
~~~

Expected: FAIL because the runtime has no roster exports, swept contact, or
AABB query.

- [ ] **Step 3: Implement the minimal runtime seam.**

Add a module-level \`participantIds\` initialized to null. The setter stores a
deduplicated string set; the clearer restores null and clears active owner
references; the getter returns a sorted copy. Replace direct player target lists
with one helper that filters by roster when non-null and by dimension/liveness as
each call requires.

At GroundArm impact, call \`player.getAABB()\` and \`aabbIntersects\`. Keep the
source old-timer damage and impulse plan unchanged. For fireballs, save the old
location, compute the new location, sample blocks between the two points, then
call \`fireballSegmentHitPlan\` with roster-player AABBs before teleporting and
damage only the returned target. Pass both \`damagingEntity\` and
\`damagingProjectile\` to the source adapter when the owner is valid.

Use \`getAABB()\` as the primary path and retain only a logged bounded fallback if
an engine object unexpectedly lacks the method. Do not use a point-radius query
as the normal path. For mace damage, read \`minecraft:equippable\` mainhand and
pass the \`isFalling\`-based observation into the source gate while retaining
\`EntityDamageCause.maceSmash\` as the native prerequisite.

- [ ] **Step 4: Run focused model and syntax checks.**

~~~bash
node --test tests/integrity_parity_model.test.mjs tests/integrity_arena_model.test.mjs tests/phase3_lifecycle_model.test.mjs
node --check TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/phase3_runtime.js
~~~

Expected: all focused tests pass and syntax checking exits 0.

- [ ] **Step 5: Commit the Phase 3 slice.**

~~~bash
git add TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/phase3_runtime.js \
  tests/integrity_parity_model.test.mjs tests/integrity_arena_model.test.mjs \
  tests/phase3_lifecycle_model.test.mjs
git commit -m "fix: isolate Integrity Phase 3 to its roster"
~~~

### Task 3: Add the live Arena owner and command wiring

**Files:**
- Create: \`TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/integrity_arena_runtime.js\`
- Modify: \`TheBrokenScript_Bedrock_2_0/BP/scripts/main.js\`
- Modify: \`TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js\`
- Modify: \`TheBrokenScript_Bedrock_2_0/BP/scripts/systems/boss_hooks.js\`
- Create: \`tests/integrity_arena_runtime.test.mjs\`

**Interfaces:**
- \`begin(scheduler): void\`
- \`start(triggerPlayer, requestedPhase = "phase1"): { accepted: boolean, reason?: string, participantIds?: string[] }\`
- \`next(): { accepted: boolean, phase?: string, reason?: string }\`
- \`stop(reason = "manual"): void\`
- \`getState(): { phase: string | null, phaseTicks: number, participantIds: string[] } | null\`
- \`getParticipantIds(): string[]\`

- [ ] **Step 1: Add failing runtime-wiring tests.**

~~~js
test("main starts the Arena owner before the Phase 3 adapter", async () => {
  const main = await readFile(mainPath, "utf8");
  assert.match(main, /integrityArenaRuntime\.begin\(scheduler\)/);
  assert.ok(main.indexOf("integrityArenaRuntime.begin") < main.indexOf("phase3Runtime.begin"));
});

test("developer arena commands delegate to the runtime lifecycle", async () => {
  const commands = await readFile(commandsPath, "utf8");
  assert.match(commands, /integrityArenaRuntime\.start/);
  assert.match(commands, /integrityArenaRuntime\.next/);
  assert.match(commands, /integrityArenaRuntime\.stop/);
  assert.doesNotMatch(commands, /world\.setDynamicProperty\("tbs:arenaActive", on\)/);
});
~~~

- [ ] **Step 2: Run the wiring tests to verify red.**

~~~bash
node --test tests/integrity_arena_runtime.test.mjs
~~~

Expected: FAIL because no Arena runtime module is imported or delegated to.

- [ ] **Step 3: Implement the live Arena state machine.**

\`start\` gathers players in the trigger player's dimension, calls
\`integrityParticipantIdsWithinRadius\`, rejects an empty roster, stores the
source center/dimension/phase/tick state, sets compatibility flags, clears any
old Phase 3 roster, and spawns Phase 1 at the source surface. Each tick
reconciles IDs against \`world.getAllPlayers()\` and applies
\`arenaCheckLivingPlayers\`; an empty/disconnected roster invokes \`stop\`.

Phase 1 tracks its 1080-tick intro and ten chord IDs. Once chords have spawned,
it advances only when \`phase1Ended\` is true. Phase 2 transfers only the roster
after 20 ticks, applies the recovery helpers, and never auto-advances.
\`next\` explicitly advances Phase 2 for developer parity testing. Phase 3
transfers the roster after 20 ticks, calls
\`phase3Runtime.setParticipantIds\`, and spawns the Phase 3 entity at the source
center.

When Phase 3 starts dying, enter the 428-tick cutscene model and update only
roster players with \`setIntegrityCamera\`; at blackout start call supported
camera \`fade\`. At tick 428 clear cameras, clear the Phase 3 roster, remove
tracked transient entities, reset flags, and return to dormant. Failure and
manual stop share the cleanup path. \`boss_hooks.setArenaState\` becomes a
compatibility projection of Arena state; standalone Phase 3 no longer claims
the global flag merely because an entity exists.

- [ ] **Step 4: Run wiring, syntax, and type checks.**

~~~bash
node --test tests/integrity_arena_runtime.test.mjs tests/integrity_parity_model.test.mjs
node --check TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/integrity_arena_runtime.js
npm run typecheck
~~~

Expected: focused tests pass, syntax checking exits 0, and TypeScript reports no
errors.

- [ ] **Step 5: Commit the Arena slice.**

~~~bash
git add TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/integrity_arena_runtime.js \
  TheBrokenScript_Bedrock_2_0/BP/scripts/main.js \
  TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js \
  TheBrokenScript_Bedrock_2_0/BP/scripts/systems/boss_hooks.js \
  tests/integrity_arena_runtime.test.mjs
git commit -m "feat: add Integrity Arena runtime ownership"
~~~

### Task 4: Remove fabricated authoring transitions and update parity evidence

**Files:**
- Modify: \`TheBrokenScript_Bedrock_2_0/src/entities/boss/boss_controller.js\`
- Modify: \`Todo.md\`
- Modify: \`TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md\`
- Modify: \`TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md\`
- Modify: \`TheBrokenScript_Bedrock_2_0/docs/SOURCE_TO_RUNTIME_AUDIT.md\`
- Modify: \`.github/workflows/bedrock-addon-check.yml\`
- Modify: \`tests/integrity_arena_model.test.mjs\`

- [ ] **Step 1: Add failing documentation/authoring tests.**

~~~js
test("authoring controller does not fabricate Integrity HP transitions", async () => {
  const source = await readFile(sourceControllerPath, "utf8");
  const section = source.slice(source.indexOf("function tickIntegrityEarly"), source.indexOf("function tickIntegrityP3"));
  assert.doesNotMatch(section, /threshold|transitionPhase|currentValue/);
});

test("GitHub Actions runs the focused Integrity parity suite", async () => {
  const workflow = await readFile(workflowPath, "utf8");
  assert.match(workflow, /Run Integrity boss parity regressions/);
  assert.match(workflow, /integrity_parity_model\.test\.mjs/);
});
~~~

- [ ] **Step 2: Run the tests to verify red.**

~~~bash
node --test tests/integrity_arena_model.test.mjs
~~~

Expected: the authoring-controller assertion fails because the historical
threshold block remains and the workflow has no named Integrity step.

- [ ] **Step 3: Remove only the fabricated Integrity block and update evidence.**

Delete the authoring controller's Integrity \`frac\`/\`threshold\`/\`transitionPhase\`
branch while leaving the unrelated FracturedRoam threshold untouched. Update
source comments to point to Arena ownership. Add this workflow gate:

~~~yaml
- name: Run Integrity boss parity regressions
  if: always()
  run: >-
    node --experimental-vm-modules --test
    tests/integrity_parity_model.test.mjs
    tests/integrity_arena_runtime.test.mjs
    tests/integrity_arena_model.test.mjs
    tests/phase3_attack_model.test.mjs
    tests/phase3_lifecycle_model.test.mjs
~~~

Update the audit, adaptation notes, known limitations, and Todo item 8 with the
exact source files, roster/AABB/swept-collision implementation, and remaining
packet/custom-damage/owner/camera limits. Mark only evidence-backed rows complete.

- [ ] **Step 4: Run focused tests and documentation checks.**

~~~bash
node --test tests/integrity_arena_model.test.mjs tests/integrity_arena_runtime.test.mjs
node --check TheBrokenScript_Bedrock_2_0/src/entities/boss/boss_controller.js
git diff --check
~~~

Expected: focused tests pass, authoring syntax is valid, and the diff has no
whitespace errors.

- [ ] **Step 5: Commit the evidence slice.**

~~~bash
git add TheBrokenScript_Bedrock_2_0/src/entities/boss/boss_controller.js Todo.md \
  TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md \
  TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md \
  TheBrokenScript_Bedrock_2_0/docs/SOURCE_TO_RUNTIME_AUDIT.md \
  .github/workflows/bedrock-addon-check.yml tests/integrity_arena_model.test.mjs
git commit -m "docs: close Integrity parity evidence"
~~~

### Task 5: Full verification and publish

**Files:**
- Modify only files identified by validation failures.
- Do not check generated reports in unless repository conventions require them.

- [ ] **Step 1: Run the complete local validation suite.**

~~~bash
npm run typecheck
npm test
python -m unittest discover -s tests -p 'test_*.py' -v
python tools/audit_source_to_runtime.py --check --report artifacts/source-to-runtime-audit.json
python tools/validate_addon.py --report artifacts/addon-validation.json
python tools/validate_resource_links.py --report artifacts/resource-link-validation.json
python tools/validate_jigsaw_worldgen.py
python tools/validate_jigsaw_nbt_connectors.py
python tools/validate_mcstructures.py --report artifacts/mcstructure-validation.json
~~~

Expected: every command exits 0. If a new behavior fails, add a regression test
first and then fix the smallest production surface.

- [ ] **Step 2: Run the required Bedrock debugger scan.**

~~~bash
python /root/.codex/skills/remote-skills/skill-6a8da65113fc8191833d135c3adf3a3c/scripts/bedrock_debugger.py \
  TheBrokenScript_Bedrock_2_0 --format markdown --out artifacts/integrity-bedrock-debug-report.md
~~~

Expected: no new manifest, UUID, dependency, identifier, or pack-layout blocker.

- [ ] **Step 3: Review the final diff against the approved design.**

~~~bash
git diff origin/main...HEAD --stat
git diff origin/main...HEAD --check
rg -n "threshold|transitionPhase" \
  TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js \
  TheBrokenScript_Bedrock_2_0/src/entities/boss/boss_controller.js
git status --short
~~~

Expected: no Integrity HP-transition matches, only intended files are changed,
and the worktree is clean after committing.

- [ ] **Step 4: Request code review before publishing.**

Review the complete branch against \`origin/main\` using the code-reviewer
template. Fix every Critical or Important finding, rerun affected tests, and
commit the fixes before pushing.

- [ ] **Step 5: Push, trigger, and reconcile GitHub Actions.**

Push \`codex/integrity-boss-parity-8\`, fetch the workflow run for the pushed SHA,
inspect every job and failed log, and rerun only failed jobs once if transient.
Do not report success until the run is terminal green or a specific external
blocker is documented.

- [ ] **Step 6: Open the pull request.**

Use the GitHub connector to create a PR from \`codex/integrity-boss-parity-8\` to
\`main\` with title \`Finish Integrity boss parity\`, a Todo item 8 rationale,
source/API evidence, local and Actions checks, residual engine limitations, and
no merge operation unless separately requested.

Record the PR number, URL, head SHA, workflow run, review result, and remaining
external limitations in the handoff.
