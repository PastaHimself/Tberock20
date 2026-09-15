import test from "node:test";
import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import {
  CHAT_RESPONSE_DEFINITIONS,
  SOURCE_EVENT_DEFINITIONS,
  cleanChatMessage,
  findChatResponse,
  isChatResponseEligible,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_rules.js";

const read = (path) => readFileSync(new URL(`../${path}`, import.meta.url), "utf8");

function javaRegistryIds(source, kind) {
  const ids = [];
  const direct = new RegExp(`TBSReg\\.INSTANCE\\.${kind}\\(\\\"([^\\\"]+)\\\"`);
  const defaults = new RegExp(`BrokenReg\\.${kind}\\$default\\([^\\n]*?\\(String\\)\\\"([^\\\"]+)\\\"`);
  for (const line of source.split("\n")) {
    const match = line.match(direct) ?? line.match(defaults);
    if (match) ids.push(match[1]);
  }
  return ids;
}

test("chat-response registration order and behavior are source-backed", () => {
  const java = read("decompiled/net/thebrokenscript/registry/TBSChatResponses.java");
  const sourceIds = javaRegistryIds(java, "chatResponse");
  const bedrockIds = CHAT_RESPONSE_DEFINITIONS.map((definition) => definition.id);

  assert.equal(sourceIds.length, 42, "TBSChatResponses currently registers 42 responses");
  assert.equal(new Set(sourceIds).size, 42, "source response registry ids must be unique");
  assert.deepEqual(bedrockIds, sourceIds, "Bedrock response definitions preserve Java registration order");
  assert.equal(new Set(bedrockIds).size, 42, "Bedrock response ids must be unique");
});

test("chat matching preserves source normalization, aliases, gates, and first-match behavior", () => {
  assert.equal(cleanChatMessage("  hElLo!!!  "), "hElLo");
  assert.equal(findChatResponse("  hElLo!!!  ")?.id, "hello");
  assert.equal(findChatResponse("hello there"), undefined, "full-message aliases must not become substrings");
  assert.equal(findChatResponse("sorry, please")?.id, "sorry", "substring aliases may ignore punctuation");
  assert.equal(findChatResponse("NULL"), undefined, "the null response is case-sensitive");
  assert.equal(findChatResponse("null!")?.id, "null", "punctuation is normalized before matching");
  assert.equal(findChatResponse("This isn't a freebird situation, now is it?")?.id, "freebird");

  const hello = CHAT_RESPONSE_DEFINITIONS.find((definition) => definition.id === "hello");
  const feverHello = CHAT_RESPONSE_DEFINITIONS.find((definition) => definition.id === "fever_hello");
  const structureHello = CHAT_RESPONSE_DEFINITIONS.find((definition) => definition.id === "hello_structure");
  assert.equal(isChatResponseEligible(hello, { isNullHere: true, dimensionId: "minecraft:overworld", nearbyWatching: false }), true);
  assert.equal(isChatResponseEligible(hello, { isNullHere: true, dimensionId: "thebrokenscript:limbo", nearbyWatching: false }), false);
  assert.equal(isChatResponseEligible(feverHello, { dimensionId: "thebrokenscript:limbo" }), true);
  assert.equal(isChatResponseEligible(structureHello, { isNullHere: true, nearbyWatching: true }), true);

  const implementation = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_chat.js");
  const main = read("TheBrokenScript_Bedrock_2_0/BP/scripts/main.js");
  assert.doesNotMatch(implementation, /event\.cancel\s*=/, "the Java handler leaves the original chat visible");
  assert.match(implementation, /findChatResponse\(event\.message\)/);
  assert.match(implementation, /export function clearPlayer/);
  assert.match(main, /world\.afterEvents\.playerDimensionChange/);
  assert.match(main, /horrorEvents\.clearPlayer\(ev\.player\)/);
  assert.match(main, /horrorChat\.clearPlayer\(ev\.player\)/);
  assert.match(main, /horrorEvents\.clearPlayer\(ev\.deadEntity\)/);
  assert.match(main, /horrorChat\.clearPlayer\(ev\.deadEntity\)/);
});

test("all source horror events have handlers and source selection rules", () => {
  const java = read("decompiled/net/thebrokenscript/registry/TBSEvents.java");
  const sourceIds = javaRegistryIds(java, "event");
  const bedrockIds = SOURCE_EVENT_DEFINITIONS.map((definition) => definition.id);
  const implementation = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js");

  assert.equal(sourceIds.length, 86, "TBSEvents currently registers 86 named source events");
  assert.equal(new Set(sourceIds).size, 86, "source event registry ids must be unique");
  assert.deepEqual([...bedrockIds].sort(), [...sourceIds].sort(), "Bedrock source rules cover every Java event id");
  for (const id of bedrockIds) assert.match(implementation, new RegExp(`\\b${id}\\s*\\(`), `missing handler for ${id}`);
});
