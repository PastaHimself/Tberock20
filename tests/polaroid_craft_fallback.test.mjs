import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import test from "node:test";
import { finishPolaroid } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/polaroid_craft.js";

test("finishing the crafting-table output yields a Polaroid and grants progression", () => {
  const inventory = { item: { typeId: "thebrokenscript:polaroid_frame", amount: 1 }, getItem() { return this.item; }, setItem(_slot, item) { this.item = item; } };
  const player = { selectedSlotIndex: 3, getComponent: () => ({ container: inventory }) };
  const awarded = [];
  assert.equal(finishPolaroid(player, (id) => ({ typeId: id, amount: 1 }), (_player, id) => awarded.push(id)), true);
  assert.equal(inventory.item.typeId, "thebrokenscript:polaroid");
  assert.deepEqual(awarded, ["polaroid_craft"]);
  assert.equal(finishPolaroid(player, (id) => ({ typeId: id }), () => { throw new Error("duplicate"); }), false);
});

test("unrelated inventory items and failed conversion never grant progression", () => {
  const inventory = { getItem: () => ({ typeId: "thebrokenscript:polaroid" }), setItem: () => { throw new Error("unexpected"); } };
  const player = { selectedSlotIndex: 0, getComponent: () => ({ container: inventory }) };
  assert.equal(finishPolaroid(player, () => ({}), () => { throw new Error("award"); }), false);
  inventory.getItem = () => ({ typeId: "thebrokenscript:polaroid_frame" });
  assert.throws(() => finishPolaroid(player, () => ({}), () => { throw new Error("award"); }), /unexpected/);
});

test("crafting recipe produces a frame with a registered finishing action", () => {
  const root = new URL("../TheBrokenScript_Bedrock_2_0/BP/", import.meta.url);
  const recipe = JSON.parse(readFileSync(new URL("recipes/polaroid.json", root)));
  const frame = JSON.parse(readFileSync(new URL("items/polaroid_frame.json", root)));
  const script = readFileSync(new URL("scripts/systems/ported_features.js", root), "utf8");
  const progression = readFileSync(new URL("scripts/systems/progression.js", root), "utf8");
  assert.equal(recipe["minecraft:recipe_shapeless"].result.item, "thebrokenscript:polaroid_frame");
  assert.ok(frame["minecraft:item"].components["thebrokenscript:finish_polaroid"]);
  assert.match(script, /register\("thebrokenscript:finish_polaroid"/);
  assert.doesNotMatch(progression, /tbs\.progression_scan/);
});
