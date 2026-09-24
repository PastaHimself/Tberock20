# Chunk 13: convert source recipe JSONs (NeoForge) to Bedrock BP/recipes format.
$ErrorActionPreference = "Stop"
$srcRecipes = "C:\Users\mg4392\Downloads\tbs 2.0\source_extracted\data\thebrokenscript\recipe"
$dst = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0\BP\recipes"
New-Item -ItemType Directory -Force -Path $dst | Out-Null

$converted = 0; $skipped = 0
Get-ChildItem -LiteralPath $srcRecipes -Filter "*.json" | ForEach-Object {
  $name = $_.BaseName
  $r = Get-Content -LiteralPath $_.FullName -Raw | ConvertFrom-Json
  if ($r.type -eq "minecraft:crafting_shapeless") {
    $ings = @()
    foreach ($i in $r.ingredients) {
      $it = if ($i.item) { $i.item } else { $i.tag }
      if ($it -and $it.StartsWith("thebrokenscript:") -or $it.StartsWith("minecraft:")) { $ings += ('{ "item": "' + $it + '" }') }
    }
    $ingStr = $ings -join ",`n      "
    $json = @"
{
  "format_version": "1.21.0",
  "minecraft:recipe_shapeless": {
    "description": { "identifier": "thebrokenscript:$name" },
    "tags": [ "crafting_table" ],
    "ingredients": [
      $ingStr
    ],
    "result": { "item": "$($r.result.id)", "count": $($r.result.count) }
  }
}
"@
    Set-Content -LiteralPath (Join-Path $dst "$name.json") -Value $json -Encoding UTF8
    $converted++
  }
  elseif ($r.type -eq "minecraft:crafting_shaped") {
    $keyLines = @()
    foreach ($p in $r.key.PSObject.Properties) {
      $val = if ($p.Value.item) { $p.Value.item } else { $p.Value.tag }
      $keyLines += ('"' + $p.Name + '": { "item": "' + $val + '" }')
    }
    $keyStr = $keyLines -join ",`n      "
    $patStr = ($r.pattern | ForEach-Object { '"' + $_ + '"' }) -join ",`n    "
    $json = @"
{
  "format_version": "1.21.0",
  "minecraft:recipe_shaped": {
    "description": { "identifier": "thebrokenscript:$name" },
    "tags": [ "crafting_table" ],
    "pattern": [
    $patStr
    ],
    "key": {
      $keyStr
    },
    "result": { "item": "$($r.result.id)", "count": $($r.result.count) }
  }
}
"@
    Set-Content -LiteralPath (Join-Path $dst "$name.json") -Value $json -Encoding UTF8
    $converted++
  } else {
    $skipped++
  }
}
Write-Output "recipes converted=$converted skipped=$skipped"
