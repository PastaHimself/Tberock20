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

test("main smoke enforcement is conditional on a real report", async () => {
  const workflow = await readFile(
    new URL("../.github/workflows/bedrock-addon-check.yml", import.meta.url),
    "utf8"
  );

  const gate = workflow.match(
    /- name: Enforce complete runtime smoke evidence on main and releases[\s\S]*?(?=\n      - name:)/,
  )?.[0];
  assert.ok(gate, "complete runtime smoke gate must remain present");
  assert.match(gate, /github\.ref == ['"]refs\/heads\/main['"][\s\S]*hashFiles\(['"]tests\/runtime-smoke\/latest-report\.json['"]\) != ['"]['"]/);
  assert.match(gate, /inputs\.enforce_runtime_smoke/);
  assert.match(gate, /startsWith\(github\.ref, ['"]refs\/tags\/v['"]\)/);
  assert.doesNotMatch(gate, /github\.ref == ['"]refs\/heads\/main['"]\s*\|\|/);
});
