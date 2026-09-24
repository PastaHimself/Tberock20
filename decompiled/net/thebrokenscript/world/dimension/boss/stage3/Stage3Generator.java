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
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.arguments.blocks.BlockStateParser
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.NoiseColumn
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.biome.BiomeManager
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.chunk.LevelChunkSection
 *  net.minecraft.world.level.levelgen.GenerationStep$Carving
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  net.thebrokenscript.brokencore.api.xcsf.PackedBlock
 *  net.thebrokenscript.brokencore.api.xcsf.XcsfStructure
 *  net.thebrokenscript.brokencore.impl.resources.ReloadListener
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.boss.stage3;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.xcsf.PackedBlock;
import net.thebrokenscript.brokencore.api.xcsf.XcsfStructure;
import net.thebrokenscript.brokencore.impl.resources.ReloadListener;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J0\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J@\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J0\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+2\u0006\u0010\b\u001a\u00020,2\u0006\u0010 \u001a\u00020\u0012H\u0016J(\u0010-\u001a\u00020.2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\u0006\u0010/\u001a\u00020,2\u0006\u0010 \u001a\u00020\u0012H\u0016J(\u00100\u001a\u00020\u00072\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102012\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u000203H\u0016J\u0010\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000105H\u0014\u00a8\u00067"}, d2={"Lnet/thebrokenscript/world/dimension/boss/stage3/Stage3Generator;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "applyBiomeDecoration", "", "level", "Lnet/minecraft/world/level/WorldGenLevel;", "chunk", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "buildSurface", "region", "Lnet/minecraft/server/level/WorldGenRegion;", "randomState", "Lnet/minecraft/world/level/levelgen/RandomState;", "spawnOriginalMobs", "getGenDepth", "", "fillFromNoise", "Ljava/util/concurrent/CompletableFuture;", "p0", "Lnet/minecraft/world/level/levelgen/blending/Blender;", "p1", "p2", "p3", "applyCarvers", "seed", "", "random", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "step", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "getSeaLevel", "getMinY", "getBaseHeight", "x", "z", "type", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "Lnet/minecraft/world/level/LevelHeightAccessor;", "getBaseColumn", "Lnet/minecraft/world/level/NoiseColumn;", "height", "addDebugScreenInfo", "", "", "Lnet/minecraft/core/BlockPos;", "codec", "Lcom/mojang/serialization/MapCodec;", "Companion", "thebrokenscript-common"})
public final class Stage3Generator
extends ChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<Stage3Generator> CODEC;

    public Stage3Generator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
    }

    public void applyBiomeDecoration(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, @NotNull StructureManager structureManager) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        ResourceLocation arenaId = TBSConstants.id("phase3_arena_final");
        XcsfStructure xcsfStructure = ReloadListener.INSTANCE.getStructure(arenaId);
        if (xcsfStructure == null) {
            return;
        }
        XcsfStructure structure = xcsfStructure;
        int localChunkX = chunk.getPos().x;
        int localChunkZ = chunk.getPos().z;
        ChunkPos targetLocalChunk = new ChunkPos(localChunkX, localChunkZ);
        Map map = (Map)structure.getSectionCache().get(targetLocalChunk);
        if (map == null) {
            return;
        }
        Map chunkData = map;
        HolderLookup lookup = level.holderLookup(Registries.BLOCK);
        Map stateCache = new LinkedHashMap();
        LevelChunkSection[] sections = chunk.getSections();
        for (Map.Entry entry : chunkData.entrySet()) {
            int sectionIdx = ((Number)entry.getKey()).intValue();
            List packedBlocks = (List)entry.getValue();
            boolean bl = 0 <= sectionIdx ? sectionIdx < sections.length : false;
            if (!bl) continue;
            int n = ((Collection)packedBlocks).size();
            for (int i = 0; i < n; ++i) {
                BlockState parsedState;
                PackedBlock packed = (PackedBlock)packedBlocks.get(i);
                Intrinsics.checkNotNullExpressionValue((Object)stateCache.computeIfAbsent(packed.getStateDef(), arg_0 -> Stage3Generator.applyBiomeDecoration$lambda$1(arg_0 -> Stage3Generator.applyBiomeDecoration$lambda$0(lookup, arg_0), arg_0)), (String)"computeIfAbsent(...)");
                int worldX = (chunk.getPos().x << 4) + packed.getLocalX();
                int worldY = chunk.getSectionYFromSectionIndex(sectionIdx) * 16 + packed.getLocalY();
                int worldZ = (chunk.getPos().z << 4) + packed.getLocalZ();
                chunk.setBlockState(new BlockPos(worldX, worldY, worldZ), parsedState, false);
            }
        }
    }

    public void buildSurface(@NotNull WorldGenRegion region, @NotNull StructureManager structureManager, @NotNull RandomState randomState, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
    }

    public void spawnOriginalMobs(@NotNull WorldGenRegion region) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
    }

    public int getGenDepth() {
        return 1;
    }

    @NotNull
    public CompletableFuture<ChunkAccess> fillFromNoise(@NotNull Blender p0, @NotNull RandomState p1, @NotNull StructureManager p2, @NotNull ChunkAccess p3) {
        Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
        Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
        Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
        Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
        CompletableFuture<ChunkAccess> completableFuture = CompletableFuture.completedFuture(p3);
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"completedFuture(...)");
        return completableFuture;
    }

    public void applyCarvers(@NotNull WorldGenRegion region, long seed, @NotNull RandomState random, @NotNull BiomeManager biomeManager, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunk, @NotNull GenerationStep.Carving step) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)biomeManager, (String)"biomeManager");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)step, (String)"step");
    }

    public int getSeaLevel() {
        return 0;
    }

    public int getMinY() {
        return 0;
    }

    public int getBaseHeight(int x, int z, @NotNull Heightmap.Types type, @NotNull LevelHeightAccessor level, @NotNull RandomState random) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        return 1;
    }

    @NotNull
    public NoiseColumn getBaseColumn(int x, int z, @NotNull LevelHeightAccessor height, @NotNull RandomState random) {
        Intrinsics.checkNotNullParameter((Object)height, (String)"height");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        int minY = height.getMinBuildHeight();
        int height2 = height.getHeight();
        int n = 0;
        BlockState[] blockStateArray = new BlockState[height2];
        while (n < height2) {
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

    private static final BlockState applyBiomeDecoration$lambda$0(HolderLookup $lookup, String stringDef) {
        BlockState blockState;
        Intrinsics.checkNotNullParameter((Object)stringDef, (String)"stringDef");
        try {
            blockState = BlockStateParser.parseForBlock((HolderLookup)$lookup, (String)stringDef, (boolean)true).blockState();
        }
        catch (Exception exception) {
            blockState = Blocks.AIR.defaultBlockState();
        }
        return blockState;
    }

    private static final BlockState applyBiomeDecoration$lambda$1(Function1 $tmp0, Object p0) {
        return (BlockState)$tmp0.invoke(p0);
    }

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        return instance.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(Stage3Generator::CODEC$lambda$0$0)).apply((Applicative)instance, Stage3Generator::new);
    }

    private static final BiomeSource CODEC$lambda$0$0(Stage3Generator it) {
        return it.biomeSource;
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(Stage3Generator::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/boss/stage3/Stage3Generator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/boss/stage3/Stage3Generator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<Stage3Generator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

