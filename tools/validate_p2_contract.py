#!/usr/bin/env python3
"""Validate the repository's selected Bedrock Script API contract.

The repository intentionally targets one beta ABI. This validator reads the
manifests, development typings, API/compatibility ledgers, and smoke matrix as
one contract so a stable/latest dependency cannot be introduced silently.
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path
import re
import sys
from typing import Any


ROOT = Path(__file__).resolve().parents[1]
EXPECTED_ENGINE_FLOOR = [1, 26, 50]
EXPECTED_RUNTIME_SERVER = "2.11.0-beta"
EXPECTED_TYPING_SERVER = "2.11.0-beta.1.26.50-preview.26"
EXPECTED_RUNTIME_SERVER_UI = "2.1.0"
EXPECTED_TYPING_SERVER_UI = "2.3.0-beta.1.26.50-preview.26"
EXPECTED_PRODUCT_LINE = "1.26.50-preview"
EXPECTED_EXPERIMENT = "Beta APIs"


def _read_json(path: Path) -> dict[str, Any]:
    value = json.loads(path.read_text(encoding="utf-8"))
    if not isinstance(value, dict):
        raise ValueError(f"{path} must contain a JSON object")
    return value


def _module_dependency(manifest: dict[str, Any], module_name: str) -> str | None:
    for dependency in manifest.get("dependencies", []):
        if isinstance(dependency, dict) and dependency.get("module_name") == module_name:
            value = dependency.get("version")
            return value if isinstance(value, str) else None
    return None


def read_contract(root: Path = ROOT) -> dict[str, Any]:
    addon = root / "TheBrokenScript_Bedrock_2_0"
    bp_manifest = _read_json(addon / "BP" / "manifest.json")
    rp_manifest = _read_json(addon / "RP" / "manifest.json")
    package = _read_json(root / "package.json")
    smoke = _read_json(root / "tests" / "runtime-smoke" / "matrix.json")
    api_audit = (addon / "API_AUDIT.md").read_text(encoding="utf-8")
    compatibility = (addon / "BEDROCK_COMPATIBILITY.md").read_text(encoding="utf-8")

    return {
        "engine_floor": bp_manifest.get("header", {}).get("min_engine_version"),
        "resource_engine_floor": rp_manifest.get("header", {}).get("min_engine_version"),
        "runtime_server": _module_dependency(bp_manifest, "@minecraft/server"),
        "runtime_server_ui": _module_dependency(bp_manifest, "@minecraft/server-ui"),
        "typing_server": package.get("devDependencies", {}).get("@minecraft/server"),
        "typing_server_ui": package.get("devDependencies", {}).get("@minecraft/server-ui"),
        "product_line": smoke.get("runtime_contract", {}).get("minecraft_product_line"),
        "smoke_server": smoke.get("runtime_contract", {}).get("server_api"),
        "smoke_server_ui": smoke.get("runtime_contract", {}).get("server_ui"),
        "smoke_typings": smoke.get("runtime_contract", {}).get("typing_packages"),
        "required_experiments": smoke.get("runtime_contract", {}).get("required_experiments"),
        "api_audit": api_audit,
        "compatibility": compatibility,
    }


def validate_contract(values: dict[str, Any]) -> list[str]:
    errors: list[str] = []

    def expect(key: str, expected: Any) -> None:
        if values.get(key) != expected:
            errors.append(f"{key}: expected {expected!r}, got {values.get(key)!r}")

    expect("engine_floor", EXPECTED_ENGINE_FLOOR)
    expect("resource_engine_floor", EXPECTED_ENGINE_FLOOR)
    expect("runtime_server", EXPECTED_RUNTIME_SERVER)
    expect("runtime_server_ui", EXPECTED_RUNTIME_SERVER_UI)
    expect("typing_server", EXPECTED_TYPING_SERVER)
    expect("typing_server_ui", EXPECTED_TYPING_SERVER_UI)
    expect("product_line", EXPECTED_PRODUCT_LINE)
    expect("smoke_server", EXPECTED_RUNTIME_SERVER)
    expect("smoke_server_ui", EXPECTED_RUNTIME_SERVER_UI)
    expect(
        "smoke_typings",
        [
            f"@minecraft/server@{EXPECTED_TYPING_SERVER}",
            f"@minecraft/server-ui@{EXPECTED_TYPING_SERVER_UI}",
        ],
    )

    if EXPECTED_EXPERIMENT not in (values.get("required_experiments") or []):
        errors.append(f"required_experiments: missing {EXPECTED_EXPERIMENT!r}")

    api_audit = values.get("api_audit", "")
    compatibility = values.get("compatibility", "")
    required_api_fragments = (
        "1.26.50 preview line",
        "2.11.0-beta",
        "2.11.0-beta.1.26.50-preview.26",
        "2.1.0",
        "2.3.0-beta.1.26.50-preview.26",
        "Beta APIs",
        "Do not silently replace the beta dependency",
        "runtime-smoke-test",
    )
    for fragment in required_api_fragments:
        if fragment not in api_audit:
            errors.append(f"API_AUDIT.md: missing required contract evidence {fragment!r}")

    required_compatibility_fragments = (
        "Minecraft Bedrock 1.26.50 preview line",
        "min_engine_version: [1, 26, 50]",
        "@minecraft/server` `2.11.0-beta",
        "Beta APIs",
        "preview.26",
    )
    for fragment in required_compatibility_fragments:
        if fragment not in compatibility:
            errors.append(f"BEDROCK_COMPATIBILITY.md: missing required evidence {fragment!r}")

    if values.get("runtime_server") and not str(values["runtime_server"]).endswith("-beta"):
        errors.append("runtime_server: the selected shipping ABI must remain beta")
    if re.search(r"\.isValid\?\.\s*\(", _runtime_dimension_sources(ROOT)):
        errors.append("runtime dimensions/performance code must not call undocumented Dimension.isValid()")

    return errors


def _runtime_dimension_sources(root: Path) -> str:
    addon = root / "TheBrokenScript_Bedrock_2_0"
    paths = (
        addon / "BP" / "scripts" / "systems" / "dimensions.js",
        addon / "BP" / "scripts" / "systems" / "perf.js",
        addon / "src" / "systems" / "dimensions.js",
        addon / "src" / "systems" / "perf.js",
    )
    return "\n".join(path.read_text(encoding="utf-8") for path in paths if path.exists())


def _report(values: dict[str, Any], errors: list[str]) -> dict[str, Any]:
    return {
        "status": "ok" if not errors else "error",
        "contract": {
            key: value
            for key, value in values.items()
            if key not in {"api_audit", "compatibility"}
        },
        "errors": errors,
    }


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check", action="store_true", help="fail if any contract surface drifts")
    parser.add_argument("--report", type=Path, help="write a JSON validation report")
    args = parser.parse_args(argv)

    try:
        values = read_contract()
        errors = validate_contract(values)
    except (OSError, ValueError, json.JSONDecodeError) as error:
        values = {}
        errors = [str(error)]

    if args.report:
        args.report.parent.mkdir(parents=True, exist_ok=True)
        args.report.write_text(json.dumps(_report(values, errors), indent=2, sort_keys=True) + "\n", encoding="utf-8")

    if errors:
        for error in errors:
            print(f"P2 contract: ERROR: {error}", file=sys.stderr)
        return 1 if args.check else 0

    print("P2 contract: OK (Bedrock 1.26.50 preview beta ABI is aligned)")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
