#!/usr/bin/env python3
"""Detect conservative, evidence-backed parity rollup/source-map disagreements."""

from __future__ import annotations

import argparse
import json
import re
import sys
from collections import defaultdict
from pathlib import Path, PurePosixPath
from typing import Any

ROOT = Path(__file__).resolve().parents[1]
DEFAULT_SOURCE_MAP = ROOT / "TheBrokenScript_Bedrock_2_0" / "SOURCE_MAP.json"
DEFAULT_PARITY_MATRIX = ROOT / "TheBrokenScript_Bedrock_2_0" / "PARITY_MATRIX.md"

STATUS_RANK = {
    "uninspected": 0,
    "analyzed": 1,
    "in_progress": 2,
    "ported": 3,
    "validated": 4,
}
ROLLUP_MINIMUM = {
    "ported": STATUS_RANK["ported"],
    "validated": STATUS_RANK["validated"],
}


def _canonical_status(value: str) -> str | None:
    match = re.match(r"\s*([a-z_]+)", value.lower())
    return match.group(1) if match else None


def _split_markdown_row(line: str) -> list[str]:
    return [cell.strip() for cell in line.strip().strip("|").split("|")]


def parse_family_rows(parity_matrix: str) -> list[dict[str, str]]:
    """Parse the family rollup table from PARITY_MATRIX.md."""
    lines = parity_matrix.splitlines()
    header_index = None
    headers: list[str] = []
    for index, line in enumerate(lines):
        cells = _split_markdown_row(line) if line.lstrip().startswith("|") else []
        if cells[:5] == [
            "Source Feature",
            "Source Evidence",
            "Bedrock Implementation",
            "Status",
            "Parity",
        ]:
            header_index = index
            headers = cells
            break

    if header_index is None:
        raise ValueError("PARITY_MATRIX.md is missing the family rollup table")

    families: list[dict[str, str]] = []
    for line in lines[header_index + 2 :]:
        if not line.lstrip().startswith("|"):
            break
        cells = _split_markdown_row(line)
        if len(cells) != len(headers):
            raise ValueError(f"malformed PARITY_MATRIX.md table row: {line}")
        families.append(dict(zip(headers, cells)))
    return families


def _evidence_terms(value: str) -> list[str]:
    # Comma-separated evidence items are the matrix's explicit source references.
    # Strip Markdown code quoting only; do not stem, fuzzy-match, or infer prefixes.
    terms: list[str] = []
    for part in value.split(","):
        term = part.strip().strip("`").strip()
        if term:
            terms.append(term)
    return terms


def _source_aliases(row: dict[str, Any]) -> set[str]:
    aliases: set[str] = set()
    source_id = row.get("source_id")
    if isinstance(source_id, str) and source_id:
        aliases.add(source_id)

    source_paths = row.get("source_paths", [])
    if not isinstance(source_paths, list):
        return aliases
    for source_path in source_paths:
        if not isinstance(source_path, str) or not source_path:
            continue
        aliases.add(source_path)
        name = PurePosixPath(source_path).name
        if name:
            aliases.add(name)
            stem = PurePosixPath(name).stem
            if stem:
                aliases.add(stem)
    return aliases


def find_obvious_disagreements(
    source_map: dict[str, Any], parity_matrix: str
) -> list[str]:
    """Return only disagreements supported by unique, exact Source Evidence matches.

    A family rollup claiming ``ported`` or ``validated`` cannot be ahead of a
    uniquely and exactly referenced component row. Less-complete rollups are not
    inferred from a subset of their evidence, because doing so would require
    guessing family membership or aggregation semantics.
    """
    rows = source_map.get("rows")
    if not isinstance(rows, list):
        raise ValueError("SOURCE_MAP.json must contain a 'rows' array")

    alias_index: dict[str, list[tuple[int, dict[str, Any]]]] = defaultdict(list)
    for index, row in enumerate(rows):
        if not isinstance(row, dict):
            raise ValueError(f"SOURCE_MAP.json rows[{index}] must be an object")
        for alias in _source_aliases(row):
            alias_index[alias].append((index, row))

    disagreements: list[str] = []
    for family in parse_family_rows(parity_matrix):
        feature = family["Source Feature"]
        family_status_text = family["Status"]
        family_status = _canonical_status(family_status_text)
        minimum = ROLLUP_MINIMUM.get(family_status or "")
        if minimum is None:
            continue

        matched_rows: dict[int, tuple[dict[str, Any], str]] = {}
        for term in _evidence_terms(family["Source Evidence"]):
            matches = alias_index.get(term, [])
            if len(matches) != 1:
                continue
            index, row = matches[0]
            matched_rows.setdefault(index, (row, term))

        for index in sorted(matched_rows):
            row, term = matched_rows[index]
            source_status = row.get("status")
            if not isinstance(source_status, str):
                continue
            normalized = source_status.lower()
            rank = STATUS_RANK.get(normalized)
            if rank is None:
                # Unknown status semantics are intentionally not guessed here.
                continue
            if rank >= minimum:
                continue

            source_id = row.get("source_id")
            label = source_id if isinstance(source_id, str) and source_id else f"rows[{index}]"
            disagreements.append(
                f"{feature}: family status={family_status_text}; "
                f"{label} status={source_status} "
                f"(exact Source Evidence match: {term})"
            )

    return disagreements


def validate_parity_source_map(source_map_path: Path, parity_matrix_path: Path) -> list[str]:
    try:
        payload = json.loads(source_map_path.read_text(encoding="utf-8"))
    except OSError as exc:
        raise ValueError(f"could not read {source_map_path}: {exc}") from exc
    except json.JSONDecodeError as exc:
        raise ValueError(
            f"invalid JSON in {source_map_path}: line {exc.lineno}, column {exc.colno}: {exc.msg}"
        ) from exc
    if not isinstance(payload, dict):
        raise ValueError("SOURCE_MAP.json root must be an object")

    try:
        parity_matrix = parity_matrix_path.read_text(encoding="utf-8")
    except OSError as exc:
        raise ValueError(f"could not read {parity_matrix_path}: {exc}") from exc

    return find_obvious_disagreements(payload, parity_matrix)


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(
        description=(
            "Detect conservative, evidence-backed disagreement between PARITY_MATRIX.md "
            "family rollups and SOURCE_MAP.json component statuses."
        )
    )
    parser.add_argument(
        "--source-map",
        type=Path,
        default=DEFAULT_SOURCE_MAP,
        help=f"source-map path (default: {DEFAULT_SOURCE_MAP})",
    )
    parser.add_argument(
        "--parity-matrix",
        type=Path,
        default=DEFAULT_PARITY_MATRIX,
        help=f"parity-matrix path (default: {DEFAULT_PARITY_MATRIX})",
    )
    return parser.parse_args()


def main() -> int:
    args = parse_args()
    try:
        disagreements = validate_parity_source_map(args.source_map, args.parity_matrix)
    except ValueError as exc:
        print(f"Parity/source-map validation failed: {exc}", file=sys.stderr)
        return 1

    if disagreements:
        print(
            f"Parity/source-map validation failed: {len(disagreements)} obvious "
            f"disagreement{'s' if len(disagreements) != 1 else ''}:",
            file=sys.stderr,
        )
        for item in disagreements:
            print(f"- {item}", file=sys.stderr)
        return 1

    print("Parity/source-map validation passed: no obvious evidence-backed disagreements found.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
