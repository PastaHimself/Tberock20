#!/usr/bin/env python3
"""Print semantic-audit inventory for SOURCE_MAP without modifying repository state."""
from __future__ import annotations

import json
from collections import Counter, defaultdict
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
SOURCE_MAP = ROOT / "TheBrokenScript_Bedrock_2_0" / "SOURCE_MAP.json"
UNRESOLVED_STATUS = {"uninspected", "analyzed", "in_progress", "unknown", "deferred"}
UNRESOLVED_PARITY = {"unknown", "approximation-pending", "unsupported-pending", "pending"}
MIXED = {"entity", "item", "code_package", "damage_type", "gui", "particle", "dimension", "music", "painting", "structures"}


def unresolved(row: dict) -> bool:
    return str(row.get("status", "")).strip().lower() in UNRESOLVED_STATUS or str(row.get("parity", "")).strip().lower() in UNRESOLVED_PARITY


def main() -> int:
    rows = json.loads(SOURCE_MAP.read_text(encoding="utf-8-sig"))["rows"]
    by_category: dict[str, list[dict]] = defaultdict(list)
    for row in rows:
        by_category[str(row.get("category", ""))].append(row)

    print(f"SOURCE_MAP semantic inventory: {len(rows)} rows")
    for category in sorted(by_category):
        category_rows = by_category[category]
        unresolved_rows = [row for row in category_rows if unresolved(row)]
        combos = Counter((str(row.get("status", "")), str(row.get("parity", ""))) for row in category_rows)
        combo_text = ", ".join(f"{status}/{parity}={count}" for (status, parity), count in sorted(combos.items()))
        print(f"CATEGORY {category}: total={len(category_rows)} unresolved={len(unresolved_rows)} :: {combo_text}")
        if category in MIXED and unresolved_rows:
            for row in unresolved_rows:
                files = ",".join(row.get("bedrock_files") or [])
                paths = ",".join(row.get("source_paths") or [])
                print(f"  MIXED {row.get('source_id')} | bedrock={files or '-'} | source={paths or '-'}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
