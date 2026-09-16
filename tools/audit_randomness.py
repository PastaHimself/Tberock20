#!/usr/bin/env python3
"""Inventory Java and Bedrock randomness call sites.

The report is deliberately static. It records every recognizable Java random
draw/source and every direct Bedrock ``Math.random`` call, then assigns each
call a reviewed provenance scope. A new or ambiguous call fails ``--check``
until its scope classifier is updated, which keeps probability/order review
from silently going stale.
"""

from __future__ import annotations

import argparse
from collections import Counter
import json
import re
import sys
from pathlib import Path
from typing import Any


ROOT = Path(__file__).resolve().parents[1]
AUDIT_VERSION = 1
JAVA_ROOTS = ("decompiled", "decompiled_brokencore")
SCOPES = {
    "world",
    "entity",
    "injected",
    "local",
    "client",
    "runtime-global",
    "runtime-default",
    "horror-event-adapter",
    "unknown",
}

JAVA_DRAW_RE = re.compile(
    r"(?P<receiver>[A-Za-z_$][\w$]*(?:\.[A-Za-z_$][\w$]*)*)\."
    r"(?P<method>nextInt|nextFloat|nextDouble|nextBoolean)\s*\("
)
JAVA_SOURCE_PATTERNS = (
    ("RandomSource.create", re.compile(r"\bRandomSource\.create\s*\(")),
    ("Random.Default", re.compile(r"\bRandom\.Default\b")),
    ("CollectionsKt.random", re.compile(r"\bCollectionsKt\.random\s*\(")),
    ("ArraysKt.random", re.compile(r"\bArraysKt\.random\s*\(")),
    ("getRandom", re.compile(r"\b[A-Za-z_$][\w$]*\.getRandom\s*\(")),
)
MATH_RANDOM_RE = re.compile(r"\bMath\.random\s*\(")
STRING_RE = re.compile(r"\"(?:\\.|[^\"\\])*\"|'(?:\\.|[^'\\])*'")
BLOCK_COMMENT_RE = re.compile(r"/\*.*?\*/", re.DOTALL)
LINE_COMMENT_RE = re.compile(r"//[^\n]*")


def _preserve_newlines(match: re.Match[str]) -> str:
    return "".join("\n" if char == "\n" else " " for char in match.group(0))


def _mask_code(text: str) -> str:
    """Remove comments/strings while retaining line positions."""

    masked = STRING_RE.sub(_preserve_newlines, text)
    masked = BLOCK_COMMENT_RE.sub(_preserve_newlines, masked)
    return LINE_COMMENT_RE.sub(_preserve_newlines, masked)


def _relative(path: Path, root: Path) -> str:
    return path.relative_to(root).as_posix()


def _context(lines: list[str], index: int, radius: int = 3) -> str:
    start = max(0, index - radius)
    end = min(len(lines), index + radius + 1)
    return " ".join(lines[start:end])


def _java_scope(path: str, receiver: str, line: str, context: str) -> str:
    lowered_path = path.lower()
    lowered = f"{line} {context}".lower()
    lowered_receiver = receiver.lower()

    if (
        "/client/" in lowered_path
        or "/renderer/" in lowered_path
        or "/mixins/features/screen/" in lowered_path
    ):
        return "client"
    if "random.default" in lowered or "randomsource.create" in lowered:
        return "local"
    if "getrandom()" in lowered or "this.random" in lowered or re.search(
        r"(?:^|[.$])(?:player|serverplayer|mob|entity|this)\.random\b", lowered_receiver
    ):
        return "entity"
    if re.search(r"(?:level|serverlevel|world|place\w*)\.random\b", lowered):
        return "world"
    if lowered_receiver.endswith(".random") and any(
        token in lowered_receiver for token in ("level", "world", "place", "structure")
    ):
        return "world"
    if lowered_receiver in {
        "random",
        "rng",
        "randomsource",
        "rand",
        "randumb",
        "randomutil",
        "mth",
    } or lowered_receiver.startswith("$this$"):
        return "injected"
    if lowered_receiver.endswith(".random") or lowered_receiver.endswith(".rng"):
        return "injected"
    return "unknown"


def _source_scope(path: str, api: str, line: str, context: str) -> str:
    if api in {"RandomSource.create", "Random.Default"}:
        return "client" if "/client/" in path.lower() else "local"
    if api in {"CollectionsKt.random", "ArraysKt.random"}:
        return "local"
    receiver_match = re.search(r"\b([A-Za-z_$][\w$]*)\.getRandom\s*\(", line)
    receiver = receiver_match.group(1) if receiver_match else ""
    return _java_scope(path, receiver, line, context)


def _scan_java(root: Path) -> tuple[list[dict[str, Any]], list[dict[str, Any]]]:
    draws: list[dict[str, Any]] = []
    sources: list[dict[str, Any]] = []

    for root_name in JAVA_ROOTS:
        source_root = root / root_name
        for path in sorted(source_root.rglob("*.java")):
            original_lines = path.read_text(encoding="utf-8", errors="replace").splitlines()
            masked_lines = _mask_code("\n".join(original_lines)).splitlines()
            relative = _relative(path, root)

            for index, masked_line in enumerate(masked_lines):
                original_line = original_lines[index] if index < len(original_lines) else ""
                context = _context(masked_lines, index)
                for match in JAVA_DRAW_RE.finditer(masked_line):
                    draws.append({
                        "path": relative,
                        "line": index + 1,
                        "column": match.start() + 1,
                        "kind": "draw",
                        "api": match.group("method"),
                        "receiver": match.group("receiver"),
                        "scope": _java_scope(relative, match.group("receiver"), masked_line, context),
                        "expression": original_line.strip(),
                    })

                for api, pattern in JAVA_SOURCE_PATTERNS:
                    for source_match in pattern.finditer(masked_line):
                        sources.append({
                            "path": relative,
                            "line": index + 1,
                            "column": source_match.start() + 1,
                            "kind": "source",
                            "api": api,
                            "scope": _source_scope(relative, api, masked_line, context),
                            "expression": original_line.strip(),
                        })

    draws.sort(key=lambda item: (item["path"], item["line"], item["column"]))
    sources.sort(key=lambda item: (item["path"], item["line"], item["column"], item["api"]))
    return draws, sources


def _bedrock_scope(path: str) -> str:
    if path.endswith("core/random.js"):
        return "runtime-default"
    if path.endswith("systems/horror_events.js"):
        return "horror-event-adapter"
    return "runtime-global"


def _scan_bedrock(root: Path) -> list[dict[str, Any]]:
    calls: list[dict[str, Any]] = []
    scripts_root = root / "TheBrokenScript_Bedrock_2_0" / "BP" / "scripts"
    for path in sorted(scripts_root.rglob("*.js")):
        original_lines = path.read_text(encoding="utf-8", errors="replace").splitlines()
        masked_lines = _mask_code("\n".join(original_lines)).splitlines()
        relative = _relative(path, root)
        scope = _bedrock_scope(relative)
        for index, masked_line in enumerate(masked_lines):
            for match in MATH_RANDOM_RE.finditer(masked_line):
                calls.append({
                    "path": relative,
                    "line": index + 1,
                    "column": match.start() + 1,
                    "kind": "draw",
                    "api": "Math.random",
                    "scope": scope,
                    "expression": original_lines[index].strip(),
                })
    calls.sort(key=lambda item: (item["path"], item["line"], item["column"]))
    return calls


def _counts(records: list[dict[str, Any]]) -> dict[str, int]:
    return dict(sorted(Counter(record["scope"] for record in records).items()))


def build_report(root: Path = ROOT) -> dict[str, Any]:
    java_draws, java_sources = _scan_java(root)
    bedrock_calls = _scan_bedrock(root)
    bedrock_files = sorted({record["path"] for record in bedrock_calls})
    return {
        "audit_version": AUDIT_VERSION,
        "java": {
            "roots": list(JAVA_ROOTS),
            "draw_count": len(java_draws),
            "source_count": len(java_sources),
            "scope_counts": _counts(java_draws),
            "source_scope_counts": _counts(java_sources),
            "draws": java_draws,
            "sources": java_sources,
        },
        "bedrock": {
            "math_random_count": len(bedrock_calls),
            "files": bedrock_files,
            "scope_counts": _counts(bedrock_calls),
            "calls": bedrock_calls,
        },
    }


def validate_report(report: dict[str, Any]) -> list[str]:
    errors: list[str] = []
    if report.get("audit_version") != AUDIT_VERSION:
        errors.append(f"unsupported audit_version: {report.get('audit_version')!r}")

    for section, record_key in (("java", "draws"), ("java", "sources"), ("bedrock", "calls")):
        records = report.get(section, {}).get(record_key, [])
        if not isinstance(records, list):
            errors.append(f"{section}.{record_key} must be an array")
            continue
        for record in records:
            scope = record.get("scope")
            if scope not in SCOPES:
                errors.append(f"{section}.{record_key} {record.get('path')}:{record.get('line')} has invalid scope {scope!r}")
            elif scope == "unknown":
                errors.append(f"{section}.{record_key} {record.get('path')}:{record.get('line')} has unreviewed scope")
            for required in ("path", "line", "kind", "api", "scope"):
                if required not in record:
                    errors.append(f"{section}.{record_key} record is missing {required!r}")

    java = report.get("java", {})
    if java.get("draw_count") != len(java.get("draws", [])):
        errors.append("java.draw_count does not match java.draws")
    if java.get("source_count") != len(java.get("sources", [])):
        errors.append("java.source_count does not match java.sources")
    bedrock = report.get("bedrock", {})
    if bedrock.get("math_random_count") != len(bedrock.get("calls", [])):
        errors.append("bedrock.math_random_count does not match bedrock.calls")
    if bedrock.get("files") != sorted({record.get("path") for record in bedrock.get("calls", [])}):
        errors.append("bedrock.files does not match bedrock.calls")
    return errors


def _write_json(path: Path, value: dict[str, Any]) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value, indent=2, sort_keys=True) + "\n", encoding="utf-8")


def _markdown(report: dict[str, Any]) -> str:
    java = report["java"]
    bedrock = report["bedrock"]
    lines = [
        "# Randomness audit",
        "",
        "This is a deterministic static inventory of Java random draws/sources and direct Bedrock `Math.random()` calls.",
        "It does not claim that a Bedrock engine run reproduces a Java PRNG seed.",
        "",
        "## Inventory",
        "",
        f"- Java random draws: **{java['draw_count']}**",
        f"- Java random source expressions: **{java['source_count']}**",
        f"- Bedrock `Math.random()` calls: **{bedrock['math_random_count']}**",
        f"- Bedrock runtime files with direct draws: **{len(bedrock['files'])}**",
        "",
        "| Scope | Java draws | Java sources | Bedrock draws |",
        "| --- | ---: | ---: | ---: |",
    ]
    scopes = sorted(set(java["scope_counts"]) | set(java["source_scope_counts"]) | set(bedrock["scope_counts"]))
    for scope in scopes:
        lines.append(
            f"| `{scope}` | {java['scope_counts'].get(scope, 0)} | "
            f"{java['source_scope_counts'].get(scope, 0)} | {bedrock['scope_counts'].get(scope, 0)} |"
        )
    lines.extend([
        "",
        "## Scope rules",
        "",
        "- `world`: `level.random`/world-owned random streams.",
        "- `entity`: entity/player-owned random streams such as `getRandom()`.",
        "- `injected`: a method-provided `RandomSource`/random receiver.",
        "- `local`: Kotlin `Random.Default` or a newly created local source.",
        "- `client`: client-only/render/particle randomness, tracked separately from server parity.",
        "- Bedrock runtime scopes distinguish the default helper, the ambient horror adapter, and other direct calls.",
        "",
        "A new callsite that the classifier cannot scope fails `python tools/audit_randomness.py --check` and must be reviewed before merging.",
        "",
        "## Java file inventory",
        "",
        "The JSON report contains every line-level record. This compact table keeps the checked-in review surface readable while showing every Java file with a recognized source or draw.",
        "",
        "| File | Draws | Sources | Scopes |",
        "| --- | ---: | ---: | --- |",
    ])
    java_by_file: dict[str, dict[str, Any]] = {}
    for record in java["draws"]:
        entry = java_by_file.setdefault(record["path"], {"draws": 0, "sources": 0, "scopes": set()})
        entry["draws"] += 1
        entry["scopes"].add(record["scope"])
    for record in java["sources"]:
        entry = java_by_file.setdefault(record["path"], {"draws": 0, "sources": 0, "scopes": set()})
        entry["sources"] += 1
        entry["scopes"].add(record["scope"])
    for path in sorted(java_by_file):
        entry = java_by_file[path]
        lines.append(
            f"| `{path}` | {entry['draws']} | {entry['sources']} | "
            + ", ".join(f"`{scope}`" for scope in sorted(entry["scopes"]))
            + " |"
        )
    lines.extend([
        "",
        "## Bedrock file inventory",
        "",
        "| File | Direct `Math.random()` calls | Scope |",
        "| --- | ---: | --- |",
    ])
    bedrock_by_file: dict[str, dict[str, Any]] = {}
    for record in bedrock["calls"]:
        entry = bedrock_by_file.setdefault(record["path"], {"count": 0, "scope": record["scope"]})
        entry["count"] += 1
    for path in sorted(bedrock_by_file):
        entry = bedrock_by_file[path]
        lines.append(f"| `{path}` | {entry['count']} | `{entry['scope']}` |")
    lines.append("")
    return "\n".join(lines)


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check", action="store_true", help="validate the generated inventory")
    parser.add_argument("--report", type=Path, help="write deterministic JSON report")
    parser.add_argument("--markdown", type=Path, help="write deterministic Markdown summary")
    args = parser.parse_args(argv)

    report = build_report()
    errors = validate_report(report)
    if args.report:
        _write_json(args.report, report)
    if args.markdown:
        args.markdown.parent.mkdir(parents=True, exist_ok=True)
        args.markdown.write_text(_markdown(report), encoding="utf-8")

    if errors:
        for error in errors:
            print(f"randomness audit: ERROR: {error}", file=sys.stderr)
        return 1 if args.check else 0

    print(
        f"randomness audit: OK ({report['java']['draw_count']} Java draws, "
        f"{report['java']['source_count']} Java sources, "
        f"{report['bedrock']['math_random_count']} Bedrock Math.random calls)"
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
