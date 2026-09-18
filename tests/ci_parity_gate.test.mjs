import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

test("strict parity validation is opt-in for release workflows", async () => {
  const workflow = await readFile(
    new URL("../.github/workflows/bedrock-addon-check.yml", import.meta.url),
    "utf8"
  );

  assert.match(workflow, /tags:\s+-\s+[\"']?v\*[\"']?/);
  assert.match(workflow, /workflow_dispatch:\s+inputs:\s+enforce_parity:/s);
  assert.match(workflow, /enforce_parity:[\s\S]*?default:\s+false/);
  assert.match(
    workflow,
    /if:\s+\$\{\{[\s\S]*inputs\.enforce_parity[\s\S]*startsWith\(github\.ref,\s+[\"']refs\/tags\/v[\"']\)[\s\S]*\}\}/
  );
  assert.match(workflow, /bash tools\/package-addon\.sh --release/);
  assert.match(workflow, /bash tools\/package-addon\.sh\s*\n/);
});
