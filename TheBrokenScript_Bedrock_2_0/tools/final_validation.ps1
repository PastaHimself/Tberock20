# Chunk 18: final validation sweep — cross-reference checks beyond validate_pack.
$ErrorActionPreference = "Stop"
$proj = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$errors = 0
function Fail($m) { $script:errors++; Write-Output ("FAIL: " + $m) }

# 1. BP entity <-> RP client entity pairing
$bpEnt = Get-ChildItem (Join-Path $proj "BP\entities") -Filter *.json | ForEach-Object { $_.BaseName }
$rpEnt = Get-ChildItem (Join-Path $proj "RP\entity") -Filter *.entity.json | ForEach-Object { $_.BaseName -replace '\.entity$','' }
foreach ($b in $bpEnt) { if ($rpEnt -notcontains $b) { Fail "BP entity '$b' has no RP client entity" } }
foreach ($r in $rpEnt) { if ($bpEnt -notcontains $r) { Fail "RP client entity '$r' has no BP entity" } }
Write-Output ("1. entity pairing checked: " + $bpEnt.Count + " BP / " + $rpEnt.Count + " RP")

# 2. entity texture paths exist on disk
$rpEntityFiles = Get-ChildItem (Join-Path $proj "RP\entity") -Filter *.entity.json
foreach ($f in $rpEntityFiles) {
  $j = Get-Content -LiteralPath $f.FullName -Raw | ConvertFrom-Json
  foreach ($tex in $j."minecraft:client_entity".description.textures.PSObject.Properties) {
    $path = Join-Path (Join-Path $proj "RP") ($tex.Value + ".png")
    if (-not (Test-Path -LiteralPath $path)) { Fail "texture missing for $($f.BaseName): $($tex.Value).png" }
  }
}
Write-Output "2. entity textures verified"

# 3. terrain_texture entries resolve to files
$tt = (Get-Content (Join-Path $proj "RP\terrain_texture.json") -Raw | ConvertFrom-Json).texture_data
foreach ($p in $tt.PSObject.Properties) {
  $t = $p.Value.textures
  $first = if ($t -is [array]) { $t[0] } else { $t }
  $path = Join-Path (Join-Path $proj "RP") ($first + ".png")
  if (-not (Test-Path -LiteralPath $path)) { Fail "terrain_texture '$($p.Name)' -> missing file $first.png" }
}
Write-Output ("3. terrain_texture entries verified: " + $tt.PSObject.Properties.Name.Count)

# 4. item_texture entries resolve to files
$it = (Get-Content (Join-Path $proj "RP\item_texture.json") -Raw | ConvertFrom-Json).texture_data
foreach ($p in $it.PSObject.Properties) {
  $t = $p.Value.textures
  $first = if ($t -is [array]) { $t[0] } else { $t }
  $path = Join-Path (Join-Path $proj "RP") ($first + ".png")
  if (-not (Test-Path -LiteralPath $path)) { Fail "item_texture '$($p.Name)' -> missing file $first.png" }
}
Write-Output ("4. item_texture entries verified: " + $it.PSObject.Properties.Name.Count)

# 5. duplicate identifiers within each registry scope (entity-vs-item sharing allowed)
foreach ($scopeDef in @(@("entities", $bpEnt), @("blocks", (Get-ChildItem (Join-Path $proj "BP\blocks") -Filter *.json | ForEach-Object { $_.BaseName })))) {
  $dups = $scopeDef[1] | Group-Object | Where-Object Count -gt 1
  foreach ($d in $dups) { Fail "duplicate identifier in $($scopeDef[0]): $($d.Name)" }
}
$itemIds = if (Test-Path (Join-Path $proj "BP\items")) { Get-ChildItem (Join-Path $proj "BP\items") -Filter *.json | ForEach-Object { $_.BaseName } } else { @() }
$itemDups = $itemIds | Group-Object | Where-Object Count -gt 1
foreach ($d in $itemDups) { Fail "duplicate identifier in items: $($d.Name)" }
Write-Output "5. identifier uniqueness verified (per-scope)"
# 6. item display_name lang keys exist in BP lang
$langText = Get-Content (Join-Path $proj "BP\texts\en_US.lang") -Raw
$itemFiles = Get-ChildItem (Join-Path $proj "BP\items") -Filter *.json -ErrorAction SilentlyContinue
foreach ($f in $itemFiles) {
  $raw = Get-Content -LiteralPath $f.FullName -Raw
  if ($raw -match '"value":\s*"(item\.thebrokenscript\.[a-z_0-9]+)"') {
    $key = $Matches[1]
    if ($langText -notmatch [regex]::Escape($key)) { Fail "lang key missing in en_US.lang: $key" }
  }
}
Write-Output ("6. item lang keys verified: " + $itemFiles.Count)

# 7. geometry identifiers referenced by blocks/entities exist
$geoIds = New-Object System.Collections.Generic.HashSet[string]
Get-ChildItem (Join-Path $proj "RP\models") -Recurse -Filter *.geo.json | ForEach-Object {
  $j = Get-Content -LiteralPath $_.FullName -Raw | ConvertFrom-Json
  foreach ($g in $j."minecraft:geometry") { [void]$geoIds.Add($g.description.identifier) }
}
$geoRefs = @()
$geoRefs += [regex]::Matches((Get-ChildItem (Join-Path $proj "BP\blocks") -Filter *.json | ForEach-Object { Get-Content -LiteralPath $_.FullName -Raw }) -join "`n", '"minecraft:geometry":\s*"([^"]+)"') | ForEach-Object { $_.Groups[1].Value }
$geoRefs += [regex]::Matches((Get-ChildItem (Join-Path $proj "RP\entity") -Filter *.entity.json | ForEach-Object { Get-Content -LiteralPath $_.FullName -Raw }) -join "`n", '"default":\s*"([^"]+)"') | ForEach-Object { $_.Groups[1].Value } | Where-Object { $_ -like "geometry.*" }
foreach ($g in ($geoRefs | Select-Object -Unique)) {
  if (-not $geoIds.Contains($g)) { Fail "geometry '$g' referenced but not defined in RP models" }
}
Write-Output ("7. geometry refs checked: " + ($geoRefs | Select-Object -Unique).Count)

Write-Output ""
if ($errors -gt 0) { Write-Output "FINAL VALIDATION FAILED with $errors error(s)"; exit 1 }
Write-Output "FINAL VALIDATION PASSED"
