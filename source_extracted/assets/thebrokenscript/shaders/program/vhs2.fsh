#version 150

uniform sampler2D DiffuseSampler;
uniform vec2 InSize;
uniform float Time;

in vec2 texCoord;
out vec4 fragColor;

const vec2 TARGET_RES = vec2(320.0, 240.0);

const float LUMA_QUALITY = 2.0;
const float CHROMA_QUALITY = 4.0;

const float SCANLINE_INTENSITY = 0.15;
const float SCANLINE_FREQUENCY = 240.0;
const float SCANLINE_ROLL = 0.0;

vec3 yuv2rgb(vec3 yuv) {
    float y = yuv.x;
    float u = yuv.y;
    float v = yuv.z;

    return vec3(
        y + 1.0 / 0.877 * v,
        y - 0.39393 * u - 0.58081 * v,
        y + 1.0 / 0.493 * u
    );
}

float scanline(vec2 uv) {
    // Calculate scanline effect based on screen position
    float scanline = 1.0 - SCANLINE_INTENSITY * sin(uv.y * SCANLINE_FREQUENCY * 3.14159 + SCANLINE_ROLL * InSize.y) * sin(uv.y * SCANLINE_FREQUENCY * 3.14159);

    // Apply finer horizontal lines for authentic CRT look (optional)
    float fine_line = 1.0 - (SCANLINE_INTENSITY * 0.5) * sin(uv.x * InSize.x * 0.25) * sin(uv.x * InSize.x * 0.25);

    return scanline * fine_line;
}

void main() {
    float targetAspect = TARGET_RES.x / TARGET_RES.y;
    float screenAspect = InSize.x / InSize.y;

    vec2 targetRes;
    if (screenAspect > targetAspect) {
        // wider - use same y, add pixels to x
        float scaleX = screenAspect / targetAspect;
        targetRes = vec2(TARGET_RES.x * scaleX, TARGET_RES.y);
    } else {
        // taller - use same x, add pixels to y
        float scaleY = targetAspect / screenAspect;
        targetRes = vec2(TARGET_RES.x, TARGET_RES.y * scaleY);
    }

    vec2 t = floor(texCoord * targetRes) / targetRes;

    float luma = textureLod(DiffuseSampler, t, LUMA_QUALITY).r;
    vec2 chroma = textureLod(DiffuseSampler, t, CHROMA_QUALITY).gb;
    vec3 color = yuv2rgb(vec3(luma, chroma));

    color *= scanline(t);

    fragColor = vec4(color, 1.0);
}