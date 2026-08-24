#!/usr/bin/env python3
"""Repair validation findings in The Broken Script 2.0 Bedrock add-on.

The transformations are deliberately deterministic and idempotent so the tool can
be rerun after regenerating source-derived assets.
"""

from __future__ import annotations

import argparse
import json
import math
import re
import shutil
from pathlib import Path
from typing import Any, Iterable


ADDON_NAME = "TheBrokenScript_Bedrock_2_0"
CURRENT_CONTENT_VERSION = "1.26.40"
CURRENT_ANIMATION_VERSION = "1.10.0"
GECKOLIB_EASING_ANIMATIONS = {
    "brokenendoverhaul.animation.json",
    "desintegration.animation.json",
    "hetzer.animation.json",
    "integrity.animation.json",
    "integrity_phase2.animation.json",
    "integritywip.animation.json",
    "nothing_watcher.animation.json",
    "plush.animation.json",
    "revuxor.animation.json",
    "sub_anom_2.animation.json",
    "tbe_overhaulv4.animation.json",
    "tether.animation.json",
    "void_tentacle.animation.json",
}
GECKOLIB_BAKE_FPS = 60
GECKOLIB_MIN_EASING_SEGMENTS = 8
UTF8_BOM = b"\xef\xbb\xbf"
TEXTURE_REPLACEMENTS = (
    ("textures\\\\block\\\\", "textures/blocks/"),
    ("textures\\\\item\\\\", "textures/items/"),
    ("textures\\\\plush\\\\", "textures/items/plush/"),
    ("textures/block\\\\", "textures/blocks/"),
    ("textures/item\\\\", "textures/items/"),
    ("textures/plush\\\\", "textures/items/plush/"),
    ("textures/block/", "textures/blocks/"),
    ("textures/item/", "textures/items/"),
    ("textures/plush/", "textures/items/plush/"),
)
GEOMETRY_IDENTIFIER_REPLACEMENTS = {
    "geometry.BOULDER - Converted": "geometry.tbs_boulder_converted",
    "geometry.Max revive": "geometry.tbs_max_revive",
}
BONE_IDENTIFIER_PATTERN = re.compile(r"^[A-Za-z][A-Za-z0-9_.-]*$")
JAVA_CUSTOM_INSTRUCTION_PATTERN = re.compile(r"^[A-Za-z_][A-Za-z0-9_]*;$")


def load_json(path: Path) -> Any:
    return json.loads(path.read_text(encoding="utf-8-sig"))


def write_json(path: Path, value: Any) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value, indent=2, ensure_ascii=False) + "\n", encoding="utf-8")


def json_files(*roots: Path) -> Iterable[Path]:
    for root in roots:
        if root.is_dir():
            yield from sorted(root.rglob("*.json"))


def remove_json_boms(bp: Path, rp: Path) -> int:
    count = 0
    for path in json_files(bp, rp):
        raw = path.read_bytes()
        if raw.startswith(UTF8_BOM):
            path.write_bytes(raw[len(UTF8_BOM) :])
            count += 1
    return count


def move_tree_contents(source: Path, destination: Path) -> int:
    if not source.is_dir():
        return 0
    moved = 0
    for path in sorted(source.rglob("*")):
        if not path.is_file():
            continue
        target = destination / path.relative_to(source)
        target.parent.mkdir(parents=True, exist_ok=True)
        if target.exists():
            if target.read_bytes() != path.read_bytes():
                raise RuntimeError(f"Refusing to overwrite different texture: {target}")
            path.unlink()
        else:
            shutil.move(str(path), str(target))
        moved += 1
    for directory in sorted((p for p in source.rglob("*") if p.is_dir()), reverse=True):
        directory.rmdir()
    source.rmdir()
    return moved


def normalize_texture_layout(rp: Path) -> tuple[int, int]:
    textures = rp / "textures"
    moved = 0
    moved += move_tree_contents(textures / "block", textures / "blocks")
    moved += move_tree_contents(textures / "item", textures / "items")
    moved += move_tree_contents(textures / "plush", textures / "items" / "plush")

    changed = 0
    for path in json_files(rp):
        original = path.read_text(encoding="utf-8")
        updated = original
        for old, new in TEXTURE_REPLACEMENTS:
            updated = updated.replace(old, new)
        if updated != original:
            path.write_text(updated, encoding="utf-8")
            changed += 1
    return moved, changed


def update_format_versions(bp: Path, rp: Path) -> int:
    targets = (
        (bp / "biomes", CURRENT_CONTENT_VERSION),
        (bp / "blocks", CURRENT_CONTENT_VERSION),
        (bp / "entities", CURRENT_CONTENT_VERSION),
        (bp / "items", CURRENT_CONTENT_VERSION),
        (bp / "recipes", CURRENT_CONTENT_VERSION),
        (rp / "entity", CURRENT_CONTENT_VERSION),
    )
    changed = 0
    for root, version in targets:
        for path in json_files(root):
            value = load_json(path)
            if isinstance(value, dict) and value.get("format_version") != version:
                value["format_version"] = version
                write_json(path, value)
                changed += 1
    return changed


def repair_biome_components(bp: Path) -> int:
    changed = 0
    for path in json_files(bp / "biomes"):
        value = load_json(path)
        components = value.get("minecraft:biome", {}).get("components", {})
        if not isinstance(components, dict):
            continue
        climate = components.get("minecraft:climate")
        if not isinstance(climate, dict):
            climate = {}
            components["minecraft:climate"] = climate
        repaired = False
        for legacy_name, climate_name in (
            ("minecraft:temperature", "temperature"),
            ("minecraft:downfall", "downfall"),
        ):
            legacy = components.pop(legacy_name, None)
            if legacy is None:
                continue
            if climate_name not in climate and isinstance(legacy, dict):
                legacy_value = legacy.get("value")
                if isinstance(legacy_value, (int, float)) and not isinstance(legacy_value, bool):
                    climate[climate_name] = legacy_value
            repaired = True
        if repaired:
            write_json(path, value)
            changed += 1
    return changed


def block_component_sets(block: dict[str, Any]) -> Iterable[dict[str, Any]]:
    components = block.get("components")
    if isinstance(components, dict):
        yield components
    for permutation in block.get("permutations", []):
        if not isinstance(permutation, dict):
            continue
        components = permutation.get("components")
        if isinstance(components, dict):
            yield components


def repair_block_components(bp: Path) -> tuple[int, int]:
    geometry_added = custom_components_flattened = 0
    for path in json_files(bp / "blocks"):
        value = load_json(path)
        block = value.get("minecraft:block") if isinstance(value, dict) else None
        if not isinstance(block, dict):
            continue
        changed = False
        for components in block_component_sets(block):
            if "minecraft:material_instances" in components and "minecraft:geometry" not in components:
                components["minecraft:geometry"] = "minecraft:geometry.full_block"
                geometry_added += 1
                changed = True

            custom_ids = components.pop("minecraft:custom_components", None)
            if custom_ids is None:
                continue
            if not isinstance(custom_ids, list) or not all(isinstance(item, str) for item in custom_ids):
                raise ValueError(f"Unexpected custom component list in {path}")
            for custom_id in custom_ids:
                components.setdefault(custom_id, {})
                custom_components_flattened += 1
            changed = True
        if changed:
            write_json(path, value)
    return geometry_added, custom_components_flattened


def repair_recipe_unlocks(bp: Path) -> int:
    changed = 0
    for path in json_files(bp / "recipes"):
        value = load_json(path)
        if not isinstance(value, dict):
            continue
        recipe = next(
            (item for key, item in value.items() if key.startswith("minecraft:recipe_") and isinstance(item, dict)),
            None,
        )
        if recipe is None or "unlock" in recipe:
            continue
        recipe["unlock"] = {"context": "AlwaysUnlocked"}
        write_json(path, value)
        changed += 1
    return changed


def repair_null_item_icon(bp: Path) -> int:
    path = bp / "items" / "null.json"
    if not path.is_file():
        return 0
    value = load_json(path)
    components = value.get("minecraft:item", {}).get("components", {})
    if not isinstance(components, dict) or components.get("minecraft:icon") != "null":
        return 0
    components["minecraft:icon"] = "null_item"
    write_json(path, value)
    return 1


def repair_texture_atlases(rp: Path) -> int:
    changed = 0
    for name in ("terrain_texture.json", "item_texture.json"):
        path = rp / name
        value = load_json(path)
        for entry in value.get("texture_data", {}).values():
            textures = entry.get("textures") if isinstance(entry, dict) else None
            if isinstance(textures, str):
                entry["textures"] = [textures]
                changed += 1
        write_json(path, value)
    return changed


def repair_flipbook(rp: Path) -> int:
    path = rp / "flipbook_textures.json"
    value = load_json(path)
    if isinstance(value, dict) and isinstance(value.get("flipbook"), list):
        value = value["flipbook"]
    if not isinstance(value, list):
        raise ValueError(f"Unexpected flipbook structure in {path}")
    for entry in value:
        texture = entry.get("flipbook_texture") if isinstance(entry, dict) else None
        if isinstance(texture, str):
            entry["flipbook_texture"] = texture.replace("\\", "/").replace(
                "textures/block/", "textures/blocks/"
            )
    write_json(path, value)
    return len(value)


def repair_sounds(rp: Path) -> tuple[int, int]:
    path = rp / "sound_definitions.json"
    value = load_json(path)
    definitions = value.get("sound_definitions", {})
    removed_entries = 0
    removed_definitions = 0
    for identifier in list(definitions):
        definition = definitions[identifier]
        sounds = definition.get("sounds", []) if isinstance(definition, dict) else []
        valid = []
        for sound in sounds:
            name = sound if isinstance(sound, str) else sound.get("name")
            if not isinstance(name, str):
                removed_entries += 1
                continue
            relative = name.removeprefix("sounds/")
            candidates = (rp / f"{name}.ogg", rp / f"{name}.wav", rp / f"sounds/{relative}.fsb")
            if any(candidate.is_file() for candidate in candidates):
                valid.append(sound)
            else:
                removed_entries += 1
        if valid:
            definition["sounds"] = valid
        else:
            del definitions[identifier]
            removed_definitions += 1
    write_json(path, value)
    return removed_entries, removed_definitions


def prune_unreferenced_audio(rp: Path) -> int:
    value = load_json(rp / "sound_definitions.json")
    referenced: set[str] = set()
    for definition in value.get("sound_definitions", {}).values():
        if not isinstance(definition, dict):
            continue
        for sound in definition.get("sounds", []):
            name = sound if isinstance(sound, str) else sound.get("name")
            if isinstance(name, str) and name.startswith("sounds/"):
                referenced.add(name.removeprefix("sounds/").lower())

    removed = 0
    sound_root = rp / "sounds"
    for path in sorted(sound_root.rglob("*")):
        if not path.is_file() or path.suffix.lower() not in {".ogg", ".wav", ".fsb"}:
            continue
        relative = path.relative_to(sound_root).with_suffix("").as_posix().lower()
        if relative not in referenced:
            path.unlink()
            removed += 1
    for directory in sorted((p for p in sound_root.rglob("*") if p.is_dir()), reverse=True):
        if not any(directory.iterdir()):
            directory.rmdir()
    return removed


def ensure_render_controller(rp: Path) -> None:
    write_json(
        rp / "render_controllers" / "single_textured.render_controllers.json",
        {
            "format_version": "1.8.0",
            "render_controllers": {
                "controller.render.single_textured": {
                    "geometry": "Geometry.default",
                    "materials": [{"*": "Material.default"}],
                    "textures": ["Texture.default"],
                }
            },
        },
    )


def collapse_vector_wrappers(value: Any, *, include_easing: bool = False) -> Any:
    if isinstance(value, list):
        return [collapse_vector_wrappers(item, include_easing=include_easing) for item in value]
    if not isinstance(value, dict):
        return value
    allowed_keys = {"vector", "easing"} if include_easing else {"vector"}
    if (
        "vector" in value
        and set(value).issubset(allowed_keys)
        and isinstance(value["vector"], list)
    ):
        return collapse_vector_wrappers(value["vector"], include_easing=include_easing)
    return {
        key: collapse_vector_wrappers(item, include_easing=include_easing)
        for key, item in value.items()
    }


def _timestamp(value: float) -> str:
    rendered = f"{value:.10f}".rstrip("0").rstrip(".")
    return rendered if "." in rendered else f"{rendered}.0"


def _numeric_vector(value: Any) -> bool:
    return (
        isinstance(value, list)
        and bool(value)
        and all(
            isinstance(item, (int, float)) and not isinstance(item, bool)
            for item in value
        )
    )


def _lerp_vector(start: list[Any], end: list[Any], progress: float) -> list[Any]:
    if len(start) != len(end) or not _numeric_vector(start) or not _numeric_vector(end):
        raise ValueError("GeckoLib easing conversion requires equally sized numeric vectors")
    interpolated: list[Any] = []
    for old, new in zip(start, end):
        value = old + (new - old) * progress
        nearest_integer = round(value)
        interpolated.append(
            nearest_integer
            if math.isclose(value, nearest_integer, abs_tol=1e-12)
            else round(value, 12)
        )
    return interpolated


def _keyframe_output(value: Any) -> Any:
    if isinstance(value, dict):
        if "post" in value:
            return value["post"]
        if "vector" in value:
            return value["vector"]
    return value


def _is_geckolib_wrapper(value: Any) -> bool:
    if not isinstance(value, dict) or not isinstance(value.get("easing"), str):
        return False
    if "easingArgs" in value and not isinstance(value["easingArgs"], list):
        return False
    if isinstance(value.get("vector"), list):
        return set(value).issubset({"vector", "easing", "easingArgs"})
    if isinstance(value.get("pre"), list) or isinstance(value.get("post"), list):
        return set(value).issubset(
            {"pre", "post", "lerp_mode", "easing", "easingArgs"},
        )
    return False


def _geckolib_target(value: dict[str, Any]) -> list[Any]:
    for field in ("vector", "pre", "post"):
        target = value.get(field)
        if isinstance(target, list):
            return target
    raise ValueError("GeckoLib easing keyframe has no vector, pre, or post value")


def _bedrock_keyframe(value: dict[str, Any]) -> Any:
    if "vector" in value:
        return convert_geckolib_easing_keyframes(value["vector"])
    return {
        key: convert_geckolib_easing_keyframes(item)
        for key, item in value.items()
        if key not in {"easing", "easingArgs"}
    }


def _first_easing_arg(keyframe: dict[str, Any]) -> float | None:
    args = keyframe.get("easingArgs", [])
    if not isinstance(args, list):
        raise ValueError("GeckoLib easingArgs must be an array")
    if not args:
        return None
    value = args[0]
    if not isinstance(value, (int, float)) or isinstance(value, bool):
        raise ValueError("GeckoLib easing conversion requires a numeric first easing argument")
    return float(value)


def _bounce(progress: float, bounciness: float | None) -> float:
    value = 0.5 if bounciness is None else bounciness
    curves = (
        121 / 16 * progress * progress,
        121 / 4 * value * (progress - 6 / 11) ** 2 + 1 - value,
        121 * value * value * (progress - 9 / 11) ** 2 + 1 - value * value,
        484 * value * value * value * (progress - 10.5 / 11) ** 2
        + 1
        - value * value * value,
    )
    return min(curves)


def _baked_sample_count(start_time: float, end_time: float) -> int:
    return max(
        GECKOLIB_MIN_EASING_SEGMENTS,
        math.ceil((end_time - start_time) * GECKOLIB_BAKE_FPS),
    )


def _eased_progress(easing: str, progress: float, easing_arg: float | None) -> float:
    if easing in {"linear", "none"}:
        return progress
    if easing == "easeinsine":
        return 1 - math.cos(progress * math.pi / 2)
    if easing == "easeinoutsine":
        return (1 - math.cos(math.pi * progress)) / 2
    if easing == "easeoutquad":
        return 1 - (1 - progress) ** 2
    if easing == "easeincubic":
        return progress**3
    if easing == "easeinelastic":
        elasticity = 1 if easing_arg is None else easing_arg
        return 1 - math.cos(progress * math.pi / 2) ** 3 * math.cos(
            progress * elasticity * math.pi,
        )
    if easing == "easeinbounce":
        return _bounce(progress, easing_arg)
    if easing == "easeoutbounce":
        return 1 - _bounce(1 - progress, easing_arg)
    if easing == "easeinoutbounce":
        return (
            _bounce(progress * 2, easing_arg) / 2
            if progress < 0.5
            else 1 - _bounce((1 - progress) * 2, easing_arg) / 2
        )
    raise ValueError(f"Unsupported GeckoLib easing: {easing}")


def _add_sampled_easing(
    converted: dict[str, Any],
    start_time: float,
    end_time: float,
    start: list[Any],
    target: list[Any],
    easing: str,
    easing_arg: float | None,
) -> None:
    samples = (
        GECKOLIB_MIN_EASING_SEGMENTS
        if easing == "easeinoutsine"
        else _baked_sample_count(start_time, end_time)
    )
    for sample in range(1, samples):
        progress = sample / samples
        eased = _eased_progress(easing, progress, easing_arg)
        sample_time = start_time + (end_time - start_time) * progress
        converted[_timestamp(sample_time)] = _lerp_vector(start, target, eased)


def _add_step_easing(
    converted: dict[str, Any],
    start_time: float,
    end_time: float,
    start: list[Any],
    target: list[Any],
    easing_arg: float | None,
) -> list[Any]:
    raw_steps = 2 if easing_arg is None else easing_arg
    if raw_steps < 2:
        raise ValueError(f"GeckoLib step easing requires at least two steps, got {raw_steps}")
    steps = int(raw_steps)
    previous = start
    for step in range(1, steps):
        progress = step / steps
        current = _lerp_vector(start, target, progress)
        step_time = start_time + (end_time - start_time) * progress
        converted[_timestamp(step_time)] = {"pre": previous, "post": current}
        previous = current
    return previous


def _convert_eased_channel(channel: dict[str, Any]) -> dict[str, Any]:
    entries = sorted(channel.items(), key=lambda item: float(item[0]))
    converted: dict[str, Any] = {}
    previous_time: float | None = None
    previous_value: Any = None

    for original_time, raw_keyframe in entries:
        current_time = float(original_time)
        if not _is_geckolib_wrapper(raw_keyframe):
            keyframe = convert_geckolib_easing_keyframes(raw_keyframe)
            converted[original_time] = keyframe
            previous_time = current_time
            previous_value = _keyframe_output(keyframe)
            continue

        target = convert_geckolib_easing_keyframes(_geckolib_target(raw_keyframe))
        bedrock_keyframe = _bedrock_keyframe(raw_keyframe)
        easing = raw_keyframe["easing"].lower()
        easing_arg = _first_easing_arg(raw_keyframe)
        if previous_time is None or current_time <= previous_time:
            converted[original_time] = bedrock_keyframe
        elif easing == "step":
            final_step = _add_step_easing(
                converted,
                previous_time,
                current_time,
                previous_value,
                target,
                easing_arg,
            )
            if isinstance(bedrock_keyframe, dict):
                converted[original_time] = {
                    **bedrock_keyframe,
                    "pre": final_step,
                }
            else:
                converted[original_time] = {
                    "pre": final_step,
                    "post": target,
                }
        elif easing in {"linear", "none"}:
            converted[original_time] = bedrock_keyframe
        elif easing in {
            "easeinbounce",
            "easeincubic",
            "easeinelastic",
            "easeinoutbounce",
            "easeinoutsine",
            "easeinsine",
            "easeoutbounce",
            "easeoutquad",
        }:
            _add_sampled_easing(
                converted,
                previous_time,
                current_time,
                previous_value,
                target,
                easing,
                easing_arg,
            )
            converted[original_time] = bedrock_keyframe
        else:
            raise ValueError(f"Unsupported GeckoLib easing: {easing}")

        previous_time = current_time
        previous_value = target

    return converted


def convert_geckolib_easing_keyframes(value: Any) -> Any:
    """Convert GeckoLib keyframes to equivalent Bedrock-supported keyframes."""
    if isinstance(value, list):
        return [convert_geckolib_easing_keyframes(item) for item in value]
    if not isinstance(value, dict):
        return value
    if _is_geckolib_wrapper(value):
        # A wrapper without a timestamp is a constant transform, so its easing
        # has no interval over which it could affect interpolation.
        return _bedrock_keyframe(value)

    numeric_keys = bool(value)
    for key in value:
        try:
            float(key)
        except (TypeError, ValueError):
            numeric_keys = False
            break
    if numeric_keys and any(_is_geckolib_wrapper(item) for item in value.values()):
        return _convert_eased_channel(value)

    return {
        key: convert_geckolib_easing_keyframes(item)
        for key, item in value.items()
    }


def repair_geometry_identifiers(rp: Path) -> int:
    changed = 0
    for path in json_files(rp / "entity", rp / "models"):
        original = path.read_text(encoding="utf-8-sig")
        updated = original
        for old, new in GEOMETRY_IDENTIFIER_REPLACEMENTS.items():
            updated = updated.replace(f'"{old}"', f'"{new}"')
        replacements = sum(original.count(f'"{old}"') for old in GEOMETRY_IDENTIFIER_REPLACEMENTS)
        if updated != original:
            path.write_text(updated, encoding="utf-8")
            changed += replacements
    return changed


def _sanitize_bone_identifier(value: str) -> str:
    sanitized = re.sub(r"[^A-Za-z0-9_.-]+", "-", value).strip("-")
    if not sanitized:
        sanitized = "bone"
    if not sanitized[0].isalpha():
        sanitized = f"bone-{sanitized}"
    return sanitized


def repair_bone_identifiers(rp: Path) -> int:
    """Rename schema-invalid bones and all local geometry/animation references."""
    model_paths = list(json_files(rp / "models"))
    animation_paths = list(json_files(rp / "animations"))
    used_names: set[str] = set()
    invalid_names: set[str] = set()

    for path in model_paths:
        value = load_json(path)
        if not isinstance(value, dict):
            continue
        for geometry in value.get("minecraft:geometry", []):
            if not isinstance(geometry, dict):
                continue
            for bone in geometry.get("bones", []):
                if not isinstance(bone, dict):
                    continue
                name = bone.get("name")
                if isinstance(name, str):
                    used_names.add(name)
                    if not BONE_IDENTIFIER_PATTERN.fullmatch(name):
                        invalid_names.add(name)

    for path in animation_paths:
        value = load_json(path)
        animations = value.get("animations") if isinstance(value, dict) else None
        if not isinstance(animations, dict):
            continue
        for animation in animations.values():
            bones = animation.get("bones") if isinstance(animation, dict) else None
            if not isinstance(bones, dict):
                continue
            for name in bones:
                if not isinstance(name, str):
                    continue
                used_names.add(name)
                if not BONE_IDENTIFIER_PATTERN.fullmatch(name):
                    invalid_names.add(name)

    replacements: dict[str, str] = {}
    for old_name in sorted(invalid_names):
        base = _sanitize_bone_identifier(old_name)
        candidate = base
        suffix = 2
        while candidate in used_names:
            candidate = f"{base}-converted" if suffix == 2 else f"{base}-converted-{suffix}"
            suffix += 1
        replacements[old_name] = candidate
        used_names.add(candidate)

    changed = 0
    for path in model_paths:
        original = path.read_text(encoding="utf-8-sig")
        updated = original
        replacements_in_file = 0
        for old_name, new_name in replacements.items():
            quoted_old = re.escape(json.dumps(old_name, ensure_ascii=False))
            quoted_new = json.dumps(new_name, ensure_ascii=False)
            pattern = re.compile(rf'("(?:name|parent)"\s*:\s*){quoted_old}')
            updated, count = pattern.subn(
                lambda match: f"{match.group(1)}{quoted_new}",
                updated,
            )
            replacements_in_file += count
        if updated != original:
            path.write_text(updated, encoding="utf-8")
            changed += replacements_in_file

    for path in animation_paths:
        value = load_json(path)
        animations = value.get("animations") if isinstance(value, dict) else None
        repaired = False
        if not isinstance(animations, dict):
            continue
        for animation in animations.values():
            bones = animation.get("bones") if isinstance(animation, dict) else None
            if not isinstance(bones, dict):
                continue
            renamed: dict[str, Any] = {}
            for old_name, channels in bones.items():
                new_name = replacements.get(old_name, old_name)
                if new_name in renamed:
                    raise ValueError(f"Bone rename collision in {path}: {old_name} -> {new_name}")
                renamed[new_name] = channels
                if new_name != old_name:
                    changed += 1
                    repaired = True
            if repaired:
                animation["bones"] = renamed
        if repaired:
            write_json(path, value)
    return changed


def animation_slug(value: str) -> str:
    slug = re.sub(r"[^a-z0-9_]+", "_", value.lower()).strip("_")
    return slug or "unnamed"


def numeric_time_keys(value: Any) -> Iterable[float]:
    if not isinstance(value, dict):
        return
    for key in value:
        try:
            yield float(key)
        except (TypeError, ValueError):
            continue


def collect_geometry_bones(rp: Path) -> set[str]:
    names: set[str] = set()
    for path in json_files(rp / "models"):
        value = load_json(path)
        if not isinstance(value, dict):
            continue
        for geometry in value.get("minecraft:geometry", []):
            if not isinstance(geometry, dict):
                continue
            for bone in geometry.get("bones", []):
                if isinstance(bone, dict) and isinstance(bone.get("name"), str):
                    names.add(bone["name"])
    return names


def remove_java_custom_instruction_timeline(animation: dict[str, Any]) -> int:
    timeline = animation.get("timeline")
    if not isinstance(timeline, dict):
        return 0
    repaired: dict[str, Any] = {}
    removed = 0
    for timestamp, payload in timeline.items():
        if isinstance(payload, str):
            if JAVA_CUSTOM_INSTRUCTION_PATTERN.fullmatch(payload.strip()):
                removed += 1
            else:
                repaired[timestamp] = payload
            continue
        if isinstance(payload, list):
            filtered = [
                entry for entry in payload
                if not (
                    isinstance(entry, str)
                    and JAVA_CUSTOM_INSTRUCTION_PATTERN.fullmatch(entry.strip())
                )
            ]
            removed += len(payload) - len(filtered)
            if filtered:
                repaired[timestamp] = filtered
            continue
        repaired[timestamp] = payload
    if repaired:
        animation["timeline"] = repaired
    else:
        animation.pop("timeline", None)
    return removed


def repair_animations(rp: Path) -> tuple[int, int, int, int]:
    bones_in_project = collect_geometry_bones(rp)
    files = renamed = removed_bones = extended = 0
    for path in json_files(rp / "animations"):
        original_value = load_json(path)
        value = original_value
        if path.name in GECKOLIB_EASING_ANIMATIONS:
            value = collapse_vector_wrappers(
                convert_geckolib_easing_keyframes(value),
            )
        else:
            value = collapse_vector_wrappers(value)
        if not isinstance(value, dict) or not isinstance(value.get("animations"), dict):
            continue
        if not value["animations"]:
            path.unlink()
            files += 1
            continue
        value.pop("geckolib_format_version", None)
        value["format_version"] = CURRENT_ANIMATION_VERSION
        base = animation_slug(path.name.replace(".animation.json", "").replace(".json", ""))
        fixed_animations: dict[str, Any] = {}
        for old_name, animation in value["animations"].items():
            if old_name.startswith("animation."):
                new_name = old_name
            else:
                new_name = f"animation.thebrokenscript.{base}.{animation_slug(old_name)}"
                renamed += 1
            suffix = 2
            candidate = new_name
            while candidate in fixed_animations:
                candidate = f"{new_name}_{suffix}"
                suffix += 1
            new_name = candidate

            if isinstance(animation, dict):
                remove_java_custom_instruction_timeline(animation)
                if animation.get("bones") == {}:
                    animation.pop("bones")

            if isinstance(animation, dict) and isinstance(animation.get("bones"), dict):
                animation_bones = animation["bones"]
                for bone_name in list(animation_bones):
                    if bone_name not in bones_in_project:
                        del animation_bones[bone_name]
                        removed_bones += 1

                maximum_time = 0.0
                for bone in animation_bones.values():
                    if not isinstance(bone, dict):
                        continue
                    for channel_name in ("rotation", "position", "scale"):
                        maximum_time = max(maximum_time, *numeric_time_keys(bone.get(channel_name)), 0.0)
                length = animation.get("animation_length")
                if isinstance(length, (int, float)) and maximum_time > float(length):
                    animation["animation_length"] = maximum_time
                    extended += 1
                if not animation_bones:
                    animation.pop("bones")
            fixed_animations[new_name] = animation
        value["animations"] = fixed_animations
        if value != original_value:
            write_json(path, value)
        files += 1
    return files, renamed, removed_bones, extended


def cap_attack_damage(bp: Path) -> int:
    changed = 0
    for path in json_files(bp / "entities"):
        value = load_json(path)
        components = value.get("minecraft:entity", {}).get("components", {})
        attack = components.get("minecraft:attack") if isinstance(components, dict) else None
        if not isinstance(attack, dict):
            continue
        damage = attack.get("damage")
        if isinstance(damage, (int, float)) and damage > 50:
            attack["damage"] = 50
            write_json(path, value)
            changed += 1
    return changed


def rgb_hex(value: int) -> str:
    return f"#{value & 0xFFFFFF:06x}"


def migrate_client_biomes(rp: Path) -> int:
    legacy = rp / "biomes_client.json"
    if not legacy.is_file():
        return 0
    value = load_json(legacy)
    biomes = value.get("biomes_client", value.get("biomes", {}))
    if not isinstance(biomes, dict):
        raise ValueError(f"Unexpected client biome structure in {legacy}")
    count = 0
    for identifier, settings in biomes.items():
        if not isinstance(identifier, str) or not isinstance(settings, dict):
            continue
        short_name = identifier.split(":", 1)[-1]
        fog_identifier = f"thebrokenscript:fog_{short_name}"
        fog_color = rgb_hex(int(settings.get("fog_color", 0)))
        water_color = rgb_hex(int(settings.get("water_fog_color", 0)))
        write_json(
            rp / "fogs" / f"{short_name}.fog.json",
            {
                "format_version": "1.16.100",
                "minecraft:fog_settings": {
                    "description": {"identifier": fog_identifier},
                    "distance": {
                        "air": {
                            "fog_start": 0,
                            "fog_end": 64,
                            "render_distance_type": "fixed",
                            "fog_color": fog_color,
                        },
                        "water": {
                            "fog_start": 0,
                            "fog_end": 32,
                            "render_distance_type": "fixed",
                            "fog_color": water_color,
                        },
                    },
                },
            },
        )
        write_json(
            rp / "biomes_client" / f"{short_name}.biome_client.json",
            {
                "format_version": CURRENT_CONTENT_VERSION,
                "minecraft:client_biome": {
                    "description": {"identifier": identifier},
                    "components": {
                        "minecraft:fog_appearance": {"fog_identifier": fog_identifier},
                        "minecraft:sky_color": {"sky_color": fog_color},
                        "minecraft:water_appearance": {"surface_color": water_color},
                    },
                },
            },
        )
        count += 1
    legacy.unlink()
    return count


def repair_language_files(bp: Path, rp: Path) -> None:
    bp_lang = bp / "texts" / "en_US.lang"
    rp_lang = rp / "texts" / "en_US.lang"
    pack_lines = (
        "pack.name=The Broken Script 2.0\n"
        "pack.description=A Bedrock adaptation of The Broken Script horror experience.\n"
    )
    bp_lang.write_text(pack_lines, encoding="utf-8")
    rp_text = rp_lang.read_text(encoding="utf-8-sig")
    rp_text = rp_text.replace(
        "subtitles.thebrokenscript.glitch_overlay=$#*&!)%(*@?",
        "subtitles.thebrokenscript.glitch_overlay=§kGLITCH§r",
    )
    if "pack.name=" not in rp_text:
        rp_text = pack_lines + rp_text
    rp_lang.write_text(rp_text, encoding="utf-8")


def rename_nonlowercase_texture(rp: Path) -> int:
    source = rp / "textures" / "screens" / "very_serious" / "OygyluFufk.png"
    target = source.with_name(source.name.lower())
    if not source.exists():
        return 0
    if target.exists() and target.read_bytes() != source.read_bytes():
        raise RuntimeError(f"Refusing to overwrite different texture: {target}")
    if target.exists():
        source.unlink()
    else:
        source.rename(target)
    for path in json_files(rp):
        original = path.read_text(encoding="utf-8")
        updated = original.replace("OygyluFufk", "oygylufufk")
        if updated != original:
            path.write_text(updated, encoding="utf-8")
    return 1


def runtime_texture_references(rp: Path) -> set[str]:
    references: set[str] = set()
    pattern = re.compile(r"textures/[A-Za-z0-9_./-]+")
    for path in sorted(rp.rglob("*")):
        if not path.is_file() or path.suffix.lower() not in {".json", ".js", ".lang", ".material"}:
            continue
        try:
            text = path.read_text(encoding="utf-8-sig")
        except UnicodeDecodeError:
            continue
        for match in pattern.finditer(text):
            reference = match.group(0).rstrip(".").lower()
            for suffix in (".png", ".jpg", ".jpeg", ".tga"):
                if reference.endswith(suffix):
                    reference = reference[: -len(suffix)]
                    break
            references.add(reference)
    return references


def prune_unreferenced_textures(rp: Path) -> int:
    references = runtime_texture_references(rp)
    texture_root = rp / "textures"
    removed = 0
    for path in sorted(texture_root.rglob("*")):
        if not path.is_file() or path.suffix.lower() not in {".png", ".jpg", ".jpeg", ".tga"}:
            continue
        reference = path.relative_to(rp).with_suffix("").as_posix().lower()
        if reference not in references:
            path.unlink()
            removed += 1
    for directory in sorted((p for p in texture_root.rglob("*") if p.is_dir()), reverse=True):
        if not any(directory.iterdir()):
            directory.rmdir()
    return removed


def update_manifest(bp: Path) -> None:
    path = bp / "manifest.json"
    value = load_json(path)
    for dependency in value.get("dependencies", []):
        if dependency.get("module_name") == "@minecraft/server":
            dependency["version"] = "2.9.0"
    write_json(path, value)


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path.cwd())
    args = parser.parse_args()

    addon = args.root.resolve() / ADDON_NAME
    bp, rp = addon / "BP", addon / "RP"
    if not bp.is_dir() or not rp.is_dir():
        raise SystemExit(f"Expected add-on packs below {addon}")

    removed_boms = remove_json_boms(bp, rp)
    moved_textures, reference_files = normalize_texture_layout(rp)
    format_files = update_format_versions(bp, rp)
    biome_components = repair_biome_components(bp)
    block_geometries, custom_components = repair_block_components(bp)
    recipe_unlocks = repair_recipe_unlocks(bp)
    item_icons = repair_null_item_icon(bp)
    atlas_entries = repair_texture_atlases(rp)
    flipbooks = repair_flipbook(rp)
    sound_entries, sound_definitions = repair_sounds(rp)
    unused_audio = prune_unreferenced_audio(rp)
    ensure_render_controller(rp)
    geometry_identifiers = repair_geometry_identifiers(rp)
    bone_identifiers = repair_bone_identifiers(rp)
    animation_files, animation_names, animation_bones, animation_lengths = repair_animations(rp)
    attack_files = cap_attack_damage(bp)
    client_biomes = migrate_client_biomes(rp)
    repair_language_files(bp, rp)
    renamed_paths = rename_nonlowercase_texture(rp)
    unused_textures = prune_unreferenced_textures(rp)
    update_manifest(bp)

    print(f"Removed UTF-8 BOMs: {removed_boms}")
    print(f"Moved textures to canonical folders: {moved_textures}")
    print(f"Normalized texture references in files: {reference_files}")
    print(f"Updated content format versions: {format_files}")
    print(f"Migrated legacy biome climate components: {biome_components}")
    print(f"Added required full-block geometry components: {block_geometries}")
    print(f"Flattened deprecated custom components: {custom_components}")
    print(f"Added recipe unlock conditions: {recipe_unlocks}")
    print(f"Repaired item icon references: {item_icons}")
    print(f"Converted atlas paths to arrays: {atlas_entries}")
    print(f"Repaired flipbook entries: {flipbooks}")
    print(f"Removed missing sound entries/definitions: {sound_entries}/{sound_definitions}")
    print(f"Removed unreferenced audio files: {unused_audio}")
    print(f"Repaired geometry identifiers and references: {geometry_identifiers}")
    print(f"Repaired bone identifiers and references: {bone_identifiers}")
    print(
        "Repaired animations "
        f"(files/names/missing bones/lengths): {animation_files}/{animation_names}/{animation_bones}/{animation_lengths}"
    )
    print(f"Capped invalid attack components: {attack_files}")
    print(f"Migrated legacy client biomes: {client_biomes}")
    print(f"Renamed non-lowercase texture paths: {renamed_paths}")
    print(f"Removed unreferenced texture files: {unused_textures}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
