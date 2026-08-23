$ErrorActionPreference = "Stop"
$a = "C:\Users\mg4392\Downloads\tbs 2.0\source_extracted\assets\thebrokenscript"

"=== sounds.json sample ==="
$sj = Get-Content (Join-Path $a "sounds.json") -Raw | ConvertFrom-Json
"total sound events: $($sj.PSObject.Properties.Name.Count)"
$i = 0
foreach ($p in $sj.PSObject.Properties) {
    if ($i -ge 3) { break }
    $json = ($p.Value | ConvertTo-Json -Depth 4 -Compress)
    if ($json.Length -gt 240) { $json = $json.Substring(0, 240) }
    "{0} => {1}" -f $p.Name, $json
    $i++
}

"=== particle sample ==="
$pf = Get-ChildItem (Join-Path $a "particles") -Filter *.json | Select-Object -First 1
Get-Content $pf.FullName -TotalCount 22
"...($($pf.Name))"

"=== mcmeta files ==="
Get-ChildItem $a -Recurse -Filter *.mcmeta | ForEach-Object {
    $raw = (Get-Content $_.FullName -Raw).Trim()
    if ($raw.Length -gt 110) { $raw = $raw.Substring(0, 110) }
    "{0}: {1}" -f $_.FullName.Replace("$a\", ""), $raw
}

"=== java block model sample ==="
$bf = Get-ChildItem (Join-Path $a "models\block") -Filter *.json | Where-Object Name -notlike "*vein*" | Select-Object -First 1
Get-Content $bf.FullName -TotalCount 14
"...($($bf.Name))"

"=== java item model sample ==="
$if = Get-ChildItem (Join-Path $a "models\item") -Filter *.json | Select-Object -First 1
Get-Content $if.FullName -TotalCount 10
"...($($if.Name))"

"=== blockstate sample ==="
$bsf = Get-ChildItem (Join-Path $a "blockstates") -Filter *.json | Select-Object -First 1
Get-Content $bsf.FullName -TotalCount 12
"...($($bsf.Name))"

"=== geo identifiers ==="
Get-ChildItem (Join-Path $a "geo") -Recurse -Filter *.json | Select-Object -First 6 | ForEach-Object {
    $g = Get-Content $_.FullName -Raw | ConvertFrom-Json
    $id = $g."minecraft:geometry"[0].description.identifier
    "{0} -> {1}" -f $_.Name, $id
}

"=== animation files ==="
(Get-ChildItem (Join-Path $a "animations") -Filter *.json).Count
