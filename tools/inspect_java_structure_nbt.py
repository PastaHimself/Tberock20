#!/usr/bin/env python3
"""Inspect Java Edition structure NBT files used by the port.

The authoritative The Broken Script structure templates are Java Edition big-endian
NBT, usually gzip-compressed. Bedrock's data-driven Jigsaw system can consume those
Java templates directly, so this tool deliberately does not rewrite them. Instead it
extracts deterministic structure metadata (size, palette, and Jigsaw connectors) for
source-parity audits and regression tests.
"""

from __future__ import annotations

import argparse
import gzip
import io
import json
import struct
import sys
from pathlib import Path
from typing import Any, BinaryIO

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


class NbtError(ValueError):
    """Raised when an NBT stream is malformed or unsupported."""


def _read_exact(stream: BinaryIO, size: int) -> bytes:
    data = stream.read(size)
    if len(data) != size:
        raise NbtError(f"unexpected end of NBT stream: wanted {size} byte(s), got {len(data)}")
    return data


def _unpack(stream: BinaryIO, fmt: str) -> Any:
    size = struct.calcsize(fmt)
    return struct.unpack(fmt, _read_exact(stream, size))[0]


def _read_string(stream: BinaryIO) -> str:
    length = _unpack(stream, ">H")
    raw = _read_exact(stream, length)
    try:
        return raw.decode("utf-8")
    except UnicodeDecodeError as exc:
        raise NbtError("invalid UTF-8 in NBT string") from exc


def _read_payload(stream: BinaryIO, tag_type: int) -> Any:
    if tag_type == TAG_BYTE:
        return _unpack(stream, ">b")
    if tag_type == TAG_SHORT:
        return _unpack(stream, ">h")
    if tag_type == TAG_INT:
        return _unpack(stream, ">i")
    if tag_type == TAG_LONG:
        return _unpack(stream, ">q")
    if tag_type == TAG_FLOAT:
        return _unpack(stream, ">f")
    if tag_type == TAG_DOUBLE:
        return _unpack(stream, ">d")
    if tag_type == TAG_BYTE_ARRAY:
        length = _unpack(stream, ">i")
        if length < 0:
            raise NbtError(f"negative byte-array length: {length}")
        return list(_read_exact(stream, length))
    if tag_type == TAG_STRING:
        return _read_string(stream)
    if tag_type == TAG_LIST:
        child_type = _unpack(stream, ">B")
        length = _unpack(stream, ">i")
        if length < 0:
            raise NbtError(f"negative list length: {length}")
        if child_type == TAG_END and length:
            raise NbtError("non-empty NBT list cannot use TAG_End elements")
        return [_read_payload(stream, child_type) for _ in range(length)]
    if tag_type == TAG_COMPOUND:
        result: dict[str, Any] = {}
        while True:
            child_type = _unpack(stream, ">B")
            if child_type == TAG_END:
                return result
            name = _read_string(stream)
            result[name] = _read_payload(stream, child_type)
    if tag_type == TAG_INT_ARRAY:
        length = _unpack(stream, ">i")
        if length < 0:
            raise NbtError(f"negative int-array length: {length}")
        return [_unpack(stream, ">i") for _ in range(length)]
    if tag_type == TAG_LONG_ARRAY:
        length = _unpack(stream, ">i")
        if length < 0:
            raise NbtError(f"negative long-array length: {length}")
        return [_unpack(stream, ">q") for _ in range(length)]
    raise NbtError(f"unsupported NBT tag type: {tag_type}")


def loads_nbt(data: bytes) -> dict[str, Any]:
    """Parse one Java Edition NBT document from raw or gzip-compressed bytes."""
    if data[:2] == b"\x1f\x8b":
        try:
            data = gzip.decompress(data)
        except OSError as exc:
            raise NbtError("invalid gzip-compressed NBT") from exc

    stream = io.BytesIO(data)
    root_type = _unpack(stream, ">B")
    if root_type != TAG_COMPOUND:
        raise NbtError(f"NBT root must be TAG_Compound (10), got {root_type}")
    _read_string(stream)  # Root name is irrelevant for structure templates.
    root = _read_payload(stream, TAG_COMPOUND)
    trailing = stream.read()
    if trailing:
        raise NbtError(f"unexpected trailing NBT data: {len(trailing)} byte(s)")
    return root


def load_nbt(path: Path) -> dict[str, Any]:
    return loads_nbt(path.read_bytes())


def _palette_names(root: dict[str, Any]) -> list[str | None]:
    palette = root.get("palette")
    if not isinstance(palette, list):
        return []
    result: list[str | None] = []
    for entry in palette:
        result.append(entry.get("Name") if isinstance(entry, dict) and isinstance(entry.get("Name"), str) else None)
    return result


def jigsaw_connectors(root: dict[str, Any]) -> list[dict[str, Any]]:
    """Return normalized Jigsaw block metadata from a Java structure root."""
    palette = _palette_names(root)
    blocks = root.get("blocks")
    if not isinstance(blocks, list):
        return []

    connectors: list[dict[str, Any]] = []
    for block in blocks:
        if not isinstance(block, dict):
            continue
        state = block.get("state")
        if not isinstance(state, int) or isinstance(state, bool) or not 0 <= state < len(palette):
            continue
        if palette[state] != "minecraft:jigsaw":
            continue

        nbt = block.get("nbt")
        if not isinstance(nbt, dict):
            nbt = {}
        pos = block.get("pos")
        connector = {
            "pos": pos if isinstance(pos, list) else None,
            "name": nbt.get("name"),
            "target": nbt.get("target"),
            "pool": nbt.get("pool"),
            "final_state": nbt.get("final_state"),
            "joint": nbt.get("joint"),
        }
        connectors.append(connector)

    connectors.sort(key=lambda item: tuple(item["pos"] or []))
    return connectors


def inspect_structure(path: Path) -> dict[str, Any]:
    root = load_nbt(path)
    size = root.get("size")
    palette = root.get("palette")
    blocks = root.get("blocks")
    entities = root.get("entities")
    return {
        "path": str(path),
        "data_version": root.get("DataVersion"),
        "size": size if isinstance(size, list) else None,
        "palette_size": len(palette) if isinstance(palette, list) else 0,
        "block_count": len(blocks) if isinstance(blocks, list) else 0,
        "entity_count": len(entities) if isinstance(entities, list) else 0,
        "jigsaws": jigsaw_connectors(root),
    }


def _parse_args(argv: list[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("files", nargs="+", type=Path, help="Java .nbt structure file(s) to inspect")
    parser.add_argument("--pretty", action="store_true", help="pretty-print JSON")
    return parser.parse_args(argv)


def main(argv: list[str] | None = None) -> int:
    args = _parse_args(sys.argv[1:] if argv is None else argv)
    failures = False
    reports: list[dict[str, Any]] = []
    for path in args.files:
        try:
            reports.append(inspect_structure(path))
        except (OSError, NbtError) as exc:
            failures = True
            reports.append({"path": str(path), "error": str(exc)})

    payload: Any = reports[0] if len(reports) == 1 else reports
    print(json.dumps(payload, indent=2 if args.pretty else None, sort_keys=True))
    return 1 if failures else 0


if __name__ == "__main__":
    raise SystemExit(main())
