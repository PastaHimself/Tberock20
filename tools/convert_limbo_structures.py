#!/usr/bin/env python3
"""Convert the nine original Java Limbo templates to Bedrock structures.

This pass preserves template extents and block geometry, translates common
Java block states, and emits Script API metadata for block-entity features that
cannot be represented safely in the structure palette.
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path

from convert_stage2_structures import IGNORED, build_mcstructure
from validate_jigsaw_nbt_connectors import load_java_nbt

TEMPLATES = (
    "limbo_house",
    "limbo_caveoutpost",
    "limbo_happyfarm",
    "limbo_sanctuary",
    "limbo_thewrongdirection",
    "limbo_distastefulquandary",
    "limbo_somethingoldsomethingnew",
    "limbo_towerbaseright",
    "limbo_treehouse",
)
MAX_SIZE = (64, 96, 64)

BLOCK_NAMES = {
    "minecraft:bricks": "minecraft:brick_block",
    "minecraft:chain": "minecraft:iron_chain",
    "minecraft:cobblestone_stairs": "minecraft:stone_stairs",
    "minecraft:oak_door": "minecraft:wooden_door",
    "minecraft:oak_fence_gate": "minecraft:fence_gate",
    "minecraft:oak_sign": "minecraft:standing_sign",
    "minecraft:oak_wall_sign": "minecraft:wall_sign",
    "minecraft:spruce_sign": "minecraft:spruce_standing_sign",
    "minecraft:wall_torch": "minecraft:torch",
    "minecraft:soul_wall_torch": "minecraft:soul_torch",
    "minecraft:water_cauldron": "minecraft:cauldron",
    "minecraft:white_wall_banner": "minecraft:wall_banner",
    "minecraft:potted_allium": "minecraft:flower_pot",
    "minecraft:potted_brown_mushroom": "minecraft:flower_pot",
    "minecraft:potted_cornflower": "minecraft:flower_pot",
    "minecraft:potted_dandelion": "minecraft:flower_pot",
    "minecraft:potted_lily_of_the_valley": "minecraft:flower_pot",
    "minecraft:potted_pink_tulip": "minecraft:flower_pot",
    "minecraft:potted_poppy": "minecraft:flower_pot",
}

ITEM_NAMES = {
    "minecraft:item_frame": "minecraft:frame",
    "minecraft:light_blue_banner": "minecraft:banner",
    "minecraft:light_gray_glazed_terracotta": "minecraft:silver_glazed_terracotta",
    "minecraft:map": "minecraft:empty_map",
    "minecraft:oak_trapdoor": "minecraft:trapdoor",
    "minecraft:orange_bed": "minecraft:bed",
    "minecraft:red_nether_bricks": "minecraft:red_nether_brick",
    "minecraft:yellow_bed": "minecraft:bed",
}

STAIR_DIRECTION = {"east": 0, "west": 1, "south": 2, "north": 3}
DIRECTION = {"south": 0, "west": 1, "north": 2, "east": 3}
FACING_DIRECTION = {"down": 0, "up": 1, "north": 2, "south": 3, "west": 4, "east": 5}
VINE_DIRECTION = {"south": 1, "west": 2, "north": 4, "east": 8}


def _bool(value: str | None) -> bool:
    return str(value).lower() == "true"


def _target_name(java_name: str, properties: dict[str, str]) -> str:
    if java_name.startswith("minecraft:") and java_name.endswith("_bed"):
        return "minecraft:bed"
    if java_name.startswith("minecraft:") and java_name.endswith("_slab") \
            and properties.get("type") == "double":
        return java_name.removesuffix("_slab") + "_double_slab"
    return BLOCK_NAMES.get(java_name, java_name)


def _convert_states(java_name: str, target_name: str, properties: dict[str, str]) -> dict[str, object]:
    states: dict[str, object] = {}

    if target_name == "thebrokenscript:new_vein":
        for key in (
            "up", "down", "north", "south", "east", "west",
            "north_wall", "south_wall", "east_wall", "west_wall",
        ):
            if key in properties:
                states[f"thebrokenscript:{key}"] = _bool(properties[key])
        return states
    if target_name == "thebrokenscript:ud_oak_door":
        if "open" in properties:
            states["thebrokenscript:open"] = _bool(properties["open"])
        return states
    if target_name.startswith("thebrokenscript:"):
        return states

    if "axis" in properties and properties["axis"] in {"x", "y", "z"}:
        states["pillar_axis"] = properties["axis"]

    if target_name.endswith("_stairs"):
        states["weirdo_direction"] = STAIR_DIRECTION[properties.get("facing", "east")]
        states["upside_down_bit"] = properties.get("half") == "top"
        shape = properties.get("shape", "straight")
        states["minecraft:corner"] = "none" if shape == "straight" else shape
    elif target_name.endswith("_double_slab"):
        states["minecraft:vertical_half"] = "bottom"
    elif target_name.endswith("_slab"):
        states["minecraft:vertical_half"] = properties.get("type", "bottom")
    elif target_name.endswith("_standing_sign") or target_name == "minecraft:standing_sign":
        states["ground_sign_direction"] = int(properties.get("rotation", 0))
    elif target_name.endswith("_wall_sign") or target_name == "minecraft:wall_sign":
        states["facing_direction"] = FACING_DIRECTION[properties.get("facing", "north")]
    elif target_name.endswith("_trapdoor") or target_name == "minecraft:trapdoor":
        states["direction"] = DIRECTION[properties.get("facing", "south")]
        states["open_bit"] = _bool(properties.get("open"))
        states["upside_down_bit"] = properties.get("half") == "top"
    elif target_name.endswith("_fence_gate") or target_name == "minecraft:fence_gate":
        states["minecraft:cardinal_direction"] = properties.get("facing", "north")
        states["in_wall_bit"] = _bool(properties.get("in_wall"))
        states["open_bit"] = _bool(properties.get("open"))
    elif target_name.endswith("_fence"):
        for direction in ("north", "south", "east", "west"):
            states[f"minecraft:connection_{direction}"] = _bool(properties.get(direction))
    elif target_name.endswith("_pane"):
        for direction in ("north", "south", "east", "west"):
            states[f"minecraft:connection_{direction}"] = _bool(properties.get(direction))
    elif target_name.endswith("_wall"):
        for direction in ("north", "south", "east", "west"):
            connection = properties.get(direction, "none")
            states[f"wall_connection_type_{direction}"] = (
                "short" if connection == "low" else connection
            )
        states["wall_post_bit"] = _bool(properties.get("up"))
    elif target_name.endswith("_door"):
        states["minecraft:cardinal_direction"] = properties.get("facing", "north")
        states["door_hinge_bit"] = properties.get("hinge") == "right"
        states["open_bit"] = _bool(properties.get("open"))
        states["upper_block_bit"] = properties.get("half") == "upper"

    if target_name in {"minecraft:torch", "minecraft:soul_torch"}:
        states["torch_facing_direction"] = properties.get("facing", "top")
    elif target_name in {"minecraft:lantern", "minecraft:soul_lantern"}:
        states["hanging"] = _bool(properties.get("hanging"))
    elif target_name == "minecraft:candle":
        states["candles"] = max(0, int(properties.get("candles", 1)) - 1)
        states["lit"] = _bool(properties.get("lit"))
    elif target_name == "minecraft:grindstone":
        face = properties.get("face", "floor")
        states["attachment"] = {"floor": "standing", "ceiling": "hanging", "wall": "side"}[face]
        states["direction"] = DIRECTION[properties.get("facing", "south")]
    elif target_name in {
        "minecraft:chest", "minecraft:trapped_chest", "minecraft:furnace",
        "minecraft:blast_furnace", "minecraft:smoker",
    }:
        states["minecraft:cardinal_direction"] = properties.get("facing", "north")
    elif target_name == "minecraft:bed":
        states["direction"] = DIRECTION[properties.get("facing", "south")]
        states["head_piece_bit"] = properties.get("part") == "head"
        states["occupied_bit"] = _bool(properties.get("occupied"))
    elif target_name in {"minecraft:ladder", "minecraft:end_rod", "minecraft:wall_banner"}:
        states["facing_direction"] = FACING_DIRECTION[properties.get("facing", "north")]
    elif target_name.endswith("_leaves"):
        states["persistent_bit"] = _bool(properties.get("persistent"))
        states["update_bit"] = False
    elif target_name == "minecraft:vine":
        states["vine_direction_bits"] = sum(
            bit for direction, bit in VINE_DIRECTION.items() if _bool(properties.get(direction))
        )
    elif target_name == "minecraft:cauldron":
        states["cauldron_liquid"] = "water"
        states["fill_level"] = min(6, int(properties.get("level", 3)) * 2)
    elif target_name == "minecraft:water":
        states["liquid_depth"] = int(properties.get("level", 0))

    return states


def convert_palette_entry(entry: dict) -> dict[str, object]:
    properties = dict(entry.get("Properties", {}))
    name = _target_name(entry["Name"], properties)
    return {"name": name, "states": _convert_states(entry["Name"], name, properties)}


def _json_text(value: object) -> str:
    if not isinstance(value, str):
        return str(value)
    try:
        parsed = json.loads(value)
    except json.JSONDecodeError:
        return value
    return parsed if isinstance(parsed, str) else json.dumps(parsed, ensure_ascii=False)


def _runtime_item(item: dict) -> dict[str, object]:
    converted: dict[str, object] = {
        "slot": int(item["Slot"]),
        "typeId": ITEM_NAMES.get(item["id"], item["id"]),
        "amount": int(item.get("count", 1)),
    }
    components = item.get("components", {})
    if "minecraft:custom_name" in components:
        converted["nameTag"] = _json_text(components["minecraft:custom_name"])
    if "minecraft:damage" in components:
        converted["damage"] = int(components["minecraft:damage"])
    book = components.get("minecraft:writable_book_content")
    if isinstance(book, dict):
        converted["bookPages"] = [page.get("raw", "") for page in book.get("pages", [])]
    return converted


def extract_runtime_metadata(source: Path) -> dict[str, object]:
    """Extract block-entity features that Bedrock Script API can restore safely."""
    original = load_java_nbt(source)
    signs: list[dict[str, object]] = []
    containers: list[dict[str, object]] = []
    records: list[dict[str, object]] = []
    source_block_entities: dict[str, int] = {}

    for block in original["blocks"]:
        block_entity = block.get("nbt")
        if not isinstance(block_entity, dict):
            continue
        entity_id = str(block_entity.get("id", "unknown"))
        source_block_entities[entity_id] = source_block_entities.get(entity_id, 0) + 1
        position = [int(value) for value in block["pos"]]

        if entity_id == "minecraft:sign":
            messages = block_entity.get("front_text", {}).get("messages", [])
            lines = [_json_text(message) for message in messages]
            if any(lines):
                signs.append({"position": position, "text": "\n".join(lines)})

        items = block_entity.get("Items")
        if isinstance(items, list) and items:
            palette_entry = original["palette"][block["state"]]
            containers.append({
                "position": position,
                "chestType": palette_entry.get("Properties", {}).get("type", "single"),
                "items": [_runtime_item(item) for item in items],
            })

        record = block_entity.get("RecordItem")
        if isinstance(record, dict) and isinstance(record.get("id"), str):
            records.append({"position": position, "typeId": record["id"]})

    return {
        "signs": signs,
        "containers": containers,
        "records": records,
        "sourceBlockEntities": dict(sorted(source_block_entities.items())),
    }


def metadata_module(source_root: Path) -> str:
    metadata = {
        name: extract_runtime_metadata(source_root / f"{name}.nbt")
        for name in TEMPLATES
    }
    payload = json.dumps(metadata, indent=2, ensure_ascii=False, sort_keys=True)
    return (
        "// Generated by tools/convert_limbo_structures.py from the original Java templates.\n"
        "// Signs, inventories, writable books, item damage, and records are restored after placement.\n"
        f"export const LIMBO_STRUCTURE_METADATA = Object.freeze({payload});\n"
    )


def convert_structure(source: Path) -> bytes:
    original = load_java_nbt(source)
    if original.get("entities"):
        raise ValueError(f"Limbo template entities require a Bedrock adapter in {source}")
    size = tuple(original["size"])
    if len(size) != 3 or any(value <= 0 for value in size):
        raise ValueError(f"invalid Limbo template size in {source}: {original['size']}")
    if any(value > limit for value, limit in zip(size, MAX_SIZE)):
        raise ValueError(f"Limbo template exceeds Bedrock safety bounds in {source}: {size}")
    sx, sy, sz = size

    source_palette = original["palette"]
    converted_palette = [convert_palette_entry(block) for block in source_palette]
    palette: list[dict[str, object]] = []
    indices_by_permutation: dict[tuple[str, tuple[tuple[str, object], ...]], int] = {}
    for permutation in converted_palette:
        name = str(permutation["name"])
        key = (name, tuple(sorted(permutation["states"].items())))
        if name in IGNORED or key in indices_by_permutation:
            continue
        indices_by_permutation[key] = len(palette)
        palette.append(permutation)

    layer = [-1] * (sx * sy * sz)
    for block in original["blocks"]:
        x, y, z = block["pos"]
        if not (0 <= x < sx and 0 <= y < sy and 0 <= z < sz):
            raise ValueError(f"out-of-bounds block in {source}: {block['pos']}")
        permutation = converted_palette[block["state"]]
        name = str(permutation["name"])
        if name not in IGNORED:
            key = (name, tuple(sorted(permutation["states"].items())))
            layer[(x * sy + y) * sz + z] = indices_by_permutation[key]

    return build_mcstructure(size, palette, layer)


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    args = parser.parse_args()
    source = args.root / "source_extracted/data/thebrokenscript/structure"
    output = args.root / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript"
    output.mkdir(parents=True, exist_ok=True)
    for name in TEMPLATES:
        target = output / f"{name}.mcstructure"
        target.write_bytes(convert_structure(source / f"{name}.nbt"))
        print(f"{target.relative_to(args.root)} ({target.stat().st_size} bytes)")
    metadata = metadata_module(source)
    for target in (
        args.root / "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/limbo_structure_metadata.js",
        args.root / "TheBrokenScript_Bedrock_2_0/src/systems/limbo_structure_metadata.js",
    ):
        target.write_text(metadata, encoding="utf-8")
        print(f"{target.relative_to(args.root)} ({target.stat().st_size} bytes)")


if __name__ == "__main__":
    main()
