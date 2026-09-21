// Source: TBSEngineControl.Companion.eventFrequency(gameTime).
// Java evaluates a day-scaled curve, divides that curve by 24000, then
// subtracts the fixed 2.9166666E-4 baseline from every caller's spawn chance.
const TICKS_PER_DAY = 24000;
const CUTOFF_DAYS = 55;
const QUADRATIC_SCALE = 0.03125;
const MAX_CURVE = 7;
const BASE_OFFSET = 2.9166666e-4;

function quadCurve(days) {
    return Math.pow(QUADRATIC_SCALE * days, 2);
}

function logCurve(days) {
    return Math.log10(days + 1 - CUTOFF_DAYS) + quadCurve(CUTOFF_DAYS);
}

export function eventFrequency(gameTime) {
    const ticks = Number(gameTime);
    if (!Number.isFinite(ticks)) return 0;

    const days = ticks / TICKS_PER_DAY;
    const curve = Math.min(
        days < CUTOFF_DAYS ? quadCurve(days) : logCurve(days),
        MAX_CURVE,
    );
    return curve / TICKS_PER_DAY - BASE_OFFSET;
}
