from __future__ import annotations

import importlib.util
import json
import sys
import tempfile
import unittest
from pathlib import Path

MODULE_PATH = Path(__file__).resolve().parents[1] / "tools/validate_jigsaw_worldgen.py"
spec = importlib.util.spec_from_file_location("validate_jigsaw_worldgen", MODULE_PATH)
module = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = module
assert spec.loader is not None
spec.loader.exec_module(module)


def write_json(path: Path, value: dict) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value), encoding="utf-8")


def build_valid_pack(root: Path) -> Path:
    bp = root / "BP"
    template = bp / "structures/thebrokenscript/shaft/shaft_root.nbt"
    template.parent.mkdir(parents=True, exist_ok=True)
    template.write_bytes(b"authoritative-java-nbt")

    write_json(
        bp / "worldgen/processors/shaft.json",
        {
            "format_version": "1.21.20",
            "minecraft:processor_list": {
                "description": {"identifier": "thebrokenscript:shaft"},
                "processors": [],
            },
        },
    )
    write_json(
        bp / "worldgen/template_pools/shaft/root.json",
        {
            "format_version": "1.21.20",
            "minecraft:template_pool": {
                "description": {"identifier": "thebrokenscript:shaft/root"},
                "fallback": "minecraft:empty",
                "elements": [
                    {
                        "element": {
                            "element_type": "minecraft:single_pool_element",
                            "location": "thebrokenscript:shaft/shaft_root",
                            "processors": "thebrokenscript:shaft",
                            "projection": "rigid",
                        },
                        "weight": 1,
                    }
                ],
            },
        },
    )
    write_json(
        bp / "worldgen/structures/shaft.json",
        {
            "format_version": "1.21.20",
            "minecraft:jigsaw": {
                "description": {"identifier": "thebrokenscript:shaft"},
                "step": "underground_structures",
                "terrain_adaptation": "bury",
                "start_pool": "thebrokenscript:shaft/root",
                "max_depth": 7,
                "start_height": {
                    "type": "constant",
                    "value": {"absolute": -32},
                },
                "heightmap_projection": "world_surface",
                "max_distance_from_center": {"horizontal": 64, "vertical": 48},
            },
        },
    )
    write_json(
        bp / "worldgen/structure_sets/shaft.json",
        {
            "format_version": "1.21.20",
            "minecraft:structure_set": {
                "description": {"identifier": "thebrokenscript:shaft"},
                "structures": [{"structure": "thebrokenscript:shaft", "weight": 1}],
                "placement": {
                    "type": "minecraft:random_spread",
                    "spread_type": "linear",
                    "salt": 12345,
                    "spacing": 32,
                    "separation": 8,
                },
            },
        },
    )
    return bp


class JigsawWorldgenValidatorTests(unittest.TestCase):
    def test_valid_pack_resolves_cross_file_references(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            result = module.validate_pack(bp)
            self.assertTrue(result.ok, result.errors)
            self.assertEqual(4, result.files_checked)

    def test_missing_structure_template_is_reported(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            (bp / "structures/thebrokenscript/shaft/shaft_root.nbt").unlink()
            result = module.validate_pack(bp)
            self.assertTrue(any("does not resolve" in error for error in result.errors))

    def test_unresolved_start_pool_is_reported(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            path = bp / "worldgen/structures/shaft.json"
            data = json.loads(path.read_text(encoding="utf-8"))
            data["minecraft:jigsaw"]["start_pool"] = "thebrokenscript:missing"
            write_json(path, data)
            result = module.validate_pack(bp)
            self.assertTrue(any("unresolved start_pool" in error for error in result.errors))

    def test_random_spread_requires_separation_less_than_half_spacing(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            path = bp / "worldgen/structure_sets/shaft.json"
            data = json.loads(path.read_text(encoding="utf-8"))
            data["minecraft:structure_set"]["placement"]["spacing"] = 16
            data["minecraft:structure_set"]["placement"]["separation"] = 8
            write_json(path, data)
            result = module.validate_pack(bp)
            self.assertTrue(any("less than half the spacing" in error for error in result.errors))

    def test_ocean_floor_projection_is_valid_and_sea_floor_is_not(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            path = bp / "worldgen/structures/shaft.json"
            data = json.loads(path.read_text(encoding="utf-8"))
            data["minecraft:jigsaw"]["heightmap_projection"] = "ocean_floor"
            write_json(path, data)
            self.assertTrue(module.validate_pack(bp).ok)

            data["minecraft:jigsaw"]["heightmap_projection"] = "sea_floor"
            write_json(path, data)
            result = module.validate_pack(bp)
            self.assertTrue(any("invalid heightmap_projection" in error for error in result.errors))

    def test_max_depth_zero_is_valid_but_twenty_one_is_not(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            path = bp / "worldgen/structures/shaft.json"
            data = json.loads(path.read_text(encoding="utf-8"))
            data["minecraft:jigsaw"]["max_depth"] = 0
            write_json(path, data)
            self.assertTrue(module.validate_pack(bp).ok)

            data["minecraft:jigsaw"]["max_depth"] = 21
            write_json(path, data)
            result = module.validate_pack(bp)
            self.assertTrue(any("max_depth must be an integer in [0, 20]" in error for error in result.errors))

    def test_legacy_single_pool_element_is_supported(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            path = bp / "worldgen/template_pools/shaft/root.json"
            data = json.loads(path.read_text(encoding="utf-8"))
            data["minecraft:template_pool"]["elements"][0]["element"]["element_type"] = (
                "minecraft:legacy_single_pool_element"
            )
            write_json(path, data)
            self.assertTrue(module.validate_pack(bp).ok)


if __name__ == "__main__":
    unittest.main()
