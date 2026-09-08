import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

const ROOT = new URL("../", import.meta.url);
const EXPECTED_SERVER_PREVIEW = "2.11.0-beta.1.26.50-preview.26";
const EXPECTED_SERVER_UI_PREVIEW = "2.3.0-beta.1.26.50-preview.26";

async function json(relativePath) {
  return JSON.parse(await readFile(new URL(relativePath, ROOT), "utf8"));
}

test("BP and RP deliberately target the same minimum engine version", async () => {
  const bp = await json("TheBrokenScript_Bedrock_2_0/BP/manifest.json");
  const rp = await json("TheBrokenScript_Bedrock_2_0/RP/manifest.json");
  assert.deepEqual(bp.header.min_engine_version, [1, 26, 50]);
  assert.deepEqual(rp.header.min_engine_version, bp.header.min_engine_version);
});

test("server-ui runtime dependency stays stable while CI typings match the preview server peer", async () => {
  const bp = await json("TheBrokenScript_Bedrock_2_0/BP/manifest.json");
  const pkg = await json("package.json");
  const runtime = bp.dependencies.find((dep) => dep.module_name === "@minecraft/server-ui")?.version;

  assert.equal(runtime, "2.1.0");
  assert.equal(pkg.devDependencies["@minecraft/server"], EXPECTED_SERVER_PREVIEW);
  assert.equal(pkg.devDependencies["@minecraft/server-ui"], EXPECTED_SERVER_UI_PREVIEW);
});
