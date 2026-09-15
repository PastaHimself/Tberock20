# Jimmy / Fractured / FracturedRoam Parity Implementation Plan

> **For agentic workers:** Execute this plan task-by-task with test-first changes and a review checkpoint after each task. Steps use checkbox syntax for tracking.

**Goal:** Complete the source-verifiable portions of Todo item 9 for Jimmy, Fractured, and FracturedRoam, with deterministic tests and explicit Bedrock API fallbacks for unsupported rendered-bone and melee-impact data.

**Architecture:** Keep Java-derived constants and state transitions in pure model modules. Keep Bedrock entity queries, event subscriptions, movement, damage, sound, and spawning in `fractured_runtime.js`. Feed the runtime only deterministic plans from the models, and expose capability-limited contact-origin resolution as an injectable adapter with root-position fallback.

**Tech Stack:** ES modules, Node's built-in `node:test`, TypeScript type checking against `@minecraft/server` 2.11.0-beta.1.26.50-preview.26, Minecraft Bedrock Script API, Python audit tests, and GitHub Actions.

## Global Constraints

- Preserve the Java source timings: rise 149 ticks, dig/switch/despawn 103 ticks, Arena intro 340 ticks, and attack lengths 78/78/139/60 ticks.
- Preserve the source damage values, ranges, grounded gates, impulse strengths, rock cleanup, and equal attack weights.
- Do not invent a Bedrock server API for rendered bones, locators, or melee impact coordinates.
- Do not change unrelated Todo items, entity ownership, or the existing package dependency versions.
- Every runtime behavior added here must have a pure model test or a focused runtime wiring assertion.
- The acceptance commands are `npm test`, `npm run typecheck`, `python -m unittest discover -s tests -p 'test_*.py' -v`, and the repository's existing workflow validators.

---

### Task 1: Add the source-backed attack and rising-wave contract

**Files:**
- Modify: `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_attack_model.js`
- Test: `tests/fractured_attack_model.test.mjs`

**Interfaces:**
- Consumes: existing `FRACTURED_ATTACKS`, `FRACTURED_SOURCE`, and `chooseFracturedAttack` exports.
- Produces: `FRACTURED_RISING_SOURCE`, `fracturedRisingStep`, `fracturedRisingImpactPlan`, and `fracturedAttackCandidates` exports.

- [ ] **Step 1: Write the failing tests**

Add tests asserting four real candidates, weight 1 for each, legal repeated selection after the delay clears, and a rising window using post-decrement ticks 103 through 55.

```js
import {
  FRACTURED_RISING_SOURCE,
  fracturedAttackCandidates,
  fracturedRisingImpactPlan,
  fracturedRisingStep,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_attack_model.js";

test("Jimmy candidates preserve equal weights and allow repeats", () => {
  assert.deepEqual(fracturedAttackCandidates(), [
    { attack: "stomp", chance: 1 },
    { attack: "slam", chance: 1 },
    { attack: "moonRockToss", chance: 1 },
    { attack: "airLift", chance: 1 },
  ]);
  assert.equal(chooseFracturedAttack({
    currentAttack: "noop", attackDelay: 0, targetPresent: true, roll: 0,
  }), "stomp");
});

test("Jimmy rising uses the source window and source damage id", () => {
  assert.deepEqual(fracturedRisingStep(104), { tick: 103, active: true });
  assert.deepEqual(fracturedRisingStep(55), { tick: 54, active: false });
  assert.deepEqual(fracturedRisingStep(54), { tick: 53, active: false });
  assert.deepEqual(fracturedRisingImpactPlan(), {
    sourceId: "thebrokenscript:jimmy_rise",
    radius: 30,
    damage: 19,
    knockback: 30,
    groundedOnly: true,
  });
  assert.equal(FRACTURED_RISING_SOURCE.durationTicks, 149);
});
```

- [ ] **Step 2: Run the focused test and verify it fails**

Run: `node --test tests/fractured_attack_model.test.mjs`
Expected: FAIL because the new exports do not exist.

- [ ] **Step 3: Implement the minimal pure model**

Add these definitions and keep the selector free of any previous-attack exclusion:

```js
export const FRACTURED_RISING_SOURCE = Object.freeze({
  durationTicks: 149,
  activeMinTick: 55,
  activeMaxTick: 103,
  radius: 30,
  damage: 19,
  knockback: 30,
  groundedOnly: true,
  sourceId: "thebrokenscript:jimmy_rise",
});

export function fracturedAttackCandidates() {
  return SELECTABLE_ATTACKS.map((attack) => ({
    attack,
    chance: FRACTURED_ATTACKS[attack].chance,
  }));
}

export function fracturedRisingStep(currentTick = FRACTURED_RISING_SOURCE.durationTicks) {
  const current = Math.max(0, Math.floor(Number(currentTick) || 0));
  const tick = current > 0 ? current - 1 : 0;
  return {
    tick,
    active: tick >= FRACTURED_RISING_SOURCE.activeMinTick &&
      tick <= FRACTURED_RISING_SOURCE.activeMaxTick,
  };
}

export function fracturedRisingImpactPlan() {
  return {
    sourceId: FRACTURED_RISING_SOURCE.sourceId,
    radius: FRACTURED_RISING_SOURCE.radius,
    damage: FRACTURED_RISING_SOURCE.damage,
    knockback: FRACTURED_RISING_SOURCE.knockback,
    groundedOnly: FRACTURED_RISING_SOURCE.groundedOnly,
  };
}
```

- [ ] **Step 4: Run the focused test and verify it passes**

Run: `node --test tests/fractured_attack_model.test.mjs`
Expected: PASS.

- [ ] **Step 5: Commit the model slice**

```bash
git add TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_attack_model.js tests/fractured_attack_model.test.mjs
git commit -m "test: lock Jimmy attack and rising parity"
```

### Task 2: Implement deterministic six-region projectile sweeps

**Files:**
- Modify: `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_multipart_model.js`
- Test: `tests/fractured_multipart_model.test.mjs`

**Interfaces:**
- Consumes: existing `multipartAabbs` and `pointInsideAabb` geometry.
- Produces: `segmentIntersectsAabb` and `multipartProjectileHitPlan`.

- [ ] **Step 1: Write failing yaw, elevation, movement, and coarse-segment tests**

```js
import { multipartProjectileHitPlan } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_multipart_model.js";

test("multipart filtering sweeps between projectile samples", () => {
  const result = multipartProjectileHitPlan({
    position: { x: 0, y: 0, z: 0 },
    yawDegrees: 0,
    from: { x: -20, y: 95, z: 10 },
    to: { x: 20, y: 95, z: 10 },
    substep: 1,
  });
  assert.equal(result.hit, true);
  assert.equal(result.part.name, "head");
});

test("multipart sweep respects yaw and elevation", () => {
  const leg = multipartProjectileHitPlan({
    position: { x: 0, y: 0, z: 0 },
    yawDegrees: 90,
    from: { x: 0, y: 1, z: 25 },
    to: { x: 0, y: 1, z: 80 },
    substep: 1,
  });
  assert.equal(leg.hit, true);
  assert.equal(leg.part.name, "frontleft");

  const elevated = multipartProjectileHitPlan({
    position: { x: 0, y: 0, z: 0 },
    yawDegrees: 90,
    from: { x: 0, y: 20, z: 25 },
    to: { x: 0, y: 20, z: 80 },
    substep: 1,
  });
  assert.equal(elevated.hit, false);
});
```

- [ ] **Step 2: Run the focused test and verify it fails**

Run: `node --test tests/fractured_multipart_model.test.mjs`
Expected: FAIL because the sweep export is missing.

- [ ] **Step 3: Implement slab intersection and stable first-hit selection**

Use a slab interval for each axis. Reject intervals outside `[0, 1]`, compare entry fractions, and use existing part order as the deterministic tie breaker:

```js
export function segmentIntersectsAabb(from, to, aabb) {
  if (!from || !to || !aabb) return null;
  let entry = 0;
  let exit = 1;
  for (const axis of ["x", "y", "z"]) {
    const delta = to[axis] - from[axis];
    if (Math.abs(delta) < 1e-9) {
      if (from[axis] < aabb.min[axis] || from[axis] > aabb.max[axis]) return null;
      continue;
    }
    const first = (aabb.min[axis] - from[axis]) / delta;
    const second = (aabb.max[axis] - from[axis]) / delta;
    entry = Math.max(entry, Math.min(first, second));
    exit = Math.min(exit, Math.max(first, second));
    if (entry > exit) return null;
  }
  return { entry, exit };
}

export function multipartProjectileHitPlan({
  position, yawDegrees = 0, from, to = from,
} = {}) {
  let best = null;
  multipartAabbs({ position, yawDegrees }).forEach((part, index) => {
    const hit = segmentIntersectsAabb(from, to, part);
    if (!hit) return;
    if (!best || hit.entry < best.entry ||
        (hit.entry === best.entry && index < best.index)) {
      best = { hit: true, part, entry: hit.entry, index };
    }
  });
  return best ?? { hit: false, part: null, entry: null, index: -1 };
}
```

- [ ] **Step 4: Run the model and runtime multipart tests**

Run: `node --test tests/fractured_multipart_model.test.mjs tests/fractured_multipart_runtime.test.mjs`
Expected: PASS.

- [ ] **Step 5: Commit the sweep slice**

```bash
git add TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_multipart_model.js tests/fractured_multipart_model.test.mjs
git commit -m "feat: add swept fractured multipart hit testing"
```

### Task 3: Complete Roam lifecycle and target-range contracts

**Files:**
- Modify: `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_roam_model.js`
- Test: `tests/fractured_roam_model.test.mjs`

**Interfaces:**
- Consumes: existing Roam constants, lifecycle transitions, and movement model.
- Produces: `fracturedRoamTargetRange`, `fracturedRoamLifecycleStep`, and `fracturedRoamArenaRosterStep`.

- [ ] **Step 1: Write failing target-range, boundary, and roster tests**

```js
test("Roam uses 100 blocks normally and 30 underground", () => {
  assert.equal(fracturedRoamTargetRange("NORMAL"), 100);
  assert.equal(fracturedRoamTargetRange("UNDERGROUND"), 30);
  assert.equal(fracturedRoamTargetRange("DIGGING"), null);
});

test("Roam preserves decrement-before-promotion boundaries", () => {
  assert.deepEqual(fracturedRoamLifecycleStep({ state: "RISING", riseTicks: 1 }), {
    state: "RISING", riseTicks: 0, promote: false, discard: false,
  });
  assert.deepEqual(fracturedRoamLifecycleStep({ state: "RISING", riseTicks: 0 }), {
    state: "NORMAL", riseTicks: 0, promote: true, discard: false,
  });
  assert.deepEqual(fracturedRoamLifecycleStep({ state: "SWITCHING", switchTicks: 0 }), {
    state: "NORMAL", switchTicks: 0, promote: true, discard: false,
  });
});

test("Arena roster replaces a reconnected instance and removes stale keys", () => {
  const result = fracturedRoamArenaRosterStep({
    previous: new Map([["p1", { id: "old" }], ["p2", { id: "gone" }]]),
    current: [{ id: "new", uuid: "p1" }],
  });
  assert.deepEqual([...result.roster.entries()], [
    ["p1", { id: "new", uuid: "p1" }],
  ]);
  assert.deepEqual(result.removed, ["p2"]);
});
```

- [ ] **Step 2: Run the focused tests and verify they fail**

Run: `node --test tests/fractured_roam_model.test.mjs`
Expected: FAIL because the new exports are missing.

- [ ] **Step 3: Implement the pure helpers**

```js
export function fracturedRoamTargetRange(state) {
  if (state === "NORMAL") return FRACTURED_ROAM_SOURCE.randomStrollHorizontalRange;
  if (state === "UNDERGROUND") return 30;
  return null;
}

export function fracturedRoamLifecycleStep({
  state = "NORMAL", riseTicks = 0, switchTicks = 0,
} = {}) {
  if (state === "RISING") {
    if (riseTicks > 0) return {
      state, riseTicks: riseTicks - 1, promote: false, discard: false,
    };
    return { state: "NORMAL", riseTicks: 0, promote: true, discard: false };
  }
  if (state === "SWITCHING") {
    if (switchTicks > 0) return {
      state, switchTicks: switchTicks - 1, promote: false, discard: false,
    };
    return { state: "NORMAL", switchTicks: 0, promote: true, discard: false };
  }
  return { state, riseTicks: 0, switchTicks: 0, promote: false, discard: false };
}

export function fracturedRoamArenaRosterStep({
  previous = new Map(), current = [],
} = {}) {
  const roster = new Map();
  const removed = [];
  for (const player of current) {
    const key = player?.uuid ?? player?.id;
    if (key != null) roster.set(key, player);
  }
  for (const key of previous.keys()) if (!roster.has(key)) removed.push(key);
  return { roster, removed };
}
```

- [ ] **Step 4: Run the Roam suite**

Run: `node --test tests/fractured_roam_model.test.mjs`
Expected: PASS.

- [ ] **Step 5: Commit the Roam model slice**

```bash
git add TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_roam_model.js tests/fractured_roam_model.test.mjs
git commit -m "test: lock FracturedRoam lifecycle gates"
```

### Task 4: Integrate lifecycle, rising damage, contact fallback, and projectile sweeps

**Files:**
- Modify: `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/fractured_runtime.js`
- Modify: `tests/fractured_runtime.test.mjs`
- Modify: `tests/fractured_multipart_runtime.test.mjs`

**Interfaces:**
- Consumes: Tasks 1–3 model exports and the existing runtime maps.
- Produces: one scheduler owner for lifecycle/rising/movement/projectiles, with runtime source flags proving the integrations.

- [ ] **Step 1: Write failing runtime wiring assertions**

```js
test("runtime wires rising parity and swept multipart history", async () => {
  const runtime = await readFile(runtimePath, "utf8");
  assert.match(runtime, /fracturedRisingStep/);
  assert.match(runtime, /fracturedRisingImpactPlan/);
  assert.match(runtime, /thebrokenscript:jimmy_rise/);
  assert.match(runtime, /multipartProjectileHitPlan/);
  assert.match(runtime, /projectilePositions/);
  assert.match(runtime, /fracturedRoamTargetRange/);
  assert.match(runtime, /contactOrigin/);
});
```

- [ ] **Step 2: Run the assertions and verify they fail**

Run: `node --test tests/fractured_runtime.test.mjs tests/fractured_multipart_runtime.test.mjs`
Expected: FAIL because the current runtime has no rising integration or projectile history.

- [ ] **Step 3: Add lifecycle state, projectile history, and contact-origin resolution**

Import the new model functions. Add lifecycle state for both entity types, initialized in `RISING` with a 149-tick counter, and a `projectilePositions` map keyed by projectile id. Use this exact validation boundary for optional contact origins:

```js
export function resolveFracturedContactOrigin(entity, locator, fallback = entity?.location) {
  try {
    const value = typeof locator === "function" ? locator(entity) : null;
    if (value && ["x", "y", "z"].every((axis) => Number.isFinite(value[axis]))) {
      return { x: value.x, y: value.y, z: value.z };
    }
  } catch {}
  return fallback && ["x", "y", "z"].every((axis) => Number.isFinite(fallback[axis]))
    ? { x: fallback.x, y: fallback.y, z: fallback.z }
    : null;
}
```

- [ ] **Step 4: Implement regular Jimmy lifecycle and rising damage**

Apply the decrement-before-transition rule to regular Fractured as well as Roam. During the post-decrement rising window, call `fracturedRisingImpactPlan()`, filter grounded players within 30 blocks, apply `thebrokenscript:jimmy_rise`, and apply the source look-direction impulse. Preserve `JimAttackSelectorGoal`'s actual `NOOP`/delay/target gates for regular Jimmy; only Roam movement and digging are blocked outside their source `NORMAL` state gates. Reuse the existing safe-ground recovery behavior for both entity types, clearing velocity/fall distance and resetting navigation after teleport.

- [ ] **Step 5: Replace point-only multipart routing**

Capture each projectile's current location after each valid tick. In the hurt hook, pass the previous and current positions to `multipartProjectileHitPlan`; if no history exists, pass the impact point for a zero-length segment. Feed the returned part to `fracturedPartHitPlan`, preserve side-effect ordering, and delete history when the projectile is invalid or removed.

```js
const impact = projectileImpactPoint(projectile);
const previous = projectilePositions.get(projectile.id) ?? impact;
const hit = multipartProjectileHitPlan({
  position: parent.location,
  yawDegrees: getBodyYaw(parent),
  from: previous,
  to: impact,
});
const partPlan = fracturedPartHitPlan({
  parentType: parent.typeId,
  partHit: hit.hit ? hit.part : false,
  partRole: hit.part?.role ?? null,
  projectileType: projectile.typeId,
  projectileOnFire: isEntityOnFire(projectile),
  invulnerable: isInvulnerable(parent),
  roamState: getFracturedRoamLifecycleState(parent)?.state,
});
```

- [ ] **Step 6: Use the correct Roam target ranges and state gates**

Use a 30-block horizontal random target for underground no-target navigation and 100 blocks for normal strolling. Start digging only from `NORMAL` with cooldown clear and roll 1; promote switching only after its 103 decrements. Keep the existing source support, stuck, and target-distance checks.

- [ ] **Step 7: Run focused runtime tests**

Run: `node --test tests/fractured_runtime.test.mjs tests/fractured_multipart_runtime.test.mjs tests/fractured_roam_model.test.mjs`
Expected: PASS.

- [ ] **Step 8: Commit the runtime integration**

```bash
git add TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/fractured_runtime.js tests/fractured_runtime.test.mjs tests/fractured_multipart_runtime.test.mjs
git commit -m "feat: integrate Jimmy lifecycle and swept multipart damage"
```

### Task 5: Harden JimArena cleanup and document the API boundary

**Files:**
- Modify: `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/fractured_runtime.js`
- Modify: `TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md`
- Modify: `TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md`
- Modify: `Todo.md`
- Test: `tests/fractured_runtime.test.mjs`
- Test: `tests/fractured_multipart_model.test.mjs`

**Interfaces:**
- Consumes: the arena model and runtime sound/roster maps.
- Produces: clean failure/reset behavior and a parity ledger with no unsupported completion claims.

- [ ] **Step 1: Write failing cleanup and documentation assertions**

```js
test("Jimmy parity docs record the current Bedrock capability boundary", async () => {
  const notes = await readFile(new URL("../TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md", import.meta.url), "utf8");
  const limitations = await readFile(new URL("../TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md", import.meta.url), "utf8");
  const text = `${notes}\n${limitations}`;
  assert.match(text, /EntityHurtBeforeEvent/);
  assert.match(text, /rendered bone|locator/i);
  assert.match(text, /projectile/i);
});
```

- [ ] **Step 2: Run the assertions and verify they fail**

Run: `node --test tests/fractured_runtime.test.mjs tests/fractured_multipart_model.test.mjs`
Expected: FAIL until the new cleanup markers and API-boundary wording are present.

- [ ] **Step 3: Harden Arena refresh and reset**

Refresh players using their stable server id/UUID key, replace changed entity instances under the same key, and remove missing or invalid players. On intro/loop playback failure, stop handles already created. On reset, stop every handle, discard Jimmy and spawned SA2 entities, clear the roster/timers, and release the arena entry:

```js
function stopArenaSounds(arena) {
  for (const instance of arena.soundInstances) {
    try { instance?.stop(); } catch {}
  }
  arena.soundInstances.length = 0;
}
```

- [ ] **Step 4: Update the parity ledger and limitations**

Mark source-verifiable attack, timing, damage, impulse, AOE, lifecycle, recovery, Arena, and conceptual swept-filter claims complete only after tests pass. Keep rendered-bone/world-contact and exact ordinary-melee hit-location claims capability-bounded. Include these official references:

```text
https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable
https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entityhurtbeforeevent?view=minecraft-bedrock-stable
https://learn.microsoft.com/minecraft/creator/reference/content/visualreference/geometry.v1.21.0?view=minecraft-bedrock-stable
```

- [ ] **Step 5: Run focused tests and diff checks**

Run: `node --test tests/fractured_runtime.test.mjs tests/fractured_multipart_model.test.mjs` and `git diff --check`
Expected: PASS and no whitespace errors.

- [ ] **Step 6: Commit cleanup and documentation**

```bash
git add TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/fractured_runtime.js TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md Todo.md tests/fractured_runtime.test.mjs tests/fractured_multipart_model.test.mjs
git commit -m "docs: close verified Jimmy parity items"
```

### Task 6: Run the full repository validation and prepare the PR

**Files:**
- Inspect: `.github/workflows/bedrock-addon-check.yml`
- Inspect: `git diff main...HEAD`
- Modify: implementation files only when a check identifies a concrete defect

**Interfaces:**
- Consumes: all committed model, runtime, test, and documentation slices.
- Produces: a clean branch, a PR, and verified GitHub Actions results.

- [ ] **Step 1: Run JavaScript tests**

```bash
npm test
```

Expected: all Node tests pass.

- [ ] **Step 2: Run TypeScript type checking**

```bash
npm run typecheck
```

Expected: exit code 0 against the repository's exact Bedrock preview dependency.

- [ ] **Step 3: Run Python and repository audit tests**

```bash
python -m unittest discover -s tests -p 'test_*.py' -v
```

Expected: all Python checks pass.

- [ ] **Step 4: Inspect the final diff**

```bash
git diff --check
git status --short --branch
git diff --stat main...HEAD
git log --oneline --decorate main..HEAD
```

Expected: only item 9 implementation, tests, documentation, design, and plan files are changed.

- [ ] **Step 5: Create the remote branch and PR**

Push `codex/jimmy-fractured-parity-9` through the configured GitHub integration and open a PR to `main`:

```text
Title: Finish Jimmy / Fractured / FracturedRoam parity

Summary:
- Implements source-backed rising, lifecycle, attack, movement, multipart sweep, and Arena cleanup parity.
- Adds focused tests for timing, transforms, latency-sized projectile sweeps, side-effect ordering, and reconnect cleanup.
- Documents the current Bedrock API boundary for rendered-bone origins and exact melee hit locations.

Validation:
- npm test
- npm run typecheck
- python -m unittest discover -s tests -p 'test_*.py' -v
- GitHub Actions workflow: bedrock-addon-check.yml
```

- [ ] **Step 6: Verify GitHub Actions**

Use GitHub to find the PR-triggered workflow run, inspect every job and log, and wait until checks finish. If a check fails, fix the concrete failure locally, commit it, and rerun the relevant local command before updating the PR.

- [ ] **Step 7: Report the handoff**

Return the PR URL, commit summary, local validation results, GitHub Actions status, and the two remaining API-bounded limitations. Do not report green CI until the workflow run is complete.
