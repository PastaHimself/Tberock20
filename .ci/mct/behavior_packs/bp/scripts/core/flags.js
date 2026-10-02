const KNOWN = ["customDimensionsBetaPath"];

const state = {
    customDimensionsBetaPath: false
};

export function set(name, value) {
    if (!KNOWN.includes(name)) {
        throw new Error(`flags: unknown flag '${name}'`);
    }
    state[name] = value === true;
}

export function isEnabled(name) {
    if (!KNOWN.includes(name)) {
        throw new Error(`flags: unknown flag '${name}'`);
    }
    return state[name];
}

export function assertStable(name) {
    if (isEnabled(name)) {
        throw new Error(
            `flags: subsystem '${name}' requires an experimental dependency and must be isolated behind its own module`
        );
    }
}
