#version 150

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    // right now, this shouldn't do anything. soon(TM) i will do things :3
    vec3 color = texture(DiffuseSampler, texCoord).rgb;

    fragColor = vec4(color, 1.0);
}
