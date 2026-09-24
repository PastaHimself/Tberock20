#version 150

uniform sampler2D DiffuseSampler;
uniform sampler2D DiffuseDepthSampler;
uniform vec2 InSize;
uniform float T;
uniform mat4 InverseTransformMatrix;
uniform vec3 CameraPos;
uniform vec3 MinBounds;
uniform vec3 MaxBounds;
in vec4 vPosition;

in vec2 texCoord;
out vec4 fragColor;


vec3 pixelate(vec3 coord, ivec3 pixelate_resolution, in float depth) {
    vec3 uv = vec3(coord.x, coord.y, coord.z);
    float x = floor((uv.x + 0.005) * float(pixelate_resolution.x)) / float(pixelate_resolution.x);
    float y = floor((uv.y + 0.005) * float(pixelate_resolution.y)) / float(pixelate_resolution.y);
    float z = floor((uv.z + 0.005) * float(pixelate_resolution.z)) / float(pixelate_resolution.z);

    return vec3(x, y, z);
}

float pixelate_num(float coord, int pixelate_resolution) {
    float x = floor(coord * float(pixelate_resolution)) / float(pixelate_resolution);
    return x;
}


//	Simplex 4D Noise
//	by Ian McEwan, Stefan Gustavson (https://github.com/stegu/webgl-noise)
//
vec4 permute(vec4 x){return mod(((x*34.0)+1.0)*x, 289.0);}
float permute(float x){return floor(mod(((x*34.0)+1.0)*x, 289.0));}
vec4 taylorInvSqrt(vec4 r){return 1.79284291400159 - 0.85373472095314 * r;}
float taylorInvSqrt(float r){return 1.79284291400159 - 0.85373472095314 * r;}

vec4 grad4(float j, vec4 ip){
    const vec4 ones = vec4(1.0, 1.0, 1.0, -1.0);
    vec4 p,s;

    p.xyz = floor( fract (vec3(j) * ip.xyz) * 7.0) * ip.z - 1.0;
    p.w = 1.5 - dot(abs(p.xyz), ones.xyz);
    s = vec4(lessThan(p, vec4(0.0)));
    p.xyz = p.xyz + (s.xyz*2.0 - 1.0) * s.www;

    return p;
}

float snoise(vec4 v){
    const vec2  C = vec2( 0.138196601125010504,  // (5 - sqrt(5))/20  G4
        0.309016994374947451); // (sqrt(5) - 1)/4   F4
    // First corner
    vec4 i  = floor(v + dot(v, C.yyyy) );
    vec4 x0 = v -   i + dot(i, C.xxxx);

    // Other corners

    // Rank sorting originally contributed by Bill Licea-Kane, AMD (formerly ATI)
    vec4 i0;

    vec3 isX = step( x0.yzw, x0.xxx );
    vec3 isYZ = step( x0.zww, x0.yyz );
    //  i0.x = dot( isX, vec3( 1.0 ) );
    i0.x = isX.x + isX.y + isX.z;
    i0.yzw = 1.0 - isX;

    //  i0.y += dot( isYZ.xy, vec2( 1.0 ) );
    i0.y += isYZ.x + isYZ.y;
    i0.zw += 1.0 - isYZ.xy;

    i0.z += isYZ.z;
    i0.w += 1.0 - isYZ.z;

    // i0 now contains the unique values 0,1,2,3 in each channel
    vec4 i3 = clamp( i0, 0.0, 1.0 );
    vec4 i2 = clamp( i0-1.0, 0.0, 1.0 );
    vec4 i1 = clamp( i0-2.0, 0.0, 1.0 );

    //  x0 = x0 - 0.0 + 0.0 * C
    vec4 x1 = x0 - i1 + 1.0 * C.xxxx;
    vec4 x2 = x0 - i2 + 2.0 * C.xxxx;
    vec4 x3 = x0 - i3 + 3.0 * C.xxxx;
    vec4 x4 = x0 - 1.0 + 4.0 * C.xxxx;

    // Permutations
    i = mod(i, 289.0);
    float j0 = permute( permute( permute( permute(i.w) + i.z) + i.y) + i.x);
    vec4 j1 = permute( permute( permute( permute (
        i.w + vec4(i1.w, i2.w, i3.w, 1.0 ))
    + i.z + vec4(i1.z, i2.z, i3.z, 1.0 ))
    + i.y + vec4(i1.y, i2.y, i3.y, 1.0 ))
    + i.x + vec4(i1.x, i2.x, i3.x, 1.0 ));
    // Gradients
    // ( 7*7*6 points uniformly over a cube, mapped onto a 4-octahedron.)
    // 7*7*6 = 294, which is close to the ring size 17*17 = 289.

    vec4 ip = vec4(1.0/294.0, 1.0/49.0, 1.0/7.0, 0.0) ;

    vec4 p0 = grad4(j0,   ip);
    vec4 p1 = grad4(j1.x, ip);
    vec4 p2 = grad4(j1.y, ip);
    vec4 p3 = grad4(j1.z, ip);
    vec4 p4 = grad4(j1.w, ip);

    // Normalise gradients
    vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));
    p0 *= norm.x;
    p1 *= norm.y;
    p2 *= norm.z;
    p3 *= norm.w;
    p4 *= taylorInvSqrt(dot(p4,p4));

    // Mix contributions from the five corners
    vec3 m0 = max(0.6 - vec3(dot(x0,x0), dot(x1,x1), dot(x2,x2)), 0.0);
    vec2 m1 = max(0.6 - vec2(dot(x3,x3), dot(x4,x4)            ), 0.0);
    m0 = m0 * m0;
    m1 = m1 * m1;
    return 49.0 * ( dot(m0*m0, vec3( dot( p0, x0 ), dot( p1, x1 ), dot( p2, x2 )))
    + dot(m1*m1, vec2( dot( p3, x3 ), dot( p4, x4 ) ) ) ) ;

}

vec4 CalcEyeFromWindow(in float depth) {
    vec3 ndcPos;
    ndcPos.xy = ((2.0 * gl_FragCoord.xy)) / (InSize.xy) - 1;
    ndcPos.z = (2.0 * depth - gl_DepthRange.near - gl_DepthRange.far) / (gl_DepthRange.far - gl_DepthRange.near);
    vec4 clipPos = vec4(ndcPos, 0.999999);
    vec4 homogeneous = InverseTransformMatrix * clipPos;
    vec4 eyePos = vec4(homogeneous.xyz / homogeneous.w, homogeneous.w);
    return eyePos;
}
#define inUpperRange(p, c) p >= MaxBounds.c - 0.9999 && p <= MaxBounds.c
#define inLowerRange(p, c) p <= MinBounds.c + 0.9999 && p >= MinBounds.c
#define inRange(p, c) p > MinBounds.c && p < MaxBounds.c
#define inInnerRange(p, c) p >= MinBounds.c + 0.9999 && p <= MaxBounds.c - 0.9999

const vec4 black = vec4(vec3(0.0), 1.0);

vec4 getCol(in vec3 pos, in vec4 tex) {
    if (inInnerRange(pos.x, x) && inInnerRange(pos.y, y) && inInnerRange(pos.z, z)) {
        return tex;
    } else if (inRange(pos.x, x) && inRange(pos.y, y) && inRange(pos.z, z)) {
        vec3 size = MaxBounds - MinBounds;
        vec3 fractPos = vec3(1.0) - fract(pos);
        float n = (snoise(vec4(pos + T, T))) ;
        float n1 = (snoise(vec4(-pos + n * 2.5 - T, T))) * 0.5 + 0.5;
        float n2 = (snoise(vec4(pos * 0.5 + n1 - T, T))) * 0.5 + 0.5;
        bool lx = inLowerRange(pos.x, x);
        bool ly = inLowerRange(pos.y, y);
        bool lz = inLowerRange(pos.z, z);
        bool ux = inUpperRange(pos.x, x);
        bool uy = inUpperRange(pos.y, y);
        bool uz = inUpperRange(pos.z, z);
        vec4 color = tex;
        if (lx || ly || lz) fractPos = fract(pos);
        if (uz && lx || uz && ly) fractPos.z = 1.0 - fractPos.z;
        if (lz && ux || ux && ly) fractPos.x = 1.0 - fractPos.x;
        if ((lz || lx) && uy) fractPos.y = 1.0 - fractPos.y;
        if ((n2 - fractPos.x) > 0.0 && lx != ux) color = black;
        if ((n2 - fractPos.y) > 0.0 && ly != uy) color = black;
        if ((n2 - fractPos.z) > 0.0 && lz != uz) color = black;
        return color;
    } else return black;
}


void main()
{
    vec3 ndc = vPosition.xyz / vPosition.w; //perspective divide/normalize
    vec2 viewportCoord = ndc.xy * 0.5 + 0.5; //ndc is -1 to 1 in GL. scale for 0 to 1

    vec4 tex = vec4(texture(DiffuseSampler, viewportCoord).rgb, 1.0);
    float raw = texture(DiffuseDepthSampler, viewportCoord).r;
    if (raw < 0.99999) {
        vec3 pixelPosition = CalcEyeFromWindow(raw).xyz + CameraPos;
        vec3 pos = pixelate(pixelPosition, ivec3(16), raw);
        fragColor = getCol(pos, tex);
    } else fragColor = tex;


}
