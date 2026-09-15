# Integrity boss parity

**Status:** Approved for implementation  
**Date:** 2026-09-15  
**Target:** Todo item 8, `Integrity boss parity`

## Goal

Finish the source-verifiable Integrity boss parity work in one focused PR. The
Java source remains authoritative; Bedrock-only substitutions stay explicit in
the adaptation ledger and are never presented as exact Java behavior.

## Source contract

The recovered Java call chain is `ArenaHandler` → `Arena` → `Phase1`/`Phase2`/
`Phase3`; Phase 3 delegates combat to `Phase3Goals`,
`IntegrityPhase3Entity`, `GroundAttack`, `IntegrityP3GroundArmEntity`, and
`IntegFireballEntity`.

### Arena and phases

- `Arena.start` selects players within 150 blocks of the start center and stores
  stable UUIDs. Each tick refreshes UUIDs against currently connected players.
- The source liveness rule keeps an Arena alive with one or two connected
  players even if both are dead; with three or more, at least one must be alive.
  Empty or disconnected rosters reset the encounter.
- Phase 1 waits 1080 ticks, enables the Integrity entity, spawns ten chords in
  the source radius, and ends only after spawned chords are all gone. No health
  threshold transitions are valid.
- Phase 2 transfers after 20 ticks, recovers players in block Y `190..198`,
  selects the lowest player only when Y `> 103`, and does not end automatically:
  the recovered `ended` field is never assigned `true`.
- Phase 3 transfers after 20 ticks, starts at `{194,-59,205}`, generates
  candidate indices `0..250` inclusive with random radii `100..123`, adds the
  three fixed tentacles, kills players only when Y `> 90` after 60 ticks, and
  removes the dying boss after 298 ticks.

### Combat and presentation

- Phase 3 preserves the source selector, previous-attack exclusion, weighted
  choices, inclusive distance ranges, initial delay, hurt frames, stuck window,
  80-tick mace-parry cooldown, and damage caps.
- GroundAttack captures the target block at old timer 33 and spawns the owner-
  linked arm at old timer 40. GroundArm impacts at old timer 5 using actual AABB
  intersection, deals 15 damage, and applies horizontal 1.5/upward 2.6
  knockback. Its destruction thresholds are `>40` without a tentacle and
  `>180` with one.
- Fireballs move at 1.6 blocks/tick. Bedrock collision must sweep the complete
  old-to-new segment, select the earliest roster target deterministically, and
  exclude the projectile owner.
- `FinalCutscene.java` uses 108 pre-roll ticks, 190 movement ticks, 100 zoom
  ticks with offset 10, and total length 428. Its blackout is explicitly
  `ticks >= 388 && ticks < 428`.

## Runtime design

Add a single `integrity_arena_runtime.js` owner for live Arena state. It selects
and refreshes the roster, owns phase transitions and cleanup, starts/stops the
supported Bedrock presentation, and exposes developer hooks for `start`, `next`,
and `stop`. Phase 2 advances only through the explicit developer `next` hook,
matching the source's never-ending Phase 2 field.

`phase3_runtime.js` receives an explicit roster setter and uses it for every
target, damage, boundary, gravity, arm, camera, and projectile query. A
standalone fallback remains only for direct developer summons when no Arena has
claimed the Phase 3 family.

Pure model helpers will cover roster radius/reconciliation, strict AABB overlap,
earliest segment-vs-AABB contact, mace eligibility, arm timing, and cutscene
timing. Live adapters only collect entities and apply the resulting plans.

## Engine-limited behavior

The PR will keep these differences documented:

- Java's custom overlay/music packets have no Script API equivalent; use native
  fades/titles/sounds where possible.
- Java's custom Integrity/`void_mass` damage types cannot be registered; use the
  existing source-ID ledger with native cause/entity/projectile attribution.
- Java's synchronized integer owner field has no Bedrock equivalent; retain the
  active encounter's stable entity-ID map and document its runtime-only scope.
- Bedrock's free camera can reproduce the source path and blackout timing, but
  not the Java client transform/zoom override or packet transport.

`Entity.getAABB()` is available in the pinned API, so exact server-side AABB
contact is part of this PR rather than an engine limitation.

## Verification and delivery

Add focused Node regressions for every boundary above, including multiplayer
roster isolation and lag-safe segment collision. Add a named Integrity parity
step to the existing GitHub Actions workflow. Run the full Node/Python/source-
audit/add-on/resource/worldgen/structure checks and the Bedrock static scanner.
Update `Todo.md`, `SOURCE_TO_RUNTIME_AUDIT.md`, `ADAPTATION_NOTES.md`, and
`KNOWN_LIMITATIONS.md` with evidence and residual engine limits. Push the branch
and open a PR after local review and green GitHub Actions.
