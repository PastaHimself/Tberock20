#!/usr/bin/env python3
"""Audit every SOURCE_MAP Bedrock path reference against the current repository tree."""
from __future__ import annotations

import argparse
import fnmatch
import json
import sys
from collections import Counter, defaultdict
from dataclasses import dataclass
from pathlib import Path, PurePosixPath

ROOT = Path(__file__).resolve().parents[1]
ADDON = ROOT / "TheBrokenScript_Bedrock_2_0"
SOURCE_MAP = ADDON / "SOURCE_MAP.json"
EXPECTED_ROWS = 912


@dataclass(frozen=True)
class Problem:
    source_id: str
    spec: str
    reason: str
    suggestions: tuple[str, ...] = ()


def _normalize_spec(raw: object) -> tuple[str | None, str | None]:
    if not isinstance(raw, str):
        return None, f"bedrock_files entry must be a string, found {type(raw).__name__}"
    spec = raw.strip().replace("\\", "/")
    if not spec:
        return None, "bedrock_files entry must not be empty"
    path = PurePosixPath(spec)
    if path.is_absolute() or ".." in path.parts:
        return None, "path must stay relative to TheBrokenScript_Bedrock_2_0"
    return spec, None


def _has_glob(spec: str) -> bool:
    return any(ch in spec for ch in "*?[")


def _repository_paths(project_root: Path) -> tuple[str, ...]:
    paths: list[str] = []
    for path in project_root.rglob("*"):
        try:
            rel = path.relative_to(project_root).as_posix()
        except ValueError:
            continue
        paths.append(rel + ("/" if path.is_dir() else ""))
    return tuple(sorted(paths))


def audit_source_map(source_map: Path = SOURCE_MAP, project_root: Path = ADDON) -> dict[str, object]:
    doc = json.loads(source_map.read_text(encoding="utf-8-sig"))
    rows = doc.get("rows")
    if not isinstance(rows, list):
        raise ValueError("SOURCE_MAP.json must contain a 'rows' array")

    problems: list[Problem] = []
    project_paths = _repository_paths(project_root)
    project_paths_plain = tuple(path[:-1] if path.endswith("/") else path for path in project_paths)
    lower_index: dict[str, list[str]] = defaultdict(list)
    for path in project_paths_plain:
        lower_index[path.lower()].append(path)

    rows_with_mappings = 0
    rows_without_mappings = 0
    total_specs = 0
    literal_specs = 0
    glob_specs = 0
    matched_targets: set[str] = set()
    spec_frequency: Counter[str] = Counter()

    for index, row in enumerate(rows):
        if not isinstance(row, dict):
            problems.append(Problem(f"row-{index}", "", "row must be an object"))
            continue
        source_id = str(row.get("source_id") or f"row-{index}")
        bedrock_files = row.get("bedrock_files", [])
        if bedrock_files is None:
            bedrock_files = []
        if not isinstance(bedrock_files, list):
            problems.append(Problem(source_id, "", "bedrock_files must be an array"))
            continue
        if bedrock_files:
            rows_with_mappings += 1
        else:
            rows_without_mappings += 1

        for raw_spec in bedrock_files:
            total_specs += 1
            spec, normalization_error = _normalize_spec(raw_spec)
            if normalization_error:
                problems.append(Problem(source_id, repr(raw_spec), normalization_error))
                continue
            assert spec is not None
            spec_frequency[spec] += 1

            if _has_glob(spec):
                glob_specs += 1
                matches = sorted(
                    path for path in project_paths_plain
                    if fnmatch.fnmatchcase(path, spec)
                )
                if matches:
                    matched_targets.update(matches)
                    continue
                ci_matches = sorted(
                    path for path in project_paths_plain
                    if fnmatch.fnmatchcase(path.lower(), spec.lower())
                )
                reason = "glob matches no current path"
                if ci_matches:
                    reason += "; case-insensitive matches exist"
                problems.append(Problem(source_id, spec, reason, tuple(ci_matches[:8])))
                continue

            literal_specs += 1
            target = project_root / PurePosixPath(spec)
            if target.exists():
                matched_targets.add(spec.rstrip("/"))
                continue

            ci_matches = sorted(lower_index.get(spec.rstrip("/").lower(), []))
            reason = "path does not exist"
            if ci_matches:
                reason += "; case mismatch"
            problems.append(Problem(source_id, spec, reason, tuple(ci_matches[:8])))

    return {
        "row_count": len(rows),
        "rows_with_mappings": rows_with_mappings,
        "rows_without_mappings": rows_without_mappings,
        "mapping_specs": total_specs,
        "literal_specs": literal_specs,
        "glob_specs": glob_specs,
        "unique_specs": len(spec_frequency),
        "duplicate_spec_uses": sum(count - 1 for count in spec_frequency.values() if count > 1),
        "matched_targets": len(matched_targets),
        "problems": problems,
    }


def format_problem(problem: Problem) -> str:
    message = f"{problem.source_id}: {problem.spec!r}: {problem.reason}"
    if problem.suggestions:
        message += f" (candidates: {', '.join(problem.suggestions)})"
    return message


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--source-map", type=Path, default=SOURCE_MAP)
    parser.add_argument("--project-root", type=Path, default=ADDON)
    args = parser.parse_args(argv)

    try:
        report = audit_source_map(args.source_map, args.project_root)
    except (OSError, ValueError, json.JSONDecodeError) as exc:
        print(f"SOURCE_MAP tree audit FAILED: {exc}")
        return 1

    problems = report["problems"]
    assert isinstance(problems, list)
    count_ok = report["row_count"] == EXPECTED_ROWS
    if not count_ok:
        print(
            f"SOURCE_MAP tree audit FAILED: expected {EXPECTED_ROWS} rows, "
            f"found {report['row_count']}"
        )
    if problems:
        if count_ok:
            print("SOURCE_MAP tree audit FAILED")
        for problem in problems:
            print(f"- {format_problem(problem)}")

    print(
        "SOURCE_MAP tree audit summary: "
        f"rows={report['row_count']}; "
        f"rows_with_mappings={report['rows_with_mappings']}; "
        f"rows_without_mappings={report['rows_without_mappings']}; "
        f"mapping_specs={report['mapping_specs']}; "
        f"literal_specs={report['literal_specs']}; "
        f"glob_specs={report['glob_specs']}; "
        f"unique_specs={report['unique_specs']}; "
        f"duplicate_spec_uses={report['duplicate_spec_uses']}; "
        f"matched_targets={report['matched_targets']}; "
        f"problems={len(problems)}"
    )
    return 0 if count_ok and not problems else 1


if __name__ == "__main__":
    sys.exit(main())
