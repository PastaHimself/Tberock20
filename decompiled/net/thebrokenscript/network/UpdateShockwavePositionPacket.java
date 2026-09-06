/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.client.TBSRenderEvents;
import net.thebrokenscript.entity.fractured.attacks.JimShockwaveType;
import net.thebrokenscript.network.ShockwaveEndec;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002 \u0012\u0004\u0012\u00020\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J*\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/network/UpdateShockwavePositionPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lkotlin/Triple;", "Lnet/minecraft/world/phys/Vec3;", "", "Lnet/thebrokenscript/entity/fractured/attacks/JimShockwaveType;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class UpdateShockwavePositionPacket
extends EndecPacket<UpdateShockwavePositionPacket, Triple<? extends Vec3, ? extends Float, ? extends JimShockwaveType>> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("shockwave_position");

    public UpdateShockwavePositionPacket() {
        super((Endec)ShockwaveEndec.INSTANCE);
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull Triple<? extends Vec3, Float, ? extends JimShockwaveType> data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isServerbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> UpdateShockwavePositionPacket.handle$lambda$0(data));
    }

    private static final void handle$lambda$0(Triple $data) {
        TBSRenderEvents.INSTANCE.updateShockwavePos$thebrokenscript_common((Vec3)$data.getFirst(), ((Number)$data.getSecond()).floatValue(), (JimShockwaveType)((Object)$data.getThird()));
    }
}

