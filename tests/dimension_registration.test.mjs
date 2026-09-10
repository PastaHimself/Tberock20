import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const ROOT = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
function read(relativePath) {
  return readFileSync(path.join(ROOT, relativePath), "utf8").replace(/\r\n/g, "\n");
}

test("source and deployable dimension modules stay synchronized", () => {
  assert.equal(
    read("TheBrokenScript_Bedrock_2_0/src/systems/dimension_ids.js"),
    read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimension_ids.js")
  );
  assert.equal(
    read("TheBrokenScript_Bedrock_2_0/src/systems/dimensions.js"),
    read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimensions.js")
  );
});

test("custom dimensions use the supported startup DimensionRegistry API", () => {
  const main = read("TheBrokenScript_Bedrock_2_0/BP/scripts/main.js");
  const dimensions = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimensions.js");
  const srcDimensions = read("TheBrokenScript_Bedrock_2_0/src/systems/dimensions.js");

  assert.match(main, /dimensions\.registerCustomDimensions\(event\.dimensionRegistry\)/);
  assert.match(main, /system\.beforeEvents\.startup\.subscribe\(onStartup\)/);
  assert.match(dimensions, /for \(const id of CUSTOM_DIMENSION_IDS\)/);

  const calls = [...dimensions.matchAll(/dimensionRegistry\.registerCustomDimension\(([^)]*)\)/g)]
    .map((match) => match[1].trim());
  assert.deepEqual(calls, ["id"]);

  for (const source of [dimensions, srcDimensions]) {
    assert.doesNotMatch(source, /\.createDimension\s*\(/);
    assert.doesNotMatch(source, /generatorType\s*:/);
  }
});

test("Java ALL semantics stay separate from the 13-realm registration contract", () => {
  const dimensions = read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimensions.js");

  assert.match(dimensions, /export const ALL = \[\.\.\.JAVA_REGISTERED_REALM_NAMES\];/);
  assert.match(dimensions, /export const REGISTERED_CUSTOM_IDS = \[\.\.\.CUSTOM_DIMENSION_IDS\];/);
});
