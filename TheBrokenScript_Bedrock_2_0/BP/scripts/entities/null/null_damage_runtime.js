import { EntityDamageCause, world } from "@minecraft/server";
import * as events from "../../core/events.js";

const MAZE_ID = "thebrokenscript:null_maze";

/**
 * NullMazeEntity.hurt only accepts a direct player hit, Java GENERIC_KILL,
 * or FELL_OUT_OF_WORLD. Bedrock exposes the direct projectile separately, so
 * a player-fired projectile is intentionally rejected here like the source.
 */
function onEntityHurtBefore(event) {
    const entity = event?.hurtEntity;
    if (!entity || entity.typeId !== MAZE_ID) return;

    const source = event.damageSource;
    const directPlayer = source?.damagingProjectile === undefined && source?.damagingEntity?.typeId === "minecraft:player";
    const forcedDamage = source?.cause === EntityDamageCause.selfDestruct || source?.cause === EntityDamageCause.void;
    if (!directPlayer && !forcedDamage) event.cancel = true;
}

export function begin() {
    events.subscribeGuarded(
        world.beforeEvents.entityHurt,
        "null-damage.entityHurtBefore",
        "null-damage",
        onEntityHurtBefore,
    );
}
