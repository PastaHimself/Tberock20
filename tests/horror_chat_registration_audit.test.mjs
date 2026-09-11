import test from "node:test";
import assert from "node:assert/strict";
import { readFileSync } from "node:fs";

const read = (path) => readFileSync(new URL(`../${path}`, import.meta.url), "utf8");

function javaRegistryIds(source, kind) {
  const ids = [];
  const direct = new RegExp(`TBSReg\\.INSTANCE\\.${kind}\\(\\"([^\"]+)\\"`, "g");
  const defaults = new RegExp(`BrokenReg\\.${kind}\\$default\\([^\\n]*?\\(String\\)\\"([^\"]+)\\"`, "g");
  for (const match of source.matchAll(direct)) ids.push(match[1]);
  for (const match of source.matchAll(defaults)) ids.push(match[1]);
  return ids.sort();
}

function bedrockChatKeys(source) {
  const body = source.match(/const CHAT_RESPONSES = \{([\s\S]*?)\n\};/)?.[1] ?? "";
  return [...body.matchAll(/^\s{2}([a-z0-9_]+):/gm)].map((m) => m[1]).sort();
}

function bedrockEventIds(source) {
  const body = source.match(/const TABLE = \[([\s\S]*?)\n\];/)?.[1] ?? "";
  return [...body.matchAll(/\[\"([^\"]+)\",/g)].map((m) => m[1]).sort();
}

test("chat-response registry counts are source registrations, not Bedrock rule parity", () => {
  const java = read("decompiled/net/thebrokenscript/registry/TBSChatResponses.java");
  const bedrock = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js");
  const sourceIds = javaRegistryIds(java, "chatResponse");
  const bedrockIds = bedrockChatKeys(bedrock);

  assert.equal(sourceIds.length, 42, "TBSChatResponses currently registers 42 responses");
  assert.equal(new Set(sourceIds).size, 42, "source response registry ids must be unique");
  assert.equal(bedrockIds.length, 13, "Bedrock currently has 13 generic chat-response keys");

  // These are registry/rule identifiers. They are deliberately not asserted equal:
  // each Java ChatResponse owns its own trigger list, gates and delay semantics.
  assert.ok(sourceIds.includes("hello"));
  assert.ok(sourceIds.includes("fever_hello"));
  assert.ok(!bedrockIds.includes("fever_hello"));
});

test("Bedrock chat normalization remains exact case-insensitive trimmed full-key lookup", () => {
  const bedrock = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js");
  assert.match(bedrock, /ev\.message\.toLowerCase\(\)\.trim\(\)/);
  assert.match(bedrock, /CHAT_RESPONSES\[msg\]/);
  assert.doesNotMatch(bedrock, /includes\(msg\)|startsWith\(msg\)/);
});

test("horror-event source and Bedrock registration counts are audited independently", () => {
  const java = read("decompiled/net/thebrokenscript/registry/TBSEvents.java");
  const bedrock = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js");
  const sourceIds = javaRegistryIds(java, "event");
  const bedrockIds = bedrockEventIds(bedrock);

  assert.equal(sourceIds.length, 86, "TBSEvents currently registers 86 named source events");
  assert.equal(new Set(sourceIds).size, 86, "source event registry ids must be unique");
  assert.equal(bedrockIds.length, 79, "Bedrock ambient TABLE currently contains 79 entries");
  assert.equal(new Set(bedrockIds).size, 79, "Bedrock ambient event ids must be unique");

  // Count differences alone do not establish missing mechanics: some source events
  // are engine/UI adapters or are driven by other Bedrock systems rather than TABLE.
});
