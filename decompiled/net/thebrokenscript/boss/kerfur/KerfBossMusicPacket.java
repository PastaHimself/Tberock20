/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.kerfur;

import io.wispforest.endec.Endec;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.boss.kerfur.ClientKerfBossMusicHandler;
import net.thebrokenscript.boss.kerfur.KerfBossMusicState;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/boss/kerfur/KerfBossMusicPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Ljava/util/Optional;", "", "<init>", "()V", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "thebrokenscript-common"})
public final class KerfBossMusicPacket
extends EndecPacket<KerfBossMusicPacket, Optional<Integer>> {
    @NotNull
    private final ResourceLocation id;

    public KerfBossMusicPacket() {
        Endec endec2 = Endec.INT.optionalOf();
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"optionalOf(...)");
        super(endec2);
        this.id = TBSConstants.id("kerf_boss_music");
    }

    public void handle(@NotNull Optional<Integer> data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> KerfBossMusicPacket.handle$lambda$0(data));
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    private static final void handle$lambda$0(Optional $data) {
        Integer phase = (Integer)OptionalsKt.getOrNull((Optional)$data);
        if (phase != null) {
            KerfBossMusicState mapped = switch (phase) {
                case 1 -> KerfBossMusicState.PHASE_1;
                case 2 -> KerfBossMusicState.PHASE_2;
                case 3 -> KerfBossMusicState.PHASE_3;
                default -> throw new IndexOutOfBoundsException("Unknown Murderfur phase " + phase + "!");
            };
            ClientKerfBossMusicHandler.INSTANCE.setState(mapped);
        } else {
            ClientKerfBossMusicHandler.INSTANCE.stop();
        }
    }
}

