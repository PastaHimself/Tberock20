import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const ROOT = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");

async function read(relativePath) {
  return readFile(path.join(ROOT, relativePath), "utf8");
}

test("stalk controller follows active player dimensions and owns Curved melee scheduling", async () => {
  const source = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/stalk/stalk_controller.js");
  assert.match(source, /dimsById\.set\(player\.dimension\.id, player\.dimension\)/);
  assert.doesNotMatch(source, /system\.runInterval\(/);
  assert.match(source, /meleePulse/);
  assert.match(source, /world\.getEntity\(id\)/);
});

test("misc controller reaches Null Torture and Maze Shadows remain transient like Java", async () => {
  const controller = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/misc/misc_controller.js");
  const entity = JSON.parse(await read("TheBrokenScript_Bedrock_2_0/BP/entities/maze_shadows.json"));
  const policy = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_persistence_policy.js");

  assert.match(controller, /dimsById\.set\(player\.dimension\.id, player\.dimension\)/);
  assert.match(controller, /case "thebrokenscript:maze_shadows": return tickWanderDespawn\(e\)/);
  assert.equal("minecraft:persistent" in entity["minecraft:entity"].components, false);
  assert.match(policy, /"thebrokenscript:maze_shadows"/);
});
