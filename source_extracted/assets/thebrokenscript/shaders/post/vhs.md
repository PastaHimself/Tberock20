# vhs shader notes

### default uniforms:
- vec2 InSize
- vec2 OutSize
- float Time (delta ticks, not very consistent)
- vec2 ScreenSize
- sampler2D DiffuseSampler

## passes: 
- downsample
    - buffers: main -> swap0
    - uniforms: none extra
- quantize colors
    - buffers: swap0 -> swap1
    - uniforms:
        - float QuantizeLevels (eg 16 or 32)
        - float ColorOffsetAmplitude (max per‑channel jitter in UV)
        - float ColorOffsetSpeed (jitter speed)
- chromatic aberration
    - buffers: downsample1 -> downsample0
    - uniforms:
      - float Intensity (channel separation)
- scanlines
    - buffers: swap0 -> swap1
    - uniforms:
      - float ScanlineOpacity (0-1)
      - float ScanlineSpacing (pixel distance between scanlines)
      - float ScanlineFlicker (amplitude of opacity flicker)
- slight wobble
    - buffers: swap1 -> swap0
    - uniforms:
      - float WobbleAmplitude (pixels)
      - float WobbleFrequency (hz)
- dropped horizontal lines
    - buffers: swap0 -> swap1
    - uniforms:
      - float DropLineProbability (0-1, chance per frame to drop a line)
      - float DropLineHeight (pixels)
      - float DropLineSpeed (pixels per second)
- noise/grain
    - buffers: swap1 -> swap0
    - uniforms:
- bloom extract
    - buffers: swap0 -> bloom_temp
    - uniforms:
        - float BloomThreshold (0-1, above this value is considered bright enough to bloom)
        - float BloomKnee (0-1, how much to soften the threshold)
- bloom horizontal/vertical (same shader, just 2 passes)
    - buffers: bloom -> swap1, swap1 -> bloom_temp
    - uniforms:
        - int Direction (0 for horizontal, 1 for vertical)
        - float BlurRadius (in texels)
- bloom combine
    - buffers: swap0 + bloom_temp -> swap1
    - uniforms:
        - float BloomIntensity (0-1, how much to add bloom to the image)
    - also note that we need to include the second input buffer here,
      which may be difficult since the PostChain class only supports
      one input buffer per pass
- barrel distortion
    - buffers: swap0 -> swap1
    - uniforms:
- vignette
    - buffers: swap1 -> main
    - uniforms: 

