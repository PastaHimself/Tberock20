// Source-backed Fractured/Jimmy animation names and GeckoLib keyframe timing.
// This module stays pure so it can be regression-tested without Bedrock.

const TICKS_PER_SECOND = 20;

export const FRACTURED_ANIMATION_SOURCE = Object.freeze({
  ticksPerSecond: TICKS_PER_SECOND,
  attacks: Object.freeze({
    stomp: Object.freeze({
      animation: "OffenseStompShockwave",
      lengthSeconds: 2.5,
      sourceLengthTicks: 78,
      events: Object.freeze({ SingleStomp: 0.68 }),
    }),
    slam: Object.freeze({
      animation: "OffenseSlam",
      lengthSeconds: 3.9,
      sourceLengthTicks: 78,
      events: Object.freeze({ Slam: 1.23 }),
    }),
    moonRockToss: Object.freeze({
      animation: "MoonRockToss",
      lengthSeconds: 6.48,
      sourceLengthTicks: 139,
      events: Object.freeze({
        OffenseRockGrab: 1.41,
        OffenseRockThrow: 5.24,
      }),
    }),
    airLift: Object.freeze({
      animation: "DefenseAirLift",
      lengthSeconds: 2.98,
      sourceLengthTicks: 60,
      events: Object.freeze({ DefensiveRockRelease: 2.27 }),
    }),
  }),
});

// The source uses an explicit server tick for the stomp hit. The other
// instruction keyframes are client-rendered GeckoLib events, so their exact
// seconds are rounded to the nearest 20 Hz Bedrock runtime tick.
const RUNTIME_EVENT_TICKS = Object.freeze({
  stomp: Object.freeze({ SingleStomp: 13 }),
  slam: Object.freeze({ Slam: 25 }),
  moonRockToss: Object.freeze({ OffenseRockGrab: 28, OffenseRockThrow: 105 }),
  airLift: Object.freeze({ DefensiveRockRelease: 45 }),
});

const ATTACK_ANIMATIONS = Object.freeze({
  noop: "Idle",
  loss: "Loss",
  stomp: "OffenseStompShockwave",
  slam: "OffenseSlam",
  moonRockToss: "MoonRockToss",
  airLift: "DefenseAirLift",
});

// BaseFracturedEntity's controller selects these presentation clips from the
// lifecycle state. Keep the state names source-shaped so the runtime cannot
// silently drift from the Java controller mapping.
export const FRACTURED_PRESENTATION_ANIMATIONS = Object.freeze({
  RISING: "Spawn",
  NORMAL_IDLE: "Idle",
  NORMAL_WALK: "Walk",
  DIGGING: "Flee",
  UNDERGROUND: "Underground",
  DESPAWNING: "Flee",
  SWITCHING: "Flee",
  DEFEATED: "Loss",
});

/**
 * These are the bones forced into a world-space matrix by FracturedModel and
 * then read by FracturedEntity's custom instruction handler.
 */
export const FRACTURED_RENDERED_CONTACT_SOURCE = Object.freeze({
  trackedBones: Object.freeze(["ROCK", "right_l_claw", "left_l_claw", "right_f_tarsus"]),
  events: Object.freeze({
    SingleStomp: Object.freeze({
      bones: Object.freeze(["right_f_tarsus"]),
      locators: Object.freeze(["right_f_tarsus_contact"]),
      spatialAdapter: "source_stomp_offset",
    }),
    Slam: Object.freeze({
      bones: Object.freeze(["right_l_claw", "left_l_claw"]),
      locators: Object.freeze(["right_l_claw_contact", "left_l_claw_contact"]),
      spatialAdapter: "bone_world_position",
    }),
    OffenseRockThrow: Object.freeze({
      bones: Object.freeze(["ROCK"]),
      locators: Object.freeze(["rock_contact"]),
      spatialAdapter: "bone_world_position",
    }),
    DefensiveRockRelease: Object.freeze({
      bones: Object.freeze(["ROCK"]),
      locators: Object.freeze(["rock_contact"]),
      spatialAdapter: "bone_world_position",
    }),
  }),
});

// Resource-pack particle events are the exact visual-contact bridge. Their
// emitters follow these geometry locators as the animation moves each bone;
// gameplay damage still uses the separately documented server spatial adapter.
export const FRACTURED_CONTACT_PARTICLE_PRESENTATION = Object.freeze({
  effect: "jimmy_contact_burst",
  events: Object.freeze({
    SingleStomp: Object.freeze([
      Object.freeze({ effect: "jimmy_contact_burst", locator: "right_f_tarsus_contact" }),
    ]),
    Slam: Object.freeze([
      Object.freeze({ effect: "jimmy_contact_burst", locator: "right_l_claw_contact" }),
      Object.freeze({ effect: "jimmy_contact_burst", locator: "left_l_claw_contact" }),
    ]),
    OffenseRockThrow: Object.freeze([
      Object.freeze({ effect: "jimmy_contact_burst", locator: "rock_contact" }),
    ]),
    DefensiveRockRelease: Object.freeze([
      Object.freeze({ effect: "jimmy_contact_burst", locator: "rock_contact" }),
    ]),
  }),
});

export function fracturedAttackAnimation(attack = "noop") {
  return ATTACK_ANIMATIONS[attack] ?? ATTACK_ANIMATIONS.noop;
}

export function fracturedAnimationId(attack = "noop") {
  return `animation.thebrokenscript.fractured.${fracturedAttackAnimation(attack).toLowerCase()}`;
}

export function fracturedPresentationAnimation(state = "NORMAL", moving = false) {
  if (state === "NORMAL") {
    return moving
      ? FRACTURED_PRESENTATION_ANIMATIONS.NORMAL_WALK
      : FRACTURED_PRESENTATION_ANIMATIONS.NORMAL_IDLE;
  }
  return FRACTURED_PRESENTATION_ANIMATIONS[state]
    ?? FRACTURED_PRESENTATION_ANIMATIONS.NORMAL_IDLE;
}

export function fracturedPresentationAnimationId(state = "NORMAL", moving = false) {
  return `animation.thebrokenscript.fractured.${fracturedPresentationAnimation(state, moving).toLowerCase()}`;
}

export function fracturedAnimationEventTick(attack, eventName) {
  const definition = FRACTURED_ANIMATION_SOURCE.attacks[attack];
  if (!definition || !Object.prototype.hasOwnProperty.call(definition.events, eventName)) return null;
  const explicit = RUNTIME_EVENT_TICKS[attack]?.[eventName];
  if (explicit !== undefined) return explicit;
  return Math.round(definition.events[eventName] * TICKS_PER_SECOND);
}

/** Returns the source instruction names fired on one runtime attack tick. */
export function fracturedAnimationEventPlan(attack, attackTicks) {
  const definition = FRACTURED_ANIMATION_SOURCE.attacks[attack];
  if (!definition) return [];
  return Object.keys(definition.events).filter((eventName) =>
    fracturedAnimationEventTick(attack, eventName) === attackTicks);
}
