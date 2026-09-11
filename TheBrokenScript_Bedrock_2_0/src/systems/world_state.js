import * as state from "../core/state.js";

export const INT_MAX = 2147483647;

const DEFAULTS = {
    dataVersion: 3,
    hasNullSpawned: false,
    hasSiluetSpawned: false,
    isFirstJoin: true,
    hasGeneratedNullDimension: false,
    hasCircuitSpawned: false,
    hasTheBrokenEndSpawned: false,
    hasGeneratedClanBuildDimension: false,
    daylightCycle: true,
    daylightCycleEventTimer: 0,
    hasTriggeredRam2Die: false,
    hasRam2DieJoined: false,
    hasVoidSpawned: false,
    isNullHere: false,
    firstJoinTimer: 0,
    scheduled: false,
    joinTimerTicking: false,
    hasBuiltHerobrineShrine: false,
    moonStage: 0,
    moonShouldChange: false,
    moonTextureIndex: -1,
    moonShouldCrack: false,
    moonCrackIndex: -1,
    soundPlayed: false,
    hasMoonCorrupted: false,
    isFlat: false,
    fracturedFightActive: false,
    canFracturedSpawn: false,
    code: "",
    codeApplied: false,
    bossStructX: INT_MAX,
    bossStructZ: INT_MAX,
    clanVoidX: INT_MAX,
    clanVoidZ: INT_MAX,
    mazeFloorX: INT_MAX,
    mazeFloorZ: INT_MAX,
    woodenFloorX: INT_MAX,
    woodenFloorZ: INT_MAX,
    stoneFloorX: INT_MAX,
    stoneFloorZ: INT_MAX,
    dayAX: INT_MAX,
    dayAZ: INT_MAX,
    placedStructure: false,
    craftedPolaroid: false,
    inventoryCorruption: 0,
    inventoryCorruptionProgressed: false,
    entitySpawnDelay: 0,
    circuitSpawnDelay: 0,
    oblitSpawnDelay: 0,
    tbeSpawnDelay: 0,
    rareSpawnDelay: 0,
    nullSpawnDelay: 0,
    curvedSpawnDelay: 0,
    eerieNoiseDelay: 0,
    herobrineDelay: 0,
    circuitInhabitedDelay: 0,
    commandBlockX: 0,
    commandBlockY: 0,
    commandBlockZ: 0,
    nullBookGiven: false
};

export function init() {
    for (const [key, value] of Object.entries(DEFAULTS)) {
        const propertyKey = `mv.${key}`;
        if (state.getWorld(propertyKey, undefined) === undefined) {
            state.setWorld(propertyKey, value);
        }
    }
}

export function get(key) {
    const v = state.getWorld(`mv.${key}`, undefined);
    if (v === undefined) {
        if (!(key in DEFAULTS)) throw new Error(`world_state: unknown key '${key}'`);
        return DEFAULTS[key];
    }
    return v;
}

export function set(key, value) {
    if (!(key in DEFAULTS)) throw new Error(`world_state: unknown key '${key}'`);
    state.setWorld(`mv.${key}`, value);
}

export function update(key, fn) {
    set(key, fn(get(key)));
}
