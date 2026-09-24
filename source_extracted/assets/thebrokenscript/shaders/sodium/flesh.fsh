#version 150

uniform float u_GameTime;
uniform mat4 u_ProjectionMatrix;
uniform mat4 u_ModelViewMatrix;
uniform vec3 cameraPos;

in vec3 pos;
in vec4 vClipPos;

#import <thebrokenscript:include/cool.glsl>

out vec4 fragColor;

void main() {
    vec3 rayOrigin = cameraPos;
    rayOrigin.xy = vec2(0.0, 1.0);
    vec2 ndc = vClipPos.xy / vClipPos.w;

    mat4 inverseViewMatrix = inverse(u_ProjectionMatrix * u_ModelViewMatrix);
    vec4 nearProjection = inverseViewMatrix * vec4(ndc, -1.0, 1.0);
    vec4 farProjection  = inverseViewMatrix * vec4(ndc,  1.0, 1.0);

    nearProjection /= nearProjection.w;
    farProjection  /= farProjection.w;

    vec3 rayDir = normalize(farProjection.xyz - nearProjection.xyz);

    rayDir.xz *= -1.0;

    fragColor = biomineShader(rayOrigin, rayDir, u_GameTime * 1200);
}