#!/usr/bin/env python3
"""Copy the Java library book pages into the deployable Script API module."""

import argparse
import json
from pathlib import Path


ROOT = Path(__file__).resolve().parent.parent
SOURCE = ROOT / "source_extracted/assets/thebrokenscript/library_books"
OUTPUT = ROOT / "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/library_book_data.js"


def render() -> str:
    books = sorted(SOURCE.glob("*.json"), key=lambda file: int(file.stem))
    if [int(file.stem) for file in books] != list(range(1, 45)):
        raise ValueError("expected Java library books 1 through 44")

    lines = [
        "// Generated from source_extracted/assets/thebrokenscript/library_books/*.json.",
        "// Regenerate with: python tools/generate_library_books.py",
        "export const LIBRARY_BOOK_PAGES = Object.freeze({",
    ]
    for file in books:
        pages = json.loads(file.read_text(encoding="utf-8"))["pages"]
        lines.append(f"  {int(file.stem)}: {json.dumps(pages, ensure_ascii=False, separators=(',', ':'))},")
    lines.extend(["});", ""])
    return "\n".join(lines)


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check", action="store_true", help="verify the generated module is current")
    args = parser.parse_args()
    expected = render()
    if args.check:
        if not OUTPUT.exists() or OUTPUT.read_text(encoding="utf-8") != expected:
            parser.error(f"{OUTPUT} is stale; run python tools/generate_library_books.py")
    else:
        OUTPUT.write_text(expected, encoding="utf-8")


if __name__ == "__main__":
    main()
