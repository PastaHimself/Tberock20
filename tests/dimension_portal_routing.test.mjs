import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath, pathToFileURL } from "node:url";

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

test("portal cooldown logic blocks same-tick re-entry and permits the next tick", async () => {
  const modulePath = path.join(ROOT, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_feature_logic.js");
  const { canEnterPortal, portalCooldownUntil } = await import(pathToFileURL(modulePath));
  const cooldownUntil = portalCooldownUntil(200);
  assert.equal(cooldownUntil, 201);
  assert.equal(canEnterPortal(200, cooldownUntil), false);
  assert.equal(canEnterPortal(201, cooldownUntil), true);
});

test("linked portal activation reserves cooldown and owns failed linked routes", () => {
  const ported = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js");
  const customBlocks = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/custom_blocks.js");
  assert.match(ported, /const reservation = portalCooldownUntil\(currentTick, PORTAL_COOLDOWN_TICKS\)/);
  assert.match(ported, /player\.setDynamicProperty\(PORTAL_COOLDOWN_PROPERTY, reservation\)/);
  assert.match(ported, /clearPortalReservation\(player, reservation\)/);
  assert.match(customBlocks, /if \(portalCooldownActive\(player\)\) return;/);
  assert.match(customBlocks, /if \(hasLinkedPortal\(block\)\)/);
  assert.match(customBlocks, /await teleportLinkedPortal\(player, block\);\s*return;/);
});

test("linked travel validates its destination controller before teleporting", async () => {
  const modulePath = path.join(ROOT, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_feature_logic.js");
  const { linkedPortalDestinationExists } = await import(pathToFileURL(modulePath));
  const destination = { x: 4, y: 70, z: 9 };
  const portal = { typeId: "thebrokenscript:portal_controller" };
  assert.equal(linkedPortalDestinationExists({ getBlock: () => portal }, destination), true);
  assert.equal(linkedPortalDestinationExists({ getBlock: () => ({ typeId: "minecraft:air" }) }, destination), false);
  assert.equal(linkedPortalDestinationExists({ getBlock: () => undefined }, destination), false);
  assert.equal(linkedPortalDestinationExists({ getBlock: () => { throw new Error("unloaded"); } }, destination), false);

  const ported = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js");
  const dimensions = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimensions.js");
  assert.match(ported, /validateDestination:\s*\(dimension\)\s*=>\s*linkedPortalDestinationExists\(dimension, destination\)/);
  assert.match(dimensions, /if \(validateDestination && !validateDestination\(dim\)\) return false;/);
});
