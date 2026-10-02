import { system } from "@minecraft/server";
import { logger } from "../core/logging.js";

// A title is a per-player transport to the JSON UI image in tbs_screens.json.
// Keep this list tied to the actual RP textures: a misspelled ID would show a
// missing texture across the entire screen.
export const SCREEN_IDS = Object.freeze([
  "be_not_afraid", "behindyou", "blick", "brokenscreen", "bsodd",
  "cantyousee", "frame1", "frame2", "frame3", "frame4", "frame5",
  "keepplaying", "run", "screenshot_2025-01-01_145155",
  "nullinterface", "null_interface_2", "nullinterface_3", "nulled_gui",
  "snimok_ekrana_2024-11-02_090828", "tbe_curious",
  "tbescreenframe_1", "tbescreenframe_2", "tbescreenframe_3", "tbescreenframe_4",
  "transition", "oblit_2_effect", "very_serious/baby", "very_serious/fardaway", "wecanhearyou",
  "very_serious/what_if_garfunkle_was_betrayed_and_sealed_for_a_thousand_years",
]);

const knownScreens = new Set(SCREEN_IDS);
// Source .png.anim.json: cells are stored top-to-bottom (transition uses 3 columns).
export const SCREEN_ANIMATIONS = Object.freeze({
  tbe_curious: { frames: 4, frameTicks: 3 },
  transition: { frames: 22, frameTicks: 2 },
  oblit_2_effect: { frames: 5, frameTicks: 1 },
});
const pending = new Map();

export function showScreen(player, screen, ticks = 10) {
  if (!knownScreens.has(screen)) throw new Error(`Unknown screen overlay: ${screen}`);
  if (!player?.id || player.isValid === false) return false;
  const id = player.id;
  const previous = pending.get(id);
  if (previous) system.clearRun(previous.handle);
  const animation = SCREEN_ANIMATIONS[screen];
  const duration = ticks === 0 && animation
    ? animation.frames * animation.frameTicks
    : Math.max(1, Math.floor(ticks));
  const entry = { handle: undefined };
  pending.set(id, entry);
  const clear = () => {
    if (pending.get(id) !== entry) return;
    pending.delete(id);
    if (player.isValid === false) return;
    try {
      player.onScreenDisplay.setTitle("tbs:screen/clear", {
        fadeInDuration: 0, stayDuration: 1, fadeOutDuration: 0,
      });
    } catch (error) {
      logger.warnOnce("screen-overlay:clear", "Could not clear a screen overlay", error);
    }
  };
  const draw = (elapsed) => {
    if (pending.get(id) !== entry) return false;
    if (player.isValid === false) {
      pending.delete(id);
      return false;
    }
    const remaining = duration - elapsed;
    const frameTicks = animation ? Math.min(animation.frameTicks, remaining) : remaining;
    const frame = animation ? `/${(Math.floor(elapsed / animation.frameTicks) % animation.frames) + 1}` : "";
    try {
      player.onScreenDisplay.setTitle(`tbs:screen/${screen}${frame}`, {
        fadeInDuration: 0, stayDuration: frameTicks, fadeOutDuration: 0,
      });
    } catch (error) {
      pending.delete(id);
      logger.warnOnce(`screen-overlay:${screen}`, `Could not display ${screen}`, error);
      return false;
    }
    entry.handle = system.runTimeout(
      elapsed + frameTicks < duration ? () => draw(elapsed + frameTicks) : clear,
      frameTicks,
    );
    return true;
  };
  return draw(0);
}
