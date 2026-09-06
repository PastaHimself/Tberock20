#version 150

uniform sampler2D DiffuseSampler;
uniform sampler2D DiffuseDepthSampler;
uniform vec2 InSize;
uniform float Time;
uniform mat4 InverseTransformMatrix;
uniform vec3 HitPos;
uniform vec3 CameraPos;
uniform float RippleDelta;
uniform float Radius;
in vec4 vPosition;

in vec2 texCoord;
out vec4 fragColor;


vec3 pixelate(vec3 coord, ivec3 pixelate_resolution) {
    vec3 uv = vec3(coord.x, coord.y, coord.z);
    float x = round(uv.x * float(pixelate_resolution.x)) / float(pixelate_resolution.x);
    float y = round(uv.y * float(pixelate_resolution.y)) / float(pixelate_resolution.y);
    float z = round(uv.z * float(pixelate_resolution.z)) / float(pixelate_resolution.z);
    return vec3(x, y, z);
}

vec2 pixelate2D(vec2 coord, ivec2 pixelate_resolution) {
    vec2 uv = vec2(coord.x, coord.y);
    float x = round(uv.x * float(pixelate_resolution.x)) / float(pixelate_resolution.x);
    float y = round(uv.y * float(pixelate_resolution.y)) / float(pixelate_resolution.y);
    return vec2(x, y);
}

vec4 CalcEyeFromWindow(in float depth) {
    vec3 ndcPos;
    ndcPos.xy = ((2.0 * gl_FragCoord.xy)) / (InSize.xy) - 1;
    ndcPos.z = (2.0 * depth - gl_DepthRange.near - gl_DepthRange.far) / (gl_DepthRange.far - gl_DepthRange.near);
    vec4 clipPos = vec4(ndcPos, 1.);
    vec4 homogeneous = InverseTransformMatrix * clipPos;
    vec4 eyePos = vec4(homogeneous.xyz / homogeneous.w, homogeneous.w);
    return eyePos;
}
float random(vec2 co) {
    float a = 12.9898;
    float b = 78.233;
    float c = 43758.5453;
    float dt = dot(co.xy, vec2(a, b));
    float sn = mod(dt, 3.14);
    return fract(sin(sn) * c);
}
void main() {
    vec3 ndc = vPosition.xyz / vPosition.w; //perspective divide/normalize
    vec2 viewportCoord = ndc.xy * 0.5 + 0.5; //ndc is -1 to 1 in GL. scale for 0 to 1
    vec4 tex = vec4(texture(DiffuseSampler, viewportCoord).rgb, 1.0);
    float raw = texture(DiffuseDepthSampler, viewportCoord).r;
    vec3 pixelPosition = CalcEyeFromWindow(raw).xyz + CameraPos - HitPos;
    vec2 pixelViewport = pixelate2D(viewportCoord, ivec2(textureSize(DiffuseSampler, 0) * 0.0625));
    vec3 pos = pixelate(pixelPosition, ivec3(16));
    float dist = distance(pos, vec3(0.0));
    float mi = (Radius - 1.0) * RippleDelta;
    float mx = Radius * RippleDelta;
    if (dist > mi && dist < mx) fragColor = mix(texture(DiffuseSampler, pixelViewport + (random(pixelViewport + Time) - 0.5) * 0.05 * RippleDelta), tex, RippleDelta);
    else fragColor = tex;
}
