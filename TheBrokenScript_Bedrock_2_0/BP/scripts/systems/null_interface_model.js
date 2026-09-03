const NULL_GRID_ROWS = 5;
const NULL_GRID_COLUMNS = 5;

const NULL_INTERFACE_DEFINITIONS = Object.freeze([
  Object.freeze({
    interfaceId: "null_interface_1",
    title: "NullInterface",
    body: "behind you",
    layout: "single_text",
  }),
  Object.freeze({
    interfaceId: "null_interface_2",
    title: "NullInterface2",
    body: Array.from({ length: NULL_GRID_ROWS }, () =>
      Array.from({ length: NULL_GRID_COLUMNS }, () => "null").join("   ")
    ).join("\n"),
    layout: "five_by_five_grid",
  }),
  Object.freeze({
    interfaceId: "null_interface_3",
    title: "NullInterface3",
    body: "help",
    layout: "single_text",
  }),
]);

export const NULL_INTERFACE_COUNT = NULL_INTERFACE_DEFINITIONS.length;

export function nullInterfaceDefinition(index = 0) {
  const numericIndex = Math.floor(Number(index));
  const normalizedIndex = Number.isFinite(numericIndex)
    ? Math.abs(numericIndex) % NULL_INTERFACE_COUNT
    : 0;
  return NULL_INTERFACE_DEFINITIONS[normalizedIndex];
}

export function nullInterfaceGridShape() {
  return { rows: NULL_GRID_ROWS, columns: NULL_GRID_COLUMNS };
}
