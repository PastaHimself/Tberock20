# Horror events and chat responses audit

This audit is intentionally registration-focused. Repository-backed Java/decompiled code is the behavioral oracle; registration counts are not treated as feature-parity counts.

## Chat-response count discrepancy

`decompiled/net/thebrokenscript/registry/TBSChatResponses.java` registers **42** chat-response objects, not 45. The registered ids are:

`can_you_see_me`, `circuit`, `clan_build`, `entity_303`, `follow`, `friend`, `fuck_you`, `hello`, `herobrine`, `how_can_i_help_you`, `integrity`, `niw`, `null`, `ram2die`, `revuxor`, `steve`, `the_broken_end`, `void`, `what_do_you_want`, `who_are_you`, `i_am_scared`, `blackout`, `cal`, `catfish`, `overlord`, `whyer`, `dyexd`, `null_structure_positive`, `null_structure_negative`, `sorry`, `lucid`, `clanbase_curved`, `hello_structure`, `fever_hello`, `fever_where`, `fever_what`, `fever_who`, `fever_insult`, `fever_want`, `fever_sky`, `fever_homes`, `freebird`.

`BP/scripts/systems/commands.js` currently has **13** generic Bedrock response keys:

`null`, `herobrine`, `the_broken_end`, `integrity`, `circuit`, `hello`, `friend`, `who_are_you`, `what_do_you_want`, `i_am_scared`, `void`, `steve`, `sorry`.

These numbers are not comparable units. A Java registration points to a `ChatResponse` class that owns its own trigger aliases, `isFullMessage`, case sensitivity, delay and `shouldExecute` gates. For example, `HelloResponse` alone has 40 full-message aliases, is case-insensitive, uses a 100-tick delay, requires the source `isNullHere` state, excludes Limbo, and excludes a nearby `watching` null structure. The Bedrock table instead performs one exact lookup after `toLowerCase().trim()` and currently does not reproduce those per-response gates/delays. Therefore the prior “45 source responses vs 14 implemented” wording must not be interpreted as 31 missing aliases/features, and adding aliases without their source conditions would be incorrect.

The focused regression test `tests/horror_chat_registration_audit.test.mjs` pins the actual 42/13 registry/rule counts and current exact Bedrock normalization so future audits cannot silently regress to the stale 45/14 comparison.

## Horror-event registration

`decompiled/net/thebrokenscript/registry/TBSEvents.java` registers **81** named source events. `BP/scripts/systems/horror_events.js` currently places **79** unique ids in its ambient `TABLE`. The Bedrock ambient scheduler runs every 200 ticks, returns immediately with no players or while `tbs:arenaActive` is true, makes two distinct-id attempts per tick, checks the table gate (`null`, `nullHere`, `moon`, or always), and then applies the selected handler to every online player.

The Bedrock gate mapping is:

- `null`: `isNullHere || hasNullSpawned`
- `nullHere`: `isNullHere`
- `moon`: `hasMoonCorrupted`
- `null` JavaScript value: always eligible

Manual `fire(id)` bypasses those scheduler gates and executes the named Bedrock handler for every online player. This distinction is intentional in the audit: manual command exposure is not evidence that the ambient Java registration conditions are matched.

As with chat, **81 vs 79 is not by itself evidence of two missing features**. Some Java events are UI/desktop adapters or are driven elsewhere in the Bedrock port. No runtime mechanic, probability, cooldown, delay, player-selection rule, cleanup path, alias, or dimension gate is changed by this audit unless the corresponding Java implementation establishes it.

## Bedrock API validation

The pack is pinned to `@minecraft/server` `2.11.0-beta`. Bedrock Wiki's indexed Microsoft Creator API definitions confirm `ChatSendBeforeEvent.message`, `sender`, and cancellable `cancel`, and `Player.sendMessage`. Microsoft Learn's event guidance shows `world.beforeEvents.chatSend.subscribe(...)`; `System.runTimeout` is available for tick-delayed work. The current chat handler uses `system.run(...)` to defer the response out of the before-event callback, which is compatible with the documented before-event write restrictions.

## Scope decision

No Java response was promoted to a Bedrock runtime alias in this change because the inspected source demonstrates that aliases are coupled to class-specific execution conditions and delays. The evidence-backed fix is the count/normalization regression guard plus this audit record; runtime parity work must port each response/event from its concrete Java class rather than infer behavior from registration counts.
