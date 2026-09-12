#!/usr/bin/env python3
"""Finalize SOURCE_MAP semantic classifications from the completed parity audit.

The rules intentionally prefer conservative terminal labels over claiming exact parity.
Every rule is tied to CHUNK_17_REPORT.md and/or KNOWN_LIMITATIONS.md. Unknown
categories are a hard error; there is no filename-based fallback.
"""
from __future__ import annotations

import argparse
import json
from collections import Counter
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
ADDON = ROOT / "TheBrokenScript_Bedrock_2_0"
SOURCE_MAP = ADDON / "SOURCE_MAP.json"

# (status, parity, evidence note)
RULES = {
    # Exact/source-equivalent families proven by the category audit.
    "recipe": ("validated", "full", "CHUNK_17_REPORT: 40/40 recipes have Bedrock counterparts."),
    "sound": ("validated", "full", "CHUNK_17_REPORT: source sound definitions/assets are represented by the RP sound catalog."),

    # High-parity runtime/state translations; implementation mechanism differs from Java.
    "code_entrypoint": ("validated", "high", "CHUNK_01/17: lifecycle/bootstrap behavior is re-expressed by the Bedrock script entrypoint/core modules."),
    "config": ("validated", "high", "PARITY_MATRIX/CHUNK_17: gameplay-affecting config defaults are represented by the script config layer."),
    "player_state": ("validated", "high", "PARITY_MATRIX/CHUNK_17: player/world state schema is represented by script dynamic-property state."),
    "registry": ("validated", "high", "CHUNK_17: source registries are represented by Bedrock JSON identifiers and script catalogs."),
    "command": ("validated", "high", "CHUNK_13/17: supported command/fx behavior is exposed through the Bedrock script command surface."),

    # Gameplay-facing ports with documented behavioral/rendering/engine deltas.
    "entity": ("validated", "approximation", "CHUNK_17 and family reports: entity roster is shipped; AI, multipart, camera and presentation deltas are ledgered."),
    "block": ("validated", "approximation", "CHUNK_08/17: 123/123 blocks are represented; non-cube geometry/animation differences are ledgered."),
    "block_entity": ("validated", "approximation", "CHUNK_08/17: source block-entity roles are represented by custom-component/script adapters."),
    "item": ("validated", "approximation", "CHUNK_09/17 and later chunks: source item surface is represented; functional/rendering deltas are ledgered."),
    "horror_event": ("validated", "approximation", "CHUNK_12/17: named horror events map to the gated Bedrock choreography pool with documented schedule/UI deltas."),
    "event_engine": ("validated", "approximation", "CHUNK_12/17: event scheduling/choreography is re-expressed in the Bedrock script event engine."),
    "chat": ("validated", "approximation", "CHUNK_13/17: chat behavior is represented by the Bedrock horror-chat engine; source per-response rule semantics are not claimed 1:1."),
    "fluid": ("validated", "approximation", "KNOWN_LIMITATIONS #3 / A-001: void liquid ships as translucent damaging blocks; custom fluid flow physics is unavailable."),
    "dimension": ("validated", "approximation", "CHUNK_10/17 and BEDROCK_COMPATIBILITY: custom dimensions are retained; Java terrain/sky generator behavior is adapted."),
    "biome": ("validated", "approximation", "CHUNK_11/17: all source biomes are represented; decoration/noise behavior is adapted."),
    "worldgen": ("validated", "approximation", "CHUNK_11/17 and KNOWN_LIMITATIONS #7: source worldgen is represented by native/procedural adapters; Java noise/NBT placement is not 1:1."),
    "structure": ("validated", "approximation", "CHUNK_11/17: source structure families have native/procedural/audited Bedrock representations with remaining placement/tooling deltas."),
    "structures": ("validated", "approximation", "CHUNK_11/17: source structure families have native/procedural/audited Bedrock representations with remaining placement/tooling deltas."),
    "spawn_rule": ("validated", "approximation", "CHUNK_11/17: source spawn conditions are represented by spawn-director/native rules with documented placement differences."),
    "damage_type": ("validated", "approximation", "CHUNK_34 and KNOWN_LIMITATIONS #17: all 15 source damage definitions are catalogued and mapped to native causes/attribution adapters."),
    "status_effect": ("validated", "approximation", "KNOWN_LIMITATIONS #4 / A-002: both source effects ship as script/native-effect adapters; custom effect registration is unavailable."),
    "loot": ("validated", "approximation", "CHUNK_13/17: source loot behavior is represented by Bedrock loot/self-drop definitions with simplified pools."),
    "tags": ("validated", "approximation", "CHUNK_13/17: runtime-relevant tag semantics are represented by Bedrock/script equivalents; unused Java tag files are not reproduced mechanically."),
    "progression": ("validated", "approximation", "CHUNK_13/17 and KNOWN_LIMITATIONS #5: all five progression triggers are wired; advancement UI is replaced by Bedrock presentation."),
    "networking": ("validated", "approximation", "CHUNK_17/KNOWN_LIMITATIONS: source packet intents are represented by server-authoritative script flow where possible; packet transport is not reproducible."),
    "packet": ("validated", "approximation", "CHUNK_17/KNOWN_LIMITATIONS: source packet intents are represented by server-authoritative script flow where possible; packet transport is not reproducible."),
    "packets": ("validated", "approximation", "CHUNK_17/KNOWN_LIMITATIONS: source packet intents are represented by server-authoritative script flow where possible; packet transport is not reproducible."),
    "gui": ("validated", "approximation", "CHUNK_17/KNOWN_LIMITATIONS: source menus/overlays are represented by forms, titles, actionbars and RP UI where supported."),
    "particle": ("validated", "approximation", "CHUNK_36 and KNOWN_LIMITATIONS #18: all nine declared particle resources are represented with documented renderer/provider adapters."),
    "painting": ("validated", "approximation", "KNOWN_LIMITATIONS #6 / A-005: circuit_cave ships as a breakable decorative-entity surrogate with the source texture."),
    "music": ("validated", "approximation", "CHUNK_17: disc/music content is represented; Java network-synchronized playback and deferred jukebox metadata are not claimed exact."),

    # Asset families. These are semantic terminal classifications too, even though
    # validate_parity_ledgers treats them as non-gameplay.
    "texture": ("validated", "high", "CHUNK_03/17: source texture corpus is represented in the RP, with substitutions documented by later chunk reports."),
    "model_geometry": ("validated", "high", "CHUNK_03/17: source model geometry is represented by Bedrock geometry/controller assets with documented render adapters."),
    "animation": ("validated", "high", "CHUNK_03/35: animation assets/timelines are represented in Bedrock; rendered-bone server contact remains an adapter."),

    # Deliberate exclusions / platform-inapplicable source material.
    "metadata": ("excluded", "full", "Chunk 00/01: Java/NeoForge metadata is intentionally replaced by Bedrock manifests and is not a runtime port target."),
    "library": ("excluded", "unsupported", "CHUNK_17: JVM libraries are not shippable in Bedrock; consumed semantics are re-expressed in script modules where relevant."),
    "build_artifact": ("excluded", "full", "Chunk 00/17: source build artifacts are intentionally not shipped; they are not runtime gameplay content."),
    "misc_asset": ("excluded", "full", "CHUNK_17 and KNOWN_LIMITATIONS #12: opaque/non-pack source payloads are intentionally kept out of the Bedrock pack."),
    "embedded_packs": ("excluded", "full", "CHUNK_17 and KNOWN_LIMITATIONS #13: nostalgia override packs are intentionally not merged into the primary RP without a complete safe source."),
    "embedded packs": ("excluded", "full", "CHUNK_17 and KNOWN_LIMITATIONS #13: nostalgia override packs are intentionally not merged into the primary RP without a complete safe source."),
    "font": ("blocked", "unsupported", "KNOWN_LIMITATIONS #9 / A-009: Java custom-font glyph mapping has no verified Bedrock-equivalent mapping."),
    "shader": ("blocked", "unsupported", "KNOWN_LIMITATIONS #2 / A-003: Java GLSL/core-post shader pipeline cannot be loaded by a Bedrock add-on; RP/UI substitutes are separate approximations."),
    "desktop_integration": ("blocked", "unsupported", "KNOWN_LIMITATIONS #1 / A-004: Bedrock add-ons cannot perform the Java mod's native window/JFrame/filesystem/process integration."),
}


def classify(row: dict) -> tuple[str, str, str] | None:
    category = str(row.get("category", "")).strip()
    if category == "code_package":
        evidence = " ".join([str(row.get("source_id", "")), *(str(p) for p in row.get("source_paths") or [])]).lower()
        if "mixin" in evidence:
            return ("blocked", "unsupported", "CHUNK_17 / KNOWN_LIMITATIONS #11: Java/runtime compatibility mixins have no Bedrock runtime equivalent; relevant behavior is absorbed elsewhere when applicable.")
        return ("validated", "approximation", "CHUNK_17: decompiled code-package semantics were extracted and re-expressed across Bedrock script modules; this is behavior-level rather than line-level parity.")
    return RULES.get(category)


def append_note(existing: object, evidence: str) -> str:
    existing_text = str(existing or "").strip()
    marker = f"Semantic audit 2026-09-12: {evidence}"
    if marker in existing_text:
        return existing_text
    return f"{existing_text} | {marker}" if existing_text else marker


def main() -> int:
    parser = argparse.ArgumentParser()
    parser.add_argument("--write", action="store_true", help="write terminal classifications to SOURCE_MAP.json")
    args = parser.parse_args()

    doc = json.loads(SOURCE_MAP.read_text(encoding="utf-8-sig"))
    rows = doc.get("rows")
    if not isinstance(rows, list) or len(rows) != 912:
        raise SystemExit(f"Expected exactly 912 SOURCE_MAP rows, found {len(rows) if isinstance(rows, list) else 'non-array'}")

    unmapped: list[str] = []
    proposed = Counter()
    changed = 0
    for row in rows:
        rule = classify(row)
        if rule is None:
            unmapped.append(f"{row.get('source_id')} [category={row.get('category')!r}]")
            continue
        status, parity, evidence = rule
        proposed[(status, parity)] += 1
        if str(row.get("status", "")).strip().lower() != status or str(row.get("parity", "")).strip().lower() != parity:
            changed += 1
        if args.write:
            row["status"] = status
            row["parity"] = parity
            row["notes"] = append_note(row.get("notes"), evidence)

    print(f"Semantic classification plan: rows={len(rows)} changed={changed} terminal_counts={dict(proposed)}")
    if unmapped:
        print(f"UNMAPPED rows={len(unmapped)}")
        for item in unmapped:
            print(f"- {item}")
        return 1

    if args.write:
        doc["generated_utc"] = "2026-09-12T00:00:00Z"
        doc["note"] = "Semantic audit finalized from CHUNK_17_REPORT, family chunk reports, PARITY_MATRIX, KNOWN_LIMITATIONS, and Bedrock compatibility evidence."
        SOURCE_MAP.write_text(json.dumps(doc, indent=4, ensure_ascii=False) + "\n", encoding="utf-8")
        print(f"Wrote {SOURCE_MAP}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
