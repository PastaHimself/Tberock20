#!/usr/bin/env python3
"""Validate Bedrock Jigsaw worldgen references and generation settings.

This validator catches repository-level integrity errors before Minecraft loads the
pack. It intentionally mirrors the stable data-driven Jigsaw surface documented by
Microsoft Learn and the Bedrock Wiki; Minecraft remains the final runtime/schema
validator.
"""

from __future__ import annotations

import argparse
import json
import re
import sys
from dataclasses import dataclass
from pathlib import Path
from typing import Any

IDENTIFIER_RE = re.compile(r"^[a-z0-9_.-]+:[a-z0-9_./-]+$")
ASSET_PATH_RE = re.compile(r"^[a-z0-9_.-]+(?:/[a-z0-9_.-]+)*$")
REPO_ROOT = Path(__file__).resolve().parents[1]
DEFAULT_BP_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP"

KINDS = {
    "template_pool": ("worldgen/template_pools", "minecraft:template_pool"),
    "processor_list": ("worldgen/processors", "minecraft:processor_list"),
    "jigsaw_structure": ("worldgen/structures", "minecraft:jigsaw"),
    "structure_set": ("worldgen/structure_sets", "minecraft:structure_set"),
}

JIGSAW_STEPS = {
    "raw_generation",
    "lakes",
    "local_modifications",
    "underground_structures",
    "surface_structures",
    "strongholds",
    "underground_ores",
    "underground_decoration",
    "fluid_springs",
    "vegetal_decoration",
    "top_layer_modification",
}
HEIGHTMAP_PROJECTIONS = {"world_surface", "ocean_floor", "none"}
LIQUID_SETTINGS = {"apply_waterlogging", "ignore_waterlogging"}
TERRAIN_ADAPTATIONS = {"beard_box", "beard_thin", "bury", "encapsulate", "none"}
SPREAD_TYPES = {"linear", "triangular"}
HEIGHT_ANCHORS = {"absolute", "above_bottom", "below_top", "from_sea"}
PROJECTIONS = {"rigid", "terrain_matching"}
SINGLE_POOL_TYPES = {"minecraft:single_pool_element", "minecraft:legacy_single_pool_element"}


@dataclass(frozen=True)
class ValidationResult:
    errors: tuple[str, ...]
    files_checked: int

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


def _component_identifier(
    path: Path,
    data: dict[str, Any],
    component_key: str,
    errors: list[str],
) -> str | None:
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


def _is_asset_path(value: Any) -> bool:
    if not isinstance(value, str) or not ASSET_PATH_RE.fullmatch(value):
        return False
    return all(part not in {".", ".."} for part in value.split("/"))


def _structure_template_candidates(bp_root: Path, asset_path: str) -> tuple[Path, Path]:
    base = bp_root / "structures" / asset_path
    return Path(f"{base}.nbt"), Path(f"{base}.mcstructure")


def _validate_projection(path: Path, projection: Any, errors: list[str]) -> None:
    if projection is not None and projection not in PROJECTIONS:
        errors.append(f"{path}: invalid projection {projection!r}")


def _validate_processors(
    path: Path,
    processors: Any,
    processor_ids: set[str],
    errors: list[str],
) -> None:
    if processors is None or isinstance(processors, dict):
        return
    if not isinstance(processors, str) or not IDENTIFIER_RE.fullmatch(processors):
        errors.append(f"{path}: invalid processors reference {processors!r}")
    elif processors != "minecraft:empty" and processors not in processor_ids:
        errors.append(f"{path}: unresolved processor list {processors!r}")


def _validate_pool_element(
    *,
    path: Path,
    element: Any,
    bp_root: Path,
    processor_ids: set[str],
    errors: list[str],
    allow_list: bool = True,
) -> None:
    if not isinstance(element, dict):
        errors.append(f"{path}: pool element must be an object")
        return

    element_type = element.get("element_type")
    if element_type in SINGLE_POOL_TYPES:
        location = element.get("location")
        if not _is_asset_path(location):
            errors.append(f"{path}: {element_type} has invalid asset path location {location!r}")
        else:
            candidates = _structure_template_candidates(bp_root, location)
            if not any(candidate.is_file() for candidate in candidates):
                shown = " or ".join(str(candidate.relative_to(bp_root)) for candidate in candidates)
                errors.append(f"{path}: template {location!r} does not resolve to {shown}")
        _validate_processors(path, element.get("processors"), processor_ids, errors)
        _validate_projection(path, element.get("projection"), errors)
        return

    if element_type == "minecraft:empty_pool_element":
        _validate_projection(path, element.get("projection"), errors)
        return

    if element_type == "minecraft:feature_pool_element":
        feature = element.get("feature")
        if not isinstance(feature, str) or not IDENTIFIER_RE.fullmatch(feature):
            errors.append(f"{path}: feature_pool_element has invalid feature {feature!r}")
        _validate_projection(path, element.get("projection"), errors)
        return

    if element_type == "minecraft:list_pool_element":
        if not allow_list:
            errors.append(f"{path}: nested minecraft:list_pool_element is not supported")
            return
        children = element.get("elements")
        if not isinstance(children, list) or not children:
            errors.append(f"{path}: list_pool_element must contain at least one element")
            return
        _validate_projection(path, element.get("projection"), errors)
        for child in children:
            _validate_pool_element(
                path=path,
                element=child,
                bp_root=bp_root,
                processor_ids=processor_ids,
                errors=errors,
                allow_list=False,
            )
        return

    if not isinstance(element_type, str):
        errors.append(f"{path}: pool element is missing element_type")
    else:
        errors.append(f"{path}: unsupported pool element_type {element_type!r}")


def _validate_height_anchor(path: Path, value: Any, field: str, errors: list[str]) -> None:
    if not isinstance(value, dict) or len(value) != 1:
        errors.append(f"{path}: {field} must contain exactly one height anchor")
        return
    anchor, amount = next(iter(value.items()))
    if anchor not in HEIGHT_ANCHORS:
        errors.append(f"{path}: {field} uses unsupported height anchor {anchor!r}")
        return
    if not isinstance(amount, int) or isinstance(amount, bool):
        errors.append(f"{path}: {field}.{anchor} must be an integer")
        return
    if anchor in {"above_bottom", "below_top"} and amount < 0:
        errors.append(f"{path}: {field}.{anchor} must be non-negative")


def _validate_start_height(path: Path, raw: Any, errors: list[str]) -> None:
    if not isinstance(raw, dict):
        errors.append(f"{path}: start_height must be an object")
        return
    kind = raw.get("type")
    if kind == "constant":
        _validate_height_anchor(path, raw.get("value"), "start_height.value", errors)
    elif kind == "uniform":
        _validate_height_anchor(path, raw.get("min"), "start_height.min", errors)
        _validate_height_anchor(path, raw.get("max"), "start_height.max", errors)
    else:
        errors.append(f"{path}: start_height.type must be 'constant' or 'uniform'")


def _validate_distance(path: Path, raw: Any, errors: list[str]) -> None:
    if isinstance(raw, int) and not isinstance(raw, bool):
        if not 1 <= raw <= 128:
            errors.append(f"{path}: max_distance_from_center integer must be in [1, 128]")
        return
    if not isinstance(raw, dict):
        errors.append(f"{path}: max_distance_from_center must be an integer or object")
        return
    horizontal = raw.get("horizontal")
    if not isinstance(horizontal, int) or isinstance(horizontal, bool) or not 1 <= horizontal <= 128:
        errors.append(f"{path}: max_distance_from_center.horizontal must be in [1, 128]")
    vertical = raw.get("vertical")
    if vertical is not None and (
        not isinstance(vertical, int) or isinstance(vertical, bool) or vertical <= 1
    ):
        errors.append(f"{path}: max_distance_from_center.vertical must be an integer greater than 1")


def _validate_padding(path: Path, raw: Any, errors: list[str]) -> None:
    if isinstance(raw, int) and not isinstance(raw, bool):
        if raw < 0:
            errors.append(f"{path}: dimension_padding must be non-negative")
        return
    if not isinstance(raw, dict):
        errors.append(f"{path}: dimension_padding must be a non-negative integer or object")
        return
    for side in ("top", "bottom"):
        value = raw.get(side, 0)
        if not isinstance(value, int) or isinstance(value, bool) or value < 0:
            errors.append(f"{path}: dimension_padding.{side} must be a non-negative integer")


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
                errors.append(
                    f"{path}: duplicate {kind} identifier {identifier!r}; first declared in {previous[0]}"
                )
                continue
            indexes[kind][identifier] = (path, data)

    processor_ids = set(indexes["processor_list"])
    pool_ids = set(indexes["template_pool"])
    structure_ids = set(indexes["jigsaw_structure"])

    for identifier, (path, data) in indexes["processor_list"].items():
        processors = data["minecraft:processor_list"].get("processors")
        if not isinstance(processors, list):
            errors.append(f"{path}: processor list {identifier!r} must contain a processors array")

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
            weight = entry.get("weight", 1)
            if not isinstance(weight, int) or isinstance(weight, bool) or weight <= 0:
                errors.append(f"{path}: elements[{index}].weight must be a positive integer")
            _validate_pool_element(
                path=path,
                element=entry.get("element"),
                bp_root=bp_root,
                processor_ids=processor_ids,
                errors=errors,
            )

    for identifier, (path, data) in indexes["jigsaw_structure"].items():
        component = data["minecraft:jigsaw"]
        step = component.get("step")
        if step not in JIGSAW_STEPS:
            errors.append(f"{path}: jigsaw structure {identifier!r} has invalid step {step!r}")

        start_pool = component.get("start_pool")
        if not isinstance(start_pool, str) or not IDENTIFIER_RE.fullmatch(start_pool):
            errors.append(f"{path}: jigsaw structure {identifier!r} has invalid start_pool {start_pool!r}")
        elif start_pool not in pool_ids:
            errors.append(f"{path}: unresolved start_pool {start_pool!r}")

        start_jigsaw_name = component.get("start_jigsaw_name")
        if start_jigsaw_name is not None and (
            not isinstance(start_jigsaw_name, str) or not IDENTIFIER_RE.fullmatch(start_jigsaw_name)
        ):
            errors.append(f"{path}: invalid start_jigsaw_name {start_jigsaw_name!r}")

        max_depth = component.get("max_depth")
        if (
            not isinstance(max_depth, int)
            or isinstance(max_depth, bool)
            or not 0 <= max_depth <= 20
        ):
            errors.append(f"{path}: max_depth must be an integer in [0, 20]")

        if "start_height" not in component:
            errors.append(f"{path}: start_height is required")
        else:
            _validate_start_height(path, component.get("start_height"), errors)

        heightmap_projection = component.get("heightmap_projection", "none")
        if heightmap_projection not in HEIGHTMAP_PROJECTIONS:
            errors.append(f"{path}: invalid heightmap_projection {heightmap_projection!r}")

        liquid_settings = component.get("liquid_settings", "apply_waterlogging")
        if liquid_settings not in LIQUID_SETTINGS:
            errors.append(f"{path}: invalid liquid_settings {liquid_settings!r}")

        terrain_adaptation = component.get("terrain_adaptation", "none")
        if terrain_adaptation not in TERRAIN_ADAPTATIONS:
            errors.append(f"{path}: invalid terrain_adaptation {terrain_adaptation!r}")

        if "max_distance_from_center" in component:
            _validate_distance(path, component["max_distance_from_center"], errors)
        if "dimension_padding" in component:
            _validate_padding(path, component["dimension_padding"], errors)

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
                if not isinstance(weight, int) or isinstance(weight, bool) or weight <= 0:
                    errors.append(f"{path}: structures[{index}].weight must be a positive integer")

        placement = component.get("placement")
        if not isinstance(placement, dict):
            errors.append(f"{path}: placement must be an object")
            continue
        if placement.get("type") != "minecraft:random_spread":
            errors.append(f"{path}: placement.type must be 'minecraft:random_spread'")
            continue

        salt = placement.get("salt")
        if not isinstance(salt, int) or isinstance(salt, bool):
            errors.append(f"{path}: random-spread salt must be an integer")

        spacing = placement.get("spacing")
        if not isinstance(spacing, int) or isinstance(spacing, bool) or spacing <= 0:
            errors.append(f"{path}: random-spread spacing must be a positive integer")

        separation = placement.get("separation")
        if not isinstance(separation, int) or isinstance(separation, bool) or separation < 0:
            errors.append(f"{path}: random-spread separation must be a non-negative integer")

        if (
            isinstance(spacing, int)
            and not isinstance(spacing, bool)
            and isinstance(separation, int)
            and not isinstance(separation, bool)
            and separation * 2 >= spacing
        ):
            errors.append(
                f"{path}: random-spread separation must be less than half the spacing "
                f"(got separation={separation}, spacing={spacing})"
            )

        spread_type = placement.get("spread_type")
        if spread_type not in SPREAD_TYPES:
            errors.append(f"{path}: random-spread spread_type must be one of {sorted(SPREAD_TYPES)!r}")

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
        print(
            f"Jigsaw validation failed: {len(result.errors)} error(s) "
            f"across {result.files_checked} JSON file(s).",
            file=sys.stderr,
        )
        return 1
    print(f"Jigsaw validation passed: {result.files_checked} JSON file(s) checked.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
