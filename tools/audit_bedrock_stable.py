#!/usr/bin/env python3
"""Audit the behavior pack for a stable Bedrock Script API baseline.

The port intentionally defaults to stable Script API dependencies. Preview/beta
dependencies and known preview-only compatibility fallbacks must be explicit,
reviewed exceptions rather than silently required by the shipping pack.
"""

from __future__ import annotations

import argparse
import json
import re
import sys
from dataclasses import dataclass
from pathlib import Path
from typing import Any

REPO_ROOT = Path(__file__).resolve().parents[1]
DEFAULT_PROJECT_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0"
STABLE_SERVER_BASELINE = (2, 9, 0)
PREVIEW_MARKERS = ("-beta", "-rc", "-preview", "-internal")

# These patterns previously forced the add-on onto preview builds. Add entries
# only when first-party stable docs confirm the surface is unavailable there.
BANNED_SCRIPT_PATTERNS: tuple[tuple[str, re.Pattern[str]], ...] = (
    ("preview dynamic-dimension fallback", re.compile(r"\bworld\s*\.\s*createDimension\s*\(")),
)


@dataclass(frozen=True)
class AuditResult:
    errors: tuple[str, ...]
    warnings: tuple[str, ...]
    scripts_checked: int

    @property
    def ok(self) -> bool:
        return not self.errors


def _load_json(path: Path, errors: list[str]) -> dict[str, Any] | None:
    try:
        data = json.loads(path.read_text(encoding="utf-8-sig"))
    except (OSError, json.JSONDecodeError) as exc:
        errors.append(f"{path}: invalid JSON: {exc}")
        return None
    if not isinstance(data, dict):
        errors.append(f"{path}: root must be a JSON object")
        return None
    return data


def _parse_stable_version(raw: Any) -> tuple[int, int, int] | None:
    if not isinstance(raw, str) or any(marker in raw.lower() for marker in PREVIEW_MARKERS):
        return None
    match = re.fullmatch(r"(\d+)\.(\d+)\.(\d+)", raw)
    if not match:
        return None
    return tuple(int(part) for part in match.groups())


def _audit_manifest(bp_root: Path, errors: list[str], warnings: list[str]) -> None:
    path = bp_root / "manifest.json"
    data = _load_json(path, errors)
    if data is None:
        return

    header = data.get("header")
    if not isinstance(header, dict):
        errors.append(f"{path}: missing header object")
    else:
        mev = header.get("min_engine_version")
        if not (
            isinstance(mev, list)
            and len(mev) == 3
            and all(isinstance(v, int) and not isinstance(v, bool) and v >= 0 for v in mev)
        ):
            errors.append(f"{path}: min_engine_version must be a three-integer array")

    dependencies = data.get("dependencies")
    if not isinstance(dependencies, list):
        errors.append(f"{path}: dependencies must be an array")
        return

    server_seen = False
    for index, dep in enumerate(dependencies):
        if not isinstance(dep, dict):
            errors.append(f"{path}: dependencies[{index}] must be an object")
            continue
        module_name = dep.get("module_name")
        if not isinstance(module_name, str):
            continue
        version = dep.get("version")
        if not isinstance(version, str):
            errors.append(f"{path}: {module_name} dependency must use a string module version")
            continue
        lowered = version.lower()
        if any(marker in lowered for marker in PREVIEW_MARKERS):
            errors.append(
                f"{path}: {module_name} uses preview dependency {version!r}; "
                "shipping manifest must default to stable APIs"
            )
        if module_name == "@minecraft/server":
            server_seen = True
            parsed = _parse_stable_version(version)
            if parsed is None:
                errors.append(f"{path}: @minecraft/server version {version!r} is not a stable semantic version")
            elif parsed < STABLE_SERVER_BASELINE:
                errors.append(
                    f"{path}: @minecraft/server {version} is below the reviewed stable "
                    f"baseline {'.'.join(map(str, STABLE_SERVER_BASELINE))}"
                )
            elif parsed > STABLE_SERVER_BASELINE:
                warnings.append(
                    f"{path}: @minecraft/server {version} is newer than reviewed baseline "
                    f"{'.'.join(map(str, STABLE_SERVER_BASELINE))}; refresh API_AUDIT.md"
                )

    if not server_seen:
        errors.append(f"{path}: missing @minecraft/server dependency")


def _strip_js_comments(text: str) -> str:
    # Conservative scanner: removing comments avoids false positives in migration
    # notes while leaving strings intact. The banned patterns are API-shaped and
    # intentionally narrow, so matching a literal string is still worth review.
    text = re.sub(r"/\*.*?\*/", "", text, flags=re.S)
    text = re.sub(r"(^|[^:])//.*?$", r"\1", text, flags=re.M)
    return text


def _audit_scripts(bp_root: Path, errors: list[str]) -> int:
    scripts_root = bp_root / "scripts"
    if not scripts_root.is_dir():
        errors.append(f"{scripts_root}: scripts directory is missing")
        return 0

    checked = 0
    for path in sorted(scripts_root.rglob("*.js")):
        checked += 1
        try:
            text = path.read_text(encoding="utf-8-sig")
        except OSError as exc:
            errors.append(f"{path}: cannot read script: {exc}")
            continue
        scan_text = _strip_js_comments(text)
        for label, pattern in BANNED_SCRIPT_PATTERNS:
            for match in pattern.finditer(scan_text):
                line = scan_text.count("\n", 0, match.start()) + 1
                errors.append(f"{path}:{line}: banned {label}: {match.group(0)!r}")
    return checked


def _audit_jigsaw(project_root: Path, errors: list[str]) -> None:
    # Import the repository validator without adding third-party dependencies.
    tools_root = REPO_ROOT / "tools"
    sys.path.insert(0, str(tools_root))
    try:
        from validate_jigsaw_worldgen import validate_pack
    except Exception as exc:
        errors.append(f"cannot import tools/validate_jigsaw_worldgen.py: {exc}")
        return
    finally:
        try:
            sys.path.remove(str(tools_root))
        except ValueError:
            pass

    result = validate_pack(project_root / "BP")
    errors.extend(f"jigsaw: {message}" for message in result.errors)


def audit(project_root: Path) -> AuditResult:
    errors: list[str] = []
    warnings: list[str] = []
    bp_root = project_root / "BP"

    _audit_manifest(bp_root, errors, warnings)
    scripts_checked = _audit_scripts(bp_root, errors)
    _audit_jigsaw(project_root, errors)

    return AuditResult(
        errors=tuple(errors),
        warnings=tuple(warnings),
        scripts_checked=scripts_checked,
    )


def _parse_args(argv: list[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--project-root", type=Path, default=DEFAULT_PROJECT_ROOT)
    return parser.parse_args(argv)


def main(argv: list[str] | None = None) -> int:
    args = _parse_args(sys.argv[1:] if argv is None else argv)
    result = audit(args.project_root)

    for warning in result.warnings:
        print(f"WARNING: {warning}", file=sys.stderr)

    if result.errors:
        for error in result.errors:
            print(f"ERROR: {error}", file=sys.stderr)
        print(
            f"Stable API audit failed: {len(result.errors)} error(s), "
            f"{len(result.warnings)} warning(s), {result.scripts_checked} script(s) checked.",
            file=sys.stderr,
        )
        return 1

    print(
        f"Stable API audit passed: {result.scripts_checked} script(s) checked; "
        f"{len(result.warnings)} warning(s)."
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
