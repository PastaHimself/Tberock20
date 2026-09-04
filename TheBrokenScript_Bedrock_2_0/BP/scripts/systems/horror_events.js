import { world, system, ItemStack } from "@minecraft/server";
import * as worldState from "./world_state.js";
import * as dimensions from "./dimensions.js";
import * as progression from "./progression.js";
import * as playerState from "./player_state.js";
import { config } from "../core/config.js";
import * as state from "../core/state.js";
import {
  aggregateEventFrequency,
  pickEvent,
} from "./event_scheduler_model.js";
import {
  ABERRATION_TIMER_TICKS,
  TEXT_EVENT_MESSAGES,
  obfuscatedSignOutcome,
  titleEventOutcome,
} from "./horror_event_model.js";
import { createSignedNullBook, distributeNullBook } from "./story_book_adapter.js";
import { logger } from "../core/logging.js";
import { applyWhyCantYouLeave, showFakeDisconnect, showNullInterface, showNulledGui } from "./ported_features.js";
import { spawnSourceParticle } from "./particle_runtime.js";

// ── Chunk 12: Events & horror choreography ──────────────────────────────────
// 95 event classes in source (81 TBSEvents + 14 others). OS-level events
// (jframe/window titles, BSOD, fake crash) approximate to titles per A-004.
// The source engine evaluates one random survival player every tick. Each
// registered event has source weight 1, persistent inverse occurrence weighting,
// disabled-id filtering, and optional rerolls for events that cannot execute.

const SOUNDS = {
  heartbeat: "thebrokenscript:heartbeat",
  whisper: "thebrokenscript:null_is_here_loop",
  psst: "thebrokenscript:psst",
  glitch: "thebrokenscript:glitch_sound_1",
  reel: "thebrokenscript:reel",
  circuit_deceive: "thebrokenscript:circuit_deceive",
  kills_player: "thebrokenscript:kills_player"
};

function playNear(player, id, vol = 3, pitch = 1) {
  try { player.playSound(id, { volume: vol, pitch }); } catch {}
}
function title(player, text, stay = 30, sub) {
  try { player.onScreenDisplay.setTitle(text, { fadeInDuration: 0, stayDuration: stay, fadeOutDuration: 10, subtitle: sub }); } catch {}
}
function actionBar(player, text) {
  try { player.onScreenDisplay.setActionBar(text); } catch {}
}

// ── handlers ────────────────────────────────────────────────────────────────
const H = {
  // ambient audio
  heartbeat(p) { playNear(p, SOUNDS.heartbeat, 6, 0.9 + Math.random() * 0.2); },
  play_sound(p) { playNear(p, Math.random() < 0.5 ? "ambient.cave" : SOUNDS.glitch, 5, Math.random()); },
  random_song(p) {
    const songs = ["thebrokenscript:instability", "thebrokenscript:instabilityv2", "thebrokenscript:instabilityv3"];
    try { p.dimension.playSound(songs[Math.floor(Math.random() * songs.length)], p.location, { volume: 1 }); } catch {}
  },
  psst_event(p) { playNear(p, SOUNDS.whisper, 8, 1.4); },
  null_whisper(p) { title(p, "§7...", 20); playNear(p, SOUNDS.whisper, 10, 1); },
  breathe(p) { playNear(p, SOUNDS.reel, 4, 0.35); },
  cave(p) { playNear(p, "ambient.cave", 8, Math.random()); },

  // visual overlays
  opengl_error(p) { title(p, "§4OpenGL Error 1282: GL_INVALID_OPERATION", 60); },
  nulled_gui(p) {
    void showNulledGui(p);
    playNear(p, SOUNDS.glitch, 10, 0.0);
  },
  screen_dupe(p) { actionBar(p, "§7[screen duplicated]"); },
  fake_disconnect(p) {
    void showFakeDisconnect(p);
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
  bsod(p) { title(p, "§f:(", 80, "§7A problem has been detected."); },
  sky_blue(p) { try { p.dimension.runCommand("weather clear 100"); } catch {} },
  gamma(p) { try { p.runCommand("effect @s night_vision 100 255 true"); } catch {} },

  // source-registered NullEvent adapters
  null_book(p) {
    let item;
    try {
      item = createSignedNullBook(
        ItemStack,
        worldState.get("clanVoidX"),
        worldState.get("clanVoidZ"),
        Math.random() < 0.5,
      );
    } catch {}
    if (item) distributeNullBook(p, item);
  },
  null_interface_trigger(p) {
    void showNullInterface(p, Math.floor(Math.random() * 3));
  },

  // null-flavored
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

  // damage-ish
  damage(p) { try { p.applyDamage(2); } catch {} },
  look_and_damage(p) { try { p.applyDamage(1); } catch {} actionBar(p, "§cdon't look"); },
  set_on_fire(p) { try { p.runCommand("execute as @s run particle minecraft:flame_particle ^ ^1 ^"); } catch {} try { p.setOnFire(3, true); } catch {} },
  /** @param {import("@minecraft/server").Player} p */
  push(p) {
    const v = p.getVelocity();
    const horizontalSpeed = Math.hypot(v.x, v.z);
    const horizontalForce = horizontalSpeed > 0
      ? { x: (v.x / horizontalSpeed) * 2, z: (v.z / horizontalSpeed) * 2 }
      : { x: 0, z: 0 };
    try { p.applyKnockback(horizontalForce, 0.4); } catch {}
  },
  stick(p) { try { p.applyDamage(1); } catch {} actionBar(p, "§7you feel stuck."); },
  explode_base(p) {
    try { p.dimension.createExplosion(p.location, 2, { breaksBlocks: false }); } catch {}
  },
  lava_cast(p) {
    try { p.dimension.getBlock({ x: Math.floor(p.location.x), y: Math.floor(p.location.y) - 1, z: Math.floor(p.location.z) })?.setType("minecraft:magma"); } catch {}
  },
  hungry(p) { try { p.addEffect("hunger", 200, { amplifier: 1, showParticles: false }); } catch {} },
  paranoia(p) { title(p, "§7someone is watching.", 45); playNear(p, SOUNDS.heartbeat, 5, 1); },
  madness_1(p) { title(p, "§k▓ §rtext_madness §k▓", 30); playNear(p, SOUNDS.glitch, 4, 0.6); },
  eyes(p) {
    spawnSourceParticle(p, "eyes");
    title(p, "§4◉ ‸ ◉", 20);
  },

  // time/sky
  set_time(p) { try { p.dimension.runCommand("time set midnight"); } catch {} },
  set_random_time_of_day(p) {
    const times = ["day", "noon", "midnight", "night"];
    try { p.dimension.runCommand(`time set ${times[Math.floor(Math.random() * times.length)]}`); } catch {}
  },
  set_do_daylight_cycle(p) {
    const v = Math.random() < 0.5 ? "true" : "false";
    try { p.dimension.runCommand(`gamerule dodaylightcycle ${v}`); } catch {}
  },
  moon_phase(p) { worldState.update("moonShouldChange", () => true); },
  moon_glitch(p) { setFakeMoonTexture(); title(p, "§kthe moon flickers", 30); },
  reset_rotation(p) {
    try { p.teleport(p.location, { rotation: { x: 0, y: 0 } }); } catch {}
  },

  obfuscated_sign(p) {
    if (config.get("world.disableRandomStructures")) return;
    const structure = obfuscatedSignOutcome(Math.random());
    placeAt(p, "minecraft:oak_sign");
    actionBar(p, `§7${structure} sign attempted at the local base fallback.`);
  },
  noop() {},
  text(p) {
    const message = TEXT_EVENT_MESSAGES[Math.floor(Math.random() * TEXT_EVENT_MESSAGES.length)];
    try { p.sendMessage(message); } catch { actionBar(p, message); }
  },
  title_event(p) {
    const outcome = titleEventOutcome({
      outerRoll: Math.random(),
      innerRoll: Math.random(),
      branchRoll: Math.random(),
      nullTitleIndex: Math.floor(Math.random() * 16),
    });
    title(p, outcome.text, outcome.kind === "clear" ? 5 : 40);
  },
  aberration(p) {
    playerState.set(p, "aberrationEnabled", true);
    playerState.set(p, "aberrationTimer", ABERRATION_TIMER_TICKS);
  },

  // placement pranks
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

  // entities
  false_villager(p) { try { p.dimension.spawnEntity("minecraft:villager_v2", offsetFrom(p, 12)); } catch {} },
  strike_lightning(p) { try { p.dimension.spawnEntity("minecraft:lightning_bolt", offsetFrom(p, 16)); } catch {} },
  shadow_bug(p) { try { p.dimension.spawnParticle("minecraft:basic_smoke_particle", offsetFrom(p, 5)); } catch {} },
  hallucination(p) { title(p, "§7did you see that?", 30); },
  entity_discard(p) { actionBar(p, "§7something vanished."); },
  null_invade_base(p) {
    try { p.dimension.spawnEntity("thebrokenscript:null_invade_base", offsetFrom(p, 24)); } catch {}
  },
  tbe_curious(p) { try { p.dimension.spawnEntity("thebrokenscript:the_broken_end_curious", offsetFrom(p, 40)); } catch {} },

  // progression / items
  give_disc_11(p) { giveItem(p, "minecraft:music_disc_cat", 1); title(p, "§7disc obtained.", 25); },
  giift(p) { giveItem(p, "thebrokenscript:torn_paper", 1); title(p, "§7a gift?", 25); },
  experience(p) { try { p.addExperience(Math.floor(Math.random() * 30) + 5); } catch {} },
  inventory_corruption(p) { worldState.update("inventoryCorruption", (n) => Math.min(5, n + 1)); actionBar(p, "§8inventory corrupts..."); },
  nullnullnull_advancement(p) { progression.award(p.id, "nullnullnull"); title(p, "§8advancement made: §knullnullnull", 40); },
  null_getting_achievement(p) { progression.award(p.id, "can_someone_hear_me"); title(p, "§7achievement get! §k???", 30); },
  can_someone_hear_me(p) { progression.award(p.id, "can_someone_hear_me"); title(p, "§7can someone hear me?", 40); },
  coord(p) { actionBar(p, `§7X:${Math.floor(p.location.x)} Y:${Math.floor(p.location.y)} Z:${Math.floor(p.location.z)}`); },
  txt(p) { actionBar(p, "err.file"); }
};

function setFakeMoonTexture() {
  worldState.set("moonTextureIndex", Math.floor(Math.random() * 4));
}
function placeAt(p, blockId) {
  try {
    const b = p.dimension.getBlock({
      x: Math.floor(p.location.x) + Math.floor(Math.random() * 5 - 2),
      y: Math.floor(p.location.y) - 1,
      z: Math.floor(p.location.z) + Math.floor(Math.random() * 5 - 2)
    });
    if (b && (b.typeId === "minecraft:air" || b.isAir)) b.setType(blockId);
  } catch {}
}
function offsetFrom(p, dist) {
  return {
    x: p.location.x + (Math.random() * 2 - 1) * dist,
    y: p.location.y,
    z: p.location.z + (Math.random() * 2 - 1) * dist
  };
}
function giveItem(p, itemId, amount) {
  try {
    const inv = p.getComponent("minecraft:inventory")?.container;
    if (inv) inv.addItem(new ItemStack(itemId, amount));
  } catch {}
}

// event table: [id, gate] — gates: null (always after first join day), nullHere, moon
const TABLE = [
  ["null_book", "null"], ["null_interface_trigger", "null"],
  ["obfuscated_sign", null], ["noop", null], ["text", null], ["title_event", null], ["aberration", null],
  ["heartbeat", null], ["play_sound", null], ["random_song", null], ["psst_event", null],
  ["breathe", null], ["cave", null], ["doors", null], ["door", null], ["coord", null], ["txt", null],
  ["opengl_error", "null"], ["nulled_gui", "null"], ["screen_dupe", "null"], ["fake_disconnect", "null"],
  ["close_menu", "null"], ["keep_playing", "null"], ["why_cant_you_leave", "null"], ["rejoin", "null"],
  ["isolation", "null"], ["collinlock", "null"], ["jframe_1", "null"], ["jframe_2", "null"],
  ["jframe_3", "null"], ["jframe_4", "null"], ["jframe_5", "null"], ["wrong_overlay", "null"],
  ["bsod", "moon"], ["sky_blue", null], ["gamma", "moon"], ["reset_rotation", null],
  ["null_title", "null"], ["null_particle", "null"], ["null_scare", "null"], ["null_is_near", "null"],
  ["stare_at_player", "null"], ["behind_you", "null"], ["run", "null"], ["null_whisper", "null"],
  ["damage", "null"], ["look_and_damage", "null"], ["set_on_fire", "moon"], ["push", "null"],
  ["stick", "null"], ["explode_base", "moon"], ["lava_cast", "moon"], ["hungry", null],
  ["paranoia", "null"], ["madness_1", "null"], ["eyes", "null"],
  ["set_time", "null"], ["set_random_time_of_day", "null"], ["set_do_daylight_cycle", "null"],
  ["moon_phase", "moon"], ["moon_glitch", "moon"],
  ["place_bedrock", "null"], ["place_cave_air", "null"], ["place_empty", "null"], ["place_hello", "null"],
  ["place_netherrack", "moon"], ["place_redstone_torch", null], ["place_water", null], ["place_flowing_water", null],
  ["place_lava", "moon"], ["place_all_dead", "null"], ["place_oak_sign", "null"],
  ["false_villager", null], ["strike_lightning", "moon"], ["shadow_bug", null], ["hallucination", "null"],
  ["entity_discard", "null"], ["null_invade_base", "nullHere"], ["tbe_curious", "nullHere"],
  ["give_disc_11", "null"], ["giift", "null"], ["experience", null], ["inventory_corruption", "moon"],
  ["nullnullnull_advancement", "nullHere"], ["null_getting_achievement", "null"], ["can_someone_hear_me", "null"]
];

const EVENT_DEFINITIONS = TABLE.map(([id, gate]) => ({
  id,
  gate,
  weight: 1,
}));

const EVENT_WEIGHTS_STATE_KEY = "eventWeights";
const DISABLED_EVENTS_STATE_KEY = "eventDisabledIds";

function configBoolean(key, fallback) {
  try { return Boolean(config.get(key)); } catch { return fallback; }
}

function readEventCounts() {
  try {
    const counts = state.getWorldJSON(EVENT_WEIGHTS_STATE_KEY, {});
    return counts && typeof counts === "object" && !Array.isArray(counts) ? counts : {};
  } catch { return {}; }
}

function writeEventCounts(counts) {
  try { state.setWorldJSON(EVENT_WEIGHTS_STATE_KEY, counts); } catch (err) {
    logger.warn("event weight persistence failed: " + (err?.message ?? err));
  }
}

function normalizeEventId(value) {
  const raw = String(value ?? "").trim();
  return raw.includes(":") ? raw.slice(raw.lastIndexOf(":") + 1) : raw;
}

function validEventId(value) {
  return /^[a-z0-9_.-]+(?::[a-z0-9_.-]+)?$/i.test(value);
}

function readDisabledEventIds() {
  try {
    const ids = state.getWorldJSON(DISABLED_EVENTS_STATE_KEY, []);
    return Array.isArray(ids)
      ? ids.filter(validEventId).map(normalizeEventId)
      : [];
  } catch { return []; }
}

export function setDisabledEvents(ids) {
  const normalized = [...new Set(Array.isArray(ids) ? ids : [])]
    .map((id) => String(id).trim())
    .filter(validEventId)
    .map(normalizeEventId);
  try { state.setWorldJSON(DISABLED_EVENTS_STATE_KEY, normalized); } catch (err) {
    logger.warn("event disabled-id persistence failed: " + (err?.message ?? err));
  }
  return normalized;
}

export function getDisabledEvents() {
  return readDisabledEventIds();
}

function worldAbsoluteTime() {
  try {
    const getAbsoluteTime = world["getAbsoluteTime"];
    if (typeof getAbsoluteTime === "function") return getAbsoluteTime.call(world);
  } catch {}
  return system.currentTick;
}

function playerCanExecute(player) {
  const getGameMode = player?.["getGameMode"];
  if (typeof getGameMode !== "function") return true;
  try {
    return String(getGameMode.call(player)).toLowerCase() === "survival";
  } catch { return true; }
}

function eventsEnabledForPlayer(player) {
  if (bossArenaActive()) return false;
  try {
    const dimensionId = String(player?.dimension?.id ?? "");
    return !dimensionId.startsWith("thebrokenscript:");
  } catch { return true; }
}

export function begin(scheduler) {
  // EventEngine.tick is a server-tick hook in Java; getAbsoluteTime() supplies
  // the matching Bedrock world clock instead of sampling only every 200 ticks.
  scheduler.every("tbs.horror_events", 1, tick);
}

function tick() {
  if (!configBoolean("events.enableRandomEvents", true)) return;
  let players;
  try { players = world.getAllPlayers(); } catch { return; }
  if (players.length === 0) return;

  const player = players[Math.floor(Math.random() * players.length)];
  if (!eventsEnabledForPlayer(player)) return;

  const frequency = aggregateEventFrequency(worldAbsoluteTime());
  if (!(frequency > 0) || Math.random() >= frequency) return;

  const result = pickEvent(EVENT_DEFINITIONS, {
    rolls: Array.from({ length: EVENT_DEFINITIONS.length + 1 }, () => Math.random()),
    counts: readEventCounts(),
    disabledEventIds: readDisabledEventIds(),
    rerollEvents: configBoolean("events.rerollEvents", true),
    canExecute: (event) => playerCanExecute(player) && eligible(event.gate),
  });
  if (!result.event) return;

  writeEventCounts(result.counts);
  if (configBoolean("events.eventDebug", false)) {
    actionBar(player, "§8event: " + result.event.id);
  }
  const fn = H[result.event.id];
  if (!fn) return;
  try { fn(player); } catch (err) {
    logger.warn("event '" + result.event.id + "' failed: " + (err?.message ?? err));
  }
}

function bossArenaActive() {
  try {
    // avoid horror spam during integrity fight
    return world.getDynamicProperty?.("tbs:arenaActive") === true;
  } catch { return false; }
}

function eligible(gate) {
  if (gate === null) return true;
  if (gate === "null") return worldState.get("isNullHere") || worldState.get("hasNullSpawned");
  if (gate === "nullHere") return worldState.get("isNullHere");
  if (gate === "moon") return worldState.get("hasMoonCorrupted");
  return true;
}

// expose manual fire for other systems (Chunk 13 commands)
export function fire(id) {
  const fn = H[id];
  if (!fn) return false;
  for (const p of world.getAllPlayers()) {
    try { fn(p); } catch {}
  }
  return true;
}

export const EVENT_COUNT = TABLE.length;
