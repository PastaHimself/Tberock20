import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

const EXPECTED_MANIFEST_BETA = "2.11.0-beta";
const EXPECTED_NPM_BETA = "2.11.0-beta.1.26.50-preview.26";

async function readJson(relativePath) {
  const source = await readFile(new URL(relativePath, import.meta.url), "utf8");
  return JSON.parse(source);
}

test("behavior pack opts into the beta track and CI pins its current definitions", async () => {
  const [manifest, packageJson] = await Promise.all([
    readJson("../TheBrokenScript_Bedrock_2_0/BP/manifest.json"),
    readJson("../package.json"),
  ]);
  const serverDependency = manifest.dependencies.find(
    (dependency) => dependency.module_name === "@minecraft/server",
  );

  assert.ok(serverDependency, "behavior-pack manifest must declare @minecraft/server");
  assert.equal(serverDependency.version, EXPECTED_MANIFEST_BETA);
  assert.equal(packageJson.devDependencies["@minecraft/server"], EXPECTED_NPM_BETA);
});

test("beta pack requires its matching preview engine", async () => {
  const manifest = await readJson("../TheBrokenScript_Bedrock_2_0/BP/manifest.json");

  assert.deepEqual(manifest.header.min_engine_version, [1, 26, 50]);
});

test("CI identifies the installed Script API definitions as beta", async () => {
  const workflow = await readFile(
    new URL("../.github/workflows/bedrock-addon-check.yml", import.meta.url),
    "utf8",
  );

  assert.match(workflow, /Install Minecraft Bedrock beta Script API typings/);
  assert.doesNotMatch(workflow, /Install Minecraft Bedrock stable Script API typings/);
});
