import { LIBRARY_BOOK_PAGES } from "./library_book_data.js";

export function libraryBookPageView(bookId, pageIndex) {
  const pages = LIBRARY_BOOK_PAGES[bookId] ?? [];
  const index = pages.length
    ? Math.max(0, Math.min(pages.length - 1, Math.floor(pageIndex)))
    : 0;
  const buttons = [];
  if (index > 0) buttons.push({ label: "Previous page", nextPage: index - 1 });
  if (index + 1 < pages.length) buttons.push({ label: "Next page", nextPage: index + 1 });
  buttons.push({ label: "Close", nextPage: null });
  return { content: pages[index] ?? "", page: index, totalPages: pages.length, buttons };
}
