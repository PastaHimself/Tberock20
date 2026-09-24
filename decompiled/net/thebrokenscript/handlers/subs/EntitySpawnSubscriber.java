/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.subs;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\bR&\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/handlers/subs/EntitySpawnSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function2;", "Lnet/minecraft/world/entity/Entity;", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "", "add", "", "listener", "call", "entity", "cancelProxy", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nEntitySpawnSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntitySpawnSubscriber.kt\nnet/thebrokenscript/handlers/subs/EntitySpawnSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,14:1\n1869#2,2:15\n*S KotlinDebug\n*F\n+ 1 EntitySpawnSubscriber.kt\nnet/thebrokenscript/handlers/subs/EntitySpawnSubscriber\n*L\n12#1:15,2\n*E\n"})
public final class EntitySpawnSubscriber {
    @NotNull
    public static final EntitySpawnSubscriber INSTANCE = new EntitySpawnSubscriber();
    @NotNull
    private static final Set<Function2<Entity, CancelProxy, Unit>> listeners = new LinkedHashSet();

    private EntitySpawnSubscriber() {
    }

    public final boolean add(@NotNull Function2<? super Entity, ? super CancelProxy, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull Entity entity, @NotNull CancelProxy cancelProxy) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"cancelProxy");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function2 it = (Function2)element$iv;
            boolean bl = false;
            if (cancelProxy.isCanceled()) continue;
            it.invoke((Object)entity, (Object)cancelProxy);
        }
    }
}

