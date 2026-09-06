# Chunk 48 — TornPaper and command-block screen adapters

## Objective

Port the source TornPaperItem/TornPaperScreen path and the CommandBlockGui/CommandBlockGuiConfirm screen pair into the supported Bedrock item/block/form seams.

## Source contract

- Torn Paper opens with title Torn Paper and shows `X: <chunk-center>   Y: 216   Z: <chunk-center>`.
- Torn Paper closes through the form cancel/Close path; the source screen is Esc-closeable.
- Command GUI shows Input Code, an empty input, and Execute.
- Its source glitch cycle uses a 0.005 chance, 35 ticks, and a 10-tick swap interval; the alternate headers are Leave and You Still Have Time.
- Correct code proceeds through dimension and initiator validation to confirmation; invalid code is evaluated first.
- Confirmation shows both warning lines and Yes; both source screens are non-pausing and Esc-closeable.
- Command-block giver gives the corrupted command-block item and removes itself.

## Bedrock design

- `command_block_model.js` contains pure source contracts, coordinate math, and decision order.
- `ported_features.js` uses `ActionFormData` for Torn Paper/confirmation and `ModalFormData` for command input.
- `custom_blocks.js` routes the corrupted command block and the command-block giver through the shared custom component.
- `torn_paper.json` registers the item-use component.
- Java textures/rotation, exact EditBox glitch rendering, packet/window-title transport, and native Integrity Arena kickoff remain explicit adaptations.

## Acceptance criteria

- Source coordinates and visible text/actions are preserved.
- Correct and invalid command branches follow the source order.
- Item and block interactions open supported forms safely.
- The codeApplied transition remains persisted before confirmation.
- The command-block giver has a supported give/remove adapter.
- No native Java packet/window assumptions leak into the Bedrock runtime.

## Validation

- Focused local TDD model regressions and the repository wiring regression.
- Repository validator, beta type-check, JavaScript regressions, Blockception diagnostics, Mojang Creator Tools validation, and packaging.
- Artifact uploads may remain unavailable while GitHub storage quota is exhausted; this does not invalidate the completed code/package gates.