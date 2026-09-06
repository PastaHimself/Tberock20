#!/usr/bin/env python3
"""Validate Java NBT Jigsaw connectors against Bedrock template pools.

Minecraft Bedrock's data-driven Jigsaw system can consume Java structure `.nbt`
templates. JSON-only validation is not enough: a template can reference a pool that
exists while its `target` cannot match the `name` of any Jigsaw block in that pool.
This tool parses the compressed Java NBT directly and catches those graph errors.

The parser intentionally supports the complete standard NBT tag set but only reads
the structure fields needed for Jigsaw validation (`palette`, `blocks`, block NBT).
No third-party packages are required.
"""

from __future__ import annotations

import argparse
import gzip
import json
import re
import struct
import sys
from dataclasses import dataclass
from pathlib import Path
from typing import Any, BinaryIO, Iterable

IDENTIFIER_RE = re.compile(r"^[a-z0-9_.-]+:[a-z0-9_./-]+$")
ASSET_PATH_RE = re.compile(r"^[a-z0-9_.-]+(?:/[a-z0-9_.-]+)*$")
REPO_ROOT = Path(__file__).resolve().parents[1]
DEFAULT_BP_ROOT = REPO_ROOT / "TheBrokenScript_Bedrock_2_0/BP"
SINGLE_POOL_TYPES = {
    "minecraft:single_pool_element",
    "minecraft:legacy_single_pool_element",
}


class NbtError(ValueError):
    """Raised when a Java NBT structure is malformed or unsupported."""


@dataclass(frozen=True)
class Connector:
    template: str
    position: tuple[int, int, int] | None
    name: str
    pool: str
    target: str
    final_state: str | None


@dataclass(frozen=True)
class PoolInfo:
    identifier: str
    path: Path
    locations: tuple[str, ...]
    fallback: str | None


@dataclass(frozen=True)
class ValidationResult:
    errors: tuple[str, ...]
    templates_checked: int
    connectors_checked: int

    @property
    def ok(self) -> bool:
        return not self.errors


def _read_exact(handle: BinaryIO, size: int) -> bytes:
    data = handle.read(size)
    if len(data) != size:
        raise NbtError(f"unexpected end of NBT while reading {size} byte(s)")
    return data


def _unpack(handle: BinaryIO, fmt: str) -> Any:
    size = struct.calcsize(fmt)
    values = struct.unpack(fmt, _read_exact(handle, size))
    return values[0] if len(values) == 1 else values


def _read_string(handle: BinaryIO) -> str:
    length = _unpack(handle, ">H")
    try:
        return _read_exact(handle, length).decode("utf-8")
    except UnicodeDecodeError as exc:
        raise NbtError(f"invalid UTF-8 NBT string: {exc}") from exc


def _read_payload(handle: BinaryIO, tag_type: int) -> Any:
    if tag_type == 0:
        return None
    if tag_type == 1:
        return _unpack(handle, ">b")
    if tag_type == 2:
        return _unpack(handle, ">h")
    if tag_type == 3:
        return _unpack(handle, ">i")
    if tag_type == 4:
        return _unpack(handle, ">q")
    if tag_type == 5:
        return _unpack(handle, ">f")
    if tag_type == 6:
        return _unpack(handle, ">d")
    if tag_type == 7:
        length = _unpack(handle, ">i")
        if length < 0:
            raise NbtError("negative TAG_Byte_Array length")
        return _read_exact(handle, length)
    if tag_type == 8:
        return _read_string(handle)
    if tag_type == 9:
        child_type = _unpack(handle, ">B")
        length = _unpack(handle, ">i")
        if length < 0:
            raise NbtError("negative TAG_List length")
        return [_read_payload(handle, child_type) for _ in range(length)]
    if tag_type == 10:
        result: dict[str, Any] = {}
        while True:
            child_type = _unpack(handle, ">B")
            if child_type == 0:
                return result
            name = _read_string(handle)
            result[name] = _read_payload(handle, child_type)
    if tag_type == 11:
        length = _unpack(handle, ">i")
        if length < 0:
            raise NbtError("negative TAG_Int_Array length")
        return [_unpack(handle, ">i") for _ in range(length)]
    if tag_type == 12:
        length = _unpack(handle, ">i")
        if length < 0:
            raise NbtError("negative TAG_Long_Array length")
        return [_unpack(handle, ">q") for _ in range(length)]
    raise NbtError(f"unknown NBT tag type {tag_type}")


def load_java_nbt(path: Path) -> dict[str, Any]:
    try:
        with gzip.open(path, "rb") as handle:
            root_type = _unpack(handle, ">B")
            if root_type != 10:
                raise NbtError(f"root tag must be TAG_Compound (10), got {root_type}")
            _read_string(handle)  # root name; Java structures normally use an empty name
            root = _read_payload(handle, root_type)
    except (OSError, EOFError, struct.error) as exc:
        raise NbtError(str(exc)) from exc
    if not isinstance(root, dict):
        raise NbtError("root payload is not a compound")
    return root


def _as_identifier(value: Any) -> str | None:
    return value if isinstance(value, str) and IDENTIFIER_RE.fullmatch(value) else None


def _is_asset_path(value: Any) -> bool:
    if not isinstance(value, str) or not ASSET_PATH_RE.fullmatch(value):
        return False
    return all(part not in {".", ".."} for part in value.split("/"))


def extract_connectors(path: Path, template_id: str) -> tuple[Connector, ...]:
    root = load_java_nbt(path)
    palette = root.get("palette")
    blocks = root.get("blocks")
    if not isinstance(palette, list) or not isinstance(blocks, list):
        raise NbtError("Java structure must contain palette and blocks lists")

    jigsaw_states: set[int] = set()
    for index, state in enumerate(palette):
        if isinstance(state, dict) and state.get("Name") == "minecraft:jigsaw":
            jigsaw_states.add(index)

    connectors: list[Connector] = []
    for block in blocks:
        if not isinstance(block, dict) or block.get("state") not in jigsaw_states:
            continue
        nbt = block.get("nbt")
        if not isinstance(nbt, dict):
            raise NbtError("minecraft:jigsaw block is missing block-entity NBT")

        raw_pos = block.get("pos")
        position: tuple[int, int, int] | None = None
        if (
            isinstance(raw_pos, list)
            and len(raw_pos) == 3
            and all(isinstance(value, int) and not isinstance(value, bool) for value in raw_pos)
        ):
            position = (raw_pos[0], raw_pos[1], raw_pos[2])

        name = nbt.get("name")
        pool = nbt.get("pool")
        target = nbt.get("target")
        final_state = nbt.get("final_state")
        if not isinstance(name, str) or not isinstance(pool, str) or not isinstance(target, str):
            raise NbtError("jigsaw block NBT must contain string name, pool, and target")
        connectors.append(
            Connector(
                template=template_id,
                position=position,
                name=name,
                pool=pool,
                target=target,
                final_state=final_state if isinstance(final_state, str) else None,
            )
        )
    return tuple(connectors)


def _iter_element_locations(element: Any) -> Iterable[str]:
    if not isinstance(element, dict):
        return
    element_type = element.get("element_type")
    if element_type in SINGLE_POOL_TYPES:
        location = element.get("location")
        if isinstance(location, str):
            yield location
        return
    if element_type == "minecraft:list_pool_element":
        children = element.get("elements")
        if isinstance(children, list):
            for child in children:
                yield from _iter_element_locations(child)


def _load_pools(bp_root: Path, errors: list[str]) -> dict[str, PoolInfo]:
    pools: dict[str, PoolInfo] = {}
    directory = bp_root / "worldgen/template_pools"
    if not directory.is_dir():
        errors.append(f"{directory}: template pool directory is missing")
        return pools

    for path in sorted(directory.rglob("*.json")):
        try:
            data = json.loads(path.read_text(encoding="utf-8-sig"))
        except (OSError, json.JSONDecodeError) as exc:
            errors.append(f"{path}: invalid JSON: {exc}")
            continue
        component = data.get("minecraft:template_pool") if isinstance(data, dict) else None
        description = component.get("description") if isinstance(component, dict) else None
        identifier = description.get("identifier") if isinstance(description, dict) else None
        if not isinstance(identifier, str) or not IDENTIFIER_RE.fullmatch(identifier):
            errors.append(f"{path}: invalid or missing template-pool identifier")
            continue
        if identifier in pools:
            errors.append(f"{path}: duplicate template-pool identifier {identifier!r}")
            continue

        locations: list[str] = []
        elements = component.get("elements")
        if isinstance(elements, list):
            for entry in elements:
                element = entry.get("element") if isinstance(entry, dict) else None
                locations.extend(_iter_element_locations(element))
        fallback = component.get("fallback")
        pools[identifier] = PoolInfo(
            identifier=identifier,
            path=path,
            locations=tuple(dict.fromkeys(locations)),
            fallback=fallback if isinstance(fallback, str) else None,
        )
    return pools


def _template_path(bp_root: Path, template_id: str) -> Path | None:
    if not _is_asset_path(template_id):
        return None
    base = bp_root / "structures" / template_id
    nbt = Path(f"{base}.nbt")
    if nbt.is_file():
        return nbt
    return None


def _pool_connector_names(
    pool_id: str,
    *,
    pools: dict[str, PoolInfo],
    connectors_by_template: dict[str, tuple[Connector, ...]],
    visited: set[str] | None = None,
) -> set[str]:
    if pool_id == "minecraft:empty":
        return set()
    visited = set() if visited is None else set(visited)
    if pool_id in visited:
        return set()
    visited.add(pool_id)
    pool = pools.get(pool_id)
    if pool is None:
        return set()
    names = {
        connector.name
        for template_id in pool.locations
        for connector in connectors_by_template.get(template_id, ())
    }
    if pool.fallback and pool.fallback != "minecraft:empty":
        names.update(
            _pool_connector_names(
                pool.fallback,
                pools=pools,
                connectors_by_template=connectors_by_template,
                visited=visited,
            )
        )
    return names


def validate_pack(bp_root: Path) -> ValidationResult:
    errors: list[str] = []
    pools = _load_pools(bp_root, errors)

    referenced_templates = {
        template_id
        for pool in pools.values()
        for template_id in pool.locations
    }
    connectors_by_template: dict[str, tuple[Connector, ...]] = {}
    templates_checked = 0
    connectors_checked = 0

    for template_id in sorted(referenced_templates):
        path = _template_path(bp_root, template_id)
        if path is None:
            # JSON/worldgen validator owns missing .mcstructure and generic location checks.
            continue
        try:
            connectors = extract_connectors(path, template_id)
        except NbtError as exc:
            errors.append(f"{path}: cannot parse Java structure NBT: {exc}")
            continue
        connectors_by_template[template_id] = connectors
        templates_checked += 1
        connectors_checked += len(connectors)

    for template_id, connectors in connectors_by_template.items():
        for connector in connectors:
            where = f"{template_id}@{connector.position}" if connector.position else template_id
            for field, value in (
                ("name", connector.name),
                ("pool", connector.pool),
                ("target", connector.target),
            ):
                if not IDENTIFIER_RE.fullmatch(value):
                    errors.append(f"{where}: invalid Jigsaw {field} identifier {value!r}")

            if connector.pool == "minecraft:empty":
                continue
            if connector.pool not in pools:
                errors.append(f"{where}: unresolved Jigsaw pool {connector.pool!r}")
                continue

            target_names = _pool_connector_names(
                connector.pool,
                pools=pools,
                connectors_by_template=connectors_by_template,
            )
            if connector.target != "minecraft:empty" and connector.target not in target_names:
                errors.append(
                    f"{where}: target {connector.target!r} cannot match any Jigsaw name "
                    f"in pool {connector.pool!r}; available names={sorted(target_names)!r}"
                )

    structures_dir = bp_root / "worldgen/structures"
    if structures_dir.is_dir():
        for path in sorted(structures_dir.rglob("*.json")):
            try:
                data = json.loads(path.read_text(encoding="utf-8-sig"))
            except (OSError, json.JSONDecodeError):
                continue
            component = data.get("minecraft:jigsaw") if isinstance(data, dict) else None
            if not isinstance(component, dict):
                continue
            start_pool = component.get("start_pool")
            start_name = component.get("start_jigsaw_name")
            if not isinstance(start_pool, str) or start_pool not in pools:
                continue
            if isinstance(start_name, str) and start_name != "minecraft:empty":
                available = _pool_connector_names(
                    start_pool,
                    pools=pools,
                    connectors_by_template=connectors_by_template,
                )
                if start_name not in available:
                    errors.append(
                        f"{path}: start_jigsaw_name {start_name!r} cannot match any connector "
                        f"in start_pool {start_pool!r}; available names={sorted(available)!r}"
                    )

    return ValidationResult(
        errors=tuple(errors),
        templates_checked=templates_checked,
        connectors_checked=connectors_checked,
    )


def _parse_args(argv: list[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--bp-root", type=Path, default=DEFAULT_BP_ROOT)
    return parser.parse_args(argv)


def main(argv: list[str] | None = None) -> int:
    args = _parse_args(sys.argv[1:] if argv is None else argv)
    result = validate_pack(args.bp_root)
    if result.errors:
        for error in result.errors:
            print(f"ERROR: {error}", file=sys.stderr)
        print(
            f"Jigsaw NBT connector validation failed: {len(result.errors)} error(s); "
            f"{result.templates_checked} template(s), {result.connectors_checked} connector(s) checked.",
            file=sys.stderr,
        )
        return 1
    print(
        f"Jigsaw NBT connector validation passed: {result.templates_checked} template(s), "
        f"{result.connectors_checked} connector(s) checked."
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
