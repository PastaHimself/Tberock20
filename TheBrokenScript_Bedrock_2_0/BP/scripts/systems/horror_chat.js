import { system, world } from "@minecraft/server";
import * as dimensions from "./dimensions.js";
import * as playerState from "./player_state.js";
import * as worldState from "./world_state.js";
import { logger } from "../core/logging.js";
import {
  CHAT_RESPONSE_DEFINITIONS,
  findChatResponse,
  isChatResponseEligible,
} from "./horror_rules.js";

// The Java subscriber selects the first matching registry entry, schedules its
// response, then evaluates the world gate at execution time.  The original
// chat is not canceled.  This module keeps those exact ordering and delay
// semantics, while tracking delayed work by player id for Bedrock lifecycle
// cleanup.

const SESSION_PROPERTY = "horror_chat_session";
const pendingByPlayer = new Map();
const lastResponseTick = new Map();
const REPUTATION_TIER_BY_DELTA = new Map([
    [-1, "LOSS_TEENYTINY"], [-5, "LOSS_BABY"], [-10, "LOSS_MINOR"], [-15, "LOSS_SMALL"],
    [-20, "LOSS_RARE"], [-25, "LOSS_MEDIUM"], [-30, "LOSS_WELLDONE"], [-35, "LOSS_HUGE"], [-50, "LOSS_IHY"],
    [1, "GAIN_TEENYTINY"], [5, "GAIN_BABY"], [10, "GAIN_MINOR"], [15, "GAIN_SMALL"],
    [20, "GAIN_RARE"], [25, "GAIN_MEDIUM"], [30, "GAIN_WELLDONE"], [35, "GAIN_HUGE"], [50, "GAIN_ILY"],
]);
const LOST_REPUTATION_HALF_BY_TIER = new Map([
    ["LOSS_TEENYTINY", 0.5], ["LOSS_BABY", 2.5], ["LOSS_MINOR", 5], ["LOSS_SMALL", 7.5],
    ["LOSS_RARE", 10], ["LOSS_MEDIUM", 12.5], ["LOSS_WELLDONE", 15], ["LOSS_HUGE", 17.5], ["LOSS_IHY", 25],
]);
let sessionToken = 0;

function playerId(playerOrId) {
  return typeof playerOrId === "string" ? playerOrId : playerOrId?.id;
}

function reportAdapterFailure(operation, err) {
  logger.warnOnce(
    `horror-chat:adapter:${operation}`,
    `horror chat adapter '${operation}' failed; the side effect was skipped`,
    err,
  );
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

function nearbyNullStructure(player, radius) {
  const dimension = player.dimension;
  if (!dimension?.getBlock) return false;
  const center = player.location;
  const scanRadius = Math.max(0, Math.min(Number(radius) || 0, 15));
  const base = { x: Math.floor(center.x), y: Math.floor(center.y), z: Math.floor(center.z) };
  for (let x = -scanRadius; x <= scanRadius; x += 1) {
    for (let y = -scanRadius; y <= scanRadius; y += 1) {
      for (let z = -scanRadius; z <= scanRadius; z += 1) {
        if (x * x + y * y + z * z > scanRadius * scanRadius) continue;
        try {
          if (dimension.getBlock({ x: base.x + x, y: base.y + y, z: base.z + z })?.typeId === "thebrokenscript:null_structure") return true;
        } catch {
          return false;
        }
      }
    }
  }
  return false;
}

function nearbyWatching(player) {
  try {
    if (player.dimension.getEntities({ type: "thebrokenscript:null_watching", location: player.location, maxDistance: 20 }).length > 0) return true;
  } catch {}
  return nearbyNullStructure(player, 0);
}

function chatContext(player) {
  const dimensionId = player.dimension?.id ?? "minecraft:overworld";
  return {
    isNullHere: worldState.get("isNullHere") === true,
    dimensionId,
    nearbyWatching: nearbyWatching(player),
    // Bedrock has no Java NullStructureBlockEntity yet; the custom marker
    // block is still recognized for the radius-15 positive/negative effects.
    nearbyStructure: nearbyNullStructure(player, 15),
    nearbyAftermath: false,
  };
}

function sendToPlayer(player, message) {
  if (!message) return;
  try { player.sendMessage(message); } catch (err) { reportAdapterFailure("sender-message", err); }
}

function broadcast(message) {
  if (!message) return;
  for (const player of world.getAllPlayers()) {
    try { player.sendMessage(message); } catch (err) { reportAdapterFailure("broadcast-message", err); }
  }
}

function nullMessage(definition) {
  if (!definition.message) return "";
  if (definition.id === "void") return definition.message;
  if (definition.speaker) return `<${definition.speaker}> ${definition.message}`;
  return `<null> ${definition.message}`;
}

export function changeReputation(player, amount) {
  try {
    const delta = Number(amount);
    const next = Math.max(0, Math.min(100, Number(playerState.get(player, "entityReputation")) + delta));
    playerState.set(player, "entityReputation", next);
    const tier = REPUTATION_TIER_BY_DELTA.get(delta);
    if (tier) playerState.set(player, "lastRepInteraction", tier);
  } catch (err) { reportAdapterFailure("reputation", err); }
}

function gainBackHalfLostReputation(player) {
  try {
    const lastTier = String(playerState.get(player, "lastRepInteraction") ?? "");
    const amount = LOST_REPUTATION_HALF_BY_TIER.get(lastTier);
    if (amount === undefined) return;
    const next = Math.max(0, Math.min(100, Number(playerState.get(player, "entityReputation")) + amount));
    playerState.set(player, "entityReputation", next);
    playerState.set(player, "lastRepInteraction", "REGAIN_HALF");
  } catch (err) { reportAdapterFailure("sorry-reputation", err); }
}

function reputation(player) {
  try { return Number(playerState.get(player, "entityReputation")); } catch { return 50; }
}

function cooldownGain(definition, player, amount) {
  if (reputation(player) >= 25) return;
  const now = Number(system.currentTick ?? 0);
  const previous = lastResponseTick.get(definition.id) ?? 0;
  if (previous === 0 || now - previous < 160) changeReputation(player, amount);
  lastResponseTick.set(definition.id, now);
}

function spawnEntity(player, typeId, location = player.location) {
  try { player.dimension.spawnEntity(typeId, location); } catch (err) { reportAdapterFailure(`spawn:${typeId}`, err); }
}

function executeResponse(definition, sender) {
  const context = chatContext(sender);
  if (!isChatResponseEligible(definition, context)) return;

  switch (definition.id) {
    case "can_you_see_me":
      try { sender.playSound("ambient.cave", { volume: 10 }); } catch (err) { reportAdapterFailure("can-you-see-me-sound", err); }
      broadcast("<null> Yes.");
      scheduleForPlayer(sender, 60, () => broadcast("<null> Hello."));
      return;
    case "hello":
      try { sender.playSound("ambient.cave", { volume: 10 }); } catch (err) { reportAdapterFailure("hello-sound", err); }
      broadcast(nullMessage(definition));
      cooldownGain(definition, sender, 15);
      return;
    case "friend":
      if (reputation(sender) < 25) {
        try { sender.playSound("thebrokenscript:kills_player", { volume: 10 }); } catch (err) { reportAdapterFailure("friend-scare-sound", err); }
        spawnEntity(sender, "thebrokenscript:null_scare");
      } else {
        broadcast("<null> ?");
      }
      return;
    case "fuck_you":
      changeReputation(sender, -25);
      spawnEntity(sender, "thebrokenscript:nothingiswatchingchase");
      return;
    case "null":
      broadcast("<null> The end is nigh");
      scheduleForPlayer(sender, 20, () => broadcast("<null> The end is null"));
      scheduleForPlayer(sender, 30, (player) => spawnEntity(player, "thebrokenscript:null_chase"));
      changeReputation(sender, -25);
      return;
    case "null_structure_positive":
      if (context.nearbyStructure) changeReputation(sender, 10);
      return;
    case "null_structure_negative":
      if (context.nearbyStructure) changeReputation(sender, -10);
      return;
    case "sorry":
      gainBackHalfLostReputation(sender);
      return;
    case "freebird":
      try { sender.dimension.createExplosion(sender.location, 10, { breaksBlocks: true }); } catch (err) { reportAdapterFailure("freebird-explosion", err); }
      return;
    case "lucid":
      try { playerState.set(sender, "ticksUntilExit", 4200); playerState.set(sender, "fixPos", true); } catch (err) { reportAdapterFailure("lucid-state", err); }
      void dimensions.teleportWhenReady(sender, "lucid");
      return;
    case "the_broken_end":
      broadcast(nullMessage(definition));
      return;
    case "void":
      broadcast(definition.message);
      return;
    case "i_am_scared":
      broadcast(`<${sender.name}> ...`);
      return;
    case "hello_structure":
      for (let index = 0; index < 5; index += 1) {
        for (let message = 0; message < 45; message += 1) {
          scheduleForPlayer(sender, index * 45 + message, () => broadcast("§k..."));
        }
      }
      return;
    case "clanbase_curved":
      spawnEntity(sender, "thebrokenscript:curved", sender.location);
      return;
    default:
      if (definition.delivery === "sender") sendToPlayer(sender, definition.message);
      else if (definition.message) broadcast(nullMessage(definition));
  }

  if (["circuit", "clan_build", "entity_303", "follow", "integrity", "overlord", "revuxor", "dyexd", "blackout", "catfish", "what_do_you_want", "who_are_you", "whyer", "cal"].includes(definition.id)) {
    cooldownGain(definition, sender, definition.id === "what_do_you_want" ? 25 : 15);
  }
}

function onChat(event) {
  const definition = findChatResponse(event.message);
  if (!definition) return;
  // ChatSendBeforeEvent is read-only for message/sender. We intentionally do
  // not set event.cancel: Java leaves the original chat visible.
  scheduleForPlayer(event.sender, definition.delay, (sender) => executeResponse(definition, sender));
}

export function begin() {
  beginSession();
  try {
    world.beforeEvents.chatSend.subscribe(onChat);
  } catch (error) {
    logger.error("horror_chat: failed to subscribe to chatSend", error);
  }
}

export { CHAT_RESPONSE_DEFINITIONS };
