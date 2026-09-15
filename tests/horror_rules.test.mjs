import test from "node:test";
import assert from "node:assert/strict";

import {
  CHAT_RESPONSE_DEFINITIONS,
  EVENT_FREQUENCY,
  SOURCE_EVENT_DEFINITIONS,
  findChatResponse,
  isChatResponseEligible,
  isEventEligible,
  selectWeightedEvent,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_rules.js";

test("source chat registry preserves aliases, normalization, and first-match order", () => {
  assert.equal(CHAT_RESPONSE_DEFINITIONS.length, 42);
  assert.equal(findChatResponse("  hElLo!!! ")?.id, "hello");
  assert.equal(findChatResponse("hello there"), undefined);
  assert.equal(findChatResponse("sorry, please")?.id, "sorry");
  assert.equal(findChatResponse("NULL"), undefined);
  assert.equal(findChatResponse("null!")?.id, "null");
  assert.equal(findChatResponse("This isn't a free bird situation, is it?")?.id, "freebird");
});

test("chat gates distinguish Limbo and Null-world structure conditions", () => {
  const hello = CHAT_RESPONSE_DEFINITIONS.find((response) => response.id === "hello");
  const feverHello = CHAT_RESPONSE_DEFINITIONS.find((response) => response.id === "fever_hello");
  const helloStructure = CHAT_RESPONSE_DEFINITIONS.find((response) => response.id === "hello_structure");

  assert.equal(isChatResponseEligible(hello, {
    isNullHere: true,
    dimensionId: "overworld",
    nearbyWatching: false,
  }), true);
  assert.equal(isChatResponseEligible(hello, {
    isNullHere: true,
    dimensionId: "thebrokenscript:limbo",
    nearbyWatching: false,
  }), false);
  assert.equal(isChatResponseEligible(feverHello, {
    dimensionId: "thebrokenscript:limbo",
  }), true);
  assert.equal(isChatResponseEligible(helloStructure, {
    isNullHere: true,
    nearbyWatching: true,
  }), true);
});

test("event picker uses source frequency, one eligible player, and inverse-frequency weights", () => {
  assert.equal(EVENT_FREQUENCY, 2.9166666e-4);
  assert.equal(SOURCE_EVENT_DEFINITIONS.length, 86);

  const moonPhase = SOURCE_EVENT_DEFINITIONS.find((event) => event.id === "moon_phase");
  const isolation = SOURCE_EVENT_DEFINITIONS.find((event) => event.id === "isolation");
  const nullInvade = SOURCE_EVENT_DEFINITIONS.find((event) => event.id === "null_invade_base");
  assert.equal(moonPhase.weight, 5);
  assert.equal(isolation.weight, 0);
  assert.equal(isolation.minimumPlayers, 2);
  assert.equal(isEventEligible(nullInvade, { isNullHere: true, survival: true, dimensionId: "minecraft:overworld" }), true);
  assert.equal(isEventEligible(nullInvade, { isNullHere: true, survival: true, dimensionId: "minecraft:the_nether" }), false);
  assert.equal(isEventEligible(moonPhase, {
    isNullHere: true,
    survival: true,
    isDay: true,
    moonShouldChange: true,
    moonPhase: 0,
  }), true);

  const first = selectWeightedEvent(
    SOURCE_EVENT_DEFINITIONS.filter((event) => event.id === "moon_phase" || event.id === "heartbeat"),
    { moon_phase: 1, heartbeat: 1 },
    0.75,
  );
  assert.equal(first.id, "moon_phase");

  const second = selectWeightedEvent(
    SOURCE_EVENT_DEFINITIONS.filter((event) => event.id === "moon_phase" || event.id === "heartbeat"),
    { moon_phase: 2, heartbeat: 1 },
    0.25,
  );
  assert.equal(second.id, "heartbeat");
});
