export const MAX_BOOK_ID = 251;

export function assignBookId(existingId, random = Math.random()) {
  const current = Number(existingId);
  if (Number.isInteger(current) && current >= 1 && current < MAX_BOOK_ID) return current;

  const roll = Number(random);
  const normalized = Number.isFinite(roll) && roll > 0
    ? Math.min(roll, 0.9999999999999999)
    : 0;
  return 1 + Math.floor(normalized * (MAX_BOOK_ID - 1));
}

/** @param {readonly (number|string)[]} availableIds */
export function selectAvailableBookId(existingId, random, availableIds = []) {
  const available = availableIds.filter((id) => Number.isInteger(Number(id))).map(Number);
  const current = Number(existingId);
  if (available.includes(current)) return current;
  if (available.length === 0) return assignBookId(existingId, random);

  const roll = Number(random);
  const normalized = Number.isFinite(roll) && roll > 0
    ? Math.min(roll, 0.9999999999999999)
    : 0;
  return available[Math.floor(normalized * available.length)];
}

export function normalizeBook(value) {
  const book = value && typeof value === "object" ? value : {};
  return {
    author: typeof book.author === "string" ? book.author : "",
    pages: Array.isArray(book.pages) ? book.pages.filter((page) => typeof page === "string") : [],
  };
}

export function pageAt(book, pageNumber) {
  const page = Number(pageNumber);
  return Number.isInteger(page) && page >= 1 ? normalizeBook(book).pages[page - 1] ?? "" : "";
}

export function pageForward(currentPage, totalPages) {
  const current = Math.max(0, Math.floor(Number(currentPage) || 0));
  const total = Math.max(0, Math.floor(Number(totalPages) || 0));
  return total > 0 ? Math.min(current + 1, total - 1) : 0;
}

export function pageBack(currentPage) {
  return Math.max(0, Math.floor(Number(currentPage) || 0) - 1);
}
