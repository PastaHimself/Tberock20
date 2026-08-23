# CHUNK_12_REPORT

## Source examined
- 95 event classes (`events/**`): 81 TBSEvent registrations + 14 story/misc (TXTStory, CoordsStory, MoonCorruptionStory, NullBookStory — already ported in Chunks 02/09; NoopEvent; menu provider classes)
- Event id roster extracted from `TBSEvents.java` registrations: 81 ids across categories — ambient audio (heartbeat/play_sound/random_song/psst/breathe/cave), OS-fakes (jframe_1-5, opengl_error, nulled_gui, screen_dupe, fake_disconnect, bsod via WindowTitle/BSODEvents, close_menu, keep_playing, why_cant_you_leave, rejoin, isolation, collinlock), null-flavored (null_title/particle/scare/is_near/whisper, stare_at_player, behind_you, run, null_invade_base), damage-ish (damage, look_and_damage, set_on_fire, push, stick, explode_base, lava_cast, hungry, paranoia, madness_1, eyes), time/sky (set_time, set_random_time_of_day, set_do_daylight_cycle, moon_phase, moon_glitch, sky_blue, gamma, reset_rotation), placement pranks (place_bedrock/cave_air/empty/hello/netherrack/redstone_torch/water/flowing_water/lava/all_dead/oak_sign), entities (false_villager, strike_lightning, shadow_bug, hallucination, entity_discard, tbe_curious), progression (give_disc_11, giift, experience, inventory_corruption, nullnullnull_advancement, null_getting_achievement, can_someone_hear_me, coord, txt, doors, door)

## Implemented
- **`src/systems/horror_events.js`** — data-driven choreography engine:
  - 78-entry TABLE covering the full TBSEvents roster with story gates (always / null / nullHere / moon)
  - Weighted ambient pool: every 200 ticks fires up to 2 distinct events at all online players; suppressed while Arena active
  - ~60 typed handlers sharing helpers (playNear/title/actionBar/placeAt/offsetFrom/giveItem); OS-level fakes approximate to titles per A-004; place_* pranks use real Chunk-08 blocks where custom (empty/hello/all_dead)
  - `fire(id)` manual trigger export (for Chunk 13 commands) + EVENT_COUNT
- **Wiring**: main.js begins horrorEvents on world load; manifest re-corrected to `"beta"` after another external revert (validator caught malformed `2.7.0-beta.1.26.10-stable`)
- Sync 43 modules, validate_pack PASS (489 JSONs)

## Validation
| Check | Result |
|---|---|
| Event coverage | 78/81 TBSEvents ids mapped (remaining 3 are no-op/menu-provider internals) |
| validate_pack.ps1 | PASS (489 JSONs) |
| Gates | isNullHere/hasNullSpawned/hasMoonCorrupted consumed from world_state |

## Parity
`medium-high` for choreography feel — thresholds replaced by gated random pool (source uses per-event day schedules + weights); exact per-event timings/weights not extractable from bytecode without deeper analysis of each class's super() args (95 files). OS-integration events remain A-004 approximations by design.

## Unresolved defects
- Per-event source timing fidelity (day-based schedules) deferred to Chunk 17 parity audit pass
- MenuProvider-style GUI sequences (null_interface_1-3) approximated as title beats only

## Next chunk prerequisites
Ready: Chunk 13 = Progression/recipes/loot/tags/commands — advancements registry (5), recipes (40), loot tables, `/tbs` command surface incl. horrorEvents.fire.
