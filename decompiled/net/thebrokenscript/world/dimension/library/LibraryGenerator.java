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
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.NoiseColumn
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.biome.BiomeManager
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.GenerationStep$Carving
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.library;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 >2\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J(\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J@\u0010\"\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0016J0\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010.\u001a\u00020 H\u0016J\b\u0010/\u001a\u00020 H\u0016J0\u00100\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001cH\u0016J(\u00107\u001a\u0002082\u0006\u0010\u001e\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u0002052\u0006\u00104\u001a\u00020\u001cH\u0016J(\u00109\u001a\u00020\r2\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0:2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u0013H\u0016J\u0010\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010=H\u0014R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006?"}, d2={"Lnet/thebrokenscript/world/dimension/library/LibraryGenerator;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "ignoreBlock", "", "Lnet/minecraft/world/level/block/Block;", "kotlin.jvm.PlatformType", "getIgnoreBlock", "()Ljava/util/List;", "placeStructure", "", "structureId", "Lnet/minecraft/resources/ResourceLocation;", "region", "Lnet/minecraft/world/level/WorldGenLevel;", "pos", "Lnet/minecraft/core/BlockPos;", "chunk", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "buildSurface", "level", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "random", "Lnet/minecraft/world/level/levelgen/RandomState;", "spawnOriginalMobs", "p0", "getGenDepth", "", "applyBiomeDecoration", "applyCarvers", "seed", "", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "step", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "fillFromNoise", "Ljava/util/concurrent/CompletableFuture;", "blender", "Lnet/minecraft/world/level/levelgen/blending/Blender;", "randomState", "getSeaLevel", "getMinY", "getBaseHeight", "p1", "p2", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "p3", "Lnet/minecraft/world/level/LevelHeightAccessor;", "p4", "getBaseColumn", "Lnet/minecraft/world/level/NoiseColumn;", "addDebugScreenInfo", "", "", "codec", "Lcom/mojang/serialization/MapCodec;", "Companion", "thebrokenscript-common"})
public final class LibraryGenerator
extends ChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<Block> ignoreBlock;
    @NotNull
    private static final MapCodec<LibraryGenerator> CODEC;

    public LibraryGenerator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
        Object[] objectArray = new Block[]{Blocks.AIR, Blocks.STRUCTURE_VOID};
        this.ignoreBlock = CollectionsKt.mutableListOf((Object[])objectArray);
    }

    @NotNull
    public final List<Block> getIgnoreBlock() {
        return this.ignoreBlock;
    }

    public final void placeStructure(@NotNull ResourceLocation structureId, @NotNull WorldGenLevel region, @NotNull BlockPos pos, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)structureId, (String)"structureId");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        MinecraftServer minecraftServer = region.getServer();
        Intrinsics.checkNotNull((Object)minecraftServer);
        ServerLevel serverLevel = minecraftServer.getLevel(TBSDimensions.LIBRARY);
        if (serverLevel == null) {
            return;
        }
        ServerLevel level = serverLevel;
        Optional optional = level.getStructureManager().get(structureId);
        if (optional == null) {
            return;
        }
        Optional templateHolder = optional;
        Object t = templateHolder.get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        StructureTemplate template = (StructureTemplate)t;
        ChunkPos chunkPos = chunk.getPos();
        BoundingBox boundingBox = new BoundingBox(chunkPos.getMinBlockX() - 16, level.getMinBuildHeight(), chunkPos.getMinBlockZ() - 16, chunkPos.getMaxBlockX() + 16, level.getMaxBuildHeight(), chunkPos.getMaxBlockZ() + 16);
        StructurePlaceSettings settings = new StructurePlaceSettings().setIgnoreEntities(false).addProcessor((StructureProcessor)new BlockIgnoreProcessor(this.ignoreBlock)).setBoundingBox(boundingBox);
        template.placeInWorld((ServerLevelAccessor)region, pos, pos, settings, region.getRandom(), 3);
    }

    public void buildSurface(@NotNull WorldGenRegion level, @NotNull StructureManager structureManager, @NotNull RandomState random, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        block3: for (int i = -3; i < 12; ++i) {
            switch (i) {
                case 0: 
                case 4: 
                case 8: {
                    ResourceLocation resourceLocation = TBSConstants.id("library2");
                    WorldGenLevel worldGenLevel = (WorldGenLevel)level;
                    BlockPos blockPos = chunk.getPos().getWorldPosition();
                    Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getWorldPosition(...)");
                    this.placeStructure(resourceLocation, worldGenLevel, PositionUtil.withY((BlockPos)blockPos, (Number)(0 + i * 17)), chunk);
                    continue block3;
                }
                default: {
                    ResourceLocation resourceLocation = TBSConstants.id("library");
                    WorldGenLevel worldGenLevel = (WorldGenLevel)level;
                    BlockPos blockPos = chunk.getPos().getWorldPosition();
                    Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getWorldPosition(...)");
                    this.placeStructure(resourceLocation, worldGenLevel, PositionUtil.withY((BlockPos)blockPos, (Number)(0 + i * 17)), chunk);
                }
            }
        }
    }

    public void spawnOriginalMobs(@NotNull WorldGenRegion p0) {
        Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
    }

    public int getGenDepth() {
        return 1;
    }

    public void applyBiomeDecoration(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, @NotNull StructureManager structureManager) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
    }

    public void applyCarvers(@NotNull WorldGenRegion level, long seed, @NotNull RandomState random, @NotNull BiomeManager biomeManager, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunk, @NotNull GenerationStep.Carving step) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)biomeManager, (String)"biomeManager");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)step, (String)"step");
    }

    @NotNull
    public CompletableFuture<ChunkAccess> fillFromNoise(@NotNull Blender blender, @NotNull RandomState randomState, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)blender, (String)"blender");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        CompletableFuture<ChunkAccess> completableFuture = CompletableFuture.completedFuture(chunk);
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"completedFuture(...)");
        return completableFuture;
    }

    public int getSeaLevel() {
        return 0;
    }

    public int getMinY() {
        return 0;
    }

    public int getBaseHeight(int p0, int p1, @NotNull Heightmap.Types p2, @NotNull LevelHeightAccessor p3, @NotNull RandomState p4) {
        Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
        Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
        Intrinsics.checkNotNullParameter((Object)p4, (String)"p4");
        return 1;
    }

    @NotNull
    public NoiseColumn getBaseColumn(int p0, int p1, @NotNull LevelHeightAccessor p2, @NotNull RandomState p3) {
        Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
        Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
        int minY = p2.getMinBuildHeight();
        int height = p2.getHeight();
        int n = 0;
        BlockState[] blockStateArray = new BlockState[height];
        while (n < height) {
            int n2 = n++;
            blockStateArray[n2] = Blocks.AIR.defaultBlockState();
        }
        BlockState[] states = blockStateArray;
        return new NoiseColumn(minY, states);
    }

    public void addDebugScreenInfo(@NotNull List<String> p0, @NotNull RandomState p1, @NotNull BlockPos p2) {
        Intrinsics.checkNotNullParameter(p0, (String)"p0");
        Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
        Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
    }

    @NotNull
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        return instance.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(LibraryGenerator::CODEC$lambda$0$0)).apply((Applicative)instance, LibraryGenerator::new);
    }

    private static final BiomeSource CODEC$lambda$0$0(LibraryGenerator it) {
        return it.biomeSource;
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(LibraryGenerator::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/library/LibraryGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/library/LibraryGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<LibraryGenerator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

