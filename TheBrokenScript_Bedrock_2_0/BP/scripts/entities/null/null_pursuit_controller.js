import { world } from "@minecraft/server";
import { EntityDamageCause } from "@minecraft/server";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import { logger } from "../../core/logging.js";

const timers = new Map();
const LIFETIMES = {
  "thebrokenscript:null_chase": 450,
  "thebrokenscript:nulll": 450,
  "thebrokenscript:null_endgame": 420,
  "thebrokenscript:null_unbeatable_bossfight": 500,
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
  else if (id === "thebrokenscript:null_endgame") tickEndgame(e);
  else if (id === "thebrokenscript:null_unbeatable_bossfight") tickUnbeatable(e);
  else if (id === "thebrokenscript:null_invade_base") tickInvade(e);
}

function tickChase(e) {
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 520);
  if (!player) { e.remove(); timers.delete(e.id); return; }
  if (Math.random() < 0.01) { try { e.dimension.runCommand("time set midnight"); } catch {} }
  if (Math.random() < 0.25) { try { e.dimension.spawnParticle("thebrokenscript:null_particle", e.location); } catch {} }
  try { player.addEffect("blindness", 60, { amplifier: 0, showParticles: false }); } catch {}
}

function tickEndgame(e) {
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 50);
  if (!player) return;
  try { player.onScreenDisplay.setTitle("HERE I AM", { fadeInDuration: 0, stayDuration: 20, fadeOutDuration: 10 }); } catch {}
  if (getTimer(e) % 60 === 0) { try { player.applyDamage(999, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { player.applyDamage(999); } catch {} } }
}

function tickUnbeatable(e) {
  try { e.addEffect("resistance", 100, { amplifier: 5, showParticles: false }); } catch {}
}

function tickInvade(e) {
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 15);
  if (!player) return;
  if (!gaze.isLookingAtEntity(player, e, 14)) return;
  if (Math.random() < 0.7) {
    try { player.onScreenDisplay.setTitle("wecanhearyou", { fadeInDuration: 0, stayDuration: 10, fadeOutDuration: 0 }); } catch {}
    try { e.dimension.spawnEntity("minecraft:lightning_bolt", e.location); } catch {}
  }
  e.remove(); timers.delete(e.id);
}
