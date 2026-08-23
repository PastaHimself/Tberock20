/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.levelgen.Aquifer$FluidPicker
 *  net.minecraft.world.level.levelgen.DensityFunction
 *  net.minecraft.world.level.levelgen.DensityFunctions$BeardifierOrMarker
 *  net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
 *  net.minecraft.world.level.levelgen.NoiseChunk
 *  net.minecraft.world.level.levelgen.NoiseGeneratorSettings
 *  net.minecraft.world.level.levelgen.NoiseRouter
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.mixins.features.generationCorruption;

import java.util.Random;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.mixins.features.generationCorruption.RandomStateAccessor;
import net.thebrokenscript.util.YOffsetDensityFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={NoiseBasedChunkGenerator.class})
public abstract class NoiseBasedChunkGeneratorMixin {
    @Redirect(method={"createNoiseChunk"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/levelgen/NoiseChunk;forChunk(Lnet/minecraft/world/level/chunk/ChunkAccess;Lnet/minecraft/world/level/levelgen/RandomState;Lnet/minecraft/world/level/levelgen/DensityFunctions$BeardifierOrMarker;Lnet/minecraft/world/level/levelgen/NoiseGeneratorSettings;Lnet/minecraft/world/level/levelgen/Aquifer$FluidPicker;Lnet/minecraft/world/level/levelgen/blending/Blender;)Lnet/minecraft/world/level/levelgen/NoiseChunk;"))
    private NoiseChunk redirectForChunk(ChunkAccess chunk, RandomState state, DensityFunctions.BeardifierOrMarker beardifierOrMarker, NoiseGeneratorSettings noiseGeneratorSettings, Aquifer.FluidPicker fluidPicker, Blender blender) {
        if (!TBSConfigs.INSTANCE.getServer().getWorld().getAllowChunkYOffsetGeneration()) {
            return NoiseChunk.forChunk((ChunkAccess)chunk, (RandomState)state, (DensityFunctions.BeardifierOrMarker)beardifierOrMarker, (NoiseGeneratorSettings)noiseGeneratorSettings, (Aquifer.FluidPicker)fluidPicker, (Blender)blender);
        }
        NoiseBasedChunkGenerator self = (NoiseBasedChunkGenerator)this;
        if (!self.stable(NoiseGeneratorSettings.OVERWORLD)) {
            return NoiseChunk.forChunk((ChunkAccess)chunk, (RandomState)state, (DensityFunctions.BeardifierOrMarker)beardifierOrMarker, (NoiseGeneratorSettings)noiseGeneratorSettings, (Aquifer.FluidPicker)fluidPicker, (Blender)blender);
        }
        ChunkPos pos = chunk.getPos();
        int yOffset = NoiseBasedChunkGeneratorMixin.theBrokenScript$computeOffset(pos);
        NoiseRouter original = state.router();
        NoiseBasedChunkGeneratorMixin.theBrokenScript$wrapRouter(state, yOffset, original);
        NoiseChunk result = NoiseChunk.forChunk((ChunkAccess)chunk, (RandomState)state, (DensityFunctions.BeardifierOrMarker)beardifierOrMarker, (NoiseGeneratorSettings)noiseGeneratorSettings, (Aquifer.FluidPicker)fluidPicker, (Blender)blender);
        NoiseBasedChunkGeneratorMixin.theBrokenScript$setRouter(state, original);
        return result;
    }

    @Unique
    private static int theBrokenScript$computeOffset(ChunkPos pos) {
        long seed = ChunkPos.asLong((int)pos.x, (int)pos.z) ^ 0xC0FFEEL;
        return new Random(seed).nextInt(33) - 16;
    }

    @Unique
    private static void theBrokenScript$setRouter(RandomState random, NoiseRouter router) {
        ((RandomStateAccessor)random).setRouter(router);
    }

    @Unique
    private static void theBrokenScript$wrapRouter(RandomState random, int yOffset, NoiseRouter original) {
        if (yOffset == 0) {
            return;
        }
        NoiseBasedChunkGeneratorMixin.theBrokenScript$setRouter(random, new NoiseRouter(original.barrierNoise(), original.fluidLevelFloodednessNoise(), original.fluidLevelSpreadNoise(), original.lavaNoise(), original.temperature(), original.vegetation(), original.continents(), original.erosion(), original.depth(), original.ridges(), original.initialDensityWithoutJaggedness(), (DensityFunction)new YOffsetDensityFunction(original.finalDensity(), yOffset), original.veinToggle(), original.veinRidged(), original.veinGap()));
    }
}

