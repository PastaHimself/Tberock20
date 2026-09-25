import sys
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "tools"))

from convert_stage2_structures import convert_structure  # noqa: E402
from validate_mcstructures import LittleEndianNBTReader, validate_mcstructure_bytes  # noqa: E402


class Stage2StructureConversionTests(unittest.TestCase):
    def test_source_templates_preserve_blocks_and_ignore_air(self):
        for name in ("fieldbase", "clanvoidnew1", "clandimensionroom1", "woodfloor1", "stone1"):
            with self.subTest(name=name):
                payload = convert_structure(ROOT / "source_extracted/data/thebrokenscript/structure" / f"{name}.nbt")
                validated = validate_mcstructure_bytes(payload)
                self.assertEqual(validated["size"][0], 16)
                root = LittleEndianNBTReader(payload).read_root()
                layer = root["structure"]["block_indices"][0]
                palette = root["structure"]["palette"]["default"]["block_palette"]
                self.assertGreater(sum(index >= 0 for index in layer), 250)
                self.assertTrue(all(entry["name"].startswith(("minecraft:", "thebrokenscript:")) for entry in palette))
                self.assertTrue(all(entry["name"] not in {"minecraft:oak_door", "minecraft:wall_torch"} for entry in palette))
                if name == "woodfloor1":
                    self.assertIn("minecraft:wooden_door", [entry["name"] for entry in palette])
                if name == "clanvoidnew1":
                    self.assertIn("minecraft:torch", [entry["name"] for entry in palette])
                if name == "fieldbase":
                    self.assertEqual(palette[layer[0]]["name"], "minecraft:bedrock")
                    self.assertEqual(palette[layer[16]]["name"], "minecraft:grass_block")
                    self.assertEqual(layer[16 * 3], -1)


if __name__ == "__main__":
    unittest.main()
