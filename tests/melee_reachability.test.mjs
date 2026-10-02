import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");

function read(relative) {
  return fs.readFileSync(path.join(root, relative), "utf8");
}

function functionBody(source, name) {
  const start = source.indexOf(`function ${name}(`);
  assert.notEqual(start, -1, `missing ${name}`);
  const next = source.indexOf("\nfunction ", start + 1);
  return source.slice(start, next === -1 ? source.length : next);
}

test("TBE Java custom melee is consumed by a 600-damage 20-tick attributed Bedrock adapter", () => {
  const java = read("decompiled/net/thebrokenscript/entity/tbe/TheBrokenEndEntity.java");
  const controller = read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/tbe/tbe_controller.js");
  const model = read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/tbe/tbe_source_model.js");
  assert.match(java, /this\.attackCooldownTicks = 20/);
  assert.match(java, /expandedBox\.intersects\(target\.getBoundingBox\(\)\).*hasLineOfSight/s);
  assert.match(model, /attackDamage:\s*600/);
  assert.match(model, /attackCooldownTicks:\s*20/);
  assert.match(controller, /tbeMeleeBoxIntersects\(e\.location, player\.location\)/);
  assert.match(controller, /EntityDamageCause\.entityAttack/);
  assert.doesNotMatch(controller, /melee handled by BP components/);
});

test("NullWatching consumes its Java Player-target melee without inventing movement", () => {
  const java = read("decompiled/net/thebrokenscript/entity/nullent/NullWatchingEntity.java");
  const controller = read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_controller.js");
  assert.match(java, /NearestAttackableTargetGoal\(\(Mob\)this, Player\.class/);
  assert.match(java, /new MeleeAttackGoal\(\(PathfinderMob\)this, 1\.2, false\)/);
  assert.match(java, /Attributes\.MOVEMENT_SPEED, 0\.0/);
  assert.match(controller, /WATCHING_ATTACK_DAMAGE = 63/);
  assert.match(controller, /WATCHING_ATTACK_INTERVAL = 20/);
  assert.match(controller, /WATCHING_ATTACK_RANGE = 1\.5/);
  assert.match(functionBody(controller, "tickWatching"), /EntityDamageCause\.entityAttack/);
});

test("NullIsHere and NullUnbeatable remain non-proactive because Java has no Player target selector", () => {
  const isHereJava = read("decompiled/net/thebrokenscript/entity/nullent/NullIsHereEntity.java");
  const unbeatableJava = read("decompiled/net/thebrokenscript/entity/nullent/NullUnbeatableBossfightEntity.java");
  const nullController = read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_controller.js");
  const pursuit = read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_pursuit_controller.js");
  assert.doesNotMatch(isHereJava, /NearestAttackableTargetGoal/);
  assert.doesNotMatch(unbeatableJava, /NearestAttackableTargetGoal/);
  assert.doesNotMatch(functionBody(nullController, "tickIsHere"), /applyDamage\(313|teleport\(/);
  assert.doesNotMatch(functionBody(pursuit, "tickUnbeatable"), /applyDamage\(/);
});

test("SubAnomaly1 combat runs independently from the 40-tick corruption schedule", () => {
  const java = read("decompiled/net/thebrokenscript/entity/anomaly/sa1/SubAnomaly1Entity.java");
  const controller = read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/stalk/stalk_controller.js");
  const body = functionBody(controller, "tickSubAnomaly");
  assert.match(java, /NearestAttackableTargetGoal\(\(Mob\)this, Player\.class/);
  assert.match(java, /new MeleeAttackGoal\(\(PathfinderMob\)this, 1\.2, false\)/);
  assert.match(controller, /SUB1_ATTACK_DAMAGE = 1/);
  assert.match(controller, /SUB1_ATTACK_INTERVAL = 20/);
  assert.ok(body.indexOf("tickSubAnomaly1Combat(e)") < body.indexOf("system.currentTick % 40"));
  assert.match(functionBody(controller, "tickSubAnomaly1Combat"), /EntityDamageCause\.entityAttack/);
});

test("SubAnomaly2 uses its source brain close attack rather than a fabricated vanilla melee goal", () => {
  const ai = read("decompiled/net/thebrokenscript/api/entity/ai/anomaly2/SubAnomaly2Ai.java");
  const controller = read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/stalk/stalk_controller.js");
  assert.match(ai, /distanceToSqr\(\(Entity\)target\) < 2\.0/);
  assert.match(ai, /target\.hurt\(owner\.damageSources\(\)\.generic\(\), 2\.0f\)/);
  assert.match(controller, /SUB2_CLOSE_DAMAGE = 2/);
  assert.match(controller, /SUB2_CLOSE_RANGE_SQR = 2/);
  assert.doesNotMatch(functionBody(controller, "tickSubAnomaly2CloseAttack"), /EntityDamageCause\.entityAttack/);
});

test("Deceiver remains a contact-discard presentation entity instead of gaining an extra scripted melee pulse", () => {
  const java = read("decompiled/net/thebrokenscript/entity/DeceiverEntity.java");
  const controller = read("TheBrokenScript_Bedrock_2_0/BP/scripts/entities/humanoid/humanoid_controller.js");
  assert.match(java, /EntityUtil\.isWithin[^\n]*\(Number\)10/);
  assert.match(java, /this\.discard\(\)/);
  assert.doesNotMatch(functionBody(controller, "tickDeceiver"), /applyDamage\(13/);
});
