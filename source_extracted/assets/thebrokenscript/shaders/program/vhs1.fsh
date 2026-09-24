#version 150

uniform sampler2D DiffuseSampler;
uniform vec2 InSize;
uniform float Time;

in vec2 texCoord;
out vec4 fragColor;

const float LUMA_NOISE = 0.3;
const float CHROMA_NOISE = 0.25;
const float QUANTIZATION_LEVELS = 128.0;


float rand(vec2 co) {
    return fract(sin(dot(co.xy, vec2(12.9898, 78.233)) + Time * 37.0) * 43758.5453);
}

vec3 quantize(vec3 color, float levels) {
    return floor(color * levels) / levels;
}

vec3 rgb2yuv(vec3 rgb) {
    float y = 0.299 * rgb.r + 0.587 * rgb.g + 0.114 * rgb.b;
    return vec3(y, 0.493 * (rgb.b - y), 0.877 * (rgb.r - y));
}

void main() {
    vec3 color = texture(DiffuseSampler, texCoord).rgb;
    color = rgb2yuv(color);
    color = quantize(color, QUANTIZATION_LEVELS);

    vec3 noise = vec3(
        rand(texCoord * 0.1 + vec2(0.0, 0.0)),
        rand(texCoord * 0.1 + vec2(1.0, 0.0)),
        rand(texCoord * 0.1 + vec2(2.0, 0.0))
    );

    color.r += noise.x * LUMA_NOISE * 0.5;
    color.gb += noise.yz * CHROMA_NOISE * 0.5;

    fragColor = vec4(color, 1.0);
}
