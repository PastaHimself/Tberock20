// Boss-system hooks shared by the Integrity arena and boss-specific runtimes.
let arenaActive = false;
let arenaPhase1 = false;
let arenaParticipantIds = new Set();

export function setArenaState(active, phase1Active) {
    arenaActive = active === true;
    arenaPhase1 = phase1Active === true;
}

export function setArenaParticipants(ids = []) {
    arenaParticipantIds = new Set(
        Array.isArray(ids)
            ? ids.filter((id) => typeof id === "string" && id.length > 0)
            : [],
    );
}

export function clearArenaParticipants() {
    arenaParticipantIds.clear();
}

export function hasArenaParticipants() {
    return arenaParticipantIds.size > 0;
}

export function isArenaParticipant(entityOrId) {
    if (!hasArenaParticipants()) return true;
    const id = typeof entityOrId === "string" ? entityOrId : entityOrId?.id;
    return typeof id === "string" && arenaParticipantIds.has(id);
}

export function getArenaParticipantIds() {
    return [...arenaParticipantIds];
}

export function isArenaActive() {
    return arenaActive;
}

export function isArenaPhase1() {
    return arenaPhase1;
}
