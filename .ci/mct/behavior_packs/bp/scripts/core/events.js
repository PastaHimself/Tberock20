import { logger } from "./logging.js";

const subscriptions = new Map();

export function subscribe(signal, key, handler) {
    if (subscriptions.has(key)) {
        throw new Error(`events: duplicate subscription '${key}'`);
    }
    signal.subscribe(handler);
    subscriptions.set(key, () => signal.unsubscribe(handler));
}

export function subscribeGuarded(signal, key, context, handler) {
    if (subscriptions.has(key)) {
        throw new Error(`events: duplicate subscription '${key}'`);
    }
    const wrapped = (...args) => {
        try {
            handler(...args);
        } catch (err) {
            logger.error(`events[${key}/${context}] suppressed error`, err);
        }
    };
    signal.subscribe(wrapped);
    subscriptions.set(key, () => signal.unsubscribe(wrapped));
}

export function unsubscribe(key) {
    const off = subscriptions.get(key);
    if (off === undefined) return false;
    off();
    subscriptions.delete(key);
    return true;
}

export function unsubscribeAll() {
    for (const off of subscriptions.values()) off();
    subscriptions.clear();
}

export function registeredKeys() {
    return [...subscriptions.keys()];
}
