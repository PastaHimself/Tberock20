# Horror events and chat responses audit

This audit records the source-backed registration and runtime contract for item 6. The Java/decompiled registry is the behavior oracle; alias count, response count, and runtime adapter count are kept as separate concepts.

## Source registration coverage

- 86 Java event registrations are represented in BP/scripts/systems/horror_events.js and the ordered contracts in BP/scripts/shared/horror_event_model.js.
- 42 Java chat-response registrations are represented in BP/scripts/shared/horror_chat_model.js.
- The source response registry is not the same unit as the historical 45 handlers label or the former generic Bedrock-key count. The parity denominator is the 42 ordered source registrations, with their aliases and response-specific gates attached.

Event IDs, in source order:

bsod, can_someone_hear_me, close_menu, damage, doors, explode_base, eyes, false_villager, giift, give_disc_11, heartbeat, hungry, jframe_1, jframe_2, jframe_3, jframe_4, jframe_5, lava_cast, look_and_damage, madness_1, moon_glitch, moon_phase, noop, null_book, nulled_gui, null_interface_trigger, null_invade_base, nullnullnull_advancement, null_particle, null_scare, null_title, obfuscated_sign, opengl_error, paranoia, place_all_dead, place_bedrock, place_cave_air, place_empty, place_flowing_water, place_hello, place_lava, place_netherrack, place_oak_sign, place_redstone_torch, place_water, play_sound, push, random_song, reset_rotation, set_do_daylight_cycle, set_on_fire, set_random_time_of_day, set_time, shadow_bug, strike_lightning, text, why_cant_you_leave, wrong_overlay, hallucination, title_event, experience, aberration, breathe, keep_playing, null_whisper, behind_you, run, cave, null_is_near, stare_at_player, psst_event, gamma, null_getting_achievement, rejoin, sky_blue, txt, inventory_corruption, door, tbe_curious, entity_discard, stick, coord, screen_dupe, isolation, fake_disconnect, collinlock.

Chat response IDs, in source order:

can_you_see_me, circuit, clan_build, entity_303, follow, friend, fuck_you, hello, herobrine, how_can_i_help_you, integrity, niw, null, ram2die, revuxor, steve, the_broken_end, void, what_do_you_want, who_are_you, i_am_scared, blackout, cal, catfish, overlord, whyer, dyexd, null_structure_positive, null_structure_negative, sorry, lucid, clanbase_curved, hello_structure, fever_hello, fever_where, fever_what, fever_who, fever_insult, fever_want, fever_sky, fever_homes, freebird.

## Event scheduling and selection

The source frequency curve is evaluated every server tick from absolute world time: a quadratic curve before day 55, a logarithmic continuation after day 55, capped at seven event ticks per day. Bedrock preserves the resulting frequency contribution, the 24000-tick base frequency, random-player selection, and source class/dimension/arena gates.

The event picker uses the source registry order and weight / max(1, timesUsed) for each candidate. It rerolls invalid candidates, increments only a successfully selected event, and persists the 86-entry use-count ledger in world state. moon_phase retains source weight 5; isolation is source weight 0.

## Chat matching and delivery

Java chat matching removes every non-ASCII-alphanumeric character, flattens whitespace, and compares cleaned aliases in registration order. Full-message matching is the default; who_are_you is the source substring exception. The null and Lucy B. Locks responses retain source case sensitivity. Fever aliases are gated to the limbo dimension and are delivered only to the sender.

All ordinary response text is additive: the before-chat callback does not set event.cancel. Effects are deferred through system.run and system.runTimeout; delayed callbacks re-check their lifecycle token before touching a player or dimension. State-only and staged responses intentionally stay silent when their source handler has no ordinary chat line.

## Lifecycle and engine boundary

Leave, spawn/respawn, death, dimension-change, and world reload invalidate response/event callbacks and clear transient timestamp maps. The adapter also checks API object validity before delayed world/entity operations.

Bedrock cannot reproduce Java OS window-title mutation, client-only shader/packet hooks, exact custom GUI screens, or full desktop rendering. Those surfaces are documented as explicit approximations; the event registry, chat normalization, delivery semantics, scheduling, gates, and cleanup paths are not left as count-only placeholders.

## Required validation

- node --experimental-vm-modules --test tests/horror_*test.mjs tests/commands_operator_dev.test.mjs
- npm run typecheck
- python tools/reconcile_parity_ledgers.py --check
- python tools/audit_source_to_runtime.py --check
- python tools/validate_addon.py
- python tools/validate_resource_links.py
- python tools/validate_mcstructures.py
- GitHub Actions workflow bedrock-addon-check.yml
