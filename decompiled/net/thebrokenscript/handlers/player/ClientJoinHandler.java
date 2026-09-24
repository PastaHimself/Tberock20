/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.thebrokenscript.brokencore.api.files.UserDirs
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.thebrokenscript.brokencore.api.files.UserDirs;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.handlers.subs.ClientLoginSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/player/ClientJoinHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class ClientJoinHandler {
    @NotNull
    public static final ClientJoinHandler INSTANCE = new ClientJoinHandler();

    private ClientJoinHandler() {
    }

    private static final Unit _init_$lambda$0(Minecraft it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String string = UserDirs.Companion.home().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getAbsolutePath(...)");
        PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.SYNC_HOME_DIR.of(string), new CustomPacketPayload[0]);
        return Unit.INSTANCE;
    }

    static {
        ClientLoginSubscriber.INSTANCE.add((Function1<? super Minecraft, Unit>)((Function1)ClientJoinHandler::_init_$lambda$0));
    }
}

