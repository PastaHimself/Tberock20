/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.levelgen.RandomState
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.dimension.backrooms;

import kotlin.Metadata;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.RandomState;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/world/dimension/backrooms/BackroomsLevel;", "", "<init>", "()V", "generate", "", "worldGenRegion", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "randomState", "Lnet/minecraft/world/level/levelgen/RandomState;", "chunkAccess", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "startLevel", "", "getStartLevel", "()I", "endLevel", "getEndLevel", "thebrokenscript-common"})
public abstract class BackroomsLevel {
    public void generate(@Nullable WorldGenRegion worldGenRegion, @Nullable StructureManager structureManager, @Nullable RandomState randomState, @Nullable ChunkAccess chunkAccess) {
    }

    public final int getStartLevel() {
        return 0;
    }

    public int getEndLevel() {
        return 1;
    }
}

