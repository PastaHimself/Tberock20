import { GameMode, ItemStack, system, world } from "@minecraft/server";
import * as state from "../core/state.js";
import * as worldState from "./world_state.js";
import * as playerState from "./player_state.js";
import * as progression from "./progression.js";
import { logger } from "../core/logging.js";
import { applyWhyCantYouLeave } from "./ported_features.js";
import { spawnSourceParticle } from "./particle_runtime.js";
import {
  EVENT_FREQUENCY,
  SOURCE_EVENT_DEFINITIONS,
} from "./horror_rules.js";
import { chooseHorrorEvent } from "./horror_event_model.js";
import { isDayTime, isNightTime } from "./horror_time_model.js";

// Source EventEngine semantics:
//   * one server tick attempt;
//   * one uniformly selected player;
//   * a 2.9166666e-4 event-frequency roll;
//   * one valid event selected with the persistent inverse-frequency tracker.
// Bedrock-only UI effects remain adapters, but their source gates and delayed
// callbacks live here so they cannot outlive a player, dimension, or reload.

const SOUNDS = {
  heartbeat: "thebrokenscript:heartbeat",
  whisper: "thebrokenscript:null_is_here_loop",
  psst: "thebrokenscript:psst",
  glitch: "thebrokenscript:glitch_sound_1",
  reel: "thebrokenscript:reel",
  kills_player: "thebrokenscript:kills_player",
};

const EVENT_WEIGHT_KEY = "horror_event_weights";
const SESSION_PROPERTY = "horror_events_session";
const pendingByPlayer = new Map();
let sessionToken = 0;

function reportAdapterFailure(operation, err) {
  logger.warnOnce(
    `horror-events:adapter:${operation}`,
    `horror event adapter '${operation}' failed; the side effect was skipped`,
    err,
  );
}

function reportHandlerFailure(id, err) {
  logger.errorOnce(
    `horror-events:handler:${id}`,
    `horror event handler '${id}' failed for at least one player`,
    err,
  );
}

function playNear(player, id, volume = 3, pitch = 1) {
  try { player.playSound(id, { volume, pitch }); } catch (err) { reportAdapterFailure(`sound:${id}`, err); }
}

function title(player, text, stay = 30, subtitle) {
  try {
    player.onScreenDisplay.setTitle(text, {
      fadeInDuration: 0,
      stayDuration: stay,
      fadeOutDuration: 10,
      subtitle,
    });
  } catch (err) { reportAdapterFailure("title", err); }
}

function actionBar(player, text) {
  try { player.onScreenDisplay.setActionBar(text); } catch (err) { reportAdapterFailure("action-bar", err); }
}

function playerId(playerOrId) {
  return typeof playerOrId === "string" ? playerOrId : playerOrId?.id;
}

function currentSession() {
  try { return Number(world.getDynamicProperty(SESSION_PROPERTY) ?? sessionToken); } catch { return sessionToken; }
}

function beginSession() {
  clearAll();
  try {
    sessionToken = currentSession() + 1;
    world.setDynamicProperty(SESSION_PROPERTY, sessionToken);
  } catch {
    sessionToken += 1;
  }
}

function scheduleForPlayer(player, delayTicks, callback) {
  const id = playerId(player);
  if (!id || typeof system.runTimeout !== "function") return undefined;
  const capturedSession = sessionToken;
  const capturedDimension = player.dimension?.id;
  const handles = pendingByPlayer.get(id) ?? new Set();
  pendingByPlayer.set(id, handles);

  let handle;
  const run = () => {
    handles.delete(handle);
    if (handles.size === 0) pendingByPlayer.delete(id);
    if (capturedSession !== sessionToken || currentSession() !== capturedSession) return;

    try {
      const valid = player.isValid !== false;
      if (!valid || (capturedDimension && player.dimension?.id !== capturedDimension)) return;
      callback(player);
    } catch (err) {
      reportAdapterFailure("delayed-callback", err);
    }
  };

  try {
    handle = system.runTimeout(run, Math.max(0, Math.floor(Number(delayTicks) || 0)));
    handles.add(handle);
    return handle;
  } catch (err) {
    handles.delete(handle);
    if (handles.size === 0) pendingByPlayer.delete(id);
    reportAdapterFailure("schedule", err);
    return undefined;
  }
}

export function clearPlayer(playerOrId) {
  const id = playerId(playerOrId);
  if (!id) return false;
  const handles = pendingByPlayer.get(id);
  if (!handles) return false;
  for (const handle of handles) {
    try { system.clearRun(handle); } catch (err) { reportAdapterFailure("clear-scheduled-callback", err); }
  }
  pendingByPlayer.delete(id);
  return true;
}

export function clearAll() {
  for (const id of pendingByPlayer.keys()) clearPlayer(id);
  pendingByPlayer.clear();
}

// ── Bedrock effect adapters ────────────────────────────────────────────────
const H = {
  noop() {},

  heartbeat(p) { playNear(p, SOUNDS.heartbeat, 6, 0.9 + Math.random() * 0.2); },
  play_sound(p) { playNear(p, Math.random() < 0.5 ? "ambient.cave" : SOUNDS.glitch, 5, Math.random()); },
  random_song(p) {
    const songs = ["thebrokenscript:instability", "thebrokenscript:instabilityv2", "thebrokenscript:instabilityv3"];
    try { p.dimension.playSound(songs[Math.floor(Math.random() * songs.length)], p.location, { volume: 1 }); } catch (err) { reportAdapterFailure("dimension-sound", err); }
    scheduleForPlayer(p, 321, (player) => {
      if (Math.random() < 0.25) H.strike_lightning(player);
    });
  },
  psst_event(p) { playNear(p, SOUNDS.whisper, 8, 1.4); },
  null_whisper(p) { title(p, "§7...", 20); playNear(p, SOUNDS.whisper, 10, 1); },
  breathe(p) { playNear(p, SOUNDS.reel, 4, 0.35); },
  cave(p) { playNear(p, "ambient.cave", 8, Math.random()); },

  opengl_error(p) {
    for (const delay of [1, 20, 40, 60, 100]) {
      scheduleForPlayer(p, delay, (player) => title(player, "§4OpenGL Error 1282: GL_INVALID_OPERATION", 60));
    }
  },
  nulled_gui(p) { title(p, "§k███ §rGUI nulled §k███", 40); },
  screen_dupe(p) { actionBar(p, "§7[screen duplicated]"); },
  fake_disconnect(p) {
    title(p, "§cDisconnected", 50, "§7End of stream");
    scheduleForPlayer(p, 100, (player) => title(player, "§freconnected", 30));
  },
  close_menu(p) { title(p, " ", 5); },
  keep_playing(p) { title(p, "§fkeep playing.", 40); },
  why_cant_you_leave(p) { applyWhyCantYouLeave(p, 1000); },
  rejoin(p) { title(p, "§frejoined the game", 30); },
  isolation(p) { title(p, "§8you are alone.", 60); },
  collinlock(p) { title(p, "§7collinlock_ joined", 30); },
  jframe_1(p) { title(p, "§7[The Broken Script]", 40); },
  jframe_2(p) { title(p, "§7[Error] — cannot close window", 40); },
  jframe_3(p) { title(p, "§7[hello?]", 40); },
  jframe_4(p) { title(p, "§7[I see you]", 40); },
  jframe_5(p) { title(p, "§7[behind you]", 40); },
  wrong_overlay(p) { title(p, "§k▓▓▓", 15); },
  bsod(p) {
    title(p, "§f:(", 80, "§7A problem has been detected.");
    if (Math.random() >= 0.55) scheduleForPlayer(p, 225, (player) => H.strike_lightning(player));
  },
  sky_blue(p) {
    try { playerState.set(p, "showSkyBlue", true); } catch (err) { reportAdapterFailure("sky-blue-state", err); }
    try { p.dimension.runCommand("weather clear 100"); } catch (err) { reportAdapterFailure("weather", err); }
  },
  gamma(p) { try { p.runCommand("effect @s night_vision 100 255 true"); } catch (err) { reportAdapterFailure("night-vision", err); } },

  null_title(p) { title(p, "§knull§r", 30); },
  null_particle(p) {
    spawnSourceParticle(p, "null_particle");
    playNear(p, SOUNDS.glitch, 3, 1);
  },
  null_scare(p) {
    title(p, "§k██ null ██", 25);
    playNear(p, SOUNDS.kills_player, 6, 0.75);
  },
  null_is_near(p) { title(p, "§7he is close.", 40); playNear(p, SOUNDS.heartbeat, 8, 0.8); },
  stare_at_player(p) { title(p, "§8...", 30); },
  behind_you(p) { playNear(p, SOUNDS.psst, 10, 0.8); },
  run(p) { title(p, "§fRUN", 20); playNear(p, SOUNDS.kills_player, 5, 1.2); },

  damage(p) { try { p.applyDamage(2); } catch (err) { reportAdapterFailure("damage", err); } },
  look_and_damage(p) {
    scheduleForPlayer(p, 1, (player) => {
      try { player.applyDamage(1); } catch (err) { reportAdapterFailure("look-and-damage", err); }
      actionBar(player, "§cdon't look");
      for (const delay of [5, 10, 15]) scheduleForPlayer(player, delay, (next) => {
        try { next.applyDamage(1); } catch (err) { reportAdapterFailure("look-and-damage-followup", err); }
      });
    });
  },
  set_on_fire(p) {
    try { p.runCommand("execute as @s run particle minecraft:flame_particle ^ ^1 ^"); } catch (err) { reportAdapterFailure("fire-particle", err); }
    try { p.setOnFire(3, true); } catch (err) { reportAdapterFailure("set-on-fire", err); }
  },
  push(p) {
    const v = p.getVelocity();
    const horizontalSpeed = Math.hypot(v.x, v.z);
    const horizontalForce = horizontalSpeed > 0
      ? { x: (v.x / horizontalSpeed) * 2, z: (v.z / horizontalSpeed) * 2 }
      : { x: 0, z: 0 };
    try { p.applyKnockback(horizontalForce, 0.4); } catch (err) { reportAdapterFailure("knockback", err); }
  },
  stick(p) { try { p.applyDamage(1); } catch (err) { reportAdapterFailure("stick-damage", err); } actionBar(p, "§7you feel stuck."); },
  explode_base(p) {
    try { p.dimension.createExplosion(p.location, 2, { breaksBlocks: false }); } catch (err) { reportAdapterFailure("explosion", err); }
  },
  lava_cast(p) {
    try { p.dimension.getBlock({ x: Math.floor(p.location.x), y: Math.floor(p.location.y) - 1, z: Math.floor(p.location.z) })?.setType("minecraft:magma"); } catch (err) { reportAdapterFailure("lava-cast", err); }
  },
  hungry(p) { try { p.addEffect("hunger", 200, { amplifier: 1, showParticles: false }); } catch (err) { reportAdapterFailure("hunger", err); } },
  paranoia(p) {
    title(p, "§7someone is watching.", 45);
    playNear(p, SOUNDS.heartbeat, 5, 1);
    let delay = 0;
    for (let index = 0; index < 5; index += 1) {
      delay += 5 + Math.floor(Math.random() * 12);
      scheduleForPlayer(p, delay, (player) => playNear(player, SOUNDS.heartbeat, 4, 0.8 + Math.random() * 0.4));
    }
  },
  madness_1(p) { title(p, "§k▓ §rtext_madness §k▓", 30); playNear(p, SOUNDS.glitch, 4, 0.6); },
  eyes(p) {
    spawnSourceParticle(p, "eyes");
    title(p, "§4◉ ‸ ◉", 20);
  },

  set_time(p) { try { p.dimension.runCommand("time set midnight"); } catch (err) { reportAdapterFailure("set-time", err); } },
  set_random_time_of_day(p) {
    const times = ["day", "noon", "midnight", "night"];
    try { p.dimension.runCommand(`time set ${times[Math.floor(Math.random() * times.length)]}`); } catch (err) { reportAdapterFailure("random-time", err); }
  },
  set_do_daylight_cycle(p) {
    const next = Math.random() < 0.5;
    try { p.dimension.runCommand(`gamerule dodaylightcycle ${next ? "true" : "false"}`); } catch (err) { reportAdapterFailure("daylight-cycle", err); }
    try { worldState.set("daylightCycle", next); worldState.set("daylightCycleEventTimer", 4000); } catch (err) { reportAdapterFailure("daylight-cycle-state", err); }
    scheduleForPlayer(p, 4000, () => {
      try { worldState.set("daylightCycleEventTimer", 0); } catch (err) { reportAdapterFailure("daylight-cycle-reset", err); }
    });
  },
  moon_phase() { worldState.update("moonStage", (value) => value >= 2 ? 0 : value + 1); worldState.set("moonShouldChange", false); },
  moon_glitch(p) {
    setFakeMoonTexture();
    try { playerState.setMoonGlitch(p, true); } catch (err) { reportAdapterFailure("moon-glitch-state", err); }
    title(p, "§kthe moon flickers", 30);
  },
  reset_rotation(p) {
    try { p.teleport(p.location, { rotation: { x: 0, y: 0 } }); } catch (err) { reportAdapterFailure("reset-rotation", err); }
  },

  place_bedrock(p) { placeAt(p, "minecraft:bedrock"); },
  place_cave_air(p) { placeAt(p, "minecraft:cave_air"); },
  place_empty(p) { placeAt(p, "thebrokenscript:empty"); },
  place_hello(p) { placeAt(p, "thebrokenscript:hello"); },
  place_netherrack(p) { placeAt(p, "minecraft:netherrack"); },
  place_redstone_torch(p) { placeAt(p, "minecraft:redstone_torch"); },
  place_water(p) { placeAt(p, "minecraft:water"); },
  place_flowing_water(p) { placeAt(p, "minecraft:flowing_water"); },
  place_lava(p) { placeAt(p, "minecraft:lava"); },
  place_all_dead(p) { placeAt(p, "thebrokenscript:all_dead"); },
  place_oak_sign(p) { placeAt(p, "minecraft:oak_sign"); },
  doors(p) { playNear(p, "door.open", 6, 0.8); },
  door(p) { playNear(p, "door.close", 6, 0.8); },

  false_villager(p) { try { p.dimension.spawnEntity("minecraft:villager_v2", offsetFrom(p, 12)); } catch (err) { reportAdapterFailure("false-villager", err); } },
  strike_lightning(p) { try { p.dimension.spawnEntity("minecraft:lightning_bolt", offsetFrom(p, 16)); } catch (err) { reportAdapterFailure("lightning", err); } },
  shadow_bug(p) { try { p.dimension.spawnParticle("minecraft:basic_smoke_particle", offsetFrom(p, 5)); } catch (err) { reportAdapterFailure("shadow-particle", err); } },
  hallucination(p) { title(p, "§7did you see that?", 30); },
  entity_discard(p) { actionBar(p, "§7something vanished."); try { playerState.set(p, "despawnEntitySwitch", true); } catch (err) { reportAdapterFailure("despawn-state", err); } },
  null_invade_base(p) {
    try { p.dimension.spawnEntity("thebrokenscript:null_invade_base", offsetFrom(p, 24)); } catch (err) { reportAdapterFailure("null-invade", err); }
  },
  tbe_curious(p) { try { p.dimension.spawnEntity("thebrokenscript:the_broken_end_curious", offsetFrom(p, 40)); } catch (err) { reportAdapterFailure("tbe-curious", err); } },

  give_disc_11(p) { giveItem(p, "minecraft:music_disc_cat", 1); title(p, "§7disc obtained.", 25); },
  giift(p) { giveItem(p, "thebrokenscript:torn_paper", 1); title(p, "§7a gift?", 25); },
  experience(p) { try { p.addExperience(Math.floor(Math.random() * 30) + 5); } catch (err) { reportAdapterFailure("experience", err); } },
  inventory_corruption(p) {
    worldState.update("inventoryCorruption", (value) => Math.min(5, value + 1));
    if ((worldState.get("inventoryCorruption") ?? 0) >= 5) worldState.set("inventoryCorruptionProgressed", true);
    actionBar(p, "§8inventory corrupts...");
  },
  nullnullnull_advancement(p) { progression.award(p.id, "nullnullnull"); title(p, "§8advancement made: §knullnullnull", 40); },
  null_getting_achievement(p) { progression.award(p.id, "can_someone_hear_me"); title(p, "§7achievement get! §k???", 30); },
  can_someone_hear_me(p) { progression.award(p.id, "can_someone_hear_me"); title(p, "§7can someone hear me?", 40); },
  coord(p) {
    actionBar(p, `§7X:${Math.floor(p.location.x)} Y:${Math.floor(p.location.y)} Z:${Math.floor(p.location.z)}`);
    try { playerState.set(p, "showCoords", true); } catch (err) { reportAdapterFailure("coords-state", err); }
    scheduleForPlayer(p, 1200, (player) => {
      try { playerState.set(player, "showCoords", false); } catch (err) { reportAdapterFailure("coords-reset", err); }
    });
  },
  txt(p) { try { p.sendMessage(["err.file", "err.type=null.txt", "..."].sort(() => Math.random() - 0.5)[0]); } catch (err) { reportAdapterFailure("text-event", err); } },

  // These source registrations are desktop/client effects or interface
  // dispatchers. They still have a concrete Bedrock adapter instead of being
  // silently omitted from the weighted registry.
  null_book(p) { giveItem(p, "minecraft:book", 1); title(p, "§7a book appeared.", 25); },
  null_interface_trigger(p) { [H.null_title, H.nulled_gui, H.null_scare][Math.floor(Math.random() * 3)](p); },
  obfuscated_sign(p) { placeAt(p, "minecraft:oak_sign"); title(p, "§kread carefully", 25); },
  text(p) { H.txt(p); },
  title_event(p) { title(p, ["§knull§r", "§4ERROR", "§7..."].sort(() => Math.random() - 0.5)[0], 35); },
  aberration(p) {
    try { playerState.set(p, "aberrationEnabled", true); playerState.set(p, "aberrationTimer", 1200); } catch (err) { reportAdapterFailure("aberration-state", err); }
  },
};

function setFakeMoonTexture() {
  worldState.set("moonTextureIndex", Math.floor(Math.random() * 4));
}

function placeAt(player, blockId) {
  try {
    const block = player.dimension.getBlock({
      x: Math.floor(player.location.x) + Math.floor(Math.random() * 5 - 2),
      y: Math.floor(player.location.y) - 1,
      z: Math.floor(player.location.z) + Math.floor(Math.random() * 5 - 2),
    });
    if (block && (block.typeId === "minecraft:air" || block.isAir)) block.setType(blockId);
  } catch (err) { reportAdapterFailure("placement", err); }
}

function offsetFrom(player, distance) {
  return {
    x: player.location.x + (Math.random() * 2 - 1) * distance,
    y: player.location.y,
    z: player.location.z + (Math.random() * 2 - 1) * distance,
  };
}

function giveItem(player, itemId, amount) {
  try {
    const inventory = player.getComponent("minecraft:inventory")?.container;
    if (inventory) inventory.addItem(new ItemStack(itemId, amount));
  } catch (err) { reportAdapterFailure("inventory", err); }
}

function reputationFor(player) {
  try {
    const reputation = Number(playerState.get(player, "entityReputation"));
    return reputation < 25 ? "BAD" : reputation < 76 ? "NORMAL" : "GOOD";
  } catch (err) {
    reportAdapterFailure("reputation", err);
    return "NORMAL";
  }
}

function isFakeNullPlayer(player) {
  try {
    return playerState.get(player, "fakeNull") === true || playerState.get(player, "isNullProfile") === true;
  } catch {
    return false;
  }
}

function worldTimeOfDay() {
  try {
    if (typeof world.getTimeOfDay === "function") return Number(world.getTimeOfDay());
  } catch (err) { reportAdapterFailure("time-of-day", err); }
  return 0;
}

function moonPhase() {
  try {
    if (typeof world.getMoonPhase === "function") return Number(world.getMoonPhase());
  } catch (err) { reportAdapterFailure("moon-phase", err); }
  return undefined;
}

function eventContext(player, players, randomBoolean) {
  const time = worldTimeOfDay();
  let survival = true;
  try { survival = typeof player.getGameMode !== "function" || player.getGameMode() === GameMode.Survival; } catch (err) { reportAdapterFailure("game-mode", err); }
  const dimensionId = player.dimension?.id ?? "minecraft:overworld";
  const curious = (() => {
    try {
      return player.dimension.getEntities({ type: "thebrokenscript:the_broken_end_curious", location: player.location, maxDistance: 64 }).length > 0;
    } catch {
      return false;
    }
  })();
  return {
    enabled: !bossArenaActive() && !dimensionId.startsWith("thebrokenscript:"),
    isNullHere: worldState.get("isNullHere") === true,
    isFakeNull: isFakeNullPlayer(player),
    survival,
    funnyEnabled: true,
    dimensionId,
    reputation: reputationFor(player),
    isDay: isDayTime(time),
    isNight: isNightTime(time),
    moonPhase: moonPhase(),
    moonShouldChange: worldState.get("moonShouldChange") === true,
    moonStage: worldState.get("moonStage"),
    moonGlitchDuration: playerState.get(player, "moonGlitchDuration"),
    hasCuriousEntity: curious,
    randomBoolean,
    playerCount: players.length,
    showCoords: playerState.get(player, "showCoords"),
    inventoryCorruptionProgressed: worldState.get("inventoryCorruptionProgressed"),
    despawnEntitySwitch: playerState.get(player, "despawnEntitySwitch"),
    daylightCycle: worldState.get("daylightCycle"),
    daylightCycleEventTimer: worldState.get("daylightCycleEventTimer"),
  };
}

function readEventWeights() {
  const weights = state.getWorldJSON(EVENT_WEIGHT_KEY, {});
  return weights && typeof weights === "object" && !Array.isArray(weights) ? weights : {};
}

function recordEventWeight(id, weights) {
  weights[id] = Math.max(1, Number(weights[id] ?? 1)) + 1;
  try { state.setWorldJSON(EVENT_WEIGHT_KEY, weights); } catch (err) { reportAdapterFailure("event-weight-persistence", err); }
}

function bossArenaActive() {
  try { return world.getDynamicProperty("tbs:arenaActive") === true; } catch (err) { reportAdapterFailure("arena-state", err); return false; }
}

function tick() {
  const players = world.getAllPlayers();
  if (players.length === 0) return;

  const selection = chooseHorrorEvent({
    players,
    eventDefinitions: SOURCE_EVENT_DEFINITIONS,
    eventFrequency: EVENT_FREQUENCY,
    arenaActive: bossArenaActive(),
    getEventWeights: readEventWeights,
    random01: Math.random,
    hasHandler: (id) => typeof H[id] === "function",
    buildContext: (target, allPlayers, randomBoolean) => eventContext(target, allPlayers, randomBoolean),
  });
  const selected = selection.selected;
  if (!selected) return;

  const weights = selection.weights ?? readEventWeights();
  recordEventWeight(selected.id, weights);
  try { H[selected.id](selection.target); } catch (err) { reportHandlerFailure(selected.id, err); }
}

export function begin(scheduler) {
  beginSession();
  scheduler.every("tbs.horror_events", 1, tick);
}

// Developer command adapter: force the named event for every current player,
// matching the old command behavior and intentionally bypassing ambient gates.
export function fire(id) {
  const fn = H[id];
  if (!fn) return false;
  for (const player of world.getAllPlayers()) {
    try { fn(player); } catch (err) { reportHandlerFailure(id, err); }
  }
  return true;
}

export const EVENT_IDS = SOURCE_EVENT_DEFINITIONS.map((definition) => definition.id);
export const EVENT_COUNT = SOURCE_EVENT_DEFINITIONS.length;
