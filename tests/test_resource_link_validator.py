import importlib.util
import json
import tempfile
import unittest
from pathlib import Path


MODULE_PATH = Path(__file__).resolve().parents[1] / "tools" / "validate_resource_links.py"


def load_validator():
    if not MODULE_PATH.is_file():
        return None
    spec = importlib.util.spec_from_file_location("validate_resource_links", MODULE_PATH)
    module = importlib.util.module_from_spec(spec)
    assert spec.loader is not None
    spec.loader.exec_module(module)
    return module.validate_resource_links


class ResourceLinkValidatorTests(unittest.TestCase):
    def make_resource_pack(self, root: Path) -> Path:
        rp = root / "TheBrokenScript_Bedrock_2_0" / "RP"
        (rp / "entity").mkdir(parents=True)
        (rp / "models" / "entity").mkdir(parents=True)
        (rp / "animations").mkdir(parents=True)
        (rp / "animation_controllers").mkdir(parents=True)
        (rp / "render_controllers").mkdir(parents=True)

        (rp / "models" / "entity" / "stalker.geo.json").write_text(json.dumps({
            "format_version": "1.12.0",
            "minecraft:geometry": [{
                "description": {"identifier": "geometry.test_stalker"},
                "bones": [],
            }],
        }), encoding="utf-8")
        (rp / "animations" / "stalker.animation.json").write_text(json.dumps({
            "format_version": "1.8.0",
            "animations": {
                "animation.test_stalker.idle": {"loop": True},
            },
        }), encoding="utf-8")
        (rp / "animation_controllers" / "stalker.controller.json").write_text(json.dumps({
            "format_version": "1.10.0",
            "animation_controllers": {
                "controller.animation.test_stalker.state": {
                    "initial_state": "default",
                    "states": {"default": {}},
                },
            },
        }), encoding="utf-8")
        (rp / "render_controllers" / "stalker.render.json").write_text(json.dumps({
            "format_version": "1.8.0",
            "render_controllers": {
                "controller.render.test_stalker": {
                    "geometry": "Geometry.default",
                    "materials": [{"*": "Material.default"}],
                    "textures": ["Texture.default"],
                },
            },
        }), encoding="utf-8")
        (rp / "entity" / "stalker.entity.json").write_text(json.dumps({
            "format_version": "1.10.0",
            "minecraft:client_entity": {
                "description": {
                    "identifier": "tbs:test_stalker",
                    "geometry": {"default": "geometry.test_stalker"},
                    "animations": {
                        "idle": "animation.test_stalker.idle",
                        "state": "controller.animation.test_stalker.state",
                    },
                    "render_controllers": ["controller.render.test_stalker"],
                },
            },
        }), encoding="utf-8")
        return rp

    def validate(self, root: Path):
        validator = load_validator()
        self.assertIsNotNone(
            validator,
            "tools/validate_resource_links.py must provide validate_resource_links(root)",
        )
        return validator(root)

    def test_valid_custom_client_entity_links_pass(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            self.make_resource_pack(root)
            result = self.validate(root)
            self.assertTrue(result["ok"], result["errors"])
            self.assertEqual(result["errors"], [])

    def test_missing_geometry_reference_is_error(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            rp = self.make_resource_pack(root)
            (rp / "models" / "entity" / "stalker.geo.json").unlink()
            result = self.validate(root)
            self.assertTrue(any("geometry.test_stalker" in error for error in result["errors"]))

    def test_missing_animation_reference_is_error(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            rp = self.make_resource_pack(root)
            (rp / "animations" / "stalker.animation.json").unlink()
            result = self.validate(root)
            self.assertTrue(any("animation.test_stalker.idle" in error for error in result["errors"]))

    def test_missing_animation_controller_reference_is_error(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            rp = self.make_resource_pack(root)
            (rp / "animation_controllers" / "stalker.controller.json").unlink()
            result = self.validate(root)
            self.assertTrue(any("controller.animation.test_stalker.state" in error for error in result["errors"]))

    def test_missing_render_controller_reference_is_error(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            rp = self.make_resource_pack(root)
            (rp / "render_controllers" / "stalker.render.json").unlink()
            result = self.validate(root)
            self.assertTrue(any("controller.render.test_stalker" in error for error in result["errors"]))

    def test_custom_attachable_can_use_vanilla_item_default_render_controller(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            rp = self.make_resource_pack(root)
            attachables = rp / "attachables"
            attachables.mkdir(parents=True)
            (attachables / "flashlight.json").write_text(json.dumps({
                "format_version": "1.10.0",
                "minecraft:attachable": {
                    "description": {
                        "identifier": "tbs:flashlight",
                        "render_controllers": ["controller.render.item_default"],
                    },
                },
            }), encoding="utf-8")
            result = self.validate(root)
            self.assertFalse(
                any("controller.render.item_default" in error for error in result["errors"]),
                result["errors"],
            )

    def test_vanilla_client_entity_links_can_use_base_pack(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            rp = root / "TheBrokenScript_Bedrock_2_0" / "RP"
            (rp / "entity").mkdir(parents=True)
            (rp / "entity" / "cat.entity.json").write_text(json.dumps({
                "format_version": "1.10.0",
                "minecraft:client_entity": {
                    "description": {
                        "identifier": "minecraft:cat",
                        "geometry": {"default": "geometry.cat"},
                        "animations": {"move": "animation.cat.move"},
                        "render_controllers": ["controller.render.cat"],
                    },
                },
            }), encoding="utf-8")
            result = self.validate(root)
            self.assertTrue(result["ok"], result["errors"])


if __name__ == "__main__":
    unittest.main()
