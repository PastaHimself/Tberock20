# Chunk 37 — Fractured audio lifecycle adapter

## Goal

Port the source Fractured/Jimmy spawn cue and JimArena audio cleanup while
keeping the existing Roam lifecycle and animation presentation unchanged.

## Source contract

- `BaseFracturedEntity.playSpawnSounds()` plays `jimmy.spawn` when the
  Fractured presentation enters its spawn sequence.
- `JimArena` starts `jimbob.intro`, then starts `jimbob.loop` after
  `START_MUSIC_TICKS = 340`.
- `JimArena.reset()` delegates to the source audio fader and stops active arena
  audio before clearing the arena.

## Bedrock adapter

- Emit `thebrokenscript:jimmy.spawn` once when a Fractured or FracturedRoam
  runtime state is first created.
- Retain `SoundInstance` handles returned by each arena player's
  `playSound()` call.
- Stop and clear those handles during arena reset. The target pack floor is
  `@minecraft/server` `2.11.0-beta`, where `SoundInstance.stop()` is available.

## Non-goals

Bossbar, camera, packet transport, exact render-bone positions, and guaranteed
cross-client audio attenuation remain outside this chunk.

## Acceptance

- Runtime source contains one guarded spawn-sound hook per host state.
- Intro and loop sounds retain stoppable handles and reset stops every handle.
- Focused runtime regressions and the full Node suite pass.
