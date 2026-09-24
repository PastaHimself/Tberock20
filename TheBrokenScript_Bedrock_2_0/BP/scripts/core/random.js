/**
 * @param {number} minInclusive
 * @param {number} maxInclusive
 * @param {() => number} [random01]
 */
export function intBetween(minInclusive, maxInclusive, random01 = Math.random) {
    return Math.floor(random01() * (maxInclusive - minInclusive + 1)) + minInclusive;
}

/** @param {number} probability01 @param {() => number} [random01] */
export function chance(probability01, random01 = Math.random) {
    return random01() < probability01;
}

/** @param {number} percent0to100 @param {() => number} [random01] */
export function chancePercent(percent0to100, random01 = Math.random) {
    return random01() * 100 < percent0to100;
}

/** @param {Array<any>} list @param {() => number} [random01] */
export function pick(list, random01 = Math.random) {
    if (list.length === 0) throw new Error("random: cannot pick from empty list");
    return list[Math.floor(random01() * list.length)];
}

/** @param {Array<{value: any, weight: number}>} entries @param {() => number} [random01] */
export function weightedPick(entries, random01 = Math.random) {
    let total = 0;
    for (const e of entries) total += e.weight;
    if (total <= 0) throw new Error("random: weights must sum above zero");
    let roll = random01() * total;
    for (const e of entries) {
        roll -= e.weight;
        if (roll < 0) return e.value;
    }
    return entries[entries.length - 1].value;
}
