from __future__ import annotations

import json
import unittest
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parents[1]
SOURCE_BLOCKSTATE_ROOT = REPO_ROOT / "source_extracted/assets/thebrokenscript/blockstates"
BEDROCK_BLOCK_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP/blocks"
CUSTOM_BLOCKS_SCRIPT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/custom_blocks.js"
SOURCE_COMMAND_BLOCK = REPO_ROOT / "decompiled/net/thebrokenscript/block/CorruptedCommandBlock.java"
SOURCE_COMMAND_ENTITY = REPO_ROOT / "decompiled/net/thebrokenscript/block/entity/CommandBlockEntity.java"
SOURCE_DISRUPTION_BLOCK = REPO_ROOT / "decompiled/net/thebrokenscript/block/DisruptionBlock.java"


def load_json(path: Path) -> dict:
    return json.loads(path.read_text(encoding="utf-8-sig"))


def bedrock_blocks_by_identifier() -> dict[str, dict]:
    blocks: dict[str, dict] = {}
    for path in BEDROCK_BLOCK_ROOT.glob("*.json"):
        document = load_json(path)
        block = document.get("minecraft:block")
        if not isinstance(block, dict):
            continue
        identifier = block.get("description", {}).get("identifier")
        if isinstance(identifier, str):
            if identifier in blocks:
                raise AssertionError(f"duplicate Bedrock block identifier: {identifier}")
            blocks[identifier] = block
    return blocks


class BlockRegistryAndBehaviorParityTests(unittest.TestCase):
    def test_source_blockstate_inventory_matches_bedrock_block_registry(self):
        source_ids = {
            f"thebrokenscript:{path.stem}"
            for path in SOURCE_BLOCKSTATE_ROOT.glob("*.json")
        }
        bedrock_ids = set(bedrock_blocks_by_identifier())

        self.assertGreater(len(source_ids), 0, "no source blockstates found")
        self.assertEqual(
            source_ids,
            bedrock_ids,
            "Bedrock block identifiers must match the repository-backed source blockstate inventory",
        )

    def test_corrupted_command_block_preserves_source_code_state(self):
        source_block = SOURCE_COMMAND_BLOCK.read_text(encoding="utf-8-sig")
        source_entity = SOURCE_COMMAND_ENTITY.read_text(encoding="utf-8-sig")
        source_blockstate = load_json(SOURCE_BLOCKSTATE_ROOT / "command.json")
        bedrock = load_json(BEDROCK_BLOCK_ROOT / "command.json")["minecraft:block"]

        self.assertIn('BooleanProperty.create((String)"code")', source_block)
        self.assertIn("getCodeApplied()", source_entity)
        self.assertIn("setValue((Property)CorruptedCommandBlock.Companion.getCODE()", source_entity)

        self.assertEqual(
            source_blockstate["variants"]["code=false"]["model"],
            "thebrokenscript:block/command",
        )
        self.assertEqual(
            source_blockstate["variants"]["code=true"]["model"],
            "thebrokenscript:block/command_inactive",
        )

        self.assertEqual(
            bedrock["description"]["states"]["thebrokenscript:code"],
            [False, True],
        )
        self.assertEqual(
            bedrock["components"]["minecraft:tick"],
            {"interval_range": [1, 1], "looping": True},
        )

        inactive = [
            permutation
            for permutation in bedrock.get("permutations", [])
            if permutation.get("condition")
            == "query.block_state('thebrokenscript:code') == true"
        ]
        self.assertEqual(len(inactive), 1)
        self.assertEqual(
            inactive[0]["components"]["minecraft:material_instances"]["*"]["texture"],
            "command_block_inactive",
        )

        script = CUSTOM_BLOCKS_SCRIPT.read_text(encoding="utf-8-sig")
        self.assertIn('worldState.set("commandBlockX", x)', script)
        self.assertIn('worldState.set("commandBlockY", y)', script)
        self.assertIn('worldState.set("commandBlockZ", z)', script)
        self.assertIn('worldState.get("codeApplied")', script)
        self.assertIn('.withState("thebrokenscript:code", true)', script)
        self.assertNotIn('/give @s minecraft:knowledge', script)
        self.assertNotIn('/tp @s into_the_void', script)
        self.assertNotIn('/ban @a[distance=..64]', script)

    def test_disruption_removes_itself_after_source_100_tick_delay(self):
        source = SOURCE_DISRUPTION_BLOCK.read_text(encoding="utf-8-sig")
        script = CUSTOM_BLOCKS_SCRIPT.read_text(encoding="utf-8-sig")

        self.assertIn("add(100L", source)
        self.assertIn("Blocks.AIR.defaultBlockState()", source)

        start = script.index('register("thebrokenscript:disruption"')
        end = script.index('register("thebrokenscript:be_command"', start)
        disruption = script[start:end]
        self.assertIn("system.runTimeout", disruption)
        self.assertIn('block.setType("minecraft:air")', disruption)
        self.assertIn("}, 100);", disruption)
        self.assertNotIn("onRandomTick", disruption)


if __name__ == "__main__":
    unittest.main()
