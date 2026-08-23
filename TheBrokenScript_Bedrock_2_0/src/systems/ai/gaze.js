const DEG = Math.PI / 180;

function normalize(v) {
    const len = Math.hypot(v.x, v.y, v.z);
    if (len === 0) return { x: 0, y: 0, z: 0 };
    return { x: v.x / len, y: v.y / len, z: v.z / len };
}

export function dot(a, b) {
    return a.x * b.x + a.y * b.y + a.z * b.z;
}

export function directionFromTo(from, to) {
    return normalize({ x: to.x - from.x, y: to.y - from.y, z: to.z - from.z });
}

// Approximates PlayerUtil.isLookingAtEntityHitbox: view-cone test whose half-angle
// widens as distance shrinks so close targets fill more of the screen (hitbox-like).
export function isLookingAtLocation(player, targetLocation, maxDegrees = 12) {
    const dist = Math.hypot(
        targetLocation.x - player.location.x,
        targetLocation.y - (player.location.y + 1.62),
        targetLocation.z - player.location.z
    );
    const extraDeg = dist < 16 ? (16 - dist) : 0;
    const limit = Math.cos((maxDegrees + extraDeg) * DEG);
    const view = player.getViewDirection();
    const to = directionFromTo({ x: player.location.x, y: player.location.y + 1.62, z: player.location.z }, targetLocation);
    return dot(view, to) >= limit;
}
