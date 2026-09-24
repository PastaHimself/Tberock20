from __future__ import annotations

import importlib.util
import struct
import sys
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
TOOL = ROOT / "tools/inventory_xcsf.py"
spec = importlib.util.spec_from_file_location("inventory_xcsf", TOOL)
module = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = module
assert spec.loader is not None
spec.loader.exec_module(module)


def packed(x: int, y: int, z: int) -> int:
    return (x << 18) | (y << 9) | z


def synthetic_payload() -> bytes:
    payload = bytearray()
    payload += struct.pack("<III", 32, 32, 32)
    payload += bytes([1, 2])
    payload += bytes([9]) + b"minecraft"
    for suffix in (b"stone", b"air"):
        payload += bytes([0, len(suffix)]) + suffix

    # Two records for stone: one point and an inclusive run of three points.
    payload += struct.pack("<I", 2)
    payload += bytes([0]) + struct.pack("<I", packed(1, 2, 3))
    payload += bytes([1]) + struct.pack("<II", packed(16, 0, 0), 2)

    payload += struct.pack("<I", 1)
    payload += bytes([0]) + struct.pack("<I", packed(0, 0, 0))
    return bytes(payload)


class XcsfInventoryTests(unittest.TestCase):
    def test_decode_matches_source_bit_layout_and_inclusive_runs(self):
        result = module.decode_xcsf(synthetic_payload())
        self.assertEqual(result["size"], [32, 32, 32])
        self.assertEqual(result["palette"], ["minecraft:stone", "minecraft:air"])
        self.assertEqual(result["stateCounts"], {"minecraft:stone": 4, "minecraft:air": 1})
        self.assertEqual(result["positionCount"], 5)
        self.assertEqual(result["uniquePositionCount"], 5)
        self.assertEqual(result["duplicatePositionCount"], 0)
        self.assertEqual(result["chunkCount"], 2)
        self.assertEqual(result["sectionCount"], 2)
        self.assertEqual(result["bounds"], {"min": [0, 0, 0], "max": [16, 2, 3]})

    def test_invalid_namespace_index_is_rejected(self):
        payload = bytearray()
        payload += struct.pack("<III", 1, 1, 1)
        payload += bytes([1, 1])
        payload += bytes([9]) + b"minecraft"
        payload += bytes([1, 3]) + b"air"
        with self.assertRaises(module.XcsfError):
            module.decode_xcsf(bytes(payload))

    def test_out_of_bounds_position_is_rejected(self):
        payload = bytearray()
        payload += struct.pack("<III", 1, 1, 1)
        payload += bytes([1, 1])
        payload += bytes([9]) + b"minecraft"
        payload += bytes([0, 3]) + b"air"
        payload += struct.pack("<I", 1)
        payload += bytes([0]) + struct.pack("<I", packed(1, 0, 0))
        with self.assertRaises(module.XcsfError):
            module.decode_xcsf(bytes(payload))


if __name__ == "__main__":
    unittest.main()
