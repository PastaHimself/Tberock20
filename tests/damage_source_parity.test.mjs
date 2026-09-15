import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";
import {
  CUSTOM_DAMAGE_SOURCE_KEYS,
  getDamageSource,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/damage_source_model.js";

const dataRoot = new URL("../source_extracted/data/", import.meta.url);
const tagPaths = {
  armor: "minecraft/tags/damage_type/bypasses_armor.json",
  effects: "minecraft/tags/damage_type/bypasses_effects.json",
  invulnerability: "minecraft/tags/damage_type/bypasses_invulnerability.json",
  shield: "minecraft/tags/damage_type/bypasses_shield.json",
  totem: "brokencore/tags/damage_type/bypasses_totem.json",
  noKnockback: "minecraft/tags/damage_type/no_knockback.json",
};

async function readJson(relativePath) {
  return JSON.parse(await readFile(new URL(relativePath, dataRoot), "utf8"));
}

test("all 15 Bedrock source entries match the extracted Java damage definitions and tags", async () => {
  const tagSets = Object.fromEntries(
    await Promise.all(Object.entries(tagPaths).map(async ([key, relativePath]) => {
      const tag = await readJson(relativePath);
      return [key, new Set(tag.values)];
    })),
  );

  for (const key of CUSTOM_DAMAGE_SOURCE_KEYS) {
    const source = getDamageSource(key);
    const raw = await readJson("thebrokenscript/damage_type/" + key + ".json");
    assert.deepEqual(
      {
        deathMessageType: source.deathMessageType,
        effects: source.effects,
        exhaustion: source.exhaustion,
        messageId: source.messageId,
        scaling: source.scaling,
      },
      {
        deathMessageType: raw.death_message_type,
        effects: raw.effects,
        exhaustion: raw.exhaustion,
        messageId: raw.message_id,
        scaling: raw.scaling,
      },
      key,
    );

    for (const [flag, values] of Object.entries(tagSets)) {
      const modelValue = flag === "noKnockback" ? source.noKnockback : source.bypasses[flag];
      assert.equal(modelValue, values.has(source.id), key + "." + flag);
    }
  }
});
