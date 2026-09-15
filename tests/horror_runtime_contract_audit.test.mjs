import test from "node:test";
import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import {
  CHAT_RESPONSES,
  CHAT_RESPONSE_IDS,
  findChatResponse,
  getChatResponse,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/shared/horror_chat_model.js";
import {
  EVENT_CONTRACTS,
  SOURCE_EVENT_IDS,
  getEventContract,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/shared/horror_event_model.js";

const read = (path) => readFileSync(new URL("../" + path, import.meta.url), "utf8");

function sourceRegistryIds(source, kind) {
  const registration = new RegExp(
    '(?:TBSReg\\.INSTANCE\\.' + kind + '|BrokenReg\\.' + kind + '\\$default)\\([^\\n]*?"([^"]+)"',
    "g",
  );
  return [...source.matchAll(registration)].map((match) => match[1]);
}

function adapterIds(source) {
  const body = source.match(/const H = \{([\s\S]*?)\n\};/)?.[1] ?? "";
  return [...body.matchAll(/^\s{2}([a-z0-9_]+)\([^\n]*\)\s*\{/gm)].map((match) => match[1]);
}

test("event contracts match the ordered source registry", () => {
  const sourceIds = sourceRegistryIds(read("decompiled/net/thebrokenscript/registry/TBSEvents.java"), "event");
  const runtime = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js");
  assert.equal(sourceIds.length, 86);
  assert.deepEqual(SOURCE_EVENT_IDS, sourceIds);
  assert.deepEqual([...adapterIds(runtime)].sort(), [...SOURCE_EVENT_IDS].sort());
  assert.equal(EVENT_CONTRACTS.length, 86);
  assert.equal(getEventContract("moon_phase").weight, 5);
  assert.equal(getEventContract("isolation").weight, 0);
  assert.equal(getEventContract("coord").sourceClass, "NullEvent");
  assert.equal(getEventContract("tbe_curious").sourceClass, "NullEvent");
  assert.equal(getEventContract("nullnullnull_advancement").sourceClass, "CanHappenToNullEvent");
  assert.equal(getEventContract("null_getting_achievement").sourceClass, "OnlyNullEvent");
});

test("chat contracts match the ordered source registry", () => {
  const sourceIds = sourceRegistryIds(read("decompiled/net/thebrokenscript/registry/TBSChatResponses.java"), "chatResponse");
  assert.equal(sourceIds.length, 42);
  assert.deepEqual(CHAT_RESPONSE_IDS, sourceIds);
  assert.equal(CHAT_RESPONSES.length, 42);
  assert.equal(getChatResponse("fever_hello").delay, 100);
  assert.equal(getChatResponse("fever_hello").delivery, "sender");
  assert.equal(getChatResponse("hello").delivery, "world");
  assert.equal(getChatResponse("sorry").delivery, "none");
  assert.equal(getChatResponse("lucid").caseSensitive, true);
  assert.equal(findChatResponse("Where am I?").id, "fever_where");
});

test("event and chat adapters preserve deferred, additive lifecycle boundaries", () => {
  const eventRuntime = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js");
  const chatRuntime = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_chat.js");
  assert.match(eventRuntime, /world\.getAbsoluteTime/);
  assert.match(eventRuntime, /sourceEventFrequency/);
  assert.match(eventRuntime, /pickValidEvent/);
  assert.match(eventRuntime, /getWorldJSON/);
  assert.match(eventRuntime, /setWorldJSON/);
  assert.match(eventRuntime, /playerDimensionChange/);
  assert.match(chatRuntime, /world\.beforeEvents\.chatSend/);
  assert.match(chatRuntime, /system\.runTimeout/);
  assert.match(chatRuntime, /playerDimensionChange/);
  assert.doesNotMatch(chatRuntime, /event\.cancel\s*=|ev\.cancel\s*=/);
});
