import { GameMode, system, world } from "@minecraft/server";
import { config } from "../core/config.js";
import { logger } from "../core/logging.js";
import * as operationDiagnostics from "../core/operation_diagnostics.js";
import * as integrityArenaRuntime from "../entities/boss/integrity_arena_runtime.js";
import * as gaze from "./ai/gaze.js";
import * as dimensions from "./dimensions.js";
import {
  PLAYER_LIFECYCLE_SOURCE,
  becomeVoidTransition,
  decrementPositiveTimer,
  shouldClearDespawnEntitySwitch,
  shouldClearSkipFallDamage,
  trueEndGameStep,
} from "./player_lifecycle_model.js";
import * as playerState from "./player_state.js";
import * as worldState from "./world_state.js";

const transfersInFlight = new Set();

function setIfChanged(player, key, value) {
  if (playerState.get(player, key) !== value) playerState.set(player, key, value);
}

function tickSimpleTimer(player, timerKey, onExpire) {
  const step = decrementPositiveTimer(playerState.get(player, timerKey));
  if (step.previous <= 0) return false;
  playerState.set(player, timerKey, step.next);
  if (step.expired) onExpire?.();
  return step.expired;
}

function safePlayerMessage(player, title, subtitle = "") {
  try {
    player.onScreenDisplay.setTitle(title, {
      subtitle,
      fadeInDuration: 0,
      stayDuration: 40,
      fadeOutDuration: 10,
    });
  } catch (error) {
    operationDiagnostics.warnOnce("player_lifecycle.alert", "player lifecycle alert could not be displayed", error);
  }
}

function finishSyncTimer(player) {
  try { player.stopSound?.("tape_hiss"); } catch (error) {
    operationDiagnostics.warnOnce("player_lifecycle.sync_sound", "failed to stop tape hiss after sync timer", error);
  }
  setIfChanged(player, "vhsEnabled", !Boolean(playerState.get(player, "vhsEnabled")));
  setIfChanged(player, "isDesync", false);

  // PlayerDataTicker deliberately uses three independent random draws.
  if (Math.random() <= 0.2) {
    safePlayerMessage(player, "LWJGL Alert", "UNHANDLED PLAYER EXCEPTION");
    return;
  }
  if (Math.random() <= 0.5) return;
  if (Math.random() <= 0.05) {
    if (!config.get("server.disableBanning")) setIfChanged(player, "ban", true);
    return;
  }
  safePlayerMessage(player, "LWJGL Alert", "UNHANDLED PLAYER EXCEPTION");
  try {
    const safeName = String(player.name ?? "").replace(/"/g, '\\"');
    player.dimension.runCommand(`kick "${safeName}"`);
  } catch (error) {
    operationDiagnostics.warnOnce("player_lifecycle.sync_kick", "sync-timer kick fallback could not execute", error);
  }
}

function tickIsolation(player) {
  const timer = Number(playerState.get(player, "isolationTimer"));
  if (timer > 0) {
    playerState.set(player, "isolationTimer", Math.max(0, timer - 1));
  } else if (playerState.get(player, "isolationActive")) {
    playerState.set(player, "isolationActive", false);
    playerState.setJSON(player, "isolationAllowedUsers", []);
    return;
  }

  if (!playerState.get(player, "isolationActive")) return;
  const allowed = new Set(playerState.getJSON(player, "isolationAllowedUsers").map(String));
  const connected = new Map(world.getAllPlayers().map((candidate) => [String(candidate.id), candidate]));
  let changed = false;
  for (const id of [...allowed]) {
    if (id === String(player.id)) continue;
    const candidate = connected.get(id);
    if (!candidate || !gaze.isEntityInFovCone(player, candidate, null, Number(playerState.get(player, "fov")))) {
      allowed.delete(id);
      changed = true;
    }
  }
  if (changed) playerState.setJSON(player, "isolationAllowedUsers", [...allowed]);
}

export function startIsolation(player) {
  const ids = world.getAllPlayers().map((candidate) => String(candidate.id));
  playerState.set(player, "isolationActive", true);
  playerState.set(player, "isolationTimer", PLAYER_LIFECYCLE_SOURCE.isolationDurationTicks);
  playerState.setJSON(player, "isolationAllowedUsers", ids);
}

function standingOnAir(player) {
  try {
    const below = player.dimension.getBlock({
      x: Math.floor(player.location.x),
      y: Math.floor(player.location.y) - 1,
      z: Math.floor(player.location.z),
    });
    return !below || below.isAir === true || below.typeId === "minecraft:air";
  } catch (error) {
    operationDiagnostics.warnOnce("player_lifecycle.ground_probe", "skip-fall-damage ground probe failed", error);
    return true;
  }
}

function kickBannedPlayer(player) {
  if (!playerState.get(player, "ban") || config.get("server.disableBanning")) return;
  try {
    const safeName = String(player.name ?? "").replace(/"/g, '\\"');
    player.dimension.runCommand(`kick "${safeName}" multiplayer.disconnect.banned`);
  } catch (error) {
    operationDiagnostics.warnOnce("player_lifecycle.ban_kick", "persistent ban enforcement could not kick player", error);
  }
}

function findOverworldLanding(player, fellFromMoon) {
  const x = Math.floor(player.location.x);
  const z = Math.floor(player.location.z);
  let surfaceY = 64;
  try {
    const overworld = world.getDimension("overworld");
    for (let y = 319; y >= -63; y -= 1) {
      const block = overworld.getBlock({ x, y, z });
      if (!block || block.isAir === true || block.typeId === "minecraft:air") continue;
      surfaceY = y + 1;
      break;
    }
  } catch (error) {
    operationDiagnostics.warnOnce("player_lifecycle.overworld_height", "overworld surface scan failed; using source fallback height", error);
  }
  return { x: x + 0.5, y: surfaceY + (fellFromMoon ? 149 : 0), z: z + 0.5 };
}

async function transferPlayer(player, destination, location) {
  const id = String(player.id);
  if (transfersInFlight.has(id)) return false;
  transfersInFlight.add(id);
  playerState.set(player, "fixPos", true);
  try {
    const ok = await dimensions.teleportWhenReady(player, destination, location);
    if (!ok) playerState.set(player, "fixPos", false);
    return ok;
  } catch (error) {
    playerState.set(player, "fixPos", false);
    operationDiagnostics.errorOnce("player_lifecycle.transfer", `dimension transfer to '${destination}' failed`, error);
    return false;
  } finally {
    transfersInFlight.delete(id);
  }
}

async function returnToOverworld(player, fellFromMoon, restoreSpawnAfterTicks = 0) {
  const spawnPoint = restoreSpawnAfterTicks > 0 ? player.getSpawnPoint?.() : undefined;
  playerState.set(player, "skipFallDamage", true);
  const landed = await transferPlayer(player, "overworld", findOverworldLanding(player, fellFromMoon));
  if (!landed || !spawnPoint || restoreSpawnAfterTicks <= 0) return landed;
  system.runTimeout(() => {
    try {
      const targetDimension = spawnPoint.dimension ?? world.getDimension("overworld");
      player.teleport(
        { x: spawnPoint.x + 0.5, y: spawnPoint.y, z: spawnPoint.z + 0.5 },
        { dimension: targetDimension },
      );
    } catch (error) {
      operationDiagnostics.warnOnce("player_lifecycle.restore_spawn", "post-return spawn-point restoration failed", error);
    }
  }, restoreSpawnAfterTicks);
  return landed;
}

async function handleStage2Exit(player) {
  const ids = new Set(integrityArenaRuntime.getParticipantIds?.() ?? []);
  const connected = world.getAllPlayers();
  const participants = ids.size > 0
    ? connected.filter((candidate) => ids.has(candidate.id))
    : [player];
  await Promise.all(participants.map((candidate) => transferPlayer(candidate, "void_shadow")));
}

function stopPlayerSounds(player) {
  try { player.stopAllSounds?.(); } catch (error) {
    operationDiagnostics.warnOnce("player_lifecycle.stop_sounds", "failed to stop player sounds for Clan Void transition", error);
  }
}

async function tickDimensionTransitions(player) {
  const action = becomeVoidTransition({
    dimensionId: player.dimension?.id,
    y: player.location?.y,
    fixPos: Boolean(playerState.get(player, "fixPos")),
    moonStage: Number(worldState.get("moonStage")),
  });
  if (!action) return;

  if (action.kind === "dimension") {
    if (action.destination === "the_moon") {
      try { player.onScreenDisplay.setActionBar({ translate: "message.thebrokenscript.become_void" }); } catch (error) {
        operationDiagnostics.warnOnce("player_lifecycle.become_void_message", "BecomeVoid action-bar message failed", error);
      }
    }
    await transferPlayer(player, action.destination);
    return;
  }
  if (action.kind === "stage2_to_stage3") {
    await handleStage2Exit(player);
    return;
  }
  if (action.kind === "overworld_return") {
    await returnToOverworld(player, action.fellFromMoon, action.restoreBedAfterTicks);
    return;
  }
  if (action.kind === "clan_void_vertical") {
    stopPlayerSounds(player);
    playerState.set(player, "skipFallDamage", true);
    playerState.set(player, "musicTimer", 65);
    try { player.stopRiding?.(); } catch (error) {
      operationDiagnostics.warnOnce("player_lifecycle.stop_riding", "Clan Void transition could not stop riding", error);
    }
    try {
      player.teleport({ x: player.location.x, y: action.targetY, z: player.location.z });
      player.clearVelocity?.();
      playerState.set(player, "lastClanVoidTeleport", Number(system.currentTick ?? 0));
      try { player.playSound("travel_glitched"); } catch (error) {
        operationDiagnostics.warnOnce("player_lifecycle.travel_sound", "Clan Void travel sound failed", error);
      }
    } catch (error) {
      operationDiagnostics.warnOnce("player_lifecycle.clan_void_vertical", "Clan Void vertical transfer failed", error);
    }
    return;
  }
  if (action.kind === "clan_void_floor_guard") {
    playerState.set(player, "skipFallDamage", true);
    stopPlayerSounds(player);
  }
}

async function tickTimedExit(player) {
  const timer = Number(playerState.get(player, "ticksUntilExit"));
  if (timer <= 0) return;
  const next = Math.max(0, timer - 1);
  playerState.set(player, "ticksUntilExit", next);
  if (next !== 0) return;
  const canonical = dimensions.canonicalId(player.dimension?.id);
  const realm = canonical.startsWith("thebrokenscript:") ? canonical.slice("thebrokenscript:".length) : canonical;
  if (!dimensions.ALL.includes(realm)) return;
  const shouldRestoreSpawn = dimensions.NIGHTMARES.includes(realm) || realm === "null_torture";
  await returnToOverworld(player, false, shouldRestoreSpawn ? 15 : 0);
}

function tickTrueEndGame(player) {
  let nearby = false;
  try {
    nearby = player.dimension.getEntities({
      type: "thebrokenscript:null_endgame",
      location: player.location,
      maxDistance: PLAYER_LIFECYCLE_SOURCE.trueEndGameRadius,
      closest: 1,
    }).length > 0;
  } catch (error) {
    operationDiagnostics.warnOnce("player_lifecycle.true_end_query", "TrueEndGame proximity query failed", error);
  }
  const step = trueEndGameStep({
    shutdown: playerState.get(player, "shutdown"),
    spawnedShutdownWindow: playerState.get(player, "spawnedShutdownWindow"),
    nullEndgameNearby: nearby,
  });
  setIfChanged(player, "shutdown", step.shutdown);
  setIfChanged(player, "spawnedShutdownWindow", step.spawnedShutdownWindow);
  if (step.showInitialAlert || step.showTerminalAlert) {
    safePlayerMessage(player, "LWJGL Alert", "UNHANDLED EXCEPTION -1");
  }
  if (step.forceSurvival) {
    try {
      const gameMode = player.getGameMode?.();
      if (gameMode === GameMode.Creative || gameMode === GameMode.Spectator) {
        player.setGameMode(GameMode.Survival);
      }
    } catch (error) {
      operationDiagnostics.warnOnce("player_lifecycle.true_end_gamemode", "TrueEndGame could not force survival mode", error);
    }
  }
}

async function tickPlayer(player) {
  tickSimpleTimer(player, "moonGlitchDuration");
  tickIsolation(player);
  tickSimpleTimer(player, "aberrationTimer", () => playerState.set(player, "aberrationEnabled", false));
  tickSimpleTimer(player, "screenDupeTimer", () => playerState.set(player, "enableScreenDupe", false));
  tickSimpleTimer(player, "invertTimer", () => playerState.set(player, "invertEnabled", false));
  tickSimpleTimer(player, "syncTimer", () => finishSyncTimer(player));
  await tickTimedExit(player);

  if (shouldClearDespawnEntitySwitch(playerState.get(player, "despawnEntitySwitch"), Math.random())) {
    playerState.set(player, "despawnEntitySwitch", false);
  }
  if (shouldClearSkipFallDamage(
    playerState.get(player, "skipFallDamage"),
    Number(system.currentTick ?? 0),
    standingOnAir(player),
  )) {
    playerState.set(player, "skipFallDamage", false);
  }
  const cooldown = Number(playerState.get(player, "baseRescanCooldown"));
  if (cooldown > 0) playerState.set(player, "baseRescanCooldown", Math.max(0, cooldown - 1));

  kickBannedPlayer(player);
  tickTrueEndGame(player);
  await tickDimensionTransitions(player);
}

export function onPlayerDimensionChange(player, toDimensionId) {
  if (!player) return;
  if (playerState.get(player, "fixPos")) {
    playerState.set(player, "skipFallDamage", true);
    playerState.set(player, "fixPos", false);
  }
  if (dimensions.canonicalId(toDimensionId ?? player.dimension?.id) === "overworld") {
    playerState.set(player, "ticksUntilExit", 0);
  }
}

export function begin(scheduler) {
  scheduler.every("tbs.playerLifecycle", 1, () => {
    for (const player of world.getAllPlayers()) {
      void tickPlayer(player).catch((error) => logger.error(`player lifecycle tick failed for ${player.name}`, error));
    }
  });
}
