import importlib.util
import unittest
from pathlib import Path


MODULE_PATH = Path(__file__).resolve().parents[1] / "tools" / "validate_p2_contract.py"


def load_contract_module():
    spec = importlib.util.spec_from_file_location("validate_p2_contract", MODULE_PATH)
    module = importlib.util.module_from_spec(spec)
    assert spec.loader is not None
    spec.loader.exec_module(module)
    return module


class P2ContractTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.contract = load_contract_module()

    def test_all_version_sources_match_the_authoritative_preview_contract(self):
        values = self.contract.read_contract()

        self.assertEqual(self.contract.validate_contract(values), [])
        self.assertEqual(values["engine_floor"], [1, 26, 50])
        self.assertEqual(values["runtime_server"], "2.11.0-beta")
        self.assertEqual(values["typing_server"], "2.11.0-beta.1.26.50-preview.26")
        self.assertEqual(values["runtime_server_ui"], "2.1.0")
        self.assertEqual(values["typing_server_ui"], "2.3.0-beta.1.26.50-preview.26")
        self.assertIn("Beta APIs", values["required_experiments"])

    def test_a_channel_change_is_rejected_until_every_contract_surface_is_updated(self):
        values = self.contract.read_contract()
        values["runtime_server"] = "2.11.0"

        errors = self.contract.validate_contract(values)

        self.assertTrue(any("runtime_server" in error for error in errors))


if __name__ == "__main__":
    unittest.main()
