#!/usr/bin/env python3
"""Validate the checked-in Bedrock runtime smoke-test matrix."""

from __future__ import annotations

import argparse
import json
import sys
from pathlib import Path
from typing import Any


REQUIRED_SCENARIOS = {
    "bootstrap",
    "persistence",
    "death_respawn",
    "leave_rejoin_restart",
    "multiplayer",
    "dimensions",
    "boss_lifecycle",
    "story_progression",
    "event_suppression",
    "diagnostics",
}

EXPECTED_CONTRACT = {
    "minecraft_product_line": "1.26.50-preview",
    "server_api": "2.11.0-beta",
    "server_ui": "2.1.0",
    "typing_packages": [
        "@minecraft/server@2.11.0-beta.1.26.50-preview.26",
        "@minecraft/server-ui@2.3.0-beta.1.26.50-preview.26",
    ],
    "required_experiments": ["Beta APIs"],
}


class MatrixError(ValueError):
    """Raised when a smoke matrix violates its repository contract."""


def require(condition: bool, message: str) -> None:
    if not condition:
        raise MatrixError(message)


def require_string(value: Any, field: str) -> None:
    require(isinstance(value, str) and value.strip(), f"{field} must be a non-empty string")


def validate_matrix(matrix: Any) -> None:
    require(isinstance(matrix, dict), "matrix root must be an object")
    require(matrix.get("schema_version") == 1, "schema_version must be 1")
    require(matrix.get("matrix_id") == "tbs-bedrock-runtime-smoke-v1", "unexpected matrix_id")
    require(matrix.get("runtime_contract") == EXPECTED_CONTRACT, "runtime_contract does not match API_AUDIT.md")

    world = matrix.get("world")
    require(isinstance(world, dict), "world must be an object")
    for field in ("name", "seed", "difficulty", "operator_mode", "pack_artifact", "fixed_overworld_spawn", "fixed_dimension_probe"):
        require_string(world.get(field), f"world.{field}")
    require(world.get("cheats") is True, "world.cheats must be true for the operator smoke world")
    require(world.get("reset_between_scenarios") is True, "world.reset_between_scenarios must be true")

    evidence = matrix.get("evidence")
    require(isinstance(evidence, dict), "evidence must be an object")
    for evidence_name in ("content_log", "report"):
        entry = evidence.get(evidence_name)
        require(isinstance(entry, dict), f"evidence.{evidence_name} must be an object")
        require(entry.get("required") is True, f"evidence.{evidence_name}.required must be true")

    release_gate = matrix.get("release_gate")
    require(isinstance(release_gate, dict), "release_gate must be an object")
    require(release_gate.get("require_complete_report_on_tags") is True, "release gate must require a complete tag report")
    require(
        release_gate.get("parity_critical_diagnostic_severities") == ["error", "warning"],
        "release gate must block parity-critical errors and warnings",
    )

    scenarios = matrix.get("scenarios")
    require(isinstance(scenarios, list), "scenarios must be an array")
    ids = [scenario.get("id") if isinstance(scenario, dict) else None for scenario in scenarios]
    require(all(isinstance(identifier, str) and identifier for identifier in ids), "every scenario needs a non-empty id")
    require(len(ids) == len(set(ids)), "scenario ids must be unique")
    missing = sorted(REQUIRED_SCENARIOS - set(ids))
    require(not missing, f"missing required scenario(s): {', '.join(missing)}")

    for scenario in scenarios:
        identifier = scenario["id"]
        require_string(scenario.get("title"), f"scenario {identifier}.title")
        require(scenario.get("priority") in {"P0", "P1", "P2"}, f"scenario {identifier}.priority is invalid")
        require(scenario.get("parity_critical") is True, f"scenario {identifier} must be parity-critical")
        for field in ("preconditions", "steps", "pass_criteria", "commands", "evidence"):
            value = scenario.get(field)
            require(isinstance(value, list) and value, f"scenario {identifier}.{field} must be a non-empty array")
            require(all(isinstance(item, str) and item.strip() for item in value), f"scenario {identifier}.{field} contains an empty item")
        require(len(scenario["steps"]) >= 3, f"scenario {identifier} needs at least three repeatable steps")
        require(len(scenario["pass_criteria"]) >= 2, f"scenario {identifier} needs at least two pass criteria")
        require("content_log" in scenario["evidence"], f"scenario {identifier} must collect content-log evidence")
        require("report" in scenario["evidence"], f"scenario {identifier} must collect report evidence")


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("matrix", type=Path, help="path to the runtime smoke matrix JSON")
    args = parser.parse_args(argv)

    try:
        matrix = json.loads(args.matrix.read_text(encoding="utf-8"))
        validate_matrix(matrix)
    except (OSError, json.JSONDecodeError, MatrixError) as error:
        print(f"runtime smoke matrix invalid: {error}", file=sys.stderr)
        return 1

    print(f"runtime smoke matrix valid: {len(matrix['scenarios'])} scenarios, contract {matrix['matrix_id']}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
