// Boss-system hooks. Real values are wired by the bosses chunk (Chunk 07);
// before that the arena simply does not exist, matching a fresh world.
let arenaActive = false;
let arenaPhase1 = false;

export function setArenaState(active, phase1Active) {
    arenaActive = active === true;
    arenaPhase1 = phase1Active === true;
}

export function isArenaActive() {
    return arenaActive;
}

export function isArenaPhase1() {
    return arenaPhase1;
}
