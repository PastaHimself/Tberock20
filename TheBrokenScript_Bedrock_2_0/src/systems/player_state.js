import * as state from "../core/state.js";

const DEFAULTS = {
    dataVersion: 2,
    spawnPosX: 0,
    spawnPosY: 0,
    spawnPosZ: 0,
    hasPlayedCreepyDisc: false,
    entityReputation: 50,
    lastRepInteraction: "",
    noWayOutFrame: 0,
    vhsEnabled: false,
    pixelateEnabled: false,
    aberrationEnabled: false,
    moonGlitchDuration: 0,
    ticksUntilExit: 0,
    syncTimer: 0,
    showCoords: false,
    isDesync: false,
    lookedAtOblit: false,
    titleName: "",
    fov: 0,
    ban: false,
    fixPos: false,
    textGlitchStrength: 0,
    aberrationTimer: 0,
    enableCustomSky: false,
    customSkyR: 0,
    customSkyG: 0,
    customSkyB: 0,
    showSkyBlue: false,
    cameraMode: "FIRST_PERSON",
    skipFallDamage: false,
    enableScreenDupe: false,
    teleportCounter: 0,
    musicTimer: 0,
    despawnEntitySwitch: false,
    lastTeleport: 0,
    lastClanVoidTeleport: 0,
    nullFlyRepGainTimer: 0,
    screenDupeTimer: 0,
    triangleKickTimer: 0,
    baseRescanCooldown: 0,
    musicCausedByTBS: false,
    feverMessageProgression: 0,
    invertEnabled: false,
    invertTimer: 0,
    lastX: 0,
    lastZ: 0,
    currentX: 0,
    currentZ: 0,
    sawTxtHint: false,
    userDir: "",
    isolationActive: false,
    isolationTimer: 0,
    forceMetaParanoia: false,
    loadingPhase2: false,
    loadingPhase3: false,
    glitchesEnabled: false,
    dreamEnabled: false,
    voidBox: true
};

export const MOON_GLITCH_DURATION_SECS = 80;
export const MOON_GLITCH_DURATION_TICKS = 1600;

export function get(player, key) {
    const v = state.getPlayer(player, `pv.${key}`, undefined);
    if (v === undefined) {
        if (!(key in DEFAULTS)) throw new Error(`player_state: unknown key '${key}'`);
        return DEFAULTS[key];
    }
    return v;
}

export function set(player, key, value) {
    if (!(key in DEFAULTS)) throw new Error(`player_state: unknown key '${key}'`);
    state.setPlayer(player, `pv.${key}`, value);
}

export function update(player, key, fn) {
    set(player, key, fn(get(player, key)));
}

export function isMetaParanoia(player) {
    return (
        get(player, "forceMetaParanoia") ||
        get(player, "isDesync") ||
        get(player, "lookedAtOblit")
    );
}

export function setMoonGlitch(player, enabled) {
    set(player, "moonGlitchDuration", enabled ? MOON_GLITCH_DURATION_TICKS : 0);
}
