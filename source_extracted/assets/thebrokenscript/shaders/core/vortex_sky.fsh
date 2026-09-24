#version 150

uniform vec4 FogColor;
uniform float RenderDistance;

uniform float uTime;
uniform float VortexSkyZoom;

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;

in vec3 vRayDir;
out vec4 fragColor;

#moj_import <thebrokenscript:simplex2d.glsl>

// shadertoy.com/view/NscXR8
vec3 vortex(vec2 skyCoords, float t, float color_strength) {
    vec3 p = vec3(skyCoords, 1.0);
    vec3 d = normalize(vec3(skyCoords, -1.0));
    vec3 c = vec3(0.0);
    float ix = 0.0;

    for (int n = 0; n < 80; n++) {
        p = c;
        ix += 0.01;
        p.z -= t + ix;
        p.z *= 0.1;

        vec4 s = sin(p.z + vec4(0.0, 11.0, 33.0, 0.0));
        mat2 rot = mat2(s.x, s.y, s.z, s.w);
        p.xy *= rot;

        c += length(sin(p.yx) + cos(p.xz + t)) * d;
    }

    vec3 voidPalette = vec3(0.45, 0.38, 0.48);
    vec3 redPalette = vec3(194, 0, 0) / 255 * 2;
    voidPalette = mix(redPalette,voidPalette,color_strength);


    vec3 col = voidPalette / max(length(c), 0.0001);
    col = pow(col, vec3(1.1));

    return col / (1.0 + col);
}

vec2 rotateUV(vec2 uv, float angle)
{
    uv -= 0.5;

    float s = sin(angle);
    float c = cos(angle);

    uv = mat2(
         c, -s,
         s,  c
    ) * uv;

    uv += 0.5;
    return uv;
}

void main() {
    vec3 ray = normalize(vRayDir);
    ray.xz *= VortexSkyZoom;

    vec2 sky = ray.xz / max(abs(ray.y) + 0.3, 0.001);

    float color_strength = length(
        vec2(abs(ray.x),abs(ray.z))
        );
    color_strength -= 0.1;
    color_strength = clamp(color_strength,0,1);
    //color_strength = pow(color_strength,3);
    color_strength = smoothstep(0.4,0.7,color_strength);
    vec3 col = vortex(sky, uTime * 0.15, color_strength);

    col *= smoothstep(0.05, 0.35, ray.y);

    col = pow(max(col, vec3(0.0)), vec3(1.0 / 2.2));

    float horizon = 1.0 - clamp(abs(ray.y), 0.0, 1.0);

    horizon = pow(horizon, 0.6);

    float fadeStart = RenderDistance * 0.65;
    float fadeEnd   = RenderDistance * 0.95;

    float pseudoDistance = horizon * RenderDistance;

    float fog = smoothstep(fadeStart, fadeEnd, pseudoDistance);

    fog = max(fog, smoothstep(0.3, 0.9, horizon));

    vec3 finalColor = mix(col, FogColor.rgb, fog);
    

    //float vortex_brightness = dot(finalColor, vec3(0.2126, 0.7152, 0.0722));
    float vortex_brightness = finalColor.r;
    vec2 tendril_uv = ray.xz / ray.y;
    tendril_uv /= 1.5;
    tendril_uv = ray.xz/2+0.5;
    float tendril_speed = 0.008;
    float tendril_scale = 5;
    float tendril_offset_strength = 70;
    
    vec4 tendril_texture = vec4(0.0);
    

    tendril_uv = vec2(
        tendril_uv.x + snoise(vec2(tendril_uv.x * tendril_scale, uTime * tendril_speed))/tendril_offset_strength * clamp(length(ray.xz),0,1),
        tendril_uv.y + snoise(vec2(tendril_uv.y * tendril_scale, uTime * tendril_speed))/tendril_offset_strength * clamp(length(ray.xz),0,1)
    );
    vec4 red_texture = texture(Sampler1, ray.xz/2+0.5, -0.5);
    finalColor = mix(finalColor, red_texture.rgb, red_texture.a * smoothstep(0.5, 0.8, ray.y) * (1.0 - fog));

    for (int i = 3; i >= 0; i--) {
            vec2 rotated_uv = rotateUV(
                tendril_uv,
                sin(uTime / 60.0 + float(i) * 1.42) * (float(i) + 1.0) / 2.0
            );

            vec2 uv = rotated_uv * vec2(1.0, 0.25) + vec2(0.0, float(i) * 0.25);
            vec4 temp_texture = textureGrad(
                Sampler0,
                uv,
                dFdx(rotated_uv) * vec2(1.0, 0.25),
                dFdy(rotated_uv) * vec2(1.0, 0.25)
            );

            tendril_texture = temp_texture + (1.0 - temp_texture.a) * tendril_texture;
        }

    if (ray.y > 0.0) {
        float alpha = smoothstep(0.01, 0.08, tendril_texture.a);
        float vortex_opacity = 0.9 * (1.0 - pow(vortex_brightness, 0.8));
        float horizonFade = 1.0 - horizon;
        float fogCut = 1.0 - fog;
        finalColor = mix(finalColor, tendril_texture.rgb, alpha * vortex_opacity * horizonFade * fogCut);
    }
    fragColor = vec4(finalColor, 1.0);
}