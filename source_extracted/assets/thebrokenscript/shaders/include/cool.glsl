/*
    Credit:
    Biomine shader made by Shane

    link: https://www.shadertoy.com/view/4lyGzR

    Biomine
    -------
    
    A biocooling system for a futuristic, off-world mine... or a feeding mechanisn for an alien 
	hatchery? I wasn't really sure what I was creating when I started, and I'm still not. :) I at 
	least wanted to create the sense that the tubes were pumping some form of biomatter around 
	without having to resort to full reflective and refractive passes... I kind of got there. :)

	All things considered, there's not a lot to this. Combine a couple of gyroid surfaces, ID them,
	then add their respective material properties. The scene is simple to create, and explained in
	the distance function. There's also some function based, 2nd order cellular bump mapping, for 
	anyone interested.

	The fluid pumped through the tubes was created by indexing the reflected and refracted rays 
	into a basic environment mapping function. Not accurate, but simple, effective and way cheaper
	than the real thing.

	I'd just finished watching some of the Assembly 2016 entries on YouTube, so for better or
	worse, wanted to produce the scene without the help of any in-house textures.

    Related examples: 

    Cellular Tiling - Shane
    https://www.shadertoy.com/view/4scXz2

	Cellular Tiled Tunnel - Shane
	https://www.shadertoy.com/view/MscSDB

*/

// Max ray distance.
#define FAR 50. 

// Variables used to identify the objects. In this case, there are just two - the biotubes and
// the tunnel walls.
float objID = 0.; // Biotubes: 0, Tunnel walls: 1.
float saveID = 0.;


// Standard 1x1 hash functions. Using "cos" for non-zero origin result.
float hash( float n ){ return fract(cos(n)*45758.5453); }



// 2x2 matrix rotation. Note the absence of "cos." It's there, but in disguise, and comes courtesy
// of Fabrice Neyret's "ouside the box" thinking. :)
mat2 rot2( float a ){ vec2 v = sin(vec2(1.570796, 0) + a);	return mat2(v, -v.y, v.x); }


// Compact, self-contained version of IQ's 3D value noise function. I have a transparent noise
// example that explains it, if you require it.
float noise3D(in vec3 p){
    
	const vec3 s = vec3(7, 157, 113);
	vec3 ip = floor(p); p -= ip; 
    vec4 h = vec4(0., s.yz, s.y + s.z) + dot(ip, s);
    p = p*p*(3. - 2.*p); //p *= p*p*(p*(p * 6. - 15.) + 10.);
    h = mix(fract(sin(h)*43758.5453), fract(sin(h + s.x)*43758.5453), p.x);
    h.xy = mix(h.xz, h.yw, p.y);
    return mix(h.x, h.y, p.z); // Range: [0, 1].
}

////////
// The cellular tile routine. Draw a few objects (four spheres, in this case) using a minumum
// blend at various 3D locations on a cubic tile. Make the tile wrappable by ensuring the 
// objects wrap around the edges. That's it.
//
// Believe it or not, you can get away with as few as three spheres. If you sum the total 
// instruction count here, you'll see that it's way, way lower than 2nd order 3D Voronoi.
// Not requiring a hash function provides the biggest benefit, but there is also less setup.
// 
// The result isn't perfect, but 3D cellular tiles can enable you to put a Voronoi looking 
// surface layer on a lot of 3D objects for little cost.
//
float drawSphere(in vec3 p){
  
    p = fract(p)-.5;    
    return dot(p, p);
    
    //p = abs(fract(p)-.5);
    //return dot(p, vec3(.5));  
}


float cellTile(in vec3 p){
    
    // Draw four overlapping objects (spheres, in this case) at various positions throughout the tile.
    vec4 v, d; 
    d.x = drawSphere(p - vec3(.81, .62, .53));
    p.xy = vec2(p.y-p.x, p.y + p.x)*.7071;
    d.y = drawSphere(p - vec3(.39, .2, .11));
    p.yz = vec2(p.z-p.y, p.z + p.y)*.7071;
    d.z = drawSphere(p - vec3(.62, .24, .06));
    p.xz = vec2(p.z-p.x, p.z + p.x)*.7071;
    d.w = drawSphere(p - vec3(.2, .82, .64));

    v.xy = min(d.xz, d.yw), v.z = min(max(d.x, d.y), max(d.z, d.w)), v.w = max(v.x, v.y); 
   
    d.x =  min(v.z, v.w) - min(v.x, v.y); // First minus second order, for that beveled Voronoi look. Range [0, 1].
    //d.x =  min(v.x, v.y); // Minimum, for the cellular look.
        
    return d.x*2.66; // Normalize... roughly.
    
}

// The path is a 2D sinusoid that varies over time, depending upon the frequencies, and amplitudes.
vec2 path(in float z){ 
    return vec2(0);
    //float a = sin(z * 0.11);
    //float b = cos(z * 0.14);
    //return vec2(a*4. - b*1.5, b*1.7 + a*1.5);
}


// Smooth maximum, based on IQ's smooth minimum function.
float smaxP(float a, float b, float s){
    
    float h = clamp( 0.5 + 0.5*(a-b)/s, 0., 1.);
    return mix(b, a, h) + h*(1.0-h)*s;
}


// The distance function. It's a lot simpler than it looks: The biological tubes are just a gyroid lattice.
// The mine tunnel, is created by takoing the negative space, and bore out the center with a cylinder. The
// two are combined with a smooth maximum to produce the tunnel with biotube lattice. On top of that, the 
// whole scene is wrapped around a path and slightly mutated (the first two lines), but that's it.

float map(vec3 p, float time){
  
    p.xy -= path(p.z); // Wrap the scene around a path.

    p += cos(p.zxy*1.5707963)*.2; // Perturb slightly. The mutation gives it a bit more of an organic feel.

    // If you're not familiar with a gyroid lattice, this is basically it. Not so great to hone in on, but
    // pretty cool looking and simple to produce.
    float d = dot(cos(p*1.5707963), sin(p.yzx*1.5707963)) + 1.;

	// Biotube lattice. The final time-based term makes is heave in and out.
    float bio = d + .25 + dot(sin(p*1. + time*6.283 + sin(p.yzx*.5)), vec3(.033));

    // The tunnel. Created with a bit of trial and error. The smooth maximum against the gyroid rounds it off
    // a bit. The abs term at the end just adds some variation via the beveled edges. Also trial and error.
    float tun = smaxP(3.25 - length(p.xy - vec2(0, 1)) + .5*cos(p.z*3.14159/32.), .75-d, 1.) - abs(1.5-d)*.375;;// - sf*.25;


    objID = step(tun, bio); // Tunnel and biolattice IDs, for coloring, lighting, bumping, etc, later.

    return min(tun, bio); // Return the distance to the scene.

 
}


// Surface bump function. Cheap, but with decent visual impact.
float bumpSurf3D( in vec3 p){
    
    float bmp;
    float noi = noise3D(p*96.);
    
    if(saveID>.5){
    	float sf = cellTile(p*.75); 
    	float vor = cellTile(p*1.5);
    
        bmp = sf*.66 + (vor*.94 + noi*.06)*.34;
    }
    else {
        p/=3.;//
        float ct = cellTile(p*2. + sin(p*12.)*.5)*.66+cellTile(p*6. + sin(p*36.)*.5)*.34;
        bmp = (1.-smoothstep(-.2, .25, ct))*.9 + noi*.1;

        
    }
    
    return bmp;

}

// Standard function-based bump mapping function.
vec3 doBumpMap(in vec3 p, in vec3 nor, float bumpfactor){
    
    const vec2 e = vec2(0.001, 0);
    float ref = bumpSurf3D(p);                 
    vec3 grad = (vec3(bumpSurf3D(p - e.xyy),
                      bumpSurf3D(p - e.yxy),
                      bumpSurf3D(p - e.yyx) )-ref)/e.x;                     
          
    grad -= nor*dot(nor, grad);          
                      
    return normalize( nor + grad*bumpfactor );
	
}

// Basic raymarcher.
float trace(in vec3 ro, in vec3 rd, float time){

    float t = 0.0, h;
    for(int i = 0; i < 50; i++){
    
        h = map(ro + rd*t, time);
        // Note the "t*b + a" addition. Basically, we're putting less emphasis on accuracy, as
        // "t" increases. It's a cheap trick that works in most situations... Not all, though.
        if(abs(h)<0.002*(t*.125 + 1.) || t>FAR) break; // Alternative: 0.001*max(t*.25, 1.)        
        t += step(h, 1.)*h*.2 + h*.5;
        
    }

    return min(t, FAR);
}

// Standard normal function. It's not as fast as the tetrahedral calculation, but more symmetrical.
vec3 getNormal(in vec3 p, float time) {
	const vec2 e = vec2(0.002, 0);
	return normalize(vec3(map(p + e.xyy, time) - map(p - e.xyy, time), map(p + e.yxy, time) - map(p - e.yxy, time),	map(p + e.yyx, time) - map(p - e.yyx, time)));
}

// XT95's really clever, cheap, SSS function. The way I've used it doesn't do it justice,
// so if you'd like to really see it in action, have a look at the following:
//
// Alien Cocoons - XT95: https://www.shadertoy.com/view/MsdGz2
//
float thickness( in vec3 p, in vec3 n, float maxDist, float falloff, float time )
{
	const float nbIte = 6.0;
	float ao = 0.0;
    
    for( float i=1.; i< nbIte+.5; i++ ){
        
        float l = (i*.75 + fract(cos(i)*45758.5453)*.25)/nbIte*maxDist;
        
        ao += (l + map(p - n*l, time)) / pow(1. + l, falloff);
    }
	
    return clamp( 1.-ao/nbIte, 0., 1.);
}


// Shadows.
float softShadow(vec3 ro, vec3 rd, float start, float end, float k, float time){

    float shade = 1.0;
    const int maxIterationsShad = 20;

    float dist = start;
    //float stepDist = end/float(maxIterationsShad);

    // Max shadow iterations - More iterations make nicer shadows, but slow things down.
    for (int i=0; i<maxIterationsShad; i++){
    
        float h = map(ro + rd*dist, time);
        shade = min(shade, k*h/dist);

        // +=h, +=clamp( h, 0.01, 0.25 ), +=min( h, 0.1 ), +=stepDist, +=min(h, stepDist*2.), etc.
        dist += clamp( h, 0.01, 0.25);//min(h, stepDist);
        
        // Early exits from accumulative distance function calls tend to be a good thing.
        if (h<0.001 || dist > end) break; 
    }

    // Shadow value.
    return min(max(shade, 0.) + 0.5, 1.0); 
}



// Ambient occlusion, for that self shadowed look. Based on the original by XT95. I love this 
// function, and in many cases, it gives really, really nice results. For a better version, and 
// usage, refer to XT95's examples below:
//
// Hemispherical SDF AO - https://www.shadertoy.com/view/4sdGWN
// Alien Cocoons - https://www.shadertoy.com/view/MsdGz2
float calculateAO( in vec3 p, in vec3 n, float time )
{
	float ao = 0.0, l;
    const float maxDist = 4.;
	const float nbIte = 6.0;
	//const float falloff = 0.9;
    for( float i=1.; i< nbIte+.5; i++ ){
    
        l = (i + hash(i))*.5/nbIte*maxDist;
        
        ao += (l - map(p + n*l, time))/(1.+ l);
    }
	
    return clamp(1.- ao/nbIte, 0., 1.);
}


/////
// Code block to produce some layers of smokey haze. Not sophisticated at all.
// If you'd like to see a much more sophisticated version, refer to Nitmitz's
// Xyptonjtroz example. Incidently, I wrote this off the top of my head, but
// I did have that example in mind when writing this.

// Hash to return a scalar value from a 3D vector.
float hash31(vec3 p){ return fract(sin(dot(p, vec3(127.1, 311.7, 74.7)))*43758.5453); }

// Four layers of cheap cell tile noise to produce some subtle mist.
// Start at the ray origin, then take four samples of noise between it
// and the surface point. Apply some very simplistic lighting along the 
// way. It's not particularly well thought out, but it doesn't have to be.
float getMist(in vec3 ro, in vec3 rd, in vec3 lp, in float t){

    float mist = 0.;
    ro += rd*t/64.; // Edge the ray a little forward to begin.
    
    for (int i = 0; i<8; i++){
        // Lighting. Technically, a lot of these points would be
        // shadowed, but we're ignoring that.
        float sDi = length(lp-ro)/FAR; 
	    float sAtt = min(1./(1. + sDi*0.25 + sDi*sDi*0.25), 1.);
	    // Noise layer.
        //float n = trigNoise3D(ro/2.);//noise3D(ro/2.)*.66 + noise3D(ro/1.)*.34;
        float n = cellTile(ro/2.);
        mist += n*sAtt;//trigNoise3D
        // Advance the starting point towards the hit point.
        ro += rd*t/8.;
    }
    
    // Add a little noise, then clamp, and we're done.
    return clamp(mist/4. + hash31(ro)*0.2-0.1, 0., 1.);

}


//////
// Simple environment mapping. Pass the reflected vector in and create some
// colored noise with it. The normal is redundant here, but it can be used
// to pass into a 3D texture mapping function to produce some interesting
// environmental reflections.
//
// More sophisticated environment mapping:
// UI easy to integrate - XT95    
// https://www.shadertoy.com/view/ldKSDm
vec3 eMap(vec3 rd, vec3 sn, float time){
    
    
    // Add a time component, scale, then pass into the noise function.
    rd.y += time;
    rd /= 3.;

    // Biotube texturing.
    float ct = cellTile(rd*2. + sin(rd*12.)*.5)*.66 + cellTile(rd*6. + sin(rd*36.)*.5)*.34;
    vec3 texCol = (vec3(.25, .2, .15)*(1.-smoothstep(-.1, .3, ct)) + vec3(0.02, 0.02, 0.53)/6.); 
    return smoothstep(0., 1., texCol);
    
}

vec4 biomineShader(
    vec3 rayOrigin,
    vec3 rayDir,
    float time
){
    vec3 camPos = rayOrigin;
    vec3 rd = normalize(rayDir);
    vec3 lightPos = camPos + vec3(0.0, 0.5, 5.0);

    float t = trace(camPos, rd, time);
    saveID = objID;

    vec3 sceneCol = vec3(0.0);

    if (t < FAR){
        vec3 sp = camPos + rd * t;
        vec3 sn = getNormal(sp, time);

        if (saveID > 0.5) sn = doBumpMap(sp, sn, 0.2);
        else sn = doBumpMap(sp, sn, 0.008);

        float ao = calculateAO(sp, sn, time);

        vec3 ld = lightPos - sp;
        float dist = max(length(ld), 0.001);
        ld /= dist;

        float sha = softShadow(sp, ld, 0.05, dist, 8.0, time);

        float atten = 1.0 / (1.0 + dist * 0.5 + dist * dist * 0.1);
        float ambience = 0.1;
        float diff = max(dot(sn, ld), 0.0);
        float spec = pow(max(dot(reflect(-ld, sn), -rd), 0.0), 32.0);
        float fre = pow(clamp(dot(sn, rd) + 1.0, 0.0, 1.0), 1.0);

        vec3 texCol;

        if (saveID > 0.5){
            texCol = vec3(0.3) *
                (noise3D(sp * 32.0) * 0.66 + noise3D(sp * 64.0) * 0.34) *
                (1.0 - cellTile(sp * 16.0) * 0.75);

            texCol *= smoothstep(-0.1, 0.5,
                cellTile(sp * 0.75) * 0.66 + cellTile(sp * 1.5) * 0.34) * 0.85 + 0.15;
        } else {
            vec3 sps = sp / 3.0;
            float ct = cellTile(sps * 2.0 + sin(sps * 12.0) * 0.5) * 0.66 +
                       cellTile(sps * 6.0 + sin(sps * 36.0) * 0.5) * 0.34;

            texCol = vec3(0.45, 0.15, 0.15) * (1.0 - smoothstep(-0.1, 0.25, ct))
                   + vec3(0.12, 0.02, 0.02);
        }

        vec3 hf = normalize(ld + sn);
        float th = thickness(sp, sn, 1.0, 1.0, time);
        float tdiff = pow(clamp(dot(rd, -hf), 0.0, 1.0), 1.0);
        float trans = pow((tdiff) * th, 4.0);

        sceneCol = texCol * (diff * sha + ambience)
                 + vec3(0.8, 0.8, 0.8) * spec;

        if (saveID < 0.5)
            sceneCol += vec3(0.8, 0.8, 0.8) * spec * spec;

        sceneCol += texCol * vec3(0.85, 0.85, 0.85) * pow(fre, 4.0) * 2.0;
        sceneCol += vec3(0.5, 0.5, 0.5) * trans * 1.5;

        if (saveID < 0.5){
            vec3 ref = reflect(rd, sn);
            sceneCol += eMap(ref, sn, time) * 0.5;

            ref = refract(rd, sn, 1.0 / 1.3);
            sceneCol += eMap(ref, sn, time) * vec3(2.0, 0.2, 0.3) * 1.5;
        }

        sceneCol *= atten * ao;
    }

    if (t < FAR) {
        float mistAmount = getMist(camPos, rd, lightPos, t);
        sceneCol = mix(sceneCol, vec3(0.055), mistAmount * 0.35);
    }

    vec3 sky = vec3(0.05, 0.05, 0.05);
    sceneCol = mix(sky, sceneCol, 1.0 / (t * t / FAR / FAR * 8.0 + 1.0));

    sceneCol *= 0.6;

    vec3 finalCol = sceneCol;

    float lum = dot(finalCol, vec3(0.299, 0.587, 0.114));

    float saturationBoost = 1.5; // Adjust this (1.0 = no change, 2.0 = double saturation)
    finalCol = mix(vec3(lum), finalCol, saturationBoost);

    return vec4(sqrt(clamp(finalCol, 0.0, 1.0)), 1.0);
}