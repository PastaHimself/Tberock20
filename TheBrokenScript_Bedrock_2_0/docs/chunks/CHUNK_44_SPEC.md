# Chunk 44 — Library Book reader adapter

## Objective
Port the source LibraryBookItem/LibraryBookScreen contract and recovered payload corpus.

## Source contract
- source item id is retained when present; new source ids use 1..250.
- screen loads library_books/<id>.json; missing resources/pages render empty.
- pages are one-based and navigation is bounded.
- source payloads provide author plus page strings; 44 payloads are present in the supplied source corpus.

## Bedrock design
- library_book_model.js contains pure id, normalization, page, and navigation APIs.
- library_book_data.js embeds the 44 recovered payloads and exposes available ids.
- book.json registers thebrokenscript:library_book_use.
- ported_features.js shows an ActionFormData reader, preserves § formatting in page text, uses Previous/Next/Close controls, and safely retains an item-stack id when exposed.

## Acceptance criteria
- source range and valid-id retention are preserved.
- unavailable source ids fall back to a recovered payload for usable new books.
- pages and navigation match the source bounds.
- item use opens and closes safely without breaking the existing item component registry.
- Java-only texture/noisy/special-page presentation remains explicitly documented.

## Validation
- focused local model tests and full repository Node regressions.
- repository validators, beta API type-check, diagnostics, MCT, packaging, and report generation.
