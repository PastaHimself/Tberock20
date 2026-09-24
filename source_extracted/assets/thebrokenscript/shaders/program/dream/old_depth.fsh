#version 150

uniform sampler2D DiffuseSampler; // main depth
uniform sampler2D OldDepthSampler; // self explanatory

in vec2 texCoord;
out vec4 fragColor;

void main() {
    fragColor = vec4(1);
    //fragColor.rgb = (texture(DiffuseSampler,texCoord).rgb*2 + texture(OldDepthSampler,texCoord).rgb) / 3;
    float current_weight = 1;
    float old_weight = 4;
    fragColor.rgb = (
        texture(DiffuseSampler,texCoord).rgb * current_weight + 
        texture(OldDepthSampler,texCoord).rgb * old_weight
        ) / (current_weight + old_weight);
}