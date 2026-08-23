# Static validator for the Bedrock pack pair.
# Usage: powershell -File tools/validate_pack.ps1
$ErrorActionPreference = "Stop"
$proj = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$errors = 0
function Fail($msg) { $script:errors++; Write-Output "ERROR: $msg" }
function Pass($msg) { Write-Output "ok: $msg" }

# 1. All JSON files parse
$jsonFiles = Get-ChildItem (Join-Path $proj "BP"), (Join-Path $proj "RP") -Recurse -File -Filter *.json
foreach ($f in $jsonFiles) {
    try {
        Get-Content -LiteralPath $f.FullName -Raw | ConvertFrom-Json | Out-Null
    } catch {
        Fail "invalid JSON: $($f.FullName) :: $($_.Exception.Message)"
    }
}
Pass "$($jsonFiles.Count) JSON file(s) parsed"

# 2. Manifest structure + UUID uniqueness
$bpM = Get-Content (Join-Path $proj "BP\manifest.json") -Raw | ConvertFrom-Json
$rpM = Get-Content (Join-Path $proj "RP\manifest.json") -Raw | ConvertFrom-Json

if ($bpM.format_version -ne 2) { Fail "BP manifest format_version must be 2 (got $($bpM.format_version))" } else { Pass "BP format_version=2" }
if ($rpM.format_version -ne 2) { Fail "RP manifest format_version must be 2 (got $($rpM.format_version))" } else { Pass "RP format_version=2" }

$uuids = @()
foreach ($m in @($bpM, $rpM)) {
    $uuids += $m.header.uuid
    foreach ($mod in $m.modules) { $uuids += $mod.uuid }
}
if (($uuids | Group-Object | Where-Object Count -gt 1).Count -gt 0) { Fail "duplicate UUIDs in manifests" } else { Pass "$($uuids.Count) unique manifest UUIDs" }

if ($bpM.modules.type -notcontains "data") { Fail "BP missing data module" }
$scriptMod = $bpM.modules | Where-Object type -eq "script"
if (-not $scriptMod) { Fail "BP missing script module" }
else {
    if ($scriptMod.language -ne "javascript") { Fail "script module language must be javascript" }
    if (-not $scriptMod.entry) { Fail "script module missing entry" }
}

# 3. BP -> RP dependency exact match
$dep = $bpM.dependencies | Where-Object { $_.uuid }
if (-not $dep) { Fail "BP has no RP dependency" }
else {
    if ($dep.uuid -ne $rpM.header.uuid) { Fail "BP dep uuid != RP header uuid" }
    elseif ("$($dep.version -join '.')" -ne "$($rpM.header.version -join '.')") { Fail "BP dep version != RP header version" }
    else { Pass "BP->RP dependency matches header uuid+version" }
}

# 4. Script API dependencies: version is user-managed (pinned for GitHub workflow).
#    Report only; never fail regardless of channel/format.
foreach ($d in $bpM.dependencies | Where-Object module_name) {
    Pass "script dep (user-managed): $($d.module_name) $($d.version)"
}

# 5. Script entry + module files exist; import paths resolve
$entryRel = $scriptMod.entry
$entryPath = Join-Path $proj "BP\$entryRel"
if (-not (Test-Path $entryPath)) { Fail "script entry missing: $entryRel" } else { Pass "script entry exists: $entryRel" }

$jsFiles = Get-ChildItem (Join-Path $proj "src") -Recurse -File -Filter *.js
foreach ($f in $jsFiles) {
    $text = Get-Content -LiteralPath $f.FullName -Raw
    # balanced braces heuristic
    $open = ([regex]::Matches($text, "\{")).Count
    $close = ([regex]::Matches($text, "\}")).Count
    if ($open -ne $close) { Fail "unbalanced braces in $($f.Name): $open vs $close" }
    # resolve relative imports
    foreach ($m in [regex]::Matches($text, 'from\s+"(\.[^"]+)"')) {
        $imp = $m.Groups[1].Value
        $resolved = Join-Path (Split-Path $f.FullName -Parent) ($imp -replace "/", "\")
        if (-not (Test-Path $resolved)) { Fail "unresolved import '$imp' in $($f.Name)" }
    }
    # synced copy exists
    $rel = $f.FullName.Substring((Join-Path $proj "src").Length + 1)
    if (-not (Test-Path (Join-Path $proj "BP\scripts\$rel"))) { Fail "not synced to BP/scripts: $rel" }
}
Pass "$($jsFiles.Count) source module(s): braces balanced, imports resolved, synced"

# 6. Required meta files
foreach ($p in @("BP\pack_icon.png", "RP\pack_icon.png", "BP\texts\en_US.lang", "RP\texts\en_US.lang")) {
    if (Test-Path (Join-Path $proj $p)) { Pass "present: $p" } else { Fail "missing: $p" }
}

Write-Output ""
if ($errors -gt 0) { Write-Output "VALIDATION FAILED with $errors error(s)"; exit 1 }
Write-Output "VALIDATION PASSED"
