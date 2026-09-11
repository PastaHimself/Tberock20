# The Broken Script 2.0 — Bedrock Port

This repository is a Minecraft Bedrock port of **The Broken Script 2.0** for Java/NeoForge.

## Primary goal

The Bedrock edition should behave **as close to the Java version as Bedrock allows**.

The Java implementation is the behavioral reference. Do not invent, simplify, rebalance, or redesign a mechanic merely because a different Bedrock implementation is easier. When Java behavior is reachable from Bedrock APIs, reproduce it. When an exact port is impossible because of an engine/API limitation, preserve the player-visible behavior as closely as possible and document the difference explicitly.

**Porting rule:** source fidelity first, Bedrock adaptation second.

## Source of truth

When implementations or documents disagree, use this order:

1. Decompiled Java source and original data/resources under `decompiled/`, `decompiled_brokencore/`, and `source_extracted/`.
2. Observable Java runtime behavior when source intent is ambiguous.
3. Source-backed tests, constants, timelines, tables, and source maps.
4. Bedrock implementation under `TheBrokenScript_Bedrock_2_0/`.
5. Progress/documentation claims.

Do not treat a previous Bedrock approximation as authoritative if the Java source provides more exact behavior.

## Current state

The port already contains a large amount of implemented content and validation. `PORT_PROGRESS.md` records chunks 00–38 as completed, and the project has static validators, Script API type checking, regression tests, resource checks, and packaging checks.

However, **chunk completion is not the same as proven Java parity**. The family-level `PARITY_MATRIX.md` still contains stale `uninspected`, `unknown`, and `in_progress` entries for systems that later progress chunks report as implemented. Runtime smoke testing is also still required for important gameplay paths. The active audit/rework backlog is therefore maintained in [`Todo.md`](Todo.md).

## Definition of parity

A mechanic is not considered parity-complete merely because it exists on Bedrock. For each Java feature, verify as applicable:

- trigger conditions and negative conditions;
- probabilities, random ranges, weights, and selection rules;
- tick timing, delays, cooldowns, durations, and ordering;
- health, damage, knockback, movement, ranges, hitboxes, and targeting;
- AI/state-machine transitions and interruption rules;
- spawn/despawn rules and dimension/biome restrictions;
- block, item, inventory, loot, recipe, and persistence side effects;
- quest/story prerequisites, flags, rewards, dialogue, and one-shot behavior;
- sounds, particles, animations, camera/UI presentation, and event timing;
- multiplayer ownership/targeting semantics;
- save/reload/death/respawn behavior;
- failure and edge cases.

If exact parity is blocked by Bedrock, record the Java behavior, the Bedrock limitation, the replacement behavior, and the player-visible difference in the adaptation/limitations documentation.

## Parity workflow

For every feature or bug fix:

1. Locate the exact Java class/data/resource responsible for the behavior.
2. Trace all relevant constants, callers, state, timers, random branches, and side effects. Do not port one method in isolation when its behavior depends on another class.
3. Compare the current Bedrock implementation against that source behavior.
4. Fix missing behavior, wrong constants, wrong ordering, approximations that can now be made exact, persistence errors, multiplayer errors, and presentation/timing drift.
5. Add or update focused regression tests where the behavior can be modeled outside Minecraft.
6. Run repository validation and type checks.
7. Runtime-smoke-test the mechanic in the matching Bedrock build when it depends on actual game-engine behavior.
8. Update `SOURCE_MAP.json`, `PARITY_MATRIX.md`, `PORT_PROGRESS.md`, `ADAPTATION_NOTES.md`, and/or `KNOWN_LIMITATIONS.md` so the ledgers match the code.

## Priority

Work in this order:

1. **P0 — correctness/parity blockers:** missing Java features, broken progression, wrong state persistence, wrong event gates/timing, crashes/errors, multiplayer correctness, or unverified source coverage.
2. **P1 — mechanic fidelity:** AI, bosses, entities, quests/story, events, worldgen, structures, portals, items, loot, commands, animation/audio/particle timing, and source-accurate constants.
3. **P2 — robustness and maintenance:** deterministic tests, documentation/ledger synchronization, performance improvements that preserve behavior, and Script API migration safety.

See [`Todo.md`](Todo.md) for the live detailed checklist.

## Important parity documents

- [`TheBrokenScript_Bedrock_2_0/PARITY_MATRIX.md`](TheBrokenScript_Bedrock_2_0/PARITY_MATRIX.md) — family-level source → Bedrock parity ledger.
- [`TheBrokenScript_Bedrock_2_0/SOURCE_MAP.json`](TheBrokenScript_Bedrock_2_0/SOURCE_MAP.json) — component-level source inventory mapping.
- [`TheBrokenScript_Bedrock_2_0/PORT_PROGRESS.md`](TheBrokenScript_Bedrock_2_0/PORT_PROGRESS.md) — historical chunk implementation log.
- [`TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md`](TheBrokenScript_Bedrock_2_0/ADAPTATION_NOTES.md) — documented engine-driven adaptations.
- [`TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md`](TheBrokenScript_Bedrock_2_0/KNOWN_LIMITATIONS.md) — known Java features that cannot be reproduced exactly on Bedrock.
- [`TheBrokenScript_Bedrock_2_0/API_AUDIT.md`](TheBrokenScript_Bedrock_2_0/API_AUDIT.md) — pinned Bedrock Script API/runtime contract.

## Validation

The current repository audit documents these core validation commands:

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

Static validation does **not** replace in-game validation. Anything involving engine AI, collision, damage, spawning, dimensions, camera/UI, sound instances, animation playback, multiplayer, save/reload, or beta Script API behavior should be smoke-tested in the targeted Bedrock runtime.

## Bedrock-only limitations

Some Java mechanisms do not have a direct Bedrock add-on equivalent. Current documented examples include Java mixins/packet interception, the Java GLSL post-processing pipeline, true custom fluid physics, Java custom damage/effect/advancement registries, exact custom noise generators, Java multipart/render-bone access, OS/window integration, and some transport/camera behavior.

These are **not permission to drop the mechanic**. Preserve the observable gameplay result where possible, keep the adaptation narrowly scoped, and continue to re-evaluate old workarounds when the Bedrock API gains new capabilities.

## Contribution standard

A parity change should answer four questions clearly:

- **What does Java do?**
- **What did Bedrock do before the change?**
- **What now matches, with tests/evidence?**
- **What still cannot match, and why?**

The target is not merely a functional Bedrock remake. The target is the closest practical Bedrock reproduction of the Java mod.