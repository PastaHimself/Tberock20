# CHUNK_40_SPEC — Story Clock and Day-Cycle Parity

## Goal

Finish TODO item 4 by reproducing the Java story dispatcher’s day-cycle and
player-presence semantics in the pinned Bedrock Script API runtime, and verify
the complete source story schedule without losing exact tick offsets.

## Source contract

The decompiled `brokencore` `StoryEvents.tick()` implementation:

1. returns immediately when `GameRules.RULE_DAYLIGHT` is disabled;
2. increments persisted story time only when at least one player is online; and
3. evaluates events at the resulting persisted time, including when daylight
   is enabled but no players are online.

The source event classes register exact thresholds at `Time.days(day) + 1000`:

- TXT: days 5, 10, 15, and 20;
- coordinates hint: day 6;
- null book: day 12; and
- moon corruption: days 24, 32, 38, and 48.

## Bedrock design

- Read `world.gameRules.doDayLightCycle`, exposed by the pinned
  `@minecraft/server` `GameRules` API.
- Keep the tick decision pure in `shared/story_clock_model.js` so pause,
  resume, and dispatch behavior can be tested without a Bedrock engine.
- Use one immutable source-backed threshold schedule for both `BP` and `src`
  story-event registries.
- Keep the deployed BP copy and authoring src copy behaviorally aligned.

## Acceptance criteria

- Daylight disabled pauses both counter advancement and event dispatch.
- Daylight enabled with zero players preserves time and still evaluates the
  persisted exact threshold.
- Daylight enabled with one or more players advances exactly one tick before
  dispatch.
- All ten source thresholds retain their day and `+1000` tick offset.
- Focused regressions run in GitHub Actions as a named gate, in addition to
  the existing full add-on validation workflow.
