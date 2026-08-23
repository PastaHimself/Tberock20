# Packages BP + RP into a single .mcaddon archive.
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
Compress-Archive -Path (Join-Path $stage "*") -DestinationPath $tmpZip -CompressionLevel Optimal
Move-Item -LiteralPath $tmpZip -Destination $out -Force
Remove-Item -Recurse -Force $stage

$size = (Get-Item $out).Length
Write-Output "packaged: $out ($size bytes)"
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zip = [System.IO.Compression.ZipFile]::OpenRead($out)
try {
    Write-Output ("archive entries: " + $zip.Entries.Count)
    $roots = $zip.Entries | ForEach-Object { ($_.FullName -split "/")[0] } | Sort-Object -Unique
    Write-Output ("top level: " + ($roots -join ", "))
} finally { $zip.Dispose() }
