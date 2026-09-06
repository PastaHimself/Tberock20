#version 150
#moj_import <thebrokenscript:cool.glsl>
uniform float GameTime;
uniform vec2 ScreenSize;
uniform vec3 cameraPos;

uniform mat4 ProjMat;
uniform mat4 ModelViewMat;

in vec2 texCoord0;
in vec2 texCoord1;
in vec3 pos;

in vec4 vClipPos;
out vec4 fragColor;

void main() {
    vec2 ndc = vClipPos.xy / vClipPos.w;
    mat4 inverseViewMatrix = inverse(ProjMat * ModelViewMat);

    vec4 nearProjection = inverseViewMatrix * vec4(ndc, -1.0, 1.0);
    vec4 farProjection  = inverseViewMatrix * vec4(ndc,  1.0, 1.0);

    nearProjection /= nearProjection.w;
    farProjection  /= farProjection.w;

    vec3 rayOrigin = cameraPos;
    rayOrigin.xy = vec2(0.0, 1.0);
    vec3 rayDir = normalize(farProjection.xyz - nearProjection.xyz);

    rayDir.xz *= -1.0;

    fragColor = biomineShader(rayOrigin, rayDir, GameTime * 1200);
}