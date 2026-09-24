#version 150

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in vec2 UV2;

uniform mat4 u_ProjectionMatrix;
uniform mat4 u_ModelViewMatrix;

out vec4 vertexColor;
out vec2 texCoord0;
out vec2 texCoord2;

void main() {
    _vert_init();
    gl_Position = u_ProjectionMatrix * u_ModelViewMatrix * vec4(Position, 1.0);

    vertexColor = Color;
    texCoord0 = UV0;
    texCoord2 = UV2;
}