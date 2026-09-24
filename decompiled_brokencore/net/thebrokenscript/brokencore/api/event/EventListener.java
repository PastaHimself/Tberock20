/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event;

import java.io.Closeable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/event/EventListener;", "Ljava/io/Closeable;", "uuid", "Ljava/util/UUID;", "event", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "<init>", "(Ljava/util/UUID;Lnet/thebrokenscript/brokencore/api/event/GameEvent;)V", "getUuid", "()Ljava/util/UUID;", "getEvent", "()Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "detach", "", "close", "brokencore-common"})
public final class EventListener
implements Closeable {
    @NotNull
    private final UUID uuid;
    @NotNull
    private final GameEvent<?> event;

    public EventListener(@NotNull UUID uuid, @NotNull GameEvent<?> event) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        Intrinsics.checkNotNullParameter(event, (String)"event");
        this.uuid = uuid;
        this.event = event;
    }

    @NotNull
    public final UUID getUuid() {
        return this.uuid;
    }

    @NotNull
    public final GameEvent<?> getEvent() {
        return this.event;
    }

    public final void detach() {
        this.event.getListeners$brokencore_common().remove(this.uuid);
    }

    @Override
    public void close() {
        this.detach();
    }
}

