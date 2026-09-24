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
import net.thebrokenscript.brokencore.api.client.overlay.OverlayInfo;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import net.thebrokenscript.brokencore.impl.client.OverlayLayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/impl/packets/ShowOverlayPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayInfo;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "of", "texture", "duration", "", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "brokencore-common"})
public final class ShowOverlayPacket
extends EndecPacket<ShowOverlayPacket, OverlayInfo> {
    @NotNull
    private final ResourceLocation id = BrokenCore.id("show_overlay");

    public ShowOverlayPacket() {
        super(OverlayInfo.Companion.getENDEC());
    }

    @Override
    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    @NotNull
    public final ShowOverlayPacket of(@NotNull ResourceLocation texture, long duration2) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (ShowOverlayPacket)this.of(new OverlayInfo(texture, duration2));
    }

    @Override
    public void handle(@NotNull OverlayInfo data2, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> ShowOverlayPacket.handle$lambda$0(data2));
    }

    private static final void handle$lambda$0(OverlayInfo $data) {
        OverlayLayer.activateOverlay($data.getTexture(), $data.getDuration());
    }
}

