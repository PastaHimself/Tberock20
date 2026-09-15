# Horror events and chat responses audit

The decompiled Java classes are the behavioral oracle. Registration counts are checked independently from runtime adapters, and every source registration now has an ordered Bedrock rule/handler entry.

## Registration reconciliation

`TBSChatResponses.java` registers **42** response objects. `horror_rules.js` contains the same 42 ids in the same order, including all fever, structure, funny, and miscellaneous responses. The previous “45 source responses vs 14 implemented responses” wording compared different snapshots and different units; the focused audit now compares the source registry with the actual response definitions.

`TBSEvents.java` registers **86** named events. `horror_rules.js` contains all 86 source ids and `horror_events.js` provides a concrete handler for each one, including the seven previously absent adapters: `noop`, `null_book`, `null_interface_trigger`, `obfuscated_sign`, `text`, `title_event`, and `aberration`.

## Event selection and gates

The ambient event engine now follows the source selection shape: once per server tick, one uniformly selected online player, the source frequency `2.9166666e-4`, source event-class/player gates, and one weighted selection. Event weights are persistent and use the source effective weight `weight / max(1, selectionCount)`. `moon_phase` has weight 5, `isolation` has weight 0, and all other registered events have weight 1. The selected event is executed only for the selected player; the developer `fire(id)` adapter remains an explicit manual override.

The rule definitions cover survival/null-profile categories, Null presence, reputation, dimension, day/night, moon phase/change, moon glitch duration, curious-entity exclusion, player-count, coordinate visibility, inventory progression, despawn state, and daylight-cycle readiness. Delayed event effects capture the player session and dimension and are cleared on death, disconnect, dimension change, and server reload.

## Chat matching and delivery

Chat normalization replaces non-ASCII-alphanumeric punctuation with spaces, collapses whitespace, and trims. Each response then applies its Java case-sensitivity and full-message/substring setting. The registry is searched in source order and the first matching registration owns the response, even when its execution gate later rejects the message. Responses preserve the source 100-tick default delay, zero-tick exceptions, sender-only Fever delivery, broadcast delivery, and the original chat message remains visible.

The response gates include Null presence, Limbo exclusion, Limbo Fever behavior, nearby watching structures, aftermath structures, and structure-radius checks. Reputation interactions record the source tier so `sorry` can restore half of the last loss tier. Delayed chat effects are session-, player-, and dimension-safe and are cleared on death, disconnect, dimension change, and reload.

## Bedrock API validation

The pack is pinned to `@minecraft/server` `2.11.0-beta`. Microsoft Learn documents the before-event `ChatSendBeforeEvent` sender/message fields, `System.runTimeout` tick scheduling, player validity, `WorldAfterEvents.playerDimensionChange`, and `PlayerLeaveAfterEvent`. The implementation leaves the chat event uncanceled and defers world mutations to scheduled callbacks. Bedrock Wiki's indexed Microsoft Creator API definitions were used as a cross-check for the same event and player lifecycle contracts.

## Known limitations

Desktop/window title, shader, screenshot, and Java `NullStructureBlockEntity` aftermath/fate behavior have no one-to-one Bedrock API. They use explicit title, state, marker-block, and entity/particle adapters; the audit does not claim client-mod parity for those effects. A Bedrock world/runtime smoke test remains dependent on Minecraft execution and is covered by the repository's package/static CI checks.
