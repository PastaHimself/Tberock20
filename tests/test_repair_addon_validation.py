import json
import tempfile
import unittest
from pathlib import Path

from tools.repair_addon_validation import (
    collapse_vector_wrappers,
    convert_geckolib_easing_keyframes,
    repair_biome_components,
    repair_block_components,
    repair_geometry_identifiers,
    repair_null_item_icon,
    repair_recipe_unlocks,
    update_format_versions,
)


def write_json(path: Path, value: object) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value), encoding="utf-8")


def read_json(path: Path) -> object:
    return json.loads(path.read_text(encoding="utf-8"))


class RepairAddonValidationTests(unittest.TestCase):
    def test_step_easing_is_preserved_with_discontinuous_bedrock_keyframes(self):
        channel = {
            "0.0": [0, 0, 0],
            "1.0": {"vector": [0, 0, 10], "easing": "step"},
        }

        self.assertEqual(
            convert_geckolib_easing_keyframes(channel),
            {
                "0.0": [0, 0, 0],
                "0.5": {"pre": [0, 0, 0], "post": [0, 0, 5]},
                "1.0": {"pre": [0, 0, 5], "post": [0, 0, 10]},
            },
        )

    def test_sine_easing_is_approximated_with_bedrock_linear_keyframes(self):
        channel = {
            "0.0": [0, 0, 0],
            "1.0": {"vector": [0, 0, 2], "easing": "easeInOutSine"},
        }

        converted = convert_geckolib_easing_keyframes(channel)

        self.assertEqual(len(converted), 9)
        self.assertEqual(converted["0.0"], [0, 0, 0])
        self.assertEqual(converted["0.5"], [0, 0, 1])
        self.assertEqual(converted["1.0"], [0, 0, 2])
        self.assertAlmostEqual(converted["0.125"][2], 0.0761204675)

    def test_constant_easing_wrapper_has_no_interpolation_to_preserve(self):
        self.assertEqual(
            convert_geckolib_easing_keyframes(
                {"vector": [1, -1, 1], "easing": "step"},
            ),
            [1, -1, 1],
        )

    def test_easing_wrappers_are_collapsed_only_when_explicitly_enabled(self):
        wrapped = {"1.0": {"vector": [1, 2, 3], "easing": "step"}}
        self.assertEqual(collapse_vector_wrappers(wrapped), wrapped)
        self.assertEqual(
            collapse_vector_wrappers(wrapped, include_easing=True),
            {"1.0": [1, 2, 3]},
        )

        supported_wrapper = {
            "1.0": {"vector": [1, 2, 3], "easing": "easeInBounce", "easingArgs": [0.2]}
        }
        self.assertEqual(
            collapse_vector_wrappers(supported_wrapper, include_easing=True),
            supported_wrapper,
        )

    def test_schema_repairs_are_idempotent(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            bp, rp = root / "BP", root / "RP"
            biome_path = bp / "biomes" / "void.json"
            block_path = bp / "blocks" / "marker.json"
            recipe_path = bp / "recipes" / "marker.json"
            item_path = bp / "items" / "null.json"
            entity_path = rp / "entity" / "rock.entity.json"
            model_path = rp / "models" / "entity" / "rock.geo.json"

            write_json(biome_path, {
                "format_version": "1.13.0",
                "minecraft:biome": {
                    "components": {
                        "minecraft:temperature": {"value": 0.5},
                        "minecraft:downfall": {"value": 0.0},
                    },
                },
            })
            write_json(block_path, {
                "format_version": "1.26.40",
                "minecraft:block": {
                    "components": {
                        "minecraft:material_instances": {"*": {"texture": "marker"}},
                        "minecraft:custom_components": ["test:marker"],
                    },
                },
            })
            write_json(recipe_path, {
                "format_version": "1.26.40",
                "minecraft:recipe_shapeless": {
                    "description": {"identifier": "test:marker"},
                    "ingredients": [{"item": "minecraft:stone"}],
                    "result": {"item": "minecraft:stone"},
                },
            })
            write_json(item_path, {
                "format_version": "1.26.40",
                "minecraft:item": {"components": {"minecraft:icon": "null"}},
            })
            write_json(entity_path, {"geometry": "geometry.BOULDER - Converted"})
            write_json(model_path, {"identifier": "geometry.BOULDER - Converted"})

            self.assertEqual(update_format_versions(bp, rp), 2)
            self.assertEqual(repair_biome_components(bp), 1)
            self.assertEqual(repair_block_components(bp), (1, 1))
            self.assertEqual(repair_recipe_unlocks(bp), 1)
            self.assertEqual(repair_null_item_icon(bp), 1)
            self.assertEqual(repair_geometry_identifiers(rp), 2)

            biome = read_json(biome_path)["minecraft:biome"]["components"]
            self.assertEqual(biome["minecraft:climate"], {"temperature": 0.5, "downfall": 0.0})
            block = read_json(block_path)["minecraft:block"]["components"]
            self.assertEqual(block["minecraft:geometry"], "minecraft:geometry.full_block")
            self.assertEqual(block["test:marker"], {})
            self.assertNotIn("minecraft:custom_components", block)
            recipe = read_json(recipe_path)["minecraft:recipe_shapeless"]
            self.assertEqual(recipe["unlock"], {"context": "AlwaysUnlocked"})
            item = read_json(item_path)["minecraft:item"]["components"]
            self.assertEqual(item["minecraft:icon"], "null_item")
            self.assertIn("geometry.tbs_boulder_converted", entity_path.read_text())
            self.assertIn("geometry.tbs_boulder_converted", model_path.read_text())

            self.assertEqual(update_format_versions(bp, rp), 0)
            self.assertEqual(repair_biome_components(bp), 0)
            self.assertEqual(repair_block_components(bp), (0, 0))
            self.assertEqual(repair_recipe_unlocks(bp), 0)
            self.assertEqual(repair_null_item_icon(bp), 0)
            self.assertEqual(repair_geometry_identifiers(rp), 0)


if __name__ == "__main__":
    unittest.main()
