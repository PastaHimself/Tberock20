import importlib.util
import json
import unittest
from pathlib import Path


MODULE_PATH = Path(__file__).resolve().parents[1] / "tools" / "audit_randomness.py"


def load_audit_module():
    spec = importlib.util.spec_from_file_location("audit_randomness", MODULE_PATH)
    module = importlib.util.module_from_spec(spec)
    assert spec.loader is not None
    spec.loader.exec_module(module)
    return module


class RandomnessAuditTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.audit = load_audit_module()

    def test_java_and_bedrock_randomness_sources_are_inventoryed_with_scopes(self):
        report = self.audit.build_report()

        self.assertGreater(report["java"]["draw_count"], 0)
        self.assertGreater(report["java"]["source_count"], 0)
        self.assertGreater(report["bedrock"]["math_random_count"], 0)
        self.assertIn("world", report["java"]["scope_counts"])
        self.assertIn("entity", report["java"]["scope_counts"])
        self.assertIn("local", report["java"]["scope_counts"])
        self.assertIn("horror_events.js", "\n".join(report["bedrock"]["files"]))
        self.assertEqual(self.audit.validate_report(report), [])

    def test_report_is_deterministic_and_json_serializable(self):
        first = self.audit.build_report()
        second = self.audit.build_report()

        self.assertEqual(first, second)
        json.dumps(first)

    def test_invalid_scope_is_rejected_by_the_check(self):
        report = self.audit.build_report()
        report["java"]["draws"][0]["scope"] = "unreviewed"

        errors = self.audit.validate_report(report)

        self.assertTrue(any("scope" in error for error in errors))


if __name__ == "__main__":
    unittest.main()
