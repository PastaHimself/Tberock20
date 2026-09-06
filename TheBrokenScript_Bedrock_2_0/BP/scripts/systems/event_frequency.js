// Event-frequency hook. Source: LongExt.eventFrequency(gameTime) ->
// TBSEngineControl.Companion.eventFrequency. The runtime scheduler uses the
// aggregate default-controller-plus-TBS probability from the same model.
import { sourceEventFrequency } from "./event_scheduler_model.js";

let frequencyFn = null;

export function setEventFrequencyProvider(fn) {
    if (typeof fn !== "function") throw new Error("event_frequency: provider must be a function");
    frequencyFn = fn;
}

export function eventFrequency(gameTime) {
    if (frequencyFn === null) return sourceEventFrequency(gameTime);
    return frequencyFn(gameTime);
}
