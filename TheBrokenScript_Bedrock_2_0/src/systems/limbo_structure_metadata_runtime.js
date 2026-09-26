import {
  BlockComponentTypes,
  ItemComponentTypes,
  ItemStack,
} from "@minecraft/server";
import { LIMBO_STRUCTURE_METADATA } from "./limbo_structure_metadata.js";

function absolutePosition(origin, relative) {
  return {
    x: origin.x + relative[0],
    y: origin.y + relative[1],
    z: origin.z + relative[2],
  };
}

function requireBlock(dimension, origin, relative, feature) {
  const position = absolutePosition(origin, relative);
  const block = dimension.getBlock(position);
  if (!block) throw new Error(`Limbo ${feature} block is unavailable at ${position.x},${position.y},${position.z}`);
  return block;
}

function createItemStack(spec) {
  const item = new ItemStack(spec.typeId, spec.amount);
  if (spec.nameTag) item.nameTag = spec.nameTag;
  if (Number.isInteger(spec.damage)) {
    const durability = item.getComponent(ItemComponentTypes.Durability);
    if (!durability) throw new Error(`Limbo item '${spec.typeId}' has no durability component`);
    durability.damage = Math.min(spec.damage, durability.maxDurability);
  }
  if (Array.isArray(spec.bookPages)) {
    const book = item.getComponent(ItemComponentTypes.Book);
    if (!book) throw new Error(`Limbo item '${spec.typeId}' has no book component`);
    book.setContents(spec.bookPages);
  }
  return item;
}

export function applyLimboStructureMetadata(dimension, structureName, origin) {
  const metadata = LIMBO_STRUCTURE_METADATA[structureName];
  if (!metadata) throw new Error(`missing Limbo metadata for '${structureName}'`);

  for (const signSpec of metadata.signs) {
    const block = requireBlock(dimension, origin, signSpec.position, "sign");
    const sign = block.getComponent(BlockComponentTypes.Sign);
    if (!sign) throw new Error(`Limbo sign component is unavailable in '${structureName}'`);
    sign.setText(signSpec.text);
  }

  for (const containerSpec of metadata.containers) {
    const block = requireBlock(dimension, origin, containerSpec.position, "container");
    const container = block.getComponent(BlockComponentTypes.Inventory)?.container;
    if (!container) throw new Error(`Limbo inventory component is unavailable in '${structureName}'`);
    const slotOffset = container.size >= 54 && containerSpec.chestType === "right" ? 27 : 0;
    for (const itemSpec of containerSpec.items) {
      container.setItem(slotOffset + itemSpec.slot, createItemStack(itemSpec));
    }
  }

  for (const recordSpec of metadata.records) {
    const block = requireBlock(dimension, origin, recordSpec.position, "record player");
    const recordPlayer = block.getComponent(BlockComponentTypes.RecordPlayer);
    if (!recordPlayer) throw new Error(`Limbo record-player component is unavailable in '${structureName}'`);
    recordPlayer.setRecord(recordSpec.typeId, false);
  }
}
