#!/usr/bin/env python3
"""Inventory and validate The Broken Script XCSF structures."""

from __future__ import annotations

import argparse
import hashlib
import json
import struct
from collections import Counter, defaultdict
from pathlib import Path

MASK = 0x1FF


class XcsfError(RuntimeError):
    """Raised when an XCSF payload is malformed or inconsistent."""


class Reader:
    def __init__(self, payload: bytes) -> None:
        self.payload = payload
        self.offset = 0

    def _take(self, count: int) -> bytes:
        if count < 0 or self.offset + count > len(self.payload):
            raise XcsfError(f"truncated XCSF at byte {self.offset}")
        data = self.payload[self.offset:self.offset + count]
        self.offset += count
        return data

    def u8(self) -> int:
        return self._take(1)[0]

    def u32(self) -> int:
        return struct.unpack("<I", self._take(4))[0]

    def text(self, count: int) -> str:
        start = self.offset
        try:
            return self._take(count).decode()
        except UnicodeDecodeError as exc:
            raise XcsfError(f"invalid text at byte {start}: {exc}") from exc


def unpack_pos(value: int) -> tuple[int, int, int]:
    """Mirror XcsfLoader.unpackPos: 9 bits each for x, y, z."""
    return ((value >> 18) & MASK, (value >> 9) & MASK, value & MASK)


def decode_xcsf(payload: bytes) -> dict:
    reader = Reader(payload)
    size = [reader.u32(), reader.u32(), reader.u32()]
    if not all(1 <= value <= 512 for value in size):
        raise XcsfError(f"invalid XCSF size {size}")

    namespace_count = reader.u8()
    palette_count = reader.u8()
    namespaces = [reader.text(reader.u8()) for _ in range(namespace_count)]

    palette: list[str] = []
    for _ in range(palette_count):
        namespace_index = reader.u8()
        if namespace_index >= len(namespaces):
            raise XcsfError(f"palette namespace index {namespace_index} out of range")
        suffix = reader.text(reader.u8())
        palette.append(f"{namespaces[namespace_index]}:{suffix}")

    positions_by_state: list[tuple[str, list[tuple[int, int, int]]]] = []
    state_counts: Counter[str] = Counter()
    duplicate_count = 0
    seen: set[tuple[int, int, int]] = set()
    chunks: dict[tuple[int, int], set[int]] = defaultdict(set)
    bounds = [512, 512, 512, -1, -1, -1]

    for state in palette:
        record_count = reader.u32()
        positions: list[tuple[int, int, int]] = []
        for _ in range(record_count):
            flag = reader.u8()
            if flag == 1:
                start = reader.u32()
                run_length = reader.u32()
                # Source decoder expands inclusively: start..start+len.
                raw_values = range(start, start + run_length + 1)
            elif flag == 0:
                raw_values = (reader.u32(),)
            else:
                raise XcsfError(f"invalid run flag {flag}")

            for raw_value in raw_values:
                position = unpack_pos(raw_value)
                if any(position[index] >= size[index] for index in range(3)):
                    raise XcsfError(f"packed position {position} outside structure size {size}")

                if position in seen:
                    duplicate_count += 1
                else:
                    seen.add(position)

                x, y, z = position
                bounds[0] = min(bounds[0], x)
                bounds[1] = min(bounds[1], y)
                bounds[2] = min(bounds[2], z)
                bounds[3] = max(bounds[3], x)
                bounds[4] = max(bounds[4], y)
                bounds[5] = max(bounds[5], z)
                chunks[(x >> 4, z >> 4)].add(y >> 4)

                positions.append(position)
                state_counts[state] += 1
        positions_by_state.append((state, positions))

    if reader.offset != len(payload):
        raise XcsfError(f"{len(payload) - reader.offset} trailing bytes")

    return {
        "size": size,
        "namespaceCount": namespace_count,
        "palette": palette,
        "paletteCount": len(palette),
        "positionCount": sum(state_counts.values()),
        "uniquePositionCount": len(seen),
        "duplicatePositionCount": duplicate_count,
        "bounds": None if not seen else {"min": bounds[:3], "max": bounds[3:]},
        "chunkCount": len(chunks),
        "sectionCount": sum(len(sections) for sections in chunks.values()),
        "stateCounts": dict(state_counts),
        "positions": positions_by_state,
    }


def inventory_file(path: Path) -> dict:
    payload = path.read_bytes()
    result = decode_xcsf(payload)
    result.pop("positions", None)
    result["byteSize"] = len(payload)
    result["sha256"] = hashlib.sha256(payload).hexdigest()
    return result


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument("--report", type=Path)
    args = parser.parse_args()
    root = args.root.resolve()
    source = root / "source_extracted/data/thebrokenscript/xcsf_structure/phase3_arena_final.xcsf"

    result = {
        "schemaVersion": 1,
        "decoderSource": "decompiled_brokencore/net/thebrokenscript/brokencore/api/xcsf/XcsfLoader.java",
        "path": source.relative_to(root).as_posix(),
        **inventory_file(source),
    }
    payload = json.dumps(result, indent=2, sort_keys=True) + "\n"

    if args.report:
        report = args.report if args.report.is_absolute() else root / args.report
        report.parent.mkdir(parents=True, exist_ok=True)
        report.write_text(payload, encoding="utf-8")

    print(
        "XCSF: "
        f"{result['size']} palette={result['paletteCount']} "
        f"positions={result['positionCount']} chunks={result['chunkCount']} "
        f"sections={result['sectionCount']}"
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
