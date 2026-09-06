#!/usr/bin/env python3
"""Convert the Java Stage 2 structure corpus to Bedrock ``.mcstructure``.

The original mod stores its Stage 2 rooms as gzip-compressed Java structure
NBT. Bedrock structure files use an uncompressed little-endian NBT document,
ZYX block-index order, and Bedrock block-state names. This module keeps the
conversion deterministic so the complete audited catalog can be regenerated
from ``STAGE2_GENERATOR_AUDIT.json`` instead of hand-editing binary assets.

The block-state mappings are intentionally explicit. Java properties that have
no Bedrock equivalent (for example chest ``type`` or door ``powered``) are
omitted; the corresponding block entity or neighboring blocks retain the
portable part of the behavior. Item stacks inside block entities are adapted
from Java's ``id``/``count`` fields to Bedrock's ``Name``/``Count`` fields.

References used while porting the format and state names:

* https://wiki.bedrock.dev/nbt/mcstructure
* https://learn.microsoft.com/minecraft/creator/reference/content/vanillalistingsreference/blocks?view=minecraft-bedrock-stable
"""

from __future__ import annotations

import argparse
import copy
import json
import struct
from pathlib import Path
from typing import Any, Mapping

try:
    from .validate_jigsaw_nbt_connectors import load_java_nbt
except ImportError:  # pragma: no cover - supports direct script execution
    from validate_jigsaw_nbt_connectors import load_java_nbt


TAG_END = 0
TAG_BYTE = 1
TAG_SHORT = 2
TAG_INT = 3
TAG_LONG = 4
TAG_FLOAT = 5
TAG_DOUBLE = 6
TAG_BYTE_ARRAY = 7
TAG_STRING = 8
TAG_LIST = 9
TAG_COMPOUND = 10
TAG_INT_ARRAY = 11
TAG_LONG_ARRAY = 12

MCSTRUCTURE_FORMAT_VERSION = 1
# Current Bedrock block-palette version used by the pack's 1.26.x target.
BEDROCK_BLOCK_VERSION = 18168865
AIR = "minecraft:air"
IGNORED_STRUCTURE_BLOCKS = frozenset(
    {"minecraft:air", "minecraft:cave_air", "minecraft:structure_void"}
)

CARDINAL_DIRECTIONS = {"north", "south", "east", "west"}
FACING_DIRECTION = {
    "down": 0,
    "up": 1,
    "north": 2,
    "south": 3,
    "west": 4,
    "east": 5,
}
STAIR_DIRECTION = {"east": 0, "west": 1, "south": 2, "north": 3}
RAIL_DIRECTION = {
    "east_west": 0,
    "north_south": 1,
    "ascending_east": 2,
    "ascending_west": 3,
    "ascending_north": 4,
    "ascending_south": 5,
    "south_east": 6,
    "south_west": 7,
    "north_west": 8,
    "north_east": 9,
}

# These Java identifiers do not exist as portable Bedrock block identifiers in
# the target listing, or they use a legacy Bedrock name.
BLOCK_NAME_MAP = {
    "minecraft:grass": "minecraft:grass_block",
    "minecraft:oak_door": "minecraft:wooden_door",
    "minecraft:oak_fence_gate": "minecraft:fence_gate",
    "minecraft:oak_sign": "minecraft:standing_sign",
    "minecraft:oak_wall_sign": "minecraft:wall_sign",
    "minecraft:piston_head": "minecraft:sticky_piston_arm_collision",
    "minecraft:redstone_wall_torch": "minecraft:redstone_torch",
    "minecraft:wall_torch": "minecraft:torch",
    "thebrokenscript:it": "thebrokenscript:block_is_missing_id",
    "thebrokenscript:null": "thebrokenscript:null_structure",
}


class StructureConversionError(ValueError):
    """Raised when a source structure cannot be converted safely."""


def _require_int(value: Any, label: str) -> int:
    if isinstance(value, bool) or not isinstance(value, int):
        raise StructureConversionError(f"{label} must be an integer")
    return int(value)


def _require_triplet(value: Any, label: str) -> tuple[int, int, int]:
    if not isinstance(value, list) or len(value) != 3:
        raise StructureConversionError(f"{label} must be a list of three integers")
    return tuple(_require_int(item, f"{label}[{index}]") for index, item in enumerate(value))


def _as_bool(properties: Mapping[str, Any], key: str, default: bool = False) -> bool:
    value = properties.get(key, "true" if default else "false")
    if isinstance(value, bool):
        return value
    return str(value).lower() == "true"


def _as_int(properties: Mapping[str, Any], key: str, default: int = 0) -> int:
    value = properties.get(key, default)
    if isinstance(value, bool):
        return int(value)
    try:
        return int(value)
    except (TypeError, ValueError) as exc:
        raise StructureConversionError(f"block property {key!r} is not an integer") from exc


def _direction(properties: Mapping[str, Any], key: str = "facing") -> str:
    value = str(properties.get(key, "north"))
    if value not in CARDINAL_DIRECTIONS:
        raise StructureConversionError(f"unsupported cardinal direction {value!r}")
    return value


def _facing_value(direction: str) -> int:
    try:
        return FACING_DIRECTION[direction]
    except KeyError as exc:
        raise StructureConversionError(f"unsupported facing direction {direction!r}") from exc


def _bit(value: bool) -> int:
    return 1 if value else 0


def _convert_block_state(name: str, properties: Mapping[str, Any]) -> tuple[str, dict[str, Any]]:
    """Return a Bedrock block identifier and only its supported states."""

    target = BLOCK_NAME_MAP.get(name, name)

    # Custom pack blocks are deliberately authored as full blocks without
    # Java-style state permutations. ``ud_oak_door`` is the source's custom
    # surrogate and therefore keeps its authored appearance.
    if target.startswith("thebrokenscript:"):
        return target, {}

    if name == "minecraft:oak_door":
        return target, {
            "door_hinge_bit": _bit(str(properties.get("hinge", "left")) == "right"),
            "minecraft:cardinal_direction": _direction(properties),
            "open_bit": _bit(_as_bool(properties, "open")),
            "upper_block_bit": _bit(str(properties.get("half", "lower")) == "upper"),
        }

    if name in {"minecraft:wall_torch", "minecraft:redstone_wall_torch"}:
        return target, {"torch_facing_direction": _direction(properties)}

    if name == "minecraft:redstone_torch":
        return target, {"torch_facing_direction": "top"}

    if name == "minecraft:oak_wall_sign":
        return target, {"facing_direction": _facing_value(_direction(properties))}

    if name == "minecraft:oak_sign":
        return target, {"ground_sign_direction": _as_int(properties, "rotation")}

    if name == "minecraft:chest":
        return target, {"minecraft:cardinal_direction": _direction(properties)}

    if name == "minecraft:furnace":
        target = "minecraft:lit_furnace" if _as_bool(properties, "lit") else "minecraft:furnace"
        return target, {"minecraft:cardinal_direction": _direction(properties)}

    if name == "minecraft:dispenser":
        return target, {
            "facing_direction": _facing_value(_direction(properties)),
            "triggered_bit": _bit(_as_bool(properties, "triggered")),
        }

    if name == "minecraft:ladder":
        return target, {"facing_direction": _facing_value(_direction(properties))}

    if name == "minecraft:lectern":
        return target, {
            "minecraft:cardinal_direction": _direction(properties),
            "powered_bit": _bit(_as_bool(properties, "powered")),
        }

    if name == "minecraft:lever":
        face = str(properties.get("face", "floor"))
        direction = _direction(properties)
        if face == "floor":
            lever_direction = "down_north_south" if direction in {"north", "south"} else "down_east_west"
        elif face == "ceiling":
            lever_direction = "up_north_south" if direction in {"north", "south"} else "up_east_west"
        elif face == "wall":
            lever_direction = direction
        else:
            raise StructureConversionError(f"unsupported lever face {face!r}")
        return target, {
            "lever_direction": lever_direction,
            "open_bit": _bit(_as_bool(properties, "powered")),
        }

    if name in {"minecraft:oak_slab", "minecraft:smooth_stone_slab"}:
        half = str(properties.get("type", "bottom"))
        if half not in {"bottom", "top"}:
            raise StructureConversionError(f"unsupported slab type {half!r}")
        return target, {"minecraft:vertical_half": half}

    if name == "minecraft:oak_stairs":
        direction = _direction(properties)
        return target, {
            "upside_down_bit": _bit(str(properties.get("half", "bottom")) == "top"),
            "weirdo_direction": STAIR_DIRECTION[direction],
        }

    if name == "minecraft:oak_fence":
        # Bedrock stores fence connections as four boolean permutations. The
        # Java source already contains those relationships, so retain them.
        return target, {
            "minecraft:connection_east": _bit(_as_bool(properties, "east")),
            "minecraft:connection_north": _bit(_as_bool(properties, "north")),
            "minecraft:connection_south": _bit(_as_bool(properties, "south")),
            "minecraft:connection_west": _bit(_as_bool(properties, "west")),
        }

    if name == "minecraft:oak_fence_gate":
        return target, {
            "in_wall_bit": _bit(_as_bool(properties, "in_wall")),
            "minecraft:cardinal_direction": _direction(properties),
            "open_bit": _bit(_as_bool(properties, "open")),
        }

    if name == "minecraft:cobblestone_wall":
        return target, {
            "wall_connection_type_east": "short" if str(properties.get("east")) == "low" else str(properties.get("east", "none")),
            "wall_connection_type_north": "short" if str(properties.get("north")) == "low" else str(properties.get("north", "none")),
            "wall_connection_type_south": "short" if str(properties.get("south")) == "low" else str(properties.get("south", "none")),
            "wall_connection_type_west": "short" if str(properties.get("west")) == "low" else str(properties.get("west", "none")),
            "wall_post_bit": _bit(_as_bool(properties, "up", True)),
        }

    if name in {"minecraft:piston", "minecraft:sticky_piston"}:
        return target, {"facing_direction": _facing_value(_direction(properties))}

    if name == "minecraft:piston_head":
        return target, {"facing_direction": _facing_value(_direction(properties))}

    if name == "minecraft:rail":
        shape = str(properties.get("shape", "east_west"))
        if shape not in RAIL_DIRECTION:
            raise StructureConversionError(f"unsupported rail shape {shape!r}")
        return target, {"rail_direction": RAIL_DIRECTION[shape]}

    if name == "minecraft:redstone_wire":
        return target, {"redstone_signal": max(0, min(15, _as_int(properties, "power")))}

    if name == "minecraft:repeater":
        target = "minecraft:powered_repeater" if _as_bool(properties, "powered") else "minecraft:unpowered_repeater"
        # Java delays are 1..4 while Bedrock's state is 0..3.
        delay = max(1, min(4, _as_int(properties, "delay", 1)))
        return target, {
            "minecraft:cardinal_direction": _direction(properties),
            "repeater_delay": delay - 1,
        }

    if name in {"minecraft:water", "minecraft:lava"}:
        return target, {"liquid_depth": max(0, min(15, _as_int(properties, "level")))}

    if name == "minecraft:tall_grass":
        return target, {"upper_block_bit": _bit(str(properties.get("half", "lower")) == "upper")}

    # Most source palette entries are already valid Bedrock blocks with no
    # meaningful state properties (flowers, furniture, air, and full blocks).
    # Dropping unknown properties is safer than emitting Java-only names that
    # make BlockPermutation resolution fail at load time.
    return target, {}


def _convert_item_stack(item: Any) -> Any:
    if not isinstance(item, Mapping):
        return copy.deepcopy(item)

    converted = copy.deepcopy(dict(item))
    item_id = converted.pop("id", None)
    count = converted.pop("count", None)
    if "Name" not in converted and isinstance(item_id, str):
        converted["Name"] = item_id
    if "Count" not in converted and count is not None:
        converted["Count"] = _require_int(count, "item count")
    if "Count" in converted and "Damage" not in converted:
        converted["Damage"] = 0
    return converted


def _convert_block_entity(nbt: Mapping[str, Any]) -> dict[str, Any]:
    converted = copy.deepcopy(dict(nbt))
    items = converted.get("Items")
    if isinstance(items, list):
        converted["Items"] = [_convert_item_stack(item) for item in items]
    for key in ("Book", "RecordItem"):
        if key in converted:
            converted[key] = _convert_item_stack(converted[key])
    return converted


def _convert_entities(raw_entities: Any) -> list[dict[str, Any]]:
    if raw_entities is None:
        return []
    if not isinstance(raw_entities, list):
        raise StructureConversionError("Java structure entities must be a list")

    converted_entities: list[dict[str, Any]] = []
    for index, raw_entity in enumerate(raw_entities):
        if not isinstance(raw_entity, Mapping):
            raise StructureConversionError(f"entities[{index}] must be a compound")
        nbt = raw_entity.get("nbt")
        if not isinstance(nbt, Mapping):
            raise StructureConversionError(f"entities[{index}] is missing its NBT compound")
        entity = copy.deepcopy(dict(nbt))
        identifier = entity.pop("id", None)
        if not isinstance(identifier, str) or not identifier:
            raise StructureConversionError(f"entities[{index}] is missing a valid id")
        entity["identifier"] = identifier
        position = raw_entity.get("pos")
        if isinstance(position, list) and len(position) == 3:
            entity["Pos"] = copy.deepcopy(position)
        converted_entities.append(entity)
    return converted_entities


def _cell_index(position: tuple[int, int, int], size: tuple[int, int, int]) -> int:
    """Flatten [x, y, z] using Bedrock's ZYX order (z fastest)."""

    x, y, z = position
    size_x, size_y, size_z = size
    if not (0 <= x < size_x and 0 <= y < size_y and 0 <= z < size_z):
        raise StructureConversionError(f"block position {position} is outside structure size {size}")
    return x * size_y * size_z + y * size_z + z


def convert_java_structure(path: Path) -> dict[str, Any]:
    """Convert one gzip-compressed Java structure into a Python mcstructure tree."""

    root = load_java_nbt(path)
    size = _require_triplet(root.get("size"), "size")
    if any(value <= 0 for value in size):
        raise StructureConversionError(f"structure size must be positive, got {size}")

    raw_palette = root.get("palette")
    raw_blocks = root.get("blocks")
    if not isinstance(raw_palette, list) or not isinstance(raw_blocks, list):
        raise StructureConversionError("Java structure must contain palette and blocks lists")

    converted_palette: list[dict[str, Any]] = []
    palette_indices: dict[str, int] = {}
    source_state_to_target: list[int] = []

    for source_index, raw_state in enumerate(raw_palette):
        if not isinstance(raw_state, Mapping):
            raise StructureConversionError(f"palette[{source_index}] must be a compound")
        name = raw_state.get("Name")
        if not isinstance(name, str) or not name:
            raise StructureConversionError(f"palette[{source_index}] is missing Name")
        properties = raw_state.get("Properties", {})
        if not isinstance(properties, Mapping):
            raise StructureConversionError(f"palette[{source_index}].Properties must be a compound")
        target_name, states = _convert_block_state(name, properties)
        key = json.dumps([target_name, states], sort_keys=True, separators=(",", ":"))
        target_index = palette_indices.get(key)
        if target_index is None:
            target_index = len(converted_palette)
            palette_indices[key] = target_index
            converted_palette.append(
                {
                    "name": target_name,
                    "states": states,
                    "version": BEDROCK_BLOCK_VERSION,
                }
            )
        source_state_to_target.append(target_index)

    if not any(entry["name"] in IGNORED_STRUCTURE_BLOCKS for entry in converted_palette):
        converted_palette.append({"name": AIR, "states": {}, "version": BEDROCK_BLOCK_VERSION})

    volume = size[0] * size[1] * size[2]
    # Java's BlockIgnoreProcessor ignores AIR and STRUCTURE_VOID when a
    # template is placed. Bedrock uses -1 in both block-index layers for the
    # equivalent no-op cell; encoding air as a palette index would erase the
    # support/barrier layers that are generated before this template loads.
    primary = [-1] * volume
    block_position_data: dict[str, dict[str, Any]] = {}

    for block_index, raw_block in enumerate(raw_blocks):
        if not isinstance(raw_block, Mapping):
            raise StructureConversionError(f"blocks[{block_index}] must be a compound")
        position = _require_triplet(raw_block.get("pos"), f"blocks[{block_index}].pos")
        target_cell = _cell_index(position, size)
        source_state = _require_int(raw_block.get("state"), f"blocks[{block_index}].state")
        if not 0 <= source_state < len(source_state_to_target):
            raise StructureConversionError(f"blocks[{block_index}] references invalid palette index {source_state}")
        target_state = source_state_to_target[source_state]
        if converted_palette[target_state]["name"] not in IGNORED_STRUCTURE_BLOCKS:
            primary[target_cell] = target_state

        raw_nbt = raw_block.get("nbt")
        if raw_nbt is not None:
            if not isinstance(raw_nbt, Mapping):
                raise StructureConversionError(f"blocks[{block_index}].nbt must be a compound")
            block_position_data[str(target_cell)] = {
                "block_entity_data": _convert_block_entity(raw_nbt),
            }

    return {
        "format_version": MCSTRUCTURE_FORMAT_VERSION,
        "size": list(size),
        "structure": {
            "block_indices": [primary, [-1] * volume],
            "entities": _convert_entities(root.get("entities", [])),
            "palette": {
                "default": {
                    "block_palette": converted_palette,
                    "block_position_data": block_position_data,
                }
            },
        },
        "structure_world_origin": [0, 0, 0],
    }


BYTE_FIELDS = {
    "Count",
    "Slot",
    "Fire",
    "OnGround",
    "Invulnerable",
    "is_waxed",
    "has_glowing_text",
    "powered",
    "lit",
}


def _tag_type(value: Any, name: str = "") -> int:
    if value is None:
        return TAG_END
    if isinstance(value, bool):
        return TAG_BYTE
    if isinstance(value, int):
        if name == "Damage":
            return TAG_SHORT
        if name in BYTE_FIELDS or name.endswith("_bit"):
            return TAG_BYTE
        return TAG_INT
    if isinstance(value, float):
        return TAG_DOUBLE
    if isinstance(value, str):
        return TAG_STRING
    if isinstance(value, (bytes, bytearray)):
        return TAG_BYTE_ARRAY
    if isinstance(value, Mapping):
        return TAG_COMPOUND
    if isinstance(value, list):
        if not value:
            return TAG_LIST
        return TAG_LIST
    raise TypeError(f"unsupported NBT value {type(value).__name__} for {name!r}")


def _write_string(buffer: bytearray, value: str) -> None:
    encoded = value.encode("utf-8")
    if len(encoded) > 0xFFFF:
        raise StructureConversionError("NBT string exceeds the 16-bit length limit")
    buffer.extend(struct.pack("<H", len(encoded)))
    buffer.extend(encoded)


def _list_element_type(values: list[Any]) -> int:
    if not values:
        return TAG_END
    first = values[0]
    if isinstance(first, bool):
        return TAG_BYTE
    if isinstance(first, int):
        return TAG_INT
    if isinstance(first, float):
        return TAG_DOUBLE
    if isinstance(first, str):
        return TAG_STRING
    if isinstance(first, Mapping):
        return TAG_COMPOUND
    if isinstance(first, (bytes, bytearray)):
        return TAG_BYTE_ARRAY
    if isinstance(first, list):
        return TAG_LIST
    raise TypeError(f"unsupported NBT list element {type(first).__name__}")


def _write_payload(buffer: bytearray, tag_type: int, value: Any, name: str = "") -> None:
    if tag_type == TAG_BYTE:
        buffer.extend(struct.pack("<b", int(value)))
    elif tag_type == TAG_SHORT:
        buffer.extend(struct.pack("<h", int(value)))
    elif tag_type == TAG_INT:
        buffer.extend(struct.pack("<i", int(value)))
    elif tag_type == TAG_LONG:
        buffer.extend(struct.pack("<q", int(value)))
    elif tag_type == TAG_FLOAT:
        buffer.extend(struct.pack("<f", float(value)))
    elif tag_type == TAG_DOUBLE:
        buffer.extend(struct.pack("<d", float(value)))
    elif tag_type == TAG_BYTE_ARRAY:
        raw = bytes(value)
        buffer.extend(struct.pack("<i", len(raw)))
        buffer.extend(raw)
    elif tag_type == TAG_STRING:
        _write_string(buffer, str(value))
    elif tag_type == TAG_LIST:
        values = list(value)
        child_type = _list_element_type(values)
        buffer.extend(struct.pack("<B", child_type))
        buffer.extend(struct.pack("<i", len(values)))
        for child in values:
            _write_payload(buffer, child_type, child)
    elif tag_type == TAG_COMPOUND:
        for child_name, child_value in value.items():
            if child_value is None:
                continue
            _write_named_tag(buffer, str(child_name), child_value)
        buffer.extend(b"\x00")
    elif tag_type == TAG_INT_ARRAY:
        values = list(value)
        buffer.extend(struct.pack("<i", len(values)))
        for child in values:
            buffer.extend(struct.pack("<i", int(child)))
    elif tag_type == TAG_LONG_ARRAY:
        values = list(value)
        buffer.extend(struct.pack("<i", len(values)))
        for child in values:
            buffer.extend(struct.pack("<q", int(child)))
    else:
        raise TypeError(f"unsupported NBT tag type {tag_type} for {name!r}")


def _write_named_tag(buffer: bytearray, name: str, value: Any) -> None:
    tag_type = _tag_type(value, name)
    if tag_type == TAG_END:
        return
    buffer.extend(struct.pack("<B", tag_type))
    _write_string(buffer, name)
    _write_payload(buffer, tag_type, value, name)


def serialize_mcstructure(tree: Mapping[str, Any]) -> bytes:
    """Serialize an mcstructure tree as little-endian NBT."""

    buffer = bytearray()
    buffer.extend(struct.pack("<B", TAG_COMPOUND))
    _write_string(buffer, "")
    _write_payload(buffer, TAG_COMPOUND, tree, "root")
    return bytes(buffer)


def convert_and_write(source: Path, destination: Path) -> None:
    converted = convert_java_structure(source)
    destination.parent.mkdir(parents=True, exist_ok=True)
    destination.write_bytes(serialize_mcstructure(converted))


def _default_paths() -> tuple[Path, Path, Path]:
    root = Path(__file__).resolve().parents[1]
    return (
        root / "TheBrokenScript_Bedrock_2_0/STAGE2_GENERATOR_AUDIT.json",
        root / "source_extracted/data/thebrokenscript/structure",
        root / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage2",
    )


def main() -> int:
    default_audit, default_source_root, default_output_root = _default_paths()
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--audit", type=Path, default=default_audit)
    parser.add_argument("--source-root", type=Path, default=default_source_root)
    parser.add_argument("--output-root", type=Path, default=default_output_root)
    parser.add_argument(
        "--template",
        dest="templates",
        action="append",
        help="template id to convert; repeat the option, or omit it for all audited templates",
    )
    args = parser.parse_args()

    audit = json.loads(args.audit.read_text(encoding="utf-8"))
    entries = audit.get("templates") if isinstance(audit, Mapping) else None
    if not isinstance(entries, list):
        parser.error(f"{args.audit}: expected a templates list")
    by_id = {entry.get("id"): entry for entry in entries if isinstance(entry, Mapping)}
    template_ids = args.templates or [entry["id"] for entry in entries]

    for template_id in template_ids:
        if template_id not in by_id:
            parser.error(f"template {template_id!r} is not in {args.audit}")
        source = args.source_root / f"{template_id}.nbt"
        destination = args.output_root / f"{template_id}.mcstructure"
        convert_and_write(source, destination)
        print(f"{template_id}: {source} -> {destination}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
