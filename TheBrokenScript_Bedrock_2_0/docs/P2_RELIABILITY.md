# P2 — Reliability, deterministic parity tests, and performance

Reviewed: 2026-09-16

This document records the source-backed reliability, randomness, performance, and Script API safeguards delivered for the P2 section of `Todo.md`. It separates deterministic evidence from checks that require a running Bedrock client or server.

## 23. Expand source-backed regression tests

The focused regression surface now covers:

- inclusive integer and weighted-selection boundaries, strict probability boundaries, and negative eligibility paths;
- ambient horror-event selection, including no-player and arena suppression, handler filtering, and multiplayer target selection;
- player-presence and dimension-handle cache reuse, transient lookup failures, explicit invalidation, and world-load reset;
- persistence schema descriptors, defaults, additive migration, and compatibility values through the existing persistence parity suite;
- source-backed event/chat definitions, entity-family registries, persistence schemas, story-clock thresholds, and source-map category counts through `tests/fixtures/p2_source_snapshot.json`;
- a source-map lookup assertion for every shipped entity, including the documented `null_chase` → `nulll` alias.

The snapshot is intentionally plain JSON so a source constant or registry change is visible in a normal review diff. The broad “every mechanic” and “every threshold” Todo bullets remain partial where a behavior is coupled to the Bedrock engine and has no meaningful engine-independent model yet.

## 24. Randomness parity

`tools/audit_randomness.py` statically inventories the Java source tree and every direct Bedrock `Math.random()` call. The checked-in report currently contains:

| Inventory | Count |
|---|---:|
| Java random draws | 492 |
| Java random source expressions | 266 |
| Bedrock `Math.random()` calls | 157 |
| Bedrock runtime files with direct draws | 25 |

Java sources are classified as `world`, `entity`, `injected`, `local`, or `client`; unknown callsites fail the audit. The generated details are in [RANDOMNESS_AUDIT.md](RANDOMNESS_AUDIT.md).

The ambient event adapter follows the source picker order recorded in `decompiled_brokencore/net/thebrokenscript/brokencore/impl/event/engine/StatisticsEventPicker.java`:

1. global event-frequency roll;
2. target-player selection;
3. event-context boolean;
4. eligible-candidate filtering;
5. weighted event selection.

The candidate filter runs before the weighted draw and preserves the Java rule predicates. The model uses an injectable `random01` function for tests; production calls continue to default to `Math.random`, so the production probability distribution is unchanged.

## 25. Performance without behavior loss

The five 1-tick controller families audited in Chunk 16 retain their existing tick cadence and entity-scan coverage. The shared performance model only removes repeated work that is safe to cache:

- player presence is read once per tick and shared by the controller short-circuit;
- dimension handles are reused by name;
- failed dimension lookups are not cached;
- callers can explicitly invalidate one dimension or clear all handles;
- world load resets the performance and dimension caches;
- stable-ID entity references are re-resolved through `Entity.isValid` and invalidated on player leave/death;
- no particle count, scan frequency, AI frequency, or event-check reduction was introduced.

The current Script API does not expose a `Dimension.isValid()` handle method. The runtime therefore uses explicit invalidation after failed operations and reset on world load instead of probing an unsupported API shape.

`tools/profile_p2_scans.mjs --check` runs a deterministic 240-tick synthetic workload for idle, solo, small-multiplayer, large-multiplayer, and stress-multiplayer populations. It asserts that cached player reads are once per tick, controller dispatch is unchanged, entity-scan work is unchanged, and dimension reads do not increase. This is a regression profile, not an engine benchmark; an actual Bedrock profiler run remains follow-up work.

No defensive engine budget was added because this change has no measured authoritative engine limit to enforce. Adding a budget that skips a parity check would require an explicit, documented gameplay trade-off.

## 26. Script API/version safety

The repository remains on its existing contract; this change does not migrate the pack to stable or to the latest preview:

- Minecraft Bedrock product line: `1.26.50-preview`;
- BP and RP minimum engine: `[1, 26, 50]`;
- shipping `@minecraft/server`: `2.11.0-beta`;
- development `@minecraft/server` typings: `2.11.0-beta.1.26.50-preview.26`;
- shipping `@minecraft/server-ui`: `2.1.0`;
- development `@minecraft/server-ui` typings: `2.3.0-beta.1.26.50-preview.26`;
- required world experiment: `Beta APIs`.

`tools/validate_p2_contract.py --check` reads the manifests, `package.json`, runtime smoke matrix, `API_AUDIT.md`, and `BEDROCK_COMPATIBILITY.md` as one contract. `package-lock.json` pins the exact development packages and `npm ci` is used in CI. The validator also rejects the unsupported `Dimension.isValid()` call shape in the affected runtime adapters.

The upgrade rule is deliberate: a future Bedrock/API migration must re-check the old `ENGINE_UNSUPPORTED` and approximation entries, update the manifests and exact typings together, run static/pack validation, and complete the runtime smoke matrix before declaring the new build supported. This P2 change does not make that declaration; no in-game smoke report was available here.

## Validation commands

The focused checks are also part of `.github/workflows/bedrock-addon-check.yml`:

```text
python tools/audit_randomness.py --check
python tools/validate_p2_contract.py --check
node --experimental-vm-modules --test tests/horror_event_model.test.mjs tests/random_determinism.test.mjs tests/perf_model.test.mjs tests/p2_source_snapshot.test.mjs tests/p2_profile.test.mjs
node tools/profile_p2_scans.mjs --check
```

The full JavaScript, Python, syntax, type, add-on, resource, and packaging gates remain in the existing workflow. Runtime smoke is represented by `tests/runtime-smoke/matrix.json` but requires a matching Bedrock environment and is not claimed as run by this change.

## Documentation consulted

- [Microsoft Learn — Script Module Versioning](https://learn.microsoft.com/minecraft/creator/documents/scripting/versioning?view=minecraft-bedrock-stable)
- [Microsoft Learn — Dimension](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/dimension?view=minecraft-bedrock-stable)
- [Microsoft Learn — World](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/world?view=minecraft-bedrock-stable)
- [Microsoft Learn — Entity](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable)
- [Microsoft Learn — Script profiler command](https://learn.microsoft.com/minecraft/creator/commands/commands/script?view=minecraft-bedrock-stable)

BedrockWiki MCP was used as a cross-check for the current `Entity.isValid` property and the absence of a `Dimension.isValid` method; Microsoft Learn remains the authority for version-sensitive runtime claims.

## Limitations and follow-up

- The synthetic profile cannot measure actual Bedrock scheduler, chunk, or entity-query cost.
- An in-game runtime smoke run against the exact 1.26.50 preview build is still required for engine-level support claims.
- Static parity tests cannot prove visual, network, or unloaded-world behavior; those remain in the runtime smoke matrix and existing adaptation ledgers.
