import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { world, system } from "@minecraft/server";
import { EntityDamageCause, GameMode } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import * as effects from "../../systems/ai/effects.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import { logger } from "../../core/logging.js";

const timers = new Map();
const watchingMeleeReadyAt = new Map();
const WATCHING_LIFE = 8000, SCARE_LIFE = 40, MINING_LIFE = 1200, IS_HERE_LIFE = 500;
const WATCHING_ATTACK_DAMAGE = 63;
const WATCHING_ATTACK_RANGE = 1.5;
const WATCHING_ATTACK_INTERVAL = 20;

function getTimer(e) { return timers.get(e.id) ?? 0; }
function setTimer(e, v) { timers.set(e.id, v); }

function isAttackablePlayer(player) {
  const gm = typeof player?.getGameMode === "function" ? player.getGameMode() : undefined;
  return gm !== GameMode.Creative && gm !== GameMode.Spectator;
}

export function begin(scheduler) {
  scheduler.every("tbs.null_tick", 5, onNullTick);
}

function onNullTick() {
  for (const dim of [world.getDimension("overworld")]) {
    let list = [];
    try { list = dim.getEntities({ families: ["thebrokenscript_null"] }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_controller.js.23", "best-effort Bedrock API fallback", error); continue; }
    for (const e of list) { try { tickEntity(e); } catch (err) { logger.error(`null tick ${e.typeId}`, err); } }
  }
}

function tickEntity(e) {
  const id = e.typeId;
  if (id === "thebrokenscript:null_watching") tickWatching(e);
  else if (id === "thebrokenscript:null_scare") tickScare(e);
  else if (id === "thebrokenscript:null_mining") tickMining(e);
  else if (id === "thebrokenscript:null_is_here") tickIsHere(e);
}

function tickWatching(e) {
  let t = getTimer(e); if (t === 0) { setTimer(e, WATCHING_LIFE); t = WATCHING_LIFE; }
  t -= 5; setTimer(e, t); if (t <= 0) { e.remove(); timers.delete(e.id); watchingMeleeReadyAt.delete(e.id); return; }
  const meleeTarget = entityFinder.closestPlayerForEntity(
    world.getAllPlayers().filter(isAttackablePlayer),
    e,
    WATCHING_ATTACK_RANGE,
  );
  if (meleeTarget && system.currentTick >= (watchingMeleeReadyAt.get(e.id) ?? 0)) {
    try {
      meleeTarget.applyDamage(WATCHING_ATTACK_DAMAGE, {
        cause: EntityDamageCause.entityAttack,
        damagingEntity: e,
      });
      watchingMeleeReadyAt.set(e.id, system.currentTick + WATCHING_ATTACK_INTERVAL);
    } catch (error) {
      operationDiagnostics.warnOnce("null_watching.melee", "NullWatching melee damage failed", error);
    }
  }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 30);
  if (!player) return;
  if (!gaze.isLookingAtEntity(player, e, 12)) return;
  const choice = Math.floor(Math.random() * 9) + 1;
  switch (choice) {
    case 1: effects.blindness(player, 4); try { player.playSound("null_flee"); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_controller.js.44", "best-effort Bedrock API fallback", error);} e.remove(); timers.delete(e.id); watchingMeleeReadyAt.delete(e.id); break;
    case 2: spawnHelpers.trySummon(e.dimension, "thebrokenscript:null_chase", e.location); effects.darkness(player, 3); e.remove(); timers.delete(e.id); watchingMeleeReadyAt.delete(e.id); break;
    case 4: try { e.dimension.spawnParticle("thebrokenscript:null_particle", e.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_controller.js.46", "best-effort Bedrock API fallback", error);} e.remove(); timers.delete(e.id); watchingMeleeReadyAt.delete(e.id); break;
    case 8: {
      const dest = { x: e.location.x + (Math.random()*6-3), y: e.location.y + 1, z: e.location.z + (Math.random()*6-3) };
      try { e.teleport(dest); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_controller.js.49", "best-effort Bedrock API fallback", error);} break;
    }
    default: e.remove(); timers.delete(e.id); watchingMeleeReadyAt.delete(e.id); break;
  }
}

function tickScare(e) {
  let t = getTimer(e); if (t === 0) { setTimer(e, 0); }
  t += 5; setTimer(e, t); if (t >= SCARE_LIFE) { e.remove(); timers.delete(e.id); }
  if (t === 5) { try { e.dimension.playSound?.("kills_player", e.location, { volume: 0.3, pitch: 0.75 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_controller.js.58", "best-effort Bedrock API fallback", error);} }
}

function tickMining(e) {
  let t = getTimer(e); if (t === 0) { setTimer(e, MINING_LIFE); t = MINING_LIFE; }
  t -= 5; setTimer(e, t); if (t <= 0) { e.remove(); timers.delete(e.id); return; }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 100);
  if (!player) return;
  if (Math.random() < 0.02) {
    const front = { x: Math.floor(e.location.x + e.getViewDirection().x * 2), y: Math.floor(e.location.y), z: Math.floor(e.location.z + e.getViewDirection().z * 2) };
    try {
      const block = e.dimension.getBlock(front);
      if (block && block.typeId === "minecraft:air") { block.setType("minecraft:cobblestone"); }
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_controller.js.71", "best-effort Bedrock API fallback", error);}
  }
}

function tickIsHere(e) {
  let t = getTimer(e); if (t === 0) { setTimer(e, IS_HERE_LIFE); t = IS_HERE_LIFE; }
  t -= 5; setTimer(e, t); if (t <= 0) { e.remove(); timers.delete(e.id); return; }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 128);
  if (!player) return;
  // Source has no proactive Player target selector here. HurtByTargetGoal cannot
  // create the old Bedrock chase in normal play because ordinary damage is rejected.
  if (Math.random() < 0.25) {
    try { player.onScreenDisplay.setTitle("§k null §r", { fadeInDuration: 0, stayDuration: 20, fadeOutDuration: 10 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_controller.js.93", "best-effort Bedrock API fallback", error);}
  }
}
