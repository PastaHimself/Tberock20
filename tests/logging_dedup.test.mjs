import test from "node:test";
import assert from "node:assert/strict";
import { logger } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/logging.js";

function captureConsole(method, fn) {
  const original = console[method];
  const calls = [];
  console[method] = (...args) => calls.push(args.join(" "));
  try {
    fn();
  } finally {
    console[method] = original;
  }
  return calls;
}

test("warnOnce emits one diagnostic per key", () => {
  const key = `warn-${Date.now()}-${Math.random()}`;
  const calls = captureConsole("warn", () => {
    logger.warnOnce(key, "first");
    logger.warnOnce(key, "duplicate");
  });

  assert.deepEqual(calls, ["[tbs] first"]);
});

test("errorOnce emits one error and retains error detail", () => {
  const key = `error-${Date.now()}-${Math.random()}`;
  const calls = captureConsole("error", () => {
    logger.errorOnce(key, "dimension registration failed", new Error("boom"));
    logger.errorOnce(key, "duplicate", new Error("ignored"));
  });

  assert.equal(calls.length, 1);
  assert.match(calls[0], /^\[tbs\] dimension registration failed :: Error: boom/);
});

test("warnOnce and errorOnce have independent key spaces", () => {
  const key = `shared-${Date.now()}-${Math.random()}`;
  const warnings = captureConsole("warn", () => logger.warnOnce(key, "warning"));
  const errors = captureConsole("error", () => logger.errorOnce(key, "error"));

  assert.deepEqual(warnings, ["[tbs] warning"]);
  assert.deepEqual(errors, ["[tbs] error"]);
});
