#version 150

#import <thebrokenscript:include/chunk_vertex.glsl>

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV2;
in vec3 Normal;

out vec3 pos;
out vec4 vClipPos;

uniform vec3 u_RegionOffset;
uniform mat4 u_ProjectionMatrix;
uniform mat4 u_ModelViewMatrix;

uvec3 _get_relative_chunk_coord(uint pos) {
    return uvec3(pos) >> uvec3(5u, 0u, 2u) & uvec3(7u, 3u, 7u);
}

vec3 _get_draw_translation(uint pos) {
    return _get_relative_chunk_coord(pos) * vec3(16.0);
}

void main() {
    _vert_init();
    vec3 translation = u_RegionOffset + _get_draw_translation(_draw_id);

    vec3 basePos = _vert_position + translation;
    pos = basePos;

    vClipPos = u_ProjectionMatrix * u_ModelViewMatrix * vec4(basePos, 1.0);

    gl_Position = vClipPos;
}