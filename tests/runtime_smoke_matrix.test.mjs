import assert from "node:assert/strict";
import { execFile } from "node:child_process";
import { mkdtemp, readFile, rm, writeFile } from "node:fs/promises";
import os from "node:os";
import path from "node:path";
import { promisify } from "node:util";
import test from "node:test";

const execFileAsync = promisify(execFile);
const ROOT = path.resolve(path.dirname(new URL(import.meta.url).pathname), "..");
const MATRIX_PATH = path.join(ROOT, "tests/runtime-smoke/matrix.json");
const MATRIX_VALIDATOR = path.join(ROOT, "tools/validate_runtime_smoke_matrix.py");
const REPORT_VALIDATOR = path.join(ROOT, "tools/validate_runtime_smoke_report.py");
const WORKFLOW_PATH = path.join(ROOT, ".github/workflows/bedrock-addon-check.yml");

const REQUIRED_SCENARIOS = [
  "bootstrap",
  "persistence",
  "death_respawn",
  "leave_rejoin_restart",
  "multiplayer",
  "dimensions",
  "boss_lifecycle",
  "story_progression",
  "event_suppression",
  "diagnostics"
];

async function readMatrix() {
  return JSON.parse(await readFile(MATRIX_PATH, "utf8"));
}

function completeReport(matrix, evidenceFor = (id) => [`artifacts/${id}.png`, "content_log", "report"]) {
  return {
    schema_version: 1,
    matrix_id: matrix.matrix_id,
    run_id: "example-run",
    started_at: "2026-09-13T00:00:00Z",
    finished_at: "2026-09-13T01:00:00Z",
    runtime_contract: matrix.runtime_contract,
    status: "pass",
    results: matrix.scenarios.map(({ id }) => ({
      id,
      status: "pass",
      evidence: evidenceFor(id)
    })),
    diagnostics: []
  };
}

async function runPython(script, args) {
  try {
    const result = await execFileAsync("python", [script, ...args], { cwd: ROOT });
    return { code: 0, output: `${result.stdout}${result.stderr}` };
  } catch (error) {
    return {
      code: error.code ?? 1,
      output: `${error.stdout ?? ""}${error.stderr ?? ""}`
    };
  }
}

test("runtime smoke matrix locks the pinned Bedrock contract and required scenarios", async () => {
  const matrix = await readMatrix();

  assert.equal(matrix.schema_version, 1);
  assert.equal(matrix.matrix_id, "tbs-bedrock-runtime-smoke-v1");
  assert.deepEqual(matrix.runtime_contract, {
    minecraft_product_line: "1.26.50-preview",
    server_api: "2.11.0-beta",
    server_ui: "2.1.0",
    typing_packages: [
      "@minecraft/server@2.11.0-beta.1.26.50-preview.26",
      "@minecraft/server-ui@2.3.0-beta.1.26.50-preview.26"
    ],
    required_experiments: ["Beta APIs"]
  });
  assert.equal(matrix.world.name, "TBS 2.0 Runtime Smoke 1.26.50 Preview");
  assert.equal(matrix.world.seed, "260501126");
  assert.deepEqual(matrix.world, {
    name: "TBS 2.0 Runtime Smoke 1.26.50 Preview",
    seed: "260501126",
    difficulty: "normal",
    operator_mode: "creative",
    cheats: true,
    pack_artifact: "dist/The_Broken_Script_2_0.mcaddon",
    reset_between_scenarios: true,
    fixed_overworld_spawn: "0 80 0",
    fixed_dimension_probe: "0 201 0"
  });
  assert.equal(matrix.release_gate.require_complete_report_on_tags, true);
  assert.deepEqual(matrix.release_gate.parity_critical_diagnostic_severities, ["error", "warning"]);
  assert.deepEqual(matrix.release_gate.allowed_nonblocking_diagnostic_severities, ["info"]);

  const scenarios = matrix.scenarios;
  assert.deepEqual(scenarios.map(({ id }) => id).sort(), [...REQUIRED_SCENARIOS].sort());
  for (const scenario of scenarios) {
    assert.equal(scenario.priority, "P0", `${scenario.id} must remain P0`);
    assert.equal(scenario.parity_critical, true, `${scenario.id} must be parity-critical`);
    assert.ok(scenario.preconditions.length >= 1, `${scenario.id} needs preconditions`);
    assert.ok(scenario.steps.length >= 3, `${scenario.id} needs repeatable steps`);
    assert.ok(scenario.pass_criteria.length >= 2, `${scenario.id} needs pass criteria`);
    assert.ok(scenario.evidence.includes("content_log"), `${scenario.id} needs content-log evidence`);
    assert.ok(scenario.evidence.includes("report"), `${scenario.id} needs report evidence`);
  }
});

test("runtime smoke matrix validator locks P0 priority and fixed world values", async () => {
  const matrix = await readMatrix();
  const tempDir = await mkdtemp(path.join(os.tmpdir(), "tbs-runtime-contract-"));
  const invalidPath = path.join(tempDir, "matrix.json");
  try {
    const downgraded = {
      ...matrix,
      scenarios: matrix.scenarios.map((scenario, index) => index === 0 ? { ...scenario, priority: "P1" } : scenario)
    };
    await writeFile(invalidPath, JSON.stringify(downgraded));
    const priorityResult = await runPython(MATRIX_VALIDATOR, [invalidPath]);
    assert.notEqual(priorityResult.code, 0);
    assert.match(priorityResult.output, /priority must remain P0/i);

    await writeFile(invalidPath, JSON.stringify({ ...matrix, world: { ...matrix.world, difficulty: "hard" } }));
    const worldResult = await runPython(MATRIX_VALIDATOR, [invalidPath]);
    assert.notEqual(worldResult.code, 0);
    assert.match(worldResult.output, /pinned smoke-world contract/i);
  } finally {
    await rm(tempDir, { recursive: true, force: true });
  }
});

test("runtime smoke matrix validator rejects a missing required scenario", async () => {
  const matrix = await readMatrix();
  const tempDir = await mkdtemp(path.join(os.tmpdir(), "tbs-runtime-smoke-"));
  const invalidPath = path.join(tempDir, "matrix.json");
  try {
    await writeFile(invalidPath, JSON.stringify({ ...matrix, scenarios: matrix.scenarios.slice(1) }));
    const result = await runPython(MATRIX_VALIDATOR, [invalidPath]);
    assert.notEqual(result.code, 0);
    assert.match(result.output, /missing required scenario/i);
  } finally {
    await rm(tempDir, { recursive: true, force: true });
  }
});

test("runtime smoke report validator blocks parity-critical diagnostics", async () => {
  const matrix = await readMatrix();
  const tempDir = await mkdtemp(path.join(os.tmpdir(), "tbs-runtime-report-"));
  const reportPath = path.join(tempDir, "report.json");
  try {
    const report = completeReport(matrix);

    await writeFile(reportPath, JSON.stringify(report));
    const clean = await runPython(REPORT_VALIDATOR, [reportPath, "--matrix", MATRIX_PATH, "--require-complete"]);
    assert.equal(clean.code, 0, clean.output);

    report.diagnostics.push({
      id: "startup-script-error",
      severity: "error",
      parity_critical: true,
      message: "script failed to initialize"
    });
    await writeFile(reportPath, JSON.stringify(report));
    const blocked = await runPython(REPORT_VALIDATOR, [reportPath, "--matrix", MATRIX_PATH, "--require-complete"]);
    assert.notEqual(blocked.code, 0);
    assert.match(blocked.output, /parity-critical/i);
  } finally {
    await rm(tempDir, { recursive: true, force: true });
  }
});

test("runtime smoke report requires declared evidence and consistent pass status", async () => {
  const matrix = await readMatrix();
  const tempDir = await mkdtemp(path.join(os.tmpdir(), "tbs-runtime-evidence-"));
  const reportPath = path.join(tempDir, "report.json");
  try {
    const report = completeReport(matrix, () => ["screen_capture"]);
    await writeFile(reportPath, JSON.stringify(report));
    const missingEvidence = await runPython(REPORT_VALIDATOR, [reportPath, "--matrix", MATRIX_PATH, "--require-complete"]);
    assert.notEqual(missingEvidence.code, 0);
    assert.match(missingEvidence.output, /missing required category/i);

    report.results = report.results.map((result) => ({ ...result, evidence: ["content_log", "report"] }));
    report.results[0].evidence.push("replace-with-evidence");
    await writeFile(reportPath, JSON.stringify(report));
    const placeholder = await runPython(REPORT_VALIDATOR, [reportPath, "--matrix", MATRIX_PATH, "--require-complete"]);
    assert.notEqual(placeholder.code, 0);
    assert.match(placeholder.output, /unresolved placeholder/i);

    report.results[0].evidence = ["content_log", "report"];
    report.results[0].status = "not-run";
    await writeFile(reportPath, JSON.stringify(report));
    const inconsistentStatus = await runPython(REPORT_VALIDATOR, [reportPath, "--matrix", MATRIX_PATH]);
    assert.notEqual(inconsistentStatus.code, 0);
    assert.match(inconsistentStatus.output, /status pass requires every scenario/i);
  } finally {
    await rm(tempDir, { recursive: true, force: true });
  }
});

test("GitHub Actions validates the matrix and gates release tags on a complete report", async () => {
  const workflow = await readFile(WORKFLOW_PATH, "utf8");

  assert.match(workflow, /validate_runtime_smoke_matrix\.py/);
  assert.match(workflow, /latest-report\.json/);
  assert.match(workflow, /validate_runtime_smoke_report\.py/);
  assert.match(workflow, /--require-complete/);
  assert.match(workflow, /enforce_runtime_smoke/);
  assert.match(workflow, /if: \$\{\{ inputs\.enforce_runtime_smoke \|\| startsWith\(github\.ref, 'refs\/tags\/v'\) \}\}/);
  assert.match(workflow, /test -f tests\/runtime-smoke\/latest-report\.json[\s\S]*--require-complete/);
});
