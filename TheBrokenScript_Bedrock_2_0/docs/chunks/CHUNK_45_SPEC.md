# Chunk 45 — Null interface form adapters

## Objective
Port the source NullInterfaceTriggerEvent and its three Null interface screens.

## Source contract
- NullInterfaceTriggerEvent selects one of three Null interface events.
- Interface 1 opens NullInterface and renders behind you.
- Interface 2 opens NullInterface2 and renders 25 null labels in a five-by-five grid.
- Interface 3 opens NullInterface3 and renders help.
- Escape closes each Java container screen.

## Bedrock design
- null_interface_model.js contains pure screen definitions, text, titles, and grid shape.
- ported_features.js exposes showNullInterface as an ActionFormData adapter.
- horror_events.js routes null_interface_trigger to the selected form definition.
- The existing source nullInterfaceOutcome selection contract remains compatible with the new form adapter.

## Acceptance criteria
- all three source titles and player-visible text are preserved.
- the 25-cell NullInterface2 layout remains a five-by-five grid in the form body.
- invalid selections normalize safely without throwing.
- event execution opens a supported form and cancel/close does not break the event loop.
- Java-only texture/container presentation remains explicitly documented.

## Validation
- focused local model tests and full repository Node regressions.
- repository validators, beta API type-check, diagnostics, MCT, packaging, and report generation.
