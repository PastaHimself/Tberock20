#!/usr/bin/env python3
"""Convert the two original Java Library templates to Bedrock structures."""

from __future__ import annotations

import argparse
from pathlib import Path
from typing import Any, Mapping

from convert_stage2_structures import IGNORED, build_mcstructure
from validate_jigsaw_nbt_connectors import load_java_nbt


TEMPLATES = ("library", "library2")


def _bedrock_palette_entry(block: Mapping[str, Any]) -> str | dict[str, Any]:
    name = block["Name"]
    if name != "thebrokenscript:mono_slab":
        return name

    slab_type = block.get("Properties", {}).get("type")
    if slab_type not in {"top", "bottom"}:
        raise ValueError(f"unsupported mono slab type: {slab_type!r}")
    return {
        "name": name,
        "states": {"thebrokenscript:top": slab_type == "top"},
    }


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
    if size != (16, 17, 16):
        raise ValueError(f"unsupported Library template size in {source}: {original['size']}")

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
        if entry is not None:
            layer[(x * sy + y) * sz + z] = indices[_palette_key(entry)]

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


if __name__ == "__main__":
    main()
