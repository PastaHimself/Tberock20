const PREFIX = "[tbs]";

let debugEnabled = false;
const emittedOnce = new Set();

function stringifyError(err) {
    if (err === undefined || err === null) return "";
    if (typeof err === "string") return err;
    const stack = typeof err.stack === "string" ? `\n${err.stack}` : "";
    return `${err.name ?? "Error"}: ${err.message ?? String(err)}${stack}`;
}

function shouldEmitOnce(level, key) {
    const token = `${level}:${String(key)}`;
    if (emittedOnce.has(token)) return false;
    emittedOnce.add(token);
    return true;
}

export const logger = {
    setDebug(value) {
        debugEnabled = value === true;
    },
    isDebug() {
        return debugEnabled;
    },
    info(message) {
        console.log(`${PREFIX} ${message}`);
    },
    warn(message) {
        console.warn(`${PREFIX} ${message}`);
    },
    warnOnce(key, message) {
        if (shouldEmitOnce("warn", key)) console.warn(`${PREFIX} ${message}`);
    },
    error(message, err) {
        console.error(`${PREFIX} ${message}${err !== undefined ? ` :: ${stringifyError(err)}` : ""}`);
    },
    errorOnce(key, message, err) {
        if (shouldEmitOnce("error", key)) {
            console.error(`${PREFIX} ${message}${err !== undefined ? ` :: ${stringifyError(err)}` : ""}`);
        }
    },
    debug(message) {
        if (debugEnabled) console.log(`${PREFIX} [debug] ${message}`);
    }
};
