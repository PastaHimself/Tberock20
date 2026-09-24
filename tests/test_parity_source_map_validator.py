import importlib.util
import unittest
from pathlib import Path


MODULE_PATH = Path(__file__).resolve().parents[1] / "tools" / "validate_parity_source_map.py"


def load_validator_module():
    spec = importlib.util.spec_from_file_location("validate_parity_source_map", MODULE_PATH)
    module = importlib.util.module_from_spec(spec)
    assert spec.loader is not None
    spec.loader.exec_module(module)
    return module


def matrix_row(feature, evidence, status, parity="high"):
    return "\n".join(
        [
            "| Source Feature | Source Evidence | Bedrock Implementation | Status | Parity | Validation | Notes |",
            "|---|---|---|---|---|---|---|",
            f"| {feature} | {evidence} | adapter | {status} | {parity} | test | |",
        ]
    )


class ParitySourceMapValidatorTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.validator = load_validator_module()

    def test_ported_family_rejects_uniquely_referenced_analyzed_source_id(self):
        source_map = {
            "rows": [
                {
                    "source_id": "mod.entrypoints",
                    "source_paths": ["net/thebrokenscript/TheBrokenScript.class"],
                    "status": "analyzed",
                }
            ]
        }
        disagreements = self.validator.find_obvious_disagreements(
            source_map,
            matrix_row("Mod bootstrap/lifecycle", "mod.entrypoints", "ported (foundation)"),
        )
        self.assertEqual(len(disagreements), 1)
        self.assertIn("mod.entrypoints status=analyzed", disagreements[0])

    def test_exact_path_basename_and_stem_are_valid_evidence_aliases(self):
        source_map = {
            "rows": [
                {
                    "source_id": "mod.entrypoints",
                    "source_paths": [
                        "net/thebrokenscript/TheBrokenScript.class",
                        "net/thebrokenscript/TBSEngineControl.class",
                    ],
                    "status": "analyzed",
                }
            ]
        }
        for evidence in (
            "net/thebrokenscript/TheBrokenScript.class",
            "TheBrokenScript.class",
            "TBSEngineControl",
        ):
            with self.subTest(evidence=evidence):
                disagreements = self.validator.find_obvious_disagreements(
                    source_map,
                    matrix_row("Mod bootstrap/lifecycle", evidence, "ported"),
                )
                self.assertEqual(len(disagreements), 1)

    def test_ported_rollup_accepts_ported_or_validated_components(self):
        for status in ("ported", "validated"):
            with self.subTest(status=status):
                source_map = {
                    "rows": [
                        {
                            "source_id": "feature.component",
                            "source_paths": [],
                            "status": status,
                        }
                    ]
                }
                self.assertEqual(
                    self.validator.find_obvious_disagreements(
                        source_map,
                        matrix_row("Feature", "feature.component", "ported"),
                    ),
                    [],
                )

    def test_validated_rollup_requires_validated_component(self):
        source_map = {
            "rows": [
                {
                    "source_id": "feature.component",
                    "source_paths": [],
                    "status": "ported",
                }
            ]
        }
        disagreements = self.validator.find_obvious_disagreements(
            source_map,
            matrix_row("Feature", "feature.component", "validated"),
        )
        self.assertEqual(len(disagreements), 1)

    def test_lower_rollups_are_not_inferred_from_partial_evidence(self):
        source_map = {
            "rows": [
                {
                    "source_id": "feature.component",
                    "source_paths": [],
                    "status": "ported",
                }
            ]
        }
        for family_status in ("uninspected", "analyzed", "in_progress", "blocked"):
            with self.subTest(family_status=family_status):
                self.assertEqual(
                    self.validator.find_obvious_disagreements(
                        source_map,
                        matrix_row("Broad family", "feature.component", family_status),
                    ),
                    [],
                )

    def test_ambiguous_alias_is_ignored_instead_of_guessing_family_mapping(self):
        source_map = {
            "rows": [
                {
                    "source_id": "a",
                    "source_paths": ["one/Shared.class"],
                    "status": "analyzed",
                },
                {
                    "source_id": "b",
                    "source_paths": ["two/Shared.class"],
                    "status": "analyzed",
                },
            ]
        }
        self.assertEqual(
            self.validator.find_obvious_disagreements(
                source_map,
                matrix_row("Family", "Shared.class", "ported"),
            ),
            [],
        )

    def test_fuzzy_or_prefix_evidence_is_ignored(self):
        source_map = {
            "rows": [
                {
                    "source_id": "entity.chord_projectile",
                    "source_paths": ["net/thebrokenscript/entity/ChordProjectile.class"],
                    "status": "uninspected",
                }
            ]
        }
        self.assertEqual(
            self.validator.find_obvious_disagreements(
                source_map,
                matrix_row("Projectiles", "chord_projectile", "ported"),
            ),
            [],
        )

    def test_malformed_source_map_rows_are_rejected(self):
        with self.assertRaisesRegex(ValueError, r"rows\[0\] must be an object"):
            self.validator.find_obvious_disagreements(
                {"rows": ["not-an-object"]},
                matrix_row("Feature", "feature.component", "ported"),
            )

    def test_missing_family_table_is_rejected(self):
        with self.assertRaisesRegex(ValueError, "missing the family rollup table"):
            self.validator.find_obvious_disagreements({"rows": []}, "# no table")


if __name__ == "__main__":
    unittest.main()
