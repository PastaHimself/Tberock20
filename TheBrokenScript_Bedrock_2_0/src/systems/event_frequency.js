// Event-frequency hook. Source: LongExt.eventFrequency(gameTime) ->
// TBSEngineControl.Companion.eventFrequency, backed by the brokencore EventEngine
// (ported with the events chunk). Until then the frequency bonus is 0, which
// matches a fresh world before the engine escalates.
let frequencyFn = null;

export function setEventFrequencyProvider(fn) {
    if (typeof fn !== "function") throw new Error("event_frequency: provider must be a function");
    frequencyFn = fn;
}

export function eventFrequency(gameTime) {
    if (frequencyFn === null) return 0;
    return frequencyFn(gameTime);
}
