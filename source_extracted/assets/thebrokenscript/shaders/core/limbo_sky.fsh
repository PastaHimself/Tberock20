#version 150 core

// shaders credits: Danilo Guanabara
// ShaderToy: https://www.shadertoy.com/view/XsXXDn

uniform float uTime;
in  vec3 vRayDir;
out vec4 fragColor;

vec3 plasma(vec2 p, float t) {
    vec3  c = vec3(0.0);
    float z = t;
    float l = 0.0;
    for (int i = 0; i < 3; i++) {
        vec2 uv = p + 0.5;
        z  += 0.07;
        l   = length(p);
        uv += p / l * (sin(z) + 1.0) * abs(sin(l * 9.0 - z * 2.0));
        c[i] = 0.01 / length(mod(uv, 1.0) - 0.5);
    }
    return c / max(l, 0.0001);
}

void main() {
    vec3 ray = normalize(vRayDir);

    vec2 sky = ray.xz / (abs(ray.y) + 0.3);

    vec3 col = plasma(sky, uTime * 0.012);

    col *= smoothstep(-0.35, -0.1, ray.y);

    col = pow(max(col, vec3(0.0)), vec3(1.0 / 2.2));
    fragColor = vec4(col, 1.0);
}
