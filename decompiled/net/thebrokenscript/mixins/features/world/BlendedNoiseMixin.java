/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 *  net.minecraft.world.level.levelgen.DensityFunction$FunctionContext
 *  net.minecraft.world.level.levelgen.synth.BlendedNoise
 *  net.minecraft.world.level.levelgen.synth.ImprovedNoise
 *  net.minecraft.world.level.levelgen.synth.PerlinNoise
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.world;

import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.synth.BlendedNoise;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.util.NoiseUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlendedNoise.class})
public class BlendedNoiseMixin {
    @Shadow
    @Final
    private PerlinNoise minLimitNoise;
    @Shadow
    @Final
    private PerlinNoise maxLimitNoise;
    @Shadow
    @Final
    private PerlinNoise mainNoise;
    @Shadow
    @Final
    private double xzMultiplier;
    @Shadow
    @Final
    private double yMultiplier;
    @Shadow
    @Final
    private double xzFactor;
    @Shadow
    @Final
    private double yFactor;
    @Shadow
    @Final
    private double smearScaleMultiplier;

    @Inject(method={"compute"}, at={@At(value="HEAD")}, cancellable=true)
    public void compute(DensityFunction.FunctionContext ctx, CallbackInfoReturnable<Double> cir) {
        if (!TBSConfigs.INSTANCE.getServer().getWorld().getAllowCorruptedWorldGeneration()) {
            return;
        }
        double scaledX = (double)ctx.blockX() * this.xzMultiplier;
        double scaledY = (double)ctx.blockY() * this.yMultiplier;
        double scaledZ = (double)ctx.blockZ() * this.xzMultiplier;
        boolean inXLands = Mth.abs((int)ctx.blockX()) >= 12550825;
        boolean inZLands = Mth.abs((int)ctx.blockZ()) >= 12550825;
        double mainNoiseX = scaledX / this.xzFactor;
        double mainNoiseY = scaledY / this.yFactor;
        double mainNoiseZ = scaledZ / this.xzFactor;
        double ySmearScale = this.yMultiplier * this.smearScaleMultiplier;
        double ySmearScaleFactor = ySmearScale / this.yFactor;
        double minLimitNoiseSample = 0.0;
        double maxLimitNoiseSample = 0.0;
        double mainNoiseSample = 0.0;
        double octaveAmplitude = 1.0;
        for (int octave = 0; octave < 8; ++octave) {
            ImprovedNoise mainOctave = this.mainNoise.getOctaveNoise(octave);
            if (mainOctave != null) {
                double sampleX = mainNoiseX * octaveAmplitude;
                double sampleZ = mainNoiseZ * octaveAmplitude;
                if (!inXLands) {
                    sampleX = PerlinNoise.wrap((double)sampleX);
                }
                if (!inZLands) {
                    sampleZ = PerlinNoise.wrap((double)sampleZ);
                }
                mainNoiseSample += NoiseUtil.noise(sampleX, PerlinNoise.wrap((double)(mainNoiseY * octaveAmplitude)), sampleZ, ySmearScaleFactor * octaveAmplitude, mainNoiseY * octaveAmplitude, mainOctave) / octaveAmplitude;
            }
            octaveAmplitude /= 2.0;
        }
        double lerpFactor = (mainNoiseSample / 10.0 + 1.0) / 2.0;
        boolean useOnlyMaxNoise = lerpFactor >= 1.0;
        boolean useOnlyMinNoise = lerpFactor <= 0.0;
        octaveAmplitude = 1.0;
        for (int octave = 0; octave < 16; ++octave) {
            ImprovedNoise maxLimitOctave;
            ImprovedNoise minLimitOctave;
            double sampleX = scaledX * octaveAmplitude;
            double sampleY = PerlinNoise.wrap((double)(scaledY * octaveAmplitude));
            double sampleZ = scaledZ * octaveAmplitude;
            if (!inXLands) {
                sampleX = PerlinNoise.wrap((double)sampleX);
            }
            if (!inZLands) {
                sampleZ = PerlinNoise.wrap((double)sampleZ);
            }
            double ySmear = ySmearScale * octaveAmplitude;
            if (!useOnlyMaxNoise && (minLimitOctave = this.minLimitNoise.getOctaveNoise(octave)) != null) {
                minLimitNoiseSample += NoiseUtil.noise(sampleX, sampleY, sampleZ, ySmear, scaledY * octaveAmplitude, minLimitOctave) / octaveAmplitude;
            }
            if (!useOnlyMinNoise && (maxLimitOctave = this.maxLimitNoise.getOctaveNoise(octave)) != null) {
                maxLimitNoiseSample += NoiseUtil.noise(sampleX, sampleY, sampleZ, ySmear, scaledY * octaveAmplitude, maxLimitOctave) / octaveAmplitude;
            }
            octaveAmplitude /= 2.0;
        }
        cir.setReturnValue((Object)(Mth.clampedLerp((double)(minLimitNoiseSample / 512.0), (double)(maxLimitNoiseSample / 512.0), (double)lerpFactor) / 128.0));
    }
}

