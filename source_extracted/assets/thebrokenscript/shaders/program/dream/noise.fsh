#version 150



uniform sampler2D DiffuseSampler;
uniform float Time;

in vec2 texCoord;
out vec4 fragColor;

float hash31(vec3 p)
{
    p = fract(p * 0.1031);
    p += dot(p, p.yzx + 33.33);
    return fract((p.x + p.y) * p.z);
}

float screen_noise(float strength, float scale, float time) {
    float noise = hash31(vec3(round(gl_FragCoord.xy / scale),time));
    noise -= 0.5;

    return (noise * strength) + 1;
}

vec2 barrelDistortion(vec2 uv)
{   
    float distortion = -0.125;
    vec2 centered = uv * 2.0 - 1.0; // [-1,1] space
    float r = dot(centered, centered);
    centered *= 1.0 + distortion * r;
    return centered * 0.5 + 0.5; // back to [0,1]
}

vec2 scaleUV(vec2 uv, float scale)
{
    scale = 1/scale;
    // scale > 1.0 zooms in, scale < 1.0 zooms out
    return (uv - 0.5) * scale + 0.5;
}


//pre blur
void main()
{

    // yeah that's literally it lmao. just to mess with the blur algorithm.


    //fragColor = texture(DiffuseSampler,texCoord) * vec4(vec3(screen_noise(0.5,4,GameTime)),1.0);

    vec2 uv = texCoord;
    uv = barrelDistortion(uv);
    uv = scaleUV(uv, 1.2);
    fragColor = vec4(texture(DiffuseSampler,uv).rgb, 1.0);
    fragColor.rgb *= vec3(screen_noise(0.2,8,floor(Time*2400)));
    if (uv.x < 0) fragColor = vec4(0,0,0,1);
    if (uv.x > 1) fragColor = vec4(0,0,0,1);
    if (uv.y < 0) fragColor = vec4(0,0,0,1);
    if (uv.y > 1) fragColor = vec4(0,0,0,1);

}