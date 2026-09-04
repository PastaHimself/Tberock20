# Chunk 48 — TornPaper and command-block screen adapters

## Result

Chunk 48 is implemented on the stacked Bedrock branch. Torn Paper now opens a supported reader with source chunk-centered coordinates and Y 216. Corrupted command blocks now open a source-text-compatible code editor, preserve validation order, persist `codeApplied` before confirmation, and expose the two warning lines plus Yes. The command-block giver has a give/remove adapter.

## Source-to-Bedrock mapping

| Source path | Bedrock adapter | Preserved contract | Explicit adaptation |
|---|---|---|---|
| `TornPaperItem` / `TornPaperScreen` | `torn_paper.json` + `showTornPaper` | title, coordinate math, Y 216, Close, page-turn cue | Java texture, 15° rotation, exact screen layout |
| `CommandBlockGuiScreen` | `command_block_model.js` + `showCommandBlockGui` | Input Code, Execute, invalid-code-first branch, dimension/initiator checks | Java EditBox/glitch animation, packet/window-title feedback |
| `CommandBlockGuiConfirmScreen` | `showCommandBlockConfirm` | both warning lines, Yes, Esc/cancel behavior | native Integrity Arena kickoff remains deferred |
| `CommandBlockGiverBlock` | `custom_blocks.js` | give corrupted command block and remove giver | supported command adapter |

## Evidence and tests

- Source classes and language strings were read from the recovered decompiled/resource corpus.
- `command_block_model.js` covers the source dimensions, strings, coordinate math, glitch metadata, and invalid-code → invalid-dimension → invalid-position → confirm order.
- `tests/command_block_model.test.mjs` covers the model contracts and active item/block wiring.
- Local focused TDD model tests: 2/2 passed; the repository wiring regression is included in the repository suite.
- GitHub Actions [run 33866668553](https://github.com/PastaHimself/tbs-2.0/actions/runs/33866668553) passed validator, beta type-check, JavaScript, Blockception, Creator Tools, and packaging gates. Artifact uploads failed because GitHub artifact storage quota is exhausted.

## Remaining differences

The current Bedrock form/block seam cannot reproduce Java textures, client rotation, exact EditBox glitch presentation, packet-driven native title updates, or native Integrity Arena startup. Bedrock world/runtime smoke testing is also unavailable in this environment.