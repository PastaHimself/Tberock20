#version 150 core

in vec3 Position;

uniform mat4 ProjMatInverse;
uniform mat4 ViewMatInverse;

out vec3 vRayDir;

void main() {
    gl_Position = vec4(Position.xy, 0.0, 1.0);

    vec4 clipPos = vec4(Position.xy, 1.0, 1.0);
    vec4 viewPos = ProjMatInverse * clipPos;
    viewPos /= viewPos.w;

    vec4 worldDir = ViewMatInverse * vec4(normalize(viewPos.xyz), 0.0);
    vRayDir = normalize(worldDir.xyz);
}