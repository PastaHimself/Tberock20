#version 150

#moj_import <matrix.glsl>

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;

uniform float GameTime;
uniform int EndPortalLayers;
uniform vec2 ScreenSize;
uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

in vec4 texProj0;
in mat4 inverseViewMatrix;

const mat4 SCALE_TRANSLATE = mat4(
    0.5, 0.0, 0.0, 0.25,
    0.0, 0.5, 0.0, 0.25,
    0.0, 0.0, 1.0, 0.0,
    0.0, 0.0, 0.0, 1.0
);

float hash(float n) {
    return fract(sin(n) * 43758.5453123);
}

float hash2(vec2 p) {
    return fract(sin(dot(p, vec2(12.9898, 78.233))) * 43758.5453123);
}

struct CubeData {
    vec3 pos;
    float size;
    float brightness;
    bool visible;
};
vec2 pixelate(vec2 coord, ivec2 pixelate_resolution) {
    vec2 uv = vec2(coord.x, coord.y);
    float x = floor(uv.x * float(pixelate_resolution.x)) / float(pixelate_resolution.x);
    float y = floor(uv.y * float(pixelate_resolution.y)) / float(pixelate_resolution.y);
    return vec2(x, y);
}

CubeData cubeCache[16];
int visibleCubeCount = 0;

void precomputeCubes(float timeSpeed) {
    visibleCubeCount = 0;
    int maxCubes = min(EndPortalLayers, 16);

    for (int i = 0; i < maxCubes; i++) {
        float id = float(i);

        float visibilityGlitch = hash(floor(timeSpeed * 0.5 + id * 7.3));
        if (visibilityGlitch > 0.65) {
            continue;
        }

        float cubeTime = timeSpeed;

        float speed = 1.5 + hash(id * 1.234) * 5.0;
        float radius = 2.0 + hash(id * 2.345) * 3.0;
        float angle = cubeTime * speed + hash(id * 3.456) * 6.28;

        // Precompute position
        float heightOscillate = sin(cubeTime * speed * 1.5 + id * 2.1) * 3.0;
        cubeCache[visibleCubeCount].pos = vec3(
            cos(angle) * radius,
            heightOscillate,
            sin(angle) * radius
        );

        cubeCache[visibleCubeCount].size = 0.15 + hash(id * 5.678) * 0.15;
        cubeCache[visibleCubeCount].brightness = 0.5 + 0.5 * abs(sin(id * 2.5 + GameTime * 15.0));
        cubeCache[visibleCubeCount].visible = true;

        visibleCubeCount++;
    }
}

float sdCubeFast(vec3 p, float size) {
    vec3 d = abs(p) - size;
    return min(max(d.x, max(d.y, d.z)), 0.0) + length(max(d, 0.0));
}

float sceneSDF(vec3 p, out int cubeId) {
    float minDist = 1000.0;
    cubeId = -1;

    for (int i = 0; i < visibleCubeCount; i++) {
        vec3 localP = p - cubeCache[i].pos;
        float dist = sdCubeFast(localP, cubeCache[i].size);

        if (dist < minDist) {
            minDist = dist;
            cubeId = i;
        }
    }

    return minDist;
}

out vec4 fragColor;

void main() {
    vec2 uvOld = texProj0.xy / texProj0.w;
    vec2 uv = pixelate(gl_FragCoord.xy/ScreenSize, ivec2(ScreenSize / 8.0));
    uv = uv * 2.0 - 1.0;
    uvOld = uvOld * 2.0 - 1.0;
    uvOld = pixelate(uvOld, ivec2(ScreenSize / 8.0));
    vec4 nearProjection = inverseViewMatrix * vec4(uv, 0.0, 1.0);
    vec4 farProjection  = inverseViewMatrix * vec4(uv, 1.0, 1.0);
    nearProjection /= nearProjection.w;
    farProjection  /= farProjection.w;

    float timeSpeed = GameTime * 35.0;
    precomputeCubes(timeSpeed);

    if (visibleCubeCount == 0) {
        fragColor = vec4(vec3(0.68), 1.0);
        return;
    }

    vec3 rayOrigin = nearProjection.xyz;
    vec3 rayDir = normalize(farProjection.xyz - nearProjection.xyz);

    float t = 0.0;
    int hitCubeId = -1;
    bool hit = false;

    for (int i = 0; i < 16; i++) {
        vec3 p = rayOrigin + rayDir * t;
        int cubeId;
        float d = sceneSDF(p, cubeId);

        if (d < 0.01) {
            hitCubeId = cubeId;
            hit = true;
            break;
        }

        t += d * 0.75;

        if (t > 15.0) break;
    }

    vec3 finalColor = vec3(1.0);

    if (hit && hitCubeId >= 0) {
        vec3 hitPos = rayOrigin + rayDir * t;

        float brightness = 1.0 - smoothstep(0.0, 15.0, t);
        brightness *= cubeCache[hitCubeId].brightness;

        float fakeDiffuse = (hitPos.y + 3.0) / 6.0;
        brightness *= 0.4 + 0.6 * fakeDiffuse;

        float surfaceStatic = hash2(hitPos.xy * 10.0 + GameTime * 5.0);
        brightness = mix(brightness, surfaceStatic, 0.15);

        finalColor = vec3(brightness);
    }

    float grainValue = hash2(uv + GameTime);
    finalColor += (grainValue - 0.5) * 0.15;

    if (fract(uvOld.y * 50.0 + (GameTime * 50.0)) > 0.9) {
        finalColor *= 0.8;
    }

    float vignette = 1.0 - length(uvOld) * 0.3;
    finalColor *= vignette;

    finalColor = clamp(finalColor, 0.0, 1.0);

    fragColor = vec4(finalColor, 1.0);
}