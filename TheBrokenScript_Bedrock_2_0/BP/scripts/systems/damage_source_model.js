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

export const CUSTOM_DAMAGE_SOURCE_KEYS = Object.freeze(Object.keys(DEFINITIONS));
export const CUSTOM_DAMAGE_SOURCE_COUNT = CUSTOM_DAMAGE_SOURCE_KEYS.length;

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
 * Keeps the source id as pure metadata while carrying the native Bedrock
 * attribution fields accepted by Entity.applyDamage(). The default `override`
 * cause matches script-originated damage; source-specific callers should pass
 * entityAttack, projectile, fire, or void when the Java callsite supplies one.
 */
export function damageSourcePlan(sourceId, {
  amount = 0,
  cause = "override",
  damagingEntity = null,
  damagingProjectile = null,
} = {}) {
  const source = getDamageSource(sourceId);
  if (!source) throw new Error(`Unknown custom damage source: ${sourceId}`);
  return {
    sourceId: source.id,
    amount,
    cause,
    damagingEntity,
    damagingProjectile,
  };
}
