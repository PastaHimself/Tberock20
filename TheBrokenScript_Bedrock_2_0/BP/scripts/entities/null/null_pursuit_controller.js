import { world } from "@minecraft/server";
import { EntityDamageCause } from "@minecraft/server";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import { logger } from "../../core/logging.js";

const timers = new Map();
const LIFETIMES = {
  "thebrokenscript:null_chase": 450,
  "thebrokenscript:nulll": 450,
  "thebrokenscript:null_maze": 3200,
  "thebrokenscript:null_endgame": 420,
  "thebrokenscript:null_unbeatable_bossfight": 500,
  "thebrokenscript:null_flying": 3200,
  "thebrokenscript:null_invade_base": 3200
};

function getTimer(e) { return timers.get(e.id) ?? 0; }
function setTimer(e, v) { timers.set(e.id, v); }

export function begin(scheduler) {
  scheduler.every("tbs.null_pursuit", 5, onTick);
}

function onTick() {
  for (const dim of [world.getDimension("overworld")]) {
    let list = [];
    try { list = dim.getEntities({ families: ["thebrokenscript_null"] }); } catch { continue; }
    for (const e of list) {
      if (!(e.typeId in LIFETIMES) && e.typeId !== "thebrokenscript:nulll") continue;
      try { tickEntity(e); } catch (err) { logger.error(`null_pursuit ${e.typeId}`, err); }
    }
  }
}

function tickEntity(e) {
  const id = e.typeId;
  let t = getTimer(e);
  if (t === 0) { const life = LIFETIMES[id] ?? 500; setTimer(e, life); t = life; }
  t -= 5; setTimer(e, t);
  if (t <= 0) { e.remove(); timers.delete(e.id); return; }

  if (id === "thebrokenscript:null_chase" || id === "thebrokenscript:nulll") tickChase(e);
  else if (id === "thebrokenscript:null_maze") tickMaze(e);
  else if (id === "thebrokenscript:null_endgame") tickEndgame(e);
  else if (id === "thebrokenscript:null_unbeatable_bossfight") tickUnbeatable(e);
  else if (id === "thebrokenscript:null_flying") tickFlying(e);
  else if (id === "thebrokenscript:null_invade_base") tickInvade(e);
}

function tickChase(e) {
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 520);
  if (!player) { e.remove(); timers.delete(e.id); return; }
  if (Math.random() < 0.01) { try { e.dimension.runCommand("time set midnight"); } catch {} }
  if (Math.random() < 0.25) { try { e.dimension.spawnParticle("thebrokenscript:null_particle", e.location); } catch {} }
  try { player.addEffect("blindness", 60, { amplifier: 0, showParticles: false }); } catch {}
}

function tickMaze(e) {
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 128);
  if (!player) return;
  try {
    const light = e.dimension.getBlock({ x: Math.floor(e.location.x), y: Math.floor(e.location.y + 1), z: Math.floor(e.location.z) });
    if (light && light.typeId === "minecraft:air") { light.setType("minecraft:light_block"); }
  } catch {}
}

function tickEndgame(e) {
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 50);
  if (!player) return;
  try { player.onScreenDisplay.setTitle("HERE I AM", { fadeInDuration: 0, stayDuration: 20, fadeOutDuration: 10 }); } catch {}
  if (getTimer(e) % 60 === 0) { try { player.applyDamage(999, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { player.applyDamage(999); } catch {} } }
}

function tickUnbeatable(e) {
  try { e.addEffect("resistance", 100, { amplifier: 5, showParticles: false }); } catch {}
}

function tickFlying(e) {
  if (getTimer(e) % 20 === 0) {
    try { e.teleport({ x: e.location.x, y: e.location.y + 0.2, z: e.location.z }); } catch {}
  }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 30);
  if (player && Math.random() < 0.3) { try { player.applyDamage(Math.floor(Math.random()*9)+1); } catch {} }
}

function tickInvade(e) {
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 15);
  if (!player) return;
  if (!gaze.isLookingAtLocation(player, e.location, 14)) return;
  if (Math.random() < 0.7) {
    try { player.onScreenDisplay.setTitle("wecanhearyou", { fadeInDuration: 0, stayDuration: 10, fadeOutDuration: 0 }); } catch {}
    try { e.dimension.spawnEntity("minecraft:lightning_bolt", e.location); } catch {}
  }
  e.remove(); timers.delete(e.id);
}
