/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ChunkMap
 *  net.minecraft.world.level.chunk.ChunkGeneratorStructureState
 *  net.minecraft.world.level.levelgen.RandomState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.mixins.features.world;

import net.minecraft.server.level.ChunkMap;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.RandomState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ChunkMap.class})
public interface ChunkMapAccessor {
    @Accessor(value="randomState")
    public RandomState getRandomState();

    @Accessor(value="randomState")
    public void setRandomState(RandomState var1);

    @Accessor(value="chunkGeneratorState")
    public ChunkGeneratorStructureState getChunkGeneratorState();

    @Accessor(value="chunkGeneratorState")
    public void setChunkGeneratorState(ChunkGeneratorStructureState var1);
}

