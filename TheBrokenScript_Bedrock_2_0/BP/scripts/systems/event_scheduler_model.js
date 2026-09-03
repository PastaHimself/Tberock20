// Pure source-backed model for the random-event engine.
// Runtime persistence and Bedrock API calls stay in horror_events.js.

export const TICKS_PER_DAY = 24000;
export const EVENT_CUTOFF_DAYS = 55;
export const MAX_EVENT_CURVE = 7;
export const DEFAULT_EVENT_FREQUENCY = 2.9166666e-4;

function quadCurve(x) {
  return (0.03125 * x) ** 2;
}

function logCurve(x) {
  return Math.log10(x + 1 - EVENT_CUTOFF_DAYS) + quadCurve(EVENT_CUTOFF_DAYS);
}

function evaluatedCurve(x) {
  return Math.min(x < EVENT_CUTOFF_DAYS ? quadCurve(x) : logCurve(x), MAX_EVENT_CURVE);
}

/** Mirrors TBSEngineControl.Companion.eventFrequency(gameTime). */
export function sourceEventFrequency(gameTime) {
  const ticks = Number(gameTime);
  if (!Number.isFinite(ticks)) return -DEFAULT_EVENT_FREQUENCY;
  return evaluatedCurve(ticks / TICKS_PER_DAY) / TICKS_PER_DAY - DEFAULT_EVENT_FREQUENCY;
}

/** Mirrors EngineControl's default controller plus the TBS controller. */
export function aggregateEventFrequency(gameTime) {
  return DEFAULT_EVENT_FREQUENCY + sourceEventFrequency(gameTime);
}

function normalizedRoll(roll) {
  const value = Number(roll);
  if (!Number.isFinite(value) || value <= 0) return 0;
  return value >= 1 ? 0.9999999999999999 : value;
}

function eventWeight(event, counts) {
  const weight = Number(event?.weight);
  const baseWeight = Number.isFinite(weight) && weight > 0 ? weight : 0;
  const rawCount = Number(counts[event.id]);
  const count = Number.isFinite(rawCount) && rawCount > 0 ? rawCount : 1;
  return baseWeight / count;
}

function selectableEvents(events, disabledEventIds) {
  const disabled = new Set(disabledEventIds ?? []);
  return events.filter((event) => event && typeof event.id === "string" && !disabled.has(event.id));
}

function weightedPick(events, roll, counts, disabledEventIds) {
  const selectable = selectableEvents(events, disabledEventIds);
  if (selectable.length === 0) return null;

  const total = selectable.reduce((sum, event) => sum + eventWeight(event, counts), 0);
  if (!(total > 0)) {
    return selectable[Math.floor(normalizedRoll(roll) * selectable.length)] ?? null;
  }

  let remaining = normalizedRoll(roll) * total;
  for (const event of selectable) {
    remaining -= eventWeight(event, counts);
    if (remaining <= 0) return event;
  }
  return selectable[selectable.length - 1] ?? null;
}

/**
 * Selects an executable event and returns the updated persistent counts.
 * `rolls` makes the model deterministic for tests; runtime supplies random rolls.
 */
export function pickEvent(events, {
  rolls = [0],
  counts = {},
  disabledEventIds = [],
  rerollEvents = true,
  canExecute = (_event) => true,
} = {}) {
  const nextCounts = { ...counts };
  const maxAttempts = Math.max(1, events.length + 1);
  let attempts = 0;
  let rollIndex = 0;

  while (attempts < maxAttempts) {
    const roll = rolls[rollIndex] ?? rolls[rolls.length - 1] ?? 0;
    rollIndex += 1;
    const event = weightedPick(events, roll, nextCounts, disabledEventIds);
    if (!event) return { event: null, counts: nextCounts, attempts };

    attempts += 1;
    if (canExecute(event)) {
      const current = Number(nextCounts[event.id]);
      nextCounts[event.id] = (Number.isFinite(current) && current > 0 ? current : 1) + 1;
      return { event, counts: nextCounts, attempts };
    }
    if (!rerollEvents) return { event: null, counts: nextCounts, attempts };
  }

  return { event: null, counts: nextCounts, attempts };
}
