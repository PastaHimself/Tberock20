import { logger } from "../core/logging.js";

// Source hook: LongExt.eventFrequency(gameTime) -> TBSEngineControl -> brokencore
// EventEngine. The exact source-side escalation curve still needs to be recovered;
// callers therefore retain the legacy zero fallback, but a missing provider is now
// observable instead of silently disabling escalation.
let frequencyFn = null;

export function setEventFrequencyProvider(fn) {
    if (typeof fn !== "function") throw new Error("event_frequency: provider must be a function");
    if (frequencyFn !== null) throw new Error("event_frequency: provider is already installed");
    frequencyFn = fn;
}

export function hasEventFrequencyProvider() {
    return frequencyFn !== null;
}

export function eventFrequency(gameTime) {
    if (frequencyFn === null) {
        logger.warnOnce(
            "event-frequency-provider-missing",
            "event_frequency: no escalation provider is installed; using zero contribution"
        );
        return 0;
    }

    const value = frequencyFn(gameTime);
    if (!Number.isFinite(value)) {
        logger.errorOnce(
            "event-frequency-provider-invalid-result",
            `event_frequency: provider returned non-finite contribution '${String(value)}'; using zero contribution`
        );
        return 0;
    }
    return value;
}
