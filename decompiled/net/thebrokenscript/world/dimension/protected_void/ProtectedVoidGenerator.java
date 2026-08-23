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
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.NoiseColumn
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.biome.BiomeManager
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.GenerationStep$Carving
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.protected_void;

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
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J@\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0016J0\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J0\u0010+\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0016H\u0016J(\u00102\u001a\u0002032\u0006\u0010\u0019\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u0002002\u0006\u0010/\u001a\u00020\u0016H\u0016J(\u00104\u001a\u00020\u00072\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u000106052\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0010H\u0016J\u0010\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000108H\u0014\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/world/dimension/protected_void/ProtectedVoidGenerator;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "genRoom", "", "level", "Lnet/minecraft/world/level/WorldGenLevel;", "chunkAccess", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "placeStructure", "structureId", "Lnet/minecraft/resources/ResourceLocation;", "pos", "Lnet/minecraft/core/BlockPos;", "buildSurface", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "random", "Lnet/minecraft/world/level/levelgen/RandomState;", "chunk", "spawnOriginalMobs", "p0", "getGenDepth", "", "applyBiomeDecoration", "applyCarvers", "seed", "", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "step", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "fillFromNoise", "Ljava/util/concurrent/CompletableFuture;", "blender", "Lnet/minecraft/world/level/levelgen/blending/Blender;", "randomState", "getSeaLevel", "getMinY", "getBaseHeight", "p1", "p2", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "p3", "Lnet/minecraft/world/level/LevelHeightAccessor;", "p4", "getBaseColumn", "Lnet/minecraft/world/level/NoiseColumn;", "addDebugScreenInfo", "", "", "codec", "Lcom/mojang/serialization/MapCodec;", "Companion", "thebrokenscript-common"})
public final class ProtectedVoidGenerator
extends ChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<ProtectedVoidGenerator> CODEC;

    public ProtectedVoidGenerator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
    }

    public final void genRoom(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunkAccess) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        ResourceLocation resourceLocation = TBSConstants.id("inf_stairs");
        BlockPos blockPos = chunkAccess.getPos().getWorldPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getWorldPosition(...)");
        this.placeStructure(resourceLocation, level, PositionUtil.withY((BlockPos)blockPos, (Number)64));
    }

    public final void placeStructure(@NotNull ResourceLocation structureId, @NotNull WorldGenLevel level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)structureId, (String)"structureId");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        ServerLevel serverLevel = level.getLevel();
        StructureTemplateManager templateManager = serverLevel.getStructureManager();
        Optional optional = templateManager.get(structureId);
        if (optional == null) {
            return;
        }
        Optional template = optional;
        BlockIgnoreProcessor processor = new BlockIgnoreProcessor(CollectionsKt.listOf((Object)Blocks.STRUCTURE_VOID));
        StructurePlaceSettings settings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).addProcessor((StructureProcessor)processor);
        ((StructureTemplate)template.get()).placeInWorld((ServerLevelAccessor)level, pos, pos, settings, level.getRandom(), 11);
        Vec3i size = ((StructureTemplate)template.get()).getSize();
        int n = size.getX();
        for (int x = 0; x < n; ++x) {
            int n2 = size.getY();
            for (int y = 0; y < n2; ++y) {
                int n3 = size.getZ();
                for (int z = 0; z < n3; ++z) {
                    BlockPos blockPos = pos.offset(x, y, z);
                    BlockState blockState = level.getBlockState(blockPos);
                    if (!blockState.isRandomlyTicking() && !blockState.is((Holder)TBSBlocks.PORTAL_CONTROLLER) && !blockState.is((Holder)TBSBlocks.PORTAL_EXTENDER)) continue;
                    level.scheduleTick(blockPos, blockState.getBlock(), 1);
                }
            }
        }
    }

    public void buildSurface(@NotNull WorldGenRegion level, @NotNull StructureManager structureManager, @NotNull RandomState random, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        this.genRoom((WorldGenLevel)level, chunk);
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
        return instance.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(ProtectedVoidGenerator::CODEC$lambda$0$0)).apply((Applicative)instance, ProtectedVoidGenerator::new);
    }

    private static final BiomeSource CODEC$lambda$0$0(ProtectedVoidGenerator it) {
        return it.biomeSource;
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(ProtectedVoidGenerator::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/protected_void/ProtectedVoidGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/protected_void/ProtectedVoidGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<ProtectedVoidGenerator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

