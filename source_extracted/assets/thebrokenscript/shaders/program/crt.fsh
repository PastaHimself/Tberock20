#version 150

uniform sampler2D DiffuseSampler;
uniform vec2 InSize;

in vec2 texCoord;
out vec4 fragColor;

const float targetAspect = 4.0 / 3.0;
const vec3 LETTERBOX_COLOR = vec3(0.0);
const float BARREL_DISTORTION_STRENGTH = 0.1;

vec2 barrelDistort(vec2 uv) {
    vec2 centered = uv * 2.0 - 1.0;
    float r = length(centered);
    float r2 = r * r;
    float distortion = 1.0 + BARREL_DISTORTION_STRENGTH * (r2 * r2 - r2);
    return centered * distortion * 0.5 + 0.5;
}

vec2 mapCrop(vec2 uv, vec2 cropMin, vec2 cropMax) {
    return (uv - cropMin) / (cropMax - cropMin);
}

vec2 unmapCrop(vec2 uv, vec2 cropMin, vec2 cropMax) {
    return mix(cropMin, cropMax, uv);
}

void main() {
    float screenAspect = InSize.x / InSize.y;

    vec2 cropMin = vec2(0.0);
    vec2 cropMax = vec2(1.0);

    if (screenAspect > targetAspect) {
        float scaleX = targetAspect / screenAspect;
        float bar = (1.0 - scaleX) * 0.5;
        cropMin.x = bar;
        cropMax.x = 1.0 - bar;
    } else {
        float scaleY = screenAspect / targetAspect;
        float bar = (1.0 - scaleY) * 0.5;
        cropMin.y = bar;
        cropMax.y = 1.0 - bar;
    }


    vec2 uv = barrelDistort(mapCrop(texCoord, cropMin, cropMax));

    if (uv.x < 0.0 || uv.x > 1.0 || uv.y < 0.0 || uv.y > 1.0) {
        fragColor = vec4(LETTERBOX_COLOR, 1.0);
        return;
    }

    uv = unmapCrop(uv, cropMin, cropMax);

    fragColor = vec4(texture(DiffuseSampler, uv).rgb, 1.0);
}