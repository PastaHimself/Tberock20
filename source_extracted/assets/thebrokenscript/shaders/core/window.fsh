#version 150

uniform sampler2D Sampler0;
uniform sampler2D Passthrough;
uniform vec2 ScreenSize;

in vec2 texCoord0;
in vec4 texProj0;
out vec4 fragColor;
in vec4 vertexColor;

vec2 pixelate(vec2 coord, vec2 pixelate_resolution) {
    vec2 uv = vec2(coord.x, coord.y);
    float x = floor(uv.x * pixelate_resolution.x) / pixelate_resolution.x;
    float y = floor(uv.y * pixelate_resolution.y) / pixelate_resolution.y;
    return vec2(x, y);
}

vec4 cutout_passthrough(vec4 original, vec4 passthrough) {
    vec4 color;
    if (original.a <= 0.01) color = passthrough;
    else color = original;
    return color;
}
void main() {
    vec4 block = texture(Sampler0, texCoord0) * vertexColor;
    vec4 color = textureProj(Passthrough, texProj0);
    if (color.a <= 0.01) color.rgb = vec3(0.0);
    fragColor = cutout_passthrough(block, color);
}