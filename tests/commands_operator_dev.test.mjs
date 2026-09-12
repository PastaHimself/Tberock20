import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";

const read = (path) => readFile(new URL(`../${path}`, import.meta.url), "utf8");

test("Java command root requires permission level 4 and dev additionally requires cheats", async () => {
  const root = await read("decompiled/net/thebrokenscript/command/TBSCommands.java");
  const dev = await read("decompiled/net/thebrokenscript/command/dev/DevCommands.java");
  assert.match(root, /group\("tbs", Integer\.valueOf\(4\)/);
  assert.match(root, /DevModeCommand\.INSTANCE\.addDevMode/);
  assert.match(root, /ReputationCommand\.INSTANCE\.addReputation/);
  assert.match(root, /DevCommands\.INSTANCE\.addDevCommands/);
  assert.match(dev, /group\("dev"/);
  assert.match(dev, /getEnableCheats\(\)/);
  assert.match(dev, /"Cheats are not enabled!"/);
});

test("Bedrock production reputation command preserves source gate and player requirement", async () => {
  const commands = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js");
  const main = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/main.js");
  assert.match(commands, /name: "tbs:reputation"/);
  assert.match(commands, /permissionLevel: CommandPermissionLevel\.Admin/);
  assert.match(commands, /cheatsRequired: false/);
  assert.match(commands, /"This command must be executed by a player!"/);
  assert.match(commands, /playerState\.get\(player, "entityReputation"\)/);
  assert.match(commands, /Reputation value:/);
  assert.match(commands, /Reputation: \$\{text\}/);
  assert.match(main, /commands\.register\(event\.customCommandRegistry\)/);
});

test("Bedrock-only scriptevent hooks remain explicitly dev/regression-only", async () => {
  const commands = await read("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/commands.js");
  assert.match(commands, /Bedrock-only developer\/regression hooks/);
  assert.match(commands, /system\.afterEvents\.scriptEventReceive\.subscribe/);
  assert.doesNotMatch(commands, /name: "tbs:(fire|arena|shaft|dim|adv|effect)"/);
});
