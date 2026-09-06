const PREFIX = "[tbs]";

let debugEnabled = false;

function stringifyError(err) {
    if (err === undefined || err === null) return "";
    if (typeof err === "string") return err;
    const stack = typeof err.stack === "string" ? `\n${err.stack}` : "";
    return `${err.name ?? "Error"}: ${err.message ?? String(err)}${stack}`;
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
    error(message, err) {
        console.error(`${PREFIX} ${message}${err !== undefined ? ` :: ${stringifyError(err)}` : ""}`);
    },
    debug(message) {
        if (debugEnabled) console.log(`${PREFIX} [debug] ${message}`);
    }
};
