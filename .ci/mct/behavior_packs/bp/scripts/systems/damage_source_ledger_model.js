// Pure bounded ledger primitives for the Java custom-damage metadata that
// Bedrock cannot expose through EntityHurt events. Each target keeps an
// ordered list so same-tick hits from different sources do not overwrite one
// another before the combat adapter can consume them.

export const DAMAGE_LEDGER_MAX_ENTRIES_PER_TARGET = 32;

function cloneEntry(entry) {
  return { ...entry };
}

export function appendDamageLedgerEntry(ledger, targetId, entry) {
  if (!(ledger instanceof Map) || typeof targetId !== "string" || !targetId) return;
  const entries = ledger.get(targetId) ?? [];
  entries.push(cloneEntry(entry));
  ledger.set(targetId, entries.slice(-DAMAGE_LEDGER_MAX_ENTRIES_PER_TARGET));
}

export function getDamageLedgerEntries(ledger, targetId, currentTick, maxAgeTicks = 1) {
  if (!(ledger instanceof Map) || typeof targetId !== "string" || !targetId) return [];
  const entries = ledger.get(targetId) ?? [];
  const age = Number.isFinite(maxAgeTicks) && maxAgeTicks >= 0 ? maxAgeTicks : 1;
  const fresh = entries.filter((entry) => (
    Number.isFinite(entry?.tick)
      && Number.isFinite(currentTick)
      && currentTick - entry.tick <= age
  ));
  if (fresh.length === 0) ledger.delete(targetId);
  else if (fresh.length !== entries.length) ledger.set(targetId, fresh);
  return fresh.map(cloneEntry);
}

export function getLatestDamageLedgerEntry(ledger, targetId, currentTick, maxAgeTicks = 1) {
  const entries = getDamageLedgerEntries(ledger, targetId, currentTick, maxAgeTicks);
  return entries.at(-1) ?? null;
}

export function pruneDamageLedger(ledger, currentTick, maxAgeTicks = 1) {
  if (!(ledger instanceof Map)) return;
  for (const targetId of [...ledger.keys()]) {
    getDamageLedgerEntries(ledger, targetId, currentTick, maxAgeTicks);
  }
}
