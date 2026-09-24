import importlib.util
import json
import tempfile
import unittest
from pathlib import Path


MODULE_PATH = Path(__file__).resolve().parents[1] / "tools" / "validate_source_map_release.py"


def load_validator_module():
    spec = importlib.util.spec_from_file_location("validate_source_map_release", MODULE_PATH)
    module = importlib.util.module_from_spec(spec)
    assert spec.loader is not None
    spec.loader.exec_module(module)
    return module


class SourceMapReleaseValidatorTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.validator = load_validator_module()

    def validate_rows(self, rows):
        with tempfile.TemporaryDirectory() as temp:
            source_map = Path(temp) / "SOURCE_MAP.json"
            source_map.write_text(json.dumps({"rows": rows}), encoding="utf-8")
            return self.validator.validate_source_map(source_map)

    def test_resolved_entries_pass(self):
        unresolved = self.validate_rows(
            [
                {
                    "source_id": "resolved.covered",
                    "status": "ported",
                    "parity": "covered",
                    "notes": "historical text may mention unknown without changing status",
                },
                {
                    "source_id": "resolved.adapted",
                    "status": "analyzed",
                    "parity": "adapted",
                },
            ]
        )
        self.assertEqual(unresolved, [])

    def test_all_unresolved_values_are_detected_across_status_and_parity(self):
        unresolved = self.validate_rows(
            [
                {"source_id": "a", "status": "uninspected", "parity": "covered"},
                {"source_id": "b", "status": "analyzed", "parity": "unknown"},
                {"source_id": "c", "status": "in_progress", "parity": "in_progress"},
            ]
        )
        self.assertEqual(
            unresolved,
            [
                "a: status=uninspected",
                "b: parity=unknown",
                "c: status=in_progress, parity=in_progress",
            ],
        )

    def test_non_object_rows_are_rejected(self):
        with self.assertRaisesRegex(ValueError, r"rows\[0\] must be an object"):
            self.validator.find_unresolved_entries({"rows": ["not-an-object"]})

    def test_missing_rows_array_is_rejected(self):
        with self.assertRaisesRegex(ValueError, "must contain a 'rows' array"):
            self.validator.find_unresolved_entries({})


if __name__ == "__main__":
    unittest.main()
