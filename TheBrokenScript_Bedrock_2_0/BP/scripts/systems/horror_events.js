import { world, system, ItemStack } from "@minecraft/server";
import * as worldState from "./world_state.js";
import * as dimensions from "./dimensions.js";
import * as progression from "./progression.js";
import { logger } from "../core/logging.js";

// ── Chunk 12: Events & horror choreography ──────────────────────────────────
// 95 event classes in source (81 TBSEvents + 14 others). OS-level events
// (jframe/window titles, BSOD, fake crash) approximate to titles per A-004.
// Events fire from a weighted ambient pool every 200 ticks, gated on story
// flags (isNullHere / hasMoonCorrupted / hasNullSpawned).

const SOUNDS = {
  heartbeat: "thebrokenscript:heartbeat",
  whisper: "thebrokenscript:null_whisper_loop",
  psst: "thebrokenscript:null_whisper_loop",
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
  nulled_gui(p) { title(p, "§k███ §rGUI nulled §k███", 40); },
  screen_dupe(p) { actionBar(p, "§7[screen duplicated]"); },
  fake_disconnect(p) { title(p, "§cDisconnected", 50, "§7End of stream"); },
  close_menu(p) { title(p, " ", 5); },
  keep_playing(p) { title(p, "§fkeep playing.", 40); },
  why_cant_you_leave(p) { title(p, "§fwhy can't you leave?", 50); },
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
  sky_blue(p) { try { p.dimension.runCommandAsync("weather clear 100"); } catch {} },
  gamma(p) { try { p.runCommandAsync("effect @s night_vision 100 255 true"); } catch {} },

  // null-flavored
  null_title(p) { title(p, "§knull§r", 30); },
  null_particle(p) {
    try { p.dimension.spawnParticle("minecraft:basic_smoke_particle", { x: p.location.x, y: p.location.y + 2, z: p.location.z }); } catch {}
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
  set_on_fire(p) { try { p.runCommandAsync("execute as @s run particle minecraft:flame_particle ^ ^1 ^"); } catch {} try { p.setOnFire(3, true); } catch {} },
  push(p) {
    const v = p.getVelocity();
    try { p.applyKnockback(v.x, v.z, 2, 0.4); } catch {}
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
  eyes(p) { title(p, "§4◉ ‸ ◉", 20); },

  // time/sky
  set_time(p) { try { p.dimension.runCommandAsync("time set midnight"); } catch {} },
  set_random_time_of_day(p) {
    const times = ["day", "noon", "midnight", "night"];
    try { p.dimension.runCommandAsync(`time set ${times[Math.floor(Math.random() * times.length)]}`); } catch {}
  },
  set_do_daylight_cycle(p) {
    const v = Math.random() < 0.5 ? "true" : "false";
    try { p.dimension.runCommandAsync(`gamerule dodaylightcycle ${v}`); } catch {}
  },
  moon_phase(p) { worldState.update("moonShouldChange", () => true); },
  moon_glitch(p) { setFakeMoonTexture(); title(p, "§kthe moon flickers", 30); },
  reset_rotation(p) {
    try { p.teleport(p.location, { rotation: { x: 0, y: 0 } }); } catch {}
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

export function begin(scheduler) {
  scheduler.every("tbs.horror_events", 200, tick);
}

function tick() {
  const players = world.getAllPlayers();
  if (players.length === 0) return;
  if (bossArenaActive()) return;

  const fired = new Set();
  let attempts = 2;
  while (attempts-- > 0) {
    const [id, gate] = TABLE[Math.floor(Math.random() * TABLE.length)];
    if (fired.has(id)) continue;
    fired.add(id);
    if (!eligible(gate)) continue;
    const fn = H[id];
    if (!fn) continue;
    for (const p of players) {
      try { fn(p); } catch (err) { /* per-player guard */ }
    }
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
