export function progressionPropertyKey(id) {
  return `tbs:adv_${String(id).replace(/[^a-zA-Z0-9_]/g, "_")}`;
}

export function progressionPlayerIdentity(player) {
  if (!player) return "";
  return String(player.id ?? player.name ?? "");
}

export function progressionCacheKey(player, id) {
  const identity = progressionPlayerIdentity(player);
  return identity && id ? `${identity}:${id}` : "";
}

export function hasPersistedAdvancement(player, id, cache) {
  const key = progressionCacheKey(player, id);
  if (!key) return false;
  if (cache?.has(key)) return true;

  const persisted = Boolean(player.getDynamicProperty(progressionPropertyKey(id)));
  if (persisted) cache?.add(key);
  return persisted;
}

export function persistAdvancement(player, id, cache) {
  const key = progressionCacheKey(player, id);
  if (!key) return false;
  if (hasPersistedAdvancement(player, id, cache)) return false;

  player.setDynamicProperty(progressionPropertyKey(id), true);
  cache?.add(key);
  return true;
}
