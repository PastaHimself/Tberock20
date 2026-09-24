import { logger } from "./logging.js";

export function attempt(context, fn) {
    try {
        return { ok: true, value: fn() };
    } catch (err) {
        logger.error(`attempt[${context}] failed`, err);
        return { ok: false, error: err };
    }
}

export function guard(context, fn) {
    return (...args) => {
        try {
            return fn(...args);
        } catch (err) {
            logger.error(`guard[${context}] suppressed error`, err);
        }
    };
}
