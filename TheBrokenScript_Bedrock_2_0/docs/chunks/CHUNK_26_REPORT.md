# Chunk 26 report — Chord projectile

## Ported

- Moved Chord projectile movement and collision ownership into `chord_projectile_runtime.js`.
- Preserved source speed, zero inaccuracy, initial-position distance expiry, transient/no-gravity entity setup, Chord self-hit discard, ordinary entity handling, creative-player discard, gravity restoration, and the 20-tick block-hit countdown.
- Removed the legacy projectile tick path from `boss_controller.js` so collision and damage are not processed twice.
- Kept the unresolved BrokenCore damage formula as the explicit Bedrock 6-damage adapter.
- Added the exact Java face-offset table and documented the target-height and renderer differences.

## Validation

- Chord-focused regression suite: 7 tests passed.
- The Chord-focused Node suite: 7 tests passed.
- `node --check` passed for the changed Chord modules and boss controller.
- Touched entity JSON parsed successfully.
- `bedrock_debugger.py` reported 0 errors and 0 warnings on the materialized pack.
- A Bedrock runtime world is not available in this workspace; runtime smoke testing remains a CI/device check.

## Source and API evidence

- Java: `decompiled/net/thebrokenscript/entity/boss/ChordEntity.java`, `ChordProjectileEntity.java`, and `decompiled_brokencore/.../UwuableArrow.java`.
- [`Entity.applyDamage`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable)
- [`Entity.triggerEvent`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entity?view=minecraft-bedrock-stable)
- [`EntityDamageCause.projectile`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/entitydamagecause?view=minecraft-bedrock-stable)
- [`Player.getGameMode`](https://learn.microsoft.com/minecraft/creator/scriptapi/minecraft/server/player?view=minecraft-bedrock-stable)
