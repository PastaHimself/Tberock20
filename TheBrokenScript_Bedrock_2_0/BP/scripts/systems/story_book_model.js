// Pure source-backed model for NullBookStoryEvent. The runtime adapter owns
// Bedrock ItemStack operations; this module keeps the story contract testable.

const DAY = 24000;
const OFFSET = 1000;
const INT_MAX = 2147483647;

export const NULL_BOOK_STORY_TICKS = DAY * 12 + OFFSET;

// TBSLang.NULL_BOOK_CONTENT from the Java source language registry.
export const NULL_BOOK_PAGE1 =
  "§0null.err.object.err.null.object.alone.3.not.behind.entitytype:player.receiveddata.invalid.reboot.failed.reset.playerdata:00F9219492D94210F812";

/**
 * Reproduces NullBookStoryEvent's chunk-centered binary coordinate encoding.
 * MapVariables values are Java ints, so Integer.MAX_VALUE follows the same
 * source conversion as every other coordinate.
 */
export function nullBookCoordinate(value) {
  if (!Number.isInteger(value)) return "?";
  const chunkCenter = Math.floor(value / 16) * 16 + 8;
  const binary = Math.abs(chunkCenter).toString(2);
  return chunkCenter < 0 ? `-${binary}` : binary;
}

/** Returns the two pages written by NullBookStoryEvent. */
export function nullBookPages(clanVoidX, clanVoidZ, includeCoordinates = true) {
  const page2 = [
    "X:",
    nullBookCoordinate(clanVoidX),
    "",
    "Y:",
    "201",
    "",
    "Z:",
    nullBookCoordinate(clanVoidZ),
    "",
    "CV",
  ].join("\n");
  return includeCoordinates ? [NULL_BOOK_PAGE1, page2] : [NULL_BOOK_PAGE1];
}
