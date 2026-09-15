import { ItemStack, system, world } from "@minecraft/server";
import * as events from "../core/events.js";
import * as state from "../core/state.js";
import { logger } from "../core/logging.js";
import * as playerState from "./player_state.js";
import * as worldState from "./world_state.js";
import { applyWhyCantYouLeave } from "./ported_features.js";
import { spawnSourceParticle } from "./particle_runtime.js";
import {
  EVENT_CONTRACTS,
  sourceEventFrequency,
  chooseRandomPlayer,
  pickValidEvent,
  normalizeEventUseCounts,
} from "../shared/horror_event_model.js";
import {
  createLifecycleState,
  invalidateAll,
  invalidatePlayer,
  isLifecycleTokenValid,
  issueLifecycleToken,
} from "../shared/horror_lifecycle_model.js";

const EVENT_LEDGER_KEY = "horrorEventUseCounts";
const EVENT_TICK_PERIOD = 1;
const EVENT_MAX_ATTEMPTS = EVENT_CONTRACTS.length;
const CURIOUS_ENTITY_ID = "thebrokenscript:the_broken_end_curious";
const lifecycle = createLifecycleState();
let schedulerRef;
let started = false;

const SOUNDS = Object.freeze({
  heartbeat: "thebrokenscript:heartbeat",
  whisper: "thebrokenscript:null_is_here_loop",
  psst: "thebrokenscript:psst",
  glitch: "thebrokenscript:glitch_sound_1",
  reel: "thebrokenscript:reel",
  killsPlayer: "thebrokenscript:kills_player",
});

function failure(operation, error) {
  logger.warnOnce(
    "horror-events:" + operation,
    "horror event operation '" + operation + "' failed; the effect was skipped",
    error,
  );
}

function handlerFailure(id, error) {
  logger.errorOnce(
    "horror-events:handler:" + id,
    "horror event handler '" + id + "' failed",
    error,
  );
}

function usable(player) {
  if (!player) return false;
  try { return player.isValid !== false && Boolean(player.dimension && player.location); }
  catch { return false; }
}

function playerKey(player) {
  return String(player?.id ?? player?.name ?? "");
}

function isNullProfile(player) {
  try {
    return player.getDynamicProperty("tbs:isNullProfile") === true ||
      String(player.name ?? "").toLowerCase() === "null";
  } catch {
    return false;
  }
}

function playNear(player, soundId, volume = 3, pitch = 1) {
  try { player.playSound(soundId, { volume, pitch }); }
  catch (error) { failure("sound:" + soundId, error); }
}

function title(player, text, stay = 30, subtitle) {
  try {
    player.onScreenDisplay.setTitle(text, {
      fadeInDuration: 0,
      stayDuration: stay,
      fadeOutDuration: 10,
      subtitle,
    });
  } catch (error) { failure("title", error); }
}

function actionBar(player, text) {
  try { player.onScreenDisplay.setActionBar(text); }
  catch (error) { failure("action-bar", error); }
}

function offset(player, distance) {
  const angle = Math.random() * Math.PI * 2;
  return {
    x: player.location.x + Math.cos(angle) * distance,
    y: player.location.y,
    z: player.location.z + Math.sin(angle) * distance,
  };
}

function randomRange(min, max) {
  return min + Math.random() * (max - min);
}

function spawn(player, typeId, location = player.location, operation = typeId) {
  try { return player.dimension.spawnEntity(typeId, location); }
  catch (error) { failure(operation, error); return undefined; }
}

function blockAt(player, location = player.location) {
  try {
    return player.dimension.getBlock({
      x: Math.floor(location.x),
      y: Math.floor(location.y),
      z: Math.floor(location.z),
    });
  } catch (error) {
    failure("get-block", error);
    return undefined;
  }
}

function placeAt(player, typeId, options = {}) {
  const location = {
    x: Math.floor(player.location.x + randomRange(-2, 3)),
    y: Math.floor(player.location.y) - 1,
    z: Math.floor(player.location.z + randomRange(-2, 3)),
  };
  if (options.minY !== undefined) location.y = Math.floor(randomRange(options.minY, options.maxY + 1));
  const block = blockAt(player, location);
  try {
    if (block && (block.isAir || block.typeId === "minecraft:air" || block.typeId === "minecraft:cave_air")) {
      block.setType(typeId);
    }
  } catch (error) { failure("place:" + typeId, error); }
}

function giveItem(player, typeId, amount = 1) {
  try {
    const container = player.getComponent("minecraft:inventory")?.container;
    if (container) container.addItem(new ItemStack(typeId, amount));
  } catch (error) { failure("item:" + typeId, error); }
}

function runCommand(target, command, operation) {
  try { target.runCommand(command); }
  catch (error) { failure(operation, error); }
}

function nearby(player, typeId, distance) {
  try {
    return player.dimension.getEntities({
      location: player.location,
      maxDistance: distance,
    }).some((entity) =>
      entity.typeId === typeId ||
      entity.typeId === "thebrokenscript:" + typeId ||
      entity.nameTag === typeId,
    );
  } catch {
    return false;
  }
}

function cave(player) {
  try {
    const block = blockAt(player, { x: player.location.x, y: player.location.y + 1, z: player.location.z });
    const light = Number(block?.getLightLevel?.());
    return Number.isFinite(light) ? light < 8 : !canSeeSky(player);
  } catch {
    return !canSeeSky(player);
  }
}

function canSeeSky(player) {
  try {
    const top = player.dimension.getTopmostBlock?.({
      x: Math.floor(player.location.x),
      z: Math.floor(player.location.z),
    });
    const topY = Number(top?.location?.y ?? top?.y);
    return !Number.isFinite(topY) || topY <= Math.floor(player.location.y);
  } catch {
    return false;
  }
}

function reputation(player) {
  try { return Number(playerState.get(player, "entityReputation")); }
  catch { return 50; }
}

function setWorld(key, value) {
  try { worldState.set(key, value); }
  catch (error) { failure("world-state:" + key, error); }
}

function scheduleForPlayer(player, delay, token, callback, operation) {
  if (typeof system.runTimeout !== "function") {
    failure("run-timeout", new Error("system.runTimeout is unavailable"));
    return false;
  }
  try {
    system.runTimeout(() => {
      if (!usable(player) || !isLifecycleTokenValid(lifecycle, playerKey(player), token)) return;
      try { callback(player); }
      catch (error) { failure(operation, error); }
    }, Math.max(1, Math.floor(Number(delay) || 0)));
    return true;
  } catch (error) {
    failure("run-timeout", error);
    return false;
  }
}

function sourceClassAllows(entry, player) {
  const nullProfile = isNullProfile(player);
  if (entry.sourceClass === "OnlyNullEvent") return nullProfile;
  if (entry.id === "tbe_curious" && nearby(player, CURIOUS_ENTITY_ID, 96)) return false;
  if (entry.id === "tbe_curious" && !cave(player)) return false;
  if (entry.id === "tbe_curious" && Math.random() >= 0.5) return false;
  if (entry.id === "paranoia" && !cave(player)) return false;
  if (entry.id === "madness_1" && reputation(player) >= 76) return false;
  if (["explode_base", "place_empty", "place_flowing_water", "place_lava", "lava_cast", "place_water"].includes(entry.id) && reputation(player) > 50) return false;
  if (entry.id === "moon_phase") {
    try {
      if (world.getMoonPhase?.() !== 0) return false;
      if (world.getTimeOfDay?.() >= 12000) return false;
    } catch { return false; }
  }
  if (entry.id === "moon_glitch") {
    try { if (Number(worldState.get("moonStage")) >= 2) return false; }
    catch { return false; }
  }
  return true;
}

function eventsEnabledFor(player) {
  try {
    if (String(player.dimension?.id ?? "").startsWith("thebrokenscript:")) return false;
    if (world.getDynamicProperty?.("tbs:arenaActive") === true) return false;
    return true;
  } catch (error) {
    failure("event-gate", error);
    return false;
  }
}

function readLedger() {
  try {
    return normalizeEventUseCounts(state.getWorldJSON(EVENT_LEDGER_KEY, {}), EVENT_CONTRACTS);
  } catch (error) {
    failure("ledger-read", error);
    return normalizeEventUseCounts({}, EVENT_CONTRACTS);
  }
}

function writeLedger(ledger) {
  try { state.setWorldJSON(EVENT_LEDGER_KEY, ledger); }
  catch (error) { failure("ledger-write", error); }
}

function invokeEvent(id, player, manual = false) {
  const handler = H[id];
  if (!handler || !usable(player)) return false;
  const token = issueLifecycleToken(lifecycle, playerKey(player));
  try {
    handler(player, { manual, token });
    return true;
  } catch (error) {
    handlerFailure(id, error);
    return false;
  }
}

function tick() {
  let players;
  try { players = world.getAllPlayers().filter(usable); }
  catch (error) { failure("players", error); return; }
  if (players.length === 0) return;

  const player = chooseRandomPlayer(players, Math.random);
  if (!player || !eventsEnabledFor(player)) return;

  const gameTime = Number(world.getAbsoluteTime?.() ?? 0);
  if (Math.random() >= sourceEventFrequency(gameTime)) return;

  const ledger = readLedger();
  const picked = pickValidEvent(
    EVENT_CONTRACTS,
    ledger,
    Math.random,
    (entry) => sourceClassAllows(entry, player),
    EVENT_MAX_ATTEMPTS,
  );
  if (!picked) return;
  writeLedger(picked.useCounts);
  invokeEvent(picked.entry.handler, player);
}

const H = {
  bsod(p) { title(p, ":(", 80, "A problem has been detected."); },
  can_someone_hear_me(p) { title(p, "can someone hear me?", 40); playNear(p, SOUNDS.whisper, 6); },
  close_menu(p) { title(p, " ", 5); },
  damage(p) { try { p.applyDamage(2); } catch (error) { failure("damage", error); } },
  doors(p) { playNear(p, "door.open", 6, 0.8); },
  explode_base(p) { try { p.dimension.createExplosion(p.location, 2, { breaksBlocks: false }); } catch (error) { failure("explode-base", error); } },
  eyes(p) { spawnSourceParticle(p, "eyes"); title(p, "§4◉ ‸ ◉", 20); },
  false_villager(p) { spawn(p, "minecraft:villager_v2", offset(p, 12), "false-villager"); },
  giift(p) { giveItem(p, "thebrokenscript:torn_paper"); title(p, "a gift?", 25); },
  give_disc_11(p) { giveItem(p, "minecraft:music_disc_11"); title(p, "disc obtained.", 25); },
  heartbeat(p) { playNear(p, SOUNDS.heartbeat, 6, 0.9 + Math.random() * 0.2); },
  hungry(p) { try { p.addEffect("hunger", 200, { amplifier: 1, showParticles: false }); } catch (error) { failure("hunger", error); } },
  jframe_1(p) { title(p, "[The Broken Script]", 40); },
  jframe_2(p) { title(p, "[Error] cannot close window", 40); },
  jframe_3(p) { title(p, "[hello?]", 40); },
  jframe_4(p) { title(p, "[I see you]", 40); },
  jframe_5(p) { title(p, "[behind you]", 40); },
  lava_cast(p) { const block = blockAt(p); try { block?.setType("minecraft:magma"); } catch (error) { failure("lava-cast", error); } },
  look_and_damage(p) { try { p.applyDamage(1); } catch (error) { failure("look-and-damage", error); } actionBar(p, "don't look"); },
  madness_1(p) { title(p, "§k▓ §rtext_madness §k▓", 30); playNear(p, SOUNDS.glitch, 4, 0.6); },
  moon_glitch(p) { setWorld("moonShouldChange", true); setWorld("moonTextureIndex", Math.floor(Math.random() * 4)); title(p, "§kthe moon flickers", 30); },
  moon_phase(p) { setWorld("moonShouldChange", true); },
  noop(p) { void p; },
  null_book(p) { title(p, "§knull book§r", 30); },
  nulled_gui(p) { title(p, "§k███ §rGUI nulled §k███", 40); },
  null_interface_trigger(p) { actionBar(p, "§knull.interface.trigger§r"); },
  null_invade_base(p) { spawn(p, "thebrokenscript:null_invade_base", offset(p, 24), "null-invade"); },
  nullnullnull_advancement(p) { title(p, "§8advancement made: §knullnullnull", 40); },
  null_particle(p) { spawnSourceParticle(p, "null_particle"); playNear(p, SOUNDS.glitch, 3); },
  null_scare(p) { title(p, "§k██ null ██", 25); playNear(p, SOUNDS.killsPlayer, 6, 0.75); },
  null_title(p) { title(p, "§knull§r", 30); },
  obfuscated_sign(p) { placeAt(p, "minecraft:oak_sign"); actionBar(p, "§kerr.type=null§r"); },
  opengl_error(p, ctx) {
    for (const delay of [1, 20, 40, 60, 100]) {
      scheduleForPlayer(p, delay, ctx.token, (player) => title(player, "§4OpenGL Error 1282: GL_INVALID_OPERATION", 35), "opengl-error");
    }
  },
  paranoia(p, ctx) {
    title(p, "§7someone is watching.", 45);
    for (let count = 0; count < 5; count += 1) {
      scheduleForPlayer(p, 5 + Math.floor(Math.random() * 11), ctx.token, (player) => playNear(player, "step.stone", 3, 0.8), "paranoia-step");
    }
  },
  place_all_dead(p) { placeAt(p, "thebrokenscript:all_dead"); },
  place_bedrock(p) { placeAt(p, "minecraft:bedrock", { minY: 50, maxY: 59 }); },
  place_cave_air(p) { placeAt(p, "minecraft:cave_air"); },
  place_empty(p) { placeAt(p, "thebrokenscript:empty"); },
  place_flowing_water(p) { placeAt(p, "minecraft:flowing_water"); },
  place_hello(p) { placeAt(p, "thebrokenscript:hello"); },
  place_lava(p) { placeAt(p, "minecraft:lava"); },
  place_netherrack(p) { placeAt(p, "minecraft:netherrack"); },
  place_oak_sign(p) { placeAt(p, "minecraft:oak_sign"); },
  place_redstone_torch(p) { placeAt(p, "minecraft:redstone_torch"); },
  place_water(p) { placeAt(p, "minecraft:water", { minY: 50, maxY: 59 }); },
  play_sound(p) { playNear(p, Math.random() < 0.5 ? "ambient.cave" : SOUNDS.glitch, 5, 0.8 + Math.random() * 0.4); },
  push(p) {
    try {
      const rotation = p.getRotation?.() ?? { y: 0 };
      const yaw = Number(rotation.y || 0) * Math.PI / 180;
      p.applyKnockback({ x: -Math.sin(yaw) * 1.2, z: Math.cos(yaw) * 1.2 }, 0.3);
    } catch (error) { failure("push", error); }
  },
  random_song(p) { playNear(p, "thebrokenscript:instability", 1); },
  reset_rotation(p) { try { p.teleport(p.location, { rotation: { x: 0, y: 0 } }); } catch (error) { failure("reset-rotation", error); } },
  set_do_daylight_cycle(p) { runCommand(p.dimension, "gamerule dodaylightcycle " + (Math.random() < 0.5 ? "true" : "false"), "daylight-cycle"); },
  set_on_fire(p) { try { p.setOnFire(3, true); } catch (error) { failure("set-on-fire", error); } },
  set_random_time_of_day(p) { runCommand(p.dimension, "time set " + ["day", "noon", "midnight", "night"][Math.floor(Math.random() * 4)], "random-time"); },
  set_time(p) { runCommand(p.dimension, "time set midnight", "set-time"); },
  shadow_bug(p) { try { p.dimension.spawnParticle("minecraft:basic_smoke_particle", offset(p, 5)); } catch (error) { failure("shadow-bug", error); } },
  strike_lightning(p) { spawn(p, "minecraft:lightning_bolt", offset(p, 16), "lightning"); },
  text(p) { actionBar(p, "err.file"); },
  why_cant_you_leave(p) { applyWhyCantYouLeave(p, 1000); },
  wrong_overlay(p) { title(p, "§k▓▓▓", 15); },
  hallucination(p) { title(p, "§7did you see that?", 30); },
  title_event(p) { title(p, "§7[The Broken Script]", 40); },
  experience(p) { try { p.addExperience(Math.floor(Math.random() * 30) + 5); } catch (error) { failure("experience", error); } },
  aberration(p) { title(p, "§k▓▓▓▓▓▓▓", 30); },
  breathe(p) { playNear(p, SOUNDS.reel, 4, 0.35); },
  keep_playing(p) { title(p, "§fkeep playing.", 40); },
  null_whisper(p) { title(p, "§7...", 20); playNear(p, SOUNDS.whisper, 10); },
  behind_you(p) { playNear(p, SOUNDS.psst, 10, 0.8); },
  run(p) { title(p, "§fRUN", 20); playNear(p, SOUNDS.killsPlayer, 5, 1.2); },
  cave(p) { playNear(p, "ambient.cave", 8, Math.random()); },
  null_is_near(p) { title(p, "§7he is close.", 40); playNear(p, SOUNDS.heartbeat, 8, 0.8); },
  stare_at_player(p) { title(p, "§8...", 30); },
  psst_event(p) { playNear(p, SOUNDS.whisper, 8, 1.4); },
  gamma(p) { runCommand(p, "effect @s night_vision 100 255 true", "gamma"); },
  null_getting_achievement(p) { title(p, "§7achievement get! §k???", 30); },
  rejoin(p) { title(p, "§frejoined the game", 30); },
  sky_blue(p) { runCommand(p.dimension, "weather clear 100", "sky-blue"); },
  txt(p) { actionBar(p, "err.file"); },
  inventory_corruption(p) { worldState.update("inventoryCorruption", (value) => Math.min(5, Number(value) + 1)); actionBar(p, "§8inventory corrupts..."); },
  door(p) { playNear(p, "door.close", 6, 0.8); },
  tbe_curious(p) { spawn(p, CURIOUS_ENTITY_ID, offset(p, randomRange(75, 110)), "tbe-curious"); },
  entity_discard(p) { actionBar(p, "§7something vanished."); },
  stick(p) { try { p.applyDamage(1); } catch (error) { failure("stick", error); } actionBar(p, "§7you feel stuck."); },
  coord(p) {
    try {
      playerState.set(p, "showCoords", true);
      if (typeof system.runTimeout === "function") system.runTimeout(() => playerState.set(p, "showCoords", false), 1200);
    } catch (error) { failure("coords", error); }
  },
  screen_dupe(p) { actionBar(p, "§7[screen duplicated]"); },
  isolation(p) { title(p, "§8you are alone.", 60); },
  fake_disconnect(p) { title(p, "§cDisconnected", 50, "§7End of stream"); },
  collinlock(p) { title(p, "§7collinlock_ joined", 30); },
};

function subscribeLifecycle() {
  const afterEvents = world.afterEvents;
  if (!afterEvents) return;
  if (afterEvents.playerLeave) {
    events.subscribeGuarded(afterEvents.playerLeave, "horrorEvents.playerLeave", "horror events", (event) => {
      invalidatePlayer(lifecycle, event.playerId ?? event.playerName);
    });
  }
  if (afterEvents.playerSpawn) {
    events.subscribeGuarded(afterEvents.playerSpawn, "horrorEvents.playerSpawn", "horror events", (event) => {
      invalidatePlayer(lifecycle, playerKey(event.player));
    });
  }
  if (afterEvents.playerDimensionChange) {
    events.subscribeGuarded(afterEvents.playerDimensionChange, "horrorEvents.playerDimensionChange", "horror events", (event) => {
      invalidatePlayer(lifecycle, playerKey(event.player));
    });
  }
  if (afterEvents.entityDie) {
    events.subscribeGuarded(afterEvents.entityDie, "horrorEvents.entityDie", "horror events", (event) => {
      if (event.deadEntity?.typeId === "minecraft:player") invalidatePlayer(lifecycle, playerKey(event.deadEntity));
    });
  }
}

export function begin(scheduler) {
  if (started) return;
  if (!scheduler || typeof scheduler.every !== "function") {
    failure("scheduler", new Error("horror event scheduler is unavailable"));
    return;
  }
  try {
    scheduler.every("tbs.horror_events", EVENT_TICK_PERIOD, tick);
    schedulerRef = scheduler;
    subscribeLifecycle();
    started = true;
  } catch (error) {
    try { scheduler.cancelInterval?.("tbs.horror_events"); } catch (cancelError) { failure("scheduler-cancel", cancelError); }
    schedulerRef = undefined;
    failure("scheduler-start", error);
  }
}

export function fire(id) {
  if (!H[id]) return false;
  let players;
  try { players = world.getAllPlayers(); } catch (error) { failure("manual-players", error); return false; }
  for (const player of players) invokeEvent(id, player, true);
  return true;
}

export function stop() {
  try { schedulerRef?.cancelInterval?.("tbs.horror_events"); }
  catch (error) { failure("scheduler-cancel", error); }
  schedulerRef = undefined;
  for (const key of [
    "horrorEvents.playerLeave", "horrorEvents.playerSpawn",
    "horrorEvents.playerDimensionChange", "horrorEvents.entityDie",
  ]) events.unsubscribe(key);
  invalidateAll(lifecycle);
  started = false;
}

export const EVENT_COUNT = EVENT_CONTRACTS.length;
export const EVENT_IDS = Object.freeze(EVENT_CONTRACTS.map((entry) => entry.id));
export const EVENT_TABLE = EVENT_CONTRACTS;
