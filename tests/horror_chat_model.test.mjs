import test from "node:test";
import assert from "node:assert/strict";
import {
  CHAT_RESPONSES,
  CHAT_RESPONSE_IDS,
  HELLO_ALIASES,
  cleanChatMessage,
  findChatResponse,
  getChatResponse,
  matchesChatResponse,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/shared/horror_chat_model.js";

test("chat registry carries all source registrations and ordered aliases", () => {
  assert.equal(CHAT_RESPONSES.length, 42);
  assert.equal(CHAT_RESPONSE_IDS.length, 42);
  assert.equal(new Set(CHAT_RESPONSE_IDS).size, 42);
  assert.equal(HELLO_ALIASES.length, 37);
  assert.equal(getChatResponse("fever_hello").delivery, "sender");
  assert.equal(getChatResponse("hello").delivery, "world");
});

test("source punctuation normalization is ASCII-alphanumeric whitespace", () => {
  assert.equal(cleanChatMessage("  What's   up?!  "), "What s up");
  assert.equal(cleanChatMessage("null_hello"), "null hello");
});

test("full-message and substring response contracts remain distinct", () => {
  assert.equal(matchesChatResponse("Can you see me!", getChatResponse("can_you_see_me")), true);
  assert.equal(matchesChatResponse("please tell me who are you?", getChatResponse("who_are_you")), true);
  assert.equal(matchesChatResponse("xxSteve", getChatResponse("steve")), false);
  assert.equal(matchesChatResponse("null", getChatResponse("null")), true);
  assert.equal(matchesChatResponse("NULL", getChatResponse("null")), false);
});

test("ordered source aliases resolve representative response families", () => {
  assert.equal(findChatResponse("  HULLO!!! ").id, "hello");
  assert.equal(findChatResponse("Where am I?", CHAT_RESPONSES).id, "fever_where");
  assert.equal(findChatResponse("DyeXD412").id, "dyexd");
  assert.equal(findChatResponse("This isn't a free bird situation, is it?").id, "freebird");
});
