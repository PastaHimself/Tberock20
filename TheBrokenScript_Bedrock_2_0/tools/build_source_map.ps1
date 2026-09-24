# Derives initial SOURCE_MAP.json from SOURCE_INVENTORY.json (one row per source component).
$ErrorActionPreference = "Stop"
$proj = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$inv = Get-Content (Join-Path $proj "SOURCE_INVENTORY.json") -Raw | ConvertFrom-Json

$rows = New-Object System.Collections.Generic.List[object]
foreach ($e in $inv.entries) {
    $id = $e.source_id
    $bedId = $null
    switch -Regex ($id) {
        '^entity\.(.+)$'        { $bedId = "thebrokenscript:$($Matches[1])" }
        '^block\.(.+)$'         { $bedId = "thebrokenscript:$($Matches[1])" }
        '^item\.(.+)$'          { $bedId = "thebrokenscript:$($Matches[1])" }
        '^dimension\.(.+)$'     { $bedId = "thebrokenscript:$($Matches[1]) (dimension)" }
        '^biome\.(.+)$'         { $bedId = "thebrokenscript:$($Matches[1]) (biome)" }
        default                 { $bedId = "" }
    }
    $rows.Add([ordered]@{
        source_id         = $id
        category          = $e.category
        source_paths      = $e.source_paths
        bedrock_identifier= $bedId
        bedrock_files     = @()
        status            = "uninspected"
        parity            = "unknown"
        notes             = ""
    })
}

$doc = [ordered]@{
    project       = "TheBrokenScript_Bedrock_2_0"
    generated_utc = (Get-Date).ToUniversalTime().ToString("o")
    note          = "Initial Chunk 00 map: one row per inventory entry; refined per-chunk as components are analyzed/ported"
    rows          = $rows
}
$out = Join-Path $proj "SOURCE_MAP.json"
[System.IO.File]::WriteAllText($out, ($doc | ConvertTo-Json -Depth 6), (New-Object System.Text.UTF8Encoding($false)))
Write-Output "SOURCE_MAP.json rows: $($rows.Count)"
