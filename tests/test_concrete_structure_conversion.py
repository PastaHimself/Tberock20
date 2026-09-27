import importlib.util
import sys
import unittest
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
TOOLS = ROOT / "tools"
sys.path.insert(0, str(TOOLS))

from validate_jigsaw_nbt_connectors import load_java_nbt  # noqa: E402
from validate_mcstructures import LittleEndianNBTReader, validate_mcstructure_bytes  # noqa: E402


class ConcreteStructureConversionTests(unittest.TestCase):
    def load_converter(self):
        path = TOOLS / "convert_concrete_structure.py"
        self.assertTrue(path.is_file(), "Concrete converter must exist")
        spec = importlib.util.spec_from_file_location("convert_concrete_structure", path)
        module = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(module)
        return module

    def test_source_template_converts_to_exact_size_and_block_count(self):
        converter = self.load_converter()
        source = ROOT / "source_extracted/data/thebrokenscript/structure/concrete.nbt"
        payload = converter.convert_structure(source)
        report = validate_mcstructure_bytes(payload)
        self.assertEqual(tuple(report["size"]), (9, 10, 16))
        self.assertEqual(report["non_air_blocks"], 536)

    def test_conversion_bakes_java_180_rotation_and_preserves_water(self):
        converter = self.load_converter()
        source = ROOT / "source_extracted/data/thebrokenscript/structure/concrete.nbt"
        original = load_java_nbt(source)
        payload = converter.convert_structure(source)
        root = LittleEndianNBTReader(payload).read_root()
        palette = root["structure"]["palette"]["default"]["block_palette"]
        layer = root["structure"]["block_indices"][0]
        sx, sy, sz = root["size"]

        actual = {}
        for index, palette_index in enumerate(layer):
            if palette_index < 0:
                continue
            x, remainder = divmod(index, sy * sz)
            y, z = divmod(remainder, sz)
            entry = palette[palette_index]
            actual[(x, y, z)] = (entry["name"], entry["states"])

        expected_positions = {}
        for block in original["blocks"]:
            entry = original["palette"][block["state"]]
            if entry["Name"] == "minecraft:air":
                continue
            x, y, z = block["pos"]
            expected_positions[(sx - 1 - x, y, sz - 1 - z)] = entry["Name"]

        self.assertEqual(set(actual), set(expected_positions))
        for position, name in expected_positions.items():
            self.assertEqual(actual[position][0], name)

        water_states = {
            tuple(sorted(states.items()))
            for name, states in actual.values()
            if name == "minecraft:water"
        }
        self.assertEqual(water_states, {(('liquid_depth', 0),)})


if __name__ == "__main__":
    unittest.main()
