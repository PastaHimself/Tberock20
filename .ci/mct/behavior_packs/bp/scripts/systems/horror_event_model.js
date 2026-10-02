// Pure selection model for the source StatisticsEventPicker contract.
//
// The production adapter supplies Math.random by default. Tests can inject a
// [0, 1) draw source to lock the Java-compatible draw order without changing
// the runtime probability distribution.

import { isEventEligible, selectWeightedEvent } from "./horror_rules.js";

/**
 * @param {{
 *   players?: Array<any>;
 *   eventDefinitions?: ReadonlyArray<any>;
 *   eventWeights?: Record<string, number>;
 *   getEventWeights?: () => Record<string, number>;
 *   eventFrequency?: number;
 *   arenaActive?: boolean;
 *   random01?: () => number;
 *   hasHandler?: (id: string) => boolean;
 *   buildContext?: (target: any, players: Array<any>, randomBoolean: boolean) => any;
 * }} [options]
 */
export function chooseHorrorEvent({
    players = [],
    eventDefinitions = [],
    eventWeights = {},
    getEventWeights,
    eventFrequency = 0,
    arenaActive = false,
    random01 = Math.random,
    hasHandler = () => true,
    buildContext = (_target, _players, randomBoolean) => ({ randomBoolean }),
} = {}) {
    const population = Array.isArray(players) ? players : [];
    if (population.length === 0) return { reason: "no-players", eligible: [] };
    if (arenaActive === true) return { reason: "arena", eligible: [] };

    // Java's StatisticsEventPicker performs this world-level gate before its
    // event random draw. Keep that order observable to deterministic tests.
    // Java rejects only values greater than the configured frequency; retain
    // the inclusive upper boundary for exact parity.
    if (random01() > eventFrequency) return { reason: "frequency", eligible: [] };

    const target = population[Math.floor(random01() * population.length)];
    if (!target) return { reason: "target", eligible: [] };

    const randomBoolean = random01() < 0.5;
    const context = buildContext(target, population, randomBoolean);
    if (!context || context.enabled === false) {
        return { reason: "disabled", target, context, eligible: [] };
    }

    const definitions = Array.isArray(eventDefinitions) ? eventDefinitions : [];
    const eligible = definitions.filter((definition) => (
            definition
            && hasHandler(definition.id)
            && isEventEligible(definition, context)
        ));
    if (eligible.length === 0) {
        return { reason: "no-eligible", target, context, eligible };
    }

    const weights = typeof getEventWeights === "function" ? getEventWeights() : eventWeights;
    const selected = selectWeightedEvent(eligible, weights, random01());
    return {
        reason: selected ? "selected" : "no-event",
        target,
        context,
        eligible,
        selected,
        weights,
    };
}
