export function applyEffect(player, effectName, durationTicks, options = {}) {
    player.addEffect(effectName, durationTicks, {
        amplifier: options.amplifier ?? 0,
        showParticles: options.showParticles ?? false
    });
}

export function darkness(player, seconds = 5) {
    applyEffect(player, "darkness", seconds * 20);
}

export function blindness(player, seconds = 5) {
    applyEffect(player, "blindness", seconds * 20);
}
