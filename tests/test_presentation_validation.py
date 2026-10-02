import shutil
import tempfile
import unittest
from pathlib import Path

from tools.validate_presentation import validate_presentation


REPOSITORY_ROOT = Path(__file__).resolve().parents[1]


class PresentationValidationTests(unittest.TestCase):
    def test_p1_presentation_contract_is_complete(self):
        result = validate_presentation(REPOSITORY_ROOT)

        self.assertTrue(result["ok"], "\n".join(result["errors"]))
        self.assertEqual(result["counts"]["source_animation_files"], 35)
        self.assertEqual(result["counts"]["deployed_animation_files"], 35)
        self.assertEqual(result["counts"]["source_particle_files"], 9)
        self.assertEqual(result["counts"]["java_particle_provider_types"], 7)
        self.assertEqual(result["counts"]["java_particle_callsite_types"], 7)
        self.assertEqual(result["checks"]["particles"]["unadapted_callsite_types"], [])
        self.assertEqual(result["counts"]["source_song_definitions"], 12)
        self.assertEqual(result["counts"]["source_sound_definitions"], 143)
        self.assertEqual(result["counts"]["deployed_sound_definitions"], 142)
        self.assertEqual(result["counts"]["record_items"], 10)
        self.assertEqual(result["counts"]["mismatched_script_sound_ids"], 0)
        self.assertEqual(result["checks"]["audio"]["mismatched_script_sound_ids"], [])
        self.assertEqual(result["counts"]["ui_files"], 4)
        self.assertEqual(result["counts"]["source_screen_images"], 59)

    def test_missing_animation_is_reported(self):
        with tempfile.TemporaryDirectory() as directory:
            fixture = Path(directory) / REPOSITORY_ROOT.name
            shutil.copytree(REPOSITORY_ROOT, fixture)
            (fixture / "TheBrokenScript_Bedrock_2_0/RP/animations/chord_projectile.animation.json").unlink(
                missing_ok=True,
            )

            result = validate_presentation(fixture)

        self.assertFalse(result["ok"])
        self.assertIn(
            "Missing deployed animation file: chord_projectile.animation.json",
            result["errors"],
        )

    def test_record_component_must_match_source_song_timing(self):
        with tempfile.TemporaryDirectory() as directory:
            fixture = Path(directory) / REPOSITORY_ROOT.name
            shutil.copytree(REPOSITORY_ROOT, fixture)
            item_path = fixture / "TheBrokenScript_Bedrock_2_0/BP/items/record_16.json"
            item_path.write_text(
                item_path.read_text(encoding="utf-8").replace('"duration": 98', '"duration": 97'),
                encoding="utf-8",
            )

            result = validate_presentation(fixture)

        self.assertFalse(result["ok"])
        self.assertTrue(
            any("record_16.json" in error and "duration" in error for error in result["errors"])
        )

    def test_namespaced_script_sound_must_match_deployed_definition_key(self):
        with tempfile.TemporaryDirectory() as directory:
            fixture = Path(directory) / REPOSITORY_ROOT.name
            shutil.copytree(REPOSITORY_ROOT, fixture)
            script_path = fixture / "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_chat.js"
            script_path.write_text(
                script_path.read_text(encoding="utf-8").replace(
                    'sender.playSound("kills_player"',
                    'sender.playSound("thebrokenscript:kills_player"',
                    1,
                ),
                encoding="utf-8",
            )

            result = validate_presentation(fixture)

        self.assertFalse(result["ok"])
        self.assertTrue(
            any("thebrokenscript:kills_player -> kills_player" in error for error in result["errors"])
        )


if __name__ == "__main__":
    unittest.main()
