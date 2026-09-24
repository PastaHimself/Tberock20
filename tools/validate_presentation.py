#!/usr/bin/env python3
"""Validate player-visible animation, particle, audio, and UI contracts.

The source archive is intentionally treated as read-only evidence here.  The
validator checks that the deployed assets and the script adapters preserve the
source timing contract, while reporting Bedrock-only presentation boundaries
as warnings instead of presenting them as exact Java parity.
"""

from __future__ import annotations

import argparse
import json
import re
import sys
from pathlib import Path
from typing import Any, Iterable


ADDON_NAME = "TheBrokenScript_Bedrock_2_0"
ANIMATION_LENGTH_TOLERANCE_SECONDS = 0.1
CUSTOM_NAMESPACE = "thebrokenscript"

PARTICLE_EVENT_COUNTS = {
    "null_particle": 5,
    "eyes": 5,
    "particle_of_curved": 55,
    "fardaway": 50,
    "null_structure_particle": 1,
    "paper_particle": 1,
    "wretched_particle": 2,
}
PARTICLE_TYPE_FIELDS = {
    "NULL_PARTICLE": "null_particle",
    "FARDAWAY_PARTICLE": "fardaway",
    "EYES": "eyes",
    "WRETCHED_PARTICLE": "wretched_particle",
    "PARTICLE_OF_CURVED": "particle_of_curved",
    "NULL_STRUCTURE_PARTICLE": "null_structure_particle",
    "PAPER_PARTICLE": "paper_particle",
}
ADAPTED_PARTICLE_CALLSITE_TYPES = {
    "null_particle",
    "eyes",
    "fardaway",
    "null_structure_particle",
    "paper_particle",
    "particle_of_curved",
    "wretched_particle",
}

RECORD_ITEM_BY_EVENT = {
    "jimbob.full": "attribute_mutilation.json",
    "credits": "credits.json",
    "disc15_betray": "record_15.json",
    "disc16_youcant": "record_16.json",
    "disc17": "record_17.json",
    "instability": "instability.json",
    "instability_music_box": "instability_music_box.json",
    "instability_v2": "instabilityv2.json",
    "instability_v3": "instabilityv3.json",
    "record14": "record_14.json",
}
RECORD_LEVEL_SOUND_EVENT_BY_EVENT = {
    "jimbob.full": "lt.reaction.miscmystical2",
    "credits": "lt.reaction.miscmystical",
    "disc15_betray": "lt.reaction.epaste2",
    "disc16_youcant": "lt.reaction.epaste",
    "disc17": "lt.reaction.bleach",
    "instability": "lt.reaction.icebomb",
    "instability_music_box": "lt.reaction.miscfire",
    "instability_v2": "lt.reaction.mgsalt",
    "instability_v3": "lt.reaction.miscexplosion",
    "record14": "lt.reaction.fertilizer",
}
SCRIPT_ONLY_SONG_EVENTS = {"lilly_theme", "lilly_theme_v2"}
ADAPTED_SOUND_CUE_KEYS = {
    "baby",
    "c_death",
    "circuit_jumpscare_sound",
    "fardaway",
    "jimmy.moonrise.p1",
    "jimmy.moonrise.p2",
    "jimmy.moonrise.p3",
    "kills_player",
    "mazesfx",
    "moon_crack",
    "null_chase",
    "null_jumpscare_notloudanymore",
    "phantom",
    "transform",
    "woodsfx",
}
JAVA_MENU_FAMILIES = {
    "nullinterface",
    "null_interface_2",
    "null_interface_3",
    "nulled_gui",
    "command",
    "command_confirm",
    "polaroid_gui",
    "paper_gui",
    "library_book_gui",
    "fake_disconnect",
}

ANIMATION_RESOURCE_RE = re.compile(r"animations/([^\"']+\.json)")
ANIMATION_LITERAL_RE = re.compile(r"[\"'](animation\.[A-Za-z0-9_.-]+)[\"']")


def relative(root: Path, path: Path) -> str:
    try:
        return path.resolve().relative_to(root.resolve()).as_posix()
    except ValueError:
        return str(path)


def load_json(path: Path, root: Path, errors: list[str]) -> Any | None:
    try:
        return json.loads(path.read_text(encoding="utf-8-sig"))
    except (OSError, UnicodeDecodeError, json.JSONDecodeError) as exc:
        errors.append(f"Invalid JSON {relative(root, path)}: {exc}")
        return None


def is_number(value: Any) -> bool:
    return isinstance(value, (int, float)) and not isinstance(value, bool)


def walk_strings(value: Any) -> Iterable[str]:
    if isinstance(value, str):
        yield value
    elif isinstance(value, list):
        for item in value:
            yield from walk_strings(item)
    elif isinstance(value, dict):
        for item in value.values():
            yield from walk_strings(item)


def normalize_animation_token(value: str) -> str:
    return re.sub(r"[^a-z0-9]+", "_", value.lower()).strip("_")


def normalize_animation_id(value: str) -> str:
    return re.sub(r"[^a-z0-9_.-]+", "_", value.lower())


def animation_file_stem(filename: str) -> str:
    if filename.endswith(".animation.json"):
        return filename[: -len(".animation.json")]
    if filename.endswith(".json"):
        return filename[: -len(".json")]
    return filename


def expected_animation_id(filename: str, source_name: str) -> str:
    if source_name.lower().startswith("animation."):
        return normalize_animation_id(source_name)
    return normalize_animation_id(
        "animation.%s.%s.%s"
        % (
            CUSTOM_NAMESPACE,
            normalize_animation_token(animation_file_stem(filename)),
            normalize_animation_token(source_name),
        )
    )


def client_description(document: Any) -> dict[str, Any] | None:
    if not isinstance(document, dict):
        return None
    for key in ("minecraft:client_entity", "minecraft:attachable"):
        section = document.get(key)
        if isinstance(section, dict) and isinstance(section.get("description"), dict):
            return section["description"]
    return None


def validate_animations(
    root: Path,
    errors: list[str],
    warnings: list[str],
    counts: dict[str, int],
) -> dict[str, Any]:
    source_dir = root / "source_extracted/assets/thebrokenscript/animations"
    deployed_dir = root / ADDON_NAME / "RP/animations"
    source_files = sorted(source_dir.glob("*.json")) if source_dir.is_dir() else []
    deployed_files = sorted(deployed_dir.glob("*.json")) if deployed_dir.is_dir() else []
    counts["source_animation_files"] = len(source_files)
    counts["deployed_animation_files"] = len(deployed_files)

    if not source_dir.is_dir():
        errors.append(f"Missing source animation directory: {relative(root, source_dir)}")
    if not deployed_dir.is_dir():
        errors.append(f"Missing deployed animation directory: {relative(root, deployed_dir)}")

    source_names = {path.name for path in source_files}
    deployed_names = {path.name for path in deployed_files}
    if deployed_names - source_names:
        warnings.append(
            "Animation resources present only in the deployed pack: "
            + ", ".join(sorted(deployed_names - source_names))
        )

    source_entries = 0
    deployed_entries = 0
    length_comparisons = 0
    loop_comparisons = 0
    for source_path in source_files:
        deployed_path = deployed_dir / source_path.name
        source_document = load_json(source_path, root, errors)
        source_animations = source_document.get("animations", {}) if isinstance(source_document, dict) else {}
        if not isinstance(source_animations, dict):
            errors.append(f"Source animation map is not an object: {relative(root, source_path)}")
            source_animations = {}
        source_entries += len(source_animations)

        if not deployed_path.is_file():
            errors.append(f"Missing deployed animation file: {source_path.name}")
            continue
        deployed_document = load_json(deployed_path, root, errors)
        deployed_animations = deployed_document.get("animations", {}) if isinstance(deployed_document, dict) else {}
        if not isinstance(deployed_animations, dict):
            errors.append(f"Deployed animation map is not an object: {relative(root, deployed_path)}")
            deployed_animations = {}
        deployed_entries += len(deployed_animations)
        deployed_by_key = {
            normalize_animation_id(str(name)): (name, value)
            for name, value in deployed_animations.items()
            if isinstance(name, str)
        }

        for source_name, source_animation in source_animations.items():
            if not isinstance(source_name, str):
                continue
            expected_id = expected_animation_id(source_path.name, source_name)
            deployed_entry = deployed_by_key.get(expected_id)
            if deployed_entry is None:
                errors.append(
                    f"Missing deployed animation entry: {expected_id} "
                    f"(source {relative(root, source_path)})"
                )
                continue
            _, deployed_animation = deployed_entry
            if not isinstance(source_animation, dict) or not isinstance(deployed_animation, dict):
                continue

            source_length = source_animation.get("animation_length")
            deployed_length = deployed_animation.get("animation_length")
            if source_length is not None:
                length_comparisons += 1
                if not is_number(source_length) or not is_number(deployed_length):
                    errors.append(f"Animation length missing or invalid for {expected_id}")
                elif abs(float(source_length) - float(deployed_length)) > ANIMATION_LENGTH_TOLERANCE_SECONDS:
                    errors.append(
                        f"Animation length drift for {expected_id}: "
                        f"source={source_length}, deployed={deployed_length}"
                    )

            source_loop = source_animation.get("loop", False)
            deployed_loop = deployed_animation.get("loop", False)
            loop_comparisons += 1
            if source_loop != deployed_loop:
                errors.append(
                    f"Animation loop drift for {expected_id}: "
                    f"source={source_loop!r}, deployed={deployed_loop!r}"
                )

    counts["source_animation_entries"] = source_entries
    counts["deployed_animation_entries"] = deployed_entries
    counts["animation_length_comparisons"] = length_comparisons
    counts["animation_loop_comparisons"] = loop_comparisons

    java_references: set[str] = set()
    java_root = root / "decompiled/net/thebrokenscript"
    if java_root.is_dir():
        for path in java_root.rglob("*.java"):
            try:
                source = path.read_text(encoding="utf-8-sig")
            except (OSError, UnicodeDecodeError):
                continue
            java_references.update(ANIMATION_RESOURCE_RE.findall(source))
    counts["java_animation_model_references"] = len(java_references)
    for filename in sorted(java_references):
        if filename not in source_names:
            errors.append(f"Java animation resource is absent from source archive: {filename}")
        if filename not in deployed_names:
            errors.append(f"Java animation resource is absent from deployed pack: {filename}")

    deployed_ids = {
        normalize_animation_id(str(name))
        for path in deployed_files
        for document in [load_json(path, root, errors)]
        if isinstance(document, dict)
        for name in (document.get("animations", {}) if isinstance(document.get("animations", {}), dict) else {})
    }
    direct_ids: set[str] = set()
    scripts_root = root / ADDON_NAME / "BP/scripts"
    if scripts_root.is_dir():
        for path in scripts_root.rglob("*.js"):
            try:
                source = path.read_text(encoding="utf-8-sig")
            except (OSError, UnicodeDecodeError):
                continue
            direct_ids.update(ANIMATION_LITERAL_RE.findall(source))
    counts["script_animation_literals"] = len(direct_ids)
    for animation_id in sorted(direct_ids):
        if normalize_animation_id(animation_id) not in deployed_ids:
            errors.append(f"Script animation id is absent from deployed pack: {animation_id}")

    animation_model = scripts_root / "systems/fractured_animation_model.js"
    fractured_runtime = scripts_root / "entities/boss/fractured_runtime.js"
    model_source = animation_model.read_text(encoding="utf-8-sig") if animation_model.is_file() else ""
    runtime_source = fractured_runtime.read_text(encoding="utf-8-sig") if fractured_runtime.is_file() else ""
    for required in ("TICKS_PER_SECOND = 20", "sourceLengthTicks", "fracturedAnimationEventPlan"):
        if required not in model_source:
            errors.append(f"Fractured animation timing contract is missing: {required}")
    for required in ("playAnimation", "fracturedAnimationEventPlan"):
        if required not in runtime_source:
            errors.append(f"Fractured runtime presentation bridge is missing: {required}")

    return {
        "source_files": len(source_files),
        "deployed_files": len(deployed_files),
        "java_model_references": len(java_references),
        "direct_script_animation_ids": len(direct_ids),
        "length_tolerance_seconds": ANIMATION_LENGTH_TOLERANCE_SECONDS,
    }


def source_sound_path(value: str) -> str:
    path = value.split(":", 1)[1] if ":" in value else value
    if path.startswith("sounds/"):
        return path
    return f"sounds/{path}"


def sound_entry_parts(entry: Any) -> dict[str, Any] | None:
    if isinstance(entry, str):
        return {"name": entry}
    if isinstance(entry, dict):
        return entry
    return None


def validate_particles(
    root: Path,
    errors: list[str],
    warnings: list[str],
    counts: dict[str, int],
) -> dict[str, Any]:
    source_dir = root / "source_extracted/assets/thebrokenscript/particles"
    deployed_dir = root / ADDON_NAME / "RP/particles"
    source_files = sorted(source_dir.glob("*.json")) if source_dir.is_dir() else []
    deployed_files = sorted(deployed_dir.glob("*.json")) if deployed_dir.is_dir() else []
    counts["source_particle_files"] = len(source_files)
    counts["deployed_particle_files"] = len(deployed_files)

    if not source_dir.is_dir():
        errors.append(f"Missing source particle directory: {relative(root, source_dir)}")
    if not deployed_dir.is_dir():
        errors.append(f"Missing deployed particle directory: {relative(root, deployed_dir)}")

    java_particle_callsites: dict[str, set[str]] = {}
    java_root = root / "decompiled/net/thebrokenscript"
    if java_root.is_dir():
        for path in java_root.rglob("*.java"):
            if path.name in {"TBSParticleTypes.java", "TBSParticles.java"}:
                continue
            try:
                source = path.read_text(encoding="utf-8-sig")
            except (OSError, UnicodeDecodeError):
                continue
            for field, particle_id in PARTICLE_TYPE_FIELDS.items():
                if re.search(rf"TBSParticleTypes\.{field}\b", source):
                    java_particle_callsites.setdefault(particle_id, set()).add(relative(root, path))
    provider_source = root / "decompiled/net/thebrokenscript/registry/TBSParticles.java"
    provider_ids: set[str] = set()
    if provider_source.is_file():
        provider_text = provider_source.read_text(encoding="utf-8-sig")
        for field, particle_id in PARTICLE_TYPE_FIELDS.items():
            if re.search(rf"TBSParticleTypes\.{field}\.get\(\).*::provider", provider_text):
                provider_ids.add(particle_id)
    counts["java_particle_callsite_count"] = sum(len(paths) for paths in java_particle_callsites.values())
    counts["java_particle_callsite_types"] = len(java_particle_callsites)
    counts["java_particle_provider_types"] = len(provider_ids)
    unadapted_callsite_types = sorted(set(java_particle_callsites) - ADAPTED_PARTICLE_CALLSITE_TYPES)
    if unadapted_callsite_types:
        warnings.append(
            "Java custom particle callsite types without a generic Bedrock runtime bridge: "
            + ", ".join(unadapted_callsite_types)
        )

    source_ids: set[str] = set()
    deployed_ids: set[str] = set()
    required_components = (
        "minecraft:emitter_lifetime_once",
        "minecraft:emitter_rate_instant",
        "minecraft:particle_lifetime_expression",
        "minecraft:particle_initial_speed",
        "minecraft:particle_appearance_billboard",
    )
    for source_path in source_files:
        source_document = load_json(source_path, root, errors)
        source_textures = source_document.get("textures", []) if isinstance(source_document, dict) else []
        if not isinstance(source_textures, list):
            errors.append(f"Source particle textures are not an array: {relative(root, source_path)}")
            source_textures = []
        source_ids.add(source_path.stem)

        deployed_path = deployed_dir / f"{source_path.stem}.particle.json"
        if not deployed_path.is_file():
            errors.append(f"Missing deployed particle resource: {source_path.stem}.particle.json")
            continue
        deployed_document = load_json(deployed_path, root, errors)
        effect = deployed_document.get("particle_effect", {}) if isinstance(deployed_document, dict) else {}
        description = effect.get("description", {}) if isinstance(effect, dict) else {}
        components = effect.get("components", {}) if isinstance(effect, dict) else {}
        identifier = description.get("identifier") if isinstance(description, dict) else None
        expected_identifier = f"{CUSTOM_NAMESPACE}:{source_path.stem}"
        if identifier != expected_identifier:
            errors.append(
                f"Particle identifier mismatch for {relative(root, deployed_path)}: "
                f"expected={expected_identifier!r}, actual={identifier!r}"
            )
        if isinstance(identifier, str):
            deployed_ids.add(identifier)

        render_parameters = description.get("basic_render_parameters", {}) if isinstance(description, dict) else {}
        deployed_texture = render_parameters.get("texture") if isinstance(render_parameters, dict) else None
        for source_texture in source_textures:
            if not isinstance(source_texture, str) or ":" not in source_texture:
                errors.append(f"Invalid source particle texture in {relative(root, source_path)}: {source_texture!r}")
                continue
            texture_path = source_texture.split(":", 1)[1]
            expected_texture = f"textures/particle/{texture_path}"
            if deployed_texture != expected_texture:
                errors.append(
                    f"Particle texture mismatch for {expected_identifier}: "
                    f"expected={expected_texture!r}, actual={deployed_texture!r}"
                )
            if not (root / ADDON_NAME / "RP" / f"{expected_texture}.png").is_file():
                errors.append(f"Missing particle texture: {expected_texture}.png")

        if not isinstance(components, dict):
            errors.append(f"Particle components are not an object: {relative(root, deployed_path)}")
            continue
        for component in required_components:
            if component not in components:
                errors.append(f"Particle component missing from {relative(root, deployed_path)}: {component}")
        rate = components.get("minecraft:emitter_rate_instant", {})
        particle_count = rate.get("num_particles") if isinstance(rate, dict) else None
        if not is_number(particle_count) or particle_count <= 0:
            errors.append(f"Particle count is invalid for {expected_identifier}: {particle_count!r}")
        expected_count = PARTICLE_EVENT_COUNTS.get(source_path.stem)
        if expected_count is not None and particle_count != expected_count:
            errors.append(
                f"Particle event count drift for {expected_identifier}: "
                f"expected={expected_count}, actual={particle_count}"
            )

    adapter_path = deployed_dir / "moon_stone_block_burst.particle.json"
    adapter_document = load_json(adapter_path, root, errors) if adapter_path.is_file() else None
    if not adapter_path.is_file():
        errors.append("Missing deployed Rock block-impact particle resource: moon_stone_block_burst.particle.json")
    else:
        effect = adapter_document.get("particle_effect", {}) if isinstance(adapter_document, dict) else {}
        description = effect.get("description", {}) if isinstance(effect, dict) else {}
        components = effect.get("components", {}) if isinstance(effect, dict) else {}
        if isinstance(description.get("identifier"), str):
            deployed_ids.add(description["identifier"])
        rate = components.get("minecraft:emitter_rate_instant", {}) if isinstance(components, dict) else {}
        if not isinstance(rate, dict) or rate.get("num_particles") != 400:
            errors.append("Rock block-impact particle emitter must keep num_particles=400")
        if not isinstance(components, dict) or "minecraft:emitter_shape_point" not in components:
            errors.append("Rock block-impact particle emitter must define a point origin")

    counts["particle_resource_identifiers"] = len(deployed_ids)
    counts["particle_event_count_checks"] = len(PARTICLE_EVENT_COUNTS)
    fractured_runtime = root / ADDON_NAME / "BP/scripts/entities/boss/fractured_runtime.js"
    runtime_source = fractured_runtime.read_text(encoding="utf-8-sig") if fractured_runtime.is_file() else ""
    for required in ("fracturedRockBlockBurstPlan", "spawnParticle(burst.effectId, burst.origin)"):
        if required not in runtime_source:
            errors.append(f"Rock block-impact particle runtime bridge is missing: {required}")

    if "thebrokenscript:follows_particle" in deployed_ids or "thebrokenscript:revuxor_particle" in deployed_ids:
        warnings.append(
            "follows_particle and revuxor_particle remain resource-only until a Java runtime provider/callsite is found"
        )
    return {
        "source_definitions": len(source_files),
        "deployed_definitions": len(deployed_files),
        "java_particle_callsite_types": sorted(java_particle_callsites),
        "java_particle_callsites": {
            particle_id: sorted(paths)
            for particle_id, paths in sorted(java_particle_callsites.items())
        },
        "java_particle_provider_types": sorted(provider_ids),
        "unadapted_callsite_types": unadapted_callsite_types,
        "rock_burst_count": 400,
        "event_counts": PARTICLE_EVENT_COUNTS,
    }


def validate_audio(
    root: Path,
    errors: list[str],
    warnings: list[str],
    counts: dict[str, int],
) -> dict[str, Any]:
    addon = root / ADDON_NAME
    source_song_dir = root / "source_extracted/data/thebrokenscript/jukebox_song"
    source_sounds_path = root / "source_extracted/assets/thebrokenscript/sounds.json"
    sound_definitions_path = addon / "RP/sound_definitions.json"
    event_routes_path = addon / "RP/sounds.json"
    source_song_files = sorted(source_song_dir.glob("*.json")) if source_song_dir.is_dir() else []
    source_sounds = load_json(source_sounds_path, root, errors) if source_sounds_path.is_file() else {}
    sound_definitions = load_json(sound_definitions_path, root, errors) if sound_definitions_path.is_file() else {}
    event_routes_document = load_json(event_routes_path, root, errors) if event_routes_path.is_file() else {}
    source_sounds = source_sounds if isinstance(source_sounds, dict) else {}
    sound_definitions = sound_definitions.get("sound_definitions", {}) if isinstance(sound_definitions, dict) else {}
    if not isinstance(sound_definitions, dict):
        sound_definitions = {}
    event_routes = (
        event_routes_document.get("individual_event_sounds", {}).get("events", {})
        if isinstance(event_routes_document, dict)
        else {}
    )
    if not isinstance(event_routes, dict):
        event_routes = {}

    counts["source_song_definitions"] = len(source_song_files)
    counts["sound_definitions_checked"] = 0
    counts["source_sound_definitions"] = len(source_sounds)
    counts["deployed_sound_definitions"] = len(sound_definitions)
    counts["record_items"] = len(RECORD_ITEM_BY_EVENT)
    counts["script_only_song_definitions"] = len(SCRIPT_ONLY_SONG_EVENTS)

    def report_sound_drift(event_key: str, message: str) -> None:
        if event_key in ADAPTED_SOUND_CUE_KEYS:
            warnings.append(f"Source/deployed sound cue adapter for {event_key}: {message}")
        else:
            errors.append(message)

    missing_sound_definitions = sorted(set(source_sounds) - set(sound_definitions))
    intentional_source_only_sounds = {"video/alpha3"}
    for event_key in missing_sound_definitions:
        if event_key in intentional_source_only_sounds:
            warnings.append(f"Source sound definition remains intentionally out of pack: {event_key}")
        else:
            errors.append(f"Missing deployed sound definition: {event_key}")
    unexpected_sound_definitions = sorted(set(sound_definitions) - set(source_sounds))
    if unexpected_sound_definitions:
        warnings.append(
            "Deployed sound definitions have no extracted source counterpart: "
            + ", ".join(unexpected_sound_definitions)
        )
    source_songs_by_event: dict[str, dict[str, Any]] = {}
    for source_path in source_song_files:
        document = load_json(source_path, root, errors)
        if not isinstance(document, dict):
            continue
        sound_event = document.get("sound_event")
        if not isinstance(sound_event, str) or ":" not in sound_event:
            errors.append(f"Jukebox song has invalid sound_event: {relative(root, source_path)}")
            continue
        event_key = sound_event.split(":", 1)[1]
        source_songs_by_event[event_key] = document
        target_definition = sound_definitions.get(event_key)
        if not isinstance(target_definition, dict):
            errors.append(f"Missing deployed sound definition for source song: {event_key}")
            continue
        counts["sound_definitions_checked"] += 1
        source_definition = source_sounds.get(event_key, {})
        source_entries = source_definition.get("sounds", []) if isinstance(source_definition, dict) else []
        target_entries = target_definition.get("sounds", [])
        if not isinstance(source_entries, list) or not isinstance(target_entries, list):
            errors.append(f"Sound definition entries are not arrays for source song: {event_key}")
            continue
        if len(source_entries) != len(target_entries):
            report_sound_drift(event_key,
                f"Sound cue count drift for {event_key}: source={len(source_entries)}, deployed={len(target_entries)}"
            )
        for index, source_entry in enumerate(source_entries):
            if index >= len(target_entries):
                break
            source_parts = sound_entry_parts(source_entry)
            target_parts = sound_entry_parts(target_entries[index])
            if source_parts is None or target_parts is None or not isinstance(source_parts.get("name"), str):
                errors.append(f"Invalid sound cue entry for {event_key}[{index}]")
                continue
            target_name = target_parts.get("name")
            expected_path = source_sound_path(source_parts["name"])
            if target_name != expected_path:
                report_sound_drift(event_key,
                    f"Sound path drift for {event_key}[{index}]: "
                    f"source={expected_path!r}, deployed={target_name!r}"
                )
            if isinstance(target_name, str) and not (addon / "RP" / f"{target_name}.ogg").is_file():
                errors.append(f"Missing OGG for {event_key}: {target_name}.ogg")
            for property_name in (
                "stream",
                "volume",
                "pitch",
                "attenuation_distance",
                "preload",
                "weight",
                "load_on_low_memory",
                "is3D",
            ):
                if property_name in source_parts and source_parts.get(property_name) != target_parts.get(property_name):
                    report_sound_drift(event_key,
                        f"Sound property drift for {event_key}[{index}].{property_name}: "
                        f"source={source_parts.get(property_name)!r}, deployed={target_parts.get(property_name)!r}"
                    )

    # The jukebox loop above checks song-specific timing and record coverage.
    # Check every remaining extracted sound cue as well, while preserving the
    # one intentional source-only video cue above as an explicit warning.
    for event_key in sorted((set(source_sounds) & set(sound_definitions)) - set(source_songs_by_event)):
        source_definition = source_sounds.get(event_key, {})
        target_definition = sound_definitions.get(event_key, {})
        source_entries = source_definition.get("sounds", []) if isinstance(source_definition, dict) else []
        target_entries = target_definition.get("sounds", []) if isinstance(target_definition, dict) else []
        if not isinstance(source_entries, list) or not isinstance(target_entries, list):
            errors.append(f"Sound definition entries are not arrays for source cue: {event_key}")
            continue
        counts["sound_definitions_checked"] += 1
        if len(source_entries) != len(target_entries):
            report_sound_drift(event_key,
                f"Sound cue count drift for {event_key}: source={len(source_entries)}, deployed={len(target_entries)}"
            )
        for index, source_entry in enumerate(source_entries):
            if index >= len(target_entries):
                break
            source_parts = sound_entry_parts(source_entry)
            target_parts = sound_entry_parts(target_entries[index])
            if source_parts is None or target_parts is None or not isinstance(source_parts.get("name"), str):
                errors.append(f"Invalid sound cue entry for {event_key}[{index}]")
                continue
            target_name = target_parts.get("name")
            expected_path = source_sound_path(source_parts["name"])
            if target_name != expected_path:
                report_sound_drift(event_key,
                    f"Sound path drift for {event_key}[{index}]: "
                    f"source={expected_path!r}, deployed={target_name!r}"
                )
            if isinstance(target_name, str) and not (addon / "RP" / f"{target_name}.ogg").is_file():
                errors.append(f"Missing OGG for {event_key}: {target_name}.ogg")
            for property_name in (
                "stream",
                "volume",
                "pitch",
                "attenuation_distance",
                "preload",
                "weight",
                "load_on_low_memory",
                "is3D",
            ):
                if property_name in source_parts and source_parts.get(property_name) != target_parts.get(property_name):
                    report_sound_drift(event_key,
                        f"Sound property drift for {event_key}[{index}].{property_name}: "
                        f"source={source_parts.get(property_name)!r}, deployed={target_parts.get(property_name)!r}"
                    )

    all_source_events = set(source_songs_by_event)
    represented_events = set(RECORD_ITEM_BY_EVENT) | SCRIPT_ONLY_SONG_EVENTS
    if all_source_events != represented_events:
        errors.append(
            "Jukebox song coverage drift: "
            f"unrepresented={sorted(all_source_events - represented_events)}, "
            f"unexpected={sorted(represented_events - all_source_events)}"
        )

    for event_key, item_filename in RECORD_ITEM_BY_EVENT.items():
        item_path = addon / "BP/items" / item_filename
        document = load_json(item_path, root, errors) if item_path.is_file() else None
        if not item_path.is_file():
            errors.append(f"Missing music-disc item: {relative(root, item_path)}")
            continue
        item = document.get("minecraft:item", {}) if isinstance(document, dict) else {}
        components = item.get("components", {}) if isinstance(item, dict) else {}
        record = components.get("minecraft:record") if isinstance(components, dict) else None
        source_song = source_songs_by_event.get(event_key, {})
        if not isinstance(record, dict):
            errors.append(f"Music-disc item is missing minecraft:record: {relative(root, item_path)}")
            continue
        expected_level_event = RECORD_LEVEL_SOUND_EVENT_BY_EVENT[event_key]
        if record.get("sound_event") != expected_level_event:
            errors.append(
                f"Music-disc LevelSoundEvent drift for {item_filename}: "
                f"expected={expected_level_event!r}, actual={record.get('sound_event')!r}"
            )
        route = event_routes.get(expected_level_event)
        if not isinstance(route, dict) or route.get("sound") != event_key:
            errors.append(
                f"Music-disc sound route drift for {item_filename}: "
                f"{expected_level_event!r} must route to {event_key!r} in RP/sounds.json"
            )
        expected_duration = source_song.get("length_in_seconds")
        if not is_number(record.get("duration")) or not is_number(expected_duration) or abs(
            float(record["duration"]) - float(expected_duration)
        ) > 0.01:
            errors.append(
                f"Music-disc duration drift for {item_filename}: "
                f"expected={expected_duration!r}, actual={record.get('duration')!r}"
            )
        # Java's extracted comparator output is 15, but Bedrock's component
        # contract caps comparator_signal at 13; 13 is the explicit adapter.
        if record.get("comparator_signal") != 13:
            errors.append(f"Music-disc comparator_signal must use the Bedrock-safe value 13: {item_filename}")
        if components.get("minecraft:max_stack_size") != 1:
            errors.append(f"Music-disc items must remain unstackable: {item_filename}")

    fractured_runtime = addon / "BP/scripts/entities/boss/fractured_runtime.js"
    main_path = addon / "BP/scripts/main.js"
    runtime_source = fractured_runtime.read_text(encoding="utf-8-sig") if fractured_runtime.is_file() else ""
    main_source = main_path.read_text(encoding="utf-8-sig") if main_path.is_file() else ""
    for required in (
        "soundInstances",
        "soundStops",
        "stopArenaSounds",
        "instance.stop()",
        "onPlayerLeave",
        "onPlayerDimensionChange",
        "onPlayerDeath",
    ):
        if required not in (runtime_source + main_source):
            errors.append(f"Player-visible audio cleanup hook is missing: {required}")
    warnings.append(
        "Java FancyAudio fade/attenuation and reload-time client mixing remain engine-specific; "
        "tracked Bedrock SoundInstance handles cover arena reset and player lifecycle cleanup"
    )
    return {
        "source_song_definitions": len(source_song_files),
        "record_items": len(RECORD_ITEM_BY_EVENT),
        "script_only_song_definitions": len(SCRIPT_ONLY_SONG_EVENTS),
        "custom_sound_event_mode": "stable LevelSoundEvent alias routed through RP/sounds.json",
    }


def count_object_keys(value: Any, key: str) -> int:
    if isinstance(value, dict):
        return sum((1 if name == key else 0) + count_object_keys(item, key) for name, item in value.items())
    if isinstance(value, list):
        return sum(count_object_keys(item, key) for item in value)
    return 0


def validate_ui_and_camera(
    root: Path,
    errors: list[str],
    warnings: list[str],
    counts: dict[str, int],
) -> dict[str, Any]:
    addon = root / ADDON_NAME
    rp = addon / "RP"
    ui_dir = rp / "ui"
    ui_files = sorted(ui_dir.glob("*.json")) if ui_dir.is_dir() else []
    counts["ui_files"] = len(ui_files)
    ui_documents = {path.name: load_json(path, root, errors) for path in ui_files}
    definitions = ui_documents.get("_ui_defs.json")
    hud = ui_documents.get("hud_screen.json")
    overlay = ui_documents.get("vhs_overlay.json")
    if not isinstance(definitions, dict) or "ui/vhs_overlay.json" not in definitions.get("ui_defs", []):
        errors.append("VHS overlay must be loaded through RP/ui/_ui_defs.json")
    if not isinstance(hud, dict):
        errors.append("RP/ui/hud_screen.json is missing")
    else:
        hud_section = hud.get("hud_screen", {})
        if not isinstance(hud_section, dict) or hud_section.get("$additional_screen_content") != "vhs_overlay.root":
            errors.append("HUD must inject vhs_overlay.root through $additional_screen_content")
        if not isinstance(hud_section, dict) or hud_section.get("render_only_when_topmost") is not True:
            errors.append("VHS HUD overlay must render only when the HUD is topmost")
    if not isinstance(overlay, dict) or overlay.get("namespace") != "vhs_overlay":
        errors.append("VHS overlay must use the isolated vhs_overlay namespace")
    if isinstance(overlay, dict):
        root_control = overlay.get("root", {})
        if not isinstance(root_control, dict) or root_control.get("type") != "panel":
            errors.append("VHS overlay root must remain a panel")
        textures = {
            value
            for value in walk_strings(overlay)
            if value.startswith("textures/ui/vhs/")
        }
        counts["vhs_overlay_textures"] = len(textures)
        for texture in sorted(textures):
            base_path = rp / f"{texture}.png"
            subpack_paths = list((rp / "subpacks").glob(f"*/{texture}.png")) if (rp / "subpacks").is_dir() else []
            if not base_path.is_file() and not subpack_paths:
                errors.append(f"Missing VHS overlay texture: {texture}.png")

    for filename, document in ui_documents.items():
        if filename != "hud_screen.json" and count_object_keys(document, "$additional_screen_content"):
            errors.append(f"UI file unexpectedly injects another screen: {filename}")

    menu_source_path = root / "decompiled/net/thebrokenscript/registry/TBSMenus.java"
    menu_source = menu_source_path.read_text(encoding="utf-8-sig") if menu_source_path.is_file() else ""
    menu_families = set(re.findall(r'TBSReg\.INSTANCE\.menu\("([^"]+)"', menu_source))
    counts["java_menu_families"] = len(menu_families)
    if menu_families != JAVA_MENU_FAMILIES:
        errors.append(
            "Java menu family inventory drift: "
            f"missing={sorted(JAVA_MENU_FAMILIES - menu_families)}, "
            f"unexpected={sorted(menu_families - JAVA_MENU_FAMILIES)}"
        )

    client_files = sorted((rp / "entity").glob("*.json")) if (rp / "entity").is_dir() else []
    animation_bindings = 0
    render_definitions: set[str] = set()
    animation_controller_definitions: set[str] = set()
    for path in sorted(rp.rglob("*.json")):
        document = load_json(path, root, errors)
        if not isinstance(document, dict):
            continue
        render = document.get("render_controllers")
        if isinstance(render, dict):
            render_definitions.update(name for name in render if isinstance(name, str))
        controllers = document.get("animation_controllers")
        if isinstance(controllers, dict):
            animation_controller_definitions.update(name for name in controllers if isinstance(name, str))
    for path in client_files:
        document = load_json(path, root, errors)
        description = client_description(document)
        identifier = description.get("identifier") if description else None
        if not description or not isinstance(identifier, str) or identifier.startswith("minecraft:"):
            continue
        if description.get("animations") or isinstance(description.get("scripts"), dict) and description["scripts"].get("animate"):
            animation_bindings += 1
        for render_controller in walk_strings(description.get("render_controllers", [])):
            if render_controller.startswith("controller.render.") and render_controller not in render_definitions:
                if render_controller != "controller.render.item_default":
                    errors.append(f"Missing render controller for {relative(root, path)}: {render_controller}")
    counts["client_entities_with_animation_bindings"] = animation_bindings
    counts["render_controller_definitions"] = len(render_definitions)
    counts["animation_controller_definitions"] = len(animation_controller_definitions)
    if not animation_controller_definitions:
        warnings.append(
            "No Bedrock animation-controller definitions are deployed; state changes use guarded script playAnimation bridges"
        )

    camera_files = [
        addon / "BP/scripts/entities/boss/integrity_camera.js",
        addon / "BP/scripts/entities/boss/integrity_arena_runtime.js",
    ]
    camera_source = "\n".join(
        path.read_text(encoding="utf-8-sig") for path in camera_files if path.is_file()
    )
    camera_methods = {method for method in ("setCamera", "setCameraWithEase", "playAnimation", "fade", "clear") if method in camera_source}
    counts["camera_api_methods"] = len(camera_methods)
    for required in ("setCamera", "fade", "clear"):
        if required not in camera_source:
            errors.append(f"Integrity camera adapter is missing Camera.{required}")
    warnings.append(
        "VHS overlay scope is statically HUD-only; multiplayer/client rendering still requires an in-game smoke check"
    )
    warnings.append(
        "Custom Java glyph mapping remains deferred and the Java GLSL pipeline remains BLOCKED; visible mood effects are audited as adapters"
    )
    return {
        "ui_files": len(ui_files),
        "java_menu_families": len(menu_families),
        "camera_api_methods": sorted(camera_methods),
        "shader_pipeline": "blocked_exact_parity",
        "font_mapping": "deferred_until_glyph_map_is_verified",
    }


def validate_presentation(root: Path) -> dict[str, Any]:
    root = root.resolve()
    errors: list[str] = []
    warnings: list[str] = []
    counts: dict[str, int] = {}
    checks: dict[str, Any] = {}
    checks["animations"] = validate_animations(root, errors, warnings, counts)
    checks["particles"] = validate_particles(root, errors, warnings, counts)
    checks["audio"] = validate_audio(root, errors, warnings, counts)
    checks["ui_camera"] = validate_ui_and_camera(root, errors, warnings, counts)
    return {
        "ok": not errors,
        "errors": errors,
        "warnings": warnings,
        "counts": counts,
        "checks": checks,
    }


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description="Validate TBS 2.0 presentation and player-visible timing contracts")
    parser.add_argument("--root", type=Path, default=Path.cwd())
    parser.add_argument("--report", type=Path)
    args = parser.parse_args(argv)

    result = validate_presentation(args.root)
    report = json.dumps(result, indent=2, sort_keys=True)
    print(report)
    if args.report:
        report_path = args.report if args.report.is_absolute() else args.root / args.report
        report_path.parent.mkdir(parents=True, exist_ok=True)
        report_path.write_text(report + "\n", encoding="utf-8")
    return 0 if result["ok"] else 1


if __name__ == "__main__":
    sys.exit(main())
