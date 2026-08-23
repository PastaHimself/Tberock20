#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
ADDON_ROOT="$ROOT_DIR/TheBrokenScript_Bedrock_2_0"
DIST_DIR="$ROOT_DIR/dist"
STAGE_DIR="$DIST_DIR/stage"
MCADDON_DIR="$DIST_DIR/mcaddon"
OUTPUT_FILE="$DIST_DIR/The_Broken_Script_2_0.mcaddon"

rm -rf "$DIST_DIR"
mkdir -p "$STAGE_DIR/bp" "$STAGE_DIR/rp" "$MCADDON_DIR"

cp -a "$ADDON_ROOT/BP/." "$STAGE_DIR/bp/"
cp -a "$ADDON_ROOT/RP/." "$STAGE_DIR/rp/"

if [[ ! -f "$STAGE_DIR/bp/manifest.json" ]]; then
  echo "Behavior pack manifest is missing from package staging." >&2
  exit 1
fi
if [[ ! -f "$STAGE_DIR/rp/manifest.json" ]]; then
  echo "Resource pack manifest is missing from package staging." >&2
  exit 1
fi

(
  cd "$STAGE_DIR/bp"
  zip -q -r "$MCADDON_DIR/The_Broken_Script_2_0_BP.mcpack" .
)
(
  cd "$STAGE_DIR/rp"
  zip -q -r "$MCADDON_DIR/The_Broken_Script_2_0_RP.mcpack" .
)
(
  cd "$MCADDON_DIR"
  zip -q "$OUTPUT_FILE" The_Broken_Script_2_0_BP.mcpack The_Broken_Script_2_0_RP.mcpack
)

if [[ ! -s "$OUTPUT_FILE" ]]; then
  echo "Failed to create $OUTPUT_FILE" >&2
  exit 1
fi

unzip -t "$MCADDON_DIR/The_Broken_Script_2_0_BP.mcpack"
unzip -t "$MCADDON_DIR/The_Broken_Script_2_0_RP.mcpack"
unzip -t "$OUTPUT_FILE"
echo "Created $OUTPUT_FILE"
