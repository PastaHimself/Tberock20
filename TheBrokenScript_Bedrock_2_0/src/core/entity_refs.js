import { world } from "@minecraft/server";

// Stable-ID entity reference registry. Never retain raw Entity objects across ticks.
const refs = new Map();

export function store(key, entity) {
    if (entity === undefined || !entity.isValid) return false;
    refs.set(key, { id: entity.id, dimension: entity.dimension.id });
    return true;
}

export function resolve(key) {
    const ref = refs.get(key);
    if (ref === undefined) return undefined;
    const entity = world.getEntity(ref.id);
    if (entity === undefined || !entity.isValid) {
        refs.delete(key);
        return undefined;
    }
    return entity;
}

export function peek(key) {
    return refs.get(key);
}

export function release(key) {
    return refs.delete(key);
}

export function releaseAll(prefix = "") {
    let n = 0;
    for (const k of [...refs.keys()]) {
        if (k.startsWith(prefix)) {
            refs.delete(k);
            n++;
        }
    }
    return n;
}

export function invalidateEntity(entityId) {
    for (const [k, ref] of [...refs.entries()]) {
        if (ref.id === entityId) refs.delete(k);
    }
}
