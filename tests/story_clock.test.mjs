import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import vm from "node:vm";
import { fileURLToPath, pathToFileURL } from "node:url";
import {
  STORY_EVENT_THRESHOLDS,
  evaluateStoryClockTick,
  validateStoryEventActions,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_clock_model.js";

const ROOT = new URL("../", import.meta.url);
const REPO_ROOT = fileURLToPath(ROOT);

async function source(path) {
  return readFile(new URL(path, ROOT), "utf8");
}

function absolutePath(relativePath) {
  return path.resolve(REPO_ROOT, relativePath);
}

function createSyntheticModule(context, identifier, exports) {
  return new vm.SyntheticModule(
    Object.keys(exports),
    function setExports() {
      for (const [name, value] of Object.entries(exports)) {
        this.setExport(name, value);
      }
    },
    { context, identifier },
  );
}

async function loadRuntimeModule(
  relativePath,
  worldApi,
  extraMocks = {},
  serverExtras = {},
) {
  const context = vm.createContext({ console, setTimeout, clearTimeout });
  const serverModule = createSyntheticModule(context, "@minecraft/server", {
    world: worldApi,
    system: { runTimeout: () => {} },
    ItemStack: class FakeItemStack {},
    ...serverExtras,
  });
  const mockModules = new Map([
    ["@minecraft/server", serverModule],
    ...Object.entries(extraMocks).map(([modulePath, exports]) => [
      absolutePath(modulePath),
      createSyntheticModule(context, absolutePath(modulePath), exports),
    ]),
  ]);
  const modules = new Map(mockModules);

  async function load(filePath) {
    if (modules.has(filePath)) return modules.get(filePath);
    const module = new vm.SourceTextModule(await readFile(filePath, "utf8"), {
      context,
      identifier: filePath,
      initializeImportMeta(meta) {
        meta.url = pathToFileURL(filePath).href;
      },
    });
    modules.set(filePath, module);
    await module.link(async (specifier, referencingModule) => {
      if (specifier === "@minecraft/server") return serverModule;
      if (!specifier.startsWith(".")) {
        throw new Error(`unexpected runtime test import: ${specifier}`);
      }
      return load(path.resolve(path.dirname(referencingModule.identifier), specifier));
    });
    await module.evaluate();
    return module;
  }

  return (await load(absolutePath(relativePath))).namespace;
}

test("story clock gates processing on the daylight-cycle gamerule", async () => {
  const runtime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
  );

  assert.match(runtime, /worldApi\.gameRules\.doDayLightCycle/);
  assert.match(
    runtime,
    /const doDayLightCycle = worldApi\.gameRules\.doDayLightCycle;/,
  );
  assert.match(runtime, /if \(doDayLightCycle !== true\) \{\s*return/);
  assert.match(runtime, /evaluateStoryClockTick/);
  assert.match(runtime, /shouldDispatch/);
});

test("story clock keeps the Java online-player pause semantics", async () => {
  const runtime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
  );

  assert.match(runtime, /worldApi\.getAllPlayers\(\)\.length/);
  assert.match(runtime, /evaluateStoryClockTick\(/);
  assert.match(runtime, /tick\.nextTime !== currentTime/);
  assert.match(runtime, /dispatch\(tick\.nextTime\);/);
});

test("deployed and authoring story clocks stay behaviorally aligned", async () => {
  const deployed = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
  );
  const authoring = await source(
    "TheBrokenScript_Bedrock_2_0/src/shared/story_time.js",
  );
  assert.equal(authoring, deployed);
});

test("deployed and authoring story clock models stay behaviorally aligned", async () => {
  const deployed = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_clock_model.js",
  );
  const authoring = await source(
    "TheBrokenScript_Bedrock_2_0/src/shared/story_clock_model.js",
  );
  assert.equal(authoring, deployed);
});

test("story clock model pauses, resumes, and dispatches like Java", () => {
  assert.deepEqual(evaluateStoryClockTick(100, 0, true), {
    nextTime: 100,
    shouldDispatch: true,
  });
  assert.deepEqual(evaluateStoryClockTick(100, 1, true), {
    nextTime: 101,
    shouldDispatch: true,
  });
  assert.deepEqual(evaluateStoryClockTick(100, 1, false), {
    nextTime: 100,
    shouldDispatch: false,
  });
});

test("story clock runtime dispatches persisted time before player arrival", async () => {
  const players = [];
  const worldApi = {
    gameRules: { doDayLightCycle: true },
    getAllPlayers: () => players,
  };
  const runtime = await loadRuntimeModule(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
    worldApi,
  );
  let persistedTime = 289000;
  const writes = [];
  const dispatches = [];
  const run = () => runtime.runTick({
    worldApi,
    readTime: () => persistedTime,
    writeTime: (nextTime) => {
      writes.push(nextTime);
      persistedTime = nextTime;
    },
    dispatch: (time) => dispatches.push(time),
  });

  assert.equal(typeof runtime.runTick, "function");
  const firstTick = run();
  assert.equal(firstTick.nextTime, 289000);
  assert.equal(firstTick.shouldDispatch, true);
  assert.equal(persistedTime, 289000);
  assert.deepEqual(writes, []);
  assert.deepEqual(dispatches, [289000]);

  players.push({ id: "player-1" });
  const secondTick = run();
  assert.equal(secondTick.nextTime, 289001);
  assert.equal(secondTick.shouldDispatch, true);
  assert.equal(persistedTime, 289001);
  assert.deepEqual(writes, [289001]);
  assert.deepEqual(dispatches, [289000, 289001]);
});

test("story clock runtime pauses all reads and dispatches when daylight is disabled", async () => {
  let readCount = 0;
  const worldApi = {
    gameRules: { doDayLightCycle: false },
    getAllPlayers: () => [{ id: "player-1" }],
  };
  const runtime = await loadRuntimeModule(
    "TheBrokenScript_Bedrock_2_0/src/shared/story_time.js",
    worldApi,
  );
  const writes = [];
  const dispatches = [];

  const pausedTick = runtime.runTick({
      worldApi,
      readTime: () => {
        readCount += 1;
        return 289000;
      },
      writeTime: (time) => writes.push(time),
      dispatch: (time) => dispatches.push(time),
    });
  assert.equal(pausedTick.nextTime, undefined);
  assert.equal(pausedTick.shouldDispatch, false);
  assert.equal(readCount, 0);
  assert.deepEqual(writes, []);
  assert.deepEqual(dispatches, []);
});

test("story event registries contain exactly the source-backed schedule IDs", async () => {
  const expectedIds = STORY_EVENT_THRESHOLDS.map(({ eventId }) => eventId);
  for (const relativePath of [
    "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_events.js",
    "TheBrokenScript_Bedrock_2_0/src/systems/story_events.js",
  ]) {
    const runtime = await source(relativePath);
    const ids = [...runtime.matchAll(/^\s{4}([a-z0-9_]+):\s+on[A-Za-z]+,?$/gm)]
      .map(([, eventId]) => eventId);
    assert.deepEqual(ids.sort(), [...expectedIds].sort(), relativePath);
    assert.match(runtime, /validateStoryEventActions\(STORY_EVENT_ACTIONS\)/);
  }
});

test("story event action validation rejects missing and extra handlers", () => {
  const complete = Object.fromEntries(
    STORY_EVENT_THRESHOLDS.map(({ eventId }) => [eventId, () => {}]),
  );
  assert.deepEqual(validateStoryEventActions(complete), complete);

  const missing = { ...complete };
  delete missing.null_book_hint;
  assert.throws(
    () => validateStoryEventActions(missing),
    /missing handler: null_book_hint/,
  );

  assert.throws(
    () => validateStoryEventActions({ ...complete, unexpected_event: () => {} }),
    /unexpected handler: unexpected_event/,
  );
});

test("authoring null-book handling leaves the event pending with no players", async () => {
  const players = [];
  let nullBookGiven = false;
  let retryCount = 0;
  const registrations = [];
  const worldApi = {
    gameRules: { doDayLightCycle: true },
    getAllPlayers: () => players,
  };
  const runtime = await loadRuntimeModule(
    "TheBrokenScript_Bedrock_2_0/src/systems/story_events.js",
    worldApi,
    {
      "TheBrokenScript_Bedrock_2_0/src/shared/story_time.js": {
        registerThreshold: (threshold, eventId, action) => {
          registrations.push({ threshold, eventId, action });
        },
      },
      "TheBrokenScript_Bedrock_2_0/src/systems/world_state.js": {
        get: (key) => (key === "nullBookGiven" ? nullBookGiven : undefined),
        set: (key, value) => {
          if (key === "nullBookGiven") nullBookGiven = value;
        },
        update: () => {},
      },
      "TheBrokenScript_Bedrock_2_0/src/systems/player_state.js": {
        get: () => undefined,
        set: () => {},
      },
    },
    {
      system: {
        runTimeout: () => {
          retryCount += 1;
        },
      },
    },
  );

  runtime.registerAll();
  const nullBook = registrations.find(({ eventId }) => eventId === "null_book_hint");
  assert.equal(typeof nullBook?.action, "function");
  nullBook.action();
  assert.equal(nullBookGiven, false);
  assert.equal(retryCount, 1);
});

test("story threshold model keeps chronological ordering and exact offsets", () => {
  assert.deepEqual(
    STORY_EVENT_THRESHOLDS.map(({ eventId, threshold }) => [eventId, threshold]),
    [
      ["txt_story_5", 121000],
      ["coords_hint_6", 145000],
      ["txt_story_10", 241000],
      ["null_book_hint", 289000],
      ["txt_story_15", 361000],
      ["txt_story_20", 481000],
      ["moon_corruption_24", 577000],
      ["moon_corruption_32", 769000],
      ["moon_corruption_38", 913000],
      ["moon_corruption_48", 1153000],
    ],
  );
});

test("story thresholds preserve every Java day and tick offset", async () => {
  const runtime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_events.js",
  );
  const clockRuntime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_time.js",
  );
  assert.match(runtime, /STORY_EVENT_THRESHOLDS/);
  assert.match(
    runtime,
    /for \(const \{ eventId, threshold \} of STORY_EVENT_THRESHOLDS\)/,
  );
  assert.match(runtime, /registerThreshold\(threshold, eventId/);
  assert.match(clockRuntime, /thresholds\.get\(time\)/);
});

test("deployed story events use the source-backed threshold schedule", async () => {
  const runtime = await source(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_events.js",
  );

  assert.match(runtime, /STORY_EVENT_THRESHOLDS/);
  assert.match(runtime, /for \(const \{ eventId, threshold \} of STORY_EVENT_THRESHOLDS\)/);
});

test("threshold model remains anchored to every Java story event", async () => {
  const sourceContracts = [
    [
      "decompiled/net/thebrokenscript/events/story/TXTStoryEvent.java",
      [5, 10, 15, 20],
    ],
    [
      "decompiled/net/thebrokenscript/events/story/CoordsStoryEvent.java",
      [6],
    ],
    [
      "decompiled/net/thebrokenscript/events/story/NullBookStoryEvent.java",
      [12],
    ],
    [
      "decompiled/net/thebrokenscript/events/story/MoonCorruptionStoryEvent.java",
      [24, 32, 38, 48],
    ],
  ];

  for (const [path, days] of sourceContracts) {
    const runtime = await source(path);
    for (const day of days) {
      assert.match(runtime, new RegExp(`Time\\.INSTANCE\\.days\\(${day}\\) \\+ 1000`));
    }
  }
});
