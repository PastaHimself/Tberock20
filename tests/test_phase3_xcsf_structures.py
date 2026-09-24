from __future__ import annotations

import importlib.util
import struct
import sys
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]


def load(name: str, path: Path):
    spec = importlib.util.spec_from_file_location(name, path)
    module = importlib.util.module_from_spec(spec)
    sys.modules[spec.name] = module
    assert spec.loader is not None
    spec.loader.exec_module(module)
    return module


inventory = load("inventory_xcsf_for_build", ROOT / "tools/inventory_xcsf.py")
sys.modules["inventory_xcsf"] = inventory
builder = load("build_phase3_xcsf_structures", ROOT / "tools/build_phase3_xcsf_structures.py")
validator = load("validate_mcstructures_for_xcsf", ROOT / "tools/validate_mcstructures.py")


def packed(x: int, y: int, z: int) -> int:
    return (x << 18) | (y << 9) | z


def synthetic_payload() -> bytes:
    payload = bytearray()
    payload += struct.pack("<III", 16, 16, 16)
    payload += bytes([1, 2])
    payload += bytes([15]) + b"thebrokenscript"
    for suffix in (b"r_3", b"void_liquid_block[level=0]"):
        payload += bytes([0, len(suffix)]) + suffix

    payload += struct.pack("<I", 2)
    payload += bytes([0]) + struct.pack("<I", packed(0, 0, 0))
    payload += bytes([0]) + struct.pack("<I", packed(0, 0, 1))
    payload += struct.pack("<I", 1)
    payload += bytes([0]) + struct.pack("<I", packed(1, 2, 3))
    return bytes(payload)


class Phase3XcsfStructureBuildTests(unittest.TestCase):
    def test_state_mapping_is_explicit_and_fluid_adapter_is_bounded(self):
        self.assertEqual(builder.convert_state("thebrokenscript:r_3"), ("thebrokenscript:r_3", ()))
        self.assertEqual(
            builder.convert_state("thebrokenscript:void_liquid_block[level=0]"),
            ("thebrokenscript:void_goop_still", ()),
        )
        self.assertEqual(
            builder.convert_state("thebrokenscript:void_liquid_block[level=8]"),
            ("thebrokenscript:void_goop_flow", ()),
        )
        with self.assertRaises(builder.ConversionError):
            builder.convert_state("minecraft:stone")

    def test_synthetic_xcsf_builds_valid_little_endian_mcstructure(self):
        old_size = builder.EXPECTED_SOURCE_SIZE
        old_chunks = builder.EXPECTED_CHUNK_COUNT
        try:
            builder.EXPECTED_SOURCE_SIZE = [16, 16, 16]
            builder.EXPECTED_CHUNK_COUNT = 1
            with tempfile.TemporaryDirectory() as tmp:
                output = Path(tmp) / "structures"
                report = builder.build_structures(synthetic_payload(), output)
                self.assertEqual(report["chunkCount"], 1)
                self.assertEqual(report["positionCount"], 3)
                self.assertEqual(
                    report["outputBlockCounts"],
                    {
                        "thebrokenscript:r_3": 2,
                        "thebrokenscript:void_goop_still": 1,
                    },
                )
                path = output / "chunk_0_0.mcstructure"
                metadata = validator.validate_mcstructure_file(path)
                self.assertEqual(metadata["size"], [16, 147, 16])
                self.assertEqual(metadata["layers"], 2)
                self.assertEqual(metadata["non_air_blocks"], 3)
                root = validator.LittleEndianNBTReader(path.read_bytes()).read_root()
                palette = root["structure"]["palette"]["default"]["block_palette"]
                self.assertEqual(
                    [entry["name"] for entry in palette],
                    ["thebrokenscript:r_3", "thebrokenscript:void_goop_still"],
                )
                primary = root["structure"]["block_indices"][0]
                self.assertEqual(primary[0], 0)
                self.assertEqual(primary[1], 0)
                self.assertEqual(primary[((1 * 147) + 2) * 16 + 3], 1)
                self.assertTrue(all(value == -1 for value in root["structure"]["block_indices"][1]))
        finally:
            builder.EXPECTED_SOURCE_SIZE = old_size
            builder.EXPECTED_CHUNK_COUNT = old_chunks


if __name__ == "__main__":
    unittest.main()
