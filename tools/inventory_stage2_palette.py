#!/usr/bin/env python3
"""Inventory Java block states used by the source Stage 2 generator templates."""

from __future__ import annotations

import argparse
import json
from collections import Counter, defaultdict
from pathlib import Path
from typing import Any

from inspect_java_structure_nbt import load_nbt


def freeze(value: Any) -> Any:
    if isinstance(value, dict):
        return tuple((key, freeze(child)) for key, child in sorted(value.items()))
    if isinstance(value, list):
        return tuple(freeze(child) for child in value)
    return value


def thaw(value: Any) -> Any:
    if isinstance(value, tuple):
        if value and all(isinstance(item, tuple) and len(item) == 2 and isinstance(item[0], str) for item in value):
            return {key: thaw(child) for key, child in value}
        return [thaw(child) for child in value]
    return value


def inventory(root: Path) -> dict[str, Any]:
    audit_path = root / "TheBrokenScript_Bedrock_2_0" / "STAGE2_GENERATOR_AUDIT.json"
    audit = json.loads(audit_path.read_text(encoding="utf-8"))
    entries: Counter[tuple[Any, Any]] = Counter()
    property_values: dict[str, dict[str, set[Any]]] = defaultdict(lambda: defaultdict(set))
    block_entities: Counter[str] = Counter()
    entities: Counter[str] = Counter()
    templates = []

    for template in audit["templates"]:
        source_path = root / template["sourcePath"]
        nbt = load_nbt(source_path)
        palette = nbt.get("palette") if isinstance(nbt.get("palette"), list) else []
        blocks = nbt.get("blocks") if isinstance(nbt.get("blocks"), list) else []
        raw_entities = nbt.get("entities") if isinstance(nbt.get("entities"), list) else []

        template_states = set()
        for state in palette:
            if not isinstance(state, dict):
                continue
            name = state.get("Name")
            if not isinstance(name, str):
                continue
            props = state.get("Properties") if isinstance(state.get("Properties"), dict) else {}
            signature = (name, freeze(props))
            entries[signature] += 1
            template_states.add(signature)
            for key, value in props.items():
                property_values[name][key].add(freeze(value))

        for block in blocks:
            if not isinstance(block, dict) or not isinstance(block.get("nbt"), dict):
                continue
            block_id = block["nbt"].get("id")
            if isinstance(block_id, str):
                block_entities[block_id] += 1

        for entity in raw_entities:
            if not isinstance(entity, dict) or not isinstance(entity.get("nbt"), dict):
                continue
            entity_id = entity["nbt"].get("id")
            if isinstance(entity_id, str):
                entities[entity_id] += 1

        templates.append({
            "id": template["id"],
            "paletteEntries": len(palette),
            "uniqueStates": len(template_states),
            "blockEntities": sum(1 for block in blocks if isinstance(block, dict) and isinstance(block.get("nbt"), dict)),
            "entities": len(raw_entities),
        })

    states = [
        {
            "name": name,
            "properties": thaw(props),
            "templatePaletteOccurrences": count,
        }
        for (name, props), count in sorted(entries.items(), key=lambda item: (item[0][0], repr(item[0][1])))
    ]

    properties = {
        name: {
            key: sorted((thaw(value) for value in values), key=lambda value: repr(value))
            for key, values in sorted(keys.items())
        }
        for name, keys in sorted(property_values.items())
    }

    return {
        "schemaVersion": 1,
        "templateCount": len(templates),
        "uniqueBlockStateCount": len(states),
        "uniqueBlockNameCount": len({entry["name"] for entry in states}),
        "states": states,
        "propertyValuesByBlock": properties,
        "blockEntityIds": dict(sorted(block_entities.items())),
        "entityIds": dict(sorted(entities.items())),
        "templates": templates,
    }


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument("--report", type=Path)
    args = parser.parse_args()
    root = args.root.resolve()
    result = inventory(root)
    payload = json.dumps(result, indent=2, sort_keys=True) + "\n"
    if args.report:
        report = args.report if args.report.is_absolute() else root / args.report
        report.parent.mkdir(parents=True, exist_ok=True)
        report.write_text(payload, encoding="utf-8")
    print(
        "stage2 palette inventory: "
        f"{result['templateCount']} templates, "
        f"{result['uniqueBlockNameCount']} block names, "
        f"{result['uniqueBlockStateCount']} unique states"
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
