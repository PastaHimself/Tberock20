#!/usr/bin/env python3
"""Convert the Java Concrete template with its source 180-degree rotation baked in."""

from __future__ import annotations

import argparse
from pathlib import Path
from typing import Any, Mapping

from convert_stage2_structures import IGNORED, build_mcstructure
from validate_jigsaw_nbt_connectors import load_java_nbt


def _bedrock_palette_entry(block: Mapping[str, Any]) -> str | dict[str, Any]:
    name = block["Name"]
    if name == "minecraft:water":
        return {
            "name": name,
            "states": {"liquid_depth": int(block.get("Properties", {}).get("level", 0))},
        }
    return name


def _palette_key(entry: str | Mapping[str, Any]) -> tuple[Any, ...]:
    if isinstance(entry, str):
        return (entry,)
    return (
        entry["name"],
        *sorted(entry.get("states", {}).items()),
    )


def convert_structure(source: Path) -> bytes:
    original = load_java_nbt(source)
    size = tuple(original["size"])
    if size != (9, 10, 16):
        raise ValueError(f"unsupported Concrete template size in {source}: {original['size']}")
    if original.get("entities"):
        raise ValueError(f"Concrete template unexpectedly contains entities: {source}")

    source_palette = original["palette"]
    palette: list[str | Mapping[str, Any]] = []
    indices: dict[tuple[Any, ...], int] = {}
    source_entries: dict[int, str | Mapping[str, Any] | None] = {}
    for source_index, block in enumerate(source_palette):
        if block["Name"] in IGNORED:
            source_entries[source_index] = None
            continue
        entry = _bedrock_palette_entry(block)
        key = _palette_key(entry)
        if key not in indices:
            indices[key] = len(palette)
            palette.append(entry)
        source_entries[source_index] = entry

    sx, sy, sz = size
    layer = [-1] * (sx * sy * sz)
    for block in original["blocks"]:
        x, y, z = block["pos"]
        if not (0 <= x < sx and 0 <= y < sy and 0 <= z < sz):
            raise ValueError(f"out-of-bounds block in {source}: {block['pos']}")
        entry = source_entries[block["state"]]
        if entry is None:
            continue
        rotated_x = sx - 1 - x
        rotated_z = sz - 1 - z
        layer[(rotated_x * sy + y) * sz + rotated_z] = indices[_palette_key(entry)]

    return build_mcstructure(size, palette, layer)


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    args = parser.parse_args()
    source = args.root / "source_extracted/data/thebrokenscript/structure/concrete.nbt"
    target = args.root / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/concrete.mcstructure"
    target.parent.mkdir(parents=True, exist_ok=True)
    target.write_bytes(convert_structure(source))
    print(f"{target.relative_to(args.root)} ({target.stat().st_size} bytes)")


if __name__ == "__main__":
    main()
