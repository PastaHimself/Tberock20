import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const ROOT = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");

function read(relativePath) {
  return readFileSync(path.join(ROOT, relativePath), "utf8").replace(/\r\n/g, "\n");
}

test("readiness-gated dimension modules stay synchronized between source and BP", () => {
  for (const name of ["dimension_state.js", "dimension_generation.js", "dimensions.js"]) {
    assert.equal(
      read(`TheBrokenScript_Bedrock_2_0/src/systems/${name}`),
      read(`TheBrokenScript_Bedrock_2_0/BP/scripts/systems/${name}`),
      `${name} drifted between src and deployable BP`,
    );
  }
});

test("user-facing dimension command uses readiness-gated teleport", () => {
  const commands = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js");
  assert.match(commands, /dimensions\s*\.\s*teleportWhenReady\(/);
  assert.doesNotMatch(
    commands,
    /dimensions\s*\.\s*teleportTo\(player,\s*id,\s*\{\s*x:\s*0,\s*y:\s*201/,
  );
});

test("linked portal routing no longer resolves and teleports directly", () => {
  const ported = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js");
  assert.match(ported, /await\s+dimensions\.teleportWhenReady\(/);
  assert.doesNotMatch(ported, /world\.getDimension\(destination\.dimensionId\)/);
  assert.match(ported, /export\s+async\s+function\s+teleportLinkedPortal/);
});

test("portal controller defers async destination preparation out of the component callback", () => {
  const customBlocks = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/custom_blocks.js");
  assert.match(customBlocks, /system\.run\(\(\)\s*=>\s*\{/);
  assert.match(customBlocks, /await\s+teleportLinkedPortal\(player,\s*block\)/);
  assert.match(customBlocks, /await\s+dimensions\.teleportWhenReady\(player,\s*"clan_void"/);
});
