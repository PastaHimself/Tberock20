#!/usr/bin/env python3
"""Validate the source-backed P1 content and dimension parity contract.

This is an evidence validator, not a Minecraft engine simulator.  It compares
the extracted Java resource registries with the files and runtime adapters that
are actually shipped by the Bedrock add-on.  Unsupported Java-only surfaces
are recorded as explicit warnings in the report instead of being silently
treated as complete.
"""

from __future__ import annotations

import argparse
import importlib.util
import json
import re
import sys
from pathlib import Path
from typing import Any, Iterable


ROOT = Path(__file__).resolve().parents[1]
ADDON_NAME = "TheBrokenScript_Bedrock_2_0"
ADDON_ROOT = ROOT / ADDON_NAME
NAMESPACE = "thebrokenscript"
VALIDATOR_VERSION = 2

TODO_ITEMS = [
    "P1 — Quests, items, blocks, loot, and commands",
    "P1 — Dimensions, worldgen, structures, and portals",
]

SOURCE_BLOCK_ENTITY_NAMES = (
    "command",
    "all_dead",
    "exit",
    "shadow_bug",
    "portal_controller",
    "portal_extender",
    "null_structure",
    "a_flower",
)

BLOCK_ENTITY_ADAPTERS = {
    "command": {
        "block": "thebrokenscript:command",
        "component": "thebrokenscript:be_command",
        "kind": "scripted_state",
    },
    "all_dead": {
        "block": "thebrokenscript:flesh",
        "component": None,
        "kind": "renderer_only_block_adapter",
    },
    "exit": {
        "block": "thebrokenscript:exit",
        "component": "thebrokenscript:be_exit",
        "kind": "interaction_adapter",
    },
    "shadow_bug": {
        "block": "thebrokenscript:shadow_bug",
        "component": "thebrokenscript:be_shadow_bug",
        "kind": "random_tick_adapter",
    },
    "portal_controller": {
        "block": "thebrokenscript:portal_controller",
        "component": "thebrokenscript:be_portal_controller",
        "kind": "persistent_link_adapter",
    },
    "portal_extender": {
        "block": "thebrokenscript:portal_extender",
        "component": "thebrokenscript:be_portal_extender",
        "kind": "interaction_adapter",
    },
    "null_structure": {
        "block": "thebrokenscript:null_structure",
        "component": "thebrokenscript:be_null_structure",
        "kind": "passive_marker_adapter",
    },
    "a_flower": {
        "block": "thebrokenscript:a_flower",
        "component": "thebrokenscript:be_a_flower",
        "kind": "interaction_adapter",
    },
}

SCRIPTED_ITEM_COMPONENTS = {
    "thebrokenscript:hand_cannon": "thebrokenscript:hand_cannon_use",
    "thebrokenscript:polaroid": "thebrokenscript:polaroid_use",
    "thebrokenscript:portal_linker": "thebrokenscript:portal_linker_use",
    "thebrokenscript:desyncer": "thebrokenscript:desyncer_use",
    "thebrokenscript:circuit_cave_painting": "thebrokenscript:circuit_cave_place",
    "thebrokenscript:revuxorfish": "thebrokenscript:revuxorfish_consume",
    "thebrokenscript:faraway_salmon": "thebrokenscript:faraway_salmon_consume",
    "thebrokenscript:n": "thebrokenscript:n_use",
    "thebrokenscript:gore": "thebrokenscript:gore_use",
    "thebrokenscript:torn_paper": "thebrokenscript:torn_paper_use",
    "thebrokenscript:book": "thebrokenscript:library_book_use",
}

COD_ITEM_NAMES = (
    "bennie_cod",
    "v1_cod",
    "shadowmaster_cod",
    "redstone_cod",
    "corrupt_ebridger_cod",
    "dominik_cod",
    "ebridger_cod",
    "eldritch_cod",
    "evil_codstone_cod",
    "eyae_cod",
    "garreth_cod",
    "jd_cod",
    "lost_need_cod",
    "pencil_cod",
    "v2_cod",
    "tekkit_cod",
    "zetos_cod",
)

RECORD_ITEM_CONTRACTS = {
    "record_14": {"rarity": "rare", "duration": 61, "sound_event": "record14", "bedrock_sound_event": "lt.reaction.fertilizer"},
    "record_15": {"rarity": "rare", "duration": 78, "sound_event": "disc15_betray", "bedrock_sound_event": "lt.reaction.epaste2"},
    "record_16": {"rarity": "rare", "duration": 98, "sound_event": "disc16_youcant", "bedrock_sound_event": "lt.reaction.epaste"},
    "record_17": {"rarity": "rare", "duration": 63.5, "sound_event": "disc17", "bedrock_sound_event": "lt.reaction.bleach"},
    "instability": {"rarity": "rare", "duration": 233.5, "sound_event": "instability", "bedrock_sound_event": "lt.reaction.icebomb"},
    "instabilityv2": {"rarity": "epic", "duration": 239, "sound_event": "instability_v2", "bedrock_sound_event": "lt.reaction.mgsalt"},
    "instabilityv3": {"rarity": "epic", "duration": 278, "sound_event": "instability_v3", "bedrock_sound_event": "lt.reaction.miscexplosion"},
    "instability_music_box": {"rarity": "rare", "duration": 179, "sound_event": "instability_music_box", "bedrock_sound_event": "lt.reaction.miscfire"},
    "attribute_mutilation": {"rarity": "rare", "duration": 157, "sound_event": "jimbob.full", "bedrock_sound_event": "lt.reaction.miscmystical2"},
    "credits": {"rarity": "rare", "duration": 165, "sound_event": "credits", "bedrock_sound_event": "lt.reaction.miscmystical"},
    "lilly": {"rarity": "epic", "duration": 208, "sound_event": "lilly_theme", "bedrock_sound_event": "lt.reaction.fire"},
    "lilly_v2": {"rarity": "epic", "duration": 204, "sound_event": "lilly_theme_v2", "bedrock_sound_event": "lt.reaction.fireball"},
}

FIRE_RESISTANT_ITEM_CONTRACTS = {
    **{f"piece_{index}": {"rarity": "uncommon"} for index in range(1, 6)},
    "polaroid": {"rarity": "rare"},
    "torn_paper": {"rarity": "uncommon"},
}

ITEM_MODEL_ALIASES = {
    # The source model is the vanilla Totem of Undying model; it is not a
    # custom item registry entry in the extracted mod.
    "thebrokenscript:totem": "minecraft:totem_of_undying",
}

STATEFUL_LOOT_TABLES = {
    "moon_stone_brick_slab",
    "polished_moon_stone_slab",
    "protected_void_slab",
    "spruce_wood_slab",
    "smooth_stone_vertical_slab",
    "ud_oak_door",
    "void_door",
    "void_log_door",
    "void_plank_door",
}

LOOT_OUTPUT_ADAPTERS = {
    "sideways_cobblestone_stairs": (
        "minecraft:cobblestone_stairs",
        "thebrokenscript:sideways_cobblestone_stairs",
    ),
    "ud_oak_door": (
        "minecraft:oak_door",
        "thebrokenscript:ud_oak_door",
    ),
}

FLORA_LOOT_TABLES = {
    "void_grass",
    "void_sprout",
    "void_bud",
    "void_budding",
    "void_bloom",
    "void_blossom",
    "void_vine",
}

SOURCE_DIMENSION_NAMES = (
    "backrooms",
    "clan_void",
    "concrete",
    "library",
    "limbo",
    "lucid",
    "nothing",
    "nowhere",
    "null_torture",
    "protected_void",
    "stage2",
    "the_moon",
    "void_shadow",
)


def _read(path: Path) -> str:
    return path.read_text(encoding="utf-8-sig", errors="replace")


def _strip_js_comments(source: str) -> str:
    """Remove comments before checking runtime call sites.

    The parity gate should not pass because a removed call is still mentioned
    in a stale explanatory comment.
    """

    source = re.sub(r"/\*.*?\*/", "", source, flags=re.DOTALL)
    return re.sub(r"//[^\r\n]*", "", source)


def _load_json(path: Path) -> Any:
    return json.loads(_read(path))


def _sorted_json_files(directory: Path) -> list[Path]:
    return sorted(path for path in directory.glob("*.json") if path.is_file())


def _identifier(document: Any, key: str) -> str | None:
    if not isinstance(document, dict):
        return None
    value = document.get(key)
    if not isinstance(value, dict):
        return None
    description = value.get("description")
    if not isinstance(description, dict):
        return None
    identifier = description.get("identifier")
    return identifier if isinstance(identifier, str) else None


def _bp_identifiers(directory: Path, key: str) -> dict[str, Path]:
    identifiers: dict[str, Path] = {}
    for path in _sorted_json_files(directory):
        try:
            identifier = _identifier(_load_json(path), key)
        except (OSError, json.JSONDecodeError):
            continue
        if identifier:
            identifiers[identifier] = path
    return identifiers


def _source_block_ids(repo: Path) -> list[str]:
    root = repo / "source_extracted/assets/thebrokenscript/blockstates"
    return [f"{NAMESPACE}:{path.stem}" for path in _sorted_json_files(root)]


def _source_item_model_ids(repo: Path) -> list[str]:
    root = repo / "source_extracted/assets/thebrokenscript/models/item"
    return [f"{NAMESPACE}:{path.stem}" for path in _sorted_json_files(root)]


def _block_entity_contract(repo: Path, component_source: str) -> dict[str, Any]:
    source_path = repo / "decompiled/net/thebrokenscript/registry/TBSBlockEntities.java"
    source = _read(source_path)
    registered = re.findall(r'blockEntity\("([^"]+)"', source)
    normalized = ["all_dead" if name == "all" else name for name in registered]
    missing_source = sorted(set(SOURCE_BLOCK_ENTITY_NAMES) - set(normalized))
    extra_source = sorted(set(normalized) - set(SOURCE_BLOCK_ENTITY_NAMES))
    missing_runtime: list[str] = []
    adapters: dict[str, Any] = {}
    for name in SOURCE_BLOCK_ENTITY_NAMES:
        contract = BLOCK_ENTITY_ADAPTERS[name]
        block_path = repo / "TheBrokenScript_Bedrock_2_0/BP/blocks" / f"{contract['block'].split(':', 1)[1]}.json"
        component = contract["component"]
        if not block_path.is_file():
            missing_runtime.append(f"{name}: missing {block_path.name}")
        if component and component not in component_source:
            missing_runtime.append(f"{name}: missing {component} registration/use")
        adapters[name] = {
            **contract,
            "block_file": block_path.relative_to(repo).as_posix(),
            "source_registered": name in normalized,
        }
    return {
        "source_registered": normalized,
        "source_count": len(normalized),
        "missing_source": missing_source,
        "extra_source": extra_source,
        "missing_runtime": missing_runtime,
        "adapters": adapters,
    }


def _item_contract(repo: Path, component_source: str) -> dict[str, Any]:
    source_ids = _source_item_model_ids(repo)
    source_set = set(source_ids)
    bp_items = _bp_identifiers(repo / f"{ADDON_NAME}/BP/items", "minecraft:item")
    bp_blocks = _bp_identifiers(repo / f"{ADDON_NAME}/BP/blocks", "minecraft:block")
    combined = set(bp_items) | set(bp_blocks)
    unresolved = sorted(
        identifier
        for identifier in source_set
        if identifier not in combined
        and identifier not in ITEM_MODEL_ALIASES
    )
    component_usage: dict[str, Any] = {}
    missing_components: list[str] = []
    component_code = _strip_js_comments(component_source)
    for item_id, component in SCRIPTED_ITEM_COMPONENTS.items():
        path = bp_items.get(item_id)
        used = False
        if path:
            try:
                document = _load_json(path)
                item = document.get("minecraft:item", {})
                used = component in json.dumps(item.get("components", {}), sort_keys=True)
            except (OSError, json.JSONDecodeError):
                used = False
        registered = bool(
            re.search(
                rf'\b(?:registerCustomComponent|register)\(\s*["\']{re.escape(component)}["\']',
                component_code,
            )
        )
        if not path or not used or not registered:
            missing_components.append(item_id)
        component_usage[item_id] = {
            "item_file": path.relative_to(repo).as_posix() if path else None,
            "component": component,
            "used_by_item": used,
            "registered": registered,
        }
    return {
        "source_item_model_count": len(source_ids),
        "bedrock_direct_item_count": len(bp_items),
        "bedrock_block_form_count": len(bp_blocks),
        "resolved_source_item_models": len(source_ids) - len(unresolved),
        "unresolved_source_item_models": unresolved,
        "vanilla_item_adapters": ITEM_MODEL_ALIASES,
        "scripted_item_components": component_usage,
        "missing_scripted_item_components": missing_components,
        "special_item_behavior": {
            "hand_cannon": "100-block view ray, spectator exclusion, four-tick cooldown",
            "polaroid": "use feedback and persisted craft progression scan",
            "portal_linker": "sneak-gated two-anchor persistent link",
            "desyncer": "persisted effect/state adapter",
            "circuit_cave_painting": "selected-item consumption on placement",
        },
    }


def _item_behavior_contract(repo: Path) -> dict[str, Any]:
    """Compare source item properties that affect gameplay or presentation."""

    bp_items = _bp_identifiers(repo / f"{ADDON_NAME}/BP/items", "minecraft:item")
    missing: list[str] = []
    mismatches: list[str] = []

    def components(name: str) -> dict[str, Any] | None:
        path = bp_items.get(f"{NAMESPACE}:{name}")
        if path is None:
            missing.append(name)
            return None
        try:
            document = _load_json(path)
        except (OSError, json.JSONDecodeError) as error:
            mismatches.append(f"{name}: invalid item JSON: {error}")
            return None
        return document.get("minecraft:item", {}).get("components", {})

    def expect(name: str, key: str, expected: Any) -> None:
        item_components = components(name)
        if item_components is None:
            return
        actual = item_components.get(key)
        if actual != expected:
            mismatches.append(f"{name}: {key}={actual!r}, expected {expected!r}")

    def expect_not_in_creative(name: str) -> None:
        path = bp_items.get(f"{NAMESPACE}:{name}")
        if path is None:
            if name not in missing:
                missing.append(name)
            return
        try:
            description = _load_json(path).get("minecraft:item", {}).get("description", {})
        except (OSError, json.JSONDecodeError) as error:
            mismatches.append(f"{name}: invalid item JSON: {error}")
            return
        if "menu_category" in description:
            mismatches.append(f"{name}: source noTab item is exposed through menu_category")

    cod_use = {
        "start_using": "always",
        "use_duration": 1.6,
        "movement_modifier": 0.35,
    }
    for name in COD_ITEM_NAMES:
        expect(name, "minecraft:food", {"nutrition": 2, "saturation_modifier": 0.1})
        expect(name, "minecraft:use_animation", "eat")
        expect(name, "minecraft:use_modifiers", cod_use)

    fast_food = {
        "nutrition": 0,
        "saturation_modifier": 0,
        "can_always_eat": True,
    }
    fast_use = {
        "start_using": "always",
        "use_duration": 0.8,
        "movement_modifier": 0.35,
    }
    for name, nutrition in (("null_bread", -2), ("circuit_bread", -10)):
        expect(name, "minecraft:food", {**fast_food, "nutrition": nutrition})
        expect(name, "minecraft:use_animation", "eat")
        expect(name, "minecraft:use_modifiers", fast_use)

    for name, nutrition in (("null_cod", -3), ("revuxorfish", -100), ("faraway_salmon", -100000)):
        expect(name, "minecraft:food", {**fast_food, "nutrition": nutrition})
        expect(name, "minecraft:use_animation", "eat")
        expect(name, "minecraft:use_modifiers", cod_use)

    expect("glaggle", "minecraft:max_stack_size", 16)
    glaggle = components("glaggle")
    if glaggle is not None:
        for key in ("minecraft:food", "minecraft:use_animation", "minecraft:use_modifiers"):
            if key in glaggle:
                mismatches.append(f"glaggle: source is not edible; unexpected {key}")

    for name in ("n", "gore"):
        expect(name, "minecraft:max_stack_size", 64)
        expect(name, "minecraft:rarity", "common")
        expect(name, "minecraft:interact_button", True)

    for name in ("torn_paper", "book"):
        expect(name, "minecraft:max_stack_size", 1)
        expect(name, "minecraft:interact_button", True)
    expect("integrity_fireball", "minecraft:max_stack_size", 1)
    for name in ("piece_1", "piece_2", "piece_3", "piece_4", "piece_5", "polaroid", "torn_paper", "book", "integrity_fireball", "hand_cannon"):
        expect_not_in_creative(name)

    for name, contract in FIRE_RESISTANT_ITEM_CONTRACTS.items():
        expect(name, "minecraft:max_stack_size", 1)
        expect(name, "minecraft:rarity", contract["rarity"])
        expect(name, "minecraft:fire_resistant", {"value": True})

    sounds_path = repo / f"{ADDON_NAME}/RP/sounds.json"
    sounds_document = _load_json(sounds_path) if sounds_path.is_file() else {}
    event_routes = (
        sounds_document.get("individual_event_sounds", {}).get("events", {})
        if isinstance(sounds_document, dict)
        else {}
    )
    if not isinstance(event_routes, dict):
        event_routes = {}

    records: dict[str, Any] = {}
    for name, contract in RECORD_ITEM_CONTRACTS.items():
        expect(name, "minecraft:max_stack_size", 1)
        expect(name, "minecraft:rarity", contract["rarity"])
        # Java's extracted comparator output is 15. The ten P1 presentation
        # record adapters saturate that value at Bedrock's maximum of 13;
        # Lilly's existing script-only theme records retain their main-branch
        # default signal of 1.
        expected_record = {
            "comparator_signal": 1 if name in {"lilly", "lilly_v2"} else 13,
            "duration": contract["duration"],
            "sound_event": contract["bedrock_sound_event"],
        }
        expect(name, "minecraft:record", expected_record)
        route = event_routes.get(contract["bedrock_sound_event"])
        if not isinstance(route, dict) or route.get("sound") != contract["sound_event"]:
            mismatches.append(
                f"{name}: RP/sounds.json must route {contract['bedrock_sound_event']!r} "
                f"to {contract['sound_event']!r}"
            )
        records[name] = {
            **expected_record,
            "sound_definition": contract["sound_event"],
        }

    return {
        "missing_items": sorted(set(missing)),
        "mismatches": mismatches,
        "cod_items": list(COD_ITEM_NAMES),
        "native_food_adapter": {
            "cod": {"nutrition": 2, "saturation_modifier": 0.1, "use_duration": 1.6},
            "null_cod": {"nutrition": -3, "saturation_modifier": 0, "can_always_eat": True},
            "null_bread": {"nutrition": -2, "saturation_modifier": 0, "can_always_eat": True, "use_duration": 0.8},
            "circuit_bread": {"nutrition": -10, "saturation_modifier": 0, "can_always_eat": True, "use_duration": 0.8},
        },
        "negative_food_adapter": "Bedrock documents nutrition as an integer and the source negative values are carried directly; the value is also covered by the JSON/MCT validation gates.",
        "record_items": records,
        "not_in_creative": ["piece_1", "piece_2", "piece_3", "piece_4", "piece_5", "polaroid", "torn_paper", "book", "integrity_fireball", "hand_cannon"],
        "scripted_use_adapters": {
            "n": "onUse removes one selected item outside Creative",
            "gore": "onUse removes one selected item outside Creative",
            "torn_paper": "onUse opens a stable Bedrock form in place of the Java menu",
            "book": "non-stackable ItemStack dynamic property stores a stable 1..250 source book id; form UI is the Bedrock menu adapter",
            "revuxorfish": "onConsume applies Wither for 240 ticks at amplifier 4",
            "faraway_salmon": "onConsume applies Instant Damage for 2 ticks at amplifier 5 and Wither for 1000 ticks at amplifier 100",
        },
    }


def _ingredient_signature(value: Any) -> dict[str, Any]:
    if not isinstance(value, dict):
        return {"value": value}
    if isinstance(value.get("item"), str):
        return {"item": value["item"], "count": value.get("count", 1)}
    if isinstance(value.get("tag"), str):
        return {"tag": value["tag"], "count": value.get("count", 1)}
    return {"value": value}


def _recipe_signature(document: dict[str, Any], source: bool = False) -> dict[str, Any]:
    if source:
        kind = document.get("type")
        result = document.get("result", {})
        signature: dict[str, Any] = {
            "kind": kind,
            "result": {
                "item": result.get("id"),
                "count": result.get("count", 1),
            },
        }
        if kind == "minecraft:crafting_shaped":
            signature["pattern"] = document.get("pattern", [])
            signature["key"] = {
                key: _ingredient_signature(value)
                for key, value in sorted(document.get("key", {}).items())
            }
        elif kind == "minecraft:crafting_shapeless":
            signature["ingredients"] = sorted(
                (_ingredient_signature(value) for value in document.get("ingredients", [])),
                key=lambda value: json.dumps(value, sort_keys=True),
            )
        elif kind == "minecraft:stonecutting":
            signature["ingredient"] = _ingredient_signature(document.get("ingredient", {}))
        return signature

    recipe_type = next(
        (key for key in document if key.startswith("minecraft:recipe_")),
        None,
    )
    body = document.get(recipe_type, {}) if recipe_type else {}
    tags = body.get("tags", [])
    if recipe_type == "minecraft:recipe_shaped":
        kind = "minecraft:crafting_shaped"
    elif recipe_type == "minecraft:recipe_shapeless" and "stonecutter" in tags:
        kind = "minecraft:stonecutting"
    elif recipe_type == "minecraft:recipe_shapeless":
        kind = "minecraft:crafting_shapeless"
    else:
        kind = recipe_type
    result = body.get("result", {})
    signature = {
        "kind": kind,
        "result": {
            "item": result.get("item"),
            "count": result.get("count", 1),
        },
    }
    if kind == "minecraft:crafting_shaped":
        signature["pattern"] = body.get("pattern", [])
        signature["key"] = {
            key: _ingredient_signature(value)
            for key, value in sorted(body.get("key", {}).items())
        }
    elif kind == "minecraft:crafting_shapeless":
        signature["ingredients"] = sorted(
            (_ingredient_signature(value) for value in body.get("ingredients", [])),
            key=lambda value: json.dumps(value, sort_keys=True),
        )
    elif kind == "minecraft:stonecutting":
        ingredients = body.get("ingredients", [])
        signature["ingredient"] = _ingredient_signature(ingredients[0] if ingredients else {})
    return signature


def _recipe_contract(repo: Path) -> dict[str, Any]:
    source_root = repo / "source_extracted/data/thebrokenscript/recipe"
    bp_root = repo / f"{ADDON_NAME}/BP/recipes"
    source_paths = _sorted_json_files(source_root)
    bp_paths = _sorted_json_files(bp_root)
    source_names = {path.stem for path in source_paths}
    bp_names = {path.stem for path in bp_paths}
    missing = sorted(source_names - bp_names)
    extra = sorted(bp_names - source_names)
    mismatches: list[str] = []
    adapters: dict[str, str] = {}
    for name in sorted(source_names & bp_names):
        try:
            source_signature = _recipe_signature(_load_json(source_root / f"{name}.json"), source=True)
            bp_signature = _recipe_signature(_load_json(bp_root / f"{name}.json"))
        except (OSError, json.JSONDecodeError) as error:
            mismatches.append(f"{name}: invalid recipe JSON: {error}")
            continue
        if name == "polaroid" and source_signature != bp_signature:
            frame_item = repo / f"{ADDON_NAME}/BP/items/polaroid_frame.json"
            script_root = repo / f"{ADDON_NAME}/BP/scripts/systems"
            try:
                frame = _load_json(frame_item)["minecraft:item"]
                components = frame["components"]
                runtime = _read(script_root / "ported_features.js")
                assembly = _read(script_root / "polaroid_craft.js")
                valid = (
                    source_signature["kind"] == bp_signature["kind"]
                    and source_signature["ingredients"] == bp_signature["ingredients"]
                    and source_signature["result"] == {"item": "thebrokenscript:polaroid", "count": 1}
                    and bp_signature["result"] == {"item": "thebrokenscript:polaroid_frame", "count": 1}
                    and frame["description"]["identifier"] == "thebrokenscript:polaroid_frame"
                    and "thebrokenscript:finish_polaroid" in components
                    and 'register("thebrokenscript:finish_polaroid"' in runtime
                    and 'finishPolaroid(event.source' in runtime
                    and 'makeItem("thebrokenscript:polaroid")' in assembly
                    and 'award(player, "polaroid_craft")' in assembly
                )
            except (OSError, KeyError, json.JSONDecodeError):
                valid = False
            if valid:
                adapters[name] = "five-piece recipe yields a one-use frame; use produces the Polaroid and awards progression"
                continue
        if source_signature != bp_signature:
            mismatches.append(
                f"{name}: source={json.dumps(source_signature, sort_keys=True)} "
                f"bedrock={json.dumps(bp_signature, sort_keys=True)}"
            )
    stonecutters = sorted(
        path.stem
        for path in source_paths
        if _load_json(path).get("type") == "minecraft:stonecutting"
    )
    return {
        "source_names": sorted(source_names),
        "bedrock_names": sorted(bp_names),
        "source_count": len(source_paths),
        "bedrock_count": len(bp_paths),
        "missing": missing,
        "extra": extra,
        "recipe_mismatches": mismatches,
        "recipe_adapters": adapters,
        "stonecutter_recipes": stonecutters,
        "category_adapter": "Java crafting categories map to Bedrock crafting_table; stonecutting maps to a shapeless recipe tagged stonecutter",
    }


def _source_loot_tables(repo: Path) -> dict[tuple[str, str], Path]:
    result: dict[tuple[str, str], Path] = {}
    root = repo / "source_extracted/data/thebrokenscript/loot_table"
    for kind in ("blocks", "entities"):
        for path in _sorted_json_files(root / kind):
            result[(kind, path.stem)] = path
    return result


def _bedrock_loot_tables(repo: Path) -> dict[tuple[str, str], Path]:
    result: dict[tuple[str, str], Path] = {}
    root = repo / f"{ADDON_NAME}/BP/loot_tables"
    for kind in ("blocks", "entities"):
        for path in _sorted_json_files(root / kind):
            result[(kind, path.stem)] = path
    return result


def _condition_name(condition: Any) -> str | None:
    if not isinstance(condition, dict):
        return None
    value = condition.get("condition")
    return value.split(":", 1)[-1] if isinstance(value, str) else None


def _source_loot_contract(document: dict[str, Any]) -> dict[str, Any]:
    pools = document.get("pools", [])
    if not isinstance(pools, list):
        pools = []
    entries: list[dict[str, Any]] = []
    pool_conditions: list[str] = []
    entry_conditions: list[str] = []
    functions: list[str] = []
    for pool in pools:
        if not isinstance(pool, dict):
            continue
        pool_conditions.extend(
            condition
            for condition in (_condition_name(value) for value in pool.get("conditions", []))
            if condition
        )
        for entry in pool.get("entries", []):
            if not isinstance(entry, dict):
                continue
            entry_conditions.extend(
                condition
                for condition in (_condition_name(value) for value in entry.get("conditions", []))
                if condition
            )
            functions.extend(
                function.get("function", "").split(":", 1)[-1]
                for function in entry.get("functions", [])
                if isinstance(function, dict) and isinstance(function.get("function"), str)
            )
            entries.append({
                "name": entry.get("name"),
                "count": 1,
                "weight": entry.get("weight", 1),
            })
    return {
        "empty": not entries,
        "entries": entries,
        "pool_conditions": sorted(set(pool_conditions)),
        "entry_conditions": sorted(set(entry_conditions)),
        "functions": sorted(set(functions)),
    }


def _bedrock_loot_contract(document: dict[str, Any]) -> dict[str, Any]:
    pools = document.get("pools", [])
    if not isinstance(pools, list):
        pools = []
    entries: list[dict[str, Any]] = []
    conditions: list[str] = []
    match_tool_items: list[str] = []
    for pool in pools:
        if not isinstance(pool, dict):
            continue
        for condition in pool.get("conditions", []):
            name = _condition_name(condition)
            if name:
                conditions.append(name)
            if isinstance(condition, dict) and isinstance(condition.get("item"), str):
                match_tool_items.append(condition["item"])
        for entry in pool.get("entries", []):
            if not isinstance(entry, dict):
                continue
            entries.append({
                "name": entry.get("name"),
                "count": entry.get("count", 1),
                "weight": entry.get("weight", 1),
            })
    return {
        "empty": not entries,
        "entries": entries,
        "pool_conditions": sorted(set(conditions)),
        "match_tool_items": sorted(set(match_tool_items)),
    }


def _loot_contract(repo: Path) -> dict[str, Any]:
    source = _source_loot_tables(repo)
    bedrock = _bedrock_loot_tables(repo)
    missing = [
        f"{kind}:{NAMESPACE}/{kind}/{name}"
        for kind, name in sorted(set(source) - set(bedrock))
    ]
    mismatches: list[str] = []
    adapter_tables: dict[str, str] = {}
    source_conditions: dict[str, int] = {}
    for (kind, name), source_path in sorted(source.items()):
        if (kind, name) not in bedrock:
            continue
        try:
            source_contract = _source_loot_contract(_load_json(source_path))
            bedrock_contract = _bedrock_loot_contract(_load_json(bedrock[(kind, name)]))
        except (OSError, json.JSONDecodeError) as error:
            mismatches.append(f"{kind}:{name}: invalid loot JSON: {error}")
            continue
        source_conditions[name] = len(
            set(source_contract["pool_conditions"]) | set(source_contract["entry_conditions"])
        )
        if name in LOOT_OUTPUT_ADAPTERS:
            source_name, bedrock_name = LOOT_OUTPUT_ADAPTERS[name]
            adapter_tables[name] = f"{source_name} -> {bedrock_name}"
        elif name in STATEFUL_LOOT_TABLES:
            adapter_tables[name] = "block_state_property / set_count is represented by the documented single-block Bedrock geometry adapter"
        if name in FLORA_LOOT_TABLES:
            adapter_tables[name] = "Java tag match_tool is represented by a direct minecraft:shears match_tool condition"

        if source_contract["empty"] != bedrock_contract["empty"]:
            mismatches.append(f"{kind}:{name}: empty/non-empty pool mismatch")
            continue
        if source_contract["empty"]:
            continue
        source_names = [entry["name"] for entry in source_contract["entries"]]
        expected_names = source_names[:]
        if name in LOOT_OUTPUT_ADAPTERS:
            source_name, bedrock_name = LOOT_OUTPUT_ADAPTERS[name]
            expected_names = [
                bedrock_name if entry_name == source_name else entry_name
                for entry_name in source_names
            ]
        bedrock_names = [entry["name"] for entry in bedrock_contract["entries"]]
        if expected_names != bedrock_names:
            mismatches.append(f"{kind}:{name}: output mismatch {expected_names!r} != {bedrock_names!r}")
        expected_entries = [dict(entry, name=expected_name) for entry, expected_name in zip(source_contract["entries"], expected_names)]
        if name not in STATEFUL_LOOT_TABLES and expected_entries != bedrock_contract["entries"]:
            mismatches.append(
                f"{kind}:{name}: entry count/weight mismatch "
                f"{expected_entries!r} != {bedrock_contract['entries']!r}"
            )
        if "survives_explosion" in source_contract["pool_conditions"] and "survives_explosion" not in bedrock_contract["pool_conditions"]:
            mismatches.append(f"{kind}:{name}: missing survives_explosion condition")
        if "match_tool" in source_contract["pool_conditions"]:
            if "minecraft:shears" not in bedrock_contract["match_tool_items"]:
                mismatches.append(f"{kind}:{name}: missing direct shears match_tool adapter")
        unsupported = set(source_contract["entry_conditions"]) - {"block_state_property"}
        if unsupported:
            mismatches.append(f"{kind}:{name}: unsupported source conditions {sorted(unsupported)!r}")

    return {
        "source_count": len(source),
        "bedrock_count": len(bedrock),
        "source_block_count": sum(kind == "blocks" for kind, _ in source),
        "source_entity_count": sum(kind == "entities" for kind, _ in source),
        "missing_source_loot_tables": missing,
        "loot_mismatches": mismatches,
        "adapter_tables": adapter_tables,
        "source_condition_table_count": len(source_conditions),
        "empty_source_tables": sorted(
            f"{kind}:{name}" for (kind, name), path in source.items()
            if _source_loot_contract(_load_json(path))["empty"]
        ),
    }


def _tag_contract(repo: Path) -> dict[str, Any]:
    source_root = repo / "source_extracted/data/thebrokenscript/tags"
    block_root = source_root / "block"
    item_root = source_root / "item"
    bp_root = repo / f"{ADDON_NAME}/BP/blocks"
    block_tags: dict[str, list[str]] = {}
    for path in _sorted_json_files(bp_root):
        try:
            document = _load_json(path).get("minecraft:block", {})
        except (OSError, json.JSONDecodeError):
            continue
        identifier = document.get("description", {}).get("identifier")
        tags = document.get("components", {}).get("minecraft:tags", [])
        if isinstance(identifier, str) and isinstance(tags, list):
            block_tags[identifier] = [tag for tag in tags if isinstance(tag, str)]

    missing_block_members: list[str] = []
    custom_block_membership_count = 0
    for path in _sorted_json_files(block_root):
        tag_id = f"{NAMESPACE}:{path.stem}"
        values = _load_json(path).get("values", [])
        for value in values if isinstance(values, list) else []:
            if not isinstance(value, str) or not value.startswith(f"{NAMESPACE}:"):
                continue
            custom_block_membership_count += 1
            if tag_id not in block_tags.get(value, []):
                missing_block_members.append(f"{tag_id}:{value}")

    item_tags: dict[str, list[str]] = {}
    for path in _sorted_json_files(item_root):
        values = _load_json(path).get("values", [])
        item_tags[f"{NAMESPACE}:{path.stem}"] = values if isinstance(values, list) else []
    tag_adapters = sorted(item_tags)
    flora_reference = "thebrokenscript:can_be_used_for_void_flora"
    flora_adapter_ok = all(
        "minecraft:shears" in _bedrock_loot_contract(
            _load_json(repo / f"{ADDON_NAME}/BP/loot_tables/blocks/{name}.json")
        )["match_tool_items"]
        for name in FLORA_LOOT_TABLES
    )
    return {
        "source_block_tag_count": len(_sorted_json_files(block_root)),
        "source_custom_block_membership_count": custom_block_membership_count,
        "missing_block_tag_members": sorted(missing_block_members),
        "source_item_tags": item_tags,
        "tag_adapters": tag_adapters,
        "flora_item_tag_adapter": {
            "source_tag": flora_reference,
            "source_members": item_tags.get(flora_reference, []),
            "bedrock_predicate": "minecraft:shears",
            "validated": flora_adapter_ok,
        },
        "entity_tag_adapter": "runtime entity-family/query predicates are documented; Bedrock has no portable Java tag directory equivalent",
        "worldgen_biome_tag_adapter": "source optional biome tag is retained as source evidence; Bedrock placement uses explicit registered biome IDs",
    }


def _advancement_contract(repo: Path) -> dict[str, Any]:
    source_lang = _load_json(repo / "source_extracted/assets/thebrokenscript/lang/en_us.json")
    advancement_root = repo / "source_extracted/data/thebrokenscript/advancement"
    source_ids = sorted(path.stem for path in _sorted_json_files(advancement_root))
    source_criteria = {
        identifier: _load_json(advancement_root / f"{identifier}.json").get("criteria", {})
        for identifier in source_ids
    }
    source_titles = {
        identifier: source_lang.get(f"advancement.{NAMESPACE}.{identifier}.title")
        for identifier in source_ids
    }
    source_descriptions = {
        identifier: source_lang.get(f"advancement.{NAMESPACE}.{identifier}.desc")
        for identifier in source_ids
    }
    progression = _strip_js_comments(
        _read(repo / f"{ADDON_NAME}/BP/scripts/systems/progression.js")
    )
    titles: dict[str, str | None] = {}
    descriptions: dict[str, str | None] = {}
    for identifier in source_ids:
        title_match = re.search(
            rf"\b{re.escape(identifier)}\s*:\s*([\"'])(.*?)\1",
            progression,
        )
        description_match = re.search(
            rf"\b{re.escape(identifier)}\s*:\s*([\"'])(.*?)\1",
            progression[progression.find("ADVANCEMENT_DESCRIPTIONS"):],
        ) if "ADVANCEMENT_DESCRIPTIONS" in progression else None
        titles[identifier] = title_match.group(2) if title_match else None
        descriptions[identifier] = description_match.group(2) if description_match else None
    trigger_sources = {
        "can_someone_hear_me": ["systems/horror_events.js"],
        "can_you_see_me": ["entities/humanoid/humanoid_spawn_rules.js"],
        "nullnullnull": ["systems/horror_events.js"],
        "you_ve_brought_it_upon_yourself": [
            "entities/tbe/tbe_controller.js",
            "systems/progression.js",
        ],
        "polaroid_craft": ["systems/polaroid_craft.js"],
    }
    trigger_adapters: dict[str, Any] = {}
    for identifier, relative_paths in trigger_sources.items():
        source_text = _strip_js_comments("\n".join(
            _read(repo / f"{ADDON_NAME}/BP/scripts" / relative_path)
            for relative_path in relative_paths
        ))
        trigger_adapters[identifier] = {
            "source_files": relative_paths,
            "hook_present": bool(
                re.search(
                    rf'\b(?:progression\.)?award\(\s*[^,\n]+,\s*["\']{re.escape(identifier)}["\']\s*\)',
                    source_text,
                )
            ),
            "source_criteria": source_criteria.get(identifier, {}),
        }
    return {
        "source_ids": source_ids,
        "source_count": len(source_ids),
        "source_criteria": source_criteria,
        "source_titles": source_titles,
        "source_descriptions": source_descriptions,
        "advancement_titles": titles,
        "advancement_descriptions": descriptions,
        "advancement_trigger_adapters": trigger_adapters,
        "idempotence": "per-player dynamic property plus in-memory duplicate suppression",
        "trigger_adapter": "recipe_crafted uses a five-piece crafting-table frame and a one-use finishing action on the pinned ABI",
    }


def _command_contract(repo: Path) -> dict[str, Any]:
    command_root = repo / "decompiled/net/thebrokenscript/command"
    root_source = _read(command_root / "TBSCommands.java")
    root_command_sources = "\n".join(
        _read(path)
        for path in (
            command_root / "DevModeCommand.java",
            command_root / "ReputationCommand.java",
        )
    )
    dev_sources = "\n".join(_read(path) for path in sorted((command_root / "dev").glob("*.java")))
    groups = sorted(set(re.findall(r'group\("([^"]+)"', dev_sources)))
    root_commands = sorted(set(re.findall(r'\.add\("([^"]+)"', root_command_sources)))
    dev_commands_by_file = {
        path.relative_to(repo).as_posix(): sorted(
            set(re.findall(r'\.add\("([^"]+)"', _read(path)))
        )
        for path in sorted((command_root / "dev").glob("*.java"))
    }
    runtime = _strip_js_comments(
        _read(repo / f"{ADDON_NAME}/BP/scripts/systems/commands.js")
    )
    registration_matches = list(
        re.finditer(r"customCommandRegistry\.registerCommand\s*\(", runtime)
    )
    runtime_specs: dict[str, dict[str, Any]] = {}
    for index, match in enumerate(registration_matches):
        end = registration_matches[index + 1].start() if index + 1 < len(registration_matches) else len(runtime)
        block = runtime[match.start():end]
        object_match = re.search(
            r"registerCommand\(\s*\{(?P<object>.*?)\n\s*\},\s*\(",
            block,
            flags=re.DOTALL,
        )
        if not object_match:
            continue
        object_source = object_match.group("object")
        name_match = re.search(r'\bname\s*:\s*["\']([^"\']+)["\']', object_source)
        if not name_match:
            continue
        name = name_match.group(1)
        runtime_specs[name] = {
            "name": name,
            "registered": True,
            "permission_level": "Admin"
            if re.search(r"\bpermissionLevel\s*:\s*CommandPermissionLevel\.Admin", object_source)
            else None,
            "cheats_required": False
            if re.search(r"\bcheatsRequired\s*:\s*false", object_source)
            else None,
            "mandatory_code_string": bool(
                re.search(
                    r"mandatoryParameters\s*:\s*\[\s*\{\s*name\s*:\s*[\"']code[\"']\s*,\s*type\s*:\s*CustomCommandParamType\.String",
                    object_source,
                    flags=re.DOTALL,
                )
            ),
            "player_only": bool(
                re.search(
                    r"const\s+player\s*=\s*origin\.sourceEntity[\s\S]*?"
                    r"player\.typeId\s*!==\s*[\"']minecraft:player[\"'][\s\S]*?"
                    r"This command must be executed by a player!",
                    block,
                )
            ),
        }
    production = [
        runtime_specs.get(name, {"name": name, "registered": False})
        for name in ("tbs:devmode", "tbs:reputation")
    ]
    devmode_source = runtime_specs.get("tbs:devmode", {})
    return {
        "java_root_permission_level": 4 if 'group("tbs", Integer.valueOf(4)' in root_source else None,
        "java_root_commands": root_commands,
        "java_root_groups": groups,
        "java_dev_commands_by_file": dev_commands_by_file,
        "java_command_source_files": sorted(
            path.relative_to(repo).as_posix()
            for path in command_root.rglob("*.java")
        ),
        "production_commands": production,
        "runtime_command_names": sorted(runtime_specs),
        "devmode_codes": sorted(re.findall(r'"(2018|544253)"\s*:\s*"thebrokenscript:', runtime)),
        "devmode_spawn_count": int(
            re.search(r"DEV_MODE_SPAWN_COUNT\s*=\s*(\d+)", runtime).group(1)
        )
        if re.search(r"DEV_MODE_SPAWN_COUNT\s*=\s*(\d+)", runtime)
        else None,
        "devmode_effects": sorted(
            set(re.findall(r'"(?:2018|544253)"\s*:\s*"(thebrokenscript:[^"]+)"', runtime))
        ),
        "devmode_mandatory_code_string": bool(devmode_source.get("mandatory_code_string")),
        "devmode_invalid_message": "Dev mode code is invalid!" in runtime,
        "developer_surface": "Bedrock /scriptevent tbs:* hooks",
        "developer_surface_separate": bool(
            re.search(r"scriptEventReceive\.subscribe", runtime)
            and re.search(r"function\s+handleCommand\s*\(", runtime)
        ),
        "debug_gate": "operator permission is supplied by the custom-command Admin gate; broader regression hooks remain on /scriptevent",
    }


def _load_structure_inventory(repo: Path) -> dict[str, Any]:
    tool_path = repo / "tools/inventory_structure_corpus.py"
    spec = importlib.util.spec_from_file_location("_tbs_inventory_structure_corpus", tool_path)
    if spec is None or spec.loader is None:
        raise RuntimeError(f"cannot load structure inventory tool: {tool_path}")
    module = importlib.util.module_from_spec(spec)
    sys.modules[spec.name] = module
    spec.loader.exec_module(module)
    return module.build_inventory(
        repo / "source_extracted/data/thebrokenscript/structure",
        repo / f"{ADDON_NAME}/BP/structures/thebrokenscript",
    )


def _dimension_contract(repo: Path) -> dict[str, Any]:
    source_type_root = repo / "source_extracted/data/thebrokenscript/dimension_type"
    source_dimension_root = repo / "source_extracted/data/thebrokenscript/dimension"
    policy_path = repo / f"{ADDON_NAME}/docs/P1_DIMENSION_POLICY.json"
    policy = _load_json(policy_path)
    policies = policy.get("dimensions", {}) if isinstance(policy, dict) else {}
    dimension_ids = sorted(path.stem for path in _sorted_json_files(source_dimension_root))
    dimension_types = sorted(path.stem for path in _sorted_json_files(source_type_root))
    ids_source = _strip_js_comments(
        _read(repo / f"{ADDON_NAME}/BP/scripts/systems/dimension_ids.js")
    )
    runtime = _strip_js_comments(
        _read(repo / f"{ADDON_NAME}/BP/scripts/systems/dimensions.js")
    )
    main = _strip_js_comments(_read(repo / f"{ADDON_NAME}/BP/scripts/main.js"))
    missing_policy = sorted(set(dimension_ids) - set(policies))
    missing_registration = sorted(
        name for name in dimension_ids
        if f'"{name}"' not in ids_source
    )
    return {
        "source_dimension_count": len(dimension_ids),
        "source_dimension_ids": dimension_ids,
        "source_dimension_type_count": len(dimension_types),
        "policy_count": len(policies),
        "policy_ids": sorted(policies),
        "missing_policy_ids": missing_policy,
        "missing_registration_ids": missing_registration,
        "registration_contract": {
            "startup_only": bool(
                re.search(
                    r"system\.beforeEvents\.startup\.subscribe\(\s*onStartup\s*\)",
                    main,
                )
            ),
            "register_custom_dimension": bool(
                re.search(r"dimensionRegistry\.registerCustomDimension\s*\(\s*id\s*\)", runtime)
            ),
            "readiness_gated_teleport": bool(
                re.search(r"export\s+async\s+function\s+teleportWhenReady\s*\(", runtime)
                and re.search(r"\bensureDimensionReady\s*\(", runtime)
            ),
            "void_generator_boundary": str(
                (policy.get("bedrock_adapter", {}) if isinstance(policy, dict) else {}).get(
                    "terrain", ""
                )
            ).startswith("minecraft:custom_dimension void generator"),
        },
        "policies": policies,
        "environment_adapter": policy.get("bedrock_adapter", {}) if isinstance(policy, dict) else {},
    }


def _portal_contract(repo: Path) -> dict[str, Any]:
    linker_source = _read(repo / "decompiled/net/thebrokenscript/item/LinkerItem.java")
    controller_source = _read(repo / "decompiled/net/thebrokenscript/block/portal/PortalControllerBlock.java")
    runtime = _strip_js_comments(
        _read(repo / f"{ADDON_NAME}/BP/scripts/systems/ported_features.js")
    )
    logic = _strip_js_comments(
        _read(repo / f"{ADDON_NAME}/BP/scripts/systems/ported_feature_logic.js")
    )
    custom_blocks = _strip_js_comments(
        _read(repo / f"{ADDON_NAME}/BP/scripts/systems/custom_blocks.js")
    )
    cooldown_match = re.search(r"PORTAL_COOLDOWN_TICKS\s*=\s*(\d+)", runtime)
    cooldown = int(cooldown_match.group(1)) if cooldown_match else None
    sweep = _strip_js_comments(_read(repo / f"{ADDON_NAME}/BP/scripts/systems/portal_auto_travel.js"))
    living_sweep = "getEntities({" in sweep and 'getComponent("minecraft:health")' in sweep and "portalSweep.step" in runtime
    return {
        "source_activation_requires_sneak": "isShiftKeyDown" in linker_source,
        "source_item_consumed": bool(re.search(r"\.(shrink|consume)\s*\(", linker_source)),
        "source_controller_tracks_incoming_entities": "incoming" in controller_source and "LivingEntity" in controller_source,
        "runtime_activation_requires_sneak": bool(
            re.search(r"\bplayer\.isSneaking\s*!==\s*true", runtime)
        ),
        "runtime_persistent_anchor": bool(
            re.search(r"player\.setDynamicProperty\(\s*PORTAL_ANCHOR_PROPERTY", runtime)
        ),
        "runtime_persistent_links": bool(
            re.search(r"world\.setDynamicProperty\(\s*PORTAL_LINKS_PROPERTY", runtime)
        ),
        "runtime_link_logic": bool(
            re.search(r"\blinkPortals\s*\(", logic)
            and re.search(r"\blinkedPortal\s*\(", logic)
        ),
        "safe_arrival": bool(
            re.search(r"\bteleportWhenReady\s*\(", runtime)
            and re.search(
                r"\bensureDimensionReady\s*\(",
                _strip_js_comments(
                    _read(repo / f"{ADDON_NAME}/BP/scripts/systems/dimension_generation.js")
                ),
            )
        ),
        "cooldown_ticks": cooldown,
        "cooldown_property": bool(
            re.search(r"player\.(?:get|set)DynamicProperty\(\s*PORTAL_COOLDOWN_PROPERTY", runtime)
        ),
        "fallback_destination": "clan_void"
        if re.search(r'\bteleportWhenReady\([^\n]*["\']clan_void["\']', custom_blocks)
        else None,
        "runtime_living_sweep": living_sweep,
        "entity_scope": "same-dimension linked player and living-entity tick sweep; items and projectiles excluded" if living_sweep else "player click only",
    }


def _content_contract(repo: Path, component_source: str) -> dict[str, Any]:
    source_blocks = _source_block_ids(repo)
    bp_blocks = _bp_identifiers(repo / f"{ADDON_NAME}/BP/blocks", "minecraft:block")
    block_entity = _block_entity_contract(repo, component_source)
    item = _item_contract(repo, component_source)
    item_behavior = _item_behavior_contract(repo)
    recipes = _recipe_contract(repo)
    loot = _loot_contract(repo)
    tags = _tag_contract(repo)
    advancement = _advancement_contract(repo)
    commands = _command_contract(repo)
    return {
        "source_block_count": len(source_blocks),
        "bedrock_block_count": len(bp_blocks),
        "missing_source_blocks": sorted(set(source_blocks) - set(bp_blocks)),
        "extra_bedrock_blocks": sorted(set(bp_blocks) - set(source_blocks)),
        "source_block_entity_count": block_entity["source_count"],
        "block_entities": block_entity,
        "source_item_model_count": item["source_item_model_count"],
        "bedrock_direct_item_count": item["bedrock_direct_item_count"],
        "bedrock_block_form_count": item["bedrock_block_form_count"],
        "unresolved_source_item_models": item["unresolved_source_item_models"],
        "vanilla_item_adapters": item["vanilla_item_adapters"],
        "scripted_item_components": item["scripted_item_components"],
        "missing_scripted_item_components": item["missing_scripted_item_components"],
        "special_item_behavior": item["special_item_behavior"],
        "item_behavior": item_behavior,
        "source_recipe_count": recipes["source_count"],
        "bedrock_recipe_count": recipes["bedrock_count"],
        "missing_recipes": recipes["missing"],
        "extra_recipes": recipes["extra"],
        "recipe_mismatches": recipes["recipe_mismatches"],
        "recipe_adapters": recipes["recipe_adapters"],
        "stonecutter_recipes": recipes["stonecutter_recipes"],
        "recipe_category_adapter": recipes["category_adapter"],
        "source_loot_table_count": loot["source_count"],
        "bedrock_loot_table_count": loot["bedrock_count"],
        "source_block_loot_count": loot["source_block_count"],
        "source_entity_loot_count": loot["source_entity_count"],
        "missing_source_loot_tables": loot["missing_source_loot_tables"],
        "loot_mismatches": loot["loot_mismatches"],
        "loot_adapter_tables": loot["adapter_tables"],
        "empty_source_loot_tables": loot["empty_source_tables"],
        "source_condition_table_count": loot["source_condition_table_count"],
        "source_block_tag_count": tags["source_block_tag_count"],
        "source_custom_block_membership_count": tags["source_custom_block_membership_count"],
        "missing_block_tag_members": tags["missing_block_tag_members"],
        "source_item_tags": tags["source_item_tags"],
        "tag_adapters": tags["tag_adapters"],
        "flora_item_tag_adapter": tags["flora_item_tag_adapter"],
        "entity_tag_adapter": tags["entity_tag_adapter"],
        "worldgen_biome_tag_adapter": tags["worldgen_biome_tag_adapter"],
        "advancement_ids": advancement["source_ids"],
        "advancement_titles": advancement["advancement_titles"],
        "advancement_descriptions": advancement["advancement_descriptions"],
        "source_advancement_titles": advancement["source_titles"],
        "source_advancement_descriptions": advancement["source_descriptions"],
        "advancement_source_criteria": advancement["source_criteria"],
        "advancement_trigger_adapters": advancement["advancement_trigger_adapters"],
        "advancement_idempotence": advancement["idempotence"],
        "advancement_trigger_adapter": advancement["trigger_adapter"],
        "commands": commands,
    }


def _structure_contract(repo: Path) -> dict[str, Any]:
    inventory = _load_structure_inventory(repo)
    entries = inventory.get("entries", [])
    incomplete = sorted(
        entry.get("source_relative_path", "<unknown>")
        for entry in entries
        if not all(
            isinstance(entry.get(field), str) and entry.get(field)
            for field in ("staging_status", "conversion_status", "bedrock_destination")
        )
    )
    return {
        "source_template_count": inventory.get("template_count", 0),
        "parsed_count": inventory.get("parsed_count", 0),
        "parse_error_count": inventory.get("parse_error_count", 0),
        "source_identical_staged_count": inventory.get("source_identical_staged_count", 0),
        "explicit_status_count": len(entries) - len(incomplete),
        "incomplete_inventory_entries": incomplete,
        "staged_jigsaw_files": sorted(
            path.relative_to(repo).as_posix()
            for path in (repo / f"{ADDON_NAME}/BP/structures/thebrokenscript").rglob("*.nbt")
        ),
        "worldgen_files": sorted(
            path.relative_to(repo).as_posix()
            for path in (repo / f"{ADDON_NAME}/BP/worldgen").rglob("*.json")
        ),
        "runtime_sample_validation": "not_available in static CI; source inventory and graph validators are authoritative here",
    }


def validate_report(report: dict[str, Any]) -> list[str]:
    """Return release-gate errors for a report, including mutated test reports."""

    errors: list[str] = []
    content = report.get("content", {})
    dimensions = report.get("dimensions", {})
    structures = report.get("structures", {})
    portals = report.get("portals", {})

    if report.get("todo_items") != TODO_ITEMS:
        errors.append("report does not cover the exact selected Todo headings")
    for field in ("missing_source_blocks", "unresolved_source_item_models", "missing_recipes", "recipe_mismatches", "missing_source_loot_tables", "loot_mismatches", "missing_block_tag_members", "missing_scripted_item_components"):
        values = content.get(field, [])
        if values:
            label = "missing source loot" if field == "missing_source_loot_tables" else field.replace("_", " ")
            errors.append(f"{label}: {values}")
    block_entities = content.get("block_entities", {})
    for field in ("missing_source", "missing_runtime"):
        if block_entities.get(field):
            errors.append(f"block entity {field.replace('_', ' ')}: {block_entities[field]}")
    if content.get("source_block_entity_count") != len(SOURCE_BLOCK_ENTITY_NAMES):
        errors.append("source block entity roster count does not equal the eight extracted registrations")
    if content.get("source_recipe_count") != 40:
        errors.append(f"expected 40 source recipes, found {content.get('source_recipe_count')}")
    if content.get("source_loot_table_count") != 138:
        errors.append(f"expected 138 source loot tables, found {content.get('source_loot_table_count')}")
    loot_adapters = content.get("loot_adapter_tables", {})
    for table_name, (source_name, bedrock_name) in LOOT_OUTPUT_ADAPTERS.items():
        if loot_adapters.get(table_name) != f"{source_name} -> {bedrock_name}":
            errors.append(f"loot output adapter missing for {table_name}")
    if content.get("advancement_titles") != content.get("source_advancement_titles"):
        errors.append("progression advancement titles drift from source language")
    if content.get("advancement_descriptions") != content.get("source_advancement_descriptions"):
        errors.append("progression advancement descriptions drift from source language")
    trigger_adapters = content.get("advancement_trigger_adapters", {})
    expected_trigger_ids = set(content.get("advancement_ids", []))
    if (
        set(trigger_adapters) != expected_trigger_ids
        or any(
            not isinstance(adapter, dict) or not adapter.get("hook_present")
            for adapter in trigger_adapters.values()
        )
    ):
        errors.append("one or more source advancement trigger adapters are not wired")
    item_behavior = content.get("item_behavior", {})
    if item_behavior.get("missing_items") or item_behavior.get("mismatches"):
        errors.append(
            "item behavior contract: "
            f"missing={item_behavior.get('missing_items', [])}, "
            f"mismatches={item_behavior.get('mismatches', [])}"
        )

    if dimensions.get("missing_policy_ids") or dimensions.get("missing_registration_ids"):
        errors.append("dimension policy or registration inventory is incomplete")
    if dimensions.get("policy_count") != len(SOURCE_DIMENSION_NAMES):
        errors.append("dimension policy count does not cover all 13 source dimensions")
    registration = dimensions.get("registration_contract", {})
    for field in ("startup_only", "register_custom_dimension", "readiness_gated_teleport", "void_generator_boundary"):
        if not registration.get(field):
            errors.append(f"dimension registration contract missing {field}")

    if structures.get("source_template_count") != 314:
        errors.append(f"expected 314 source structure templates, found {structures.get('source_template_count')}")
    if structures.get("explicit_status_count") != structures.get("source_template_count"):
        errors.append("structure corpus inventory has entries without explicit conversion status")

    if not portals.get("source_activation_requires_sneak") or not portals.get("runtime_activation_requires_sneak"):
        errors.append("portal linker must preserve the source sneak/shift activation gate")
    if portals.get("source_item_consumed"):
        errors.append("portal linker source unexpectedly consumes its linking item")
    if portals.get("cooldown_ticks") != 1 or not portals.get("cooldown_property"):
        errors.append("portal arrival must have the one-tick persisted bounce guard")
    if not portals.get("safe_arrival"):
        errors.append("portal arrival is not readiness/safe-landing gated")

    commands = content.get("commands", {})
    if commands.get("java_root_permission_level") != 4:
        errors.append("Java tbs command root permission evidence is missing")
    if not {"devmode [code]", "reputation"}.issubset(set(commands.get("java_root_commands", []))):
        errors.append("Java direct tbs command inventory is incomplete")
    production = {
        command.get("name"): command
        for command in commands.get("production_commands", [])
        if isinstance(command, dict)
    }
    for name in ("tbs:devmode", "tbs:reputation"):
        command = production.get(name)
        if (
            not command
            or not command.get("registered")
            or command.get("permission_level") != "Admin"
            or command.get("cheats_required") is not False
            or not command.get("player_only")
        ):
            errors.append(f"production {name} command does not preserve its operator/player contract")
    if not commands.get("devmode_mandatory_code_string"):
        errors.append("production tbs:devmode command is missing its mandatory string code argument")
    if commands.get("devmode_codes") != ["2018", "544253"]:
        errors.append("production tbs:devmode command codes drift from Java")
    if commands.get("devmode_spawn_count") != 1000:
        errors.append("production tbs:devmode spawn count drifts from Java")
    if commands.get("devmode_effects") != [
        "thebrokenscript:circuit",
        "thebrokenscript:the_broken_end",
    ]:
        errors.append("production tbs:devmode entity effects drift from Java")
    if not commands.get("devmode_invalid_message"):
        errors.append("production tbs:devmode invalid-code feedback is missing")
    if not commands.get("developer_surface_separate"):
        errors.append("developer commands are not separated from production behavior")

    return errors


def build_report(repo: Path = ROOT) -> dict[str, Any]:
    repo = repo.resolve()
    component_source = _read(repo / f"{ADDON_NAME}/BP/scripts/systems/custom_blocks.js")
    component_source += _read(repo / f"{ADDON_NAME}/BP/scripts/systems/ported_features.js")
    content = _content_contract(repo, component_source)
    dimensions = _dimension_contract(repo)
    structures = _structure_contract(repo)
    portals = _portal_contract(repo)
    report: dict[str, Any] = {
        "schema_version": VALIDATOR_VERSION,
        "todo_items": TODO_ITEMS,
        "content": content,
        "dimensions": dimensions,
        "structures": structures,
        "portals": portals,
        "warnings": [
            "Bedrock custom dimensions currently expose a void generator; exact Java noise_settings terrain generation is not claimed.",
            "Five Stage 2 templates and nine central XCSF tiles are converted; remaining room variants and outer XCSF terrain remain outside this fallback.",
            "Java block-entity storage/rendering and entity/item tags use explicit script/dynamic-property/query adapters where Bedrock lacks a portable equivalent.",
            "Linked portal controllers now move players and living entities within one dimension; item and projectile transfer remains outside the Java living-entity rule.",
            "Static CI cannot replace an in-game multiplayer/world-sample comparison; runtime smoke and structure validators remain separate gates.",
        ],
    }
    report["errors"] = validate_report(report)
    return report


def _parse_args(argv: Iterable[str] | None = None) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check", action="store_true", help="fail when the parity evidence has errors")
    parser.add_argument("--report", type=Path, help="write the JSON evidence report to this path")
    parser.add_argument("--stdout", action="store_true", help="write the JSON report to stdout")
    return parser.parse_args(list(argv) if argv is not None else None)


def main(argv: Iterable[str] | None = None) -> int:
    args = _parse_args(argv)
    try:
        report = build_report(ROOT)
    except (OSError, RuntimeError, json.JSONDecodeError, KeyError) as error:
        print(f"P1 parity validation failed to build evidence: {error}", file=sys.stderr)
        return 1
    rendered = json.dumps(report, indent=2, sort_keys=True) + "\n"
    if args.report:
        args.report.parent.mkdir(parents=True, exist_ok=True)
        args.report.write_text(rendered, encoding="utf-8")
    if args.stdout or not args.report:
        sys.stdout.write(rendered)
    if report["errors"]:
        for error in report["errors"]:
            print(f"ERROR: {error}", file=sys.stderr)
    for warning in report["warnings"]:
        print(f"WARNING: {warning}", file=sys.stderr)
    return 1 if args.check and report["errors"] else 0


if __name__ == "__main__":
    raise SystemExit(main())
