/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.synth.PerlinNoise
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.dimension.backrooms;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.world.dimension.backrooms.BRGenUtil;
import net.thebrokenscript.world.dimension.backrooms.BackroomsLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J0\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/world/dimension/backrooms/BackroomsLevelZero;", "Lnet/thebrokenscript/world/dimension/backrooms/BackroomsLevel;", "<init>", "()V", "endLevel", "", "getEndLevel", "()I", "generate", "", "worldGenRegion", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "randomState", "Lnet/minecraft/world/level/levelgen/RandomState;", "chunkAccess", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "Companion", "thebrokenscript-common"})
public final class BackroomsLevelZero
extends BackroomsLevel {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int endLevel;
    @NotNull
    private static final PerlinNoise UnlitRoomNoise;
    @NotNull
    private static final PerlinNoise EmptyAreaNoise;
    @NotNull
    private static final PerlinNoise RedRoomNoise;

    public BackroomsLevelZero() {
        this.endLevel = 9;
    }

    @Override
    public int getEndLevel() {
        return this.endLevel;
    }

    @Override
    public void generate(@Nullable WorldGenRegion worldGenRegion, @Nullable StructureManager structureManager, @Nullable RandomState randomState, @Nullable ChunkAccess chunkAccess) {
        if (chunkAccess != null) {
            BlockState blockState = Blocks.BEDROCK.defaultBlockState();
            Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"defaultBlockState(...)");
            BRGenUtil.INSTANCE.fillLayer(chunkAccess, 0, blockState);
            if (BRGenUtil.INSTANCE.isChunkInNoise(chunkAccess, RedRoomNoise, 0.3)) {
                BRGenUtil.INSTANCE.fillLayer(chunkAccess, 1, TBSBlocks.RED_MOIST_CARPET.getDefaultState());
                BRGenUtil.INSTANCE.fillLayer(chunkAccess, this.getEndLevel(), TBSBlocks.RED_CEILING_TILE.getDefaultState());
                if (!BRGenUtil.INSTANCE.isChunkInNoise(chunkAccess, UnlitRoomNoise, 0.15)) {
                    BRGenUtil.INSTANCE.generateLights(chunkAccess, this.getEndLevel(), true);
                }
                if (!BRGenUtil.INSTANCE.isChunkInNoise(chunkAccess, EmptyAreaNoise, 0.2)) {
                    BRGenUtil.INSTANCE.generateBasicWalls(chunkAccess, 1, this.getEndLevel(), TBSBlocks.RED_UGLY_WALLPAPER.getDefaultState());
                }
            } else {
                BRGenUtil.INSTANCE.fillLayer(chunkAccess, 1, TBSBlocks.MOIST_CARPET.getDefaultState());
                BRGenUtil.INSTANCE.fillLayer(chunkAccess, this.getEndLevel(), TBSBlocks.CEILING_TILE.getDefaultState());
                if (!BRGenUtil.INSTANCE.isChunkInNoise(chunkAccess, UnlitRoomNoise, 0.15)) {
                    BRGenUtil.INSTANCE.generateLights(chunkAccess, this.getEndLevel(), false);
                }
                if (!BRGenUtil.INSTANCE.isChunkInNoise(chunkAccess, EmptyAreaNoise, 0.2)) {
                    BRGenUtil.INSTANCE.generateBasicWalls(chunkAccess, 1, this.getEndLevel(), TBSBlocks.UGLY_WALLPAPER.getDefaultState());
                }
            }
        }
    }

    static {
        Object[] objectArray = new Integer[]{1, 5, 9};
        PerlinNoise perlinNoise = PerlinNoise.create((RandomSource)RandomSource.create(), (List)CollectionsKt.mutableListOf((Object[])objectArray));
        Intrinsics.checkNotNullExpressionValue((Object)perlinNoise, (String)"create(...)");
        UnlitRoomNoise = perlinNoise;
        objectArray = new Integer[]{2, 1, 9};
        PerlinNoise perlinNoise2 = PerlinNoise.create((RandomSource)RandomSource.create(), (List)CollectionsKt.mutableListOf((Object[])objectArray));
        Intrinsics.checkNotNullExpressionValue((Object)perlinNoise2, (String)"create(...)");
        EmptyAreaNoise = perlinNoise2;
        objectArray = new Integer[]{0, 4, 2};
        PerlinNoise perlinNoise3 = PerlinNoise.create((RandomSource)RandomSource.create(), (List)CollectionsKt.mutableListOf((Object[])objectArray));
        Intrinsics.checkNotNullExpressionValue((Object)perlinNoise3, (String)"create(...)");
        RedRoomNoise = perlinNoise3;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/world/dimension/backrooms/BackroomsLevelZero$Companion;", "", "<init>", "()V", "UnlitRoomNoise", "Lnet/minecraft/world/level/levelgen/synth/PerlinNoise;", "getUnlitRoomNoise", "()Lnet/minecraft/world/level/levelgen/synth/PerlinNoise;", "EmptyAreaNoise", "getEmptyAreaNoise", "RedRoomNoise", "getRedRoomNoise", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PerlinNoise getUnlitRoomNoise() {
            return UnlitRoomNoise;
        }

        @NotNull
        public final PerlinNoise getEmptyAreaNoise() {
            return EmptyAreaNoise;
        }

        @NotNull
        public final PerlinNoise getRedRoomNoise() {
            return RedRoomNoise;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

