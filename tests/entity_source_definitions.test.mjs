import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const entityDir = path.join(root, "TheBrokenScript_Bedrock_2_0/BP/entities");
const registry = fs.readFileSync(path.join(root, "decompiled/net/thebrokenscript/registry/TBSEntities.java"), "utf8");

const aliases = {
  cave_sound: "eerie_noise",
  integ_fireball: "integ_fireball",
  integrity_p3_ground_arm: "integrity_arm",
  integrity_phase1: "integrity_phase_1",
  integrity_phase2: "integrity_phase_2",
  integrity_phase3: "integrity_phase_3",
  nothing_is_watching: "niw",
  nothing_is_watching_chase: "nothingiswatchingchase",
  null_chase: "nulll",
  obliteration: "the_obliteration",
  obliteration_2: "the_obliteration_2",
};

function component(slug, id) {
  const json = JSON.parse(fs.readFileSync(path.join(entityDir, `${slug}.json`), "utf8"));
  return json["minecraft:entity"].components[id];
}

function slugOf(name) {
  const lower = name.toLowerCase();
  return aliases[lower] ?? lower;
}

function registeredAttributes() {
  const records = [];
  const method = /private static final void ([A-Z][A-Z0-9_]*)\$lambda\$0\$\d+\(AttributeSupplier\.Builder \$this\$attrs\) \{([^}]+)\}/g;
  for (const match of registry.matchAll(method)) {
    const slug = slugOf(match[1]);
    if (!fs.existsSync(path.join(entityDir, `${slug}.json`))) continue;
    records.push({ slug, body: match[2] });
  }
  return records;
}

test("Bedrock entity values follow explicit Java registry attributes", () => {
  const ids = {
    MovementSpeed: ["minecraft:movement", "value"],
    MaxHealth: ["minecraft:health", "value"],
    AttackDamage: ["minecraft:attack", "damage"],
    FollowRange: ["minecraft:follow_range", "value"],
    KnockbackResistance: ["minecraft:knockback_resistance", "value"],
  };
  let checked = 0;
  for (const { slug, body } of registeredAttributes()) {
    const attribute = /AttributeUtil\.set(\w+)\(\(AttributeSupplier\.Builder\)\$this\$attrs, \(Number\)(-?\d+(?:\.\d+)?)\)/g;
    for (const [, name, value] of body.matchAll(attribute)) {
      if (!ids[name]) continue;
      const [id, property] = ids[name];
      // Bedrock's knockback resistance is normalized to [0, 1].
      const expected = name === "KnockbackResistance" ? Math.min(Number(value), 1) : Number(value);
      assert.equal(component(slug, id)?.[property], expected, `${slug}: ${name}`);
      checked++;
    }
  }
  assert.ok(checked > 150, `Expected a broad registry audit, got ${checked} fields`);
});

test("Bedrock entities preserve Java registry fire immunity", () => {
  const method = /private static final void ([A-Z][A-Z0-9_]*)\$lambda\$0\$\d+\(EntityType\.Builder \$this\$props\) \{([^}]+)\}/g;
  let checked = 0;
  for (const match of registry.matchAll(method)) {
    if (!match[2].includes("$this$props.fireImmune()")) continue;
    const slug = slugOf(match[1]);
    if (!fs.existsSync(path.join(entityDir, `${slug}.json`))) continue;
    assert.deepEqual(component(slug, "minecraft:fire_immune"), {}, slug);
    checked++;
  }
  // null_chase is the Bedrock alias of the registered nulll entity.
  assert.deepEqual(component("null_chase", "minecraft:fire_immune"), {});
  assert.ok(checked > 50, `Expected a broad immunity audit, got ${checked} entities`);
});

test("ordinary entity collision boxes match their Java registrations", () => {
  // These three have deliberate scripted projectile or multipart collision adapters.
  const adapted = new Set(["fractured", "fractured_roam", "rock"]);
  const method = /private static final void ([A-Z][A-Z0-9_]*)\$lambda\$0\$\d+\(EntityType\.Builder \$this\$props\) \{([^}]+)\}/g;
  let checked = 0;
  for (const match of registry.matchAll(method)) {
    const slug = slugOf(match[1]);
    if (adapted.has(slug) || !fs.existsSync(path.join(entityDir, `${slug}.json`))) continue;
    const size = match[2].match(/\$this\$props\.sized\((\d+(?:\.\d+)?)f?,\s*(\d+(?:\.\d+)?)f?\)/);
    if (!size) continue;
    const box = component(slug, "minecraft:collision_box");
    assert.equal(box.width, Number(size[1]), `${slug}: width`);
    assert.equal(box.height, Number(size[2]), `${slug}: height`);
    checked++;
  }
  assert.ok(checked > 50, `Expected a broad collision audit, got ${checked} entities`);
});

test("entity classes with their own attributes retain the Java values", () => {
  const cases = [
    ["null_watching", "nullent/NullWatchingEntity.java", "ATTACK_DAMAGE", "minecraft:attack", "damage"],
    ["null_invade_base", "nullent/NullInvadeBaseEntity.java", "FOLLOW_RANGE", "minecraft:follow_range", "value"],
    ["null_unbeatable_bossfight", "nullent/NullUnbeatableBossfightEntity.java", "ATTACK_DAMAGE", "minecraft:attack", "damage"],
    ["null_unbeatable_bossfight", "nullent/NullUnbeatableBossfightEntity.java", "FOLLOW_RANGE", "minecraft:follow_range", "value"],
    ["herobrine", "HerobrineEntity.java", "KNOCKBACK_RESISTANCE", "minecraft:knockback_resistance", "value"],
    ["curved", "players/CurvedEntity.java", "KNOCKBACK_RESISTANCE", "minecraft:knockback_resistance", "value"],
  ];
  for (const [slug, source, attribute, id, property] of cases) {
    const java = fs.readFileSync(path.join(root, "decompiled/net/thebrokenscript/entity", source), "utf8");
    const match = java.match(new RegExp(`\\.add\\(Attributes\\.${attribute},\\s*(\\d+(?:\\.\\d+)?)\\)`));
    assert.ok(match, `${slug}: missing Java ${attribute}`);
    const expected = attribute === "KNOCKBACK_RESISTANCE" ? Math.min(Number(match[1]), 1) : Number(match[1]);
    assert.equal(component(slug, id)?.[property], expected, `${slug}: ${attribute}`);
  }
});
