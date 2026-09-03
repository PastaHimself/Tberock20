import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import {
  BEDROCK_RECORD_COMPARATOR_SIGNAL,
  SOURCE_MUSIC_DISCS,
  bedrockRecordComponent,
  musicDiscDefinition,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/music_disc_model.js";

const root = new URL("../TheBrokenScript_Bedrock_2_0/", import.meta.url);

async function readJson(path) {
  return JSON.parse(await readFile(new URL(path, root), "utf8"));
}

test("the recovered TBSSongs registry preserves all twelve source songs", () => {
  assert.equal(SOURCE_MUSIC_DISCS.length, 12);
  assert.equal(musicDiscDefinition("thebrokenscript:record_14").durationSeconds, 61);
  assert.equal(musicDiscDefinition("thebrokenscript:record_17").soundEvent, "disc17");
  assert.equal(musicDiscDefinition("thebrokenscript:attribute_mutilation").soundEvent, "jimbob.full");
  assert.throws(() => musicDiscDefinition("thebrokenscript:missing"), /Unknown music disc/);
});

test("all existing music items expose source-backed Bedrock record components", async () => {
  const soundDefinitions = await readJson("RP/sound_definitions.json");
  for (const definition of SOURCE_MUSIC_DISCS) {
    const item = await readJson(definition.itemPath);
    const record = item["minecraft:item"].components["minecraft:record"];
    assert.deepEqual(record, bedrockRecordComponent(definition.itemId), definition.itemId);
    assert.equal(item["minecraft:item"].components["minecraft:max_stack_size"], 1, definition.itemId);
    assert.equal(soundDefinitions.sound_definitions[definition.soundEvent]?.sounds?.length > 0, true, definition.soundEvent);
  }
  assert.equal(BEDROCK_RECORD_COMPARATOR_SIGNAL, 13);
  assert.equal(SOURCE_MUSIC_DISCS.every((entry) => entry.sourceComparatorSignal === 15), true);
});
