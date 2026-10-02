import { system } from "@minecraft/server";
import { MessageFormData, ModalFormData } from "@minecraft/server-ui";
import { logger } from "../core/logging.js";
import * as integrityArena from "../entities/boss/integrity_arena_runtime.js";
import * as worldState from "./world_state.js";

// The Java command and confirmation containers have no inventory slots. Native
// Bedrock forms preserve their two decisions while the RP carries their art.
const pending = new Set();
const OVERWORLD = "minecraft:overworld";

export function commandCodeMatches(input, expected) {
  return typeof input === "string" && input.length > 0 && input === expected;
}

function blockAt(player, position) {
  try {
    return player.dimension.getBlock(position);
  } catch (error) {
    logger.warnOnce("command-screen:block-read", "command block screen could not read the clicked block", error);
    return undefined;
  }
}

function stillCommandBlock(player, position) {
  return player?.isValid !== false && player?.dimension?.id === OVERWORLD
    && blockAt(player, position)?.typeId === "thebrokenscript:command";
}

function canApplyCode(player, position) {
  return stillCommandBlock(player, position)
    && blockAt(player, { x: position.x, y: position.y - 1, z: position.z })?.typeId
      === "thebrokenscript:initiator";
}

function arenaCenter(position) {
  // Java chooses independent integer offsets in [-20, -11] U [11, 19].
  const offset = () => {
    const index = Math.floor(Math.random() * 19);
    return index < 10 ? index - 20 : index + 1;
  };
  return { x: position.x + offset() + 0.5, y: position.y + 0.5, z: position.z + offset() + 0.5 };
}

function inform(player, message) {
  try { player.sendMessage(message); } catch (error) {
    logger.warnOnce("command-screen:feedback", "command block screen could not notify the player", error);
  }
}

async function confirmExecution(player, position) {
  const response = await new MessageFormData()
    .title("Confirm execution")
    .body("Are you sure you want to do this?\nThe world won't be yours anymore...")
    .button1("Yes")
    .button2("Cancel")
    .show(player);
  if (response.canceled || response.selection !== 0) return;
  if (!stillCommandBlock(player, position)) return;
  const key = `${player.dimension.id}:${position.x},${position.y},${position.z}`;
  if (pending.has(key) || integrityArena.getState()) return;
  pending.add(key);
  // The source waits 40 ticks before darkening the sky, then 60 before
  // starting Arena. Bedrock's existing Arena runtime owns the encounter.
  system.runTimeout(() => {
    pending.delete(key);
    if (!stillCommandBlock(player, position)) return;
    const result = integrityArena.start(player, "phase1", arenaCenter(position));
    if (!result.accepted) inform(player, `§cArena not started: ${result.reason}`);
  }, 100);
}

export async function openCommandBlockScreen(player, position) {
  if (!player?.id || integrityArena.getState() || !stillCommandBlock(player, position)) return;
  try {
    const response = await new ModalFormData()
      .title("Input Code")
      .textField("Input Code", "", { defaultValue: "" })
      .submitButton("Execute")
      .show(player);
    if (response.canceled || !stillCommandBlock(player, position)) return;
    if (!commandCodeMatches(response.formValues?.[0], worldState.get("code"))) {
      inform(player, "§cerr.invalid.code");
      return;
    }
    if (!canApplyCode(player, position)) {
      inform(player, "§c[error] invalid position: initiator must be present below command block");
      return;
    }
    // The Java code-entry button also sends InventoryCorruptionProgressPacket.
    worldState.set("codeApplied", true);
    worldState.update("inventoryCorruption", (value) => value + 1);
    await confirmExecution(player, position);
  } catch (error) {
    logger.error("command block screen failed", error);
  }
}
