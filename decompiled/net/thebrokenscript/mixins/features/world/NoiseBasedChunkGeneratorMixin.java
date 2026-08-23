/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
 *  net.minecraft.world.level.levelgen.NoiseGeneratorSettings
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  net.minecraft.world.level.levelgen.synth.ImprovedNoise
 *  net.minecraft.world.level.levelgen.synth.PerlinNoise
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.world;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.util.NoiseUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={NoiseBasedChunkGenerator.class})
public class NoiseBasedChunkGeneratorMixin {
    @Shadow
    @Final
    private Holder<NoiseGeneratorSettings> settings;
    @Unique
    private volatile PerlinNoise tbs$skyLandsNoise = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Unique
    private PerlinNoise tbs$getSkyLandsNoise(RandomState randomState) {
        if (this.tbs$skyLandsNoise == null) {
            NoiseBasedChunkGeneratorMixin noiseBasedChunkGeneratorMixin = this;
            synchronized (noiseBasedChunkGeneratorMixin) {
                if (this.tbs$skyLandsNoise == null) {
                    this.tbs$skyLandsNoise = PerlinNoise.create((RandomSource)randomState.oreRandom().fromHashOf("vertical_farlands"), List.of(Integer.valueOf(-3), Integer.valueOf(-2), Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)));
                }
            }
        }
        return this.tbs$skyLandsNoise;
    }

    @Inject(method={"fillFromNoise"}, at={@At(value="HEAD")})
    public void fillFromNoise(Blender blender, RandomState randomState, StructureManager structureManager, ChunkAccess chunk, CallbackInfoReturnable<CompletableFuture<ChunkAccess>> cir) {
        if (!TBSConfigs.INSTANCE.getServer().getWorld().getAllowCorruptedWorldGeneration()) {
            return;
        }
        int chunkX = chunk.getPos().getMinBlockX();
        int chunkZ = chunk.getPos().getMinBlockZ();
        PerlinNoise noise = this.tbs$getSkyLandsNoise(randomState);
        int SKY_LANDS_START = 192;
        int SKY_LANDS_END = 272;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 192; y <= 272; ++y) {
                    double density = this.tbs$sampleSkyLandsDensity(noise, chunkX + x, y, chunkZ + z);
                    if (!(density > 0.0)) continue;
                    chunk.setBlockState(new BlockPos(chunkX + x, y, chunkZ + z), ((NoiseGeneratorSettings)this.settings.value()).defaultBlock(), false);
                }
            }
        }
    }

    @Unique
    private double tbs$sampleSkyLandsDensity(PerlinNoise noise, int blockX, int blockY, int blockZ) {
        double sampleX = (double)blockX * 0.98322845;
        double sampleY = PerlinNoise.wrap((double)((double)blockY * 0.98322845));
        double sampleZ = (double)blockZ * 0.98322845;
        double t = (double)(blockY - 192) / 80.0;
        double yLandsBlend = 1.0 - Math.abs(t - 0.5) * 2.0;
        double sample = 0.0;
        double amplitude = 1.0;
        for (int i = 0; i < 7; ++i) {
            ImprovedNoise octave = noise.getOctaveNoise(i);
            if (octave != null) {
                double ox = sampleX * amplitude;
                double oy = PerlinNoise.wrap((double)(sampleY * amplitude));
                double oz = sampleZ * amplitude;
                sample += NoiseUtil.noise(ox, oy, oz, 0.0, 0.0, octave) / amplitude;
            }
            amplitude /= 2.0;
        }
        return sample / 10.0 + (yLandsBlend * 2.0 - 1.0);
    }
}

