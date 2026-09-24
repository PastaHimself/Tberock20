/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.HolderGetter
 *  net.minecraft.core.HolderLookup
 *  net.minecraft.core.RegistryAccess
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.server.level.ChunkMap
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.chunk.ChunkGeneratorStructureState
 *  net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
 *  net.minecraft.world.level.levelgen.NoiseGeneratorSettings
 *  net.minecraft.world.level.levelgen.RandomState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.thebrokenscript.mixins.features.world.ChunkMapAccessor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/util/SeedSwapper;", "", "<init>", "()V", "swapSeed", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "newSeed", "", "thebrokenscript-common"})
public final class SeedSwapper {
    @NotNull
    public static final SeedSwapper INSTANCE = new SeedSwapper();

    private SeedSwapper() {
    }

    @JvmStatic
    public static final void swapSeed(@NotNull ServerLevel level, long newSeed) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        ChunkMap chunkMap = level.getChunkSource().chunkMap;
        Intrinsics.checkNotNullExpressionValue((Object)chunkMap, (String)"chunkMap");
        ChunkMap chunkMap2 = chunkMap;
        ChunkGenerator generator = chunkMap2.generator();
        RegistryAccess registryAccess = level.registryAccess();
        Intrinsics.checkNotNullExpressionValue((Object)registryAccess, (String)"registryAccess(...)");
        RegistryAccess access = registryAccess;
        RandomState newRandomState = null;
        if (generator instanceof NoiseBasedChunkGenerator) {
            RandomState randomState = RandomState.create((NoiseGeneratorSettings)((NoiseGeneratorSettings)((NoiseBasedChunkGenerator)generator).generatorSettings().value()), (HolderGetter)((HolderGetter)access.lookupOrThrow(Registries.NOISE)), (long)newSeed);
            Intrinsics.checkNotNullExpressionValue((Object)randomState, (String)"create(...)");
            newRandomState = randomState;
        } else {
            RandomState randomState = RandomState.create((NoiseGeneratorSettings)NoiseGeneratorSettings.dummy(), (HolderGetter)((HolderGetter)access.lookupOrThrow(Registries.NOISE)), (long)newSeed);
            Intrinsics.checkNotNullExpressionValue((Object)randomState, (String)"create(...)");
            newRandomState = randomState;
        }
        ChunkGeneratorStructureState newStructureState = generator.createState((HolderLookup)access.lookupOrThrow(Registries.STRUCTURE_SET), newRandomState, newSeed);
        ((ChunkMapAccessor)chunkMap2).setRandomState(newRandomState);
        ((ChunkMapAccessor)chunkMap2).setChunkGeneratorState(newStructureState);
    }
}

