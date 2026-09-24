# Generates SOURCE_INVENTORY.json from the extracted The Broken Script 2.0 source tree.
# Chunk 00 tool. Re-runnable: always rebuilds the file from scratch.
$ErrorActionPreference = "Stop"

$src   = "C:\Users\mg4392\Downloads\tbs 2.0\source_extracted"
$proj  = "C:\Users\mg4392\Downloads\tbs 2.0\TheBrokenScript_Bedrock_2_0"
$outFile = Join-Path $proj "SOURCE_INVENTORY.json"

$entries = New-Object System.Collections.Generic.List[object]

function Add-Entry {
    param(
        [string]$id,
        [string]$category,
        [string[]]$paths,
        [string[]]$deps = @(),
        [string]$relevance = "runtime",
        [string]$notes = ""
    )
    $entries.Add([ordered]@{
        source_id           = $id
        category            = $category
        source_paths        = $paths
        dependencies        = $deps
        shipping_relevance  = $relevance
        status              = "uninspected"
        notes               = $notes
    })
}

function Get-JsonKeys {
    param([string]$path)
    $raw = Get-Content -LiteralPath $path -Raw
    ($raw | ConvertFrom-Json).PSObject.Properties.Name
}

# ---------------------------------------------------------------- metadata
Add-Entry "mod.metadata" "metadata" @("META-INF/neoforge.mods.toml","META-INF/MANIFEST.MF","pack.mcmeta") @() "runtime" "modId=thebrokenscript v2.0.0; MC [1.21.1,); NeoForge [21.1.227,); license All Rights Reserved; Kotlin modules present (common+neoforge)"
Add-Entry "mod.mixins.common" "metadata" @("thebrokenscript.mixins.json") @("mod.metadata") "runtime" "57 common mixins + 67 client mixins; plugin TBSMixinPlugin; JAVA_21; covers bossfight region, commands, fake players, freeze, generation corruption, inventory/respawn, moon gravity/fall damage, spawning caps, deepslate removal, world tweaks, client vfx/chat/font/screen/window"
Add-Entry "mod.mixins.neoforge" "metadata" @("thebrokenscript-neoforge.mixins.json") @("mod.metadata") "runtime" "NeoForge-specific mixin config"
Add-Entry "mod.accesstransformer" "metadata" @("META-INF/accesstransformer.cfg") @("mod.metadata") "runtime" "Field/method access widening used by engine hooks"
Add-Entry "lib.brokencore" "library" @("META-INF/jarjar/net.thebrokenscript.brokencore-neoforge-0.1.0+mc1.21.1-build.3084.jar") @("mod.metadata") "runtime" "REQUIRED dependency; shared engine library (api/engine, anim, tentaclev2 live inside main jar too); port relevant behavior into BP/RP scripts"
Add-Entry "lib.mixinextras" "library" @("META-INF/jarjar/mixinextras-neoforge-0.5.3.jar") @() "build_only" "Java-side mixin helper; no Bedrock equivalent needed"
Add-Entry "lib.mixinsquared" "library" @("META-INF/jarjar/mixinsquared-neoforge-0.3.3.jar") @() "build_only" "Java-side mixin helper; no Bedrock equivalent needed"
Add-Entry "mod.entrypoints" "code_entrypoint" @("net/thebrokenscript/TheBrokenScript.class","net/thebrokenscript/TBSEngineControl.class","net/thebrokenscript/TBSMixinPlugin.class","net/thebrokenscript/server/") @("mod.metadata","lib.brokencore") "runtime" "Mod constructor + engine control + mixin plugin + server pkg"

# ------------------------------------------------------- lang-driven roster
$langPath = Join-Path $src "assets\thebrokenscript\lang\en_us.json"
$keys = Get-JsonKeys $langPath

$entityIds = @()
$eventIds  = @()
$itemIds   = @()
foreach ($k in $keys) {
    if ($k -match '^entity\.thebrokenscript\.([a-z0-9_]+)$') { $entityIds += $Matches[1] }
    elseif ($k -match '^event\.thebrokenscript\.([a-z0-9_]+)$') { $eventIds += $Matches[1] }
    elseif ($k -match '^item\.thebrokenscript\.([a-z0-9_]+)$') { $itemIds += $Matches[1] }
}
$entityIds = $entityIds | Sort-Object -Unique
$eventIds  = $eventIds  | Sort-Object -Unique
$itemIds   = $itemIds   | Sort-Object -Unique

foreach ($e in $entityIds) { Add-Entry "entity.$e" "entity" @("lang key entity.thebrokenscript.$e", "TBSEntities registry") @("shared.runtime","shared.events") }
foreach ($v in $eventIds)  { Add-Entry "event.$v" "horror_event" @("lang key event.thebrokenscript.$v", "TBSEvents registry / events packages") @("shared.runtime") }
foreach ($i in $itemIds)   { Add-Entry "item.$i" "item" @("lang key item.thebrokenscript.$i", "TBSItems/TBSEasterEggItems/TBSPlushies registries") @("asset.foundation") }

# ------------------------------------------------------------------ blocks
$blockstates = Get-ChildItem (Join-Path $src "assets\thebrokenscript\blockstates") -Filter *.json | Sort-Object Name
foreach ($b in $blockstates) {
    Add-Entry ("block." + $b.BaseName) "block" @("assets/thebrokenscript/blockstates/$($b.Name)", "TBSBlocks registry") @("asset.foundation")
}

# ------------------------------------------------------------ block entities
foreach ($be in @("all_dead","a_flower","corrupted_command_block","exit","null_structure","portal_controller","portal_extender","shadow_bug")) {
    Add-Entry "block_entity.$be" "block_entity" @("TBSBlockEntities.$be") @("block systems") "runtime" "Bedrock: block entity behavior via scripted custom components or entity surrogate"
}

# --------------------------------------------------------------- dimensions
$dimFiles = Get-ChildItem (Join-Path $src "data\thebrokenscript\dimension") -Filter *.json | Sort-Object Name
foreach ($d in $dimFiles) {
    Add-Entry "dimension.$($d.BaseName)" "dimension" @("data/thebrokenscript/dimension/$($d.Name)","data/thebrokenscript/dimension_type/$($d.Name)") @("worldgen.foundation") "runtime" "13 total custom dimensions"
}

# ------------------------------------------------------------------ biomes
foreach ($f in (Get-ChildItem (Join-Path $src "data\thebrokenscript\worldgen\biome") -Filter *.json)) {
    Add-Entry "biome.$($f.BaseName)" "biome" @("data/thebrokenscript/worldgen/biome/$($f.Name)") @("dimension systems")
}

# ------------------------------------------------------------------ worldgen
Add-Entry "worldgen.carver.moon_hole" "worldgen" @("data/thebrokenscript/worldgen/configured_carver/moon_hole.json") @("dimension.the_moon")
foreach ($f in (Get-ChildItem (Join-Path $src "data\thebrokenscript\worldgen\configured_feature") -Filter *.json)) {
    Add-Entry "feature.$($f.BaseName)" "worldgen" @("data/thebrokenscript/worldgen/configured_feature/$($f.Name)","data/thebrokenscript/worldgen/placed_feature/$($f.Name)") @("dimension systems")
}
foreach ($f in (Get-ChildItem (Join-Path $src "data\thebrokenscript\worldgen\noise_settings") -Filter *.json)) {
    Add-Entry "noise_settings.$($f.BaseName)" "worldgen" @("data/thebrokenscript/worldgen/noise_settings/$($f.Name)") @("dimension systems") "runtime" "Custom noise terrain; Bedrock has no noise_settings -> scripted/approximate generation"
}
Add-Entry "structure.void_growth" "worldgen" @("data/thebrokenscript/worldgen/structure/void_growth.json","data/thebrokenscript/worldgen/structure_set/void_growth.json") @("structures")

# --------------------------------------------------------------- structures
$structRoot = Get-ChildItem (Join-Path $src "data\thebrokenscript\structure") -Filter *.nbt | Sort-Object Name
Add-Entry "structures.root_set" "structures" @(($structRoot | ForEach-Object { "data/thebrokenscript/structure/$($_.Name)" })) @("worldgen.foundation") "runtime" "$($structRoot.Count) standalone .nbt structures placed by code events/biome modifiers"
$shaft = Get-ChildItem (Join-Path $src "data\thebrokenscript\structure\shaft") -Filter *.nbt | Sort-Object Name
Add-Entry "structures.shaft_jigsaw" "structures" @(($shaft | ForEach-Object { "data/thebrokenscript/structure/shaft/$($_.Name)" })) @("worldgen.foundation") "runtime" "Jigsaw piece set (corner/hall/junction/room/root) for mineshaft-like shaft system"
$unused = Get-ChildItem (Join-Path $src "data\thebrokenscript\structure\unused") -Filter *.nbt | Sort-Object Name
Add-Entry "structures.unused" "structures" @(($unused | ForEach-Object { "data/thebrokenscript/structure/unused/$($_.Name)" })) @() "non_runtime" "Explicitly unused variants kept in JAR"
Add-Entry "structures.xcsf_phase3_arena" "structures" @("data/thebrokenscript/xcsf_structure/phase3_arena_final.xcsf") @("boss.integrity.phase3") "runtime" "Custom XCSF structure format (code-defined); must be reconstructed as .mcstructure"

# --------------------------------------------------------- misc data files
foreach ($f in (Get-ChildItem (Join-Path $src "data\thebrokenscript\damage_type") -Filter *.json)) {
    Add-Entry "damage_type.$($f.BaseName)" "damage_type" @("data/thebrokenscript/damage_type/$($f.Name)") @()
}
foreach ($f in (Get-ChildItem (Join-Path $src "data\thebrokenscript\jukebox_song") -Filter *.json)) {
    Add-Entry "jukebox_song.$($f.BaseName)" "music" @("data/thebrokenscript/jukebox_song/$($f.Name)") @("asset.sounds")
}
foreach ($f in (Get-ChildItem (Join-Path $src "data\thebrokenscript\advancement") -Filter *.json)) {
    Add-Entry "advancement.$($f.BaseName)" "progression" @("data/thebrokenscript/advancement/$($f.Name)","TBSAdvancements") @("events.story")
}
foreach ($f in (Get-ChildItem (Join-Path $src "data\thebrokenscript\recipe") -Filter *.json)) {
    Add-Entry "recipe.$($f.BaseName)" "recipe" @("data/thebrokenscript/recipe/$($f.Name)") @()
}
Add-Entry "loot_tables.blocks" "loot" @( (Get-ChildItem (Join-Path $src "data\thebrokenscript\loot_table\blocks") -Filter *.json | ForEach-Object { "data/thebrokenscript/loot_table/blocks/$($_.Name)" }) ) @("block systems")
Add-Entry "loot_tables.entities" "loot" @("data/thebrokenscript/loot_table/entities/null_cod.json") @("entity.null_cod")

# --------------------------------------------------------------------- tags
$tbsTags = Get-ChildItem (Join-Path $src "data\thebrokenscript\tags") -Recurse -Filter *.json | ForEach-Object { $_.FullName.Replace((Join-Path $src "data\thebrokenscript\tags\"), "") -replace "\\","/" }
Add-Entry "tags.thebrokenscript" "tags" @(($tbsTags | ForEach-Object { "data/thebrokenscript/tags/$_" })) @() "runtime" "Breakable sets, chaser/lookable/despawnable entity families, paranoia trigger sets, void flora mineable, creepy discs, allowed boss biomes"
$mcTags = Get-ChildItem (Join-Path $src "data\minecraft\tags") -Recurse -Filter *.json | ForEach-Object { $_.FullName.Replace((Join-Path $src "data\minecraft\tags\"), "") -replace "\\","/" }
Add-Entry "tags.minecraft.overrides" "tags" @(($mcTags | ForEach-Object { "data/minecraft/tags/$_" })) @() "runtime" "Vanilla tag extensions (mineable, wooden families, damage bypasses, music_discs, placeable paintings)"
Add-Entry "tags.brokencore" "tags" @("data/brokencore/tags/damage_type/bypasses_totem.json") @()

# -------------------------------------------------------- biome modifiers
$spawns = Get-ChildItem (Join-Path $src "data\thebrokenscript\neoforge\biome_modifier\spawns") -Filter *.json | Sort-Object Name
foreach ($s in $spawns) {
    Add-Entry "spawn_modifier.$($s.BaseName)" "spawn_rule" @("data/thebrokenscript/neoforge/biome_modifier/spawns/$($s.Name)","TBSSpawnConditions") @("shared.spawning") "runtime" "Code-driven spawn condition pair; Bedrock needs scripted spawner or spawn_rules approximation"
}
Add-Entry "spawn_modifier.moon_chunk" "spawn_rule" @("data/thebrokenscript/neoforge/biome_modifier/moon_chunk_biome_modifier.json") @("feature.moon_chunk")
Add-Entry "spawn_modifiers.disabled" "spawn_rule" @("data/thebrokenscript/neoforge/biome_modifier/circuit_tp_beacon_biome_modifier.jsondisabled","data/thebrokenscript/neoforge/biome_modifier/null_tp_beacon_biome_modifier.jsondisabled") @() "non_runtime" "Disabled in shipping"
Add-Entry "spawn_modifiers.todo" "spawn_rule" @("data/thebrokenscript/neoforge/biome_modifiers_todo/") @() "non_runtime" "Unshipped leftovers; document only"

# ------------------------------------------------------------- painting/misc
Add-Entry "painting.circuit_cave" "painting" @("data/thebrokenscript/painting_variant/circuit_cave.json","textures/painting") @("asset.textures")

# -------------------------------------------------------------- fluids
Add-Entry "fluid.void_liquid" "fluid" @("TBSFluids/TBSFluidTypes registry","neoforge/fluids/") @("dimension.void_shadow","dimension.protected_void") "runtime" "Source+flowing void liquid + fluid block; Bedrock: no custom fluids -> approximated with tinted blocks/particles/scripted damage"

# -------------------------------------------------------------- effects
foreach ($fx in @("heart_corruption","why_cant_you_leave")) {
    Add-Entry "effect.$fx" "status_effect" @("TBSEffects.$fx") @("shared.runtime") "runtime" "Custom mob effect; Bedrock: scripted effect emulation (no custom potion registry)"
}

# -------------------------------------------------------------- particles
foreach ($p in (Get-ChildItem (Join-Path $src "assets\thebrokenscript\particles") -Filter *.json)) {
    Add-Entry "particle.$($p.BaseName)" "particle" @("assets/thebrokenscript/particles/$($p.Name)") @("asset.particles")
}

# ------------------------------------------------------------------ sounds
Add-Entry "sound_definitions" "sound" @("assets/thebrokenscript/sounds.json") @("asset.sounds") "runtime" "Master sound event definition file; keys enumerate all sound events"
$soundDirs = Get-ChildItem (Join-Path $src "assets\thebrokenscript\sounds") -Directory
foreach ($sd in $soundDirs) {
    $n = (Get-ChildItem $sd.FullName -Recurse -File).Count
    Add-Entry "sounds.family.$($sd.Name)" "sound" @("assets/thebrokenscript/sounds/$($sd.Name)/") @("sound_definitions") "runtime" "$n ogg files"
}

# -------------------------------------------------------------- GUI / menus
foreach ($m in @("command_gui","command_confirm_gui","fake_disconnect","library_book_gui","nulled_gui","null_interface_1","null_interface_2","null_interface_3","polaroid_gui","torn_paper_gui")) {
    Add-Entry "gui.$m" "gui" @("TBSMenus.$m", "client/gui/") @("network.packets") "runtime" "Server menu screen; Bedrock: ActionFormData/ModalFormData or scripted UI substitute"
}
Add-Entry "gui.client_overlays" "gui" @("client/gui/","client/overlay/","textures/gui/") @() "runtime" "HUD overlays (hud text, bossbar textures, playercorruption frames, screens/) rendered client-side"

# ------------------------------------------------------ shaders (Java GLSL)
Add-Entry "render.java_shaders" "shader_pipeline" @(
    "assets/thebrokenscript/shaders/core/",
    "assets/thebrokenscript/shaders/post/",
    "assets/thebrokenscript/shaders/program/ (incl dream/, fever/)",
    "assets/thebrokenscript/shaders/include/",
    "assets/thebrokenscript/shaders/sodium/"
) @("client.vfx") "runtime" "89 Java GLSL core/post shaders (VHS, aberration, invert, dream, fever, glitch, sky). Bedrock has no Java shader pipeline; reproduce visible results with fog/camera/particles/titles where possible -> ENGINE_UNSUPPORTED for exact pipeline"

# ------------------------------------------------------- client asset families
Add-Entry "asset.geo_bedrock_format" "model_geometry" @( (Get-ChildItem (Join-Path $src "assets\thebrokenscript\geo") -Recurse -Filter *.json | ForEach-Object { "assets/thebrokenscript/geo/$($_.Name)" }) ) @() "runtime" "77 native Bedrock-format geometry files (GeckoLib-style format_version 1.12.0) - DIRECTLY REUSABLE in RP"
Add-Entry "asset.animations_bedrock_format" "animation" @( (Get-ChildItem (Join-Path $src "assets\thebrokenscript\animations") -Filter *.json | ForEach-Object { "assets/thebrokenscript/animations/$($_.Name)" }) ) @("asset.geo_bedrock_format") "runtime" "36 native Bedrock-format animation files (format_version 1.8.0) - DIRECTLY REUSABLE in RP"
Add-Entry "asset.models_java" "model_geometry" @("assets/thebrokenscript/models/ (388 json: block/item)") @() "runtime" "Java block/item models; convert to Bedrock blocks.json/textures/item_texture.json mappings"
Add-Entry "asset.textures" "texture" @("assets/thebrokenscript/textures/ (502 png incl entities 72, block 106, plush 39, gui 121, item 57, particle 17, moonevent 11)") @() "runtime"
Add-Entry "asset.font" "font" @("assets/thebrokenscript/font/", "textures/font/") @() "runtime" "Custom corrupted glyph font; Bedrock font support limited -> approximate or omit glyphs"
Add-Entry "asset.library_books" "misc_asset" @("assets/thebrokenscript/library_books/ (44 files)") @() "runtime" "In-game readable book content (Library dimension)"
Add-Entry "asset.schema" "misc_asset" @("assets/thebrokenscript/schema/") @() "build_only"
Add-Entry "asset.bedrock_tests" "misc_asset" @("assets/thebrokenscript/bedrock/model/test.geo.json","assets/thebrokenscript/bedrock/animation/test.animation.json") @() "non_runtime" "Dev test artifacts proving authors used Bedrock-format assets internally"

# ----------------------------------------------------------- code packages
$classRoot = Join-Path $src "net\thebrokenscript"
$pkgDirs = Get-ChildItem $classRoot -Recurse -Directory
foreach ($pd in $pkgDirs) {
    $cls = (Get-ChildItem $pd.FullName -Filter *.class -ErrorAction SilentlyContinue).Count
    if ($cls -gt 0) {
        $rel = $pd.FullName.Replace("$classRoot\","").ToLower() -replace "\\","/"
        if (($entries | Where-Object { $_.source_id -eq "code.$rel" }).Count -eq 0) {
            Add-Entry "code.$rel" "code_package" @("net/thebrokenscript/$rel") @() "runtime" "$cls class files (bytecode-only source)"
        }
    }
}
$rootCls = (Get-ChildItem $classRoot -Filter *.class).Count
if ($rootCls -gt 0) {
    # root-level classes already covered by mod.entrypoints; skip duplicates
}

# ------------------------------------------------- registry subsystem notes
Add-Entry "registry.spawn_conditions" "registry_system" @("TBSSpawnConditions (+24 condition classes)") @("shared.spawning") "runtime" "Custom spawn predicate framework (distance/light/structure/player-state aware)"
Add-Entry "registry.data_attachments" "player_state" @("TBSDataAttachments: CIRCUIT_INHABITED, INTERACTION_TRACKER, PLAYER_BASE, PLAYER_VARIABLES") @("shared.runtime") "runtime" "Per-player persistent state -> dynamic properties service"
Add-Entry "registry.chat_responses" "chat_system" @("TBSChatResponses (45 response handlers)") @("events.story","handlers.chat") "runtime" "Players typing keywords triggers horror responses"
Add-Entry "registry.event_handlers" "event_engine" @("TBSEvents (~91 handler lambdas)","events/ subpackages") @("shared.runtime") "runtime" "~85 named events from lang + internal handlers; central scheduler design required"
Add-Entry "registry.story_events" "story_progression" @("TBSStoryEvents (4 stages)") @("events.story") "runtime" "Progression stage machine gating encounters"
Add-Entry "registry.music_songs" "music" @("TBSSongs","TBSMusic","network/music/") @("sound_definitions") "runtime" "Music disc + scripted music playback incl network-synced music"
Add-Entry "registry.packets" "networking" @("TBSPackets","network/debug/","network/music/") @() "runtime" "Client<->server sync (music, debug, GUI state); Bedrock: server-authoritative script state"
Add-Entry "registry.commands.dev" "command" @("command/dev/","command/") @() "runtime" "Player/admin commands incl fx toggles (/fx aberration|dream|invert|meta_paranoia|moon_glitch|screen_dupe|sky_blue|text_glitch|vhs|custom_sky|glitches|lucid_blocks_effect), give, tp, kick, deop, inhabit"
Add-Entry "config.common" "configuration" @( ($keys | Where-Object { $_ -like 'thebrokenscript.configuration.*' } | ForEach-Object { "lang key $_" }) ) @("shared.config") "runtime" "Gameplay-affecting config: disableBanning, disableWorldEater, nightmareTeleportChance, disguisedCircuitEntityChance/OreChance, allowCorruptedWorldGeneration, allowOldWorldGen, removeDeepslate, disableVoidHoles, etc."
Add-Entry "platform_integration" "desktop_integration" @("window.thebrokenscript.* lang keys","gui.thebrokenscript.warning.*","events.jframe/","handlers subs","config enableFileCreation") @() "runtime" "Window title hijack, LWJGL alert popups, JFrame popups, desktop .txt creation, world ban/kick-to-menu, fake disconnect/crash. JVM-desktop features -> ENGINE_UNSUPPORTED on Bedrock except in-game equivalents (kick, title overlays)"

# --------------------------------------------------------- embedded packs/files
foreach ($p in @("nostalgia","nostalgia_gen")) {
    $pf = Join-Path $src $p
    if (Test-Path $pf) {
        $n = (Get-ChildItem $pf -Recurse -File).Count
        Add-Entry "embedded_pack.$p" "embedded_resource_pack" @("$p/") @() "runtime" "Embedded legacy resource pack ($n files): old sounds/models; ship as optional Bedrock RP or document"
    }
}
Add-Entry "file.book0" "misc_asset" @("books/book0.book") @() "runtime" "Custom book data format consumed by code"
Add-Entry "file.rblog_bin" "misc_asset" @("sites/rblog/file.bin (85,495,584 bytes, header F8 F1 2D 67, reassembled from 3 parts)") @() "runtime" "Opaque custom binary (ARG website payload?); not Minecraft content; preserve externally, cannot execute on Bedrock"
Add-Entry "file.important_txt" "misc_asset" @("important.txt","logo.png","LICENSE","CHUNK_REASSEMBLY_README.txt","REASSEMBLY_MANIFEST.json") @() "non_runtime" "Metadata/art/license"
Add-Entry "cache.dot_cache" "build_artifact" @(".cache/ (14 hash-named files)") @() "build_only" "Build cache; exclude from port"

# ------------------------------------------------------------------- output
$doc = [ordered]@{
    project         = "TheBrokenScript_Bedrock_2_0"
    generated_utc   = (Get-Date).ToUniversalTime().ToString("o")
    source          = "thebrokenscript-neoforge-2.0.0+mc1.21.1-build.3084 (decompressed JAR chunks 01-09)"
    source_kind     = "bytecode (.class, 1982 files) + complete original resources; NO decompiled .java supplied"
    entries         = $entries
}
$json = $doc | ConvertTo-Json -Depth 6
[System.IO.File]::WriteAllText($outFile, $json, (New-Object System.Text.UTF8Encoding($false)))

$byCat = $entries | Group-Object category | Sort-Object Count -Descending
Write-Output "TOTAL ENTRIES: $($entries.Count)"
$byCat | ForEach-Object { "{0,-26} {1}" -f $_.Name, $_.Count }
