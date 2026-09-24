/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package net.thebrokenscript.brokencore.api.queue;

import kotlin.Metadata;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0010H$R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/queue/QueuedTask;", "", "delay", "", "<init>", "(J)V", "value", "getDelay", "()J", "", "cancelled", "getCancelled", "()Z", "ready", "getReady", "cancel", "", "tick", "run", "runAction", "brokencore-common"})
public abstract class QueuedTask {
    private long delay;
    private boolean cancelled;

    public QueuedTask(long delay) {
        this.delay = delay;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final boolean getCancelled() {
        return this.cancelled;
    }

    public final boolean getReady() {
        return this.delay <= 0L;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void tick() {
        if (this.delay > 0L) {
            long l = this.delay;
            this.delay = l + -1L;
        }
    }

    public final void run() {
        if (!this.cancelled) {
            this.runAction();
        }
    }

    protected abstract void runAction();
}

