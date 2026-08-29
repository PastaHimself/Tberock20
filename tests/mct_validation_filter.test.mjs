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

const officialJigsawStructureError = {
  type: 'error',
  generatorId: 'UNKJSON',
  message: 'Unknown JSON file found',
  path: '/behavior_packs/bp/worldgen/structures/shaft.json',
};

const officialJavaStructureNbtError = {
  type: 'error',
  generatorId: 'PRJINT',
  message: 'Project contains extraneous file or folder',
  data: '/home/runner/work/repo/repo/.ci/mct/behavior_packs/bp/structures/thebrokenscript/shaft/shaft_hall.nbt',
};

const unknownJsonFailure = {
  type: 'testFail',
  generatorId: 'UNKJSON',
  message: 'Found 1 errors in Unknown JSON check',
};

const projectIntegrityFailure = {
  type: 'testFail',
  generatorId: 'PRJINT',
  message: 'Found 1 errors in Project Integrity check',
};


test('ignores only the MCT false positive for official client biome files', () => {
  const result = classifyMctFindings(reportWith(unknownJsonFailure, officialClientBiomeError));
  assert.deepEqual(result.blockers, []);
  assert.equal(result.ignored.length, 2);
});


test('ignores the MCT false positive for current Jigsaw structure JSON files', () => {
  const result = classifyMctFindings(reportWith(unknownJsonFailure, officialJigsawStructureError));
  assert.deepEqual(result.blockers, []);
  assert.equal(result.ignored.length, 2);
});


test('ignores the MCT project-integrity false positive for Java NBT structure templates', () => {
  const result = classifyMctFindings(reportWith(projectIntegrityFailure, officialJavaStructureNbtError));
  assert.deepEqual(result.blockers, []);
  assert.equal(result.ignored.length, 2);
});


test('keeps project-integrity findings outside behavior-pack structures', () => {
  const otherError = {
    ...officialJavaStructureNbtError,
    data: '/home/runner/work/repo/repo/.ci/mct/behavior_packs/bp/scripts/unknown.nbt',
  };
  const result = classifyMctFindings(reportWith(projectIntegrityFailure, otherError));
  assert.deepEqual(result.blockers, [projectIntegrityFailure, otherError]);
  assert.deepEqual(result.ignored, []);
});


test('keeps unknown JSON findings outside recognized current Bedrock locations', () => {
  const otherError = {
    ...officialClientBiomeError,
    path: '/resource_packs/rp/entity/unknown.json',
  };
  const result = classifyMctFindings(reportWith(unknownJsonFailure, otherError));
  assert.equal(result.blockers.length, 2);
  assert.deepEqual(result.ignored, []);
});


test('keeps the aggregate UNKJSON failure when any unknown file is not recognized', () => {
  const otherError = {
    ...officialClientBiomeError,
    path: '/behavior_packs/bp/unknown.json',
  };
  const aggregate = {
    ...unknownJsonFailure,
    message: 'Found 3 errors in Unknown JSON check',
  };
  const result = classifyMctFindings(
    reportWith(aggregate, officialClientBiomeError, officialJigsawStructureError, otherError),
  );
  assert.deepEqual(result.blockers, [aggregate, otherError]);
  assert.deepEqual(result.ignored, [officialClientBiomeError, officialJigsawStructureError]);
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


test('accepts mixed recognized current-layout findings at aggregate failure status', () => {
  const unknownAggregate = {
    ...unknownJsonFailure,
    message: 'Found 2 errors in Unknown JSON check',
  };
  assert.doesNotThrow(() => validateMctReport(
    reportWith(
      unknownAggregate,
      officialClientBiomeError,
      officialJigsawStructureError,
      projectIntegrityFailure,
      officialJavaStructureNbtError,
    ),
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
