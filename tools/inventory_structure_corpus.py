#!/usr/bin/env python3
"""Build a deterministic inventory of The Broken Script Java structure templates.

The inventory is intentionally evidence-oriented. It records every .nbt source file,
including empty or malformed files, and never upgrades a template to "ported" merely
because a destination path exists. Source-identical staging is reported separately
from NBT parse validation and from gameplay/worldgen integration.
"""

from __future__ import annotations

import argparse
import hashlib
import importlib.util
import json
import sys
from pathlib import Path
from typing import Any, Iterator

REPO_ROOT = Path(__file__).resolve().parents[1]
DEFAULT_SOURCE = REPO_ROOT / "source_extracted/data/thebrokenscript/structure"
DEFAULT_TARGET = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP/structures/thebrokenscript"
DEFAULT_OUTPUT = REPO_ROOT / "STRUCTURE_CORPUS_INVENTORY.json"
NAMESPACE = "thebrokenscript"


def _load_inspector():
    path = Path(__file__).with_name("inspect_java_structure_nbt.py")
    spec = importlib.util.spec_from_file_location("_tbs_structure_nbt", path)
    if spec is None or spec.loader is None:
        raise RuntimeError(f"cannot load NBT inspector: {path}")
    module = importlib.util.module_from_spec(spec)
    sys.modules[spec.name] = module
    spec.loader.exec_module(module)
    return module


INSPECTOR = _load_inspector()


def _sha256(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as handle:
        for chunk in iter(lambda: handle.read(1024 * 1024), b""):
            digest.update(chunk)
    return digest.hexdigest()


def _repo_relative(path: Path) -> str:
    try:
        return path.resolve().relative_to(REPO_ROOT.resolve()).as_posix()
    except ValueError:
        return path.as_posix()


def _walk_values(value: Any) -> Iterator[tuple[str | None, Any]]:
    if isinstance(value, dict):
        for key, child in value.items():
            yield key, child
            yield from _walk_values(child)
    elif isinstance(value, list):
        for child in value:
            yield None, child
            yield from _walk_values(child)


def _palette_names(root: dict[str, Any]) -> list[str | None]:
    palette = root.get("palette")
    if not isinstance(palette, list):
        return []
    return [
        entry.get("Name") if isinstance(entry, dict) and isinstance(entry.get("Name"), str) else None
        for entry in palette
    ]


def _block_entity_count(root: dict[str, Any]) -> int:
    blocks = root.get("blocks")
    if not isinstance(blocks, list):
        return 0
    return sum(
        1
        for block in blocks
        if isinstance(block, dict) and isinstance(block.get("nbt"), dict)
    )


def _has_loot(root: dict[str, Any]) -> bool:
    for key, value in _walk_values(root):
        normalized_key = key.lower().replace("_", "") if isinstance(key, str) else ""
        if normalized_key in {"loottable", "loottableseed"}:
            return True
        if isinstance(value, str) and "loot_tables/" in value.lower():
            return True
    return False


def _has_spawner(root: dict[str, Any], palette_names: list[str | None]) -> bool:
    if any(name in {"minecraft:spawner", "minecraft:trial_spawner"} for name in palette_names):
        return True
    for key, value in _walk_values(root):
        if isinstance(key, str) and key.lower() in {"spawnpotentials", "spawn_data", "spawndata"}:
            return True
        if isinstance(value, str) and value.lower() in {
            "minecraft:mob_spawner",
            "minecraft:spawner",
            "minecraft:trial_spawner",
        }:
            return True
    return False


def _has_data_marker(root: dict[str, Any], palette_names: list[str | None]) -> bool:
    blocks = root.get("blocks")
    if not isinstance(blocks, list):
        return False
    for block in blocks:
        if not isinstance(block, dict):
            continue
        state = block.get("state")
        if (
            not isinstance(state, int)
            or isinstance(state, bool)
            or not 0 <= state < len(palette_names)
            or palette_names[state] != "minecraft:structure_block"
        ):
            continue
        nbt = block.get("nbt")
        if not isinstance(nbt, dict):
            continue
        mode = nbt.get("mode")
        if isinstance(mode, str) and mode.upper() == "DATA":
            return True
        if isinstance(nbt.get("metadata"), str):
            return True
    return False


def inspect_template(path: Path, source_root: Path, target_root: Path) -> dict[str, Any]:
    relative = path.relative_to(source_root)
    destination = target_root / relative
    source_hash = _sha256(path)
    target_exists = destination.is_file()
    destination_hash = _sha256(destination) if target_exists else None

    if not target_exists:
        staging_status = "not_staged"
        conversion_status = "not_staged"
    elif source_hash == destination_hash:
        staging_status = "source_identical"
        conversion_status = "source_nbt_staged"
    else:
        staging_status = "differs_from_source"
        conversion_status = "destination_modified"

    entry: dict[str, Any] = {
        "source_relative_path": _repo_relative(path),
        "namespace": NAMESPACE,
        "filename": path.name,
        "source_sha256": source_hash,
        "source_size_bytes": path.stat().st_size,
        "empty_source": path.stat().st_size == 0,
        "contains_jigsaw_blocks": False,
        "connector_count": 0,
        "palette_size": 0,
        "block_count": 0,
        "entity_count": 0,
        "block_entity_count": 0,
        "has_loot": False,
        "has_spawner": False,
        "has_data_marker": False,
        "bedrock_destination": _repo_relative(destination),
        "destination_sha256": destination_hash,
        "staging_status": staging_status,
        "conversion_status": conversion_status,
        "validation_status": "unparsed",
        "parse_error": None,
    }

    try:
        root = INSPECTOR.load_nbt(path)
        palette_names = _palette_names(root)
        blocks = root.get("blocks")
        entities = root.get("entities")
        connectors = INSPECTOR.jigsaw_connectors(root)
        entry.update(
            {
                "contains_jigsaw_blocks": bool(connectors),
                "connector_count": len(connectors),
                "palette_size": len(palette_names),
                "block_count": len(blocks) if isinstance(blocks, list) else 0,
                "entity_count": len(entities) if isinstance(entities, list) else 0,
                "block_entity_count": _block_entity_count(root),
                "has_loot": _has_loot(root),
                "has_spawner": _has_spawner(root, palette_names),
                "has_data_marker": _has_data_marker(root, palette_names),
                "validation_status": "parsed",
            }
        )
    except (OSError, INSPECTOR.NbtError) as exc:
        entry["validation_status"] = "parse_error"
        entry["parse_error"] = str(exc)

    return entry


def build_inventory(source_root: Path = DEFAULT_SOURCE, target_root: Path = DEFAULT_TARGET) -> dict[str, Any]:
    if not source_root.is_dir():
        raise FileNotFoundError(f"structure source directory does not exist: {source_root}")

    paths = sorted(
        (path for path in source_root.rglob("*.nbt") if path.is_file()),
        key=lambda path: path.relative_to(source_root).as_posix(),
    )
    entries = [inspect_template(path, source_root, target_root) for path in paths]

    return {
        "schema_version": 1,
        "namespace": NAMESPACE,
        "source_root": _repo_relative(source_root),
        "bedrock_root": _repo_relative(target_root),
        "template_count": len(entries),
        "parsed_count": sum(entry["validation_status"] == "parsed" for entry in entries),
        "parse_error_count": sum(entry["validation_status"] == "parse_error" for entry in entries),
        "staged_count": sum(entry["staging_status"] != "not_staged" for entry in entries),
        "source_identical_staged_count": sum(
            entry["staging_status"] == "source_identical" for entry in entries
        ),
        "jigsaw_template_count": sum(entry["contains_jigsaw_blocks"] for entry in entries),
        "entries": entries,
    }


def render_inventory(payload: dict[str, Any]) -> str:
    return json.dumps(payload, indent=2, sort_keys=True) + "\n"


def check_inventory(output: Path, rendered: str) -> tuple[bool, str]:
    if not output.is_file():
        return False, f"inventory is missing: {output}"
    current = output.read_text(encoding="utf-8")
    if current != rendered:
        return False, f"inventory is stale: regenerate {output}"
    return True, f"inventory is current: {output}"


def _parse_args(argv: list[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--source", type=Path, default=DEFAULT_SOURCE)
    parser.add_argument("--target", type=Path, default=DEFAULT_TARGET)
    parser.add_argument("--output", type=Path, default=DEFAULT_OUTPUT)
    parser.add_argument("--check", action="store_true", help="fail if the checked-in inventory is missing or stale")
    parser.add_argument("--stdout", action="store_true", help="print the generated inventory instead of writing it")
    return parser.parse_args(argv)


def main(argv: list[str] | None = None) -> int:
    args = _parse_args(sys.argv[1:] if argv is None else argv)
    try:
        payload = build_inventory(args.source, args.target)
    except (OSError, RuntimeError) as exc:
        print(f"structure inventory failed: {exc}", file=sys.stderr)
        return 1

    rendered = render_inventory(payload)
    if args.check:
        ok, message = check_inventory(args.output, rendered)
        print(message)
        return 0 if ok else 1

    if args.stdout:
        sys.stdout.write(rendered)
        return 0

    args.output.parent.mkdir(parents=True, exist_ok=True)
    args.output.write_text(rendered, encoding="utf-8")
    print(
        f"wrote {payload['template_count']} templates to {args.output} "
        f"({payload['parsed_count']} parsed, {payload['parse_error_count']} parse errors, "
        f"{payload['source_identical_staged_count']} source-identical staged)"
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
