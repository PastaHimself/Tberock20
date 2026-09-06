import json
import sys
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT))

from tools.validate_mcstructures import validate_mcstructure_bytes
from tools.convert_stage2_structures import convert_java_structure, serialize_mcstructure


class Stage2StructureConverterTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.audit = json.loads(
            (ROOT / "TheBrokenScript_Bedrock_2_0" / "STAGE2_GENERATOR_AUDIT.json").read_text(
                encoding="utf-8"
            )
        )
        cls.source_root = ROOT / "source_extracted" / "data" / "thebrokenscript" / "structure"

    def test_every_audited_stage2_template_converts_to_valid_mcstructure(self):
        for entry in self.audit["templates"]:
            with self.subTest(template=entry["id"]):
                converted = convert_java_structure(self.source_root / f"{entry['id']}.nbt")
                self.assertEqual(converted["size"], entry["size"])
                metadata = validate_mcstructure_bytes(serialize_mcstructure(converted))
                self.assertEqual(metadata["size"], entry["size"])
                self.assertGreater(metadata["non_air_blocks"], 0)
                self.assertEqual(
                    metadata["block_position_data_entries"],
                    entry["blockEntityCount"],
                )

    def test_pack_contains_one_valid_asset_for_every_audited_template(self):
        asset_root = (
            ROOT
            / "TheBrokenScript_Bedrock_2_0"
            / "BP"
            / "structures"
            / "thebrokenscript"
            / "stage2"
        )
        expected = {entry["id"] for entry in self.audit["templates"]}
        actual = {path.stem for path in asset_root.glob("*.mcstructure")}
        self.assertEqual(actual, expected)
        for template_id in sorted(expected):
            with self.subTest(template=template_id):
                metadata = validate_mcstructure_bytes(
                    (asset_root / f"{template_id}.mcstructure").read_bytes()
                )
                self.assertEqual(metadata["format_version"], 1)
                self.assertEqual(metadata["layers"], 2)
                self.assertGreater(metadata["non_air_blocks"], 0)

    def test_asset_audit_matches_every_generated_pack_asset(self):
        asset_root = (
            ROOT
            / "TheBrokenScript_Bedrock_2_0"
            / "BP"
            / "structures"
            / "thebrokenscript"
            / "stage2"
        )
        asset_audit = json.loads(
            (
                ROOT
                / "TheBrokenScript_Bedrock_2_0"
                / "STAGE2_TEMPLATE_ASSET_AUDIT.json"
            ).read_text(encoding="utf-8")
        )
        self.assertEqual(asset_audit["validatedAssetCount"], len(self.audit["templates"]))
        self.assertEqual(asset_audit["deferredTemplateCount"], 0)
        self.assertTrue(asset_audit["automaticRuntimePlacement"])
        self.assertEqual(
            {entry["id"] for entry in asset_audit["templates"]},
            {entry["id"] for entry in self.audit["templates"]},
        )

        for entry in asset_audit["templates"]:
            with self.subTest(template=entry["id"]):
                metadata = validate_mcstructure_bytes(
                    (
                        ROOT
                        / "TheBrokenScript_Bedrock_2_0"
                        / entry["bedrockPath"]
                    ).read_bytes()
                )
                self.assertEqual(metadata["format_version"], entry["bedrockFormatVersion"])
                self.assertEqual(metadata["size"], entry["bedrockSize"])
                self.assertEqual(
                    metadata["non_air_blocks"], entry["bedrockNonAirPrimaryBlocks"]
                )
                self.assertEqual(
                    metadata["block_position_data_entries"],
                    entry["bedrockBlockEntityCount"],
                )

    def test_converter_preserves_sign_data_at_bedrock_position_index(self):
        converted = convert_java_structure(self.source_root / "clanvoidnew2.nbt")
        position_data = converted["structure"]["palette"]["default"]["block_position_data"]

        # Bedrock's block_indices use ZYX order: z is the fastest-moving
        # coordinate, then y, then x. The first sign is at [1, 2, 6].
        self.assertEqual(
            position_data["134"]["block_entity_data"]["id"],
            "minecraft:sign",
        )
        self.assertIn(
            "IKNOWWHATYOUFEAR",
            position_data["134"]["block_entity_data"]["front_text"]["messages"][0],
        )

    def test_converter_maps_java_states_and_pack_surrogates(self):
        converted = convert_java_structure(self.source_root / "clanvoidnew2.nbt")
        palette = converted["structure"]["palette"]["default"]["block_palette"]
        names = {entry["name"] for entry in palette}
        self.assertIn("minecraft:wooden_door", names)
        self.assertIn("minecraft:wall_sign", names)
        self.assertNotIn("thebrokenscript:null", names)

        door_states = {
            tuple(sorted(entry["states"].items()))
            for entry in palette
            if entry["name"] == "minecraft:wooden_door"
        }
        self.assertIn(
            (
                ("door_hinge_bit", 1),
                ("minecraft:cardinal_direction", "west"),
                ("open_bit", 0),
                ("upper_block_bit", 0),
            ),
            door_states,
        )

        sign_states = {
            tuple(sorted(entry["states"].items()))
            for entry in palette
            if entry["name"] == "minecraft:wall_sign"
        }
        self.assertIn((("facing_direction", 2),), sign_states)

    def test_converter_uses_noop_indices_for_java_ignored_blocks(self):
        converted = convert_java_structure(self.source_root / "clanvoidnew2.nbt")
        primary = converted["structure"]["block_indices"][0]
        self.assertIn(-1, primary)
        self.assertEqual(len(primary), 16 * 6 * 16)

    def test_converter_adapts_java_inventory_stack_fields(self):
        converted = convert_java_structure(self.source_root / "clanvoidnew6.nbt")
        position_data = converted["structure"]["palette"]["default"]["block_position_data"]
        chest = next(
            entry["block_entity_data"]
            for entry in position_data.values()
            if entry["block_entity_data"]["id"] == "minecraft:chest"
        )

        item = chest["Items"][0]
        self.assertEqual(item["Name"], "minecraft:music_disc_13")
        self.assertEqual(item["Count"], 1)
        self.assertNotIn("id", item)
        self.assertNotIn("count", item)


if __name__ == "__main__":
    unittest.main()
