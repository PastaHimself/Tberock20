# Chunk 46 — NulledGui screen adapter

## Objective
Port the source NulledGuiEvent and NulledGuiScreen contract.

## Source contract
- NulledGuiEvent opens the NulledGui menu with the NulledGui title.
- NulledGuiScreen renders Good luck. and )=.
- The source event emits the glitch sound cue.
- The source event also sets a client-side fake midnight state.
- Escape closes the source container screen.

## Bedrock design
- nulled_gui_model.js contains the pure title, messages, and stacked body contract.
- ported_features.js exposes showNulledGui as an ActionFormData reader with a safe Close path.
- horror_events.js routes nulled_gui to the form adapter and retains the existing glitch sound.
- The client-only fake-midnight state is documented as an explicit limitation rather than changing shared world time.

## Acceptance criteria
- source title and both visible messages are preserved.
- form body keeps the two messages readable and ordered.
- the active event opens the supported form without throwing.
- source glitch cue remains active.
- Java-only texture/container/fake-time presentation remains explicitly documented.

## Validation
- focused local model tests and full repository Node regressions.
- repository validators, beta API type-check, diagnostics, MCT, packaging, and report generation.
