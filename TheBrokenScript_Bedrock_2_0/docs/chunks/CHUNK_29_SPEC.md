# Chunk 29 spec — Jimmy multipart hitbox/support

## Scope

Port the recoverable multipart support around BaseFracturedEntity, FracturedPartEntity, FracturedSubEntity, Leg, and the FracturedRoam switch path. Preserve source geometry, body-yaw transforms, part-hit ordering, arrow effects, and the source switching duration while keeping the Bedrock implementation within the single-root entity model.

## Authoritative Java contracts

- BaseFracturedEntity defines a 14×14 head at local offset (1, 88, 10) and an 18×18 chest at (1, 68, 10).
- Four 15×15 subentities use default offsets frontleft (40, 0, 50), frontright (-40, 0, 50), backleft (40, 0, -49), and backright (-40, 0, -49).
- Four Leg targets use local offsets (45, 0, 45), (-45, 0, 45), (45, 0, -45), and (-45, 0, -45). Leg.tick rotates each target by the negative parent body yaw and then applies the parent body yaw to the subentity.
- FracturedPartEntity.hurt checks FracturedRoam promotion first for the head/chest parts, applies burning-arrow and spectral-arrow effects, rejects invulnerable sources, and temporarily marks the parent as hit via a part. Its is(entity) contract treats the part and parent as the same source entity. FracturedSubEntity legs delegate to the parent and do not invoke swap or apply those arrow side effects.
- FracturedRoamEntity starts in RISING with the source 149-tick rise duration. The source SWITCHING path is guarded by the NORMAL state, decrements for 103 ticks, then starts JimArena and replaces the roam host with the main Fractured entity.

## Bedrock ownership and adaptation

- fractured_multipart_model.js is pure and source-backed. It exposes the six logical part definitions with explicit `part` versus `sub_entity` roles, the positive/negative yaw transforms, AABB construction, point tests, source-order hit plans, the 149-tick rising guard, and the 103-tick switch state.
- fractured.json and fractured_roam.json use a derived 105×102 root collision envelope: the 105 width covers the outer ±45 leg targets plus 15-wide parts, and 102 height covers the head's local base plus its 14 height. Runtime filtering keeps the envelope from turning every broad-body projectile event into a logical part hit.
- fractured_runtime.js owns projectile part filtering, arrow effect scheduling, FracturedRoam switching tags/timer, and main/roam damage interception. boss_controller.js pauses its generic roam drift while the switching adapter owns the entity.
- System.run defers setOnFire/addEffect because the before-event callback is restricted. The source effect ordering is retained in the pure plan and runtime dispatch.

## Validation target

- deterministic multipart geometry, transform, AABB, hit-order, and identity regressions;
- runtime/static integration assertions for deferred side effects, damage-cause handling, root envelopes, and generic-controller ownership;
- node --check for changed JavaScript;
- JSON parsing for the touched Fractured and FracturedRoam definitions;
- repository CI typecheck, full regression suite, add-on validators, Blockception diagnostics, Creator Tools validation, and packaging.

## Known differences

Bedrock cannot create the Java child part hierarchy or exact parent/part identity. Projectile filtering uses the current projectile AABB center against conceptual part AABBs rather than a continuous sweep against moving child entities. The FracturedRoam switch adapter spawns the main entity directly after 103 ticks; JimArena arena construction, camera/music/participant transport, and the remaining Roam lifecycle are reserved for the next source slice.
