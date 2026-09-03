# Chunk 43 — Source event engine contract report

## Delivered

The event runtime now follows the recovered source scheduler contract:

- Absolute-time frequency uses the TBSEngineControl 55-day quadratic/log curve and aggregate default-controller offset.
- One random player is considered per tick; custom thebrokenscript: dimensions and active boss arenas suppress selection.
- Event definitions carry source weight 1, persistent counts divide effective weight, disabled IDs are filtered, and invalid events reroll according to config.
- Counts and disabled IDs persist through the Bedrock world-state service.
- Bedrock clock and game-mode access use the documented World.getAbsoluteTime() and Player.getGameMode() seams, with safe fallback behavior.
- Runtime defaults expose random events, rerolling, and debug feedback as config keys.

## Source-to-port mapping

| Source contract | Bedrock artifact | Result |
|---|---|---|
| TBSEngineControl.eventFrequency | event_scheduler_model.js | Frequency curve preserved |
| EventEngine.tick | horror_events.js | Per-tick one-player scheduler |
| StatisticsEventPicker | event_scheduler_model.js + horror_events.js | Disabled filtering, eligibility, rerolls |
| EventWeightTracker | world JSON eventWeights | Persistent inverse occurrence weights |
| EventsConfig | config_defaults.js + runtime config reads | Defaults preserved as keys |
| Bedrock clock/game mode | World.getAbsoluteTime() + Player.getGameMode() | Native seams with guarded fallbacks |

## Validation

- Local focused scheduler regressions: 3/3 PASS.
- Full local scratch Node suite: 15/15 PASS.
- GitHub Actions [run 33770176189](https://github.com/PastaHimself/tbs-2.0/actions/runs/33770176189): complete validator/package workflow PASS, including beta API type-check, JavaScript regressions, Blockception diagnostics, MCT validation, packaging, and report upload.
- Bedrock world/runtime smoke test: unavailable in the local environment.

## Known adaptations

- Java SavedData is represented by world JSON state.
- Java config UI is represented by config keys.
- Java custom Null screens, native desktop title/packet hooks, and source NBT structure placement retain the explicit Chunk 42 fallbacks.
- Handler-specific behavior remains bounded by the existing Bedrock event adapters and available Script API.
