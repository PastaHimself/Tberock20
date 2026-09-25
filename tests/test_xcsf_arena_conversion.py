import sys
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "tools"))
from convert_xcsf_arena import convert_arena, outer_platform  # noqa: E402
from validate_mcstructures import validate_mcstructure_bytes  # noqa: E402


class XcsfArenaTests(unittest.TestCase):
    def test_source_arena_encounter_tiles_roundtrip(self):
        source = ROOT / "source_extracted/data/thebrokenscript/xcsf_structure/phase3_arena_final.xcsf"
        tiles = convert_arena(source)
        self.assertEqual(len(tiles), 9)
        counts = [validate_mcstructure_bytes(payload)["non_air_blocks"] for payload in tiles.values()]
        self.assertEqual(sum(counts), 61055)
        self.assertTrue(all(count > 0 for count in counts))

    def test_outer_tentacle_platform_is_a_bedrock_structure(self):
        self.assertEqual(validate_mcstructure_bytes(outer_platform())["non_air_blocks"], 1024)


if __name__ == "__main__":
    unittest.main()
