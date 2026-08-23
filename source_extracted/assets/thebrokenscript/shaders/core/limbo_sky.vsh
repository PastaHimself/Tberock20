#version 150 core

in vec3 Position;

uniform mat4 ProjMatInverse;
uniform mat4 ViewMatInverse;

out vec3 vRayDir;

void main() {
    gl_Position = vec4(Position.xy, 1.0, 1.0);

    vec4 viewDir = ProjMatInverse * vec4(Position.xy, 1.0, 1.0);
    viewDir = vec4(viewDir.xy, -1.0, 0.0);
    vRayDir = (ViewMatInverse * viewDir).xyz;
}
