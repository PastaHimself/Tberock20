/**
 * Small token model for deferred Bedrock callbacks.
 *
 * Tokens are scoped by player id and can be invalidated on leave, respawn,
 * death, dimension change, or a global subsystem shutdown.
 */
export function createLifecycleState() {
  return {
    generation: 0,
    players: new Map(),
  };
}

export function issueLifecycleToken(state, playerId) {
  const id = String(playerId ?? "");
  const token = { generation: state.generation, playerId: id, serial: (state.players.get(id)?.serial ?? 0) + 1 };
  state.players.set(id, token);
  return token;
}

export function isLifecycleTokenValid(state, playerId, token) {
  const current = state.players.get(String(playerId ?? ""));
  return Boolean(
    token &&
    current === token &&
    token.generation === state.generation &&
    token.playerId === String(playerId ?? ""),
  );
}

export function invalidatePlayer(state, playerId) {
  const id = String(playerId ?? "");
  state.players.delete(id);
}

export function invalidateAll(state) {
  state.generation += 1;
  state.players.clear();
}
