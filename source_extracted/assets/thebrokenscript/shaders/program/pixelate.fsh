#version 150

uniform sampler2D DiffuseSampler;
uniform sampler2D DiffuseDepthSampler;
uniform vec2 InSize;
uniform float PixelSize;

in vec2 texCoord;
in vec2 oneTexel;

out vec4 fragColor;

float hash(vec2 p) {
    p = fract(p * vec2(234.34, 435.345));
    p += dot(p, p + 34.23);
    return fract(p.x * p.y);
}

void main() {
    vec2 blockSize = PixelSize / InSize;
    vec2 snappedUV = floor(texCoord / blockSize) * blockSize;

    vec4 color = texture(DiffuseSampler, snappedUV);
    float depth = texture(DiffuseDepthSampler, snappedUV).r;

    float isSky = step(0.9999, depth);
    vec2 skyBlockSize = (PixelSize * 0.5) / InSize;
    vec2 skyUV = floor(texCoord / skyBlockSize) * skyBlockSize;
    vec4 skyColor = texture(DiffuseSampler, skyUV);

    float grain = hash(snappedUV) * 0.01 - 0.04;
    fragColor = mix(color, skyColor, isSky);
    fragColor.rgb += grain;
}