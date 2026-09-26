import assert from "node:assert/strict";
import { readFile, stat } from "node:fs/promises";
import test from "node:test";
import vm from "node:vm";

const BASE = new URL("../TheBrokenScript_Bedrock_2_0/", import.meta.url);

async function runtimeFixture() {
  const tasks = new Map();
  let tick = 0;
  let nextId = 0;
  const messages = [];
  const player = {
    id: "player-one", isValid: true,
    onScreenDisplay: {
      setTitle(value, options) { messages.push({ tick, value, options }); },
    },
  };
  const system = {
    runTimeout(fn, delay) {
      const id = ++nextId;
      tasks.set(id, { fn, at: tick + delay });
      return id;
    },
    clearRun(id) { tasks.delete(id); },
  };
  const context = vm.createContext({});
  const server = new vm.SyntheticModule(["system"], function () {
    this.setExport("system", system);
  }, { context });
  const logging = new vm.SyntheticModule(["logger"], function () {
    this.setExport("logger", { warnOnce: () => assert.fail("screen transport failed") });
  }, { context });
  const source = await readFile(new URL("BP/scripts/systems/screen_overlay.js", BASE), "utf8");
  const module = new vm.SourceTextModule(source, { context });
  await module.link((specifier) => specifier === "@minecraft/server" ? server : logging);
  await module.evaluate();
  function advance(to) {
    while (true) {
      const next = [...tasks].sort((a, b) => a[1].at - b[1].at)[0];
      if (!next || next[1].at > to) break;
      tick = next[1].at;
      tasks.delete(next[0]);
      next[1].fn();
    }
    tick = to;
  }
  return { ...module.namespace, advance, messages, player };
}

test("screen overlays replace title markers, cancel prior clears, and expire per player", async () => {
  const ui = await runtimeFixture();
  assert.equal(ui.showScreen(ui.player, "tbescreenframe_1", 5), true);
  assert.equal(ui.messages[0].value, "tbs:screen/tbescreenframe_1");
  ui.advance(3);
  ui.showScreen(ui.player, "tbescreenframe_2", 5);
  ui.advance(5);
  assert.equal(ui.messages.at(-1).value, "tbs:screen/tbescreenframe_2");
  ui.advance(8);
  assert.equal(ui.messages.at(-1).value, "tbs:screen/clear");
  assert.throws(() => ui.showScreen(ui.player, "missing_asset", 1), /Unknown screen/);
});

test("sprite sheet transport advances source frames at its recorded tick rate", async () => {
  const ui = await runtimeFixture();
  ui.showScreen(ui.player, "tbe_curious", 8);
  ui.advance(3);
  ui.advance(6);
  assert.deepEqual(ui.messages.map(({ value }) => value), [
    "tbs:screen/tbe_curious/1", "tbs:screen/tbe_curious/2", "tbs:screen/tbe_curious/3",
  ]);
  ui.advance(8);
  assert.equal(ui.messages.at(-1).value, "tbs:screen/clear");
  ui.showScreen(ui.player, "transition", 0);
  ui.advance(50);
  assert.equal(ui.messages.filter(({ value }) => value.startsWith("tbs:screen/transition/")).length, 22);
});

test("every runtime screen has a texture and animated frame maps stay within source atlases", async () => {
  const ui = await runtimeFixture();
  const rp = new URL("RP/", BASE);
  for (const id of ui.SCREEN_IDS) {
    const asset = id.startsWith("very_serious/what_if_garfunkle_was_") ? "garfunkle_sealed" : id;
    assert.ok((await stat(new URL(`textures/ui/tbs/screens/${asset}.png`, rp))).size > 0, id);
  }
  const screen = JSON.parse(await readFile(new URL("ui/tbs_screens.json", rp), "utf8"));
  const hud = JSON.parse(await readFile(new URL("ui/hud_screen.json", rp), "utf8"));
  assert.match(hud.hud_title_text.bindings[1].source_property_name, /tbs:screen\//);
  const regions = screen.animated.controls.flatMap((control) => Object.values(control));
  assert.equal(regions.length, 4 + 22 + 5);
  const lastTransition = regions.find((region) => region.bindings[1].source_property_name.includes("transition/22"));
  assert.deepEqual(lastTransition.uv, [0, 3360]);
  assert.deepEqual(lastTransition.uv_size, [640, 480]);
});
