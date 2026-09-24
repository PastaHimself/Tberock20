/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.chat.Component
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.thebrokenscript.brokencore.api.dsl.ClientPlayerDSLKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\u0010\n\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u000bH\u0007\u00a2\u0006\u0002\u0010\f\"\u001a\u0010\u0000\u001a\u00020\u00018FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\r"}, d2={"MC", "Lnet/minecraft/client/Minecraft;", "getMC$annotations", "()V", "getMC", "()Lnet/minecraft/client/Minecraft;", "chat", "", "msg", "Lnet/minecraft/network/chat/Component;", "(Lnet/minecraft/client/Minecraft;Lnet/minecraft/network/chat/Component;)Lkotlin/Unit;", "", "(Lnet/minecraft/client/Minecraft;Ljava/lang/String;)Lkotlin/Unit;", "brokencore-common"})
public final class ClientDSLKt {
    @NotNull
    public static final Minecraft getMC() {
        Minecraft minecraft = Minecraft.getInstance();
        Intrinsics.checkNotNullExpressionValue((Object)minecraft, (String)"getInstance(...)");
        return minecraft;
    }

    @SideOnly(side=Side.CLIENT)
    public static /* synthetic */ void getMC$annotations() {
    }

    @SideOnly(side=Side.CLIENT)
    @Nullable
    public static final Unit chat(@NotNull Minecraft $this$chat, @NotNull Component msg) {
        Unit unit;
        Intrinsics.checkNotNullParameter((Object)$this$chat, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        LocalPlayer localPlayer = $this$chat.player;
        if (localPlayer != null) {
            ClientPlayerDSLKt.send(localPlayer, msg);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }

    @SideOnly(side=Side.CLIENT)
    @Nullable
    public static final Unit chat(@NotNull Minecraft $this$chat, @NotNull String msg) {
        Unit unit;
        Intrinsics.checkNotNullParameter((Object)$this$chat, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        LocalPlayer localPlayer = $this$chat.player;
        if (localPlayer != null) {
            ClientPlayerDSLKt.send(localPlayer, msg);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }
}

