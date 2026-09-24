/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.queue;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.queue.QueuedTask;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/queue/DefaultQueuedTask;", "Lnet/thebrokenscript/brokencore/api/queue/QueuedTask;", "delay", "", "action", "Lkotlin/Function0;", "", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "runAction", "brokencore-common"})
public final class DefaultQueuedTask
extends QueuedTask {
    @NotNull
    private final Function0<Unit> action;

    public DefaultQueuedTask(long delay, @NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, (String)"action");
        super(delay);
        this.action = action;
    }

    @Override
    protected void runAction() {
        this.action.invoke();
    }
}

