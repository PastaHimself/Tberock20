#version 150

in vec3 Position;

uniform mat4 ProjMat;
uniform mat4 InverseViewRotMat;
uniform mat4 InverseProjMat;

out vec3 fragPos;

void main() {
    fragPos = (InverseViewRotMat * InverseProjMat * vec4(Position.xy, 1.0, 1.0)).xyz;
    gl_Position = vec4(Position.xy, Position.z, 1.0);
}