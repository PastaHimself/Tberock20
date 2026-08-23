#version 150

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
out vec4 fragColor;

const vec3 AvgLumin = vec3(0.5, 0.5, 0.5);
const vec3 LumCoeff = vec3(0.2125, 0.7154, 0.0721);
uniform float Intensity;

void BSC(inout vec3 color, float brightness, float saturation, float contrast) {
    color *= brightness;
    vec3 intensity = vec3(dot(color, LumCoeff));
    color = mix(intensity, color, saturation);
    color = mix(AvgLumin, color, contrast);
}

void main() {
    vec3 color = texture(DiffuseSampler, texCoord).rgb;

    color.r = texture(DiffuseSampler, texCoord * (1 + Intensity)).r;
    color.b = texture(DiffuseSampler, texCoord * (1 - Intensity)).b;

    BSC(color, 1.0, 1.0, 1.25);
    fragColor = vec4(color, 1.0);
}
