#version 150
uniform sampler2D DiffuseSampler;
uniform float Time;
in vec2 texCoord;
out vec4 fragColor;

float hash(float n) {
    return fract(sin(n) * 43758.5453123);
}

void main() {
    vec2 uv = texCoord;
    vec2 center = vec2(0.5);
    vec2 fromCenter = uv - center;
    float dist = length(fromCenter);

    float edgeFactor = smoothstep(0.25, 0.75, dist);

    const float PI = 3.14159265358979323846;
    float t = Time * 2.0 * PI;
    float lines = sin(uv.y * 60.0 + t);
    lines = clamp(lines, -1.0, 1.0);

    float aberrationStrength = edgeFactor;
    vec2 offset = vec2(lines * aberrationStrength * 0.02, 0.0);
    vec2 offsetUv = clamp(uv + offset, vec2(0.0), vec2(1.0));

    vec4 sceneColor = texture(DiffuseSampler, offsetUv);

    float noise = hash(dot(uv, vec2(12.9898, 78.233)) + t * 1000.0);
    float noiseIntensity = edgeFactor * 0.05 + (lines * 0.01);
    vec3 noiseColor = vec3(noise - 0.5);

    vec3 tint = vec3(1.0, 1.0, 0.95);
    vec3 finalColor = sceneColor.rgb * tint + noiseColor * noiseIntensity;

    float scanlineMask = abs(lines) * edgeFactor;
    finalColor = mix(finalColor, vec3(0.0), scanlineMask * 0.15);

    fragColor = vec4(finalColor, 1.0);
}