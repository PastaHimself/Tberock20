import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import {
  ARENA_START_SOURCE,
  arenaCenter,
  arenaParticipants,
  integrityArenaStartPlan,
  sampleArenaOffset,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_start_model.js";

test("Integrity Arena startup preserves the recovered packet constants", () => {
  assert.deepEqual(ARENA_START_SOURCE, {
    participantRadius: 150,
    offsetRandomMinInclusive: -20,
    offsetRandomMaxExclusive: 20,
    offsetAcceptMinInclusive: -10,
    offsetAcceptMaxInclusive: 10,
    preStartDelayTicks: 40,
    startDelayTicks: 60,
    phase1IntroDelayTicks: 1080,
    phase1: "phase1",
    fakeTimeOfDay: "midnight",
    customSkyEnabled: true,
    customSkyColor: { x: 70, y: 0, z: 0 },
  });
});

test("startup offset sampling rejects values outside the source acceptance band", () => {
  const calls = [];
  const values = [-11, 11, -10];
  const offset = sampleArenaOffset((min, max) => {
    calls.push([min, max]);
    return values.shift();
  });

  assert.equal(offset, -10);
  assert.deepEqual(calls, [[-20, 20], [-20, 20], [-20, 20]]);
  assert.deepEqual(
    arenaCenter({ x: 100, y: 64, z: -40 }, { x: -10, z: 10 }, 220),
    { x: 90, y: 220, z: -30 },
  );
});

test("startup captures only same-dimension players within the source radius", () => {
  const center = { x: 0, y: 80, z: 0 };
  const players = [
    { id: "inside", dimensionId: "minecraft:overworld", location: { x: 0.5, y: 80.5, z: 149.5 } },
    { id: "edge", dimensionId: "minecraft:overworld", location: { x: 150.5, y: 80.5, z: 0.5 } },
    { id: "outside", dimensionId: "minecraft:overworld", location: { x: 151, y: 80.5, z: 0.5 } },
    { id: "other-dimension", dimensionId: "minecraft:nether", location: { x: 0.5, y: 80.5, z: 0.5 } },
  ];

  assert.deepEqual(
    arenaParticipants(players, center, "minecraft:overworld").map((player) => player.id),
    ["inside", "edge"],
  );
});

test("existing empty arena restarts its current phase before creating a new one", () => {
  assert.deepEqual(
    integrityArenaStartPlan({
      existingArena: true,
      livingPlayers: [
        { connected: false, alive: true },
        { connected: false, alive: true },
        { connected: false, alive: false },
      ],
      commandBlockPosition: { x: 10, y: 64, z: 20 },
      offset: { x: 0, z: 0 },
      surfaceY: 70,
      dimensionId: "minecraft:overworld",
      nearbyPlayers: [],
    }),
    { action: "restart_phase" },
  );
});

test("new startup schedules the source's midnight/sky step and Phase 1 start", () => {
  const plan = integrityArenaStartPlan({
    existingArena: false,
    livingPlayers: [],
    commandBlockPosition: { x: 10, y: 64, z: 20 },
    offset: { x: -2, z: 3 },
    surfaceY: 70,
    dimensionId: "minecraft:overworld",
    nearbyPlayers: [{ id: "alice" }],
  });

  assert.deepEqual(plan, {
    action: "create_and_start",
    center: { x: 8, y: 70, z: 23 },
    participantIds: ["alice"],
    phase: "phase1",
    schedule: {
      preStartDelayTicks: 40,
      startDelayTicks: 60,
      phase1IntroDelayTicks: 1080,
      fakeTimeOfDay: "midnight",
      customSkyEnabled: true,
      customSkyColor: { x: 70, y: 0, z: 0 },
    },
  });
});

test("Yes now reaches the supported Arena start adapter and intro gate", async () => {
  const [features, runtime, boss] = await Promise.all([
    readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js", import.meta.url), "utf8"),
    readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_runtime.js", import.meta.url), "utf8"),
    readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js", import.meta.url), "utf8"),
  ]);

  assert.match(features, /startIntegrityArena(player, block)/);
  assert.match(runtime, /dimension.getTopmostBlock({ x, z })/);
  assert.match(runtime, /spawnEntity("thebrokenscript:integrity_phase_1"/);
  assert.match(runtime, /runLater(() => prepareArena(activeArena?.token), plan.schedule.preStartDelayTicks)/);
  assert.match(runtime, /phase1IntroDelayTicks/);
  assert.match(runtime, /tbs:integrity_intro_until/);
  assert.match(boss, /isIntegrityPhase1Invulnerable/);
  assert.match(boss, /introUntil.*tbs:integrity_intro_until/);
});
