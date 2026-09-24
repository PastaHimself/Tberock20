
// yeah a solid amount was chatGPT (mainly to fix the non-functioning code)

vec3 access_lut(vec3 color, vec2 texture_size, sampler2D lutTex)
{
    const float N = 16.0;                 // LUT_COUNT
    vec2  tileSize   = texture_size / N;  // 256×256 if tex = 4096×4096

    // --- 1. blue slice → tile column/row -------------------------------
    float bIdx = color.b * (N * N - 1.0); // 0-255
    float bx   = mod(bIdx, N);            // 0-15
    float by   = floor(bIdx / N);         // 0-15

    // --- 2. red/green indices inside that tile -------------------------
    float rIdx = color.r * (N - 1.0);     // 0-15
    float gIdx = color.g * (N - 1.0);     // 0-15

    // --- 3. CORRECTED: Compute step size accounting for tile boundaries ---
    float stepX = (tileSize.x - 1.0) / (N - 1.0); // Adjusted step
    float stepY = (tileSize.y - 1.0) / (N - 1.0);

    vec2 uvPix = vec2(
        bx * tileSize.x + rIdx * stepX,
        by * tileSize.y + gIdx * stepY
    ) + 0.5; // centre of the texel

    vec2 uv    = uvPix / texture_size;    // normalised 0-1 coords

    return texture(lutTex, uv).rgb;
}


// texel = 1.0 / textureSize(s, 0);
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



// tv effect stuff
vec2 barrelDistortion(vec2 uv)
{   
    float distortion = 0.2;
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

float hash21(vec2 p)
{
    p = fract(p * vec2(123.34, 456.21));
    p += dot(p, p + 45.32);
    return fract(p.x * p.y);
}

float hash31(vec3 p)
{
    p = fract(p * 0.1031);
    p += dot(p, p.yzx + 33.33);
    return fract((p.x + p.y) * p.z);
}

float screen_noise(float strength, float scale, float time) {
    hash31(vec3(round(gl_FragCoord.xy / scale),time));
    noise -= 0.5;

    return (noise / strength) + 1;
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
