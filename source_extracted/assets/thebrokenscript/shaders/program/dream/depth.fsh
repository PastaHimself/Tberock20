#version 150

uniform sampler2D DiffuseDepthSampler;

in vec2 texCoord;
out vec4 fragColor;

float near = 0.05;
float far  = 128.0;

float LinearizeDepth(float depth)
{
    float z = depth * 2.0 - 1.0; // Back to NDC
    return (near * far) / (far + near - z * (far - near));
}

float readLinearDepth(sampler2D tex)
{
    float raw = texture(tex, texCoord).r;
    // Treat skybox (raw depth of 1.0) as max distance
    if (raw >= 0.999999) return far;
    return LinearizeDepth(raw);
}

void main()
{
    float d = readLinearDepth(DiffuseDepthSampler) / far;
    d = clamp(d, 0.0, 1.0);

    d = smoothstep(0.0, 1.0, d);

    float closestDepth = pow(1.0 - d, 7.0);

    fragColor = vec4(vec3(closestDepth), 1.0);
}