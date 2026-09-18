# Runtime smoke-test world

This is the engine-level smoke protocol for the Bedrock port. The repository's
Node/Python tests and Mojang Creator Tools checks validate pack structure and
source-backed behavior; they do not start a Minecraft world. The matrix in
[`matrix.json`](matrix.json) is the executable contract for the missing engine
coverage.

## Runtime contract

Run the world on the exact contract in
[`TheBrokenScript_Bedrock_2_0/API_AUDIT.md`](../../TheBrokenScript_Bedrock_2_0/API_AUDIT.md):

- Minecraft Bedrock 1.26.50 Preview line.
- `@minecraft/server` `2.11.0-beta` at runtime.
- `@minecraft/server-ui` `2.1.0` at runtime.
- **Beta APIs** experiment enabled.
- Development packages pinned to the exact preview.26 declarations in
  `package.json`.

Microsoft's versioning guidance says beta APIs have no backwards-compatibility
promise and require the Beta APIs experiment. Do not substitute retail, a later
preview, or a newer npm package and call the result evidence for this matrix.

## Create the repeatable world

1. Build the pack from the repository root. The packager fixes archive metadata
   from `SOURCE_DATE_EPOCH` and uses metadata-free, sorted ZIP entries so the
   resulting `.mcaddon` can be hashed reproducibly:

   ```bash
   bash tools/package-addon.sh
   ```

2. Import `dist/The_Broken_Script_2_0.mcaddon` into the matching Bedrock Preview
   client or install its BP/RP folders on the matching Bedrock Dedicated Server.
3. Create a new world with the exact values in `matrix.json`:
   - name: `TBS 2.0 Runtime Smoke 1.26.50 Preview`;
   - seed: `260501126`;
   - difficulty: Normal;
   - cheats enabled and the operator in Creative mode;
   - **Beta APIs** enabled;
   - both the behavior and resource packs applied to the world.
4. Set the world spawn to `0 80 0`, keep the initial probe area clear, and take a
   screenshot of the world settings before entering it.
5. In **Settings → Creator**, enable **Content Log File** and **Content Log
   GUI**. Use Info or Verbose GUI logging for the run. Keep the complete log
   file; do not copy only the final error line.

The content log is the primary runtime evidence. On current Windows Preview it
is under `%APPDATA%\\Minecraft Bedrock Preview\\logs\\`; Android and iOS use
the platform's `games/com.mojang/logs` or `Minecraft/game/com.mojang/logs`
location. The Content Log History screen is acceptable when the file cannot be
collected, but the report must say so.

## Execute the matrix

Run scenarios in the order shown in `matrix.json`. Reset to a fresh copy of the
world between scenarios unless a scenario explicitly says to continue after a
reload, reconnect, or restart. Use the listed `/scriptevent` commands for
deterministic hooks already exposed by the pack:

```text
/scriptevent tbs:help
/scriptevent tbs:events
/scriptevent tbs:arena start
/scriptevent tbs:arena stop
/scriptevent tbs:dim clan_void
/scriptevent tbs:dim overworld
/scriptevent tbs:adv can_you_see_me
```

For boss checks, use only disposable worlds and the identifiers in the matrix.
Record the exact tick, player names, dimension IDs, entity IDs when available,
and whether the event was a first run, reload, reconnect, abort, or replay.
The story scenario is intentionally a long-running threshold test: its report
must include the observed story-clock tick for every threshold rather than
using wall-clock time as a proxy.

## Record and gate the result

Copy [`report.template.json`](report.template.json) to
`latest-report.json`, replace its placeholders with the real engine run's
evidence, candidate commit, and packaged artifact digest, and validate it
locally from the same checkout:

```bash
python tools/validate_runtime_smoke_matrix.py tests/runtime-smoke/matrix.json
bash tools/package-addon.sh
CANDIDATE_COMMIT="$(git rev-parse --verify HEAD^{commit})"
ARTIFACT_SHA256="$(sha256sum dist/The_Broken_Script_2_0.mcaddon | awk '{print $1}')"
python tools/validate_runtime_smoke_report.py \
  tests/runtime-smoke/latest-report.json \
  --matrix tests/runtime-smoke/matrix.json \
  --artifact dist/The_Broken_Script_2_0.mcaddon \
  --expected-commit "$CANDIDATE_COMMIT" \
  --expected-artifact-sha256 "$ARTIFACT_SHA256" \
  --require-complete
```

Every scenario needs a result and evidence reference. Every runtime error or
warning needs a diagnostic entry. Mark a diagnostic `parity_critical: true`
when it affects pack initialization, state, targeting/ownership, dimensions,
boss cleanup, story progression, suppression, or another matrix pass criterion.
A parity-critical error or warning fails the report validator. Informational
messages may be retained without blocking the report.

Do not commit `latest-report.json` until it represents a real engine run. The
report's `candidate_commit` must be the exact full 40-hex Git SHA for the
checkout used to build and test the world. Its `artifact_sha256` must be the
exact full 64-hex SHA-256 of the `.mcaddon` named by `artifact_path`.
Pull-request CI validates any committed report against the checked-out commit
and freshly packaged artifact; this rejects reports or artifacts copied from a
different revision. The workflow requires a complete passing report when
`enforce_runtime_smoke` is selected manually or when a version tag is built;
the existing static gates remain active as well.

The template is intentionally `not-run` and contains placeholders. It is not
runtime evidence: do not replace it with invented or synthetic Bedrock output.

## Evidence sources

- [API contract](../../TheBrokenScript_Bedrock_2_0/API_AUDIT.md)
- [Microsoft: Script Module Versioning](https://learn.microsoft.com/minecraft/creator/documents/scripting/versioning?view=minecraft-bedrock-stable)
- [Microsoft: Debugging Scripts in Minecraft](https://learn.microsoft.com/minecraft/creator/documents/scripting/debugging-scripts?view=minecraft-bedrock-stable)
- [Microsoft: Content Error Log](https://learn.microsoft.com/minecraft/creator/documents/contenterrorlog?view=minecraft-bedrock-stable)
- [Bedrock Wiki: Script events and dynamic properties](https://github.com/Bedrock-OSS/bedrock-wiki/blob/wiki/docs/scripting/script-server.md)
