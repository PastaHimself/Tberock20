import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const ROOT = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const addon = (relativePath) => readFileSync(path.join(ROOT, "TheBrokenScript_Bedrock_2_0", relativePath), "utf8");

test("high-risk entity controllers use bounded operation diagnostics", () => {
  for (const file of [
    "BP/scripts/entities/tbe/tbe_controller.js",
    "BP/scripts/entities/humanoid/humanoid_controller.js",
    "BP/scripts/entities/misc/misc_controller.js",
  ]) {
    const source = addon(file);
    assert.match(source, /operation_diagnostics\.js/);
    assert.match(source, /operationDiagnostics\.(warnOnce|errorOnce)/);
    assert.doesNotMatch(source, /getEntities\([\s\S]{0,180}\)\s*;\s*}\s*catch\s*\{\s*continue/);
  }
});

test("dimension and portal failures preserve fallbacks while logging stable keys", () => {
  const dimensions = addon("BP/scripts/systems/dimensions.js");
  const sourceDimensions = addon("src/systems/dimensions.js");
  const portals = addon("BP/scripts/systems/ported_features.js");
  assert.match(dimensions, /operationDiagnostics\.errorOnce\("dimensions\./);
  assert.match(portals, /operationDiagnostics\.(warnOnce|errorOnce)\("ported_features\./);
  assert.equal(dimensions, sourceDimensions, "dimension authoring and deployment copies must stay identical");
  assert.match(portals, /clearPortalReservation\(player, reservation\)/);
});
