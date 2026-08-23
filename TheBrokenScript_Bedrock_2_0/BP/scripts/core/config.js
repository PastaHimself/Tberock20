const defaults = new Map();

export function registerDefaults(table) {
    for (const [key, def] of Object.entries(table)) {
        if (defaults.has(key)) {
            throw new Error(`config: duplicate default registration for '${key}'`);
        }
        const type = typeof def.value;
        if (type !== "string" && type !== "number" && type !== "boolean") {
            throw new Error(`config: default for '${key}' must be a primitive`);
        }
        defaults.set(key, { value: def.value, type, source: def.source ?? "unspecified" });
    }
}

export function get(key) {
    const stored = defaults.get(key);
    if (stored === undefined) {
        throw new Error(`config: unknown key '${key}' (register defaults before use)`);
    }
    return stored.value;
}

export function all() {
    const out = {};
    for (const [key, def] of defaults.entries()) {
        out[key] = { ...def };
    }
    return out;
}

export const config = { registerDefaults, get, all };
