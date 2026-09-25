// Dynamic properties outside the canonical mv./pv. state adapters are listed
// here so scope and lifetime cannot drift silently between source and BP.

// This audit-support policy is mirrored from src/core. The behavior-pack
// runtime intentionally does not import it; source-backed tests and static
// audits consume it instead.
export const SOURCE_AUDIT_DISPOSITION = Object.freeze({
    kind: "audit-support",
    runtimeReachability: "unreachable",
    wiring: "intentionally-not-wired",
    reason: "source-backed contract consumed by static audits and tests",
});

export const DYNAMIC_PROPERTY_POLICY = Object.freeze({
    "tbs:arenaActive": Object.freeze({ scope: "world", persistence: "persistent", owner: "arena" }),
    "tbs:arenaPhase1": Object.freeze({ scope: "world", persistence: "persistent", owner: "arena" }),
    "tbs:portal_anchor_v1": Object.freeze({ scope: "player", persistence: "transient", clear: "player-spawn" }),
    "tbs:portal_cooldown_until": Object.freeze({ scope: "player", persistence: "transient", clear: "expiry-or-player-spawn" }),
    "tbs:portal_links_v1": Object.freeze({ scope: "world", persistence: "persistent", owner: "portal-link" }),
    "tbs:heart_corruption_until": Object.freeze({ scope: "player", persistence: "transient", clear: "expiry-or-player-spawn" }),
    "tbs:why_leave_until": Object.freeze({ scope: "player", persistence: "transient", clear: "expiry-or-player-spawn" }),
    "tbs:jim_stage": Object.freeze({ scope: "block", persistence: "persistent", owner: "jim-trigger" }),
    "tbs:jim_stage_touch": Object.freeze({ scope: "entity", persistence: "transient", clear: "next-tick" }),
    "tbs:faraway_appearance": Object.freeze({ scope: "entity", persistence: "transient", clear: "entity-removal" }),
    // Java stores this field in each NullMaze/NullFlying entity's persistent
    // NBT. Bedrock has no portable NBT attachment, so the runtime maps it to
    // one explicitly declared entity dynamic property.
    "tbs:despawn_timer": Object.freeze({ scope: "entity", persistence: "persistent", owner: "null-pursuit", javaField: "NullMazeEntity/NullFlyingEntity.timer" }),
    "tbe:alive": Object.freeze({ scope: "entity", persistence: "persistent", javaField: "TheBrokenEndAmbushEntity.aliveTicks" }),
    "tbe:lifetime": Object.freeze({ scope: "entity", persistence: "persistent", javaField: "TheBrokenEndAmbushEntity.lifetime" }),
    "tbe:variant": Object.freeze({ scope: "entity", persistence: "persistent", javaField: "TheBrokenEndAmbushEntity.variant" }),
    "tbs:ban": Object.freeze({ scope: "player", persistence: "legacy", migrateTo: "pv.ban" }),
    "tbs:fixPos": Object.freeze({ scope: "player", persistence: "legacy", migrateTo: "pv.fixPos" }),
    "tbs:skipFallDamage": Object.freeze({ scope: "player", persistence: "legacy", migrateTo: "pv.skipFallDamage" }),
    "tbs:triangleKickTimer": Object.freeze({ scope: "player", persistence: "legacy", migrateTo: "pv.triangleKickTimer" }),
    "tbs:adv_*": Object.freeze({ scope: "player", persistence: "persistent", owner: "progression" }),
});

export const ENTITY_DYNAMIC_PROPERTY_POLICY = Object.freeze({
    "tbe:alive": DYNAMIC_PROPERTY_POLICY["tbe:alive"],
    "tbe:lifetime": DYNAMIC_PROPERTY_POLICY["tbe:lifetime"],
    "tbe:variant": DYNAMIC_PROPERTY_POLICY["tbe:variant"],
    "tbs:jim_stage_touch": DYNAMIC_PROPERTY_POLICY["tbs:jim_stage_touch"],
    "tbs:faraway_appearance": DYNAMIC_PROPERTY_POLICY["tbs:faraway_appearance"],
    "tbs:despawn_timer": DYNAMIC_PROPERTY_POLICY["tbs:despawn_timer"],
});

export const PERSISTENT_ENTITY_EVIDENCE = Object.freeze({
    "tbe:alive": Object.freeze({
        javaClass: "TheBrokenEndAmbushEntity",
        saveKey: "AliveTicks",
    }),
    "tbe:lifetime": Object.freeze({
        javaClass: "TheBrokenEndAmbushEntity",
        saveKey: "Lifetime",
    }),
    "tbe:variant": Object.freeze({
        javaClass: "TheBrokenEndAmbushEntity",
        saveKey: "variant",
    }),
    "tbs:despawn_timer": Object.freeze({
        javaClass: "NullFlyingEntity",
        saveKey: "despawn_timer",
    }),
});

export const TRANSIENT_RUNTIME_STATE = Object.freeze([
    "circuit_controller timers Map keyed by entity.id",
    "null_controller timers Map keyed by entity.id",
    "humanoid_controller timers Map keyed by entity.id",
    "misc_controller timers Map keyed by entity.id",
    "stalk_controller timers Map keyed by entity.id",
    "boss_controller timers Map keyed by entity.id",
    "tbe_controller timers and extraState Maps keyed by entity.id",
    "ported_features cannonReadyAt Map keyed by player.id",
]);

export const NON_PERSISTENT_ENTITY_TYPES = Object.freeze([
    "thebrokenscript:integrity_arm",
    "thebrokenscript:chord_projectile",
]);
