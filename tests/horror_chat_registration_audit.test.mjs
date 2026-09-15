import test from "node:test";
import assert from "node:assert/strict";
import { readFileSync } from "node:fs";

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

test("chat runtime uses the read-only before-chat boundary", () => {
  const chat = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_chat.js");
  assert.match(chat, /world\.beforeEvents\.chatSend/);
  assert.match(chat, /events\.subscribeGuarded/);
  assert.match(chat, /system\.run\(\(\) => handleChat/);
  assert.match(chat, /system\.runTimeout/);
  assert.match(chat, /matchesChatResponse/);
  assert.match(chat, /isLifecycleTokenValid/);
  assert.match(chat, /playerDimensionChange/);
  assert.doesNotMatch(chat, /event\.cancel\s*=|ev\.cancel\s*=/);
});

test("all 42 source chats and 86 event adapters are explicit", () => {
  const chatSource = read("decompiled/net/thebrokenscript/registry/TBSChatResponses.java");
  const eventSource = read("decompiled/net/thebrokenscript/registry/TBSEvents.java");
  const chat = read("TheBrokenScript_Bedrock_2_0/BP/scripts/shared/horror_chat_model.js");
  const events = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js");
  assert.equal(sourceRegistryIds(chatSource, "chatResponse").length, 42);
  assert.equal(sourceRegistryIds(eventSource, "event").length, 86);
  assert.equal(adapterIds(events).length, 86);
  assert.match(chat, /export const CHAT_RESPONSES/);
  assert.match(events, /export const EVENT_CONTRACTS|EVENT_CONTRACTS/);
});
