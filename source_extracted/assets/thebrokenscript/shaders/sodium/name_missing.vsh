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


uvec3 _get_relative_chunk_coord(uint pos) {
    // Packing scheme is defined by LocalSectionIndex6
    return uvec3(pos) >> uvec3(5u, 0u, 2u) & uvec3(7u, 3u, 7u);
}

vec3 _get_draw_translation(uint pos) {
    return _get_relative_chunk_coord(pos) * vec3(16.0);
}

float random(vec2 co)
{
    highp float a = 12.9898;
    highp float b = 78.233;
    highp float c = 43758.5453;
    highp float dt= dot(co.xy ,vec2(a,b));
    highp float sn= mod(dt,3.14);
    return fract(sin(sn) * c);
}
void main() {
    _vert_init();

    vec3 translation = u_RegionOffset + _get_draw_translation(_draw_id);
    vec3 basePos = _vert_position + translation;
    float delta = max((sin(u_GameTime * 6000.0) * 0.5) * 0.2, 0.0);
    float x = random(vec2(basePos.x, -basePos.x) + u_GameTime) - 0.5;
    float y = random(vec2(basePos.y, -basePos.y) - u_GameTime) - 0.5;
    float z = random(vec2(basePos.z, -basePos.z) + (u_GameTime * 0.5)) - 0.5;
    gl_Position = u_ProjectionMatrix * u_ModelViewMatrix * vec4(basePos + (vec3(x, y, z) * delta), 1.0);

}
