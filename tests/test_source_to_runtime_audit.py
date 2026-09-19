import importlib.util
import json
import tempfile
import unittest
from pathlib import Path


REPO_ROOT = Path(__file__).resolve().parents[1]
MODULE_PATH = REPO_ROOT / "tools/audit_source_to_runtime.py"
SPEC = importlib.util.spec_from_file_location("audit_source_to_runtime", MODULE_PATH)
MODULE = importlib.util.module_from_spec(SPEC)
assert SPEC.loader is not None
SPEC.loader.exec_module(MODULE)


class SourceToRuntimeAuditTests(unittest.TestCase):
    def test_relative_import_resolution_normalizes_parent_segments(self):
        addon_root = Path("/tmp/addon")
        source = addon_root / "BP/scripts/systems/events/boss.js"

        resolved = MODULE.resolve_relative_import(
            source, "../../core/logging.js", addon_root
        )

        self.assertEqual(resolved, addon_root / "BP/scripts/core/logging.js")

    def test_runtime_graph_reports_missing_imports_and_reachability(self):
        with tempfile.TemporaryDirectory() as directory:
            addon_root = Path(directory) / "TheBrokenScript_Bedrock_2_0"
            scripts = addon_root / "BP/scripts"
            scripts.mkdir(parents=True)
            (addon_root / "BP/manifest.json").write_text(
                json.dumps(
                    {
                        "modules": [
                            {"type": "script", "entry": "scripts/main.js"}
                        ]
                    }
                ),
                encoding="utf-8",
            )
            (scripts / "main.js").write_text(
                'import "./systems/../core.js";\n', encoding="utf-8"
            )
            (scripts / "core.js").write_text("export const ok = true;\n", encoding="utf-8")
            (scripts / "orphan.js").write_text("export const orphan = true;\n", encoding="utf-8")

            graph = MODULE.build_runtime_graph(addon_root)

            self.assertEqual(graph["missing_imports"], [])
            self.assertEqual(graph["reachable_from_manifest"], [
                "BP/scripts/core.js",
                "BP/scripts/main.js",
            ])
            self.assertEqual(graph["unreachable_modules"], ["BP/scripts/orphan.js"])

    def test_entity_audit_support_modules_have_explicit_unreachable_dispositions(self):
        report = MODULE.audit_project(REPO_ROOT)
        runtime = report["runtime"]
        expected = [
            "BP/scripts/core/entity_family_registry.js",
            "BP/scripts/core/entity_persistence_policy.js",
        ]

        for module in expected:
            self.assertIn(module, runtime["unreachable_modules"])
            self.assertIn("audit-support", runtime["unreachable_dispositions"][module])

        self.assertFalse(
            any(
                finding["code"] == "runtime-module-unreachable"
                for finding in report["findings"]
            )
        )

    def test_nested_asset_glob_matches_original_source_path(self):
        self.assertTrue(
            MODULE.asset_pattern_matches(
                "assets/thebrokenscript/geo/plush/bear.geo.json",
                "assets/thebrokenscript/geo/**/*.json",
            )
        )
        self.assertFalse(
            MODULE.asset_pattern_matches(
                "assets/thebrokenscript/geo/plush/bear.geo.json",
                "assets/thebrokenscript/animations/*.json",
            )
        )

    def test_source_map_directory_descriptor_matches_files_in_that_directory(self):
        self.assertTrue(
            MODULE._source_reference_matches(
                ".cache/16897c9b77d11d266ed5963947874285af4cf785",
                ".cache/ (14 hash-named files)",
            )
        )
        self.assertFalse(
            MODULE._source_reference_matches(
                ".cache-not-mapped/file",
                ".cache/ (14 hash-named files)",
            )
        )

    def test_zero_byte_control_name_is_reported_as_extraction_artifact(self):
        with tempfile.TemporaryDirectory() as directory:
            root = Path(directory)
            addon_root = root / "TheBrokenScript_Bedrock_2_0"
            addon_root.mkdir(parents=True)
            source_root = root / "source_extracted"
            source_root.mkdir()
            (source_root / ("\x7f" * 4)).write_bytes(b"")

            assets = MODULE.audit_source_assets(
                root,
                addon_root,
                {"rows": []},
                {"families": []},
            )

            self.assertEqual(assets["unmapped_files"], [])
            self.assertEqual(
                assets["family_counts"]["source_extraction_artifacts"],
                1,
            )

    def test_silent_catch_is_reported_and_annotated_fallback_is_not(self):
        findings = MODULE.find_silent_catches(
            "try { player.applyDamage(2); } catch {}\n"
            "try { player.playSound(\"x\"); } catch { /* audit: expected-fallback api */ }\n",
            "BP/scripts/example.js",
        )

        self.assertEqual(len(findings), 1)
        self.assertEqual(findings[0]["severity"], "error")
        self.assertIn("applyDamage", findings[0]["context"])

    def test_operation_diagnostics_counts_as_observable_catch_handling(self):
        findings = MODULE.find_silent_catches(
            "try { player.applyDamage(2); } catch (error) { "
            "operationDiagnostics.errorOnce('damage', 'damage failed', error); "
            "return false; }\n",
            "BP/scripts/example.js",
        )

        self.assertEqual(findings, [])

    def test_project_has_no_unobserved_runtime_catches(self):
        report = MODULE.audit_project(REPO_ROOT)

        self.assertEqual(report["fallbacks"]["silent_catch_count"], 0)

    def test_minimal_project_has_zero_structural_errors(self):
        with tempfile.TemporaryDirectory() as directory:
            root = Path(directory)
            addon_root = root / "TheBrokenScript_Bedrock_2_0"
            scripts = addon_root / "BP/scripts"
            java = root / "decompiled/net/example"
            scripts.mkdir(parents=True)
            java.mkdir(parents=True)
            (addon_root / "BP/manifest.json").write_text(
                json.dumps(
                    {
                        "modules": [
                            {"type": "script", "entry": "scripts/main.js"}
                        ]
                    }
                ),
                encoding="utf-8",
            )
            (scripts / "main.js").write_text("export const main = true;\n", encoding="utf-8")
            (java / "Main.java").write_text(
                "package net.example;\npublic class Main {}\n", encoding="utf-8"
            )
            rows = [
                {
                    "source_id": "mod.entrypoints",
                    "category": "code_entrypoint",
                    "source_paths": ["net/example/Main.class"],
                    "bedrock_files": ["BP/scripts/main.js"],
                    "status": "ported",
                    "parity": "full",
                    "notes": "test fixture",
                }
            ]
            (addon_root / "SOURCE_MAP.json").write_text(
                json.dumps({"rows": rows}), encoding="utf-8"
            )
            (addon_root / "SOURCE_INVENTORY.json").write_text(
                json.dumps({"entries": [dict(rows[0], dependencies=[])]}),
                encoding="utf-8",
            )
            (addon_root / "ASSET_MAP.json").write_text(
                json.dumps({"families": []}), encoding="utf-8"
            )

            report = MODULE.audit_project(root)

            self.assertEqual(report["summary"]["errors"], 0)
            self.assertEqual(report["java"]["coverage"]["unmapped"], 0)
            self.assertEqual(report["runtime"]["missing_imports"], [])

    def test_github_actions_runs_the_audit_and_publishes_json_artifact(self):
        workflow = (
            REPO_ROOT / ".github/workflows/bedrock-addon-check.yml"
        ).read_text(encoding="utf-8")

        self.assertIn("python tools/audit_source_to_runtime.py", workflow)
        self.assertIn("--check", workflow)
        self.assertIn("artifacts/source-to-runtime-audit.json", workflow)
        self.assertIn("path: artifacts/*.json", workflow)

    def test_constant_audit_ignores_dates_and_comments(self):
        with tempfile.TemporaryDirectory() as directory:
            root = Path(directory)
            java = root / "decompiled/net/example"
            scripts = root / "TheBrokenScript_Bedrock_2_0/BP/scripts"
            java.mkdir(parents=True)
            scripts.mkdir(parents=True)
            (java / "Constants.java").write_text(
                "package net.example; public class Constants { public static final int VALUE = 1; }\n",
                encoding="utf-8",
            )
            (scripts / "main.js").write_text(
                'const VALUE = 1; const TEXT = "snimok_2024-11-02_090828"; // 17.5\n',
                encoding="utf-8",
            )

            constants = MODULE.audit_constants(root, root / "TheBrokenScript_Bedrock_2_0")

            self.assertEqual(constants["named_constant_comparison_count"], 1)
            self.assertEqual(constants["unmatched_runtime_constants"], [])


if __name__ == "__main__":
    unittest.main()
