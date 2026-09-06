# Packages BP + RP into a single .mcaddon archive.
# Uses System.IO.Compression directly so entry names use '/' (Compress-Archive
# on PS5.1 writes '\' which Minecraft cannot import).
$ErrorActionPreference = "Stop"
$proj   = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$stage  = Join-Path $env:TEMP ("tbs_pack_" + [guid]::NewGuid().ToString("N"))
$outDir = Join-Path $proj "dist"
New-Item -ItemType Directory -Force -Path $stage, $outDir | Out-Null

Copy-Item -Recurse -Force (Join-Path $proj "BP") (Join-Path $stage "The Broken Script 2.0 [BP]")
Copy-Item -Recurse -Force (Join-Path $proj "RP") (Join-Path $stage "The Broken Script 2.0 [RP]")

$out = Join-Path $outDir "TheBrokenScript_2_0_Bedrock.mcaddon"
$tmpZip = "$out.zip"
if (Test-Path $out) { Remove-Item $out -Force }
if (Test-Path $tmpZip) { Remove-Item $tmpZip -Force }

Add-Type -AssemblyName System.IO.Compression
Add-Type -AssemblyName System.IO.Compression.FileSystem

$zip = [System.IO.Compression.ZipFile]::Open($tmpZip, [System.IO.Compression.ZipArchiveMode]::Create)
try {
    Get-ChildItem -LiteralPath $stage -Recurse -File | ForEach-Object {
        $rel = $_.FullName.Substring($stage.Length + 1).Replace('\', '/')
        [System.IO.Compression.ZipFileExtensions]::CreateEntryFromFile($zip, $_.FullName, $rel, [System.IO.Compression.CompressionLevel]::Optimal) | Out-Null
    }
} finally { $zip.Dispose() }

Move-Item -LiteralPath $tmpZip -Destination $out -Force
Remove-Item -Recurse -Force $stage

$size = (Get-Item -LiteralPath $out).Length
Write-Output "packaged: $out ($size bytes)"

# verify: entry count, top-level roots, forward slashes only, key files present
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zip = [System.IO.Compression.ZipFile]::OpenRead($out)
try {
    Write-Output ("archive entries: " + $zip.Entries.Count)
    $badSep = @($zip.Entries | Where-Object { $_.FullName -match '\\' }).Count
    if ($badSep -gt 0) { Write-Output "FAIL: $badSep entries use backslash separators"; exit 1 }
    Write-Output "separator check: all forward-slash"
    $roots = $zip.Entries | ForEach-Object { ($_.FullName -split "/")[0] } | Sort-Object -Unique
    Write-Output ("top level: " + ($roots -join ", "))
    foreach ($k in @(
        "The Broken Script 2.0 [BP]/manifest.json",
        "The Broken Script 2.0 [RP]/manifest.json",
        "The Broken Script 2.0 [BP]/scripts/main.js",
        "The Broken Script 2.0 [BP]/blocks/mono_slab.json",
        "The Broken Script 2.0 [BP]/items/polaroid.json",
        "The Broken Script 2.0 [BP]/dimensions/clan_void.json",
        "The Broken Script 2.0 [BP]/biomes/limbo.json",
        "The Broken Script 2.0 [RP]/entity/the_broken_end.entity.json",
        "The Broken Script 2.0 [RP]/models/blocks/tbs_cross.geo.json"
    )) {
        $found = $zip.Entries | Where-Object { $_.FullName -eq $k }
        if (-not $found) { Write-Output "FAIL: missing in archive: $k"; exit 1 }
    }
    Write-Output "key-file spot check: PASS"
} finally { $zip.Dispose() }
Write-Output "PACKAGE OK"
