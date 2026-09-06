/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/world/ChunkDistTracker;", "", "<init>", "()V", "minChunkX", "Lkotlin/concurrent/atomics/AtomicInt;", "Ljava/util/concurrent/atomic/AtomicInteger;", "minChunkZ", "maxChunkX", "maxChunkZ", "thebrokenscript-common"})
public final class ChunkDistTracker {
    @NotNull
    public static final ChunkDistTracker INSTANCE = new ChunkDistTracker();
    @JvmField
    @NotNull
    public static final AtomicInteger minChunkX = new AtomicInteger(0);
    @JvmField
    @NotNull
    public static final AtomicInteger minChunkZ = new AtomicInteger(0);
    @JvmField
    @NotNull
    public static final AtomicInteger maxChunkX = new AtomicInteger(0);
    @JvmField
    @NotNull
    public static final AtomicInteger maxChunkZ = new AtomicInteger(0);

    private ChunkDistTracker() {
    }
}

