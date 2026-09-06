import { nullBookPages } from "./story_book_model.js";

/**
 * Builds the source written book through an injected ItemStack constructor.
 * Keeping the constructor injectable lets the source-facing behavior be
 * tested without importing the Bedrock runtime module.
 */
export function createSignedNullBook(ItemStackConstructor, clanVoidX, clanVoidZ, includeCoordinates = true) {
  const item = new ItemStackConstructor("minecraft:writable_book", 1);
  const book = item.getComponent("minecraft:book");
  if (!book) return null;
  book.setContents(nullBookPages(clanVoidX, clanVoidZ, includeCoordinates));
  book.signBook("null", "null");
  return item;
}

/**
 * Gives a copy to one player and drops an uninserted remainder at that
 * player's location, matching the player-facing intent of Java addItem.
 */
export function distributeNullBook(player, item) {
  try {
    const candidate = typeof item.clone === "function" ? item.clone() : item;
    let remainder;
    if (typeof player.addItem === "function") {
      remainder = player.addItem(candidate);
    } else {
      const container = player.getComponent("minecraft:inventory")?.container;
      if (!container) return false;
      remainder = container.addItem(candidate);
    }
    if (remainder === undefined) return true;
    if (typeof player.dimension?.spawnItem !== "function") return false;
    player.dimension.spawnItem(remainder, player.location);
    return true;
  } catch {
    return false;
  }
}
