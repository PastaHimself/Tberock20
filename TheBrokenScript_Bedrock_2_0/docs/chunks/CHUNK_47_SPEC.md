# Chunk 47 — FakeDisconnect screen adapter

## Objective
Port the source FakeDisconnectEvent/FakeDisconnectScreen contract.

## Source contract
- FakeDisconnectEvent opens the FakeDisconnect screen with Timed out as its title.
- FakeDisconnectScreen renders Connection Lost above Timed out.
- The screen exposes a Back to title screen button.
- Escape is disabled.
- The source event schedules cleanup after 100 ticks and manages a sound/music flag.

## Bedrock design
- fake_disconnect_model.js contains pure source heading/title/body/action and source metadata.
- ported_features.js shows the contract through ActionFormData.
- horror_events.js routes fake_disconnect to the form adapter.
- Java panorama, client disconnect transition, forced close, sound/music flag lifecycle, and Esc lockout remain explicit adaptations.

## Acceptance criteria
- source text and action label are preserved and ordered.
- the active event opens a supported form without throwing.
- the source 100-tick/escape/panorama metadata remains visible in the model/ledger.
- no shared world time or player state is mutated by the form adapter.
- Java-only disconnect/panorama presentation remains documented.

## Validation
- focused local model tests and full repository Node regressions.
- repository validators, beta API type-check, diagnostics, MCT, packaging, and report generation.
