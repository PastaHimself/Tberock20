#!/usr/bin/env node
// Synthetic controller profile. It models the five shipped controllers that
// use the shared 1-tick player/dimension cache. Entity scan work is counted,
// not executed, so the profile stays fast and deterministic while still
// proving that caching does not reduce scan frequency or entity coverage.

import { createDimensionHandleCache, createPlayerPresenceCache } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/perf_model.js";

const TICKS = 240;
const CONTROLLERS = ["boss", "tbe", "humanoid", "misc", "stalk"];
const DIMENSIONS = ["overworld", "nether", "the_end"];
const SCENARIOS = [
  { id: "idle", players: 0, entitiesPerDimension: 0 },
  { id: "solo", players: 1, entitiesPerDimension: 25 },
  { id: "small-multiplayer", players: 4, entitiesPerDimension: 100 },
  { id: "large-multiplayer", players: 8, entitiesPerDimension: 250 },
  { id: "stress-multiplayer", players: 16, entitiesPerDimension: 400 },
];

function profileScenario(scenario) {
  let playerReads = 0;
  let dimensionReads = 0;
  let controllerTicks = 0;
  let entityScans = 0;
  const players = Array.from({ length: scenario.players }, (_, index) => ({ id: `player-${index}` }));
  const presence = createPlayerPresenceCache(() => {
    playerReads += 1;
    return players;
  });
  const dimensions = createDimensionHandleCache((name) => {
    dimensionReads += 1;
    return { id: name };
  });

  const started = performance.now();
  for (let tick = 0; tick < TICKS; tick += 1) {
    for (const _controller of CONTROLLERS) {
      if (!presence.hasPlayers(tick)) continue;
      controllerTicks += 1;
      for (const dimension of DIMENSIONS) {
        dimensions.get(dimension);
        // The cache is not allowed to alter which entities are scanned.
        entityScans += scenario.entitiesPerDimension;
      }
    }
  }
  const elapsedMs = Number((performance.now() - started).toFixed(3));
  const activeTicks = scenario.players > 0 ? TICKS : 0;
  const uncached = {
    playerReads: TICKS * CONTROLLERS.length,
    dimensionReads: activeTicks * CONTROLLERS.length * DIMENSIONS.length,
    controllerTicks: activeTicks * CONTROLLERS.length,
    entityScans: activeTicks * CONTROLLERS.length * DIMENSIONS.length * scenario.entitiesPerDimension,
  };

  return {
    id: scenario.id,
    players: scenario.players,
    entitiesPerDimension: scenario.entitiesPerDimension,
    ticks: TICKS,
    elapsedMs,
    cached: { playerReads, dimensionReads, controllerTicks, entityScans },
    uncached,
  };
}

function buildReport() {
  return {
    schemaVersion: 1,
    ticksPerScenario: TICKS,
    controllers: CONTROLLERS,
    dimensions: DIMENSIONS,
    scenarios: SCENARIOS.map(profileScenario),
  };
}

function validateReport(report) {
  const errors = [];
  for (const scenario of report.scenarios) {
    if (scenario.cached.playerReads !== scenario.ticks) {
      errors.push(`${scenario.id}: player cache read more than once per tick`);
    }
    if (scenario.cached.controllerTicks !== scenario.uncached.controllerTicks) {
      errors.push(`${scenario.id}: cache changed controller dispatch count`);
    }
    if (scenario.cached.entityScans !== scenario.uncached.entityScans) {
      errors.push(`${scenario.id}: cache changed entity scan work`);
    }
    if (scenario.cached.dimensionReads > scenario.uncached.dimensionReads) {
      errors.push(`${scenario.id}: dimension cache increased lookups`);
    }
  }
  return errors;
}

const args = new Set(process.argv.slice(2));
const report = buildReport();
const errors = validateReport(report);
if (errors.length > 0 && args.has("--check")) {
  for (const error of errors) console.error(`P2 scan profile: ERROR: ${error}`);
  process.exitCode = 1;
} else if (args.has("--json")) {
  console.log(JSON.stringify(report, null, 2));
} else {
  console.log("P2 scan profile (synthetic 240-tick controller workload)");
  for (const scenario of report.scenarios) {
    console.log(
      `${scenario.id}: players=${scenario.players} entities/dimension=${scenario.entitiesPerDimension} `
      + `dimension lookups ${scenario.uncached.dimensionReads}->${scenario.cached.dimensionReads} `
      + `entity scans=${scenario.cached.entityScans} elapsed=${scenario.elapsedMs}ms`,
    );
  }
  if (errors.length > 0) process.exitCode = 1;
}
