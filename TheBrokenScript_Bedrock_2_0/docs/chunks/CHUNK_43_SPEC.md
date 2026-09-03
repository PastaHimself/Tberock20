# Chunk 43 — Source event engine contract

## Objective

Port the source random-event engine contract behind the existing Bedrock horror-event adapters.

## Source contract

- TBSEngineControl.Companion.eventFrequency(gameTime) evaluates the source curve in absolute ticks: quadratic until day 55, logarithmic afterward, capped at 7, then divided by 24,000 and offset by -2.9166666E-4.
- The brokencore engine aggregates the default controller offset, so a fresh world begins at zero random-event probability.
- EventEngine.tick selects one random player per server tick and asks the event picker to select an event.
- StatisticsEventPicker filters configured-disabled IDs, applies inverse occurrence weighting, checks canExecute, rerolls when enabled, and increments the tracker only after a successful selection.
- Source event registrations currently construct with weight 1; the persistent tracker starts each event at count 1.

## Bedrock design

- event_scheduler_model.js contains pure frequency, aggregate-frequency, weighted-pick, disabled-filter, and reroll logic.
- horror_events.js schedules every tick, selects one player, gates custom dimensions/arenas, uses World.getAbsoluteTime() and Player.getGameMode() when exposed, and invokes one selected handler.
- Event occurrence counts and disabled IDs use the existing world JSON persistence service.
- Source defaults are exposed through events.enableRandomEvents, events.rerollEvents, and events.eventDebug.
- The seven Chunk 42 event adapters remain the selected handler catalog.

## Acceptance criteria

- The frequency curve is zero in aggregate at time zero, grows after the source threshold, and respects the source cap.
- Weighted selection skips disabled IDs, divides each event weight by its persisted occurrence count, and increments only the selected event.
- Invalid candidates reroll when enabled and stop when disabled.
- The scheduler respects the source one-player-per-tick and survival eligibility contracts.
- Java-only GUI, desktop-window, packet, and NBT-structure mechanisms remain explicitly documented adaptations.

## Validation plan

- Run focused scheduler tests and the full Node regression suite.
- Run repository validators, beta API type-check, diagnostics, MCT validation, packaging, and report generation through GitHub Actions.
- Record source evidence and remaining engine limitations in the parity, adaptation, limitation, and validation ledgers.
