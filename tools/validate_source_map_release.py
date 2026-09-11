#!/usr/bin/env python3
"""Block release packaging while SOURCE_MAP.json contains unresolved entries."""

from __future__ import annotations

import argparse
import json
import sys
from pathlib import Path
from typing import Any


UNRESOLVED_VALUES = frozenset({"uninspected", "unknown", "in_progress"})
STATUS_FIELDS = ("status", "parity")
DEFAULT_SOURCE_MAP = (
    Path(__file__).resolve().parents[1]
    / "TheBrokenScript_Bedrock_2_0"
    / "SOURCE_MAP.json"
)


def find_unresolved_entries(source_map: dict[str, Any]) -> list[str]:
    """Return actionable descriptions of rows with unresolved status/parity values."""
    rows = source_map.get("rows")
    if not isinstance(rows, list):
        raise ValueError("SOURCE_MAP.json must contain a 'rows' array")

    unresolved: list[str] = []
    for index, row in enumerate(rows):
        if not isinstance(row, dict):
            raise ValueError(f"SOURCE_MAP.json rows[{index}] must be an object")

        hits = [
            f"{field}={row[field]}"
            for field in STATUS_FIELDS
            if row.get(field) in UNRESOLVED_VALUES
        ]
        if not hits:
            continue

        source_id = row.get("source_id")
        label = source_id if isinstance(source_id, str) and source_id else f"rows[{index}]"
        unresolved.append(f"{label}: {', '.join(hits)}")

    return unresolved


def validate_source_map(source_map_path: Path) -> list[str]:
    """Load a source map and return all unresolved row descriptions."""
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
    return find_unresolved_entries(payload)


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(
        description="Fail if SOURCE_MAP.json contains unresolved release statuses."
    )
    parser.add_argument(
        "source_map",
        nargs="?",
        type=Path,
        default=DEFAULT_SOURCE_MAP,
        help=f"source-map path (default: {DEFAULT_SOURCE_MAP})",
    )
    return parser.parse_args()


def main() -> int:
    args = parse_args()
    try:
        unresolved = validate_source_map(args.source_map)
    except ValueError as exc:
        print(f"Source-map release validation failed: {exc}", file=sys.stderr)
        return 1

    if unresolved:
        print(
            f"Source-map release validation failed: {len(unresolved)} unresolved "
            f"entr{'y' if len(unresolved) == 1 else 'ies'} in {args.source_map}:",
            file=sys.stderr,
        )
        for item in unresolved:
            print(f"- {item}", file=sys.stderr)
        print(
            "Resolve all uninspected, unknown, and in_progress source-map statuses "
            "before release packaging.",
            file=sys.stderr,
        )
        return 1

    print(f"Source-map release validation passed: {args.source_map}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
