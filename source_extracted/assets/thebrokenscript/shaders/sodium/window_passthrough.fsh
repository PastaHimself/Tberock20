#version 150

uniform sampler2D Sampler0;
uniform float u_GameTime;

in vec4 vertexColor;
in vec2 texCoord0;
in vec2 texCoord2;

out vec4 fragColor;
float random(vec2 co) {
    float a = 12.9898;
    float b = 78.233;
    float c = 43758.5453;
    float dt = dot(co.xy, vec2(a, b));
    float sn = mod(dt, 3.14);
    return fract(sin(sn) * c);
}
vec2 pixelate(vec2 coord, vec2 pixelate_resolution) {
    vec2 uv = vec2(coord.x, coord.y);
    float x = floor(uv.x * pixelate_resolution.x) / pixelate_resolution.x;
    float y = floor(uv.y * pixelate_resolution.y) / pixelate_resolution.y;
    return vec2(x, y);
}

void main() {
    vec2 size = textureSize(Sampler0, 0);

    vec2 coord = pixelate(texCoord0, vec2(size));
    vec4 color = texture(Sampler0, texCoord0) * vertexColor;
    if (color.a < 0.1) {
        discard;
    }
    fragColor = color + (random(coord + vec2(u_GameTime * 6000.0, u_GameTime * -6000.0)) * 0.2);
}


