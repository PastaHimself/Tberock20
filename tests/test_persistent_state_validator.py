import subprocess
import sys
import unittest
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
TOOL = ROOT / "tools" / "validate_persistent_state.py"


class PersistentStateValidatorTests(unittest.TestCase):
    def run_validator(self, *args: str) -> subprocess.CompletedProcess[str]:
        return subprocess.run(
            [sys.executable, str(TOOL), *args],
            cwd=ROOT,
            text=True,
            capture_output=True,
        )

    def test_validator_accepts_checked_in_persistence_contract(self):
        result = self.run_validator()
        self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
        self.assertIn("persistent state parity: OK", result.stdout)

    def test_validator_can_write_a_machine_readable_report(self):
        report = ROOT / "artifacts" / "persistent-state-test-report.json"
        report.parent.mkdir(exist_ok=True)
        try:
            result = self.run_validator("--report", str(report))
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertTrue(report.exists())
            self.assertIn('"status": "ok"', report.read_text(encoding="utf-8"))
        finally:
            report.unlink(missing_ok=True)


if __name__ == "__main__":
    unittest.main()
