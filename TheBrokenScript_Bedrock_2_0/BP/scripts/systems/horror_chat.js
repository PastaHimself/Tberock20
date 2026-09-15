import { system, world } from "@minecraft/server";
import * as events from "../core/events.js";
import { logger } from "../core/logging.js";
import * as dimensions from "./dimensions.js";
import * as playerState from "./player_state.js";
import * as worldState from "./world_state.js";
import {
  CHAT_RESPONSES,
  CHAT_RESPONSE_IDS,
  matchesChatResponse,
} from "../shared/horror_chat_model.js";
import {
  createLifecycleState,
  invalidateAll,
  invalidatePlayer,
  isLifecycleTokenValid,
  issueLifecycleToken,
} from "../shared/horror_lifecycle_model.js";

const RESPONSE_SOUND = "ambient.cave";
const RESPONSE_KILLS_SOUND = "thebrokenscript:kills_player";
const LIMBO_DIMENSION_ID = "thebrokenscript:limbo";
const WATCHING_MARKER = "null_watching";
const AFTERMATH_MARKER = "aftermath";
const FATE_MARKER = "fate";

const UNKNOWN_RESPONSE_MESSAGES = Object.freeze([
  "LET ME GO", "PLEASE DON'T LEAVE", "IT HURTS SO MUCH", "WHY WON'T IT STOP",
  "HELP ME", "I WANT TO GO HOME", "I CAN'T LEAVE", "WHY AREN'T YOU HELPING",
  "IT WON'T STOP HURTING", "PLEASE HELP", "I WANT MY MOM", "I CAN'T TAKE THIS",
  "LET US DIE", "PLEASE HELP ME", "NO MORE NO MORE NO MORE",
  "WHY AREN'T YOU LISTENING", "GET US OUT", "THEIR SCREAMS ARE SO LOUD",
  "WE WILL BE TOGETHER FOREVER", "PLEASE MAKE IT STOP", "I CAN'T TELL IF I'M ME",
  "DON'T LISTEN TO THEM", "YOU", "WHERE IS MY FAMILY",
  "HAHAHHAHAHAHAHHAHA", "I FELT MYSELF DIE", "YOU AREN'T LEAVING US",
  "JOIN US", "PLEASE HELP THEM", "TAKE US WITH YOU", "DON'T LEAVE",
  "HELP HELP HELP HELP", "THEY LIED", "LOOK AT ME", "THERE IS NO HOPE",
  "SEND HELP", "YOU'RE MAKING A MISTAKE", "HEAR US",
  "WE CAN ALL BE HAPPY TOGETHER", "STOP, PLEASE JUST STOP",
  "I CAN'T TAKE IT ANYMORE", "YOU NEED TO LEAVE", "I FEEL SO ALONE",
  "THIS IS HELL", "LEAVE WHILE YOU STILL CAN",
]);

const SCARED_MESSAGES = Object.freeze([
  "So was I", "Me too", "I couldn't do anything",
  "It's been an eternity in there", "Set them free", "Help us",
  "It looked like me", "There was nowhere to run", "There was no way out",
  "Locked forever", "It took all of us", "It took our lives and minds",
  "I'm losing parts of myself",
]);

const lifecycle = createLifecycleState();
const responseTimestamps = new Map();
let started = false;

function failure(operation, error) {
  logger.warnOnce(
    "horror-chat:" + operation,
    "horror chat operation '" + operation + "' failed; the response was skipped",
    error,
  );
}

function playerKey(player) {
  return String(player?.id ?? player?.name ?? "");
}

function clearResponseTimestamps(playerId) {
  const prefix = String(playerId ?? "") + ":";
  for (const key of responseTimestamps.keys()) {
    if (key.startsWith(prefix)) responseTimestamps.delete(key);
  }
}

function usable(player) {
  if (!player) return false;
  try {
    return player.isValid !== false && Boolean(player.dimension && player.location);
  } catch {
    return false;
  }
}

function isNullHere() {
  try { return worldState.get("isNullHere") === true; }
  catch { return false; }
}

function isLimbo(player) {
  try { return player.dimension?.id === LIMBO_DIMENSION_ID; }
  catch { return false; }
}

function hasNearbyMarker(player, marker, distance) {
  try {
    const entities = player.dimension.getEntities({ location: player.location, maxDistance: distance });
    return entities.some((entity) =>
      entity.typeId === marker ||
      entity.typeId === "thebrokenscript:" + marker ||
      entity.nameTag === marker,
    );
  } catch {
    return false;
  }
}

function gateAllows(response, player) {
  const watching = hasNearbyMarker(player, WATCHING_MARKER, 32);
  const aftermath = hasNearbyMarker(player, AFTERMATH_MARKER, 32);
  switch (response.gate) {
    case "null": return isNullHere();
    case "null-not-limbo": return isNullHere() && !isLimbo(player);
    case "null-not-limbo-no-watching": return isNullHere() && !isLimbo(player) && !watching;
    case "null-watching": return isNullHere() && watching;
    case "null-no-aftermath": return isNullHere() && !aftermath;
    case "null-not-aftermath": return isNullHere() && !aftermath;
    case "limbo": return isLimbo(player);
    default: return true;
  }
}

function findEligibleResponse(message, player) {
  return CHAT_RESPONSES.find((response) =>
    matchesChatResponse(message, response) && gateAllows(response, player),
  );
}

function playSound(player, soundId, volume = 10, pitch = 0, operation = "sound") {
  try { player.playSound(soundId, { volume, pitch }); }
  catch (error) { failure(operation, error); }
}

function responseSpeaker(response) {
  if (response.id === "the_broken_end") return "Circuit";
  if (response.id === "how_can_i_help_you" || response.id === "void") return "";
  if (response.id === "i_am_scared") return String(100000 + Math.floor(Math.random() * 100000));
  return "Null";
}

function responseText(response) {
  if (response.id !== "i_am_scared") return response.text;
  return SCARED_MESSAGES[Math.floor(Math.random() * SCARED_MESSAGES.length)] ?? "";
}

function sendWorldMessage(player, text, speaker = "Null") {
  const formatted = speaker ? "§8<" + speaker + "> " + text : "§8" + text;
  try {
    world.sendMessage(formatted);
  } catch (error) {
    failure("world-message", error);
    try { player.sendMessage(formatted); }
    catch (fallbackError) { failure("world-message-fallback", fallbackError); }
  }
}

function sendResponse(player, response) {
  if (response.delivery === "none") return;
  const text = responseText(response);
  if (response.delivery === "sender") {
    try { player.sendMessage("§8" + text); }
    catch (error) { failure("sender-message:" + response.id, error); }
  } else {
    sendWorldMessage(player, text, responseSpeaker(response));
  }
  if (response.id === "hello" || response.id === "what_do_you_want" || response.id === "who_are_you") {
    playSound(player, RESPONSE_SOUND, 10, 0, "response-sound:" + response.id);
  }
  rewardBadResponse(player, response.id);
}

const REWARD_RESPONSE_IDS = new Set([
  "circuit", "clan_build", "entity_303", "follow", "hello", "integrity",
  "niw", "catfish", "overlord", "revuxor", "whyer", "dyexd", "blackout",
  "who_are_you",
]);

function updateReputation(player, delta, tier) {
  try {
    playerState.update(player, "entityReputation", (value) =>
      Math.min(100, Math.max(0, Number(value) + delta)),
    );
    if (tier) playerState.set(player, "lastRepInteraction", tier);
  } catch (error) { failure("reputation", error); }
}

function rewardBadResponse(player, responseId) {
  const reward = REWARD_RESPONSE_IDS.has(responseId)
    ? 15
    : responseId === "what_do_you_want" || responseId === "cal" ? 25
    : 0;
  if (!reward) return;
  try {
    if (Number(playerState.get(player, "entityReputation")) > 25) return;
    const key = playerKey(player) + ":" + responseId;
    const now = Number(system.currentTick) || 0;
    const last = responseTimestamps.get(key);
    if (last === undefined || now - last < 160) {
      responseTimestamps.set(key, now);
      updateReputation(player, reward, reward === 25 ? "GAIN_MEDIUM" : "GAIN_SMALL");
    }
  } catch (error) { failure("response-reputation:" + responseId, error); }
}

function restoreLastLoss(player) {
  try {
    const tier = String(playerState.get(player, "lastRepInteraction") ?? "");
    const values = {
      LOSS_IHY: 50, LOSS_MEDIUM: 25, LOSS_WELLDONE: 30, LOSS_HUGE: 35,
      LOSS_RARE: 20, LOSS_SMALL: 15, LOSS_MINOR: 10, LOSS_BABY: 5,
      LOSS_TEENYTINY: 1,
    };
    const loss = values[tier];
    if (loss) updateReputation(player, Math.floor(loss / 2), "REGAIN_HALF");
  } catch (error) { failure("sorry-reputation", error); }
}

function spawnEntity(player, typeId, location, operation) {
  try { return player.dimension.spawnEntity(typeId, location); }
  catch (error) { failure(operation, error); return undefined; }
}

function randomLocation(player, minDistance, maxDistance) {
  const angle = Math.random() * Math.PI * 2;
  const distance = minDistance + Math.random() * Math.max(0, maxDistance - minDistance);
  return {
    x: player.location.x + Math.cos(angle) * distance,
    y: player.location.y,
    z: player.location.z + Math.sin(angle) * distance,
  };
}

function canSeeSky(player) {
  try {
    const top = player.dimension.getTopmostBlock?.({
      x: Math.floor(player.location.x),
      z: Math.floor(player.location.z),
    });
    const topY = Number(top?.location?.y ?? top?.y);
    return !Number.isFinite(topY) || topY <= Math.floor(player.location.y);
  } catch (error) {
    failure("sky-check", error);
    return false;
  }
}

function defer(player, token, delay, callback, operation) {
  if (typeof system.runTimeout !== "function") {
    failure("run-timeout", new Error("system.runTimeout is unavailable"));
    return false;
  }
  try {
    system.runTimeout(() => {
      if (!usable(player) || !isLifecycleTokenValid(lifecycle, playerKey(player), token)) return;
      try { callback(); }
      catch (error) { failure(operation, error); }
    }, Math.max(1, Math.floor(Number(delay) || 0)));
    return true;
  } catch (error) {
    failure("run-timeout", error);
    return false;
  }
}

function runAction(player, response, token) {
  switch (response.action) {
    case "can_you_see_me":
      playSound(player, RESPONSE_SOUND);
      sendWorldMessage(player, "Yes.");
      defer(player, token, 60, () => {
        playSound(player, RESPONSE_SOUND);
        sendWorldMessage(player, "Hello.");
        defer(player, token, 60, () => {
          if (canSeeSky(player)) spawnEntity(player, "minecraft:lightning_bolt", player.location, "can-you-see-me-lightning");
        }, "can-you-see-me-final");
      }, "can-you-see-me-followup");
      return;
    case "null":
      playSound(player, RESPONSE_SOUND);
      sendWorldMessage(player, "The end is nigh");
      defer(player, token, 20, () => {
        playSound(player, RESPONSE_SOUND);
        sendWorldMessage(player, "The end is null");
        defer(player, token, 10, () => {
          spawnEntity(player, "thebrokenscript:null_chase", player.location, "null-response-chase");
          updateReputation(player, -25, "LOSS_MEDIUM");
        }, "null-response-chase");
      }, "null-response-followup");
      return;
    case "friend":
      if (Number(playerState.get(player, "entityReputation")) <= 25) {
        playSound(player, RESPONSE_KILLS_SOUND, 10, 0, "friend-bad-sound");
        spawnEntity(player, "thebrokenscript:null_scare", player.location, "friend-bad-scare");
      } else {
        sendWorldMessage(player, "?", "Null");
      }
      return;
    case "fuck_you":
      spawnEntity(player, "thebrokenscript:nothing_is_watching_chase", randomLocation(player, 0, 26), "fuck-you-chase");
      updateReputation(player, -25, "LOSS_MEDIUM");
      return;
    case "ram2die":
      sendWorldMessage(player, "Rot in hell.");
      spawnEntity(player, "thebrokenscript:null_is_here", player.location, "ram2die-null");
      updateReputation(player, -50, "LOSS_IHY");
      return;
    case "cal":
      if (hasNearbyMarker(player, FATE_MARKER, 20)) {
        spawnEntity(player, "thebrokenscript:the_broken_end_ambush", randomLocation(player, 50, 100), "cal-ambush");
      } else {
        sendWorldMessage(player, "Innocent.");
        rewardBadResponse(player, "cal");
      }
      return;
    case "null_structure_positive":
      if (hasNearbyMarker(player, "structure", 15) || hasNearbyMarker(player, AFTERMATH_MARKER, 15)) {
        updateReputation(player, 10, "GAIN_MINOR");
      }
      return;
    case "null_structure_negative":
      if (hasNearbyMarker(player, "structure", 15) || hasNearbyMarker(player, AFTERMATH_MARKER, 15)) {
        updateReputation(player, -10, "LOSS_MINOR");
      }
      return;
    case "sorry":
      restoreLastLoss(player);
      return;
    case "hello_structure":
      for (let burst = 0; burst < 5; burst += 1) {
        for (const [index, message] of UNKNOWN_RESPONSE_MESSAGES.entries()) {
          defer(player, token, burst * UNKNOWN_RESPONSE_MESSAGES.length + index, () => {
            sendWorldMessage(player, message, "");
            playSound(player, "mob.ghast.hurt", 0.9, 1 + Math.random() * 2, "hello-structure-sound");
          }, "hello-structure-message");
        }
      }
      return;
    case "clanbase_curved":
      spawnEntity(player, "thebrokenscript:curved", randomLocation(player, 50, 100), "clanbase-curved");
      return;
    case "freebird":
      try { player.dimension.createExplosion(player.location, 10, { breaksBlocks: true }); }
      catch (error) { failure("freebird-explosion", error); }
      return;
    case "lucid":
      try {
        playerState.set(player, "ticksUntilExit", 4200);
        playerState.set(player, "fixPos", true);
        void dimensions.teleportWhenReady(player, "thebrokenscript:lucid", player.location);
      } catch (error) { failure("lucid-teleport", error); }
      return;
    default:
      sendResponse(player, response);
  }
}

function scheduleResponse(player, response, message) {
  const token = issueLifecycleToken(lifecycle, playerKey(player));
  defer(player, token, response.delay, () => {
    if (!gateAllows(response, player)) return;
    runAction(player, response, token);
  }, "response:" + response.id);
  void message;
}

function handleChat(player, message) {
  if (!usable(player)) return;
  const response = findEligibleResponse(message, player);
  if (response) scheduleResponse(player, response, message);
}

function subscribeLifecycle() {
  const afterEvents = world.afterEvents;
  if (!afterEvents) return;
  if (afterEvents.playerLeave) {
    events.subscribeGuarded(afterEvents.playerLeave, "horrorChat.playerLeave", "horror chat", (event) => {
      const id = event.playerId ?? event.playerName;
      invalidatePlayer(lifecycle, id);
      clearResponseTimestamps(id);
    });
  }
  if (afterEvents.playerSpawn) {
    events.subscribeGuarded(afterEvents.playerSpawn, "horrorChat.playerSpawn", "horror chat", (event) => {
      const id = playerKey(event.player);
      invalidatePlayer(lifecycle, id);
      clearResponseTimestamps(id);
    });
  }
  if (afterEvents.playerDimensionChange) {
    events.subscribeGuarded(afterEvents.playerDimensionChange, "horrorChat.playerDimensionChange", "horror chat", (event) => {
      const id = playerKey(event.player);
      invalidatePlayer(lifecycle, id);
      clearResponseTimestamps(id);
    });
  }
  if (afterEvents.entityDie) {
    events.subscribeGuarded(afterEvents.entityDie, "horrorChat.entityDie", "horror chat", (event) => {
      if (event.deadEntity?.typeId !== "minecraft:player") return;
      const id = playerKey(event.deadEntity);
      invalidatePlayer(lifecycle, id);
      clearResponseTimestamps(id);
    });
  }
}

export function begin() {
  if (started) return;
  try {
    events.subscribeGuarded(world.beforeEvents.chatSend, "horrorChat.chatSend", "horror chat", (event) => {
      const sender = event.sender;
      const message = event.message;
      if (typeof system.run !== "function") {
        failure("run", new Error("system.run is unavailable"));
        return;
      }
      system.run(() => handleChat(sender, message));
    });
    subscribeLifecycle();
    started = true;
  } catch (error) {
    started = false;
    logger.error("horror_chat: failed to subscribe to chatSend", error);
  }
}

export function stop() {
  for (const key of [
    "horrorChat.chatSend", "horrorChat.playerLeave", "horrorChat.playerSpawn",
    "horrorChat.playerDimensionChange", "horrorChat.entityDie",
  ]) events.unsubscribe(key);
  invalidateAll(lifecycle);
  responseTimestamps.clear();
  started = false;
}

export const CHAT_RESPONSE_COUNT = CHAT_RESPONSES.length;
export { CHAT_RESPONSES, CHAT_RESPONSE_IDS };
