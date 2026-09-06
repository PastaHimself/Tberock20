import { world } from "@minecraft/server";
import { EntityDamageCause } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import * as effects from "../../systems/ai/effects.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import { logger } from "../../core/logging.js";

const timers = new Map();
const WATCHING_LIFE = 8000, SCARE_LIFE = 40, MINING_LIFE = 1200, IS_HERE_LIFE = 500;

function getTimer(e) { return timers.get(e.id) ?? 0; }
function setTimer(e, v) { timers.set(e.id, v); }

export function begin(scheduler) {
  scheduler.every("tbs.null_tick", 5, onNullTick);
}

function onNullTick() {
  for (const dim of [world.getDimension("overworld")]) {
    let list = [];
    try { list = dim.getEntities({ families: ["thebrokenscript_null"] }); } catch { continue; }
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
  t -= 5; setTimer(e, t); if (t <= 0) { e.remove(); timers.delete(e.id); return; }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 30);
  if (!player) return;
  if (!gaze.isLookingAtLocation(player, e.location, 12)) return;
  const choice = Math.floor(Math.random() * 9) + 1;
  switch (choice) {
    case 1: effects.blindness(player, 4); try { player.playSound("thebrokenscript:null_flee"); } catch {} e.remove(); timers.delete(e.id); break;
    case 2: spawnHelpers.trySummon(e.dimension, "thebrokenscript:null_chase", e.location); effects.darkness(player, 3); e.remove(); timers.delete(e.id); break;
    case 4: try { e.dimension.spawnParticle("thebrokenscript:null_particle", e.location); } catch {} e.remove(); timers.delete(e.id); break;
    case 8: {
      const dest = { x: e.location.x + (Math.random()*6-3), y: e.location.y + 1, z: e.location.z + (Math.random()*6-3) };
      try { e.teleport(dest); } catch {} break;
    }
    default: e.remove(); timers.delete(e.id); break;
  }
}

function tickScare(e) {
  let t = getTimer(e); if (t === 0) { setTimer(e, 0); }
  t += 5; setTimer(e, t); if (t >= SCARE_LIFE) { e.remove(); timers.delete(e.id); }
  if (t === 5) { try { e.dimension.playSound?.("thebrokenscript:kills_player", e.location, { volume: 0.3, pitch: 0.75 }); } catch {} }
}

function tickMining(e) {
  let t = getTimer(e); if (t === 0) { setTimer(e, MINING_LIFE); t = MINING_LIFE; }
  t -= 5; setTimer(e, t); if (t <= 0) { e.remove(); timers.delete(e.id); return; }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 100);
  if (!player) return;
  if (Math.random() < 0.02) {
    const front = { x: Math.floor(e.location.x + e.getViewDirection().x * 2), y: Math.floor(e.location.y), z: Math.floor(e.location.z + e.getViewDirection().z * 2) };
    try {
      const block = e.dimension.getBlock(front);
      if (block && block.typeId === "minecraft:air") { block.setType("minecraft:cobblestone"); }
    } catch {}
  }
}

let isHereApproach = 0;
function tickIsHere(e) {
  let t = getTimer(e); if (t === 0) { setTimer(e, IS_HERE_LIFE); t = IS_HERE_LIFE; }
  t -= 5; setTimer(e, t); if (t <= 0) { e.remove(); timers.delete(e.id); return; }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 128);
  if (!player) return;
  isHereApproach = (isHereApproach + 5) % 5;
  if (isHereApproach === 0) {
    const dir = { x: player.location.x - e.location.x, y: player.location.y - e.location.y, z: player.location.z - e.location.z };
    const len = Math.hypot(dir.x, dir.y, dir.z) || 1;
    const step = { x: dir.x/len*1.5 + (Math.random()*6-3), y: dir.y/len*1.5, z: dir.z/len*1.5 };
    const dest = { x: e.location.x + step.x, y: e.location.y + step.y, z: e.location.z + step.z };
    try { e.teleport(dest); } catch {}
  }
  if (Math.hypot(player.location.x - e.location.x, player.location.y - e.location.y, player.location.z - e.location.z) < 2.4) {
    try { player.applyDamage(313, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { player.applyDamage(313); } catch {} }
  }
  if (Math.random() < 0.25) {
    try { player.onScreenDisplay.setTitle("§k null §r", { fadeInDuration: 0, stayDuration: 20, fadeOutDuration: 10 }); } catch {}
  }
}
