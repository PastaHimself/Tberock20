import assert from "node:assert/strict";
import test from "node:test";
import { PortalSweep } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/portal_auto_travel.js";
import { linkPortals } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_feature_logic.js";

const a = { dimensionId: "overworld", x: 2, y: 70, z: 3 };
const b = { dimensionId: "overworld", x: 25, y: 70, z: 3 };

function fixture() {
  const blocks = new Map([["2:70:3", "thebrokenscript:portal_controller"], ["25:70:3", "thebrokenscript:portal_controller"]]);
  const living = { id: "cow", typeId: "minecraft:cow", location: { x: 2.2, y: 71.1, z: 3.7 }, getComponent: () => ({}), teleport(target) { this.location = target; this.travels++; }, travels: 0 };
  const item = { id: "drop", typeId: "minecraft:item", location: { x: 2.3, y: 71.1, z: 3.6 }, getComponent: () => undefined, teleport() { throw Error("items must not travel"); } };
  const entities = [living, item];
  const dimension = {
    id: "overworld",
    getBlock: ({ x, y, z }) => ({ typeId: blocks.get(`${x}:${y}:${z}`) ?? "minecraft:air" }),
    getEntities: () => entities,
  };
  const links = linkPortals({}, a, b);
  const sweep = new PortalSweep({ getDimension: () => dimension, getEntity: (id) => entities.find((e) => e.id === id) });
  return { blocks, living, item, links, sweep };
}

test("living entities traverse linked controllers automatically without bouncing back", () => {
  const { living, links, sweep } = fixture();
  assert.equal(sweep.step(links), 1);
  assert.deepEqual(living.location, { x: 25.2, y: 71.1, z: 3.7 });
  assert.equal(sweep.step(links), 0);
  living.location = { x: 27, y: 71.1, z: 3.7 };
  sweep.step(links);
  living.location = { x: 25.2, y: 71.1, z: 3.7 };
  assert.equal(sweep.step(links), 1);
  assert.ok(Math.abs(living.location.x - 2.2) < 1e-9);
  assert.equal(living.location.y, 71.1);
  assert.equal(living.location.z, 3.7);
});

test("nonliving items and removed destination controllers never travel", () => {
  const { blocks, living, links, sweep } = fixture();
  blocks.delete("25:70:3");
  assert.equal(sweep.step(links), 0);
  assert.equal(living.travels, 0);
  blocks.set("25:70:3", "thebrokenscript:portal_controller");
  assert.equal(sweep.step(links), 1);
});
