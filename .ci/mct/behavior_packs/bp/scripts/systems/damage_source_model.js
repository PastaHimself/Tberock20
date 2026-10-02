// Pure source-backed catalog for the Java data/thebrokenscript/damage_type
// entries and TBSDamageTypes registry builders. Bedrock cannot register these
// JSON damage types, so runtime callers use damageSourcePlan() to retain the
// custom source id beside the nearest native Script API attribution.

const NAMESPACE = "thebrokenscript:";
const FALSE_BYPASSES = Object.freeze({
  armor: false,
  effects: false,
  invulnerability: false,
  shield: false,
  totem: false,
});

function freezeDefinition(definition) {
  return Object.freeze({
    ...definition,
    bypasses: Object.freeze({ ...FALSE_BYPASSES, ...(definition.bypasses ?? {}) }),
  });
}

const DEFINITIONS = {
  bad_sun: {
    effects: "burning",
    exhaustion: 0,
    scaling: "never",
    noKnockback: true,
    bypasses: { totem: true },
  },
  bite: {
    deathMessage: "%1$s lost their legs.",
    deathByPlayerMessage: "%1$s lost the lower half of their body whilst fighting %2$s",
    noKnockback: true,
    bypasses: { totem: true },
  },
  fever_attack: {
    deathMessage: "%1$s never saw it coming.",
    deathByPlayerMessage: "%1$s didn't look behind them while fighting %2$s",
    bypasses: { armor: true, effects: true, invulnerability: true, totem: true },
  },
  circuit_attack: {
    deathMessage: "%1$s couldn't hide.",
    deathByPlayerMessage: "%1$s got killed while fighting %2$s",
    bypasses: { armor: true, effects: true, invulnerability: true, totem: true },
  },
  chord_lazer: {
    deathMessage: "%1$s's voice joined the chorus.",
    deathByPlayerMessage: "%1$s was tranced by the symphony while fighting %2$s",
    noKnockback: true,
  },
  integrity_ball: {
    deathMessage: "%1$s was amalgamated.",
    deathByPlayerMessage: "%1$s was amalgamated while fighting %2$s",
    bypasses: { armor: true, effects: true, invulnerability: true, totem: true },
  },
  null_maze: {
    deathMessage: "%1$s was found.",
    deathByPlayerMessage: "%1$s was found while fighting %2$s",
    bypasses: { armor: true, effects: true, totem: true },
  },
  rock: {
    deathMessage: "%1$s got crushed.",
    deathByPlayerMessage: "%1$s got crushed while fighting %2$s",
  },
  jimmy_rise: {
    deathMessage: "%1$s didn't feel the tremors.",
    deathByPlayerMessage: "%1$s didn't feel the tremors while fighting %2$s",
    noKnockback: true,
    bypasses: { armor: true, effects: true, totem: true },
  },
  sa1: {
    deathMessage: "%1$s was disassembled.",
    deathByPlayerMessage: "%1$s was disassembled while fighting %2$s",
    noKnockback: true,
    bypasses: { armor: true, effects: true, totem: true },
  },
  jimmy_stomp: {
    deathMessage: "%1$s was flattened.",
    deathByPlayerMessage: "%1$s was flattened while fighting %2$s",
    bypasses: { armor: true, effects: true, totem: true },
  },
  void_mass: {
    deathMessage: "%1$s is no more.",
    deathByPlayerMessage: "%1$s became no more while fighting %2$s",
    bypasses: { armor: true, effects: true, invulnerability: true, shield: true, totem: true },
  },
  integ_bypass: {
    deathMessage: "%1$s has been killed",
    deathByPlayerMessage: "%1$s has been killed while fighting %2$s",
    bypasses: { armor: true, effects: true, invulnerability: false, shield: true, totem: true },
  },
  hand_cannon_damage: {
    deathMessage: "%1$s was made whole",
    bypasses: { armor: true, effects: true, invulnerability: true, shield: true, totem: false },
  },
  sub_anom_2: {
    deathMessage: "%1$s has been killed",
    deathByPlayerMessage: "%1$s has been killed while fighting %2$s",
    bypasses: { totem: true },
  },
};

// Bedrock cannot register Java DamageType JSON or its bypass tags. These are
// the nearest stable Script API causes and attribution shapes for each source
// callsite; the source id and unsupported Java flags remain explicit metadata.
const BEDROCK_MAPPINGS = {
  bad_sun: { nativeCause: "fire", attribution: "environment" },
  bite: { nativeCause: "entityAttack", attribution: "entity" },
  fever_attack: { nativeCause: "entityAttack", attribution: "entity" },
  circuit_attack: { nativeCause: "entityAttack", attribution: "entity" },
  chord_lazer: { nativeCause: "entityAttack", attribution: "entity" },
  integrity_ball: { nativeCause: "projectile", attribution: "projectile" },
  null_maze: { nativeCause: "entityAttack", attribution: "entity" },
  rock: { nativeCause: "projectile", attribution: "projectile" },
  jimmy_rise: { nativeCause: "entityAttack", attribution: "entity" },
  sa1: { nativeCause: "entityAttack", attribution: "entity" },
  jimmy_stomp: { nativeCause: "entityAttack", attribution: "entity" },
  void_mass: { nativeCause: "void", attribution: "entity" },
  integ_bypass: { nativeCause: "entityAttack", attribution: "entity" },
  hand_cannon_damage: { nativeCause: "magic", attribution: "entity" },
  sub_anom_2: { nativeCause: "entityAttack", attribution: "entity" },
};

export const CUSTOM_DAMAGE_SOURCE_KEYS = Object.freeze(Object.keys(DEFINITIONS));
export const CUSTOM_DAMAGE_SOURCE_COUNT = CUSTOM_DAMAGE_SOURCE_KEYS.length;
export const CUSTOM_DAMAGE_SOURCE_MAPPINGS = Object.freeze(Object.fromEntries(
  CUSTOM_DAMAGE_SOURCE_KEYS.map((key) => [key, Object.freeze({ ...BEDROCK_MAPPINGS[key] })]),
));

export const CUSTOM_DAMAGE_SOURCES = Object.freeze(Object.fromEntries(
  CUSTOM_DAMAGE_SOURCE_KEYS.map((key) => [key, freezeDefinition({
    key,
    id: `${NAMESPACE}${key}`,
    messageId: `thebrokenscript.${key}`,
    deathMessageType: "default",
    effects: "hurt",
    exhaustion: 0.1,
    scaling: "always",
    noKnockback: false,
    mapping: CUSTOM_DAMAGE_SOURCE_MAPPINGS[key],
    ...DEFINITIONS[key],
  })]),
));

function normalizeKey(sourceId) {
  if (typeof sourceId !== "string") return null;
  return sourceId.startsWith(NAMESPACE) ? sourceId.slice(NAMESPACE.length) : sourceId;
}

export function getDamageSource(sourceId) {
  const key = normalizeKey(sourceId);
  return key ? CUSTOM_DAMAGE_SOURCES[key] ?? null : null;
}

/**
 * @param {string} sourceId
 * @param {{
 *   amount?: number;
 *   cause?: string;
 *   damagingEntity?: any;
 *   damagingProjectile?: any;
 * }} [options]
 */
export function damageSourcePlan(sourceId, {
  amount = 0,
  cause,
  damagingEntity = null,
  damagingProjectile = null,
} = {}) {
  const source = getDamageSource(sourceId);
  if (!source) throw new Error(`Unknown custom damage source: ${sourceId}`);
  if (cause !== undefined && cause !== source.mapping.nativeCause) {
    throw new Error(
      `Custom damage source ${source.id} is mapped to ${source.mapping.nativeCause}, not ${cause}`,
    );
  }
  return {
    sourceId: source.id,
    amount,
    cause: source.mapping.nativeCause,
    damagingEntity,
    damagingProjectile,
  };
}

/**
 * Builds one of the two mutually exclusive applyDamage option shapes exposed
 * by the Bedrock Script API. Projectile attribution implies the native
 * projectile cause, so it must not be mixed with the ordinary `cause` field.
 */
export function damageSourceApplyOptions(plan) {
  if (plan?.damagingProjectile) {
    return {
      ...(plan.damagingEntity ? { damagingEntity: plan.damagingEntity } : {}),
      damagingProjectile: plan.damagingProjectile,
    };
  }
  return {
    cause: plan?.cause,
    ...(plan?.damagingEntity ? { damagingEntity: plan.damagingEntity } : {}),
  };
}
