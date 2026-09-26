import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import { EntityDamageCause } from "@minecraft/server";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import { logger } from "../../core/logging.js";
import { showScreen } from "../../systems/screen_overlay.js";

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
    try { list = dim.getEntities({ families: ["thebrokenscript_null"] }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.26", "best-effort Bedrock API fallback", error); continue; }
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
  if (Math.random() < 0.01) { try { e.dimension.runCommand("time set midnight"); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.50", "best-effort Bedrock API fallback", error);} }
  if (Math.random() < 0.25) { try { e.dimension.spawnParticle("thebrokenscript:null_particle", e.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.51", "best-effort Bedrock API fallback", error);} }
  try { player.addEffect("blindness", 60, { amplifier: 0, showParticles: false }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.52", "best-effort Bedrock API fallback", error);}
}

function tickEndgame(e) {
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 50);
  if (!player) return;
  try { player.onScreenDisplay.setTitle("HERE I AM", { fadeInDuration: 0, stayDuration: 20, fadeOutDuration: 10 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.58", "best-effort Bedrock API fallback", error);}
  if (getTimer(e) % 60 === 0) { try { player.applyDamage(999, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { player.applyDamage(999); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.59", "best-effort Bedrock API fallback", error);} } }
}

function tickUnbeatable(e) {
  try { e.addEffect("resistance", 100, { amplifier: 5, showParticles: false }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.63", "best-effort Bedrock API fallback", error);}
}

function tickInvade(e) {
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 15);
  if (!player) return;
  if (!gaze.isLookingAtEntity(player, e, 14)) return;
  if (Math.random() < 0.7) {
    showScreen(player, "wecanhearyou", 10);
    try { e.dimension.spawnEntity("minecraft:lightning_bolt", e.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_pursuit_controller.js.72", "best-effort Bedrock API fallback", error);}
  }
  e.remove(); timers.delete(e.id);
}
