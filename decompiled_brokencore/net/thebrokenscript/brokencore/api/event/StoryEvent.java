/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.minecraft.server.MinecraftServer;
import net.thebrokenscript.brokencore.api.ext.MinecraftServerExtKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH$J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0004R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "", "times", "", "", "<init>", "([Ljava/lang/Number;)V", "getTimes", "()[Ljava/lang/Number;", "[Ljava/lang/Number;", "server", "Lnet/minecraft/server/MinecraftServer;", "eventName", "", "getEventName", "()Ljava/lang/String;", "canExecute", "", "execute", "", "run", "queue", "afterTicks", "", "action", "Lkotlin/Function0;", "brokencore-common"})
public abstract class StoryEvent {
    @NotNull
    private final Number[] times;
    private MinecraftServer server;

    public StoryEvent(Number ... times) {
        Intrinsics.checkNotNullParameter((Object)times, (String)"times");
        this.times = times;
    }

    @NotNull
    public final Number[] getTimes() {
        return this.times;
    }

    @NotNull
    public final String getEventName() {
        String string = Reflection.getOrCreateKotlinClass(this.getClass()).getSimpleName();
        if (string == null) {
            string = "UnknownEvent";
        }
        return string;
    }

    public boolean canExecute(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        return true;
    }

    protected abstract void execute(@NotNull MinecraftServer var1);

    public final void run(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        this.server = server;
        this.execute(server);
    }

    protected final void queue(long afterTicks, @NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, (String)"action");
        MinecraftServer minecraftServer = this.server;
        if (minecraftServer == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"server");
            minecraftServer = null;
        }
        MinecraftServerExtKt.getQueue(minecraftServer).add(afterTicks, (Function0<Unit>)((Function0)() -> StoryEvent.queue$lambda$0(action)));
    }

    private static final Unit queue$lambda$0(Function0 $action) {
        $action.invoke();
        return Unit.INSTANCE;
    }
}

