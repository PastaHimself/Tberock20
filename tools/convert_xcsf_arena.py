#!/usr/bin/env python3
"""Rebuild the central Phase 3 boss arena from Java's packed XCSF file."""

from __future__ import annotations

import argparse
import struct
from pathlib import Path

from convert_stage2_structures import build_mcstructure

TILE_SIZE = 32
HEIGHT = 64
ORIGIN_X = 144
ORIGIN_Z = 160
TILES_PER_AXIS = 3
VOLUME = TILE_SIZE * HEIGHT * TILE_SIZE


def _name(source: str) -> str:
    if source.startswith("thebrokenscript:void_liquid_block[level="):
        level = int(source.partition("level=")[2].rstrip("]"))
        return "thebrokenscript:void_goop_still" if level == 0 else "thebrokenscript:void_goop_flow"
    return source.split("[", 1)[0]


def convert_arena(source: Path) -> dict[tuple[int, int], bytes]:
    data = source.read_bytes()
    size_x, size_y, size_z = struct.unpack_from("<III", data)
    if (size_x, size_y, size_z) != (400, 147, 404):
        raise ValueError(f"unexpected XCSF dimensions {(size_x, size_y, size_z)}")
    cursor = 12
    namespace_count, palette_count = struct.unpack_from("BB", data, cursor)
    cursor += 2
    namespaces = []
    for _ in range(namespace_count):
        length = data[cursor]
        cursor += 1
        namespaces.append(data[cursor:cursor + length].decode("utf-8"))
        cursor += length
    source_palette = []
    for _ in range(palette_count):
        namespace, length = struct.unpack_from("BB", data, cursor)
        cursor += 2
        source_palette.append(namespaces[namespace] + ":" + data[cursor:cursor + length].decode("utf-8"))
        cursor += length

    layers = {(x, z): [-1] * VOLUME for x in range(3) for z in range(3)}
    palettes: dict[tuple[int, int], list[str]] = {(x, z): [] for x in range(3) for z in range(3)}
    lookups: dict[tuple[int, int], dict[str, int]] = {(x, z): {} for x in range(3) for z in range(3)}
    for raw_name in source_palette:
        entries = struct.unpack_from("<I", data, cursor)[0]
        cursor += 4
        name = _name(raw_name)
        for _ in range(entries):
            flag = data[cursor]
            packed = struct.unpack_from("<I", data, cursor + 1)[0]
            cursor += 5
            run = 0
            if flag == 1:
                run = struct.unpack_from("<I", data, cursor)[0]
                cursor += 4
            for coordinate in range(packed, packed + run + 1):
                x = (coordinate >> 18) & 511
                y = (coordinate >> 9) & 511
                z = coordinate & 511
                if not (ORIGIN_X <= x < ORIGIN_X + 3 * TILE_SIZE
                        and ORIGIN_Z <= z < ORIGIN_Z + 3 * TILE_SIZE
                        and y < HEIGHT and raw_name != "minecraft:air"):
                    continue
                tile = ((x - ORIGIN_X) // TILE_SIZE, (z - ORIGIN_Z) // TILE_SIZE)
                if name not in lookups[tile]:
                    lookups[tile][name] = len(palettes[tile])
                    palettes[tile].append(name)
                local_x = (x - ORIGIN_X) % TILE_SIZE
                local_z = (z - ORIGIN_Z) % TILE_SIZE
                layers[tile][(local_x * HEIGHT + y) * TILE_SIZE + local_z] = lookups[tile][name]
    if cursor != len(data):
        raise ValueError(f"XCSF decoder stopped at {cursor}, expected {len(data)}")
    return {tile: build_mcstructure((TILE_SIZE, HEIGHT, TILE_SIZE), palettes[tile], layer)
            for tile, layer in layers.items()}


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    args = parser.parse_args()
    source = args.root / "source_extracted/data/thebrokenscript/xcsf_structure/phase3_arena_final.xcsf"
    output = args.root / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript"
    output.mkdir(parents=True, exist_ok=True)
    for (x, z), payload in convert_arena(source).items():
        path = output / f"phase3_core_{x}_{z}.mcstructure"
        path.write_bytes(payload)
        print(f"{path.relative_to(args.root)} ({len(payload)} bytes)")


if __name__ == "__main__":
    main()
