import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import { chooseHorrorEvent } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_event_model.js";

const sourceEvents = [
  { id: "first", weight: 1, sourceBase: "RandomEvent", target: "any-player" },
  { id: "second", weight: 1, sourceBase: "RandomEvent", target: "any-player" },
];

test("horror selection consumes global, target, context, and weighted rolls in stable order", () => {
  const values = [0.1, 0.99, 0.1, 0.75];
  const calls = [];
  const players = [{ id: "one" }, { id: "two" }];

  const result = chooseHorrorEvent({
    players,
    eventDefinitions: sourceEvents,
    eventFrequency: 0.5,
    random01: () => {
      calls.push(values.shift());
      return calls.at(-1);
    },
    buildContext: (target, allPlayers, randomBoolean) => ({
      enabled: true,
      survival: true,
      playerCount: allPlayers.length,
      selectedId: target.id,
      randomBoolean,
    }),
  });

  assert.equal(result.target, players[1]);
  assert.equal(result.selected?.id, "second");
  assert.deepEqual(result.eligible.map((event) => event.id), ["first", "second"]);
  assert.deepEqual(calls, [0.1, 0.99, 0.1, 0.75]);
  assert.equal(result.context.randomBoolean, true);
});

test("a failed global frequency roll does not consume target or context randomness", () => {
  let calls = 0;
  const result = chooseHorrorEvent({
    players: [{ id: "one" }],
    eventDefinitions: sourceEvents,
    eventFrequency: 0.5,
    random01: () => {
      calls += 1;
      return 0.9;
    },
    buildContext: () => ({ enabled: true, survival: true }),
  });

  assert.equal(result.selected, undefined);
  assert.equal(result.reason, "frequency");
  assert.equal(calls, 1);
});

test("the global frequency boundary remains inclusive like Java's greater-than gate", () => {
  const values = [0.5, 0, 0, 0];
  const result = chooseHorrorEvent({
    players: [{ id: "one" }],
    eventDefinitions: sourceEvents,
    eventFrequency: 0.5,
    random01: () => values.shift(),
    buildContext: () => ({ enabled: true, survival: true }),
  });

  assert.equal(result.reason, "selected");
  assert.equal(result.selected?.id, "first");
});

test("handler filtering happens before weighted selection and preserves source order", () => {
  const result = chooseHorrorEvent({
    players: [{ id: "one" }],
    eventDefinitions: [
      { id: "missing", weight: 100, sourceBase: "RandomEvent", target: "any-player" },
      { id: "present", weight: 1, sourceBase: "RandomEvent", target: "any-player" },
    ],
    eventFrequency: 1,
    random01: () => 0,
    hasHandler: (id) => id === "present",
    buildContext: () => ({ enabled: true, survival: true }),
  });

  assert.deepEqual(result.eligible.map((event) => event.id), ["present"]);
  assert.equal(result.selected?.id, "present");
});

test("empty or suppressed populations do not consume random values", () => {
  let calls = 0;
  const random01 = () => {
    calls += 1;
    return 0;
  };

  assert.equal(chooseHorrorEvent({ players: [], random01 }).reason, "no-players");
  assert.equal(chooseHorrorEvent({ players: [{ id: "one" }], arenaActive: true, random01 }).reason, "arena");
  assert.equal(calls, 0);
});

test("the runtime adapter dispatches the selected event to the selected player", async () => {
  const source = await readFile(
    new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js", import.meta.url),
    "utf8",
  );

  assert.match(source, /H\[selected\.id\]\(selection\.target\)/);
  assert.doesNotMatch(source, /H\[selected\.id\]\(target\)/);
});
