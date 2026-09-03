import { readFile } from "node:fs/promises";
import assert from "node:assert/strict";
import test from "node:test";

import {
  ABERRATION_TIMER_TICKS,
  SOURCE_REGISTERED_EVENT_ADAPTERS,
  TEXT_EVENT_MESSAGES,
  nullInterfaceOutcome,
  obfuscatedSignOutcome,
  titleEventOutcome,
  enableAberration,
  missingSourceEventIds,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_event_model.js";

const SOURCE_REGISTERED_EVENT_IDS = [
  "null_book",
  "null_interface_trigger",
  "obfuscated_sign",
  "noop",
  "text",
  "title_event",
  "aberration",
];

test("catalogues every source-registered horror event omitted by the runtime", () => {
  assert.deepEqual(
    missingSourceEventIds([], SOURCE_REGISTERED_EVENT_ADAPTERS),
    SOURCE_REGISTERED_EVENT_IDS,
  );
});

test("models the source aberration event's enabled state and 1200-tick timer", () => {
  assert.deepEqual(
    enableAberration({ aberrationEnabled: false, aberrationTimer: 3, other: "kept" }),
    { aberrationEnabled: true, aberrationTimer: ABERRATION_TIMER_TICKS, other: "kept" },
  );
  assert.equal(ABERRATION_TIMER_TICKS, 1200);
});

test("preserves the source TextEvent message pool", () => {
  assert.deepEqual(TEXT_EVENT_MESSAGES, [
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
});

test("keeps WindowTitleEvent's 90/90/50 branch contract", () => {
  assert.deepEqual(titleEventOutcome({ outerRoll: 0.95 }), {
    kind: "clear",
    text: "",
  });
  assert.deepEqual(titleEventOutcome({ outerRoll: 0.2, innerRoll: 0.95, branchRoll: 0.2 }), {
    kind: "become_void",
    text: "ERR.INTEGRITY",
  });
  assert.deepEqual(titleEventOutcome({ outerRoll: 0.2, innerRoll: 0.95, branchRoll: 0.8 }), {
    kind: "eye",
    text: "<o>",
  });
  assert.deepEqual(titleEventOutcome({ outerRoll: 0.2, innerRoll: 0.2, nullTitleIndex: 1 }), {
    kind: "null_title",
    text: "Worship me",
  });
});

test("maps the NullInterfaceTriggerEvent selection to all three source menus", () => {
  assert.deepEqual(nullInterfaceOutcome(0), {
    kind: "null_interface",
    interfaceId: "null_interface_1",
    title: "NullInterface",
  });
  assert.deepEqual(nullInterfaceOutcome(1), {
    kind: "null_interface",
    interfaceId: "null_interface_2",
    title: "NullInterface2",
  });
  assert.deepEqual(nullInterfaceOutcome(2), {
    kind: "null_interface",
    interfaceId: "null_interface_3",
    title: "NullInterface3",
  });
});

test("preserves ObfuscatedSignEvent's 70/30 structure selection", () => {
  assert.equal(obfuscatedSignOutcome(0.69), "obfuscatedsign");
  assert.equal(obfuscatedSignOutcome(0.7), "ciphersign");
});


test("wires all seven source registrations into the Bedrock event table", async () => {
  const runtime = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js",
    import.meta.url,
  ), "utf8");
  for (const id of SOURCE_REGISTERED_EVENT_IDS) {
    assert.match(runtime, new RegExp(`\\\\b${id}\\\\(`));
    assert.match(runtime, new RegExp(`\\\\["${id}",`));
  }
  assert.match(runtime, /export const EVENT_COUNT = TABLE\.length/);
});
