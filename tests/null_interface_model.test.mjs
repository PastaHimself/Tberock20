import { readFile } from "node:fs/promises";
import assert from "node:assert/strict";
import test from "node:test";

import {
  NULL_INTERFACE_COUNT,
  nullInterfaceDefinition,
  nullInterfaceGridShape,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/null_interface_model.js";

test("models all three source Null interface screens", () => {
  assert.equal(NULL_INTERFACE_COUNT, 3);
  assert.deepEqual(nullInterfaceDefinition(0), {
    interfaceId: "null_interface_1",
    title: "NullInterface",
    body: "behind you",
    layout: "single_text",
  });
  assert.deepEqual(nullInterfaceDefinition(2), {
    interfaceId: "null_interface_3",
    title: "NullInterface3",
    body: "help",
    layout: "single_text",
  });
});

test("preserves the source NullInterface2 five-by-five null grid", () => {
  const definition = nullInterfaceDefinition(1);
  const rows = definition.body.split("\n");

  assert.deepEqual(nullInterfaceGridShape(), { rows: 5, columns: 5 });
  assert.equal(rows.length, 5);
  assert.ok(rows.every((row) => row.split("   ").length === 5));
  assert.equal((definition.body.match(/null/g) || []).length, 25);
});

test("normalizes invalid or out-of-range interface selections safely", () => {
  assert.equal(nullInterfaceDefinition(3).interfaceId, "null_interface_1");
  assert.equal(nullInterfaceDefinition(-2).interfaceId, "null_interface_3");
  assert.equal(nullInterfaceDefinition("not-a-number").interfaceId, "null_interface_1");
});

test("the active Null interface event uses the form adapter", async () => {
  const runtime = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js",
    import.meta.url,
  ), "utf8");
  const events = await readFile(new URL(
    "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js",
    import.meta.url,
  ), "utf8");

  assert.match(runtime, /export async function showNullInterface\(/);
  assert.match(runtime, /nullInterfaceDefinition\(index\)/);
  assert.match(events, /void showNullInterface\(p, Math\.floor\(Math\.random\(\) \* 3\)\)/);
  assert.doesNotMatch(events, /null_interface_trigger\(p\) \{\s*const outcome = nullInterfaceOutcome/);
});
