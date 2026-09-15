import assert from "node:assert/strict";
import test from "node:test";
import {
  DAMAGE_LEDGER_MAX_ENTRIES_PER_TARGET,
  appendDamageLedgerEntry,
  getDamageLedgerEntries,
  getLatestDamageLedgerEntry,
  pruneDamageLedger,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/damage_source_ledger_model.js";

test("damage ledger preserves every same-tick source in arrival order", () => {
  const ledger = new Map();
  appendDamageLedgerEntry(ledger, "victim", {
    sourceId: "thebrokenscript:rock",
    cause: "projectile",
    amount: 15,
    damagingEntityId: "jimmy-a",
    damagingProjectileId: "rock-a",
    accepted: true,
    fallback: false,
    tick: 42,
  });
  appendDamageLedgerEntry(ledger, "victim", {
    sourceId: "thebrokenscript:fever_attack",
    cause: "entityAttack",
    amount: 10,
    damagingEntityId: "fever-b",
    damagingProjectileId: null,
    accepted: true,
    fallback: false,
    tick: 42,
  });

  assert.deepEqual(getDamageLedgerEntries(ledger, "victim", 42), [
    {
      sourceId: "thebrokenscript:rock",
      cause: "projectile",
      amount: 15,
      damagingEntityId: "jimmy-a",
      damagingProjectileId: "rock-a",
      accepted: true,
      fallback: false,
      tick: 42,
    },
    {
      sourceId: "thebrokenscript:fever_attack",
      cause: "entityAttack",
      amount: 10,
      damagingEntityId: "fever-b",
      damagingProjectileId: null,
      accepted: true,
      fallback: false,
      tick: 42,
    },
  ]);
  assert.equal(getLatestDamageLedgerEntry(ledger, "victim", 42).sourceId, "thebrokenscript:fever_attack");
});

test("damage ledger expires records outside its age window without affecting another target", () => {
  const ledger = new Map();
  appendDamageLedgerEntry(ledger, "victim", { sourceId: "thebrokenscript:rock", tick: 10 });
  appendDamageLedgerEntry(ledger, "other", { sourceId: "thebrokenscript:sa1", tick: 12 });

  assert.deepEqual(getDamageLedgerEntries(ledger, "victim", 12, 1), []);
  assert.deepEqual(getDamageLedgerEntries(ledger, "other", 12, 1), [
    { sourceId: "thebrokenscript:sa1", tick: 12 },
  ]);
});

test("damage ledger remains bounded and prunes stale targets without a read", () => {
  const ledger = new Map();
  for (let tick = 0; tick < DAMAGE_LEDGER_MAX_ENTRIES_PER_TARGET + 5; tick += 1) {
    appendDamageLedgerEntry(ledger, "victim", { sourceId: `source-${tick}`, tick: 42 });
  }
  appendDamageLedgerEntry(ledger, "stale", { sourceId: "old", tick: 1 });

  pruneDamageLedger(ledger, 42, 1);
  assert.equal(getDamageLedgerEntries(ledger, "victim", 42).length, DAMAGE_LEDGER_MAX_ENTRIES_PER_TARGET);
  assert.equal(ledger.has("stale"), false);
});
