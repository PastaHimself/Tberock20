/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.packets;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.overlay.OverlayQueueInfo;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import net.thebrokenscript.brokencore.impl.client.BCClient;
import net.thebrokenscript.brokencore.impl.client.OverlayLayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/impl/packets/OverlayQueuePacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "", "Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayQueueInfo;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "brokencore-common"})
public final class OverlayQueuePacket
extends EndecPacket<OverlayQueuePacket, List<? extends OverlayQueueInfo>> {
    @NotNull
    private final ResourceLocation id = BrokenCore.id("overlay_queue");

    public OverlayQueuePacket() {
        super(OverlayQueueInfo.Companion.getLIST_ENDEC());
    }

    @Override
    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public void handle(@NotNull List<OverlayQueueInfo> data2, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter(data2, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> OverlayQueuePacket.handle$lambda$0(data2));
    }

    private static final void handle$lambda$0(List $data) {
        for (OverlayQueueInfo item2 : $data) {
            BCClient.INSTANCE.getQueue().add(item2.getDelay(), (Function0<Unit>)((Function0)() -> OverlayQueuePacket.handle$lambda$0$0(item2)));
        }
    }

    private static final Unit handle$lambda$0$0(OverlayQueueInfo $item) {
        OverlayLayer.activateOverlay($item.getTexture(), $item.getDuration());
        return Unit.INSTANCE;
    }
}

