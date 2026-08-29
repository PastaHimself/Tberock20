#!/usr/bin/env python3
"""Validate Bedrock Jigsaw worldgen references and staged structure templates.

This is a repository-level integrity validator, not a replacement for Minecraft's
runtime schema validation. It focuses on failures that are easy to introduce while
porting Java Jigsaw data: duplicate identifiers, unresolved pools/processors,
unresolved structure templates, and invalid random-spread relationships.
"""

from __future__ import annotations

import argparse
import json
import re
import sys
from dataclasses import dataclass
from pathlib import Path
from typing import Any, Iterable

IDENTIFIER_RE = re.compile(r"^[a-z0-9_.-]+:[a-z0-9_./-]+$")
REPO_ROOT = Path(__file__).resolve().parents[1]
DEFAULT_BP_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP"

KINDS = {
    "template_pool": ("worldgen/template_pools", "minecraft:template_pool"),
    "processor_list": ("worldgen/processors", "minecraft:processor_list"),
    "jigsaw_structure": ("worldgen/structures", "minecraft:jigsaw"),
    "structure_set": ("worldgen/structure_sets", "minecraft:structure_set"),
}


@dataclass(frozen=True)
class ValidationResult:
    errors: tuple[str, ...]
    files_checked: int

    @property
    def ok(self) -> bool:
        return not self.errors


def _load_json(path: Path, errors: list[str]) -> dict[str, Any] | None:
    try:
        data = json.loads(path.read_text(encoding="utf-8"))
    except (OSError, json.JSONDecodeError) as exc:
        errors.append(f"{path}: invalid JSON: {exc}")
        return None
    if not isinstance(data, dict):
        errors.append(f"{path}: root must be a JSON object")
        return None
    return data


def _component_identifier(path: Path, data: dict[str, Any], component_key: str, errors: list[str]) -> str | None:
    component = data.get(component_key)
    if not isinstance(component, dict):
        errors.append(f"{path}: missing object {component_key}")
        return None
    description = component.get("description")
    if not isinstance(description, dict):
        errors.append(f"{path}: {component_key}.description must be an object")
        return None
    identifier = description.get("identifier")
    if not isinstance(identifier, str) or not IDENTIFIER_RE.fullmatch(identifier):
        errors.append(f"{path}: invalid or missing {component_key}.description.identifier")
        return None
    return identifier


def _structure_template_candidates(bp_root: Path, identifier: str) -> tuple[Path, Path]:
    namespace, rel = identifier.split(":", 1)
    base = bp_root / "structures" / namespace / rel
    return base.with_suffix(".nbt"), base.with_suffix(".mcstructure")


def _validate_single_pool_element(
    *,
    path: Path,
    element: dict[str, Any],
    bp_root: Path,
    processor_ids: set[str],
    errors: list[str],
) -> None:
    location = element.get("location")
    if not isinstance(location, str) or not IDENTIFIER_RE.fullmatch(location):
        errors.append(f"{path}: single_pool_element has invalid location {location!r}")
    else:
        candidates = _structure_template_candidates(bp_root, location)
        if not any(candidate.is_file() for candidate in candidates):
            shown = " or ".join(str(p.relative_to(bp_root)) for p in candidates)
            errors.append(f"{path}: template {location!r} does not resolve to {shown}")

    processors = element.get("processors")
    if processors is not None and not isinstance(processors, dict):
        if not isinstance(processors, str) or not IDENTIFIER_RE.fullmatch(processors):
            errors.append(f"{path}: invalid processors reference {processors!r}")
        elif processors != "minecraft:empty" and processors not in processor_ids:
            errors.append(f"{path}: unresolved processor list {processors!r}")

    projection = element.get("projection")
    if projection is not None and projection not in {"rigid", "terrain_matching"}:
        errors.append(f"{path}: invalid projection {projection!r}")


def _iter_pool_elements(raw: Any) -> Iterable[dict[str, Any]]:
    if isinstance(raw, list):
        for entry in raw:
            if isinstance(entry, dict):
                yield entry


def validate_pack(bp_root: Path) -> ValidationResult:
    errors: list[str] = []
    indexes: dict[str, dict[str, tuple[Path, dict[str, Any]]]] = {kind: {} for kind in KINDS}
    files_checked = 0

    for kind, (relative_dir, component_key) in KINDS.items():
        directory = bp_root / relative_dir
        if not directory.is_dir():
            continue
        for path in sorted(directory.rglob("*.json")):
            files_checked += 1
            data = _load_json(path, errors)
            if data is None:
                continue
            identifier = _component_identifier(path, data, component_key, errors)
            if identifier is None:
                continue
            previous = indexes[kind].get(identifier)
            if previous is not None:
                errors.append(f"{path}: duplicate {kind} identifier {identifier!r}; first declared in {previous[0]}")
                continue
            indexes[kind][identifier] = (path, data)

    processor_ids = set(indexes["processor_list"])
    pool_ids = set(indexes["template_pool"])
    structure_ids = set(indexes["jigsaw_structure"])

    for identifier, (path, data) in indexes["template_pool"].items():
        component = data["minecraft:template_pool"]
        fallback = component.get("fallback")
        if fallback is not None:
            if not isinstance(fallback, str) or not IDENTIFIER_RE.fullmatch(fallback):
                errors.append(f"{path}: invalid fallback pool {fallback!r}")
            elif fallback != "minecraft:empty" and fallback not in pool_ids:
                errors.append(f"{path}: unresolved fallback pool {fallback!r}")

        elements = component.get("elements")
        if not isinstance(elements, list) or not elements:
            errors.append(f"{path}: template pool {identifier!r} must contain at least one element")
            continue
        for index, entry in enumerate(elements):
            if not isinstance(entry, dict):
                errors.append(f"{path}: elements[{index}] must be an object")
                continue
            weight = entry.get("weight")
            if weight is not None and (not isinstance(weight, int) or isinstance(weight, bool) or weight <= 0):
                errors.append(f"{path}: elements[{index}].weight must be a positive integer")
            element = entry.get("element")
            if not isinstance(element, dict):
                errors.append(f"{path}: elements[{index}].element must be an object")
                continue
            element_type = element.get("element_type")
            if element_type == "minecraft:single_pool_element":
                _validate_single_pool_element(
                    path=path,
                    element=element,
                    bp_root=bp_root,
                    processor_ids=processor_ids,
                    errors=errors,
                )
            elif element_type == "minecraft:list_pool_element":
                nested = list(_iter_pool_elements(element.get("elements")))
                if not nested:
                    errors.append(f"{path}: list_pool_element must contain nested elements")
                for child in nested:
                    if child.get("element_type") == "minecraft:single_pool_element":
                        _validate_single_pool_element(
                            path=path,
                            element=child,
                            bp_root=bp_root,
                            processor_ids=processor_ids,
                            errors=errors,
                        )
            elif not isinstance(element_type, str):
                errors.append(f"{path}: elements[{index}] is missing element_type")

    for identifier, (path, data) in indexes["jigsaw_structure"].items():
        component = data["minecraft:jigsaw"]
        start_pool = component.get("start_pool")
        if not isinstance(start_pool, str) or not IDENTIFIER_RE.fullmatch(start_pool):
            errors.append(f"{path}: jigsaw structure {identifier!r} has invalid start_pool {start_pool!r}")
        elif start_pool not in pool_ids:
            errors.append(f"{path}: unresolved start_pool {start_pool!r}")

        max_depth = component.get("max_depth")
        if max_depth is not None and (not isinstance(max_depth, int) or isinstance(max_depth, bool) or not 0 <= max_depth <= 20):
            errors.append(f"{path}: max_depth must be an integer in [0, 20]")

    for identifier, (path, data) in indexes["structure_set"].items():
        component = data["minecraft:structure_set"]
        structures = component.get("structures")
        if not isinstance(structures, list) or not structures:
            errors.append(f"{path}: structure set {identifier!r} must contain at least one structure")
        else:
            for index, entry in enumerate(structures):
                if not isinstance(entry, dict):
                    errors.append(f"{path}: structures[{index}] must be an object")
                    continue
                structure = entry.get("structure")
                if not isinstance(structure, str) or not IDENTIFIER_RE.fullmatch(structure):
                    errors.append(f"{path}: structures[{index}] has invalid structure reference {structure!r}")
                elif structure not in structure_ids:
                    errors.append(f"{path}: unresolved structure reference {structure!r}")
                weight = entry.get("weight")
                if weight is not None and (not isinstance(weight, int) or isinstance(weight, bool) or weight <= 0):
                    errors.append(f"{path}: structures[{index}].weight must be a positive integer")

        placement = component.get("placement")
        if isinstance(placement, dict) and placement.get("type") == "minecraft:random_spread":
            spacing = placement.get("spacing")
            separation = placement.get("separation")
            if not isinstance(spacing, int) or isinstance(spacing, bool) or spacing <= 0:
                errors.append(f"{path}: random-spread spacing must be a positive integer")
            if not isinstance(separation, int) or isinstance(separation, bool) or separation < 0:
                errors.append(f"{path}: random-spread separation must be a non-negative integer")
            if isinstance(spacing, int) and isinstance(separation, int) and spacing <= separation:
                errors.append(f"{path}: random-spread spacing must be greater than separation")
            salt = placement.get("salt")
            if salt is not None and (not isinstance(salt, int) or isinstance(salt, bool)):
                errors.append(f"{path}: random-spread salt must be an integer")
        elif placement is not None and not isinstance(placement, dict):
            errors.append(f"{path}: placement must be an object")

    return ValidationResult(errors=tuple(errors), files_checked=files_checked)


def _parse_args(argv: list[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--bp-root", type=Path, default=DEFAULT_BP_ROOT)
    return parser.parse_args(argv)


def main(argv: list[str] | None = None) -> int:
    args = _parse_args(sys.argv[1:] if argv is None else argv)
    result = validate_pack(args.bp_root)
    if result.errors:
        for error in result.errors:
            print(f"ERROR: {error}", file=sys.stderr)
        print(f"Jigsaw validation failed: {len(result.errors)} error(s) across {result.files_checked} JSON file(s).", file=sys.stderr)
        return 1
    print(f"Jigsaw validation passed: {result.files_checked} JSON file(s) checked.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
