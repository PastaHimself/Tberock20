#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
ADDON_ROOT="$ROOT_DIR/TheBrokenScript_Bedrock_2_0"
DIST_DIR="$ROOT_DIR/dist"
STAGE_DIR="$DIST_DIR/stage"
MCADDON_DIR="$DIST_DIR/mcaddon"
OUTPUT_FILE="$DIST_DIR/The_Broken_Script_2_0.mcaddon"

usage() {
  echo "Usage: $0 [--release]" >&2
}

RELEASE_BUILD=0
case "${1:-}" in
  "")
    ;;
  --release)
    RELEASE_BUILD=1
    shift
    ;;
  -h|--help)
    usage
    exit 0
    ;;
  *)
    usage
    exit 2
    ;;
esac

if (( $# != 0 )); then
  usage
  exit 2
fi

# Routine CI packages a validated artifact, but that is not itself a release build.
# Release packaging must opt in explicitly so unresolved source-map audit state and
# obvious parity-rollup disagreement are rejected before any artifact is staged.
if (( RELEASE_BUILD )); then
  python "$ROOT_DIR/tools/validate_source_map_release.py"
  python "$ROOT_DIR/tools/validate_parity_source_map.py"
fi

rm -rf "$DIST_DIR"
mkdir -p "$STAGE_DIR/bp" "$STAGE_DIR/rp" "$MCADDON_DIR"

cp -a "$ADDON_ROOT/BP/." "$STAGE_DIR/bp/"
cp -a "$ADDON_ROOT/RP/." "$STAGE_DIR/rp/"

# Current Bedrock Jigsaw accepts Structure Templates stored as .nbt or .mcstructure.
# Keep the source-identical Shaft Java NBT templates and their Jigsaw definitions in
# the packaged behavior pack instead of rewriting or stripping authoritative source.

# Normalize generated/legacy source artifacts in the package copy only.
find "$STAGE_DIR" -type f \( -name '*.gif' -o -name '*.json.old' \) -delete
if [[ -f "$STAGE_DIR/rp/sound_definitions.json" ]]; then
  mkdir -p "$STAGE_DIR/rp/sounds"
  mv "$STAGE_DIR/rp/sound_definitions.json" "$STAGE_DIR/rp/sounds/sound_definitions.json"
fi

STAGE_DIR="$STAGE_DIR" node --input-type=module <<'NODE'
import { readFile, readdir, writeFile } from 'node:fs/promises';
import path from 'node:path';

async function walk(dir) {
  for (const entry of await readdir(dir, { withFileTypes: true })) {
    const full = path.join(dir, entry.name);
    if (entry.isDirectory()) {
      await walk(full);
    } else if (entry.isFile() && entry.name.toLowerCase().endsWith('.json')) {
      const bytes = await readFile(full);
      if (bytes.length >= 3 && bytes[0] === 0xef && bytes[1] === 0xbb && bytes[2] === 0xbf) {
        await writeFile(full, bytes.subarray(3));
      }
    }
  }
}

await walk(process.env.STAGE_DIR);
NODE

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
