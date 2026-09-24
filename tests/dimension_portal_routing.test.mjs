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


test("portal relinking removes both endpoints' obsolete reverse links", async () => {
  const modulePath = path.join(ROOT, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_feature_logic.js");
  const { linkPortals, linkedPortal } = await import(pathToFileURL(modulePath));

  const a = { dimensionId: "overworld", x: 0, y: 64, z: 0 };
  const b = { dimensionId: "overworld", x: 10, y: 64, z: 0 };
  const c = { dimensionId: "overworld", x: 20, y: 64, z: 0 };
  const d = { dimensionId: "overworld", x: 30, y: 64, z: 0 };

  let links = linkPortals({}, a, b);
  links = linkPortals(links, c, d);
  links = linkPortals(links, a, c);

  assert.deepEqual(linkedPortal(links, a), c);
  assert.deepEqual(linkedPortal(links, c), a);
  assert.equal(linkedPortal(links, b), undefined);
  assert.equal(linkedPortal(links, d), undefined);
});

test("portal link model rejects cross-dimension source parity", async () => {
  const modulePath = path.join(ROOT, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_feature_logic.js");
  const { samePortalDimension } = await import(pathToFileURL(modulePath));
  assert.equal(
    samePortalDimension(
      { dimensionId: "overworld", x: 0, y: 64, z: 0 },
      { dimensionId: "thebrokenscript:library", x: 0, y: 64, z: 0 },
    ),
    false,
  );
});

test("portal relative-position model preserves offset and passenger Y semantics", async () => {
  const modulePath = path.join(ROOT, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_feature_logic.js");
  const { portalTargetLocation, samePortalBoundsSize } = await import(pathToFileURL(modulePath));
  const source = { min: { x: 0, y: 60, z: 0 }, max: { x: 3, y: 64, z: 2 } };
  const destination = { min: { x: 100, y: 20, z: 50 }, max: { x: 103, y: 24, z: 52 } };

  assert.equal(samePortalBoundsSize(source, destination), true);
  assert.deepEqual(
    portalTargetLocation(source, destination, { x: 1.25, y: 62.5, z: 0.75 }, false),
    { x: 101.25, y: 22.5, z: 50.75 },
  );
  assert.deepEqual(
    portalTargetLocation(source, destination, { x: 1.25, y: 62.5, z: 0.75 }, true),
    { x: 101.25, y: 20, z: 50.75 },
  );
});

test("portal runtime restores the Java one-tick living-entity sweep contract", () => {
  const ported = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js");
  assert.match(ported, /scheduler\.every\("ported_features\.portals",\s*1,\s*tickLinkedPortals\)/);
  assert.match(ported, /dimension\.getEntities\(\{\s*location:\s*bounds\.min,\s*volume:/s);
  assert.match(ported, /entity\.getComponent\("minecraft:health"\)/);
  assert.match(ported, /entity\.getAABB\(\)/);
  assert.match(ported, /keepVelocity:\s*true/);
  assert.match(ported, /samePortalBoundsSize\(sourceBounds,\s*destinationBounds\)/);
  assert.match(ported, /PORTAL_EXTENDER_ID/);
});

test("portal runtime validates stale controller links before use", () => {
  const ported = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js");
  assert.match(ported, /resolvePortalController\(destination\)/);
  assert.match(ported, /links = unlinkPortal\(links,\s*source\)/);
  assert.match(ported, /block\.typeId !== PORTAL_CONTROLLER_ID/);
});
