import assert from "node:assert/strict";
import { access, readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath, pathToFileURL } from "node:url";

const repoRoot = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const addonRoot = path.join(repoRoot, "TheBrokenScript_Bedrock_2_0");
const bpRoot = path.join(addonRoot, "BP");
const rpRoot = path.join(addonRoot, "RP");

async function readJsonOrNull(file) {
  try {
    return JSON.parse(await readFile(file, "utf8"));
  } catch {
    return null;
  }
}

async function exists(file) {
  try {
    await access(file);
    return true;
  } catch {
    return false;
  }
}

test("VHS UI uses a valid additional HUD control and declares every source texture", async () => {
  const defs = await readJsonOrNull(path.join(rpRoot, "ui/_ui_defs.json"));
  const hud = await readJsonOrNull(path.join(rpRoot, "ui/hud_screen.json"));
  const overlay = await readJsonOrNull(path.join(rpRoot, "ui/vhs_overlay.json"));

  assert.ok(defs, "VHS _ui_defs.json must exist");
  assert.ok(hud, "VHS HUD patch must exist");
  assert.ok(overlay, "VHS overlay definition must exist");
  assert.ok(defs.ui_defs.includes("ui/vhs_overlay.json"));
  assert.equal(hud.hud_screen?.$additional_screen_content, "vhs_overlay.root");
  assert.equal(hud.root_panel, undefined, "cross-namespace modifications must not be used");

  const textures = [...JSON.stringify(overlay).matchAll(/textures\/ui\/vhs\/[a-z0-9_]+/g)]
    .map((match) => match[0]);
  assert.ok(textures.length >= 10, "overlay must retain the supplied VHS layers");
  for (const texture of new Set(textures)) {
    assert.equal(await exists(path.join(rpRoot, `${texture}.png`)), true, `${texture}.png`);
  }
});

test("resource manifest enables Vibrant Visuals and all four VHS severity subpacks", async () => {
  const manifest = await readJsonOrNull(path.join(rpRoot, "manifest.json"));
  assert.ok(manifest, "resource manifest must exist");
  assert.ok(manifest.capabilities?.includes("pbr"));
  assert.deepEqual(
    manifest.subpacks?.map((entry) => entry.folder_name),
    ["clean_tape", "damaged_lp", "severe_tracking", "worn_sp"],
  );
  for (const folder of manifest.subpacks.map((entry) => entry.folder_name)) {
    assert.equal(
      await exists(path.join(rpRoot, `subpacks/${folder}/textures/ui/vhs/grain_atlas.png`)),
      true,
      `${folder} must provide its grain atlas`,
    );
  }
});

test("behavior manifest declares the stable server UI module used by the Polaroid", async () => {
  const manifest = await readJsonOrNull(path.join(bpRoot, "manifest.json"));
  const packageMetadata = await readJsonOrNull(path.join(repoRoot, "package.json"));
  assert.ok(manifest, "behavior manifest must exist");
  assert.ok(packageMetadata, "package metadata must exist");
  const dependency = manifest.dependencies?.find((entry) => entry.module_name === "@minecraft/server-ui");
  assert.equal(dependency?.version, "2.1.0");
  assert.equal(
    packageMetadata.devDependencies?.["@minecraft/server-ui"],
    "2.3.0-beta.1.26.50-preview.26",
    "CI typings must accept the pinned @minecraft/server 2.11 preview",
  );
});

test("functional Java-source item ports are connected to Script API v2 components", async () => {
  const expected = new Map([
    ["hand_cannon.json", "thebrokenscript:hand_cannon_use"],
    ["polaroid.json", "thebrokenscript:polaroid_use"],
    ["portal_linker.json", "thebrokenscript:portal_linker_use"],
    ["desyncer.json", "thebrokenscript:desyncer_use"],
    ["circuit_cave_painting.json", "thebrokenscript:circuit_cave_place"],
  ]);
  const lang = await readFile(path.join(rpRoot, "texts/en_US.lang"), "utf8");

  for (const [file, component] of expected) {
    const item = await readJsonOrNull(path.join(bpRoot, "items", file));
    assert.ok(item, `${file} must exist`);
    assert.deepEqual(item["minecraft:item"]?.components?.[component], {});
    assert.equal(item["minecraft:item"]?.components?.["minecraft:interact_button"], true);
    const identifier = item["minecraft:item"]?.description?.identifier?.split(":")[1];
    assert.match(lang, new RegExp(`^item\\.thebrokenscript\\.${identifier}=.+$`, "m"));
  }
});

test("hand cannon targeting selects the first non-shooter entity within 100 blocks", async () => {
  const modulePath = path.join(bpRoot, "scripts/systems/ported_feature_logic.js");
  assert.equal(await exists(modulePath), true, "ported feature logic must exist");
  const { firstHandCannonTarget } = await import(pathToFileURL(modulePath));
  const shooter = { id: "shooter" };
  const target = { id: "target" };
  const far = { id: "far" };
  const spectator = {
    id: "spectator",
    typeId: "minecraft:player",
    getGameMode: () => "Spectator",
  };
  assert.equal(
    firstHandCannonTarget(
      [{ entity: shooter, distance: 0 }, { entity: target, distance: 12 }, { entity: far, distance: 101 }],
      shooter.id,
    ),
    target,
  );
  assert.equal(
    firstHandCannonTarget(
      [{ entity: spectator, distance: 4 }, { entity: target, distance: 12 }],
      shooter.id,
    ),
    target,
    "the Java hand cannon ignores spectator players",
  );
  assert.equal(firstHandCannonTarget([{ entity: far, distance: 101 }], shooter.id), undefined);
});

test("painting placement maps only horizontal wall faces to stable offsets and yaw", async () => {
  const modulePath = path.join(bpRoot, "scripts/systems/ported_feature_logic.js");
  assert.equal(await exists(modulePath), true, "ported feature logic must exist");
  const { circuitPaintingPlacement } = await import(pathToFileURL(modulePath));
  const block = { x: 10, y: 20, z: 30 };
  assert.deepEqual(circuitPaintingPlacement(block, "North"), {
    location: { x: 10.5, y: 20, z: 29.49 },
    yaw: 180,
  });
  assert.deepEqual(circuitPaintingPlacement(block, "East"), {
    location: { x: 11.51, y: 20, z: 30.5 },
    yaw: -90,
  });
  assert.equal(circuitPaintingPlacement(block, "Up"), undefined);
});

test("portal link storage is symmetric and dimension-safe", async () => {
  const modulePath = path.join(bpRoot, "scripts/systems/ported_feature_logic.js");
  assert.equal(await exists(modulePath), true, "ported feature logic must exist");
  const { linkPortals, linkedPortal } = await import(pathToFileURL(modulePath));
  const a = { dimensionId: "minecraft:overworld", x: 1, y: 64, z: 2 };
  const b = { dimensionId: "thebrokenscript:limbo", x: 8, y: 70, z: 9 };
  const links = linkPortals({}, a, b);
  assert.deepEqual(linkedPortal(links, a), b);
  assert.deepEqual(linkedPortal(links, b), a);
});

test("portal block interaction preserves the old fallback and does not swallow linker use", async () => {
  const source = await readFile(path.join(bpRoot, "scripts/systems/custom_blocks.js"), "utf8");
  assert.match(source, /heldItemTypeId\(ev\.player\) === "thebrokenscript:portal_linker"/);
  assert.match(source, /dimensions\.teleportTo\(ev\.player, "clan_void", loc\)/);
});

test("ported effects expose finite tick durations and the horror event applies leave pressure", async () => {
  const featurePath = path.join(bpRoot, "scripts/systems/ported_features.js");
  const horrorPath = path.join(bpRoot, "scripts/systems/horror_events.js");
  const eyesPath = path.join(rpRoot, "particles/eyes.particle.json");
  assert.equal(await exists(featurePath), true, "ported feature runtime must exist");
  const source = await readFile(featurePath, "utf8");
  const horror = await readFile(horrorPath, "utf8");
  assert.match(source, /export function applyHeartCorruption\(/);
  assert.match(source, /export function applyWhyCantYouLeave\(/);
  assert.match(source, /EntityDamageCause\.magic/);
  assert.match(source, /spawnParticle\("thebrokenscript:eyes"/);
  assert.match(horror, /applyWhyCantYouLeave\(p, 1000\)/);
  const eyes = await readJsonOrNull(eyesPath);
  assert.equal(eyes?.particle_effect?.description?.identifier, "thebrokenscript:eyes");
  assert.equal(await exists(path.join(rpRoot, "textures/particle/eyes.png")), true);
});

test("circuit cave painting surrogate has a complete BP/RP entity chain", async () => {
  const files = [
    "BP/entities/circuit_cave_painting.json",
    "RP/entity/circuit_cave_painting.entity.json",
    "RP/models/entity/circuit_cave_painting.geo.json",
    "RP/render_controllers/circuit_cave_painting.render_controllers.json",
    "RP/textures/entity/circuit_cave.png",
  ];
  for (const file of files) {
    assert.equal(await exists(path.join(addonRoot, file)), true, file);
  }

  const geometry = await readJsonOrNull(
    path.join(rpRoot, "models/entity/circuit_cave_painting.geo.json"),
  );
  const description = geometry?.["minecraft:geometry"]?.[0]?.description;
  const cube = geometry?.["minecraft:geometry"]?.[0]?.bones?.[0]?.cubes?.[0];
  assert.equal(description?.texture_width, 128);
  assert.equal(description?.texture_height, 64);
  assert.deepEqual(cube?.uv?.north?.uv_size, [128, 64]);

  const runtime = await readFile(path.join(bpRoot, "scripts/systems/ported_features.js"), "utf8");
  assert.match(runtime, /consumeSelectedItem\(player, "thebrokenscript:circuit_cave_painting"\)/);
});
