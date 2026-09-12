import importlib.util
import json
import tempfile
import unittest
from pathlib import Path


MODULE_PATH = Path(__file__).resolve().parents[1] / "tools" / "audit_source_map_tree.py"
REPO_ROOT = Path(__file__).resolve().parents[1]
PROJECT_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0"
SOURCE_MAP = PROJECT_ROOT / "SOURCE_MAP.json"


def load_audit_module():
    spec = importlib.util.spec_from_file_location("audit_source_map_tree", MODULE_PATH)
    module = importlib.util.module_from_spec(spec)
    assert spec.loader is not None
    spec.loader.exec_module(module)
    return module


class SourceMapTreeAuditTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.audit = load_audit_module()

    def test_repository_source_map_resolves_current_tree(self):
        report = self.audit.audit_source_map(SOURCE_MAP, PROJECT_ROOT)
        self.assertEqual(report["row_count"], 912)
        self.assertEqual(
            report["problems"],
            [],
            "SOURCE_MAP contains stale or malformed Bedrock path references",
        )

    def test_literal_and_glob_paths_resolve(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            (root / "BP" / "scripts").mkdir(parents=True)
            (root / "BP" / "scripts" / "main.js").write_text("", encoding="utf-8")
            source_map = root / "SOURCE_MAP.json"
            source_map.write_text(
                json.dumps(
                    {
                        "rows": [
                            {
                                "source_id": "literal",
                                "bedrock_files": ["BP/scripts/main.js"],
                            },
                            {
                                "source_id": "glob",
                                "bedrock_files": ["BP/scripts/*.js"],
                            },
                        ]
                    }
                ),
                encoding="utf-8",
            )
            report = self.audit.audit_source_map(source_map, root)
            self.assertEqual(report["problems"], [])
            self.assertEqual(report["literal_specs"], 1)
            self.assertEqual(report["glob_specs"], 1)

    def test_missing_and_case_mismatched_paths_are_reported(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            (root / "RP" / "textures").mkdir(parents=True)
            (root / "RP" / "textures" / "Present.png").write_text("", encoding="utf-8")
            source_map = root / "SOURCE_MAP.json"
            source_map.write_text(
                json.dumps(
                    {
                        "rows": [
                            {
                                "source_id": "case",
                                "bedrock_files": ["RP/textures/present.png"],
                            },
                            {
                                "source_id": "missing",
                                "bedrock_files": ["BP/entities/missing.json"],
                            },
                        ]
                    }
                ),
                encoding="utf-8",
            )
            report = self.audit.audit_source_map(source_map, root)
            problems = report["problems"]
            self.assertEqual(len(problems), 2)
            self.assertIn("case mismatch", problems[0].reason)
            self.assertEqual(problems[0].suggestions, ("RP/textures/Present.png",))
            self.assertEqual(problems[1].reason, "path does not exist")


if __name__ == "__main__":
    unittest.main()
