import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import { EntityDamageCause } from "@minecraft/server";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import { logger } from "../../core/logging.js";
import { showScreen } from "../../systems/screen_overlay.js";
import { config } from "../../core/config.js";
import * as horrorChat from "../../systems/horror_chat.js";
import {
  NULL_PURSUIT_SOURCE,
  invadeSeenOutcome,
  stepPursuitTimer,
} from "./null_pursuit_source_model.js";

const timers = new Map();
const ages = new Map();
const OWNER_PROPERTY = "tbs:null_invade_owner";
const LIFETIMES = {
  "thebrokenscript:null_chase": 450,
  "thebrokenscript:nulll": 450,
  "thebrokenscript:null_endgame": NULL_PURSUIT_SOURCE.endgameLifetimeTicks,
  "thebrokenscript:null_unbeatable_bossfight": NULL_PURSUIT_SOURCE.unbeatableLifetimeTicks,
  "thebrokenscript:null_invade_base": NULL_PURSUIT_SOURCE.invadeLifetimeTicks,
};

function getPersistentNumber(e, key, fallback = 0) {
  try {
    const value = Number(e.getDynamicProperty(key));
    return Number.isFinite(value) ? value : fallback;
  } catch (error) {
    operationDiagnostics.warnOnce("null_pursuit.dynamic_property_read", "null pursuit: dynamic-property read failed; using fallback", error);
    return fallback;
  }
}

function getTimer(e) {
  if (timers.has(e.id)) return timers.get(e.id);
  const property = timerProperty(e.typeId);
  const persisted = property ? getPersistentNumber(e, property, 0) : 0;
  timers.set(e.id, persisted);
  return persisted;
}
function setTimer(e, v) {
  const value = Math.max(0, Math.trunc(Number(v) || 0));
  timers.set(e.id, value);
  const property = timerProperty(e.typeId);
  if (property) {
    try { e.setDynamicProperty(property, value); } catch (error) {
      operationDiagnostics.warnOnce("null_pursuit.persist_timer", `failed to persist ${e.typeId} timer`, error);
    }
  }
}
function getAge(e) {
  return ages.get(e.id) ?? 0;
}
function setAge(e, v) {
  const value = Math.max(0, Math.trunc(Number(v) || 0));
  ages.set(e.id, value);
}
function timerProperty(typeId) {
  if (typeId === "thebrokenscript:null_endgame") return "tbs:null_endgame_timer";
  if (typeId === "thebrokenscript:null_invade_base") return "tbs:null_invade_timer";
  if (typeId === "thebrokenscript:null_unbeatable_bossfight") return "tbs:null_unbeatable_timer";
  return undefined;
}
function clearRuntimeState(e) {
  timers.delete(e.id);
  ages.delete(e.id);
}

function removeEntity(e) {
  try { e.remove(); } finally { clearRuntimeState(e); }
}

function advanceLifetime(e, elapsedTicks = 5) {
  let timer = getTimer(e);
  if (timer <= 0) timer = LIFETIMES[e.typeId] ?? 500;
  const step = stepPursuitTimer(timer, elapsedTicks, true);
  setTimer(e, step.timer);
  return step;
}

let deathHandlerRegistered = false;

export function begin(scheduler) {
  scheduler.every("tbs.null_pursuit", 5, onTick);
  if (!deathHandlerRegistered) {
    deathHandlerRegistered = true;
    world.afterEvents.entityDie.subscribe((event) => {
      const dead = event.deadEntity;
      if (!dead) return;
      clearRuntimeState(dead);
      if (dead.typeId === "thebrokenscript:null_endgame") {
        const killer = event.damageSource?.damagingEntity;
        if (killer?.typeId === "minecraft:player") {
          horrorChat.changeReputation(killer, NULL_PURSUIT_SOURCE.endgameDeathReputation);
        }
      } else if (dead.typeId === "thebrokenscript:null_unbeatable_bossfight" && !config.get("server.disableBanning")) {
        try { dead.dimension.spawnEntity(/** @type {any} */ ("thebrokenscript:ban"), dead.location); } catch (error) {
          operationDiagnostics.warnOnce("null_pursuit.unbeatable_ban", "NullUnbeatable death could not summon BAN", error);
        }
      }
    });
  }
}

function onTick() {
  for (const dim of [world.getDimension("overworld")]) {
    let list = [];
    try { list = dim.getEntities({ families: ["thebrokenscript_null"] }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.26", "best-effort Bedrock API fallback", error); continue; }
    for (const e of list) {
      if (!(e.typeId in LIFETIMES) && e.typeId !== "thebrokenscript:nulll") continue;
      try { tickEntity(e); } catch (err) { logger.error(`null_pursuit ${e.typeId}`, err); }
    }
  }
}

function tickEntity(e) {
  const id = e.typeId;
  setAge(e, getAge(e) + 5);
  if (id === "thebrokenscript:null_endgame") {
    tickEndgame(e);
    return;
  }
  const life = advanceLifetime(e, 5);
  if (life.expired) {
    if (id === "thebrokenscript:null_invade_base") rewardInvadeOwner(e);
    removeEntity(e);
    return;
  }

  if (id === "thebrokenscript:null_chase" || id === "thebrokenscript:nulll") tickChase(e);
  else if (id === "thebrokenscript:null_unbeatable_bossfight") tickUnbeatable(e);
  else if (id === "thebrokenscript:null_invade_base") tickInvade(e);
}

function tickChase(e) {
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 520);
  if (!player) { removeEntity(e); return; }
  if (Math.random() < 0.01) { try { e.dimension.runCommand("time set midnight"); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.50", "best-effort Bedrock API fallback", error);} }
  if (Math.random() < 0.25) { try { e.dimension.spawnParticle("thebrokenscript:null_particle", e.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.51", "best-effort Bedrock API fallback", error);} }
  try { player.addEffect("blindness", 60, { amplifier: 0, showParticles: false }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.52", "best-effort Bedrock API fallback", error);}
}

function tickEndgame(e) {
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, NULL_PURSUIT_SOURCE.endgameRadius);
  if (!player) return;
  try { player.onScreenDisplay.setTitle("HERE I AM", { fadeInDuration: 0, stayDuration: 20, fadeOutDuration: 10 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.58", "best-effort Bedrock API fallback", error);}
  if (getAge(e) % NULL_PURSUIT_SOURCE.endgameDamagePeriodTicks === 0) {
    try { player.applyDamage(NULL_PURSUIT_SOURCE.endgameDamage, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); }
    catch { try { player.applyDamage(NULL_PURSUIT_SOURCE.endgameDamage); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.59", "best-effort Bedrock API fallback", error);} }
  }
  const life = advanceLifetime(e, 5);
  if (life.expired) removeEntity(e);
}

function tickUnbeatable(e) {
  try { e.addEffect("resistance", 100, { amplifier: 5, showParticles: false }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.63", "best-effort Bedrock API fallback", error);}
}

function tickInvade(e) {
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, NULL_PURSUIT_SOURCE.invadeTrackingRadius);
  if (!player) return;
  if (Math.hypot(
    player.location.x - e.location.x,
    player.location.y - e.location.y,
    player.location.z - e.location.z,
  ) > NULL_PURSUIT_SOURCE.invadeTriggerRadius) return;
  if (!gaze.isLookingAtEntity(player, e, 14)) return;
  horrorChat.changeReputation(player, NULL_PURSUIT_SOURCE.invadeTriggerReputation);
  if (invadeSeenOutcome(Math.random()) === "scare") {
    showScreen(player, "wecanhearyou", 10);
    try { player.playSound("text_madness_1"); } catch (error) {
      operationDiagnostics.warnOnce("null_pursuit.invade_sound", "NullInvade scare sound failed", error);
    }
    try { e.dimension.spawnEntity("minecraft:lightning_bolt", e.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.72", "best-effort Bedrock API fallback", error);}
  } else {
    try { e.dimension.spawnEntity("thebrokenscript:null_chase", e.location); } catch (error) {
      operationDiagnostics.warnOnce("null_pursuit.invade_chase", "NullInvade chase branch could not summon NullChase", error);
    }
  }
  removeEntity(e);
}

function rewardInvadeOwner(e) {
  let ownerId = "";
  try { ownerId = String(e.getDynamicProperty(OWNER_PROPERTY) ?? ""); } catch (error) {
    operationDiagnostics.warnOnce("null_pursuit.owner_read", "NullInvade owner state could not be read", error);
  }
  if (!ownerId) return;
  const owner = world.getAllPlayers().find((player) => String(player.id) === ownerId);
  if (owner) horrorChat.changeReputation(owner, NULL_PURSUIT_SOURCE.invadeTimeoutReputation);
}
