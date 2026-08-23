#version 150

in vec3 Position;
uniform vec3 ChunkOffset;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform float GameTime;

float random(vec2 co) {
    highp float a = 12.9898;
    highp float b = 78.233;
    highp float c = 43758.5453;
    highp float dt = dot(co.xy, vec2(a, b));
    highp float sn = mod(dt, 3.14);
    return fract(sin(sn) * c);
}

void main() {
    vec3 basePos = Position + ChunkOffset;
    float delta = max((sin(GameTime * 6000.0) * 0.5) * 0.2, 0.0);
    float x = random(vec2(basePos.x, -basePos.x) + GameTime) - 0.5;
    float y = random(vec2(basePos.y, -basePos.y) - GameTime) - 0.5;
    float z = random(vec2(basePos.z, -basePos.z) + (GameTime * 0.5)) - 0.5;
    gl_Position = ProjMat * ModelViewMat * vec4(basePos + vec3(x,y,z) * delta, 1.0);

}
