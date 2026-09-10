import assert from "node:assert/strict";
import { readdirSync, readFileSync } from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

import {
  CUSTOM_REALM_NAMES,
  JAVA_REGISTERED_REALM_NAMES,
  RESOURCE_ONLY_REALM_NAMES
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimension_ids.js";

const ROOT = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const JAVA_DIMENSION_DIR = path.join(
  ROOT,
  "source_extracted/data/thebrokenscript/dimension"
);
const TBS_DIMENSIONS_JAVA = path.join(
  ROOT,
  "decompiled/net/thebrokenscript/registry/TBSDimensions.java"
);

function sorted(values) {
  return [...values].sort((a, b) => a.localeCompare(b));
}

test("Bedrock custom dimension contract covers every Java dimension resource", () => {
  const sourceResourceRealms = readdirSync(JAVA_DIMENSION_DIR)
    .filter((name) => name.endsWith(".json"))
    .map((name) => name.slice(0, -".json".length));

  assert.deepEqual(sorted(CUSTOM_REALM_NAMES), sorted(sourceResourceRealms));
});

test("TBSDimensions.ALL remains the 12 Java keys and backrooms is the resource-only exception", () => {
  const javaSource = readFileSync(TBS_DIMENSIONS_JAVA, "utf8");
  const javaRegisteredRealms = [
    ...javaSource.matchAll(/INSTANCE\.dim\("([a-z0-9_]+)"\)/g)
  ].map((match) => match[1]);

  assert.deepEqual(sorted(JAVA_REGISTERED_REALM_NAMES), sorted(javaRegisteredRealms));
  assert.deepEqual(RESOURCE_ONLY_REALM_NAMES, ["backrooms"]);
  assert.deepEqual(
    sorted(CUSTOM_REALM_NAMES.filter((name) => !javaRegisteredRealms.includes(name))),
    ["backrooms"]
  );
});

test("backrooms source resource is backed by the custom Java generator", () => {
  const backrooms = JSON.parse(
    readFileSync(path.join(JAVA_DIMENSION_DIR, "backrooms.json"), "utf8")
  );

  assert.equal(backrooms.type, "thebrokenscript:backrooms");
  assert.equal(backrooms.generator?.type, "thebrokenscript:backrooms_generator");
});
