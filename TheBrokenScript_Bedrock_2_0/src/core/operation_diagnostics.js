import { logger } from "./logging.js";

function stableKey(key) {
    return `operation:${String(key)}`;
}

export function warnOnce(key, message, error) {
    logger.warnOnce(stableKey(key), message, error);
}

export function errorOnce(key, message, error) {
    logger.errorOnce(stableKey(key), message, error);
}

export function tryWarnOnce(key, operation, fallback, message = `operation '${key}' failed`) {
    try {
        return operation();
    } catch (error) {
        warnOnce(key, message, error);
        return fallback;
    }
}

export function tryErrorOnce(key, operation, fallback, message = `operation '${key}' failed`) {
    try {
        return operation();
    } catch (error) {
        errorOnce(key, message, error);
        return fallback;
    }
}
