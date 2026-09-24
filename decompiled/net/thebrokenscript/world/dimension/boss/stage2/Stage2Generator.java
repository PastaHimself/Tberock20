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
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.util.RandomSource
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
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
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
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.dimension.boss.stage2;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
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
import net.thebrokenscript.block.R3Block;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 Y2\u00020\u0001:\u0002XYB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J6\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010J\u0016\u0010#\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J>\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020'J(\u0010,\u001a\u00020\f2\u0006\u0010%\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0006\u00102\u001a\u00020\fJ \u00103\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/H\u0016J\u0016\u00104\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0010J&\u00105\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00102\u0006\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\u0014J\u001e\u00108\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00102\u0006\u00106\u001a\u00020'J\u0010\u00109\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020-H\u0016J\b\u0010:\u001a\u00020'H\u0016J0\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u0010H\u0016J@\u0010B\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010C\u001a\u00020\b2\u0006\u00100\u001a\u0002012\u0006\u0010D\u001a\u00020E2\u0006\u0010.\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020'H\u0016J\b\u0010I\u001a\u00020'H\u0016J0\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020'2\u0006\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020N2\u0006\u0010%\u001a\u00020O2\u0006\u00100\u001a\u000201H\u0016J(\u0010P\u001a\u00020Q2\u0006\u0010K\u001a\u00020'2\u0006\u0010L\u001a\u00020'2\u0006\u0010R\u001a\u00020O2\u0006\u00100\u001a\u000201H\u0016J(\u0010S\u001a\u00020\f2\u000e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0T2\u0006\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020\u001dH\u0016J\u0010\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010WH\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006Z"}, d2={"Lnet/thebrokenscript/world/dimension/boss/stage2/Stage2Generator;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "occupiedChunks", "", "", "getOccupiedChunks", "()Ljava/util/Set;", "genRoom", "", "worldGenRegion", "Lnet/minecraft/world/level/WorldGenLevel;", "chunkAccess", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "genSurface", "ignoreBlock", "", "Lnet/minecraft/world/level/block/Block;", "kotlin.jvm.PlatformType", "getIgnoreBlock", "()Ljava/util/List;", "placeStructure", "structureId", "Lnet/minecraft/resources/ResourceLocation;", "region", "pos", "Lnet/minecraft/core/BlockPos;", "mirror", "Lnet/minecraft/world/level/block/Mirror;", "rotation", "Lnet/minecraft/world/level/block/Rotation;", "chunk", "genTunnel", "genNowhere", "level", "yOffset", "", "xOffset", "zOffset", "randomOffset", "divider", "buildSurface", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "random", "Lnet/minecraft/world/level/levelgen/RandomState;", "resetOccupancy", "applyBiomeDecoration", "genBorders", "genFloor", "y", "block", "genBarrier", "spawnOriginalMobs", "getGenDepth", "fillFromNoise", "Ljava/util/concurrent/CompletableFuture;", "p0", "Lnet/minecraft/world/level/levelgen/blending/Blender;", "p1", "p2", "p3", "applyCarvers", "seed", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "step", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "getSeaLevel", "getMinY", "getBaseHeight", "x", "z", "type", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "Lnet/minecraft/world/level/LevelHeightAccessor;", "getBaseColumn", "Lnet/minecraft/world/level/NoiseColumn;", "height", "addDebugScreenInfo", "", "", "codec", "Lcom/mojang/serialization/MapCodec;", "HolePoint", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nStage2Generator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Stage2Generator.kt\nnet/thebrokenscript/world/dimension/boss/stage2/Stage2Generator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,648:1\n1761#2,3:649\n1788#2,4:652\n*S KotlinDebug\n*F\n+ 1 Stage2Generator.kt\nnet/thebrokenscript/world/dimension/boss/stage2/Stage2Generator\n*L\n321#1:649,3\n395#1:652,4\n*E\n"})
public final class Stage2Generator
extends ChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Set<Long> occupiedChunks;
    @NotNull
    private final List<Block> ignoreBlock;
    @NotNull
    private static final MapCodec<Stage2Generator> CODEC;
    public static final int ROOM_MIN = 16;
    public static final int ROOM_MAX = 160;

    public Stage2Generator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
        Set set = Collections.synchronizedSet(Collections.newSetFromMap((Map)new LinkedHashMap<Long, Boolean>(){

            protected boolean removeEldestEntry(Map.Entry<Long, Boolean> eldest) {
                Intrinsics.checkNotNullParameter(eldest, (String)"eldest");
                return this.size() > 10000;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(set, (String)"synchronizedSet(...)");
        this.occupiedChunks = set;
        Object[] objectArray = new Block[]{Blocks.AIR, Blocks.STRUCTURE_VOID};
        this.ignoreBlock = CollectionsKt.mutableListOf((Object[])objectArray);
    }

    @NotNull
    public final Set<Long> getOccupiedChunks() {
        return this.occupiedChunks;
    }

    public final void genRoom(@NotNull WorldGenLevel worldGenRegion, @NotNull ChunkAccess chunkAccess) {
        String string;
        String string2;
        String string3;
        Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        RandomSource random = RandomSource.create((long)(worldGenRegion.getSeed() + (long)chunkAccess.getPos().x * 341873128712L + (long)chunkAccess.getPos().z * 132897987541L));
        Mirror mirror = random.nextBoolean() ? Mirror.FRONT_BACK : Mirror.NONE;
        Rotation rotation = (Rotation)EntriesMappings.entries$0.get(random.nextInt(0, 4));
        double variantF1 = random.nextInt(1, 8);
        double variantF2 = random.nextInt(1, 6);
        double variantF3 = random.nextInt(1, 38);
        double variantF4 = random.nextInt(1, 7);
        boolean randomExtra = (double)random.nextFloat() >= 0.9875;
        boolean special = (double)random.nextFloat() <= 0.95;
        double d = variantF1;
        if (d == 1.0) {
            string3 = "clanvoidnew1";
        } else if (d == 2.0) {
            string3 = "clanvoidnew2";
        } else if (d == 3.0) {
            string3 = "clanvoidnew3";
        } else if (d == 4.0) {
            string3 = "clanvoidnew4";
        } else if (d == 5.0) {
            string3 = "clanvoidnew5";
        } else if (d == 6.0) {
            string3 = "clanvoidnew6";
        } else if (d == 7.0) {
            string3 = "clanvoidnew7";
        } else {
            throw new IndexOutOfBoundsException("How did we get here?");
        }
        String structureIdFloor1 = string3;
        double d2 = variantF2;
        if (d2 == 1.0) {
            string2 = "clandimensionroom1";
        } else if (d2 == 2.0) {
            string2 = "clandimensionroom2";
        } else if (d2 == 3.0) {
            string2 = "clandimensionroom3";
        } else if (d2 == 4.0) {
            string2 = "clandimensionroom3";
        } else if (d2 == 5.0) {
            string2 = special ? "clandimensionroom2" : "clandimensionroom5";
        } else {
            throw new IndexOutOfBoundsException("How did we get here?");
        }
        String structureIdFloor2 = string2;
        ResourceLocation resourceLocation = TBSConstants.id(structureIdFloor1);
        BlockPos blockPos = chunkAccess.getPos().getWorldPosition().atY(200);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"atY(...)");
        this.placeStructure(resourceLocation, worldGenRegion, blockPos, mirror, rotation, chunkAccess);
        ResourceLocation resourceLocation2 = TBSConstants.id(structureIdFloor2);
        BlockPos blockPos2 = chunkAccess.getPos().getWorldPosition().atY(207);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"atY(...)");
        this.placeStructure(resourceLocation2, worldGenRegion, blockPos2, mirror, rotation, chunkAccess);
        double d3 = variantF3;
        if (d3 == 1.0) {
            string = "woodfloor1";
        } else if (d3 == 2.0) {
            string = "woodfloor2";
        } else if (d3 == 3.0) {
            string = "woodfloor3";
        } else if (d3 == 4.0) {
            string = "woodfloor4";
        } else if (d3 == 5.0) {
            string = "woodfloor5";
        } else if (d3 == 6.0) {
            string = "woodfloor6";
        } else if (d3 == 7.0) {
            string = "woodfloor7";
        } else if (d3 == 8.0) {
            string = randomExtra ? "woodfloor8" : "woodfloor4";
        } else if (d3 == 9.0) {
            string = randomExtra ? "woodfloor9" : "woodfloor4";
        } else if (d3 == 10.0) {
            string = randomExtra ? "tek_woodfloor1" : "woodfloor1";
        } else if (d3 == 11.0) {
            string = randomExtra ? "tek_woodfloor2" : "woodfloor1";
        } else if (d3 == 12.0) {
            string = randomExtra ? "tek_woodfloor3" : "woodfloor2";
        } else if (d3 == 13.0) {
            string = randomExtra ? "tek_woodfloor4" : "woodfloor2";
        } else if (d3 == 14.0) {
            string = randomExtra ? "tek_woodfloor6" : "woodfloor3";
        } else if (d3 == 15.0) {
            string = randomExtra ? "tek_woodfloor7" : "woodfloor3";
        } else if (d3 == 16.0) {
            string = randomExtra ? "tek_woodfloor8" : "woodfloor4";
        } else if (d3 == 17.0) {
            string = randomExtra ? "tek_woodfloor9" : "woodfloor4";
        } else if (d3 == 18.0) {
            string = randomExtra ? "tek_woodfloor10" : "woodfloor1";
        } else if (d3 == 19.0) {
            string = "woodfloor1";
        } else if (d3 == 20.0) {
            string = randomExtra ? "tek_woodfloor12" : "woodfloor2";
        } else if (d3 == 21.0) {
            string = randomExtra ? "tek_woodfloor13" : "woodfloor2";
        } else if (d3 == 22.0) {
            string = randomExtra ? "tek_woodfloor14" : "woodfloor3";
        } else if (d3 == 23.0) {
            string = randomExtra ? "tek_woodfloor15" : "woodfloor3";
        } else if (d3 == 24.0) {
            string = randomExtra ? "tek_woodfloor16" : "woodfloor4";
        } else if (d3 == 25.0) {
            string = randomExtra ? "tek_woodfloor17" : "woodfloor4";
        } else if (d3 == 26.0) {
            string = randomExtra ? "tek_woodfloor18" : "woodfloor1";
        } else if (d3 == 27.0) {
            string = randomExtra ? "tek_woodfloor20" : "woodfloor2";
        } else if (d3 == 28.0) {
            string = randomExtra ? "tek_woodfloor21" : "woodfloor2";
        } else if (d3 == 29.0) {
            string = randomExtra ? "tek_woodfloor22" : "woodfloor3";
        } else if (d3 == 30.0) {
            string = randomExtra ? "tek_woodfloor23" : "woodfloor3";
        } else if (d3 == 31.0) {
            string = randomExtra ? "tek_woodfloor24" : "woodfloor4";
        } else if (d3 == 32.0) {
            string = randomExtra ? "tek_woodfloor25" : "woodfloor4";
        } else if (d3 == 33.0) {
            string = randomExtra ? "tek_woodfloor26" : "woodfloor1";
        } else if (d3 == 34.0) {
            string = randomExtra ? "tek_woodfloor27" : "woodfloor1";
        } else if (d3 == 35.0) {
            string = randomExtra ? "tek_woodfloor28" : "woodfloor2";
        } else if (d3 == 36.0) {
            string = "woodfloor2";
        } else if (d3 == 37.0) {
            string = "woodfloor6";
        } else {
            throw new IndexOutOfBoundsException("How did we get here?");
        }
        String structureIdFloor3 = string;
        ResourceLocation resourceLocation3 = TBSConstants.id(structureIdFloor3);
        BlockPos blockPos3 = chunkAccess.getPos().getWorldPosition().atY(217);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos3, (String)"atY(...)");
        this.placeStructure(resourceLocation3, worldGenRegion, blockPos3, mirror, rotation, chunkAccess);
        String structureIdFloor4 = "stone1";
        if (special && (double)random.nextFloat() < 0.05) {
            String string4;
            double d4 = variantF4;
            if (d4 == 1.0) {
                string4 = "stone2";
            } else if (d4 == 2.0) {
                string4 = "stone3";
            } else if (d4 == 3.0) {
                string4 = "stone4";
            } else if (d4 == 4.0) {
                string4 = "stone5";
            } else if (d4 == 5.0) {
                string4 = "stone6";
            } else if (d4 == 6.0) {
                string4 = "stone7";
            } else {
                throw new IndexOutOfBoundsException("How did we get here?");
            }
            structureIdFloor4 = string4;
        }
        ResourceLocation resourceLocation4 = TBSConstants.id(structureIdFloor4);
        BlockPos blockPos4 = chunkAccess.getPos().getWorldPosition().atY(233);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos4, (String)"atY(...)");
        this.placeStructure(resourceLocation4, worldGenRegion, blockPos4, mirror, rotation, chunkAccess);
    }

    public final void genSurface(@NotNull WorldGenLevel worldGenRegion, @NotNull ChunkAccess chunkAccess) {
        Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        RandomSource random = RandomSource.create((long)(worldGenRegion.getSeed() + (long)chunkAccess.getPos().x * 341873128712L + (long)chunkAccess.getPos().z * 132897987541L));
        Mirror mirror = random.nextBoolean() ? Mirror.FRONT_BACK : Mirror.NONE;
        Rotation rotation = (Rotation)EntriesMappings.entries$0.get(random.nextInt(0, 4));
        String structureId = (double)random.nextFloat() < 0.99 ? "fieldbase" : "fieldbase2";
        ResourceLocation resourceLocation = TBSConstants.id(structureId);
        BlockPos blockPos = chunkAccess.getPos().getWorldPosition().atY(252);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"atY(...)");
        this.placeStructure(resourceLocation, worldGenRegion, blockPos, mirror, rotation, chunkAccess);
    }

    @NotNull
    public final List<Block> getIgnoreBlock() {
        return this.ignoreBlock;
    }

    public final void placeStructure(@NotNull ResourceLocation structureId, @NotNull WorldGenLevel region, @NotNull BlockPos pos, @NotNull Mirror mirror, @NotNull Rotation rotation, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)structureId, (String)"structureId");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)mirror, (String)"mirror");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        MinecraftServer minecraftServer = region.getServer();
        Intrinsics.checkNotNull((Object)minecraftServer);
        ServerLevel serverLevel = minecraftServer.getLevel(TBSDimensions.CLAN_VOID);
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
        BlockPos transformedOrigin = template.getZeroPositionWithTransform(pos, mirror, rotation);
        int genMinX = chunkPos.getMinBlockX() - 16;
        int genMaxX = chunkPos.getMaxBlockX() + 16;
        int genMinZ = chunkPos.getMinBlockZ() - 16;
        int genMaxZ = chunkPos.getMaxBlockZ() + 16;
        BoundingBox boundingBox = new BoundingBox(genMinX, level.getMinBuildHeight(), genMinZ, genMaxX, level.getMaxBuildHeight(), genMaxZ);
        StructurePlaceSettings settings = new StructurePlaceSettings().setIgnoreEntities(false).setMirror(mirror).setRotation(rotation).setBoundingBox(boundingBox).addProcessor((StructureProcessor)new BlockIgnoreProcessor(this.ignoreBlock));
        template.placeInWorld((ServerLevelAccessor)region, transformedOrigin, transformedOrigin, settings, region.getRandom(), 3);
    }

    public final void genTunnel(@NotNull WorldGenLevel worldGenRegion, @NotNull ChunkAccess chunkAccess) {
        String string;
        Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        RandomSource randomSource = RandomSource.create();
        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"create(...)");
        RandomSource random = randomSource;
        if (random.nextFloat() < 0.9f) {
            string = "bedrockhallway1";
        } else {
            Object[] objectArray = new String[]{"bedrockhallway2", "bedrockhallway3", "bedrockhallway4", "bedrockhallway5", "bedrockhallway6", "bedrockhallway7", "bedrockhallway8", "bedrockhallway9", "bedrockhallway10"};
            string = (String)CollectionsKt.random((Collection)CollectionsKt.listOf((Object[])objectArray), (Random)((Random)Random.Default));
        }
        String structureId = string;
        ResourceLocation resourceLocation = TBSConstants.id(structureId);
        BlockPos blockPos = chunkAccess.getPos().getWorldPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getWorldPosition(...)");
        this.placeStructure(resourceLocation, worldGenRegion, PositionUtil.withY((BlockPos)blockPos, (Number)160), Mirror.NONE, Rotation.NONE, chunkAccess);
    }

    public final void genNowhere(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunkAccess, int yOffset, int xOffset, int zOffset, long randomOffset, int divider) {
        int y;
        int n;
        int targetChunkX;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        if (divider == 0) {
            throw new IllegalArgumentException("divider can't be 0");
        }
        List voronoiPoints = new ArrayList();
        for (int chunkOffsetX = -1; chunkOffsetX < 2; ++chunkOffsetX) {
            for (int chunkOffsetZ = -1; chunkOffsetZ < 2; ++chunkOffsetZ) {
                targetChunkX = chunkAccess.getPos().x + chunkOffsetX;
                int targetChunkZ = chunkAccess.getPos().z + chunkOffsetZ;
                RandomSource random = RandomSource.create((long)(level.getSeed() + (long)targetChunkX * randomOffset + (long)targetChunkZ * (randomOffset / (long)divider) + (long)yOffset * 123456789L));
                int numPoints = random.nextInt(3, 6);
                int chunkCenterX = targetChunkX * 16 + 8 + xOffset;
                int chunkCenterZ = targetChunkZ * 16 + 8 + zOffset;
                double minDistanceBetweenPoints = 8.0;
                int maxAttempts = 50;
                for (int i = 0; i < numPoints; ++i) {
                    boolean bl;
                    int pointZ;
                    int pointX;
                    int it = i;
                    boolean bl2 = false;
                    HolePoint validPoint = null;
                    for (int attempts = 0; attempts < maxAttempts; ++attempts) {
                        boolean tooClose;
                        HolePoint candidate;
                        block34: {
                            pointX = chunkCenterX + random.nextInt(-16, 16);
                            pointZ = chunkCenterZ + random.nextInt(-16, 16);
                            candidate = new HolePoint(pointX, pointZ);
                            Iterable $this$any$iv = voronoiPoints;
                            boolean $i$f$any = false;
                            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                v0 = false;
                            } else {
                                for (Object element$iv : $this$any$iv) {
                                    int dz;
                                    HolePoint existing = (HolePoint)element$iv;
                                    boolean bl3 = false;
                                    int dx = candidate.getX() - existing.getX();
                                    if (!(Math.sqrt(dx * dx + (dz = candidate.getZ() - existing.getZ()) * dz) < minDistanceBetweenPoints)) continue;
                                    v0 = true;
                                    break block34;
                                }
                                v0 = tooClose = false;
                            }
                        }
                        if (tooClose) continue;
                        validPoint = candidate;
                        break;
                    }
                    if (validPoint != null) {
                        bl = voronoiPoints.add(validPoint);
                        continue;
                    }
                    pointX = chunkCenterX + random.nextInt(-16, 16);
                    pointZ = chunkCenterZ + random.nextInt(-16, 16);
                    bl = voronoiPoints.add(new HolePoint(pointX, pointZ));
                }
            }
        }
        Map isSolidMap = new LinkedHashMap();
        int x = chunkAccess.getPos().getMinBlockX();
        if (x <= (targetChunkX = chunkAccess.getPos().getMaxBlockX())) {
            while (true) {
                int random;
                int z;
                if ((z = chunkAccess.getPos().getMinBlockZ()) <= (random = chunkAccess.getPos().getMaxBlockZ())) {
                    while (true) {
                        double minDist = Double.MAX_VALUE;
                        double secondMinDist = Double.MAX_VALUE;
                        for (HolePoint point : voronoiPoints) {
                            double dist = Math.sqrt((x - point.getX()) * (x - point.getX()) + (z - point.getZ()) * (z - point.getZ()));
                            if (dist < minDist) {
                                secondMinDist = minDist;
                                minDist = dist;
                                continue;
                            }
                            if (!(dist < secondMinDist)) continue;
                            secondMinDist = dist;
                        }
                        double edgeDistance = Math.abs(secondMinDist - minDist);
                        double pathwayThickness = 2.895;
                        double minHoleRadius = 3.0;
                        boolean isInHole = minDist < minHoleRadius;
                        Map map = isSolidMap;
                        Pair pair = new Pair((Object)x, (Object)z);
                        Boolean bl = edgeDistance < pathwayThickness && !isInHole;
                        map.put(pair, bl);
                        if (z == random) break;
                        ++z;
                    }
                }
                if (x == targetChunkX) break;
                ++x;
            }
        }
        Map fixedSolidMap = new LinkedHashMap();
        int x2 = chunkAccess.getPos().getMinBlockX();
        if (x2 <= (n = chunkAccess.getPos().getMaxBlockX())) {
            while (true) {
                int n2;
                int z;
                if ((z = chunkAccess.getPos().getMinBlockZ()) <= (n2 = chunkAccess.getPos().getMaxBlockZ())) {
                    while (true) {
                        boolean currentIsSolid;
                        Boolean bl = (Boolean)isSolidMap.get(new Pair((Object)x2, (Object)z));
                        boolean bl4 = currentIsSolid = bl != null ? bl : false;
                        if (!currentIsSolid) {
                            int n3;
                            Object[] minDistanceBetweenPoints = new Boolean[8];
                            Boolean bl5 = (Boolean)isSolidMap.get(new Pair((Object)(x2 + 1), (Object)z));
                            minDistanceBetweenPoints[0] = bl5 != null ? bl5 : true;
                            Boolean bl6 = (Boolean)isSolidMap.get(new Pair((Object)(x2 - 1), (Object)z));
                            minDistanceBetweenPoints[1] = bl6 != null ? bl6 : true;
                            Boolean bl7 = (Boolean)isSolidMap.get(new Pair((Object)x2, (Object)(z + 1)));
                            minDistanceBetweenPoints[2] = bl7 != null ? bl7 : true;
                            Boolean bl8 = (Boolean)isSolidMap.get(new Pair((Object)x2, (Object)(z - 1)));
                            minDistanceBetweenPoints[3] = bl8 != null ? bl8 : true;
                            Boolean bl9 = (Boolean)isSolidMap.get(new Pair((Object)(x2 + 1), (Object)(z + 1)));
                            minDistanceBetweenPoints[4] = bl9 != null ? bl9 : true;
                            Boolean bl10 = (Boolean)isSolidMap.get(new Pair((Object)(x2 + 1), (Object)(z - 1)));
                            minDistanceBetweenPoints[5] = bl10 != null ? bl10 : true;
                            Boolean bl11 = (Boolean)isSolidMap.get(new Pair((Object)(x2 - 1), (Object)(z + 1)));
                            minDistanceBetweenPoints[6] = bl11 != null ? bl11 : true;
                            Boolean bl12 = (Boolean)isSolidMap.get(new Pair((Object)(x2 - 1), (Object)(z - 1)));
                            minDistanceBetweenPoints[7] = bl12 != null ? bl12 : true;
                            List surroundingSolids = CollectionsKt.listOf((Object[])minDistanceBetweenPoints);
                            $this$count$iv = surroundingSolids;
                            boolean $i$f$count = false;
                            if ($this$count$iv instanceof Collection && ((Collection)$this$count$iv).isEmpty()) {
                                n3 = 0;
                            } else {
                                int count$iv = 0;
                                Iterator iterator = $this$count$iv.iterator();
                                while (iterator.hasNext()) {
                                    Object element$iv = iterator.next();
                                    boolean it = (Boolean)element$iv;
                                    boolean bl13 = false;
                                    if (!it || ++count$iv >= 0) continue;
                                    CollectionsKt.throwCountOverflow();
                                }
                                n3 = count$iv;
                            }
                            int solidCount = n3;
                            $this$count$iv = fixedSolidMap;
                            Pair pair = new Pair((Object)x2, (Object)z);
                            Boolean bl14 = solidCount >= 6;
                            $this$count$iv.put(pair, bl14);
                        } else {
                            Map map = fixedSolidMap;
                            Pair solidCount = new Pair((Object)x2, (Object)z);
                            $this$count$iv = true;
                            map.put(solidCount, $this$count$iv);
                        }
                        if (z == n2) break;
                        ++z;
                    }
                }
                if (x2 == n) break;
                ++x2;
            }
        }
        if ((y = yOffset) <= (n = yOffset + 3)) {
            while (true) {
                int n4;
                int x3;
                if ((x3 = chunkAccess.getPos().getMinBlockX()) <= (n4 = chunkAccess.getPos().getMaxBlockX())) {
                    while (true) {
                        int n5;
                        int z;
                        if ((z = chunkAccess.getPos().getMinBlockZ()) <= (n5 = chunkAccess.getPos().getMaxBlockZ())) {
                            while (true) {
                                Boolean bl = (Boolean)fixedSolidMap.get(new Pair((Object)x3, (Object)z));
                                boolean isSolid = bl != null ? bl : false;
                                BlockPos pos = new BlockPos(x3, y, z);
                                if (level.ensureCanWrite(pos)) {
                                    if (isSolid && level.getBlockState(pos).isAir()) {
                                        level.setBlock(pos, Blocks.MUD.defaultBlockState(), 3);
                                    } else if (level.getBlockState(pos).isAir()) {
                                        level.setBlock(pos, Blocks.BARRIER.defaultBlockState(), 3);
                                    }
                                }
                                if (z == n5) break;
                                ++z;
                            }
                        }
                        if (x3 == n4) break;
                        ++x3;
                    }
                }
                if (y == n) break;
                ++y;
            }
        }
    }

    public void buildSurface(@NotNull WorldGenRegion level, @NotNull StructureManager structureManager, @NotNull RandomState random, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        int chunkX = chunk.getPos().getWorldPosition().getX();
        int chunkZ = chunk.getPos().getWorldPosition().getZ();
        boolean bl = 0 <= chunkX ? chunkX < 161 : false;
        if (bl) {
            boolean bl2 = 0 <= chunkZ ? chunkZ < 161 : false;
            if (bl2) {
                boolean isBorder;
                boolean bl3 = isBorder = chunkX == 0 || chunkX == 160 || chunkZ == 0 || chunkZ == 160;
                if (!isBorder) {
                    this.genSurface((WorldGenLevel)level, chunk);
                    this.genFloor((WorldGenLevel)level, chunk, 199, (Block)TBSBlocks.INSTANCE.getCOBBLESTONE_BORDER_BLOCK().get());
                    WorldGenLevel worldGenLevel = (WorldGenLevel)level;
                    Block block = Blocks.BEDROCK;
                    Intrinsics.checkNotNullExpressionValue((Object)block, (String)"BEDROCK");
                    this.genFloor(worldGenLevel, chunk, 160, block);
                    this.genBarrier((WorldGenLevel)level, chunk, 251);
                    this.genBarrier((WorldGenLevel)level, chunk, 232);
                    this.genBarrier((WorldGenLevel)level, chunk, 216);
                    this.genBarrier((WorldGenLevel)level, chunk, 206);
                    this.genBarrier((WorldGenLevel)level, chunk, 102);
                    this.genNowhere((WorldGenLevel)level, chunk, 100, 0, 0, 341873128712L, 1);
                } else {
                    this.genBorders((WorldGenLevel)level, chunk);
                }
            }
        }
        boolean bl4 = 0 <= chunkX ? chunkX < 162 : false;
        if (bl4) {
            boolean bl5 = 0 <= chunkZ ? chunkZ < 162 : false;
            if (bl5) {
                this.genBarrier((WorldGenLevel)level, chunk, 271);
            }
        }
    }

    public final void resetOccupancy() {
        this.occupiedChunks.clear();
    }

    public void applyBiomeDecoration(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, @NotNull StructureManager structureManager) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        int chunkX = chunk.getPos().getWorldPosition().getX();
        int chunkZ = chunk.getPos().getWorldPosition().getZ();
        boolean bl = 0 <= chunkX ? chunkX < 161 : false;
        if (bl) {
            boolean bl2 = 0 <= chunkZ ? chunkZ < 161 : false;
            if (bl2) {
                boolean isBorder;
                boolean bl3 = isBorder = chunkX == 0 || chunkX == 160 || chunkZ == 0 || chunkZ == 160;
                if (!isBorder) {
                    this.genRoom(level, chunk);
                    super.applyBiomeDecoration(level, chunk, structureManager);
                }
                if (chunkX == 80 && chunkZ != 0 && chunkZ != 160) {
                    this.genTunnel(level, chunk);
                }
            }
        }
    }

    public final void genBorders(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        int chunkX = chunk.getPos().getWorldPosition().getX();
        int chunkZ = chunk.getPos().getWorldPosition().getZ();
        ChunkPos chunkPos = chunk.getPos();
        int xMod = chunkX % 160;
        int zMod = chunkZ % 160;
        int minY = level.getMinBuildHeight();
        int maxY = 270;
        BlockState wallMaterial = null;
        BlockState borderMaterial = Blocks.BARRIER.defaultBlockState();
        boolean isXBorder = xMod == 0;
        boolean isZBorder = zMod == 0;
        int y = minY;
        if (y <= maxY) {
            while (true) {
                Intrinsics.checkNotNullExpressionValue((Object)((R3Block)((Object)TBSBlocks.R_3.get())).defaultBlockState(), (String)"defaultBlockState(...)");
                if (isXBorder) {
                    for (int z = 0; z < 16; ++z) {
                        chunk.setBlockState(new BlockPos(chunkPos.getMinBlockX() + 0, y, chunkPos.getMinBlockZ() + z), wallMaterial, false);
                        chunk.setBlockState(new BlockPos(chunkPos.getMinBlockX() + 1, y, chunkPos.getMinBlockZ() + z), borderMaterial, false);
                        chunk.setBlockState(new BlockPos(chunkPos.getMinBlockX() + 15, y, chunkPos.getMinBlockZ() + z), wallMaterial, false);
                        chunk.setBlockState(new BlockPos(chunkPos.getMinBlockX() + 14, y, chunkPos.getMinBlockZ() + z), borderMaterial, false);
                    }
                }
                if (isZBorder) {
                    for (int x = 0; x < 16; ++x) {
                        chunk.setBlockState(new BlockPos(chunkPos.getMinBlockX() + x, y, chunkPos.getMinBlockZ() + 0), wallMaterial, false);
                        chunk.setBlockState(new BlockPos(chunkPos.getMinBlockX() + x, y, chunkPos.getMinBlockZ() + 1), borderMaterial, false);
                        chunk.setBlockState(new BlockPos(chunkPos.getMinBlockX() + x, y, chunkPos.getMinBlockZ() + 15), wallMaterial, false);
                        chunk.setBlockState(new BlockPos(chunkPos.getMinBlockX() + x, y, chunkPos.getMinBlockZ() + 14), borderMaterial, false);
                    }
                }
                if (y == maxY) break;
                ++y;
            }
        }
    }

    public final void genFloor(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, int y, @NotNull Block block) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)block, (String)"block");
        int x = chunk.getPos().getMinBlockX();
        int n = chunk.getPos().getMaxBlockX();
        if (x <= n) {
            while (true) {
                int n2;
                int z;
                if ((z = chunk.getPos().getMinBlockZ()) <= (n2 = chunk.getPos().getMaxBlockZ())) {
                    while (true) {
                        BlockPos pos;
                        if (level.ensureCanWrite(pos = new BlockPos(x, y, z))) {
                            level.setBlock(pos, block.defaultBlockState(), 3);
                            level.setBlock(pos.below(), Blocks.BARRIER.defaultBlockState(), 3);
                        }
                        if (z == n2) break;
                        ++z;
                    }
                }
                if (x == n) break;
                ++x;
            }
        }
    }

    public final void genBarrier(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, int y) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        int x = chunk.getPos().getMinBlockX();
        int n = chunk.getPos().getMaxBlockX();
        if (x <= n) {
            while (true) {
                int n2;
                int z;
                if ((z = chunk.getPos().getMinBlockZ()) <= (n2 = chunk.getPos().getMaxBlockZ())) {
                    while (true) {
                        BlockPos pos;
                        if (level.ensureCanWrite(pos = new BlockPos(x, y, z))) {
                            level.setBlock(pos, Blocks.BARRIER.defaultBlockState(), 3);
                        }
                        if (z == n2) break;
                        ++z;
                    }
                }
                if (x == n) break;
                ++x;
            }
        }
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

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        return instance.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(Stage2Generator::CODEC$lambda$0$0)).apply((Applicative)instance, Stage2Generator::new);
    }

    private static final BiomeSource CODEC$lambda$0$0(Stage2Generator it) {
        return it.biomeSource;
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(Stage2Generator::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/world/dimension/boss/stage2/Stage2Generator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/boss/stage2/Stage2Generator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "ROOM_MIN", "", "ROOM_MAX", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<Stage2Generator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Rotation> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Rotation.values()));
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/world/dimension/boss/stage2/Stage2Generator$HolePoint;", "", "x", "", "z", "<init>", "(II)V", "getX", "()I", "getZ", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "thebrokenscript-common"})
    public static final class HolePoint {
        private final int x;
        private final int z;

        public HolePoint(int x, int z) {
            this.x = x;
            this.z = z;
        }

        public final int getX() {
            return this.x;
        }

        public final int getZ() {
            return this.z;
        }

        public final int component1() {
            return this.x;
        }

        public final int component2() {
            return this.z;
        }

        @NotNull
        public final HolePoint copy(int x, int z) {
            return new HolePoint(x, z);
        }

        public static /* synthetic */ HolePoint copy$default(HolePoint holePoint, int n, int n2, int n3, Object object) {
            if ((n3 & 1) != 0) {
                n = holePoint.x;
            }
            if ((n3 & 2) != 0) {
                n2 = holePoint.z;
            }
            return holePoint.copy(n, n2);
        }

        @NotNull
        public String toString() {
            return "HolePoint(x=" + this.x + ", z=" + this.z + ")";
        }

        public int hashCode() {
            int result = Integer.hashCode(this.x);
            result = result * 31 + Integer.hashCode(this.z);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HolePoint)) {
                return false;
            }
            HolePoint holePoint = (HolePoint)other;
            if (this.x != holePoint.x) {
                return false;
            }
            return this.z == holePoint.z;
        }
    }
}

