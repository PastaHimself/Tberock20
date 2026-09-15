// Source-backed rules shared by the Bedrock horror event and chat runtimes.
//
// This file deliberately has no Script API imports.  Keeping the registry data
// and the selection/normalization functions pure makes the parity rules
// testable without a running Bedrock world.

export const EVENT_FREQUENCY = 2.9166666e-4;

export const SOURCE_EVENT_IDS = Object.freeze([
  "bsod", "can_someone_hear_me", "close_menu", "damage", "doors", "explode_base", "eyes",
  "false_villager", "giift", "give_disc_11", "heartbeat", "hungry", "jframe_1", "jframe_2",
  "jframe_3", "jframe_4", "jframe_5", "lava_cast", "look_and_damage", "madness_1",
  "moon_glitch", "moon_phase", "noop", "null_book", "nulled_gui", "null_interface_trigger",
  "null_invade_base", "nullnullnull_advancement", "null_particle", "null_scare", "null_title",
  "obfuscated_sign", "opengl_error", "paranoia", "place_all_dead", "place_bedrock", "place_cave_air",
  "place_empty", "place_flowing_water", "place_hello", "place_lava", "place_netherrack",
  "place_oak_sign", "place_redstone_torch", "place_water", "play_sound", "push", "random_song",
  "reset_rotation", "set_do_daylight_cycle", "set_on_fire", "set_random_time_of_day", "set_time",
  "shadow_bug", "strike_lightning", "text", "why_cant_you_leave", "wrong_overlay", "hallucination",
  "title_event", "experience", "aberration", "breathe", "keep_playing", "null_whisper", "behind_you",
  "run", "cave", "null_is_near", "stare_at_player", "psst_event", "gamma", "null_getting_achievement",
  "rejoin", "sky_blue", "txt", "inventory_corruption", "door", "tbe_curious", "entity_discard", "stick",
  "coord", "screen_dupe", "isolation", "fake_disconnect", "collinlock",
]);

const NULL_EVENT_IDS = new Set([
  "false_villager", "giift", "lava_cast", "moon_glitch", "moon_phase", "null_book",
  "nulled_gui", "null_interface_trigger", "null_invade_base", "null_particle", "null_scare",
  "null_title", "opengl_error", "place_water", "tbe_curious", "null_is_near", "null_whisper",
  "txt", "inventory_corruption", "coord", "fake_disconnect",
]);

const ONLY_NULL_EVENT_IDS = new Set(["null_getting_achievement"]);
const CAN_HAPPEN_TO_NULL_EVENT_IDS = new Set(["nullnullnull_advancement"]);
const FUNNY_EVENT_IDS = new Set(["collinlock"]);
const RANDOM_EVENT_IDS = new Set(["door", "gamma", "run", "stick", "rejoin", "sky_blue", "isolation"]);
const BAD_REPUTATION_EVENT_IDS = new Set([
  "explode_base", "lava_cast", "place_empty", "place_flowing_water", "place_lava", "place_water",
]);

function eventDefinition(id) {
  const sourceBase = ONLY_NULL_EVENT_IDS.has(id)
    ? "OnlyNullEvent"
    : CAN_HAPPEN_TO_NULL_EVENT_IDS.has(id)
      ? "CanHappenToNullEvent"
      : FUNNY_EVENT_IDS.has(id)
        ? "FunnyEvent"
        : NULL_EVENT_IDS.has(id)
          ? "NullEvent"
          : RANDOM_EVENT_IDS.has(id)
            ? "RandomEvent"
            : "TBSEvent";

  return {
    id,
    weight: id === "moon_phase" ? 5 : id === "isolation" ? 0 : 1,
    sourceBase,
    target: sourceBase === "NullEvent"
      ? "survival-player-while-null-is-here"
      : sourceBase === "OnlyNullEvent"
        ? "null-profile-while-null-is-here"
        : sourceBase === "CanHappenToNullEvent"
          ? "any-player-while-null-is-here"
          : sourceBase === "FunnyEvent"
            ? "survival-player-with-funny-setting"
            : sourceBase === "TBSEvent"
              ? "survival-player"
              : "any-player",
    ...(
      BAD_REPUTATION_EVENT_IDS.has(id)
        ? { reputation: "BAD" }
        : id === "giift"
          ? { reputation: "GOOD" }
          : id === "madness_1"
            ? { reputation: ["BAD", "NORMAL"] }
            : {}
    ),
    ...(id === "moon_phase" ? { requiresDay: true, requiresMoonChange: true, moonPhase: 0 } : {}),
    ...(id === "moon_glitch" ? { moonGlitchAvailable: true } : {}),
    ...(id === "tbe_curious" ? { moonStageNot: 2, requiresNoCuriousEntity: true, randomBooleanGate: true } : {}),
    ...(id === "null_invade_base" ? { dimension: "overworld" } : {}),
    ...(id === "sky_blue" ? { requiresNight: true } : {}),
    ...(id === "isolation" ? { minimumPlayers: 2 } : {}),
    ...(id === "coord" ? { requiresCoordsHidden: true, cleanupAfter: 1200 } : {}),
    ...(id === "inventory_corruption" ? { requiresInventoryCorruptionUnprogressed: true } : {}),
    ...(id === "entity_discard" ? { requiresDespawnSwitchOff: true } : {}),
    ...(id === "set_do_daylight_cycle" ? { requiresDaylightTimerReady: true } : {}),
  };
}

export const SOURCE_EVENT_DEFINITIONS = Object.freeze(SOURCE_EVENT_IDS.map((id) => Object.freeze(eventDefinition(id))));

const HELLO_TRIGGERS = [
  "Hello", "Hi?", "Hey", "Hallo", "Hullo", "Heya", "Heyo", "Welcome", "What's up",
  "How's it goin?", "How's it going?", "Wassup", "Yo", "Yo wassup", "Hey there", "Hiya",
  "Heyyo", "Sup", "Ello", "Yo waddup", "Hai", "Hewwo :3", "Hewwo", "Yello", "Morning",
  "Good morning", "Afternoon", "Good afternoon", "Evening", "Good evening", "wsg", "hihi",
  "Hey man", "Hey bro", "yo", "hilo", "greetings",
];
const NULL_HELLO_TRIGGERS = ["Hello", "Hi?", "Hello null", "Hi null", "Hey null", "Hey", ...HELLO_TRIGGERS.filter((item) => item !== "Hello" && item !== "Hi?" && item !== "Hey")];
const INSULT_TRIGGERS = ["Fuck you", "Asshole", "Ass hole", "Fucker", "Piece of shit", "Asshat", "Fuck ass", "Bitch", "Bitch ass", "Ass hat"];
const CAL_TRIGGERS = ["Not_It_Cal", "not it cal", "not_it_cal"];

function chat(id, triggers, options = {}) {
  return Object.freeze({
    id,
    triggers: Object.freeze([...triggers]),
    delay: 100,
    caseSensitive: false,
    fullMessage: true,
    ignorePunctuation: true,
    gate: "none",
    delivery: "broadcast",
    message: "",
    ...options,
  });
}

export const CHAT_RESPONSE_DEFINITIONS = Object.freeze([
  chat("can_you_see_me", ["Can you see me?"], { gate: "null", effects: ["delayed-hello"] }),
  chat("circuit", ["Circuit"], { gate: "null", message: "It was all his fault." }),
  chat("clan_build", ["clan_build", "clan build"], { gate: "null", message: "Home." }),
  chat("entity_303", ["Entity303", "Entity 303"], { gate: "null", message: "Ended his own life." }),
  chat("follow", ["Follow"], { gate: "null", message: "Is behind you." }),
  chat("friend", ["Friend?"], { gate: "null", effects: ["bad-reputation-scare"], message: "?" }),
  chat("fuck_you", INSULT_TRIGGERS, { gate: "null-not-limbo", effects: ["bad-reputation-chase"] }),
  chat("hello", NULL_HELLO_TRIGGERS, { gate: "null-not-limbo-not-watching", message: "err.type=null.hello", effects: ["cave-sound"] }),
  chat("herobrine", ["Herobrine"], { gate: "null", message: "" }),
  chat("how_can_i_help_you", ["How can I help you?"], { gate: "null", message: "[?][?][?]" }),
  chat("integrity", ["Integrity"], { gate: "null", message: "Deep down under the bedrock." }),
  chat("niw", ["NothingIsWatching", "Nothing is Watching"], { gate: "null", message: "A broken promise." }),
  chat("null", ["null"], { gate: "null", caseSensitive: true, message: "The end is nigh", effects: ["delayed-null-lines"] }),
  chat("ram2die", ["xXram2dieXx"], { gate: "null", message: "Rot in hell." }),
  chat("revuxor", ["Revuxor"], { gate: "null", message: "Poor soul." }),
  chat("steve", ["Steve"], { gate: "null", message: "[0.1]" }),
  chat("the_broken_end", ["TheBrokenEnd", "The Broken End"], { message: "Administration.", speaker: "Circuit" }),
  chat("void", ["Void"], { message: "It's me.", delivery: "broadcast" }),
  chat("what_do_you_want", ["What do you want?"], { gate: "null-not-limbo", message: "err.type=null.freedom" }),
  chat("who_are_you", ["Who are you?"], { gate: "null-not-limbo", fullMessage: false, message: "err.type=null." }),
  chat("i_am_scared", ["I am scared", "I'm scared"], { message: "" }),
  chat("blackout", ["__Blackout__", "Blackout"], { gate: "null", message: "Asshole." }),
  chat("cal", CAL_TRIGGERS, { gate: "null-not-aftermath", message: "Innocent." }),
  chat("catfish", ["catfish12", "catfish 12"], { gate: "null", message: "Should've left it alone." }),
  chat("overlord", ["OVERLORD"], { gate: "null", message: "He was wrong." }),
  chat("whyer", ["Whyer4"], { gate: "null", message: "..." }),
  chat("dyexd", ["DyeXD", "DyeXD412", "Dye XD 412"], { gate: "null", message: "Obsessed with answers." }),
  chat("null_structure_positive", ["Oo", "Ooo", "Oooo", "Cool", "Sick", "Nice"], { fullMessage: false, delay: 0, effects: ["positive-reputation"] }),
  chat("null_structure_negative", ["Ew", "Bad", "Gross", "Break", "Never Build again", "Get rid of this", "Ugly"], { fullMessage: false, delay: 0, effects: ["negative-reputation"] }),
  chat("sorry", ["Sorry", "My Bad", "mb", "I Apologize", "Apologies"], { fullMessage: false, delay: 0, message: "" }),
  chat("lucid", ["Lucy B. Locks"], { caseSensitive: true, effects: ["teleport-lucid"] }),
  chat("clanbase_curved", [...CAL_TRIGGERS, "Disc 13", "disc 13", "disc13"], { gate: "null-aftermath", effects: ["spawn-curved"] }),
  chat("hello_structure", HELLO_TRIGGERS, { gate: "null-watching", effects: ["structure-chat-storm"] }),
  chat("fever_hello", HELLO_TRIGGERS, { gate: "limbo", delivery: "sender", message: "<Fever> Greetings." }),
  chat("fever_where", ["Where am I?"], { gate: "limbo", delivery: "sender", message: "<Fever> Isn't it much more intriguing to think about where you aren't?" }),
  chat("fever_what", ["What is this place?"], { gate: "limbo", delivery: "sender", message: "<Fever> This? This is a safe haven. You don't need to be afraid here." }),
  chat("fever_who", ["Who are you?", "What are you?"], { gate: "limbo", delivery: "sender", message: "<Fever> Don't fret, I am your Savior." }),
  chat("fever_insult", INSULT_TRIGGERS, { gate: "limbo", delivery: "sender", message: "<Fever> That is no way to speak to your Savior. Do you wish for §4Judgement§r?" }),
  chat("fever_want", ["What do you want?"], { gate: "limbo", delivery: "sender", message: "<Fever> I want to see you, from the inside out." }),
  chat("fever_sky", ["The sky looks weird"], { gate: "limbo", delivery: "sender", message: "<Fever> Isn't it beautiful?" }),
  chat("fever_homes", ["What are those houses?", "What are those structures?", "What are those homes?", "What are those buildings?"], { gate: "limbo", delivery: "sender", message: "<Fever> Such flora, in the forest." }),
  chat("freebird", [
    "This isn't a freebird situation, now is it?",
    "This isn't a free bird situation, now is it?",
    "This isn't a freebird situation, is it?",
    "This isn't a free bird situation, is it?",
  ], { fullMessage: false, delay: 0, effects: ["freebird-explosion"] }),
]);

export function cleanChatMessage(value) {
  return String(value ?? "")
    .replace(/[^A-Za-z0-9]/g, " ")
    .replace(/\s+/g, " ")
    .trim();
}

function normalized(value, definition) {
  const valueToNormalize = definition.ignorePunctuation ? cleanChatMessage(value) : String(value ?? "");
  return definition.caseSensitive ? valueToNormalize : valueToNormalize.toLowerCase();
}

export function matchesChatResponse(definition, message) {
  if (!definition) return false;
  const candidate = normalized(message, definition);
  return definition.triggers.some((trigger) => {
    const expected = normalized(trigger, definition);
    return definition.fullMessage ? candidate === expected : candidate.includes(expected);
  });
}

export function findChatResponse(message) {
  return CHAT_RESPONSE_DEFINITIONS.find((definition) => matchesChatResponse(definition, message));
}

export function isChatResponseEligible(definition, context = {}) {
  if (!definition) return false;
  switch (definition.gate) {
    case "null":
      return context.isNullHere === true;
    case "null-not-limbo":
      return context.isNullHere === true && context.dimensionId !== "thebrokenscript:limbo" && context.dimensionId !== "limbo";
    case "null-not-limbo-not-watching":
      return context.isNullHere === true && context.dimensionId !== "thebrokenscript:limbo" && context.dimensionId !== "limbo" && context.nearbyWatching !== true;
    case "null-not-aftermath":
      return context.isNullHere === true && context.nearbyAftermath !== true;
    case "null-watching":
      return context.isNullHere === true && context.nearbyWatching === true;
    case "null-aftermath":
      return context.isNullHere === true && context.nearbyAftermath === true;
    case "limbo":
      return context.dimensionId === "thebrokenscript:limbo" || context.dimensionId === "limbo";
    case "none":
    default:
      return true;
  }
}

export function isEventEligible(definition, context = {}) {
  if (!definition || context.enabled === false) return false;

  const isSurvival = context.survival !== false;
  const isNullProfile = context.isFakeNull === true;
  switch (definition.sourceBase) {
    case "TBSEvent":
      if (!isSurvival || isNullProfile) return false;
      break;
    case "NullEvent":
      if (!context.isNullHere || !isSurvival || isNullProfile) return false;
      break;
    case "OnlyNullEvent":
      if (!context.isNullHere || !isNullProfile) return false;
      break;
    case "CanHappenToNullEvent":
      if (!context.isNullHere) return false;
      break;
    case "FunnyEvent":
      if (!isSurvival || isNullProfile || context.funnyEnabled !== true) return false;
      break;
    case "RandomEvent":
      break;
    default:
      return false;
  }

  if (definition.reputation !== undefined) {
    const allowed = Array.isArray(definition.reputation) ? definition.reputation : [definition.reputation];
    if (!allowed.includes(context.reputation)) return false;
  }
  if (definition.dimension && context.dimensionId !== definition.dimension && context.dimensionId !== `minecraft:${definition.dimension}`) return false;
  if (definition.requiresDay && context.isDay !== true) return false;
  if (definition.requiresNight && context.isNight !== true) return false;
  if (definition.requiresMoonChange && context.moonShouldChange !== true) return false;
  if (definition.moonPhase !== undefined && context.moonPhase !== definition.moonPhase) return false;
  if (definition.moonGlitchAvailable && !(Number(context.moonGlitchDuration) < 1)) return false;
  if (definition.moonStageNot !== undefined && context.moonStage === definition.moonStageNot) return false;
  if (definition.requiresNoCuriousEntity && context.hasCuriousEntity === true) return false;
  if (definition.randomBooleanGate && context.randomBoolean !== true) return false;
  if (definition.minimumPlayers !== undefined && Number(context.playerCount) < definition.minimumPlayers) return false;
  if (definition.requiresCoordsHidden && context.showCoords === true) return false;
  if (definition.requiresInventoryCorruptionUnprogressed && context.inventoryCorruptionProgressed === true) return false;
  if (definition.requiresDespawnSwitchOff && context.despawnEntitySwitch === true) return false;
  if (definition.requiresDaylightTimerReady && (context.daylightCycle !== true || Number(context.daylightCycleEventTimer) > 0)) return false;
  return true;
}

export function selectWeightedEvent(events, counts = {}, roll = Math.random()) {
  const candidates = (events ?? []).filter((event) => event && Number(event.weight) >= 0);
  if (candidates.length === 0) return undefined;

  const weights = candidates.map((event) => Number(event.weight) / Math.max(1, Number(counts[event.id] ?? 1)));
  const total = weights.reduce((sum, weight) => sum + (Number.isFinite(weight) ? weight : 0), 0);
  if (total <= 0) return candidates[Math.min(candidates.length - 1, Math.floor(Math.max(0, Math.min(0.999999999, roll)) * candidates.length))];

  let remaining = Math.max(0, Math.min(0.999999999, Number(roll))) * total;
  for (let index = 0; index < candidates.length; index += 1) {
    remaining -= weights[index];
    if (remaining <= 0) return candidates[index];
  }
  return candidates[candidates.length - 1];
}
