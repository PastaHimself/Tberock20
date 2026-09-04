import { readFile } from "node:fs/promises";
import assert from "node:assert/strict";
import test from "node:test";

import { nulledGuiBody, nulledGuiDefinition } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/nulled_gui_model.js";

test("preserves the source NulledGui title and visible messages", () => {
  assert.deepEqual(nulledGuiDefinition(), {
    title: "NulledGui",
    messages: ["Good luck.", ")="],
  });
});

test("stacks the source NulledGui messages into a readable form body", () => {
  assert.equal(nulledGuiBody(), "Good luck.\n\n)=");
});

test("the active NulledGui event uses the form adapter", async () => {
  const runtime = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js",
    import.meta.url,
  ), "utf8");
  const events = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js",
    import.meta.url,
  ), "utf8");

  assert.match(runtime, /export async function showNulledGui\(/);
  assert.match(runtime, /nulledGuiBody\(\)/);
  assert.match(events, /nulled_gui\(p\) \{\s*void showNulledGui\(p\);\s*playNear\(p, SOUNDS\.glitch, 10, 0\.0\);/);
  assert.doesNotMatch(events, /nulled_gui\(p\) \{ title\(p, "§k███ §rGUI nulled §k███", 40\); \}/);
});
