#version 150

uniform sampler2D DiffuseSampler;


in vec2 texCoord;
out vec4 fragColor;

vec3 kawaseBlur4Tap(sampler2D s, vec2 uv, float offsetStep)
{   
    vec2 texel = 1.0 / textureSize(s, 0);
    vec2 off = texel * (offsetStep + 0.5); // +0.5 gives centre between texels

    vec3 c  = texture(s, uv +  off).rgb;
         c += texture(s, uv + vec2(-off.x,  off.y)).rgb;
         c += texture(s, uv -  off).rgb;
         c += texture(s, uv + vec2( off.x, -off.y)).rgb;

    return c * 0.25;                       // average the four gathers
}

void main()
{

    //remember: vec3 kawaseBlur4Tap(sampler2D s, vec2 uv, float offsetStep)
    fragColor = vec4(1.0);
    fragColor.rgb = kawaseBlur4Tap(DiffuseSampler, texCoord, 2);

}