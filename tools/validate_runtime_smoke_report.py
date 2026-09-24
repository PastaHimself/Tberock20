#!/usr/bin/env python3
"""Validate a Bedrock runtime smoke-test report and enforce its release gate."""

from __future__ import annotations

import argparse
import hashlib
import json
import re
import sys
from pathlib import Path
from typing import Any

from validate_runtime_smoke_matrix import MatrixError, validate_matrix


VALID_STATUSES = {"pass", "fail", "blocked", "not-run"}
VALID_SEVERITIES = {"error", "warning", "info"}
PLACEHOLDER_MARKERS = ("replace-with", "placeholder", "your-", "todo")
FULL_COMMIT_PATTERN = re.compile(r"[0-9a-f]{40}")
SHA256_PATTERN = re.compile(r"[0-9a-f]{64}")


def require(condition: bool, message: str) -> None:
    if not condition:
        raise MatrixError(message)


def validate_report(
    report: Any,
    matrix: dict[str, Any],
    require_complete: bool,
    expected_commit: str | None = None,
    expected_artifact_sha256: str | None = None,
    artifact_path: Path | None = None,
) -> None:
    require(isinstance(report, dict), "report root must be an object")
    require(report.get("schema_version") == 1, "report schema_version must be 1")
    require(report.get("matrix_id") == matrix["matrix_id"], "report matrix_id does not match the matrix")
    candidate_commit = report.get("candidate_commit")
    require(
        isinstance(candidate_commit, str) and FULL_COMMIT_PATTERN.fullmatch(candidate_commit) is not None,
        "report candidate_commit must be an exact full 40-hex candidate commit",
    )
    require(
        isinstance(report.get("artifact_path"), str)
        and report["artifact_path"] == matrix["world"]["pack_artifact"],
        "report artifact_path must match the matrix packaged .mcaddon path",
    )
    artifact_sha256 = report.get("artifact_sha256")
    require(
        isinstance(artifact_sha256, str) and SHA256_PATTERN.fullmatch(artifact_sha256) is not None,
        "report artifact_sha256 must be an exact full 64-hex SHA-256 digest",
    )
    if expected_commit is not None:
        require(
            FULL_COMMIT_PATTERN.fullmatch(expected_commit) is not None,
            "--expected-commit must be an exact full 40-hex candidate commit",
        )
        require(
            candidate_commit == expected_commit,
            "report candidate commit does not match the expected candidate commit",
        )
    if expected_artifact_sha256 is not None:
        require(
            SHA256_PATTERN.fullmatch(expected_artifact_sha256) is not None,
            "--expected-artifact-sha256 must be an exact full 64-hex SHA-256 digest",
        )
        require(
            artifact_sha256 == expected_artifact_sha256,
            "report artifact SHA-256 does not match the expected packaged artifact",
        )
    if artifact_path is not None:
        require(artifact_path.suffix.lower() == ".mcaddon", "--artifact must point to a .mcaddon file")
        require(artifact_path.is_file(), f"packaged artifact does not exist: {artifact_path}")
        actual_artifact_sha256 = hashlib.sha256(artifact_path.read_bytes()).hexdigest()
        require(
            actual_artifact_sha256 == artifact_sha256,
            "report artifact SHA-256 does not match packaged artifact",
        )
        if expected_artifact_sha256 is not None:
            require(
                actual_artifact_sha256 == expected_artifact_sha256,
                "packaged artifact SHA-256 does not match the expected artifact digest",
            )
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
        required_evidence = {
            name for name, definition in matrix["evidence"].items() if definition.get("required") is True
        }
        evidence_set = set(evidence)
        require(
            required_evidence <= evidence_set,
            f"result {identifier}.evidence is missing required category(s): "
            f"{', '.join(sorted(required_evidence - evidence_set))}",
        )
        require(
            not any(any(marker in item.lower() for marker in PLACEHOLDER_MARKERS) for item in evidence),
            f"result {identifier}.evidence contains an unresolved placeholder",
        )

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

    if report["status"] == "pass":
        require(
            all(result["status"] == "pass" for result in results),
            "report status pass requires every scenario to pass",
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
    parser.add_argument("--expected-commit", help="exact full candidate commit expected in the report")
    parser.add_argument("--expected-artifact-sha256", help="exact full SHA-256 expected for the packaged .mcaddon")
    parser.add_argument("--artifact", type=Path, help="packaged .mcaddon to hash and compare with the report")
    args = parser.parse_args(argv)

    try:
        matrix = json.loads(args.matrix.read_text(encoding="utf-8"))
        validate_matrix(matrix)
        report = json.loads(args.report.read_text(encoding="utf-8"))
        validate_report(
            report,
            matrix,
            args.require_complete,
            expected_commit=args.expected_commit,
            expected_artifact_sha256=args.expected_artifact_sha256,
            artifact_path=args.artifact,
        )
    except (OSError, json.JSONDecodeError, MatrixError) as error:
        print(f"runtime smoke report invalid: {error}", file=sys.stderr)
        return 1

    mode = "complete" if args.require_complete else "partial"
    print(f"runtime smoke report valid ({mode}): {report['run_id']}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
