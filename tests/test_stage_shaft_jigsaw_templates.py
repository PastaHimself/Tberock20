from __future__ import annotations

import importlib.util
import tempfile
import sys
import unittest
from pathlib import Path

MODULE_PATH = Path(__file__).resolve().parents[1] / "tools/stage_shaft_jigsaw_templates.py"
spec = importlib.util.spec_from_file_location("stage_shaft_jigsaw_templates", MODULE_PATH)
module = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = module
assert spec.loader is not None
spec.loader.exec_module(module)


class StageShaftTemplatesTests(unittest.TestCase):
    def test_stage_and_check_are_byte_exact(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            source = root / "source"
            target = root / "target"
            source.mkdir()
            for index, name in enumerate(module.SHAFT_TEMPLATES):
                (source / name).write_bytes(b"nbt" + bytes([index]))

            staged = module.stage_templates(source, target)
            self.assertTrue(staged.ok, staged.messages)
            checked = module.check_templates(source, target)
            self.assertTrue(checked.ok, checked.messages)

            (target / module.SHAFT_TEMPLATES[0]).write_bytes(b"changed")
            checked = module.check_templates(source, target)
            self.assertFalse(checked.ok)
            self.assertTrue(any("differs from source" in message for message in checked.messages))

    def test_missing_authoritative_source_fails_without_partial_copy(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            source = root / "source"
            target = root / "target"
            source.mkdir()
            for name in module.SHAFT_TEMPLATES[:-1]:
                (source / name).write_bytes(b"nbt")

            result = module.stage_templates(source, target)
            self.assertFalse(result.ok)
            self.assertFalse(target.exists())


if __name__ == "__main__":
    unittest.main()
