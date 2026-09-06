# Chunk 34 — Custom damage-source catalog and attribution adapter

## Delivered

- Added a pure catalog for all 15 `thebrokenscript` custom damage types.
- Preserved source JSON fields and `TBSDamageTypes` builder metadata, including custom death text, burning/hurt effects, exhaustion/scaling, no-knockback, and bypass flags.
- Added a Bedrock runtime adapter that sends native cause, damaging entity, and damaging projectile values through `Entity.applyDamage()` while retaining the custom source id in a same-tick ledger.
- Routed recovered Jimmy stomp, Rock, Integrity ball, Integrity shield bypass, void mass, Fever, and Chord damage sites through the adapter.
- Added deterministic model and runtime wiring regressions.

## Source-to-engine decision

Bedrock exposes native damage causes plus optional entity/projectile attribution, but it does not expose a registry for arbitrary Java damage-type ids. The port keeps the exact source catalog and uses native causes only as the engine transport layer. Exact custom death messages, exhaustion/scaling, and armor/effect/invulnerability/shield/totem bypass behavior remain explicitly documented as engine gaps.

## Validation

- 53/53 Node regressions pass locally.
- Touched model, adapter, and boss runtime JavaScript passes `node --check`.
- Rock entity and moon-stone particle JSON parse successfully.
- BedrockWiki and Microsoft Learn references confirm the stable native cause/entity/projectile attribution surface.
- Minecraft Bedrock world/runtime smoke testing remains unavailable in this workspace.
