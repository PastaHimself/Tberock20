import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";
import vm from "node:vm";

async function fixture({ code = "a$B_2", initiator = true, confirm = 0 } = {}) {
  const state = { code, codeApplied: false, inventoryCorruption: 2 };
  const tasks = [];
  const calls = [];
  const messages = [];
  const position = { x: 3, y: 70, z: 9 };
  const blocks = new Map([
    ["3,70,9", "thebrokenscript:command"],
    ["3,69,9", initiator ? "thebrokenscript:initiator" : "minecraft:stone"],
  ]);
  const player = {
    id: "tester", isValid: true, typeId: "minecraft:player",
    location: { x: 3, y: 70, z: 9 },
    sendMessage(value) { messages.push(value); },
    dimension: {
      id: "minecraft:overworld",
      getBlock({ x, y, z }) { return { typeId: blocks.get(`${x},${y},${z}`) ?? "minecraft:air" }; },
    },
  };
  let answer = code;
  const ui = {
    ModalFormData: class {
      title() { return this; }
      textField() { return this; }
      submitButton() { return this; }
      async show() { return { canceled: false, formValues: [answer] }; }
    },
    MessageFormData: class {
      title() { return this; }
      body() { return this; }
      button1() { return this; }
      button2() { return this; }
      async show() { return { canceled: confirm === null, selection: confirm ?? undefined }; }
    },
  };
  const system = { runTimeout(fn, ticks) { tasks.push({ fn, ticks }); } };
  const arena = {
    getState: () => null,
    start(...args) { calls.push(args); return { accepted: true }; },
  };
  const worldState = {
    get(key) { return state[key]; },
    set(key, value) { state[key] = value; },
    update(key, fn) { state[key] = fn(state[key]); },
  };
  const context = vm.createContext({});
  const modules = {
    "@minecraft/server": { system },
    "@minecraft/server-ui": ui,
    "../core/logging.js": { logger: { error: (_, error) => { throw error; } } },
    "../entities/boss/integrity_arena_runtime.js": arena,
    "./world_state.js": worldState,
  };
  const source = await readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/command_block_screen.js", import.meta.url), "utf8");
  const module = new vm.SourceTextModule(source, { context });
  await module.link((specifier) => {
    const exports = modules[specifier];
    assert.ok(exports, specifier);
    return new vm.SyntheticModule(Object.keys(exports), function () {
      for (const [key, value] of Object.entries(exports)) this.setExport(key, value);
    }, { context });
  });
  await module.evaluate();
  return { ...module.namespace, state, calls, tasks, blocks, player, position, messages, setAnswer: (value) => { answer = value; } };
}

test("command screen requires exact code and an initiator before applying progression", async () => {
  const f = await fixture();
  f.setAnswer("a$b_2");
  await f.openCommandBlockScreen(f.player, f.position);
  assert.equal(f.state.codeApplied, false);
  assert.equal(f.state.inventoryCorruption, 2);
  assert.match(f.messages.at(-1), /invalid.code/);
  f.setAnswer("a$B_2");
  f.blocks.set("3,69,9", "minecraft:stone");
  await f.openCommandBlockScreen(f.player, f.position);
  assert.equal(f.state.codeApplied, false);
  assert.match(f.messages.at(-1), /initiator/);
  assert.equal(f.tasks.length, 0);
});

test("confirmation starts the Integrity arena after the source delay at an offset from the block", async () => {
  const f = await fixture();
  await f.openCommandBlockScreen(f.player, f.position);
  assert.equal(f.state.codeApplied, true);
  assert.equal(f.state.inventoryCorruption, 3);
  assert.equal(f.tasks.length, 1);
  assert.equal(f.tasks[0].ticks, 100);
  assert.equal(f.calls.length, 0);
  f.tasks[0].fn();
  assert.equal(f.calls[0][0], f.player);
  assert.equal(f.calls[0][1], "phase1");
  const center = f.calls[0][2];
  assert.ok(Math.abs(center.x - f.position.x) >= 10.5);
  assert.ok(Math.abs(center.z - f.position.z) >= 10.5);
});

test("cancellation and block removal do not start an encounter", async () => {
  const canceled = await fixture({ confirm: null });
  await canceled.openCommandBlockScreen(canceled.player, canceled.position);
  assert.equal(canceled.state.codeApplied, true);
  assert.equal(canceled.tasks.length, 0);
  const removed = await fixture();
  await removed.openCommandBlockScreen(removed.player, removed.position);
  removed.blocks.delete("3,70,9");
  removed.tasks[0].fn();
  assert.equal(removed.calls.length, 0);
});
