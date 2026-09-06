# Builds the RP asset foundation from the extracted source tree.
# Re-runnable: regenerates generated files, re-copies assets.
$ErrorActionPreference = "Stop"
Add-Type -AssemblyName System.IO.Compression.FileSystem

$src  = "C:\Users\mg4392\Downloads\tbs 2.0\source_extracted\assets\thebrokenscript"
$proj = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$rp   = Join-Path $proj "RP"
$docs = Join-Path $proj "docs"
New-Item -ItemType Directory -Force -Path "$rp\sounds", "$rp\textures", "$rp\models\entity", "$rp\animations", "$rp\texts", $docs | Out-Null

function Write-JsonFile([string]$path, $obj) {
    $json = $obj | ConvertTo-Json -Depth 10
    [System.IO.File]::WriteAllText($path, $json, (New-Object System.Text.UTF8Encoding($false)))
}

function Copy-Tree([string]$from, [string]$to) {
    if (-not (Test-Path $from)) { return 0 }
    $files = Get-ChildItem $from -Recurse -File
    foreach ($f in $files) {
        $rel = $f.FullName.Substring($from.Length + 1)
        $target = Join-Path $to $rel
        $tdir = Split-Path $target -Parent
        if (-not (Test-Path $tdir)) { New-Item -ItemType Directory -Force -Path $tdir | Out-Null }
        Copy-Item -LiteralPath $f.FullName -Destination $target -Force
    }
    return $files.Count
}

# ---------------------------------------------------------------- 1. sounds
$nSounds = Copy-Tree (Join-Path $src "sounds") (Join-Path $rp "sounds")
"copied $nSounds sound files"

# ------------------------------------------------- 2. sound_definitions.json
$categoryByFolder = @{
    ambience = "ambient"; music = "music"; boss = "hostile"; null = "hostile"
    fever = "hostile"; integrity = "hostile"; jimmy = "hostile"; oblit = "hostile"
    curved = "hostile"; plush = "player"; sfx = "ui"; tekkit = "player"
    chords = "neutral"; jon = "neutral"; funny = "neutral"; e = "neutral"
    lucid_blocks_easteregg = "record"
}
$soundsJson = Get-Content (Join-Path $src "sounds.json") -Raw | ConvertFrom-Json
$defs = [ordered]@{}
$skippedVanillaRefs = 0
foreach ($p in $soundsJson.PSObject.Properties) {
    $evt = $p.Name
    $rawSounds = $p.Value.sounds
    if ($null -eq $rawSounds) { continue }
    $outSounds = New-Object System.Collections.Generic.List[object]
    foreach ($s in $rawSounds) {
        if ($s -is [string]) { $name = $s; $extra = @{} }
        else { $name = $s.name; $extra = @{ stream = $s.stream; volume = $s.volume; pitch = $s.pitch; weight = $s.weight } }
        if ($null -eq $name) { continue }
        if ($name.StartsWith("thebrokenscript:")) {
            $rel = $name.Substring("thebrokenscript:".Length)
        } elseif ($name.StartsWith("minecraft:")) {
            $skippedVanillaRefs++; continue
        } else {
            $rel = $name
        }
        $bedName = "sounds/$rel"
        $entry = [ordered]@{ name = $bedName }
        foreach ($k in @("stream","volume","pitch","weight")) {
            if ($null -ne $extra[$k] -and $extra[$k] -ne $false) { $entry[$k] = $extra[$k] }
        }
        $outSounds.Add($entry)
    }
    if ($outSounds.Count -eq 0) { continue }
    $folder = ($evt -split "[/.]")[0]
    $category = if ($categoryByFolder.ContainsKey($folder)) { $categoryByFolder[$folder] } else { "neutral" }
    $defs[$evt] = [ordered]@{ category = $category; sounds = $outSounds }
}
Write-JsonFile (Join-Path $rp "sound_definitions.json") ([ordered]@{
    format_version = "1.14.0"
    sound_definitions = $defs
})
"wrote sound_definitions.json: $($defs.Count) events (vanilla-ns refs skipped: $skippedVanillaRefs)"

# --------------------------------------------------------------- 3. textures
$nTex = Copy-Tree (Join-Path $src "textures") (Join-Path $rp "textures")
"copied $nTex texture files"

# ------------------------------------ 4/5. terrain + item texture atlases
function Build-AtlasKeys([string]$modelsDir) {
    $keys = @{}
    if (Test-Path $modelsDir) {
        foreach ($f in (Get-ChildItem $modelsDir -Recurse -Filter *.json)) {
            try { $m = Get-Content $f.FullName -Raw | ConvertFrom-Json } catch { continue }
            if ($null -eq $m.textures) { continue }
            foreach ($prop in $m.textures.PSObject.Properties) {
                $v = $prop.Value
                if ($v -isnot [string]) { continue }
                if (-not $v.StartsWith("thebrokenscript:")) { continue }
                $rest = $v.Substring("thebrokenscript:".Length)
                $base = [System.IO.Path]::GetFileNameWithoutExtension($rest)
                if (-not $keys.ContainsKey($base)) { $keys[$base] = "textures/$rest" -replace "\.png$", "" }
            }
        }
    }
    return $keys
}

$terrainKeys = Build-AtlasKeys (Join-Path $src "models\block")
foreach ($png in (Get-ChildItem (Join-Path $src "textures\block") -Recurse -Filter *.png)) {
    $base = [System.IO.Path]::GetFileNameWithoutExtension($png.Name)
    $rel = $png.FullName.Substring((Join-Path $src "textures").Length + 1).Replace("\","/")
    $path = "textures/" + ($rel -replace "\.png$", "")
    if ($terrainKeys.ContainsKey($base) -and $terrainKeys[$base] -ne $path) {
        $i = 2; while ($terrainKeys.ContainsKey("${base}_$i")) { $i++ }
        $terrainKeys["${base}_$i"] = $path
    } else { $terrainKeys[$base] = $path }
}
$textureData = [ordered]@{}
foreach ($k in ($terrainKeys.Keys | Sort-Object)) { $textureData[$k] = [ordered]@{ textures = $terrainKeys[$k] } }
Write-JsonFile (Join-Path $rp "terrain_texture.json") ([ordered]@{
    resource_pack_name = "thebrokenscript"
    texture_name = "atlas.terrain"
    padding = 8
    num_mip_levels = 4
    texture_data = $textureData
})
"wrote terrain_texture.json: $($textureData.Count) entries"

$itemKeys = Build-AtlasKeys (Join-Path $src "models\item")
foreach ($png in (Get-ChildItem (Join-Path $src "textures\item") -Recurse -Filter *.png)) {
    $base = [System.IO.Path]::GetFileNameWithoutExtension($png.Name)
    $itemKeys[$base] = "textures/item/$base"
}
$itemData = [ordered]@{}
foreach ($k in ($itemKeys.Keys | Sort-Object)) { $itemData[$k] = [ordered]@{ textures = $itemKeys[$k] } }
Write-JsonFile (Join-Path $rp "item_texture.json") ([ordered]@{
    resource_pack_name = "thebrokenscript"
    texture_name = "atlas.items"
    texture_data = $itemData
})
"wrote item_texture.json: $($itemData.Count) entries"

# ------------------------------------------- 6. geometry with unique ids
$idMap = [ordered]@{}
$duplicatesFixed = 0
foreach ($g in (Get-ChildItem (Join-Path $src "geo") -Recurse -Filter *.json)) {
    $raw = Get-Content $g.FullName -Raw | ConvertFrom-Json
    $desc = $raw."minecraft:geometry"[0].description
    $oldId = $desc.identifier
    $newId = $oldId
    if ($oldId -eq "geometry.unknown") {
        $base = [System.IO.Path]::GetFileNameWithoutExtension($g.Name) -replace "\.geo$", ""
        $newId = "geometry.tbs_$base"
        $duplicatesFixed++
    }
    if ($idMap.Contains($newId) -and $idMap[$newId] -ne $g.Name) {
        $base2 = [System.IO.Path]::GetFileNameWithoutExtension($g.Name) -replace "\.geo$", ""
        $newId = "geometry.tbs_$base2"
    }
    if ($newId -ne $oldId) { $desc.identifier = $newId }
    if (-not $idMap.Contains($newId)) { $idMap[$newId] = @{ file = $g.Name; original = $oldId } }
    $target = Join-Path $rp ("models\entity\" + $g.Name)
    Write-JsonFile $target $raw
}
Write-JsonFile (Join-Path $docs "GEOMETRY_ID_MAP.json") ([ordered]@{
    note = "original -> bedrock geometry identifiers; geometry.unknown rewritten uniquely"
    mappings = $idMap
})
"geo copied: $($idMap.Count) unique ids (rewritten: $duplicatesFixed)"

# ------------------------------------------------------------ 7. animations
$nAnim = Copy-Tree (Join-Path $src "animations") (Join-Path $rp "animations")
"copied $nAnim animation files"

# ------------------------------------------------------- 8. flipbook_textures
$flipbook = New-Object System.Collections.Generic.List[object]
foreach ($mc in (Get-ChildItem (Join-Path $src "textures\block") -Recurse -Filter *.png.mcmeta)) {
    try { $meta = Get-Content $mc.FullName -Raw | ConvertFrom-Json } catch { continue }
    if ($null -eq $meta.animation) { continue }
    $anim = $meta.animation
    $texRel = $mc.FullName.Replace("$src\textures\", "").Replace(".png.mcmeta", "")
    $fb = [ordered]@{
        flipbook_texture = "textures/$texRel"
        atlas_tile = [System.IO.Path]::GetFileName($texRel)
        ticks_per_frame = [Math]::Max(1, [int][Math]::Round([double]$anim.frametime))
        blend_frames = [bool]$anim.interpolate
    }
    if ($null -ne $anim.frames) { $fb.frames = @($anim.frames) }
    $flipbook.Add($fb)
}
if ($flipbook.Count -gt 0) {
    Write-JsonFile (Join-Path $rp "flipbook_textures.json") ([ordered]@{ flipbook = $flipbook })
}
"wrote flipbook_textures.json: $($flipbook.Count) entries"

# ------------------------------------------------------------- 9. localization
$langSrc = Get-Content (Join-Path $src "..\..\assets\thebrokenscript\lang\en_us.json") -Raw | ConvertFrom-Json
$lines = New-Object System.Collections.Generic.List[string]
foreach ($p in $langSrc.PSObject.Properties) { $lines.Add("$($p.Name)=$($p.Value)") }
[System.IO.File]::WriteAllLines((Join-Path $rp "texts\en_US.lang"), $lines, (New-Object System.Text.UTF8Encoding($false)))
[System.IO.File]::WriteAllText((Join-Path $rp "texts\languages.json"), '["en_US"]', (New-Object System.Text.UTF8Encoding($false)))
[System.IO.File]::WriteAllLines((Join-Path $proj "BP\texts\en_US.lang"), $lines, (New-Object System.Text.UTF8Encoding($false)))
[System.IO.File]::WriteAllText((Join-Path $proj "BP\texts\languages.json"), '["en_US"]', (New-Object System.Text.UTF8Encoding($false)))
"lang lines: $($lines.Count)"

Write-Output "RP ASSET BUILD COMPLETE"
