import * as operationDiagnostics from "../../core/operation_diagnostics.js";
export function skyLightLevelAt(dimension, location) {
    if (!dimension || !location) return undefined;

    const sample = {
        x: Math.floor(location.x),
        y: Math.floor(location.y + 1),
        z: Math.floor(location.z),
    };

    try {
        const skyLight = dimension.getSkyLightLevel?.(sample);
        if (typeof skyLight === "number") return skyLight;
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.ai.visibility.js.13", "best-effort Bedrock API fallback", error);
        // The location may be outside the loaded world boundary for this tick.
    }

    return undefined;
}

export function hasSkyLightAt(dimension, location, minimum = 15) {
    const skyLight = skyLightLevelAt(dimension, location);
    return typeof skyLight === "number" && skyLight >= minimum;
}
