"""Generate fixed UV regions for the Java screen sprite sheets in Bedrock JSON UI.

The original PNGs stay byte-for-byte intact. Each frame is selected by the
per-player title protocol in BP/scripts/systems/screen_overlay.js.
"""

import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
UI = ROOT / "TheBrokenScript_Bedrock_2_0/RP/ui/tbs_screens.json"

SHEETS = {
    "tbe_curious": (4, 1, 642, 481),
    "transition": (22, 3, 640, 480),
    "oblit_2_effect": (5, 1, 640, 480),
}
MENU_SCREENS = ("nullinterface", "null_interface_2", "nullinterface_3", "nulled_gui")
# Creator Tools rejects paths longer than 100 characters. Keep the source
# screen ID while storing this one unusually long filename under a short path.
SHORT_PATH_SCREENS = {
    "very_serious/what_if_garfunkle_was_betrayed_and_sealed_for_a_thousand_years": "garfunkle_sealed",
}


def build():
    # The usual still-image path is derived from the title's source filename.
    # Animated IDs have their own fixed UV controls so the original atlas is
    # never stretched across the entire viewport.
    animation_check = " and ".join(
        f"((#hud_title_text_string - 'tbs:screen/{name}/') = #hud_title_text_string)"
        for name in SHEETS
    )
    menu_check = " and ".join(
        f"not (#hud_title_text_string = 'tbs:screen/{name}')"
        for name in (*MENU_SCREENS, *SHORT_PATH_SCREENS)
    )
    texture_binding = {
        "binding_type": "view",
        "binding_condition": "visible",
        "source_property_name": (
            "('textures/ui/tbs/screens/' + "
            "(#hud_title_text_string - 'tbs:screen/'))"
        ),
        "target_property_name": "#texture",
    }
    controls = {
        "namespace": "tbs_screens",
        "fullscreen": {
            "type": "image", "texture": "#texture", "size": ["100%", "100%"],
            "fill": True, "layer": 30,
            "bindings": [
                {"binding_name": "#hud_title_text_string", "binding_type": "global"},
                {
                    "binding_type": "view",
                    "source_property_name": (
                        "(not ((#hud_title_text_string - 'tbs:screen/') = #hud_title_text_string) "
                        "and not (#hud_title_text_string = 'tbs:screen/clear') "
                        f"and {animation_check} and {menu_check})"
                    ),
                    "target_property_name": "#visible",
                },
                texture_binding,
            ],
        },
        "menu": {
            "type": "image", "texture": "#texture", "size": [176, 166],
            "anchor_from": "center", "anchor_to": "center", "layer": 30,
            "bindings": [
                {"binding_name": "#hud_title_text_string", "binding_type": "global"},
                {
                    "binding_type": "view",
                    "source_property_name": "(" + " or ".join(
                        f"(#hud_title_text_string = 'tbs:screen/{name}')"
                        for name in MENU_SCREENS
                    ) + ")",
                    "target_property_name": "#visible",
                },
                texture_binding,
            ],
        },
        "animated": {
            "type": "panel", "size": ["100%", "100%"], "layer": 30,
            "controls": [],
        },
    }
    for source_id, short_name in SHORT_PATH_SCREENS.items():
        controls[f"short_path_{short_name}"] = {
            "type": "image", "size": ["100%", "100%"], "fill": True,
            "layer": 30, "texture": f"textures/ui/tbs/screens/{short_name}",
            "bindings": [
                {"binding_name": "#hud_title_text_string", "binding_type": "global"},
                {
                    "binding_type": "view",
                    "source_property_name": f"(#hud_title_text_string = 'tbs:screen/{source_id}')",
                    "target_property_name": "#visible",
                },
            ],
        }
    for name, (frames, columns, width, height) in SHEETS.items():
        for index in range(frames):
            frame = index + 1
            controls["animated"]["controls"].append({
                f"{name}_frame_{frame}": {
                    "type": "image", "size": ["100%", "100%"], "fill": True,
                    "texture": f"textures/ui/tbs/screens/{name}",
                    "uv": [(index % columns) * width, (index // columns) * height],
                    "uv_size": [width, height],
                    "bindings": [
                        {"binding_name": "#hud_title_text_string", "binding_type": "global"},
                        {
                            "binding_type": "view",
                            "source_property_name": f"(#hud_title_text_string = 'tbs:screen/{name}/{frame}')",
                            "target_property_name": "#visible",
                        },
                    ],
                }
            })
    return controls


if __name__ == "__main__":
    UI.write_text(json.dumps(build(), indent=2) + "\n", encoding="utf-8")
