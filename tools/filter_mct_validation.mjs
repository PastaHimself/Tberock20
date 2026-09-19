#!/usr/bin/env node

import { appendFileSync, readFileSync } from 'node:fs';
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
// MCT 0.17.7 does not yet recognize some current Bedrock content locations/formats
// documented by Mojang. Keep these patterns intentionally narrow and back them with
// our own dedicated validators so unrelated findings remain blocking.
const CLIENT_BIOME_PATH = /^\/resource_packs\/rp\/biomes_client\/[a-z0-9._-]+\.biome_client\.json$/;
const JIGSAW_STRUCTURE_JSON_PATH = /^\/behavior_packs\/bp\/worldgen\/structures\/[a-z0-9._/-]+\.json$/;
const JAVA_STRUCTURE_NBT_PATH = /\/behavior_packs\/bp\/structures\/[a-z0-9._/-]+\.nbt$/;


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


export function classifyMctFindings(report) {
  if (!Array.isArray(report.projects) || report.projects.length === 0) {
    throw new Error('Mojang Creator Tools did not discover any Minecraft projects.');
  }

  const items = report.projects.flatMap((project) => project.items ?? []);
  const rawBlockers = items.filter((item) => BLOCKING_TYPES.has(item.type));
  const warnings = items.filter((item) => item.type === 'warning');

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
  const ignored = [];
  for (const item of rawBlockers) {
    const text = serializedFinding(item);
    const ignore = isSelfComparisonScriptModuleError(item)
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
    (ignore ? ignored : blockers).push(item);
  }

  return {
    blockers,
    ignored,
    warnings,
    projectCount: report.projects.length,
    rawBlockerCount: rawBlockers.length,
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
    `- **Known false-positive blockers (not hidden):** ${result.ignored.length}`,
    '',
  ];

  const groups = [
    ['Blocking findings', result.blockers, 'BLOCKER'],
    ['Warnings', result.warnings, 'WARNING'],
    ['Ignored known false-positive blockers', result.ignored, 'IGNORED BLOCKER'],
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

  for (const item of result.ignored) {
    printFinding(item, 'warn');
    emitGithubAnnotation(
      item,
      'warning',
      'MCT ignored blocker',
      '[known false-positive blocker; still shown] ',
    );
  }

  appendGithubStepSummary(result);
}


export function validateMctReport(report, status = 0) {
  const result = classifyMctFindings(report);
  console.log(
    `Mojang Creator Tools: ${result.projectCount} project(s), ${result.blockers.length} blocker(s), `
      + `${result.warnings.length} warning(s), ${result.ignored.length} known false-positive blocker(s) ignored.`,
  );

  reportFindings(result);

  if (result.ignored.length > 0) {
    console.warn(
      'Known false-positive blockers are allowed only for exact Script Module self-comparisons, '
        + 'official resource-pack biomes_client files, current Jigsaw structure JSON files, '
        + 'and Java NBT structure templates under behavior-pack structures/. They are still '
        + 'printed and annotated above so CI never hides them.',
    );
  }
  if (result.blockers.length > 0) {
    throw new Error(
      `Mojang Creator Tools validation failed (exit ${status}) with ${result.blockers.length} blocking finding(s).`,
    );
  }
  if (status === 0) return result;

  const expectedStatus = Math.max(
    0,
    ...result.ignored.map((item) => MCT_EXIT_CODES.get(item.type) ?? 0),
  );
  const recognizedValidationFailure = expectedStatus > 0
    && status === expectedStatus
    && result.rawBlockerCount > 0
    && result.ignored.length === result.rawBlockerCount;
  if (!recognizedValidationFailure) {
    throw new Error(
      `Mojang Creator Tools exited unexpectedly (exit ${status}; expected ${expectedStatus}).`,
    );
  }
  return result;
}


const invokedPath = process.argv[1] ? path.resolve(process.argv[1]) : '';
if (invokedPath === fileURLToPath(import.meta.url)) {
  const reportPath = process.argv[2];
  if (!reportPath) throw new Error('Usage: node tools/filter_mct_validation.mjs <report.json>');
  const report = JSON.parse(readFileSync(reportPath, 'utf8'));
  validateMctReport(report, Number(process.env.MCT_STATUS ?? '0'));
}
