/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.WorldGenRegion
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
 *  net.minecraft.world.level.levelgen.GenerationStep$Carving
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.lucid;

import com.mojang.serialization.MapCodec;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
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
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.thebrokenscript.world.dimension.lucid.LucidGenerator;
import net.thebrokenscript.world.gen.SingleLayerGenerator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 >2\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J@\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\b\u00101\u001a\u00020\u0007H\u0016J0\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u001f\u001a\u0002072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u00108\u001a\u0002092\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u0010:\u001a\u0002072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0<H\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#X\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(\u00a8\u0006?"}, d2={"Lnet/thebrokenscript/world/dimension/lucid/LucidGenerator;", "Lnet/thebrokenscript/world/gen/SingleLayerGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "pillarRNG", "", "getPillarRNG", "()I", "setPillarRNG", "(I)V", "roughGround", "getRoughGround", "setRoughGround", "buildSurface", "", "region", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "random", "Lnet/minecraft/world/level/levelgen/RandomState;", "chunk", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "groundGen", "roughGroundGen", "pillarGen", "spawnOriginalMobs", "getGenDepth", "applyBiomeDecoration", "level", "Lnet/minecraft/world/level/WorldGenLevel;", "blockList", "", "Lnet/minecraft/world/level/block/state/BlockState;", "getBlockList", "()Ljava/util/List;", "block", "getBlock", "()Lnet/minecraft/world/level/block/state/BlockState;", "applyCarvers", "seed", "", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "step", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "getSeaLevel", "getMinY", "getBaseHeight", "x", "z", "type", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "Lnet/minecraft/world/level/LevelHeightAccessor;", "getBaseColumn", "Lnet/minecraft/world/level/NoiseColumn;", "height", "codec", "Lcom/mojang/serialization/MapCodec;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "Companion", "thebrokenscript-common"})
public final class LucidGenerator
extends SingleLayerGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int pillarRNG;
    private int roughGround;
    @NotNull
    private final List<BlockState> blockList;
    @NotNull
    private final BlockState block;
    @NotNull
    private static final MapCodec<LucidGenerator> CODEC = SingleLayerGenerator.Companion.codec(Companion.CODEC.1.INSTANCE);
    public static final int BASE_Y = 1;

    public LucidGenerator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
        Object[] objectArray = new BlockState[]{Blocks.WHITE_CONCRETE.defaultBlockState(), Blocks.ORANGE_CONCRETE.defaultBlockState(), Blocks.MAGENTA_CONCRETE.defaultBlockState(), Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState(), Blocks.YELLOW_CONCRETE.defaultBlockState(), Blocks.LIME_CONCRETE.defaultBlockState(), Blocks.PINK_CONCRETE.defaultBlockState(), Blocks.GRAY_CONCRETE.defaultBlockState(), Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState(), Blocks.CYAN_CONCRETE.defaultBlockState(), Blocks.PURPLE_CONCRETE.defaultBlockState(), Blocks.BLUE_CONCRETE.defaultBlockState(), Blocks.BROWN_CONCRETE.defaultBlockState(), Blocks.GREEN_CONCRETE.defaultBlockState(), Blocks.RED_CONCRETE.defaultBlockState()};
        this.blockList = CollectionsKt.listOf((Object[])objectArray);
        BlockState blockState = Blocks.AIR.defaultBlockState();
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"defaultBlockState(...)");
        this.block = blockState;
    }

    public final int getPillarRNG() {
        return this.pillarRNG;
    }

    public final void setPillarRNG(int n) {
        this.pillarRNG = n;
    }

    public final int getRoughGround() {
        return this.roughGround;
    }

    public final void setRoughGround(int n) {
        this.roughGround = n;
    }

    @Override
    public void buildSurface(@NotNull WorldGenRegion region, @NotNull StructureManager structureManager, @NotNull RandomState random, @NotNull ChunkAccess chunk) {
        boolean isPillarChunk;
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        boolean bl = isPillarChunk = region.getRandom().nextInt(0, 151) == this.pillarRNG;
        if (isPillarChunk) {
            this.pillarGen(region, chunk);
        } else {
            boolean isRough;
            boolean bl2 = isRough = region.getRandom().nextInt(0, 151) == 0;
            if (isRough || this.roughGround > 0) {
                if (this.roughGround == 0) {
                    this.roughGround = 5;
                }
                this.roughGroundGen(region, chunk);
                int n = this.roughGround;
                this.roughGround = n + -1;
            } else {
                this.groundGen(region, chunk);
            }
        }
        this.pillarRNG = region.getRandom().nextInt(0, 201);
    }

    public final void groundGen(@NotNull WorldGenRegion region, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        int x = chunk.getPos().getMinBlockX();
        int n = chunk.getPos().getMaxBlockX();
        if (x <= n) {
            while (true) {
                int n2;
                int z;
                if ((z = chunk.getPos().getMinBlockZ()) <= (n2 = chunk.getPos().getMaxBlockZ())) {
                    while (true) {
                        int maxY = 1 + region.getRandom().nextInt(0, 5);
                        BlockState block = this.blockList.get(region.getRandom().nextInt(this.blockList.size()));
                        int y = 1;
                        if (y <= maxY) {
                            while (true) {
                                BlockPos pos;
                                if (region.ensureCanWrite(pos = new BlockPos(x, y, z))) {
                                    region.setBlock(pos, block, 3);
                                    if ((double)region.getRandom().nextFloat() < 0.05) {
                                        block = this.blockList.get(region.getRandom().nextInt(this.blockList.size()));
                                    }
                                }
                                if (y == maxY) break;
                                ++y;
                            }
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

    public final void roughGroundGen(@NotNull WorldGenRegion region, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        int x = chunk.getPos().getMinBlockX();
        int n = chunk.getPos().getMaxBlockX();
        if (x <= n) {
            while (true) {
                int n2;
                int z;
                if ((z = chunk.getPos().getMinBlockZ()) <= (n2 = chunk.getPos().getMaxBlockZ())) {
                    while (true) {
                        int y;
                        int maxY = 0 + region.getRandom().nextInt(0, 4);
                        BlockState block = this.blockList.get(region.getRandom().nextInt(this.blockList.size()));
                        if (!((double)region.getRandom().nextFloat() < 0.05) && (y = 1) <= maxY) {
                            while (true) {
                                BlockPos pos;
                                if (region.ensureCanWrite(pos = new BlockPos(x, y, z))) {
                                    region.setBlock(pos, block, 3);
                                    if ((double)region.getRandom().nextFloat() < 0.05) {
                                        block = this.blockList.get(region.getRandom().nextInt(this.blockList.size()));
                                    }
                                }
                                if (y == maxY) break;
                                ++y;
                            }
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

    public final void pillarGen(@NotNull WorldGenRegion region, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        int x = chunk.getPos().getMinBlockX();
        int n = chunk.getPos().getMaxBlockX();
        if (x <= n) {
            while (true) {
                int n2;
                int z;
                if ((z = chunk.getPos().getMinBlockZ()) <= (n2 = chunk.getPos().getMaxBlockZ())) {
                    while (true) {
                        int n3;
                        BlockState block = this.blockList.get(region.getRandom().nextInt(this.blockList.size()));
                        int y = chunk.getMinBuildHeight();
                        if (y <= (n3 = chunk.getMaxBuildHeight())) {
                            while (true) {
                                BlockPos pos;
                                if (region.ensureCanWrite(pos = new BlockPos(x, y, z))) {
                                    region.setBlock(pos, block, 3);
                                    if ((double)region.getRandom().nextFloat() < 0.005) {
                                        block = this.blockList.get(region.getRandom().nextInt(this.blockList.size()));
                                    }
                                }
                                if (y == n3) break;
                                ++y;
                            }
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

    @Override
    public void spawnOriginalMobs(@NotNull WorldGenRegion region) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
    }

    @Override
    public int getGenDepth() {
        return 1;
    }

    public void applyBiomeDecoration(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, @NotNull StructureManager structureManager) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
    }

    @NotNull
    public final List<BlockState> getBlockList() {
        return this.blockList;
    }

    @Override
    @NotNull
    protected BlockState getBlock() {
        return this.block;
    }

    @Override
    public void applyCarvers(@NotNull WorldGenRegion region, long seed, @NotNull RandomState random, @NotNull BiomeManager biomeManager, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunk, @NotNull GenerationStep.Carving step) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)biomeManager, (String)"biomeManager");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)step, (String)"step");
    }

    @Override
    public int getSeaLevel() {
        return 0;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getBaseHeight(int x, int z, @NotNull Heightmap.Types type, @NotNull LevelHeightAccessor level, @NotNull RandomState random) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        return 1;
    }

    @Override
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

    @NotNull
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/world/dimension/lucid/LucidGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/lucid/LucidGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "BASE_Y", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<LucidGenerator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

