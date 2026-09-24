/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network.debug;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.handlers.debug.ClientMazePathfinderDebug;
import net.thebrokenscript.network.debug.MazePayload;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/debug/MazePathfindDebugPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/network/debug/MazePayload;", "<init>", "()V", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "thebrokenscript-common"})
public final class MazePathfindDebugPacket
extends EndecPacket<MazePathfindDebugPacket, MazePayload> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("debug_pathfinder_maze");

    public MazePathfindDebugPacket() {
        super(MazePayload.Companion.getENDEC());
    }

    public void handle(@NotNull MazePayload data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (cx.isClientbound) {
            cx.getEnqueueWork().invoke(() -> MazePathfindDebugPacket.handle$lambda$0(data));
        }
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    private static final void handle$lambda$0(MazePayload $data) {
        ClientMazePathfinderDebug.INSTANCE.updatePath($data.getEntityId(), CollectionsKt.toList((Iterable)$data.getPath().getEntries()));
    }
}

