const SOURCE_COMPARATOR_SIGNAL = 15;

export const BEDROCK_RECORD_COMPARATOR_SIGNAL = 13;

const definitions = [
  ["thebrokenscript:record_14", "BP/items/record_14.json", "record14", 61, "14"],
  ["thebrokenscript:record_15", "BP/items/record_15.json", "disc15_betray", 78, "(15) Betray"],
  ["thebrokenscript:record_16", "BP/items/record_16.json", "disc16_youcant", 98, "(16) You can't"],
  ["thebrokenscript:record_17", "BP/items/record_17.json", "disc17", 63.5, "(17) Silenced"],
  ["thebrokenscript:instability", "BP/items/instability.json", "instability", 233.5, "L0V3M1ST - Instability"],
  ["thebrokenscript:instability_music_box", "BP/items/instability_music_box.json", "instability_music_box", 179, "L0V3M1ST - Instability (Music Box)"],
  ["thebrokenscript:instabilityv2", "BP/items/instabilityv2.json", "instability_v2", 239, "L0V3M1ST - Instability V2"],
  ["thebrokenscript:instabilityv3", "BP/items/instabilityv3.json", "instability_v3", 278, "L0V3M1ST - Instability V3"],
  ["thebrokenscript:lilly", "BP/items/lilly.json", "lilly_theme", 208, "L0V3M1ST - Lilly's Theme"],
  ["thebrokenscript:lilly_v2", "BP/items/lilly_v2.json", "lilly_theme_v2", 204, "L0V3M1ST - Lilly's Theme V2"],
  ["thebrokenscript:credits", "BP/items/credits.json", "credits", 165, "RedstoneWizard08 - A Story Fractured"],
  ["thebrokenscript:attribute_mutilation", "BP/items/attribute_mutilation.json", "jimbob.full", 157, "TornadicPolarity - Attribute Mutilation"],
].map(([itemId, itemPath, soundEvent, durationSeconds, description]) => Object.freeze({
  itemId,
  itemPath,
  soundEvent,
  durationSeconds,
  description,
  sourceComparatorSignal: SOURCE_COMPARATOR_SIGNAL,
}));

export const SOURCE_MUSIC_DISCS = Object.freeze(definitions);

export function musicDiscDefinition(itemId) {
  const definition = SOURCE_MUSIC_DISCS.find((entry) => entry.itemId === itemId);
  if (!definition) throw new Error(`Unknown music disc: ${itemId}`);
  return definition;
}

export function bedrockRecordComponent(itemId) {
  const definition = musicDiscDefinition(itemId);
  return {
    comparator_signal: BEDROCK_RECORD_COMPARATOR_SIGNAL,
    duration: definition.durationSeconds,
    sound_event: definition.soundEvent,
  };
}
