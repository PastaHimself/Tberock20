#!/usr/bin/env python3
"""Audit the Java/source/data graph against the shipped Bedrock runtime.

This is intentionally a static audit.  It does not claim to simulate a
Minecraft server; instead it makes the source-to-runtime boundary explicit and
fails CI when the evidence graph itself becomes incomplete.  Runtime hazard
findings are retained in the report as warnings so that defensive Bedrock API
adapters can be reviewed without making the release gate unusable on engines
whose APIs are deliberately best-effort.

The audit covers:

* every Java decompilation file, including the embedded brokencore library;
* Java package/import/inheritance edges and integration-point categories;
* the manifest JavaScript entrypoint and normalized relative-import graph;
* original extracted data/assets and their ASSET_MAP dispositions;
* conservative Java-vs-JavaScript numeric constant comparisons; and
* fallback/no-op markers and catch blocks that suppress side effects.

Use ``--check`` in CI.  ``--report`` and ``--markdown`` are optional output
paths for machine-readable and human-readable evidence respectively.
"""

from __future__ import annotations

import argparse
from decimal import Decimal, InvalidOperation
import fnmatch
import json
import re
import subprocess
import sys
from collections import Counter
from pathlib import Path, PurePosixPath
from typing import Any, Iterable


ROOT = Path(__file__).resolve().parents[1]
ADDON_NAME = "TheBrokenScript_Bedrock_2_0"
AUDIT_VERSION = 1

# A Bedrock module import can span several lines.  Stop at the declaration's
# semicolon so a later relative string literal cannot be mistaken for the
# current import when a package import is external.
STATIC_IMPORT_RE = re.compile(
    r"(?:\bimport\s+(?!\()(?:(?!;).)*?|"
    r"\bexport\s+(?:(?!;).)*?\sfrom\s+)"
    r"[\"'](?P<specifier>\.[^\"']+)[\"']",
    re.DOTALL,
)
PACKAGE_RE = re.compile(r"\bpackage\s+([A-Za-z_$][\w$]*(?:\.[A-Za-z_$][\w$]*)*)\s*;")
IMPORT_RE = re.compile(
    r"\bimport\s+([A-Za-z_$][\w$]*(?:\.[A-Za-z_$][\w$]*)*(?:\.\*)?)\s*;"
)
DECLARATION_RE = re.compile(
    r"\b(?:class|interface|enum|record|object)\s+([A-Za-z_$][\w$]*)"
)
INHERITANCE_RE = re.compile(
    r"\b(?:extends|implements)\s+([A-Za-z_$][\w$]*(?:\s*,\s*[A-Za-z_$][\w$]*)*)"
)
NUMBER_RE = re.compile(
    r"(?<![\w.])(?:0[xX][0-9a-fA-F_]+|[\d_]+(?:\.[\d_]+)?(?:[eE][+-]?[\d_]+)?)"
    r"[fFdDlL]?(?![\w.])"
)
JAVA_NAMED_CONSTANT_RE = re.compile(
    r"\b(?P<name>[A-Z][A-Z0-9_]{2,})\s*=\s*"
    r"(?P<value>0[xX][0-9a-fA-F_]+|[\d_]+(?:\.[\d_]+)?(?:[eE][+-]?[\d_]+)?)[fFdDlL]?\b"
)
JS_NAMED_CONSTANT_RE = re.compile(
    r"\b(?:const|let|var)\s+(?P<name>[A-Z][A-Z0-9_]{2,})\s*=\s*"
    r"(?P<value>0[xX][0-9a-fA-F_]+|[\d_]+(?:\.[\d_]+)?(?:[eE][+-]?[\d_]+)?)\b"
)
CATCH_RE = re.compile(r"\bcatch\s*(?:\([^)]*\))?\s*\{")
STRING_LITERAL_RE = re.compile(
    r"(?P<quote>[\"'`])(?:\\.|(?!(?P=quote)).)*(?P=quote)"
)
FALLBACK_RE = re.compile(
    r"\b(?:fallback|no[- ]?op|noop|skip(?:ped|ping)?|unsupported|not\s+implemented)\b",
    re.IGNORECASE,
)
HIGH_RISK_RE = re.compile(
    r"\b(?:applyDamage|addEffect|spawnEntity|spawnParticle|runCommand|setType|"
    r"teleport|addItem|createExplosion|setOnFire|applyKnockback)\b"
)
AUDIT_ANNOTATION_RE = re.compile(r"\baudit\s*:\s*", re.IGNORECASE)
INTERNAL_PACKAGE_PREFIXES = ("net.thebrokenscript",)
COMMON_RUNTIME_NUMBERS = {
    "0",
    "1",
    "2",
    "3",
    "4",
    "5",
    "10",
    "20",
    "30",
    "60",
    "100",
    "200",
}
UNREACHABLE_DISPOSITIONS = {
    "BP/scripts/core/cooldowns.js": "source-only cooldown helper; no current Bedrock caller",
    "BP/scripts/core/entity_family_registry.js": "audit-support source contract; intentionally not wired into the Bedrock runtime",
    "BP/scripts/core/entity_persistence_policy.js": "audit-support source contract; intentionally not wired into the Bedrock runtime",
    "BP/scripts/core/flags.js": "source-only feature-flag guard; no current Bedrock caller",
    "BP/scripts/core/random.js": "source-only random helper; callers currently use local source-backed predicates",
    "BP/scripts/entities/boss/integrity_camera.js": "engine-limited camera adapter retained for future camera API support",
    "BP/scripts/shared/ids.js": "superseded shared constants; active modules use their explicit namespace tables",
    "BP/scripts/systems/integrity_encounter_model.js": "source-backed pure encounter model retained for regression coverage; live controller owns the runtime state",
}


def _posix(path: Path | str) -> str:
    return str(path).replace("\\", "/").lstrip("./")


def _read_text(path: Path) -> str:
    return path.read_text(encoding="utf-8", errors="replace")


def _load_json(path: Path) -> Any:
    return json.loads(_read_text(path))


def _relative(path: Path, root: Path) -> str:
    return path.resolve().relative_to(root.resolve()).as_posix()


def _finding(
    code: str,
    severity: str,
    message: str,
    **details: Any,
) -> dict[str, Any]:
    finding: dict[str, Any] = {
        "code": code,
        "severity": severity,
        "message": message,
    }
    finding.update(details)
    return finding


def extract_relative_imports(source: str) -> list[str]:
    """Return static relative ES module specifiers in source order."""

    return [match.group("specifier") for match in STATIC_IMPORT_RE.finditer(source)]


def resolve_relative_import(source_path: Path, specifier: str, addon_root: Path) -> Path:
    """Resolve a relative JavaScript import with ``..`` segments normalized.

    Bedrock's script module loader accepts explicit ``.js`` files.  For author
    convenience the audit also checks the extensionless and ``index.js`` forms
    when the specifier does not include an extension.
    """

    if not specifier.startswith("."):
        raise ValueError(f"not a relative import: {specifier}")

    root = addon_root.resolve()
    candidate = (source_path.parent / Path(specifier)).resolve()
    try:
        candidate.relative_to(root)
    except ValueError as exc:
        raise ValueError(f"import escapes add-on root: {specifier}") from exc

    if candidate.suffix:
        return candidate

    js_candidate = candidate.with_suffix(".js")
    if js_candidate.is_file():
        return js_candidate
    index_candidate = candidate / "index.js"
    if index_candidate.is_file():
        return index_candidate
    return js_candidate


def _manifest_entry(addon_root: Path) -> tuple[str | None, str | None]:
    manifest_path = addon_root / "BP/manifest.json"
    if not manifest_path.is_file():
        return None, f"missing {manifest_path.relative_to(addon_root)}"
    try:
        manifest = _load_json(manifest_path)
    except (OSError, json.JSONDecodeError) as exc:
        return None, f"invalid BP/manifest.json: {exc}"
    modules = manifest.get("modules", []) if isinstance(manifest, dict) else []
    if not isinstance(modules, list):
        return None, "BP/manifest.json modules must be an array"
    for module in modules:
        if isinstance(module, dict) and module.get("type") == "script":
            entry = module.get("entry")
            if isinstance(entry, str) and entry:
                return entry, None
    return None, "BP/manifest.json has no script module entry"


def build_runtime_graph(addon_root: Path) -> dict[str, Any]:
    """Build the shipped BP JavaScript import graph from its manifest entry."""

    addon_root = addon_root.resolve()
    scripts_root = addon_root / "BP/scripts"
    script_paths = sorted(scripts_root.rglob("*.js")) if scripts_root.is_dir() else []
    script_by_rel = {
        _relative(path, addon_root): path
        for path in script_paths
    }
    entry, manifest_error = _manifest_entry(addon_root)
    errors: list[str] = []
    if manifest_error:
        errors.append(manifest_error)

    entry_rel: str | None = None
    entry_path: Path | None = None
    if entry:
        entry_path = (addon_root / "BP" / Path(entry)).resolve()
        try:
            entry_rel = _relative(entry_path, addon_root)
        except ValueError:
            errors.append(f"script entry escapes BP: {entry}")
        else:
            if entry_rel not in script_by_rel:
                errors.append(f"missing script entry: {entry}")

    edges: list[dict[str, str]] = []
    missing_imports: list[str] = []
    visited: set[str] = set()
    pending: list[Path] = [entry_path] if entry_path and entry_path.is_file() else []
    while pending:
        current = pending.pop()
        current_rel = _relative(current, addon_root)
        if current_rel in visited:
            continue
        visited.add(current_rel)
        source = _read_text(current)
        for specifier in extract_relative_imports(source):
            try:
                target = resolve_relative_import(current, specifier, addon_root)
            except ValueError as exc:
                missing_imports.append(f"{current_rel} -> {specifier}: {exc}")
                continue
            target_rel = _relative(target, addon_root)
            edges.append({"from": current_rel, "to": target_rel, "specifier": specifier})
            if target_rel not in script_by_rel:
                missing_imports.append(f"{current_rel} -> {specifier}: {target_rel}")
            elif target_rel not in visited:
                pending.append(script_by_rel[target_rel])

    reachable = sorted(visited)
    all_modules = sorted(script_by_rel)
    unreachable = sorted(set(all_modules) - visited)
    return {
        "entry": entry_rel,
        "manifest_errors": errors,
        "module_count": len(all_modules),
        "edge_count": len(edges),
        "edges": sorted(edges, key=lambda edge: (edge["from"], edge["to"])),
        "missing_imports": sorted(set(missing_imports)),
        "reachable_from_manifest": reachable,
        "unreachable_modules": unreachable,
        "unreachable_dispositions": {
            module: UNREACHABLE_DISPOSITIONS.get(module, "review required")
            for module in unreachable
        },
    }


def asset_pattern_matches(path: str, pattern: str) -> bool:
    """Match an extracted source path against an ASSET_MAP glob.

    ``fnmatch`` treats ``*`` as crossing path separators, while the asset map
    uses ``**`` to mean recursive directories.  Handling the recursive portion
    explicitly keeps nested ``geo/plush`` and ``geo/fractured`` content from
    being falsely reported as untracked.
    """

    path = _posix(path)
    pattern = _posix(pattern).split(" (", 1)[0].rstrip("/")
    if not pattern:
        return False
    if "**" in pattern:
        prefix, suffix = pattern.split("**", 1)
        prefix = prefix.rstrip("/")
        suffix = suffix.lstrip("/")
        if prefix and not (path == prefix or path.startswith(prefix + "/")):
            return False
        remainder = path[len(prefix):].lstrip("/") if prefix else path
        if not suffix:
            return True
        return fnmatch.fnmatchcase(remainder, suffix)
    return fnmatch.fnmatchcase(path, pattern) or PurePosixPath(path).match(pattern)


def _asset_families(asset_map: Any) -> list[dict[str, Any]]:
    families = asset_map.get("families", []) if isinstance(asset_map, dict) else []
    return [family for family in families if isinstance(family, dict)]


def _source_map_rows(source_map: Any) -> list[dict[str, Any]]:
    rows = source_map.get("rows", []) if isinstance(source_map, dict) else []
    return [row for row in rows if isinstance(row, dict)]


def _normal_source_ref(value: str) -> str:
    return _posix(value).strip("`").strip()


def _source_row_for_java(
    java_rel: str,
    rows: Iterable[dict[str, Any]],
) -> dict[str, Any] | None:
    """Choose the most specific source-map row for a decompiled class."""

    class_rel = f"{java_rel[:-5]}.class" if java_rel.endswith(".java") else java_rel
    candidates: list[tuple[int, str, dict[str, Any]]] = []
    for row in rows:
        source_id = str(row.get("source_id", ""))
        for raw_ref in row.get("source_paths", []):
            if not isinstance(raw_ref, str):
                continue
            ref = _normal_source_ref(raw_ref)
            if ref.endswith(".class"):
                if class_rel == ref:
                    candidates.append((100_000 + len(ref), source_id, row))
            elif ref:
                exact = java_rel == ref
                prefix = java_rel.startswith(ref.rstrip("/") + "/")
                # The decompiler preserves Java package case while the source
                # inventory was normalized to lowercase for this package.  A
                # case-insensitive fallback is safe only after the exact path
                # lookup has been attempted and still uses longest-prefix wins.
                folded_java = java_rel.casefold()
                folded_ref = ref.casefold()
                folded_exact = folded_java == folded_ref
                folded_prefix = folded_java.startswith(folded_ref.rstrip("/") + "/")
                if exact or prefix:
                    candidates.append((10_000 + len(ref), source_id, row))
                elif folded_exact or folded_prefix:
                    candidates.append((len(ref), source_id, row))
    if not candidates:
        return None
    candidates.sort(key=lambda item: (-item[0], item[1]))
    return candidates[0][2]


def _java_file_record(path: Path, java_root: Path, repository_root: Path) -> dict[str, Any]:
    source = _read_text(path)
    package_match = PACKAGE_RE.search(source)
    package = package_match.group(1) if package_match else ""
    declarations = DECLARATION_RE.findall(source)
    if not declarations:
        declarations = [path.stem]
    fqcn = [f"{package}.{name}" if package else name for name in declarations]
    return {
        "path": _relative(path, repository_root),
        "source_path": _relative(path, java_root),
        "package": package,
        "classes": fqcn,
        "text": source,
    }


def _java_graph(records: list[dict[str, Any]]) -> dict[str, Any]:
    class_to_record: dict[str, dict[str, Any]] = {}
    for record in records:
        for name in record["classes"]:
            class_to_record.setdefault(name, record)

    import_edges: set[tuple[str, str]] = set()
    unresolved_imports: set[str] = set()
    inheritance_edges: set[tuple[str, str]] = set()
    caller_callee_edges: set[tuple[str, str]] = set()

    for record in records:
        source_name = record["classes"][0]
        source = record["text"]
        for imported in IMPORT_RE.findall(source):
            if imported.endswith(".*"):
                continue
            if not imported.startswith(INTERNAL_PACKAGE_PREFIXES):
                continue
            target_name = imported
            target = class_to_record.get(target_name)
            if target is None and "$" in imported:
                # javap/decompiler output often imports a synthetic nested
                # class (Outer$Inner) without emitting a separate .java file.
                # The outer class is the auditable source/runtime unit.
                target_name = imported.split("$", 1)[0]
                target = class_to_record.get(target_name)
            if target is None:
                unresolved_imports.add(f"{source_name} -> {imported}")
                continue
            import_edges.add((source_name, target_name))
            caller_callee_edges.add((source_name, target_name))

        package = record["package"]
        for names in INHERITANCE_RE.findall(source):
            for simple_name in re.split(r"\s*,\s*", names):
                target_name = f"{package}.{simple_name}" if package else simple_name
                target = class_to_record.get(target_name)
                if target is not None:
                    inheritance_edges.add((source_name, target_name))
                    caller_callee_edges.add((source_name, target_name))

    return {
        "class_count": len(class_to_record),
        "internal_import_edges": [
            {"from": source, "to": target}
            for source, target in sorted(import_edges)
        ],
        "inheritance_edges": [
            {"from": source, "to": target}
            for source, target in sorted(inheritance_edges)
        ],
        "caller_callee_edges": [
            {"from": source, "to": target}
            for source, target in sorted(caller_callee_edges)
        ],
        "unresolved_internal_imports": sorted(unresolved_imports),
    }


def audit_java_sources(
    repository_root: Path,
    addon_root: Path,
    source_rows: list[dict[str, Any]],
) -> dict[str, Any]:
    records: list[dict[str, Any]] = []
    mapped: list[dict[str, Any]] = []
    unmapped: list[dict[str, Any]] = []
    scope_counts: Counter[str] = Counter()
    integration_counts: Counter[str] = Counter()
    limitations = "\n".join(
        _read_text(addon_root / name)
        for name in ("KNOWN_LIMITATIONS.md", "ADAPTATION_NOTES.md", "BEDROCK_ARCHITECTURE.md")
        if (addon_root / name).is_file()
    )

    roots = [
        (repository_root / "decompiled", "mod"),
        (repository_root / "decompiled_brokencore", "brokencore"),
    ]
    for java_root, scope in roots:
        paths = sorted(java_root.rglob("*.java")) if java_root.is_dir() else []
        scope_counts[scope] = len(paths)
        for path in paths:
            record = _java_file_record(path, java_root, repository_root)
            record["scope"] = scope
            records.append(record)
            source_row = _source_row_for_java(record["source_path"], source_rows)
            if source_row is None and scope == "brokencore":
                source_row = next(
                    (row for row in source_rows if row.get("source_id") == "lib.brokencore"),
                    None,
                )
            if source_row is None:
                unmapped.append(
                    {
                        "path": record["path"],
                        "source_path": record["source_path"],
                        "classes": record["classes"],
                        "scope": scope,
                    }
                )
                continue
            evidence = [
                value
                for value in source_row.get("bedrock_files", [])
                if isinstance(value, str) and (addon_root / value).exists()
            ]
            if not evidence and scope != "brokencore" and not limitations:
                unmapped.append(
                    {
                        "path": record["path"],
                        "source_path": record["source_path"],
                        "classes": record["classes"],
                        "scope": scope,
                        "reason": "mapped row has no existing Bedrock evidence",
                    }
                )
                continue
            record_without_text = {key: value for key, value in record.items() if key != "text"}
            record_without_text["source_id"] = source_row.get("source_id")
            record_without_text["status"] = source_row.get("status")
            record_without_text["parity"] = source_row.get("parity")
            record_without_text["evidence"] = evidence
            mapped.append(record_without_text)

            path_lower = record["path"].lower()
            for label, terms in {
                "mixins": ("mixin",),
                "event_subscribers": ("event", "subscriber", "listener"),
                "registry_hooks": ("registry", "register"),
                "data_attachments": ("attachment", "dynamic", "state"),
                "inherited_behavior": ("extends", "base", "abstract"),
            }.items():
                if any(term in path_lower or term in record["text"].lower() for term in terms):
                    integration_counts[label] += 1

    graph = _java_graph(records)
    findings: list[dict[str, Any]] = []
    if unmapped:
        findings.append(
            _finding(
                "java-class-unmapped",
                "error",
                f"{len(unmapped)} Java files have no source-map/runtime disposition.",
                samples=unmapped[:20],
            )
        )
    if graph["unresolved_internal_imports"]:
        findings.append(
            _finding(
                "java-import-unresolved",
                "error",
                f"{len(graph['unresolved_internal_imports'])} internal Java imports do not resolve to an audited class.",
                samples=graph["unresolved_internal_imports"][:20],
            )
        )

    coverage = {
        "java_files": len(records),
        "mapped": len(mapped),
        "unmapped": len(unmapped),
        "scope_counts": dict(sorted(scope_counts.items())),
        "mapped_class_records": mapped,
        "unmapped_class_records": unmapped,
    }
    return {
        "coverage": coverage,
        "graph": graph,
        "integration_points": dict(sorted(integration_counts.items())),
        "findings": findings,
    }


def _source_reference_matches(path: str, reference: str) -> bool:
    path = _posix(path)
    reference = _normal_source_ref(reference)
    # Source-map rows may describe a directory with a human-readable count,
    # e.g. ".cache/ (14 hash-named files)".  The parenthetical is metadata,
    # not part of the path, so strip it before applying the directory match.
    reference = re.sub(r"\s+\([^)]*\)$", "", reference).rstrip()
    if not reference:
        return False
    if reference.endswith("/**"):
        return path.startswith(reference[:-3].rstrip("/") + "/")
    if reference.endswith("/"):
        return path.startswith(reference)
    return path == reference


def audit_source_assets(
    repository_root: Path,
    addon_root: Path,
    source_map: Any,
    asset_map: Any,
) -> dict[str, Any]:
    source_root = repository_root / "source_extracted"
    source_files = sorted(path for path in source_root.rglob("*") if path.is_file()) if source_root.is_dir() else []
    rows = _source_map_rows(source_map)
    families = _asset_families(asset_map)
    family_counts: Counter[str] = Counter()
    family_files: dict[str, list[str]] = {}
    unmapped: list[str] = []
    invalid_json: list[dict[str, str]] = []
    source_map_matches = 0

    for path in source_files:
        relative = _relative(path, repository_root / "source_extracted")
        if path.suffix.lower() in {".json", ".mcmeta"}:
            try:
                _load_json(path)
            except (OSError, json.JSONDecodeError) as exc:
                invalid_json.append({"path": relative, "error": str(exc)})

        matched_family: dict[str, Any] | None = None
        for family in families:
            patterns = family.get("source_paths", [])
            if any(
                isinstance(pattern, str) and asset_pattern_matches(relative, pattern)
                for pattern in patterns
            ):
                matched_family = family
                break
        matched_row = any(
            isinstance(reference, str)
            and _source_reference_matches(relative, reference)
            for row in rows
            for reference in row.get("source_paths", [])
            if isinstance(row, dict)
        )
        if matched_family is not None:
            name = str(matched_family.get("asset_family", "unknown"))
            family_counts[name] += 1
            family_files.setdefault(name, []).append(relative)
        elif matched_row:
            source_map_matches += 1
        elif relative in {"pack.mcmeta", "REASSEMBLY_MANIFEST.json"} or relative.startswith("data/"):
            family_counts["source_data_and_metadata"] += 1
            family_files.setdefault("source_data_and_metadata", []).append(relative)
        elif relative.startswith("assets/thebrokenscript/lang/"):
            family_counts["source_localization"] += 1
            family_files.setdefault("source_localization", []).append(relative)
        elif relative.startswith("META-INF/"):
            family_counts["source_loader_metadata"] += 1
            family_files.setdefault("source_loader_metadata", []).append(relative)
        elif relative.endswith(".class"):
            # Compiled Java blobs are retained as source evidence and are
            # covered by the decompiled Java class audit above; they are not
            # Bedrock assets and should not be mistaken for missing pack data.
            family_counts["source_class_artifacts"] += 1
            family_files.setdefault("source_class_artifacts", []).append(relative)
        elif (
            path.stat().st_size == 0
            and relative
            and all(ord(character) == 0x7F for character in relative)
        ):
            # The source extraction contains one zero-byte DEL-named sentinel.
            # It is an archive/extraction artifact, not source content or a
            # runtime asset; retain it for provenance but give it an explicit
            # disposition instead of treating it as an unmapped source file.
            family_counts["source_extraction_artifacts"] += 1
            family_files.setdefault("source_extraction_artifacts", []).append(relative)
        elif relative.startswith("assets/") or relative.endswith((".txt", ".schema.json")):
            # These are source-only text/schema payloads with no directly
            # shipped Bedrock equivalent.  Keep them visible as an explicit
            # disposition instead of silently dropping them from the audit.
            family_counts["source_only_text_and_schema"] += 1
            family_files.setdefault("source_only_text_and_schema", []).append(relative)
        else:
            unmapped.append(relative)

    extension_counts = Counter(path.suffix.lower() or "<no extension>" for path in source_files)

    findings: list[dict[str, Any]] = []
    if invalid_json:
        findings.append(
            _finding(
                "source-json-invalid",
                "warning",
                f"{len(invalid_json)} original extracted JSON files are not parseable.",
                samples=invalid_json[:20],
            )
        )
    if unmapped:
        findings.append(
            _finding(
                "source-asset-unmapped",
                "warning",
                f"{len(unmapped)} original extracted files have no ASSET_MAP or source-map family.",
                samples=unmapped[:40],
            )
        )

    declared_total = None
    if isinstance(asset_map, dict) and isinstance(asset_map.get("summary"), dict):
        value = asset_map["summary"].get("total_source_asset_files_analyzed")
        if isinstance(value, int):
            declared_total = value

    return {
        "source_root_present": source_root.is_dir(),
        "source_file_count": len(source_files),
        "extension_counts": dict(sorted(extension_counts.items())),
        "nbt_file_count": extension_counts.get(".nbt", 0),
        "declared_asset_count": declared_total,
        "family_counts": dict(sorted(family_counts.items())),
        "family_files": {key: sorted(value) for key, value in sorted(family_files.items())},
        "source_map_matched_files": source_map_matches,
        "unmapped_files": unmapped,
        "invalid_json": invalid_json,
        "findings": findings,
    }


def _java_numeric_literals(repository_root: Path) -> set[str]:
    values: set[str] = set()
    for root_name in ("decompiled", "decompiled_brokencore"):
        java_root = repository_root / root_name
        if not java_root.is_dir():
            continue
        for path in java_root.rglob("*.java"):
            values.update(_canonical_numeric(value) for value in NUMBER_RE.findall(_read_text(path)))
    return values


def _canonical_numeric(value: str) -> str:
    value = value.replace("_", "")
    if value.lower().startswith("0x"):
        if value[-1:] in {"l", "L"}:
            value = value[:-1]
        return str(int(value, 16))
    value = value.rstrip("fFdDlL")
    try:
        decimal = Decimal(value)
    except InvalidOperation:
        return value
    if decimal == decimal.to_integral_value():
        return format(decimal, "f").split(".", 1)[0]
    return format(decimal.normalize(), "f")


def _named_numeric_constants(
    paths: Iterable[Path],
    pattern: re.Pattern[str],
    repository_root: Path,
) -> dict[str, list[dict[str, Any]]]:
    constants: dict[str, list[dict[str, Any]]] = {}
    for path in paths:
        source = _read_text(path)
        for match in pattern.finditer(source):
            constants.setdefault(match.group("name"), []).append(
                {
                    "value": _canonical_numeric(match.group("value")),
                    "path": _relative(path, repository_root),
                    "line": _line_number(source, match.start()),
                }
            )
    return constants


def audit_constants(repository_root: Path, addon_root: Path) -> dict[str, Any]:
    java_values = _java_numeric_literals(repository_root)
    java_paths = [
        path
        for root_name in ("decompiled", "decompiled_brokencore")
        for path in (repository_root / root_name).rglob("*.java")
        if path.is_file()
    ]
    occurrences: list[dict[str, Any]] = []
    unmatched: list[dict[str, Any]] = []
    scripts_root = addon_root / "BP/scripts"
    runtime_paths = sorted(scripts_root.rglob("*.js")) if scripts_root.is_dir() else []
    java_named = _named_numeric_constants(java_paths, JAVA_NAMED_CONSTANT_RE, repository_root)
    runtime_named = _named_numeric_constants(runtime_paths, JS_NAMED_CONSTANT_RE, repository_root)
    named_comparisons: list[dict[str, Any]] = []
    named_mismatches: list[dict[str, Any]] = []
    for name in sorted(set(java_named) & set(runtime_named)):
        java_values_for_name = {item["value"] for item in java_named[name]}
        runtime_values_for_name = {item["value"] for item in runtime_named[name]}
        # Repeated generic names such as OFFSET are not a safe cross-feature
        # identity.  Compare only unique values on both sides.
        if (
            len(java_named[name]) != 1
            or len(runtime_named[name]) != 1
            or len(java_values_for_name) != 1
            or len(runtime_values_for_name) != 1
        ):
            continue
        comparison = {
            "name": name,
            "java_value": next(iter(java_values_for_name)),
            "runtime_value": next(iter(runtime_values_for_name)),
            "java_occurrences": java_named[name],
            "runtime_occurrences": runtime_named[name],
        }
        named_comparisons.append(comparison)
        if comparison["java_value"] != comparison["runtime_value"]:
            named_mismatches.append(comparison)
    for path in sorted(scripts_root.rglob("*.js")) if scripts_root.is_dir() else []:
        lines = _read_text(path).splitlines()
        relative = _relative(path, addon_root)
        for line_number, line in enumerate(lines, 1):
            if "version" in line.lower() or "uuid" in line.lower():
                continue
            code_line = STRING_LITERAL_RE.sub("", line.split("//", 1)[0])
            for literal in NUMBER_RE.findall(code_line):
                occurrence = {"path": relative, "line": line_number, "value": literal}
                occurrences.append(occurrence)
                nearby = " ".join(lines[max(0, line_number - 8): min(len(lines), line_number + 3)])
                adapter_justified = bool(
                    re.search(r"(?:source|java|port|adapter|bedrock|engine|fallback|audit|approx)", nearby, re.IGNORECASE)
                )
                normalized_literal = _canonical_numeric(literal)
                if normalized_literal not in java_values and normalized_literal not in COMMON_RUNTIME_NUMBERS and not adapter_justified:
                    unmatched.append(occurrence)

    findings: list[dict[str, Any]] = []
    if unmatched:
        findings.append(
            _finding(
                "runtime-constant-without-java-evidence",
                "warning",
                f"{len(unmatched)} non-trivial JavaScript numeric literals have no exact Java token or adapter annotation.",
                samples=unmatched[:40],
            )
        )
    if named_mismatches:
        findings.append(
            _finding(
                "named-runtime-constant-mismatch",
                "warning",
                f"{len(named_mismatches)} uniquely named Java/Bedrock numeric constants differ.",
                samples=named_mismatches[:20],
            )
        )
    return {
        "java_numeric_value_count": len(java_values),
        "runtime_numeric_occurrence_count": len(occurrences),
        "named_constant_comparison_count": len(named_comparisons),
        "named_constant_mismatches": named_mismatches,
        "unmatched_runtime_constants": unmatched,
        "findings": findings,
    }


def _matching_brace_end(source: str, open_index: int) -> int:
    depth = 0
    quote: str | None = None
    escaped = False
    for index in range(open_index, len(source)):
        char = source[index]
        if quote:
            if escaped:
                escaped = False
            elif char == "\\":
                escaped = True
            elif char == quote:
                quote = None
            continue
        if char in {"'", '"', "`"}:
            quote = char
        elif char == "{":
            depth += 1
        elif char == "}":
            depth -= 1
            if depth == 0:
                return index
    return len(source) - 1


def _line_number(source: str, index: int) -> int:
    return source.count("\n", 0, index) + 1


def _strip_comments(value: str) -> str:
    value = re.sub(r"/\*.*?\*/", "", value, flags=re.DOTALL)
    value = re.sub(r"//[^\n]*", "", value)
    return value.strip()


def find_silent_catches(source: str, path: str) -> list[dict[str, Any]]:
    """Find empty/default catch blocks that do not log, rethrow, or annotate.

    The returned severity is deliberately risk-sensitive for callers that want
    to use the function as a focused lint.  The project audit records these as
    warnings because many are documented best-effort Bedrock API adapters.
    """

    findings: list[dict[str, Any]] = []
    for match in CATCH_RE.finditer(source):
        body_start = match.end() - 1
        body_end = _matching_brace_end(source, body_start)
        body = source[body_start + 1:body_end]
        context_start = max(0, match.start() - 320)
        context = source[context_start:body_end + 1]
        stripped = _strip_comments(body)
        if AUDIT_ANNOTATION_RE.search(body):
            continue
        effective_body = _strip_comments(body)
        has_observable_handling = bool(
            re.search(
                r"\b(?:logger|operationDiagnostics)\.|\b(?:warnOnce|errorOnce)\s*\(|\bconsole\.|\bthrow\b",
                effective_body,
            )
        )
        if has_observable_handling:
            continue
        is_default_control_flow = bool(re.search(r"\b(?:return|continue|break)\b", effective_body))
        try_start = source.rfind("try", max(0, match.start() - 2000), match.start())
        try_body_start = source.find("{", try_start, match.start()) if try_start >= 0 else -1
        try_body = source[try_body_start:match.start()] if try_body_start >= 0 else context
        risk = "high" if HIGH_RISK_RE.search(try_body) else "normal"
        if not stripped or is_default_control_flow:
            findings.append(
                {
                    "code": "silent-catch" if not is_default_control_flow else "silent-fallback-catch",
                    "severity": "error" if risk == "high" and not is_default_control_flow else "warning",
                    "path": path,
                    "line": _line_number(source, match.start()),
                    "risk": risk,
                    "context": re.sub(r"\s+", " ", context).strip()[-360:],
                }
            )
    return findings


def audit_fallbacks(addon_root: Path) -> dict[str, Any]:
    scripts_root = addon_root / "BP/scripts"
    silent_catches: list[dict[str, Any]] = []
    fallback_markers: list[dict[str, Any]] = []
    if scripts_root.is_dir():
        for path in sorted(scripts_root.rglob("*.js")):
            source = _read_text(path)
            relative = _relative(path, addon_root)
            silent_catches.extend(find_silent_catches(source, relative))
            for match in FALLBACK_RE.finditer(source):
                fallback_markers.append(
                    {
                        "path": relative,
                        "line": _line_number(source, match.start()),
                        "text": re.sub(r"\s+", " ", source.splitlines()[_line_number(source, match.start()) - 1]).strip(),
                    }
                )

    findings: list[dict[str, Any]] = []
    if silent_catches:
        high_risk = sum(item.get("risk") == "high" for item in silent_catches)
        findings.append(
            _finding(
                "catch-and-ignore-paths",
                "warning",
                f"{len(silent_catches)} catch/default-fallback paths suppress an exception; {high_risk} surround high-risk gameplay calls.",
                samples=silent_catches[:60],
            )
        )
    return {
        "silent_catch_count": len(silent_catches),
        "high_risk_silent_catch_count": sum(item.get("risk") == "high" for item in silent_catches),
        "silent_catches": silent_catches,
        "fallback_marker_count": len(fallback_markers),
        "fallback_markers": fallback_markers,
        "findings": findings,
    }


def _event_hook_summary(addon_root: Path) -> dict[str, int]:
    counts: Counter[str] = Counter()
    scripts_root = addon_root / "BP/scripts"
    if not scripts_root.is_dir():
        return {}
    for path in scripts_root.rglob("*.js"):
        source = _read_text(path)
        counts["event_subscriptions"] += len(re.findall(r"\b(?:beforeEvents|afterEvents)\b|\.subscribe\s*\(", source))
        counts["scheduler_hooks"] += len(re.findall(r"\bsystem\.(?:run|runInterval|runTimeout|runJob)\s*\(", source))
        counts["registry_calls"] += len(re.findall(r"\b(?:register|registerCustomComponent|registerCommand)\s*\(", source))
        counts["data_attachment_calls"] += len(re.findall(r"\b(?:setDynamicProperty|getDynamicProperty|addTag|setProperty)\s*\(", source))
    return dict(sorted(counts.items()))


def audit_project(repository_root: Path) -> dict[str, Any]:
    """Return a deterministic source-to-runtime audit report for a checkout."""

    repository_root = Path(repository_root).resolve()
    addon_root = repository_root / ADDON_NAME
    findings: list[dict[str, Any]] = []

    source_map_path = addon_root / "SOURCE_MAP.json"
    inventory_path = addon_root / "SOURCE_INVENTORY.json"
    asset_map_path = addon_root / "ASSET_MAP.json"
    try:
        source_map = _load_json(source_map_path)
    except (OSError, json.JSONDecodeError) as exc:
        source_map = {}
        findings.append(_finding("source-map-invalid", "error", str(exc)))
    try:
        source_inventory = _load_json(inventory_path)
    except (OSError, json.JSONDecodeError) as exc:
        source_inventory = {}
        findings.append(_finding("source-inventory-invalid", "error", str(exc)))
    try:
        asset_map = _load_json(asset_map_path)
    except (OSError, json.JSONDecodeError) as exc:
        asset_map = {}
        findings.append(_finding("asset-map-invalid", "error", str(exc)))

    source_rows = _source_map_rows(source_map)
    inventory_entries = (
        source_inventory.get("entries", [])
        if isinstance(source_inventory, dict)
        else []
    )
    if len(source_rows) != len(inventory_entries):
        findings.append(
            _finding(
                "ledger-cardinality-drift",
                "error",
                f"SOURCE_MAP rows ({len(source_rows)}) and SOURCE_INVENTORY entries ({len(inventory_entries)}) differ.",
            )
        )

    java = audit_java_sources(repository_root, addon_root, source_rows)
    runtime = build_runtime_graph(addon_root)
    assets = audit_source_assets(repository_root, addon_root, source_map, asset_map)
    constants = audit_constants(repository_root, addon_root)
    fallbacks = audit_fallbacks(addon_root)
    findings.extend(java["findings"])
    findings.extend(
        _finding("runtime-manifest", "error", message)
        for message in runtime["manifest_errors"]
    )
    if runtime["missing_imports"]:
        findings.append(
            _finding(
                "runtime-import-unresolved",
                "error",
                f"{len(runtime['missing_imports'])} manifest-reachable JavaScript imports do not resolve.",
                samples=runtime["missing_imports"][:30],
            )
        )
    undispositioned = [
        module
        for module in runtime["unreachable_modules"]
        if runtime["unreachable_dispositions"].get(module) == "review required"
    ]
    if undispositioned:
        findings.append(
            _finding(
                "runtime-module-unreachable",
                "warning",
                f"{len(undispositioned)} shipped JavaScript modules are not reachable from the manifest entrypoint and lack a disposition.",
                samples=undispositioned[:40],
            )
        )
    findings.extend(assets["findings"])
    findings.extend(constants["findings"])
    findings.extend(fallbacks["findings"])

    severity_counts = Counter(item["severity"] for item in findings)
    errors = severity_counts.get("error", 0)
    warnings = severity_counts.get("warning", 0)
    return {
        "schema_version": AUDIT_VERSION,
        "audit": "full-source-to-runtime",
        "project": ADDON_NAME,
        "summary": {
            "status": "pass" if errors == 0 else "fail",
            "errors": errors,
            "warnings": warnings,
            "finding_count": len(findings),
        },
        "source_ledger": {
            "source_map_rows": len(source_rows),
            "source_inventory_entries": len(inventory_entries),
            "row_ids": sorted(str(row.get("source_id", "")) for row in source_rows),
        },
        "java": java,
        "runtime": {
            **runtime,
            "hooks": _event_hook_summary(addon_root),
        },
        "assets": assets,
        "constants": constants,
        "fallbacks": fallbacks,
        "findings": sorted(
            findings,
            key=lambda item: (
                {"error": 0, "warning": 1, "info": 2}.get(item.get("severity", "info"), 3),
                item.get("code", ""),
                item.get("message", ""),
            ),
        ),
    }


def _markdown_list(values: Iterable[str], limit: int = 12) -> str:
    values = list(values)
    if not values:
        return "- None"
    lines = [f"- `{value}`" for value in values[:limit]]
    if len(values) > limit:
        lines.append(f"- … {len(values) - limit} more; see the JSON report")
    return "\n".join(lines)


def render_markdown(report: dict[str, Any]) -> str:
    """Render the compact human-readable companion to the JSON report."""

    summary = report["summary"]
    coverage = report["java"]["coverage"]
    graph = report["java"]["graph"]
    runtime = report["runtime"]
    assets = report["assets"]
    fallbacks = report["fallbacks"]
    constants = report["constants"]
    status = "PASS" if summary["status"] == "pass" else "FAIL"
    lines = [
        "# Full source-to-runtime audit",
        "",
        f"**Status:** {status} — {summary['errors']} blocking errors, {summary['warnings']} review warnings.",
        "",
        "This report is generated by `tools/audit_source_to_runtime.py`. It is a static evidence audit; it does not replace an in-game smoke test.",
        "",
        "## Java coverage",
        "",
        "| Scope | Files | Mapped | Unmapped |",
        "| --- | ---: | ---: | ---: |",
    ]
    for scope, count in sorted(coverage["scope_counts"].items()):
        mapped_scope = sum(item.get("scope") == scope for item in coverage["mapped_class_records"])
        unmapped_scope = sum(item.get("scope") == scope for item in coverage["unmapped_class_records"])
        lines.append(f"| `{scope}` | {count} | {mapped_scope} | {unmapped_scope} |")
    lines.extend(
        [
            f"| **Total** | **{coverage['java_files']}** | **{coverage['mapped']}** | **{coverage['unmapped']}** |",
            "",
            f"The Java graph contains {len(graph['caller_callee_edges'])} internal caller/callee or inheritance edges, including {len(graph['inheritance_edges'])} inheritance edges. Unresolved internal imports: **{len(graph['unresolved_internal_imports'])}**.",
            "",
            "Integration-point inventory:",
            "",
        ]
    )
    for name, count in sorted(report["java"]["integration_points"].items()):
        lines.append(f"- `{name}`: {count}")
    lines.extend(
        [
            "",
            "## Runtime graph",
            "",
            f"Manifest entry: `{runtime.get('entry') or 'missing'}`; {runtime['module_count']} JavaScript modules and {runtime['edge_count']} import edges.",
            "",
            f"Reachable from manifest: **{len(runtime['reachable_from_manifest'])}**; unresolved imports: **{len(runtime['missing_imports'])}**; unreachable modules: **{len(runtime['unreachable_modules'])}**.",
            "",
            "The runtime boundary is the behavior-pack script module entry and its early-execution hooks. See the [Bedrock Script API early-execution guidance](https://github.com/MicrosoftDocs/minecraft-creator/blob/main/creator/Documents/scripting/execution-privilege.md) and [startup registration guidance](https://github.com/MicrosoftDocs/minecraft-creator/blob/main/creator/Documents/scripting/custom-commands.md).",
            "",
            "Unreachable-module dispositions:",
            "",
        ]
    )
    for module, disposition in sorted(runtime["unreachable_dispositions"].items()):
        lines.append(f"- `{module}` — {disposition}")
    lines.extend(["", "Runtime hook counts:", ""])
    for name, count in sorted(runtime["hooks"].items()):
        lines.append(f"- `{name}`: {count}")
    lines.extend(
        [
            "",
            "## Original data and assets",
            "",
            f"`source_extracted/` files inspected: **{assets['source_file_count']}**; original NBT files: **{assets['nbt_file_count']}**; retained compiled-class evidence: **{assets['family_counts'].get('source_class_artifacts', 0)}**; files without a family/disposition: **{len(assets['unmapped_files'])}**; invalid JSON: **{len(assets['invalid_json'])}**.",
            "",
            "Family counts:",
            "",
        ]
    )
    for name, count in sorted(assets["family_counts"].items()):
        lines.append(f"- `{name}`: {count}")
    lines.extend(
        [
            "",
            "## Constant and fallback audit",
            "",
            f"Java numeric tokens: {constants['java_numeric_value_count']}; runtime numeric occurrences: {constants['runtime_numeric_occurrence_count']}; uniquely named constant comparisons: {constants['named_constant_comparison_count']}; named mismatches: {len(constants['named_constant_mismatches'])}; unmatched non-trivial runtime literals: {len(constants['unmatched_runtime_constants'])}.",
            "",
            f"Silent/default catches: **{fallbacks['silent_catch_count']}** ({fallbacks['high_risk_silent_catch_count']} around high-risk calls). Fallback/no-op markers: **{fallbacks['fallback_marker_count']}**.",
            "",
            "The complete catch and constant occurrence inventories are retained in the JSON artifact. Adapter warnings require review when a Bedrock API intentionally has no Java equivalent.",
            "",
            "## Blocking findings",
            "",
        ]
    )
    blocking = [item for item in report["findings"] if item.get("severity") == "error"]
    lines.append(_markdown_list([item["message"] for item in blocking]))
    lines.extend(
        [
            "",
            "## Review warnings",
            "",
        ]
    )
    warnings = [item for item in report["findings"] if item.get("severity") == "warning"]
    lines.append(_markdown_list([item["message"] for item in warnings]))
    lines.extend(
        [
            "",
            "## Interpretation",
            "",
            "A passing result means every discovered Java class has a source-map disposition, the manifest-reachable JavaScript graph resolves, and the source ledgers have matching cardinality. It does not assert one-to-one parity for Java-only systems; those remain explicit `blocked`/`excluded` rows in `SOURCE_MAP.json` and `KNOWN_LIMITATIONS.md`.",
            "",
        ]
    )
    return "\n".join(lines)


def _write_report(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content, encoding="utf-8")


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--repo-root", type=Path, default=ROOT)
    parser.add_argument("--report", type=Path, help="write JSON evidence report")
    parser.add_argument("--markdown", type=Path, help="write Markdown evidence report")
    parser.add_argument("--check", action="store_true", help="exit non-zero on structural errors")
    args = parser.parse_args(argv)

    report = audit_project(args.repo_root)
    if args.report:
        _write_report(args.report, json.dumps(report, indent=2, sort_keys=True) + "\n")
    if args.markdown:
        _write_report(args.markdown, render_markdown(report))

    summary = report["summary"]
    print(
        "source-to-runtime audit: "
        f"{summary['status'].upper()} — {summary['errors']} errors, "
        f"{summary['warnings']} warnings; "
        f"{report['java']['coverage']['java_files']} Java files, "
        f"{report['runtime']['module_count']} runtime modules"
    )
    return 1 if args.check and summary["errors"] else 0


if __name__ == "__main__":
    sys.exit(main())
