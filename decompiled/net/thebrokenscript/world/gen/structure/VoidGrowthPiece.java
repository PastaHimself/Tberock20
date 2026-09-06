/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongIterator
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.StructurePiece
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType
 *  net.thebrokenscript.brokencore.api.dsl.MathUtil
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.gen.structure;

import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.thebrokenscript.brokencore.api.dsl.MathUtil;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSStructurePieceTypes;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0014J@\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/world/gen/structure/VoidGrowthPiece;", "Lnet/minecraft/world/level/levelgen/structure/StructurePiece;", "startPos", "Lnet/minecraft/core/BlockPos;", "targetX", "", "targetY", "targetZ", "angleSeed", "", "<init>", "(Lnet/minecraft/core/BlockPos;IIIJ)V", "tag", "Lnet/minecraft/nbt/CompoundTag;", "(Lnet/minecraft/nbt/CompoundTag;)V", "addAdditionalSaveData", "", "context", "Lnet/minecraft/world/level/levelgen/structure/pieces/StructurePieceSerializationContext;", "postProcess", "level", "Lnet/minecraft/world/level/WorldGenLevel;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "chunkGenerator", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "random", "Lnet/minecraft/util/RandomSource;", "box", "Lnet/minecraft/world/level/levelgen/structure/BoundingBox;", "chunkPos", "Lnet/minecraft/world/level/ChunkPos;", "pos", "Companion", "thebrokenscript-common"})
public final class VoidGrowthPiece
extends StructurePiece {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int targetX;
    private final int targetY;
    private final int targetZ;
    private final long angleSeed;
    private static final float MAX_RADIUS = 4.0f;

    public VoidGrowthPiece(@NotNull BlockPos startPos, int targetX, int targetY, int targetZ, long angleSeed) {
        Intrinsics.checkNotNullParameter((Object)startPos, (String)"startPos");
        super((StructurePieceType)TBSStructurePieceTypes.VOID_GROWTH.value(), 0, Companion.computeBounds(startPos, targetX, targetY, targetZ));
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetZ = targetZ;
        this.angleSeed = angleSeed;
    }

    public VoidGrowthPiece(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        this(new BlockPos(tag.getInt("sx"), tag.getInt("sy"), tag.getInt("sz")), tag.getInt("tx"), tag.getInt("ty"), tag.getInt("tz"), tag.getLong("seed"));
    }

    protected void addAdditionalSaveData(@NotNull StructurePieceSerializationContext context, @NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        tag.putInt("sx", this.boundingBox.minX());
        tag.putInt("sy", this.boundingBox.minY());
        tag.putInt("sz", this.boundingBox.minZ());
        tag.putInt("tx", this.targetX);
        tag.putInt("ty", this.targetY);
        tag.putInt("tz", this.targetZ);
        tag.putLong("seed", this.angleSeed);
    }

    public void postProcess(@NotNull WorldGenLevel level, @NotNull StructureManager structureManager, @NotNull ChunkGenerator chunkGenerator, @NotNull RandomSource random, @NotNull BoundingBox box, @NotNull ChunkPos chunkPos, @NotNull BlockPos pos) {
        float radius;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunkGenerator, (String)"chunkGenerator");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)box, (String)"box");
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockEntry<RotatedPillarBlock> log = TBSBlocks.VOID_LOG;
        BlockEntry<Block> wood = TBSBlocks.VOID_WOOD;
        BlockPos shiftedOrigin = new BlockPos(this.boundingBox.minX() + 5, this.boundingBox.minY() + 5, this.boundingBox.minZ() + 5);
        float dirX = this.targetX - shiftedOrigin.getX();
        float dirY = this.targetY - shiftedOrigin.getY();
        float dirZ = this.targetZ - shiftedOrigin.getZ();
        float distance = (float)Math.sqrt(MathUtil.getSquared((float)dirX) + MathUtil.getSquared((float)dirY) + MathUtil.getSquared((float)dirZ));
        LongOpenHashSet bodySet = new LongOpenHashSet();
        if (box.isInside((Vec3i)shiftedOrigin)) {
            level.setBlock(shiftedOrigin, log.getDefaultState(), 3);
        }
        block0: for (float i = 0.0f; i < distance * 0.92f; i += Math.max(0.45f, radius * 0.3f)) {
            float t = i / distance;
            float x = Mth.lerp((float)t, (float)shiftedOrigin.getX(), (float)this.targetX);
            float y = Mth.lerp((float)t, (float)shiftedOrigin.getY(), (float)this.targetY);
            float z = Mth.lerp((float)t, (float)shiftedOrigin.getZ(), (float)this.targetZ);
            radius = Math.max(0.85f, 4.0f * (0.95f - (float)Math.pow(t, 1.5f)));
            int radiusInt = Math.max(1, (int)radius);
            bodySet.add(BlockPos.asLong((int)((int)x), (int)((int)y), (int)((int)z)));
            int dx = -radiusInt;
            if (dx > radiusInt) continue;
            while (true) {
                int dy;
                if ((dy = -radiusInt) <= radiusInt) {
                    while (true) {
                        int dz;
                        if ((dz = -radiusInt) <= radiusInt) {
                            while (true) {
                                if ((float)(dx * dx + dy * dy + dz * dz) <= radius * radius) {
                                    bodySet.add(BlockPos.asLong((int)((int)x + dx), (int)((int)y + dy), (int)((int)z + dz)));
                                }
                                if (dz == radiusInt) break;
                                ++dz;
                            }
                        }
                        if (dy == radiusInt) break;
                        ++dy;
                    }
                }
                if (dx == radiusInt) continue block0;
                ++dx;
            }
        }
        int[] x = new int[]{-1, 0, 0, 1, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, -1, 0, 0, 1};
        int[] neighbors = x;
        LongOpenHashSet finalSet = new LongOpenHashSet();
        LongIterator longIterator = bodySet.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator, (String)"iterator(...)");
        LongIterator longIterator2 = longIterator;
        while (longIterator2.hasNext()) {
            Long posLong = longIterator2.next();
            Intrinsics.checkNotNull((Object)posLong);
            int x2 = BlockPos.getX((long)posLong);
            int y = BlockPos.getY((long)posLong);
            int z = BlockPos.getZ((long)posLong);
            int count = 0;
            for (int n = 0; n < 18; n += 3) {
                if (!bodySet.contains(BlockPos.asLong((int)(x2 + neighbors[n]), (int)(y + neighbors[n + 1]), (int)(z + neighbors[n + 2])))) continue;
                ++count;
            }
            if (count < 3) continue;
            finalSet.add(posLong.longValue());
        }
        LongIterator longIterator3 = finalSet.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator3, (String)"iterator(...)");
        longIterator2 = longIterator3;
        while (longIterator2.hasNext()) {
            int z;
            int y;
            Long posLong = longIterator2.next();
            Intrinsics.checkNotNull((Object)posLong);
            BlockPos blockPos = BlockPos.of((long)posLong);
            if (!box.isInside((Vec3i)blockPos)) continue;
            int x3 = BlockPos.getX((long)posLong);
            boolean exposed = !finalSet.contains(BlockPos.asLong((int)(x3 - 1), (int)(y = BlockPos.getY((long)posLong)), (int)(z = BlockPos.getZ((long)posLong)))) || !finalSet.contains(BlockPos.asLong((int)(x3 + 1), (int)y, (int)z)) || !finalSet.contains(BlockPos.asLong((int)x3, (int)(y - 1), (int)z)) || !finalSet.contains(BlockPos.asLong((int)x3, (int)(y + 1), (int)z)) || !finalSet.contains(BlockPos.asLong((int)x3, (int)y, (int)(z - 1))) || !finalSet.contains(BlockPos.asLong((int)x3, (int)y, (int)(z + 1)));
            level.setBlock(blockPos, exposed ? wood.getDefaultState() : log.getDefaultState(), 3);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/world/gen/structure/VoidGrowthPiece$Companion;", "", "<init>", "()V", "MAX_RADIUS", "", "computeBounds", "Lnet/minecraft/world/level/levelgen/structure/BoundingBox;", "start", "Lnet/minecraft/core/BlockPos;", "tx", "", "ty", "tz", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final BoundingBox computeBounds(@NotNull BlockPos start, int tx, int ty, int tz) {
            Intrinsics.checkNotNullParameter((Object)start, (String)"start");
            int pad = 5;
            return new BoundingBox(Math.min(start.getX(), tx) - pad, Math.min(start.getY(), ty) - pad, Math.min(start.getZ(), tz) - pad, Math.max(start.getX(), tx) + pad, Math.max(start.getY(), ty) + pad, Math.max(start.getZ(), tz) + pad);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

