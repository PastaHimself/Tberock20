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
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.biome.BiomeManager
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.GenerationStep$Carving
 *  net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
 *  net.minecraft.world.level.levelgen.NoiseGeneratorSettings
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.clan_void;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 >2\u00020\u0001:\u0001>B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J@\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020'J(\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010%\u001a\u00020\u0013H\u0016J \u0010/\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,H\u0016J@\u00100\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020\u00132\u0006\u00104\u001a\u000205H\u0016J0\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020.2\u0006\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0<H\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006?"}, d2={"Lnet/thebrokenscript/world/dimension/clan_void/ClanVoidGenerator;", "Lnet/minecraft/world/level/levelgen/NoiseBasedChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "settings", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/level/levelgen/NoiseGeneratorSettings;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;Lnet/minecraft/core/Holder;)V", "occupiedChunks", "", "", "getOccupiedChunks", "()Ljava/util/Set;", "genRoom", "", "worldGenRegion", "Lnet/minecraft/world/level/WorldGenLevel;", "chunkAccess", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "genSurface", "ignoreBlock", "", "Lnet/minecraft/world/level/block/Block;", "kotlin.jvm.PlatformType", "getIgnoreBlock", "()Ljava/util/List;", "placeStructure", "structureId", "Lnet/minecraft/resources/ResourceLocation;", "region", "pos", "Lnet/minecraft/core/BlockPos;", "mirror", "Lnet/minecraft/world/level/block/Mirror;", "rotation", "Lnet/minecraft/world/level/block/Rotation;", "chunk", "isRooms", "", "buildSurface", "level", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "random", "Lnet/minecraft/world/level/levelgen/RandomState;", "applyBiomeDecoration", "applyCarvers", "seed", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "step", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "fillFromNoise", "Ljava/util/concurrent/CompletableFuture;", "blender", "Lnet/minecraft/world/level/levelgen/blending/Blender;", "randomState", "codec", "Lcom/mojang/serialization/MapCodec;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "Companion", "thebrokenscript-common"})
public final class ClanVoidGenerator
extends NoiseBasedChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Set<Long> occupiedChunks;
    @NotNull
    private final List<Block> ignoreBlock;
    @NotNull
    private static final MapCodec<ClanVoidGenerator> CODEC;

    public ClanVoidGenerator(@NotNull BiomeSource biomeSource, @NotNull Holder<NoiseGeneratorSettings> settings) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        Intrinsics.checkNotNullParameter(settings, (String)"settings");
        super(biomeSource, settings);
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

    /*
     * Unable to fully structure code
     */
    public final void genRoom(@NotNull WorldGenLevel worldGenRegion, @NotNull ChunkAccess chunkAccess) {
        block149: {
            block148: {
                block147: {
                    block146: {
                        block145: {
                            Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
                            Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
                            random = RandomSource.create((long)(worldGenRegion.getSeed() + (long)chunkAccess.getPos().x * 341873128712L + (long)chunkAccess.getPos().z * 132897987541L));
                            mirror = random.nextBoolean() != false ? Mirror.FRONT_BACK : Mirror.NONE;
                            rotation = (Rotation)EntriesMappings.entries$0.get(random.nextInt(0, 4));
                            v0 = chunkAccess.getPos().getWorldPosition().getX();
                            v1 = worldGenRegion.getLevel();
                            Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"getLevel(...)");
                            if (v0 != LevelExt.INSTANCE.getVars((LevelAccessor)v1).getClanVoidX()) break block145;
                            v2 = chunkAccess.getPos().getWorldPosition().getZ();
                            v3 = worldGenRegion.getLevel();
                            Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getLevel(...)");
                            if (v2 == LevelExt.INSTANCE.getVars((LevelAccessor)v3).getClanVoidZ()) ** GOTO lbl-1000
                        }
                        if ((double)random.nextFloat() < 0.03) {
                            v4 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v4 = shouldMakeIntersection = false;
                        }
                        if (shouldMakeIntersection) {
                            v5 = TBSConstants.id("clanvoidintersection");
                            v6 = chunkAccess.getPos().getWorldPosition().atY(200);
                            Intrinsics.checkNotNullExpressionValue((Object)v6, (String)"atY(...)");
                            ClanVoidGenerator.placeStructure$default(this, v5, worldGenRegion, v6, mirror, rotation, chunkAccess, false, 64, null);
                        }
                        variantF1 = random.nextInt(1, 9);
                        variantF2 = random.nextInt(1, 6);
                        variantF3 = random.nextInt(1, 38);
                        variantF4 = random.nextInt(1, 13);
                        randomExtra = (double)random.nextFloat() >= 0.9875;
                        special = (double)random.nextFloat() <= 0.95;
                        isRooms = false;
                        var19_14 = variantF1;
                        if (var19_14 == 1.0) {
                            v7 = "clanvoidnew1";
                        } else if (var19_14 == 2.0) {
                            v7 = "clanvoidnew2";
                        } else if (var19_14 == 3.0) {
                            v7 = "clanvoidnew3";
                        } else if (var19_14 == 4.0) {
                            v7 = "clanvoidnew4";
                        } else if (var19_14 == 5.0) {
                            v7 = "clanvoidnew5";
                        } else if (var19_14 == 6.0) {
                            v7 = "clanvoidnew6";
                        } else if (var19_14 == 7.0) {
                            v7 = "clanvoidnew7";
                        } else if (var19_14 == 8.0) {
                            isRooms = true;
                            v7 = "clan_void_rooms";
                        } else {
                            throw new IndexOutOfBoundsException("How did we get here?");
                        }
                        structureIdFloor1 = v7;
                        v8 = chunkAccess.getPos().getWorldPosition().getX();
                        v9 = worldGenRegion.getLevel();
                        Intrinsics.checkNotNullExpressionValue((Object)v9, (String)"getLevel(...)");
                        if (v8 == LevelExt.INSTANCE.getVars((LevelAccessor)v9).getClanVoidX()) {
                            v10 = chunkAccess.getPos().getWorldPosition().getZ();
                            v11 = worldGenRegion.getLevel();
                            Intrinsics.checkNotNullExpressionValue((Object)v11, (String)"getLevel(...)");
                            if (v10 == LevelExt.INSTANCE.getVars((LevelAccessor)v11).getClanVoidZ()) {
                                structureIdFloor1 = "clanvoidpredetermined";
                            }
                        }
                        if ((var20_17 = variantF2) == 1.0) {
                            v12 = "clandimensionroom1";
                        } else if (var20_17 == 2.0) {
                            v12 = "clandimensionroom2";
                        } else if (var20_17 == 3.0) {
                            v12 = "clandimensionroom3";
                        } else if (var20_17 == 4.0) {
                            v12 = special ? "clandimensionroom3" : "clandimensionroom4";
                        } else if (var20_17 == 5.0) {
                            v12 = special ? "clandimensionroom2" : "clandimensionroom5";
                        } else {
                            throw new IndexOutOfBoundsException("How did we get here?");
                        }
                        structureIdFloor2 = v12;
                        if (!shouldMakeIntersection) break block146;
                        v13 = chunkAccess.getPos().getWorldPosition().getX();
                        v14 = worldGenRegion.getLevel();
                        Intrinsics.checkNotNullExpressionValue((Object)v14, (String)"getLevel(...)");
                        if (v13 != LevelExt.INSTANCE.getVars((LevelAccessor)v14).getMazeFloorX()) break block147;
                        v15 = chunkAccess.getPos().getWorldPosition().getZ();
                        v16 = worldGenRegion.getLevel();
                        Intrinsics.checkNotNullExpressionValue((Object)v16, (String)"getLevel(...)");
                        if (v15 != LevelExt.INSTANCE.getVars((LevelAccessor)v16).getMazeFloorZ()) break block147;
                    }
                    if (!((double)random.nextFloat() < 0.03)) ** GOTO lbl-1000
                    v17 = chunkAccess.getPos().getWorldPosition().getX();
                    v18 = worldGenRegion.getLevel();
                    Intrinsics.checkNotNullExpressionValue((Object)v18, (String)"getLevel(...)");
                    if (v17 != LevelExt.INSTANCE.getVars((LevelAccessor)v18).getMazeFloorX()) ** GOTO lbl-1000
                    v19 = chunkAccess.getPos().getWorldPosition().getZ();
                    v20 = worldGenRegion.getLevel();
                    Intrinsics.checkNotNullExpressionValue((Object)v20, (String)"getLevel(...)");
                    if (v19 != LevelExt.INSTANCE.getVars((LevelAccessor)v20).getMazeFloorZ()) lbl-1000:
                    // 2 sources

                    {
                        structureIdFloor2 = random.nextBoolean() != false ? "woodfloorintersection" : "tek_woodfloor5";
                    } else lbl-1000:
                    // 2 sources

                    {
                        v21 = chunkAccess.getPos().getWorldPosition().getX();
                        v22 = worldGenRegion.getLevel();
                        Intrinsics.checkNotNullExpressionValue((Object)v22, (String)"getLevel(...)");
                        if (v21 == LevelExt.INSTANCE.getVars((LevelAccessor)v22).getMazeFloorX()) {
                            v23 = chunkAccess.getPos().getWorldPosition().getZ();
                            v24 = worldGenRegion.getLevel();
                            Intrinsics.checkNotNullExpressionValue((Object)v24, (String)"getLevel(...)");
                            if (v23 == LevelExt.INSTANCE.getVars((LevelAccessor)v24).getMazeFloorZ()) {
                                structureIdFloor2 = "mazepredetermined";
                            }
                        }
                    }
                    v25 = TBSConstants.id(structureIdFloor1);
                    v26 = chunkAccess.getPos().getWorldPosition().atY(200);
                    Intrinsics.checkNotNullExpressionValue((Object)v26, (String)"atY(...)");
                    this.placeStructure(v25, worldGenRegion, v26, mirror, rotation, chunkAccess, isRooms);
                    v27 = TBSConstants.id(structureIdFloor2);
                    v28 = chunkAccess.getPos().getWorldPosition().atY(206);
                    Intrinsics.checkNotNullExpressionValue((Object)v28, (String)"atY(...)");
                    ClanVoidGenerator.placeStructure$default(this, v27, worldGenRegion, v28, mirror, rotation, chunkAccess, false, 64, null);
                }
                v29 = chunkAccess.getPos().getWorldPosition().getX();
                v30 = worldGenRegion.getLevel();
                Intrinsics.checkNotNullExpressionValue((Object)v30, (String)"getLevel(...)");
                if (v29 != LevelExt.INSTANCE.getVars((LevelAccessor)v30).getWoodenFloorX()) ** GOTO lbl-1000
                v31 = chunkAccess.getPos().getWorldPosition().getZ();
                v32 = worldGenRegion.getLevel();
                Intrinsics.checkNotNullExpressionValue((Object)v32, (String)"getLevel(...)");
                if (v31 == LevelExt.INSTANCE.getVars((LevelAccessor)v32).getWoodenFloorZ()) {
                    v33 = false;
                } else lbl-1000:
                // 2 sources

                {
                    v33 = (double)random.nextFloat() < 0.03;
                }
                stoneFloorIntersection = v33;
                v34 = chunkAccess.getPos().getWorldPosition().getX();
                v35 = worldGenRegion.getLevel();
                Intrinsics.checkNotNullExpressionValue((Object)v35, (String)"getLevel(...)");
                if (v34 != LevelExt.INSTANCE.getVars((LevelAccessor)v35).getWoodenFloorX()) ** GOTO lbl-1000
                v36 = chunkAccess.getPos().getWorldPosition().getZ();
                v37 = worldGenRegion.getLevel();
                Intrinsics.checkNotNullExpressionValue((Object)v37, (String)"getLevel(...)");
                if (v36 == LevelExt.INSTANCE.getVars((LevelAccessor)v37).getWoodenFloorZ()) {
                    v38 = TBSConstants.id("woodpredetermined");
                    v39 = chunkAccess.getPos().getWorldPosition().atY(215);
                    Intrinsics.checkNotNullExpressionValue((Object)v39, (String)"atY(...)");
                    ClanVoidGenerator.placeStructure$default(this, v38, worldGenRegion, v39, mirror, rotation, chunkAccess, false, 64, null);
                } else if (!stoneFloorIntersection) {
                    var22_19 = variantF3;
                    if (var22_19 == 1.0) {
                        v40 = "woodfloor1";
                    } else if (var22_19 == 2.0) {
                        v40 = "woodfloor2";
                    } else if (var22_19 == 3.0) {
                        v40 = "woodfloor3";
                    } else if (var22_19 == 4.0) {
                        v40 = "woodfloor4";
                    } else if (var22_19 == 5.0) {
                        v40 = "woodfloor5";
                    } else if (var22_19 == 6.0) {
                        v40 = "woodfloor6";
                    } else if (var22_19 == 7.0) {
                        v40 = "woodfloor7";
                    } else if (var22_19 == 8.0) {
                        v40 = randomExtra ? "woodfloor8" : "woodfloor4";
                    } else if (var22_19 == 9.0) {
                        v40 = randomExtra ? "woodfloor9" : "woodfloor4";
                    } else if (var22_19 == 10.0) {
                        v40 = randomExtra ? "tek_woodfloor1" : "woodfloor1";
                    } else if (var22_19 == 11.0) {
                        v40 = randomExtra ? "tek_woodfloor2" : "woodfloor1";
                    } else if (var22_19 == 12.0) {
                        v40 = randomExtra ? "tek_woodfloor3" : "woodfloor2";
                    } else if (var22_19 == 13.0) {
                        v40 = randomExtra ? "tek_woodfloor4" : "woodfloor2";
                    } else if (var22_19 == 14.0) {
                        v40 = randomExtra ? "tek_woodfloor6" : "woodfloor3";
                    } else if (var22_19 == 15.0) {
                        v40 = randomExtra ? "tek_woodfloor7" : "woodfloor3";
                    } else if (var22_19 == 16.0) {
                        v40 = randomExtra ? "tek_woodfloor8" : "woodfloor4";
                    } else if (var22_19 == 17.0) {
                        v40 = randomExtra ? "tek_woodfloor9" : "woodfloor4";
                    } else if (var22_19 == 18.0) {
                        v40 = randomExtra ? "tek_woodfloor10" : "woodfloor1";
                    } else if (var22_19 == 19.0) {
                        v40 = randomExtra ? "tek_woodfloor11" : "woodfloor1";
                    } else if (var22_19 == 20.0) {
                        v40 = randomExtra ? "tek_woodfloor12" : "woodfloor2";
                    } else if (var22_19 == 21.0) {
                        v40 = randomExtra ? "tek_woodfloor13" : "woodfloor2";
                    } else if (var22_19 == 22.0) {
                        v40 = randomExtra ? "tek_woodfloor14" : "woodfloor3";
                    } else if (var22_19 == 23.0) {
                        v40 = randomExtra ? "tek_woodfloor15" : "woodfloor3";
                    } else if (var22_19 == 24.0) {
                        v40 = randomExtra ? "tek_woodfloor16" : "woodfloor4";
                    } else if (var22_19 == 25.0) {
                        v40 = randomExtra ? "tek_woodfloor17" : "woodfloor4";
                    } else if (var22_19 == 26.0) {
                        v40 = randomExtra ? "tek_woodfloor18" : "woodfloor1";
                    } else if (var22_19 == 27.0) {
                        v40 = randomExtra ? "tek_woodfloor20" : "woodfloor2";
                    } else if (var22_19 == 28.0) {
                        v40 = randomExtra ? "tek_woodfloor21" : "woodfloor2";
                    } else if (var22_19 == 29.0) {
                        v40 = randomExtra ? "tek_woodfloor22" : "woodfloor3";
                    } else if (var22_19 == 30.0) {
                        v40 = randomExtra ? "tek_woodfloor23" : "woodfloor3";
                    } else if (var22_19 == 31.0) {
                        v40 = randomExtra ? "tek_woodfloor24" : "woodfloor4";
                    } else if (var22_19 == 32.0) {
                        v40 = randomExtra ? "tek_woodfloor25" : "woodfloor4";
                    } else if (var22_19 == 33.0) {
                        v40 = randomExtra ? "tek_woodfloor26" : "woodfloor1";
                    } else if (var22_19 == 34.0) {
                        v40 = randomExtra ? "tek_woodfloor27" : "woodfloor1";
                    } else if (var22_19 == 35.0) {
                        v40 = randomExtra ? "tek_woodfloor28" : "woodfloor2";
                    } else if (var22_19 == 36.0) {
                        v40 = randomExtra ? "tek_woodfloor29" : "woodfloor2";
                    } else if (var22_19 == 37.0) {
                        v40 = special ? "woodfloor6" : "woodfloorexit";
                    } else {
                        throw new IndexOutOfBoundsException("How did we get here?");
                    }
                    structureIdFloor3 = v40;
                    if (!Intrinsics.areEqual((Object)structureIdFloor2, (Object)"woodfloorintersection") && !Intrinsics.areEqual((Object)structureIdFloor2, (Object)"tek_woodfloor5")) {
                        v41 = TBSConstants.id(structureIdFloor3);
                        v42 = chunkAccess.getPos().getWorldPosition().atY(215);
                        Intrinsics.checkNotNullExpressionValue((Object)v42, (String)"atY(...)");
                        ClanVoidGenerator.placeStructure$default(this, v41, worldGenRegion, v42, mirror, rotation, chunkAccess, false, 64, null);
                        if (Intrinsics.areEqual((Object)structureIdFloor3, (Object)"tek_woodfloor4")) {
                            stoneFloorIntersection = true;
                        }
                    }
                } else {
                    v43 = TBSConstants.id("stoneintersection");
                    v44 = chunkAccess.getPos().getWorldPosition().atY(215);
                    Intrinsics.checkNotNullExpressionValue((Object)v44, (String)"atY(...)");
                    ClanVoidGenerator.placeStructure$default(this, v43, worldGenRegion, v44, mirror, rotation, chunkAccess, false, 64, null);
                }
                if (!stoneFloorIntersection) break block148;
                v45 = chunkAccess.getPos().getWorldPosition().getX();
                v46 = worldGenRegion.getLevel();
                Intrinsics.checkNotNullExpressionValue((Object)v46, (String)"getLevel(...)");
                if (v45 != LevelExt.INSTANCE.getVars((LevelAccessor)v46).getStoneFloorX()) break block149;
                v47 = chunkAccess.getPos().getWorldPosition().getZ();
                v48 = worldGenRegion.getLevel();
                Intrinsics.checkNotNullExpressionValue((Object)v48, (String)"getLevel(...)");
                if (v47 != LevelExt.INSTANCE.getVars((LevelAccessor)v48).getStoneFloorZ()) break block149;
            }
            v49 = chunkAccess.getPos().getWorldPosition().getX();
            v50 = worldGenRegion.getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)v50, (String)"getLevel(...)");
            if (v49 != LevelExt.INSTANCE.getVars((LevelAccessor)v50).getStoneFloorX()) ** GOTO lbl-1000
            v51 = chunkAccess.getPos().getWorldPosition().getZ();
            v52 = worldGenRegion.getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)v52, (String)"getLevel(...)");
            if (v51 == LevelExt.INSTANCE.getVars((LevelAccessor)v52).getStoneFloorZ()) {
                v53 = "stonepredetermined";
            } else lbl-1000:
            // 2 sources

            {
                v53 = structureIdFloor4 = "stone1";
            }
            if (!Intrinsics.areEqual((Object)structureIdFloor4, (Object)"stonepredetermined") && special && (double)random.nextFloat() < 0.05) {
                var22_19 = variantF4;
                if (var22_19 == 1.0) {
                    v54 = "stone2";
                } else if (var22_19 == 2.0) {
                    v54 = "stone3";
                } else if (var22_19 == 3.0) {
                    v54 = "stone4";
                } else if (var22_19 == 4.0) {
                    v54 = "stone5";
                } else if (var22_19 == 5.0) {
                    v54 = "stone6";
                } else if (var22_19 == 6.0) {
                    v54 = "stone7";
                } else if (var22_19 == 7.0) {
                    v54 = "stone_maze";
                } else if (var22_19 == 8.0) {
                    v54 = "stone_mining";
                } else if (var22_19 == 9.0) {
                    v54 = "stone_morsecode";
                } else if (var22_19 == 10.0) {
                    v54 = "stone_torchlonggoneout";
                } else if (var22_19 == 11.0) {
                    v54 = "stone_trigger";
                } else if (var22_19 == 12.0) {
                    v54 = "stone_webs";
                } else {
                    throw new IndexOutOfBoundsException("How did we get here?");
                }
                structureIdFloor4 = v54;
                if ((double)random.nextFloat() < 0.05) {
                    structureIdFloor4 = "stonespecial";
                }
            }
            v55 = TBSConstants.id(structureIdFloor4);
            v56 = chunkAccess.getPos().getWorldPosition().atY(230);
            Intrinsics.checkNotNullExpressionValue((Object)v56, (String)"atY(...)");
            ClanVoidGenerator.placeStructure$default(this, v55, worldGenRegion, v56, mirror, rotation, chunkAccess, false, 64, null);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void genSurface(@NotNull WorldGenLevel worldGenRegion, @NotNull ChunkAccess chunkAccess) {
        Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        random = RandomSource.create((long)(worldGenRegion.getSeed() + (long)chunkAccess.getPos().x * 341873128712L + (long)chunkAccess.getPos().z * 132897987541L));
        mirror = random.nextBoolean() != false ? Mirror.FRONT_BACK : Mirror.NONE;
        rotation = (Rotation)EntriesMappings.entries$0.get(random.nextInt(0, 4));
        structureId = (double)random.nextFloat() < 0.99 ? "fieldbase" : "fieldbase2";
        v0 = chunkAccess.getPos().getWorldPosition().getX();
        v1 = worldGenRegion.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"getLevel(...)");
        if (v0 != LevelExt.INSTANCE.getVars((LevelAccessor)v1).getDayAX()) ** GOTO lbl-1000
        v2 = chunkAccess.getPos().getWorldPosition().getZ();
        v3 = worldGenRegion.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getLevel(...)");
        if (v2 == LevelExt.INSTANCE.getVars((LevelAccessor)v3).getDayAZ()) {
            structureId = "fieldpredetermined";
            v4 = TBSConstants.id(structureId);
            v5 = chunkAccess.getPos().getWorldPosition().atY(250);
            Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"atY(...)");
            ClanVoidGenerator.placeStructure$default(this, v4, worldGenRegion, v5, mirror, rotation, chunkAccess, false, 64, null);
        } else lbl-1000:
        // 2 sources

        {
            v6 = TBSConstants.id(structureId);
            v7 = chunkAccess.getPos().getWorldPosition().atY(250);
            Intrinsics.checkNotNullExpressionValue((Object)v7, (String)"atY(...)");
            ClanVoidGenerator.placeStructure$default(this, v6, worldGenRegion, v7, mirror, rotation, chunkAccess, false, 64, null);
        }
        if (chunkAccess.getPos().getWorldPosition().getX() == 992 && chunkAccess.getPos().getWorldPosition().getZ() == 992) {
            v8 = TBSConstants.id("fieldbaron");
            v9 = chunkAccess.getPos().getWorldPosition().atY(252);
            Intrinsics.checkNotNullExpressionValue((Object)v9, (String)"atY(...)");
            ClanVoidGenerator.placeStructure$default(this, v8, worldGenRegion, v9, mirror, rotation, chunkAccess, false, 64, null);
        }
    }

    @NotNull
    public final List<Block> getIgnoreBlock() {
        return this.ignoreBlock;
    }

    public final void placeStructure(@NotNull ResourceLocation structureId, @NotNull WorldGenLevel region, @NotNull BlockPos pos, @NotNull Mirror mirror, @NotNull Rotation rotation, @NotNull ChunkAccess chunk, boolean isRooms) {
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
        if (isRooms) {
            int n = 4;
            for (int i = 0; i < n; ++i) {
                int it = i;
                boolean bl = false;
                RandomSource random = RandomSource.create((long)(region.getSeed() + (long)chunk.getPos().x * 341873128712L + (long)chunk.getPos().z * 132897987541L + (long)it));
                ResourceLocation id = TBSConstants.id("clan_void_subroom_" + random.nextInt(0, 10));
                Optional templateHolder2 = level.getStructureManager().get(id);
                Object t2 = templateHolder2.get();
                Intrinsics.checkNotNullExpressionValue(t2, (String)"get(...)");
                StructureTemplate template2 = (StructureTemplate)t2;
                StructurePlaceSettings settings2 = new StructurePlaceSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setBoundingBox(boundingBox).addProcessor((StructureProcessor)new BlockIgnoreProcessor(this.ignoreBlock));
                BlockPos transformedOrigin2 = switch (it) {
                    case 0 -> pos.offset(1, 0, 1);
                    case 1 -> pos.offset(10, 0, 1);
                    case 2 -> pos.offset(1, 0, 10);
                    case 3 -> pos.offset(10, 0, 10);
                    default -> throw new RuntimeException("how did we get here?");
                };
                template2.placeInWorld((ServerLevelAccessor)region, transformedOrigin2, transformedOrigin2, settings2, region.getRandom(), 3);
            }
        }
    }

    public static /* synthetic */ void placeStructure$default(ClanVoidGenerator clanVoidGenerator, ResourceLocation resourceLocation, WorldGenLevel worldGenLevel, BlockPos blockPos, Mirror mirror, Rotation rotation, ChunkAccess chunkAccess, boolean bl, int n, Object object) {
        if ((n & 0x40) != 0) {
            bl = false;
        }
        clanVoidGenerator.placeStructure(resourceLocation, worldGenLevel, blockPos, mirror, rotation, chunkAccess, bl);
    }

    public void buildSurface(@NotNull WorldGenRegion level, @NotNull StructureManager structureManager, @NotNull RandomState random, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        this.genSurface((WorldGenLevel)level, chunk);
    }

    public void applyBiomeDecoration(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, @NotNull StructureManager structureManager) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        this.genRoom(level, chunk);
        super.applyBiomeDecoration(level, chunk, structureManager);
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

    @NotNull
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        return instance.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(ClanVoidGenerator::CODEC$lambda$0$0), (App)NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter(ClanVoidGenerator::CODEC$lambda$0$1)).apply((Applicative)instance, ClanVoidGenerator::new);
    }

    private static final BiomeSource CODEC$lambda$0$0(ClanVoidGenerator it) {
        return it.biomeSource;
    }

    private static final Holder CODEC$lambda$0$1(ClanVoidGenerator it) {
        return it.generatorSettings();
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(ClanVoidGenerator::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/clan_void/ClanVoidGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/clan_void/ClanVoidGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<ClanVoidGenerator> getCODEC() {
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
}

