export function intBetween(minInclusive, maxInclusive) {
    return Math.floor(Math.random() * (maxInclusive - minInclusive + 1)) + minInclusive;
}

export function chance(probability01) {
    return Math.random() < probability01;
}

export function chancePercent(percent0to100) {
    return Math.random() * 100 < percent0to100;
}

export function pick(list) {
    if (list.length === 0) throw new Error("random: cannot pick from empty list");
    return list[Math.floor(Math.random() * list.length)];
}

export function weightedPick(entries) {
    let total = 0;
    for (const e of entries) total += e.weight;
    if (total <= 0) throw new Error("random: weights must sum above zero");
    let roll = Math.random() * total;
    for (const e of entries) {
        roll -= e.weight;
        if (roll < 0) return e.value;
    }
    return entries[entries.length - 1].value;
}
