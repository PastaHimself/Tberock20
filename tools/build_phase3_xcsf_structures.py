#!/usr/bin/env python3
"""Convert the source Phase 3 XCSF arena into Bedrock .mcstructure chunks."""

from __future__ import annotations

import argparse
import json
import shutil
import struct
import sys
from array import array
from pathlib import Path

from inventory_xcsf import XcsfError, decode_xcsf

MCSTRUCTURE_FORMAT_VERSION = 1
MCSTRUCTURE_BLOCK_VERSION = 18_168_865
SOURCE_MIN_Y = -64
CHUNK_SIZE = 16
STRUCTURE_HEIGHT = 147
EXPECTED_SOURCE_SIZE = [400, 147, 404]
EXPECTED_CHUNK_COUNT = 560

TAG_END = 0
TAG_BYTE = 1
TAG_INT = 3
TAG_STRING = 8
TAG_LIST = 9
TAG_COMPOUND = 10


class ConversionError(RuntimeError):
    """Raised when source XCSF cannot be represented by the approved Bedrock adapter."""


DIRECT_BLOCKS = frozenset({
    "minecraft:air",
    "minecraft:diamond_block",
    "minecraft:dirt",
    "minecraft:gray_concrete",
    "thebrokenscript:decomposed_semiotics",
    "thebrokenscript:deviation",
    "thebrokenscript:intense_projection",
    "thebrokenscript:necrosis",
    "thebrokenscript:r_3",
    "thebrokenscript:void_template_2",
    "thebrokenscript:void_template_3",
    "thebrokenscript:void_template_6",
})


def convert_state(source_state: str) -> tuple[str, tuple[tuple[str, object], ...]]:
    if source_state in DIRECT_BLOCKS:
        return source_state, ()

    prefix = "thebrokenscript:void_liquid_block[level="
    if source_state.startswith(prefix) and source_state.endswith("]"):
        raw = source_state[len(prefix):-1]
        try:
            level = int(raw)
        except ValueError as exc:
            raise ConversionError(f"invalid void-liquid level in {source_state!r}") from exc
        if not 0 <= level <= 8:
            raise ConversionError(f"unsupported void-liquid level {level}")
        # A-001: Bedrock has no custom fluid registry. Preserve source-vs-flowing
        # distinction with the existing still/flow block adapter.
        return (
            "thebrokenscript:void_goop_still" if level == 0 else "thebrokenscript:void_goop_flow",
            (),
        )

    raise ConversionError(f"unmapped XCSF block state {source_state!r}")


def _name(out, value: str) -> None:
    encoded = value.encode("utf-8")
    if len(encoded) > 0x7FFF:
        raise ConversionError("NBT name/string is too long")
    out.write(struct.pack("<h", len(encoded)))
    out.write(encoded)


def _tag_header(out, tag_type: int, name: str) -> None:
    out.write(bytes([tag_type]))
    _name(out, name)


def _write_named_int(out, name: str, value: int) -> None:
    _tag_header(out, TAG_INT, name)
    out.write(struct.pack("<i", value))


def _write_named_string(out, name: str, value: str) -> None:
    _tag_header(out, TAG_STRING, name)
    _name(out, value)


def _write_int_list_payload(out, values) -> None:
    out.write(bytes([TAG_INT]))
    out.write(struct.pack("<i", len(values)))
    if isinstance(values, array) and values.typecode == "i":
        data = array("i", values)
        if sys.byteorder != "little":
            data.byteswap()
        out.write(data.tobytes())
        return
    for value in values:
        out.write(struct.pack("<i", int(value)))


def _write_named_int_list(out, name: str, values) -> None:
    _tag_header(out, TAG_LIST, name)
    _write_int_list_payload(out, values)


def _write_palette_entry(out, name: str, states: tuple[tuple[str, object], ...]) -> None:
    _write_named_string(out, "name", name)
    _tag_header(out, TAG_COMPOUND, "states")
    for state_name, state_value in states:
        if isinstance(state_value, bool):
            _tag_header(out, TAG_BYTE, state_name)
            out.write(struct.pack("<b", 1 if state_value else 0))
        elif isinstance(state_value, int):
            _write_named_int(out, state_name, state_value)
        elif isinstance(state_value, str):
            _write_named_string(out, state_name, state_value)
        else:
            raise ConversionError(f"unsupported Bedrock state value {state_value!r}")
    out.write(bytes([TAG_END]))
    _write_named_int(out, "version", MCSTRUCTURE_BLOCK_VERSION)
    out.write(bytes([TAG_END]))


def write_mcstructure(
    path: Path,
    primary: array,
    palette: list[tuple[str, tuple[tuple[str, object], ...]]],
) -> None:
    volume = CHUNK_SIZE * STRUCTURE_HEIGHT * CHUNK_SIZE
    if len(primary) != volume:
        raise ConversionError(f"primary layer length {len(primary)} != {volume}")
    path.parent.mkdir(parents=True, exist_ok=True)

    with path.open("wb") as out:
        out.write(bytes([TAG_COMPOUND]))
        _name(out, "")

        _write_named_int(out, "format_version", MCSTRUCTURE_FORMAT_VERSION)
        _write_named_int_list(out, "size", [CHUNK_SIZE, STRUCTURE_HEIGHT, CHUNK_SIZE])

        _tag_header(out, TAG_COMPOUND, "structure")
        _tag_header(out, TAG_LIST, "block_indices")
        out.write(bytes([TAG_LIST]))
        out.write(struct.pack("<i", 2))
        _write_int_list_payload(out, primary)
        _write_int_list_payload(out, array("i", [-1]) * volume)

        _tag_header(out, TAG_LIST, "entities")
        out.write(bytes([TAG_COMPOUND]))
        out.write(struct.pack("<i", 0))

        _tag_header(out, TAG_COMPOUND, "palette")
        _tag_header(out, TAG_COMPOUND, "default")
        _tag_header(out, TAG_LIST, "block_palette")
        out.write(bytes([TAG_COMPOUND]))
        out.write(struct.pack("<i", len(palette)))
        for name, states in palette:
            _write_palette_entry(out, name, states)
        _tag_header(out, TAG_COMPOUND, "block_position_data")
        out.write(bytes([TAG_END]))
        out.write(bytes([TAG_END]))
        out.write(bytes([TAG_END]))
        out.write(bytes([TAG_END]))

        _write_named_int_list(out, "structure_world_origin", [0, SOURCE_MIN_Y, 0])
        out.write(bytes([TAG_END]))


def build_structures(payload: bytes, output_root: Path, *, clean: bool = True) -> dict:
    decoded = decode_xcsf(payload)
    if decoded["size"] != EXPECTED_SOURCE_SIZE:
        raise ConversionError(
            f"unexpected Phase 3 XCSF size {decoded['size']}; expected {EXPECTED_SOURCE_SIZE}"
        )
    if decoded["duplicatePositionCount"] != 0:
        raise ConversionError("Phase 3 XCSF contains duplicate block positions")

    converted_by_source = {}
    palette = []
    palette_index = {}
    for state in decoded["palette"]:
        converted = convert_state(state)
        converted_by_source[state] = converted
        if converted not in palette_index:
            palette_index[converted] = len(palette)
            palette.append(converted)

    volume = CHUNK_SIZE * STRUCTURE_HEIGHT * CHUNK_SIZE
    chunks = {}
    source_counts = {}
    output_counts = {}

    for source_state, positions in decoded["positions"]:
        converted = converted_by_source[source_state]
        target_index = palette_index[converted]
        target_name = converted[0]
        source_counts[source_state] = len(positions)
        output_counts[target_name] = output_counts.get(target_name, 0) + len(positions)
        for x, y, z in positions:
            chunk_key = (x >> 4, z >> 4)
            primary = chunks.get(chunk_key)
            if primary is None:
                primary = array("i", [-1]) * volume
                chunks[chunk_key] = primary
            local_x = x & 0xF
            local_z = z & 0xF
            flat = ((local_x * STRUCTURE_HEIGHT) + y) * CHUNK_SIZE + local_z
            if primary[flat] != -1:
                raise ConversionError(f"duplicate converted block at {(x, y, z)}")
            primary[flat] = target_index

    if len(chunks) != EXPECTED_CHUNK_COUNT:
        raise ConversionError(
            f"unexpected occupied chunk count {len(chunks)}; expected {EXPECTED_CHUNK_COUNT}"
        )

    if clean and output_root.exists():
        shutil.rmtree(output_root)
    output_root.mkdir(parents=True, exist_ok=True)

    files = []
    non_void_total = 0
    for chunk_x, chunk_z in sorted(chunks, key=lambda value: (value[1], value[0])):
        primary = chunks[(chunk_x, chunk_z)]
        assigned = sum(1 for value in primary if value >= 0)
        non_void_total += assigned
        path = output_root / f"chunk_{chunk_x}_{chunk_z}.mcstructure"
        write_mcstructure(path, primary, palette)
        files.append({
            "chunk": [chunk_x, chunk_z],
            "path": path.name,
            "assignedBlocks": assigned,
            "byteSize": path.stat().st_size,
        })

    if non_void_total != decoded["positionCount"]:
        raise ConversionError(
            f"converted {non_void_total} positions but source contains {decoded['positionCount']}"
        )

    return {
        "schemaVersion": 1,
        "sourceSize": decoded["size"],
        "sourceMinY": SOURCE_MIN_Y,
        "sourcePaletteCount": decoded["paletteCount"],
        "outputPalette": [{"name": name, "states": dict(states)} for name, states in palette],
        "chunkCount": len(files),
        "positionCount": non_void_total,
        "sourceStateCounts": source_counts,
        "outputBlockCounts": output_counts,
        "files": files,
    }


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    root_default = Path(__file__).resolve().parents[1]
    parser.add_argument("--root", type=Path, default=root_default)
    parser.add_argument("--source", type=Path)
    parser.add_argument("--output-root", type=Path)
    parser.add_argument("--report", type=Path)
    args = parser.parse_args(argv)

    root = args.root.resolve()
    source = args.source or (
        root / "source_extracted/data/thebrokenscript/xcsf_structure/phase3_arena_final.xcsf"
    )
    output = args.output_root or (
        root / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/stage3/phase3_arena_final"
    )
    source = source if source.is_absolute() else root / source
    output = output if output.is_absolute() else root / output

    try:
        result = build_structures(source.read_bytes(), output)
    except (OSError, XcsfError, ConversionError) as exc:
        print(f"Phase 3 XCSF conversion failed: {exc}", file=sys.stderr)
        return 1

    if args.report:
        report = args.report if args.report.is_absolute() else root / args.report
        report.parent.mkdir(parents=True, exist_ok=True)
        report.write_text(json.dumps(result, indent=2, sort_keys=True) + "\n", encoding="utf-8")

    print(
        "Phase 3 XCSF structures: "
        f"chunks={result['chunkCount']} positions={result['positionCount']} "
        f"palette={len(result['outputPalette'])}"
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
