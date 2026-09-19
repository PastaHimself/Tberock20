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


test('strict validation rejects recognized false-positive blockers', () => {
  assert.throws(
    () => validateMctReport(
      reportWith(unknownJsonFailure, officialClientBiomeError),
      4,
    ),
    /strict validation failed: 0 blocker\(s\), 0 warning\(s\), 2 ignored\/known-tool blocker\(s\)/,
  );
});


test('strict validation rejects mixed recognized current-layout findings', () => {
  const unknownAggregate = {
    ...unknownJsonFailure,
    message: 'Found 2 errors in Unknown JSON check',
  };
  assert.throws(
    () => validateMctReport(
      reportWith(
        unknownAggregate,
        officialClientBiomeError,
        officialJigsawStructureError,
        projectIntegrityFailure,
        officialJavaStructureNbtError,
      ),
      4,
    ),
    /strict validation failed: 0 blocker\(s\), 0 warning\(s\), 5 ignored\/known-tool blocker\(s\)/,
  );
});


test('strict validation rejects a recognized error even without an aggregate failure', () => {
  assert.throws(
    () => validateMctReport(
      reportWith(officialClientBiomeError),
      3,
    ),
    /strict validation failed: 0 blocker\(s\), 0 warning\(s\), 1 ignored\/known-tool blocker\(s\)/,
  );
});


test('strict validation rejects warnings', () => {
  assert.throws(
    () => validateMctReport(reportWith({
      type: 'warning',
      generatorId: 'JSONF',
      message: 'Schema warning',
      path: '/behavior_packs/bp/entities/example.json',
    }), 0),
    /strict validation failed: 0 blocker\(s\), 1 warning\(s\), 0 ignored\/known-tool blocker\(s\)/,
  );
});


test('strict validation rejects real blockers', () => {
  assert.throws(
    () => validateMctReport(reportWith({
      type: 'error',
      generatorId: 'JSON',
      message: 'Invalid pack data',
      path: '/behavior_packs/bp/entities/example.json',
    }), 3),
    /strict validation failed: 1 blocker\(s\), 0 warning\(s\), 0 ignored\/known-tool blocker\(s\)/,
  );
});


test('accepts only a zero-finding report with zero exit status', () => {
  assert.doesNotThrow(() => validateMctReport(reportWith(), 0));
});


test('rejects nonzero MCT status even when the report contains zero findings', () => {
  assert.throws(
    () => validateMctReport(reportWith(), 5),
    /exited unexpectedly with status 5 despite reporting zero findings/,
  );
});


test('rejects initialization status 1 when the report has zero findings', () => {
  assert.throws(
    () => validateMctReport(reportWith(), 1),
    /exited unexpectedly with status 1 despite reporting zero findings/,
  );
});

test('ignores the MCT self-comparison for a bare beta version', () => {
  const result = classifyMctFindings({
    projects: [{
      name: 'fixture',
      items: [{
        type: 'error',
        generatorId: 'SCRIPTMODULE',
        message: 'For @minecraft/server, using an out of date beta version 2.11.0-beta compared to the current version: 2.11.0-beta',
        path: '/behavior_packs/bp/manifest.json',
      }],
    }],
  });
  assert.deepEqual(result.blockers, []);
  assert.equal(result.ignored.length, 1);
});
