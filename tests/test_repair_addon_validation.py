import json
import math
import tempfile
import unittest
from pathlib import Path

from tools.repair_addon_validation import (
    collapse_vector_wrappers,
    convert_geckolib_easing_keyframes,
    repair_animations,
    repair_biome_components,
    repair_bone_identifiers,
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

    def test_step_easing_on_pre_post_keyframe_is_preserved(self):
        channel = {
            "0.0": [1, 1, 1],
            "0.125": {
                "pre": [1, 0, 1],
                "post": [1, 0, 1],
                "easing": "step",
                "easingArgs": [2],
            },
        }

        self.assertEqual(
            convert_geckolib_easing_keyframes(channel),
            {
                "0.0": [1, 1, 1],
                "0.0625": {
                    "pre": [1, 1, 1],
                    "post": [1, 0.5, 1],
                },
                "0.125": {
                    "pre": [1, 0.5, 1],
                    "post": [1, 0, 1],
                },
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

    def test_bounce_easings_are_baked_into_bedrock_keyframes(self):
        ease_in = convert_geckolib_easing_keyframes({
            "0.0": [0, 0, 0],
            "1.0": {"vector": [0, 0, 10], "easing": "easeInBounce"},
        })
        ease_in_out = convert_geckolib_easing_keyframes({
            "0.0": [0, 0, 0],
            "1.0": {
                "vector": [0, 0, 10],
                "easing": "easeInOutBounce",
                "easingArgs": [0.5],
            },
        })

        self.assertEqual(ease_in["0.0"], [0, 0, 0])
        self.assertEqual(ease_in["1.0"], [0, 0, 10])
        self.assertAlmostEqual(ease_in["0.5"][2], 5.3125)
        self.assertAlmostEqual(ease_in_out["0.25"][2], 2.65625)
        self.assertAlmostEqual(ease_in_out["0.75"][2], 7.34375)
        serialized = json.dumps({"in": ease_in, "in_out": ease_in_out})
        self.assertNotIn('"vector"', serialized)
        self.assertNotIn('"easing"', serialized)
        self.assertNotIn('"easingArgs"', serialized)

    def test_additional_geckolib_easings_are_baked(self):
        cases = {
            "easeOutQuad": ("0.5", 7.5),
            "easeInSine": ("0.5", 10 * (1 - math.cos(math.pi / 4))),
            "easeInCubic": ("0.5", 1.25),
            "easeOutBounce": ("0.5", 4.6875),
            "easeInElastic": (
                "0.25",
                10 * (1 - math.cos(math.pi / 8) ** 3 * math.cos(math.pi / 4)),
            ),
        }

        for easing, (timestamp, expected) in cases.items():
            with self.subTest(easing=easing):
                converted = convert_geckolib_easing_keyframes({
                    "0.0": [0, 0, 0],
                    "1.0": {"vector": [0, 0, 10], "easing": easing},
                })
                self.assertAlmostEqual(converted[timestamp][2], expected)
                self.assertEqual(converted["1.0"], [0, 0, 10])
                serialized = json.dumps(converted)
                self.assertNotIn('"vector"', serialized)
                self.assertNotIn('"easing"', serialized)

    def test_linear_easing_uses_bedrocks_native_interpolation(self):
        self.assertEqual(
            convert_geckolib_easing_keyframes({
                "0.0": [0, 0, 0],
                "1.0": {"vector": [0, 0, 10], "easing": "linear"},
            }),
            {
                "0.0": [0, 0, 0],
                "1.0": [0, 0, 10],
            },
        )

    def test_animation_repairs_cover_bones_callbacks_metadata_and_empty_sections(self):
        with tempfile.TemporaryDirectory() as temp:
            rp = Path(temp) / "RP"
            geometry_path = rp / "models" / "entity" / "integrity_phase3.geo.json"
            animation_path = rp / "animations" / "integrity_phase3.animation.json"
            easing_path = rp / "animations" / "integrity_phase2.animation.json"
            empty_path = rp / "animations" / "chord_projectile.animation.json"

            write_json(geometry_path, {
                "format_version": "1.12.0",
                "minecraft:geometry": [{
                    "description": {"identifier": "geometry.Integrityphase3"},
                    "bones": [
                        {"name": "torso"},
                        {"name": "middle tendrils", "parent": "torso"},
                        {"name": "spine tendrils 2", "parent": "middle tendrils"},
                        {"name": "spine_tendrils_2", "parent": "middle tendrils"},
                    ],
                }],
            })
            write_json(animation_path, {
                "format_version": "1.10.0",
                "animations": {
                    "animation.thebrokenscript.integrity_phase3.attack": {
                        "bones": {
                            "middle tendrils": {"rotation": [0, 0, 0]},
                            "spine tendrils 2": {"rotation": [1, 2, 3]},
                            "spine_tendrils_2": {"rotation": [4, 5, 6]},
                        },
                        "timeline": {
                            "0.5": "ballin;",
                            "0.75": ["variable.flash = 1.0;", "aoesmall;"],
                        },
                    },
                    "animation.thebrokenscript.integrity_phase3.empty": {
                        "loop": True,
                        "bones": {},
                    },
                },
            })
            write_json(easing_path, {
                "format_version": "1.10.0",
                "geckolib_format_version": 2,
                "animations": {
                    "animation.thebrokenscript.integrity_phase2.crawl_idle": {
                        "bones": {
                            "torso": {
                                "rotation": {
                                    "0.0": [0, 0, 0],
                                    "1.0": {
                                        "vector": [0, 10, 0],
                                        "easing": "easeInBounce",
                                    },
                                },
                            },
                        },
                    },
                },
            })
            write_json(empty_path, {"format_version": "1.10.0", "animations": {}})
            original_geometry_text = geometry_path.read_text(encoding="utf-8")

            self.assertEqual(repair_bone_identifiers(rp), 6)
            self.assertEqual(repair_animations(rp), (3, 0, 0, 0))
            self.assertEqual(
                geometry_path.read_text(encoding="utf-8"),
                original_geometry_text
                .replace('"middle tendrils"', '"middle-tendrils"')
                .replace('"spine tendrils 2"', '"spine-tendrils-2"'),
            )

            geometry = read_json(geometry_path)["minecraft:geometry"][0]["bones"]
            self.assertEqual(
                [(bone["name"], bone.get("parent")) for bone in geometry],
                [
                    ("torso", None),
                    ("middle-tendrils", "torso"),
                    ("spine-tendrils-2", "middle-tendrils"),
                    ("spine_tendrils_2", "middle-tendrils"),
                ],
            )
            repaired = read_json(animation_path)["animations"]
            bones = repaired["animation.thebrokenscript.integrity_phase3.attack"]["bones"]
            self.assertEqual(set(bones), {
                "middle-tendrils", "spine-tendrils-2", "spine_tendrils_2",
            })
            self.assertEqual(
                repaired["animation.thebrokenscript.integrity_phase3.attack"]["timeline"],
                {"0.75": ["variable.flash = 1.0;"]},
            )
            self.assertNotIn(
                "bones",
                repaired["animation.thebrokenscript.integrity_phase3.empty"],
            )
            easing = read_json(easing_path)
            self.assertNotIn("geckolib_format_version", easing)
            easing_text = json.dumps(easing)
            self.assertNotIn('"vector"', easing_text)
            self.assertNotIn('"easing"', easing_text)
            self.assertFalse(empty_path.exists())

            first_pass_bytes = {
                path: path.read_bytes()
                for path in (geometry_path, animation_path, easing_path)
            }
            self.assertEqual(repair_bone_identifiers(rp), 0)
            self.assertEqual(repair_animations(rp), (2, 0, 0, 0))
            self.assertEqual(
                {path: path.read_bytes() for path in first_pass_bytes},
                first_pass_bytes,
            )

    def test_valid_animation_serialization_is_left_untouched(self):
        with tempfile.TemporaryDirectory() as temp:
            rp = Path(temp) / "RP"
            path = rp / "animations" / "already_valid.animation.json"
            path.parent.mkdir(parents=True)
            original = (
                '{"format_version":  "1.10.0", "animations":  '
                '{"animation.test.id":  {"loop":  true}}}'
            )
            path.write_text(original, encoding="utf-8")

            self.assertEqual(repair_animations(rp), (1, 0, 0, 0))
            self.assertEqual(path.read_text(encoding="utf-8"), original)

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
