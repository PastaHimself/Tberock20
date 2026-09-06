import test from "node:test";
import assert from "node:assert/strict";
import {
  FRACTURED_ANIMATION_SOURCE,
  FRACTURED_CONTACT_PARTICLE_PRESENTATION,
  FRACTURED_PRESENTATION_ANIMATIONS,
  FRACTURED_RENDERED_CONTACT_SOURCE,
  fracturedAnimationEventPlan,
  fracturedAnimationId,
  fracturedAnimationEventTick,
  fracturedAttackAnimation,
  fracturedPresentationAnimation,
  fracturedPresentationAnimationId,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_animation_model.js";

test("Jimmy attack animations preserve source names and lengths", () => {
  assert.deepEqual(FRACTURED_ANIMATION_SOURCE.attacks, {
    stomp: {
      animation: "OffenseStompShockwave",
      lengthSeconds: 2.5,
      sourceLengthTicks: 78,
      events: { SingleStomp: 0.68 },
    },
    slam: {
      animation: "OffenseSlam",
      lengthSeconds: 3.9,
      sourceLengthTicks: 78,
      events: { Slam: 1.23 },
    },
    moonRockToss: {
      animation: "MoonRockToss",
      lengthSeconds: 6.48,
      sourceLengthTicks: 139,
      events: { OffenseRockGrab: 1.41, OffenseRockThrow: 5.24 },
    },
    airLift: {
      animation: "DefenseAirLift",
      lengthSeconds: 2.98,
      sourceLengthTicks: 60,
      events: { DefensiveRockRelease: 2.27 },
    },
  });
  assert.equal(fracturedAttackAnimation("stomp"), "OffenseStompShockwave");
  assert.equal(fracturedAttackAnimation("slam"), "OffenseSlam");
  assert.equal(fracturedAttackAnimation("moonRockToss"), "MoonRockToss");
  assert.equal(fracturedAttackAnimation("airLift"), "DefenseAirLift");
  assert.equal(fracturedAnimationId("slam"), "animation.thebrokenscript.fractured.offenseslam");
  assert.equal(fracturedAnimationId("noop"), "animation.thebrokenscript.fractured.idle");
});

test("source keyframe times convert to deterministic 20 Hz runtime ticks", () => {
  assert.equal(fracturedAnimationEventTick("stomp", "SingleStomp"), 13);
  assert.equal(fracturedAnimationEventTick("slam", "Slam"), 25);
  assert.equal(fracturedAnimationEventTick("moonRockToss", "OffenseRockGrab"), 28);
  assert.equal(fracturedAnimationEventTick("moonRockToss", "OffenseRockThrow"), 105);
  assert.equal(fracturedAnimationEventTick("airLift", "DefensiveRockRelease"), 45);
});

test("rendered contact events retain the Java tracked bone contract", () => {
  assert.deepEqual(FRACTURED_RENDERED_CONTACT_SOURCE, {
    trackedBones: ["ROCK", "right_l_claw", "left_l_claw", "right_f_tarsus"],
    events: {
      SingleStomp: {
        bones: ["right_f_tarsus"],
        locators: ["right_f_tarsus_contact"],
        spatialAdapter: "source_stomp_offset",
      },
      Slam: {
        bones: ["right_l_claw", "left_l_claw"],
        locators: ["right_l_claw_contact", "left_l_claw_contact"],
        spatialAdapter: "bone_world_position",
      },
      OffenseRockThrow: { bones: ["ROCK"], locators: ["rock_contact"], spatialAdapter: "bone_world_position" },
      DefensiveRockRelease: { bones: ["ROCK"], locators: ["rock_contact"], spatialAdapter: "bone_world_position" },
    },
  });
});

test("rendered contact presentation binds source events to animated bone locators", () => {
  assert.deepEqual(FRACTURED_CONTACT_PARTICLE_PRESENTATION, {
    effect: "jimmy_contact_burst",
    events: {
      SingleStomp: [{ effect: "jimmy_contact_burst", locator: "right_f_tarsus_contact" }],
      Slam: [
        { effect: "jimmy_contact_burst", locator: "right_l_claw_contact" },
        { effect: "jimmy_contact_burst", locator: "left_l_claw_contact" },
      ],
      OffenseRockThrow: [{ effect: "jimmy_contact_burst", locator: "rock_contact" }],
      DefensiveRockRelease: [{ effect: "jimmy_contact_burst", locator: "rock_contact" }],
    },
  });
});

test("event plans fire once at the source event tick", () => {
  assert.deepEqual(fracturedAnimationEventPlan("slam", 24), []);
  assert.deepEqual(fracturedAnimationEventPlan("slam", 25), ["Slam"]);
  assert.deepEqual(fracturedAnimationEventPlan("moonRockToss", 105), ["OffenseRockThrow"]);
  assert.deepEqual(fracturedAnimationEventPlan("airLift", 45), ["DefensiveRockRelease"]);
});

test("roam presentation states preserve the BaseFractured controller mapping", () => {
  assert.deepEqual(FRACTURED_PRESENTATION_ANIMATIONS, {
    RISING: "Spawn",
    NORMAL_IDLE: "Idle",
    NORMAL_WALK: "Walk",
    DIGGING: "Flee",
    UNDERGROUND: "Underground",
    DESPAWNING: "Flee",
    SWITCHING: "Flee",
    DEFEATED: "Loss",
  });
  assert.equal(fracturedPresentationAnimation("RISING"), "Spawn");
  assert.equal(fracturedPresentationAnimation("NORMAL", false), "Idle");
  assert.equal(fracturedPresentationAnimation("NORMAL", true), "Walk");
  assert.equal(fracturedPresentationAnimation("UNDERGROUND"), "Underground");
  assert.equal(fracturedPresentationAnimation("SWITCHING"), "Flee");
  assert.equal(fracturedPresentationAnimationId("NORMAL", true), "animation.thebrokenscript.fractured.walk");
  assert.equal(fracturedPresentationAnimationId("DEFEATED"), "animation.thebrokenscript.fractured.loss");
});
