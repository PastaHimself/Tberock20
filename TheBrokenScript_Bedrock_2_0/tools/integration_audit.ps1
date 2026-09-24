# Chunk 15: integration audit — cross-system consistency checks.
# A. family tags queried by controllers exist on BP entities
# B. dimension ids referenced in JS have BP/dimensions JSONs
# C. thebrokenscript: sounds referenced in JS exist in RP/sound_definitions.json
# D. thebrokenscript: blocks/entities referenced in JS exist in BP
# E. world_state keys referenced in JS exist in DEFAULTS
$ErrorActionPreference = "Stop"
$proj = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$errors = 0
function Fail($m) { $script:errors++; Write-Output ("FAIL: " + $m) }

# gather source JS
$jsFiles = Get-ChildItem (Join-Path $proj "src") -Recurse -File -Filter *.js
$jsText = ($jsFiles | ForEach-Object { Get-Content -LiteralPath $_.FullName -Raw }) -join "`n"

# ── A. families ──
$familiesQueried = [regex]::Matches($jsText, 'families:\s*\[\s*"([^"]+)"') | ForEach-Object { $_.Groups[1].Value } | Select-Object -Unique
$bpEntities = Get-ChildItem (Join-Path $proj "BP\entities") -Filter *.json
$entityFamilies = New-Object System.Collections.Generic.HashSet[string]
foreach ($f in $bpEntities) {
  $j = Get-Content -LiteralPath $f.FullName -Raw | ConvertFrom-Json
  foreach ($fam in $j."minecraft:entity".components."minecraft:type_family".family) { [void]$entityFamilies.Add($fam) }
}
foreach ($q in $familiesQueried) {
  if (-not $entityFamilies.Contains($q)) { Fail "family '$q' queried but no BP entity declares it" }
}
Write-Output ("A. families checked: " + $familiesQueried.Count)

# ── B. dimensions ──
$dimRefs = ([regex]::Matches($jsText, '"(clan_void|null_torture|the_moon|nowhere|limbo|nothing|protected_void|library|concrete|lucid|stage2|void_shadow)"') | ForEach-Object { $_.Groups[1].Value } | Select-Object -Unique)
foreach ($d in $dimRefs) {
  if (-not (Test-Path (Join-Path $proj "BP\dimensions\$d.json"))) { Fail "dimension '$d' referenced but BP/dimensions/$d.json missing" }
}
Write-Output ("B. dimension refs checked: " + $dimRefs.Count)

# ── C+D. every thebrokenscript:<id> string in JS must resolve to a sound, block,
#    entity, item, dimension, or known dynamic-property/particle suffix ──
$soundDefs = (Get-Content (Join-Path $proj "RP\sound_definitions.json") -Raw | ConvertFrom-Json).sound_definitions.PSObject.Properties.Name
$blockIds = Get-ChildItem (Join-Path $proj "BP\blocks") -Filter *.json | ForEach-Object { $_.BaseName }
$entIds = Get-ChildItem (Join-Path $proj "BP\entities") -Filter *.json | ForEach-Object { $_.BaseName }
$itemIds = @()
if (Test-Path (Join-Path $proj "BP\items")) { $itemIds = Get-ChildItem (Join-Path $proj "BP\items") -Filter *.json | ForEach-Object { $_.BaseName } }
$dimIds = Get-ChildItem (Join-Path $proj "BP\dimensions") -Filter *.json | ForEach-Object { $_.BaseName }
$knownSuffixes = @(
  "fixPos","skipFallDamage","ban","arenaActive","arenaPhase1","jim_stage","jim_stage_touch","triangleKickTimer",
  "null_particle",  # particle name, not a sound/asset id
  "integrity_phase","integrity" # dynamic prefixes: startsWith() checks for integrity family
)
$idRefs = [regex]::Matches($jsText, '"thebrokenscript:([a-z_0-9]+)"') | ForEach-Object { $_.Groups[1].Value } | Select-Object -Unique
foreach ($i in $idRefs) {
  if ($soundDefs -contains $i) { continue }
  if ($blockIds -contains $i) { continue }
  if ($entIds -contains $i) { continue }
  if ($itemIds -contains $i) { continue }
  if ($dimIds -contains $i) { continue }
  if ($knownSuffixes -contains $i) { continue }
  Fail "identifier 'thebrokenscript:$i' referenced in JS resolves to no sound/block/entity/item/dimension"
}
Write-Output ("CD. tbs identifier classification checked: " + $idRefs.Count)

# ── E. world_state keys ──
$wsText = Get-Content (Join-Path $proj "src\systems\world_state.js") -Raw
$knownKeys = [regex]::Matches($wsText, '^\s{4}([a-zA-Z_0-9]+):', 'Multiline') | ForEach-Object { $_.Groups[1].Value }
$usedKeys = [regex]::Matches($jsText, 'worldState\.(?:get|set|update)\(\s*"([a-zA-Z_0-9]+)"') | ForEach-Object { $_.Groups[1].Value } | Select-Object -Unique
foreach ($k in $usedKeys) {
  if ($knownKeys -notcontains $k) { Fail "worldState key '$k' used but not declared in DEFAULTS" }
}
Write-Output ("E. world_state keys checked: " + $usedKeys.Count)

Write-Output ""
if ($errors -gt 0) { Write-Output "INTEGRATION AUDIT FAILED with $errors error(s)"; exit 1 }
Write-Output "INTEGRATION AUDIT PASSED"
