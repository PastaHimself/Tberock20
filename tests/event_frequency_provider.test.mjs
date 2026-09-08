import test from "node:test";
import assert from "node:assert/strict";

const moduleUrl = new URL(
  "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/event_frequency.js",
  import.meta.url,
);

async function freshEventFrequencyModule(label) {
  const url = new URL(moduleUrl);
  url.searchParams.set("test", `${label}-${Date.now()}-${Math.random()}`);
  return import(url.href);
}

function captureConsole(method, fn) {
  const original = console[method];
  const calls = [];
  console[method] = (...args) => calls.push(args.join(" "));
  try {
    return { value: fn(), calls };
  } finally {
    console[method] = original;
  }
}

test("missing event-frequency provider falls back to zero and warns once", async () => {
  const frequency = await freshEventFrequencyModule("missing");
  assert.equal(frequency.hasEventFrequencyProvider(), false);

  const { calls } = captureConsole("warn", () => {
    assert.equal(frequency.eventFrequency(0), 0);
    assert.equal(frequency.eventFrequency(12000), 0);
  });

  assert.equal(calls.length, 1);
  assert.match(calls[0], /no escalation provider is installed/);
});

test("event-frequency provider can be installed exactly once", async () => {
  const frequency = await freshEventFrequencyModule("installed");
  const provider = (gameTime) => Math.floor(gameTime / 1000);

  frequency.setEventFrequencyProvider(provider);
  assert.equal(frequency.hasEventFrequencyProvider(), true);
  assert.equal(frequency.eventFrequency(0), 0);
  assert.equal(frequency.eventFrequency(999), 0);
  assert.equal(frequency.eventFrequency(1000), 1);
  assert.equal(frequency.eventFrequency(5500), 5);
  assert.throws(
    () => frequency.setEventFrequencyProvider(() => 99),
    /already installed/,
  );
});

test("invalid provider output is contained and reported", async () => {
  const frequency = await freshEventFrequencyModule("invalid");
  frequency.setEventFrequencyProvider(() => Number.NaN);

  const { value, calls } = captureConsole("error", () => frequency.eventFrequency(42));
  assert.equal(value, 0);
  assert.equal(calls.length, 1);
  assert.match(calls[0], /non-finite contribution/);
});
