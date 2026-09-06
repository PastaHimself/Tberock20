# CHUNK_05C_SPEC — Null Pursuit/Endgame Family

## Source basis
- 6 entities: `null_chase` (nulll, HP80 mov0.3 atk20 450t/22.5s, 800 range, particles, midnight fake, 313? no 20dmg, forces survival), `null_maze` (HP75 mov0.3 3200t/160s, stalk+dynamic nav, light block, stuck break), `null_endgame` (HP80 mov0 420t/21s, 999 dmg/60t pulse, chat spam), `null_unbeatable` (HP910 mov0 flying, 500t/25s, invulnerable GK/void only, boss bar, summon BAN on kill), `null_flying` (HP810 mov0.3 3200t/160s, 25 above, FOV sneak 20t delay, 30 proximity dmg), `null_invade_base` (HP910 mov0 3200t, 15 FOV trigger, 70% overlay+lightning)
- Spawn via NullConditions where applicable (sky visible, isNullHere, 7200) or summoned

## Files
```
BP/entities/null_{chase,maze,endgame,unbeatable,flying,invade_base}.json (6)
RP/entity/null_*.entity.json (6) → geo notexture/nothing_watcher, textures null/anomaly
src/entities/null/null_pursuit_controller.js (timers 450/3200/420/500, chase/maze/endgame/flying/invade behaviors)
src/entities/null/null_pursuit_spawn_rules.js
```

## Validation
parse 137 JSONs; controller imports resolved.
