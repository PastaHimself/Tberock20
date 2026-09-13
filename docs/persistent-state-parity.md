# Persistent state parity

This report closes Todo item 5. The Java attachments are `MapVariables` (world saved data) and `PlayerVariables` (per-player NBT). Bedrock stores their canonical fields under the namespaced `mv.*` and `pv.*` dynamic-property adapters.

## Canonical field contract

`core/persistence_schema.js` is the source/deploy-synchronized contract. Every Java field is declared once with its Java type, Bedrock storage type, default, and `reset: "never"` policy. The validator compares that contract directly with the decompiled Java field declarations.

| Java field | Bedrock key/storage | Default or migration rule |
| --- | --- | --- |
| `MapVariables.commandBlockLocation` | `mv.commandBlockX/Y/Z` numeric properties | `(0, 0, 0)`; three values preserve the Java `BlockPos` |
| `PlayerVariables.spawnPos` | `pv.spawnPos` Bedrock `Vector3` | `{x: 0, y: 0, z: 0}`; legacy scalar keys are read first |
| `PlayerVariables.customSkyColor` | `pv.customSkyColor` Bedrock `Vector3` | `{x: 0, y: 0, z: 0}`; legacy RGB keys are read first |
| `PlayerVariables.doors` | `tbs:pj:pv.doors` JSON property | empty list |
| `PlayerVariables.isolationAllowedUsers` | `tbs:pj:pv.isolationAllowedUsers` JSON property | empty list |
| All remaining primitive fields | `mv.*` or `pv.*` dynamic properties | Java constructor defaults; only missing properties receive defaults |

The extra Bedrock-only `mv.nullBookGiven`, `pv.nullBookDelivered`, and legacy scalar compatibility keys are kept outside the Java field roster. They are additive and never reset existing values.

## Lifecycle and migration rules

- Core adapter metadata is monotonic: a missing schema starts at version 2, version 1 upgrades to version 2, and a future version fails loudly instead of rewriting gameplay data.
- World initialization and player initialization use missing-only writes. Respawn calls `playerState.init` again, so it can repair a missing property without resetting saved progress.
- Java lifecycle resets remain separate from attachment initialization: initial join clears `showCoords`, `musicCausedByTBS`, and `glitchesEnabled`; respawn clears `pixelateEnabled` unless the player is in the Lucid dimension.
- Existing legacy player keys (`tbs:ban`, `tbs:fixPos`, `tbs:skipFallDamage`, `tbs:triangleKickTimer`, scalar spawn/RGB coordinates) are copied into `pv.*` only when the canonical key is absent. Legacy keys remain readable for rollback compatibility.
- Progression awards are keyed by player identity and persisted on the player. A runtime cache is only an optimization, so an award remains consumed after script reload and two players do not share it. The Null Book delivery ledger is also player-persisted, while `mv.nullBookGiven` remains the world-level completion flag.
- Portal anchors and timed ported effects are transient. Persisted transient properties are removed on an initial spawn/rejoin; timed properties are also removed with `undefined` after expiry. A respawn does not discard an in-progress transient handoff. The one-tick Jim trigger touch marker is removed after its handoff tick.
- World arena/portal-link state is stored on the world. Player attachment state is stored on the player; controller code no longer writes the canonical ban, fix-position, fall-damage, or triangle-kick fields as global/world state.

## Entity policy

The entity policy makes the remaining entity-owned state explicit:

- `tbe:variant` is persistent entity state on `the_broken_end_ambush`, matching Java `TheBrokenEndAmbushEntity.addAdditionalSaveData` / `readAdditionalSaveData`.
- Controller `Map` timers, `extraState`, and cooldown maps are runtime-only and are not serialized.
- `integrity_arm` (GroundArm) and `chord_projectile` intentionally omit `minecraft:persistent`; the validator requires both to remain explicitly listed as non-persistent.
- Other shipped custom entity definitions must declare `minecraft:persistent`, preventing an accidental change in entity lifetime from silently changing Java persistence behavior. The validator also checks the declared Java save/load key for each persistent entity-owned property.

## Validation

Run locally with:

```bash
python tools/validate_persistent_state.py
node --test tests/persistent_state_parity.test.mjs
python -m unittest tests.test_persistent_state_validator -v
```

The `Bedrock Add-on Check` GitHub Actions workflow runs this validator before the source-to-runtime audit, alongside the existing JavaScript, type, pack, and MCT checks.

The storage decisions follow the Bedrock Script API contract: dynamic properties support primitives and `Vector3`, `undefined` removes a property, and world/entity state access belongs after `worldLoad`.

- [Microsoft Learn: World dynamic properties](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/world?view=minecraft-bedrock-stable)
- [Microsoft Learn: Entity dynamic properties](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable)
- [Microsoft Learn: Scripting V2 lifecycle](https://learn.microsoft.com/minecraft/creator/documents/scripting/v2-overview?view=minecraft-bedrock-stable)
- [Bedrock Wiki: Script server persistence reference](https://github.com/Bedrock-OSS/bedrock-wiki/blob/wiki/docs/scripting/script-server.md)
