/**
 * Source-backed, side-effect-free horror event contracts.
 *
 * The Java registry order is intentionally kept here so source/audit tests can
 * compare the runtime adapter without relying on the old approximation table.
 */
export const EVENT_TICKS_PER_DAY = 24000;
export const EVENT_CURVE_CUTOFF_DAYS = 55;
export const EVENT_CURVE_CAP_TICKS = 7;
export const BASE_EVENT_FREQUENCY = EVENT_CURVE_CAP_TICKS / EVENT_TICKS_PER_DAY;
export const MAX_EVENT_USE_COUNT = 1000000;

export const SOURCE_EVENT_IDS = Object.freeze([
  "bsod",
  "can_someone_hear_me",
  "close_menu",
  "damage",
  "doors",
  "explode_base",
  "eyes",
  "false_villager",
  "giift",
  "give_disc_11",
  "heartbeat",
  "hungry",
  "jframe_1",
  "jframe_2",
  "jframe_3",
  "jframe_4",
  "jframe_5",
  "lava_cast",
  "look_and_damage",
  "madness_1",
  "moon_glitch",
  "moon_phase",
  "noop",
  "null_book",
  "nulled_gui",
  "null_interface_trigger",
  "null_invade_base",
  "nullnullnull_advancement",
  "null_particle",
  "null_scare",
  "null_title",
  "obfuscated_sign",
  "opengl_error",
  "paranoia",
  "place_all_dead",
  "place_bedrock",
  "place_cave_air",
  "place_empty",
  "place_flowing_water",
  "place_hello",
  "place_lava",
  "place_netherrack",
  "place_oak_sign",
  "place_redstone_torch",
  "place_water",
  "play_sound",
  "push",
  "random_song",
  "reset_rotation",
  "set_do_daylight_cycle",
  "set_on_fire",
  "set_random_time_of_day",
  "set_time",
  "shadow_bug",
  "strike_lightning",
  "text",
  "why_cant_you_leave",
  "wrong_overlay",
  "hallucination",
  "title_event",
  "experience",
  "aberration",
  "breathe",
  "keep_playing",
  "null_whisper",
  "behind_you",
  "run",
  "cave",
  "null_is_near",
  "stare_at_player",
  "psst_event",
  "gamma",
  "null_getting_achievement",
  "rejoin",
  "sky_blue",
  "txt",
  "inventory_corruption",
  "door",
  "tbe_curious",
  "entity_discard",
  "stick",
  "coord",
  "screen_dupe",
  "isolation",
  "fake_disconnect",
  "collinlock",
]);

const NULL_EVENT_IDS = new Set([
  "giift", "lava_cast", "moon_glitch", "moon_phase", "coord",
  "opengl_error", "inventory_corruption", "txt", "place_water",
  "null_book", "null_invade_base", "null_is_near", "null_particle",
  "null_scare", "null_title", "null_whisper", "nulled_gui",
  "null_interface_trigger", "fake_disconnect", "tbe_curious",
]);
const RANDOM_EVENT_IDS = new Set(["door", "gamma", "run", "sky_blue", "stick", "rejoin", "isolation"]);
const SPECIAL_EVENT_CLASSES = new Map([
  ["nullnullnull_advancement", "CanHappenToNullEvent"],
  ["null_getting_achievement", "OnlyNullEvent"],
  ["collinlock", "FunnyEvent"],
]);

export function sourceEventClass(id, isNullProfile = false) {
  if (id === "false_villager" && isNullProfile) return "NullEvent";
  if (SPECIAL_EVENT_CLASSES.has(id)) return SPECIAL_EVENT_CLASSES.get(id);
  if (NULL_EVENT_IDS.has(id)) return "NullEvent";
  if (RANDOM_EVENT_IDS.has(id)) return "RandomEvent";
  return "TBSEvent";
}

export const SOURCE_EVENT_WEIGHTS = Object.freeze(
  Object.fromEntries(SOURCE_EVENT_IDS.map((id) => [id, id === "moon_phase" ? 5 : id === "isolation" ? 0 : 1])),
);

export const EVENT_CONTRACTS = Object.freeze(SOURCE_EVENT_IDS.map((id) => Object.freeze({
  id,
  handler: id,
  sourceClass: sourceEventClass(id),
  weight: SOURCE_EVENT_WEIGHTS[id],
  reroll: true,
})));

export const EVENT_CONTRACT_BY_ID = new Map(EVENT_CONTRACTS.map((entry) => [entry.id, entry]));

export function getEventContract(id) {
  return EVENT_CONTRACT_BY_ID.get(id);
}

export function eventCurveTicks(gameTime) {
  const days = Math.max(0, Number(gameTime) || 0) / EVENT_TICKS_PER_DAY;
  const quadratic = (0.03125 * days) ** 2;
  const curve = days < EVENT_CURVE_CUTOFF_DAYS
    ? quadratic
    : Math.log10(days + 1 - EVENT_CURVE_CUTOFF_DAYS) + ((0.03125 * EVENT_CURVE_CUTOFF_DAYS) ** 2);
  return Math.min(curve, EVENT_CURVE_CAP_TICKS);
}

export function sourceEventFrequencyContribution(gameTime) {
  return eventCurveTicks(gameTime) / EVENT_TICKS_PER_DAY - 2.9166666e-4;
}

export function sourceEventFrequency(gameTime) {
  return Math.max(0, Math.min(BASE_EVENT_FREQUENCY, sourceEventFrequencyContribution(gameTime) + BASE_EVENT_FREQUENCY));
}

function randomUnit(random) {
  const value = Number(random?.());
  return Number.isFinite(value) ? Math.max(0, Math.min(0.999999999, value)) : 0;
}

export function chooseRandomPlayer(players, random = Math.random) {
  if (!Array.isArray(players) || players.length === 0) return undefined;
  return players[Math.floor(randomUnit(random) * players.length)];
}

export function weightedPick(entries, useCounts = {}, random = Math.random) {
  if (!Array.isArray(entries) || entries.length === 0) return undefined;
  const weighted = entries.map((entry) => {
    const count = Number(useCounts?.[entry.id]);
    const timesUsed = Number.isFinite(count) ? Math.max(0, Math.floor(count)) : 0;
    return { entry, score: Math.max(0, Number(entry.weight) || 0) / Math.max(1, timesUsed) };
  });
  const total = weighted.reduce((sum, item) => sum + item.score, 0);
  if (total <= 0) return weighted[Math.floor(randomUnit(random) * weighted.length)].entry;
  let target = randomUnit(random) * total;
  for (const item of weighted) {
    target -= item.score;
    if (target < 0) return item.entry;
  }
  return weighted[weighted.length - 1].entry;
}

/**
 * @param {Record<string, unknown>} raw
 * @param {readonly (string | {id: string})[]} entriesOrIds
 * @param {number} max
 * @returns {Record<string, number>}
 */
export function normalizeEventUseCounts(raw, entriesOrIds = SOURCE_EVENT_IDS, max = MAX_EVENT_USE_COUNT) {
  const ids = entriesOrIds.map((entry) => {
    if (typeof entry === "string") return entry;
    return entry.id;
  });
  const result = {};
  for (const id of ids) {
    const number = Number(raw?.[id]);
    result[id] = Number.isFinite(number)
      ? Math.min(max, Math.max(0, Math.floor(number)))
      : 0;
  }
  return result;
}

export function incrementEventUseCount(useCounts, id, max = MAX_EVENT_USE_COUNT) {
  const current = Number(useCounts?.[id]);
  const next = Number.isFinite(current) ? Math.max(0, Math.floor(current)) + 1 : 1;
  return Math.min(max, next);
}

export function pickValidEvent(
  entries,
  useCounts = {},
  random = Math.random,
  isValid = (_entry) => true,
  maxAttempts = Math.max(1, entries?.length ?? 1),
) {
  const normalized = normalizeEventUseCounts(useCounts, entries ?? []);
  for (let attempts = 1; attempts <= maxAttempts; attempts += 1) {
    const entry = weightedPick(entries, normalized, random);
    if (!entry) return undefined;
    if (!isValid(entry)) continue;
    normalized[entry.id] = incrementEventUseCount(normalized, entry.id);
    return { entry, attempts, useCounts: normalized };
  }
  return undefined;
}
