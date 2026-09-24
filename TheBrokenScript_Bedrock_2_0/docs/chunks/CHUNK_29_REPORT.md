# Chunk 29 report — Jimmy multipart hitbox/support

## Ported

- Added fractured_multipart_model.js with exact BaseFracturedEntity part dimensions, offsets, explicit parent-part versus leg-subentity roles, role-specific body-yaw transforms, conceptual AABBs, point tests, parent/part identity semantics, source-order arrow effects, the 149-tick Roam rising guard, and the 103-tick switch contract.
- Added deterministic tests covering geometry constants, role-specific yaw transforms, six logical AABBs, accepted/missed/invulnerable arrow hits, parent-part versus leg-subentity behavior, burning/spectral effects, Roam state guarding, SWITCHING, runtime integration, root collision envelopes, and controller ownership.
- Extended fractured_runtime.js to return the matched conceptual part, route parent-part and leg-subentity behavior separately, defer setOnFire/addEffect effects, track the 149-tick Roam rise state, handle FracturedRoam switching, and promote to the main Fractured entity. The generic boss controller pauses roaming drift while the switch tag is active.
- Expanded the Fractured and FracturedRoam root collision envelopes to the derived 105×102 bounds; runtime logical-part filtering prevents the envelope from becoming unconditional body damage.

## Source/API evidence

- Java source: decompiled/net/thebrokenscript/api/entity/BaseFracturedEntity.java; decompiled/net/thebrokenscript/entity/fractured/{FracturedPartEntity,FracturedSubEntity,Leg,FracturedRoamEntity}.java; decompiled/net/thebrokenscript/boss/fractured/JimArena.java.
- Microsoft Learn: Entity.getAABB, Entity.setOnFire, Entity.addEffect, and System.run.
- BedrockWikiMcp cross-check: stable signatures and restricted-event deferral pattern for the four API surfaces used by the adapter.

## Validation

- Local focused suite: 12 passed, 0 failed.
- node --check passed for fractured_multipart_model.js, fractured_runtime.js, and boss_controller.js.
- Static runtime assertions passed for role-specific part routing, deferred arrow effects, Roam rising-state guarding, EntityDamageCause.projectile handling, root collision envelopes, six logical AABBs, and generic-controller ownership.
- GitHub Actions run 33359740828 passed all code/validation gates: type-check, 112 JavaScript regressions, 67 Python validator tests, add-on validators, Blockception diagnostics (0 errors / 0 warnings), Mojang Creator Tools validation (0 blockers after documented false-positive filtering), and packaging. Artifact uploads were blocked by repository storage quota. No Minecraft Bedrock world is installed locally, so in-game behavior still requires device/runtime smoke testing.

## Next unfinished source slice

The next source boundary is FracturedRoamEntity.java's remaining host lifecycle: underground/dig movement, switching/arena choreography, and despawn/host transitions. Chunk 29 does not claim exact JimArena construction, camera/music/participant transport, or the full Roam lifecycle.
