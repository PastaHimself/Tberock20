// Bedrock 2.11 does not expose a recipe-craft event. The five source pieces
// craft one frame; using that frame completes the recipe and awards progress.
export function finishPolaroid(player, makeItem, award) {
  const inventory = player.getComponent("minecraft:inventory")?.container;
  const slot = player.selectedSlotIndex;
  if (!inventory || !Number.isInteger(slot)) return false;
  if (inventory.getItem(slot)?.typeId !== "thebrokenscript:polaroid_frame") return false;
  inventory.setItem(slot, makeItem("thebrokenscript:polaroid"));
  award(player, "polaroid_craft");
  return true;
}
