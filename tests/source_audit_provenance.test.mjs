import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import {
  SOURCE_AUDIT_DISPOSITION as FAMILY_AUDIT_DISPOSITION,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_family_registry.js";
import {
  SOURCE_AUDIT_DISPOSITION as PERSISTENCE_AUDIT_DISPOSITION,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_persistence_policy.js";

const ROOT = new URL("../", import.meta.url);

async function text(relativePath) {
  return readFile(new URL(relativePath, ROOT), "utf8");
}

test("entity audit-support modules are explicitly unreachable and mirrored", async () => {
  for (const [disposition, sourcePath, deployedPath] of [
    [
      FAMILY_AUDIT_DISPOSITION,
      "TheBrokenScript_Bedrock_2_0/src/core/entity_family_registry.js",
      "TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_family_registry.js",
    ],
    [
      PERSISTENCE_AUDIT_DISPOSITION,
      "TheBrokenScript_Bedrock_2_0/src/core/entity_persistence_policy.js",
      "TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_persistence_policy.js",
    ],
  ]) {
    assert.deepEqual(disposition, {
      kind: "audit-support",
      runtimeReachability: "unreachable",
      wiring: "intentionally-not-wired",
      reason: "source-backed contract consumed by static audits and tests",
    });
    assert.equal(await text(sourcePath), await text(deployedPath));
  }

  const main = await text("TheBrokenScript_Bedrock_2_0/BP/scripts/main.js");
  assert.doesNotMatch(main, /entity_family_registry|entity_persistence_policy/);
});

test("generated audit documentation records the explicit source-only dispositions", async () => {
  const audit = await text("TheBrokenScript_Bedrock_2_0/docs/SOURCE_TO_RUNTIME_AUDIT.md");
  assert.match(audit, /BP\/scripts\/core\/entity_family_registry\.js.*audit-support/);
  assert.match(audit, /BP\/scripts\/core\/entity_persistence_policy\.js.*audit-support/);
  assert.doesNotMatch(audit, /shipped JavaScript modules are not reachable.*lack a disposition/);
});
