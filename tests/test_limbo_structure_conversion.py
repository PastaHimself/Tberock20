import re
import sys
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "tools"))

from convert_limbo_structures import (  # noqa: E402
    TEMPLATES,
    convert_structure,
    extract_runtime_metadata,
)
from validate_jigsaw_nbt_connectors import load_java_nbt  # noqa: E402
from validate_mcstructures import LittleEndianNBTReader, validate_mcstructure_bytes  # noqa: E402


EXPECTED_SIZES = {
    "limbo_caveoutpost": [48, 44, 47],
    "limbo_distastefulquandary": [18, 14, 17],
    "limbo_happyfarm": [19, 15, 23],
    "limbo_house": [11, 7, 11],
    "limbo_sanctuary": [23, 40, 17],
    "limbo_somethingoldsomethingnew": [24, 23, 26],
    "limbo_thewrongdirection": [21, 13, 10],
    "limbo_towerbaseright": [62, 61, 39],
    "limbo_treehouse": [39, 34, 27],
}


class LimboStructureConversionTests(unittest.TestCase):
    def test_every_limbo_source_template_converts_with_its_original_extent(self):
        self.assertEqual(set(TEMPLATES), set(EXPECTED_SIZES))
        source_root = ROOT / "source_extracted/data/thebrokenscript/structure"
        for name, expected_size in EXPECTED_SIZES.items():
            with self.subTest(name=name):
                payload = convert_structure(source_root / f"{name}.nbt")
                validated = validate_mcstructure_bytes(payload)
                self.assertEqual(validated["size"], expected_size)
                self.assertGreater(validated["non_air_blocks"], 0)

                root = LittleEndianNBTReader(payload).read_root()
                palette = root["structure"]["palette"]["default"]["block_palette"]
                names = [entry["name"] for entry in palette]
                self.assertTrue(all(block.startswith(("minecraft:", "thebrokenscript:")) for block in names))
                self.assertTrue({"minecraft:air", "minecraft:cave_air", "minecraft:structure_void"}.isdisjoint(names))
                self.assertNotIn("minecraft:oak_door", names)
                self.assertNotIn("minecraft:wall_torch", names)
                self.assertEqual(load_java_nbt(source_root / f"{name}.nbt")["entities"], [])

    def test_converted_vanilla_block_ids_exist_in_the_pinned_bedrock_catalog(self):
        catalog = (
            ROOT / "node_modules/@minecraft/vanilla-data/lib/mojang-block.d.ts"
        ).read_text(encoding="utf-8")
        vanilla_ids = set(re.findall(r'= "(minecraft:[^"]+)"', catalog))
        state_types = {
            alias: set(re.findall(r"'([^']+)'", keys))
            for alias, keys in re.findall(
                r"export type (\w+States) = Pick<BlockStateSuperset, ([^;]+)>;",
                catalog,
            )
        }
        state_aliases = dict(re.findall(r"'(minecraft:[^']+)': (\w+States);", catalog))
        state_value_types = dict(
            re.findall(r"\['([^']+)'\]\?: (boolean|number|string);", catalog)
        )
        source_root = ROOT / "source_extracted/data/thebrokenscript/structure"
        converted_ids = set()
        for name in TEMPLATES:
            root = LittleEndianNBTReader(
                convert_structure(source_root / f"{name}.nbt")
            ).read_root()
            palette = root["structure"]["palette"]["default"]["block_palette"]
            converted_ids.update(
                entry["name"] for entry in palette if entry["name"].startswith("minecraft:")
            )
            for entry in palette:
                block_id = entry["name"]
                states = entry["states"]
                if not states or not block_id.startswith("minecraft:"):
                    continue
                alias = state_aliases[block_id]
                self.assertEqual(set(states) - state_types[alias], set(), block_id)
                for state_name, value in states.items():
                    expected = state_value_types[state_name]
                    if expected == "string":
                        self.assertIsInstance(value, str, f"{block_id}:{state_name}")
                    else:
                        self.assertIsInstance(value, int, f"{block_id}:{state_name}")
        self.assertEqual(converted_ids - vanilla_ids, set())

    def test_java_permutations_are_translated_to_bedrock_states(self):
        source_root = ROOT / "source_extracted/data/thebrokenscript/structure"

        house = LittleEndianNBTReader(convert_structure(source_root / "limbo_house.nbt")).read_root()
        house_palette = house["structure"]["palette"]["default"]["block_palette"]
        house_entries = {(entry["name"], tuple(sorted(entry["states"].items()))) for entry in house_palette}
        self.assertIn(("minecraft:spruce_log", (("pillar_axis", "x"),)), house_entries)
        self.assertIn(("minecraft:candle", (("candles", 2), ("lit", 1))), house_entries)
        self.assertIn(
            ("minecraft:spruce_standing_sign", (("ground_sign_direction", 6),)),
            house_entries,
        )

        cave = LittleEndianNBTReader(convert_structure(source_root / "limbo_caveoutpost.nbt")).read_root()
        cave_palette = cave["structure"]["palette"]["default"]["block_palette"]
        cave_entries = {(entry["name"], tuple(sorted(entry["states"].items()))) for entry in cave_palette}
        self.assertIn(
            (
                "minecraft:wooden_door",
                (
                    ("door_hinge_bit", 1),
                    ("minecraft:cardinal_direction", "east"),
                    ("open_bit", 0),
                    ("upper_block_bit", 0),
                ),
            ),
            cave_entries,
        )
        self.assertIn(
            ("minecraft:torch", (("torch_facing_direction", "north"),)),
            cave_entries,
        )

        sanctuary = LittleEndianNBTReader(convert_structure(source_root / "limbo_sanctuary.nbt")).read_root()
        sanctuary_palette = sanctuary["structure"]["palette"]["default"]["block_palette"]
        sanctuary_names = {entry["name"] for entry in sanctuary_palette}
        self.assertIn("minecraft:birch_double_slab", sanctuary_names)
        self.assertIn("minecraft:oak_double_slab", sanctuary_names)

        tower = LittleEndianNBTReader(convert_structure(source_root / "limbo_towerbaseright.nbt")).read_root()
        tower_palette = tower["structure"]["palette"]["default"]["block_palette"]
        tower_entries = {(entry["name"], tuple(sorted(entry["states"].items()))) for entry in tower_palette}
        self.assertIn(
            (
                "minecraft:bed",
                (("direction", 0), ("head_piece_bit", 0), ("occupied_bit", 0)),
            ),
            tower_entries,
        )

    def test_lore_bearing_block_entities_are_extracted_for_script_api_restoration(self):
        source_root = ROOT / "source_extracted/data/thebrokenscript/structure"
        cave = extract_runtime_metadata(source_root / "limbo_caveoutpost.nbt")
        self.assertEqual(len(cave["signs"]), 5)
        self.assertEqual(cave["signs"][0]["text"], "Deeper into the\npeace inside\nthat weak\nmind of yours.")
        self.assertEqual(len(cave["containers"]), 1)
        self.assertEqual(len(cave["containers"][0]["items"]), 23)
        self.assertEqual(len(cave["records"]), 2)
        self.assertEqual(cave["records"][0]["typeId"], "minecraft:music_disc_cat")

        treehouse = extract_runtime_metadata(source_root / "limbo_treehouse.nbt")
        books = [
            item
            for container in treehouse["containers"]
            for item in container["items"]
            if item["typeId"] == "minecraft:writable_book"
        ]
        seven = next(item for item in books if item.get("nameTag") == "Seven")
        self.assertTrue(seven["bookPages"][0].startswith("It's cold."))
        self.assertGreater(len(seven["bookPages"]), 5)

    def test_java_only_inventory_item_ids_are_mapped_to_bedrock_ids(self):
        source_root = ROOT / "source_extracted/data/thebrokenscript/structure"
        item_ids = {
            item["typeId"]
            for name in TEMPLATES
            for container in extract_runtime_metadata(source_root / f"{name}.nbt")["containers"]
            for item in container["items"]
        }
        catalog = (
            ROOT / "node_modules/@minecraft/vanilla-data/lib/mojang-item.d.ts"
        ).read_text(encoding="utf-8")
        vanilla_ids = set(re.findall(r'= "(minecraft:[^"]+)"', catalog))
        self.assertEqual(
            {item_id for item_id in item_ids if item_id.startswith("minecraft:")} - vanilla_ids,
            set(),
        )
        self.assertTrue({
            "minecraft:bed",
            "minecraft:banner",
            "minecraft:empty_map",
            "minecraft:frame",
            "minecraft:red_nether_brick",
            "minecraft:silver_glazed_terracotta",
            "minecraft:trapdoor",
        }.issubset(item_ids))
        self.assertTrue({
            "minecraft:orange_bed",
            "minecraft:yellow_bed",
            "minecraft:light_blue_banner",
            "minecraft:map",
            "minecraft:item_frame",
            "minecraft:red_nether_bricks",
            "minecraft:light_gray_glazed_terracotta",
            "minecraft:oak_trapdoor",
        }.isdisjoint(item_ids))


if __name__ == "__main__":
    unittest.main()
