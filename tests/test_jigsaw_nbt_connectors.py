from __future__ import annotations

import gzip
import importlib.util
import json
import struct
import sys
import tempfile
import unittest
from pathlib import Path

MODULE_PATH = Path(__file__).resolve().parents[1] / "tools/validate_jigsaw_nbt_connectors.py"
spec = importlib.util.spec_from_file_location("validate_jigsaw_nbt_connectors", MODULE_PATH)
module = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = module
assert spec.loader is not None
spec.loader.exec_module(module)


def _name(value: str) -> bytes:
    encoded = value.encode("utf-8")
    return struct.pack(">H", len(encoded)) + encoded


def _string_tag(name: str, value: str) -> bytes:
    encoded = value.encode("utf-8")
    return b"\x08" + _name(name) + struct.pack(">H", len(encoded)) + encoded


def _int_tag(name: str, value: int) -> bytes:
    return b"\x03" + _name(name) + struct.pack(">i", value)


def _compound_tag(name: str, payload: bytes) -> bytes:
    return b"\x0a" + _name(name) + payload + b"\x00"


def _list_tag(name: str, child_type: int, values: list[bytes]) -> bytes:
    return b"\x09" + _name(name) + bytes([child_type]) + struct.pack(">i", len(values)) + b"".join(values)


def structure_nbt(*, name: str, pool: str, target: str) -> bytes:
    palette_entry = _string_tag("Name", "minecraft:jigsaw") + b"\x00"
    block_nbt = (
        _string_tag("name", name)
        + _string_tag("pool", pool)
        + _string_tag("target", target)
        + _string_tag("final_state", "minecraft:air")
    )
    block = (
        _int_tag("state", 0)
        + _list_tag(
            "pos",
            3,
            [struct.pack(">i", 0), struct.pack(">i", 0), struct.pack(">i", 0)],
        )
        + _compound_tag("nbt", block_nbt)
        + b"\x00"
    )
    root_payload = (
        _list_tag("palette", 10, [palette_entry])
        + _list_tag("blocks", 10, [block])
        + b"\x00"
    )
    return gzip.compress(b"\x0a\x00\x00" + root_payload)


def write_json(path: Path, value: dict) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value), encoding="utf-8")


def write_template(bp: Path, template_id: str, data: bytes) -> None:
    namespace, relative = template_id.split(":", 1)
    path = bp / "structures" / namespace / f"{relative}.nbt"
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_bytes(data)


def write_pool(bp: Path, pool_id: str, locations: list[str]) -> None:
    write_json(
        bp / "worldgen/template_pools" / f"{pool_id.split(':', 1)[1]}.json",
        {
            "format_version": "1.21.20",
            "minecraft:template_pool": {
                "description": {"identifier": pool_id},
                "fallback": "minecraft:empty",
                "elements": [
                    {
                        "element": {
                            "element_type": "minecraft:single_pool_element",
                            "location": location,
                            "projection": "rigid",
                        },
                        "weight": 1,
                    }
                    for location in locations
                ],
            },
        },
    )


def build_valid_pack(root: Path) -> Path:
    bp = root / "BP"
    root_id = "thebrokenscript:shaft/shaft_root"
    hall_id = "thebrokenscript:shaft/shaft_hall"
    write_template(
        bp,
        root_id,
        structure_nbt(
            name="thebrokenscript:shaft_root",
            pool="thebrokenscript:hallway",
            target="thebrokenscript:hallway",
        ),
    )
    write_template(
        bp,
        hall_id,
        structure_nbt(
            name="thebrokenscript:hallway",
            pool="minecraft:empty",
            target="minecraft:empty",
        ),
    )
    write_pool(bp, "thebrokenscript:shaft_root", [root_id])
    write_pool(bp, "thebrokenscript:hallway", [hall_id])
    write_json(
        bp / "worldgen/structures/shaft.json",
        {
            "format_version": "1.21.20",
            "minecraft:jigsaw": {
                "description": {"identifier": "thebrokenscript:shaft"},
                "start_pool": "thebrokenscript:shaft_root",
                "start_jigsaw_name": "thebrokenscript:shaft_root",
            },
        },
    )
    return bp


class JigsawNbtConnectorTests(unittest.TestCase):
    def test_valid_connector_graph_passes(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            result = module.validate_pack(bp)
            self.assertTrue(result.ok, result.errors)
            self.assertEqual(2, result.templates_checked)
            self.assertEqual(2, result.connectors_checked)

    def test_unresolved_connector_pool_is_reported(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            write_template(
                bp,
                "thebrokenscript:shaft/shaft_root",
                structure_nbt(
                    name="thebrokenscript:shaft_root",
                    pool="thebrokenscript:missing",
                    target="thebrokenscript:hallway",
                ),
            )
            result = module.validate_pack(bp)
            self.assertTrue(any("unresolved Jigsaw pool" in error for error in result.errors))

    def test_target_must_match_a_connector_name_in_pool(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            write_template(
                bp,
                "thebrokenscript:shaft/shaft_root",
                structure_nbt(
                    name="thebrokenscript:shaft_root",
                    pool="thebrokenscript:hallway",
                    target="thebrokenscript:not_a_hallway",
                ),
            )
            result = module.validate_pack(bp)
            self.assertTrue(any("cannot match any Jigsaw name" in error for error in result.errors))

    def test_start_jigsaw_name_must_exist_in_start_pool(self):
        with tempfile.TemporaryDirectory() as temp:
            bp = build_valid_pack(Path(temp))
            path = bp / "worldgen/structures/shaft.json"
            data = json.loads(path.read_text(encoding="utf-8"))
            data["minecraft:jigsaw"]["start_jigsaw_name"] = "thebrokenscript:missing_start"
            write_json(path, data)
            result = module.validate_pack(bp)
            self.assertTrue(any("start_jigsaw_name" in error for error in result.errors))


if __name__ == "__main__":
    unittest.main()
