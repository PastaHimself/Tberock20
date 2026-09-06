import { config } from "../core/config.js";

config.registerDefaults({
    "events.enableRandomEvents": { value: true, source: "EventsConfig enableRandomEvents=true" },
    "events.rerollEvents": { value: true, source: "EventsConfig rerollEvents=true" },
    "events.eventDebug": { value: false, source: "EventsConfig eventDebug=!isProduction (release=false)" },
    "world.removeDeepslate": { value: true, source: "WorldConfig removeDeepslate=true" },
    "world.allowOldWorldGen": { value: true, source: "WorldConfig allowOldWorldGen=true" },
    "world.disableVoidHoles": { value: false, source: "WorldConfig disableVoidHoles=false" },
    "world.disableWorldEater": { value: false, source: "WorldConfig disableWorldEater=false" },
    "world.disableRandomStructures": { value: false, source: "WorldConfig disableRandomStructures=false" },
    "world.nightmareTeleportChance": { value: 10, source: "WorldConfig nightmareTeleportChance=10 (0..100)" },
    "world.disableSeedChanger": { value: false, source: "WorldConfig disableSeedChanger=false" },
    "world.allowCorruptedWorldGeneration": { value: false, source: "WorldConfig allowCorruptedWorldGeneration=false" },
    "world.allowChunkYOffsetGeneration": { value: false, source: "WorldConfig allowChunkYOffsetGeneration=false" },
    "danger.disableAttackCooldown": { value: true, source: "DangerConfig disableAttackCooldown=true" },
    "danger.disableSpawningEntities": { value: false, source: "DangerConfig disableSpawningEntities=false" },
    "danger.funnySetting": { value: false, source: "DangerConfig funnySetting=false" },
    "danger.showTriggerBlocks": { value: false, source: "DangerConfig showTriggerBlocks=!isProduction (release=false)" },
    "entity.disguisedCircuitEntityChance": { value: 0.001, source: "EntityConfig disguisedCircuitEntityChance=0.001" },
    "entity.disguisedCircuitOreChance": { value: 0.01, source: "EntityConfig disguisedCircuitOreChance=0.01" }
});
