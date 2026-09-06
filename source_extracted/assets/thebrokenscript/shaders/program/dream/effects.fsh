#version 150



uniform sampler2D DiffuseSampler;
//uniform sampler2D LUTSampler; big sad. i can't use this! damn old ass version

uniform float Time;

in vec2 texCoord;
out vec4 fragColor;


// pixel modification things
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


    vec3 adjustVibrance(vec3 color, float strength) {
        float avg = (color.r + color.g + color.b) / 3.0;  // Average brightness
        vec3 intensity = vec3(avg);
        return mix(intensity, color, strength);  // Strength affects less saturated areas more

    }

    vec3 adjustContrast(vec3 color, float contrast) {
        return 0.5 + (color - 0.5) * contrast;
    }

    vec3 adjustSaturation(vec3 color, float saturation) {
        float gray = dot(color, vec3(0.2126, 0.7152, 0.0722));  // Grayscale
        return mix(vec3(gray), color, saturation);
    }
    float findBrightness(vec3 color) {
        return dot(color.rgb, vec3(0.2126, 0.7152, 0.0722));
    }

    vec3 adjustExposure(vec3 color, float exposure) {
        return clamp(color * exposure, 0.0, 1.0);
    }

    vec3 posterize(vec3 color, int levels) {
        float step = 1.0 / float(levels - 1);
        return clamp(floor(color / step) * step, 0.0, 1.0);
    }


// tv effect stuff

    // good lord that's a lot of input things. yeah this is chatgpt CORRECTED mainly coded by me
    vec3 applyScanlines(
        vec2 uv,               // Normalized UV coordinates (0.0–1.0)
        float time,            // Time value (in seconds)
        float scanSpeedAdd,    // Speed multiplier for animation
        float lineCut,         // Controls scanline thickness
        float whiteIntensity,  // Intensity of white component
        float anaglyphIntensity, // Intensity of RGB separation
        vec3 col_r,            // Anaglyph right color
        vec3 col_l             // Anaglyph left color
    ) {
        vec2 uv_right = uv + vec2(0.01);
        vec2 uv_left  = uv - vec2(0.01);

        float scanSpeed = (fract(time) * 2.5 / 40.0) * scanSpeedAdd;

        vec3 scanlines       = vec3(1.0) * abs(cos((uv.y + scanSpeed) * 100.0)) - lineCut;
        vec3 scanlines_right = col_r * abs(cos((uv_right.y + scanSpeed) * 100.0)) - lineCut;
        vec3 scanlines_left  = col_l * abs(cos((uv_left.y  + scanSpeed) * 100.0)) - lineCut;

        return
            smoothstep(0.1, 0.7, scanlines       * whiteIntensity) +
            smoothstep(0.1, 0.7, scanlines_right * anaglyphIntensity) +
            smoothstep(0.1, 0.7, scanlines_left  * anaglyphIntensity);
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


// rest of it; post blur
void main()
{

    vec2 uv = texCoord;
    uv = barrelDistortion(uv);
    uv = scaleUV(uv, 1.2);

    

    vec3 scanlineEffect = applyScanlines(
        uv,
        Time,
        0.75,         // scanSpeedAdd
        0.1,         // lineCut
        0.4,         // whiteIntensity
        0.2,         // anaglyphIntensity
        vec3(0.0, 1.0, 1.0), // col_r
        vec3(1.0, 0.0, 0.0)  // col_l
    );

    vec2 chrom_r_dir = vec2(0.00125,0.0);
    vec2 chrom_g_dir = vec2(-0.00125,0.0);
    vec2 chrom_b_dir = vec2(0.0,0.0);

    
    
    // figure it out as i go. please dont crash please dont crash please dont crash please dont crash please dont crash please dont crash please dont crash please dont crash please dont crash please dont crash 
    fragColor = vec4(
        texture(DiffuseSampler,texCoord+chrom_r_dir).r,
        texture(DiffuseSampler,texCoord+chrom_g_dir).g,
        texture(DiffuseSampler,texCoord+chrom_b_dir).b,
        1.0
    );

    fragColor.rgb = adjustSaturation(fragColor.rgb,0.8);
    fragColor.rgb = adjustExposure(fragColor.rgb,1.2);
    fragColor.rgb = adjustContrast(fragColor.rgb,1.2);

    fragColor.rgb *= vec3(screen_noise(0.2,2,floor(Time*3600)));


    if (uv.x < 0) scanlineEffect = vec3(0);
    if (uv.x > 1) scanlineEffect = vec3(0);
    if (uv.y < 0) scanlineEffect = vec3(0);
    if (uv.y > 1) scanlineEffect = vec3(0);
    fragColor.rgb += scanlineEffect * 0.05;

}

