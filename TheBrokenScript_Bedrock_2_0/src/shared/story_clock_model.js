export const STORY_TICKS_PER_DAY = 24000;
export const STORY_THRESHOLD_OFFSET = 1000;

function threshold(day) {
    return STORY_TICKS_PER_DAY * day + STORY_THRESHOLD_OFFSET;
}

// Source order is chronological at runtime because Java looks up the
// multimap by the current exact story tick.
export const STORY_EVENT_THRESHOLDS = Object.freeze([
    Object.freeze({ eventId: "txt_story_5", threshold: threshold(5) }),
    Object.freeze({ eventId: "coords_hint_6", threshold: threshold(6) }),
    Object.freeze({ eventId: "txt_story_10", threshold: threshold(10) }),
    Object.freeze({ eventId: "null_book_hint", threshold: threshold(12) }),
    Object.freeze({ eventId: "txt_story_15", threshold: threshold(15) }),
    Object.freeze({ eventId: "txt_story_20", threshold: threshold(20) }),
    Object.freeze({ eventId: "moon_corruption_24", threshold: threshold(24) }),
    Object.freeze({ eventId: "moon_corruption_32", threshold: threshold(32) }),
    Object.freeze({ eventId: "moon_corruption_38", threshold: threshold(38) }),
    Object.freeze({ eventId: "moon_corruption_48", threshold: threshold(48) }),
]);

export function evaluateStoryClockTick(currentTime, playerCount, doDayLightCycle) {
    if (doDayLightCycle !== true) {
        return { nextTime: currentTime, shouldDispatch: false };
    }
    return {
        nextTime: playerCount > 0 ? currentTime + 1 : currentTime,
        shouldDispatch: true,
    };
}
