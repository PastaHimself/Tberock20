import importlib.util
import sys
import unittest
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
TOOLS = ROOT / "tools"
sys.path.insert(0, str(TOOLS))

from validate_mcstructures import LittleEndianNBTReader, validate_mcstructure_bytes  # noqa: E402


class LibraryStructureConversionTests(unittest.TestCase):
    def load_converter(self):
        path = TOOLS / "convert_library_structures.py"
        self.assertTrue(path.is_file(), "Library converter must exist")
        spec = importlib.util.spec_from_file_location("convert_library_structures", path)
        module = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(module)
        return module

    def test_source_templates_convert_to_exact_sizes_and_block_counts(self):
        converter = self.load_converter()
        source = ROOT / "source_extracted/data/thebrokenscript/structure"
        expected = {
            "library": ((16, 17, 16), 930),
            "library2": ((16, 17, 16), 1012),
        }
        for name, (size, non_air) in expected.items():
            payload = converter.convert_structure(source / f"{name}.nbt")
            report = validate_mcstructure_bytes(payload)
            self.assertEqual(tuple(report["size"]), size)
            self.assertEqual(report["non_air_blocks"], non_air)

    def test_library2_conversion_preserves_top_and_bottom_slab_states(self):
        converter = self.load_converter()
        payload = converter.convert_structure(
            ROOT / "source_extracted/data/thebrokenscript/structure/library2.nbt",
        )
        root = LittleEndianNBTReader(payload).read_root()
        palette = root["structure"]["palette"]["default"]["block_palette"]
        slabs = [entry for entry in palette if entry["name"] == "thebrokenscript:mono_slab"]
        self.assertEqual(
            {entry["states"]["thebrokenscript:top"] for entry in slabs},
            {0, 1},
        )


if __name__ == "__main__":
    unittest.main()
