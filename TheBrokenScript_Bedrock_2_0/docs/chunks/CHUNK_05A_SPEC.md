# CHUNK_05A_SPEC — Circuit Family

## Source basis (decompiled)
- 6 entities: `circuit` (chaser, HP 910, mov 0.4, atk 50, follow 64), `circuit_stalk` (HP 110, mov 0.3, follow 816), `circuit_stare` (immobile), `circuit_mineshaft_walk` (HP 910, mov 0.3), `circuit_mineshaft_stare` (immobile), `circuit_mineshaft_flee` (runner, HP10)
- Shared: 0.6×(1.8-2.0) size, fireImmune, pushable false (flee true), xp 0, persistenceRequired, invulnerable except GENERIC_KILL/FELL_OUT_WORLD, stepHeight up to 80.6
- Timers: grace 160 (circuit), spawning 10 (stalk/stare), lifetime 10000 (stalk/walk) / 300 (flee, pauses <25), despawn 15 (circuit), noWayOutFrame cycle 0-5 via 46-tick LOS
- Behaviors: stalk→ stare (gaze gates 100/20, 50% overlay, 70% transform), circuit chase (climb/wall destroy, mount 6t, Darkness/Blindness 5s, midnight fake, block break when stuck, boat discard 40)
- Handlers: inhabited delay 5200, ore chance 0.01 (isNullHere), entity chance 0.001, despawner radius 2000, blockBreaking config gate
- Sounds: intro, jumpscare, watching, you_know_nothing, chase; Overlays: blick.png, screenshot..., frame2.png

## Bedrock files to create
```
BP/entities/thebrokenscript_circuit.json + …_circuit_stalk|stare|mineshaft_* (6)
BP/spawn_rules/circuit*.json (minimal, director does real gating)
RP/entity/thebrokenscript_circuit*.entity.json (6) + render_controllers, textures via GEOMETRY_ID_MAP
src/entities/circuit/circuit_controller.js (server tick: grace→chase, wall climb approx, despawn, stare transform, flee)
src/entities/circuit/circuit_spawn_rules.js (register CircuitStalkConditions port into spawn_director)
```

## Validation
validate_pack.ps1 parse 129+ JSONs; geometry ids via docs/GEOMETRY_ID_MAP.json; no missing texture/geometry refs.
