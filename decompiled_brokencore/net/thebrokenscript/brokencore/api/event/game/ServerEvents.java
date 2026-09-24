/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event.game;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/ServerEvents;", "", "<init>", "()V", "START", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/event/game/ServerEvents$Data;", "STOP", "TICK_START", "TICK_END", "Data", "brokencore-common"})
public final class ServerEvents {
    @NotNull
    public static final ServerEvents INSTANCE = new ServerEvents();
    @JvmField
    @NotNull
    public static final GameEvent<Data> START = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Data> STOP = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Data> TICK_START = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Data> TICK_END = new GameEvent();

    private ServerEvents() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/ServerEvents$Data;", "", "server", "Lnet/minecraft/server/MinecraftServer;", "<init>", "(Lnet/minecraft/server/MinecraftServer;)V", "getServer", "()Lnet/minecraft/server/MinecraftServer;", "brokencore-common"})
    public static class Data {
        @NotNull
        private final MinecraftServer server;

        public Data(@NotNull MinecraftServer server) {
            Intrinsics.checkNotNullParameter((Object)server, (String)"server");
            this.server = server;
        }

        @NotNull
        public final MinecraftServer getServer() {
            return this.server;
        }
    }
}

