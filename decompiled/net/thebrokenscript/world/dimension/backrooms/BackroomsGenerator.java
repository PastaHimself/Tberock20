/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.NoiseColumn
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.biome.BiomeManager
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.GenerationStep$Carving
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.backrooms;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.thebrokenscript.world.dimension.backrooms.BackroomsLevelZero;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007H\u0014J@\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020!H\u0016J0\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020!H\u0016J0\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020!2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u00101\u001a\u00020\t2\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00105\u001a\u000206H\u0016R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u00068"}, d2={"Lnet/thebrokenscript/world/dimension/backrooms/BackroomsGenerator;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "codec", "Lcom/mojang/serialization/MapCodec;", "applyCarvers", "", "worldGenRegion", "Lnet/minecraft/server/level/WorldGenRegion;", "l", "", "randomState", "Lnet/minecraft/world/level/levelgen/RandomState;", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "chunkAccess", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "carving", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "levelZero", "Lnet/thebrokenscript/world/dimension/backrooms/BackroomsLevelZero;", "getLevelZero", "()Lnet/thebrokenscript/world/dimension/backrooms/BackroomsLevelZero;", "setLevelZero", "(Lnet/thebrokenscript/world/dimension/backrooms/BackroomsLevelZero;)V", "buildSurface", "spawnOriginalMobs", "getGenDepth", "", "fillFromNoise", "Ljava/util/concurrent/CompletableFuture;", "blender", "Lnet/minecraft/world/level/levelgen/blending/Blender;", "getSeaLevel", "getMinY", "getBaseHeight", "i", "i1", "types", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "levelHeightAccessor", "Lnet/minecraft/world/level/LevelHeightAccessor;", "getBaseColumn", "Lnet/minecraft/world/level/NoiseColumn;", "addDebugScreenInfo", "list", "", "", "blockPos", "Lnet/minecraft/core/BlockPos;", "Companion", "thebrokenscript-common"})
public final class BackroomsGenerator
extends ChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private BackroomsLevelZero levelZero;
    @NotNull
    private static final MapCodec<BackroomsGenerator> CODEC;

    public BackroomsGenerator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
        this.levelZero = new BackroomsLevelZero();
    }

    @NotNull
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    public void applyCarvers(@NotNull WorldGenRegion worldGenRegion, long l, @NotNull RandomState randomState, @NotNull BiomeManager biomeManager, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunkAccess, @NotNull GenerationStep.Carving carving) {
        Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        Intrinsics.checkNotNullParameter((Object)biomeManager, (String)"biomeManager");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        Intrinsics.checkNotNullParameter((Object)carving, (String)"carving");
    }

    @NotNull
    public final BackroomsLevelZero getLevelZero() {
        return this.levelZero;
    }

    public final void setLevelZero(@NotNull BackroomsLevelZero backroomsLevelZero) {
        Intrinsics.checkNotNullParameter((Object)backroomsLevelZero, (String)"<set-?>");
        this.levelZero = backroomsLevelZero;
    }

    public void buildSurface(@NotNull WorldGenRegion worldGenRegion, @NotNull StructureManager structureManager, @NotNull RandomState randomState, @NotNull ChunkAccess chunkAccess) {
        Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        this.levelZero.generate(worldGenRegion, structureManager, randomState, chunkAccess);
    }

    public void spawnOriginalMobs(@NotNull WorldGenRegion worldGenRegion) {
        Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
    }

    public int getGenDepth() {
        return 256;
    }

    @NotNull
    public CompletableFuture<ChunkAccess> fillFromNoise(@NotNull Blender blender, @NotNull RandomState randomState, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunkAccess) {
        Intrinsics.checkNotNullParameter((Object)blender, (String)"blender");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        CompletableFuture<ChunkAccess> completableFuture = CompletableFuture.completedFuture(chunkAccess);
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"completedFuture(...)");
        return completableFuture;
    }

    public int getSeaLevel() {
        return 0;
    }

    public int getMinY() {
        return 0;
    }

    public int getBaseHeight(int i, int i1, @NotNull Heightmap.Types types, @NotNull LevelHeightAccessor levelHeightAccessor, @NotNull RandomState randomState) {
        Intrinsics.checkNotNullParameter((Object)types, (String)"types");
        Intrinsics.checkNotNullParameter((Object)levelHeightAccessor, (String)"levelHeightAccessor");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        return 0;
    }

    @NotNull
    public NoiseColumn getBaseColumn(int i, int i1, @NotNull LevelHeightAccessor levelHeightAccessor, @NotNull RandomState randomState) {
        Intrinsics.checkNotNullParameter((Object)levelHeightAccessor, (String)"levelHeightAccessor");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        return new NoiseColumn(this.getMinY(), new BlockState[0]);
    }

    public void addDebugScreenInfo(@NotNull List<String> list, @NotNull RandomState randomState, @NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter(list, (String)"list");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
    }

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        RecordCodecBuilder.Instance instance2 = instance;
        Intrinsics.checkNotNull((Object)instance2);
        return instance2.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(BackroomsGenerator::CODEC$lambda$0$0)).apply((Applicative)instance, BackroomsGenerator::CODEC$lambda$0$1);
    }

    private static final BiomeSource CODEC$lambda$0$0(BackroomsGenerator gen) {
        BackroomsGenerator backroomsGenerator = gen;
        Intrinsics.checkNotNull((Object)((Object)backroomsGenerator));
        return backroomsGenerator.biomeSource;
    }

    private static final BackroomsGenerator CODEC$lambda$0$1(BiomeSource biomeSource) {
        BiomeSource biomeSource2 = biomeSource;
        Intrinsics.checkNotNull((Object)biomeSource2);
        return new BackroomsGenerator(biomeSource2);
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(BackroomsGenerator::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/backrooms/BackroomsGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/backrooms/BackroomsGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<BackroomsGenerator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

