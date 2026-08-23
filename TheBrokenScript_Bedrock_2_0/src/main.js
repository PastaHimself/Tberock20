import { world, system } from "@minecraft/server";
import { logger } from "./core/logging.js";
import { guard } from "./core/errors.js";
import * as scheduler from "./core/scheduler.js";
import * as events from "./core/events.js";
import * as state from "./core/state.js";
import { config } from "./core/config.js";
import * as storyTime from "./shared/story_time.js";
import * as worldState from "./systems/world_state.js";
import * as playerState from "./systems/player_state.js";
import * as configDefaults from "./systems/config_defaults.js";
import * as storyEvents from "./systems/story_events.js";
import * as spawnDirector from "./systems/spawn_director.js";
import * as entityRefs from "./core/entity_refs.js";
import * as circuitController from "./entities/circuit/circuit_controller.js";
import * as circuitSpawnRules from "./entities/circuit/circuit_spawn_rules.js";
import * as nullController from "./entities/null/null_controller.js";
import * as nullSpawnRules from "./entities/null/null_spawn_rules.js";
import * as nullPursuitController from "./entities/null/null_pursuit_controller.js";
import * as tbeController from "./entities/tbe/tbe_controller.js";
import * as tbeSpawnRules from "./entities/tbe/tbe_spawn_rules.js";
import * as humanoidController from "./entities/humanoid/humanoid_controller.js";
import * as humanoidSpawnRules from "./entities/humanoid/humanoid_spawn_rules.js";
import * as miscController from "./entities/misc/misc_controller.js";
import * as miscSpawnRules from "./entities/misc/misc_spawn_rules.js";
import * as stalkController from "./entities/stalk/stalk_controller.js";
import * as stalkSpawnRules from "./entities/stalk/stalk_spawn_rules.js";
import * as bossController from "./entities/boss/boss_controller.js";
import * as bossSpawnRules from "./entities/boss/boss_spawn_rules.js";

function onStartup() {
    logger.info("startup: early-execution hook registered (script modules active)");
}

function onWorldLoad() {
    state.init();
    worldState.init();
    scheduler.begin();
    storyEvents.registerAll();
    storyTime.begin(scheduler);
    spawnDirector.begin(scheduler);
    circuitSpawnRules.register();
    circuitController.begin(scheduler);
    nullSpawnRules.register();
    nullController.begin(scheduler);
    nullPursuitController.begin(scheduler);
    tbeSpawnRules.register();
    tbeController.begin(scheduler);
    humanoidSpawnRules.register();
    humanoidController.begin(scheduler);
    miscSpawnRules.register();
    miscController.begin(scheduler);
    stalkSpawnRules.register();
    stalkController.begin(scheduler);
    bossSpawnRules.register();
    bossController.begin(scheduler);
    events.subscribeGuarded(
        world.afterEvents.playerJoin,
        "core.playerJoin",
        "lifecycle",
        (ev) => {
            logger.debug(`playerJoin ${ev.playerName}`);
        }
    );
    events.subscribeGuarded(
        world.afterEvents.playerLeave,
        "core.playerLeave",
        "lifecycle",
        (ev) => {
            logger.debug(`playerLeave ${ev.playerName} (${ev.playerId})`);
            entityRefs.invalidateEntity(ev.playerId);
        }
    );
    events.subscribeGuarded(
        world.afterEvents.playerSpawn,
        "core.playerSpawn",
        "lifecycle",
        (ev) => {
            if (ev.initialSpawn) {
                state.ensurePlayer(ev.player);
                playerState.set(ev.player, "lastX", Math.floor(ev.player.location.x));
                playerState.set(ev.player, "lastZ", Math.floor(ev.player.location.z));
                logger.debug(`initial spawn tracked for ${ev.player.name}`);
            }
        }
    );
    events.subscribeGuarded(
        world.afterEvents.entityDie,
        "core.entityDie",
        "lifecycle",
        (ev) => {
            entityRefs.invalidateEntity(ev.deadEntity.id);
            if (ev.deadEntity.typeId !== "minecraft:player") return;
            logger.debug(`player death: ${ev.deadEntity.name} source=${ev.damageSource?.cause ?? "unknown"}`);
        }
    );
    logger.info(
        `world loaded: seed=${world.seed} tick=${system.currentTick} storyTime=${storyTime.getTime()} configKeys=${Object.keys(config.all()).length}`
    );
}

system.beforeEvents.startup.subscribe(guard("startup", onStartup));
world.afterEvents.worldLoad.subscribe(guard("worldLoad", onWorldLoad));
