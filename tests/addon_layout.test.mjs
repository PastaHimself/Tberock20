import assert from 'node:assert/strict';
import { readFile } from 'node:fs/promises';
import path from 'node:path';
import test from 'node:test';

const addonRoot = path.resolve('TheBrokenScript_Bedrock_2_0');
const bpRoot = path.join(addonRoot, 'BP');
const rpRoot = path.join(addonRoot, 'RP');

async function readJson(file) {
  return JSON.parse(await readFile(file, 'utf8'));
}

test('behavior and resource pack manifests exist and parse', async () => {
  const [bp, rp] = await Promise.all([
    readJson(path.join(bpRoot, 'manifest.json')),
    readJson(path.join(rpRoot, 'manifest.json')),
  ]);
  assert.equal(bp.format_version, 2);
  assert.equal(rp.format_version, 2);
});

test('behavior pack script entry resolves to a real file', async () => {
  const bp = await readJson(path.join(bpRoot, 'manifest.json'));
  const script = bp.modules?.find((module) => module?.type === 'script');
  assert.ok(script?.entry, 'behavior pack must define a script entry');
  const source = await readFile(path.join(bpRoot, script.entry), 'utf8');
  assert.ok(source.length > 0, 'script entry must not be empty');
});

test('behavior pack resource dependency matches the resource pack header', async () => {
  const [bp, rp] = await Promise.all([
    readJson(path.join(bpRoot, 'manifest.json')),
    readJson(path.join(rpRoot, 'manifest.json')),
  ]);
  const dependency = bp.dependencies?.find((entry) => entry?.uuid === rp.header?.uuid);
  assert.ok(dependency, 'behavior pack must depend on the resource pack header UUID');
  assert.deepEqual(dependency.version, rp.header.version);
});
