import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import { resolve } from "node:path";
import { pathToFileURL } from "node:url";
import vm from "node:vm";

const pack = resolve("TheBrokenScript_Bedrock_2_0");
const script = resolve(pack, "BP/scripts/systems/item_block_runtime.js");
const logic = resolve(pack, "BP/scripts/systems/item_block_logic.js");

async function runtime() {
  const context = vm.createContext({});
  const synthetic = (id, exports) => new vm.SyntheticModule(Object.keys(exports), function () {
    for (const [key, value] of Object.entries(exports)) this.setExport(key, value);
  }, { context, identifier: id });
  class ItemStack {
    constructor(typeId, amount) { Object.assign(this, { typeId, amount }); }
  }
  const minecraft = synthetic("@minecraft/server", {
    BlockPermutation: { resolve: (typeId, states = {}) => ({ typeId, states, getState: key => states[key], getAllStates: () => states }) },
    GameMode: { Creative: "creative" }, ItemStack,
  });
  const diagnostics = synthetic("diagnostics", { warnOnce() {}, errorOnce() {} });
  const pure = new vm.SourceTextModule(await readFile(logic, "utf8"), { context, identifier: logic });
  const module = new vm.SourceTextModule(await readFile(script, "utf8"), { context, identifier: script });
  await module.link(specifier => {
    if (specifier === "@minecraft/server") return minecraft;
    if (specifier.endsWith("operation_diagnostics.js")) return diagnostics;
    if (specifier.endsWith("item_block_logic.js")) return pure;
    throw Error(`unexpected dependency ${specifier}`);
  });
  await module.evaluate();
  return module.namespace;
}

function worldGrid() {
  const blocks = new Map();
  const dimension = {
    id: "minecraft:overworld", spawned: [], played: [],
    getBlock(location) {
      const key = `${location.x},${location.y},${location.z}`;
      if (!blocks.has(key)) {
        const block = {
          location: { ...location }, dimension, typeId: "minecraft:air", isAir: true, isSolid: false,
          setType(typeId) { this.setPermutation({ typeId, states: {}, getState: () => undefined, getAllStates: () => ({}) }); },
          setPermutation(permutation) {
            this.permutation = permutation;
            this.typeId = permutation.typeId;
            this.isAir = this.typeId === "minecraft:air";
            this.isSolid = this.typeId === "minecraft:stone";
          },
        };
        block.setType("minecraft:air");
        blocks.set(key, block);
      }
      return blocks.get(key);
    },
    spawnItem(item) { this.spawned.push(item); },
    playSound(sound) { this.played.push(sound); },
  };
  return { dimension, block: (x, y, z) => dimension.getBlock({ x, y, z }) };
}

function player(dimension, typeId, amount = 1, creative = false) {
  const inventory = {
    item: { typeId, amount },
    getItem() { return this.item; },
    setItem(_slot, item) { this.item = item; },
  };
  return {
    typeId: "minecraft:player", isSneaking: false, selectedSlotIndex: 0,
    location: { x: 0, y: 0, z: 0 }, dimension, inventory,
    getComponent() { return { container: inventory }; },
    getGameMode() { return creative ? "creative" : "survival"; },
    getViewDirection() { return { x: 0, z: -1 }; },
    onScreenDisplay: { setActionBar() {} }, playSound() {},
  };
}

test("all 26 plush items place a source model, carry head wearability, and drop the same item", async () => {
  const { readdir } = await import("node:fs/promises");
  const files = (await readdir(resolve(pack, "BP/items"))).filter(name => name.endsWith("_plush.json"));
  assert.equal(files.length, 26);
  for (const filename of files) {
    const name = filename.slice(0, -11);
    const item = JSON.parse(await readFile(resolve(pack, "BP/items", filename)))["minecraft:item"];
    const block = JSON.parse(await readFile(resolve(pack, "BP/blocks", `${name}_plush_block.json`)))["minecraft:block"];
    const geometry = JSON.parse(await readFile(resolve(pack, "RP/models/blocks/plush", `${name}.geo.json`)));
    assert.equal(item.components["minecraft:wearable"].slot, "slot.armor.head");
    assert.equal(item.components["minecraft:max_stack_size"], 1);
    assert.equal(block.components["minecraft:collision_box"], false);
    assert.equal(block.components["minecraft:geometry"], geometry["minecraft:geometry"][0].description.identifier);
    const loot = JSON.parse(await readFile(resolve(pack, "BP", block.components["minecraft:loot"])));
    assert.equal(loot.pools[0].entries[0].name, item.description.identifier);
    const worn = JSON.parse(await readFile(resolve(pack, "RP/attachables", filename)))["minecraft:attachable"].description;
    const wornModel = JSON.parse(await readFile(resolve(pack, "RP/models/attachables/plush", `${name}.geo.json`)));
    assert.equal(worn.identifier, item.description.identifier);
    assert.equal(worn.geometry.default, wornModel["minecraft:geometry"][0].description.identifier);
    assert.equal(wornModel["minecraft:geometry"][0].bones[0].binding, "q.item_slot_to_bone_name(context.item_slot)");
  }
});

test("plush placement spends one in survival, keeps one in creative, and refuses occupied cells", async () => {
  const api = await runtime();
  const grid = worldGrid();
  const support = grid.block(0, 0, 0);
  support.setType("minecraft:stone");
  const p = player(grid.dimension, "thebrokenscript:tekkit_plush");
  assert.equal(api.usePlush(p, p.inventory.item, support, "Up"), true);
  assert.equal(grid.block(0, 1, 0).typeId, "thebrokenscript:tekkit_plush_block");
  assert.equal(grid.block(0, 1, 0).permutation.states["thebrokenscript:direction"], "south");
  assert.equal(p.inventory.item, undefined);
  const creative = player(grid.dimension, "thebrokenscript:tekkit_plush", 1, true);
  assert.equal(api.usePlush(creative, creative.inventory.item, support, "Up"), false);
  assert.equal(creative.inventory.item.amount, 1);
});

test("void bucket places a source and an empty bucket collects only a source", async () => {
  const api = await runtime();
  const grid = worldGrid();
  const support = grid.block(0, 0, 0); support.setType("minecraft:stone");
  const p = player(grid.dimension, "thebrokenscript:void_liquid_bucket");
  assert.equal(api.useFluidBucket(p, support, "Up"), true);
  const fluid = grid.block(0, 1, 0);
  assert.equal(fluid.typeId, "thebrokenscript:void_goop_still");
  assert.equal(p.inventory.item.typeId, "minecraft:bucket");
  assert.equal(api.collectFluid(p, fluid), true);
  assert.equal(fluid.typeId, "minecraft:air");
  assert.equal(p.inventory.item.typeId, "thebrokenscript:void_liquid_bucket");
  fluid.setPermutation({ typeId: "thebrokenscript:void_goop_flow", states: { "thebrokenscript:level": 3 }, getState: () => 3, getAllStates: () => ({}) });
  p.inventory.item.typeId = "minecraft:bucket";
  assert.equal(api.collectFluid(p, fluid), false);
});

test("source spreads downward and horizontally, unsupported flow disappears", async () => {
  const api = await runtime();
  const grid = worldGrid();
  const source = grid.block(0, 1, 0); source.setType("thebrokenscript:void_goop_still");
  api.tickFluid(source);
  assert.equal(grid.block(0, 0, 0).typeId, "thebrokenscript:void_goop_flow");
  grid.block(0, 0, 0).setType("minecraft:stone");
  api.tickFluid(source);
  assert.equal(grid.block(1, 1, 0).permutation.states["thebrokenscript:level"], 1);
  source.setType("minecraft:air");
  const flow = grid.block(1, 1, 0);
  grid.block(1, 0, 0).setType("minecraft:stone");
  api.tickFluid(flow);
  assert.equal(flow.typeId, "minecraft:air");
});

test("buds lose their attachment and veins update connection state", async () => {
  const api = await runtime();
  const grid = worldGrid();
  const bud = grid.block(0, 1, 0);
  bud.setPermutation({ typeId: "thebrokenscript:void_bud", states: {}, getState: () => "up", getAllStates: () => ({}) });
  grid.block(0, 0, 0).setType("minecraft:stone");
  api.tickVoidBud(bud); assert.equal(bud.typeId, "thebrokenscript:void_bud");
  grid.block(0, 0, 0).setType("minecraft:air");
  api.tickVoidBud(bud); assert.equal(bud.typeId, "minecraft:air");
  const vein = grid.block(3, 1, 0); vein.setType("thebrokenscript:new_vein");
  grid.block(3, 0, 0).setType("minecraft:stone");
  grid.block(4, 1, 0).setType("thebrokenscript:new_vein");
  api.tickNewVein(vein);
  assert.equal(vein.permutation.states["thebrokenscript:east"], true);
  assert.equal(vein.permutation.states["thebrokenscript:down"], true);
  grid.block(3, 0, 0).setType("minecraft:air");
  api.tickNewVein(vein); assert.equal(vein.typeId, "minecraft:air");
});
