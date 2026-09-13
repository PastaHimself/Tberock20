#!/usr/bin/env python3
"""Validate the Java attachment-to-Bedrock persistence contract."""

from __future__ import annotations

import argparse
import json
import re
import sys
from collections import defaultdict
from pathlib import Path
from typing import Any


SYNCED_FILES = (
    "core/state.js",
    "core/persistence_schema.js",
    "core/entity_persistence_policy.js",
    "systems/player_state.js",
    "systems/world_state.js",
)

JAVA_TYPE_TO_BEDROCK = {
    "int": "number",
    "long": "number",
    "double": "number",
    "float": "number",
    "boolean": "boolean",
    "String": "string",
    "CameraMode": "string",
    "BlockPos": "vector3",
    "Vec3": "vector3",
    "WrappedBlockPosList": "json",
    "WrappedUUIDSet": "json",
}

SCHEMA_ENTRY_RE = re.compile(
    r'^\s{4}(?P<key>[A-Za-z_]\w*):\s+'
    r'(?P<storage>dynamic|json)\("(?P<java_field>[^"]+)"'
    r'(?:,\s*"(?P<type>[^"]+)")?',
    re.MULTILINE,
)
JAVA_FIELD_RE = re.compile(
    r'^\s*private\s+(?!static\b)(?:final\s+)?'
    r'(?P<type>[A-Za-z][A-Za-z0-9_$<>?, ]*)\s+(?P<name>\w+);',
    re.MULTILINE,
)
POLICY_ENTRY_RE = re.compile(
    r'^\s*"(?P<key>[^"]+)":\s+Object\.freeze\(\{'
    r'\s*scope:\s+"(?P<scope>[^"]+)",\s*'
    r'persistence:\s+"(?P<persistence>[^"]+)"',
    re.MULTILINE,
)
ENTITY_EVIDENCE_ENTRY_RE = re.compile(
    r'"(?P<key>[^"]+)":\s+Object\.freeze\(\{\s*'
    r'javaClass:\s+"(?P<java_class>[^"]+)",\s*'
    r'saveKey:\s+"(?P<save_key>[^"]+)"',
    re.MULTILINE,
)
RAW_DYNAMIC_CALL_RE = re.compile(
    r'\.(?P<method>get|set)DynamicProperty\(\s*["\'](?P<key>[^"\']+)["\']',
)
PROPERTY_CONSTANT_RE = re.compile(
    r'\b(?:const|let)\s+\w+\s*=\s*["\'](?P<key>(?:tbs|tbe):[^"\']+)["\']',
)


def read_text(path: Path) -> str:
    return path.read_text(encoding="utf-8-sig")


def schema_block(source: str, name: str) -> str:
    marker = f"export const {name} = Object.freeze({{"
    start = source.find(marker)
    if start < 0:
        return ""
    end = source.find("\n});", start)
    return source[start:end if end >= 0 else len(source)]


def parse_schema(source: str, name: str) -> dict[str, list[dict[str, str]]]:
    fields: dict[str, list[dict[str, str]]] = defaultdict(list)
    for match in SCHEMA_ENTRY_RE.finditer(schema_block(source, name)):
        storage = match.group("storage")
        fields[match.group("java_field")].append(
            {
                "key": match.group("key"),
                "storage": storage,
                "type": match.group("type") or "json",
            },
        )
    return dict(fields)


def java_class_body(source: str, class_name: str) -> str:
    class_start = source.find(f"public final class {class_name}")
    if class_start < 0:
        return ""
    constructor = re.search(rf"^\s+public\s+{class_name}\(", source[class_start:], re.MULTILINE)
    if constructor is None:
        return source[class_start:]
    return source[class_start : class_start + constructor.start()]


def parse_java_fields(path: Path, class_name: str) -> dict[str, str]:
    source = read_text(path)
    fields = {}
    for match in JAVA_FIELD_RE.finditer(java_class_body(source, class_name)):
        fields[match.group("name")] = match.group("type").strip()
    return fields


def parse_policy(source: str) -> dict[str, dict[str, str]]:
    return {
        match.group("key"): {
            "scope": match.group("scope"),
            "persistence": match.group("persistence"),
        }
        for match in POLICY_ENTRY_RE.finditer(source)
    }


def parse_persistent_entity_evidence(source: str) -> dict[str, dict[str, str]]:
    return {
        match.group("key"): {
            "java_class": match.group("java_class"),
            "save_key": match.group("save_key"),
        }
        for match in ENTITY_EVIDENCE_ENTRY_RE.finditer(source)
    }


def parse_non_persistent_entity_types(source: str) -> set[str]:
    marker = "export const NON_PERSISTENT_ENTITY_TYPES"
    start = source.find(marker)
    if start < 0:
        return set()
    end = source.find("]);", start)
    block = source[start : end if end >= 0 else len(source)]
    return set(re.findall(r'"([^"]+)"', block))


def expected_schema_errors(
    schema: dict[str, list[dict[str, str]]],
    java_fields: dict[str, str],
    label: str,
) -> list[str]:
    errors = []
    java_names = set(java_fields)
    schema_names = set(schema)
    for missing in sorted(java_names - schema_names):
        errors.append(f"{label}: Java field {missing} is missing from the Bedrock schema")
    for extra in sorted(schema_names - java_names):
        errors.append(f"{label}: schema field {extra} has no Java attachment field")

    for java_name, java_type in java_fields.items():
        entries = schema.get(java_name, [])
        expected = JAVA_TYPE_TO_BEDROCK.get(java_type)
        if not entries or expected is None:
            continue
        if java_name == "commandBlockLocation":
            if len(entries) != 3 or any(entry["type"] != "number" for entry in entries):
                errors.append(
                    f"{label}: {java_name} must map to three numeric coordinates",
                )
            continue
        if len(entries) != 1:
            errors.append(f"{label}: {java_name} maps to {len(entries)} properties, expected one")
            continue
        actual = entries[0]["type"]
        if actual != expected:
            errors.append(
                f"{label}: {java_name} is {java_type} in Java but {actual} in Bedrock",
            )
        if expected == "json" and entries[0]["storage"] != "json":
            errors.append(f"{label}: {java_name} must use JSON dynamic-property storage")
        if expected != "json" and entries[0]["storage"] != "dynamic":
            errors.append(f"{label}: {java_name} must use primitive/vector dynamic-property storage")
    return errors


def validate(root: Path) -> list[str]:
    addon = root / "TheBrokenScript_Bedrock_2_0"
    src = addon / "src"
    bp = addon / "BP" / "scripts"
    errors: list[str] = []

    for relative in SYNCED_FILES:
        source_path = src / relative
        deploy_path = bp / relative
        if not source_path.exists() or not deploy_path.exists():
            errors.append(f"missing synchronized persistence file: {relative}")
            continue
        if read_text(source_path) != read_text(deploy_path):
            errors.append(f"source/BP persistence file drift: {relative}")

    schema_path = src / "core" / "persistence_schema.js"
    schema_source = read_text(schema_path) if schema_path.exists() else ""
    world_schema = parse_schema(schema_source, "WORLD_STATE_SCHEMA")
    player_schema = parse_schema(schema_source, "PLAYER_STATE_SCHEMA")
    world_java = parse_java_fields(root / "decompiled/net/thebrokenscript/data/MapVariables.java", "MapVariables")
    player_java = parse_java_fields(root / "decompiled/net/thebrokenscript/data/PlayerVariables.java", "PlayerVariables")
    errors.extend(expected_schema_errors(world_schema, world_java, "MapVariables"))
    errors.extend(expected_schema_errors(player_schema, player_java, "PlayerVariables"))

    policy_path = src / "core" / "entity_persistence_policy.js"
    policy_source = read_text(policy_path) if policy_path.exists() else ""
    policy = parse_policy(policy_source)
    entity_evidence = parse_persistent_entity_evidence(policy_source)
    non_persistent = parse_non_persistent_entity_types(policy_source)
    if not non_persistent:
        errors.append("entity persistence policy has no non-persistent entity list")

    for key, entry in sorted(policy.items()):
        if entry["scope"] != "entity" or entry["persistence"] != "persistent":
            continue
        evidence = entity_evidence.get(key)
        if evidence is None:
            errors.append(f"persistent entity key {key} has no Java save/load evidence")
            continue
        java_candidates = list((root / "decompiled").rglob(f"{evidence['java_class']}.java"))
        if not java_candidates:
            errors.append(
                f"persistent entity key {key} references missing Java class {evidence['java_class']}",
            )
            continue
        java_source = read_text(java_candidates[0])
        save_key = re.escape(evidence["save_key"])
        if not re.search(rf'put[A-Za-z]+\("{save_key}"', java_source):
            errors.append(f"{key}: Java class does not save '{evidence['save_key']}'")
        if not re.search(rf'get[A-Za-z]+\("{save_key}"', java_source):
            errors.append(f"{key}: Java class does not load '{evidence['save_key']}'")

    raw_properties: dict[str, set[str]] = defaultdict(set)
    legacy_writes = []
    for tree in (src, bp):
        for path in tree.rglob("*.js"):
            source = read_text(path)
            for match in RAW_DYNAMIC_CALL_RE.finditer(source):
                key = match.group("key")
                raw_properties[key].add(str(path.relative_to(root)))
                if match.group("method") == "set" and policy.get(key, {}).get("persistence") == "legacy":
                    legacy_writes.append(f"{path.relative_to(root)} writes legacy key {key}")
            for match in PROPERTY_CONSTANT_RE.finditer(source):
                key = match.group("key")
                raw_properties[key].add(str(path.relative_to(root)))

    for key, paths in sorted(raw_properties.items()):
        if key in policy:
            continue
        if key.startswith("tbs:adv_"):
            continue
        errors.append(f"undeclared dynamic-property key {key} ({', '.join(sorted(paths))})")
    errors.extend(legacy_writes)

    entity_dir = addon / "BP" / "entities"
    for path in sorted(entity_dir.glob("*.json")):
        try:
            document = json.loads(path.read_text(encoding="utf-8-sig"))
        except json.JSONDecodeError as exc:
            errors.append(f"{path.relative_to(root)}: invalid JSON ({exc})")
            continue
        entity = document.get("minecraft:entity", {})
        identifier = entity.get("description", {}).get("identifier")
        components = entity.get("components", {})
        has_persistent = "minecraft:persistent" in components
        if identifier in non_persistent and has_persistent:
            errors.append(f"{identifier} is listed non-persistent but declares minecraft:persistent")
        elif identifier not in non_persistent and not has_persistent:
            errors.append(
                f"{identifier} has no minecraft:persistent component and is not declared transient",
            )

    if not re.search(r"TRANSIENT_RUNTIME_STATE[\s\S]*?timers", policy_source):
        errors.append("entity persistence policy does not record transient controller timers")
    return errors


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument("--report", type=Path)
    args = parser.parse_args(argv)
    root = args.root.resolve()
    errors = validate(root)
    result: dict[str, Any] = {
        "status": "ok" if not errors else "error",
        "errors": errors,
    }
    if args.report:
        report = args.report if args.report.is_absolute() else root / args.report
        report.parent.mkdir(parents=True, exist_ok=True)
        report.write_text(json.dumps(result, indent=2) + "\n", encoding="utf-8")
    if errors:
        print("persistent state parity: FAILED", file=sys.stderr)
        for error in errors:
            print(f"- {error}", file=sys.stderr)
        return 1
    print("persistent state parity: OK")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
