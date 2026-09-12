# Command and operator/dev audit

This audit is scoped to Todo item 15 and uses the repository's extracted/decompiled Java classes as the behavioral oracle.

## Proven Java command root

`TBSCommands.register` creates a `tbs` command group at Java permission level `4`. The root registers exactly three branches visible in that class:

- `tbs devmode [code]` — implemented by `DevModeCommand`; accepted codes are `2018` and `544253`, both reply `Have fun!` and spawn one thousand of the corresponding source entity; any other code fails with `Dev mode code is invalid!`.
- `tbs reputation` — player-only. It reports the numeric `entityReputation`, then `BAD` (<=25), `NORMAL` (<=75), or `GOOD` (>75) with the source description.
- `tbs dev ...` — implemented by `DevCommands`; it has an additional BrokenCore `enableCheats` guard and fails with `Cheats are not enabled!` when disabled.

The local `tbs dev` dispatcher registers these source-backed families: `arena`, `jim arena`, `boss`, entity commands, give commands, player commands, structure commands, world commands, set commands, FX commands, summon commands, reputation debug, `code`, `coord`, and `update_capes [players]`, plus BrokenCore chunk/time/overlay/event/popup/inspect/entity command families. The recovered local source proves, among others:

- `tbs dev arena start|create|next|kill_phase_3|destroy|arms`
- `tbs dev boss animate [entity]`, `kit [players]`, `bar [players] [show] [value]`, `jim_bar [players] [show] [value]`
- `tbs dev code get|reroll|status`
- `tbs dev update_capes [players]`

The first Todo subcheck remains unchecked because every nested local and BrokenCore command signature, default, feedback string, and side effect has not yet been exhaustively transcribed into a checked inventory. No missing signature is guessed here.

## Bedrock permission mapping

The pinned pack uses `@minecraft/server` `2.11.0-beta`. Custom commands were added in Script API 2.1.0, so this target can register them during `system.beforeEvents.startup` through `StartupEvent.customCommandRegistry`.

Java's permission-level `4` does not have a one-to-one Bedrock equivalent. Bedrock `CommandPermissionLevel.Admin` is the closest in-game operator-only level: it requires Operator Commands permission and excludes command blocks/automation. `Host` and `Owner` are not equivalent because they restrict execution to the game owner or dedicated-server console. The Java `tbs dev` subtree's extra cheats setting maps to `cheatsRequired: true` when individual dev commands are ported.

`tbs:reputation` is therefore registered at `CommandPermissionLevel.Admin` with `cheatsRequired: false`: it preserves the Java root permission intent without incorrectly importing the separate dev-cheats requirement. The Java player-only failure text is preserved exactly.

## Implemented Bedrock production subset

`/tbs:reputation` is the only new production custom command in this item-15 change. Bedrock requires custom command names to be namespaced, so the source `tbs reputation` literal is represented by the existing `tbs` namespace plus the source subcommand name. Its state source is the already-ported `player_state.entityReputation` field.

The Java hover component used for the reputation explanation has no direct string-message equivalent in this implementation. Bedrock sends the same source-backed category and description as visible lines instead of inventing a hover interaction.

## Dev/regression hooks versus player-facing behavior

The pre-existing `/scriptevent tbs:*` handlers (`help`, `fire`, `events`, `arena`, `shaft`, `dim`, `adv`, `effect`) are Bedrock-only developer/regression hooks. They are not claimed as Java command parity. `/scriptevent` itself is a Game Directors command and requires cheats in Bedrock, and the handler additionally rejects non-player `sourceEntity` values.

Player-facing horror chat responses were moved unchanged to `systems/horror_chat.js`; `systems/commands.js` now contains production custom-command registration plus developer/regression hooks only. This preserves behavior while making the production/dev boundary explicit.

The hooks remain useful regression entry points for high-risk event, arena, structure, dimension, progression, and effect systems, but their existing names/messages/side effects were not rewritten because the Java command tree does not establish those Bedrock-only interfaces.

## Remaining blocker for full item 15 parity

Full completion requires an exhaustive inventory of every nested command registered by the local dev command files and the BrokenCore command implementations, followed by a source-by-source feasibility mapping. Several Java dev commands depend on Java-only packet, overlay, inspection, chunk, popup, or engine/debug facilities; unsupported cases must be documented individually rather than approximated. Until that inventory and mapping is complete, the Todo enumeration and full feedback/side-effect comparison subchecks remain intentionally unchecked.

## API validation basis

- Bedrock Wiki MCP / Microsoft Creator Script API: `StartupEvent.customCommandRegistry`, `CustomCommandRegistry.registerCommand`, `CustomCommand`, `CommandPermissionLevel`, `CustomCommandStatus`, and `CustomCommandOrigin.sourceEntity`.
- Microsoft Learn custom-command guidance: custom commands register during startup; command callbacks run in before-event context, so world/state work is deferred with `system.run`; `Admin` is operator-only and cannot be invoked by command-block/script automation.
- Microsoft Learn `/scriptevent`: Game Directors permission, cheats required.
