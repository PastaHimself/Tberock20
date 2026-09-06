/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.thebrokenscript.brokencore.api.ext.MinecraftServerExt;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"queue", "Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "Lnet/minecraft/server/MinecraftServer;", "getQueue", "(Lnet/minecraft/server/MinecraftServer;)Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "brokencore-common"})
public final class MinecraftServerExtKt {
    @NotNull
    public static final WorkQueue getQueue(@NotNull MinecraftServer $this$queue) {
        Intrinsics.checkNotNullParameter((Object)$this$queue, (String)"<this>");
        return ((MinecraftServerExt)$this$queue).getBc_queue();
    }
}

