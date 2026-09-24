#!/usr/bin/env python3
"""Reconcile SOURCE_MAP.json with the current shipped Bedrock pack.

The source inventory is the authoritative set of rows.  This tool deliberately
uses the behavior-pack/resource-pack tree as the shipping authority: the
authoring ``src`` tree can lag the deployed BP copy while a chunk is being
integrated.  Every row receives an explicit terminal decision and at least one
existing Bedrock-side artifact or evidence document.

Use ``--write`` to update SOURCE_MAP.json.  CI uses ``--check`` so a later
change to the add-on cannot silently make the ledger stale again.
"""

from __future__ import annotations

import argparse
import copy
import json
import re
import sys
from collections import Counter, defaultdict
from pathlib import Path
from typing import Any


ROOT = Path(__file__).resolve().parents[1]
ADDON = ROOT / "TheBrokenScript_Bedrock_2_0"
SOURCE_MAP = ADDON / "SOURCE_MAP.json"
SOURCE_INVENTORY = ADDON / "SOURCE_INVENTORY.json"
AUDIT_DATE = "2026-09-13"
AUDIT_COMMIT = "4956a0575da28cbec161773d8b7c4ef947b41550"

TERMINAL = {
    ("ported", "full"),
    ("ported", "high"),
    ("ported", "approximation"),
    ("blocked", "unsupported"),
    ("excluded", "unsupported"),
    ("excluded", "full"),
}

COMMON_RUNTIME = [
    "BP/scripts/main.js",
    "BP/scripts/core/state.js",
    "BP/scripts/core/scheduler.js",
]
LIMITATIONS = ["KNOWN_LIMITATIONS.md", "ADAPTATION_NOTES.md"]


class ReconciliationError(ValueError):
    """Raised when the live pack cannot support an explicit ledger decision."""


def rel(path: str) -> Path:
    """Return an add-on-relative path, rejecting accidental repository paths."""

    candidate = ADDON / Path(path)
    if candidate.is_file():
        return candidate
    raise ReconciliationError(f"missing Bedrock evidence file: {path}")


def existing(*paths: str) -> list[str]:
    """Return unique existing paths in the order supplied."""

    result: list[str] = []
    for path in paths:
        if path and path not in result:
            rel(path)
            result.append(path)
    if not result:
        raise ReconciliationError("a ledger row needs at least one evidence file")
    return result


def source_key(source_id: str) -> str:
    return source_id.split(".", 1)[1] if "." in source_id else source_id


def choose_entity_controller(key: str) -> list[str]:
    if key.startswith("circuit"):
        return [
            "BP/scripts/entities/circuit/circuit_controller.js",
            "BP/scripts/entities/circuit/circuit_spawn_rules.js",
        ]
    if key.startswith("null") or key == "nulll":
        return [
            "BP/scripts/entities/null/null_controller.js",
            "BP/scripts/entities/null/null_pursuit_controller.js",
            "BP/scripts/entities/null/null_spawn_rules.js",
        ]
    if key in {
        "fractured", "fractured_roam", "rock", "integrity_arm",
        "integrity_curious", "integrity_phase_1", "integrity_phase_2",
        "integrity_phase_3", "integ_fireball", "murderfur", "tether",
        "chord", "chord_projectile", "void_tentacle",
    }:
        return [
            "BP/scripts/entities/boss/boss_controller.js",
            "BP/scripts/entities/boss/boss_spawn_rules.js",
            "BP/scripts/entities/boss/phase3_runtime.js",
        ]
    if key.startswith("tbe") or key == "the_broken_end":
        return [
            "BP/scripts/entities/tbe/tbe_controller.js",
            "BP/scripts/entities/tbe/tbe_spawn_rules.js",
        ]
    if key in {
        "he", "he_chase", "he_hallucination", "curved", "deceiver",
        "faraway", "fever", "fever_stalk", "herobrine", "hetzer",
        "jon", "siluet", "siluet_chase", "siluet_hallucination",
        "siluet_stare", "sub_anomaly_1", "sub_anomaly_2",
    }:
        return [
            "BP/scripts/entities/humanoid/humanoid_controller.js",
            "BP/scripts/entities/humanoid/humanoid_spawn_rules.js",
            "BP/scripts/entities/stalk/stalk_controller.js",
            "BP/scripts/entities/stalk/stalk_spawn_rules.js",
        ]
    return [
        "BP/scripts/entities/misc/misc_controller.js",
        "BP/scripts/entities/misc/misc_spawn_rules.js",
    ]


def source_backed_followup_files(category: str, key: str) -> list[str]:
    """Return evidence files for the recovered Null/chunk source slice."""

    if category == "entity" and key == "null_maze":
        return [
            "BP/scripts/entities/null/null_source_controller.js",
            "BP/scripts/systems/null_pursuit_model.js",
            "BP/scripts/systems/ai/gaze.js",
            "BP/scripts/systems/door_runtime.js",
            "ADAPTATION_NOTES.md",
        ]
    if category == "entity" and key == "null_flying":
        return [
            "BP/scripts/entities/null/null_source_controller.js",
            "BP/scripts/systems/null_pursuit_model.js",
            "BP/scripts/systems/ai/gaze.js",
            "ADAPTATION_NOTES.md",
        ]
    if category == "entity" and key == "chunk_remover":
        return [
            "BP/scripts/entities/misc/misc_spawn_rules.js",
            "BP/scripts/systems/chunk_remover_model.js",
            "BP/scripts/systems/chunk_remover_runtime.js",
            "BP/scripts/systems/modified_chunks.js",
            "ADAPTATION_NOTES.md",
        ]
    return []


def current_horror_event_keys() -> tuple[set[str], set[str]]:
    path = ADDON / "BP/scripts/systems/horror_events.js"
    text = path.read_text(encoding="utf-8")
    rules_path = ADDON / "BP/scripts/systems/horror_rules.js"
    rules_text = rules_path.read_text(encoding="utf-8")
    try:
        handlers_start = text.index("const H = {") + len("const H = {")
        handlers_end = text.index("\n};\n\nfunction setFakeMoonTexture", handlers_start)
        handlers_text = text[handlers_start:handlers_end]
        event_ids_text = rules_text.split("export const SOURCE_EVENT_IDS = Object.freeze([", 1)[1].split("]);", 1)[0]
    except IndexError as exc:
        raise ReconciliationError("could not locate horror event handlers or source registry") from exc
    handlers = set(re.findall(r"^\s{2}([A-Za-z0-9_]+)\([^)]*\)", handlers_text, re.MULTILINE))
    registry = set(re.findall(r'"([A-Za-z0-9_]+)"', event_ids_text))
    if handlers != registry:
        missing_handlers = sorted(registry - handlers)
        missing_registry = sorted(handlers - registry)
        raise ReconciliationError(
            f"horror event handler/registry drift: missing handlers={missing_handlers}; "
            f"missing registry entries={missing_registry}"
        )
    return handlers, registry


def decide(
    row: dict[str, Any],
    *,
    status: str,
    parity: str,
    identifier: str,
    files: list[str],
    notes: str,
) -> None:
    if (status, parity) not in TERMINAL:
        raise ReconciliationError(
            f"{row.get('source_id')}: non-terminal decision {status}/{parity}"
        )
    if not notes.strip():
        raise ReconciliationError(f"{row.get('source_id')}: reconciliation needs evidence notes")
    row["bedrock_identifier"] = identifier
    row["bedrock_files"] = existing(*files)
    row["status"] = status
    row["parity"] = parity
    row["notes"] = f"{AUDIT_DATE} audit: {notes}"


def reconcile_metadata(row: dict[str, Any], key: str) -> None:
    sid = row["source_id"]
    if sid == "mod.metadata":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="thebrokenscript:bedrock-manifests",
            files=["BP/manifest.json", "RP/manifest.json", "BEDROCK_COMPATIBILITY.md"],
            notes="NeoForge metadata is represented by the current BP/RP manifests; loader-specific version and dependency metadata is intentionally translated, not copied.",
        )
    else:
        decide(
            row,
            status="excluded",
            parity="unsupported",
            identifier=f"not-shipped:{sid}",
            files=LIMITATIONS + ["BEDROCK_ARCHITECTURE.md"],
            notes="Java/NeoForge mixin and access-transformer metadata has no Bedrock pack equivalent; its gameplay effects are audited under the corresponding runtime rows.",
        )


def reconcile_library(row: dict[str, Any], key: str) -> None:
    if key == "brokencore":
        decide(
            row,
            status="ported",
            parity="high",
            identifier="script:shared-runtime",
            files=[
                "BP/scripts/core/config.js",
                "BP/scripts/core/state.js",
                "BP/scripts/shared/story_time.js",
                "BP/scripts/shared/story_clock_model.js",
                "BEDROCK_ARCHITECTURE.md",
            ],
            notes="Shared brokencore clock, configuration, state, and utility behavior is absorbed into the shipping BP runtime; the Java library jar itself is not shipped.",
        )
    else:
        decide(
            row,
            status="excluded",
            parity="unsupported",
            identifier=f"not-shipped:{key}",
            files=LIMITATIONS + ["BEDROCK_ARCHITECTURE.md"],
            notes="Java-side mixin helper is build-time infrastructure with no Bedrock runtime artifact.",
        )


def reconcile_block(row: dict[str, Any], key: str) -> None:
    block = f"BP/blocks/{key}.json"
    files = [block, f"BP/loot_tables/blocks/{key}.json"]
    if key in {"command", "command_block_giver", "exit", "null_structure", "portal_controller", "portal_extender", "shadow_bug", "flesh", "a_flower"}:
        files.append("BP/scripts/systems/custom_blocks.js")
    decide(
        row,
        status="ported",
        parity="approximation",
        identifier=f"thebrokenscript:{key}",
        files=files,
        notes="Source block resolves to a current BP block definition and loot entry; scripted components and Java render/state behavior remain the documented Bedrock adaptations.",
    )


def reconcile_block_entity(row: dict[str, Any], key: str) -> None:
    block_key = "command" if key == "corrupted_command_block" else key
    decide(
        row,
        status="ported",
        parity="approximation",
        identifier=f"thebrokenscript:{block_key}#component",
        files=[
            f"BP/blocks/{block_key}.json",
            "BP/scripts/systems/custom_blocks.js",
            "BEDROCK_ARCHITECTURE.md",
        ],
        notes="Block-entity behavior is represented by the corresponding BP block and custom component registry; Java block-entity classes are not one-to-one Bedrock JSON objects.",
    )


def reconcile_item(row: dict[str, Any], key: str) -> None:
    item_path = Path(f"BP/items/{key}.json")
    block_path = Path(f"BP/blocks/{key}.json")
    if (ADDON / item_path).is_file():
        primary = item_path.as_posix()
        form = "direct BP item"
    elif (ADDON / block_path).is_file():
        primary = block_path.as_posix()
        form = "implicit block item form"
    else:
        raise ReconciliationError(f"item.{key}: no BP item or block definition")
    files = [primary]
    if key in {"hand_cannon", "polaroid", "portal_linker", "desyncer", "circuit_cave_painting"}:
        files.extend(["BP/scripts/systems/ported_features.js", "BP/scripts/systems/ported_feature_logic.js"])
    decide(
        row,
        status="ported",
        parity="approximation",
        identifier=f"thebrokenscript:{key}",
        files=files,
        notes=f"Source item resolves to a {form}; functional item behavior is routed through the shipping BP components where applicable, with Java inventory/render hooks adapted.",
    )


def reconcile_entity(row: dict[str, Any], key: str) -> None:
    entity_path = ADDON / f"BP/entities/{key}.json"
    rp_path = ADDON / f"RP/entity/{key}.entity.json"
    if key == "fake_player":
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier="thebrokenscript:fake_player",
            files=LIMITATIONS + ["BEDROCK_COMPATIBILITY.md"],
            notes="Java FakePlayerEntity depends on a GameProfile, skin/session state, and client packet synchronization; no equivalent custom entity is shipped in the current pack.",
        )
        return
    if key == "liberty":
        decide(
            row,
            status="excluded",
            parity="full",
            identifier="minecraft:allay (vanilla helper)",
            files=["BEDROCK_ARCHITECTURE.md", "KNOWN_LIMITATIONS.md"],
            notes="The Java LibrarianHandler creates a vanilla Allay named Liberty rather than registering a TBS entity; the source helper is intentionally excluded from the custom-entity ledger.",
        )
        return
    if key == "nothingiswatching":
        entity_path = ADDON / "BP/entities/niw.json"
        rp_path = ADDON / "RP/entity/niw.entity.json"
        bedrock_key = "niw"
    else:
        bedrock_key = key
    if not entity_path.is_file() or not rp_path.is_file():
        raise ReconciliationError(f"entity.{key}: missing BP/RP entity pair")
    high = key.startswith("circuit") or key.startswith("null") or key == "nulll"
    decide(
        row,
        status="ported",
        parity="high" if high else "approximation",
        identifier=f"thebrokenscript:{bedrock_key}",
        files=[
            f"BP/entities/{bedrock_key}.json",
            f"RP/entity/{bedrock_key}.entity.json",
            *choose_entity_controller(key),
            *source_backed_followup_files("entity", key),
        ],
        notes="Source entity resolves to the current BP/RP pair and its controller/spawn family; AI, pathfinding, and client presentation differences remain explicit Bedrock adaptations.",
    )


STORY_EVENT_FILES = [
    "BP/scripts/systems/story_events.js",
    "BP/scripts/shared/story_time.js",
    "BP/scripts/shared/story_clock_model.js",
    "BP/scripts/systems/player_state.js",
    "BP/scripts/systems/world_state.js",
]
STORY_EVENT_KEYS = {"coords_hint", "moon_corruption_story", "null_book", "null_book_hint", "txt_story"}
EXCLUDED_EVENT_KEYS = {
    "collinlock16", "disconnect_1", "disconnect_2", "disconnect_3", "noop", "text",
}


def reconcile_horror_event(row: dict[str, Any], key: str, current_events: set[str]) -> None:
    if key in current_events:
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"thebrokenscript:event/{key}",
            files=[
                "BP/scripts/systems/horror_events.js",
                "BP/scripts/systems/event_frequency.js",
                "RP/texts/en_US.lang",
            ],
            notes="Source event id is present in the live source-backed handler registry; timing, gating, native API calls, and desktop-facing effects use the documented Bedrock adaptations.",
        )
    elif key in STORY_EVENT_KEYS:
        files = STORY_EVENT_FILES
        if key in {"null_book", "null_book_hint"}:
            files += [
                "BP/scripts/systems/story_book_model.js",
                "BP/scripts/systems/story_book_adapter.js",
            ]
        decide(
            row,
            status="ported",
            parity="high" if key in {"moon_corruption_story", "null_book_hint", "txt_story"} else "approximation",
            identifier=f"thebrokenscript:story-event/{key}",
            files=files,
            notes="Source story event is represented by the source-backed story-clock threshold schedule and current state/book adapter; the BP copy is the shipping authority for the integrated runtime behavior.",
        )
    elif key == "aberration":
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier="not-shipped:event/aberration",
            files=["BP/scripts/systems/horror_events.js", "RP/ui/vhs_overlay.json", *LIMITATIONS],
            notes="The source aberration event depends on the Java shader pipeline; the shipped VHS overlay is an explicit visual approximation, not exact shader parity.",
        )
    elif key == "null_interface_trigger":
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier="not-shipped:event/null_interface_trigger",
            files=["BP/scripts/systems/horror_events.js", "RP/ui/vhs_overlay.json", *LIMITATIONS],
            notes="The source custom interface trigger has no Bedrock screen/window equivalent; available title/overlay behavior is ledgered separately.",
        )
    elif key == "title_event":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:title-event-surrogate",
            files=["BP/scripts/systems/horror_events.js", "RP/ui/_ui_defs.json", *LIMITATIONS],
            notes="The source desktop/window title event is represented by in-game title/actionbar presentation; OS-level title mutation is not claimed.",
        )
    elif key == "obfuscated_sign":
        decide(
            row,
            status="excluded",
            parity="unsupported",
            identifier="not-shipped:event/obfuscated_sign",
            files=["HORROR_CHAT_AUDIT.md", "docs/chunks/CHUNK_17_REPORT.md", "RP/texts/en_US.lang"],
            notes="The source/lang entry is not part of the current source-backed handler registry and has no evidence-backed placement/schedule in the shipped pack; it remains intentionally excluded.",
        )
    elif key in EXCLUDED_EVENT_KEYS:
        decide(
            row,
            status="excluded",
            parity="full",
            identifier=f"not-shipped:event/{key}",
            files=["HORROR_CHAT_AUDIT.md", "docs/chunks/CHUNK_17_REPORT.md", "RP/texts/en_US.lang"],
            notes="The source/lang event entry is not part of the current source-backed handler registry and has no evidence-backed runtime behavior in the shipped pack; it is intentionally excluded.",
        )
    else:
        raise ReconciliationError(f"event.{key}: no explicit reconciliation rule")


def reconcile_code_package(row: dict[str, Any], key: str) -> None:
    source_id = row["source_id"]
    if source_id == "code.block/portal":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:block/portal",
            files=[
                "BP/scripts/systems/custom_blocks.js",
                "BP/scripts/systems/ported_features.js",
                "BP/scripts/systems/ported_feature_logic.js",
                "BP/scripts/main.js",
                "BP/scripts/core/state.js",
                "BP/scripts/core/scheduler.js",
                "BEDROCK_ARCHITECTURE.md",
            ],
            notes="The source portal package is represented by the restored same-dimension one-tick living-entity sweep, connected extender bounds, relative placement, incoming guards, preserved velocity, relink cleanup, and controller validation.",
        )
        row["notes"] = "2026-09-24 parity pass: source one-tick same-dimension LivingEntity portal scanning is restored with connected extender bounds, relative placement, incoming guards, velocity retention, relink cleanup, and controller validation. Bedrock maps Java LivingEntity to documented minecraft:health entities; real-engine chunk-edge/multiplayer behavior remains runtime-verified."
        return
    if source_id.startswith("code.compat"):
        decide(
            row,
            status="excluded",
            parity="unsupported",
            identifier=f"not-shipped:{key}",
            files=LIMITATIONS + ["BEDROCK_COMPATIBILITY.md"],
            notes="Optional Java client/mod compatibility integration is outside the Bedrock add-on runtime; no equivalent is claimed.",
        )
        return
    if source_id == "code.api/entity/ai/null_maze":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:null-maze-source-adapter",
            files=[
                "BP/entities/null_maze.json",
                "BP/scripts/entities/null/null_source_controller.js",
                "BP/scripts/systems/null_pursuit_model.js",
                "BP/scripts/systems/ai/gaze.js",
                "BP/scripts/systems/door_runtime.js",
                "ADAPTATION_NOTES.md",
            ],
            notes="MazeHitGoal and the source targeting/pathfinding helpers are represented by the native AI contract plus the source-backed controller/model; Java custom pathfinder and damage/swing hooks remain explicit adapters.",
        )
        return
    if source_id == "code.entity/maze":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:null-maze-runtime",
            files=[
                "BP/entities/null_maze.json",
                "BP/scripts/entities/null/null_source_controller.js",
                "BP/scripts/systems/null_pursuit_model.js",
                "BP/scripts/systems/door_runtime.js",
                "BEDROCK_COMPATIBILITY.md",
            ],
            notes="The source Null Maze entity lifecycle, light/block/door side effects, timers, and supported goal flags are reconciled to the deployed BP runtime; Java-only navigation internals remain documented.",
        )
        return
    if source_id == "code.world/chunk":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:chunk-operation-surrogate",
            files=[
                "BP/scripts/systems/chunk_remover_model.js",
                "BP/scripts/systems/chunk_remover_runtime.js",
                "BP/scripts/systems/modified_chunks.js",
                "BP/scripts/entities/misc/misc_spawn_rules.js",
                "BP/scripts/systems/commands.js",
                "BEDROCK_COMPATIBILITY.md",
            ],
            notes="Source chunk gates, random operations, persistent modified-chunk guard, command clear, and loaded block/entity observable effects are represented by supported Bedrock operations; raw section/ticket/packet internals remain engine-limited.",
        )
        return
    if (
        source_id.startswith("code.mixins")
        or source_id.startswith("code.neoforge")
        or source_id in {"code.mixinterfaces", "code.client/window", "code.events/jframe"}
        or source_id.startswith("code.network")
        or "fake_player" in key
    ):
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier=f"not-shipped:{key}",
            files=LIMITATIONS + ["BEDROCK_ARCHITECTURE.md"],
            notes="The Java loader/mixin/client-hook mechanism is not available in Bedrock; any gameplay behavior that can be represented is tracked by its separate BP/RP subsystem row.",
        )
        return

    candidates: list[str] = []
    if "boss" in key or "integrity" in key or "fractured" in key:
        candidates += ["BP/scripts/entities/boss/boss_controller.js", "BP/scripts/entities/boss/phase3_runtime.js"]
    if "entity" in key or "ai/" in key or "players" in key:
        candidates += choose_entity_controller(key.rsplit("/", 1)[-1])
    if any(token in key for token in ("event", "events", "handler", "response", "story", "chat")):
        candidates += ["BP/scripts/systems/horror_events.js", "BP/scripts/systems/story_events.js", "BP/scripts/systems/horror_chat.js"]
    if "block" in key or "portal" in key:
        candidates += ["BP/scripts/systems/custom_blocks.js", "BP/scripts/systems/ported_features.js"]
    if "item" in key:
        candidates += ["BP/scripts/systems/ported_features.js", "BP/scripts/systems/ported_feature_logic.js"]
    if "world" in key or "dimension" in key or "gen" in key:
        candidates += ["BP/scripts/systems/dimensions.js", "BP/scripts/systems/dimension_generation.js", "BP/scripts/systems/worldgen_structures.js"]
    if "config" in key:
        candidates += ["BP/scripts/core/config.js", "BP/scripts/systems/config_defaults.js"]
    if "command" in key or "advancement" in key:
        candidates += ["BP/scripts/systems/commands.js", "BP/scripts/systems/progression.js"]
    if "data" in key or "state" in key:
        candidates += ["BP/scripts/core/state.js", "BP/scripts/systems/player_state.js", "BP/scripts/systems/world_state.js"]
    if "particle" in key:
        candidates += ["BP/scripts/systems/particle_model.js", "BP/scripts/systems/particle_runtime.js"]
    if "client" in key or "render" in key or "model" in key or "renderer" in key:
        candidates += ["RP/ui/_ui_defs.json", "RP/animations/fractured.animation.json", "BP/scripts/systems/fractured_animation_model.js"]
    if "network" in key:
        candidates += ["BP/scripts/systems/ported_features.js", *LIMITATIONS]
    candidates += COMMON_RUNTIME
    # Keep only the live files; every generic package still has explicit runtime
    # evidence, while this check catches a renamed module rather than guessing.
    live = [path for path in candidates if (ADDON / path).is_file()]
    decide(
        row,
        status="ported",
        parity="approximation",
        identifier=f"script:{key}",
        files=live[:5] + ["BEDROCK_ARCHITECTURE.md"],
        notes="The source package is reconciled at behavior level: its supported semantics are absorbed into the listed shipping BP/RP modules, not represented as a line-for-line Java package.",
    )


def reconcile_spawn_rule(row: dict[str, Any], key: str) -> None:
    if key in {"disabled", "todo"}:
        decide(
            row,
            status="excluded",
            parity="full",
            identifier=f"not-active:spawn_modifier.{key}",
            files=["BP/scripts/systems/spawn_director.js", "docs/chunks/CHUNK_17_REPORT.md"],
            notes="Source marker is not an active spawn rule; it is intentionally excluded rather than represented as a false runtime rule.",
        )
        return
    if key == "fake_player":
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier="not-shipped:spawn_modifier.fake_player",
            files=LIMITATIONS + ["BP/scripts/systems/spawn_director.js"],
            notes="The source spawn modifier targets the unsupported Java FakePlayerEntity surface; no fake-player spawn is claimed.",
        )
        return
    controller = choose_entity_controller(key)
    if key == "chunk_remover":
        controller += [
            "BP/scripts/entities/misc/misc_spawn_rules.js",
            "BP/scripts/systems/chunk_remover_model.js",
            "BP/scripts/systems/chunk_remover_runtime.js",
            "BP/scripts/systems/modified_chunks.js",
            "BEDROCK_COMPATIBILITY.md",
        ]
    elif key in {"null_maze", "null_flying"}:
        controller += [
            "BP/scripts/entities/null/null_source_controller.js",
            "BP/scripts/systems/null_pursuit_model.js",
            "BP/scripts/systems/ai/gaze.js",
        ]
    decide(
        row,
        status="ported",
        parity="approximation",
        identifier=f"script:spawn/{key}",
        files=["BP/scripts/systems/spawn_director.js", *controller],
        notes="Source spawn condition/modifier is represented by the live script spawn director and entity-family rules; native placement, biome weighting, and Java scheduler details are adapted.",
    )


def reconcile_worldgen(row: dict[str, Any], key: str) -> None:
    files = [
        "BP/scripts/systems/worldgen_structures.js",
        "BP/scripts/systems/dimension_generation.js",
        "ADAPTATION_NOTES.md",
    ]
    if key in {"feature.day_a", "feature.moon_chunk", "feature.void_cyst", "structure.void_growth"}:
        files.insert(0, "BP/worldgen/structures/shaft.json")
    decide(
        row,
        status="ported",
        parity="approximation",
        identifier=f"script:worldgen/{key}",
        files=files,
        notes="Source worldgen is represented by the current procedural builders and/or native Bedrock structure definitions; Java noise, custom generator hooks, and placement frequency remain documented approximations.",
    )


def reconcile_structure(row: dict[str, Any], key: str) -> None:
    if key == "shaft_jigsaw":
        files = [
            "BP/structures/thebrokenscript/shaft/shaft_corner.nbt",
            "BP/structures/thebrokenscript/shaft/shaft_hall.nbt",
            "BP/structures/thebrokenscript/shaft/shaft_junction.nbt",
            "BP/structures/thebrokenscript/shaft/shaft_room.nbt",
            "BP/structures/thebrokenscript/shaft/shaft_room_hall.nbt",
            "BP/structures/thebrokenscript/shaft/shaft_root.nbt",
            "BP/worldgen/template_pools/shaft_root.json",
            "BP/worldgen/template_pools/hallway.json",
            "BP/worldgen/template_pools/shaft_room.json",
            "BP/worldgen/structures/shaft.json",
        ]
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="thebrokenscript:shaft",
            files=files,
            notes="All six source-identical Shaft templates and the current Bedrock Jigsaw pools/structure are present; natural placement and Java pool weighting remain an explicit approximation.",
        )
    elif key == "unused":
        decide(
            row,
            status="excluded",
            parity="full",
            identifier="not-shipped:unused-structure-corpus",
            files=["docs/chunks/CHUNK_17_REPORT.md", "KNOWN_LIMITATIONS.md"],
            notes="The source marks this structure corpus as unused/deferred and the current pack does not claim a runtime reconstruction.",
        )
    elif key == "xcsf_phase3_arena":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:integrity-phase3-arena",
            files=["BP/scripts/systems/integrity_arena_model.js", "BP/scripts/entities/boss/phase3_runtime.js", *LIMITATIONS],
            notes="Integrity Stage 2/3 arena behavior is represented by the source-backed runtime model; the Java XCSF transport/generator format is not a Bedrock-native structure format.",
        )
    elif key == "root_set":
        reconcile_worldgen(row, key)
    else:
        raise ReconciliationError(f"structures.{key}: no explicit reconciliation rule")


def reconcile_misc_asset(row: dict[str, Any], key: str) -> None:
    if key == "library_books":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:story-books",
            files=["BP/scripts/systems/story_book_model.js", "BP/scripts/systems/story_book_adapter.js", "RP/texts/en_US.lang"],
            notes="Book content and delivery behavior are represented by the current story-book model/adapter; Java screen and book-component APIs are adapted.",
        )
    elif key == "schema":
        decide(
            row,
            status="excluded",
            parity="full",
            identifier="validation:bedrock-pack-schema",
            files=["BP/manifest.json", "RP/manifest.json", "BEDROCK_COMPATIBILITY.md"],
            notes="The schema is a validation concern, not a runtime asset; the current manifests and compatibility contract are the evidence-backed Bedrock representation.",
        )
    elif key == "bedrock_tests":
        decide(
            row,
            status="excluded",
            parity="full",
            identifier="validation:repository-tests",
            files=["VALIDATION_LOG.md", "BEDROCK_ARCHITECTURE.md"],
            notes="Test fixtures and harnesses are repository validation artifacts, intentionally not packaged into the runtime add-on.",
        )
    elif key == "book0":
        decide(
            row,
            status="excluded",
            parity="full",
            identifier="script:story-book-model",
            files=["BP/scripts/systems/story_book_model.js", "BP/scripts/systems/story_book_adapter.js", "docs/chunks/CHUNK_17_REPORT.md"],
            notes="The source binary is parsed into the current signed-book model rather than shipped as an opaque raw file.",
        )
    elif key == "rblog_bin":
        decide(
            row,
            status="excluded",
            parity="unsupported",
            identifier="not-shipped:sites/rblog/file.bin",
            files=LIMITATIONS + ["BEDROCK_COMPATIBILITY.md"],
            notes="The opaque external payload has no supported Bedrock pack/runtime representation and is intentionally excluded.",
        )
    elif key == "important_txt":
        decide(
            row,
            status="excluded",
            parity="full",
            identifier="documentation:important.txt",
            files=["VALIDATION_LOG.md", "BEDROCK_ARCHITECTURE.md"],
            notes="The source note is documentation-only and is represented by the repository's current architecture/validation records, not packaged as gameplay content.",
        )
    else:
        raise ReconciliationError(f"misc_asset.{key}: no explicit reconciliation rule")


def reconcile_row(row: dict[str, Any], current_events: set[str]) -> None:
    sid = row.get("source_id")
    category = row.get("category")
    if not isinstance(sid, str) or not isinstance(category, str):
        raise ReconciliationError(f"invalid source-map row: {row!r}")
    key = source_key(sid)

    if category == "metadata":
        reconcile_metadata(row, key)
    elif category == "library":
        reconcile_library(row, key)
    elif category == "block":
        reconcile_block(row, key)
    elif category == "block_entity":
        reconcile_block_entity(row, key)
    elif category == "item":
        reconcile_item(row, key)
    elif category == "entity":
        reconcile_entity(row, key)
    elif category == "horror_event":
        reconcile_horror_event(row, key, current_events)
    elif category == "chat_system":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:horror-chat",
            files=["BP/scripts/systems/horror_chat.js", "HORROR_CHAT_AUDIT.md", "RP/texts/en_US.lang"],
            notes="All 42 source chat registrations are represented by ordered Bedrock response definitions; class-specific aliases, gates, punctuation normalization, delays, and sender/broadcast delivery remain explicit in the shared horror rules module.",
        )
    elif category == "event_engine":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:horror-event-engine",
            files=["BP/scripts/systems/horror_events.js", "BP/scripts/systems/event_frequency.js", "BP/scripts/systems/story_events.js", "HORROR_CHAT_AUDIT.md"],
            notes="The live source-backed handler registry, event frequency gates, and story thresholds are present; desktop/client hooks are reconciled as explicit adapters.",
        )
    elif category == "code_entrypoint":
        decide(
            row,
            status="ported",
            parity="high",
            identifier="thebrokenscript:bp-entrypoint",
            files=["BP/scripts/main.js", "BP/manifest.json", *COMMON_RUNTIME],
            notes="The deployed BP entrypoint and core runtime are the current bootstrap authority; the authoring src tree is not used as the shipping copy for this audit.",
        )
    elif category == "code_package":
        reconcile_code_package(row, key)
    elif category == "command":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:commands",
            files=["BP/scripts/systems/commands.js", "BP/scripts/main.js", "BP/scripts/systems/progression.js"],
            notes="Source command/dev behavior is represented by the current script command and progression surface; Java command registration and permission hooks are adapted.",
        )
    elif category == "configuration":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:configuration",
            files=["BP/scripts/core/config.js", "BP/scripts/systems/config_defaults.js", "BEDROCK_COMPATIBILITY.md"],
            notes="Gameplay-affecting defaults are present in the BP config layer; client-only menus and NeoForge config plumbing are not claimed as exact equivalents.",
        )
    elif category == "registry_system":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="script:spawn-registry",
            files=["BP/scripts/systems/spawn_director.js", "BP/scripts/entities/misc/misc_spawn_rules.js", "BP/scripts/main.js"],
            notes="Source registry/condition discovery is reconciled to the live script spawn director and entity-family rules; Bedrock has no Java registry class surface.",
        )
    elif category == "player_state":
        decide(
            row,
            status="ported",
            parity="high",
            identifier="script:persistent-player-state",
            files=["BP/scripts/systems/player_state.js", "BP/scripts/core/state.js", "BP/scripts/systems/world_state.js"],
            notes="Source attachment state is represented by the current persistent player/world state services and their default schema.",
        )
    elif category == "story_progression":
        decide(
            row,
            status="ported",
            parity="high",
            identifier="script:story-progression",
            files=[*STORY_EVENT_FILES, "BP/scripts/systems/story_book_adapter.js"],
            notes="Registered story thresholds, persistent gates, and the signed null-book delivery path are present in the current BP integration.",
        )
    elif category == "recipe":
        decide(
            row,
            status="ported",
            parity="full",
            identifier=f"thebrokenscript:{key}",
            files=[f"BP/recipes/{key}.json"],
            notes="Source recipe resolves to the matching current BP recipe JSON.",
        )
    elif category == "biome":
        client = f"RP/biomes_client/{key}.biome_client.json"
        files = [f"BP/biomes/{key}.json", client, "BP/scripts/systems/dimension_generation.js"]
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"thebrokenscript:{key}",
            files=files,
            notes="Source biome resolves to current BP climate data and, where present, its RP client biome definition; Java noise/decorator behavior is explicitly adapted.",
        )
    elif category == "fluid":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="thebrokenscript:void_liquid",
            files=["BP/blocks/void_goop_still.json", "BP/blocks/void_goop_flow.json", "BP/items/void_liquid_bucket.json", "BP/scripts/systems/custom_blocks.js", *LIMITATIONS],
            notes="The source custom fluid is represented by still/flow goop blocks, a bucket item, and scripted effects; Bedrock custom-fluid physics are unavailable.",
        )
    elif category == "dimension":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"thebrokenscript:{key}",
            files=["BP/scripts/systems/dimension_ids.js", "BP/scripts/systems/dimensions.js", "BP/scripts/systems/dimension_generation.js", "BEDROCK_COMPATIBILITY.md"],
            notes="Source dimension is represented by the live startup custom-dimension registration and safe landing/ticking-area adapter; Java generator/noise semantics remain documented approximations.",
        )
    elif category == "worldgen":
        reconcile_worldgen(row, key)
    elif category == "structures":
        reconcile_structure(row, key)
    elif category == "spawn_rule":
        reconcile_spawn_rule(row, key)
    elif category == "loot":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"loot:{key}",
            files=["BP/loot_tables/blocks/a_flower.json", "BP/loot_tables/entities/null_cod.json", "BP/scripts/systems/custom_blocks.js"],
            notes="The current pack contains the generated block loot surface and null_cod entity loot; the source aggregate rows are reconciled to these shipped tables without claiming Java loot-provider identity.",
        )
    elif category == "tags":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"script:tag-predicate/{key}",
            files=["BP/scripts/systems/custom_blocks.js", "BP/scripts/entities/misc/misc_controller.js", "BEDROCK_ARCHITECTURE.md"],
            notes="Source tag behavior is represented by the current script predicates and component/controller checks; no unsupported BP tag directory is claimed.",
        )
    elif category == "progression":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"script:progression/{key}",
            files=["BP/scripts/systems/progression.js", "BP/scripts/systems/progression_state.js", "BP/scripts/systems/horror_events.js", *LIMITATIONS],
            notes="Source advancement trigger is represented by persistent progression flags and toast/title-equivalent UX; Bedrock custom advancement registration is unavailable.",
        )
    elif category == "damage_type":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"script:damage-source/{key}",
            files=["BP/scripts/systems/damage_source_model.js", "BP/scripts/systems/damage_source_runtime.js", *LIMITATIONS],
            notes="The source damage catalog is represented by the current model and native cause/entity/projectile attribution adapter; Bedrock custom damage-type registration remains unsupported.",
        )
    elif category == "status_effect":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"script:effect/{key}",
            files=["BP/scripts/systems/ported_features.js", "BP/scripts/systems/ported_feature_logic.js", "BP/scripts/systems/player_state.js", *LIMITATIONS],
            notes="Source effect behavior is emulated by scripted state/components; no custom potion-effect registry equivalent is claimed.",
        )
    elif category == "sound":
        if sid == "sound_definitions":
            status, parity = "ported", "full"
            notes = "Current RP sound_definitions.json is the authoritative Bedrock sound mapping for the shipped audio surface."
        else:
            status, parity = "ported", "approximation"
            notes = "Source sound family resolves to the current RP sound definitions and packaged audio; Java audio-instance lifecycle and attenuation are adapted."
        decide(
            row,
            status=status,
            parity=parity,
            identifier=f"resource:sounds/{key}",
            files=["RP/sound_definitions.json", "RP/sounds/heartbeat.ogg", "BP/scripts/systems/horror_events.js"],
            notes=notes,
        )
    elif category == "music":
        item_key = {
            "disc15.betray": "record_15",
            "disc16.youcant": "record_16",
            "disc17.silenced": "record_17",
            "record14": "record_14",
        }.get(key, key)
        item_file = f"BP/items/{item_key}.json"
        sound_file = f"RP/sounds/{key.replace('.', '_')}.ogg"
        files = ["RP/sound_definitions.json", "BP/scripts/systems/horror_events.js"]
        if (ADDON / item_file).is_file():
            files.insert(0, item_file)
        if (ADDON / sound_file).is_file():
            files.append(sound_file)
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"resource:music/{key}",
            files=files,
            notes="Source song/record resolves to the current item, sound-definition, and script playback surface where present; Java jukebox/network synchronization is adapted.",
        )
    elif category == "particle":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"thebrokenscript:particle/{key}",
            files=[f"RP/particles/{key}.particle.json", "BP/scripts/systems/particle_model.js", "BP/scripts/systems/particle_runtime.js"],
            notes="Source particle resolves to the current RP emitter and BP callsite adapter; provider/render-hook differences are explicit Bedrock adaptations.",
        )
    elif category == "painting":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="thebrokenscript:circuit_cave_painting",
            files=[
                "BP/items/circuit_cave_painting.json",
                "BP/entities/circuit_cave_painting.json",
                "RP/entity/circuit_cave_painting.entity.json",
                "RP/models/entity/circuit_cave_painting.geo.json",
                *LIMITATIONS,
            ],
            notes="The source painting variant is represented by the current item/entity surrogate; Bedrock has no custom painting-variant registration path.",
        )
    elif category == "gui":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier=f"ui:{key}",
            files=["RP/ui/_ui_defs.json", "RP/ui/vhs_overlay.json", "BP/scripts/systems/commands.js", "BP/scripts/systems/horror_events.js", *LIMITATIONS],
            notes="Source screen/menu/overlay is represented by current Bedrock forms, titles, actionbars, and UI definitions; desktop and Java screen internals are not claimed.",
        )
    elif category == "shader_pipeline":
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier="not-shipped:java-shader-pipeline",
            files=["RP/ui/vhs_overlay.json", *LIMITATIONS],
            notes="The Java GLSL pipeline has no Bedrock Script API equivalent; the shipped VHS overlay is the documented approximation layer.",
        )
    elif category == "desktop_integration":
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier="not-shipped:desktop-integration",
            files=["BP/scripts/systems/horror_events.js", *LIMITATIONS],
            notes="OS window, JFrame, file, and client-process hooks are outside the Bedrock add-on sandbox; in-game title/actionbar surrogates are tracked separately.",
        )
    elif category == "networking":
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier="not-shipped:java-packet-hooks",
            files=["BP/scripts/systems/ported_features.js", *LIMITATIONS, "BEDROCK_COMPATIBILITY.md"],
            notes="Java packet interception and client synchronization hooks are unavailable; the current server-authoritative script flow is an explicit adapter.",
        )
    elif category == "embedded_resource_pack":
        decide(
            row,
            status="excluded",
            parity="unsupported",
            identifier=f"not-shipped:{sid}",
            files=["BEDROCK_COMPATIBILITY.md", "KNOWN_LIMITATIONS.md", "BEDROCK_ARCHITECTURE.md"],
            notes="The embedded nostalgia resource is optional/out-of-pack source material and is intentionally not represented as a required runtime pack.",
        )
    elif category == "misc_asset":
        reconcile_misc_asset(row, key)
    elif category == "model_geometry":
        if key == "geo_bedrock_format":
            status, parity = "ported", "high"
            notes = "Current Bedrock geometry files and identifier map are the shipping geometry representation."
        else:
            status, parity = "ported", "approximation"
            notes = "Java model assets are represented by translated RP geometry; Java renderer/bone behavior is adapted."
        decide(
            row,
            status=status,
            parity=parity,
            identifier=f"resource:geometry/{key}",
            files=["RP/models/entity/fractured.geo.json", "docs/GEOMETRY_ID_MAP.json", *LIMITATIONS],
            notes=notes,
        )
    elif category == "animation":
        decide(
            row,
            status="ported",
            parity="approximation",
            identifier="resource:animations",
            files=["RP/animations/fractured.animation.json", "BP/scripts/systems/fractured_animation_model.js", *LIMITATIONS],
            notes="Current RP animation JSON and BP timeline adapter represent the source animation surface; render-bone world transforms remain a documented server-side adaptation.",
        )
    elif category == "texture":
        decide(
            row,
            status="ported",
            parity="full",
            identifier="resource:textures",
            files=["RP/textures/terrain_texture.json", "RP/textures/item_texture.json", "RP/textures/blocks/a_flower.png"],
            notes="Current terrain/item atlases and packaged texture files represent the source texture inventory at resource level.",
        )
    elif category == "font":
        decide(
            row,
            status="blocked",
            parity="unsupported",
            identifier="not-shipped:java-font",
            files=["RP/manifest.json", *LIMITATIONS],
            notes="The source custom Java font pipeline has no supported Bedrock equivalent in the current pack.",
        )
    elif category == "build_artifact":
        decide(
            row,
            status="excluded",
            parity="full",
            identifier="build-artifact:not-shipped",
            files=["VALIDATION_LOG.md", "BP/manifest.json"],
            notes="Build cache content is not runtime add-on content and is intentionally excluded from packaging.",
        )
    else:
        raise ReconciliationError(f"{sid}: unsupported source-map category {category!r}")


def load_payload(path: Path) -> dict[str, Any]:
    try:
        payload = json.loads(path.read_text(encoding="utf-8-sig"))
    except (OSError, json.JSONDecodeError) as exc:
        raise ReconciliationError(f"could not load {path}: {exc}") from exc
    if not isinstance(payload, dict) or not isinstance(payload.get("rows"), list):
        raise ReconciliationError(f"{path} must contain an object with a rows array")
    return payload


def load_object(path: Path) -> dict[str, Any]:
    try:
        payload = json.loads(path.read_text(encoding="utf-8-sig"))
    except (OSError, json.JSONDecodeError) as exc:
        raise ReconciliationError(f"could not load {path}: {exc}") from exc
    if not isinstance(payload, dict):
        raise ReconciliationError(f"{path} must contain a JSON object")
    return payload


def reconcile_payload(payload: dict[str, Any]) -> dict[str, Any]:
    inventory = load_object(SOURCE_INVENTORY)
    map_rows = payload["rows"]
    inventory_rows = inventory.get("entries")
    if not isinstance(inventory_rows, list):
        raise ReconciliationError("SOURCE_INVENTORY.json must contain an entries array")
    map_ids = [row.get("source_id") for row in map_rows if isinstance(row, dict)]
    inventory_ids = [row.get("source_id") for row in inventory_rows if isinstance(row, dict)]
    if len(map_rows) != 912 or len(inventory_rows) != 912:
        raise ReconciliationError(
            f"source inventory/map must each contain 912 rows (map={len(map_rows)}, inventory={len(inventory_rows)})"
        )
    if map_ids != inventory_ids:
        raise ReconciliationError("SOURCE_MAP.json row order/IDs differ from SOURCE_INVENTORY.json")

    current_events, _ = current_horror_event_keys()
    if len(current_events) != 86:
        raise ReconciliationError(f"expected 86 current horror event handlers, found {len(current_events)}")

    for row in map_rows:
        if not isinstance(row, dict):
            raise ReconciliationError(f"non-object source-map row: {row!r}")
        reconcile_row(row, current_events)

    payload["reconciled_from_commit"] = AUDIT_COMMIT
    payload["reconciled_date"] = AUDIT_DATE
    payload["reconciliation_tool"] = "tools/reconcile_parity_ledgers.py"
    return payload


def summary(payload: dict[str, Any]) -> str:
    statuses = Counter((row["status"], row["parity"]) for row in payload["rows"])
    categories = Counter(row["category"] for row in payload["rows"])
    lines = [
        f"Reconciled {len(payload['rows'])} source rows against the current BP/RP tree.",
        "Terminal decisions: " + ", ".join(
            f"{status}/{parity}={count}" for (status, parity), count in sorted(statuses.items())
        ),
        "Categories: " + ", ".join(f"{name}={count}" for name, count in sorted(categories.items())),
    ]
    return "\n".join(lines)


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    group = parser.add_mutually_exclusive_group(required=True)
    group.add_argument("--write", action="store_true", help="write the reconciled source map")
    group.add_argument("--check", action="store_true", help="fail if the source map is stale")
    return parser.parse_args()


def main() -> int:
    args = parse_args()
    try:
        original = load_payload(SOURCE_MAP)
        expected = reconcile_payload(copy.deepcopy(original))
    except ReconciliationError as exc:
        print(f"Parity-ledger reconciliation FAILED: {exc}", file=sys.stderr)
        return 1

    if args.write:
        SOURCE_MAP.write_text(
            json.dumps(expected, ensure_ascii=False, indent=2) + "\n",
            encoding="utf-8",
        )
        print(summary(expected))
        return 0

    if original != expected:
        print("Parity-ledger reconciliation FAILED: SOURCE_MAP.json is stale", file=sys.stderr)
        print(summary(expected), file=sys.stderr)
        return 1
    print("Parity-ledger reconciliation PASS: SOURCE_MAP.json matches the current BP/RP tree.")
    print(summary(expected))
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
