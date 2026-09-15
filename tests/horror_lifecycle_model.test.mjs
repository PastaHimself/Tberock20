import test from "node:test";
import assert from "node:assert/strict";
import {
  createLifecycleState,
  invalidateAll,
  invalidatePlayer,
  isLifecycleTokenValid,
  issueLifecycleToken,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/shared/horror_lifecycle_model.js";

test("player lifecycle tokens are replaced and invalidated independently", () => {
  const state = createLifecycleState();
  const first = issueLifecycleToken(state, "player-a");
  const other = issueLifecycleToken(state, "player-b");
  assert.equal(isLifecycleTokenValid(state, "player-a", first), true);
  assert.equal(isLifecycleTokenValid(state, "player-b", other), true);
  const replacement = issueLifecycleToken(state, "player-a");
  assert.equal(isLifecycleTokenValid(state, "player-a", first), false);
  assert.equal(isLifecycleTokenValid(state, "player-a", replacement), true);
  invalidatePlayer(state, "player-b");
  assert.equal(isLifecycleTokenValid(state, "player-b", other), false);
  invalidateAll(state);
  assert.equal(isLifecycleTokenValid(state, "player-a", replacement), false);
});
