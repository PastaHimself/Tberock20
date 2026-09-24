from __future__ import annotations

import importlib.util
import sys
import unittest
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parents[1]
TOOL_PATH = REPO_ROOT / "tools/inventory_structure_corpus.py"
spec = importlib.util.spec_from_file_location("inventory_structure_corpus", TOOL_PATH)
module = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = module
assert spec.loader is not None
spec.loader.exec_module(module)

SOURCE_ROOT = REPO_ROOT / "source_extracted/data/thebrokenscript/structure"
TARGET_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript"


class StructureCorpusInventoryTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.payload = module.build_inventory(SOURCE_ROOT, TARGET_ROOT)
        cls.entries = cls.payload["entries"]

    def test_inventory_contains_every_source_nbt_once(self):
        expected = sorted(
            path.relative_to(SOURCE_ROOT).as_posix()
            for path in SOURCE_ROOT.rglob("*.nbt")
            if path.is_file()
        )
        actual = [
            Path(entry["source_relative_path"]).relative_to(
                "source_extracted/data/thebrokenscript/structure"
            ).as_posix()
            for entry in self.entries
        ]
        self.assertEqual(expected, actual)
        self.assertEqual(len(expected), self.payload["template_count"])
        self.assertEqual(len(actual), len(set(actual)))

    def test_inventory_keeps_empty_or_malformed_sources_visible(self):
        empty = [entry for entry in self.entries if entry["empty_source"]]
        self.assertTrue(empty, "authoritative corpus contains known empty templates; they must not be omitted")
        for entry in empty:
            with self.subTest(path=entry["source_relative_path"]):
                self.assertEqual("parse_error", entry["validation_status"])
                self.assertTrue(entry["parse_error"])

    def test_required_audit_fields_are_populated(self):
        required = {
            "source_relative_path",
            "namespace",
            "filename",
            "source_sha256",
            "source_size_bytes",
            "contains_jigsaw_blocks",
            "connector_count",
            "palette_size",
            "block_count",
            "entity_count",
            "block_entity_count",
            "has_loot",
            "has_spawner",
            "has_data_marker",
            "bedrock_destination",
            "staging_status",
            "conversion_status",
            "validation_status",
        }
        for entry in self.entries:
            with self.subTest(path=entry["source_relative_path"]):
                self.assertTrue(required.issubset(entry))
                self.assertEqual("thebrokenscript", entry["namespace"])
                self.assertEqual(64, len(entry["source_sha256"]))

    def test_shaft_templates_are_the_only_source_identical_staged_templates_today(self):
        staged = [entry for entry in self.entries if entry["staging_status"] == "source_identical"]
        shaft = [entry for entry in staged if "/shaft/" in entry["source_relative_path"]]
        self.assertEqual(6, len(shaft))
        self.assertEqual(6, len(staged))
        root = next(entry for entry in shaft if entry["filename"] == "shaft_root.nbt")
        self.assertTrue(root["contains_jigsaw_blocks"])
        self.assertGreaterEqual(root["connector_count"], 1)

    def test_inventory_is_deterministic(self):
        again = module.build_inventory(SOURCE_ROOT, TARGET_ROOT)
        self.assertEqual(self.payload, again)
        self.assertEqual(module.render_inventory(self.payload), module.render_inventory(again))


if __name__ == "__main__":
    unittest.main()
