#!/usr/bin/env python3
"""Validate a Bedrock runtime smoke-test report and enforce its release gate."""

from __future__ import annotations

import argparse
import json
import sys
from pathlib import Path
from typing import Any

from validate_runtime_smoke_matrix import MatrixError, validate_matrix


VALID_STATUSES = {"pass", "fail", "blocked", "not-run"}
VALID_SEVERITIES = {"error", "warning", "info"}


def require(condition: bool, message: str) -> None:
    if not condition:
        raise MatrixError(message)


def validate_report(report: Any, matrix: dict[str, Any], require_complete: bool) -> None:
    require(isinstance(report, dict), "report root must be an object")
    require(report.get("schema_version") == 1, "report schema_version must be 1")
    require(report.get("matrix_id") == matrix["matrix_id"], "report matrix_id does not match the matrix")
    require(isinstance(report.get("run_id"), str) and report["run_id"].strip(), "report run_id must be non-empty")
    require(isinstance(report.get("started_at"), str) and report["started_at"].strip(), "report started_at must be non-empty")
    require(isinstance(report.get("finished_at"), str) and report["finished_at"].strip(), "report finished_at must be non-empty")
    require(report.get("runtime_contract") == matrix["runtime_contract"], "report runtime_contract does not match the matrix")
    require(report.get("status") in VALID_STATUSES, "report status is invalid")

    expected_ids = {scenario["id"] for scenario in matrix["scenarios"]}
    results = report.get("results")
    require(isinstance(results, list), "report results must be an array")
    result_ids = [result.get("id") if isinstance(result, dict) else None for result in results]
    require(all(isinstance(identifier, str) and identifier for identifier in result_ids), "every result needs a non-empty id")
    require(len(result_ids) == len(set(result_ids)), "report result ids must be unique")
    require(set(result_ids) == expected_ids, "report results must cover exactly the matrix scenarios")

    result_by_id = {result["id"]: result for result in results}
    for scenario in matrix["scenarios"]:
        identifier = scenario["id"]
        result = result_by_id[identifier]
        require(result.get("status") in VALID_STATUSES, f"result {identifier}.status is invalid")
        evidence = result.get("evidence")
        require(isinstance(evidence, list) and evidence, f"result {identifier} needs evidence references")
        require(all(isinstance(item, str) and item.strip() for item in evidence), f"result {identifier}.evidence contains an empty item")

        if scenario["parity_critical"] and result["status"] == "fail":
            raise MatrixError(f"parity-critical scenario failed: {identifier}")

    diagnostics = report.get("diagnostics")
    require(isinstance(diagnostics, list), "report diagnostics must be an array")
    blocking_severities = set(matrix["release_gate"]["parity_critical_diagnostic_severities"])
    for index, diagnostic in enumerate(diagnostics):
        require(isinstance(diagnostic, dict), f"diagnostic {index} must be an object")
        require(diagnostic.get("severity") in VALID_SEVERITIES, f"diagnostic {index}.severity is invalid")
        require(isinstance(diagnostic.get("message"), str) and diagnostic["message"].strip(), f"diagnostic {index}.message must be non-empty")
        require(isinstance(diagnostic.get("parity_critical"), bool), f"diagnostic {index}.parity_critical must be boolean")
        if diagnostic["parity_critical"] and diagnostic["severity"] in blocking_severities:
            raise MatrixError(
                f"parity-critical {diagnostic['severity']} blocks the runtime smoke report: {diagnostic['message']}"
            )

    if require_complete:
        require(report["status"] == "pass", "complete runtime smoke report must have status pass")
        for result in results:
            require(result["status"] == "pass", f"complete runtime smoke report has non-passing scenario: {result['id']}")


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("report", type=Path, help="path to a runtime smoke report JSON")
    parser.add_argument("--matrix", type=Path, required=True, help="path to the matrix JSON")
    parser.add_argument("--require-complete", action="store_true", help="require every parity-critical scenario to pass")
    args = parser.parse_args(argv)

    try:
        matrix = json.loads(args.matrix.read_text(encoding="utf-8"))
        validate_matrix(matrix)
        report = json.loads(args.report.read_text(encoding="utf-8"))
        validate_report(report, matrix, args.require_complete)
    except (OSError, json.JSONDecodeError, MatrixError) as error:
        print(f"runtime smoke report invalid: {error}", file=sys.stderr)
        return 1

    mode = "complete" if args.require_complete else "partial"
    print(f"runtime smoke report valid ({mode}): {report['run_id']}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
