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
