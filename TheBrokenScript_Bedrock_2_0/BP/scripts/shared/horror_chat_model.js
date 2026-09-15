/**
 * Source-backed chat matching and response contracts.
 *
 * Matching is pure because the Bedrock before-chat signal is read-only. Runtime
 * effects are handled by horror_chat.js after the event has returned.
 */
export function cleanChatMessage(message) {
  return String(message ?? "")
    .replace(/[^A-Za-z0-9]/g, " ")
    .replace(/\s+/g, " ")
    .trim();
}

export function matchesChatResponse(message, response) {
  const candidate = response.ignorePunctuation ? cleanChatMessage(message) : String(message ?? "").trim();
  const triggers = response.ignorePunctuation
    ? response.triggers.map(cleanChatMessage)
    : response.triggers.map((trigger) => String(trigger).trim());
  const left = response.caseSensitive ? candidate : candidate.toLowerCase();
  return triggers.some((trigger) => {
    const right = response.caseSensitive ? trigger : trigger.toLowerCase();
    return response.fullMessage ? left === right : left.includes(right);
  });
}

export function response(id, triggers, options = {}) {
  return Object.freeze({
    id,
    triggers: Object.freeze([...triggers]),
    fullMessage: false,
    caseSensitive: false,
    ignorePunctuation: true,
    delay: 0,
    gate: "always",
    delivery: "world",
    action: id,
    text: "",
    ...options,
  });
}

export const HELLO_ALIASES = Object.freeze([
  "Hello", "Hi?", "Hey", "Hallo", "Hullo", "Heya", "Heyo", "Welcome",
  "What's up", "How's it goin?", "How's it going?", "Wassup", "Yo",
  "Yo wassup", "Hey there", "Hiya", "Heyyo", "Sup", "Ello", "Yo waddup",
  "Hai", "Hewwo :3", "Hewwo", "Yello", "Morning", "Good morning",
  "Afternoon", "Good afternoon", "Evening", "Good evening", "wsg", "hihi",
  "Hey man", "Hey bro", "yo", "hilo", "greetings",
]);

export const HELLO_NULL_ALIASES = Object.freeze([
  "Hello", "Hi?", "Hello null", "Hi null", "Hey null",
  ...HELLO_ALIASES.slice(2),
]);

export const INSULT_ALIASES = Object.freeze([
  "Fuck you", "Asshole", "Ass hole", "Fucker", "Piece of shit",
  "Asshat", "Fuck ass", "Bitch", "Bitch ass", "Ass hat",
]);

const NULL = (id, triggers, text, options = {}) => response(id, triggers, {
  fullMessage: true,
  delay: 100,
  gate: "null",
  text,
  ...options,
});
const ALWAYS = (id, triggers, text, options = {}) => response(id, triggers, {
  fullMessage: true,
  delay: 100,
  text,
  ...options,
});

export const CHAT_RESPONSES = Object.freeze([
  NULL("can_you_see_me", ["Can you see me?"], "Yes.", { delivery: "none", action: "can_you_see_me" }),
  NULL("circuit", ["Circuit"], "All his fault."),
  NULL("clan_build", ["clan_build", "clan build"], "Home."),
  NULL("entity_303", ["Entity303", "Entity 303"], "Ended his own life."),
  NULL("follow", ["Follow"], "Is behind you."),
  NULL("friend", ["Friend?"], "?", { delivery: "none", action: "friend" }),
  NULL("fuck_you", INSULT_ALIASES, "", { delivery: "none", action: "fuck_you" }),
  NULL("hello", HELLO_NULL_ALIASES, "err.type=null.hello", { gate: "null-not-limbo-no-watching" }),
  NULL("herobrine", ["Herobrine"], "he is not real. he never was."),
  NULL("how_can_i_help_you", ["How can I help you?"], "[?][?][?]", { delivery: "world" }),
  NULL("integrity", ["Integrity"], "Deep down under the bedrock."),
  NULL("niw", ["NothingIsWatching", "Nothing is Watching"], "A broken promise."),
  NULL("null", ["null"], "The end is nigh", { caseSensitive: true, delivery: "none", action: "null" }),
  NULL("ram2die", ["xXram2dieXx"], "Rot in hell.", { delivery: "none", action: "ram2die" }),
  NULL("revuxor", ["Revuxor"], "Poor soul."),
  NULL("steve", ["Steve"], "[0.1]"),
  ALWAYS("the_broken_end", ["TheBrokenEnd", "The Broken End"], "Administration."),
  ALWAYS("void", ["Void"], "It's me."),
  NULL("what_do_you_want", ["What do you want?"], "err.type=null.freedom", { gate: "null-not-limbo" }),
  response("who_are_you", ["Who are you?"], {
    fullMessage: false,
    delay: 100,
    gate: "null-not-limbo",
    text: "err.type=null.",
  }),
  ALWAYS("i_am_scared", ["I am scared", "I'm scared"], "", {
    action: "i_am_scared",
    delivery: "world",
  }),
  NULL("blackout", ["__Blackout__", "Blackout"], "Asshole."),
  NULL("cal", ["Not_It_Cal", "not it cal", "not_it_cal"], "Innocent.", {
    delivery: "none",
    action: "cal",
    gate: "null-not-aftermath",
  }),
  NULL("catfish", ["catfish12", "catfish 12"], "Should've left it alone."),
  NULL("overlord", ["OVERLORD"], "He was wrong."),
  NULL("whyer", ["Whyer4"], "..."),
  NULL("dyexd", ["DyeXD", "DyeXD412", "Dye XD 412"], "Obsessed with answers."),
  ALWAYS("null_structure_positive", ["Oo", "Ooo", "Oooo", "Cool", "Sick", "Nice"], "", {
    action: "null_structure_positive",
    delivery: "none",
  }),
  ALWAYS("null_structure_negative", ["Ew", "Bad", "Gross", "Break", "Never Build again", "Get rid of this", "Ugly"], "", {
    action: "null_structure_negative",
    delivery: "none",
  }),
  ALWAYS("sorry", ["Sorry", "My Bad", "mb", "I Apologize", "Apologies"], "", {
    action: "sorry",
    delivery: "none",
  }),
  ALWAYS("lucid", ["Lucy B. Locks"], "", {
    caseSensitive: true,
    action: "lucid",
    delivery: "none",
  }),
  ALWAYS("clanbase_curved", ["Not_It_Cal", "not it cal", "not_it_cal", "Disc 13", "disc 13", "disc13"], "", {
    action: "clanbase_curved",
    delivery: "none",
    gate: "null-no-aftermath",
  }),
  ALWAYS("hello_structure", HELLO_ALIASES, "", {
    action: "hello_structure",
    delivery: "none",
    gate: "null-watching",
  }),
  response("fever_hello", HELLO_ALIASES, {
    fullMessage: true,
    delay: 100,
    gate: "limbo",
    text: "<Fever> Greetings.",
    delivery: "sender",
  }),
  response("fever_where", ["Where am I?"], {
    fullMessage: true,
    delay: 100,
    gate: "limbo",
    text: "<Fever> Isn't it much more intriguing to think about where you aren't?",
    delivery: "sender",
  }),
  response("fever_what", ["What is this place?"], {
    fullMessage: true,
    delay: 100,
    gate: "limbo",
    text: "<Fever> This? This is a safe haven. You don't need to be afraid here.",
    delivery: "sender",
  }),
  response("fever_who", ["Who are you?", "What are you?"], {
    fullMessage: true,
    delay: 100,
    gate: "limbo",
    text: "<Fever> Don't fret, I am your Savior.",
    delivery: "sender",
  }),
  response("fever_insult", INSULT_ALIASES, {
    fullMessage: true,
    delay: 100,
    gate: "limbo",
    text: "<Fever> That is no way to speak to your Savior. Do you wish for §4Judgement§r?",
    delivery: "sender",
  }),
  response("fever_want", ["What do you want?"], {
    fullMessage: true,
    delay: 100,
    gate: "limbo",
    text: "<Fever> I want to see you, from the inside out.",
    delivery: "sender",
  }),
  response("fever_sky", ["The sky looks weird"], {
    fullMessage: true,
    delay: 100,
    gate: "limbo",
    text: "<Fever> Isn't it beautiful?",
    delivery: "sender",
  }),
  response("fever_homes", ["What are those houses?", "What are those structures?", "What are those homes?", "What are those buildings?"], {
    fullMessage: true,
    delay: 100,
    gate: "limbo",
    text: "<Fever> Such flora, in the forest.",
    delivery: "sender",
  }),
  response("freebird", [
    "This isn't a freebird situation, now is it?",
    "This isn't a free bird situation, now is it?",
    "This isn't a freebird situation, is it?",
    "This isn't a free bird situation, is it?",
  ], {
    fullMessage: true,
    action: "freebird",
    delivery: "none",
  }),
]);

export const CHAT_RESPONSE_IDS = Object.freeze(CHAT_RESPONSES.map((entry) => entry.id));
export const CHAT_RESPONSE_BY_ID = new Map(CHAT_RESPONSES.map((entry) => [entry.id, entry]));

export function getChatResponse(id) {
  return CHAT_RESPONSE_BY_ID.get(id);
}

export function findChatResponse(message, responses = CHAT_RESPONSES) {
  return responses.find((entry) => matchesChatResponse(message, entry));
}
