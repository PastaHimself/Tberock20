from __future__ import annotations

import json
import unittest
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parents[1]
SOURCE_TAG_ROOT = REPO_ROOT / "source_extracted/data/thebrokenscript/tags/block"
BEDROCK_BLOCK_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP/blocks"
MOD_NAMESPACE = "thebrokenscript:"


def load_json(path: Path) -> dict:
    return json.loads(path.read_text(encoding="utf-8-sig"))


def bedrock_blocks_by_identifier() -> dict[str, dict]:
    blocks: dict[str, dict] = {}
    for path in BEDROCK_BLOCK_ROOT.glob("*.json"):
        document = load_json(path)
        block = document.get("minecraft:block")
        if not isinstance(block, dict):
            continue
        description = block.get("description", {})
        identifier = description.get("identifier")
        if isinstance(identifier, str):
            blocks[identifier] = block
    return blocks


class BlockTagParityTests(unittest.TestCase):
    def test_custom_source_block_tag_members_are_declared_in_bedrock(self):
        blocks = bedrock_blocks_by_identifier()
        checked_memberships = 0

        for source_tag_path in sorted(SOURCE_TAG_ROOT.glob("*.json")):
            source_tag = load_json(source_tag_path)
            bedrock_tag = f"thebrokenscript:{source_tag_path.stem}"

            for value in source_tag.get("values", []):
                if not isinstance(value, str) or not value.startswith(MOD_NAMESPACE):
                    continue

                with self.subTest(tag=bedrock_tag, block=value):
                    self.assertIn(value, blocks, f"source tag member has no Bedrock block: {value}")
                    components = blocks[value].get("components", {})
                    declared_tags = components.get("minecraft:tags", [])
                    self.assertIn(
                        bedrock_tag,
                        declared_tags,
                        f"{value} is missing source-backed Bedrock tag {bedrock_tag}",
                    )
                checked_memberships += 1

        self.assertGreater(checked_memberships, 0, "no custom source block tag memberships were checked")


if __name__ == "__main__":
    unittest.main()
