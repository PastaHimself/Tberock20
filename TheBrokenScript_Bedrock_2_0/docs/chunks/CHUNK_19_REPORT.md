# CHUNK_19_REPORT — Packaging

## Output
`dist/TheBrokenScript_2_0_Bedrock.mcaddon` — **145,789,490 bytes**, **1400 entries**.

## Packaging fix
Original packager used `Compress-Archive`, which on PowerShell 5.1 writes entry names with `\` separators — Minecraft cannot import such archives. Rewrote `tools/package_mcaddon.ps1` to use `System.IO.Compression.ZipFile` directly with normalized `/` separators; added self-verification (separator scan + key-file spot check) to the script.

## Archive verification
| Check | Result |
|---|---|
| Entry separators | all forward-slash |
| Top-level roots | `The Broken Script 2.0 [BP]`, `The Broken Script 2.0 [RP]` |
| Key files | BP/RP manifests, scripts/main.js, blocks/items/dimensions/biomes samples, RP entity+geometry samples present |

## Import notes
- Requires **Beta APIs** experiment enabled (script dep is owner-pinned beta channel).
- Both packs carry matching UUID dependency links from BP → RP.

**PORT COMPLETE.**
