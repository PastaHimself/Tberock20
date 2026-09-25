from __future__ import annotations

import copy
import importlib.util
import sys
import unittest
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parents[1]
TOOL_PATH = REPO_ROOT / "tools/validate_p1_parity.py"
spec = importlib.util.spec_from_file_location("validate_p1_parity", TOOL_PATH)
module = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = module
assert spec.loader is not None
spec.loader.exec_module(module)


TODO_ITEMS = [
    "P1 — Quests, items, blocks, loot, and commands",
    "P1 — Dimensions, worldgen, structures, and portals",
]


class P1ParityValidatorTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.report = module.build_report(REPO_ROOT)

    def test_report_covers_the_selected_todo_items(self):
        self.assertEqual(TODO_ITEMS, self.report["todo_items"])
        self.assertEqual(123, self.report["content"]["source_block_count"])
        self.assertEqual(125, self.report["content"]["bedrock_block_count"])
        self.assertEqual(8, self.report["content"]["source_block_entity_count"])
        self.assertEqual(40, self.report["content"]["source_recipe_count"])
        self.assertEqual(138, self.report["content"]["source_loot_table_count"])
        self.assertEqual(314, self.report["structures"]["source_template_count"])

    def test_report_closes_content_and_dimension_gaps(self):
        content = self.report["content"]
        self.assertEqual([], content["missing_source_loot_tables"])
        self.assertEqual([], content["recipe_mismatches"])
        self.assertIn("polaroid", content["recipe_adapters"])
        self.assertEqual([], content["item_behavior"]["missing_items"])
        self.assertEqual([], content["item_behavior"]["mismatches"])
        self.assertEqual(12, len(content["item_behavior"]["record_items"]))
        self.assertEqual("Go away", content["advancement_titles"]["can_someone_hear_me"])
        self.assertEqual(
            "Look at the bigger picture",
            content["advancement_titles"]["polaroid_craft"],
        )
        self.assertEqual(13, self.report["dimensions"]["policy_count"])
        self.assertEqual(1, self.report["portals"]["cooldown_ticks"])
        self.assertTrue(self.report["portals"]["runtime_living_sweep"])
        self.assertTrue(
            all(
                adapter["hook_present"]
                for adapter in content["advancement_trigger_adapters"].values()
            )
        )
        self.assertIn("devmode [code]", content["commands"]["java_root_commands"])
        self.assertIn(
            "thebrokenscript:can_be_used_for_void_flora",
            content["tag_adapters"],
        )

    def test_vanilla_only_loot_outputs_are_explicit_bedrock_adapters(self):
        adapters = self.report["content"]["loot_adapter_tables"]
        self.assertEqual(
            "minecraft:cobblestone_stairs -> thebrokenscript:sideways_cobblestone_stairs",
            adapters["sideways_cobblestone_stairs"],
        )
        self.assertEqual(
            "minecraft:oak_door -> thebrokenscript:ud_oak_door",
            adapters["ud_oak_door"],
        )

    def test_validator_rejects_a_reintroduced_missing_source_loot_table(self):
        mutated = copy.deepcopy(self.report)
        mutated["content"]["missing_source_loot_tables"] = [
            "thebrokenscript:blocks/example"
        ]
        errors = module.validate_report(mutated)
        self.assertTrue(any("missing source loot" in error for error in errors))

    def test_validator_rejects_item_metadata_drift(self):
        mutated = copy.deepcopy(self.report)
        mutated["content"]["item_behavior"]["mismatches"] = [
            "record_14: minecraft:record duration drift"
        ]
        errors = module.validate_report(mutated)
        self.assertTrue(any("item behavior contract" in error for error in errors))

    def test_validator_rejects_missing_advancement_adapter_evidence(self):
        mutated = copy.deepcopy(self.report)
        mutated["content"]["advancement_trigger_adapters"] = {}
        errors = module.validate_report(mutated)
        self.assertTrue(any("advancement trigger adapters" in error for error in errors))


if __name__ == "__main__":
    unittest.main()
