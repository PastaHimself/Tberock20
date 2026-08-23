#version 150

in vec3 Position;
#moj_import <projection.glsl>

uniform vec3 ChunkOffset;
uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
in vec2 UV0;
in vec4 Color;

out vec2 texCoord0;
out vec4 texProj0;

out vec4 vertexColor;

void main() {
    vec3 basePos = Position + ChunkOffset;
    gl_Position = ProjMat * ModelViewMat * vec4(basePos, 1.0);
    texCoord0 = UV0;
    texProj0 = projection_from_position(gl_Position);
    vertexColor = Color;

}
