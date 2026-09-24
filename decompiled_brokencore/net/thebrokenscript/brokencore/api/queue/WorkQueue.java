/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.CollectionToArray
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.markers.KMutableCollection
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableCollection;
import net.thebrokenscript.brokencore.api.queue.DefaultQueuedTask;
import net.thebrokenscript.brokencore.api.queue.QueuedTask;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\u0006\u0010\r\u001a\u00020\fJ\u0011\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0096\u0001J\u0017\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0096\u0003J\u0017\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u000eH\u0096\u0001J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0003J\u0011\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0096\u0001J\u0017\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0096\u0001J\u0017\u0010\u001b\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0096\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u001dX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "", "Lnet/thebrokenscript/brokencore/api/queue/QueuedTask;", "tasks", "Ljava/util/Queue;", "<init>", "(Ljava/util/Queue;)V", "add", "afterTicks", "", "task", "Lkotlin/Function0;", "", "tick", "", "element", "addAll", "elements", "", "clear", "contains", "containsAll", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "size", "", "getSize", "()I", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nnet/thebrokenscript/brokencore/api/queue/WorkQueue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
public class WorkQueue
implements Collection<QueuedTask>,
KMutableCollection {
    @NotNull
    private final Queue<QueuedTask> tasks;

    public WorkQueue(@NotNull Queue<QueuedTask> tasks) {
        Intrinsics.checkNotNullParameter(tasks, (String)"tasks");
        this.tasks = tasks;
    }

    public /* synthetic */ WorkQueue(Queue queue, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            queue = new ConcurrentLinkedQueue();
        }
        this(queue);
    }

    @JvmOverloads
    @NotNull
    public final QueuedTask add(long afterTicks, @NotNull Function0<Unit> task) {
        DefaultQueuedTask defaultQueuedTask;
        Intrinsics.checkNotNullParameter(task, (String)"task");
        DefaultQueuedTask it = defaultQueuedTask = new DefaultQueuedTask(afterTicks, task);
        boolean bl = false;
        this.add(it);
        return defaultQueuedTask;
    }

    public static /* synthetic */ QueuedTask add$default(WorkQueue workQueue, long l, Function0 function0, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
        }
        if ((n & 1) != 0) {
            l = 0L;
        }
        return workQueue.add(l, (Function0<Unit>)function0);
    }

    public final void tick() {
        Iterator<QueuedTask> it = this.iterator();
        while (it.hasNext()) {
            QueuedTask task = it.next();
            if (task.getReady()) {
                it.remove();
                task.run();
                continue;
            }
            task.tick();
        }
    }

    @Override
    @NotNull
    public Iterator<QueuedTask> iterator() {
        return this.tasks.iterator();
    }

    @Override
    public boolean add(@NotNull QueuedTask element) {
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        return this.tasks.add(element);
    }

    public boolean remove(@NotNull QueuedTask element) {
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        return this.tasks.remove(element);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends QueuedTask> elements) {
        Intrinsics.checkNotNullParameter(elements, (String)"elements");
        return this.tasks.addAll(elements);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, (String)"elements");
        return this.tasks.removeAll(elements);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, (String)"elements");
        return this.tasks.retainAll(elements);
    }

    @Override
    public void clear() {
        this.tasks.clear();
    }

    public int getSize() {
        return this.tasks.size();
    }

    @Override
    public boolean isEmpty() {
        return this.tasks.isEmpty();
    }

    public boolean contains(@NotNull QueuedTask element) {
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        return this.tasks.contains(element);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, (String)"elements");
        return this.tasks.containsAll(elements);
    }

    @JvmOverloads
    @NotNull
    public final QueuedTask add(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, (String)"task");
        return WorkQueue.add$default(this, 0L, task, 1, null);
    }

    public WorkQueue() {
        this(null, 1, null);
    }

    @Override
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, (String)"array");
        return CollectionToArray.toArray((Collection)this, (Object[])array);
    }

    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }
}

