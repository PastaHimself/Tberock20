/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.chunk.LevelChunk
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0007H\u0007R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/util/WrongChunkGetter;", "", "<init>", "()V", "wrongChunks", "Ljava/util/HashMap;", "Lnet/minecraft/world/level/ChunkPos;", "Lnet/minecraft/world/level/chunk/LevelChunk;", "Lkotlin/collections/HashMap;", "getWrongChunks", "()Ljava/util/HashMap;", "i", "", "getI", "()I", "setI", "(I)V", "getWrongChunk", "level", "Lnet/minecraft/world/level/Level;", "x", "z", "sourceChunk", "brokencore-common"})
public final class WrongChunkGetter {
    @NotNull
    public static final WrongChunkGetter INSTANCE = new WrongChunkGetter();
    @NotNull
    private static final HashMap<ChunkPos, LevelChunk> wrongChunks = new HashMap();
    private static int i;

    private WrongChunkGetter() {
    }

    @NotNull
    public final HashMap<ChunkPos, LevelChunk> getWrongChunks() {
        return wrongChunks;
    }

    public final int getI() {
        return i;
    }

    public final void setI(int n) {
        i = n;
    }

    @JvmStatic
    @NotNull
    public static final LevelChunk getWrongChunk(@NotNull Level level, int x, int z, @NotNull LevelChunk sourceChunk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sourceChunk, (String)"sourceChunk");
        if (level.isClientSide) {
            return sourceChunk;
        }
        if (Intrinsics.areEqual((Object)level.dimension(), (Object)Level.NETHER)) {
            return sourceChunk;
        }
        boolean bl = -2 <= x ? x < 3 : false;
        if (bl) {
            boolean bl2 = -2 <= z ? z < 3 : false;
            if (bl2) {
                MinecraftServer minecraftServer = level.getServer();
                if (minecraftServer == null) {
                    return sourceChunk;
                }
                MinecraftServer server = minecraftServer;
                ServerLevel serverLevel = server.getLevel(Level.NETHER);
                if (serverLevel == null) {
                    return sourceChunk;
                }
                ServerLevel serverLevel2 = serverLevel;
                LevelChunk levelChunk = serverLevel2.getChunk(x, z);
                if (levelChunk == null) {
                    levelChunk = sourceChunk;
                }
                return levelChunk;
            }
        }
        return sourceChunk;
    }
}

