# Chunk 37 — Fractured audio lifecycle adapter

## Result

The Fractured runtime now emits the source `jimmy.spawn` cue once per
Fractured/FracturedRoam host state. JimArena intro and loop tracks retain the
Bedrock `SoundInstance` handles returned by `Player.playSound`, and arena reset
stops and clears those handles before removing the arena entities.

## Source evidence

- `decompiled/net/thebrokenscript/api/entity/BaseFracturedEntity.java`
  (`playSpawnSounds`)
- `decompiled/net/thebrokenscript/boss/jimmy/JimArena.java`
- `decompiled/net/thebrokenscript/boss/jimmy/AudioFader.java`

## Validation

- TDD RED: the new Fractured audio contract test failed because the runtime had
  no `SoundInstance` retention, stop path, intro bridge, or spawn cue.
- TDD GREEN: `node --test tests/fractured_runtime.test.mjs` — **5/5 passed**.
- Bedrock API grounding: Microsoft Learn documents `Player.playSound()` handles
  and `SoundInstance.stop()` for the target API line.
- Bedrock world/runtime smoke testing remains unavailable locally.
- GitHub Actions run 125 ([Bedrock Add-on Check](https://github.com/PastaHimself/tbs-2.0/actions/runs/33642389983)): **success**; the validator, full add-on/resource checks, Bedrock beta type-check, JavaScript regressions, Blockception diagnostics, and packaging completed successfully.

## Parity

Source spawn/audio-reset ownership is now represented. The Bedrock adapter still
uses the supported server sound handles rather than Java's client-only
`FancyAudio`/`AudioFader` implementation, and exact local attenuation remains a
runtime presentation difference.
