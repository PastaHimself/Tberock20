#!/usr/bin/env python3
"""Convert five original Stage 2 Java templates to Bedrock structures.

The source generator ignores air and structure void, so primary layer -1
represents those cells. Directional Java states and block entities require
Bedrock equivalents and are intentionally excluded from this geometry pass.
"""

from __future__ import annotations

import argparse
import struct
from pathlib import Path

from validate_jigsaw_nbt_connectors import load_java_nbt
from validate_mcstructures import validate_mcstructure_bytes

TEMPLATES = ("fieldbase", "clanvoidnew1", "clandimensionroom1", "woodfloor1", "stone1")
BLOCK_NAMES = {
    "minecraft:grass": "minecraft:short_grass",
    "minecraft:wall_torch": "minecraft:torch",
    "minecraft:oak_door": "minecraft:wooden_door",
}
IGNORED = {"minecraft:air", "minecraft:cave_air", "minecraft:structure_void"}


def _int(value: int) -> bytes:
    return struct.pack("<i", value)


def _string(value: str) -> bytes:
    encoded = value.encode("utf-8")
    return struct.pack("<h", len(encoded)) + encoded


def _tag(tag_type: int, name: str, value: bytes) -> bytes:
    return bytes((tag_type,)) + _string(name) + value


def _compound(*children: bytes) -> bytes:
    return b"".join(children) + b"\0"


def _list(tag_type: int, payloads: list[bytes]) -> bytes:
    return bytes((tag_type,)) + _int(len(payloads)) + b"".join(payloads)


def _int_list(items: list[int]) -> bytes:
    return _list(3, [_int(item) for item in items])


def build_mcstructure(size: tuple[int, int, int], palette: list[str], layer: list[int]) -> bytes:
    sx, sy, sz = size
    if len(layer) != sx * sy * sz:
        raise ValueError("block layer does not match structure size")
    blocks = [_compound(
        _tag(8, "name", _string(name)),
        _tag(3, "version", _int(18168865)),
        _tag(10, "states", _compound()),
    ) for name in palette]
    default_palette = _compound(
        _tag(9, "block_palette", _list(10, blocks)),
        _tag(10, "block_position_data", _compound()),
    )
    structure = _compound(
        _tag(9, "block_indices", _list(9, [_int_list(layer), _int_list([-1] * len(layer))])),
        _tag(9, "entities", _list(10, [])),
        _tag(10, "palette", _compound(_tag(10, "default", default_palette))),
    )
    result = _tag(10, "", _compound(
        _tag(3, "format_version", _int(1)),
        _tag(9, "size", _int_list([sx, sy, sz])),
        _tag(9, "structure_world_origin", _int_list([0, 0, 0])),
        _tag(10, "structure", structure),
    ))
    validate_mcstructure_bytes(result)
    return result


def convert_structure(source: Path) -> bytes:
    original = load_java_nbt(source)
    sx, sy, sz = original["size"]
    if (sx, sz) != (16, 16) or sy > 96:
        raise ValueError(f"unsupported Stage 2 cell size in {source}: {original['size']}")

    source_palette = original["palette"]
    palette = []
    indices_by_name = {}
    for block in source_palette:
        name = BLOCK_NAMES.get(block["Name"], block["Name"])
        if name in IGNORED or name in indices_by_name:
            continue
        indices_by_name[name] = len(palette)
        palette.append(name)

    layer = [-1] * (sx * sy * sz)
    for block in original["blocks"]:
        x, y, z = block["pos"]
        if not (0 <= x < sx and 0 <= y < sy and 0 <= z < sz):
            raise ValueError(f"out-of-bounds block in {source}: {block['pos']}")
        name = BLOCK_NAMES.get(source_palette[block["state"]]["Name"], source_palette[block["state"]]["Name"])
        if name not in IGNORED:
            layer[(x * sy + y) * sz + z] = indices_by_name[name]

    return build_mcstructure((sx, sy, sz), palette, layer)


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    args = parser.parse_args()
    source = args.root / "source_extracted/data/thebrokenscript/structure"
    output = args.root / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript"
    output.mkdir(parents=True, exist_ok=True)
    for name in TEMPLATES:
        target = output / f"stage2_{name}.mcstructure"
        target.write_bytes(convert_structure(source / f"{name}.nbt"))
        print(f"{target.relative_to(args.root)} ({target.stat().st_size} bytes)")


if __name__ == "__main__":
    main()
