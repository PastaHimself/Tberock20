#!/usr/bin/env node

import {
  appendFileSync,
  readFileSync,
  readdirSync,
} from 'node:fs';
import path from 'node:path';
import { fileURLToPath } from 'node:url';


const BLOCKING_TYPES = new Set(['error', 'testFail', 'internalProcessingError']);
// Mojang Creator Tools v0.17.7 ErrorCodes: error=3, testFail=4,
// internalProcessingError=5. Higher-severity findings determine the exit code.
const MCT_EXIT_CODES = new Map([
  ['error', 3],
  ['testFail', 4],
  ['internalProcessingError', 5],
]);
// MCT 0.17.7 does not yet recognize some current Bedrock content locations/formats.
// These predicates are deliberately narrow.  A finding is accepted only when its
// exact MCT shape and the repository's current source evidence match; raw findings
// remain in the Actions log, annotations, and step summary.
const CLIENT_BIOME_PATH = /^\/resource_packs\/rp\/biomes_client\/[a-z0-9._-]+\.biome_client\.json$/;
const JIGSAW_STRUCTURE_JSON_PATH = /^\/behavior_packs\/bp\/worldgen\/structures\/[a-z0-9._/-]+\.json$/;
const JAVA_STRUCTURE_NBT_PATH = /\/behavior_packs\/bp\/structures\/[a-z0-9._/-]+\.nbt$/;
const SUBPACK_MANIFEST_PATH = '/resource_packs/rp/manifest.json';
const LIGHTING_SETTINGS_PATH = '/resource_packs/rp/lighting/global.json';
const CUSTOM_UI_OVERLAY_PATH = '/resource_packs/rp/ui/vhs_overlay.json';
const ITEM_LINK_WARNING = 'Link to item type is not found in this pack';
const TEXTURE_LINK_WARNING = 'Link to texture is not found in this pack';


function serializedFinding(item) {
  return JSON.stringify(item);
}


function isSelfComparisonScriptModuleError(item) {
  if (item.type !== 'error') return false;
  const text = serializedFinding(item);
  if (!text.includes('@minecraft/server') || !text.includes('using an out of date beta version')) {
    return false;
  }
  const versions = [...text.matchAll(/\d+\.\d+\.\d+-beta(?:\.[0-9A-Za-z.-]+)?/g)]
    .map((match) => match[0]);
  return versions.length >= 2 && versions.at(-2) === versions.at(-1);
}


function isOfficialClientBiomeUnknownJsonError(item) {
  return item.type === 'error'
    && item.generatorId === 'UNKJSON'
    && item.message === 'Unknown JSON file found'
    && typeof item.path === 'string'
    && CLIENT_BIOME_PATH.test(item.path);
}


function isOfficialJigsawStructureUnknownJsonError(item) {
  return item.type === 'error'
    && item.generatorId === 'UNKJSON'
    && item.message === 'Unknown JSON file found'
    && typeof item.path === 'string'
    && JIGSAW_STRUCTURE_JSON_PATH.test(item.path);
}


function isOfficialJavaStructureNbtIntegrityError(item) {
  return item.type === 'error'
    && item.generatorId === 'PRJINT'
    && item.message === 'Project contains extraneous file or folder'
    && typeof item.data === 'string'
    && JAVA_STRUCTURE_NBT_PATH.test(item.data);
}


function linkedIdentifier(item) {
  if (typeof item.data !== 'string') return null;
  return item.data.match(/ to `([^`]+)`/)?.[1] ?? null;
}


function isOfficialSubpackObjectWarning(item, evidence) {
  return item.type === 'warning'
    && item.generatorId === 'JSON'
    && item.message === 'Structure issue'
    && item.path === SUBPACK_MANIFEST_PATH
    && evidence.subpacksValid === true
    && typeof item.data === 'string'
    // MCT truncates long object previews with an ellipsis before the closing
    // quote, so accept either the complete value or that exact truncation.
    && /^In "subpacks\[\d+\]": \{"folder_name":"[A-Za-z0-9_.-]+(?:"|\.\.\.)/.test(item.data)
    && item.data.includes('object value found, but a string is required');
}


function isOfficialLightingKeyframeWarning(item, evidence) {
  const supportedPaths = new Set([
    'At minecraft:lighting_settings.ambient.color,',
    'At minecraft:lighting_settings.ambient.illuminance,',
    'At minecraft:lighting_settings.sky.intensity,',
  ]);
  const prefix = typeof item.message === 'string'
    ? item.message.split(' data', 1)[0]
    : '';
  return item.type === 'warning'
    && item.generatorId === 'JSONF'
    && item.path === LIGHTING_SETTINGS_PATH
    && evidence.lightingKeyframesValid === true
    && supportedPaths.has(prefix)
    && typeof item.message === 'string'
    && item.message.includes('object');
}


function isOfficialAutoCreatedBlockItemWarning(item, evidence) {
  if (item.type !== 'warning'
      || item.generatorId !== 'UNLINK'
      || item.message !== ITEM_LINK_WARNING
      || typeof item.path !== 'string'
      || !/^\/behavior_packs\/bp\/(?:loot_tables\/blocks|recipes)\/[a-z0-9._/-]+\.json$/.test(item.path)) {
    return false;
  }
  const identifier = linkedIdentifier(item);
  return typeof identifier === 'string'
    && identifier.startsWith('thebrokenscript:')
    && evidence.customBlockIdentifiers instanceof Set
    && evidence.customBlockIdentifiers.has(identifier);
}


function isOfficialVanillaRecipeItemWarning(item) {
  return item.type === 'warning'
    && item.generatorId === 'UNLINK'
    && item.message === ITEM_LINK_WARNING
    && typeof item.path === 'string'
    && /^\/behavior_packs\/bp\/recipes\/[a-z0-9._/-]+\.json$/.test(item.path)
    && typeof linkedIdentifier(item) === 'string'
    && linkedIdentifier(item).startsWith('minecraft:');
}


function isOfficialExistingUiTextureWarning(item, evidence) {
  if (item.type !== 'warning'
      || item.generatorId !== 'UNLINK'
      || item.message !== TEXTURE_LINK_WARNING
      || item.path !== CUSTOM_UI_OVERLAY_PATH) {
    return false;
  }
  const identifier = linkedIdentifier(item);
  return typeof identifier === 'string'
    && evidence.uiTextureIdentifiers instanceof Set
    && evidence.uiTextureIdentifiers.has(identifier);
}


function readJsonIfPresent(filePath) {
  try {
    return JSON.parse(readFileSync(filePath, 'utf8'));
  } catch {
    return null;
  }
}


function isKeyframeObject(value) {
  return value !== null
    && typeof value === 'object'
    && !Array.isArray(value)
    && Object.keys(value).length > 0
    && Object.keys(value).every((key) => /^\d+(?:\.\d+)?$/.test(key));
}


export function loadMctCompatibilityEvidence(repositoryRoot = process.cwd()) {
  const addonRoot = path.resolve(repositoryRoot, 'TheBrokenScript_Bedrock_2_0');
  const customBlockIdentifiers = new Set();
  const blocksRoot = path.join(addonRoot, 'BP', 'blocks');
  try {
    for (const entry of readdirSync(blocksRoot, { withFileTypes: true })) {
      if (!entry.isFile() || !entry.name.endsWith('.json')) continue;
      const payload = readJsonIfPresent(path.join(blocksRoot, entry.name));
      const block = payload?.['minecraft:block'];
      const identifier = block?.description?.identifier;
      if (typeof identifier === 'string'
          && block.description.menu_category
          && identifier.startsWith('thebrokenscript:')) {
        customBlockIdentifiers.add(identifier);
      }
    }
  } catch {
    // Missing evidence intentionally leaves this compatibility category strict.
  }

  const uiTextureIdentifiers = new Set();
  const uiTexturesRoot = path.join(addonRoot, 'RP', 'textures', 'ui', 'vhs');
  try {
    for (const entry of readdirSync(uiTexturesRoot, { withFileTypes: true })) {
      if (!entry.isFile() || !entry.name.endsWith('.png')) continue;
      uiTextureIdentifiers.add(`textures/ui/vhs/${entry.name.slice(0, -4)}`);
    }
  } catch {
    // Missing evidence intentionally leaves this compatibility category strict.
  }

  const manifest = readJsonIfPresent(path.join(addonRoot, 'RP', 'manifest.json'));
  const subpacksValid = Array.isArray(manifest?.subpacks)
    && manifest.subpacks.length > 0
    && manifest.subpacks.every((subpack) => (
      subpack !== null
      && typeof subpack === 'object'
      && typeof subpack.folder_name === 'string'
      && typeof subpack.name === 'string'
      && Number.isInteger(subpack.memory_tier)
    ));

  const lighting = readJsonIfPresent(path.join(addonRoot, 'RP', 'lighting', 'global.json'));
  const lightingSettings = lighting?.['minecraft:lighting_settings'];
  const lightingKeyframesValid = lighting?.format_version === '1.26.0'
    && isKeyframeObject(lightingSettings?.ambient?.color)
    && isKeyframeObject(lightingSettings?.ambient?.illuminance)
    && isKeyframeObject(lightingSettings?.sky?.intensity);

  return {
    customBlockIdentifiers,
    uiTextureIdentifiers,
    subpacksValid,
    lightingKeyframesValid,
  };
}


function isMatchingUnknownJsonAggregateFailure(item, errorCount) {
  return item.type === 'testFail'
    && item.generatorId === 'UNKJSON'
    && item.message === `Found ${errorCount} errors in Unknown JSON check`;
}


function isMatchingProjectIntegrityAggregateFailure(item, errorCount) {
  return item.type === 'testFail'
    && item.generatorId === 'PRJINT'
    && item.message === `Found ${errorCount} errors in Project Integrity check`;
}


export function classifyMctFindings(report, options = {}) {
  if (!Array.isArray(report.projects) || report.projects.length === 0) {
    throw new Error('Mojang Creator Tools did not discover any Minecraft projects.');
  }

  const evidence = options.compatibilityEvidence ?? options;
  const items = report.projects.flatMap((project) => project.items ?? []);
  const rawBlockers = items.filter((item) => BLOCKING_TYPES.has(item.type));
  const rawWarnings = items.filter((item) => item.type === 'warning');

  const scriptModuleErrors = rawBlockers.filter(
    (item) => item.type === 'error'
      && serializedFinding(item).includes('using an out of date beta version'),
  );
  const onlySelfComparisonScriptErrors = scriptModuleErrors.length > 0
    && scriptModuleErrors.every(isSelfComparisonScriptModuleError);

  const unknownJsonErrors = rawBlockers.filter(
    (item) => item.type === 'error' && item.generatorId === 'UNKJSON',
  );
  const onlyRecognizedOfficialUnknownJsonErrors = unknownJsonErrors.length > 0
    && unknownJsonErrors.every(
      (item) => isOfficialClientBiomeUnknownJsonError(item)
        || isOfficialJigsawStructureUnknownJsonError(item),
    );

  const projectIntegrityErrors = rawBlockers.filter(
    (item) => item.type === 'error' && item.generatorId === 'PRJINT',
  );
  const onlyOfficialJavaStructureNbtIntegrityErrors = projectIntegrityErrors.length > 0
    && projectIntegrityErrors.every(isOfficialJavaStructureNbtIntegrityError);

  const blockers = [];
  const compatibility = [];
  for (const item of rawBlockers) {
    const text = serializedFinding(item);
    const isCompatibility = isSelfComparisonScriptModuleError(item)
      || isOfficialClientBiomeUnknownJsonError(item)
      || isOfficialJigsawStructureUnknownJsonError(item)
      || isOfficialJavaStructureNbtIntegrityError(item)
      || (
        item.type === 'testFail'
        && text.includes('Script Modules check')
        && onlySelfComparisonScriptErrors
      )
      || (
        isMatchingUnknownJsonAggregateFailure(item, unknownJsonErrors.length)
        && onlyRecognizedOfficialUnknownJsonErrors
      )
      || (
        isMatchingProjectIntegrityAggregateFailure(item, projectIntegrityErrors.length)
        && onlyOfficialJavaStructureNbtIntegrityErrors
      );
    (isCompatibility ? compatibility : blockers).push(item);
  }

  const warnings = [];
  for (const item of rawWarnings) {
    const isCompatibility = isOfficialSubpackObjectWarning(item, evidence)
      || isOfficialLightingKeyframeWarning(item, evidence)
      || isOfficialAutoCreatedBlockItemWarning(item, evidence)
      || isOfficialVanillaRecipeItemWarning(item)
      || isOfficialExistingUiTextureWarning(item, evidence);
    (isCompatibility ? compatibility : warnings).push(item);
  }

  return {
    blockers,
    warnings,
    compatibility,
    // Keep the old field as a read-only compatibility alias for callers that
    // consume the previous report shape.  It is not counted as a CI failure.
    ignored: compatibility,
    projectCount: report.projects.length,
    rawBlockerCount: rawBlockers.length,
    rawWarningCount: rawWarnings.length,
    rawFindingCount: rawBlockers.length + rawWarnings.length,
  };
}


function findingText(item) {
  const itemPath = item.path ? ` (${item.path})` : '';
  const data = item.data === undefined
    ? ''
    : `: ${typeof item.data === 'string' ? item.data : JSON.stringify(item.data)}`;
  return `[${item.type}] ${item.generatorId ?? 'validation'}: ${item.message}${data}${itemPath}`;
}


function printFinding(item, method = 'error') {
  console[method](findingText(item));
}


function githubEscape(value) {
  return String(value).replaceAll('%', '%25').replaceAll('\r', '%0D').replaceAll('\n', '%0A');
}


function githubPropertyEscape(value) {
  return githubEscape(value).replaceAll(':', '%3A').replaceAll(',', '%2C');
}


function githubFileForFinding(item) {
  const candidates = [item.path, typeof item.data === 'string' ? item.data : null]
    .filter((value) => typeof value === 'string' && value.length > 0)
    .map((value) => value.replaceAll('\\', '/'));

  for (const candidate of candidates) {
    const behaviorMarker = '/behavior_packs/bp/';
    const behaviorIndex = candidate.indexOf(behaviorMarker);
    if (behaviorIndex !== -1) {
      return `TheBrokenScript_Bedrock_2_0/BP/${candidate.slice(behaviorIndex + behaviorMarker.length)}`;
    }

    const resourceMarker = '/resource_packs/rp/';
    const resourceIndex = candidate.indexOf(resourceMarker);
    if (resourceIndex !== -1) {
      return `TheBrokenScript_Bedrock_2_0/RP/${candidate.slice(resourceIndex + resourceMarker.length)}`;
    }
  }

  return null;
}


function emitGithubAnnotation(item, level, title, prefix = '') {
  if (!process.env.GITHUB_ACTIONS) return;
  const file = githubFileForFinding(item);
  const properties = [
    `title=${githubPropertyEscape(title)}`,
    ...(file ? [`file=${githubPropertyEscape(file)}`] : []),
  ].join(',');
  const message = `${prefix}${findingText(item)}`;
  console.log(`::${level} ${properties}::${githubEscape(message)}`);
}


function markdownEscape(value) {
  return String(value)
    .replaceAll('|', '\\|')
    .replaceAll('\r', ' ')
    .replaceAll('\n', '<br>');
}


function markdownFinding(item, disposition) {
  const file = githubFileForFinding(item) ?? item.path ?? '';
  return `| ${markdownEscape(disposition)} | ${markdownEscape(item.type)} | `
    + `${markdownEscape(item.generatorId ?? 'validation')} | ${markdownEscape(item.message)} | `
    + `${markdownEscape(file)} |`;
}


function appendGithubStepSummary(result) {
  const summaryPath = process.env.GITHUB_STEP_SUMMARY;
  if (!summaryPath) return;

  const lines = [
    '## Mojang Creator Tools diagnostics',
    '',
    `- **Projects:** ${result.projectCount}`,
    `- **Blocking findings:** ${result.blockers.length}`,
    `- **Warnings:** ${result.warnings.length}`,
    `- **Compatibility findings (raw diagnostics retained):** ${result.compatibility.length}`,
    '',
  ];

  const groups = [
    ['Blocking findings', result.blockers, 'BLOCKER'],
    ['Warnings', result.warnings, 'WARNING'],
    ['Evidence-backed compatibility findings', result.compatibility, 'COMPATIBILITY'],
  ];

  for (const [title, items, disposition] of groups) {
    lines.push(`<details${items.length > 0 && disposition === 'BLOCKER' ? ' open' : ''}>`);
    lines.push(`<summary><strong>${title} (${items.length})</strong></summary>`);
    lines.push('');
    if (items.length === 0) {
      lines.push('_None._');
    } else {
      lines.push('| Status | Type | Generator | Message | File |');
      lines.push('| --- | --- | --- | --- | --- |');
      for (const item of items) lines.push(markdownFinding(item, disposition));
    }
    lines.push('');
    lines.push('</details>');
    lines.push('');
  }

  appendFileSync(summaryPath, `${lines.join('\n')}\n`, 'utf8');
}


function reportFindings(result) {
  // Always print every finding to the raw Actions log. GitHub's annotation UI can
  // cap how many annotations it displays, so the log and step summary remain the
  // complete source of diagnostics.
  for (const item of result.blockers) {
    printFinding(item, 'error');
    emitGithubAnnotation(item, 'error', 'MCT blocker');
  }

  for (const item of result.warnings) {
    printFinding(item, 'warn');
    emitGithubAnnotation(item, 'warning', 'MCT warning');
  }

  for (const item of result.compatibility) {
    printFinding(item, 'warn');
    emitGithubAnnotation(
      item,
      'warning',
      'MCT compatibility diagnostic',
      '[evidence-backed compatibility diagnostic; raw finding retained] ',
    );
  }

  appendGithubStepSummary(result);
}


export function validateMctReport(report, status = 0, options = {}) {
  const result = classifyMctFindings(report, options);
  console.log(
    `Mojang Creator Tools: ${result.projectCount} project(s), ${result.blockers.length} blocker(s), `
      + `${result.warnings.length} warning(s), ${result.compatibility.length} compatibility diagnostic(s).`,
  );

  reportFindings(result);

  if (result.compatibility.length > 0) {
    console.warn(
      'Evidence-backed compatibility diagnostics remain visible in the raw report and step summary; '
        + 'they are accepted because the current pack schema/location is documented outside MCT 0.17.7.',
    );
  }

  const findingCount = result.blockers.length + result.warnings.length;
  if (findingCount > 0) {
    throw new Error(
      `Mojang Creator Tools strict validation failed: `
        + `${result.blockers.length} blocker(s), ${result.warnings.length} warning(s), `
        + `${result.compatibility.length} compatibility diagnostic(s). CI requires zero `
        + 'unclassified findings.',
    );
  }

  if (status !== 0) {
    if (result.compatibility.length === 0) {
      throw new Error(
        `Mojang Creator Tools exited unexpectedly with status ${status} despite reporting zero findings.`,
      );
    }
    console.warn(
      `Mojang Creator Tools exited with status ${status}; all reported findings are `
        + 'evidence-backed compatibility diagnostics.',
    );
  }

  return result;
}


const invokedPath = process.argv[1] ? path.resolve(process.argv[1]) : '';
if (invokedPath === fileURLToPath(import.meta.url)) {
  const reportPath = process.argv[2];
  if (!reportPath) throw new Error('Usage: node tools/filter_mct_validation.mjs <report.json>');
  const report = JSON.parse(readFileSync(reportPath, 'utf8'));
  validateMctReport(
    report,
    Number(process.env.MCT_STATUS ?? '0'),
    { compatibilityEvidence: loadMctCompatibilityEvidence(process.cwd()) },
  );
}
