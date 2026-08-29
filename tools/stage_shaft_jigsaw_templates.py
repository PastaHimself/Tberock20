#!/usr/bin/env python3
"""Stage the authoritative Java Shaft NBT templates for Bedrock Jigsaw use.

Bedrock Jigsaw structures can reference Java .nbt structure templates directly.
This tool intentionally copies only the six source-backed Shaft templates; it does
not claim that arbitrary Java structures are valid for every Bedrock placement API.
"""

from __future__ import annotations

import argparse
import hashlib
import shutil
import sys
from dataclasses import dataclass
from pathlib import Path

SHAFT_TEMPLATES = (
    "shaft_corner.nbt",
    "shaft_hall.nbt",
    "shaft_junction.nbt",
    "shaft_room.nbt",
    "shaft_room_hall.nbt",
    "shaft_root.nbt",
)

REPO_ROOT = Path(__file__).resolve().parents[1]
DEFAULT_SOURCE = REPO_ROOT / "source_extracted/data/thebrokenscript/structure/shaft"
DEFAULT_TARGET = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript/shaft"


@dataclass(frozen=True)
class CheckResult:
    ok: bool
    messages: tuple[str, ...]


def _sha256(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as handle:
        for chunk in iter(lambda: handle.read(1024 * 1024), b""):
            digest.update(chunk)
    return digest.hexdigest()


def check_templates(source: Path, target: Path) -> CheckResult:
    messages: list[str] = []
    ok = True

    for name in SHAFT_TEMPLATES:
        src = source / name
        dst = target / name
        if not src.is_file():
            ok = False
            messages.append(f"missing source template: {src}")
            continue
        if not dst.is_file():
            ok = False
            messages.append(f"missing staged template: {dst}")
            continue
        if _sha256(src) != _sha256(dst):
            ok = False
            messages.append(f"template differs from source: {name}")

    if target.is_dir():
        expected = set(SHAFT_TEMPLATES)
        extras = sorted(p.name for p in target.glob("*.nbt") if p.name not in expected)
        if extras:
            ok = False
            messages.append("unexpected staged Shaft templates: " + ", ".join(extras))

    if ok:
        messages.append(f"verified {len(SHAFT_TEMPLATES)} Shaft templates byte-for-byte")
    return CheckResult(ok=ok, messages=tuple(messages))


def stage_templates(source: Path, target: Path) -> CheckResult:
    missing = [name for name in SHAFT_TEMPLATES if not (source / name).is_file()]
    if missing:
        return CheckResult(
            ok=False,
            messages=tuple(f"missing source template: {source / name}" for name in missing),
        )

    target.mkdir(parents=True, exist_ok=True)
    for name in SHAFT_TEMPLATES:
        shutil.copyfile(source / name, target / name)
    return check_templates(source, target)


def _parse_args(argv: list[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--source", type=Path, default=DEFAULT_SOURCE)
    parser.add_argument("--target", type=Path, default=DEFAULT_TARGET)
    parser.add_argument(
        "--check",
        action="store_true",
        help="verify that staged files exactly match the authoritative source without modifying them",
    )
    return parser.parse_args(argv)


def main(argv: list[str] | None = None) -> int:
    args = _parse_args(sys.argv[1:] if argv is None else argv)
    result = check_templates(args.source, args.target) if args.check else stage_templates(args.source, args.target)
    for message in result.messages:
        print(message)
    return 0 if result.ok else 1


if __name__ == "__main__":
    raise SystemExit(main())
