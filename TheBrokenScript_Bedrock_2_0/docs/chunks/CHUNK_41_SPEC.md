# Chunk 41 — Fractured rendered-contact spatial resolver

## Goal

Port the source Fractured/Jimmy contact-origin contract into a reusable Bedrock
resolver that can accept exact rendered-bone positions when an external bridge
is available and remains deterministic on Bedrock-only servers.

## Source contract

- Track `ROCK`, `right_l_claw`, `left_l_claw`, and `right_f_tarsus`.
- Use rendered world positions for Slam, rock throw, rock release, and stomp
  instruction origins.
- Preserve the recovered Stomp source offset
  `(210, 0, -1313) × 0.125 = (26.25, 0, -164.125)`, including body-yaw
  rotation.
- Keep source event/bone ownership explicit rather than inventing new locators
  or packet semantics.

## Bedrock adapter

- Derive the event catalog from `fractured_animation_model.js`.
- Accept bridge-provided `boneWorldPositions` for exact contact routing.
- Use the source stomp transform when `right_f_tarsus` is unavailable.
- Use an explicit entity-anchor fallback for unavailable claw/rock bones.
- Route `fractured_runtime.js` stomp, slam, rock throw, and rock release
  origins through the resolver.

## Non-goals

A live GeckoLib render-bone matrix bridge, Java custom packet transport, exact
client/server animation-controller parity, and continuous projectile sweep are
not available through the current Bedrock Script API and remain documented
engine/deferred items.

## Acceptance

- All four tracked source bones and four contact events are catalogued.
- Supplied rendered positions are returned without modification.
- Missing stomp positions use the source offset and body yaw.
- Missing claw/rock positions use an explicit entity-anchor fallback.
- Runtime routes all four contact-origin families through the resolver.
- Focused regressions and the repository's full validation workflow pass.
