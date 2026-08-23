import assert from "node:assert/strict";
import { readdir, readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath, pathToFileURL } from "node:url";

const ROOT = fileURLToPath(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/", import.meta.url));

async function javascriptFiles(directory) {
  const files = [];
  for (const entry of await readdir(directory, { withFileTypes: true })) {
    const absolute = path.join(directory, entry.name);
    if (entry.isDirectory()) files.push(...(await javascriptFiles(absolute)));
    else if (entry.isFile() && entry.name.endsWith(".js")) files.push(absolute);
  }
  return files.sort();
}

test("runtime scripts avoid APIs removed from the current beta module", async () => {
  const forbidden = [
    ["runCommandAsync", /\.runCommandAsync\(/g],
    ["World.getTime", /\bworld\.getTime(?:\?\.)?\(/g],
    ["Entity.isValid()", /\.isValid\(\)/g],
    ["raw entityAttack cause", /cause:\s*["']entityAttack["']/g],
    ["raw GameMode value", /\bgm\s*[!=]==?\s*(?:["'](?:creative|spectator)["']|[13])\b/g],
    ["legacy four-argument applyKnockback", /\.applyKnockback\(\s*[^,\n]+,\s*[^,\n]+,\s*[^,\n]+,\s*[^)\n]+\)/g],
  ];
  const violations = [];

  for (const file of await javascriptFiles(ROOT)) {
    const source = await readFile(file, "utf8");
    for (const [label, pattern] of forbidden) {
      if (pattern.test(source)) violations.push(`${path.relative(ROOT, file)}: ${label}`);
      pattern.lastIndex = 0;
    }

    const titleCall = /\.setTitle\([^\n]*,\s*\{([^}\n]*)\}\)/g;
    for (const match of source.matchAll(titleCall)) {
      const options = match[1];
      const hasAllDurations = ["fadeInDuration", "stayDuration", "fadeOutDuration"]
        .every((field) => options.includes(field));
      if (!hasAllDurations) {
        violations.push(`${path.relative(ROOT, file)}: incomplete TitleDisplayOptions`);
      }
    }
  }

  assert.deepEqual(violations, []);
});

test("config module keeps its object facade for existing consumers", async () => {
  const configPath = pathToFileURL(path.join(ROOT, "core/config.js"));
  const configModule = await import(configPath.href);

  assert.deepEqual(Object.keys(configModule.config).sort(), ["all", "get", "registerDefaults"]);
  assert.equal(configModule.config.get, configModule.get);
  assert.equal(configModule.config.all, configModule.all);
  assert.equal(configModule.config.registerDefaults, configModule.registerDefaults);
});
