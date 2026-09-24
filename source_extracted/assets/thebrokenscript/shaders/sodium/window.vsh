#version 150

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV2;
in vec3 Normal;

#import <thebrokenscript:include/chunk_vertex.glsl>

uniform float u_GameTime;
uniform vec3 u_RegionOffset;
uniform mat4 u_ProjectionMatrix;
uniform mat4 u_ModelViewMatrix;

out vec2 texCoord0;
out vec4 texProj0;

out vec4 vertexColor;

vec4 projection_from_position(vec4 position) {
    vec4 projection = position * 0.5;
    projection.xy = vec2(projection.x + projection.w, projection.y + projection.w);
    projection.zw = position.zw;
    return projection;
}


uvec3 _get_relative_chunk_coord(uint pos) {
    // Packing scheme is defined by LocalSectionIndex6
    return uvec3(pos) >> uvec3(5u, 0u, 2u) & uvec3(7u, 3u, 7u);
}

vec3 _get_draw_translation(uint pos) {
    return _get_relative_chunk_coord(pos) * vec3(16.0);
}



void main() {
    _vert_init();
    vec3 translation = u_RegionOffset + _get_draw_translation(_draw_id);
    vec3 basePos = _vert_position + translation;
    gl_Position = u_ProjectionMatrix * u_ModelViewMatrix * vec4(basePos, 1.0);
    texCoord0 = UV0;
    texProj0 = projection_from_position(gl_Position);
    vertexColor = Color;
}
