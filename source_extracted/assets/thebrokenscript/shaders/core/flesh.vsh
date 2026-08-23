#version 150

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV2;
in vec3 Normal;

uniform mat4 ProjMat;
uniform mat4 ModelViewMat;
uniform vec3 ChunkOffset;

out vec3 pos;
out vec4 vClipPos;
out vec2 texCoord0;
out vec2 texCoord1;

void main() {
    vec3 basePos = Position + ChunkOffset;
    vClipPos = ProjMat * ModelViewMat * vec4(basePos, 1.0);
    gl_Position = vClipPos;
    pos = basePos;
    texCoord0 = UV0;
    texCoord1 = vec2(UV2);
}