#version 150

uniform float GameTime;
uniform float FancyRendering;

in vec3 fragPos;
out vec4 fragColor;

float hash1(float n) {
    return fract(sin(n) * 43758.5453123);
}

float hash1b(float n) {
    return fract(cos(n * 0.7231) * 31758.1453);
}

vec4 starFieldWithColor(vec3 dir) {
    vec3 p = dir * 55.0;
    float ix = floor(p.x);
    float iy = floor(p.y);
    float iz = floor(p.z);
    float fx = fract(p.x) - 0.5;
    float fy = fract(p.y) - 0.5;
    float fz = fract(p.z) - 0.5;
    float n = hash1(dot(vec3(ix, iy, iz), vec3(12.9898, 78.233, 37.719)));
    if (n < 0.95) return vec4(0.0);
    float dist = sqrt(fx*fx + fy*fy + fz*fz);
    float star = smoothstep(0.07, 0.0, dist) * n * 10.0;
    // Color inline — no second floor/hash call
    vec3 col = vec3(1.0);
    if (n < 0.15) col = vec3(0.6, 0.7, 1.0);
    else if (n < 0.25) col = vec3(1.0, 0.85, 0.6);
    else if (n < 0.30) col = vec3(1.0, 0.5, 0.3);
    return vec4(col, star);
}

float milkyWay(vec3 dir) {
    float gx = dir.x * 0.8 + dir.y * 0.5 + dir.z * 0.3;
    float gy = -dir.x * 0.5 + dir.y * 0.7 - dir.z * 0.5;
    float gz = dir.z * 0.8 - dir.x * 0.1 + dir.y * 0.3;
    float len = sqrt(gx*gx + gy*gy + gz*gz);
    float sinLat = gy / len;
    float band = exp(-sinLat * sinLat * 18.0);
    float angle = atan(gz, gx);
    float streak1 = exp(-abs(sin(angle * 3.0 + 1.2 + sin(GameTime * 5 + sinLat) )) * 4.0) * 0.4;
    float streak2 = exp(-abs(sin(angle * 5.0 - 0.8 + sin(GameTime * 5 + sinLat))) * 6.0) * 0.25;
    float streak3 = exp(-abs(sin(angle * 2.0 + 2.5 + sin(GameTime * 5 + sinLat))) * 3.0) * 0.3;
    float dust1 = 1.0 - 0.6 * exp(-abs(sin(angle * 4.0 + 0.3 + sin(GameTime * 5 + sinLat))) * 8.0) * band;
    float dust2 = 1.0 - 0.4 * exp(-abs(sin(angle * 7.0 - 1.1 + sin(GameTime * 5 + sinLat))) * 10.0) * band;
    float mw = (band + streak1 + streak2 + streak3) * dust1 * dust2;
    return clamp(mw, 0.0, 1.0) * min((1.0 - sinLat) * 64.0, 1.0);
}

vec3 renderGalaxy(vec3 dir, vec3 galaxyDir, float size, float rotation, vec3 color) {
    float d = dot(dir, galaxyDir);
    if (d < 0.0) return vec3(0.0);
    float dist = length(dir - galaxyDir);
    if (dist > size * 3.0) return vec3(0.0);
    vec3 proj = dir - d * galaxyDir;
    float cosA = cos(rotation);
    float sinA = sin(rotation);
    float px = dot(proj, vec3(1.0, 0.0, 0.0));
    float py = dot(proj, vec3(0.0, 1.0, 0.0));
    float rx = px * cosA - py * sinA;
    float ry = px * sinA + py * cosA;
    float ellipse = sqrt(rx*rx + (ry * 2.5)*(ry * 2.5));
    float core = exp(-ellipse / (size * 0.15)) * 1.5;
    float disk = exp(-ellipse / (size * 0.6)) * 0.5;
    float angle = atan(ry, rx);
    float armA = exp(-abs(sin(angle * 2.0 - ellipse * 8.0)) * 2.0) * disk * 0.8;
    float armB = exp(-abs(sin(angle * 2.0 - ellipse * 8.0 + 3.14159)) * 2.0) * disk * 0.8;
    float brightness = core + disk + armA + armB;
    brightness *= smoothstep(size * 3.0, size * 0.5, dist);
    return color * brightness;
}

vec3 renderNebula(vec3 dir, vec3 nebulaDir, float size, vec3 color) {
    float dist = length(dir - nebulaDir);
    if (dist > size * 2.5) return vec3(0.0);
    float nx = dir.x - nebulaDir.x;
    float ny = dir.y - nebulaDir.y;
    float nz = dir.z - nebulaDir.z;
    float cx = floor(nx * 80.0 / size);
    float cy = floor(ny * 80.0 / size);
    float cz = floor(nz * 80.0 / size);
    float noise = hash1(cx + cy * 41.0 + cz * 73.0) * 0.5
                + hash1b(cx * 2.0 + cy * 83.0 + cz * 37.0) * 0.5;
    float blob = exp(-dist * dist / (size * size * 0.3));
    float wisp = exp(-dist * dist / (size * size * 1.2)) * 0.4;
    return color * (blob * noise + wisp) * 0.6;
}

float raySphere(vec3 ro, vec3 rd, vec3 center, float radius) {
    vec3 oc = ro - center;
    float b = dot(oc, rd);
    float c = dot(oc, oc) - radius * radius;
    float disc = b * b - c;
    if (disc < 0.0) return -1.0;
    float sqrtDisc = sqrt(disc);
    float t = -b - sqrtDisc;
    if (t > 0.0) return t;
    return -1.0;
}

float rayDisk(vec3 ro, vec3 rd, vec3 center, vec3 normal, float rMin, float rMax) {
    float denom = dot(rd, normal);
    if (abs(denom) < 0.0001) return -1.0;
    float t = dot(center - ro, normal) / denom;
    if (t < 0.0) return -1.0;
    vec3 hit = ro + t * rd;
    float d = length(hit - center);
    if (d < rMin) return -1.0;
    if (d > rMax) return -1.0;
    return t;
}

float computeNoise3(vec3 p) {
    float ix = floor(p.x);
    float iy = floor(p.y);
    float iz = floor(p.z);
    float fx = fract(p.x);
    float fy = fract(p.y);
    float fz = fract(p.z);
    fx = fx * fx * (3.0 - 2.0 * fx);
    fy = fy * fy * (3.0 - 2.0 * fy);
    fz = fz * fz * (3.0 - 2.0 * fz);
    float n000 = hash1(ix        + iy * 157.0         + iz * 113.0);
    float n100 = hash1(ix + 1.0  + iy * 157.0         + iz * 113.0);
    float n010 = hash1(ix        + (iy + 1.0) * 157.0 + iz * 113.0);
    float n110 = hash1(ix + 1.0  + (iy + 1.0) * 157.0 + iz * 113.0);
    float n001 = hash1(ix        + iy * 157.0         + (iz + 1.0) * 113.0);
    float n101 = hash1(ix + 1.0  + iy * 157.0         + (iz + 1.0) * 113.0);
    float n011 = hash1(ix        + (iy + 1.0) * 157.0 + (iz + 1.0) * 113.0);
    float n111 = hash1(ix + 1.0  + (iy + 1.0) * 157.0 + (iz + 1.0) * 113.0);
    float x00 = mix(n000, n100, fx);
    float x10 = mix(n010, n110, fx);
    float x01 = mix(n001, n101, fx);
    float x11 = mix(n011, n111, fx);
    float y0  = mix(x00, x10, fy);
    float y1  = mix(x01, x11, fy);
    return mix(y0, y1, fz);
}

float fbm(vec3 p) {
    float v = 0.0;
    float a = 0.5;
    vec3 shift = vec3(1.7, 9.2, 3.4);
    for (int i = 0; i < 5; i++) {
        v += a * computeNoise3(p);
        p = p * 2.1 + shift;
        a *= 0.5;
    }
    return v;
}

float fbmFast(vec3 p) {
    float v = 0.0;
    float a = 0.5;
    vec3 shift = vec3(1.7, 9.2, 3.4);
    for (int i = 0; i < 3; i++) { // 3 instead of 5
        v += a * computeNoise3(p);
        p = p * 2.1 + shift;
        a *= 0.5;
    }
    return v;
}

vec4 renderEarth(vec3 ro, vec3 rd)
{
    vec3 center = normalize(vec3(0.0, 0.1, -1.0)) * 3.5;
    float radius = 0.80;

    float tPlanet = raySphere(ro, rd, center, radius);
    if (tPlanet < 0.0) return vec4(0.0);

    vec3 hitPos = ro + tPlanet * rd;

    vec3 sphereNormal = normalize(hitPos - center);
    vec3 normal = sphereNormal;

    float time = GameTime * 1200.0 * 0.004;

    float cosT = cos(time);
    float sinT = sin(time);

    vec3 rotNorm = vec3(
        cosT * normal.x + sinT * normal.z,
        normal.y,
        -sinT * normal.x + cosT * normal.z
    );

    float continent = fbm(rotNorm * 3.5 + vec3(1.3, 2.1, 0.7));

    float elevLarge = fbm(rotNorm * 6.0  + vec3(5.1, 3.2, 1.9));
    float elevFine  = fbm(rotNorm * 18.0 + vec3(2.3, 7.1, 4.4));

    float mountains =
        smoothstep(0.52, 0.82, elevLarge) * elevFine;

    float landMask =
        smoothstep(0.43, 0.57, continent);

    float eps = 0.003;

    float h1 = fbmFast(rotNorm * 12.0 + vec3(eps * 12.0, 0.0, 0.0));
    float h3 = fbmFast(rotNorm * 12.0 + vec3(0.0, eps * 12.0, 0.0));

    vec3 up =
        abs(sphereNormal.y) > 0.99
        ? vec3(1.0, 0.0, 0.0)
        : vec3(0.0, 1.0, 0.0);

    vec3 tangent =
        normalize(cross(up, sphereNormal));

    vec3 bitangent =
        normalize(cross(sphereNormal, tangent));

    float hx = h1 - elevLarge;
    float hy = h3 - elevLarge;

    vec3 bumpNormal =
        sphereNormal +
        tangent * hx * 2.2 +
        bitangent * hy * 2.2;

    normal = normalize(
        mix(
            sphereNormal,
            bumpNormal,
            mountains * landMask
        )
    );

    vec3 lightDir = normalize(vec3(1.5, 0.6, 0.3));

    float diff = max(dot(normal, lightDir), 0.0);

    float wrapped =
        smoothstep(-0.12, 0.35, diff);

    wrapped *= wrapped;

    float ambient = 0.018;

    float fresnel =
        pow(1.0 - max(dot(-rd, normal), 0.0), 4.0);

    vec3 oceanDeep  = vec3(0.005, 0.025, 0.12);
    vec3 oceanLight = vec3(0.03, 0.20, 0.60);

    vec3 oceanColor =
        mix(oceanDeep, oceanLight, wrapped);

    float wave =
        fbm(rotNorm * 40.0 + time * 0.25);

    oceanColor += wave * 0.025;

    vec3 reflDir = reflect(-lightDir, normal);

    float specDot = max(dot(-rd, reflDir), 0.0);

    float spec =
        pow(specDot, 180.0) *
        (1.0 - landMask);

    float wideSpec =
        pow(specDot, 24.0) *
        (1.0 - landMask);

    oceanColor += vec3(1.2, 1.1, 0.9) * spec * 2.8;
    oceanColor += vec3(0.45, 0.6, 0.9) * wideSpec * 0.5;

    vec3 coast     = vec3(0.10, 0.20, 0.10);
    vec3 plains    = vec3(0.14, 0.34, 0.10);
    vec3 forest    = vec3(0.08, 0.22, 0.07);
    vec3 mountain  = vec3(0.36, 0.28, 0.18);
    vec3 snow      = vec3(0.92, 0.94, 0.98);

    vec3 landColor = plains;

    landColor = mix(landColor, forest,
        smoothstep(0.30, 0.55, elevLarge));

    landColor = mix(landColor, mountain,
        smoothstep(0.55, 0.78, elevLarge));

    landColor = mix(landColor, snow,
        smoothstep(0.72, 0.88, elevLarge));

    landColor *= 0.7 + mountains * 0.7;

    float polar =
        smoothstep(0.65, 0.88, abs(rotNorm.y));

    landColor = mix(landColor, snow, polar);

    float cloudBase =
        fbm(rotNorm * 4.0 + vec3(0.5, time * 0.18, 2.3));

    float cloudDetail =
        fbm(rotNorm * 10.0 + vec3(3.1, time * 0.3, 0.8));

    float clouds =
        smoothstep(0.52, 0.72,
            cloudBase + cloudDetail * 0.2);

    vec3 cloudColor =
        vec3(1.0) * (0.4 + wrapped);

    float cloudShadow =
        clouds *
        smoothstep(0.0, 0.4, diff) *
        0.45;

    vec3 surface =
        mix(oceanColor, landColor, landMask);

    surface *= (1.0 - cloudShadow);

    surface = mix(surface, cloudColor, clouds * 0.9);

    float scatter =
            pow(1.0 - diff, 3.0) *
            (1.0 - fresnel);

    surface +=
        vec3(0.18, 0.35, 1.0) *
        scatter *
        0.35;

    float night =
        1.0 - smoothstep(0.0, 0.18, diff);

    float cityNoise =
        fbm(rotNorm * 55.0);

    float cities =
        smoothstep(0.78, 0.9, cityNoise) *
        landMask *
        night *
        (1.0 - clouds);

    surface += vec3(1.2, 0.75, 0.25) * cities * 2.0;

    float rim =
        pow(1.0 - max(dot(-rd, sphereNormal), 0.0), 3.0);

    surface +=
        vec3(0.35, 0.55, 1.2) *
        pow(rim, 1.8) *
        (0.2 + diff * 1.6);

    surface +=
        vec3(0.4, 0.55, 1.0) *
        fresnel *
        0.15;

    surface +=
        vec3(1.0, 0.35, 0.08) *
        pow(rim, 5.0) *
        smoothstep(-0.15, 0.15, diff);


    surface *= ambient + wrapped * 1.1;

    surface = pow(surface, vec3(0.92));

    float curvature =
        pow(max(dot(sphereNormal, lightDir), 0.0), 0.35);

    surface *= curvature + ambient;

    return vec4(surface, 1.0);
}

float getSmoothDiskNoise(vec3 p, float time) {
    float v = fbm(p * 0.3 + vec3(0.0, time * 0.05, 0.0));
    v += fbm(p * 0.6 - vec3(time * 0.02, 0.0, 0.0)) * 0.5;
    return smoothstep(0.35, 0.75, v);
}

void getDiskDensity(vec3 p, vec3 rayDir, float time, out vec3 color, out float density) {
    float tilt = 0.35;
    float s = sin(tilt);
    float c = cos(tilt);
    vec3 q = vec3(p.x, p.y * c - p.z * s, p.y * s + p.z * c);

    float bhRadius = 0.075;
    float r = length(q.xz);
    float diskInner = bhRadius * 1.8;
    float diskOuter = bhRadius * 8.0;

    float thickness = 0.035;
    float distFromPlane = abs(q.y);

    if (distFromPlane > (thickness + 0.01) || r < (diskInner - 0.03) || r > (diskOuter + 0.03)) {
        density = 0.0;
        return;
    }

    float innerFade = smoothstep(diskInner - 0.02, diskInner + 0.04, r);
    float outerFade = smoothstep(diskOuter + 0.02, diskOuter - 0.3, r);
    float thickFade = smoothstep(thickness + 0.01, 0.0, distFromPlane);

    float angle = atan(q.z, q.x);

    float wave = sin(GameTime * 3200.0 + r * 16.0 + angle * 4.0 * 2.0) * 0.5 + 0.5;
    float verticalFade = thickFade * (0.7 + 0.3 * wave);

    float radial = clamp((r - diskInner) / (diskOuter - diskInner), 0.0, 1.0);

    float shearedAngle = angle * 6.0 - r * 50.0;
    float strands = fbm(vec3(r * 50.0, shearedAngle, time * 0.4));
    strands = smoothstep(0.15, 0.85, strands) * 0.7 + 0.3;

    float noise = getSmoothDiskNoise(q * 2.5, time + angle * 0.1 * 0.5);
    noise = max(noise, 0.3);

    vec3 tangent = normalize(cross(vec3(0.0, 1.0, 0.0), q));
    float beam = dot(tangent, rayDir);

    float beaming = 0.7 + 0.3 * pow(clamp(1.0 - beam, 0.0, 1.0), 3.0);

    density = noise * strands * (1.0 - radial) * verticalFade * innerFade * outerFade * 6.0;

    float doppler = dot(tangent, rayDir);

    float radialFactor = smoothstep(0.9, 0.1, radial);
    float dopplerScale = (doppler > 0.0) ? 0.6 : 0.32;
    float dopplerFactor = 1.0 + doppler * dopplerScale * radialFactor;
    float dopplerBoost = pow(dopplerFactor, 3.2);

    vec3 innerColor = vec3(4.0, 3.2, 2.2);
    vec3 midColor   = vec3(3.5, 1.8, 0.4);
    vec3 outerColor = vec3(0.8, 0.18, 0.02);

    vec3 col;
    if (radial < 0.35) {
        col = mix(innerColor, midColor, radial / 0.35);
    } else {
        col = mix(midColor, outerColor, (radial - 0.35) / 0.65);
    }

    float innerGlow = exp(-radial * 6.0) * 3.0;
    col += vec3(2.5, 1.9, 1.2) * innerGlow;

    if (doppler > 0.0) {
            col += vec3(1.8, 1.4, 1.0) * pow(doppler, 2.0) * 2.0 * radialFactor;
    } else {
        col.g = mix(col.g, col.g * 0.65, abs(doppler) * 0.5);
        col.b = mix(col.b, col.b * 0.2, abs(doppler) * 0.7);
        col *= (1.0 + doppler * 0.15);
    }

    vec3 finalOut = col * dopplerBoost;

    float continuousCore = exp(-radial * 11.0) * 7.5 * innerFade * thickFade;
    finalOut += vec3(5.0, 4.5, 4.0) * continuousCore;

    vec3 modernBloom = finalOut * 0.38;
    vec3 overExposed = (modernBloom / (vec3(1.0) + modernBloom)) * 2.2;

    float viewAngle = 1.0 - abs(dot(rayDir, vec3(0.0, 1.0, 0.0)));
    float limbBright = 0.6 + 0.4 * viewAngle;

    color = overExposed * limbBright;
}

vec4 raymarchBlackHole(vec3 ro, inout vec3 rd) {
    vec3 center = normalize(vec3(0.865, 0.45, 0.45)) * 4.0;

    float bhRadius = 0.0585;
    float mass = 2.25;

    float dither = fract(dot(gl_FragCoord.xy, vec2(0.75487766, 0.56984026))) * 0.004;
    vec3 p = ro + rd * dither;
    vec3 v = rd;

    float stepSize = 0.03;
    vec3 diskAccum = vec3(0.0);
    float transmittance = 1.0;
    float closestDist = 10.0;
    for (int i = 0; i < 175; i++) {
        vec3 relPos = p - center;
        float d2 = dot(relPos, relPos);
        float r = sqrt(d2);

        closestDist = min(closestDist, r);

        vec3 col; float den;
        getDiskDensity(relPos, v, GameTime, col, den);
        if (den > 0.0) {
            float alpha = 1.0 - exp(-den * stepSize * 8.0);
            diskAccum += transmittance * col * alpha;
            transmittance *= (1.0 - alpha);
        }

        if (r < bhRadius) return vec4(diskAccum, 0.0);

        vec3 gravityDir = normalize(-relPos);
        float deflection = (mass * bhRadius) / d2;

        float photonBoost = 1.0 + max(0.0, 3.0 - r / bhRadius) * 0.5;
        v = normalize(v + gravityDir * deflection * stepSize * photonBoost);
        p += v * stepSize;

        if (r > 15.0 || transmittance < 0.01) break;
    }

    rd = v;

    float ring = exp(-pow((closestDist - bhRadius * 1.9) / 0.01, 2.0));
    diskAccum += vec3(2.5, 2.2, 1.8) * ring * transmittance * 2.0;

    return vec4(diskAccum, transmittance);
}

vec3 horizonHaze(vec3 dir) {
    float horizonBand = smoothstep(0.15, -0.10, dir.y);

    vec3 hazeColor = vec3(0.14, 0.15, 0.20);

    vec3 haze = hazeColor * horizonBand * 0.8;

    float line = smoothstep(0.10, 0.0, abs(dir.y));
    haze += vec3(0.10, 0.12, 0.18) * line * 0.6;

    return haze;
}

void main() {
    vec3 ro = vec3(0.0);
    vec3 rd = normalize(fragPos);

    vec4 bhResult = FancyRendering > 0.0 ? raymarchBlackHole(ro, rd) : vec4(0.0, 0.0, 0.0, 1.0);

    vec3 color = vec3(0.0, 0.0, 0.012);

    float mw = milkyWay(rd);
    float mwMask = smoothstep(0.0, 0.08, rd.y);
    vec3 mwColor = mix(vec3(0.15, 0.18, 0.28), vec3(0.25, 0.22, 0.18), mw);
    color += mwColor * mw * 0.35 * mwMask;

    float starMask = smoothstep(-0.02, 0.08, rd.y);
    vec4 starResult = starFieldWithColor(rd);
    if (starResult.a > 0.001) {
        color += starResult.rgb * starResult.a * starMask;
    }

    vec3 g1dir = normalize(vec3(-0.6, 0.5, -0.8));
    color += renderGalaxy(rd, g1dir, 0.04, 0.8, vec3(0.5, 0.6, 0.9)) * mwMask;
    vec3 g2dir = normalize(vec3(0.5, 0.6, -0.7));
    color += renderGalaxy(rd, g2dir, 0.025, 2.1, vec3(0.8, 0.7, 0.4)) * mwMask;

    vec3 neb1dir = normalize(vec3(-0.4, 0.4, -1.0));
    color += renderNebula(rd, neb1dir, 0.18, vec3(0.05, 0.04, 0.18)) * mwMask;

    color = color * bhResult.a + bhResult.rgb;

    vec3 originalRd = normalize(fragPos);
    vec3 earthCenter = normalize(vec3(0.0, 0.1, -1.0)) * 3.5;
    vec3 relEarth = earthCenter - ro;
    float dist = length(relEarth);
    float earthRadius = 0.80;

    float threshold = sqrt(1.0 - pow(earthRadius / dist, 2.0));

    if (dot(originalRd, normalize(relEarth)) > threshold * 0.95) {
        vec4 earth = renderEarth(ro, originalRd);
        color = mix(color, earth.rgb, earth.a);
    }

    vec3 haze = horizonHaze(originalRd);
    float hazeStrength = smoothstep(0.15, -0.10, originalRd.y);
    color += haze * hazeStrength;

    fragColor = vec4(color, 1.0);
}