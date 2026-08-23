#version 150

uniform sampler2D DiffuseSampler;
uniform sampler2D DepthSampler;
uniform sampler2D OldDepthSampler;

in vec2 texCoord;
out vec4 fragColor;

void main()
{
    // get depth difference
    // multiple 1 - diff against main colour

    float diff = texture(DepthSampler,texCoord).r - texture(OldDepthSampler,texCoord).r;
    diff = 1 - abs(diff);
    diff = pow(diff,3);

    diff = clamp(diff,0,1);

    fragColor = vec4(texture(DiffuseSampler,texCoord).rgb, 1.0);
    fragColor.rgb = mix(
        fragColor.rgb,
        fragColor.rgb * diff,
        0.4
    ); // mix value is the strength of effect compared to just.... not having it active

}