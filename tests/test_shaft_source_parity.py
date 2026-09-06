from __future__ import annotations

import hashlib
import importlib.util
import json
import sys
import unittest
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parents[1]
TOOL_PATH = REPO_ROOT / "tools/inspect_java_structure_nbt.py"
spec = importlib.util.spec_from_file_location("inspect_java_structure_nbt", TOOL_PATH)
module = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = module
assert spec.loader is not None
spec.loader.exec_module(module)

SOURCE_SHAFT = REPO_ROOT / "source_extracted/data/thebrokenscript/structure/shaft"
BP_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP"
BEDROCK_SHAFT = BP_ROOT / "structures/thebrokenscript/shaft"
SHAFT_TEMPLATES = (
    "shaft_corner.nbt",
    "shaft_hall.nbt",
    "shaft_junction.nbt",
    "shaft_room.nbt",
    "shaft_room_hall.nbt",
    "shaft_root.nbt",
)


def sha256(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as handle:
        for chunk in iter(lambda: handle.read(1024 * 1024), b""):
            digest.update(chunk)
    return digest.hexdigest()


class ShaftSourceParityTests(unittest.TestCase):
    def test_all_six_bedrock_jigsaw_templates_are_source_identical(self):
        for name in SHAFT_TEMPLATES:
            source = SOURCE_SHAFT / name
            staged = BEDROCK_SHAFT / name
            with self.subTest(template=name):
                self.assertTrue(source.is_file(), f"missing authoritative Shaft template: {source}")
                self.assertTrue(staged.is_file(), f"missing staged Shaft template: {staged}")
                self.assertEqual(sha256(source), sha256(staged))

    def test_root_jigsaw_connector_matches_source_metadata(self):
        root = module.load_nbt(SOURCE_SHAFT / "shaft_root.nbt")
        connectors = module.jigsaw_connectors(root)
        self.assertEqual(
            [
                {
                    "pos": [2, 0, 0],
                    "name": "minecraft:empty",
                    "target": "thebrokenscript:hallway",
                    "pool": "thebrokenscript:hallway",
                    "final_state": "minecraft:stone",
                    "joint": "rollable",
                },
                {
                    "pos": [2, 1, 1],
                    "name": "thebrokenscript:shaft_root",
                    "target": "minecraft:empty",
                    "pool": "minecraft:empty",
                    "final_state": "minecraft:air",
                    "joint": "rollable",
                },
            ],
            connectors,
        )

    def test_bedrock_root_pool_and_structure_use_source_connector_ids(self):
        root_pool = json.loads(
            (BP_ROOT / "worldgen/template_pools/shaft_root.json").read_text(encoding="utf-8-sig")
        )["minecraft:template_pool"]
        structure = json.loads(
            (BP_ROOT / "worldgen/structures/shaft.json").read_text(encoding="utf-8-sig")
        )["minecraft:jigsaw"]

        self.assertEqual("thebrokenscript:shaft_root", root_pool["description"]["identifier"])
        self.assertEqual("thebrokenscript/shaft/shaft_root", root_pool["elements"][0]["element"]["location"])
        self.assertEqual("thebrokenscript:shaft_root", structure["start_pool"])
        self.assertEqual("thebrokenscript:shaft_root", structure["start_jigsaw_name"])

    def test_packaging_preserves_authoritative_shaft_jigsaw_assets(self):
        package_script = (REPO_ROOT / "tools/package-addon.sh").read_text(encoding="utf-8")
        workflow = (REPO_ROOT / ".github/workflows/bedrock-addon-check.yml").read_text(encoding="utf-8")

        self.assertNotIn("find \"$STAGE_DIR/bp/structures\" -type f -name '*.nbt' -delete", package_script)
        self.assertNotIn("worldgen/structures/shaft.json\" \\", package_script)
        self.assertNotIn("find .ci/mct/behavior_packs/bp/structures -type f -name '*.nbt' -delete", workflow)
        self.assertIn("python tools/validate_jigsaw_worldgen.py", workflow)
        self.assertIn("python tools/validate_jigsaw_nbt_connectors.py", workflow)

    def test_no_invented_natural_shaft_structure_set_is_shipped(self):
        self.assertFalse(
            (BP_ROOT / "worldgen/structure_sets/shaft.json").exists(),
            "Java source has no natural Shaft structure_set; Bedrock must not invent one",
        )
        self.assertFalse(
            (REPO_ROOT / "source_extracted/data/thebrokenscript/worldgen/structure_set/shaft.json").exists()
        )

    def test_null_structure_block_has_no_fabricated_click_to_shaft_action(self):
        script = (BP_ROOT / "scripts/systems/custom_blocks.js").read_text(encoding="utf-8")
        self.assertIn('register("thebrokenscript:be_null_structure", {});', script)
        self.assertNotIn("placeJigsawStructure", script)
        self.assertNotIn("buildShaft", script)


if __name__ == "__main__":
    unittest.main()
