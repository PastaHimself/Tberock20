// Source-registered event adapters that were absent from the Bedrock runtime.
// Runtime calls stay in horror_events.js; this catalog keeps the source
// boundary and its explicit Bedrock replacement visible to tests and ledgers.
export const SOURCE_REGISTERED_EVENT_ADAPTERS = Object.freeze({
  null_book: Object.freeze({
    sourceType: "null_event",
    bedrockAdapter: "signed_null_book",
  }),
  null_interface_trigger: Object.freeze({
    sourceType: "null_event",
    bedrockAdapter: "null_interface_form_reader",
  }),
  obfuscated_sign: Object.freeze({
    sourceType: "tbs_event",
    bedrockAdapter: "structure_or_notice_fallback",
  }),
  noop: Object.freeze({
    sourceType: "tbs_event",
    bedrockAdapter: "no_op",
  }),
  text: Object.freeze({
    sourceType: "tbs_event",
    bedrockAdapter: "chat_message",
  }),
  title_event: Object.freeze({
    sourceType: "tbs_event",
    bedrockAdapter: "in_game_title_fallback",
  }),
  aberration: Object.freeze({
    sourceType: "tbs_event",
    bedrockAdapter: "player_aberration_timer",
  }),
});

export const ABERRATION_TIMER_TICKS = 1200;

export const TEXT_EVENT_MESSAGES = Object.freeze([
  "I see you.",
  "Can you see me?",
  "It was your fault.",
  "Help us.",
  "I am right behind you.",
  "§4I am right behind you.",
  "null",
  "null.err",
  "000",
  "§kAAAAAAAAA",
  "§eNull joined the game",
  "§eNull left the game",
  "§ejoined the game",
  "<?>",
  "§cInternal Error: IllegalStateException - '<>' is not a valid player name!",
  "§cInternal Error: IllegalStateException - '<?>' is not a valid player name!",
]);

export const NULL_TITLES = Object.freeze([
  "You know nothing",
  "Worship me",
  "Follow me",
  "Join us",
  "Corrupted",
  "Go away",
  "Null",
  "We can hear you",
  "Can you see me?",
  "0",
  "Behind you",
  "Help me",
  "Nothing can be changed",
  "Nothing can be changed",
  "Close your eyes",
  "One of us",
]);

export function titleEventOutcome({
  outerRoll = 0,
  innerRoll = 0,
  branchRoll = 0,
  nullTitleIndex = 0,
} = {}) {
  if (outerRoll >= 0.9) return { kind: "clear", text: "" };
  if (innerRoll >= 0.9) {
    return branchRoll < 0.5
      ? { kind: "become_void", text: "ERR.INTEGRITY" }
      : { kind: "eye", text: "<o>" };
  }
  const index = Math.abs(Math.floor(nullTitleIndex)) % NULL_TITLES.length;
  return { kind: "null_title", text: NULL_TITLES[index] };
}

export function nullInterfaceOutcome(index) {
  const normalized = Math.abs(Math.floor(index)) % 3;
  const number = normalized + 1;
  return {
    kind: "null_interface",
    interfaceId: `null_interface_${number}`,
    title: number === 1 ? "NullInterface" : `NullInterface${number}`,
  };
}

export function obfuscatedSignOutcome(roll) {
  return roll < 0.7 ? "obfuscatedsign" : "ciphersign";
}

export function enableAberration(state) {
  return {
    ...state,
    aberrationEnabled: true,
    aberrationTimer: ABERRATION_TIMER_TICKS,
  };
}

export function missingSourceEventIds(
  deployedEventIds,
  adapters = SOURCE_REGISTERED_EVENT_ADAPTERS,
) {
  const deployed = new Set(deployedEventIds);
  return Object.keys(adapters).filter((id) => !deployed.has(id));
}
