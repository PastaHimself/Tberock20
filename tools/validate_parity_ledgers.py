#!/usr/bin/env python3
"""Validate SOURCE_MAP terminal classifications and family-level parity rollups."""
from __future__ import annotations

import json
import re
import sys
from collections import Counter, defaultdict
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
ADDON = ROOT / "TheBrokenScript_Bedrock_2_0"
SOURCE_MAP = ADDON / "SOURCE_MAP.json"
PARITY_MATRIX = ADDON / "PARITY_MATRIX.md"

TERMINAL = {
    ("ported", "full"): "exact port",
    ("validated", "full"): "exact port",
    ("ported", "high"): "validated high-parity port",
    ("validated", "high"): "validated high-parity port",
    ("ported", "approximation"): "validated approximation",
    ("validated", "approximation"): "validated approximation",
    ("blocked", "unsupported"): "engine-unsupported",
    ("excluded", "unsupported"): "intentionally excluded",
    ("excluded", "full"): "intentionally excluded",
}
UNRESOLVED_STATUS = {"uninspected", "analyzed", "in_progress", "unknown", "deferred"}
UNRESOLVED_PARITY = {"unknown", "approximation-pending", "unsupported-pending", "pending"}
NON_GAMEPLAY_CATEGORIES = {
    "metadata", "library", "build_artifact", "font", "texture", "model_geometry",
    "animation", "sound", "misc_asset", "embedded_packs", "embedded_resource_pack"
}
FAMILY_RULES = {
    "Entities & variants (remaining)": {"entity"},
    "Bosses (Integrity P1–3, Jimmy, Kerfur)": {"entity"},
    "Status effects (2)": {"status_effect"},
    "Events engine (~94 named)": {"horror_event", "event_engine"},
    "Chat responses (45)": {"chat_system"},
    "Blocks (123) + block entities (8)": {"block", "block_entity"},
    "Items (192)": {"item"},
    "Fluid void_liquid": {"fluid"},
    "Dimensions (13)": {"dimension"},
    "Biomes (15) + carver/features/noise": {"biome", "worldgen"},
    "Spawn conditions/modifiers (33)": {"spawn_rule"},
    "Recipes (40)": {"recipe"},
    "Loot tables": {"loot"},
    "Tags": {"tags"},
    "Advancements (5)": {"progression"},
    "Commands + fx toggles": {"command"},
}


def _split_markdown_row(line: str) -> list[str]:
    return [cell.strip() for cell in line.strip().strip("|").split("|")]


def parse_family_rows(markdown: str) -> list[dict[str, str]]:
    """Parse and validate the complete family rollup table."""
    lines = markdown.splitlines()
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


def canonical_matrix_value(value: str) -> str:
    match = re.match(r"\s*([a-z_]+)", value.lower())
    return match.group(1) if match else ""


def load_source_map():
    doc = json.loads(SOURCE_MAP.read_text(encoding="utf-8-sig"))
    rows = doc.get("rows")
    if not isinstance(rows, list):
        raise SystemExit("SOURCE_MAP.json rows must be an array")
    return rows


def main() -> int:
    errors: list[str] = []
    rows = load_source_map()
    if len(rows) != 912:
        errors.append(f"SOURCE_MAP row count must remain 912, found {len(rows)}")

    by_category = defaultdict(list)
    terminal_counts = Counter()
    for i, row in enumerate(rows):
        sid = str(row.get("source_id", f"row-{i}"))
        category = str(row.get("category", ""))
        status = str(row.get("status", "")).strip().lower()
        parity = str(row.get("parity", "")).strip().lower()
        notes = str(row.get("notes", "")).strip()
        by_category[category].append(row)

        gameplay = category not in NON_GAMEPLAY_CATEGORIES
        if not gameplay:
            continue
        if status in UNRESOLVED_STATUS or parity in UNRESOLVED_PARITY or not status or not parity:
            errors.append(f"{sid}: unresolved gameplay classification status={status!r} parity={parity!r}")
            continue
        label = TERMINAL.get((status, parity))
        if label is None:
            errors.append(f"{sid}: unsupported terminal combination status={status!r} parity={parity!r}")
            continue
        if label in {"validated approximation", "engine-unsupported", "intentionally excluded"} and not notes:
            errors.append(f"{sid}: {label} requires evidence/limitation notes")
        terminal_counts[label] += 1

    try:
        families = parse_family_rows(PARITY_MATRIX.read_text(encoding="utf-8-sig"))
    except (OSError, ValueError) as exc:
        errors.append(str(exc))
        families = []

    matrix_rows = {
        family["Source Feature"]: (
            canonical_matrix_value(family["Status"]),
            canonical_matrix_value(family["Parity"]),
        )
        for family in families
    }
    for family in families:
        feature = family["Source Feature"]
        status = canonical_matrix_value(family["Status"])
        parity = canonical_matrix_value(family["Parity"])
        if status in UNRESOLVED_STATUS or parity in UNRESOLVED_PARITY or not status or not parity:
            errors.append(f"{feature}: unresolved family rollup status={family['Status']!r} parity={family['Parity']!r}")
        elif (status, parity) not in TERMINAL:
            errors.append(f"{feature}: unsupported family rollup status={family['Status']!r} parity={family['Parity']!r}")

    for family, categories in FAMILY_RULES.items():
        if family not in matrix_rows:
            continue
        family_status, family_parity = matrix_rows[family]
        component_rows = [r for c in categories for r in by_category.get(c, [])]
        unresolved = [r.get("source_id") for r in component_rows if str(r.get("status", "")).lower() in UNRESOLVED_STATUS or str(r.get("parity", "")).lower() in UNRESOLVED_PARITY]
        if unresolved and family_status.startswith(("ported", "validated", "blocked")) and "unknown" not in family_parity:
            errors.append(f"{family}: family claims resolved but {len(unresolved)} source-map rows remain unresolved")
        if not unresolved and component_rows and family_status in {"uninspected", "in_progress", "unknown"}:
            errors.append(f"{family}: source-map category rows are terminal but family rollup remains {family_status}")

    if errors:
        print("Parity-ledger validation FAILED")
        for error in errors:
            print(f"- {error}")
        return 1

    print(f"Parity-ledger validation PASS: {len(rows)} rows; terminal gameplay counts={dict(terminal_counts)}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
