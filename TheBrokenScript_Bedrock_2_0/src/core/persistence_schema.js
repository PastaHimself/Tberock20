const INT_MAX = 2147483647;

export const CORE_SCHEMA_VERSION = 2;

function dynamic(javaField, type, defaultValue) {
    return Object.freeze({
        javaField,
        type,
        storage: "dynamic",
        reset: "never",
        default: defaultValue,
    });
}

function json(javaField, defaultValue) {
    return Object.freeze({
        javaField,
        type: "json",
        storage: "json",
        reset: "never",
        default: defaultValue,
    });
}

function extra(type, defaultValue) {
    return Object.freeze({
        javaField: undefined,
        type,
        storage: "dynamic",
        reset: "never",
        default: defaultValue,
    });
}

function cloneDefault(value) {
    if (Array.isArray(value)) return value.map(cloneDefault);
    if (value && typeof value === "object") {
        return Object.fromEntries(Object.entries(value).map(([key, child]) => [key, cloneDefault(child)]));
    }
    return value;
}

function defaultsFor(schema) {
    return Object.freeze(
        Object.fromEntries(
            Object.entries(schema).map(([key, descriptor]) => [key, cloneDefault(descriptor.default)]),
        ),
    );
}

function defaultsForStorage(schema, storage) {
    return defaultsFor(
        Object.fromEntries(
            Object.entries(schema).filter(([, descriptor]) => descriptor.storage === storage),
        ),
    );
}

function javaFieldsFor(schema) {
    const fields = {};
    for (const [bedrockKey, descriptor] of Object.entries(schema)) {
        if (!descriptor.javaField) continue;
        const current = fields[descriptor.javaField];
        fields[descriptor.javaField] = current === undefined
            ? bedrockKey
            : Array.isArray(current)
                ? [...current, bedrockKey]
                : [current, bedrockKey];
    }
    return Object.freeze(fields);
}

export const WORLD_STATE_SCHEMA = Object.freeze({
    dataVersion: dynamic("dataVersion", "number", 3),
    hasNullSpawned: dynamic("hasNullSpawned", "boolean", false),
    hasSiluetSpawned: dynamic("hasSiluetSpawned", "boolean", false),
    isFirstJoin: dynamic("isFirstJoin", "boolean", true),
    hasGeneratedNullDimension: dynamic("hasGeneratedNullDimension", "boolean", false),
    hasCircuitSpawned: dynamic("hasCircuitSpawned", "boolean", false),
    hasTheBrokenEndSpawned: dynamic("hasTheBrokenEndSpawned", "boolean", false),
    hasGeneratedClanBuildDimension: dynamic("hasGeneratedClanBuildDimension", "boolean", false),
    daylightCycle: dynamic("daylightCycle", "boolean", true),
    daylightCycleEventTimer: dynamic("daylightCycleEventTimer", "number", 0),
    hasTriggeredRam2Die: dynamic("hasTriggeredRam2Die", "boolean", false),
    hasRam2DieJoined: dynamic("hasRam2DieJoined", "boolean", false),
    hasVoidSpawned: dynamic("hasVoidSpawned", "boolean", false),
    isNullHere: dynamic("isNullHere", "boolean", false),
    firstJoinTimer: dynamic("firstJoinTimer", "number", 0),
    scheduled: dynamic("scheduled", "boolean", false),
    joinTimerTicking: dynamic("joinTimerTicking", "boolean", false),
    hasBuiltHerobrineShrine: dynamic("hasBuiltHerobrineShrine", "boolean", false),
    moonStage: dynamic("moonStage", "number", 0),
    moonShouldChange: dynamic("moonShouldChange", "boolean", false),
    moonTextureIndex: dynamic("moonTextureIndex", "number", -1),
    moonShouldCrack: dynamic("moonShouldCrack", "boolean", false),
    moonCrackIndex: dynamic("moonCrackIndex", "number", -1),
    soundPlayed: dynamic("soundPlayed", "boolean", false),
    hasMoonCorrupted: dynamic("hasMoonCorrupted", "boolean", false),
    isFlat: dynamic("isFlat", "boolean", false),
    fracturedFightActive: dynamic("fracturedFightActive", "boolean", false),
    canFracturedSpawn: dynamic("canFracturedSpawn", "boolean", false),
    code: dynamic("code", "string", ""),
    codeApplied: dynamic("codeApplied", "boolean", false),
    bossStructX: dynamic("bossStructX", "number", INT_MAX),
    bossStructZ: dynamic("bossStructZ", "number", INT_MAX),
    clanVoidX: dynamic("clanVoidX", "number", INT_MAX),
    clanVoidZ: dynamic("clanVoidZ", "number", INT_MAX),
    mazeFloorX: dynamic("mazeFloorX", "number", INT_MAX),
    mazeFloorZ: dynamic("mazeFloorZ", "number", INT_MAX),
    woodenFloorX: dynamic("woodenFloorX", "number", INT_MAX),
    woodenFloorZ: dynamic("woodenFloorZ", "number", INT_MAX),
    stoneFloorX: dynamic("stoneFloorX", "number", INT_MAX),
    stoneFloorZ: dynamic("stoneFloorZ", "number", INT_MAX),
    dayAX: dynamic("dayAX", "number", INT_MAX),
    dayAZ: dynamic("dayAZ", "number", INT_MAX),
    placedStructure: dynamic("placedStructure", "boolean", false),
    craftedPolaroid: dynamic("craftedPolaroid", "boolean", false),
    inventoryCorruption: dynamic("inventoryCorruption", "number", 0),
    inventoryCorruptionProgressed: dynamic("inventoryCorruptionProgressed", "boolean", false),
    entitySpawnDelay: dynamic("entitySpawnDelay", "number", 0),
    circuitSpawnDelay: dynamic("circuitSpawnDelay", "number", 0),
    oblitSpawnDelay: dynamic("oblitSpawnDelay", "number", 0),
    tbeSpawnDelay: dynamic("tbeSpawnDelay", "number", 0),
    rareSpawnDelay: dynamic("rareSpawnDelay", "number", 0),
    nullSpawnDelay: dynamic("nullSpawnDelay", "number", 0),
    curvedSpawnDelay: dynamic("curvedSpawnDelay", "number", 0),
    eerieNoiseDelay: dynamic("eerieNoiseDelay", "number", 0),
    herobrineDelay: dynamic("herobrineDelay", "number", 0),
    circuitInhabitedDelay: dynamic("circuitInhabitedDelay", "number", 0),
    commandBlockX: dynamic("commandBlockLocation", "number", 0),
    commandBlockY: dynamic("commandBlockLocation", "number", 0),
    commandBlockZ: dynamic("commandBlockLocation", "number", 0),
});

export const WORLD_EXTRA_SCHEMA = Object.freeze({
    nullBookGiven: extra("boolean", false),
});

export const PLAYER_STATE_SCHEMA = Object.freeze({
    dataVersion: dynamic("dataVersion", "number", 2),
    spawnPos: dynamic("spawnPos", "vector3", { x: 0, y: 0, z: 0 }),
    hasPlayedCreepyDisc: dynamic("hasPlayedCreepyDisc", "boolean", false),
    entityReputation: dynamic("entityReputation", "number", 50),
    lastRepInteraction: dynamic("lastRepInteraction", "string", ""),
    noWayOutFrame: dynamic("noWayOutFrame", "number", 0),
    vhsEnabled: dynamic("vhsEnabled", "boolean", false),
    pixelateEnabled: dynamic("pixelateEnabled", "boolean", false),
    aberrationEnabled: dynamic("aberrationEnabled", "boolean", false),
    moonGlitchDuration: dynamic("moonGlitchDuration", "number", 0),
    ticksUntilExit: dynamic("ticksUntilExit", "number", 0),
    syncTimer: dynamic("syncTimer", "number", 0),
    showCoords: dynamic("showCoords", "boolean", false),
    isDesync: dynamic("isDesync", "boolean", false),
    lookedAtOblit: dynamic("lookedAtOblit", "boolean", false),
    titleName: dynamic("titleName", "string", ""),
    fov: dynamic("fov", "number", 0),
    ban: dynamic("ban", "boolean", false),
    fixPos: dynamic("fixPos", "boolean", false),
    textGlitchStrength: dynamic("textGlitchStrength", "number", 0),
    aberrationTimer: dynamic("aberrationTimer", "number", 0),
    enableCustomSky: dynamic("enableCustomSky", "boolean", false),
    customSkyColor: dynamic("customSkyColor", "vector3", { x: 0, y: 0, z: 0 }),
    showSkyBlue: dynamic("showSkyBlue", "boolean", false),
    cameraMode: dynamic("cameraMode", "string", "FIRST_PERSON"),
    skipFallDamage: dynamic("skipFallDamage", "boolean", false),
    enableScreenDupe: dynamic("enableScreenDupe", "boolean", false),
    teleportCounter: dynamic("teleportCounter", "number", 0),
    musicTimer: dynamic("musicTimer", "number", 0),
    despawnEntitySwitch: dynamic("despawnEntitySwitch", "boolean", false),
    lastTeleport: dynamic("lastTeleport", "number", 0),
    lastClanVoidTeleport: dynamic("lastClanVoidTeleport", "number", 0),
    nullFlyRepGainTimer: dynamic("nullFlyRepGainTimer", "number", 0),
    screenDupeTimer: dynamic("screenDupeTimer", "number", 0),
    triangleKickTimer: dynamic("triangleKickTimer", "number", 0),
    baseRescanCooldown: dynamic("baseRescanCooldown", "number", 0),
    musicCausedByTBS: dynamic("musicCausedByTBS", "boolean", false),
    feverMessageProgression: dynamic("feverMessageProgression", "number", 0),
    invertEnabled: dynamic("invertEnabled", "boolean", false),
    invertTimer: dynamic("invertTimer", "number", 0),
    lastX: dynamic("lastX", "number", 0),
    lastZ: dynamic("lastZ", "number", 0),
    currentX: dynamic("currentX", "number", 0),
    currentZ: dynamic("currentZ", "number", 0),
    sawTxtHint: dynamic("sawTxtHint", "boolean", false),
    userDir: dynamic("userDir", "string", ""),
    doors: json("doors", []),
    isolationActive: dynamic("isolationActive", "boolean", false),
    isolationTimer: dynamic("isolationTimer", "number", 0),
    isolationAllowedUsers: json("isolationAllowedUsers", []),
    forceMetaParanoia: dynamic("forceMetaParanoia", "boolean", false),
    loadingPhase2: dynamic("loadingPhase2", "boolean", false),
    loadingPhase3: dynamic("loadingPhase3", "boolean", false),
    glitchesEnabled: dynamic("glitchesEnabled", "boolean", false),
    dreamEnabled: dynamic("dreamEnabled", "boolean", false),
    voidBox: dynamic("voidBox", "boolean", true),
});

export const PLAYER_EXTRA_SCHEMA = Object.freeze({
    // Bedrock-only delivery ledger for the one-shot story book adapter.
    nullBookDelivered: extra("boolean", false),
});

export const PLAYER_COMPATIBILITY_DEFAULTS = Object.freeze({
    // Kept readable so worlds made before vector parity was added can migrate
    // without losing the old scalar representation.
    spawnPosX: 0,
    spawnPosY: 0,
    spawnPosZ: 0,
    customSkyR: 0,
    customSkyG: 0,
    customSkyB: 0,
});

export const WORLD_DEFAULTS = defaultsFor(WORLD_STATE_SCHEMA);
export const WORLD_EXTRA_DEFAULTS = defaultsFor(WORLD_EXTRA_SCHEMA);
export const PLAYER_DEFAULTS = defaultsFor(PLAYER_STATE_SCHEMA);
export const PLAYER_DYNAMIC_DEFAULTS = defaultsForStorage(PLAYER_STATE_SCHEMA, "dynamic");
export const PLAYER_EXTRA_DEFAULTS = defaultsFor(PLAYER_EXTRA_SCHEMA);
export const PLAYER_JSON_DEFAULTS = Object.freeze({
    doors: cloneDefault(PLAYER_STATE_SCHEMA.doors.default),
    isolationAllowedUsers: cloneDefault(PLAYER_STATE_SCHEMA.isolationAllowedUsers.default),
});
export const JAVA_WORLD_FIELDS = javaFieldsFor(WORLD_STATE_SCHEMA);
export const JAVA_PLAYER_FIELDS = javaFieldsFor(PLAYER_STATE_SCHEMA);

export function applyMissingDefaults(defaults, read, write) {
    const written = [];
    for (const [key, value] of Object.entries(defaults)) {
        if (read(key) !== undefined) continue;
        const next = cloneDefault(value);
        write(key, next);
        written.push(key);
    }
    return written;
}

function matchesDescriptor(descriptor, value) {
    if (value === undefined) return false;
    if (descriptor.type === "boolean") return typeof value === "boolean";
    if (descriptor.type === "string") return typeof value === "string";
    if (descriptor.type === "number") return typeof value === "number" && Number.isFinite(value);
    if (descriptor.type === "vector3") {
        return value !== null && typeof value === "object" &&
            Number.isFinite(value.x) && Number.isFinite(value.y) && Number.isFinite(value.z);
    }
    if (descriptor.type === "json") {
        if (Array.isArray(descriptor.default)) return Array.isArray(value);
        if (descriptor.default !== null && typeof descriptor.default === "object") {
            return value !== null && typeof value === "object" && !Array.isArray(value);
        }
        return value !== null;
    }
    return false;
}

export function applySchemaDefaults(schema, read, write) {
    const written = [];
    for (const [key, descriptor] of Object.entries(schema)) {
        if (matchesDescriptor(descriptor, read(key))) continue;
        const next = cloneDefault(descriptor.default);
        write(key, next);
        written.push(key);
    }
    return written;
}

export function migrateCoreSchema(current, write, now, shouldWriteFirstInit = true) {
    if (current === undefined) {
        write("schema", CORE_SCHEMA_VERSION);
        if (shouldWriteFirstInit) write("firstInit", now);
        return "first-init";
    }
    if (!Number.isInteger(current) || current < 0) {
        throw new Error(`state: invalid schema version '${current}'`);
    }
    if (current > CORE_SCHEMA_VERSION) {
        throw new Error(`state: schema version ${current} is newer than supported ${CORE_SCHEMA_VERSION}`);
    }
    if (current < CORE_SCHEMA_VERSION) {
        write("schema", CORE_SCHEMA_VERSION);
        return "migrated";
    }
    return "current";
}
