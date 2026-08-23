# Syncs authored scripts from src/ into the Behavior Pack (deployable ES modules).
$ErrorActionPreference = "Stop"
$proj = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$src  = Join-Path $proj "src"
$dst  = Join-Path $proj "BP\scripts"

if (-not (Test-Path $src)) { throw "src/ not found" }
New-Item -ItemType Directory -Force -Path $dst | Out-Null

# Remove previously synced files, then copy current tree (keeps pack clean of stale modules).
Get-ChildItem $dst -Recurse -File -Filter *.js -ErrorAction SilentlyContinue | Remove-Item -Force
$copied = 0
Get-ChildItem $src -Recurse -File -Filter *.js | ForEach-Object {
    $rel = $_.FullName.Substring($src.Length + 1)
    $target = Join-Path $dst $rel
    $targetDir = Split-Path $target -Parent
    if (-not (Test-Path $targetDir)) { New-Item -ItemType Directory -Force -Path $targetDir | Out-Null }
    Copy-Item -LiteralPath $_.FullName -Destination $target -Force
    $copied++
}
Write-Output "synced $copied script file(s) to BP/scripts"
Get-ChildItem $dst -Recurse -File | ForEach-Object { $_.FullName.Replace("$dst\","") -replace "\\","/" }
