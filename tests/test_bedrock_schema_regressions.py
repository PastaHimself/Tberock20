import json
import re
import unittest
from pathlib import Path
from typing import Any, Iterable


ROOT = Path(__file__).resolve().parents[1]
ADDON = ROOT / "TheBrokenScript_Bedrock_2_0"
BP = ADDON / "BP"
RP = ADDON / "RP"
GEOMETRY_REFERENCE_RE = re.compile(r"^geometry\.[A-Za-z_][A-Za-z0-9_.]*$")
ANIMATION_IDENTIFIER_RE = re.compile(r"^animation\.[A-Za-z0-9_.-]+$")
BONE_IDENTIFIER_RE = re.compile(r"^[A-Za-z][A-Za-z0-9_.-]*$")
JAVA_CUSTOM_INSTRUCTION_RE = re.compile(r"^[A-Za-z_][A-Za-z0-9_]*;$")


def read_json(path: Path) -> Any:
    return json.loads(path.read_text(encoding="utf-8-sig"))


def version_tuple(value: Any) -> tuple[int, ...]:
    if not isinstance(value, str):
        return ()
    try:
        return tuple(int(part) for part in value.split("."))
    except ValueError:
        return ()


def component_sets(block: dict[str, Any]) -> Iterable[tuple[str, dict[str, Any]]]:
    components = block.get("components")
    if isinstance(components, dict):
        yield "components", components
    for index, permutation in enumerate(block.get("permutations", [])):
        if not isinstance(permutation, dict):
            continue
        components = permutation.get("components")
        if isinstance(components, dict):
            yield f"permutations[{index}].components", components


def walk(value: Any) -> Iterable[Any]:
    yield value
    if isinstance(value, dict):
        for child in value.values():
            yield from walk(child)
    elif isinstance(value, list):
        for child in value:
            yield from walk(child)


class BedrockSchemaRegressionTests(unittest.TestCase):
    def test_all_animation_documents_and_bones_are_bedrock_schema_safe(self):
        geometry_bones = set()
        geometry_issues = []
        for path in sorted((RP / "models").rglob("*.json")):
            for geometry_index, geometry in enumerate(
                read_json(path).get("minecraft:geometry", []),
            ):
                if not isinstance(geometry, dict):
                    continue
                bones = [
                    bone for bone in geometry.get("bones", [])
                    if isinstance(bone, dict)
                ]
                names = [bone.get("name") for bone in bones]
                if len(names) != len(set(names)):
                    geometry_issues.append(
                        f"{path.name}:geometry[{geometry_index}] has duplicate bones",
                    )
                local_names = set(names)
                for bone in bones:
                    name = bone.get("name")
                    if not isinstance(name, str) or not BONE_IDENTIFIER_RE.fullmatch(name):
                        geometry_issues.append(f"{path.name}: invalid bone {name!r}")
                        continue
                    geometry_bones.add(name)
                    parent = bone.get("parent")
                    if parent is not None and (
                        not isinstance(parent, str)
                        or not BONE_IDENTIFIER_RE.fullmatch(parent)
                        or parent not in local_names
                    ):
                        geometry_issues.append(
                            f"{path.name}: {name!r} has invalid parent {parent!r}",
                        )

        animation_issues = []
        for path in sorted((RP / "animations").glob("*.json")):
            document = read_json(path)
            unexpected = set(document) - {"format_version", "animations"}
            if unexpected:
                animation_issues.append(
                    f"{path.name}: unexpected top-level keys {sorted(unexpected)}",
                )
            animations = document.get("animations")
            if not isinstance(animations, dict) or not animations:
                animation_issues.append(f"{path.name}: empty or missing animations")
                continue
            for animation_name, animation in animations.items():
                if not ANIMATION_IDENTIFIER_RE.fullmatch(animation_name):
                    animation_issues.append(
                        f"{path.name}: invalid animation ID {animation_name!r}",
                    )
                if not isinstance(animation, dict):
                    continue
                bones = animation.get("bones")
                if bones == {}:
                    animation_issues.append(f"{path.name}:{animation_name}: empty bones")
                if isinstance(bones, dict):
                    for bone_name in bones:
                        if not BONE_IDENTIFIER_RE.fullmatch(bone_name):
                            animation_issues.append(
                                f"{path.name}:{animation_name}: invalid bone {bone_name!r}",
                            )
                        elif bone_name not in geometry_bones:
                            animation_issues.append(
                                f"{path.name}:{animation_name}: unresolved bone {bone_name!r}",
                            )
                timeline = animation.get("timeline")
                if isinstance(timeline, dict):
                    for payload in timeline.values():
                        entries = payload if isinstance(payload, list) else [payload]
                        for entry in entries:
                            if (
                                isinstance(entry, str)
                                and JAVA_CUSTOM_INSTRUCTION_RE.fullmatch(entry.strip())
                            ):
                                animation_issues.append(
                                    f"{path.name}:{animation_name}: Java callback {entry!r}",
                                )

            for value in walk(document):
                if isinstance(value, dict):
                    invalid_fields = {"vector", "easing", "easingArgs"} & set(value)
                    if invalid_fields:
                        animation_issues.append(
                            f"{path.name}: GeckoLib fields {sorted(invalid_fields)}",
                        )
                        break

        self.assertEqual(geometry_issues, [])
        self.assertEqual(animation_issues, [])

    def test_server_biomes_use_1_21_110_or_newer(self):
        outdated = []
        for path in sorted((BP / "biomes").glob("*.json")):
            version = version_tuple(read_json(path).get("format_version"))
            if version < (1, 21, 110):
                outdated.append(f"{path.name}: {'.'.join(map(str, version)) or 'missing'}")
        self.assertEqual(outdated, [])

    def test_server_biomes_use_the_current_climate_component(self):
        legacy = []
        for path in sorted((BP / "biomes").glob("*.json")):
            components = read_json(path).get("minecraft:biome", {}).get("components", {})
            for name in ("minecraft:temperature", "minecraft:downfall"):
                if name in components:
                    legacy.append(f"{path.name}: {name}")
            self.assertIsInstance(components.get("minecraft:climate"), dict, path.name)
        self.assertEqual(legacy, [])

    def test_materialized_blocks_have_geometry_and_flattened_custom_components(self):
        missing_geometry = []
        deprecated_custom_components = []
        for path in sorted((BP / "blocks").glob("*.json")):
            block = read_json(path).get("minecraft:block", {})
            if not isinstance(block, dict):
                continue
            for location, components in component_sets(block):
                if "minecraft:material_instances" in components and "minecraft:geometry" not in components:
                    missing_geometry.append(f"{path.name}:{location}")
                if "minecraft:custom_components" in components:
                    deprecated_custom_components.append(f"{path.name}:{location}")
        self.assertEqual(missing_geometry, [])
        self.assertEqual(deprecated_custom_components, [])

    def test_modern_recipes_define_an_unlock_condition(self):
        missing = []
        for path in sorted((BP / "recipes").glob("*.json")):
            document = read_json(path)
            if version_tuple(document.get("format_version")) < (1, 20, 10):
                continue
            recipe = next(
                (value for key, value in document.items() if key.startswith("minecraft:recipe_")),
                None,
            )
            if isinstance(recipe, dict) and "unlock" not in recipe:
                missing.append(path.name)
        self.assertEqual(missing, [])

    def test_item_icons_resolve_through_the_resource_pack_atlas(self):
        atlas = read_json(RP / "item_texture.json").get("texture_data", {})
        missing = []
        for path in sorted((BP / "items").glob("*.json")):
            components = read_json(path).get("minecraft:item", {}).get("components", {})
            icon = components.get("minecraft:icon") if isinstance(components, dict) else None
            if isinstance(icon, dict):
                icon = icon.get("textures", {}).get("default")
            if isinstance(icon, str) and icon not in atlas:
                missing.append(f"{path.name}: {icon}")
        self.assertEqual(missing, [])

    def test_animation_keyframes_do_not_contain_geckolib_vector_wrappers(self):
        wrapped = []
        path = RP / "animations" / "revuxor.animation.json"
        document = read_json(path)
        for value in walk(document):
            if (
                isinstance(value, dict)
                and "vector" in value
                and set(value).issubset({"vector", "easing"})
            ):
                wrapped.append(path.name)
                break
        self.assertEqual(wrapped, [])

        animations = document["animations"]
        stepped = animations["animation.thebrokenscript.revuxor.idle2"]["bones"][
            "RightArm"
        ]["rotation"]
        self.assertEqual(
            stepped["0.5"],
            {"pre": [0, 0, 0], "post": [0, 0, 22.5]},
        )
        self.assertEqual(
            stepped["1.0"],
            {"pre": [0, 0, 22.5], "post": [0, 0, 45]},
        )

        smoothed = animations["animation.thebrokenscript.revuxor.idle1"]["bones"][
            "RightArm"
        ]["rotation"]
        self.assertAlmostEqual(smoothed["0.125"][2], 0.0951505844)
        self.assertEqual(smoothed["0.5"], [0, 0, 1.25])

    def test_custom_block_components_are_registered_once_during_startup(self):
        custom_ids = set()
        for path in sorted((BP / "blocks").glob("*.json")):
            block = read_json(path).get("minecraft:block", {})
            if not isinstance(block, dict):
                continue
            for _, components in component_sets(block):
                custom_ids.update(
                    name for name in components
                    if name.startswith("thebrokenscript:")
                )

        script_path = BP / "scripts" / "systems" / "custom_blocks.js"
        script = script_path.read_text(encoding="utf-8-sig")
        registrations = re.findall(r'register\("([^"]+)"', script)
        main = (BP / "scripts" / "main.js").read_text(encoding="utf-8-sig")

        self.assertTrue(custom_ids, "Expected custom component IDs in block JSON")
        self.assertTrue(custom_ids.issubset(registrations))
        self.assertEqual(len(registrations), len(set(registrations)))
        self.assertTrue(all(":" in name for name in registrations))
        self.assertNotRegex(script, r'import\s*\{[^}]*\bblockComponentRegistry\b')
        self.assertNotRegex(script, r"\bblock\.setDynamicProperty\(")
        self.assertIn(
            '@param {import("@minecraft/server").BlockComponentRegistry}',
            script,
        )
        self.assertIn(
            '@param {import("@minecraft/server").BlockCustomComponent}',
            script,
        )
        self.assertIn("onStepOn(ev)", script)
        self.assertNotIn("onEntityStepOn", script)
        self.assertRegex(
            main,
            r"function onStartup\(event\)\s*\{[^}]*"
            r"initCustomBlocks\(event\.blockComponentRegistry\)",
        )
        world_load = main.partition("function onWorldLoad()")[2].partition(
            "system.beforeEvents.startup.subscribe",
        )[0]
        self.assertNotIn("initCustomBlocks", world_load)

    def test_client_geometry_references_are_literal_safe_and_resolve(self):
        definitions = set()
        for path in sorted((RP / "models").rglob("*.json")):
            for geometry in read_json(path).get("minecraft:geometry", []):
                if not isinstance(geometry, dict):
                    continue
                identifier = geometry.get("description", {}).get("identifier")
                if isinstance(identifier, str):
                    definitions.add(identifier)

        invalid = []
        unresolved = []
        for path in sorted((RP / "entity").glob("*.json")):
            description = read_json(path).get("minecraft:client_entity", {}).get("description", {})
            for identifier in description.get("geometry", {}).values():
                if not isinstance(identifier, str):
                    continue
                if not GEOMETRY_REFERENCE_RE.fullmatch(identifier):
                    invalid.append(f"{path.name}: {identifier}")
                if identifier not in definitions:
                    unresolved.append(f"{path.name}: {identifier}")
        self.assertEqual(invalid, [])
        self.assertEqual(unresolved, [])


if __name__ == "__main__":
    unittest.main()
