/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.packets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.network.ActionPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import net.thebrokenscript.brokencore.impl.client.OverlayLayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/impl/packets/ClearOverlaysPacket;", "Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "brokencore-common"})
public final class ClearOverlaysPacket
extends ActionPacket<ClearOverlaysPacket> {
    @NotNull
    private final ResourceLocation id = BrokenCore.id("clear_overlays");

    @Override
    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public void handle(@NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(ClearOverlaysPacket::handle$lambda$0);
    }

    private static final void handle$lambda$0() {
        OverlayLayer.clearOverlays();
    }
}

