import { BlockPermutation, GameMode, ItemStack } from "@minecraft/server";
import * as diagnostics from "../core/operation_diagnostics.js";
import { adjacent, flowLevel, plushDirection, plushName } from "./item_block_logic.js";

const PREFIX = "thebrokenscript:";
const SOURCE = `${PREFIX}void_goop_still`;
const FLOW = `${PREFIX}void_goop_flow`;
const LEVEL = `${PREFIX}level`;
const SOUNDS = new Set(["dominik", "ebridger", "eyae", "garreth", "hermit", "lost", "lovemist", "nahbro", "pyrit", "redstone", "stevelocks", "tekkit", "zetos"]);
const HORIZONTAL = ["North", "East", "South", "West"];
const FACES = ["Up", "Down", ...HORIZONTAL];

function selected(player, type) {
  const inventory = player.getComponent("minecraft:inventory")?.container;
  const slot = player.selectedSlotIndex;
  const item = inventory?.getItem(slot);
  return item?.typeId === type ? { inventory, slot, item } : undefined;
}

function spend(player, type, replacement) {
  if (player.getGameMode() === GameMode.Creative) return true;
  const held = selected(player, type);
  if (!held) return false;
  if (held.item.amount === 1) held.inventory.setItem(held.slot, replacement && new ItemStack(replacement, 1));
  else {
    held.item.amount -= 1;
    held.inventory.setItem(held.slot, held.item);
    if (replacement) player.dimension.spawnItem(new ItemStack(replacement, 1), player.location);
  }
  return true;
}

function targetBlock(block, face) {
  const location = adjacent(block.location, face);
  return location && block.dimension.getBlock(location);
}

function openForPlacement(block) {
  return block?.isAir || block?.typeId === FLOW || ["minecraft:tall_grass", "minecraft:short_grass", "minecraft:snow_layer"].includes(block?.typeId);
}

function playSquish(player, name, block) {
  try {
    if (SOUNDS.has(name)) {
      const sound = `plush.${name}.squish`;
      if (block) block.dimension.playSound(sound, { x: block.location.x + 0.5, y: block.location.y + 0.5, z: block.location.z + 0.5 });
      else player.playSound(sound);
    } else player.onScreenDisplay.setActionBar("§d* squish *");
  } catch (error) {
    diagnostics.warnOnce(`item_blocks.squish.${name}`, "plush squish presentation failed", error);
  }
}

export function usePlush(player, item, block, face) {
  const name = plushName(item?.typeId);
  if (!name || player?.typeId !== "minecraft:player") return false;
  if (player.isSneaking) {
    playSquish(player, name);
    return true;
  }
  if (!block) return false;
  const target = targetBlock(block, face);
  if (!openForPlacement(target)) return false;
  const prior = target.permutation;
  try {
    target.setPermutation(BlockPermutation.resolve(`${PREFIX}${name}_plush_block`, { [`${PREFIX}direction`]: plushDirection(player.getViewDirection()) }));
    if (!spend(player, item.typeId)) {
      target.setPermutation(prior);
      return false;
    }
    return true;
  } catch (error) {
    try { target.setPermutation(prior); } catch (restoreError) {
      diagnostics.errorOnce("item_blocks.plush_restore", "failed to restore plush placement", restoreError);
    }
    diagnostics.warnOnce(`item_blocks.plush_place.${name}`, "plush placement failed", error);
    return false;
  }
}

export function useFluidBucket(player, block, face) {
  if (player?.typeId !== "minecraft:player" || !block) return false;
  const target = targetBlock(block, face);
  if (!openForPlacement(target)) return false;
  const prior = target.permutation;
  try {
    target.setType(SOURCE);
    if (!spend(player, `${PREFIX}void_liquid_bucket`, "minecraft:bucket")) {
      target.setPermutation(prior);
      return false;
    }
    return true;
  } catch (error) {
    try { target.setPermutation(prior); } catch (restoreError) {
      diagnostics.errorOnce("item_blocks.fluid_restore", "failed to restore bucket placement", restoreError);
    }
    diagnostics.warnOnce("item_blocks.bucket_place", "void fluid placement failed", error);
    return false;
  }
}

export function collectFluid(player, block) {
  if (player?.typeId !== "minecraft:player" || block?.typeId !== SOURCE) return false;
  const held = selected(player, "minecraft:bucket");
  if (!held) return false;
  try {
    const prior = block.permutation;
    block.setType("minecraft:air");
    try {
      if (!spend(player, "minecraft:bucket", `${PREFIX}void_liquid_bucket`)) {
        block.setPermutation(prior);
        return false;
      }
      return true;
    } catch (error) {
      block.setPermutation(prior);
      throw error;
    }
  } catch (error) {
    diagnostics.warnOnce("item_blocks.bucket_collect", "void fluid collection failed", error);
    return false;
  }
}

function setFlow(block, level) {
  if (!openForPlacement(block) || block?.typeId === SOURCE) return;
  if (block.typeId === FLOW && Number(block.permutation.getState(LEVEL)) <= level) return;
  block.setPermutation(BlockPermutation.resolve(FLOW, { [LEVEL]: level }));
}

export function tickFluid(block) {
  const source = block.typeId === SOURCE;
  if (!source && block.typeId !== FLOW) return;
  try {
    const below = targetBlock(block, "Down");
    if (openForPlacement(below) && below.typeId !== FLOW) {
      setFlow(below, 1);
      return;
    }
    if (below?.typeId === FLOW) setFlow(below, 1);
    let level = source ? 0 : Number(block.permutation.getState(LEVEL));
    if (!source) {
      let nearest = 8;
      for (const face of HORIZONTAL) {
        const adjacentBlock = targetBlock(block, face);
        if (adjacentBlock?.typeId === SOURCE) nearest = 0;
        else if (adjacentBlock?.typeId === FLOW) nearest = Math.min(nearest, Number(adjacentBlock.permutation.getState(LEVEL)));
      }
      const above = targetBlock(block, "Up");
      if (above?.typeId === SOURCE || above?.typeId === FLOW) nearest = 0;
      const desired = flowLevel(nearest);
      if (desired === undefined || desired > 7) { block.setType("minecraft:air"); return; }
      if (desired !== level) {
        block.setPermutation(BlockPermutation.resolve(FLOW, { [LEVEL]: desired }));
        level = desired;
      }
    }
    const next = flowLevel(level);
    if (next !== undefined) for (const face of HORIZONTAL) setFlow(targetBlock(block, face), next);
  } catch (error) {
    diagnostics.warnOnce("item_blocks.fluid_tick", "void fluid update failed", error);
  }
}

export function interactPlush(player, block) {
  const name = /^thebrokenscript:([a-z0-9_]+)_plush_block$/.exec(block?.typeId)?.[1];
  if (name && player) playSquish(player, name, block);
}

export function tickVoidBud(block) {
  try {
    const face = String(block.permutation.getState("minecraft:block_face"));
    const opposite = { up: "Down", down: "Up", north: "South", south: "North", east: "West", west: "East" }[face];
    if (opposite && !targetBlock(block, opposite)?.isSolid) block.setType("minecraft:air");
  } catch (error) {
    diagnostics.warnOnce("item_blocks.void_bud", "void bud support check failed", error);
  }
}

export function tickNewVein(block) {
  try {
    const neighbors = Object.fromEntries(FACES.map(face => [face.toLowerCase(), targetBlock(block, face)]));
    if (!neighbors.up?.isSolid && !neighbors.down?.isSolid) {
      block.setType("minecraft:air");
      return;
    }
    const states = {};
    for (const face of FACES) {
      const key = face.toLowerCase();
      const neighbor = neighbors[key];
      states[`${PREFIX}${key}`] = face === "Up" || face === "Down"
        ? Boolean(neighbor?.isSolid)
        : neighbor?.typeId === `${PREFIX}new_vein`;
      if (face !== "Up" && face !== "Down") states[`${PREFIX}${key}_wall`] = Boolean(neighbor?.isSolid);
    }
    const prior = block.permutation.getAllStates();
    if (Object.entries(states).some(([key, value]) => prior[key] !== value)) {
      block.setPermutation(BlockPermutation.resolve(block.typeId, states));
    }
  } catch (error) {
    diagnostics.warnOnce("item_blocks.new_vein", "new vein connection update failed", error);
  }
}
