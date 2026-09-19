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

const compatibilityEvidence = {
  customBlockIdentifiers: new Set(['thebrokenscript:all_dead']),
  uiTextureIdentifiers: new Set(['textures/ui/vhs/color_wash']),
  subpacksValid: true,
  lightingKeyframesValid: true,
};

const officialSubpackWarning = {
  type: 'warning',
  generatorId: 'JSON',
  message: 'Structure issue',
  data: 'In "subpacks[0]": {"folder_name":"clean_tape","n... - object value found, but a string is required',
  path: '/resource_packs/rp/manifest.json',
};

const officialTruncatedSubpackWarning = {
  ...officialSubpackWarning,
  data: 'In "subpacks[2]": {"folder_name":"severe_trackin... - object value found, but a string is required',
};

const officialLightingWarning = {
  type: 'warning',
  generatorId: 'JSONF',
  message: 'At minecraft:lighting_settings.ambient.color, data does not match any one of the expected types: Data is an object',
  path: '/resource_packs/rp/lighting/global.json',
};

const officialCustomBlockItemWarning = {
  type: 'warning',
  generatorId: 'UNLINK',
  message: 'Link to item type is not found in this pack',
  data: '/behavior_packs/bp/loot_tables/blocks/all_dead.json to `thebrokenscript:all_dead`',
  path: '/behavior_packs/bp/loot_tables/blocks/all_dead.json',
};

const officialVanillaRecipeItemWarning = {
  type: 'warning',
  generatorId: 'UNLINK',
  message: 'Link to item type is not found in this pack',
  data: '/behavior_packs/bp/recipes/notch_apple.json to `minecraft:gold_block`',
  path: '/behavior_packs/bp/recipes/notch_apple.json',
};

const officialCustomUiTextureWarning = {
  type: 'warning',
  generatorId: 'UNLINK',
  message: 'Link to texture is not found in this pack',
  data: '/resource_packs/rp/ui/vhs_overlay.json to `textures/ui/vhs/color_wash`',
  path: '/resource_packs/rp/ui/vhs_overlay.json',
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


test('classifies only evidence-backed current-schema compatibility findings', () => {
  const result = classifyMctFindings(
    reportWith(
      officialTruncatedSubpackWarning,
      officialLightingWarning,
      officialCustomBlockItemWarning,
      officialVanillaRecipeItemWarning,
      officialCustomUiTextureWarning,
    ),
    compatibilityEvidence,
  );

  assert.deepEqual(result.blockers, []);
  assert.deepEqual(result.warnings, []);
  assert.equal(result.compatibility.length, 5);
});


test('keeps compatibility-shaped findings when their evidence does not match', () => {
  const wrongEvidence = {
    ...compatibilityEvidence,
    customBlockIdentifiers: new Set(['thebrokenscript:not_a_block']),
    uiTextureIdentifiers: new Set(['textures/ui/vhs/not_present']),
    subpacksValid: false,
    lightingKeyframesValid: false,
  };
  const result = classifyMctFindings(
    reportWith(
      officialSubpackWarning,
      officialLightingWarning,
      officialCustomBlockItemWarning,
      officialCustomUiTextureWarning,
    ),
    wrongEvidence,
  );

  assert.deepEqual(result.compatibility, []);
  assert.equal(result.warnings.length, 4);
});


test('does not classify an item link for a custom item as an auto-created block item', () => {
  const result = classifyMctFindings(
    reportWith({
      ...officialCustomBlockItemWarning,
      data: '/behavior_packs/bp/loot_tables/blocks/all_dead.json to `thebrokenscript:custom_item`',
    }),
    compatibilityEvidence,
  );

  assert.deepEqual(result.compatibility, []);
  assert.equal(result.warnings.length, 1);
});


test('strict validation accepts documented current-layout compatibility findings', () => {
  assert.doesNotThrow(() => validateMctReport(
    reportWith(unknownJsonFailure, officialClientBiomeError),
    0,
  ));
});


test('strict validation accepts mixed recognized current-layout findings', () => {
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
    0,
  ));
});


test('strict validation accepts a recognized error without an aggregate failure', () => {
  assert.doesNotThrow(() => validateMctReport(reportWith(officialClientBiomeError), 0));
});


test('strict validation rejects warnings', () => {
  assert.throws(
    () => validateMctReport(reportWith({
      type: 'warning',
      generatorId: 'JSONF',
      message: 'Schema warning',
      path: '/behavior_packs/bp/entities/example.json',
    }), 0),
    /strict validation failed: 0 blocker\(s\), 1 warning\(s\), 0 compatibility diagnostic\(s\)/,
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
    /strict validation failed: 1 blocker\(s\), 0 warning\(s\), 0 compatibility diagnostic\(s\)/,
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
