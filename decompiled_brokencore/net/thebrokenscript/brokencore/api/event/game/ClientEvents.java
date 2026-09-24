/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event.game;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/ClientEvents;", "", "<init>", "()V", "TICK_END", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/event/game/ClientEvents$Data;", "INACTIVE_TICK_END", "STARTUP", "EARLY_STARTUP", "SHUTDOWN", "Data", "brokencore-common"})
public final class ClientEvents {
    @NotNull
    public static final ClientEvents INSTANCE = new ClientEvents();
    @JvmField
    @NotNull
    public static final GameEvent<Data> TICK_END = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Data> INACTIVE_TICK_END = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Data> STARTUP = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Data> EARLY_STARTUP = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Data> SHUTDOWN = new GameEvent();

    private ClientEvents() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/ClientEvents$Data;", "", "<init>", "()V", "brokencore-common"})
    public static class Data {
    }
}

