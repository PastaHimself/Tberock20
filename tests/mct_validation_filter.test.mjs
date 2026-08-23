import assert from 'node:assert/strict';
import test from 'node:test';

import {
  classifyMctFindings,
  validateMctReport,
} from '../tools/filter_mct_validation.mjs';


function reportWith(...items) {
  return { projects: [{ name: 'fixture', items }] };
}


const officialClientBiomeError = {
  type: 'error',
  generatorId: 'UNKJSON',
  message: 'Unknown JSON file found',
  path: '/resource_packs/rp/biomes_client/void.biome_client.json',
};

const unknownJsonFailure = {
  type: 'testFail',
  generatorId: 'UNKJSON',
  message: 'Found 1 errors in Unknown JSON check',
};


test('ignores only the MCT false positive for official client biome files', () => {
  const result = classifyMctFindings(reportWith(unknownJsonFailure, officialClientBiomeError));
  assert.deepEqual(result.blockers, []);
  assert.equal(result.ignored.length, 2);
});


test('keeps unknown JSON findings outside the official client biome directory', () => {
  const otherError = {
    ...officialClientBiomeError,
    path: '/resource_packs/rp/entity/unknown.json',
  };
  const result = classifyMctFindings(reportWith(unknownJsonFailure, otherError));
  assert.equal(result.blockers.length, 2);
  assert.deepEqual(result.ignored, []);
});


test('keeps the aggregate UNKJSON failure when any unknown file is not a client biome', () => {
  const otherError = {
    ...officialClientBiomeError,
    path: '/behavior_packs/bp/unknown.json',
  };
  const result = classifyMctFindings(
    reportWith(unknownJsonFailure, officialClientBiomeError, otherError),
  );
  assert.deepEqual(result.blockers, [unknownJsonFailure, otherError]);
  assert.deepEqual(result.ignored, [officialClientBiomeError]);
});


test('does not suppress unrelated UNKJSON test failures', () => {
  const unrelatedFailure = {
    type: 'testFail',
    generatorId: 'UNKJSON',
    message: 'Unknown JSON validator crashed',
  };
  const result = classifyMctFindings(reportWith(unrelatedFailure, officialClientBiomeError));
  assert.deepEqual(result.blockers, [unrelatedFailure]);
  assert.deepEqual(result.ignored, [officialClientBiomeError]);
});


test('preserves the existing exact script-module self-comparison suppression', () => {
  const scriptError = {
    type: 'error',
    generatorId: 'SCRIPT',
    message: '@minecraft/server 2.7.0-beta.1.26.10-stable is using an out of date beta version; current version is 2.7.0-beta.1.26.10-stable',
  };
  const scriptFailure = {
    type: 'testFail',
    generatorId: 'SCRIPT',
    message: 'Script Modules check failed',
  };
  const result = classifyMctFindings(reportWith(scriptError, scriptFailure));
  assert.deepEqual(result.blockers, []);
  assert.equal(result.ignored.length, 2);
});


test('accepts the exact aggregate test-failure status when every blocker is recognized', () => {
  assert.doesNotThrow(() => validateMctReport(
    reportWith(unknownJsonFailure, officialClientBiomeError),
    4,
  ));
});


test('accepts error status 3 for a recognized error without an aggregate failure', () => {
  assert.doesNotThrow(() => validateMctReport(
    reportWith(officialClientBiomeError),
    3,
  ));
});


test('does not mask Mojang Creator Tools internal-processing failures', () => {
  assert.throws(
    () => validateMctReport(
      reportWith(unknownJsonFailure, officialClientBiomeError),
      5,
    ),
    /exited unexpectedly \(exit 5; expected 4\)/,
  );
});


test('rejects initialization status 1 when the report has no blockers', () => {
  assert.throws(
    () => validateMctReport(reportWith(), 1),
    /exit 1; expected 0/,
  );
});
