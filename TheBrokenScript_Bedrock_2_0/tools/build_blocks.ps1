# Chunk 08 generator: emits BP/blocks/*.json from a name->(texture,shape) map,
# merges missing terrain_texture keys, and creates the shared cross geometry.
$ErrorActionPreference = "Stop"
$proj = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$bpBlocks = Join-Path $proj "BP\blocks"
New-Item -ItemType Directory -Force -Path $bpBlocks | Out-Null

# shape: cube | cross | marker(invisible,no-collision)
# T = terrain_texture key
$map = [ordered]@{
  # ── full cubes ──
  "deviation"                 = @("cube","deviation")
  "decomposed_semiotics"      = @("cube","decomposed_semiotics")
  "all_dead"                  = @("cube","flesh")
  "viscera"                   = @("cube","flesh")
  "flesh"                     = @("cube","flesh")
  "oldblock"                  = @("cube","old")
  "hello"                     = @("cube","hi")
  "empty"                     = @("cube","empty")
  "it"                        = @("cube","it")
  "exit"                      = @("cube","exit")
  "disruption"                = @("cube","noise")
  "concrete"                  = @("cube","concrete")
  "intense_projection"        = @("cube","intense_projection")
  "mono_planks"               = @("cube","mono_planks")
  "mono_library"              = @("cube","mono_library")
  "white"                     = @("cube","white")
  "r_3"                       = @("cube","block3")
  "int"                       = @("cube","block4")
  "moon_stone"                = @("cube","moon_stone")
  "moon_stone_bricks"         = @("cube","moon_stone_bricks")
  "chiseled_moon_stone_bricks"= @("cube","chiseled_moon_stone_bricks")
  "corrupted_moon_stone_bricks"=@("cube","corrupted_moon_stone_bricks")
  "polished_moon_stone"       = @("cube","polished_moon_stone")
  "protected_void"            = @("cube","protected_void")
  "obsidian"                  = @("cube","redobsidian")
  "limbo"                     = @("cube","limbo")
  "nothing"                   = @("cube","nothing")
  "teeth"                     = @("cube","teeth")
  "name_missing"              = @("cube","errornotexture")
  "block_is_missing_id"       = @("cube","errornotexture")
  "nowhere_block"             = @("cube","nullvoid")
  "physical_stacktrace"       = @("cube","stack_trace")
  "ceiling_light"             = @("cube","ceiling_light")
  "red_ceiling_light"         = @("cube","red_ceiling_light")
  "ceiling_tile"              = @("cube","ceiling_tile")
  "red_ceiling_tile"          = @("cube","red_ceiling_tile")
  "moist_carpet"              = @("cube","moist_carpet")
  "red_moist_carpet"          = @("cube","red_moist_carpet")
  "ugly_wallpaper"            = @("cube","ugly_wallpaper")
  "red_ugly_wallpaper"        = @("cube","red_ugly_wallpaper")
  "void_log"                  = @("cube_side_top","void_log_side","void_log_top")
  "void_wood"                 = @("cube_side_top","void_log_side","void_planks")
  "void_planks"               = @("cube","void_planks")
  "necrosis"                  = @("cube","necrosis")
  "new_vein"                  = @("cross","vein_center")
  # ── slab/stairs/wall/fence approximations (full cube, ledgered) ──
  "mono_slab"                 = @("cube","mono_planks")
  "mono_stairs"               = @("cube","mono_planks")
  "moon_stone_brick_slab"     = @("cube","moon_stone_bricks")
  "moon_stone_brick_stairs"   = @("cube","moon_stone_bricks")
  "moon_stone_brick_wall"     = @("cube","moon_stone_bricks")
  "polished_moon_stone_slab"  = @("cube","polished_moon_stone")
  "polished_moon_stone_stairs"= @("cube","polished_moon_stone")
  "polished_moon_stone_wall"  = @("cube","polished_moon_stone")
  "protected_void_slab"       = @("cube","protected_void")
  "protected_void_stairs"     = @("cube","protected_void")
  "protected_void_wall"       = @("cube","protected_void")
  "protected_void_fence"      = @("cube","protected_void")
  "protected_void_light"      = @("cube","void_light")
  "void_plank_slab"           = @("cube","void_planks")
  "void_plank_stairs"         = @("cube","void_planks")
  "sideways_fence"            = @("cube","mossy_oak")
  "sideways_pane"             = @("cube","sideways_pane")
  "smooth_stone_vertical_slab"= @("cube","bedrock")
  "spruce_wood_slab"          = @("cube","mono_planks")
  "sideways_cobblestone_stairs"=@("cube","sideways_cobblestone_stairs")
  "sideways_furnace"          = @("cube","sideways_furnace")
  "void_wood_trapdoor"        = @("cube","void_wood_trapdoor")
  # door approximations (full cubes)
  "ud_oak_door"               = @("cube","ud_oak_door_bottom")
  "void_door"                 = @("cube","void_door_bottom")
  "void_log_door"             = @("cube","void_log_door_bottom")
  "void_plank_door"           = @("cube","void_plank_door_bottom")
  # ── border-block family (barrier-like) ──
  "border_block"              = @("cube","barrier")
  "cobblestone_border_block"  = @("cube","sideways_cobblestone_stairs")
  "dirt_border_block"         = @("cube","void_grass")
  "glass_border_block"        = @("cube","sideways_pane")
  "stone_border_block"        = @("cube","bedrock")
  "stone_slab_border_block"   = @("cube","bedrock")
  # ── cross flora ──
  "lily_of_the_abyss"         = @("cross","lily_of_the_abyss")
  "potted_lily_of_the_abyss"  = @("cross","lily_of_the_abyss")
  "potted_void_bell"          = @("cross","void_bell")
  "potted_void_cap"           = @("cross","void_cap")
  "potted_void_shroom"        = @("cross","void_shroom")
  "void_bell"                 = @("cross","void_bell")
  "void_bloom"                = @("cross","tether_bloom_idle")
  "void_blossom"              = @("cross","tether_bloom_rot")
  "void_bud"                  = @("cross","tether_bloom_disintegrate")
  "void_budding"              = @("cross","void_growth")
  "void_bush"                 = @("cross","void_bush")
  "void_cap"                  = @("cross","void_cap")
  "void_grass"                = @("cross","void_grass")
  "void_root"                 = @("cross","void_root")
  "void_roots"                = @("cross","void_roots")
  "void_shroom"               = @("cross","void_shroom")
  "void_sprout"               = @("cross","void_sprout")
  "void_vine"                 = @("cross","void_vine")
}

function Emit-Block($name, $shape, $texA, $texB) {
  $comps = New-Object System.Collections.ArrayList
  if ($shape -eq "cross") {
    [void]$comps.Add('"minecraft:material_instances": { "*": { "texture": "' + $texA + '", "render_method": "alpha_test_single_sided" } }')
    [void]$comps.Add('"minecraft:geometry": "geometry.tbs_cross"')
    [void]$comps.Add('"minecraft:collision_box": false')
    [void]$comps.Add('"minecraft:selection_box": true')
    [void]$comps.Add('"minecraft:light_dampening": 0')
  } else {
    if ($texB) {
      [void]$comps.Add('"minecraft:material_instances": { "*": { "texture": "' + $texA + '" }, "up": { "texture": "' + $texB + '" }, "down": { "texture": "' + $texB + '" } }')
    } else {
      [void]$comps.Add('"minecraft:material_instances": { "*": { "texture": "' + $texA + '" } }')
    }
    [void]$comps.Add('"minecraft:destructible_by_mining": { "seconds_to_destroy": 1.5 }')
    [void]$comps.Add('"minecraft:destructible_by_explosion": { "explosion_resistance": 5 }')
    [void]$comps.Add('"minecraft:light_dampening": 0')
  }
  $componentsStr = $comps -join ",`n      "
  $json = @"
{
  "format_version": "1.21.0",
  "minecraft:block": {
    "description": {
      "identifier": "thebrokenscript:$name",
      "menu_category": { "category": "construction" }
    },
    "components": {
      $componentsStr
    }
  }
}
"@
  Set-Content -LiteralPath (Join-Path $bpBlocks "$name.json") -Value $json -Encoding UTF8
}

$count = 0
foreach ($k in $map.Keys) {
  $v = $map[$k]
  Emit-Block $k $v[0] $v[1] $(if ($v.Count -gt 2) { $v[2] } else { $null })
  $count++
}
Write-Output "emitted $count BP block definitions"

# shared cross geometry for flora
$geoDir = Join-Path $proj "RP\models\blocks"
New-Item -ItemType Directory -Force -Path $geoDir | Out-Null
$crossGeo = @"
{
  "format_version": "1.12.0",
  "minecraft:geometry": [
    {
      "description": {
        "identifier": "geometry.tbs_cross",
        "texture_width": 16,
        "texture_height": 16
      },
      "bones": [
        {
          "name": "cross",
          "pivot": [0, 0, 0],
          "cubes": [
            { "origin": [-8, 0, -0.01], "size": [16, 16, 0.02], "uv": [0, 0] },
            { "origin": [-8, 0, -0.01], "size": [16, 16, 0.02], "pivot": [0, 0, 0], "rotation": [0, 90, 0], "uv": [0, 0] }
          ]
        }
      ]
    }
  ]
}
"@
Set-Content -LiteralPath (Join-Path $geoDir "tbs_cross.geo.json") -Value $crossGeo -Encoding UTF8

# merge missing terrain_texture keys
$ttPath = Join-Path $proj "RP\terrain_texture.json"
$tt = Get-Content -LiteralPath $ttPath -Raw | ConvertFrom-Json
$missing = @{
  "void_bloom"   = "textures/block/tether_bloom_idle"
  "void_blossom" = "textures/block/tether_bloom_rot"
  "void_bud"     = "textures/block/tether_bloom_disintegrate"
  "void_budding" = "textures/block/void_growth"
  "new_vein"     = "textures/block/vein_center"
  "vein_center"  = "textures/block/vein_center"
  "hello"        = "textures/block/hi"
  "oldblock"     = "textures/block/old"
  "nowhere_block"= "textures/block/nullvoid"
  "name_missing" = "textures/block/errornotexture"
  "block_is_missing_id" = "textures/block/errornotexture"
  "r_3"          = "textures/block/block3"
  "int"          = "textures/block/block4"
  "physical_stacktrace" = "textures/block/stack_trace"
  "teeth"        = "textures/block/teeth"
  "necrosis"     = "textures/block/necrosis"
  "void_light"   = "textures/block/void_light"
  "void_growth"  = "textures/block/void_growth"
  "void_shimmer" = "textures/block/void_shimmer"
}
$tdObj = $tt.texture_data
$added = 0
foreach ($k in $missing.Keys) {
  if (-not $tdObj.PSObject.Properties[$k]) {
    $tdObj | Add-Member -NotePropertyName $k -NotePropertyValue @{ textures = $missing[$k] } -Force
    $added++
  }
}
$tt | ConvertTo-Json -Depth 8 | Set-Content -LiteralPath $ttPath -Encoding UTF8
Write-Output "terrain_texture: added $added key(s)"

# ── special/BE blocks + void templates (custom components via beta API) ─────
function Write-SpecialBlock($name, $tex, $comp, $shape = "cube") {
  $cc = if ($comp) { "`n      `"minecraft:custom_components`": [`"thebrokenscript:$comp`"]," } else { "" }
  if ($shape -eq "marker") {
    $json = @"
{
  "format_version": "1.21.0",
  "minecraft:block": {
    "description": {
      "identifier": "thebrokenscript:$name",
      "menu_category": { "category": "construction", "is_hidden_in_commands": false }
    },
    "components": {
      "minecraft:material_instances": { "*": { "texture": "$tex", "render_method": "alpha_test_single_sided" } },
      "minecraft:collision_box": false,
      "minecraft:selection_box": false,
      "minecraft:light_dampening": 0
    }
  }
}
"@
  } else {
    $json = @"
{
  "format_version": "1.21.0",
  "minecraft:block": {
    "description": {
      "identifier": "thebrokenscript:$name",
      "menu_category": { "category": "construction" }
    },
    "components": {
      "minecraft:material_instances": { "*": { "texture": "$tex" } },$cc
      "minecraft:destructible_by_mining": { "seconds_to_destroy": 1.5 },
      "minecraft:destructible_by_explosion": { "explosion_resistance": 5 }
    }
  }
}
"@
  }
  Set-Content -LiteralPath (Join-Path $bpBlocks "$name.json") -Value $json -Encoding UTF8
}
Write-SpecialBlock "command" "command_block" "be_command"
Write-SpecialBlock "portal_controller" "portal_controller" "be_portal_controller"
Write-SpecialBlock "portal_extender" "portal_extender" "be_portal_extender"
Write-SpecialBlock "null_structure" "null_structure" "be_null_structure"
Write-SpecialBlock "shadow_bug" "dark" "be_shadow_bug"
Write-SpecialBlock "a_flower" "a_flower" "be_a_flower"
for ($i = 1; $i -le 4; $i++) { Write-SpecialBlock "jim_trigger_$i" "jim_trigger_$i" "be_jim_trigger" }
Write-SpecialBlock "command_block_giver" "command_block" "be_command"
Write-SpecialBlock "initiator" "null_structure" $null
for ($i = 1; $i -le 16; $i++) { Write-SpecialBlock "void_template_$i" "nothing" $null "marker" }
