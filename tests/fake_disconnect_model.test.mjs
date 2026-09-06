import { readFile } from "node:fs/promises";
import assert from "node:assert/strict";
import test from "node:test";

import { fakeDisconnectDefinition } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fake_disconnect_model.js";

test("preserves the source FakeDisconnect visible contract and metadata", () => {
  assert.deepEqual(fakeDisconnectDefinition(), {
    heading: "Connection Lost",
    title: "Timed out",
    body: "Timed out",
    button: "Back to title screen",
    canCloseOnEsc: false,
    autoCloseTicks: 100,
    panorama: true,
  });
});

test("the active FakeDisconnect event uses the form adapter", async () => {
  const runtime = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js",
    import.meta.url,
  ), "utf8");
  const events = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js",
    import.meta.url,
  ), "utf8");

  assert.match(runtime, /export async function showFakeDisconnect\(/);
  assert.match(runtime, /fakeDisconnectDefinition\(\)/);
  assert.match(events, /fake_disconnect\(p\) \{\s*void showFakeDisconnect\(p\);\s*\}/);
  assert.doesNotMatch(events, /fake_disconnect\(p\) \{ title\(p, "§cDisconnected", 50, "§7End of stream"\); \}/);
});
