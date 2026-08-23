/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.packets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.client.level.FakeTimeOfDay;
import net.thebrokenscript.brokencore.api.client.level.FakeTimeOfDayInfo;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/impl/packets/FakeTimeOfDayPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/brokencore/api/client/level/FakeTimeOfDayInfo;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "of", "time", "", "enabled", "", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "brokencore-common"})
public final class FakeTimeOfDayPacket
extends EndecPacket<FakeTimeOfDayPacket, FakeTimeOfDayInfo> {
    @NotNull
    private final ResourceLocation id = BrokenCore.id("fake_time_of_day");

    public FakeTimeOfDayPacket() {
        super(FakeTimeOfDayInfo.Companion.getENDEC());
    }

    @Override
    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    @NotNull
    public final FakeTimeOfDayPacket of(@NotNull Number time2, boolean enabled) {
        Intrinsics.checkNotNullParameter((Object)time2, (String)"time");
        return (FakeTimeOfDayPacket)this.of(new FakeTimeOfDayInfo(time2.floatValue(), enabled));
    }

    @Override
    public void handle(@NotNull FakeTimeOfDayInfo data2, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> FakeTimeOfDayPacket.handle$lambda$0(cx, data2));
    }

    private static final void handle$lambda$0(PacketHandlerContext $cx, FakeTimeOfDayInfo $data) {
        Player player = $cx.getPlayer();
        if (Intrinsics.areEqual((Object)(player != null && (player = player.level()) != null ? player.dimension() : null), (Object)Level.OVERWORLD)) {
            FakeTimeOfDay.INSTANCE.apply($data);
        }
    }
}

